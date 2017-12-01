package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.ci.ord.s.bp.qry.RecipeDTOQry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.sys.jdbc.handler.BeanListHandler;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 处理外配处方
 * @author li_zheng
 *
 */
public class getExtdispenseDtoBP {
	public static getExtdispenseDtoBP instance;
	private getExtdispenseDtoBP(){};
	public static getExtdispenseDtoBP getInstance()throws BizException{
		if(instance==null){
		   instance = new getExtdispenseDtoBP();	
		}
		return instance;
	}
	public PrescriptionConstBaseDto getExtdispenseDto(String patid, FDateTime dtSignB, FDateTime dtSignE,
 			String code_entp, String Id_org) throws BizException {
		 PrescriptionConstBaseDto baseDto = new PrescriptionConstBaseDto();
		 FArrayList prescrptionObsAndLabList = new FArrayList();
		 String condition = getCondition(patid,dtSignB,dtSignE,code_entp,Id_org);
		 String sql = getSql(condition);
		 DAFacade dafacade = new DAFacade();
		 @SuppressWarnings("unchecked")
		List<PrescriptionCostDto> rtn = (List<PrescriptionCostDto>)dafacade.execQuery(sql, new BeanListHandler(PrescriptionCostDto.class));
		 FArrayList prescriptionList = new FArrayList();
		  Map map = new HashMap();
		  for(PrescriptionCostDto presDto:rtn){
			   if(presDto.getPresno() == null){
				   presDto.setPresno(presDto.getCode());
			   }
			  prescriptionList.add(presDto);
			  map.put(presDto.getId_pres(), presDto.getId_pres());
		  }
		  baseDto.setPrescriptionCostDto(prescriptionList);
		  FArrayList  prescrptionlist =  getPress(map);
		  if(prescrptionlist != null && prescrptionlist.size()>0){
			 for(int i=0;i<prescrptionlist.size();i++){
				 prescrptionObsAndLabList.add(prescrptionlist.get(i));
			 }
		  }
		  baseDto.setRecipeDTO(prescrptionObsAndLabList);
		  return baseDto;
	}
	
	/**
	 * 查询的sql
	 * @param condition
	 * @return
	 */
	private String getSql(String condition){
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
		sql.append("  ci_or_srv.id_org_mp,");
		sql.append("  ci_or_srv.id_dep_mp,");
		sql.append("  ci_or_srv.id_su_mp,");
		sql.append("  ci_or_srv.sd_su_mp,");
		sql.append("  ci_or_srv.id_su_bl,");
		sql.append("  ci_or_srv.sd_su_bl,");
	    sql.append("  ci_or_srv.dt_last_bl   dt_bl_last,");
		sql.append("  ci_or_srv.fg_mm,");
		sql.append("  ci_or_srv.fg_indic,");
		sql.append("  ci_or_srv.fg_propc,");
		sql.append("  ci_or_srv.fg_self,");
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
		sql.append("  ci_order.dt_sign, ");  
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
		sql.append("  en_ent_hp.id_hpkind ,");
		sql.append("  ci_order.orders ");
		sql.append("  from ci_order ci_order");
		sql.append("  inner join ci_or_srv ci_or_srv");
		sql.append("  on ci_order.id_or=ci_or_srv.id_or ");
		sql.append("  left join ci_or_srv_mm ci_or_srv_mm ");
		sql.append("  on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv ");
		sql.append("  left outer join bd_srv bd_srv");
		sql.append("  on bd_srv.id_srv = ci_or_srv.id_srv ");
		sql.append("  inner join en_ent en_ent ");
		sql.append("  on ci_or_srv.id_en = en_ent.id_ent ");
		sql.append(" left outer join en_ent_hp on en_ent_hp.id_ent = en_ent.id_ent ");
		sql.append("    left join ci_pres pres on pres.id_pres = ci_or_srv.id_pres  ");
		sql.append("   left join bd_udidoc udi  on udi.id_udidoc = pres.id_prestp  ");
		sql.append("   left outer join  bd_mm  bdmm  on  bdmm.id_mm = ci_or_srv_mm.id_mm  ");
		sql.append("   left join bd_dep  dep on dep.id_dep = ci_or_srv.id_dep_srv ");
		sql.append("   left join bd_dep  depmp on depmp.id_dep = ci_or_srv.id_dep_mp  ");
		sql.append("   left join ci_pres  on ci_pres.id_pres = ci_or_srv.id_pres  ");		 
		sql.append("  where ci_or_srv.sd_su_bl='0'  and ci_or_srv.ds = 0 and ci_order.ds = 0   and ci_or_srv.sd_srvtp like '01%' and  ci_or_srv.fg_self ='N'  and ci_or_srv.fg_bl ='Y'  ");
		sql.append("  and  ci_order.fg_sign ='Y' and   ci_order.fg_canc='N' ");
		sql.append("  and   ci_order.sd_su_or in ('");
		sql.append(ICiDictCodeConst.SD_SU_SIGN);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		sql.append("')");
		sql.append("  and ci_or_srv.fg_extdispense ='Y'  ");
		if(condition != null){
			sql.append(condition);
		}
		/*sql.append("  and  ci_order.id_pat=?  and ci_order.code_entp= ? and  ci_order.id_org = ? ");
		 if(dtSignB != null){
			 sql.append( "and ci_order.dt_sign>=?" );
		 }
		if(dtSignE != null){
			sql.append( " and ci_order.dt_sign<= ?") ;
		 }*/
		sql.append( "  order by ci_pres.id_pres,ci_order.dt_sign desc ");
        return sql.toString();
	}
	
