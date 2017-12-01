package iih.ci.ord.s.bp.validate;

import java.util.ArrayList;
import java.util.Hashtable;

import iih.bd.srv.srvrtctl.d.SrvRtCtlDTO;
import iih.bd.srv.srvrtctl.d.SrvRtCtlParam;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.CiOrSrvRtCtlUnAuthorizedException;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;

/*
 * 服务开立权限检查操作BP
 */
public class SrvDoctorRtValidateBP {
	private static final String  ERR_MSG="你没有%s项目签署权限(属于%s权限)，[%s]医嘱签署失败！";
	/**
	 * 服务开立权限检查
	 * @param aggors
	 * @throws BizException
	 */
	public void exec(CiorderAggDO[] aggors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(aggors))return;
		
		//参数设置
		Hashtable<Integer,String> orindexht=new Hashtable<Integer,String>();
		SrvRtCtlParam rtctlparam=createRtCtlParam(aggors,orindexht);
		if(CiOrdUtils.isEmpty(rtctlparam))return;
		
//		//获得医嘱未授权服务项目开立权限信息
		SrvRtCtlDTO[] orsrvrtinfos = CiOrdAppUtils.getBdSrvQryQryService()
				.getUnAuthorizedSrvRtCtlInfo(rtctlparam);
		if(CiOrdUtils.isEmpty(orsrvrtinfos))return;
//		
//		//抛医嘱项目未授权错误信息
		String errmsg=getErrMsg(orsrvrtinfos,aggors,orindexht);
		throw new CiOrSrvRtCtlUnAuthorizedException(errmsg);
	}
	
	/**
	 * 获得异常信息
	 * @param orsrvrtinfos
	 * @param aggors
	 * @param orindexht
	 * @return
	 */
	private String getErrMsg(SrvRtCtlDTO[] orsrvrtinfos, CiorderAggDO[] aggors,
			Hashtable<Integer, String> orindexht) {
		String errrtn="";
		String id_srv=null;
		String tm="";
		ArrayList<Integer> orindexes=null;
		for(int i=0;i<orsrvrtinfos.length;i++){
			id_srv=orsrvrtinfos[i].getId_srv();
			orindexes=getOrIndexes(id_srv,orindexht);
			if(CiOrdUtils.isEmpty(orindexes))continue;
			tm=getMsgStr(orsrvrtinfos[i],aggors,orindexes,id_srv);
			if(CiOrdUtils.isEmpty(tm))continue;
			errrtn+=tm;
		}
		
		return errrtn;
	}
	
	/**
	 * 获得异常信息
	 * @param orsrvrt
	 * @param aggors
	 * @param orindexes
	 * @param id_srv
	 * @return
	 */
	private String getMsgStr(SrvRtCtlDTO orsrvrt,CiorderAggDO[] aggors,ArrayList<Integer> orindexes,String id_srv){
		String errrtn="";
		CiorderAggDO aggdo=null;
		String srvname=null;
		for(int j=0;j<orindexes.size();j++){
			aggdo=aggors[orindexes.get(j)];
			srvname=getSrvName(aggdo,id_srv);
			if(CiOrdUtils.isEmpty(srvname))continue;
			errrtn+=String.format(ERR_MSG, srvname,orsrvrt.getName(),aggdo.getParentDO().getName_or())+CiOrdUtils.CRLF;
		}
		return errrtn;
	}
	
	/**
	 * 获得医疗服务名称
	 * @param agg
	 * @param id_srv
	 * @return
	 */
	private String getSrvName(CiorderAggDO agg,String id_srv){
		OrdSrvDO[]  srvdos=agg.getOrdSrvDO();
		if(CiOrdUtils.isEmpty(srvdos))return "";
		for(int i=0;i<srvdos.length;i++){
			if(id_srv.equals(srvdos[i].getId_srv()))return srvdos[i].getName_srv();
		}
		return "";
	}
	
	/**
	 * 获得为开立项目对应的医嘱集合
	 * @param id_srv
	 * @param orindexht
	 * @return
	 */
	private ArrayList<Integer> getOrIndexes(String id_srv,Hashtable<Integer,String> orindexht){
		String orsrvidstr="";
		ArrayList<Integer> rtn=new ArrayList<Integer>();
		for(Integer key:orindexht.keySet()){
			orsrvidstr=orindexht.get(key);
			if(CiOrdUtils.isInStr(id_srv, orsrvidstr)){
				rtn.add(key);
			}
		}
		return rtn;
	}
	
	private String grpid=null;    //集团id
	private String orgid=null;    //组织id
	private String empid=null;    //人员id
	
	/**
	 * 创建医嘱开立服务权限检查入口参数
	 * @param aggors
	 * @return
	 * @throws BizException 
	 */
	private SrvRtCtlParam createRtCtlParam(CiorderAggDO[] aggors,
			Hashtable<Integer, String> orindexht) throws BizException {
		String id_srvs=getIdSrvs(aggors,orindexht);
		if(CiOrdUtils.isEmpty(id_srvs))return null;
		setCommonData();
		SrvRtCtlParam param=new SrvRtCtlParam();
		param.setId_org(orgid);
		param.setId_entp(aggors[0].getParentDO().getId_entp());
		param.setId_emp_doctor(empid);
		param.setId_srvs(id_srvs);
		return param;
	}
	
	/**
	 * 获得医嘱项目信息
	 * @param aggors
	 * @return
	 */
	private String getIdSrvs(CiorderAggDO[] aggors,Hashtable<Integer,String> orindexht){
		String rtn="";
		OrdSrvDO[] orsrvs=null;
		String srvstr="";
		for(int i=0;i<aggors.length;i++){
			orsrvs=aggors[i].getOrdSrvDO();
			if(CiOrdUtils.isEmpty(orsrvs))continue;
			srvstr=getOrSrvs(orsrvs);
			if(CiOrdUtils.isEmpty(srvstr))continue;
			orindexht.put(i, srvstr);
			rtn+=CiOrdUtils.COMMA_STR+srvstr;
		}
        if(CiOrdUtils.isEmpty(rtn))
        	return rtn;
		return rtn.substring(1, rtn.length());
	}
	
	/**
	 * 获得医嘱项目串
	 * @param orsrvs
	 * @return
	 */
	private String getOrSrvs(OrdSrvDO[] orsrvs){
		String rtn="";
		for(int j=0;j<orsrvs.length;j++){
			if(!OrSrvSplitUtil.isTrue(orsrvs[j].getFg_or()))continue;
			rtn+=CiOrdUtils.COMMA_STR+orsrvs[j].getId_srv();
		}
		if(CiOrdUtils.isEmpty(rtn))return "";
		return rtn.substring(1);
	}
	
	/**
	 * 设置公共数据信息
	 * @throws BizException
	 */
	private  void setCommonData() throws BizException{
		grpid=CiOrdAppUtils.getEnvContext().getGroupId();    //集团id
		orgid=CiOrdAppUtils.getEnvContext().getOrgId();    //组织id
		empid=CiOrdAppUtils.getEnvContext().getUserId();    //人员id
		empid=CiOrdUtils.getPsnDocID(empid);
	}
}
