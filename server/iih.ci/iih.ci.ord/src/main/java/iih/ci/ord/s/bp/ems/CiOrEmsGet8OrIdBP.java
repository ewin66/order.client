package iih.ci.ord.s.bp.ems;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.d.desc.OrdSrvDoseDODesc;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.d.desc.OrdSrvSetDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.CiOrappbtGetBP;
import iih.ci.ord.s.bp.CiOrappbuGetBP;
import iih.ci.ord.s.bp.CiOrappconsultGetBP;
import iih.ci.ord.s.bp.CiOrapplisGetBP;
import iih.ci.ord.s.bp.CiOrappoptGetBP;
import iih.ci.ord.s.bp.CiOrappoutGetBP;
import iih.ci.ord.s.bp.CiOrapppathgyGetBP;
import iih.ci.ord.s.bp.CiOrapprisGetBP;
import iih.ci.ord.s.bp.CiOrapptransdepGetBP;
import iih.ci.ord.s.bp.GetCiOderBlSrvBP;
import iih.ci.ord.s.bp.GetDefaultEmsTp8SrvtpBP;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据医嘱id生成医疗单Ems数据信息操作BP
 */
public class CiOrEmsGet8OrIdBP {
	/**
	 * 根据医嘱id生成医疗单Ems数据信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public FMap exec(String[] id_ors)  throws BizException{
		// 有效性校验
		if (id_ors == null || id_ors.length <= 0)
			return null;

		// 获得医嘱聚集数据
		CiorderAggDO[] aggdos = CiOrdAppUtils.getOrAggQryService().findByIds(id_ors, FBoolean.FALSE);

		FMap fMap = new FMap();
		if (aggdos != null && aggdos.length > 0) {
			for (CiorderAggDO aggdo : aggdos) {
				// 根据医嘱聚集数据生成基本EmsDTO数据信息
				CiEmsDTO emsdto = createCiEmsDTO8AggDO(aggdo);
				fMap.put(emsdto.getId_or(), emsdto);
			}
		}

		return fMap;
	}
	
	/**
	 * 根据医嘱聚集数据创建Ems数据
	 * @param aggdo
	 * @return
	 * @throws BizException 
	 */
	private CiEmsDTO createCiEmsDTO8AggDO(CiorderAggDO aggdo) throws BizException{
		//有效性判断
		if (aggdo == null || aggdo.getParentDO() == null) {
			throw new BizException("id_or对应的医嘱数据不存在!");
		}
		
		//医疗单主数据创建
		CiOrderDO ordo = aggdo.getParentDO();
		CiEmsDTO emsdto = new CiEmsDTO();
		emsdto.setId_or(ordo.getId_or());
		emsdto.setId_pat(ordo.getId_pat());
		emsdto.setId_en(ordo.getId_en());
		emsdto.setId_entp(ordo.getId_entp());
		emsdto.setCode_entp(ordo.getCode_entp());
		emsdto.setId_srvtp(ordo.getId_srvtp());
		emsdto.setSd_srvtp(ordo.getSd_srvtp());
		emsdto.setId_srv(ordo.getId_srv());
		emsdto.setFg_set(ordo.getFg_set());// 李政  20151218 添加  
		emsdto.setId_srv_pkg(ordo.getId_srv_pkg());
		emsdto.setFg_long(ordo.getFg_long());
		emsdto.setEmstype(getEmsType(ordo.getSd_srvtp()));
		emsdto.setId_freq(ordo.getId_freq());
		emsdto.setName_freq(ordo.getFreq_name());
		emsdto.setFreqct(ordo.getFreqct());
		emsdto.setFrequnitct(ordo.getFrequnitct());
		emsdto.setSd_frequnitct(ordo.getSd_frequnitct());
		emsdto.setId_route(ordo.getId_route());
		emsdto.setName_route(ordo.getRoute_name());
		emsdto.setId_routedes(ordo.getId_routedes());
		emsdto.setName_routedes(ordo.getRoutedes_name());
		emsdto.setId_boil(ordo.getId_boil());
		emsdto.setName_boil(ordo.getBoil_name());
		emsdto.setId_boildes(ordo.getId_boildes());
		emsdto.setName_boildes(ordo.getBoildes_name());
		emsdto.setFg_boil(ordo.getFg_boil());
		emsdto.setDays_or(ordo.getDays_or());
		emsdto.setOrders(ordo.getOrders());
		emsdto.setOrders_boil(ordo.getOrders_boil());
		emsdto.setCode(ordo.getCode_or());
		emsdto.setName(ordo.getName_or());
		emsdto.setContent(ordo.getContent_or());
		emsdto.setNote(ordo.getNote_or());
		emsdto.setDes_or(ordo.getDes_or());
		emsdto.setId_emp_phy(ordo.getId_emp_or());
		emsdto.setName_emp_phy(ordo.getEmp_phy_name());
		emsdto.setId_dep_phy(ordo.getId_dep_or());
		emsdto.setName_dep_phy(ordo.getDept_or_name());
		emsdto.setId_wg_or(ordo.getId_wg_or());
		emsdto.setDt_begin(ordo.getDt_effe());
		emsdto.setDt_end(ordo.getDt_end());
		emsdto.setDt_invalid(ordo.getDt_invalid());
		emsdto.setFg_bb(ordo.getFg_bb());
		emsdto.setNo_bb(ordo.getNo_bb());
		emsdto.setFg_pmor(ordo.getFg_pmor());
		emsdto.setDes_pmor(ordo.getDes_pmor());
		emsdto.setFg_active_pm(ordo.getFg_active_pm());
		emsdto.setId_reltp(ordo.getId_reltp());
		emsdto.setSd_reltp(ordo.getSd_reltp());
		emsdto.setId_or_rel(ordo.getId_or_rel());
		emsdto.setFg_ctlcp(ordo.getFg_ctlcp());
		emsdto.setFg_mr(ordo.getFg_mr());
		emsdto.setFg_skintest(ordo.getFg_skintest());
		emsdto.setId_skintest_skip_reaso(ordo.getId_skintest_skip_reason());
		emsdto.setSd_skintest_skip_reaso(ordo.getSd_skintest_skip_reason());
		emsdto.setFg_mp_in(ordo.getFg_mp_in());
		emsdto.setTimes_mp_in(ordo.getTimes_mp_in());
		emsdto.setFg_mp_bed(ordo.getFg_mp_bed());
		emsdto.setTimes_firday_mp(ordo.getQuan_firday_mp());
		emsdto.setFg_or_doc(ordo.getFg_or_form());
		emsdto.setId_su_or(ordo.getId_su_or());
		emsdto.setSd_su_or(ordo.getSd_su_or());
		//添加医疗单的路径和id_srvof
		emsdto.setFuncclassstr(ordo.getFuncclassstr());
		emsdto.setId_srvof(ordo.getId_srvof());
		emsdto.setId_srvca(ordo.getId_srvca());
		// 新增字段对应 - wqz 2016.7.22
		emsdto.setTimes_cur(ordo.getTimes_cur());
		emsdto.setId_unit_med(ordo.getId_unit_med());
		emsdto.setName_unit_med(ordo.getName_unit_med());
		emsdto.setQuan_medu(ordo.getQuan_medu());
		emsdto.setId_dep_mp(ordo.getId_dep_mp());
		emsdto.setName_dep_mp(ordo.getName_dep_mp());
		emsdto.setEu_hpindicjudge(ordo.getEu_hpindicjudge());//医保适应证
		emsdto.setEu_uncporjudge(ordo.getEu_uncporjudge());//非径内医嘱判断标识枚
		emsdto.setReason_uncporuse(ordo.getReason_uncporuse());//径外医嘱使用说明
		emsdto.setPurpose_or(ordo.getPurpose_or());//医嘱目的
		emsdto.setFg_feertnable(FBoolean.TRUE);//可退费标识
		emsdto.setFg_urgent(ordo.getFg_urgent());// 加急标识
		
		//添加医嘱来源字段
		emsdto.setEu_orsrcmdtp(ordo.getEu_orsrcmdtp());
		emsdto.setId_orsrc_main(ordo.getId_orsrc_main());
		emsdto.setId_orsrc_sub(ordo.getId_orsrc_sub());
		emsdto.setId_orsrc_subsub(ordo.getId_orsrc_subsub());
		emsdto.setFg_quickwflow(ordo.getFg_quickwflow());
		//时间戳
		emsdto.setSv(ordo.getSv());
		emsdto.setFg_prisrvhandled(FBoolean.TRUE);
		//医保标识
		emsdto.setFg_orhp(ordo.getFg_orhp());
		//构建医疗单项目信息
		FArrayList arrylist=createEmsSrvs8AggDo(aggdo);
		if(arrylist!=null && arrylist.size()!=0){
			emsdto.setEmssrvs(arrylist);
		}
		
		//套内项目BD数据的获得
		if(!OrSrvSplitUtil.isEmpty(ordo.getId_srv()) && OrSrvSplitUtil.isTrue(ordo.getFg_set())){
		 //MedSrvSetItemDO[] setitemdos=CiOrdUtils.getBdSrvSetItems(ordo.getId_srv(), null);
			OrdSrvSetDO[] ordsrvsetDO = CiOrdUtils.getIOrdsrvsetRService().find("a0.id_or ='"+ordo.getId_or()+"'", "a0.id_or", FBoolean.FALSE);
			MedSrvDO medsrvDO = CiOrdAppUtils.getMedsrvMDORService().findById(ordo.getId_srv());
			if(ordsrvsetDO!=null && ordsrvsetDO.length!=0){ 
				FMap map=new FMap();
				//是否将数组转换为FArrayList CiOrdUtils.array2FArrayList(setitemdos)
				map.put(ordo.getId_srv(),CiOrdUtils.array2FArrayList(ordsrvsetDO)); 
				//map.put(ordo.getId_or(),medsrvDO); 
				FMap2 Mapinfo=new FMap2();
				Mapinfo.put(ordo.getId_srv(), medsrvDO);
				emsdto.setMapinfo(Mapinfo);
				emsdto.setSrvsetitms(map);
			}
		}
		
		//申请单相关数据的处理
		orAppInfoHandle(ordo.getId_or(),emsdto);
		
		return emsdto;
	}
	
