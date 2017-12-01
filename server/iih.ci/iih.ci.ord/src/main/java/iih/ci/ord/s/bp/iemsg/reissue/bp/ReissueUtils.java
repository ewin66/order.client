package iih.ci.ord.s.bp.iemsg.reissue.bp;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.i.ICiorderRService;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class ReissueUtils {
	
	
	public static Map<String,FDouble> getorpri(String idors) throws BizException{
		
		Map<String,FDouble> map=new HashMap<String, FDouble>();
		ICiorderRService ciorservice=ServiceFinder.find(ICiorderRService.class);
		CiorderAggDO[] ciagg=ciorservice.find(CiOrderDODesc.TABLE_ALIAS_NAME+".id_or in  (" +idors+ ")", "", FBoolean.FALSE);
		for (CiorderAggDO ciorderAggDO : ciagg) {
			
			FDouble fee=FDouble.ZERO_DBL;
			OrdSrvDO[] srvs=ciorderAggDO.getOrdSrvDO();
			for (OrdSrvDO ordSrvDO : srvs) {
				if(ordSrvDO.getFg_bl().booleanValue()==FBoolean.TRUE.booleanValue()){
				fee=fee.add(ordSrvDO.getQuan_total_medu().doubleValue()*ordSrvDO.getPri().doubleValue());
				}
			}
			map.put(ciorderAggDO.getParentDO().getId_or(), fee);
		}
		return map;
		
	}

}
