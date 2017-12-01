package iih.ci.ord.s.bp.ordpres;

import iih.bd.utils.BdEnvContextUtil;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获得医嘱处方明细信息查询
 */
public class GetOrdPresItemsInfoQry  implements ITransQry  {
	private SqlParam sqlparam;

	/**
	 * 构造函数
	 * @param id_en
	 */
	public GetOrdPresItemsInfoQry() {
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		
		String orgsql=BdEnvContextUtil.processEnvContext(new OrdSrvDO(), "B");
		return " select B.Id_Orsrv as id_ordsrv,B.id_pres,B.id_or,B.id_srvtp,B.sd_srvtp,B.id_srv,B.code_srv,B.Name||'('||J.Name||')' name_srv,B.Id_Medu as id_unit_med,"
			  +" D.Name as name_unit_med,B.Quan_Medu as quan_med,B.id_freq,E.Name as name_freq,B.id_route,F.Name as name_route,B.id_routedes,G.Name as name_routedes, "
			  +" B.id_boil,H.Name as name_boil,B.id_boildes,I.Name as name_boildes,B.fg_bl,C.Price_Pgku_Cur as price,C.id_orsrvmm,C.id_mm,J.Name as name_mm,J.Spec as spec_mm, "
			  +" J.Id_Sup as id_manufacture,J.Sup_Name as name_manufacture,C.Id_Pgku_Cur as id_unit_sale,D1.Name as name_unit_sale,C.Id_Pgku_Base as id_unit_base,D2.Name as name_unit_base,  "
			  +" C.quan_cur,null as quan_cur_rtn,null as quan_base,C.Factor as factor_cb,C.factor_mb,null as amt_should,null as amt_real,null as amt_rtn,B.Sortno,K.Days_Or as use_day "
			  +"  ,C.quan_num_base,C.quan_den_base,'一次' || C.quan_num_base || (case when C.quan_den_base!=1 then '/' || C.quan_den_base  else '' end)  || D2.Name  as des_uselevel,L.Name as name_hpsrvtp,B.id_dep_mp,M.name as name_dep_mp "  //打印新增行
			  +" from ci_or_srv B  "
			  +" left outer join ci_or_srv_mm C on B.Id_Orsrv = C.Id_Orsrv "
			  +" left outer join bd_mm J ON C.Id_Mm=J.Id_Mm "
			  +" left outer join bd_measdoc D on B.Id_Medu = D.Id_Measdoc "
			  +" left outer join bd_measdoc D1 on C.Id_Pgku_Cur = D1.Id_Measdoc "
			  +" left outer join bd_measdoc D2 on C.Id_Pgku_Base = D2.Id_Measdoc "
			  +" left outer join bd_freq E on B.Id_Freq = E.Id_Freq "
			  +" left outer join bd_route F on B.id_route = F.Id_Route "
			  +" left outer join bd_route_des G on B.Id_Routedes = G.Id_Routedes "
			  +" left outer join bd_boil H on B.Id_Boil = H.Id_Boil "
			  +" left outer join bd_boil_des I on B.Id_Boildes = I.Id_Boildes "
			  +" left outer join ci_order K on B.Id_Or = K.Id_Or" 
			  +" left outer join bd_udidoc L on L.Id_Udidoc=B.Id_Hpsrvtp "   //打印新增行  
			  +" left outer join bd_dep M on M.Id_Dep=B.Id_Dep_Mp "//打印新增行  
			  +" where B.Id_Pres=?   "+" and "+orgsql;
	}
	
	/**
	 * 设置查询参数
	 * @param id_pres
	 */
	public void setQryParameter(String id_pres){
		if(CiOrdUtils.isEmpty(id_pres)){sqlparam=null;return;};
		sqlparam = new SqlParam();
		sqlparam.addParam(id_pres);
	}
}
