package iih.ci.ord.s.bp;



import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;

/**
 * 获得药品、检查、检验、诊疗项目打印单数据 
 *
 */
public class GetPrintChargesDetailsBP {
	public PrescriptionConstBaseDto exe(String[] print_nos,String id_ent) throws BizException{
		PrescriptionConstBaseDto baseDto = new PrescriptionConstBaseDto();
		if(print_nos.length<=0)return baseDto;
		String printnos="";
		for(String no : print_nos){
			printnos+="'"+no+"',";
		}
		printnos=printnos.substring(0, printnos.lastIndexOf(","));
		//药品
		PrescriptionCostDto[] pres=getPresMsg(printnos,id_ent);
		//检验
		PrescriptionCostDto[] lis=getLisMsg(printnos,id_ent);
		//检查
		PrescriptionCostDto[] ris=getRisMsg(printnos,id_ent);
		//诊疗收费清单
		PrescriptionCostDto[] treat=getTreatConstMsg(printnos,id_ent);
		FArrayList prescrptionObsAndLabList = new FArrayList();
		if(pres!=null && pres.length>0){
			prescrptionObsAndLabList=setSrvMsg(prescrptionObsAndLabList,pres);
		}
		if(lis!=null &&lis.length>0){
			prescrptionObsAndLabList=setSrvMsg(prescrptionObsAndLabList,lis);
		}
		if(ris!=null &&ris.length>0){
			prescrptionObsAndLabList=setSrvMsg(prescrptionObsAndLabList,ris);
		}
		if(treat!=null &&treat.length>0){
			prescrptionObsAndLabList=setSrvMsg(prescrptionObsAndLabList,treat);
		}
		if(prescrptionObsAndLabList!=null &&prescrptionObsAndLabList.size()>0){
			baseDto.setPrescriptionCostDto(prescrptionObsAndLabList);
		}
		return baseDto;
	}
	private FArrayList setSrvMsg(FArrayList list,PrescriptionCostDto[] srvdo){
		for(PrescriptionCostDto src:srvdo){
			list.add(src);
		}
		return list;
	}

	/**
	 * 获取药品打印数据
	 * @param print_nos 打印单号
	 * @param id_ent 就诊id
	 * @return
	 * @throws BizException
	 */
	private PrescriptionCostDto[] getPresMsg(String print_nos,String id_ent) throws BizException{
		String sql = getDrugPrescriptionSql(print_nos,id_ent);
		List<PrescriptionCostDto>  list  = (List<PrescriptionCostDto>) new DAFacade().execQuery(sql,new BeanListHandler(PrescriptionCostDto.class));
		if(list != null && list.size() >0){
			return list.toArray(new PrescriptionCostDto[list.size()]); 
		}
		return null;

	}
	
	/**
	 * 获取检验打印数据
	 * @param print_nos 打印单号
	 * @param id_ent 就诊id
	 * @return
	 * @throws BizException
	 */
	private PrescriptionCostDto[] getRisMsg(String print_nos,String id_ent) throws BizException{
		String sql = getRisPrescriptionSql(print_nos,id_ent);
		List<PrescriptionCostDto>  list  = (List<PrescriptionCostDto>) new DAFacade().execQuery(sql,new BeanListHandler(PrescriptionCostDto.class));
		if(list != null && list.size() >0){
			return list.toArray(new PrescriptionCostDto[list.size()]); 
		}
		return null;

	}
	
	/**
	 * 获取检验打印数据
	 * @param print_nos 打印单号
	 * @param id_ent 就诊id
	 * @return
	 * @throws BizException
	 */
	private PrescriptionCostDto[] getLisMsg(String print_nos,String id_ent) throws BizException{
		String sql = getLisPrescriptionSql(print_nos,id_ent);
		List<PrescriptionCostDto>  list  = (List<PrescriptionCostDto>) new DAFacade().execQuery(sql,new BeanListHandler(PrescriptionCostDto.class));
		if(list != null && list.size() >0){
			return list.toArray(new PrescriptionCostDto[list.size()]); 
		}
		return null;

	}
	