	/**
	 * 根据医嘱聚集DO创建医疗单项目信息集合
	 * @param aggdo
	 * @return
	 * @throws BizException 
	 */
	private FArrayList createEmsSrvs8AggDo(CiorderAggDO aggdo) throws BizException{
		OrdSrvDO[] orsrvdos = aggdo.getOrdSrvDO();
		// 根据SortNo升序
		CiOrdUtils.orderBySortNoAscSrvItems(orsrvdos);
		// 根据医嘱项目集合创建医疗单项目数据集
		FArrayList arrylist = createEmsSrvs8OrSrvDOs(orsrvdos);

		// createEmsSrvs8OrSrvSetDOs(aggdo,arrylist);

		return arrylist;
	}
	
	/**
	 * 根据医嘱项目对应服务套信息创建医疗单项目数据集合
	 * @param aggdo
	 * @param arrylist
	 * @throws BizException 
	 */
	private void createEmsSrvs8OrSrvSetDOs(CiorderAggDO aggdo,FArrayList arrylist) throws BizException{
		CiOrderDO ordo=aggdo.getParentDO();
		createEmsSrv4SetOrOpen(ordo,arrylist);
		String whereStr=OrdSrvSetDODesc.TABLE_ALIAS_NAME+".id_or='"+ordo.getId_or()+"'";
		OrdSrvSetDO[] orsrvsetdos=CiOrdAppUtils.getOrsrvsetQryService().find(whereStr, "sortno", FBoolean.FALSE);
		if(orsrvsetdos==null || orsrvsetdos.length==0)return;
		
		//遍历
		for(int i=0;i<orsrvsetdos.length;i++){
			// 2016-04-13  医嘱项目和医嘱套内项目重复 需要过滤 （李政   孟祥杰 张镌尹）
			if(!isCheckRepeat(arrylist,orsrvsetdos[i].getId_srvset())){
				arrylist.add(createEmsSrv8OrSrvSetDO(ordo,orsrvsetdos[i]));
			}
			
		}
	}
	
