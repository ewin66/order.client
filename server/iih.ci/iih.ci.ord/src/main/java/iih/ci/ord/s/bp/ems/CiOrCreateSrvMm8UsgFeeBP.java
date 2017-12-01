package iih.ci.ord.s.bp.ems;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.emsdi.d.ExeDeptCalParamDTO;
import iih.ci.ord.emsdi.d.ExeWhDeptDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.CiOrBdSrvDrugNullException;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/*
 * 根据用法关联的材料费用服务创建临床医嘱项目操作BP
 */
public class CiOrCreateSrvMm8UsgFeeBP {
	/**
	 * 根据用法关联的材料费用服务创建临床医嘱项目
	 * @param aggdo
	 * @param bdsrvdo
	 * @param usgrelfeesrvdo
	 * @return
	 * @throws BizException
	 */
	public OrdSrvItemDatum exec(CiorderAggDO aggdo,MedSrvDO bdsrvdo,UsageRelFeeSrvDO usgrelfeesrvdo)  throws BizException{ 
		//有效性校验
		if(!validateCheck(aggdo,bdsrvdo,usgrelfeesrvdo))return null;
		
		//参数设置
		OrdSrvItemDatum rtn=new OrdSrvItemDatum();
		CiOrderDO ordo=aggdo.getParentDO();

		if(CiOrdUtils.isDONew(ordo)){//新增处理
			createCiOrSrvAndMmInfo(aggdo,bdsrvdo,rtn,usgrelfeesrvdo);
		}else{//修改处理
			orSrvMmInfoModHandle(aggdo,bdsrvdo,rtn,usgrelfeesrvdo);
		}
		
		return rtn;
	}
	
	/**
	 * 有效性校验
	 * @param aggdo
	 * @param bdsrvdo
	 * @param usgrelfeesrvdo
	 * @return
	 */
	private boolean validateCheck(CiorderAggDO aggdo,MedSrvDO bdsrvdo,UsageRelFeeSrvDO usgrelfeesrvdo){
		if(aggdo==null || aggdo.getParentDO()==null ||  bdsrvdo==null || usgrelfeesrvdo==null)return false;
		return true;
	}
	
