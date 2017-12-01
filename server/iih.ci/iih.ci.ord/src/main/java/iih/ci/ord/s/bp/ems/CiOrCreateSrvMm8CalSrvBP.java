package iih.ci.ord.s.bp.ems;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.emsdi.d.ExeDeptCalParamDTO;
import iih.ci.ord.emsdi.d.ExeWhDeptDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 根据定价模式返回的价格服务生成医嘱项目操作BP（仅对套的情形）
 */
public class CiOrCreateSrvMm8CalSrvBP {
	/**
	 * 根据组合定价模式返回的价格服务生成医嘱项目（仅对套的情形）
	 * @param ordo
	 * @param ems
	 * @param srvindex
	 * @param prisrv
	 * @param quan
	 * @return
	 * @throws BizException
	 */
	public  OrdSrvDO exec(CiorderAggDO aggdo,CiEmsDTO ems,Integer srvindex,PriStdSrvDTO prisrv,Integer quan,String priby)  throws BizException{
		long startTime = System.currentTimeMillis();
		
		if(prisrv==null)return null;
		CiOrderDO ordo=aggdo.getParentDO();
		OrdSrvDO srvdo=null; 
		if(CiOrdUtils.isDONew(ordo)){//新增处理
			srvdo=createOrSrvMmInfo(ordo,ems,srvindex,prisrv,quan,priby);
		
		}else if(CiOrdUtils.isDOMod(ordo)){//修改
			srvdo=orSrvMmInfoModHandle(aggdo,ems,srvindex,prisrv,quan,priby);
		}
		CiOrdUtils.getlogger().info("根据组合定价模式返回的价格服务生成医嘱项目（仅对套的情形）(CiOrCreateSrvMm8CalSrvBP) 耗时"+( System.currentTimeMillis()-startTime));
		return srvdo;
	}
	

	
	/**
	 * 生成医嘱项目信息
	 * @param ordo
	 * @param srvdo
	 * @param ems
	 * @param srvindex
	 * @param prisrv
	 * @param quan
	 * @throws BizException
	 */
	private OrdSrvDO createOrSrvMmInfo(CiOrderDO ordo,CiEmsDTO ems,Integer srvindex,PriStdSrvDTO prisrv,Integer quan,String priby)  throws BizException{
		CiEmsSrvDTO setsrv=(CiEmsSrvDTO)ems.getEmssrvs().get(srvindex);
		MedSrvDO prisrvdo=CiOrdAppUtils.getMedsrvMDORService().findById(prisrv.getId_srv());
		OrdSrvDO srvdo=new OrdSrvDO();
		//srvdo.setId_orsrv(srvdto.getId_orsrv());
		srvdo.setId_or(ordo.getId_or());  //2016-06-27  新增逻辑
		//srvdo.setId_pres(srvdto.getId_pres());
		srvdo.setId_pat(ordo.getId_pat());
		srvdo.setId_entp(ordo.getId_entp());
		srvdo.setCode_entp(ordo.getCode_entp());
		srvdo.setId_en(ordo.getId_en());
		//srvdo.setSortno(srvdto.getSortno());
		srvdo.setId_srvtp(prisrvdo.getId_srvtp());
		srvdo.setSd_srvtp(prisrvdo.getSd_srvtp());
		srvdo.setId_srv(prisrvdo.getId_srv());
		srvdo.setName(prisrvdo.getName());
		srvdo.setFg_dose_anoma(FBoolean.FALSE);
		srvdo.setQuan_medu(new FDouble(quan));
		srvdo.setId_medu(prisrvdo.getId_unit_med());
		srvdo.setId_route(prisrvdo.getId_route());
		srvdo.setId_routedes(prisrvdo.getId_routedes());
		srvdo.setId_boil(prisrvdo.getId_boil());
		srvdo.setId_boildes(prisrvdo.getId_boildes());
		srvdo.setId_freq(ordo.getId_freq());
		srvdo.setId_org_srv(ordo.getId_org_or());
		srvdo.setId_dep_srv(ordo.getId_dep_or());
		srvdo.setId_wg_or(ordo.getId_wg_or());
		srvdo.setId_emp_srv(ordo.getId_emp_or());
		srvdo.setDt_create(ordo.getDt_entry());
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		//srvdo.setDt_last_mp(srvdto.getDt_last_mp());
		srvdo.setDt_last_cg(getLastDt(setsrv.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		srvdo.setDt_last_bl(getLastDt(setsrv.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		srvdo.setFg_or(FBoolean.FALSE);
		srvdo.setEu_blmd(prisrvdo.getEu_blmd());  //本服务定价
		srvdo.setFg_mm(FBoolean.FALSE);
		//srvdo.setPri(CiOrdUtils.getOrSrvPrice(ordo, setsrv));
		srvdo.setPri(prisrv.getPrice());//zwq 2016-09-12
		srvdo.setFg_set(FBoolean.FALSE);
		//srvdo.setFg_indic(srvdto.getFg_indic());
		srvdo.setFg_propc(FBoolean.FALSE);
		srvdo.setFg_self(FBoolean.FALSE);
		srvdo.setFg_pres_outp(FBoolean.FALSE);
		srvdo.setNote_srv("");  //暂时先用这个字段存 定价依据
		srvdo.setId_srvca(prisrvdo.getId_srvca());
		srvdo.setFg_bl(CiOrdUtils.nullHandle(prisrvdo.getFg_bl()));
		srvdo.setCode_srv(prisrvdo.getCode());
		srvdo.setEu_sourcemd(OrSrvSourceFromEnum.AGENTFROMPRIMD);
		srvdo.setId_primd(prisrvdo.getId_primd());
		srvdo.setFg_selfsrv(prisrvdo.getFg_ctm());
		srvdo.setId_srv_src(setsrv.getId_srv());
		srvdo.setQuan_total_medu(setsrv.getQuan_total_medu());
		srvdo.setFg_selfpay(setsrv.getFg_selfpay());//2016-07-08新增自费标识
		srvdo.setId_hp(setsrv.getId_hp());//2016-07-12新增医保相关信息
		srvdo.setId_hpsrvtp(setsrv.getId_hpsrvtp());
		srvdo.setSd_hpsrvtp(setsrv.getSd_hpsrvtp());
		ExeWhDeptDTO exeandwhdeptinfo=null;  //2016-07-28  新执行科室逻辑调整    调整到新的时将如下语句进行对应处理
		if(srvdo.getId_dep_mp()== null){
			exeandwhdeptinfo=getMpDeptID(ordo,ems,setsrv,prisrvdo,null);  //待打开
			srvdo.setId_org_mp(exeandwhdeptinfo.getId_org_mp());   //待打开
			srvdo.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp());   //待打开
			srvdo.setId_dep_wh(exeandwhdeptinfo.getId_dep_wh());   //待打开
		}else{
			
		}
		//srvdo.setId_dep_mp(getMpDeptID(ems,srvdo));  //2016-08-05注释掉该逻辑
		if(srvdo.getId_org_mp()== null){
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));}
		
		
		//srvdo.setFg_base(Fg_base);    //2016-08-02 新增如下两字段（含本字段） 
		srvdo.setPriby(priby);
		srvdo.setFg_feertnable(FBoolean.TRUE);
		srvdo.setStatus(DOStatus.NEW);
		
		//li_cheng 
		srvdo.setId_grp(CiOrdAppUtils.getEnvContext().getGroupId()); // 集团id
		srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId()); // 组织id
		//医嘱项目对应的物品处理
		if(OrSrvSplitUtil.isTrue(prisrvdo.getFg_mm())){
			//应该是不存在这个情况
		}
		
		//变动用药处理  应该是不存在这个情况
		
		return srvdo;
	}
	
