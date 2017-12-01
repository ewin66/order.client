/**
 * 
 */
package iih.ci.ord.s.bp;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * @ClassName: getConsultationPatientsBP
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年6月3日 下午1:48:52
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getConsultationPatientsBP {
  
	/**
     * 会诊患者列表
     * @param id_org 机构
     * @param id_dep 登陆科室
     * @param id_emp_response 登陆人员
     * @return  String[] 就诊id_en
     * @throws BizException
     */
    public   String[] exe(String id_org,String id_dep,String id_emp_response)throws BizException{
    	//getConsultationPatientsQry qry = new getConsultationPatientsQry(id_org,id_dep,id_emp_response);
    	//String[] rtn = (String[])AppFwUtil.getDORstWithDao(qry, String.class);
    	DAFacade facade = new DAFacade();  
    	 
    	String sql = getSql(id_org,id_dep,id_emp_response);
    	List<CiOrderDO> list = (List<CiOrderDO>)facade.execQuery(sql, new BeanListHandler(CiOrderDO.class));
    	
    	if(list != null && list.size() >0)
    	{   String[] id_ors = new String[list.size()];
    		for(int i =0;i<list.size();i++){
    			id_ors[i]= list.get(i).getId_en();
    		}
    		return id_ors;
    	}
    	return null;
    }
    
	/**
     * 待应答会诊患者列表查询接口
     * @param id_org 机构
     * @param id_dep 登陆科室
     * @param id_emp_response 登陆人员
     * @return String[] 就诊id_en
     * @throws BizException
     */
    public String[] exe2(String id_org,String id_dep,String id_emp_response)throws BizException{
    	String sql =getRespondSql(id_org,id_dep,id_emp_response);
    	DAFacade facade = new DAFacade();  
    	List<CiOrderDO> list = (List<CiOrderDO>)facade.execQuery(sql, new BeanListHandler(CiOrderDO.class));
    	if(list != null && list.size() >0)
    	{   String[] id_ors = new String[list.size()];
    		for(int i =0;i<list.size();i++){
    			id_ors[i]= list.get(i).getId_en();
    		}
    		return id_ors;
    	}
    	return null;
    }
    
    
     /**
      * 会诊可见天数
      * @param id_org
      * @return
      * @throws BizException
      */
	private int getconsEffeTime(String id_org) throws BizException {

		// String consEffeTime=ParamsetQryUtil.getParaString("GLOBLE00000000000000",ICiOrdSysParamConst.SYS_PARAM_ORConsEffeTime);
		// return Integer.parseInt(consEffeTime);
		
		// modify by hums SYS_PARAM_ORConsEffeTime 与 SYS_PARAM_OrConsPatVisDay含义相同 废弃SYS_PARAM_ORConsEffeTime
		
		String consEffeTime = ParamsetQryUtil.getParaString(id_org, ICiOrdNSysParamConst.SYS_PARAM_OrConsPatVisDays);
		if(StringUtils.isEmpty(consEffeTime)){
			consEffeTime = "3";
		}
		
		return Integer.parseInt(consEffeTime); // 在sql中按天数加，不是按小时加
		//会诊设置的天数，准换成小时
		//return Integer.parseInt(consEffeTime)*24;
	}
    /**
     * 会诊患者列表
     * @param id_org
     * @param id_dep
     * @param id_emp_response
     * @return
     * @throws BizException
     */
	private String getSql(String id_org, String id_dep, String id_emp_response) throws BizException {
		StringBuffer sb = new StringBuffer();
		/*sb.append("select ap.id_or,ap.dt_plan,or.id_ent,en.fg_ip ");
		sb.append(arg0)
		*/

		sb.append("select distinct ord.id_en ");
		//--en.fg_ip   --判断本次就诊是否还在院
		sb.append(" from CI_INVITE_CONS cons ");
		sb.append(" inner join CI_AP_CONS ap on cons.id_apcons=ap.id_apcons ");
		sb.append(" inner join CI_ORDER ord on ap.id_or= ord.id_or ");
		sb.append(" inner join EN_ENT_IP en on ord.id_en=en.id_ent ");
		//sb.append(" inner join EN_ENT ent on ord.id_en=ent.id_ent ");
		sb.append(" where ord.sd_srvtp='" + IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS + "'");		
		sb.append(" and ord.fg_sign='Y' and ord.fg_canc='N' ");//  --sd_su_or=‘10已签署’ or  ‘20核对通过’
		sb.append(" and en.fg_doc_commit='N'  ");// --查询出id_or后，在查ci_order表，
		//sb.append(" and ent.fg_ip = 'Y'"); // 患者在院
		//--and//受邀医生匹配过滤？
		sb.append(" and cons.fg_response='Y' "); // 已应答
		//-- and （ap.dt_plan+参数：OrConsPatVisDays会诊患者可见天数）>当前时间 
		sb.append(" and to_char(to_date(ap.dt_plan,'yyyy-mm-dd HH24:MI:SS')+" + getconsEffeTime(id_org)
				+ ",'yyyy-mm-dd HH24:MI:SS') > to_char(sysdate,'yyyy-mm-dd HH24:MI:SS') ");
		if (id_org != null && id_org != "") {
			sb.append("  and cons.id_org ='" + id_org + "' ");
		}
		if (id_dep != null && id_dep != "") {
			sb.append("  and cons.id_dep ='" + id_dep + "' ");
		}
		if(id_emp_response != null && id_emp_response !=""){
			sb.append("  and cons.id_emp='"+id_emp_response+"' ");
		}
		
		return sb.toString();
	}
    
    /**
     * 应答会诊患者列表
     * @param id_org
     * @param id_dep
     * @param id_emp_response
     * @return
     * @throws BizException
     */
    private String getRespondSql(String id_org,String id_dep,String id_emp_response)throws BizException{
		StringBuffer sb= new StringBuffer();
		sb.append(" select distinct ci_order.id_en from ci_order ci_order, ");
		sb.append(" ci_ap_cons  ci_ap_cons, ");
		sb.append(" ci_invite_cons ci_invite_cons ");
		sb.append(" where  ci_order.id_or = ci_ap_cons.id_or ");
		sb.append("  and ci_invite_cons.id_apcons = ci_ap_cons.id_apcons ");
		sb.append("  and ci_order.fg_sign ='Y' and ci_order.fg_canc ='N' ");
		sb.append("  and ci_order.sd_srvtp ='"+IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS+"'");
		sb.append("  and ci_invite_cons.fg_response ='N' ");
		sb.append("  and to_char(to_date(ci_ap_cons.dt_plan,'yyyy-mm-dd HH24:MI:SS')+"+getconsEffeTime(id_org)+",'yyyy-mm-dd HH24:MI:SS') > to_char(sysdate,'yyyy-mm-dd HH24:MI:SS')");
	    sb.append("  and  ci_ap_cons.sd_su_cons in ('"+ICiDictCodeConst.SD_CI_CONS_DKSYD+"','"+ICiDictCodeConst.SD_CI_CONS_KSBFYD+"')");
		if(id_org !=null && id_org !=""){
	      sb.append("  and ci_invite_cons.id_org ='"+id_org+"' ");
	    }
		if(id_dep != null && id_dep !=""){
			sb.append("  and ci_invite_cons.id_dep ='"+id_dep+"' ");
		}
		/*if(id_emp_response != null && id_emp_response !=""){
			sb.append("  and ci_invite_cons.id_emp_response='"+id_emp_response+"' ");
		}*/
		return sb.toString();
	}
    //测试sql
    /*select distinct ci_order.id_en from ci_order ci_order,
    ci_ap_cons  ci_ap_cons,
    ci_invite_cons ci_invite_cons
where  ci_order.id_or = ci_ap_cons.id_or
 and ci_invite_cons.id_apcons = ci_ap_cons.id_apcons
 and ci_order.fg_sign ='Y' and ci_order.fg_canc ='N'
 and ci_order.sd_srvtp ='0902'
 and ci_invite_cons.fg_response ='N'
 and  ci_ap_cons.sd_su_cons in('4','5')
 and ci_ap_cons.dt_plan > 
 and ci_invite_cons.id_org =''
 and ci_invite_cons.id_dep =''
 and ci_invite_cons.id_emp_response=''*/
}