	// 2016-04-13  医嘱项目和医嘱套内项目重复 需要过滤 （李政   孟祥杰 张镌尹）
	private  Boolean isCheckRepeat(FArrayList arrylist,String id_srv){
		Boolean  IsRepaeat = false;
		for(int i= 0;i<arrylist.size();i++){
			CiEmsSrvDTO srvDto =(CiEmsSrvDTO)arrylist.get(i);
			if(srvDto.getId_srv()== id_srv){
				IsRepaeat = true;
			}
		}
		return IsRepaeat;
	}
	
	
	/**
	 * 根据医嘱项目对应医嘱套内项目创建医疗单项目数据
	 * @param ordo
	 * @param orsrvsetdo
	 */
	private CiEmsSrvDTO createEmsSrv8OrSrvSetDO(CiOrderDO ordo,OrdSrvSetDO orsrvsetdo){
		CiEmsSrvDTO emssrvmm=new CiEmsSrvDTO();
		 //emssrvmm.setId_orsrv();
		 emssrvmm.setId_or(orsrvsetdo.getId_or());
		 //emssrvmm.setSortno();
		 emssrvmm.setId_srv(orsrvsetdo.getId_srvset());
		 emssrvmm.setId_srv_set(orsrvsetdo.getId_srvsetdef());
		 //emssrvmm.setId_srvtp(orsrvsetdo.getId_srvtp());
		 //emssrvmm.setSd_srvtp(orsrvsetdo.getSd_srvtp());
		 emssrvmm.setCode_srv(orsrvsetdo.getCode());
		 emssrvmm.setName_srv(orsrvsetdo.getName());
		 //emssrvmm.setId_srvca(orsrvdo.getId_srvca());
		 emssrvmm.setId_unit_med(orsrvsetdo.getId_medu());
		 //emssrvmm.setName_unit_med(orsrvsetdo.getMedu_name());
		 emssrvmm.setQuan_med(orsrvsetdo.getQuan_medu());
		// emssrvmm.setPrice(orsrvsetdo.getPri());
		 emssrvmm.setId_freq(orsrvsetdo.getId_freqdef());
		 //emssrvmm.setName_freq(orsrvsetdo.getFreq_name());
		 //emssrvmm.setId_route(orsrvsetdo.getId_route());
		 //emssrvmm.setName_route(orsrvsetdo.getRoute_name());
		 //emssrvmm.setId_routedes(orsrvsetdo.getId_routedes());
		 //emssrvmm.setName_routedes(orsrvsetdo.getRoutedes_name());
		 //emssrvmm.setId_boil(orsrvsetdo.getId_boil());
		 //emssrvmm.setName_boil(orsrvsetdo.getBoil_name());
		 //emssrvmm.setId_boildes(orsrvsetdo.getId_boildes());
		 //emssrvmm.setName_boildes(orsrvsetdo.getBoildes_name());
		 //emssrvmm.setFg_dose_anoma(orsrvdo.getFg_dose_anoma());
		 emssrvmm.setDes_srv(orsrvsetdo.getDes_srv());
		 //emssrvmm.setFg_mm(orsrvsetdo.getFg_mm());
		 //emssrvmm.setFg_set(orsrvsetdo.getFg_set());
		 //emssrvmm.setFg_or(orsrvsetdo.getFg_or());
		 //emssrvmm.setFg_bl(orsrvsetdo.getFg_bl());
		 //emssrvmm.setFg_self(orsrvsetdo.getFg_self());
		 //emssrvmm.setFg_outp(orsrvsetdo.getFg_pres_outp());
		 //emssrvmm.setFg_propc(orsrvsetdo.getFg_propc());
		 //emssrvmm.setFg_treat();
		 //emssrvmm.setFg_indic(orsrvsetdo.getFg_indic());
		 //emssrvmm.setId_org_srv(orsrvsetdo.getId_org_srv());
		 //emssrvmm.setId_dep_srv(orsrvsetdo.getId_dep_srv());
		 //emssrvmm.setId_ward_srv(orsrvsetdo.getId_dep_nur_srv());
		 //emssrvmm.setId_emp_srv(orsrvsetdo.getId_emp_srv());
		 //emssrvmm.setDt_create_srv(orsrvsetdo.getDt_create());
		 //emssrvmm.setId_dep(orsrvsetdo.getId_dep_mp());
		 //emssrvmm.setName_dep(orsrvsetdo.getDep_mp_name());
		 //emssrvmm.setDt_last_bl(orsrvsetdo.getDt_last_bl());
		 //emssrvmm.setEu_blmd(orsrvsetdo.getEu_blmd());
		 emssrvmm.setEu_sourcemd(OrSrvSourceFromEnum.OTHER);
		 
		 emssrvmm.setId_body(orsrvsetdo.getId_body());
		 emssrvmm.setSd_body(orsrvsetdo.getSd_body());
		 emssrvmm.setId_pos(orsrvsetdo.getId_pos());
		 emssrvmm.setSd_pos(orsrvsetdo.getSd_pos());
		 emssrvmm.setBody_name(orsrvsetdo.getBody_name());		
		return emssrvmm;
	}
	
