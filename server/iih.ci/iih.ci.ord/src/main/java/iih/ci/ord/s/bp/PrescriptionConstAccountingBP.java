package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.RecipeDTOQry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 就诊未计费和计费的医嘱项目
 * 
 * @author li_zheng
 *
 */
public class PrescriptionConstAccountingBP {
	/**
	 * 就诊未计费和计费的医嘱项目
	 * @param id_ent
	 * @param sd_su_bl
	 * @return
	 * @throws BizException
	 */
	public PrescriptionConstBaseDto exec(String id_ent, String[] sd_su_bl)throws BizException{
		
		  PrescriptionConstBaseDto baseDto = new PrescriptionConstBaseDto();
		  //药品
		   long StartTime = System.currentTimeMillis();
		  PrescriptionCostDto[] rtn = this.getDrugPrescriptionConstDto(id_ent,sd_su_bl);
		  
		  CiOrdUtils.LogerOutInfo("getDrugPrescriptionConstDto     耗时 :"+(System.currentTimeMillis()- StartTime));
		  // 检查检验
		  long StartTime2 = System.currentTimeMillis();
		  PrescriptionCostDto[] rtnobsAndLab = this.getLabAndObsPrescriptionConstDto(id_ent,sd_su_bl);
		  CiOrdUtils.LogerOutInfo("getLabAndObsPrescriptionConstDto   耗时 :"+(System.currentTimeMillis()- StartTime2));
		  //检查检验虚拟处方
		  
		  if(rtn == null && rtnobsAndLab == null) return  null;
		  
		  FArrayList prescrptionObsAndLabList = new FArrayList();
		  long StartTime3 = System.currentTimeMillis();
		  String[] str = null;
		  if(rtn !=  null && rtn.length > 0){
			  str=  CiOrdUtils.getDiag(rtn[0].getId_en());
		  }else if(rtnobsAndLab != null && rtnobsAndLab.length > 0){
			  str=  CiOrdUtils.getDiag(rtnobsAndLab[0].getId_en());
		  }
		  
		 
		  FArrayList prescriptionList = new FArrayList();
		  Map map = new HashMap();
		  if(rtn != null){
			  for( PrescriptionCostDto presDto:rtn){
				   if(presDto.getPresno() == null){
					   presDto.setPresno(presDto.getCode());
				   }
				  prescriptionList.add(presDto);
				  map.put(presDto.getId_pres(), presDto.getId_pres());
			  }
		  }
		  if(rtnobsAndLab != null){
			  for(PrescriptionCostDto presDto:rtnobsAndLab){
				  prescriptionList.add(presDto);
				  //检查检验 虚拟处方
				  prescrptionObsAndLabList.add(this.getPrescrptionObsAndLab(presDto,str));
				  
			  }
	   }
		  
		  baseDto.setPrescriptionCostDto(prescriptionList);
		  FArrayList  prescrptionlist =  getPress(map);
		  if(prescrptionlist != null && prescrptionlist.size()>0){
			 for(int i=0;i<prescrptionlist.size();i++){
				 prescrptionObsAndLabList.add(prescrptionlist.get(i));
			 }
		  }
		  baseDto.setRecipeDTO(prescrptionObsAndLabList);
		  CiOrdUtils.LogerOutInfo("PrescriptionConstBaseDto  循环    耗时 :"+(System.currentTimeMillis()- StartTime3));
		  CiOrdUtils.LogerOutInfo("PrescriptionConstBaseDto exe2    耗时 :"+(System.currentTimeMillis()- StartTime2));
		  return baseDto;
	}
	
	
	 //检查检验 虚拟处方  需要完善 todo
	   private  RecipeDTO getPrescrptionObsAndLab(PrescriptionCostDto presDto,String[] str)throws BizException{
		      RecipeDTO prescriptionInfo = new RecipeDTO();
			  prescriptionInfo.setId_pres(presDto.getId_pres());
			  prescriptionInfo.setPrestp_name(presDto.getPresrption_name());
			  prescriptionInfo.setId_en(presDto.getId_en());
			  prescriptionInfo.setId_pat(presDto.getId_pat());
			
			  prescriptionInfo.setRecipetype(presDto.getFg_self());
			  //开单科室名称
			  prescriptionInfo.setHospital_dept_name(presDto.getId_dep_srv());
			
			  if(str != null && str.length >1){
				  //诊断编码字符串
				  prescriptionInfo.setDidef_code(str[1]);
				  //诊断名称字符串
				  prescriptionInfo.setDidef_name(str[0]);
			  }
			
			  //处方日期，对于检查检验，则为医嘱开立日期
			  prescriptionInfo.setDt_entry(presDto.getDt_sign());
			  prescriptionInfo.setId_dep_or(presDto.getId_dep_srv());
			  prescriptionInfo.setId_dep_name(presDto.getName_dep_srv());
			  //开单医生名称
			  prescriptionInfo.setId_emp_or(presDto.getId_emp_srv());
			  //开单医生姓名
			  prescriptionInfo.setId_emp_name(null);
			  //单据类型，能标示是药品还是诊疗的字段
			  //prescriptionInfo.setBillstype("5");

			  return  prescriptionInfo;
	   }
	   
