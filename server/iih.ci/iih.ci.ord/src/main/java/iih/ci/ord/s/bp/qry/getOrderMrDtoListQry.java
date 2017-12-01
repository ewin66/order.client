package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getOrderMrDtoListQry implements ITransQry {
   
	private String _id_ent;
	private String _code_entp;
	public getOrderMrDtoListQry(String id_ent,String type){
		this._id_ent = id_ent;
		this._code_entp = type;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this._id_ent);
		sqlparam.addParam(this._code_entp);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}

	
	 private String getSql(){
		 String sql= " select ciorder.id_or as id_or, ciorder.id_pat as id_pat, ciorder.id_en as id_en, ciorder.id_entp as id_entp, ciorder.code_entp as code_entp,  ciorder.fg_long as fg_long, "
			 		+ " ciorder.id_srvtp as id_srvtp, ciorder.sd_srvtp as sd_srvtp, ciorder.id_freq as id_freq, freq.name as name_freq, ciorder.id_route as  id_route, route.name as name_route, '' as id_routedes, '' as name_routedes, "
			 		+ " ciorder.id_boil as id_boil, boil.name as name_boil, '' as id_boildes, '' as name_boildes, ciorder.days_or as days_or,  ciorder.orders_boil as orders_boil, ciorder.orders as orders, "
			 		+ " cisrv.name as name, ciorder.content_or as content_or, '' as id_emp_phy, '' as name_emp_phy, '' as id_dep_phy, '' as name_dep_phy,  ciorder.id_wg_or as id_wg_or, ciorder.Dt_chk_stop,ciorder.dt_effe as dt_effe, ciorder.dt_end as dt_end, "
			 		+ " ciorder.note_or as note, ciorder.sd_su_or as sd_su_or, '' as name_su_or, '' as order_support, cisrv.quan_medu as quan_num_base,  cisrv.id_medu as id_medu, measdoc.name as id_medu_name "
			 		+ " from ci_order ciorder"
			 		+ " left outer join ci_or_srv  cisrv   on cisrv.id_or = ciorder.id_or"
			 		+ " left outer join bd_measdoc measdoc on cisrv.id_medu = measdoc.id_measdoc"
			 		+ " left outer join bd_udidoc  udidoc  on udidoc.id_udidoc = ciorder.id_srvtp"
			 		+ " left outer join bd_freq    freq    on ciorder.id_freq = freq.id_freq"
			 		+ " left outer join bd_route   route   on ciorder.id_route = route.id_route"
			 		+ " left outer join bd_boil    boil    on ciorder.id_boil = boil.id_boil"
			 		+ " where ciorder.ds = '0'"
			 		+ " and ciorder.fg_sign='Y'"
			 		+ " and cisrv.sd_srvtp not like '07%'"
			 		+ " and cisrv.fg_or ='Y'"
			 		+ " and ciorder.id_en =?"
			 		+ " and ciorder.code_entp =?"
			 		+ " order by ciorder.dt_effe desc";
			 
			 return sql;
	 }
}
