package iih.ci.ord.s.bp.qry;

import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class OpPatiNoDrugPresHeadQry implements ITransQry {
	
	private String _patiid;
	private FBoolean _isHerb;
	public OpPatiNoDrugPresHeadQry(String patiid,FBoolean  isHerb){
		_patiid=patiid;
		_isHerb=isHerb;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(_patiid);

		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return getQrySQLStr_();
	}
	
	private String getQrySQLStr2_(){
		return " select t.id_pres,t.id_grp,t.id_org,t.id_pati,p.name as name_pati, "
		     + " q.name as name_patica,t.id_entp,t.code_entp,t.id_en,t.id_di, "
		     + " t.id_diitm,t.str_id_di,t.str_name_di,t.id_srvtp, "
		     + " t.sd_srvtp,t.id_prestp,t.sd_prestp,r.name as name_prestp, "
		     + " t.code,t.name,id_dep_or,u.name as name_dep_or, "
		     + " id_emp_or, z.name as name_emp_or,dt_entry,fg_bb, "
		     + " no_bb,id_bb,id_route,id_routedes,id_boil,id_boildes, "
		     + " fg_charge,fg_dispense,id_backtp,sd_backtp,fg_back, "
		     + " t.id_pres_rel_add,id_emp,'' as id_emp_disp,'' as name_emp_disp, "
		     + " '' as dt_disp,'' as dt_charge,'' as reason_rtn,'' as batchno "
		     + " from ci_pres t "
		     + " inner join pi_pat p on t.id_pati=p.id_pat "
		     + " left outer join pi_pat_ca q on p.id_paticate=q.id_patca "
		     + " left outer join bd_udidoc r on r.id_udidoc=t.id_prestp "
		     + " left outer join bd_dep u on u.id_dep=t.id_dep_or "
		     + " left join bd_employee z on z.id_psndoc=t.id_emp_or "//开方医生
		     + " where "+getOrgCondStr()+" t.code_entp='01'  "
		     + " "+getPresTypeCondStr()+"  and "+getSrvTypeCondStr()+"  "
		     + " and t.fg_dispense='N' and t.sd_su_bl='1' and t.id_pati=? ";
		
	}
	
	private String getQrySQLStr_(){
		return " select distinct t.id_pat as id_pati,p.name as name_pati,"
				+ "z.name as name_emp_or ,u.name as name_dep_or ,di.des as str_name_di,"
				+ "t.id_prestp,r.name as name_prestp,t.id_en,id_pres,id_prestp,code_prestp,code_prestp as sd_prestp"
				+ ",code_pres as code,name_pres as name,id_emp_or,id_dep_or "
				+ "from  mp_dg_oep_dt t left join pi_pat p on t.id_pat = p.id_pat  "
				+ " left outer join pi_pat_ca q on p.id_paticate = q.id_patca   "
				+ " left outer join bd_udidoc r on r.id_udidoc = t.id_prestp  "
				+ " left outer join bd_dep u on u.id_dep = t.id_dep_or "
				+ " left outer join bd_employee z on z.id_psndoc = t.id_emp_or "
				+ " left outer join en_ent_di di on t.id_en  = di.id_ent and di.fg_maj = 'Y'"
				+ " where "+getOrgCondStr()+"  "
				+ " t.code_entp = '01'  "
				+ " and "+getSrvTypeCondStr()+"  "
				+ " and t.eu_su_mp <2 "
				+ " and  t.id_pat=? ";
		
	}
	
	/**
	 * 西成药 或草药串
	 * @return
	 */
	private String getSrvTypeCondStr(){
		if(_isHerb.isValue()){return "(substr(t.sd_srvtp, 1, 4)='0103')";}
		return "(substr(t.sd_srvtp, 1, 4) = '0101' or substr(t.sd_srvtp, 1, 4) = '0102')";
	}
	
	/**
	 * 处方类型串
	 * @return
	 */
	private String getPresTypeCondStr(){
		return "";  //and (t.sd_prestp='')
	}
	
	/**
	 * 组织串
	 * @return
	 */
	private String getOrgCondStr(){
		return "";//t.id_org='' and t.id_grp='' and
	}
}