	   /**
	    * 
	    * @param id_ent
	    * @param sd_su_bl
	    * @return
	    */
	   private  PrescriptionCostDto[] getDrugPrescriptionConstDto(String id_ent,String[] sd_su_bl)throws BizException{
		   String sql = getDrugPrescriptionSql(id_ent,sd_su_bl);
		   List<PrescriptionCostDto>  list  = (List<PrescriptionCostDto>) new DAFacade().execQuery(sql,
				  new BeanListHandler(PrescriptionCostDto.class));
		     if(list != null && list.size() >0){
		    	 return list.toArray(new PrescriptionCostDto[list.size()]); 
		     }
		     return null;
	   }
	   
	   /**
	    * 非药品的
	    * @param id_ent
	    * @param sd_su_bl
	    * @return
	    */
	   private  PrescriptionCostDto[] getLabAndObsPrescriptionConstDto(String id_ent,String[] sd_su_bl)throws BizException{
		   String sql = getQrySQLStr(id_ent,sd_su_bl);
		   List<PrescriptionCostDto>  list  = (List<PrescriptionCostDto>) new DAFacade().execQuery(sql,
				  new BeanListHandler(PrescriptionCostDto.class));
		     if(list != null && list.size() >0){
		    	 return list.toArray(new PrescriptionCostDto[list.size()]); 
		     }
		     return null;
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
		
		/**
		 *药品
		 * @param id_ent
		 * @param sd_su_bl
		 * @return
		 */
		private String getDrugPrescriptionSql(String id_ent,String[] sd_su_bl){
			        StringBuffer sql = new StringBuffer();
			         
			        sql.append("  select DISTINCT ci_or_srv.id_orsrv,");
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
					sql.append("  ci_or_srv.dt_last_bl    as dt_bl_last,");
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
					sql.append("  ci_order.dt_sign, "); //这是新增的
					sql.append("   pres.name as presrption_name, "); 
					sql.append("   udi.name  prestp_name,");
					sql.append("   ci_or_srv.id_hp,ci_or_srv.id_hpsrvtp,ci_or_srv.sd_hpsrvtp ,ci_or_srv.id_dep_wh, ");
					sql.append("   bd_mm.apprno,  ");
					sql.append("   dep.name  name_dep_srv, ");
					sql.append("   pres.code  , ci_order.sv ci_sv,");
					sql.append("   bd_dep.name  name_dep_mp, ");
					sql.append("   ci_or_srv.fg_specill, ");
					sql.append("   ci_or_srv.fg_extdispense, ");
					sql.append("   ci_pres.code   presno, ");
					sql.append(" ci_or_srv.id_srvca, ");
					sql.append("   '01'  Prntype, ");
					//手动划价 需要查出 eu_blmd,pri,pri_std,pri_ratio by yzh 2017-10-24 09:57:03
					sql.append("   ci_or_srv.eu_blmd,ci_or_srv.pri,ci_or_srv.pri_std,ci_or_srv.pri_ratio, ");
					sql.append("  en_ent_hp.id_hpkind");
					sql.append("  from ci_order ci_order");
					sql.append("  inner join ci_or_srv ci_or_srv");
					sql.append("  on ci_order.id_or=ci_or_srv.id_or ");
					sql.append("  left join ci_or_srv_mm ci_or_srv_mm ");
					sql.append("  on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv ");
					sql.append("  left outer join bd_srv bd_srv ");
					sql.append("  on bd_srv.id_srv = ci_or_srv.id_srv ");
					sql.append("  inner join en_ent en_ent ");
					sql.append("  on ci_or_srv.id_en = en_ent.id_ent ");
					sql.append(" left outer join en_ent_hp on en_ent_hp.id_ent = en_ent.id_ent AND en_ent_hp.fg_MAJ='Y' ");
					sql.append("    left join ci_pres pres on pres.id_pres = ci_or_srv.id_pres  ");
					sql.append("   left join bd_udidoc udi  on udi.id_udidoc = pres.id_prestp  ");
 
					sql.append("   left outer join  bd_mm  bd_mm  on  bd_mm.id_mm = ci_or_srv_mm.id_mm  ");
					sql.append("   left join bd_dep  dep on dep.id_dep = ci_or_srv.id_dep_srv ");
					sql.append("   left join bd_dep  bd_dep on bd_dep.id_dep = ci_or_srv.id_dep_mp  ");
					sql.append("     left join ci_pres  on ci_pres.id_pres = ci_or_srv.id_pres  ");		 
					sql.append(" where en_ent.fg_canc='N' and ci_order.sd_su_or='");
					sql.append(ICiDictCodeConst.SD_SU_SIGN);
					sql.append("'  and ci_or_srv.ds = 0 and ci_order.ds = 0  and  ci_or_srv.fg_self ='N'  ");
					sql.append(" and ci_or_srv.fg_bl = 'Y'   ");
					sql.append(" and    ci_or_srv.sd_srvtp  like '01%'  ");
					sql.append(" and  ci_order.id_en='");
					sql.append(id_ent);
					sql.append("'");
					if(sd_su_bl != null && sd_su_bl.length > 0){
						sql.append(" and ci_or_srv.sd_su_bl  in (");
						sql.append(CiOrdUtils.IdsConveretCharacterString(sd_su_bl));
						sql.append(")");
								 
					}
			        return sql.toString();
		}
		
		/**
		 *  非药品的数据
		 * @param id_ent
		 * @param sd_su_bl
		 * @return
		 */
		@Deprecated
		private String getlabAndObs(String id_ent,String[] sd_su_bl){
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
			sb.append(" en_ent_hp.id_hpkind   ");
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
			sb.append(" left join bd_dep  bd_dep on bd_dep.id_dep = p.id_dep_mp   "); 
			sb.append(" where   tt.sd_su_or='");
			sb.append(ICiDictCodeConst.SD_SU_SIGN);
			sb.append("'  ");
			sb.append(" and p.fg_bl = 'Y'   ");
			sb.append(" and   p.id_pres ='~' and p.sd_srvtp not like '01%'  ");
			sb.append(" and  tt.id_en='");
			sb.append(id_ent);
			sb.append("'");
			if(sd_su_bl != null && sd_su_bl.length > 0){
				sb.append(" and p.sd_su_bl  in (");
				sb.append(CiOrdUtils.IdsConveretCharacterString(sd_su_bl));
				sb.append(")");
						 
			}
            //sb.append("   order by id_pres,dt_sign desc ");
	        return sb.toString();
		}
		
		public String getQrySQLStr(String id_ent,String[] sd_su_bl) {
			// TODO Auto-generated method stub
			/*public static final String DRUG_TYPE = "01";  //01 药品
			public static final String RIS_TYPE = "02";//02 检查
			public static final String LIS_TYPE = "03";//03检验
			public static final String TREATMENT_TYPE = "04";//04 诊疗
			public static final String PATHGY_TYPE = "05";//05 检查*/
			return getSqlObs(id_ent,sd_su_bl) + "  union all  	" + getSqlLab(id_ent,sd_su_bl) + " union all  " + getSqltreatment(id_ent,sd_su_bl)
					+ "  union all  	" +getSqlpathology(id_ent,sd_su_bl) ;
		}
		// 检查
		private String getSqlObs(String id_ent,String[] sd_su_bl) {
			StringBuffer sql = new StringBuffer();

			sql.append(" select DISTINCT ci_or_srv.id_orsrv, ");
			sql.append(" ci_or_srv.id_srv, ");
			sql.append(" ci_or_srv.id_or,ci_order.id_or  id_pres, ");
			sql.append(" ci_or_srv.id_pat,ci_or_srv.id_entp, ");
			sql.append(" ci_or_srv.code_entp,ci_or_srv.id_en, ");
			sql.append(" ci_or_srv.sortno,ci_or_srv.id_srvtp,   ci_or_srv.sd_srvtp, ");
			sql.append("  bd_srv.name          as name_srv, ");
			sql.append(" ci_or_srv.quan_total_medu     as quan_med,  ");
			sql.append(" ci_or_srv.id_medu       as id_unit_med,");
			sql.append(" ci_or_srv.id_route,ci_or_srv.id_routedes, ");
			sql.append(" ci_or_srv.id_boil,ci_or_srv.id_boildes, ");
			sql.append(" ci_or_srv.id_freq,ci_or_srv.id_org_srv, ");
			sql.append(" ci_or_srv.id_dep_srv,ci_or_srv.id_wg_or      as id_wg_srv, ");
			sql.append(" ci_or_srv.id_emp_srv,ci_or_srv.id_org_mp, ");
			sql.append(" ci_or_srv.id_dep_mp,ci_or_srv.id_su_mp, ");
			sql.append(" ci_or_srv.sd_su_mp,ci_or_srv.id_su_bl, ");
			sql.append(" ci_or_srv.sd_su_bl,ci_or_srv.dt_last_bl    as dt_bl_last, ");
			sql.append(" ci_or_srv.fg_mm,ci_or_srv.fg_indic,ci_or_srv.fg_propc, ");
			//sql.append(" case ci_or_srv.fg_selfpay  when 'Y' then 'N' when 'N' then 'Y' end as fg_self,ci_or_srv_mm.id_orsrvmm, ");
			sql.append(" ci_order.fg_orhp fg_self,ci_or_srv_mm.id_orsrvmm, ");
			sql.append(" ci_or_srv_mm.id_mm,ci_or_srv_mm.quan_cur, ");
			sql.append(" ci_or_srv_mm.quan_bed_medu, ");
			sql.append(" ci_or_srv_mm.id_pgku_cur   as id_unit_cur, ");
			sql.append(" ci_or_srv_mm.id_pgku_base  as id_unit_base, ");
			sql.append(" ci_or_srv_mm.factor        as factor_cb, ");
			sql.append(" ci_or_srv_mm.code_mm,ci_or_srv_mm.id_mmtp,ci_or_srv_mm.code_mm, ");
			sql.append(" bd_srv.code          as code_srv, ");
			sql.append(" en_ent.id_pripat     as id_pripat, ");
			sql.append(" ci_or_srv_mm.name_mm,ci_order.id_org,ci_order.id_grp, ");
			sql.append(" ci_order.name_or as des,ci_order.fg_bb, ");
			sql.append(" ci_order.no_bb,ci_order.dt_sign, ");
			sql.append(" ci_or_srv.name as presrption_name, ");
			sql.append(" ci_or_srv.fg_bl,");
			sql.append(" bdudidoc.name  prestp_name, ");
			sql.append(" ci_or_srv.id_dep_wh,  ");
			sql.append(" ci_or_srv.id_hp,ci_or_srv.ID_HPSRVTP,ci_or_srv.SD_HPSRVTP ,");
			sql.append(" dep.name  name_dep_srv, ");
			sql.append(" ci_order.applyno  code, ci_order.sv ci_sv,");
			sql.append(" depmp.name  name_dep_mp ,");
			sql.append(" ci_or_srv.fg_specill, ");
			sql.append(" ci_or_srv.id_srvca, ");
			sql.append(" ci_or_srv.fg_extdispense, ");
			sql.append("  en_ent_hp.id_hpkind, ");
			sql.append("  ci_app_ris.code_app   presno, ");
			//手动划价 需要查出 eu_blmd,pri,pri_std,pri_ratio by yzh 2017-10-24 09:57:03
			sql.append("   ci_or_srv.eu_blmd,ci_or_srv.pri,ci_or_srv.pri_std,ci_or_srv.pri_ratio, ");			
			sql.append("   '02'  Prntype  ");
			sql.append(" from ci_order ci_order  ");
			sql.append(" inner join ci_or_srv ci_or_srv  ");
			sql.append(" on ci_order.id_or=ci_or_srv.id_or ");
			
			sql.append(" left join ci_app_ris ci_app_ris  ");
			sql.append(" on ci_order.id_or=ci_app_ris.id_or ");
			
			sql.append(" left join ci_or_srv_mm ci_or_srv_mm ");
			sql.append(" on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv ");
			sql.append(" left outer join bd_srv bd_srv ");
			sql.append(" on bd_srv.id_srv = ci_or_srv.id_srv ");
			sql.append(" inner join en_ent en_ent  ");
			sql.append(" on ci_or_srv.id_en = en_ent.id_ent ");
			sql.append(" left outer join en_ent_hp on en_ent_hp.id_ent = en_ent.id_ent  AND en_ent_hp.fg_MAJ='Y'");
			sql.append(" left outer join bd_udidoc bdudidoc on bdudidoc.id_udidoc =ci_or_srv.id_srvtp ");
			sql.append(" left join bd_dep  dep on dep.id_dep = ci_or_srv.id_dep_srv ");
			sql.append(" left join bd_dep  depmp on depmp.id_dep = ci_or_srv.id_dep_mp  ");
			sql.append(" where  en_ent.fg_canc='N' and ci_order.sd_su_or in (");
			sql.append("'");
			sql.append(ICiDictCodeConst.SD_SU_SIGN);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_XECUTING);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_DOCTORSTOP);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_CHECKSTOP);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_FINISH);
			sql.append("' ");
			sql.append(")");