	/**
	 * 获取诊疗收费清单数据
	 * @param print_nos 打印单号
	 * @param id_ent 就诊ID
	 * @return
	 * @throws BizException
	 */
	private PrescriptionCostDto[] getTreatConstMsg(String print_nos,String id_ent) throws BizException{
		String sql = getTreatPrescriptionSql(print_nos,id_ent);
		List<PrescriptionCostDto>  list  = (List<PrescriptionCostDto>) new DAFacade().execQuery(sql,new BeanListHandler(PrescriptionCostDto.class));
		if(list != null && list.size() >0){
			return list.toArray(new PrescriptionCostDto[list.size()]); 
		}
		return null;

	}

	/**
	 * 获取药品打印数据查询语句
	 * @param print_nos 打印单号
	 * @param id_ent 就诊id
	 * @return
	 */
	private String getDrugPrescriptionSql(String print_nos,String id_ent){
		StringBuffer sb = new StringBuffer();
		sb.append(" select p.id_orsrv,  p.id_or, p.id_pres, "); 
		sb.append("p.id_pat, p.id_entp, p.code_entp,  p.id_en, "); 
		sb.append("p.sortno, p.id_srvtp,  p.sd_srvtp, "); 
		sb.append(" p.id_srv,  s.name  as name_srv,  ");
		sb.append(" p.quan_medu  as quan_med,  ");
		sb.append(" p.id_medu  as id_unit_med, "); 
		sb.append(" p.id_route,  p.id_routedes,");  
		sb.append(" p.id_boil, p.id_boildes,  ");
		sb.append(" p.id_freq,   p.id_org_srv, "); 
		sb.append(" p.id_dep_srv,   p.id_wg_or   as id_wg_srv, "); 
		sb.append(" p.id_emp_srv, p.id_org_mp,  ");
		sb.append(" p.id_dep_mp,   p.id_su_mp, "); 
		sb.append(" p.sd_su_mp,   p.id_su_bl,  ");
		sb.append(" p.sd_su_bl,  p.dt_last_bl  as dt_bl_last, "); 
		sb.append(" p.fg_mm,    p.fg_indic,   p.fg_propc,  ");
		sb.append(" p.fg_self,    q.id_orsrvmm,   ");
		sb.append(" q.id_mm,     q.quan_cur,  ");
		sb.append(" q.quan_bed_medu,  q.id_pgku_cur   as id_unit_cur,   ");
		sb.append(" q.id_pgku_base  as id_unit_base,   ");
		sb.append(" q.factor        as factor_cb,  "); 
		sb.append(" q.code_mm,     q.id_mmtp,   ");
		sb.append(" q.code_mm,  s.code  as code_srv,   ");
		sb.append(" t.id_pripat     as id_pripat,   ");
		sb.append(" q.name_mm,   tt.id_org,tt.id_grp,  "); 
		sb.append(" tt.name_or as des,   ");
		sb.append(" tt.fg_bb,    tt.no_bb,  "); 
		sb.append(" tt.dt_sign,    ");
		sb.append(" pres.name as presrption_name,    "); 
		sb.append(" udi.name  prestp_name,   ");
		sb.append(" p.id_hp,p.id_hpsrvtp,p.sd_hpsrvtp ,p.id_dep_wh,  ");  
		sb.append(" bdmm.apprno,  dep.name  name_dep_srv,   "); 
		sb.append(" pres.code,pres.code as presno, tt.sv ci_sv,   ");
		sb.append(" depmp.name  name_dep_mp,    ");
		sb.append(" p.fg_specill,    ");
		sb.append(" p.fg_extdispense,    ");
		sb.append(" en_ent_hp.id_hpkind,    ");
		sb.append(" '01' prntype    ");
		sb.append(" from ci_order tt   ");
		sb.append(" inner join ci_or_srv p   ");
		sb.append(" on tt.id_or=p.id_or    ");
		sb.append(" left join ci_or_srv_mm q    ");
		sb.append(" on p.id_orsrv = q.id_orsrv   "); 
		sb.append(" left outer join bd_srv s    ");
		sb.append(" on s.id_srv = p.id_srv   "); 
		sb.append(" inner join en_ent t    ");
		sb.append(" on p.id_en = t.id_ent    ");
		sb.append(" left outer join en_ent_hp on en_ent_hp.id_ent = t.id_ent  ");  
		sb.append(" left join ci_pres pres on pres.id_pres = p.id_pres   ");  
		sb.append(" left join bd_udidoc udi  on udi.id_udidoc = pres.id_prestp   ");  
		sb.append("  left outer join  bd_mm  bdmm  on  bdmm.id_mm = q.id_mm   ");  
		sb.append(" left join bd_dep  dep on dep.id_dep = p.id_dep_srv    ");
		sb.append(" left join bd_dep  depmp on depmp.id_dep = p.id_dep_mp   ");  
		sb.append(" where  tt.sd_su_or='10'   and p.sd_srvtp like '01%' and  p.fg_self ='N'  and p.fg_bl ='Y'  "); 

		if(print_nos != null && print_nos.length() >0){
			sb.append(" and (pres.id_pres in(");
			sb.append(print_nos);
			sb.append(") or pres.code in(");
			sb.append(print_nos);
			sb.append("))");
		}
		if(id_ent != null && id_ent.length() >0){
			sb.append(" and pres.id_en ='");
			sb.append(id_ent);
			sb.append("'");
		}
		return sb.toString();
	}

