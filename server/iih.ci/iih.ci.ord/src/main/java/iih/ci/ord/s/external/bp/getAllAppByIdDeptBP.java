package iih.ci.ord.s.external.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.utils.BdEnvContextUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.appobsdto.d.AppObsDto;
import iih.ci.ord.dto.enappointmentdto.d.EnappointmentDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.getAppLabDtoBP;
import iih.ci.ord.s.bp.getAppObsDtoBP;
import iih.ci.ord.s.bp.getAppPathgyDtoBP;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
/**
 * 根据执行科室查询申请单
 * @author li_zheng
 *
 */
public class getAllAppByIdDeptBP {

	 public static getAllAppByIdDeptBP instance;
	 private getAllAppByIdDeptBP(){};
	 public static getAllAppByIdDeptBP getInstance()throws BizException{
		 if(instance == null){
			instance = new getAllAppByIdDeptBP(); 
		 }
		 return instance;
	 }
	
	
	/**
	 * 根据科室查询申请单
	 * @param id_dep_exe
	 * @param entps
	 * @param lab_status
	 * @param types
	 * @param dtSignB
	 * @param dtSignE
	 * @return
	 * @throws BizException
	 */
	public  AppObsDto[] getAllAppRequisitionByIdDeptBP(EnappointmentDTO enappointmentDTO)throws BizException{
       //li_cheng 增加管控
		String  orgsql=BdEnvContextUtil.processEnvContext(new CiOrderDO(), "ci_order");
		// 拼接sql
	    StringBuffer condition =  getSql(enappointmentDTO);
	    condition.append("  and ").append(orgsql);
	  //  查询 那些医疗单
	    
	    if(enappointmentDTO != null && enappointmentDTO.getSd_srvtp() != null){
	     FMap2 map =  enappointmentDTO.getSd_srvtp();
	     AppObsDto[] obsDto=null;
	     AppObsDto[] labDto = null;
	     AppObsDto[] pathgyDto = null;
	     //检查
	    if(map.containsKey(IBdSrvDictCodeConst.SD_SRVTP_RIS)){
	      obsDto = getAppObsDtoBP.getInstance().exce(condition.toString());
	    }
	    //检验
		if(map.containsKey(IBdSrvDictCodeConst.SD_SRVTP_LIS)){
			labDto = getAppLabDtoBP.getInstance().exce(condition.toString()); 	
		 }
		//病理
		if(map.containsKey(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)){
		   pathgyDto =getAppPathgyDtoBP.getInstance().exce(condition.toString());		
		}

       //整理集合
	    AppObsDto[] both = (AppObsDto[]) ArrayUtils.addAll(obsDto, labDto);
	    AppObsDto[] both2 = (AppObsDto[]) ArrayUtils.addAll(both, pathgyDto);
	    return both2;
	    }
  	 return null;
   }
   /**
    * 
    * @param types
    * @return
    */
	private  Map  getConvertArrayToMap(String[] types){
		Map map = new HashedMap();
		if(types != null && types.length >0){
		 for(String type:types){
			 map.put(type, type);
		 }	
		}
		return map;
	}
	/**
	 * 
	 * @param id_dep_exe
	 * @param entps
	 * @param lab_status
	 * @param dtSignB
	 * @param dtSignE
	 * @return
	 */
	private StringBuffer getSql(EnappointmentDTO enappointmentDTO)throws BizException{
		
		 StringBuffer condition =  new StringBuffer();
 		  if(enappointmentDTO.getId_dept() != null){
	    		  condition.append(" and CI_ORDER.id_dep_mp ='") ;
	    		  condition.append(enappointmentDTO.getId_dept());
	    		  condition.append("'");
	    	  }
	    	  if(enappointmentDTO.getEn_entp() != null && enappointmentDTO.getEn_entp().size() >0){
	    		  condition.append(" and CI_ORDER.code_entp in (") ;
	    		  condition.append(CiOrdUtils.getMapConveretstr(enappointmentDTO.getEn_entp()));
	    		  condition.append(")");
	    	  }
	    	  if(enappointmentDTO.getPayment() != null && enappointmentDTO.getPayment().size() >0){
	    		  condition.append(" and CI_ORDER.sd_su_bl in (") ;
	    		  condition.append(CiOrdUtils.getMapConveretstr(enappointmentDTO.getPayment()));
	    		  condition.append(")");
	    	  }else{
	    		  condition.append(" and CI_ORDER.sd_su_bl !='2'  ") ;
	    	  }
	    	  if(enappointmentDTO.getDtsignb() != null){
	    		  condition.append(" and CI_ORDER.dt_effe >='") ;
	    		  condition.append(enappointmentDTO.getDtsignb());
	    		  condition.append("'");
	    	  }
	    	  if(enappointmentDTO.getDtsigne() != null){
	    		  condition.append("  and CI_ORDER.dt_effe <='") ;
	    		  condition.append(enappointmentDTO.getDtsigne());
	    		  condition.append("'");
	    	  }
	    	  return condition;
	}
	
}
