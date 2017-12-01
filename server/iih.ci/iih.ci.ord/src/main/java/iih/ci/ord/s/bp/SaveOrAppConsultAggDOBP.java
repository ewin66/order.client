/**
 * 
 */
package iih.ci.ord.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.cior.d.OrConsApAuditDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/**
 * @ClassName: SaveOrAppConsultAggDOBP
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年6月14日 下午4:20:50
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class SaveOrAppConsultAggDOBP {

 public    CiorappconsultAggDO[]   exe(CiorappconsultAggDO[] aggdos,String consultType) throws BizException{
	  if(aggdos == null || aggdos.length ==0||consultType == null) throw new BizException("会诊记录为空！   ");
	   //根据consultType  类型  0 应答，1 科室审批，2 医务审批    类型判断会诊状态
	   if(ICiDictCodeConst.CONS_RESPONSE.equals(consultType)){
		   setSdSuConsResponse(aggdos);
	   }else if(ICiDictCodeConst.CONS_DEPREVIEW.equals(consultType)){
		   setsetSdSuConsDept(aggdos);
	   }else if(ICiDictCodeConst.CONS_MADREVIEW.equals(consultType)){
		   setsetSdSuConsMedical(aggdos);
	   }
	   CiorappconsultAggDO[]  aggs = CiOrdAppUtils.getICiorappconsultCudService().save(aggdos);
		 return aggs;
	 }
 
   /**
    * 应答处理
    */
   private void setSdSuConsResponse(CiorappconsultAggDO[] aggdos) throws BizException{
	   if(aggdos== null || aggdos.length ==0)  throw new BizException("没有会诊的数据！");
	   CiorappconsultAggDO aggDO = aggdos[0];
	   CiordInviteConsDO[]  inviteConss = aggDO.getCiordInviteConsDO();
	    if(inviteConss != null && inviteConss.length >0){
	    	getResponse(inviteConss,aggDO);
	    }
    }
    /**
     * 应答标志
     * @param inviteConss
     */
    private void getResponse(CiordInviteConsDO[]  inviteConss,CiorappconsultAggDO aggDO){
    	Map map = new HashMap();
    	for(CiordInviteConsDO cons:inviteConss){
    		map.put(cons.getFg_response(), cons.getFg_response());
    	}
    	if(map != null && map.size() ==1){
    		aggDO.getParentDO().setId_su_cons(ICiDictCodeConst.ID_CI_CONS_KSYYD);
    		aggDO.getParentDO().setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_KSYYD);
    	}else if(map != null && map.size() > 1){
    		aggDO.getParentDO().setId_su_cons(ICiDictCodeConst.ID_CI_CONS_KSBFYD);
    		aggDO.getParentDO().setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_KSBFYD);
    	}
    	 
    }
   
   
   /**
    * 科室处理
    * @param aggdos
    */
   private void setsetSdSuConsDept(CiorappconsultAggDO[] aggdos)throws BizException{
	   if(aggdos== null || aggdos.length ==0)  throw new BizException("没有会诊的数据！");
	   CiorappconsultAggDO aggDO = aggdos[0];
	   //科室审批
	   OrConsApAuditDO[] apAuditDOS = aggDO.getOrConsApAuditDO();
	    if(apAuditDOS != null && apAuditDOS.length >0){
	    	for(OrConsApAuditDO audit:apAuditDOS){
	    		if(audit.getStatus()== DOStatus.NEW){
	    			if(audit.getFg_audit().booleanValue()){
	    				 if(aggDO.getParentDO().getFg_audit_admdep().booleanValue()){
	    					aggDO.getParentDO().setId_su_cons(ICiDictCodeConst.ID_CI_CONS_DYWSP);
		 	    	    	aggDO.getParentDO().setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_DYWSP); 
	    				 }else{
	    					aggDO.getParentDO().setId_su_cons(ICiDictCodeConst.ID_CI_CONS_DKSYD);
	 	    	    		aggDO.getParentDO().setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_DKSYD); 
	    				 }
	    				
	    				
	    			}else {
	    				aggDO.getParentDO().setId_su_cons(ICiDictCodeConst.ID_CI_CONS_KSBH);
	    	    		aggDO.getParentDO().setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_KSBH);
	    			}
	    			break;
	    		}
	    	}
	    	
	    }
	 /*  if(aggDO.getParentDO().getFg_audit_clidep().booleanValue()){
			    aggDO.getParentDO().setId_su_cons(ICiDictCodeConst.ID_CI_CONS_KSBFYD);
	    		aggDO.getParentDO().setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_KSBFYD);
	   }else{
		   aggDO.getParentDO().setId_su_cons(ICiDictCodeConst.ID_CI_CONS_KSBFYD);
   		   aggDO.getParentDO().setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_KSBFYD);
	   }*/
   }
   
   /**
    * 医务处处理
    * @param aggdos
    */
   private void setsetSdSuConsMedical(CiorappconsultAggDO[] aggdos)throws BizException{
	   if(aggdos== null || aggdos.length ==0)  throw new BizException("没有会诊的数据！");
	   CiorappconsultAggDO aggDO = aggdos[0];
	   OrConsApAuditDO[] apAuditDOS = aggDO.getOrConsApAuditDO();
	    if(apAuditDOS != null && apAuditDOS.length >0){
	    	for(OrConsApAuditDO audit:apAuditDOS){
	    		if(audit.getStatus()== DOStatus.NEW){
	    			if(audit.getFg_audit().booleanValue()){
	    				aggDO.getParentDO().setId_su_cons(ICiDictCodeConst.ID_CI_CONS_DKSYD);
	    	    		aggDO.getParentDO().setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_DKSYD);
	    			}else {
	    				aggDO.getParentDO().setId_su_cons(ICiDictCodeConst.ID_CI_CONS_YWBH);
	    	    		aggDO.getParentDO().setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_YWBH);
	    			}
	    			break;
	    		}
	    	}
	    	
	    }
   }
   
   
}
