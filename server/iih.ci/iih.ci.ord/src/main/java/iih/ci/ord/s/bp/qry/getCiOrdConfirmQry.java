package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciordems.d.OrConfirm;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getCiOrdConfirmQry implements ITransQry{
	
	private String id_dep_nur;
	private String sd_su_or;
	private String fg_long;
	private String id_dep_phy;
	private String id_bed;
	
	public getCiOrdConfirmQry(OrConfirm confirm){
		this.id_dep_nur=confirm.getId_dep_nur();
		this.fg_long=confirm.getFg_long()==null?null:(confirm.getFg_long()).toString();
		this.id_dep_phy=confirm.getId_dep_phy();
		this.sd_su_or=confirm.getSd_su_or();
		this.id_bed=confirm.getId_bed();
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		param.addParam(this.id_dep_nur);
		if(this.sd_su_or!=null)
			param.addParam(this.sd_su_or);

		if(this.fg_long!=null)
			param.addParam(this.fg_long);
		if(this.id_dep_phy!=null)
			param.addParam(this.id_dep_phy);
		if(this.id_bed!=null)
			param.addParam(this.id_bed);
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String str="SELECT EN_ENT_IP.name_bed, "
				+ "EN_ENT_IP.id_bed, "
				+ "EN_ENT.id_ent,"
				+ "EN_ENT.code entcode, ";
		str+="EN_ENT.code_entp, "
				+ "EN_ENT.id_pat, "
				+ "EN_ENT.name_pat, "
				+ "EN_ENT.sd_sex_pat sd_sex, "
				+ "floor(months_between(SYSDATE,to_date(EN_ENT.dt_birth_pat,'yyyy-mm-dd'))/12) age_pat, ";
		str+=" EN_ENT.id_dep_phy, "
				+ "CI_OR. id_or id_confirm, CI_OR.sd_su_or, CI_OR.fg_long, CI_OR.id_freq,";
		str+=" CI_OR.content_or, CI_OR.dt_effe,CI_OR.id_emp_or id_emp_create,   CI_OR.dt_stop,";
		str+=" (select b.NAME  from BD_PSNDOC b where b.ID_PSNDOC=CI_OR.ID_EMP_OR) name_emp_sign,(select b.NAME  from BD_PSNDOC b where b.ID_PSNDOC=CI_OR.ID_EMP_STOP) name_emp_stop,(select b.NAME  from BD_PSNDOC b where b.ID_PSNDOC=CI_OR.ID_EMP_CANC) name_emp_canc,";
		str+=" CI_OR.id_emp_stop, CI_OR.dt_canc, CI_OR.id_emp_canc, EN_ENT_HP.id_hp ";
		str+=" FROM CI_ORDER CI_OR INNER JOIN EN_ENT ON EN_ENT. id_ent = CI_OR .id_en ";
		str+="  LEFT JOIN EN_ENT_IP ON EN_ENT_IP. id_ent = EN_ENT.id_ent ";
		str+="  LEFT JOIN EN_ENT_HP ON EN_ENT_HP. id_ent = EN_ENT . id_ent AND EN_ENT_HP. fg_maj ='Y' ";
		str+="  WHERE EN_ENT. id_dep_nur =? And EN_ENT.fg_ip='Y' And EN_ENT.code_entp='"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"' ";
		if(this.sd_su_or!=null)
			str+=" And CI_OR .sd_su_or =? ";
		else{
			str+=" And CI_OR .sd_su_or in ('"+ICiDictCodeConst.SD_SU_SIGN+"','"+ICiDictCodeConst.SD_SU_DOCTORSTOP+"','"+ICiDictCodeConst.SD_SU_CANCEL+"') ";
		}
		if(this.fg_long!=null)
			str+=" And CI_OR .fg_long =? ";
		if(this.id_dep_phy!=null)
			str+=" And EN_ENT. id_dep_phy =? ";
		if(this.id_bed!=null)
			str+=" And EN_ENT_IP . id_bed = ? ";

		return str;
	}

}
