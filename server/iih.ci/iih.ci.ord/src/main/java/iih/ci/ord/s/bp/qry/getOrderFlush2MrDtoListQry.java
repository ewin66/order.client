package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getOrderFlush2MrDtoListQry implements ITransQry {

	private String _id_ent;
	private String _code_entp;
	public getOrderFlush2MrDtoListQry(String id_ent,String type){
		this._id_ent = id_ent;
		this._code_entp = type;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		//sqlparam.addParam(this._id_ent);
		//sqlparam.addParam(this._code_entp);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}


	private String getSql(){
		String sql= 
				//				 "select * from(select ciorder.id_or as id_or,\n" +
				//						 "       ciorder.id_pat as id_pat,\n" + 
				//						 "       ciorder.id_en as id_en,\n" + 
				//						 "       ciorder.id_entp as id_entp,\n" + 
				//						 "       ciorder.code_entp as code_entp,\n" + 
				//						 "       ciorder.fg_long as fg_long,\n" + 
				//						 "       ciorder.id_srvtp as id_srvtp,\n" + 
				//						 "       ciorder.sd_srvtp as sd_srvtp,\n" + 
				//						 "       ciorder.id_freq as id_freq,\n" + 
				//						 "       freq.name as name_freq,\n" + 
				//						 "       ciorder.id_route as id_route,\n" + 
				//						 "       route.name as name_route,\n" + 
				//						 "       '' as id_routedes,\n" + 
				//						 "       '' as name_routedes,\n" + 
				//						 "       ciorder.id_boil as id_boil,\n" + 
				//						 "       boil.name as name_boil,\n" + 
				//						 "       '' as id_boildes,\n" + 
				//						 "       '' as name_boildes,\n" + 
				//						 "       ciorder.days_or as days_or,\n" + 
				//						 "       ciorder.orders_boil as orders_boil,\n" + 
				//						 "       ciorder.orders as orders,\n" + 
				//						 "       cisrv.name as name,\n" + 
				//						 "       ciorder.content_or as content_or,\n" + 
				//						 "       '' as id_emp_phy,\n" + 
				//						 "       '' as name_emp_phy,\n" + 
				//						 "       '' as id_dep_phy,\n" + 
				//						 "       '' as name_dep_phy,\n" + 
				//						 "       ciorder.id_wg_or as id_wg_or,\n" + 
				//						 "       ciorder.dt_effe as dt_effe,\n" + 
				//						 "       ciorder.dt_end as dt_end,\n" + 
				//						 "       ciorder.note_or as note,\n" + 
				//						 "       ciorder.sd_su_or as sd_su_or,\n" + 
				//						 "       ciorder.dt_entry as dt_entry,\n" + 
				//						 "       '' as name_su_or,\n" + 
				//						 "       '' as order_support,\n" + 
				//						 "       cisrv.quan_medu as quan_num_base,\n" + 
				//						 "       cisrv.id_medu as id_medu,\n" + 
				//						 "       cisrv.sortno as sortno,\n" + 
				//						 "       measdoc.name as id_medu_name\n" + 
				//						 "  from ci_order ciorder\n" + 
				//						 "  left outer join ci_or_srv cisrv\n" + 
				//						 "    on cisrv.id_or = ciorder.id_or\n" + 
				//						 "  left outer join bd_measdoc measdoc\n" + 
				//						 "    on cisrv.id_medu = measdoc.id_measdoc\n" + 
				//						 "  left outer join bd_udidoc udidoc\n" + 
				//						 "    on udidoc.id_udidoc = ciorder.id_srvtp\n" + 
				//						 "  left outer join bd_freq freq\n" + 
				//						 "    on ciorder.id_freq = freq.id_freq\n" + 
				//						 "  left outer join bd_route route\n" + 
				//						 "    on ciorder.id_route = route.id_route\n" + 
				//						 "  left outer join bd_boil boil\n" + 
				//						 "    on ciorder.id_boil = boil.id_boil\n" + 
				//						 " where ciorder.ds = '0'\n" + 
				//						 "   and ciorder.fg_sign = 'Y'\n" + 
				//						 "   and ciorder.fg_flush2mr = 'Y'\n" + 
				//						 "   and cisrv.sd_srvtp not like '07%'\n" + 
				//						 "   and cisrv.fg_or = 'Y'\n" + 
				//						 "   and ciorder.id_en ='"+this._id_ent+"'\n" + 
				//						 "   and ciorder.code_entp ='"+this._code_entp+"'\n" + 
				//						 "   and ciorder.fg_set = 'N'\n" + 
				//						 "union\n" + 
				//						 "select ciorder.id_or as id_or,\n" + 
				//						 "       ciorder.id_pat as id_pat,\n" + 
				//						 "       ciorder.id_en as id_en,\n" + 
				//						 "       ciorder.id_entp as id_entp,\n" + 
				//						 "       ciorder.code_entp as code_entp,\n" + 
				//						 "       ciorder.fg_long as fg_long,\n" + 
				//						 "       ciorder.id_srvtp as id_srvtp,\n" + 
				//						 "       ciorder.sd_srvtp as sd_srvtp,\n" + 
				//						 "       ciorder.id_freq as id_freq,\n" + 
				//						 "       freq.name as name_freq,\n" + 
				//						 "       ciorder.id_route as id_route,\n" + 
				//						 "       route.name as name_route,\n" + 
				//						 "       '' as id_routedes,\n" + 
				//						 "       '' as name_routedes,\n" + 
				//						 "       ciorder.id_boil as id_boil,\n" + 
				//						 "       boil.name as name_boil,\n" + 
				//						 "       '' as id_boildes,\n" + 
				//						 "       '' as name_boildes,\n" + 
				//						 "       ciorder.days_or as days_or,\n" + 
				//						 "       ciorder.orders_boil as orders_boil,\n" + 
				//						 "       ciorder.orders as orders,\n" + 
				//						 "       bdsrv.name as name,\n" + 
				//						 "       ciorder.content_or as content_or,\n" + 
				//						 "       '' as id_emp_phy,\n" + 
				//						 "       '' as name_emp_phy,\n" + 
				//						 "       '' as id_dep_phy,\n" + 
				//						 "       '' as name_dep_phy,\n" + 
				//						 "       ciorder.id_wg_or as id_wg_or,\n" + 
				//						 "       ciorder.dt_effe as dt_effe,\n" + 
				//						 "       ciorder.dt_end as dt_end,\n" + 
				//						 "       ciorder.note_or as note,\n" + 
				//						 "       ciorder.sd_su_or as sd_su_or,\n" + 
				//						 "       ciorder.dt_entry as dt_entry,\n" + 
				//						 "       '' as name_su_or,\n" + 
				//						 "       '' as order_support,\n" + 
				//						 "       srvset.quan_medu as quan_num_base,\n" + 
				//						 "       srvset.id_medu as id_medu,\n" + 
				//						 "       srvset.sortno as sortno,\n" + 
				//						 "       measdoc.name as id_medu_name\n" + 
				//						 "  from ci_order ciorder\n" + 
				//						 "  left outer join ci_or_srv_set srvset\n" + 
				//						 "    on srvset.id_or = ciorder.id_or\n" + 
				//						 "  left outer join bd_measdoc measdoc\n" + 
				//						 "    on srvset.id_medu = measdoc.id_measdoc\n" + 
				//						 "  left outer join bd_udidoc udidoc\n" + 
				//						 "    on udidoc.id_udidoc = ciorder.id_srvtp\n" + 
				//						 "  left outer join bd_freq freq\n" + 
				//						 "    on ciorder.id_freq = freq.id_freq\n" + 
				//						 "  left outer join bd_route route\n" + 
				//						 "    on ciorder.id_route = route.id_route\n" + 
				//						 "  left outer join bd_boil boil\n" + 
				//						 "    on ciorder.id_boil = boil.id_boil\n" + 
				//						 "  left outer join bd_srv bdsrv\n" + 
				//						 "    on bdsrv.id_srv = srvset.id_srvset\n" + 
				//						 " where ciorder.ds = '0'\n" + 
				//						 "   and ciorder.fg_sign = 'Y'\n" + 
				//						 "   and ciorder.fg_flush2mr = 'Y'\n" + 
				//						 "   and ciorder.sd_srvtp not like '07%'\n" +  
				//						 "   and srvset.fg_clinical = 'Y'\n" + 
				//						 "   and ciorder.fg_set = 'Y'\n" +
				//						 "   and ciorder.id_en ='"+this._id_ent+"'\n" + 
				//						 "   and ciorder.code_entp ='"+this._code_entp+"')\n" + 
				//						 " order by dt_entry desc,sortno asc\n";


				"select *\n" +
				"  from (select ciorder.id_or as id_or,\n" + 
				"               ciorder.id_pat as id_pat,\n" + 
				"               ciorder.id_en as id_en,\n" + 
				"               ciorder.id_entp as id_entp,\n" + 
				"               ciorder.code_entp as code_entp,\n" + 
				"               ciorder.fg_long as fg_long,\n" + 
				"               ciorder.id_srvtp as id_srvtp,\n" + 
				"               ciorder.sd_srvtp as sd_srvtp,\n" + 
				"               ciorder.id_freq as id_freq,\n" + 
				"               freq.name as name_freq,\n" + 
				"               ciorder.id_route as id_route,\n" + 
				"               route.name as name_route,\n" + 
				"               '' as id_routedes,\n" + 
				"               '' as name_routedes,\n" + 
				"               ciorder.id_boil as id_boil,\n" + 
				"               boil.name as name_boil,\n" + 
				"               '' as id_boildes,\n" + 
				"               '' as name_boildes,\n" + 
				"               ciorder.days_or as days_or,\n" + 
				"               ciorder.orders_boil as orders_boil,\n" + 
				"               ciorder.orders as orders,\n" + 
				"               cisrv.name as name,\n" + 
				"               ciorder.content_or as content_or,\n" + 
				"               '' as id_emp_phy,\n" + 
				"               '' as name_emp_phy,\n" + 
				"               '' as id_dep_phy,\n" + 
				"               '' as name_dep_phy,\n" + 
				"               ciorder.id_wg_or as id_wg_or,\n" + 
				"               ciorder.dt_effe as dt_effe,\n" + 
				"               ciorder.dt_end as dt_end,\n" + 
				"               ciorder.note_or as note,\n" + 
				"               ciorder.sd_su_or as sd_su_or,\n" + 
				"               ciorder.dt_entry as dt_entry,\n" + 
				"               '' as name_su_or,\n" + 
				"               '' as order_support,\n" + 
				"               cisrv.quan_medu as quan_num_base,\n" + 
				"               cisrv.id_medu as id_medu,\n" + 
				"               cisrv.sortno as sortno,\n" + 
				"               measdoc.name as id_medu_name\n" + 
				"          from ci_order ciorder\n" + 
				"          left outer join ci_or_srv cisrv\n" + 
				"            on cisrv.id_or = ciorder.id_or\n" + 
				"          left outer join bd_measdoc measdoc\n" + 
				"            on cisrv.id_medu = measdoc.id_measdoc\n" + 
				"          left outer join bd_udidoc udidoc\n" + 
				"            on udidoc.id_udidoc = ciorder.id_srvtp\n" + 
				"          left outer join bd_freq freq\n" + 
				"            on ciorder.id_freq = freq.id_freq\n" + 
				"          left outer join bd_route route\n" + 
				"            on ciorder.id_route = route.id_route\n" + 
				"          left outer join bd_boil boil\n" + 
				"            on ciorder.id_boil = boil.id_boil\n" + 
				"         where ciorder.ds = '0'\n" + 
				"           and ciorder.fg_sign = 'Y'\n" + 
				"           and ciorder.fg_flush2mr = 'Y'\n" + 
				"           and cisrv.sd_srvtp not like '07%'\n" + 
				"           and cisrv.fg_or = 'Y'\n" + 
				"   and ciorder.id_en ='"+this._id_ent+"'\n" + 
				"   and ciorder.code_entp ='"+this._code_entp+"'\n" + 
				"           and ciorder.fg_set = 'N'\n" + 
				"        union\n" + 
				"        select ciorder.id_or as id_or,\n" + 
				"               ciorder.id_pat as id_pat,\n" + 
				"               ciorder.id_en as id_en,\n" + 
				"               ciorder.id_entp as id_entp,\n" + 
				"               ciorder.code_entp as code_entp,\n" + 
				"               ciorder.fg_long as fg_long,\n" + 
				"               ciorder.id_srvtp as id_srvtp,\n" + 
				"               ciorder.sd_srvtp as sd_srvtp,\n" + 
				"               ciorder.id_freq as id_freq,\n" + 
				"               freq.name as name_freq,\n" + 
				"               ciorder.id_route as id_route,\n" + 
				"               route.name as name_route,\n" + 
				"               '' as id_routedes,\n" + 
				"               '' as name_routedes,\n" + 
				"               ciorder.id_boil as id_boil,\n" + 
				"               boil.name as name_boil,\n" + 
				"               '' as id_boildes,\n" + 
				"               '' as name_boildes,\n" + 
				"               ciorder.days_or as days_or,\n" + 
				"               ciorder.orders_boil as orders_boil,\n" + 
				"               ciorder.orders as orders,\n" + 
				"               ciorder.name_or as name,\n" + 
				"               ciorder.content_or as content_or,\n" + 
				"               '' as id_emp_phy,\n" + 
				"               '' as name_emp_phy,\n" + 
				"               '' as id_dep_phy,\n" + 
				"               '' as name_dep_phy,\n" + 
				"               ciorder.id_wg_or as id_wg_or,\n" + 
				"               ciorder.dt_effe as dt_effe,\n" + 
				"               ciorder.dt_end as dt_end,\n" + 
				"               ciorder.note_or as note,\n" + 
				"               ciorder.sd_su_or as sd_su_or,\n" + 
				"               ciorder.dt_entry as dt_entry,\n" + 
				"               '' as name_su_or,\n" + 
				"               '' as order_support,\n" + 
				"               0 as quan_num_base,\n" + 
				"               '' as id_medu,\n" + 
				"               0 as sortno,\n" + 
				"               '' as id_medu_name\n" + 
				"          from ci_order ciorder\n" + 
				"          left outer join bd_udidoc udidoc\n" + 
				"            on udidoc.id_udidoc = ciorder.id_srvtp\n" + 
				"          left outer join bd_freq freq\n" + 
				"            on ciorder.id_freq = freq.id_freq\n" + 
				"          left outer join bd_route route\n" + 
				"            on ciorder.id_route = route.id_route\n" + 
				"          left outer join bd_boil boil\n" + 
				"            on ciorder.id_boil = boil.id_boil\n" + 
				"           where ciorder.ds = '0'\n" + 
				"           and ciorder.fg_sign = 'Y'\n" + 
				"           and ciorder.fg_flush2mr = 'Y'\n" + 
				"           and ciorder.sd_srvtp not like '07%'\n" + 
				"   and ciorder.fg_set = 'Y'\n" +
				"   and ciorder.id_en ='"+this._id_ent+"'\n" + 
				"   and ciorder.code_entp ='"+this._code_entp+"')\n" + 
				" order by dt_entry desc,sortno asc\n";


		return sql;
	}
}