	/**
	 * 根据医嘱项目集合创建医疗单项目信息集合
	 * @param orsrvdos
	 * @return
	 * @throws BizException 
	 */
	private FArrayList createEmsSrvs8OrSrvDOs(OrdSrvDO[] orsrvdos) throws BizException {
		FArrayList arrylist = new FArrayList();
		FMap blsrvFMap = getBlSrvFMap(orsrvdos);
		// 批量查询物品信息
		FMap srvMmMap = getSrvMMInfoMap(orsrvdos);
		if (!CiOrdUtils.isEmpty(orsrvdos)) {
			for (int i = 0; i < orsrvdos.length; i++) {
				arrylist.add(createEmsSrv8OrSrvDO(orsrvdos[i], blsrvFMap,srvMmMap.get(orsrvdos[i].getId_orsrv())));
			}
		}
		return arrylist;
	}

	/**
	 * 如果服务中存在物品，将对应的OrdSrvMmDO给缓存下来
	 * 
	 * @param orsrvdos
	 * @return
	 */
	private FMap getSrvMMInfoMap(OrdSrvDO[] orsrvdos) {
		FArrayList srvIdList = new FArrayList();
		FMap srvMmMap = new FMap();
		for (OrdSrvDO srv : orsrvdos) {
			if (!CiOrdUtils.isEmpty(srv.getFg_mm()) && srv.getFg_mm().booleanValue()) {
				srvIdList.add(srv.getId_orsrv());
			}
		}
		if (srvIdList.size() > 0) {
			try {
				OrdSrvMmDO[] srvmmdos = CiOrdAppUtils.getOrSrvMmQryService().findByAttrValList(OrdSrvMmDO.ID_ORSRV,
						srvIdList);
				if (srvmmdos != null && srvmmdos.length > 0) {
					for (OrdSrvMmDO mm : srvmmdos) {
						srvMmMap.put(mm.getId_orsrv(), mm);
					}
				}
			} catch (BizException e) {
				e.printStackTrace();
			}
		}
		return srvMmMap;
	}