//			sql.append("  and ci_or_srv.sd_su_bl ='0'");
			sql.append("  and ci_or_srv.ds = 0  ");
			sql.append("  and ci_or_srv.fg_bl = 'Y' and ci_or_srv.ds = 0 ");
			sql.append("     and   ci_or_srv.id_pres ='~' and (  ci_or_srv.sd_srvtp like '02%' and  ci_or_srv.sd_srvtp not like '0207%')");

			sql.append(" and  ci_or_srv.id_en='");
			sql.append(id_ent);
			sql.append("'");
			if(sd_su_bl != null && sd_su_bl.length > 0){
				sql.append(" and ci_or_srv.sd_su_bl  in (");
				sql.append(CiOrdUtils.IdsConveretCharacterString(sd_su_bl));
				sql.append(")");
						 
			}
			return sql.toString();
		}
           //病理
		private String getSqlpathology(String id_ent,String[] sd_su_bl) {
			StringBuffer sql = new StringBuffer();
			 
			sql.append(" select DISTINCT ci_or_srv.id_orsrv, ");
			sql.append(" ci_or_srv.id_srv, ");
			sql.append(" ci_or_srv.id_or,ci_order.id_or  id_pres, ");
			sql.append(" ci_or_srv.id_pat,ci_or_srv.id_entp, ");
			sql.append(" ci_or_srv.code_entp,ci_or_srv.id_en, ");
			sql.append(" ci_or_srv.sortno,ci_or_srv.id_srvtp,   ci_or_srv.sd_srvtp, ");
			sql.append("  bd_srv.name          as name_srv, ");
			sql.append(" ci_or_srv.quan_total_medu     as quan_med,  ");
			sql.append(" ci_or_srv.id_medu       as id_unit_med,");
			sql.append(" ci_or_srv.id_route,ci_or_srv.id_routedes, ");
			sql.append(" ci_or_srv.id_boil,ci_or_srv.id_boildes, ");
			sql.append(" ci_or_srv.id_freq,ci_or_srv.id_org_srv, ");
			sql.append(" ci_or_srv.id_dep_srv,ci_or_srv.id_wg_or      as id_wg_srv, ");
			sql.append(" ci_or_srv.id_emp_srv,ci_or_srv.id_org_mp, ");
			sql.append(" ci_or_srv.id_dep_mp,ci_or_srv.id_su_mp, ");
			sql.append(" ci_or_srv.sd_su_mp,ci_or_srv.id_su_bl, ");
			sql.append(" ci_or_srv.sd_su_bl,ci_or_srv.dt_last_bl    as dt_bl_last, ");
			sql.append(" ci_or_srv.fg_mm,ci_or_srv.fg_indic,ci_or_srv.fg_propc, ");
			sql.append(" case ci_or_srv.fg_selfpay  when 'Y' then 'N' when 'N' then 'Y' end as fg_self,ci_or_srv_mm.id_orsrvmm, ");
			sql.append(" ci_or_srv_mm.id_mm,ci_or_srv_mm.quan_cur, ");
			sql.append(" ci_or_srv_mm.quan_bed_medu, ");
			sql.append(" ci_or_srv_mm.id_pgku_cur   as id_unit_cur, ");
			sql.append(" ci_or_srv_mm.id_pgku_base  as id_unit_base, ");
			sql.append(" ci_or_srv_mm.factor        as factor_cb, ");
			sql.append(" ci_or_srv_mm.code_mm,ci_or_srv_mm.id_mmtp,ci_or_srv_mm.code_mm, ");
			sql.append(" bd_srv.code          as code_srv, ");
			sql.append(" en_ent.id_pripat     as id_pripat, ");
			sql.append(" ci_or_srv_mm.name_mm,ci_order.id_org,ci_order.id_grp, ");
			sql.append(" ci_order.name_or as des,ci_order.fg_bb, ");
			sql.append(" ci_order.no_bb,ci_order.dt_sign, ");
			sql.append(" ci_or_srv.name as presrption_name, ");
			sql.append(" ci_or_srv.fg_bl,");
			sql.append(" bdudidoc.name  prestp_name, ");
			sql.append(" ci_or_srv.id_dep_wh,  ");
			sql.append(" ci_or_srv.id_hp,ci_or_srv.ID_HPSRVTP,ci_or_srv.SD_HPSRVTP ,");
			sql.append(" dep.name  name_dep_srv, ");
			sql.append(" ci_order.applyno  code, ci_order.sv ci_sv,");
			sql.append(" depmp.name  name_dep_mp ,");
			sql.append(" ci_or_srv.fg_specill, ");
			sql.append(" ci_or_srv.id_srvca, ");
			sql.append(" ci_or_srv.fg_extdispense, ");
			sql.append("  en_ent_hp.id_hpkind, ");
			sql.append("  ci_app_pathgy.code_app   presno, ");
			//手动划价 需要查出 eu_blmd,pri,pri_std,pri_ratio by yzh 2017-10-24 09:57:03
			sql.append("   ci_or_srv.eu_blmd,ci_or_srv.pri,ci_or_srv.pri_std,ci_or_srv.pri_ratio, ");
			sql.append("   '02'  Prntype  ");
			sql.append(" from ci_order ci_order  ");
			sql.append(" inner join ci_or_srv ci_or_srv  ");
			sql.append(" on ci_order.id_or=ci_or_srv.id_or ");
			
			sql.append(" left join ci_app_pathgy ci_app_pathgy  ");
			sql.append(" on ci_order.id_or=ci_app_pathgy.id_or ");
			
			sql.append(" left join ci_or_srv_mm ci_or_srv_mm ");
			sql.append(" on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv ");
			sql.append(" left outer join bd_srv bd_srv ");
			sql.append(" on bd_srv.id_srv = ci_or_srv.id_srv ");
			sql.append(" inner join en_ent en_ent  ");
			sql.append(" on ci_or_srv.id_en = en_ent.id_ent ");
			sql.append(" left outer join en_ent_hp on en_ent_hp.id_ent = en_ent.id_ent  AND en_ent_hp.fg_MAJ='Y'");
			sql.append(" left outer join bd_udidoc bdudidoc on bdudidoc.id_udidoc =ci_or_srv.id_srvtp ");
			sql.append(" left join bd_dep  dep on dep.id_dep = ci_or_srv.id_dep_srv ");
			sql.append(" left join bd_dep  depmp on depmp.id_dep = ci_or_srv.id_dep_mp  ");
			sql.append(" where  en_ent.fg_canc='N' and ci_order.sd_su_or in (");
			sql.append("'");
			sql.append(ICiDictCodeConst.SD_SU_SIGN);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_XECUTING);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_DOCTORSTOP);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_CHECKSTOP);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_FINISH);
			sql.append("' ");
			sql.append(")");