	/**
	 * 根据用法关联的服务创建医嘱项目及关联的物品
	 * @param ordo
	 * @param bdsrvdo
	 * @param rtn
	 * @throws BizException 
	 */
	private void  createCiOrSrvAndMmInfo(CiorderAggDO aggdo,MedSrvDO bdsrvdo,OrdSrvItemDatum rtn,UsageRelFeeSrvDO usgrelfeesrvdo) throws BizException{
		CiOrderDO ordo=aggdo.getParentDO();
		OrdSrvDO srvdo=new OrdSrvDO();
		MedSrvRelMmDTO srvrelmmdo=null;
		//srvdo.setId_orsrv(srvdto.getId_orsrv());
		srvdo.setId_or(ordo.getId_or());
		//srvdo.setId_pres(srvdto.getId_pres());
		srvdo.setId_pat(ordo.getId_pat());
		srvdo.setId_entp(ordo.getId_entp());
		srvdo.setCode_entp(ordo.getCode_entp());
		srvdo.setId_en(ordo.getId_en());
		//srvdo.setSortno(srvdto.getSortno());
		srvdo.setId_srvtp(bdsrvdo.getId_srvtp());
		srvdo.setSd_srvtp(bdsrvdo.getSd_srvtp());
		srvdo.setId_srv(bdsrvdo.getId_srv());
		srvdo.setName(bdsrvdo.getName());
		srvdo.setFg_dose_anoma(FBoolean.FALSE);
//		//2016-11-14 修正原有的剂量及剂量单位逻辑  下面6行原有的代码注释掉了   
//		//要注意的是服务单价是以BD_SRV中的医学单位定义的****计算单价时要考虑两者的单位转换
		//服务关联时，是定值时实际上是有两层含义（总量定值法、单次定值法）：我们目前情况下是指总量定值法
		if(CiOrdUtils.isTrue(usgrelfeesrvdo.getIsTotalQuanMd())){//2016-11-14 新增  服务关联总量模式的赋值逻辑
			srvdo.setQuan_medu(null);
			srvdo.setId_medu(CiOrdUtils.getUnit4UsgRelFeeSrv(usgrelfeesrvdo)); 
		}else{
//		srvdo.setQuan_medu(bdsrvdo.getQuan_med()); 
//		srvdo.setId_medu(bdsrvdo.getId_unit_med());	
		srvdo.setQuan_medu(CiOrdUtils.getQuan_Med4UsgRelFeeSrv(usgrelfeesrvdo));  //2016-06-22修改 //bdsrvdo.getQuan_med()
//		if(CiOrdUtils.isHerbOrder(ordo.getSd_srvtp())){//2016-08-15注释掉这个逻辑判断
//			srvdo.setId_medu(bdsrvdo.getId_unit_med());
//		}else{
			srvdo.setId_medu(CiOrdUtils.getUnit4UsgRelFeeSrv(usgrelfeesrvdo));   
//		}
		}
		srvdo.setId_route(bdsrvdo.getId_route());
		srvdo.setId_routedes(bdsrvdo.getId_routedes());
		srvdo.setId_boil(bdsrvdo.getId_boil());
		srvdo.setId_boildes(bdsrvdo.getId_boildes());
		srvdo.setId_freq(ordo.getId_freq());
		//zwq 2016-09-05
		srvdo.setFreqct(ordo.getFreqct());
		srvdo.setFreq_name(ordo.getFreq_name());
		srvdo.setSd_frequnitct(ordo.getSd_frequnitct());
		
		srvdo.setId_org_srv(ordo.getId_org_or());
		srvdo.setId_dep_srv(ordo.getId_dep_or());
		srvdo.setId_wg_or(ordo.getId_wg_or());
		srvdo.setId_emp_srv(ordo.getId_emp_or());
		srvdo.setDt_create(ordo.getDt_entry());
		//srvdo.setId_dep_mp(getMpDeptID());      //调整到最后
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		//srvdo.setDt_last_mp(srvdto.getDt_last_mp());
		//在开立时，dt_last_cg的值不存储
//		srvdo.setDt_last_cg(getLastDt(ordo.getId_freq(),ordo.getDt_effe(),ordo.getQuan_firday_mp(),ordo.getFg_long()));
		srvdo.setDt_last_bl(getLastDt(ordo.getId_freq(),ordo.getDt_effe(),ordo.getQuan_firday_mp(),ordo.getFg_long()));
		srvdo.setFg_or(FBoolean.FALSE);
		srvdo.setEu_blmd(bdsrvdo.getEu_blmd());  //本服务定价
		srvdo.setFg_mm(FBoolean.FALSE);
		srvdo.setFg_set(FBoolean.FALSE);
		//srvdo.setFg_indic(srvdto.getFg_indic());
		srvdo.setFg_propc(FBoolean.FALSE);
		srvdo.setFg_self(FBoolean.FALSE);
		srvdo.setFg_pres_outp(FBoolean.FALSE);
		srvdo.setNote_srv("");
		srvdo.setId_srvca(bdsrvdo.getId_srvca());
		srvdo.setFg_bl(CiOrdUtils.nullHandle(bdsrvdo.getFg_bl()));
		srvdo.setCode_srv(bdsrvdo.getCode());
//		if(CiOrdUtils.isHerbOrder(ordo.getSd_srvtp())){
//			srvdo.setEu_sourcemd(OrSrvSourceFromEnum.BOILRELFEE);
//		}else{
//			srvdo.setEu_sourcemd(OrSrvSourceFromEnum.USAGERELFEE);
//		}
		srvdo.setEu_sourcemd(CiOrdUtils.getRelType_Med4UsgRelFeeSrv(usgrelfeesrvdo));
		//srvdo.setFg_skintest_rst(Fg_skintest_rst);//2016-06-28新增字段
		srvdo.setId_primd(bdsrvdo.getId_primd());
		srvdo.setFg_selfsrv(bdsrvdo.getFg_ctm());
		srvdo.setId_srv_src(ordo.getId_srv());
		//只有门诊模式才计算总量
		if(CiOrdUtils.isOpMode(ordo.getCode_entp(), ordo.getFg_pres_outp(),srvdo.getSd_srvtp()).booleanValue()||srvdo.getEu_sourcemd().equals(OrSrvSourceFromEnum.BOILRELFEE)){
			srvdo.setQuan_total_medu(CiOrdUtils.getQuan4UsgRelFeeSrv(ordo,usgrelfeesrvdo));
		}
		//srvdo.setFg_selfpay(setsrv.getFg_selfpay());//2016-07-08新增自费标识  可能是有问题
		srvdo.setId_hp(usgrelfeesrvdo.getDef1());//2016-07-12新增医保相关信息
		//srvdo.setId_hpsrvtp(setsrv.getId_hpsrvtp());
		//srvdo.setSd_hpsrvtp(setsrv.getSd_hpsrvtp());
		if(OrSrvSplitUtil.isTrue(srvdo.getFg_mm())){srvrelmmdo=CiOrdUtils.getSrvRelDefaultMmDTO(bdsrvdo.getId_srv(), ordo.getId_dep_or());}
		ExeWhDeptDTO exeandwhdeptinfo=null;  //2016-07-28  新执行科室逻辑调整    调整到新的时将如下语句进行对应处理
		if(srvdo.getId_dep_mp()== null){
			exeandwhdeptinfo=getMpDeptID(ordo,bdsrvdo,srvrelmmdo);  //待打开
			srvdo.setId_org_mp(exeandwhdeptinfo.getId_org_mp());   //待打开
			srvdo.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp());   //待打开
			srvdo.setId_dep_wh(exeandwhdeptinfo.getId_dep_wh());   //待打开
		}else{}
		if(srvdo.getId_org_mp()== null){srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));}
		
		//给 id_org和id_grp赋值	

	    srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId());
	    srvdo.setId_grp( CiOrdAppUtils.getEnvContext().getGroupId());
	    
		srvdo.setFg_feertnable(FBoolean.TRUE);
		srvdo.setStatus(DOStatus.NEW);
		rtn.setSrvdo(srvdo);
		
		//医嘱项目对应的物品处理
		if(OrSrvSplitUtil.isTrue(bdsrvdo.getFg_mm())){
			OrdSrvMmDO ordsrvmmdo=createCiOrdSrvMmDO(srvdo,bdsrvdo,srvrelmmdo);
			rtn.setSrvmm(ordsrvmmdo);
		}else{
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ordo.getCode_entp(), srvdo.getId_srv(), srvdo.getId_primd(), srvdo);
		}
	}
	
	/**
	 * 根据用法关联的服务设置医嘱项目及关联的物品信息数据
	 * @param ordo
	 * @param srvdo
	 * @param bdsrvdo
	 * @param rtn
	 * @throws BizException
	 */
	private void  setOrSrvAndMmInfo(CiOrderDO ordo,OrdSrvDO srvdo,MedSrvDO bdsrvdo,OrdSrvItemDatum rtn) throws BizException{
		MedSrvRelMmDTO srvrelmmdo=null;
		//srvdo.setId_orsrv(srvdto.getId_orsrv());
		//srvdo.setId_or(srvdto.getId_or());
		//srvdo.setId_pres(srvdto.getId_pres());
		//srvdo.setId_pat(ordo.getId_pat());
		//srvdo.setId_entp(ordo.getId_entp());
		//srvdo.setCode_entp(ordo.getCode_entp());
		//srvdo.setId_en(ordo.getId_en());
		//srvdo.setSortno(srvdto.getSortno());
		srvdo.setId_srvtp(bdsrvdo.getId_srvtp());
		srvdo.setSd_srvtp(bdsrvdo.getSd_srvtp());
		srvdo.setId_srv(bdsrvdo.getId_srv());
		srvdo.setName(bdsrvdo.getName());
		srvdo.setFg_dose_anoma(FBoolean.FALSE);
		srvdo.setQuan_medu(bdsrvdo.getQuan_med());
		
		srvdo.setId_medu(bdsrvdo.getId_unit_med());
		srvdo.setId_route(bdsrvdo.getId_route());
		srvdo.setId_routedes(bdsrvdo.getId_routedes());
		srvdo.setId_boil(bdsrvdo.getId_boil());
		srvdo.setId_boildes(bdsrvdo.getId_boildes());
		srvdo.setId_freq(bdsrvdo.getId_freq());
		
		//srvdo.setId_org_srv(ordo.getId_org_or());
		//srvdo.setId_dep_srv(ordo.getId_dep_or());
		//srvdo.setId_wg_or(ordo.getId_wg_or());
		//srvdo.setId_emp_srv(ordo.getId_emp_or());
		//srvdo.setDt_create(ordo.getDt_entry());
		//srvdo.setId_dep_mp(getMpDeptID());    //调整到最后
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		//srvdo.setDt_last_mp(srvdto.getDt_last_mp());
		srvdo.setDt_last_bl(getLastDt(ordo.getId_freq(),ordo.getDt_effe(),ordo.getQuan_firday_mp(),ordo.getFg_long()));
		srvdo.setFg_or(FBoolean.FALSE);
		srvdo.setEu_blmd(bdsrvdo.getEu_blmd());  //本服务定价
		srvdo.setFg_mm(FBoolean.FALSE);
		//srvdo.setPri(getPrice(bdsrvdo.getId_srv(),bdsrvdo.getId_primd()));  //物品价格  再算
		srvdo.setFg_set(FBoolean.FALSE);
		//srvdo.setFg_indic(srvdto.getFg_indic());
		srvdo.setFg_propc(FBoolean.FALSE);
		srvdo.setFg_self(FBoolean.FALSE);
		srvdo.setFg_pres_outp(FBoolean.FALSE);
		srvdo.setNote_srv("");
		srvdo.setId_srvca(bdsrvdo.getId_srvca());
		srvdo.setFg_bl(CiOrdUtils.nullHandle(bdsrvdo.getFg_bl()));
		srvdo.setCode_srv(bdsrvdo.getCode());
		//srvdo.setEu_sourcemd(OrSrvSourceFromEnum.USAGERELFEE);  //2016-08-15注释掉该行
		//2016-06-28新增字段
		//srvdo.setFg_skintest_rst(Fg_skintest_rst);
		srvdo.setId_primd(bdsrvdo.getId_primd());
		srvdo.setFg_selfsrv(bdsrvdo.getFg_ctm());
		srvdo.setId_srv_src(ordo.getId_srv());
		//srvdo.setQuan_total_medu(CiOrdUtils.getQuan4UsgRelFeeSrv(ordo,usgrelfeesrvdo));
		//srvdo.setFg_selfpay(setsrv.getFg_selfpay());//2016-07-08新增自费标识  可能是有问题
		//srvdo.setId_hp(orsrvdos[0].getId_hp());//2016-07-12新增医保相关信息
		//srvdo.setId_hpsrvtp(setsrv.getId_hpsrvtp());
		//srvdo.setSd_hpsrvtp(setsrv.getSd_hpsrvtp());
		if(OrSrvSplitUtil.isTrue(srvdo.getFg_mm())){srvrelmmdo=CiOrdUtils.getSrvRelDefaultMmDTO(bdsrvdo.getId_srv(), srvdo.getId_dep_srv());}
		ExeWhDeptDTO exeandwhdeptinfo=null;  //2016-07-28  新执行科室逻辑调整    调整到新的时将如下语句进行对应处理
		if(srvdo.getId_dep_mp()== null){
			exeandwhdeptinfo=getMpDeptID(ordo,bdsrvdo,srvrelmmdo);  //待打开
			srvdo.setId_org_mp(exeandwhdeptinfo.getId_org_mp());   //待打开
			srvdo.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp());   //待打开
			srvdo.setId_dep_wh(exeandwhdeptinfo.getId_dep_wh());   //待打开
		}else{}
		if(srvdo.getId_org_mp()== null){srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));}

		//给 id_org和id_grp赋值	