	/**
	 * 根据医嘱项目及相关信息创建医疗单项目与物品数据
	 * @param orsrvdo
	 * @return
	 * @throws BizException 
	 */
	private CiEmsSrvDTO createEmsSrv8OrSrvDO(OrdSrvDO orsrvdo, FMap blsrvFMap,Object srvMm) throws BizException {
		CiEmsSrvDTO emssrvmm = new CiEmsSrvDTO();
		 emssrvmm.setId_orsrv(orsrvdo.getId_orsrv());
		 emssrvmm.setId_or(orsrvdo.getId_or());
		 emssrvmm.setSortno(orsrvdo.getSortno());
		 emssrvmm.setId_srv(orsrvdo.getId_srv());
		 emssrvmm.setInnercode_srvca(orsrvdo.getInnercode_srvca());
		 //emssrvmm.setId_srv_set();
		 emssrvmm.setId_srvtp(orsrvdo.getId_srvtp());
		 emssrvmm.setSd_srvtp(orsrvdo.getSd_srvtp());
		 emssrvmm.setCode_srv(orsrvdo.getCode_srv());
		 emssrvmm.setName_srv(orsrvdo.getName());
		 emssrvmm.setId_srvca(orsrvdo.getId_srvca());
		 emssrvmm.setId_unit_med(orsrvdo.getId_medu());
		 if(!CiOrdUtils.isEmpty(orsrvdo.getMedu_name()))
		 emssrvmm.setName_unit_med(orsrvdo.getMedu_name().trim());
		 emssrvmm.setQuan_med(orsrvdo.getQuan_medu());
		 emssrvmm.setQuan_total_medu(orsrvdo.getQuan_total_medu()); // add by qz 2016-8-22
		 emssrvmm.setPrice(orsrvdo.getPri());
		 //折扣价、折扣系数、价格分类
		 CiOrdUtils.assignPriratToEmsSrvDTO(orsrvdo,emssrvmm);
		 emssrvmm.setId_freq(orsrvdo.getId_freq());
		 emssrvmm.setName_freq(orsrvdo.getFreq_name());
		 emssrvmm.setFreqct(orsrvdo.getFreqct());// add by qz 2016-8-22
		 emssrvmm.setSd_frequnitct(orsrvdo.getSd_frequnitct());// add by qz 2016-8-22
		 emssrvmm.setId_route(orsrvdo.getId_route());
		 emssrvmm.setName_route(orsrvdo.getRoute_name());
		 emssrvmm.setId_routedes(orsrvdo.getId_routedes());
		 emssrvmm.setName_routedes(orsrvdo.getRoutedes_name());
		 emssrvmm.setId_boil(orsrvdo.getId_boil());
		 emssrvmm.setName_boil(orsrvdo.getBoil_name());
		 emssrvmm.setId_boildes(orsrvdo.getId_boildes());
		 emssrvmm.setName_boildes(orsrvdo.getBoildes_name());
		 emssrvmm.setFg_dose_anoma(orsrvdo.getFg_dose_anoma());
		 emssrvmm.setDes_srv(orsrvdo.getNote_srv());
		 emssrvmm.setFg_mm(orsrvdo.getFg_mm());
		 emssrvmm.setFg_set(orsrvdo.getFg_set());
		 emssrvmm.setFg_or(orsrvdo.getFg_or());
		 emssrvmm.setFg_bl(orsrvdo.getFg_bl());
		 emssrvmm.setFg_self(orsrvdo.getFg_self());
		 emssrvmm.setFg_outp(orsrvdo.getFg_pres_outp());
		 emssrvmm.setFg_propc(orsrvdo.getFg_propc());
		 emssrvmm.setId_hp(orsrvdo.getId_hp());
		 emssrvmm.setId_hpsrvtp(orsrvdo.getId_hpsrvtp());
		 emssrvmm.setSd_hpsrvtp(orsrvdo.getSd_hpsrvtp());
		 emssrvmm.setName_hpsrvtp(orsrvdo.getName_hpsrvtp());
		 emssrvmm.setFg_selfpay(orsrvdo.getFg_selfpay());
		 //emssrvmm.setFg_treat();
		 emssrvmm.setFg_indic(orsrvdo.getFg_indic());
		 emssrvmm.setLimit(orsrvdo.getDes_hplimit());
		 emssrvmm.setFg_hpindicjudged(orsrvdo.getFg_hpindicjudged());
		 emssrvmm.setId_org_srv(orsrvdo.getId_org_srv());
		 emssrvmm.setId_dep_srv(orsrvdo.getId_dep_srv());
		 emssrvmm.setId_ward_srv(orsrvdo.getId_dep_nur_srv());
		 emssrvmm.setId_emp_srv(orsrvdo.getId_emp_srv());
		 emssrvmm.setDt_create_srv(orsrvdo.getDt_create());
		 emssrvmm.setId_dep(orsrvdo.getId_dep_mp());
		 emssrvmm.setId_dep_wh(orsrvdo.getId_dep_wh());
		 emssrvmm.setName_dep(orsrvdo.getDep_mp_name());
		 emssrvmm.setDt_last_bl(orsrvdo.getDt_last_bl());
		 emssrvmm.setEu_blmd(orsrvdo.getEu_blmd());
		 emssrvmm.setEu_sourcemd(orsrvdo.getEu_sourcemd());
		 emssrvmm.setFg_selfsrv(orsrvdo.getFg_selfsrv());
		 emssrvmm.setId_srv_src(orsrvdo.getId_srv_src());//2016-08-30 zwq
		 emssrvmm.setId_primd(orsrvdo.getId_primd());//2016-09-06 zwq
		 //皮试信息
		 emssrvmm.setFg_skintest(orsrvdo.getFg_skintest());
		 emssrvmm.setId_or_rel(orsrvdo.getId_or_rel());
		 emssrvmm.setId_skintest_skip_reason(orsrvdo.getId_skintest_skip_reason());
		 emssrvmm.setId_reltp(orsrvdo.getId_reltp());
		 emssrvmm.setSd_reltp(orsrvdo.getSd_reltp());
		emssrvmm.setFg_extdispense(orsrvdo.getFg_extdispense());// 外配标识
		// 根据医嘱项目对应物品数据信息创建医疗单服务物品信息
		if (OrSrvSplitUtil.isTrue(emssrvmm.getFg_mm())) {
			setEmsSrvMmInfo(emssrvmm,(OrdSrvMmDO)srvMm);
		}

		 //医嘱项目变动用药情形的处理
		 if(OrSrvSplitUtil.isTrue(orsrvdo.getFg_dose_anoma())){
			 String wherestr=OrdSrvDoseDODesc.TABLE_ALIAS_NAME+".id_orsrv='"+orsrvdo.getId_orsrv()+"'";
			 OrdSrvDoseDO[] orsrvdosedos=CiOrdAppUtils.getOrsrvdoseQryService().find(wherestr, "", FBoolean.FALSE);
			 if(orsrvdosedos!=null && orsrvdosedos.length!=0){
				 emssrvmm.setEmsfreqdose(CiOrdUtils.array2FArrayList(orsrvdosedos));
			 }
		 }
		 //费用说明
		 if(!CiOrdUtils.isEmpty(blsrvFMap) && blsrvFMap.containsKey(orsrvdo.getId_srv())){
			 MedSrvDO medsrv=(MedSrvDO)blsrvFMap.get(orsrvdo.getId_srv());
			 if(!CiOrdUtils.isEmpty(medsrv)){
				 emssrvmm.Des_bl(medsrv.getDes());
			 }
		 }
//		 emssrvmm.setId_body();
//		 emssrvmm.setSd_body();
//		 emssrvmm.setId_pos();
//		 emssrvmm.setSd_pos();
//		 emssrvmm.setBody_name();		
		return emssrvmm;
	}
	