	/**
	 * 获取检验打印数据查询语句
	 * @param print_nos 打印单号
	 * @param id_ent 就诊id
	 * @return
	 */
	private String getRisPrescriptionSql(String print_nos,String id_ent){
		StringBuffer sb = new StringBuffer();
		sb.append(" select p.id_orsrv, ");  
		sb.append(" p.id_or,tt.id_or  id_pres, ");  
		sb.append(" p.id_pat,p.id_entp,   ");
		sb.append(" p.code_entp,p.id_en,   ");
		sb.append(" p.sortno,p.id_srvtp,   ");
		sb.append(" p.sd_srvtp,p.id_srv,   ");
		sb.append(" s.name          as name_srv, ");  
		sb.append(" p.quan_total_medu     as quan_med,  ");  
		sb.append(" p.id_medu       as id_unit_med,");  
		sb.append(" p.id_route,p.id_routedes,  "); 
		sb.append(" p.id_boil,p.id_boildes,   ");
		sb.append(" p.id_freq,p.id_org_srv,   ");
		sb.append(" p.id_dep_srv,p.id_wg_or      as id_wg_srv,  "); 
		sb.append(" p.id_emp_srv,p.id_org_mp,   ");
		sb.append(" p.id_dep_mp,p.id_su_mp,   ");
		sb.append(" p.sd_su_mp,p.id_su_bl,   ");
		sb.append(" p.sd_su_bl,p.dt_last_bl    as dt_bl_last, "); 
		sb.append(" p.fg_mm,p.fg_indic,p.fg_propc,   ");
		sb.append(" case p.fg_selfpay  when 'Y' then 'N' when 'N' then 'Y' end as fg_self,q.id_orsrvmm, ");  
		sb.append(" q.id_mm,q.quan_cur,  "); 
		sb.append(" q.quan_bed_medu,   ");
		sb.append(" q.id_pgku_cur   as id_unit_cur, ");   
		sb.append(" q.id_pgku_base  as id_unit_base,  "); 
		sb.append(" q.factor        as factor_cb, ");  
		sb.append(" q.code_mm,q.id_mmtp,q.code_mm, ");  
		sb.append(" s.code          as code_srv,   ");
		sb.append(" t.id_pripat     as id_pripat,  "); 
		sb.append(" q.name_mm,tt.id_org,tt.id_grp, ");  
		sb.append(" tt.name_or as des,tt.fg_bb,   ");
		sb.append(" tt.no_bb,tt.dt_sign,      ");
		sb.append(" p.name as presrption_name,   ");
		sb.append(" p.fg_bl,  ");
		sb.append(" bdudidoc.name  prestp_name, ");  
		sb.append(" p.id_dep_wh,    ");
		sb.append(" p.id_hp,p.ID_HPSRVTP,p.SD_HPSRVTP ,  ");
		sb.append(" dep.name  name_dep_srv,    ");
		sb.append(" tt.applyno  code, tt.sv ci_sv, "); 
		sb.append(" depmp.name  name_dep_mp ,  ");
		sb.append(" p.fg_specill,   ");
		sb.append(" p.fg_extdispense,   ");
		sb.append(" en_ent_hp.id_hpkind,apobs.code_app as presno ,");
		sb.append(" '02' prntype    ");
		sb.append(" from ci_order tt    ");
		sb.append(" inner join ci_or_srv p    ");
		sb.append(" on tt.id_or=p.id_or   ");
		sb.append(" left join ci_or_srv_mm q   ");
		sb.append(" on p.id_orsrv = q.id_orsrv   ");
		sb.append(" left outer join bd_srv s   ");
		sb.append(" on s.id_srv = p.id_srv   ");
		sb.append(" inner join en_ent t    ");
		sb.append(" on p.id_en = t.id_ent   ");
		sb.append(" left outer join en_ent_hp on en_ent_hp.id_ent = t.id_ent ");  
		sb.append(" left outer join bd_udidoc bdudidoc on bdudidoc.id_udidoc =p.id_srvtp  "); 
		sb.append(" left join bd_dep  dep on dep.id_dep = p.id_dep_srv   ");
		sb.append(" left join bd_dep  depmp on depmp.id_dep = p.id_dep_mp   "); 
		sb.append(" left join ci_app_ris apobs on apobs.id_or=tt.id_or   "); 
		sb.append(" where p.fg_bl = 'Y'   ");
		sb.append(" and tt.sd_srvtp like '02%'  ");
		if(print_nos != null && print_nos.length() > 0){	
			sb.append(" and apobs.code_app in (");
			sb.append(print_nos);
			sb.append(")");

		}
		if(id_ent != null && id_ent.length() >0){
			sb.append(" and apobs.id_en ='");
			sb.append(id_ent);
			sb.append("'");
		}
		return sb.toString();
	}	

