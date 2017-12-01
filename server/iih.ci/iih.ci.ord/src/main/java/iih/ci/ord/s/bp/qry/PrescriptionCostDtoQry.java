/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: PrescriptionCostDtoQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年4月18日 上午11:23:45
 * @Package iih.ci.ord.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class PrescriptionCostDtoQry implements ITransQry {

	
	private String patid;
	private FDateTime 	dtSignB;
	private FDateTime dtSignE;
	private String code_entp;
	private String id_org;
	
	public PrescriptionCostDtoQry(String patid,
			FDateTime dtSignB, FDateTime dtSignE, String code_entp,String Id_org){
		this.patid= patid;
		this.dtSignB = dtSignB;
		this.dtSignE = dtSignE;
		this.code_entp = code_entp;
		this.id_org = Id_org;	
			
		}
	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQryParameter(java.lang.StringBuffer)
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(patid);
		rtnParam.addParam(code_entp);
		rtnParam.addParam(id_org);
		if(dtSignB != null){
			rtnParam.addParam(dtSignB);
		}
		if(dtSignE != null){
			rtnParam.addParam(dtSignE);
		}
		
	
		return rtnParam;
	}

	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQrySQLStr()
	 */
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return   getSql();
	}

	private String getSql(){
		StringBuffer sql = new StringBuffer();
		sql.append("  select ci_or_srv.id_orsrv,");
		sql.append("  ci_or_srv.id_or,");
		sql.append("  ci_or_srv.id_pres,");
		sql.append("  ci_or_srv.id_pat,");
		sql.append("  ci_or_srv.id_entp,");
		sql.append("  ci_or_srv.code_entp,");
		sql.append("  ci_or_srv.id_en,");
		sql.append("  ci_or_srv.sortno,");
		sql.append("  ci_or_srv.id_srvtp,");
		sql.append("  ci_or_srv.sd_srvtp,");
		sql.append("  ci_or_srv.id_srv,");
		sql.append("  bd_srv.name          as name_srv,");
		sql.append("  ci_or_srv.quan_medu     as quan_med,");
		sql.append("  ci_or_srv.id_medu       as id_unit_med,");
		sql.append("  ci_or_srv.id_route,");
		sql.append("  ci_or_srv.id_routedes,");
		sql.append("  ci_or_srv.id_boil,");
		sql.append("  ci_or_srv.id_boildes,");
		sql.append("  ci_or_srv.id_freq,");
		sql.append("  ci_or_srv.id_org_srv,");
		sql.append("  ci_or_srv.id_dep_srv,");
		sql.append("  ci_or_srv.id_wg_or      as id_wg_srv,");
		sql.append("  ci_or_srv.id_emp_srv,");
		sql.append("  DOC.name name_emp_srv,");
		sql.append("  ci_or_srv.id_org_mp,");
		sql.append("  ci_or_srv.id_dep_mp,");
		sql.append("  ci_or_srv.id_su_mp,");
		sql.append("  ci_or_srv.sd_su_mp,");
		sql.append("  ci_or_srv.id_su_bl,");
		sql.append("  ci_or_srv.sd_su_bl,");
		sql.append("  ci_or_srv.dt_last_bl    as dt_bl_last,");
		sql.append("  ci_or_srv.fg_mm,");
		sql.append("  ci_or_srv.fg_indic,");
		sql.append("  ci_or_srv.fg_propc,");
		sql.append("  ci_or_srv.fg_self,");
		sql.append("  ci_or_srv.fg_selfpay,");
		sql.append("  ci_or_srv_mm.id_orsrvmm,");
		sql.append("  ci_or_srv_mm.id_mm,");
		sql.append("  ci_or_srv_mm.quan_cur,");
		sql.append("  ci_or_srv_mm.quan_bed_medu,");
		sql.append("  ci_or_srv_mm.id_pgku_cur   as id_unit_cur,");
		sql.append("  ci_or_srv_mm.id_pgku_base  as id_unit_base,");
		sql.append("  ci_or_srv_mm.factor        as factor_cb,");
		sql.append("  ci_or_srv_mm.code_mm,");
		sql.append("  ci_or_srv_mm.id_mmtp,");
		sql.append("  ci_or_srv_mm.code_mm,");
		sql.append("  bd_srv.code          as code_srv,");
		sql.append("  en_ent.id_pripat     as id_pripat,");
		sql.append("  ci_or_srv_mm.name_mm,");
		sql.append("  ci_order.id_org,ci_order.id_grp,");
		sql.append("  ci_order.name_or as des,");
		sql.append("  ci_order.fg_bb,");
		sql.append("  ci_order.no_bb,");
		sql.append("  ci_order.dt_sign, "); //这是新增的
		sql.append("   pres.name as presrption_name, "); 
		sql.append("   udi.name  prestp_name,");
		sql.append("   ci_or_srv.id_hp,ci_or_srv.id_hpsrvtp,ci_or_srv.sd_hpsrvtp ,ci_or_srv.id_dep_wh, ");
		sql.append("   bdmm.apprno,  ");
		sql.append("   dep.name  name_dep_srv, ");
		sql.append("   pres.code  , ci_order.sv ci_sv,");
		sql.append("   depmp.name  name_dep_mp, ");
		sql.append("   ci_or_srv.fg_specill, ");
		sql.append("   ci_or_srv.fg_extdispense, ");
		sql.append("   ci_or_srv.id_srvca, ");
		sql.append("   ci_pres.code   presno, ");
		sql.append("   '01'  Prntype, ci_pres.sd_prestpword, ");
		//手动划价 需要查出 eu_blmd,pri,pri_std,pri_ratio by yzh 2017-10-24 09:57:03
		sql.append("   ci_or_srv.eu_blmd,ci_or_srv.pri,ci_or_srv.pri_std,ci_or_srv.pri_ratio, ");
		sql.append("  en_ent_hp.id_hpkind, ");
		sql.append("   ci_or_srv_hp.indicitemid");
		sql.append("  from ci_order ci_order");
		sql.append("  inner join ci_or_srv ci_or_srv");
		sql.append("  on ci_order.id_or=ci_or_srv.id_or ");
		sql.append("  left join ci_or_srv_mm ci_or_srv_mm ");
		sql.append("  on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv ");
		sql.append("  left outer join bd_srv bd_srv");
		sql.append("  on bd_srv.id_srv = ci_or_srv.id_srv ");
		sql.append("  inner join en_ent en_ent ");
		sql.append("  on ci_or_srv.id_en = en_ent.id_ent ");
		sql.append("  INNER JOIN BD_PSNDOC DOC ON DOC.ID_PSNDOC=ci_or_srv.id_emp_srv");
		sql.append(" left join en_ent_hp on en_ent_hp.id_ent = en_ent.id_ent and en_ent_hp.fg_maj='Y'");
		sql.append("    left join ci_pres pres on pres.id_pres = ci_or_srv.id_pres  ");
		sql.append("   left join bd_udidoc udi  on udi.id_udidoc = pres.id_prestp  ");
		sql.append("   left outer join  bd_mm  bdmm  on  bdmm.id_mm = ci_or_srv_mm.id_mm  ");
		sql.append("   left join bd_dep  dep on dep.id_dep = ci_or_srv.id_dep_srv ");
		sql.append("   left join bd_dep  depmp on depmp.id_dep = ci_or_srv.id_dep_mp  ");
		sql.append("   left join ci_pres  on ci_pres.id_pres = ci_or_srv.id_pres  ");	
		sql.append("   left join ci_or_srv_hp ci_or_srv_hp  on ci_or_srv_hp.id_orsrv = ci_or_srv.id_orsrv  ");		 
		sql.append("  where en_ent.fg_canc='N' and ci_or_srv.sd_su_bl='0' and ci_order.sd_su_or='10' and ci_or_srv.ds = 0 and ci_order.ds = 0   and ci_or_srv.sd_srvtp like '01%' and  ci_or_srv.fg_self ='N'  and ci_or_srv.fg_bl ='Y'  ");
		sql.append("  and  ci_order.id_pat=?  and ci_order.code_entp= ? and  ci_order.id_org = ? ");
		 if(dtSignB != null){
			 sql.append( "and ci_order.dt_sign>=?" );
		 }
		if(dtSignE != null){
			sql.append( " and ci_order.dt_sign<= ?") ;
		 }
		sql.append( "  order by ci_pres.id_pres,ci_order.dt_sign desc ");
        return sql.toString();
	}
}