	/**
	 * 根据医嘱项目对应物品数据信息创建医疗单服务物品信息
	 * @param emssrvmm
	 * @param id_orsrv
	 * @throws BizException 
	 */
	private void setEmsSrvMmInfo(CiEmsSrvDTO emssrvmm, OrdSrvMmDO srvmmdo) throws BizException {
		 emssrvmm.setId_orsrvmm(srvmmdo.getId_orsrvmm());
		 emssrvmm.setId_mm(srvmmdo.getId_mm());
		 emssrvmm.setCode_mm(srvmmdo.getCode_mm());
		 emssrvmm.setName_mm(srvmmdo.getName_mm());
		 emssrvmm.setSpec_mm(srvmmdo.getSpec());
		 emssrvmm.setId_unit_sale(srvmmdo.getId_pgku_cur());
		 emssrvmm.setName_unit_sale(srvmmdo.getName_pgku_cur());
		 emssrvmm.setId_unit_base(srvmmdo.getId_pgku_base());
		 emssrvmm.setName_unit_base(srvmmdo.getName_pgku_base());
		 emssrvmm.setQuan_num_base(srvmmdo.getQuan_num_base());
		 emssrvmm.setQuan_den_base(srvmmdo.getQuan_den_base());
		 emssrvmm.setPrice_cur(srvmmdo.getPrice_pgku_cur());
		 emssrvmm.setQuan_cur(srvmmdo.getQuan_cur());
		 //emssrvmm.setQuan_base();
		 emssrvmm.setQuan_bed_medu(srvmmdo.getQuan_bed_medu());
		 emssrvmm.setFactor_cb(srvmmdo.getFactor());
		 emssrvmm.setFactor_mb(srvmmdo.getFactor_mb());
		 emssrvmm.setId_dosage(srvmmdo.getId_dosage());
		 emssrvmm.setSd_dosage(srvmmdo.getSd_dosage());
		 emssrvmm.setId_pharm(srvmmdo.getId_pharm());
		 emssrvmm.setSd_pharm(srvmmdo.getSd_pharm());
		 emssrvmm.setId_pois(srvmmdo.getId_pois());
		 emssrvmm.setSd_pois(srvmmdo.getSd_pois());
		 emssrvmm.setId_anti(srvmmdo.getId_anti());
		 emssrvmm.setSd_anti(srvmmdo.getSd_anti());
		 if(!StringUtils.isEmpty(emssrvmm.getSd_anti())&&emssrvmm.getSd_anti().equals(IBdMmDictCodeConst.SD_ANTI_NULL)){
			 emssrvmm.setFg_propc(null);
		 }
		 emssrvmm.setId_mmtp(srvmmdo.getId_mmtp());
		 emssrvmm.setSd_mmtp(srvmmdo.getSd_mmtp());
		 emssrvmm.setId_val(srvmmdo.getId_val());
		 emssrvmm.setSd_val(srvmmdo.getSd_val());
		 emssrvmm.setIndica(srvmmdo.getIndica());
		 emssrvmm.setConstr(srvmmdo.getConstr());
		 emssrvmm.setReact(srvmmdo.getReact());
		 emssrvmm.setDays_available(srvmmdo.getDays_available());//领可用天数（门诊用）
		 emssrvmm.setId_opmutp(srvmmdo.getId_mupkgutp()); // 取整模式 
		 emssrvmm.setSd_opmutp(srvmmdo.getSd_mupkgutp());
		 emssrvmm.setId_mupkgutp(srvmmdo.getId_mupkgutp());// 取整模式
		 emssrvmm.setSd_mupkgutp(srvmmdo.getSd_mupkgutp());
		 //物品删除字段报错 todo
		 //emssrvmm.setGuide(srvmmdo.getGuide());
		 //emssrvmm.setFg_otc(srvmmdo.getFg_otc());
	}
	
