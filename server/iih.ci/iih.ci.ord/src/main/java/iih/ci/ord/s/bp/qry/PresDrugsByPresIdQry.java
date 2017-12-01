package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class PresDrugsByPresIdQry implements ITransQry {
	
	private String _presid;
	private String _euStatusMp; //发药状态
	public PresDrugsByPresIdQry(String presid,String euStatusMp){
		_presid=presid;
		_euStatusMp = euStatusMp;
		
	}
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(_presid);

		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		//String ret=getQrySQLStr_();
		return getQrySQLStr_();
	}
	
	private String getQrySQLStr_(){
		return "   select t.id_orsrv as id_ordsrv,t.id_dgoepdt,t.id_pres,t.id_or,t.id_srvtp,t.sd_srvtp,t.id_srv, "
			 + " q.code as code_srv,q.name as name_srv,t.id_unit_med,r.name as name_unit_med, "
			 + " t.quan_medu as quan_med,t.id_freq,s.name as name_freq,t.id_route,u.name as name_route, "
			 + " id_routedes,v.name as name_routedes,t.id_boil,w.name as name_boil, "
			 + " id_boildes,x.name as name_boildes,p.price_pgku_cur as price,id_orsrvmm, "
			 + " p.id_mm,y.name as name_mm,y.spec as spec_mm,y.id_sup as id_manufacture,z.name as name_manufacture, "
			 + " p.id_pgku_base as id_unit_sale,m.name as name_unit_sale,p.id_pgku_base as id_unit_base,n.name as name_unit_base, "
			 + " t.quan_bk as quan_cur_rtn,p.quan_base,y.factor_sb as factor_cb, "
			 + " y.factor_mb as factor_mb,0 as amt_should,rownum as sortno "
			 + " ,232 as amt_real, 232 as amt_should,(t.quan - nvl(t.quan_mp,0)) as quan_cur,1 as quan_disp,t.quan_or as quan_pair,1 as quan_cur_rtn,1 as quan_withdraw"
			 + " from mp_dg_oep_dt t "
			 + " left outer join ci_or_srv_mm p on t.id_orsrv=p.id_orsrv "
			 + " inner join bd_srv q on t.id_srv=q.id_srv  "
			 + " left outer join bd_measdoc r on r.id_measdoc=t.id_unit_med "
			 + " left outer join bd_freq s on s.id_freq=t.id_freq "
			 + " left outer join bd_route u on u.id_route=t.id_route "
			 + " left outer join bd_route_des v on v.id_routedes=t.id_routedes "
			 + " left outer join bd_boil w on w.id_boil=t.id_boil "
			 + " left outer join bd_boil_des x on x.id_boildes=t.id_boildes   "
			 + " left outer join bd_mm y on y.id_mm=p.id_mm "
			 + " left outer join  bd_sup z on y.id_sup=z.id_sup "
			 + " left outer join bd_measdoc m on m.id_measdoc=p.id_pgku_cur "
			 + " left outer join bd_measdoc n on n.id_measdoc=p.id_pgku_base "
			 + " where t.id_pres=? "+getStatusMpSQLStr();

		
	}
	
	private String getStatusMpSQLStr(){
		if("back".equals(_euStatusMp)){
			return " and t.eu_su_mp>0 and t.eu_su_mp<=8 ";
		}else{
			return " and t.eu_su_mp<2 ";
		}
	}
}