	/**
	 * 设置医嘱项目数据信息
	 * @param aggdo
	 * @param ems
	 * @param srvindex
	 * @param prisrv
	 * @param quan
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO orSrvMmInfoModHandle(CiorderAggDO aggdo,CiEmsDTO ems,Integer srvindex,PriStdSrvDTO prisrv,Integer quan,String priby) throws BizException{
		CiEmsSrvDTO setsrv=(CiEmsSrvDTO)ems.getEmssrvs().get(srvindex);
		MedSrvDO prisrvdo=CiOrdAppUtils.getMedsrvMDORService().findById(prisrv.getId_srv());
		OrdSrvDO srvdo=CiOrdUtils.getMatchDatum(aggdo.getOrdSrvDO(), setsrv.getId_orsrv());
		if(srvdo==null){
			return createOrSrvMmInfo(aggdo.getParentDO(),ems,srvindex,prisrv,quan, priby);
		}
		CiOrderDO ordo=aggdo.getParentDO();
		//srvdo.setId_orsrv(srvdto.getId_orsrv());
		//srvdo.setId_or(srvdto.getId_or());
		//srvdo.setId_pres(srvdto.getId_pres());
		//srvdo.setId_pat(ordo.getId_pat());
		//srvdo.setId_entp(ordo.getId_entp());
		//srvdo.setCode_entp(ordo.getCode_entp());
		//srvdo.setId_en(ordo.getId_en());
		//srvdo.setSortno(srvdto.getSortno());
		srvdo.setId_srvtp(prisrvdo.getId_srvtp());
		srvdo.setSd_srvtp(prisrvdo.getSd_srvtp());
		srvdo.setId_srv(prisrvdo.getId_srv());
		srvdo.setName(prisrvdo.getName());
		srvdo.setFg_dose_anoma(FBoolean.FALSE);
		srvdo.setQuan_medu(new FDouble(quan));
		srvdo.setId_medu(prisrvdo.getId_unit_med());
		srvdo.setId_route(prisrvdo.getId_route());
		srvdo.setId_routedes(prisrvdo.getId_routedes());
		srvdo.setId_boil(prisrvdo.getId_boil());
		srvdo.setId_boildes(prisrvdo.getId_boildes());
		srvdo.setId_freq(ordo.getId_freq());
		srvdo.setId_org_srv(ordo.getId_org_or());
		srvdo.setId_dep_srv(ordo.getId_dep_or());
		srvdo.setId_wg_or(ordo.getId_wg_or());
		srvdo.setId_emp_srv(ordo.getId_emp_or());
		srvdo.setDt_create(ordo.getDt_entry());
		//srvdo.setId_dep_mp(getMpDeptID());       //调整到最后
		srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		//srvdo.setDt_last_mp(srvdto.getDt_last_mp());
		srvdo.setDt_last_cg(getLastDt(setsrv.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		srvdo.setFg_or(FBoolean.FALSE);
		srvdo.setEu_blmd(prisrvdo.getEu_blmd());  //本服务定价
		srvdo.setFg_mm(FBoolean.FALSE);
		srvdo.setPri(prisrv.getPrice());
		srvdo.setFg_set(FBoolean.FALSE);
		//srvdo.setFg_indic(srvdto.getFg_indic());
		srvdo.setFg_propc(FBoolean.FALSE);
		srvdo.setFg_self(FBoolean.FALSE);
		srvdo.setFg_pres_outp(FBoolean.FALSE);
		srvdo.setNote_srv(priby);
		srvdo.setId_srvca(prisrvdo.getId_srvca());
		srvdo.setFg_bl(CiOrdUtils.nullHandle(prisrvdo.getFg_bl()));
		srvdo.setCode_srv(prisrvdo.getCode());
		srvdo.setEu_sourcemd(OrSrvSourceFromEnum.AGENTFROMPRIMD);
		//srvdo.setId_dep_mp(getMpDeptID(ems,srvdo));  //2016-08-05 注释掉该逻辑
		srvdo.setId_primd(prisrvdo.getId_primd());
		srvdo.setFg_selfsrv(prisrvdo.getFg_ctm());
		srvdo.setId_srv_src(setsrv.getId_srv());
		if(setsrv.getQuan_total_medu() != null){
			srvdo.setQuan_total_medu(setsrv.getQuan_total_medu());
		}else{
			srvdo.setQuan_total_medu(CiOrdUtils.getOrSrvQuanMed(ems, srvindex,srvdo));
		}
		
		srvdo.setFg_selfpay(setsrv.getFg_selfpay());//2016-07-08新增自费标识
		srvdo.setId_hp(setsrv.getId_hp());//2016-07-12新增医保相关信息
		srvdo.setId_hpsrvtp(setsrv.getId_hpsrvtp());
		srvdo.setSd_hpsrvtp(setsrv.getSd_hpsrvtp());
		ExeWhDeptDTO exeandwhdeptinfo=null;  //2016-07-28  新执行科室逻辑调整    调整到新的时将如下语句进行对应处理
		if(srvdo.getId_dep_mp()== null){
			exeandwhdeptinfo=getMpDeptID(ordo,ems,setsrv,prisrvdo,null);  //待打开
			srvdo.setId_org_mp(exeandwhdeptinfo.getId_org_mp());   //待打开
			srvdo.setId_dep_mp(exeandwhdeptinfo.getId_dep_mp());   //待打开
			srvdo.setId_dep_wh(exeandwhdeptinfo.getId_dep_wh());   //待打开
		}else{}
		if(srvdo.getId_org_mp()== null){srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));}
		
//		srvdo.setId_grp(CiOrdAppUtils.getEnvContext().getGroupId()); // 集团id
//		srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId()); // 组织id
		
		//srvdo.setFg_base(Fg_base);  //2016-08-02 新增如下两字段（含本字段） 
		srvdo.setPriby(priby);
		
		srvdo.setStatus(DOStatus.UPDATED);
		
		//医嘱项目对应的物品处理
		if(OrSrvSplitUtil.isTrue(prisrvdo.getFg_mm())){
			//应该是不存在这个情况
		}
		
		//变动用药处理  应该是不存在这个情况
		
		return srvdo;
			
	}
	
	
	/**
	 * 获得服务对应的执行科室
	 * @return
	 * @throws BizException
	 */
	private String getMpDeptID(CiEmsDTO ems,OrdSrvDO srvdo) throws BizException{
		OrWfExDeptParamDTO param=getOrWfExDeptParam(ems,srvdo);
		CiOrSrvExecuteDeptGetBP bp=new CiOrSrvExecuteDeptGetBP();
		OrWfExDeptDTO[] do1=bp.exec(param);
		if(do1==null || do1.length==0)return null;
		return do1[0].getId_dept();

	}
	private OrWfExDeptParamDTO getOrWfExDeptParam(CiEmsDTO ems,OrdSrvDO srvdo){
		OrWfExDeptParamDTO param=new OrWfExDeptParamDTO();
		param.setCode_entp(ems.getCode_entp());
		param.setSd_srvtp(srvdo.getSd_srvtp());
		param.setId_srvca(srvdo.getId_srvca());
		param.setId_usage(srvdo.getId_route());
		param.setRecurstr(CiOrdUtils.getFg_longStr(ems.getFg_long()));
		//param.setWeekno();
		//param.setTimestr();
		param.setId_srv(srvdo.getId_srv());
		//param.setId_mm();
		param.setId_dept_en(ems.getId_dept_en());
		param.setId_dept_ns(ems.getId_dept_ns());
		param.setId_dept_or(ems.getId_dep_phy());
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
	 * 获得执行科室数据信息
	 * @param ordo
	 * @param ems
	 * @param srvinsetdo
	 * @param tmpdo
	 * @param srvrelmmdo
	 * @return
	 * @throws BizException
	 */
	private ExeWhDeptDTO getMpDeptID(CiOrderDO ordo,CiEmsDTO ems,CiEmsSrvDTO srvinsetdo,MedSrvDO prisrvdo,MedSrvRelMmDTO srvrelmmdo) throws BizException{
		ExeDeptCalParamDTO param=getExeDeptCalParamDTO(ordo,ems,srvinsetdo,prisrvdo,srvrelmmdo);
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
	private ExeDeptCalParamDTO getExeDeptCalParamDTO(CiOrderDO ordo,CiEmsDTO ems,CiEmsSrvDTO srvinsetdo,MedSrvDO prisrvdo,MedSrvRelMmDTO srvrelmmdo){
		ExeDeptCalParamDTO paramdto=new ExeDeptCalParamDTO();
		paramdto.setCode_entp(ems.getCode_entp());
		paramdto.setId_dep_en(ems.getId_dept_en());
		paramdto.setId_dep_or(ems.getId_dep_phy());
		paramdto.setId_dep_ns(ems.getId_dept_ns());
		paramdto.setId_dep_exe(ordo.getId_dep_mp());
		paramdto.setFg_long(ems.getFg_long());
		paramdto.setId_srv(prisrvdo.getId_srv());
		if(!CiOrdUtils.isEmpty(srvrelmmdo)){
		paramdto.setId_mm(srvrelmmdo.getId_mm());}
		paramdto.setSd_srvtp(prisrvdo.getSd_srvtp());
		paramdto.setId_srvca(prisrvdo.getId_srvca());
		paramdto.setInnercode_srvca(prisrvdo.getSrvca_innercode());
		paramdto.setId_route(prisrvdo.getId_route());
		paramdto.setDt_effe(ordo.getDt_effe());
		//paramdto.setDef1();
		//paramdto.setDef2();
		paramdto.setDef3(IBdSrvDictCodeConst.SD_ORTMPLTP_WITHSRVSET+CiOrdUtils.COMMA_STR+""+CiOrdUtils.COMMA_STR+ordo.getId_dep_mp());
		//paramdto.setDef4();
		//paramdto.setDef5();
		if(!CiOrdUtils.isTrue(prisrvdo.getFg_mm())){
			paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW);  //只求执行科室
		}else{
			paramdto.setEu_wftp(EnumFlow.NULL);   //求物资流向科室
		}
		
		return paramdto;
	}
}
