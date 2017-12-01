package iih.ci.ord.s.bp.ems;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.srv.ems.d.eu_srvcatpenum;
import iih.bd.srv.medsrv.d.MedSrvBlModeEnum;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciordems.d.QuantumParamDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorsrvhp.d.CiOrSrvHpDO;
import iih.ci.ord.ciorsrvhp.i.ICiorsrvhpRService;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.ExeDeptCalParamDTO;
import iih.ci.ord.emsdi.d.ExeWhDeptDTO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.common.CiOrParamUtils;
import iih.ci.ord.s.bp.exception.CiOrSrvMmRelSkinSrvNullException;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 生成医嘱项目信息（含物品）操作BP
 */
public class CiOrCreateSrvMm8EmsBP {
	/**
	 * 生成医嘱项目信息（含物品）
	 * @param ordo
	 * @param ems
	 * @param index
	 * @return
	 * @throws BizException
	 */
	public  OrdSrvItemDatum exec(CiorderAggDO aggdo,CiEmsDTO ems,int index)  throws BizException{
		CiOrderDO ordo=aggdo.getParentDO();
	
		OrdSrvItemDatum rtn=new OrdSrvItemDatum();
		if(CiOrdUtils.isDONew(ordo)){//新增处理
			createOrSrvMmInfo(ordo,ems,index,rtn);
		}else if(CiOrdUtils.isDOMod(ordo)){//修改处理
			orSrvMmInfoModHandle(aggdo,ems,index,rtn);
		}
		
		return rtn;
	}
	public  OrdSrvItemDatum exec(CiorderAggDO aggdo,CiEmsDTO ems,int index,Map<String,MedSrvSetItemDO> bdsrvinsetClinicalMap)  throws BizException{
		CiOrderDO ordo=aggdo.getParentDO();
	
		OrdSrvItemDatum rtn=new OrdSrvItemDatum();
		if(CiOrdUtils.isDONew(ordo)){//新增处理
			createOrSrvMmInfo(ordo,ems,index,rtn,bdsrvinsetClinicalMap);
		}else if(CiOrdUtils.isDOMod(ordo)){//修改处理
			orSrvMmInfoModHandle(aggdo,ems,index,rtn,bdsrvinsetClinicalMap);
		}
		
		return rtn;
	}
	/**
	 * 生成医嘱项目信息
	 * @param ordo
	 * @param ems
	 * @param index
	 * @param rtn
	 * @throws BizException
	 */
	private void createOrSrvMmInfo(CiOrderDO ordo,CiEmsDTO ems,int index,OrdSrvItemDatum rtn) throws BizException {
		OrdSrvDO srvdo=new OrdSrvDO(); 
		HashMap<String, CiOrSrvHpDO> orSrvHpMap = new HashMap<String, CiOrSrvHpDO>();
		CiEmsSrvDTO srvdto=(CiEmsSrvDTO)ems.getEmssrvs().get(index);
		if(srvdto.getStatus()==DOStatus.DELETED) return;
		CiOrSrvHpDO ciorsrvhpdo = new CiOrSrvHpDO();
		if(!CiOrdUtils.isEmpty(srvdto.getBdHpIndication())){
			BdHpIndicationDTO bdHpIndication = (BdHpIndicationDTO) srvdto.getBdHpIndication().get(0);
			//FIXME 枚举
			//ciorsrvhpdo.setEu_hpindicrst();
			int model = CiOrParamUtils.getMedInsuranceIndicInfoModelSet(CiOrdAppUtils.getEnvContext().getOrgId());
			if(model==2){
				ciorsrvhpdo.setDes_hplimit(" 医保限制条件："+CiOrdUtils.IsNull(bdHpIndication.getDes_hplimit())+"\n 院内限制条件："+ CiOrdUtils.IsNull(bdHpIndication.getDes_hislimit()));
			}else if(model==1){
				ciorsrvhpdo.setDes_hplimit(" 院内限制条件："+ CiOrdUtils.IsNull(bdHpIndication.getDes_hislimit()));
			}else{
				ciorsrvhpdo.setDes_hplimit(bdHpIndication.getDes_hplimit());
			}
			ciorsrvhpdo.setIndicitemid(srvdto.getIndicitemid());
			ciorsrvhpdo.setDes_hpsrvtp(bdHpIndication.getDes_hpsrvtp());
			ciorsrvhpdo.setEu_hpindicjudged_model(bdHpIndication.getCode_hpindicjudged());
			ciorsrvhpdo.setFg_indic(bdHpIndication.getFg_indic());
			ciorsrvhpdo.setFg_selfpay(srvdto.getFg_selfpay());
			//ciorsrvhpdo.setFg_specill();
			ciorsrvhpdo.setId_ent(ordo.getId_en());
			ciorsrvhpdo.setId_hp(srvdto.getId_hp());
			ciorsrvhpdo.setId_hpsrvtp(srvdto.getId_hpsrvtp());
			ciorsrvhpdo.setStatus(srvdto.getStatus());
			orSrvHpMap.put(srvdto.getId_srv(), ciorsrvhpdo);
			rtn.setCiorsrvhpdo(orSrvHpMap);
			//ciorsrvhpdo.setId_orsrv(Id_orsrv);
//			BdHpIndication.
		}else{
			if(!CiOrdUtils.isEmpty(srvdto.getIndicitemid())){
				ciorsrvhpdo.setIndicitemid(srvdto.getIndicitemid());
				ciorsrvhpdo.setStatus(srvdto.getStatus());
				rtn.setCiorsrvhpdo(orSrvHpMap);
			}
		}
		//多报销比例id yzh
		srvdo.setIndicitemid(srvdto.getIndicitemid());//计算字段
		//srvdo.setId_orsrv(srvdto.getId_orsrv());
		srvdo.setId_or(CiOrdUtils.getCiOrderId(ordo, srvdto.getId_or()));
		//srvdo.setId_pres(srvdto.getId_pres());
		srvdo.setId_pat(ordo.getId_pat());
		srvdo.setId_entp(ordo.getId_entp());
		srvdo.setCode_entp(ordo.getCode_entp());
		srvdo.setId_en(ordo.getId_en());
		srvdo.setSortno(srvdto.getSortno());
		srvdo.setId_srvtp(srvdto.getId_srvtp());
		srvdo.setSd_srvtp(srvdto.getSd_srvtp());
		srvdo.setId_srv(srvdto.getId_srv());
		srvdo.setName(srvdto.getName_srv());
		srvdo.setFg_dose_anoma(CiOrdUtils.nullHandle(srvdto.getFg_dose_anoma()));
		srvdo.setQuan_medu(srvdto.getQuan_med());
		srvdo.setId_medu(srvdto.getId_unit_med());
		srvdo.setId_route(srvdto.getId_route());
		srvdo.setId_routedes(srvdto.getId_routedes());
		srvdo.setId_boil(srvdto.getId_boil());
		srvdo.setId_boildes(srvdto.getId_boildes());
		srvdo.setId_freq(srvdto.getId_freq());   //2016-12-01 - mxj - 修改ordo.getId_freq()--》srvdto.getId_freq()  应该为业务传进的项目freq不应该是医嘱的freq，如果是的话应该走业务规则算法
		srvdo.setId_org_srv(ordo.getId_org_or());
		srvdo.setId_dep_srv(ordo.getId_dep_or());
		srvdo.setId_wg_or(ordo.getId_wg_or());
		srvdo.setId_emp_srv(ordo.getId_emp_or());
		srvdo.setDt_create(ordo.getDt_entry());
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdto.getId_dep()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
	    //srvdo.setDt_last_mp(ordo.getDt_effe());//孟祥杰 张镌尹  王琦 讨论 开立时不用赋值
	    //孟祥杰 张镌尹  王琦 讨论 不赋值
		//srvdo.setDt_last_cg(getLastDt(srvdto.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		srvdo.setDt_last_bl(getLastDt(srvdto.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		srvdo.setFg_or(CiOrdUtils.nullHandle(srvdto.getFg_or()));
		srvdo.setEu_blmd(srvdto.getEu_blmd());
		srvdo.setFg_mm(CiOrdUtils.nullHandle(srvdto.getFg_mm()));
		//if(CiOrdUtils.isEmpty(srvdto.getPrice())){
			//映射折扣价，如果折扣价为空，则后台再查询折扣价
		if(!CiOrdUtils.isEmpty(srvdo.getEu_blmd()) && srvdo.getEu_blmd()==MedSrvBlModeEnum.MANUALBL){
			srvdo.setPri(srvdto.getPrice());
			srvdo.setPri_std(srvdto.getPrice());
			srvdo.setPri_ratio(FDouble.ONE_DBL);
		}else{
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ordo.getCode_entp(), srvdto, srvdo);
		}
//		}else{
//			srvdo.setPri(srvdto.getPrice());
//			srvdo.setPri_std(srvdto.getPri_std());
//			srvdo.setPri_ratio(srvdto.getPri_ratio());
//			srvdo.setId_pripat(srvdto.getId_pripat());
//		}
		srvdo.setFg_set(CiOrdUtils.nullHandle(srvdto.getFg_set()));
		srvdo.setFg_indic(srvdto.getFg_indic());//之前关闭，现在打开了（zhangwq）
		srvdo.setFg_propc(CiOrdUtils.nullHandle(srvdto.getFg_propc()));
		srvdo.setFg_self(CiOrdUtils.nullHandle(srvdto.getFg_self()));
		srvdo.setFg_pres_outp(CiOrdUtils.nullHandle(srvdto.getFg_outp()));
		srvdo.setNote_srv(srvdto.getDes_srv());
		srvdo.setId_srvca(srvdto.getId_srvca());
		srvdo.setFg_bl(CiOrdUtils.nullHandle(srvdto.getFg_bl()));
		srvdo.setCode_srv(srvdto.getCode_srv());
		srvdo.setEu_sourcemd(srvdto.getEu_sourcemd());
		srvdo.setEu_blmd(srvdto.getEu_blmd());
	    srvdo.setId_primd(srvdto.getId_primd());
		srvdo.setFg_skintest(CiOrdUtils.nullHandle(srvdto.getFg_skintest()));//2016-03-25 新增
		srvdo.setId_skintest_skip_reason(srvdto.getId_skintest_skip_reason());//2016-03-25 新增
		srvdo.setSd_skintest_skip_reason(srvdto.getSd_skintest_skip_reason());//2016-03-25 新增
		srvdo.setId_reltp(srvdto.getId_reltp());//2016-03-25 新增 关联类型
		srvdo.setFg_hpindicjudged(srvdto.getFg_hpindicjudged());//0不需要判断，1待判断，2已判断;
		srvdo.setFg_extdispense(srvdto.getFg_extdispense());//外配药标识
		if(srvdo.getFg_skintest()==FBoolean.TRUE)
		{
			srvdo.setSd_reltp(IBdSrvDictCodeConst.SD_RELORDTYPE_SKIN);
		}else{
			srvdo.setSd_reltp(srvdto.getSd_reltp());//2016-03-25 新增  关联类型编码
		}
		srvdo.setId_or_rel(srvdto.getId_or_rel());//2016-03-25 新增  对应关联医嘱id
		//srvdo.setDt_last_cg(srvdto.getDt_last_bl());//2016-03-25 新增  最近费用日期
		srvdo.setEu_sourcemd(srvdto.getEu_sourcemd()); //添加医疗单来源
		srvdo.setId_primd(srvdto.getId_primd());
		srvdo.setFg_selfsrv(srvdto.getFg_selfsrv());
		srvdo.setId_srv_src(srvdto.getId_srv_src());
		