//
//	    srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId());
//	    srvdo.setId_grp( CiOrdAppUtils.getEnvContext().getGroupId());
	    
		srvdo.setStatus(DOStatus.UPDATED);
		rtn.setSrvdo(srvdo);
		
		//医嘱项目对应的物品处理
		if(OrSrvSplitUtil.isTrue(bdsrvdo.getFg_mm())){
			OrdSrvMmDO ordsrvmmdo=createCiOrdSrvMmDO(srvdo,bdsrvdo,srvrelmmdo);
			rtn.setSrvmm(ordsrvmmdo);
		}else{
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ordo.getCode_entp(), srvdo.getId_srv(), srvdo.getId_primd(), srvdo);
		}
	}
	
	
	/**
	 * 创建医嘱项目对应的物品DO信息
	 * @param srvdo
	 * @param bdsrvdo
	 * @return
	 * @throws BizException 
	 */
		//MedSrvRelMmDO srvrelmmdo=CiOrdUtils.getSrvRelDefaultMmDO(bdsrvdo.getId_srv(), srvdo.getId_dep_srv());//2016-04-14注释掉
	private OrdSrvMmDO createCiOrdSrvMmDO(OrdSrvDO srvdo,MedSrvDO bdsrvdo,MedSrvRelMmDTO srvrelmmdo) throws BizException{
		//MedSrvRelMmDTO srvrelmmdo=CiOrdUtils.getSrvRelDefaultMmDTO(bdsrvdo.getId_srv(), srvdo.getId_dep_srv());
		MeterialDO mmdo=null;
		MedSrvDrugDO medSrvDrugDO =null;
		//medSrvDrugDO =   CiOrdAppUtils.getIMedSrvDrugDORService().findById(bdsrvdo.getId_srv());
		medSrvDrugDO =CiOrdUtils.getBdSrvDrugDO(bdsrvdo.getId_srv());
		if(medSrvDrugDO == null) throw new CiOrBdSrvDrugNullException(bdsrvdo.getName());
		if(srvrelmmdo!=null){mmdo=CiOrdAppUtils.getMaterialQryService().findById(srvrelmmdo.getId_mm());}
		if(mmdo==null)return null;
		 
		OrdSrvMmDO srvmmdo=new OrdSrvMmDO();
		
		//srvmmdo.setId_orsrvmm();
		//srvmmdo.setId_orsrv();
		srvmmdo.setId_mm(mmdo.getId_mm());
		srvmmdo.setCode_mm(mmdo.getCode());
		srvmmdo.setName_mm(mmdo.getName());
		srvmmdo.setId_pgku_cur(mmdo.getId_unit_pkgsp());
		srvmmdo.setPrice_pgku_cur(getMaterialStockPrice(srvdo.getId_dep_mp(),mmdo.getId_mm(),mmdo.getId_unit_pkgsp()));
		//srvmmdo.setQuan_cur(srvdto.getQuan_cur());
		srvmmdo.setId_pgku_base(mmdo.getId_unit_pkgbase());
		int[] numben=OrSrvSplitUtil.getNumDen(bdsrvdo.getQuan_med(), mmdo.getFactor_mb());
		srvmmdo.setQuan_num_base(numben[0]);
		srvmmdo.setQuan_den_base(numben[1]);
		//srvmmdo.setQuan_bed_medu(srvdto.getQuan_bed_medu());
		srvmmdo.setFactor(mmdo.getFactor_sb());
		srvmmdo.setFactor_mb(mmdo.getFactor_mb());
		srvmmdo.setId_val(mmdo.getId_val());
		srvmmdo.setSd_val(mmdo.getSd_val());
		if(!CiOrdUtils.isEmpty(medSrvDrugDO)){
			srvmmdo.setId_dosage(medSrvDrugDO.getId_dosage());
			srvmmdo.setSd_dosage(medSrvDrugDO.getSd_dosage());
			srvmmdo.setId_pharm(medSrvDrugDO.getId_pharm());
			srvmmdo.setSd_pharm(medSrvDrugDO.getSd_pharm());
			srvmmdo.setId_pois(medSrvDrugDO.getId_pois());
			srvmmdo.setSd_pois(medSrvDrugDO.getSd_pois());
			srvmmdo.setId_anti(medSrvDrugDO.getId_anti());
			srvmmdo.setSd_anti(medSrvDrugDO.getSd_anti());
		}
		srvmmdo.setId_mmtp(mmdo.getId_mmtp());
		srvmmdo.setSd_mmtp(mmdo.getSd_mmtp());
		//srvmmdo.setId_antipsy(mmdo.getId_antipsy());  //暂时没有这个概念
		//srvmmdo.setSd_antipsy(mmdo.getSd_antipsy());
		//srvmmdo.setFg_otc(mmdo.getFg_otc()); //物品中需要增加此字段
		
		srvmmdo.setStatus(DOStatus.NEW);
		
		return srvmmdo;
	}
	
	/**
	 * 获得服务对应的执行科室
	 * @return
	 * @throws BizException
	 */
	private String getMpDeptID(CiOrderDO ordo,OrdSrvDO srvdo) throws BizException{
		OrWfExDeptParamDTO param=getOrWfExDeptParam(ordo,srvdo);
		CiOrSrvExecuteDeptGetBP bp=new CiOrSrvExecuteDeptGetBP();
		OrWfExDeptDTO[] do1=bp.exec(param);
		if(do1==null  || do1.length==0)return null;
		return do1[0].getId_dept();
	}
	private OrWfExDeptParamDTO getOrWfExDeptParam(CiOrderDO ordo,OrdSrvDO srvdo) throws BizException{
		String[] depsinfo=CiOrdUtils.getPatEnDepInfo(ordo.getId_en());
		OrWfExDeptParamDTO param=new OrWfExDeptParamDTO();
		param.setCode_entp(ordo.getCode_entp());
		param.setSd_srvtp(srvdo.getSd_srvtp());
		param.setId_srvca(srvdo.getId_srvca());
		param.setId_usage(srvdo.getId_route());
		param.setRecurstr(CiOrdUtils.getFg_longStr(ordo.getFg_long()));
		//param.setWeekno();
		//param.setTimestr();
		param.setId_srv(srvdo.getId_srv());
		//param.setId_mm();
		param.setId_dept_en(depsinfo[0]);
		param.setId_dept_ns(depsinfo[1]);
		param.setId_dept_or(srvdo.getId_dep_srv());
		//param.setId_dept_ex();
		//param.setReserv1("");  //所属套
		//param.setReserv2();
		//param.setReserv3();		

		return param;
	}
	
	/**
	 * 获得最近医嘱生成日期
	 * @param id_freq
	 * @param dt_effe
	 * @param firstdaytimes
	 * @return
	 * @throws BizException
	 */
	private FDateTime getLastDt(String id_freq,FDateTime dt_effe,Integer firstdaytimes,FBoolean fg_long) throws BizException{
		CiOrDtLastBlCal4OpenBP bp=new CiOrDtLastBlCal4OpenBP();
		return bp.exec(id_freq, dt_effe, firstdaytimes,fg_long);
	}
	
	/**
	 * 获得服务价格
	 * @param id_srv
	 * @param id_primd
	 * @return
	 * @throws BizException
	 */
	private FDouble getPrice(String id_srv,String id_primd) throws BizException{
		CiOrCalSrvPriceBP bp=new CiOrCalSrvPriceBP();
		return bp.exec(id_srv, id_primd);
	}
	
	/**
	 * 获得价格  结存量信息
	 * @param id_dep
	 * @param id_mm
	 * @param id_unit
	 * @return
	 * @throws BizException
	 */
	private FDouble  getMaterialStockPrice(String id_dep,String id_mm,String id_unit)  throws BizException{
		CiOrGetMmPriceBP bp=new CiOrGetMmPriceBP();
		return bp.exec(id_dep, id_mm, id_unit);
	}
	
	/**
	 * 设置医嘱项目数据信息
	 * @param aggdo
	 * @param bdsrvdo
	 * @param rtn
	 * @throws BizException
	 */
	private void orSrvMmInfoModHandle(CiorderAggDO aggdo,MedSrvDO bdsrvdo,OrdSrvItemDatum rtn,UsageRelFeeSrvDO usgrelfeesrvdo) throws BizException {
		OrdSrvDO srvdo=CiOrdUtils.getMatchDatum(aggdo.getOrdSrvDO(), bdsrvdo.getId_srv(),OrdSrvDO.ID_SRV);
		if(srvdo==null){//新增情况
			createCiOrSrvAndMmInfo(aggdo,bdsrvdo,rtn, usgrelfeesrvdo);
		}else{
			
		}
	}
	
	/**
	 * 获得执行科室数据信息
	 * @param ordo
	 * @param ems
	 * @param srvinsetdo
	 * @param tmpdo
	 * @param srvrelmmdo
	 * @return
	 * @throws BizException
	 */
	private ExeWhDeptDTO getMpDeptID(CiOrderDO ordo,MedSrvDO bdsrvdo,MedSrvRelMmDTO srvrelmmdo) throws BizException{
		ExeDeptCalParamDTO param=getExeDeptCalParamDTO(ordo,bdsrvdo,srvrelmmdo);
		return CiOrdUtils.getMpDeptID(param);
	}
	
	/**
	 * 获得执行科室计算参数信息DTO
	 * @param ordo
	 * @param ems
	 * @param srvinsetdo
	 * @param tmpdo
	 * @param srvrelmmdo
	 * @return
	 * @throws BizException 
	 */
	private ExeDeptCalParamDTO getExeDeptCalParamDTO(CiOrderDO ordo,MedSrvDO bdsrvdo,MedSrvRelMmDTO srvrelmmdo) throws BizException{
		ExeDeptCalParamDTO paramdto=new ExeDeptCalParamDTO();
		PatiVisitDO pvdo=CiOrdUtils.getPatiVisitDO(ordo.getId_en());  //最后注释掉 从 ordo中取该相关数据值
		paramdto.setCode_entp(ordo.getCode_entp());
		paramdto.setId_dep_en(pvdo.getId_dep_phy());
		paramdto.setId_dep_or(ordo.getId_dep_or());
		paramdto.setId_dep_ns(pvdo.getId_dep_nur());
		paramdto.setId_dep_exe(ordo.getId_dep_mp());
		paramdto.setFg_long(ordo.getFg_long());
		paramdto.setId_srv(bdsrvdo.getId_srv());
		if(!CiOrdUtils.isEmpty(srvrelmmdo)){
		paramdto.setId_mm(srvrelmmdo.getId_mm());}
		paramdto.setSd_srvtp(bdsrvdo.getSd_srvtp());
		paramdto.setId_srvca(bdsrvdo.getId_srvca());
		paramdto.setInnercode_srvca(bdsrvdo.getSrvca_innercode());
		paramdto.setId_route(bdsrvdo.getId_route());
		paramdto.setDt_effe(ordo.getDt_effe());
		//paramdto.setDef1();
		//paramdto.setDef2();
		//paramdto.setDef3();
		//paramdto.setDef4();
		//paramdto.setDef5();
		if(!CiOrdUtils.isTrue(bdsrvdo.getFg_mm())){
			paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW);  //只求执行科室
		}else{
			paramdto.setEu_wftp(EnumFlow.NULL);   //求物资流向科室
		}
		
		return paramdto;
	}
}