	/**
	 * 根据医嘱项目对应医嘱套内项目创建医疗单项目数据
	 * @param ordo
	 * @param orsrvsetdo
	 */
	private void createEmsSrv4SetOrOpen(CiOrderDO ordo,FArrayList arrylist){
		//if(OrSrvSplitUtil.isEmpty(ordo.getId_srv_set()))return;
		if(!OrSrvSplitUtil.isTrue(ordo.getFg_set()))return;
		CiEmsSrvDTO emssrvmm=new CiEmsSrvDTO();
		 //emssrvmm.setId_orsrv();
		 emssrvmm.setId_or(ordo.getId_or());
		 //emssrvmm.setSortno();
		 emssrvmm.setId_srv(ordo.getId_srv());
		 emssrvmm.setId_srv_set(ordo.getId_srv());
		 //emssrvmm.setId_srvtp(orsrvsetdo.getId_srvtp());
		 //emssrvmm.setSd_srvtp(orsrvsetdo.getSd_srvtp());
		 //emssrvmm.setCode_srv(orsrvsetdo.getCode());
		 //emssrvmm.setName_srv(orsrvsetdo.getName());
		 //emssrvmm.setId_srvca(orsrvdo.getId_srvca());
		 //emssrvmm.setId_unit_med(orsrvsetdo.getId_medu());
		 //emssrvmm.setName_unit_med(orsrvsetdo.getMedu_name());
		 //emssrvmm.setQuan_med(orsrvsetdo.getQuan_medu());
		// emssrvmm.setPrice(orsrvsetdo.getPri());
		 //emssrvmm.setId_freq(orsrvsetdo.getId_freqdef());
		 //emssrvmm.setName_freq(orsrvsetdo.getFreq_name());
		 //emssrvmm.setId_route(orsrvsetdo.getId_route());
		 //emssrvmm.setName_route(orsrvsetdo.getRoute_name());
		 //emssrvmm.setId_routedes(orsrvsetdo.getId_routedes());
		 //emssrvmm.setName_routedes(orsrvsetdo.getRoutedes_name());
		 //emssrvmm.setId_boil(orsrvsetdo.getId_boil());
		 //emssrvmm.setName_boil(orsrvsetdo.getBoil_name());
		 //emssrvmm.setId_boildes(orsrvsetdo.getId_boildes());
		 //emssrvmm.setName_boildes(orsrvsetdo.getBoildes_name());
		 //emssrvmm.setFg_dose_anoma(orsrvdo.getFg_dose_anoma());
		 //emssrvmm.setDes_srv(orsrvsetdo.getDes_srv());
		 //emssrvmm.setFg_mm(orsrvsetdo.getFg_mm());
		 //emssrvmm.setFg_set(orsrvsetdo.getFg_set());
		 //emssrvmm.setFg_or(orsrvsetdo.getFg_or());
		 //emssrvmm.setFg_bl(orsrvsetdo.getFg_bl());
		 //emssrvmm.setFg_self(orsrvsetdo.getFg_self());
		 //emssrvmm.setFg_outp(orsrvsetdo.getFg_pres_outp());
		 //emssrvmm.setFg_propc(orsrvsetdo.getFg_propc());
		 //emssrvmm.setFg_treat();
		 //emssrvmm.setFg_indic(orsrvsetdo.getFg_indic());
		 //emssrvmm.setId_org_srv(orsrvsetdo.getId_org_srv());
		 //emssrvmm.setId_dep_srv(orsrvsetdo.getId_dep_srv());
		 //emssrvmm.setId_ward_srv(orsrvsetdo.getId_dep_nur_srv());
		 //emssrvmm.setId_emp_srv(orsrvsetdo.getId_emp_srv());
		 //emssrvmm.setDt_create_srv(orsrvsetdo.getDt_create());
		 //emssrvmm.setId_dep(orsrvsetdo.getId_dep_mp());
		 //emssrvmm.setName_dep(orsrvsetdo.getDep_mp_name());
		 //emssrvmm.setDt_last_bl(orsrvsetdo.getDt_last_bl());
		 //emssrvmm.setEu_blmd(orsrvsetdo.getEu_blmd());
		 emssrvmm.setEu_sourcemd(OrSrvSourceFromEnum.OTHER);
		 
		 //emssrvmm.setId_body(orsrvsetdo.getId_body());
		 //emssrvmm.setSd_body(orsrvsetdo.getSd_body());
		 //emssrvmm.setId_pos(orsrvsetdo.getId_pos());
		 //emssrvmm.setSd_pos(orsrvsetdo.getSd_pos());
		 //emssrvmm.setBody_name(orsrvsetdo.getBody_name());		
		 arrylist.add(emssrvmm);
	}
	
	/**
	 * 获得医疗单类型
	 * @param sd_srvtp
	 * @return
	 * @throws BizException 
	 */
	private Integer getEmsType(String sd_srvtp) throws BizException{
		GetDefaultEmsTp8SrvtpBP bp=new GetDefaultEmsTp8SrvtpBP();
		return bp.exec(sd_srvtp);
	}
	
	/**
	 * 申请单相关数据处理
	 * @param id_or
	 * @param iemstp
	 * @throws BizException 
	 */
	private void orAppInfoHandle(String id_or,CiEmsDTO emsdto) throws BizException{
		int iemstp=emsdto.getEmstype();
		if(CiOrdUtils.isEmpty(id_or))return;
		//申请单数据查询
		if(EmsType.LIS.equals(iemstp)){
			getOrapplisInfo(id_or,emsdto,iemstp);;
		}else if(EmsType.RIS.equals(iemstp)){
			getOrapprisInfo(id_or,emsdto,iemstp);
		}else if(EmsType.OPER.equals(iemstp)){
			getOrappoptInfo(id_or,emsdto,iemstp);
		}else if(EmsType.PATHGY.equals(iemstp)){
			getOrapppathgyInfo(id_or,emsdto,iemstp);
		}else if(EmsType.BT.equals(iemstp)){
			getOrappbtInfo(id_or,emsdto,iemstp);
		}else if(EmsType.CONS.equals(iemstp)){
			getOrappconsultInfo(id_or,emsdto,iemstp);
		}else if(EmsType.BTUSE.equals(iemstp)){
			getOrappbuInfo(id_or,emsdto,iemstp);
		}else if(EmsType.TRANSDEPT.equals(iemstp)){
			getOrapptransdepInfo(id_or,emsdto,iemstp);
		}else if(EmsType.OUTHOSP.equals(iemstp)){
			getOrappoutInfo(id_or,emsdto,iemstp);
		}
	}
	
