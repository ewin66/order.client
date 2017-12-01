package iih.ci.ord.s.bp.qry;

import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 签署为计费列表
 * @author li_zheng
 *
 */
public class UnchargeOrderSrvQry implements ITransQry{
	
			private String patid;
			private FDateTime 	dtSignB;
			private FDateTime dtSignE;
			private String code_entp;
			private String id_org;
			
			public String id_or ;
			
			public UnchargeOrderSrvQry(String id_or){
				this.id_or = id_or;
				
			}

			public UnchargeOrderSrvQry(){		
				
			}

		public UnchargeOrderSrvQry(String patid,
				FDateTime dtSignB, FDateTime dtSignE, String code_entp,String Id_org){
			this.patid= patid;
			this.dtSignB = dtSignB;
			this.dtSignE = dtSignE;
			this.code_entp = code_entp;
			this.id_org = Id_org;	
				
			}
		
		
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(id_or);

//		rtnParam.addParam(patid);
//		rtnParam.addParam(code_entp);
//		rtnParam.addParam(id_org);
//		if(dtSignB != null){
//			rtnParam.addParam(dtSignB);
//		}
//		if(dtSignE != null){
//			rtnParam.addParam(dtSignE);
//		}
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
//		String sql = getSql();
//		if(dtSignB != null){
//			sql += "and ciorder.dt_sign>=?" ;
//		}
//		if(dtSignE != null){
//			sql +=" and ciorder.dt_sign<= ?";
//		}
//		return sql;
		
		return  getSql();
	}

	 private String getSql(){
		 
		 return "  select  p.id_orsrv,p.id_or,p.id_pres,p.id_pat,p.id_entp,p.code_entp,p.id_en,p.sortno, "
		        +"  p.id_srvtp,p.sd_srvtp,p.id_srv,s.name as name_srv,p.quan_medu as quan_med,p.id_medu as id_unit_med,p.id_route, "
		        +"  p.id_routedes,p.id_boil,p.id_boildes,p.id_freq,p.id_org_srv,p.id_dep_srv, "
		        +"  p.id_wg_or as id_wg_srv,p.id_emp_srv,p.id_org_mp,p.id_dep_mp,p.id_su_mp,p.sd_su_mp, "
		        +"  p.id_su_bl,p.sd_su_bl,p.dt_last_bl as dt_bl_last ,p.fg_mm,p.fg_indic,p.fg_propc,p.fg_self, "
		        +"  q.id_orsrvmm,q.id_mm,q.quan_cur, "
		        +"  q.quan_bed_medu, "
		        +"  q.id_pgku_cur as id_unit_cur, "
		        +"  q.id_pgku_base as id_unit_base,q.factor as factor_cb, "
		        +"  q.code_mm,q.id_mmtp,q.code_mm,s.code as code_srv , "
		        +"  t.id_pripat as id_pripat,q.name_mm ,"
		        +"  p.id_dep_wh ,p.id_hp,p.id_hpsrvtp,p.sd_hpsrvtp "
		        +"  from ci_or_srv p  "
		        +"  left join ci_or_srv_mm q on p.id_orsrv=q.id_orsrv "
		        +"  left outer join bd_srv s on s.id_srv=p.id_srv "
		        +"   inner   join en_ent t  on p.id_en=t.id_ent  "
		        +"  where p.sd_su_bl ='0' and  p.id_or=?";
   
	 }
	 
//以上 sql	 
/*	 select  p.id_orsrv,p.id_or,p.id_pres,p.id_pat,p.id_entp,p.code_entp,p.id_en,p.sortno,
     p.id_srvtp,p.sd_srvtp,p.id_srv,s.name as name_srv,p.quan_medu as quan_med,p.id_medu as id_unit_med,p.id_route,
     p.id_routedes,p.id_boil,p.id_boildes,p.id_freq,p.id_org_srv,p.id_dep_srv,
     p.id_wg_or as id_wg_srv,p.id_emp_srv,p.id_org_mp,p.id_dep_mp,p.id_su_mp,p.sd_su_mp,
     p.id_su_bl,p.sd_su_bl,p.dt_last_bl,p.fg_mm,p.fg_indic,p.fg_propc,p.fg_self,
     q.id_orsrvmm,q.id_mm,q.quan_cur,
     q.quan_bed_medu,
     q.id_pgku_cur as id_unit_cur,
     q.id_pgku_base as id_unit_base,q.factor as factor_cb,
     q.code_mm,q.id_mmtp,q.code_mm,s.code as code_srv ,
     p.pri as id_pripat
     from ci_or_srv p 
     inner join ci_or_srv_mm q on p.id_orsrv=q.id_orsrv
     left outer join bd_srv s on s.id_srv=p.id_srv
  	 where p.id_or=?*/
	 
	 
// 待修改  修改成一条 sql 	 
/*	 "  select  p.id_orsrv,p.id_or,p.id_pres,p.id_pat,p.id_entp,p.code_entp,p.id_en,p.sortno, "
     +"  p.id_srvtp,p.sd_srvtp,p.id_srv,s.name as name_srv,p.quan_medu as quan_med,p.id_medu as id_unit_med,p.id_route, "
     +"  p.id_routedes,p.id_boil,p.id_boildes,p.id_freq,p.id_org_srv,p.id_dep_srv, "
     +"  p.id_wg_or as id_wg_srv,p.id_emp_srv,p.id_org_mp,p.id_dep_mp,p.id_su_mp,p.sd_su_mp, "
     +"  p.id_su_bl,p.sd_su_bl,p.dt_last_bl as dt_bl_last ,p.fg_mm,p.fg_indic,p.fg_propc,p.fg_self, "
     +"  q.id_orsrvmm,q.id_mm,q.quan_cur, "
     +"  q.quan_bed_medu, "
     +"  q.id_pgku_cur as id_unit_cur, "
     +"  q.id_pgku_base as id_unit_base,q.factor as factor_cb, "
     +"  q.code_mm,q.id_mmtp,q.code_mm,s.code as code_srv , "
     +"  t.id_pripat as id_pripat,q.name_mm "
     +"  from   ci_order ciorder "
     +"  left outer join  ci_or_srv p on p.id_or = ciorder.id_or "
     +"  left outer join ci_or_srv_mm q   on p.id_orsrv = q.id_orsrv "
     +"  left outer join bd_srv s  on s.id_srv = p.id_srv  "
     +"  inner   join en_ent t   on ciorder.id_en=t.id_ent  "
     +"  where ciorder.sd_su_bl='0' and ciorder.sd_su_or='10' "
     +"  and  ciorder.id_pat=? " 
     +"  and ciorder.code_entp= ? and  ciorder.id_org = ?"; */
}
