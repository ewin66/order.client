/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.utils.BdEnvContextUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: getCiApObsDtoNoApplyFormQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年4月7日 上午9:57:42
 * @Package iih.ci.ord.s.bp.qry Copyright: Copyright (c) 2011 Company:
 *          北大医疗信息技术有限责任公司
 */
public class getCiApObsDtoNoApplyFormQry implements ITransQry {

	private String _noApplyForm;
	private String _param = "";
	private String _sd_su_bl;

	public getCiApObsDtoNoApplyFormQry(String noApplyForm, String param, String[] sd_su_bl) {
		this._noApplyForm = noApplyForm;
		this._param = param;
		this._sd_su_bl = this.getSdSuBL(sd_su_bl);
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
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * xap.sys.appfw.orm.utils.ITransQry#getQryParameter(java.lang.StringBuffer)
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		param.addParam(this._noApplyForm);
		return param;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQrySQLStr()
	 */
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		if (this._param == "2") {
			return getSql2();
		} else {
			return getSql();
		}

	}

	private String getSql2() {
		//li_cheng 增加管控
		String  orgsql=BdEnvContextUtil.processEnvContext(new CiOrderDO(), "ci_order");
		return " Select "
				+ " CI_ORDER.id_or, "
				+ " CI_ORDER.Id_Dep_Or,  "
				+ " CI_ORDER. name_or,  "
				+ " CI_ORDER. content_or,  "
				+ " CI_ORDER. id_en,     "
				+ " CI_ORDER.id_dep_mp ,     "
				+ " CI_ORDER.ID_ENTP,   "
				+ " obs.dt_plan dt_effe,    "
				+ " CI_ORDER. id_emp_sign,  "
				+ " psndoc.name  name_emp_sign,"
				+ " CI_ORDER. id_dep_sign, "
				+ " bddep.name  name_dep_sign,"
				+ " ''  id_srvset,  "
				+ " ''    name_srv,"
				+ " CI_ORDER.id_srv    id_srv,"
				+ " '' body_name, "
				+ " '' sd_pos,    "
				+ " '' quan_medu,  "
				+ " '' id_medu,   "
				+ " pat.sd_sex, "
				+ " pat.dt_birth, "
				+ " obs.fg_urgent  fg_urgent, "
				+ " obs.sd_su_obs"
				+ " From CI_ORDER"
				+ "  inner join ci_ap_obs obs on obs.id_or = ci_order.id_or and obs.sd_su_obs ='0' "
				+
				// " left outer join ci_or_srv  on CI_ORDER.id_or = ci_or_srv.id_or  "+
				// " left outer join CI_OR_SRV_SET on CI_ORDER.id_or= CI_OR_SRV_SET.id_or "+
				" left outer join pi_pat  pat on pat.id_pat = CI_ORDER.Id_Pat  "
				+ " left outer join bd_psndoc psndoc on psndoc.id_psndoc = CI_ORDER.id_emp_sign  "
				+ "left outer join bd_dep bddep on bddep.id_dep = CI_ORDER.Id_Dep_Sign  "
				+ " where   ( CI_ORDER.sd_su_or ='" + ICiDictCodeConst.SD_SU_CHECKTHROUGH + "'"
				+ "  or  CI_ORDER.sd_su_or ='" + ICiDictCodeConst.SD_SU_SIGN + "')"
				+ "  and obs.sd_su_obs = '0'    and  CI_ORDER.Sd_Su_Bl in ("+_sd_su_bl+")  and obs.no_applyform =? "
						+ " and "+orgsql;
	}

	private String getSql() {
		//li_cheng 增加管控
		String  orgsql=BdEnvContextUtil.processEnvContext(new CiOrderDO(), "ci_order");
		return " Select "
				+ " CI_ORDER.id_or, "
				+ " CI_ORDER.Id_Dep_Or,  "
				+ " CI_ORDER. name_or,  "
				+ " CI_ORDER. content_or,  "
				+ " CI_ORDER. id_en,     "
				+ " CI_ORDER.ID_ENTP,   "
				+ " CI_ORDER.id_dep_mp ,     "
				+ " obs.dt_plan dt_effe,    "
				+ " CI_ORDER. id_emp_sign,  "
				+ " psndoc.name  name_emp_sign,"
				+ " CI_ORDER. id_dep_sign, "
				+ " bddep.name  name_dep_sign,"
				+ " CI_OR_SRV_SET.id_srvset,  "
				+ " ci_or_srv.name  name_srv,"
				+ " ci_or_srv.id_srv  id_srv,"
				+ " CI_OR_SRV_SET.body_name, "
				+ " CI_OR_SRV_SET.sd_pos,    "
				+ " CI_OR_SRV_SET.quan_medu,  "
				+ " CI_OR_SRV_SET.id_medu,   "
				+ " pat.sd_sex, "
				+ " pat.dt_birth, "
				+ " obs.fg_urgent  fg_urgent, "
				+ " obs.sd_su_obs "
				+ " From CI_ORDER "
				+ "  inner join ci_ap_obs obs on obs.id_or = ci_order.id_or and obs.sd_su_obs ='0' "
				+ " left outer join ci_or_srv  on CI_ORDER.id_or = ci_or_srv.id_or  "
				+ " left outer join CI_OR_SRV_SET on CI_ORDER.id_or= CI_OR_SRV_SET.id_or "
				+ " left outer join pi_pat  pat on pat.id_pat = CI_ORDER.Id_Pat  "
				+ " left outer join bd_psndoc psndoc on psndoc.id_psndoc = CI_ORDER.id_emp_sign  "
				+ "left outer join bd_dep bddep on bddep.id_dep = CI_ORDER.Id_Dep_Sign  "
				+ " where   ( CI_ORDER.sd_su_or ='" + ICiDictCodeConst.SD_SU_CHECKTHROUGH + "'"
				+ "  or  CI_ORDER.sd_su_or ='" + ICiDictCodeConst.SD_SU_SIGN + "')"
				+ "  and obs.sd_su_obs = '0'   and  CI_ORDER.Sd_Su_Bl !='2'  " + "  and obs.no_applyform =? "
						+ " and "+orgsql;
	}
}
