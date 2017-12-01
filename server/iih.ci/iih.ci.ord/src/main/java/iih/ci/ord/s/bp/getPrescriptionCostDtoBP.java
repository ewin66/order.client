/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.PrescriptionCostDtoObsAndLabQry;
import iih.ci.ord.s.bp.qry.PrescriptionCostDtoQry;
import iih.ci.ord.s.bp.qry.RecipeDTOQry;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @ClassName: getPrescriptionCostDtoBP
 * @Description:  按处方收费
 * @author Comsys-li_zheng
 * @date 2016年4月18日 上午11:21:52
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getPrescriptionCostDtoBP {
	//LogbackLogger  loginfo = new LogbackLogger(Logger.class);
       /**
        *  未计费服务信息（药品）
        * @param patid
        * @param dtSignB
        * @param dtSignE
        * @param code_entp
        * @param Id_org
        * @return
        * @throws BizException
        */
	   public  PrescriptionCostDto[] exe(String patid,FDateTime dtSignB,FDateTime dtSignE,String code_entp,String Id_org)throws BizException{
		   PrescriptionCostDtoQry qry = new PrescriptionCostDtoQry(patid,dtSignB,dtSignE,code_entp,Id_org);
		   
		   PrescriptionCostDto[] rtn =	(PrescriptionCostDto[])AppFwUtil.getDORstWithDao(qry, PrescriptionCostDto.class);
		   //loginfo.info("rtn is null");
		   return rtn;
		}
	
	   
	   /**
        *  未计费服务信息（非药品 ，检查检验）
        * @param patid
        * @param dtSignB
        * @param dtSignE
        * @param code_entp
        * @param Id_org
        * @return
        * @throws BizException
        */
	   public  PrescriptionCostDto[] exeObsAndLab(String patid,FDateTime dtSignB,FDateTime dtSignE,String code_entp,String Id_org)throws BizException{
		   PrescriptionCostDtoObsAndLabQry qry = new PrescriptionCostDtoObsAndLabQry(patid,dtSignB,dtSignE,code_entp,Id_org);
		   
		   PrescriptionCostDto[] rtn =	(PrescriptionCostDto[])AppFwUtil.getDORstWithDao(qry, PrescriptionCostDto.class);
		   //loginfo.info("rtn is null");
		   return rtn;
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
	        *  未计费服务信息
	        * @param patid
	        * @param dtSignB
	        * @param dtSignE
	        * @param code_entp
	        * @param Id_org
	        * @return
	        * @throws BizException
	        */
	  public PrescriptionConstBaseDto exe2(String patid,FDateTime dtSignB,FDateTime dtSignE,String code_entp,String Id_org) throws BizException{
		  
		  PrescriptionConstBaseDto baseDto = new PrescriptionConstBaseDto();
		  //药品
		   long StartTime = System.currentTimeMillis();
		  PrescriptionCostDto[] rtn = this.exe(patid, dtSignB, dtSignE, code_entp, Id_org);
		  CiOrdUtils.LogerOutInfo("PrescriptionConstBaseDto exe2  的this.exe  耗时 :"+(System.currentTimeMillis()- StartTime));
		  // 检查检验
		  long StartTime2 = System.currentTimeMillis();
		  PrescriptionCostDto[] rtnobsAndLab = this.exeObsAndLab(patid, dtSignB, dtSignE, code_entp, Id_org);
		  CiOrdUtils.LogerOutInfo("PrescriptionConstBaseDto exe2  的this.exeObsAndLab  耗时 :"+(System.currentTimeMillis()- StartTime2));
		  //检查检验虚拟处方
		  FArrayList prescrptionObsAndLabList = new FArrayList();
		  long StartTime3 = System.currentTimeMillis();
		 /* String[] str = null;
		  if(rtn !=  null && rtn.length > 0){
			  str=  CiOrdUtils.getDiag(rtn[0].getId_en());
		  }else if(rtnobsAndLab != null && rtnobsAndLab.length > 0){
			  str=  CiOrdUtils.getDiag(rtnobsAndLab[0].getId_en());
		  }*/
		  
		  //if(rtn == null || rtn.length ==0) return  null;
		  FArrayList prescriptionList = new FArrayList();
		  Map map = new HashMap();
		  for( PrescriptionCostDto presDto:rtn){
			   if(presDto.getPresno() == null){
				   presDto.setPresno(presDto.getCode());
			   }
			  prescriptionList.add(presDto);
			  map.put(presDto.getId_pres(), presDto.getId_pres());
		  }
		   String id_en ="";
		   String[] str = null;
		  for(PrescriptionCostDto presDto:rtnobsAndLab){
			  prescriptionList.add(presDto);
			  if(!id_en.equals(presDto.getId_en())){
				  str=  CiOrdUtils.getDiag(rtnobsAndLab[0].getId_en());
			  }
			  id_en = presDto.getId_en();
			  //检查检验 虚拟处方
			  prescrptionObsAndLabList.add(this.getPrescrptionObsAndLab(presDto,str));
			  
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
	   * @param id_repres
	   * @return
	   * @throws BizException
	   */
	  public  RecipeDTO[] exe3(String[] id_repres)throws BizException{
		 
		  if(id_repres == null || id_repres.length == 0) return null;
		  Map map= new HashMap();
		  for(String id:id_repres){
			 map.put(id, id);
		  }
		   FArrayList list =  this.getPress(map);
		  return (RecipeDTO[])list.toArray();
	  }
	  
}