		// 非住院就诊或出院带药时候，计算服务总量 -- 2016.12.28 by wangqzh
		if(CiOrdUtils.isOpMode(ems.getCode_entp(), ems.getFg_pres_outp(),srvdo.getSd_srvtp()).booleanValue()){
			CiOrdUtils.setQuanTotalMeduToSrvDO(ems, srvdto, srvdo);
		}
//		if (!ems.getCode_entp().equals(IEnDictCodeConst.SD_ENTP_INPATIENT)||(!CiOrdUtils.isEmpty(ems.getFg_pres_outp()))&&ems.getFg_pres_outp().booleanValue()){
//
//			if(srvdto.getQuan_total_medu() != null&&srvdto.getQuan_total_medu().doubleValue()!=0){
//				srvdo.setQuan_total_medu(srvdto.getQuan_total_medu());
//			}else{
//				QuantumParamDTO quantum = new QuantumParamDTO(ems,srvdto);
//				CalQuantumBP bp = new CalQuantumBP();
//				srvdo.setQuan_total_medu(bp.getQuantum(quantum));
//				//srvdo.setQuan_total_medu(CiOrdUtils.getTotalMedu(srvdto,ems.getDays_or(),ems.getOrders()));
//			}
//		}
		srvdo.setFg_selfpay(srvdto.getFg_selfpay());//2016-07-08新增自费标识
		srvdo.setId_hp(srvdto.getId_hp());//2016-07-12新增医保相关信息
		srvdo.setId_hpsrvtp(srvdto.getId_hpsrvtp());
		srvdo.setSd_hpsrvtp(srvdto.getSd_hpsrvtp());
		srvdo.setDes_hplimit(srvdto.getLimit());
		srvdo.setFg_pres_outp(srvdto.getFg_outp());//出院带药标识  zwq 2016-08-11
		ExeWhDeptDTO exeandwhdeptinfo=null;  //2016-07-28  新执行科室逻辑调整    调整到新的时将如下语句进行对应处理
		if(srvdto.getId_dep() == null){
			exeandwhdeptinfo=CiOrdUtils.getMpDeptID(ems,index,ordo.getDt_effe());  //待打开
			srvdo.setId_org_mp(exeandwhdeptinfo.getId_org_mp());   //待打开
			if(exeandwhdeptinfo.getId_dep_mp() == null){
				srvdo.setId_dep_mp(ems.getId_dep_mp());
			}else{
				srvdo.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp());   //待打开
			}
			srvdo.setId_dep_wh(exeandwhdeptinfo.getId_dep_wh());   //待打开
			//srvdo.setId_dep_mp(CiOrdUtils.getMpDeptID(ems,srvdo));   //调整到最后    //待注释
			
		}else{
			srvdo.setId_dep_mp(srvdto.getId_dep()); 
			srvdo.setId_dep_wh(srvdto.getId_dep_wh());
		}
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		srvdo.setFg_base(srvdto.getFg_base());
		srvdo.setPriby(srvdto.getPriby());//2016-09-01  新增
		srvdo.setFg_feertnable(FBoolean.TRUE); //可退费标识
		srvdo.setStatus(DOStatus.NEW);
		srvdo.setId_org( CiOrdAppUtils.getEnvContext().getOrgId()); // 组织id);
		srvdo.setId_grp( CiOrdAppUtils.getEnvContext().getGroupId()); // 集团id;
		//关联的物品id
		srvdo.setId_mm(srvdto.getId_mm());
		rtn.setSrvdo(srvdo);
		
		//医嘱项目对应的物品处理
		if(OrSrvSplitUtil.isTrue(srvdto.getFg_mm())){
			if(!CiOrdUtils.isEmpty(srvdto.getId_mm())){
				OrdSrvMmDO ordsrvmmdo=createCiOrdSrvMmDO(srvdo,srvdto);
				// 住院就诊时候，不需要计算 Quan_cur 的值 -- 2016.12.28 by wangqzh
				if (!CiOrdUtils.isOpMode(ems.getCode_entp(), ems.getFg_pres_outp(), srvdo.getSd_srvtp()).booleanValue()){
					ordsrvmmdo.setQuan_cur(FDouble.ZERO_DBL);
					ordsrvmmdo.setId_mupkgutp(srvdto.getId_mupkgutp());
					ordsrvmmdo.setSd_mupkgutp(srvdto.getSd_mupkgutp());
				}
				else{
					ordsrvmmdo.setId_mupkgutp(srvdto.getId_opmutp());
					ordsrvmmdo.setSd_mupkgutp(srvdto.getSd_opmutp());
				}
				rtn.setSrvmm(ordsrvmmdo);

				//2016-07-21 新增  毒麻药品服务 代办人信息核对登录处理逻辑
				if(CiOrdUtils.isSrvPoisonHandle(srvdto)){
					OrSrvAgentInfoDO orsrvagentdo=createSrvAgentInfoDO(srvdto);
					rtn.setSrvagent(orsrvagentdo);
				}
				
				
			}
		}
		
		//变动用药处理
		if(OrSrvSplitUtil.isTrue(srvdto.getFg_dose_anoma())){
			OrdSrvDoseDO[] dosedos=getOrdSrvDoses(srvdo,srvdto);
			if(dosedos!=null && dosedos.length!=0){
				rtn.setSrvdoses(dosedos);
			}
		}
		//到此为止的sd_reltp是前台判断医嘱是否进行皮试的标识0需要皮试
		if(srvdto.getFg_skintest()==FBoolean.TRUE && srvdto.getSd_reltp()!=null && srvdto.getSd_reltp().equals(ICiDictCodeConst.CODE_SKIN_SKIN))
		{
			//在此重新为sd_reltp和id_reltp重新赋值，赋值为皮试医嘱关联的sd和id
			srvdto.setSd_reltp(ICiDictCodeConst.SD_RELTYPE_SKINTEST);
			srvdto.setId_reltp(ICiDictCodeConst.SD_RELTYPE_ID_SKINTEST);
			//需皮试,皮试医嘱相关处理逻辑
			if(CiOrdUtils.isNeedSkinTest(srvdto)){
				CiOrAggAndRelDatum skinagg=getSkinTestOrInfo(ems,srvdto.getId_mm());
				if(!CiOrdUtils.isEmpty(skinagg)){
					String[] ids = new DBUtil().getOIDs(1);
					srvdo.setId_or_rel(ids[0]);
					skinagg.getOraggdo().getParentDO().setId_or(ids[0]);
					skinagg.getOraggdo().getParentDO().setFg_skintest(FBoolean.TRUE);
					rtn.setSkintestagginfo(skinagg);
				}
			}
		}
	}
	private void createOrSrvMmInfo(CiOrderDO ordo,CiEmsDTO ems,int index,OrdSrvItemDatum rtn,Map<String,MedSrvSetItemDO> bdsrvinsetClinicalMap) throws BizException {
		OrdSrvDO srvdo=new OrdSrvDO(); 
		
		CiEmsSrvDTO srvdto=(CiEmsSrvDTO)ems.getEmssrvs().get(index);
		if(srvdto.getStatus()==DOStatus.DELETED) return;
		//srvdo.setId_orsrv(srvdto.getId_orsrv());
		srvdo.setId_or(CiOrdUtils.getCiOrderId(ordo, srvdto.getId_or()));
		//srvdo.setId_pres(srvdto.getId_pres());
		srvdo.setId_pat(ordo.getId_pat());
		srvdo.setId_entp(ordo.getId_entp());
		srvdo.setCode_entp(ordo.getCode_entp());
		srvdo.setId_en(ordo.getId_en());
		srvdo.setSortno(srvdto.getSortno());
		srvdo.setId_srvtp(srvdto.getId_srvtp());
		srvdo.setSd_srvtp(srvdto.getSd_srvtp());
		srvdo.setId_srv(srvdto.getId_srv());
		srvdo.setName(srvdto.getName_srv());
		srvdo.setFg_dose_anoma(CiOrdUtils.nullHandle(srvdto.getFg_dose_anoma()));
		srvdo.setQuan_medu(srvdto.getQuan_med());
		srvdo.setId_medu(srvdto.getId_unit_med());
		srvdo.setId_route(srvdto.getId_route());
		srvdo.setId_routedes(srvdto.getId_routedes());
		srvdo.setId_boil(srvdto.getId_boil());
		srvdo.setId_boildes(srvdto.getId_boildes());
		srvdo.setId_freq(srvdto.getId_freq());   //2016-12-01 - mxj - 修改ordo.getId_freq()--》srvdto.getId_freq()  应该为业务传进的项目freq不应该是医嘱的freq，如果是的话应该走业务规则算法
		srvdo.setId_org_srv(ordo.getId_org_or());
		srvdo.setId_dep_srv(ordo.getId_dep_or());
		srvdo.setId_wg_or(ordo.getId_wg_or());
		srvdo.setId_emp_srv(ordo.getId_emp_or());
		srvdo.setDt_create(ordo.getDt_entry());
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdto.getId_dep()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
	    //srvdo.setDt_last_mp(ordo.getDt_effe());//孟祥杰 张镌尹  王琦 讨论 开立时不用赋值
	    //孟祥杰 张镌尹  王琦 讨论 不赋值
		//srvdo.setDt_last_cg(getLastDt(srvdto.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		srvdo.setDt_last_bl(getLastDt(srvdto.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		srvdo.setFg_or(CiOrdUtils.nullHandle(srvdto.getFg_or()));
		srvdo.setEu_blmd(srvdto.getEu_blmd());
		srvdo.setFg_mm(CiOrdUtils.nullHandle(srvdto.getFg_mm()));
		//if(CiOrdUtils.isEmpty(srvdto.getPrice())){
			//映射折扣价，如果折扣价为空，则后台再查询折扣价
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ordo.getCode_entp(), srvdto, srvdo);
//		}else{
//			srvdo.setPri(srvdto.getPrice());
//			srvdo.setPri_std(srvdto.getPri_std());
//			srvdo.setPri_ratio(srvdto.getPri_ratio());
//			srvdo.setId_pripat(srvdto.getId_pripat());
//		}
		srvdo.setFg_set(CiOrdUtils.nullHandle(srvdto.getFg_set()));
		srvdo.setFg_indic(srvdto.getFg_indic());//之前关闭，现在打开了（zhangwq）
		srvdo.setFg_propc(CiOrdUtils.nullHandle(srvdto.getFg_propc()));
		srvdo.setFg_self(CiOrdUtils.nullHandle(srvdto.getFg_self()));
		srvdo.setFg_pres_outp(CiOrdUtils.nullHandle(srvdto.getFg_outp()));
		srvdo.setNote_srv(srvdto.getDes_srv());
		srvdo.setId_srvca(srvdto.getId_srvca());
		srvdo.setFg_bl(CiOrdUtils.nullHandle(srvdto.getFg_bl()));
		srvdo.setCode_srv(srvdto.getCode_srv());
		srvdo.setEu_sourcemd(srvdto.getEu_sourcemd());
		srvdo.setEu_blmd(srvdto.getEu_blmd());
	    srvdo.setId_primd(srvdto.getId_primd());
		srvdo.setFg_skintest(CiOrdUtils.nullHandle(srvdto.getFg_skintest()));//2016-03-25 新增
		srvdo.setId_skintest_skip_reason(srvdto.getId_skintest_skip_reason());//2016-03-25 新增
		srvdo.setSd_skintest_skip_reason(srvdto.getSd_skintest_skip_reason());//2016-03-25 新增
		srvdo.setId_reltp(srvdto.getId_reltp());//2016-03-25 新增 关联类型
		srvdo.setFg_hpindicjudged(srvdto.getFg_hpindicjudged());//0不需要判断，1待判断，2已判断;
		srvdo.setFg_extdispense(srvdto.getFg_extdispense());//外配药标识
		if(srvdo.getFg_skintest()==FBoolean.TRUE)
		{
			srvdo.setSd_reltp(IBdSrvDictCodeConst.SD_RELORDTYPE_SKIN);
		}else{
			srvdo.setSd_reltp(srvdto.getSd_reltp());//2016-03-25 新增  关联类型编码
		}
		srvdo.setId_or_rel(srvdto.getId_or_rel());//2016-03-25 新增  对应关联医嘱id
		//srvdo.setDt_last_cg(srvdto.getDt_last_bl());//2016-03-25 新增  最近费用日期
		srvdo.setEu_sourcemd(srvdto.getEu_sourcemd()); //添加医疗单来源
		srvdo.setId_primd(srvdto.getId_primd());
		srvdo.setFg_selfsrv(srvdto.getFg_selfsrv());
		srvdo.setId_srv_src(srvdto.getId_srv_src());
		
		// 非住院就诊或出院带药时候，计算服务总量 -- 2016.12.28 by wangqzh
		if(CiOrdUtils.isOpMode(ems.getCode_entp(), ems.getFg_pres_outp(),srvdo.getSd_srvtp()).booleanValue()){
			CiOrdUtils.setQuanTotalMeduToSrvDO(ems, srvdto, srvdo);
		}