	 /*select ci_or_srv.id_orsrv,
     ci_or_srv.id_or,
     ci_or_srv.id_pres,
     ci_or_srv.id_pat,
     ci_or_srv.id_entp,
     ci_or_srv.code_entp,
     ci_or_srv.id_en,
     ci_or_srv.sortno,
     ci_or_srv.id_srvtp,
     ci_or_srv.sd_srvtp,
     ci_or_srv.id_srv,
     bd_srv.name as name_srv,
     ci_or_srv.quan_medu as quan_med,
     ci_or_srv.id_medu as id_unit_med,
     ci_or_srv.id_route,
     ci_or_srv.id_routedes,
     ci_or_srv.id_boil,
     ci_or_srv.id_boildes,
     ci_or_srv.id_freq,
     ci_or_srv.id_org_srv,
     ci_or_srv.id_dep_srv,
     ci_or_srv.id_wg_or as id_wg_srv,
     ci_or_srv.id_emp_srv,
     ci_or_srv.id_org_mp,
     ci_or_srv.id_dep_mp,
     ci_or_srv.id_su_mp,
     ci_or_srv.sd_su_mp,
     ci_or_srv.id_su_bl,
     ci_or_srv.sd_su_bl,
     ci_or_srv.dt_last_bl dt_bl_last,
     ci_or_srv.fg_mm,
     ci_or_srv.fg_indic,
     ci_or_srv.fg_propc,
     ci_or_srv.fg_self,
     ci_or_srv_mm.id_orsrvmm,
     ci_or_srv_mm.id_mm,
     ci_or_srv_mm.quan_cur,
     ci_or_srv_mm.quan_bed_medu,
     ci_or_srv_mm.id_pgku_cur as id_unit_cur,
     ci_or_srv_mm.id_pgku_base as id_unit_base,
     ci_or_srv_mm.factor as factor_cb,
     ci_or_srv_mm.code_mm,
     ci_or_srv_mm.id_mmtp,
     ci_or_srv_mm.code_mm,
     bd_srv.code as code_srv,
     en_ent.id_pripat as id_pripat,
     ci_or_srv_mm.name_mm,
     ci_order.id_org,
     ci_order.id_grp,
     ci_order.name_or as des,
     ci_order.fg_bb,
     ci_order.no_bb,
     ci_order.dt_sign,
     pres.name as presrption_name,
     udi.name prestp_name,
     ci_or_srv.id_hp,
     ci_or_srv.id_hpsrvtp,
     ci_or_srv.sd_hpsrvtp,
     ci_or_srv.id_dep_wh,
     bdmm.apprno,
     dep.name name_dep_srv,
     pres.code,
     ci_order.sv ci_sv,
     depmp.name name_dep_mp,
     ci_or_srv.fg_specill,
     ci_or_srv.fg_extdispense,
     ci_or_srv.id_srvca,
     ci_pres.code presno,
     '01' Prntype,
     ci_pres.sd_prestpword,
     en_ent_hp.id_hpkind,
     ci_order.orders
from ci_order ci_order
inner join ci_or_srv ci_or_srv on ci_order.id_or = ci_or_srv.id_or
left join ci_or_srv_mm ci_or_srv_mm on ci_or_srv.id_orsrv =
                                       ci_or_srv_mm.id_orsrv
left outer join bd_srv bd_srv on bd_srv.id_srv = ci_or_srv.id_srv
inner join en_ent en_ent on ci_or_srv.id_en = en_ent.id_ent
left outer join en_ent_hp on en_ent_hp.id_ent = en_ent.id_ent
left join ci_pres pres on pres.id_pres = ci_or_srv.id_pres
left join bd_udidoc udi on udi.id_udidoc = pres.id_prestp
left outer join bd_mm bdmm on bdmm.id_mm = ci_or_srv_mm.id_mm
left join bd_dep dep on dep.id_dep = ci_or_srv.id_dep_srv
left join bd_dep depmp on depmp.id_dep = ci_or_srv.id_dep_mp
left join ci_pres on ci_pres.id_pres = ci_or_srv.id_pres
where ci_or_srv.sd_su_bl = '0'
 and ci_or_srv.ds = 0
 and ci_order.ds = 0
 and ci_or_srv.sd_srvtp like '01%'
 and ci_or_srv.fg_self = 'N'
 and ci_or_srv.fg_bl = 'Y'
 and ci_order.fg_sign = 'Y'
 and ci_order.fg_canc = 'N'
 and ci_or_srv.fg_extdispense = 'Y'
 and ci_order.id_pat = '1001Z810000000004182'
order by ci_pres.id_pres, ci_order.dt_sign desc*/

