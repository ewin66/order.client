package iih.ci.ord.s.bp.validate;

import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 临床医嘱开立时，获得服务互斥信息数据操作BP
 */
public class CiOrOpenOrSrvReactInfoGetBP {
	/**
	 * 临床医嘱开立时，获得服务互斥信息数据
	 * @param ems
	 * @throws BizException
	 */
	public SrvReactDTO[] exec(CiEmsDTO ems) throws BizException{
		//有效性校验
		if(ems==null || CiOrdUtils.isEmpty(ems.getEmssrvs()))return null;
		//是否是大科室小病区
		if(isEMSTransWardWithinUniDeptBP(ems))return null;
		//获得医疗单服务项目字串
		String srvcondstr=getSrv4EmsCondStr(ems);
		if(CiOrdUtils.isEmpty(srvcondstr))return null;
		
		//返回
		return CiOrdAppUtils.getBdSrvQryQryService().getSrvReactInfos(srvcondstr);
	}

	
	/**
	 * 获得医疗单中所含医疗服务条件串
	 * @param ems
	 * @return
	 */
	private String getSrv4EmsCondStr(CiEmsDTO ems){
		String rtnstr="";
		CiEmsSrvDTO emssrvdto=null;
		int iN=0;
		
		for(int i=0;i<ems.getEmssrvs().size();i++){
			emssrvdto=(CiEmsSrvDTO)(ems.getEmssrvs().get(i));
			if(CiOrdUtils.isEmpty(emssrvdto))continue;
			if(CiOrdUtils.isEmpty(emssrvdto.getId_srv()))continue;
	//		if(isTransWardWithinUniDept(ordo))continue;  //2016-07-25 新增该业务逻辑  判断转科医嘱为同一就诊科室下的转病区
			iN+=1;
			rtnstr+=CiOrdUtils.COMMA_STR+CiOrdUtils.SQUOTE_MARK_STR+emssrvdto.getId_srv()+CiOrdUtils.SQUOTE_MARK_STR;
		}
		if(iN==0)return null;
		rtnstr=rtnstr.substring(1);
		if(iN==1)return CiOrdUtils.EQUAL_STR+rtnstr;
		return CiOrdUtils.IN_STR_WITHBLANK+CiOrdUtils.LBRACE_STR+rtnstr+CiOrdUtils.RBRACE_STR;
	}
	
	/**
	 * 是否是同一就诊科室下转病区医嘱判断
	 * @param ordo
	 * @return
	 * @throws BizException
	 */
	private boolean isEMSTransWardWithinUniDeptBP(CiEmsDTO ems)
			throws BizException {
		IsEMSTransWardWithinUniDeptBP bp=new IsEMSTransWardWithinUniDeptBP();
		return bp.exec(ems).booleanValue();
	}
	
}
