/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: getCiApObsDtoIdPatQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年4月7日 上午9:58:04
 * @Package iih.ci.ord.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getCiApObsDtoIdPatQry implements ITransQry {
   
	private String _id_pat;
	private String _param ="";
	private String _sd_su_bl;
	
	public getCiApObsDtoIdPatQry(String id_pat,String param,String[] sd_su_bl){
		this._id_pat = id_pat;
		this._param = param;
		this._sd_su_bl = this.getSdSuBL(sd_su_bl);
	}
	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQryParameter(java.lang.StringBuffer)
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		param.addParam(this._id_pat);
		return param;
	}
	
    private String getSdSuBL(String[] sd_su_bl){
    	if (sd_su_bl.length == 0)
			return "";
		String resultStr = "";
		for (String str : sd_su_bl) {
			resultStr += ((resultStr.length() == 0 ? "" : ",") + "'" + str + "'");
		}
    	return resultStr;
    }
	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQrySQLStr()
	 */
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		if(_param=="2"){
			return  getSql2();
		}else{
		   return getSql();
		}
		
	}
	private String getSql2(){
		 return " Select "+
				" CI_ORDER.id_or, "+
				" CI_ORDER.Id_Dep_Or,  "+
				" CI_ORDER. name_or,  "+
				" CI_ORDER. content_or,  "+
				" CI_ORDER. id_en,     "+
				" CI_ORDER.ID_ENTP,   "+
				" obs.dt_plan dt_effe,    "+
				" CI_ORDER. id_emp_sign,  "+
				" psndoc.name  name_emp_sign,"+
				" CI_ORDER. id_dep_sign, "+
				" bddep.name  name_dep_sign,"+
				" '' id_srvset,  "+
				" ''   name_srv,"+
				" CI_ORDER.id_srv   id_srv,"+
				" pat.id_pat id_pat,"+
				" '' body_name, "+
				" '' sd_pos,    "+
				" '' quan_medu,  "+
				" '' id_medu,   "+
				" pat.sd_sex, "+
				" pat.dt_birth, "+
				" CI_ORDER.Id_Dep_Mp Id_dep_mp,"+
				" obs.fg_urgent  fg_urgent "+
				" From CI_ORDER" +
				"  inner join ci_ap_obs obs on obs.id_or = ci_order.id_or and obs.sd_su_obs ='0' "+
				//" left outer join ci_or_srv  on CI_ORDER.id_or = ci_or_srv.id_or  "+
				//" left outer join CI_OR_SRV_SET on CI_ORDER.id_or= CI_OR_SRV_SET.id_or "+
				" left outer join pi_pat  pat on pat.id_pat = CI_ORDER.Id_Pat  "+
				" left outer join bd_psndoc psndoc on psndoc.id_psndoc = CI_ORDER.id_emp_sign  "+
				"left outer join bd_dep bddep on bddep.id_dep = CI_ORDER.Id_Dep_Sign  "+
				" where   (CI_ORder.sd_su_or ='"+ICiDictCodeConst.SD_SU_CHECKTHROUGH+"'  or "
						+ " CI_ORder.sd_su_or ='"+ICiDictCodeConst.SD_SU_SIGN+"')"+
				 "  and obs.sd_su_obs = '0' "+
				 "  and  CI_ORDER.Sd_Su_Bl in ("+_sd_su_bl+")"+
				 "  and CI_ORDER.id_pat =? ";
	  }
	
	private String getSql(){
		 return " Select "+
				" CI_ORDER.id_or, "+
				" CI_ORDER.Id_Dep_Or,  "+
				" CI_ORDER. name_or,  "+
				" CI_ORDER. content_or,  "+
				" CI_ORDER. id_en,     "+
				" CI_ORDER.ID_ENTP,   "+
				" obs.dt_plan dt_effe,    "+
				" CI_ORDER. id_emp_sign,  "+
				" psndoc.name  name_emp_sign,"+
				" CI_ORDER. id_dep_sign, "+
				" bddep.name  name_dep_sign,"+
				" CI_OR_SRV_SET.id_srvset,  "+
				" ci_or_srv.name  name_srv,"+
				" ci_or_srv.id_srv  id_srv,"+
				" CI_OR_SRV_SET.body_name, "+
				" CI_OR_SRV_SET.sd_pos,    "+
				" CI_OR_SRV_SET.quan_medu,  "+
				" CI_OR_SRV_SET.id_medu,   "+
				" pat.sd_sex, "+
				" pat.dt_birth, "+
				" obs.fg_urgent  fg_urgent "+
				" From CI_ORDER" +
				"  inner join ci_ap_obs obs on obs.id_or = ci_order.id_or and obs.sd_su_obs ='0' "+
				" left outer join ci_or_srv  on CI_ORDER.id_or = ci_or_srv.id_or  "+
				" left outer join CI_OR_SRV_SET on CI_ORDER.id_or= CI_OR_SRV_SET.id_or "+
				" left outer join pi_pat  pat on pat.id_pat = CI_ORDER.Id_Pat  "+
				" left outer join bd_psndoc psndoc on psndoc.id_psndoc = CI_ORDER.id_emp_sign  "+
				"left outer join bd_dep bddep on bddep.id_dep = CI_ORDER.Id_Dep_Sign  "+
				" where  (CI_ORder.sd_su_or ='"+ICiDictCodeConst.SD_SU_CHECKTHROUGH+"' or "
						+ "  CI_ORder.sd_su_or ='"+ICiDictCodeConst.SD_SU_SIGN+"')"+
				 "  and obs.sd_su_obs = '0' "+
				 " and  CI_ORDER.Sd_Su_Bl !='2'"+
				 "  and CI_ORDER.id_pat =? ";
	 }
}