	/**
	 * 获取检验打印数据查询语句
	 * @param print_nos 打印单号
	 * @param id_ent 就诊id
	 * @return
	 */
	private String getLisPrescriptionSql(String print_nos,String id_ent){
		StringBuffer sb = new StringBuffer();
		sb.append(" select p.id_orsrv, ");  
		sb.append(" p.id_or,tt.id_or  id_pres, ");  
		sb.append(" p.id_pat,p.id_entp,   ");
		sb.append(" p.code_entp,p.id_en,   ");
		sb.append(" p.sortno,p.id_srvtp,   ");
		sb.append(" p.sd_srvtp,p.id_srv,   ");
		sb.append(" s.name          as name_srv, ");  
		sb.append(" p.quan_total_medu     as quan_med,  ");  
		sb.append(" p.id_medu       as id_unit_med,");  
		sb.append(" p.id_route,p.id_routedes,  "); 
		sb.append(" p.id_boil,p.id_boildes,   ");
		sb.append(" p.id_freq,p.id_org_srv,   ");
		sb.append(" p.id_dep_srv,p.id_wg_or      as id_wg_srv,  "); 
		sb.append(" p.id_emp_srv,p.id_org_mp,   ");
		sb.append(" p.id_dep_mp,p.id_su_mp,   ");
		sb.append(" p.sd_su_mp,p.id_su_bl,   ");
		sb.append(" p.sd_su_bl,p.dt_last_bl    as dt_bl_last, "); 
		sb.append(" p.fg_mm,p.fg_indic,p.fg_propc,   ");
		sb.append(" case p.fg_selfpay  when 'Y' then 'N' when 'N' then 'Y' end as fg_self,q.id_orsrvmm, ");  
		sb.append(" q.id_mm,q.quan_cur,  "); 
		sb.append(" q.quan_bed_medu,   ");
		sb.append(" q.id_pgku_cur   as id_unit_cur, ");   
		sb.append(" q.id_pgku_base  as id_unit_base,  "); 
		sb.append(" q.factor        as factor_cb, ");  
		sb.append(" q.code_mm,q.id_mmtp,q.code_mm, ");  
		sb.append(" s.code          as code_srv,   ");
		sb.append(" t.id_pripat     as id_pripat,  "); 
		sb.append(" q.name_mm,tt.id_org,tt.id_grp, ");  
		sb.append(" tt.name_or as des,tt.fg_bb,   ");
		sb.append(" tt.no_bb,tt.dt_sign,      ");
		sb.append(" p.name as presrption_name,   ");
		sb.append(" p.fg_bl,  ");
		sb.append(" bdudidoc.name  prestp_name, ");  
		sb.append(" p.id_dep_wh,    ");
		sb.append(" p.id_hp,p.ID_HPSRVTP,p.SD_HPSRVTP ,  ");
		sb.append(" dep.name  name_dep_srv,    ");
		sb.append(" tt.applyno  code, tt.sv ci_sv, "); 
		sb.append(" depmp.name  name_dep_mp ,  ");
		sb.append(" p.fg_specill,   ");
		sb.append(" p.fg_extdispense,   ");
		sb.append(" en_ent_hp.id_hpkind,lis.code_app as presno ,  ");
		sb.append(" '03' prntype    ");
		sb.append(" from ci_app_lis lis    ");
		sb.append(" left join ci_app_lis_or lisor on lisor.id_ciapplissheet=lis.id_ciapplissheet");
		sb.append(" left join ci_order tt on tt.id_or=lisor.id_or");
		sb.append(" inner join ci_or_srv p    ");
		sb.append(" on tt.id_or=p.id_or   ");
		sb.append(" left join ci_or_srv_mm q   ");
		sb.append(" on p.id_orsrv = q.id_orsrv   ");
		sb.append(" left outer join bd_srv s   ");
		sb.append(" on s.id_srv = p.id_srv   ");
		sb.append(" inner join en_ent t    ");
		sb.append(" on p.id_en = t.id_ent   ");
		sb.append(" left outer join en_ent_hp on en_ent_hp.id_ent = t.id_ent ");  
		sb.append(" left outer join bd_udidoc bdudidoc on bdudidoc.id_udidoc =p.id_srvtp  "); 
		sb.append(" left join bd_dep  dep on dep.id_dep = p.id_dep_srv   ");
		sb.append(" left join bd_dep  depmp on depmp.id_dep = p.id_dep_mp   "); 
		sb.append(" where p.fg_bl = 'Y'   ");
		sb.append(" and tt.sd_srvtp like '03%'  ");
		if(print_nos != null && print_nos.length() > 0){	
			sb.append(" and lis.code_app in (");
			sb.append(print_nos);
			sb.append(")");
		}
		if(id_ent != null && id_ent.length() >0){
			sb.append(" and lis.id_en ='");
			sb.append(id_ent);
			sb.append("'");
		}
		return sb.toString();
	}