// sql
/*select p.id_orsrv, 
                     p.id_or,  
             p.id_pres,  
             p.id_pat,  
             p.id_entp,  
             p.code_entp,  
             p.id_en,  
             p.sortno,  
             p.id_srvtp,  
             p.sd_srvtp,  
             p.id_srv,  
             s.name          as name_srv,  
             p.quan_medu     as quan_med,  
             p.id_medu       as id_unit_med,  
             p.id_route,  
             p.id_routedes,  
             p.id_boil,  
             p.id_boildes,  
             p.id_freq,  
             p.id_org_srv,  
             p.id_dep_srv,  
             p.id_wg_or      as id_wg_srv,  
             p.id_emp_srv,  
             p.id_org_mp,  
             p.id_dep_mp,  
             p.id_su_mp,  
             p.sd_su_mp,  
             p.id_su_bl,  
             p.sd_su_bl,  
             p.dt_last_bl    as dt_bl_last,  
             p.fg_mm,  
             p.fg_indic,  
             p.fg_propc,  
             p.fg_self,  
             q.id_orsrvmm,  
             q.id_mm,  
             q.quan_cur,  
             q.quan_bed_medu,  
             q.id_pgku_cur   as id_unit_cur,  
             q.id_pgku_base  as id_unit_base,  
             q.factor        as factor_cb,  
             q.code_mm,  
             q.id_mmtp,  
             q.code_mm,  
             s.code          as code_srv,  
             t.id_pripat     as id_pripat,  
             q.name_mm,  
             tt.id_org,tt.id_grp,  
             tt.name_or as des,  
             tt.fg_bb,  
             tt.no_bb,  
             tt.dt_sign,   
             --- //这是新增的
              pres.name as presrption_name,    
              udi.name  prestp_name,  
              p.id_hp,p.id_hpsrvtp,p.sd_hpsrvtp ,p.id_dep_wh,   
              bdmm.apprno,    
              dep.name  name_dep_srv,   
              pres.code  , p.sv ci_sv,  
                      depmp.name  name_dep_mp ,  
              p.fg_specill,   
              p.fg_extdispense,   
             en_ent_hp.id_hpkind   
             from ci_order tt  
             inner join ci_or_srv p  
             on tt.id_or=p.id_or   
             left join ci_or_srv_mm q   
             on p.id_orsrv = q.id_orsrv   
             left outer join bd_srv s   
             on s.id_srv = p.id_srv   
             inner join en_ent t   
             on p.id_en = t.id_ent   
            left outer join en_ent_hp on en_ent_hp.id_ent = t.id_ent   
               left join ci_pres pres on pres.id_pres = p.id_pres    
              left join bd_udidoc udi  on udi.id_udidoc = pres.id_prestp    
              left outer join  bd_mm  bdmm  on  bdmm.id_mm = q.id_mm    
              left join bd_dep  dep on dep.id_dep = p.id_dep_srv   
              left join bd_dep  depmp on depmp.id_dep = p.id_dep_mp    
*/