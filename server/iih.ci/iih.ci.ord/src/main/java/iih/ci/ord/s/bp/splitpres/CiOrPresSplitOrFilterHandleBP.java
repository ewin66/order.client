package iih.ci.ord.s.bp.splitpres;

import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 临床医嘱分方时，分方医嘱过滤与处理操作BP
 */
public class CiOrPresSplitOrFilterHandleBP {
	/**
	 * 临床医嘱分方时，分方医嘱过滤与处理
	 * @param ciorder
	 * @param session
	 * @return
	 * @throws BizException
	 */
	public CiOrderDO[] exec(CiOrderDO[] ciorder,CiOrSessionDO session )throws BizException{
		String code_entp = ciorder[0].getCode_entp();
		if (CiOrdUtils.isEmpty(ciorder) || !CiOrdUtils.isOpUrgentWf(code_entp)) {
			if (session != null) {
				CiOrdAppUtils.getCiorsessionService().delete(new CiOrSessionDO[] { session });
			}
			if (CiOrdUtils.isIpWf(code_entp)) { //住院医嘱的处理
				//住院医嘱时,获得需分方医嘱集合
				ciorder = getIpHerbFgpresoutpOr(ciorder);
				if (CiOrdUtils.isEmpty(ciorder))
					return null;
			} else {
				return null;
			}
		}

		//返回
		return ciorder;
	}
	
	/**
	 * 住院医嘱时,获得需分方医嘱集合   出院带药 草药 和 毒麻药品 
	 * @param ciors
	 * @return
	 */
    private CiOrderDO[] getIpHerbFgpresoutpOr(CiOrderDO[] ciors)throws BizException{
   	 List<CiOrderDO> list=new ArrayList<CiOrderDO>();
   	 Map<String, CiOrderDO> map = new HashMap();
   	 for (CiOrderDO ciOrderDO : ciors) {
			if(ciOrderDO.getFg_pres_outp()==FBoolean.TRUE || ciOrderDO.getSd_srvtp().startsWith("0103")){			
				list.add(ciOrderDO);
			}else{
				map.put(ciOrderDO.getId_or(), ciOrderDO);
			}
		}
   	 //住院的毒麻药品
     judgePoisonousAndHempDrug(list,map);
   	 if(list.size()>0)
   		 return list.toArray(new CiOrderDO[0]);
   	 return null;
    }
    
    /**
     * 
     * @param list
     * @param map
     */
    private void  judgePoisonousAndHempDrug(List list,Map<String,CiOrderDO> map)throws BizException{
    	if(map != null && map.size() >0){
    	  String id_or = getIdOr(map);
    	  List<OrdSrvMmDO> srvmmList = getPoisonousList(id_or);
    	  if(srvmmList != null && srvmmList.size() >0){
    		 for(OrdSrvMmDO ordSrvMM: srvmmList){
    			 list.add(map.get(ordSrvMM.getId_pois()));
    		 } 
    	  }
    	}
    }
    
    /**
     * 医嘱的主键
     * @param map
     * @return
     */
    private String getIdOr(Map<String,CiOrderDO> map){
    	String id_or = "";
    	if(map != null && map.size() >0){
    		for(String key :map.keySet()){
    			id_or +=",'"+key+"'";
    		}
    		if(id_or != ""){
    			id_or = id_or.substring(1);
    		}
    	}
    	return id_or;
    }
    private  List<OrdSrvMmDO> getPoisonousList(String id_or)throws BizException{
    	String sql = " select ci_order.id_or id_pois , mm.sd_pois "
    			+ " from ci_order ci_order , ci_or_srv orsrv , "
    			+ " ci_or_srv_mm mm "
                + " where ci_order.id_or = orsrv.id_or"
                + "  and  orsrv.id_orsrv = mm.id_orsrv"
                + "  and mm.sd_pois not in ('0','5')"
                + "  and ci_order.id_or in ("+id_or+")";
    	
    	List<OrdSrvMmDO> hpdos = (List<OrdSrvMmDO>)new DAFacade().execQuery(sql, new BeanListHandler(OrdSrvMmDO.class)); 
    	return hpdos;
    }
    
}