//		if (!ems.getCode_entp().equals(IEnDictCodeConst.SD_ENTP_INPATIENT)||(!CiOrdUtils.isEmpty(ems.getFg_pres_outp()))&&ems.getFg_pres_outp().booleanValue()){
//
//			if(srvdto.getQuan_total_medu() != null&&srvdto.getQuan_total_medu().doubleValue()!=0){
//				srvdo.setQuan_total_medu(srvdto.getQuan_total_medu());
//			}else{
//				QuantumParamDTO quantum = new QuantumParamDTO(ems,srvdto);
//				CalQuantumBP bp = new CalQuantumBP();
//				srvdo.setQuan_total_medu(bp.getQuantum(quantum));
//				//srvdo.setQuan_total_medu(CiOrdUtils.getTotalMedu(srvdto,ems.getDays_or(),ems.getOrders()));
//			}
//		}
		srvdo.setFg_selfpay(srvdto.getFg_selfpay());//2016-07-08新增自费标识
		srvdo.setId_hp(srvdto.getId_hp());//2016-07-12新增医保相关信息
		srvdo.setId_hpsrvtp(srvdto.getId_hpsrvtp());
		srvdo.setSd_hpsrvtp(srvdto.getSd_hpsrvtp());
		srvdo.setDes_hplimit(srvdto.getLimit());
		srvdo.setFg_pres_outp(srvdto.getFg_outp());//出院带药标识  zwq 2016-08-11
		ExeWhDeptDTO exeandwhdeptinfo=null;  //2016-07-28  新执行科室逻辑调整    调整到新的时将如下语句进行对应处理
		if(srvdto.getId_dep() == null){
			exeandwhdeptinfo = this.getMpDeptID(ordo, ems, bdsrvinsetClinicalMap.get(srvdo.getId_srv()),srvdo, srvdto.getId_mm());
			srvdo.setId_org_mp(exeandwhdeptinfo.getId_org_mp());   //待打开
			srvdo.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp());   //待打开
			srvdo.setId_dep_wh(exeandwhdeptinfo.getId_dep_wh());   //待打开
			//srvdo.setId_dep_mp(CiOrdUtils.getMpDeptID(ems,srvdo));   //调整到最后    //待注释
			
		}else{
			srvdo.setId_dep_mp(srvdto.getId_dep()); 
			srvdo.setId_dep_wh(srvdto.getId_dep_wh());
		}
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		srvdo.setFg_base(srvdto.getFg_base());
		srvdo.setPriby(srvdto.getPriby());//2016-09-01  新增
		srvdo.setFg_feertnable(FBoolean.TRUE); //可退费标识
		srvdo.setStatus(DOStatus.NEW);
		srvdo.setId_org( CiOrdAppUtils.getEnvContext().getOrgId()); // 组织id);
		srvdo.setId_grp( CiOrdAppUtils.getEnvContext().getGroupId()); // 集团id;
		//关联的物品id
		srvdo.setId_mm(srvdto.getId_mm());
		rtn.setSrvdo(srvdo);
		
		//医嘱项目对应的物品处理
		if(OrSrvSplitUtil.isTrue(srvdto.getFg_mm())){
			if(!CiOrdUtils.isEmpty(srvdto.getId_mm())){
				OrdSrvMmDO ordsrvmmdo=createCiOrdSrvMmDO(srvdo,srvdto);
				// 住院就诊时候，不需要计算 Quan_cur 的值 -- 2016.12.28 by wangqzh
				if (!CiOrdUtils.isOpMode(ems.getCode_entp(), ems.getFg_pres_outp(), srvdo.getSd_srvtp()).booleanValue()){
					ordsrvmmdo.setQuan_cur(FDouble.ZERO_DBL);
					ordsrvmmdo.setId_mupkgutp(srvdto.getId_mupkgutp());
					ordsrvmmdo.setSd_mupkgutp(srvdto.getSd_mupkgutp());
				}
				else{
					ordsrvmmdo.setId_mupkgutp(srvdto.getId_opmutp());
					ordsrvmmdo.setSd_mupkgutp(srvdto.getSd_opmutp());
				}
				rtn.setSrvmm(ordsrvmmdo);

				//2016-07-21 新增  毒麻药品服务 代办人信息核对登录处理逻辑
				if(CiOrdUtils.isSrvPoisonHandle(srvdto)){
					OrSrvAgentInfoDO orsrvagentdo=createSrvAgentInfoDO(srvdto);
					rtn.setSrvagent(orsrvagentdo);
				}
				
				
			}
		}
		
		//变动用药处理
		if(OrSrvSplitUtil.isTrue(srvdto.getFg_dose_anoma())){
			OrdSrvDoseDO[] dosedos=getOrdSrvDoses(srvdo,srvdto);
			if(dosedos!=null && dosedos.length!=0){
				rtn.setSrvdoses(dosedos);
			}
		}
		//到此为止的sd_reltp是前台判断医嘱是否进行皮试的标识0需要皮试
		if(srvdto.getFg_skintest()==FBoolean.TRUE && srvdto.getSd_reltp()!=null && srvdto.getSd_reltp().equals(ICiDictCodeConst.CODE_SKIN_SKIN))
		{
			//在此重新为sd_reltp和id_reltp重新赋值，赋值为皮试医嘱关联的sd和id
			srvdto.setSd_reltp(ICiDictCodeConst.SD_RELTYPE_SKINTEST);
			srvdto.setId_reltp(ICiDictCodeConst.SD_RELTYPE_ID_SKINTEST);
			//需皮试,皮试医嘱相关处理逻辑
			if(CiOrdUtils.isNeedSkinTest(srvdto)){
				CiOrAggAndRelDatum skinagg=getSkinTestOrInfo(ems,srvdto.getId_mm());
				if(!CiOrdUtils.isEmpty(skinagg)){
					String[] ids = new DBUtil().getOIDs(1);
					srvdo.setId_or_rel(ids[0]);
					skinagg.getOraggdo().getParentDO().setId_or(ids[0]);
					skinagg.getOraggdo().getParentDO().setFg_skintest(FBoolean.TRUE);
					rtn.setSkintestagginfo(skinagg);
				}
			}
		}
	}
	private FDouble getOrSrvQuanMed(CiEmsDTO ems,Integer ipos,OrdSrvDO srvdo){
		if(CiOrdUtils.isEmpty(ems.getTimes_cur())){
			FDouble quan_cur = ((CiEmsSrvDTO)ems.getEmssrvs().get(0)).getQuan_cur();
			if(quan_cur!=null){
				return quan_cur.multiply(srvdo.getQuan_medu());
			}else{
				Integer freqct = ((CiEmsSrvDTO)ems.getEmssrvs().get(ipos)).getFreqct();
				freqct = freqct==null?1:freqct;
				Integer days = (ems.getDays_or()==null||ems.getDays_or()==0)?1:ems.getDays_or();
				return new FDouble(freqct.doubleValue()*days.doubleValue()).multiply(srvdo.getQuan_medu());
			}
			
		}else{
			return srvdo.getQuan_medu().multiply(ems.getTimes_cur());
		}
	}
	/**
	 * 根据医疗单项目数据设置医嘱项目对应的变动剂量数据
	 * @param srvdo
	 * @param srvdto
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDoseDO[] getOrdSrvDoses(OrdSrvDO srvdo,CiEmsSrvDTO srvdto) throws BizException{
		SetDoseInfoOfOrSrv8EmsBP bp=new SetDoseInfoOfOrSrv8EmsBP();
		return bp.exec(srvdo, srvdto);
	}
	/**
	 * 设置医嘱项目医保Fg_hpindicjudged信息
	 * @author yzh
	 * @param ordo
	 * @param ems
	 * @param index
	 * @param rtn
	 * @throws BizException
	 */
	private void orSrvInfoHpHandle(CiorderAggDO aggdo,OrdSrvDO srvdo,CiEmsDTO ems,int index,OrdSrvItemDatum rtn) throws BizException {
		CiOrderDO ordo=aggdo.getParentDO();
		//CiEmsSrvDTO srvdto=(CiEmsSrvDTO)ems.getEmssrvs().get(index);
		if(!CiOrdUtils.isEmpty(ordo.getEu_hpindicjudge())&& ordo.getEu_hpindicjudge() == HpIndicJudgeEnum.SELFPAY){
			srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.SELFPAY);//0不需要判断，1待判断，2已判断;
			srvdo.setStatus(DOStatus.UPDATED);
		}else{
			//判断fg_hpindicjudged=9 则这条orsrv是来 勾选自费标志后保存 
			if(!CiOrdUtils.isEmpty(srvdo.getFg_hpindicjudged()) && srvdo.getFg_hpindicjudged() == HpIndicJudgeEnum.SELFPAY){
				srvdo.setFg_hpindicjudged(null);//FIXME 编辑状态暂时置为null 去医保计算处重新计算
				srvdo.setStatus(DOStatus.UPDATED);
			}
		}
	}
	/**
	 * 设置医嘱项目数据信息
	 * @param aggdo
	 * @param ems
	 * @param index
	 * @param rtn
	 * @throws BizException
	 */
	private void setOrSrvMmModInfo(CiorderAggDO aggdo,OrdSrvDO srvdo,CiEmsDTO ems,int index,OrdSrvItemDatum rtn) throws BizException {
		if(CiOrdUtils.isEmpty(srvdo)) return;
		CiOrderDO ordo=aggdo.getParentDO();
		CiEmsSrvDTO srvdto=(CiEmsSrvDTO)ems.getEmssrvs().get(index);
		//皮试医嘱相关处理逻辑
		if(CiOrdUtils.isNeedSkinTest(srvdto)){
			srvMmRelSkinOrModHandle(srvdo,srvdto,rtn,ems);
		}
		ICiorsrvhpRService iCiorsrvhpRService = CiOrdAppUtils.getICiorsrvhpRService();
		CiOrSrvHpDO[] orSrvHpDos = iCiorsrvhpRService.find(" id_orsrv='"+srvdto.getId_orsrv()+"'", null, FBoolean.FALSE);
		HashMap<String, CiOrSrvHpDO> orSrvHpMap = new HashMap<String, CiOrSrvHpDO>();
		CiOrSrvHpDO ciorsrvhpdo = new CiOrSrvHpDO();
		if(!CiOrdUtils.isEmpty(orSrvHpDos)) ciorsrvhpdo = orSrvHpDos[0];
		if(!CiOrdUtils.isEmpty(srvdto.getBdHpIndication())){
			BdHpIndicationDTO bdHpIndication = (BdHpIndicationDTO) srvdto.getBdHpIndication().get(0);
			if(!CiOrdUtils.isEmpty(orSrvHpDos)){
			}
			//FIXME 枚举
			//ciorsrvhpdo.setEu_hpindicrst();
			int model = CiOrParamUtils.getMedInsuranceIndicInfoModelSet(CiOrdAppUtils.getEnvContext().getOrgId());
			if(model==2){
				ciorsrvhpdo.setDes_hplimit(" 医保限制条件："+CiOrdUtils.IsNull(bdHpIndication.getDes_hplimit())+"\n 院内限制条件："+ CiOrdUtils.IsNull(bdHpIndication.getDes_hislimit()));
			}else if(model==1){
				ciorsrvhpdo.setDes_hplimit(" 院内限制条件："+ CiOrdUtils.IsNull(bdHpIndication.getDes_hislimit()));
			}else{
				ciorsrvhpdo.setDes_hplimit(bdHpIndication.getDes_hplimit());
			}
			ciorsrvhpdo.setIndicitemid(srvdto.getIndicitemid());
			ciorsrvhpdo.setDes_hpsrvtp(bdHpIndication.getDes_hpsrvtp());
			ciorsrvhpdo.setEu_hpindicjudged_model(bdHpIndication.getCode_hpindicjudged());
			ciorsrvhpdo.setFg_indic(bdHpIndication.getFg_indic());
			ciorsrvhpdo.setFg_selfpay(srvdto.getFg_selfpay());
			//ciorsrvhpdo.setFg_specill();
			ciorsrvhpdo.setId_ent(ordo.getId_en());
			ciorsrvhpdo.setId_hp(srvdto.getId_hp());
			ciorsrvhpdo.setId_hpsrvtp(srvdto.getId_hpsrvtp());
			ciorsrvhpdo.setStatus(srvdto.getStatus());
			ciorsrvhpdo.setId_orsrv(srvdto.getId_orsrv());
			orSrvHpMap.put(srvdto.getId_srv(), ciorsrvhpdo);
			ciorsrvhpdo.setStatus(DOStatus.UPDATED);
			rtn.setCiorsrvhpdo(orSrvHpMap);
			//ciorsrvhpdo.setId_orsrv(Id_orsrv);
//			BdHpIndication.
		}else{
			if(!CiOrdUtils.isEmpty(srvdto.getIndicitemid())){
				ciorsrvhpdo.setIndicitemid(srvdto.getIndicitemid());
				ciorsrvhpdo.setId_orsrv(srvdto.getId_orsrv());
				orSrvHpMap.put(srvdto.getId_srv(), ciorsrvhpdo);
				rtn.setCiorsrvhpdo(orSrvHpMap);
				ciorsrvhpdo.setStatus(DOStatus.UPDATED);
			}
		}
		//多报销比例id yzh
		//srvdo.setIndicitemid(srvdto.getIndicitemid());
		//srvdo.setId_orsrv(srvdto.getId_orsrv());
		//srvdo.setId_or(srvdto.getId_or());
		//srvdo.setId_pres(srvdto.getId_pres());
		//srvdo.setId_pat(ordo.getId_pat());
		//srvdo.setId_entp(ordo.getId_entp());
		//srvdo.setCode_entp(ordo.getCode_entp());
		//srvdo.setId_en(ordo.getId_en());
		//srvdo.setSortno(srvdto.getSortno());
		srvdo.setId_srvtp(srvdto.getId_srvtp());
		srvdo.setSd_srvtp(srvdto.getSd_srvtp());
		srvdo.setId_srv(srvdto.getId_srv());
		srvdo.setName(srvdto.getName_srv());
		srvdo.setFg_dose_anoma(CiOrdUtils.nullHandle(srvdto.getFg_dose_anoma()));
		srvdo.setQuan_medu(srvdto.getQuan_med());
		srvdo.setId_medu(srvdto.getId_unit_med());
		srvdo.setId_route(srvdto.getId_route());
		srvdo.setId_routedes(srvdto.getId_routedes());
		srvdo.setId_boil(srvdto.getId_boil());
		srvdo.setId_boildes(srvdto.getId_boildes());
		srvdo.setId_freq(ordo.getId_freq());
		//srvdo.setId_org_srv(ordo.getId_org_or());
		//srvdo.setId_dep_srv(ordo.getId_dep_or());
		//srvdo.setId_wg_or(ordo.getId_wg_or());
		//srvdo.setId_emp_srv(ordo.getId_emp_or());
		//srvdo.setDt_create(ordo.getDt_entry());
		srvdo.setId_dep_mp(srvdto.getId_dep());  //调用科室算法
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdto.getId_dep()));
		//srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		//srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		//srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		//srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		//srvdo.setDt_last_mp(srvdto.getDt_last_mp());
		
		srvdo.setDt_last_bl(getLastDt(srvdto.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		srvdo.setFg_or(CiOrdUtils.nullHandle(srvdto.getFg_or()));
		srvdo.setEu_blmd(srvdto.getEu_blmd());
		srvdo.setFg_mm(CiOrdUtils.nullHandle(srvdto.getFg_mm()));
//		srvdo.setPri(srvdto.getPrice());
//		//折扣价、折扣系数赋值、标准价
//		CiOrdUtils.assignPriratToSrvDO(srvdto,srvdo);
		
		if(CiOrdUtils.isEmpty(srvdto.getPrice())){
			if(!CiOrdUtils.isEmpty(srvdo.getEu_blmd()) && srvdo.getEu_blmd()==MedSrvBlModeEnum.MANUALBL){
				srvdo.setPri(srvdto.getPrice());
				srvdo.setPri_std(srvdto.getPrice());
				srvdo.setPri_ratio(FDouble.ONE_DBL);
			}else{
				//映射折扣价，如果折扣价为空，则后台再查询折扣价
				CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ordo.getCode_entp(), srvdto, srvdo);
			}
		}else{
			if(!CiOrdUtils.isEmpty(srvdo.getEu_blmd()) && srvdo.getEu_blmd()==MedSrvBlModeEnum.MANUALBL){
				srvdo.setPri(srvdto.getPrice());
				srvdo.setPri_std(srvdto.getPrice());
				srvdo.setPri_ratio(FDouble.ONE_DBL);
			}else{
				srvdo.setPri(srvdto.getPrice());
				srvdo.setPri_std(srvdto.getPri_std());
				srvdo.setPri_ratio(srvdto.getPri_ratio());
				srvdo.setId_pripat(srvdto.getId_pripat());
			}
		}
		srvdo.setFg_set(CiOrdUtils.nullHandle(srvdto.getFg_set()));
		srvdo.setFg_indic(srvdto.getFg_indic());//之前关闭，现在打开了（zhangwq）
		srvdo.setFg_propc(CiOrdUtils.nullHandle(srvdto.getFg_propc()));
		srvdo.setFg_self(CiOrdUtils.nullHandle(srvdto.getFg_self()));
		srvdo.setFg_pres_outp(CiOrdUtils.nullHandle(srvdto.getFg_outp()));
		String desSrv = srvdto.getDes_srv();
		srvdo.setNote_srv(srvdto.getDes_srv());
		srvdo.setId_srvca(srvdto.getId_srvca());
		srvdo.setFg_bl(CiOrdUtils.nullHandle(srvdto.getFg_bl()));
		srvdo.setCode_srv(srvdto.getCode_srv());
		srvdo.setEu_sourcemd(srvdto.getEu_sourcemd());
		srvdo.setEu_blmd(srvdto.getEu_blmd());
		srvdo.setFg_skintest(CiOrdUtils.nullHandle(srvdto.getFg_skintest()));//2016-03-25 新增
		srvdo.setId_skintest_skip_reason(srvdto.getId_skintest_skip_reason());//2016-03-25 新增
		srvdo.setSd_skintest_skip_reason(srvdto.getSd_skintest_skip_reason());//2016-03-25 新增
		srvdo.setId_reltp(srvdto.getId_reltp());//2016-03-25 新增 关联类型
		srvdo.setSd_reltp(srvdto.getSd_reltp());//2016-03-25 新增  关联类型编码
		srvdo.setId_or_rel(srvdto.getId_or_rel());//2016-03-25 新增  对应关联医嘱id
		//srvdo.setDt_last_cg(srvdto.getDt_last_bl());//2016-03-25 新增  最近费用日期
		srvdo.setId_primd(srvdto.getId_primd());
		srvdo.setFg_selfsrv(srvdto.getFg_selfsrv());
		srvdo.setId_srv_src(srvdto.getId_srv_src());
		srvdo.setFg_extdispense(srvdto.getFg_extdispense());//外配药标识
		// 非住院就诊或出院带药时候，计算服务总量 -- 2016.12.28 by wangqzh
		if(CiOrdUtils.isOpMode(ems.getCode_entp(), ems.getFg_pres_outp(),srvdo.getSd_srvtp()).booleanValue()){
			CiOrdUtils.setQuanTotalMeduToSrvDO(ems, srvdto, srvdo);
		}
//		if (!ems.getCode_entp().equals(IEnDictCodeConst.SD_ENTP_INPATIENT)
//				|| (!CiOrdUtils.isEmpty(ordo.getFg_pres_outp()))
//				&& ordo.getFg_pres_outp().booleanValue()) {
//
//			if (srvdto.getQuan_total_medu() != null&&srvdto.getQuan_total_medu().doubleValue()!=0) {
//				srvdo.setQuan_total_medu(srvdto.getQuan_total_medu());
//			} else {
//				QuantumParamDTO quantum = new QuantumParamDTO(ems,srvdto);
//				CalQuantumBP bp = new CalQuantumBP();
//				srvdo.setQuan_total_medu(bp.getQuantum(quantum));
//			}
//		}
		//FIXME  Fg_hpindicjudged=9 fg_selfpay='Y'
		srvdo.setFg_selfpay(srvdto.getFg_selfpay()); //2016-07-08新增自费标识
		srvdo.setId_hp(srvdto.getId_hp());//2016-07-12新增医保相关信息
		srvdo.setId_hpsrvtp(srvdto.getId_hpsrvtp());
		srvdo.setSd_hpsrvtp(srvdto.getSd_hpsrvtp());
		srvdo.setPriby(srvdto.getPriby());//2016-09-01  新增
		if(!CiOrdUtils.isEmpty(ordo.getEu_hpindicjudge())&& ordo.getEu_hpindicjudge() == 9){
			srvdo.setFg_hpindicjudged(srvdto.getFg_hpindicjudged());//0不需要判断，1待判断，2已判断;
		}else{
			if(!CiOrdUtils.isEmpty(srvdto.getFg_hpindicjudged()) && srvdto.getFg_hpindicjudged() == HpIndicJudgeEnum.SELFPAY){
				srvdo.setFg_hpindicjudged(null);//FIXME 编辑状态暂时置为null 去医保计算处重新计算
			}else{
				srvdo.setFg_hpindicjudged(srvdto.getFg_hpindicjudged());
			}
		}
		srvdo.setFg_base(srvdto.getFg_base());
		srvdo.setStatus(DOStatus.UPDATED);
		//关联的物品id
		srvdo.setId_mm(srvdto.getId_mm());
//		srvdo.setId_org( CiOrdAppUtils.getEnvContext().getOrgId()); // 组织id);
//		srvdo.setId_grp( CiOrdAppUtils.getEnvContext().getGroupId()); // 集团id;
		rtn.setSrvdo(srvdo);
		
		//医嘱项目对应的物品处理
		srvMmInfoModHandle(srvdo,srvdto,rtn);
		if (rtn.getSrvmm() != null){
			if(CiOrdUtils.isOpMode(ems.getCode_entp(), ems.getFg_pres_outp(),srvdo.getSd_srvtp()).booleanValue()){
				rtn.getSrvmm().setId_mupkgutp(srvdto.getId_opmutp());
				rtn.getSrvmm().setSd_mupkgutp(srvdto.getSd_opmutp());
			}
			else{
				rtn.getSrvmm().setId_mupkgutp(srvdto.getId_mupkgutp());
				rtn.getSrvmm().setSd_mupkgutp(srvdto.getSd_mupkgutp());
			}
		}
		
		
		
		//变动用药处理
		srvDoseInfoModHandle(srvdo,srvdto,rtn);

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
	private ExeWhDeptDTO getMpDeptID(CiOrderDO ordo,CiEmsDTO ems,MedSrvDO srvinsetdo,MedSrvSetItemDO tmpdo,MedSrvRelMmDTO srvrelmmdo) throws BizException{
		ExeDeptCalParamDTO param=getExeDeptCalParamDTO(ordo,ems,srvinsetdo,tmpdo,srvrelmmdo);
		return CiOrdUtils.getMpDeptID(param);
	}
	private ExeWhDeptDTO getMpDeptID(CiOrderDO ordo,CiEmsDTO ems,MedSrvSetItemDO tmpdo,OrdSrvDO srvdo,String srvrelmmdo) throws BizException{
		ExeDeptCalParamDTO param=getExeDeptCalParamDTO(ordo,ems,tmpdo,srvdo,srvrelmmdo);
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
	 */
	private ExeDeptCalParamDTO getExeDeptCalParamDTO(CiOrderDO ordo,CiEmsDTO ems,MedSrvDO srvinsetdo,MedSrvSetItemDO tmpdo,MedSrvRelMmDTO srvrelmmdo){
		ExeDeptCalParamDTO paramdto=new ExeDeptCalParamDTO();
		paramdto.setCode_entp(ems.getCode_entp());
		paramdto.setId_dep_en(ems.getId_dept_en());
		paramdto.setId_dep_or(ems.getId_dep_phy());
		paramdto.setId_dep_ns(ems.getId_dept_ns());
		paramdto.setId_dep_exe(ordo.getId_dep_mp());
		paramdto.setFg_long(ems.getFg_long());
		if(!CiOrdUtils.isEmpty(srvrelmmdo)){
		paramdto.setId_mm(srvrelmmdo.getId_mm());}
		paramdto.setSd_srvtp(srvinsetdo.getSd_srvtp());
		paramdto.setId_srvca(srvinsetdo.getId_srvca());
		paramdto.setInnercode_srvca(srvinsetdo.getSrvca_innercode());
		paramdto.setDt_effe(ordo.getDt_effe());
		//paramdto.setDef1();
		//paramdto.setDef2();
		if(!CiOrdUtils.isEmpty(tmpdo)){
			paramdto.setId_srv(tmpdo.getId_srv_itm());
			paramdto.setDef3(tmpdo.getSd_mpdepcalmd()+CiOrdUtils.COMMA_STR+tmpdo.getId_dep_mp()+CiOrdUtils.COMMA_STR+ordo.getId_dep_mp());
			paramdto.setId_route(tmpdo.getId_route());
		}
		//paramdto.setDef4();
		//paramdto.setDef5();
		if(!CiOrdUtils.isTrue(srvinsetdo.getFg_mm())){
			paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW);  //只求执行科室
		}else{
			paramdto.setEu_wftp(EnumFlow.NULL);   //求物资流向科室
		}
		
		return paramdto;
	}
	private ExeDeptCalParamDTO getExeDeptCalParamDTO(CiOrderDO ordo,CiEmsDTO ems,MedSrvSetItemDO tmpdo,OrdSrvDO srvdo,String id_mm){
		ExeDeptCalParamDTO paramdto=new ExeDeptCalParamDTO();
		paramdto.setCode_entp(ems.getCode_entp());
		paramdto.setId_dep_en(ems.getId_dept_en());
		paramdto.setId_dep_or(ems.getId_dep_phy());
		paramdto.setId_dep_ns(ems.getId_dept_ns());
		paramdto.setId_dep_exe(ordo.getId_dep_mp());
		paramdto.setFg_long(ems.getFg_long());
		paramdto.setId_mm(id_mm);
		paramdto.setSd_srvtp(srvdo.getSd_srvtp());
		paramdto.setId_srvca(srvdo.getId_srvca());
		//paramdto.setInnercode_srvca(ems.getSrvca_innercode());
		paramdto.setDt_effe(ordo.getDt_effe());
		//paramdto.setDef1();
		//paramdto.setDef2();
		if(!CiOrdUtils.isEmpty(tmpdo)){
			paramdto.setId_srv(tmpdo.getId_srv_itm());
			paramdto.setDef3(tmpdo.getSd_mpdepcalmd()+CiOrdUtils.COMMA_STR+tmpdo.getId_dep_mp()+CiOrdUtils.COMMA_STR+ordo.getId_dep_mp());
			paramdto.setId_route(tmpdo.getId_route());
		}
		//paramdto.setDef4();
		//paramdto.setDef5();
		if(!CiOrdUtils.isEmpty(id_mm)){
			paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW);  //只求执行科室
		}else{
			paramdto.setEu_wftp(EnumFlow.NULL);   //求物资流向科室
		}
		
		return paramdto;
	}
	/**
	 * 医嘱项目修改时对应变动用量的处理逻辑
	 * @param srvdo
	 * @param srvdto
	 * @param rtn
	 * @throws BizException
	 */
	private void srvDoseInfoModHandle(OrdSrvDO srvdo,CiEmsSrvDTO srvdto,OrdSrvItemDatum rtn) throws BizException{
		OrdSrvDoseDO[] doses=getOrdSrvDoses(srvdo, srvdto);
		if(doses!=null && doses.length!=0){
			rtn.setSrvdoses(doses);
		}
	}
	
	/**
	 * 医嘱项目修改时对应物品的处理逻辑
	 * @param srvdo
	 * @param srvdto
	 * @param rtn
	 * @return
	 * @throws BizException 
	 */
	private void srvMmInfoModHandle(OrdSrvDO srvdo,CiEmsSrvDTO srvdto,OrdSrvItemDatum rtn) throws BizException{
		OrdSrvMmDO ormmdo=createCiOrdSrvMmDO(srvdo,srvdto);
		if(ormmdo==null)return;
		rtn.setSrvmm(ormmdo);
	}
	
	/**
	 * 医嘱项目修改时，对应皮试医嘱处理逻辑
	 * @param srvdo
	 * @param srvdto
	 * @param rtn
	 * @throws BizException 
	 */
	private void srvMmRelSkinOrModHandle(OrdSrvDO srvdo,CiEmsSrvDTO srvdto,OrdSrvItemDatum rtn,CiEmsDTO ems) throws BizException{
		CiOrAggAndRelDatum orskin=createCiOrSkinAggDO(srvdo,srvdto,ems);
		if(orskin==null)return;
		rtn.setSkintestagginfo(orskin);
	}
	
	/**
	 * 医嘱项目对应物品为需要皮试时生成皮试医嘱数据信息
	 * @param srvdo
	 * @param srvdto
	 * @return
	 * @throws BizException 
	 */
	private CiOrAggAndRelDatum createCiOrSkinAggDO(OrdSrvDO srvdo,CiEmsSrvDTO srvdto,CiEmsDTO ems) throws BizException{
		//生成过的，则生成过。不再自动处理   自动只是一种便利性而已（不再自动维护其关系的一致性）
		if(srvdto.getId_srv().equals(srvdo.getId_srv())){
			//药品品种未变化。已经生成，不需要再次生成
			if(isOrSrvMmSame(srvdo.getId_orsrv(),srvdto.getId_mm()))return null; 
			
			//获得皮试药品对应的皮试服务
			String id_srvskin=CiOrdUtils.getMmRelSkinSrv(srvdto.getId_mm());
			if(CiOrdUtils.isEmpty(id_srvskin)){throw new CiOrSrvMmRelSkinSrvNullException();}
			
			//继续
		}else{
			//继续
		}
		
		return getSkinTestOrInfo(ems,srvdto.getId_mm());
	}
	
	/**
	 * 创建毒麻药品代办人信息DO
	 * @param srvdto
	 * @return
	 */
	private OrSrvAgentInfoDO createSrvAgentInfoDO(CiEmsSrvDTO srvdto){
		return (OrSrvAgentInfoDO)srvdto.getEmsagentinfo().get(0);
	}
	
	/**
	 * 生成医嘱项目对应物品数据信息
	 * @param srvdo
	 * @param srvdto
	 * @return
	 * @throws BizException
	 */
	private OrdSrvMmDO createCiOrdSrvMmDO(OrdSrvDO srvdo,CiEmsSrvDTO srvdto) throws BizException{
		SetMmInfoOfOrSrv8EmsBP bp=new SetMmInfoOfOrSrv8EmsBP();
		return bp.exec(srvdo, srvdto);
	}
	
	/**
	 * 设置医嘱项目数据信息
	 * @param ordo
	 * @param ems
	 * @param index
	 * @param rtn
	 * @throws BizException
	 */
	private void orSrvMmInfoModHandle(CiorderAggDO aggdo,CiEmsDTO ems,int index,OrdSrvItemDatum rtn) throws BizException {
		CiOrderDO ordo=aggdo.getParentDO();
		CiEmsSrvDTO srvdto=(CiEmsSrvDTO)ems.getEmssrvs().get(index);
		if(CiOrdUtils.isDONew(srvdto)){
			createOrSrvMmInfo(ordo,ems,index,rtn);
		}else{
			OrdSrvDO srvdo=CiOrdUtils.getMatchDatum(aggdo.getOrdSrvDO(), srvdto.getId_orsrv());
			if(CiOrdUtils.isDODel(srvdto)){
				ciOrSrvMmDel(rtn,srvdo);
			}else if(CiOrdUtils.isDOMod(srvdto)){
				if(CiOrdUtils.isEmpty(srvdo)){throw new BizException("医嘱数据已被他人修改，请刷新界面重试！");}
				setOrSrvMmModInfo(aggdo,srvdo,ems,index,rtn);
			}else if(CiOrdUtils.isDOUnChange(srvdto)){
				orSrvInfoHpHandle(aggdo,srvdo,ems,index,rtn);
			}
			
		}
	}
	
	
	private void orSrvMmInfoModHandle(CiorderAggDO aggdo,CiEmsDTO ems,int index,OrdSrvItemDatum rtn,Map<String,MedSrvSetItemDO> bdsrvinsetClinicalMap) throws BizException {
		CiOrderDO ordo=aggdo.getParentDO();
		CiEmsSrvDTO srvdto=(CiEmsSrvDTO)ems.getEmssrvs().get(index);
		if(CiOrdUtils.isDONew(srvdto)){
			createOrSrvMmInfo(ordo,ems,index,rtn,bdsrvinsetClinicalMap);
		}else{
			OrdSrvDO srvdo=CiOrdUtils.getMatchDatum(aggdo.getOrdSrvDO(), srvdto.getId_orsrv());
			if(CiOrdUtils.isDODel(srvdto)){
				ciOrSrvMmDel(rtn,srvdo);
			}else if(CiOrdUtils.isDOMod(srvdto)){
				if(CiOrdUtils.isEmpty(srvdo)){throw new BizException("医嘱数据已被他人修改，请刷新界面重试！");}
				setOrSrvMmModInfo(aggdo,srvdo,ems,index,rtn);
			}else if(CiOrdUtils.isDOUnChange(srvdto)){
				orSrvInfoHpHandle(aggdo,srvdo,ems,index,rtn);
			}
			
			
		}
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
	 * 医嘱项目数据删除
	 * @param srvitmdatum
	 * @param orsrvdo
	 * @throws BizException
	 */
	private void ciOrSrvMmDel(OrdSrvItemDatum srvitmdatum,OrdSrvDO orsrvdo) throws BizException{
		CiOrSrvMmDelBP bp=new CiOrSrvMmDelBP();
		bp.exec(srvitmdatum, orsrvdo);
	}
	
	/**
	 * 获得皮试医嘱及相关附加数据信息
	 * @param ems
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private CiOrAggAndRelDatum getSkinTestOrInfo(CiEmsDTO ems,String id_mm) throws BizException{
		CiOrSkinTestOrInfoGet bp=new CiOrSkinTestOrInfoGet();
		return bp.exec(ems, id_mm);
	}
	
	/**
	 * 获得医嘱项目对应的医嘱项目药品数据信息
	 * @param id_orsrv
	 * @return
	 * @throws BizException
	 */
	private OrdSrvMmDO getOrdSrvMm(String id_orsrv) throws BizException{
		GetCiOrSrvMmBP bp=new GetCiOrSrvMmBP();
		return bp.exec(id_orsrv);
	}
	
	/**
	 * 是否为相同药品的判断逻辑
	 * @param id_orsrv
	 * @param id_mm
	 * @return
	 * @throws BizException
	 */
	private boolean isOrSrvMmSame(String id_orsrv,String id_mm) throws BizException{
		OrdSrvMmDO orsrvmmdo=getOrdSrvMm(id_orsrv);
		if(CiOrdUtils.isEmpty(orsrvmmdo)){return false;}
		if(id_mm.equals(orsrvmmdo.getId_mm()))return true;
		return false;
	}
	
}

