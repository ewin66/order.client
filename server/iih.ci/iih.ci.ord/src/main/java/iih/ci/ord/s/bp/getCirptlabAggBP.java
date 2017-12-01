package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.cirptlab.d.CiRptLabDO;
import iih.ci.ord.cirptlab.d.CirptlabAggDO;
import iih.ci.ord.cirptlab.d.desc.CiRptLabDODesc;
import iih.ci.ord.cirptlab.i.ICirptlabRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 
 * @author li_zheng
 *
 */
public class getCirptlabAggBP {
    /**
     * 检验数据 agg
     * @param id_ent
     * @return
     * @throws BizException
     */
	 public CirptlabAggDO[] exec(String id_ent)throws BizException
	 {
		  
		 ICirptlabRService service =  CiOrdAppUtils.getCirptlabRService();
		 String ids = getCiOrderIds(id_ent);
		 if(ids != null ){
		  return  service.find(CiRptLabDODesc.TABLE_ALIAS_NAME+"."+CiRptLabDO.ID_OR+" in "+ids,CiRptLabDO.ID_OR, FBoolean.FALSE);
		 }
		 return null;
	 }
	 
	 /**
	  * 根据就诊号，取得 医嘱集合
	  * @param id_ent
	  * @return
	  * @throws BizException
	  */
	 private String getCiOrderIds(String id_ent)throws BizException{
		 
		 String ids =  null;
		 
		 ICiorderMDORService service = CiOrdAppUtils.getCiorderMDORService();
		 CiOrderDO[] ciorderdo = service.find(CiOrderDODesc.TABLE_ALIAS_NAME+"."+CiOrderDO.ID_EN +" = '"+id_ent+"' and "+CiOrderDODesc.TABLE_ALIAS_NAME+"."+CiOrderDO.SD_SRVTP+" like '"+IBdSrvDictCodeConst.SD_SRVTP_LIS+"%'", "", FBoolean.FALSE);
	     if(ciorderdo!= null && ciorderdo.length >0 ){
	    	 ids ="(";
	    	 for(int i=0;i<ciorderdo.length;i++){
	    		
	    		 if(i == ciorderdo.length-1 ){
	    			 ids += "'"+ ciorderdo[i].getId_or()+"'";
	    		 }else{
	    			 ids += "'"+ ciorderdo[i].getId_or()+"',";
	    		 }
	    	 }
	    	 ids += ")";
	     }
	     return ids;
	 }
	 
	 
}