//			sql.append("  and ci_or_srv.sd_su_bl ='0'");
			sql.append("  and ci_or_srv.ds = 0  ");
			sql.append("  and ci_or_srv.fg_bl = 'Y' and ci_or_srv.ds = 0 ");
			sql.append("     and   ci_or_srv.id_pres ='~' and (  ci_or_srv.sd_srvtp like '0207%')");

			sql.append(" and  ci_or_srv.id_en='");
			sql.append(id_ent);
			sql.append("'");
			if(sd_su_bl != null && sd_su_bl.length > 0){
				sql.append(" and ci_or_srv.sd_su_bl  in (");
				sql.append(CiOrdUtils.IdsConveretCharacterString(sd_su_bl));
				sql.append(")");
						 
			}
			return sql.toString();
		}


		private String getSqlLab(String id_ent,String[] sd_su_bl) {
			StringBuffer sql = new StringBuffer();
			// 检验
			sql.append(" select DISTINCT ci_or_srv.id_orsrv, ");
			sql.append(" ci_or_srv.id_srv, ");
			sql.append(" ci_or_srv.id_or,ci_order.id_or  id_pres, ");
			sql.append(" ci_or_srv.id_pat,ci_or_srv.id_entp, ");
			sql.append(" ci_or_srv.code_entp,ci_or_srv.id_en, ");
			sql.append(" ci_or_srv.sortno,ci_or_srv.id_srvtp,   ci_or_srv.sd_srvtp, ");
			sql.append("  bd_srv.name          as name_srv, ");
			sql.append(" ci_or_srv.quan_total_medu     as quan_med,  ");
			sql.append(" ci_or_srv.id_medu       as id_unit_med,");
			sql.append(" ci_or_srv.id_route,ci_or_srv.id_routedes, ");
			sql.append(" ci_or_srv.id_boil,ci_or_srv.id_boildes, ");
			sql.append(" ci_or_srv.id_freq,ci_or_srv.id_org_srv, ");
			sql.append(" ci_or_srv.id_dep_srv,ci_or_srv.id_wg_or      as id_wg_srv, ");
			sql.append(" ci_or_srv.id_emp_srv,ci_or_srv.id_org_mp, ");
			sql.append(" ci_or_srv.id_dep_mp,ci_or_srv.id_su_mp, ");
			sql.append(" ci_or_srv.sd_su_mp,ci_or_srv.id_su_bl, ");
			sql.append(" ci_or_srv.sd_su_bl,ci_or_srv.dt_last_bl    as dt_bl_last, ");
			sql.append(" ci_or_srv.fg_mm,ci_or_srv.fg_indic,ci_or_srv.fg_propc, ");
			//sql.append(" case ci_or_srv.fg_selfpay  when 'Y' then 'N' when 'N' then 'Y' end as fg_self,ci_or_srv_mm.id_orsrvmm, ");
			sql.append(" ci_order.fg_orhp fg_self,ci_or_srv_mm.id_orsrvmm, ");
			sql.append(" ci_or_srv_mm.id_mm,ci_or_srv_mm.quan_cur, ");
			sql.append(" ci_or_srv_mm.quan_bed_medu, ");
			sql.append(" ci_or_srv_mm.id_pgku_cur   as id_unit_cur, ");
			sql.append(" ci_or_srv_mm.id_pgku_base  as id_unit_base, ");
			sql.append(" ci_or_srv_mm.factor        as factor_cb, ");
			sql.append(" ci_or_srv_mm.code_mm,ci_or_srv_mm.id_mmtp,ci_or_srv_mm.code_mm, ");
			sql.append(" bd_srv.code          as code_srv, ");
			sql.append(" en_ent.id_pripat     as id_pripat, ");
			sql.append(" ci_or_srv_mm.name_mm,ci_order.id_org,ci_order.id_grp, ");
			sql.append(" ci_order.name_or as des,ci_order.fg_bb, ");
			sql.append(" ci_order.no_bb,ci_order.dt_sign, ");
			sql.append(" ci_or_srv.name as presrption_name, ");
			sql.append(" ci_or_srv.fg_bl,");
			sql.append(" bdudidoc.name  prestp_name, ");
			sql.append(" ci_or_srv.id_dep_wh,  ");
			sql.append(" ci_or_srv.id_hp,ci_or_srv.ID_HPSRVTP,ci_or_srv.SD_HPSRVTP ,");
			sql.append(" dep.name  name_dep_srv, ");
			sql.append(" ci_order.applyno  code, ci_order.sv ci_sv,");
			sql.append(" depmp.name  name_dep_mp ,");
			sql.append(" ci_or_srv.fg_specill, ");
			sql.append(" ci_or_srv.id_srvca, ");
			sql.append(" ci_or_srv.fg_extdispense, ");
			sql.append("  en_ent_hp.id_hpkind, ");
			sql.append(" ci_app_lis.code_app presno, ");
			//手动划价 需要查出 eu_blmd,pri,pri_std,pri_ratio by yzh 2017-10-24 09:57:03
			sql.append("   ci_or_srv.eu_blmd,ci_or_srv.pri,ci_or_srv.pri_std,ci_or_srv.pri_ratio, ");
			sql.append("   '03'  Prntype  ");
			sql.append(" from ci_order ci_order  ");
			sql.append(" inner join ci_or_srv ci_or_srv  ");
			sql.append(" on ci_order.id_or=ci_or_srv.id_or ");
			sql.append(" inner join ci_app_lis_or ci_app_lis_or  ");
			sql.append(" on ci_order.id_or=ci_app_lis_or.id_or ");
			sql.append(" inner join ci_app_lis ci_app_lis  ");
			sql.append(" on ci_app_lis.id_ciapplissheet=ci_app_lis_or.id_ciapplissheet ");
			
			sql.append(" left join ci_or_srv_mm ci_or_srv_mm ");
			sql.append(" on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv ");
			sql.append(" left outer join bd_srv bd_srv ");
			sql.append(" on bd_srv.id_srv = ci_or_srv.id_srv ");
			sql.append(" inner join en_ent en_ent  ");
			sql.append(" on ci_or_srv.id_en = en_ent.id_ent ");
			sql.append(" left outer join en_ent_hp on en_ent_hp.id_ent = en_ent.id_ent AND en_ent_hp.fg_MAJ='Y' ");
			sql.append(" left outer join bd_udidoc bdudidoc on bdudidoc.id_udidoc =ci_or_srv.id_srvtp ");
			sql.append(" left join bd_dep  dep on dep.id_dep = ci_or_srv.id_dep_srv ");
			sql.append(" left join bd_dep  depmp on depmp.id_dep = ci_or_srv.id_dep_mp  ");
			sql.append(" where  en_ent.fg_canc='N' and ci_order.sd_su_or in (");
			sql.append("'");
			sql.append(ICiDictCodeConst.SD_SU_SIGN);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_XECUTING);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_DOCTORSTOP);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_CHECKSTOP);
			sql.append("','");
			sql.append(ICiDictCodeConst.SD_SU_FINISH);
			sql.append("' ");
			sql.append(")");