	/**
	 * 获取诊疗收费清单数据查询语句
	 * @param print_nos 打印单号
	 * @param id_ent 就诊ID
	 * @return
	 */
	private String getTreatPrescriptionSql(String print_nos,String id_ent){
		StringBuffer sb = new StringBuffer();
		sb.append(" select p.id_orsrv, ");  
		sb.append(" p.id_or,tt.id_or  id_pres, ");  
		sb.append(" p.id_pat,p.id_entp,   ");
		sb.append(" p.code_entp,p.id_en,   ");
		sb.append(" p.sortno,p.id_srvtp,   ");
		sb.append(" p.sd_srvtp,p.id_srv,   ");
		sb.append(" s.name          as name_srv, ");  
		sb.append(" p.quan_total_medu     as quan_med,  ");  
		sb.append(" p.id_medu       as id_unit_med,");  
		sb.append(" p.id_route,p.id_routedes,  "); 
		sb.append(" p.id_boil,p.id_boildes,   ");
		sb.append(" p.id_freq,p.id_org_srv,   ");
		sb.append(" p.id_dep_srv,p.id_wg_or      as id_wg_srv,  "); 
		sb.append(" p.id_emp_srv,p.id_org_mp,   ");
		sb.append(" p.id_dep_mp,p.id_su_mp,   ");
		sb.append(" p.sd_su_mp,p.id_su_bl,   ");
		sb.append(" p.sd_su_bl,p.dt_last_bl    as dt_bl_last, "); 
		sb.append(" p.fg_mm,p.fg_indic,p.fg_propc,   ");
		sb.append(" case p.fg_selfpay  when 'Y' then 'N' when 'N' then 'Y' end as fg_self,q.id_orsrvmm, ");  
		sb.append(" q.id_mm,q.quan_cur,  "); 
		sb.append(" q.quan_bed_medu,   ");
		sb.append(" q.id_pgku_cur   as id_unit_cur, ");   
		sb.append(" q.id_pgku_base  as id_unit_base,  "); 
		sb.append(" q.factor        as factor_cb, ");  
		sb.append(" q.code_mm,q.id_mmtp,q.code_mm, ");  
		sb.append(" s.code          as code_srv,   ");
		sb.append(" t.id_pripat     as id_pripat,  "); 
		sb.append(" q.name_mm,tt.id_org,tt.id_grp, ");  
		sb.append(" tt.name_or as des,tt.fg_bb,   ");
		sb.append(" tt.no_bb,tt.dt_sign,      ");
		sb.append(" p.name as presrption_name,   ");
		sb.append(" p.fg_bl,  ");
		sb.append(" bdudidoc.name  prestp_name, ");  
		sb.append(" p.id_dep_wh,    ");
		sb.append(" p.id_hp,p.ID_HPSRVTP,p.SD_HPSRVTP ,  ");
		sb.append(" dep.name  name_dep_srv,    ");
		sb.append(" tt.applyno  code, tt.sv ci_sv, "); 
		sb.append(" depmp.name  name_dep_mp ,  ");
		sb.append(" p.fg_specill,   ");
		sb.append(" p.fg_extdispense,   ");
		sb.append(" en_ent_hp.id_hpkind,prn.code_prn as presno,   ");
		sb.append(" '04' prntype    ");
		sb.append(" from ci_order tt    ");		
		sb.append(" inner join ci_or_srv p    ");
		sb.append(" on tt.id_or=p.id_or   ");
		sb.append(" left join ci_prn_item prnitem on prnitem.id_biz = p.id_orsrv");
		sb.append(" left join ci_prn prn on prn.id_ciprn = prnitem.id_ciprn");
		sb.append(" left join ci_or_srv_mm q   ");
		sb.append(" on p.id_orsrv = q.id_orsrv   ");
		sb.append(" left outer join bd_srv s   ");
		sb.append(" on s.id_srv = p.id_srv   ");
		sb.append(" inner join en_ent t    ");
		sb.append(" on p.id_en = t.id_ent   ");
		sb.append(" left outer join en_ent_hp on en_ent_hp.id_ent = t.id_ent ");  
		sb.append(" left outer join bd_udidoc bdudidoc on bdudidoc.id_udidoc =p.id_srvtp  "); 
		sb.append(" left join bd_dep  dep on dep.id_dep = p.id_dep_srv   ");
		sb.append(" left join bd_dep  depmp on depmp.id_dep = p.id_dep_mp   "); 
		sb.append(" left join ci_ap_obs apobs on apobs.id_or=tt.id_or   "); 
		sb.append(" where p.fg_bl = 'Y'   ");
		if(print_nos != null && print_nos.length() > 0){	
			sb.append(" and prn.code_prn in (");
			sb.append(print_nos);
			sb.append(")");

		}
		if(id_ent != null && id_ent.length() >0){
			sb.append(" and prn.id_en ='");
			sb.append(id_ent);
			sb.append("'");
		}
		return sb.toString();
	}


}