	/**
	 * 
	 * @param patid
	 * @param dtSignB
	 * @param dtSignE
	 * @param code_entp
	 * @param Id_org
	 * @return
	 */
	private  String getCondition(String patid, FDateTime dtSignB, FDateTime dtSignE,
 			String code_entp, String Id_org){
		 StringBuffer sb = new StringBuffer();
		 if(patid!= null){
			sb.append(" and  ci_order.id_pat='"); 
			sb.append(patid); 
			sb.append("'"); 
		 }
		 if(dtSignB!= null){
				sb.append(" and  ci_order.dt_effe >='"); 
				sb.append(dtSignB); 
				sb.append("'"); 
			 }
		 if(dtSignE!= null){
				sb.append(" and  ci_order.dt_effe <='"); 
				sb.append(dtSignE); 
				sb.append("'"); 
			 }
		 if(code_entp!= null){
				sb.append(" and  ci_order.code_entp='"); 
				sb.append(code_entp); 
				sb.append("'"); 
			 }
		 if(Id_org!= null){
				sb.append(" and  ci_order.Id_org='"); 
				sb.append(Id_org); 
				sb.append("'"); 
			 }
		 
		 
		 return sb.toString();
	}
	
	 /***
	 * 患者未计费处方信息(药品)
	 * @param map
	 * @return
	 */
	private  FArrayList  getPress(Map<String,String> map)throws BizException{
		
		FArrayList recipres = new FArrayList();
		if(map != null && map.size() >0){
			String id_press = "";
			for(String pres :map.keySet()){
				id_press += "'"+pres +"',";
			}
			id_press = id_press.substring(0, id_press.lastIndexOf(","));
			RecipeDTOQry qry = new RecipeDTOQry(id_press);
			RecipeDTO[] RecipresList = (RecipeDTO[])AppFwUtil.getDORstWithDao(qry, RecipeDTO.class);
		    if(RecipresList != null && RecipresList.length>0){
		    	for(RecipeDTO dto :RecipresList){
		    		recipres.add(dto);
		    	}
		    }
		}
		return recipres;
	}
}
