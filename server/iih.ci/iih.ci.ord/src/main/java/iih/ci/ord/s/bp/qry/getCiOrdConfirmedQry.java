package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.ciordems.d.OrConfirm;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getCiOrdConfirmedQry implements ITransQry{
	
	private String id_dep_nur;
	private String id_dep_phy;
	private String id_bed;
	private OrConfirm confirm;
	public getCiOrdConfirmedQry(OrConfirm confirm){
		this.id_dep_nur=confirm.getId_dep_nur();
		this.id_dep_phy=confirm.getId_dep_phy();
		this.id_bed=confirm.getId_bed();
		this.confirm=confirm;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		param.addParam(this.id_dep_nur);

		if(this.id_dep_phy!=null)
			param.addParam(this.id_dep_phy);
		if(this.id_bed!=null)
			param.addParam(this.id_bed);
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		
		
		String str="SELECT CI_OR.ID_OR id_confirm, EN_ENT_IP.name_bed, "
				+ "EN_ENT_IP.id_bed, "
				+ "EN_ENT.id_ent,"
				+ "EN_ENT.code entcode, ";
		str+="EN_ENT.code_entp, "
				+ "EN_ENT.id_pat, "
				+ "EN_ENT.name_pat, "
				+ "EN_ENT.sd_sex_pat sd_sex, "
				+ " EN_ENT.dt_birth_pat , "
				+ "CI_OR .fg_sign,CI_OR .fg_stop,CI_OR .fg_canc,CI_OR .fg_chk, "
				+ "CI_OR .fg_chk_stop,CI_OR .fg_chk_canc, "
				+ "CI_OR.ID_EMP_SIGN id_emp_create,CI_OR.id_emp_stop,CI_OR.id_emp_canc,"
				+ "CI_OR.fg_long, CI_OR.id_freq,A.NAME name_emp_sign,B.NAME name_emp_stop,C.NAME name_emp_canc,";
		str+=" CI_OR.content_or, CI_OR.dt_effe,  CI_OR.dt_stop dt_end, CI_OR.dt_canc,";
		str+=" EN_ENT.id_dep_phy, EN_ENT_HP.id_hp, EN_ENT. id_dep_nur ";
		str+=" FROM CI_ORDER CI_OR LEFT JOIN EN_ENT ON EN_ENT.ID_ENT=CI_OR.ID_EN ";
		str+="  LEFT JOIN EN_ENT_IP ON EN_ENT_IP. id_ent = EN_ENT.id_ent ";
		str+="  LEFT JOIN EN_ENT_HP ON EN_ENT_HP. id_ent = EN_ENT.id_ent AND EN_ENT_HP. fg_maj ='Y' ";
		str+="  LEFT JOIN BD_PSNDOC A ON A.ID_PSNDOC=CI_OR.ID_EMP_SIGN ";
		str+="  LEFT JOIN BD_PSNDOC B ON  B.ID_PSNDOC=CI_OR.ID_EMP_STOP ";
		str+="  LEFT JOIN BD_PSNDOC C ON C.ID_PSNDOC=CI_OR.ID_EMP_CANC ";

		
		str+="  WHERE EN_ENT. id_dep_nur =? And EN_ENT.fg_ip='Y' And EN_ENT.code_entp='"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"'  ";
		
		str+=" and CI_OR .fg_canc = 'N' And CI_OR .fg_chk ='Y' and CI_OR .sd_su_mp='0' and CI_OR .ds=0 ";
		
		if(this.confirm.getId_orderchkca()!=null&&!this.confirm.getId_orderchkca().equals(""))
			str+=" and ("+this.confirm.getId_orderchkca()+") ";
		
		if(this.id_dep_phy!=null)
			str+=" And EN_ENT. id_dep_phy =? ";
		if(this.id_bed!=null)
			str+=" And EN_ENT_IP . id_bed = ? ";
         str+=" order by EN_ENT_IP.name_bed asc,CI_OR.dt_effe asc";
		return str;
	}

}
