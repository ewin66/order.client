/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: getConsultationPatientsQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年6月3日 下午1:50:54
 * @Package iih.ci.ord.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getConsultationPatientsQry implements ITransQry {
    
	private String _id_org;
	private String _id_dep;
	private String _id_emp_response;
	private int _consEffeTime;
	public getConsultationPatientsQry(String id_org,String id_dep,String id_emp_response)throws BizException{
		this._id_org = id_org;
		this._id_dep = id_dep;
		this._id_emp_response = id_emp_response;
	   //String consEffeTime=ParamsetQryUtil.getParaString(this._id_org, ICiOrdSysParamConst.SYS_PARAM_ORConsEffeTime);
	   //_consEffeTime = Integer.parseInt(consEffeTime);
	}
	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQryParameter(java.lang.StringBuffer)
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		param.addParam(this._id_org);
		param.addParam(this._id_dep);
		param.addParam(this._id_emp_response);
		return param;
	}

	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQrySQLStr()
	 */
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
   
	private String getSql(){
		StringBuffer sb= new StringBuffer();
		sb.append(" select distinct ci_order.id_en from ci_order ci_order, ");
		sb.append(" ci_ap_cons  ci_ap_cons, ");
		sb.append(" ci_invite_cons ci_invite_cons ");
		sb.append(" where  ci_order.id_or = ci_ap_cons.id_or ");
		sb.append("  and ci_invite_cons.id_apcons = ci_ap_cons.id_apcons ");
		sb.append("  and ci_order.fg_sign ='Y' and ci_order.fg_canc ='N' ");
		sb.append("  and ci_order.sd_srvtp ='"+IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS+"'");
		sb.append("  and ci_invite_cons.fg_response ='Y' ");
		sb.append("  and to_char(to_date(ci_ap_cons.dt_plan,'yyyy-mm-dd HH24:MI:SS')+"+48/24+",'yyyy-mm-dd HH24:MI:SS') > to_char(sysdate,'yyyy-mm-dd HH24:MI:SS')");
		sb.append("  and ci_invite_cons.id_org =? ");
		sb.append("  and ci_invite_cons.id_dep =? ");
		sb.append("  and ci_invite_cons.id_emp_response=? ");
		return sb.toString();
	}
}
