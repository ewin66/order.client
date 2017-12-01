package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getCiApObsDtoIdEnQry implements ITransQry {

	private String _id_en;
	private String _param ="";
	public getCiApObsDtoIdEnQry(String id_en,String param){
		this._id_en = id_en;
		this._param = param;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam(this._id_en);
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		if(this._param =="2"){
			return getSql2();
		}else{
			return getSql();
		}
		
	}
	 private String getSql2(){
		 return     " Select "+
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
					" ''   id_srv,"+
					" '' body_name, "+
					" '' sd_pos,    "+
					" '' quan_medu,  "+
					" '' id_medu,   "+
					" pat.sd_sex, "+
					" pat.dt_birth, "+
					"   obs.fg_urgent  fg_urgent, "+
					 "   obs.sd_su_obs"+
					"  From CI_ORDER" +
					"  inner join ci_ap_obs obs on obs.id_or = ci_order.id_or and obs.sd_su_obs ='0' "+
					//" left outer join ci_or_srv  on CI_ORDER.id_or = ci_or_srv.id_or  "+
					//" left outer join CI_OR_SRV_SET on CI_ORDER.id_or= CI_OR_SRV_SET.id_or "+
					" left outer join pi_pat  pat on pat.id_pat = CI_ORDER.Id_Pat  "+
					" left outer join bd_psndoc psndoc on psndoc.id_psndoc = CI_ORDER.id_emp_sign  "+
					"left outer join bd_dep bddep on bddep.id_dep = CI_ORDER.Id_Dep_Sign  "+
					" where   ( CI_ORDER.sd_su_or ='"+ICiDictCodeConst.SD_SU_CHECKTHROUGH+"'"+
					  "  or  CI_ORDER.sd_su_or ='"+ICiDictCodeConst.SD_SU_SIGN+"')"+
					 "  and  CI_ORDER.Sd_Su_Bl !='2' "+
					"   and CI_ORDER.Id_En = ?"
					;
	 }
   
	 private String getSql(){
		 return     " Select "+
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
					" CI_ORDER.name_or  name_srv,"+
					" CI_ORDER.id_srv  id_srv,"+
					" pat.id_pat, "+
					" pat.sd_sex, "+
					" pat.dt_birth, "+
					"   obs.fg_urgent  fg_urgent, "+
					 "   obs.sd_su_obs"+
					"  From CI_ORDER" +
					"  inner join ci_ap_obs obs on obs.id_or = ci_order.id_or and obs.sd_su_obs ='0' "+
					" left outer join pi_pat  pat on pat.id_pat = CI_ORDER.Id_Pat  "+
					" left outer join bd_psndoc psndoc on psndoc.id_psndoc = CI_ORDER.id_emp_sign  "+
					"left outer join bd_dep bddep on bddep.id_dep = CI_ORDER.Id_Dep_Sign  "+
					" where   ( CI_ORDER.sd_su_or ='"+ICiDictCodeConst.SD_SU_CHECKTHROUGH+"'"+
					  "  or  CI_ORDER.sd_su_or ='"+ICiDictCodeConst.SD_SU_SIGN+"')"+
					"   and  CI_ORDER.Sd_Su_Bl !='2' "+
					"   and CI_ORDER.Id_En = ?"
					;
	 }
}