//			sql.append("  and ci_or_srv.sd_su_bl ='0' ");
			sql.append("  and ci_or_srv.ds = 0 ");
			sql.append("  and ci_or_srv.fg_bl = 'Y' and ci_or_srv.ds = 0 ");
			sql.append("     and   ci_or_srv.id_pres ='~' and (  ci_or_srv.sd_srvtp like '03%')");

			sql.append(" and  ci_or_srv.id_en='");
			sql.append(id_ent);
			sql.append("'");
			if(sd_su_bl != null && sd_su_bl.length > 0){
				sql.append(" and ci_or_srv.sd_su_bl  in (");
				sql.append(CiOrdUtils.IdsConveretCharacterString(sd_su_bl));
				sql.append(")");
						 
			}

			return sql.toString();
		}

		// 诊疗
		private String getSqltreatment(String id_ent,String[] sd_su_bl) {
			StringBuffer sql = new StringBuffer();
			 
			sql.append(" select DISTINCT ci_or_srv.id_orsrv, ");
			sql.append(" ci_or_srv.id_srv, ");
			sql.append(" ci_or_srv.id_or,ci_order.id_or  id_pres, ");
			sql.append(" ci_or_srv.id_pat,ci_or_srv.id_entp, ");
			sql.append(" ci_or_srv.code_entp,ci_or_srv.id_en, ");
			sql.append(" ci_or_srv.sortno,ci_or_srv.id_srvtp,   ci_or_srv.sd_srvtp, ");
			sql.append("  bd_srv.name          as name_srv, ");
			sql.append(" ci_or_srv.quan_total_medu     as quan_med,  ");
			sql.append(" ci_or_srv.id_medu       as id_unit_med,");
			sql.append(" ci_or_srv.id_route,ci_or_srv.id_routedes, ");
			sql.append(" ci_or_srv.id_boil,ci_or_srv.id_boildes, ");
			sql.append(" ci_or_srv.id_freq,ci_or_srv.id_org_srv, ");
			sql.append(" ci_or_srv.id_dep_srv,ci_or_srv.id_wg_or      as id_wg_srv, ");
			sql.append(" ci_or_srv.id_emp_srv,ci_or_srv.id_org_mp, ");
			sql.append(" ci_or_srv.id_dep_mp,ci_or_srv.id_su_mp, ");
			sql.append(" ci_or_srv.sd_su_mp,ci_or_srv.id_su_bl, ");
			sql.append(" ci_or_srv.sd_su_bl,ci_or_srv.dt_last_bl    as dt_bl_last, ");
			sql.append(" ci_or_srv.fg_mm,ci_or_srv.fg_indic,ci_or_srv.fg_propc, ");
			//sql.append(" case ci_or_srv.fg_selfpay  when 'Y' then 'N' when 'N' then 'Y' end as fg_self,ci_or_srv_mm.id_orsrvmm, ");
			sql.append(" ci_order.fg_orhp fg_self,ci_or_srv_mm.id_orsrvmm, ");
			sql.append(" ci_or_srv_mm.id_mm,ci_or_srv_mm.quan_cur, ");
			sql.append(" ci_or_srv_mm.quan_bed_medu, ");
			sql.append(" ci_or_srv_mm.id_pgku_cur   as id_unit_cur, ");
			sql.append(" ci_or_srv_mm.id_pgku_base  as id_unit_base, ");
			sql.append(" ci_or_srv_mm.factor        as factor_cb, ");
			sql.append(" ci_or_srv_mm.code_mm,ci_or_srv_mm.id_mmtp,ci_or_srv_mm.code_mm, ");
			sql.append(" bd_srv.code          as code_srv, ");
			sql.append(" en_ent.id_pripat     as id_pripat, ");
			sql.append(" ci_or_srv_mm.name_mm,ci_order.id_org,ci_order.id_grp, ");
			sql.append(" ci_order.name_or as des,ci_order.fg_bb, ");
			sql.append(" ci_order.no_bb,ci_order.dt_sign, ");
			sql.append(" ci_or_srv.name as presrption_name, ");
			sql.append(" ci_or_srv.fg_bl,");
			sql.append(" bdudidoc.name  prestp_name, ");
			sql.append(" ci_or_srv.id_dep_wh,  ");
			sql.append(" ci_or_srv.id_hp,ci_or_srv.ID_HPSRVTP,ci_or_srv.SD_HPSRVTP ,");
			sql.append(" dep.name  name_dep_srv, ");
			sql.append(" ci_order.applyno  code, ci_order.sv ci_sv,");
			sql.append(" depmp.name  name_dep_mp ,");
			sql.append(" ci_or_srv.fg_specill, ");
			sql.append(" ci_or_srv.id_srvca, ");
			sql.append(" ci_or_srv.fg_extdispense, ");
			sql.append("  en_ent_hp.id_hpkind, ");
			//sql.append("    ci_prn.code_prn presno, ");
			  
			 sql.append("  case  when ci_prn.code_prn is null and  ci_order.sd_srvtp like '02%' then ci_app_ris.code_app  ");
			 sql.append("   when ci_prn.code_prn is null and  ci_order.sd_srvtp like '03%' then ci_app_lis.code_app ");
			 sql.append("  when  ci_prn.code_prn is not null  then  ci_prn.code_prn  ");
			 sql.append("   end   presno, ");
			 sql.append("   ci_or_srv.eu_blmd,ci_or_srv.pri,ci_or_srv.pri_std,ci_or_srv.pri_ratio, ");
			 sql.append("  case  when ci_prn.code_prn is null and  ci_order.sd_srvtp like '02%' then '02'  ");
			//手动划价 需要查出 eu_blmd,pri,pri_std,pri_ratio by yzh 2017-10-24 09:57:03
			
		     sql.append("  when ci_prn.code_prn is null and  ci_order.sd_srvtp like '03%' then '03'   ");
		     sql.append("    when  ci_prn.code_prn is not null  then  '04'   ");
		     sql.append("    end   Prntype  ");
			sql.append(" from ci_order ci_order  ");
			sql.append(" inner join ci_or_srv ci_or_srv  ");
			sql.append(" on ci_order.id_or=ci_or_srv.id_or ");
			sql.append(" left join ci_prn_item ci_prn_item ");
			sql.append(" on ci_prn_item.id_biz = ci_or_srv.id_orsrv ");

			sql.append(" left join ci_prn ci_prn ");
			sql.append(" on ci_prn.id_ciprn = ci_prn_item.id_ciprn ");
            
			sql.append("  left outer join  ci_app_ris ci_app_ris    on ci_app_ris.id_or = ci_order.id_or   ");
			sql.append("  left outer join ci_app_lis_or ci_app_lis_or on ci_app_lis_or.id_or = ci_order.id_or ");
			sql.append("  left outer join  ci_app_lis ci_app_lis on ci_app_lis.id_ciapplissheet= ci_app_lis_or.id_ciapplissheet ");
		 

			sql.append(" left join ci_or_srv_mm ci_or_srv_mm ");
			sql.append(" on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv ");
			sql.append(" left outer join bd_srv bd_srv ");
			sql.append(" on bd_srv.id_srv = ci_or_srv.id_srv ");
			sql.append(" inner join en_ent en_ent  ");
			sql.append(" on ci_or_srv.id_en = en_ent.id_ent ");
			sql.append(" left outer join en_ent_hp on en_ent_hp.id_ent = en_ent.id_ent AND en_ent_hp.fg_MAJ='Y' ");
			sql.append(" left outer join bd_udidoc bdudidoc on bdudidoc.id_udidoc =ci_or_srv.id_srvtp ");
			sql.append(" left join bd_dep  dep on dep.id_dep = ci_or_srv.id_dep_srv ");
			sql.append(" left join bd_dep  depmp on depmp.id_dep = ci_or_srv.id_dep_mp  ");
			sql.append(" where en_ent.fg_canc='N' and ( ci_order.sd_su_or='");
			sql.append(ICiDictCodeConst.SD_SU_SIGN);
			sql.append("' or  ci_order.eu_orsrcmdtp ='0C' )");
//			sql.append("  and ci_or_srv.sd_su_bl ='0' ");
			sql.append("  and ci_or_srv.fg_bl = 'Y' and ci_or_srv.ds = 0 and ci_order.ds = 0 ");
			sql.append("     and   ci_or_srv.id_pres ='~' ");
			sql.append(" and   ci_or_srv.sd_srvtp  not like '01%' ");
			sql.append(" and   ci_or_srv.sd_srvtp  not like '02%' ");
			sql.append(" and   ci_or_srv.sd_srvtp  not like '03%' ");
			sql.append(" and  ci_or_srv.id_en='");
			sql.append(id_ent);
			sql.append("'");
			if(sd_su_bl != null && sd_su_bl.length > 0){
				sql.append(" and ci_or_srv.sd_su_bl  in (");
				sql.append(CiOrdUtils.IdsConveretCharacterString(sd_su_bl));
				sql.append(")");
						 
			}

			return sql.toString();
		}
		
		
		
}