	/**
	 * 会诊申请查询
	 * @throws BizException 
	 */
	private void getOrappconsultInfo(String id_or,CiEmsDTO emsdto,int iemstp) throws BizException{
		CiOrappconsultGetBP bp=new CiOrappconsultGetBP();
		CiorappconsultAggDO[] dos=bp.exec(id_or);
		CiOrdUtils.setEmsAppDatum(dos,emsdto,iemstp);
	}

	/**
	 * 手术申请查询
	 * @throws BizException 
	 */
	private void getOrappoptInfo(String id_or,CiEmsDTO emsdto,int iemstp) throws BizException{
		CiOrappoptGetBP bp=new CiOrappoptGetBP();
		CiorappsurgeryAggDO[] dos=bp.exec(id_or);
		CiOrdUtils.setEmsAppDatum(dos,emsdto,iemstp);
	}
	
	/**
	 * 病理申请查询
	 * @throws BizException 
	 */
	private void getOrapppathgyInfo(String id_or,CiEmsDTO emsdto,int iemstp) throws BizException{
		CiOrapppathgyGetBP bp=new CiOrapppathgyGetBP();
		CiorapppathgyAggDO[] dos=bp.exec(id_or);
		CiOrdUtils.setEmsAppDatum(dos,emsdto,iemstp);
	}

	/**
	 * 备血申请查询
	 * @throws BizException 
	 */
	private void getOrappbtInfo(String id_or,CiEmsDTO emsdto,int iemstp) throws BizException{
		CiOrappbtGetBP bp=new CiOrappbtGetBP();
		CiorappbtAggDO[] dos=bp.exec(id_or);
		CiOrdUtils.setEmsAppDatum(dos,emsdto,iemstp);
	}
	
	/**
	 * 用血申请查询
	 * @throws BizException 
	 */
	private void getOrappbuInfo(String id_or,CiEmsDTO emsdto,int iemstp) throws BizException{
		CiOrappbuGetBP bp=new CiOrappbuGetBP();
		OrdAppBtUseDO[] dos=bp.exec(id_or);
		CiOrdUtils.setEmsAppDatum(dos,emsdto,iemstp);
	}
	
	/**
	 * 检验申请查询
	 * @throws BizException 
	 */
	private void getOrapplisInfo(String id_or,CiEmsDTO emsdto,int iemstp) throws BizException{
		CiOrapplisGetBP bp=new CiOrapplisGetBP();
		OrdApLabDO[] dos=bp.exec(id_or);
		CiOrdUtils.setEmsAppDatum(dos,emsdto,iemstp);
		
	}
	
	/**
	 * 出院申请查询
	 * @throws BizException 
	 */
	private void getOrappoutInfo(String id_or,CiEmsDTO emsdto,int iemstp) throws BizException{
		CiOrappoutGetBP bp=new CiOrappoutGetBP();
		OrdApOutDO[] dos=bp.exec(id_or);
		CiOrdUtils.setEmsAppDatum(dos,emsdto,iemstp);
	}
	
	/**
	 * 检查申请查询
	 * @throws BizException 
	 */
	private void getOrapprisInfo(String id_or,CiEmsDTO emsdto,int iemstp) throws BizException{
		CiOrapprisGetBP bp=new CiOrapprisGetBP();
		OrdApObsDO[] dos=bp.exec(id_or);
		CiOrdUtils.setEmsAppDatum(dos,emsdto,iemstp);
	}
	
	/**
	 * 转科申请查询
	 * @throws BizException 
	 */
	private void getOrapptransdepInfo(String id_or, CiEmsDTO emsdto, int iemstp)
			throws BizException {
		CiOrapptransdepGetBP bp = new CiOrapptransdepGetBP();
		OrdApTransDO[] dos = bp.exec(id_or);
		CiOrdUtils.setEmsAppDatum(dos, emsdto, iemstp);
	}
	/**
	 * 将OrSrvDO中医保判断标识，转换为CiEmsSrvDTO中医生是否已判断过医保信息的标识，供前台使用
	 * @param orsrvEuHp
	 * @return
	 */
	private Integer orSrvEuHpToEmsSrvEuHp(Integer orsrvEuHp) {
		if (orsrvEuHp == null || orsrvEuHp == HpIndicJudgeEnum.NONEEDJUDGE
				|| orsrvEuHp == HpIndicJudgeEnum.JUDGED) {
			return 1;// 医生已判断
		} else {
			return 0;// 医生未判断
		}
	}
	/**
	 * 获取费用服务信息
	 * @param orsrvdos
	 * @return
	 * @throws BizException
	 */
	private FMap getBlSrvFMap(OrdSrvDO[] orsrvdos) throws BizException {
		GetCiOderBlSrvBP bp = new GetCiOderBlSrvBP();
		List<String> id_srvlist = new ArrayList<String>();
		for (OrdSrvDO srvdo : orsrvdos) {
			id_srvlist.add(srvdo.getId_srv());
		}
		return bp.getCiordBlSrvByIdsrvs(id_srvlist.toArray(new String[id_srvlist.size()]));
	}
}
