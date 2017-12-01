package iih.ci.ord.s.bp.ordpres;

import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获得医嘱处方信息查询
 */
public class GetOrdPresInfoQry implements ITransQry {
	private String _id_en;
	private String _ids_orpres;

	/**
	 * 构造函数
	 * @param id_en
	 */
	public GetOrdPresInfoQry(String id_en,String ids_orpres) {
		_id_en = id_en;
		_ids_orpres=ids_orpres;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlparam=new SqlParam();
		if(CiOrdUtils.isEmpty(_ids_orpres)){ //患者本次就诊的处方查询情况 或批量打印查询
			sqlparam.addParam(_id_en);
		}else{//按处方id进行处方查询   目前主要是处方重打或补打用
			if(!CiOrdUtils.isEmpty(_id_en)){sqlparam.addParam(_id_en);}
			if(!isIDs()){sqlparam.addParam(_ids_orpres);}
		}
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		if(CiOrdUtils.isEmpty(_ids_orpres))return getQrySQl8IDEn();
		return getQrySql8IdPres();
	}
	/**
	 * 就诊批量查询基本SQL
	 * @return
	 */
	private String getQrySQlBaseStr(){
		return " select A.Id_Pres,A.Id_Grp,A.ID_ORG,A.ID_PATI,B.Name_Pat as name_pati,C.Name as name_patica,A.id_entp,A.code_entp,A.id_en, "
				  +" A.Id_Di,A.Id_Diitm,A.Str_Id_Di,A.Str_Name_Di,A.id_srvtp,A.Sd_Srvtp,A.Id_Prestp,A.sd_prestp,D.Name as name_prestp,A.code, "
				  +" A.Id_Dep_mp,J.NAME as name_dep_mp,A.id_prestpword,A.sd_prestpword,"
				  +" A.name,A.Id_Dep_Or,E.NAME as name_dep_or,A.Id_Emp_Or as id_emp_or,F.Name as name_emp_or,A.Dt_Entry,A.Fg_Bb,A.No_Bb,'' as id_bb, "
				  +" A.id_route,A.id_routedes,A.Id_boil,A.Id_boildes,A.Fg_Charge,A.Fg_Dispense,A.Id_Backtp,A.Sd_Backtp,A.Fg_Back, "
				  +" A.Id_Pres_Rel_Add as id_pres_rel,A.Id_Emp as id_emp,'' as id_emp_disp,'' as name_emp_disp,'' as dt_disp,'' as dt_charge,'' as rereason_rtn,'' as batchno "
				  +" ,B.CODE as barcode,I.orgcode as regnum_org,'' as code_poishempres,G.Name as gender,0 as age,H.Id_Code as idno,H.workunit," //打印新增行部分
				  +" '' as psn_agent,'' as idno_agent,'' as id_dep_mp,'' as name_dep_mp,0 as num_pv,'' as des_alcla,0 as amt_total"//打印新增行部分
				  +" from ci_pres A  "
				  +" left join en_ent B on A.Id_En = B.Id_Ent  "
				  +" left join pi_pat_ca C on B.Id_Patca = C.Id_Patca  "
				  +" left join bd_udidoc D on A.Id_Prestp=D.Id_Udidoc "
				  +" left join bd_dep E on A.Id_Dep_Or = E.Id_Dep "
				  +" left join bd_psndoc F on a.id_emp_or = F.ID_PSNDOC "
				  +" left outer join bd_udidoc G on B.Id_Sex_Pat=G.Id_Udidoc " //打印新增行部分
				  +" left outer join pi_pat H on A.Id_Pati=H.Id_Pat "//打印新增行部分
				  +" left outer join bd_org I on A.Id_Org=I.Id_Org "//打印新增行部分
				  +" left join bd_dep J on A.Id_Dep_mp = J.Id_Dep "
				  ;
	}
	/**
	 * 就诊批量查询SQL
	 * 根据就诊
	 * @return
	 */
	private String getQrySQl8IDEn(){
		return getQrySQlBaseStr() +" where A.Id_En=? ";		
	}
	
	/**
	 * 就诊批量查询SQL
	 * 根据处方
	 * @return
	 */
	private String getQrySql8IdPres(){
		return getQrySQlBaseStr() +getIdPresSqlStr();	
	}
	
	private String getIdPresSqlStr(){
		String rtn="";
		if(!CiOrdUtils.isEmpty(_id_en)){rtn=" where A.Id_En=?  and ";}
		String id_pressql=CiOrdUtils.getSqlInStrsWithOutIn(_ids_orpres);
		if(!isIDs())return rtn+" A.Id_Pres=? ";
		return rtn+" A.Id_Pres in ("+id_pressql+") ";
	}
	
	private boolean isIDs(){
		if(_ids_orpres.indexOf(CiOrdUtils.COMMA_STR)==-1)return false;
		return true;
	}

}
