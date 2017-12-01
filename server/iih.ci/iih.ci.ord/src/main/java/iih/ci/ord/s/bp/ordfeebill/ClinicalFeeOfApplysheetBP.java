package iih.ci.ord.s.bp.ordfeebill;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;

/**
 * 申请单模式下的临床费用
 * @author wangqzh
 *
 */
public class ClinicalFeeOfApplysheetBP {
	
	protected CiorderAggDO[] exec(CiorderAggDO[] o){
		if (null == o){
			return null;
		}
		
		List<CiorderAggDO> ordList = new ArrayList<CiorderAggDO>();
		
		for (CiorderAggDO agg : o){
			// ciorder.fg_quick = 'N'
			if (!FeebillUtils.IsTreatMode(agg.getParentDO())){

				List<OrdSrvDO> srvList = new ArrayList<OrdSrvDO>();
				for (OrdSrvDO srv : agg.getOrdSrvDO()){
					if (FeebillUtils.IsClinicalFee(srv)&&FeebillUtils.IsBl(srv)){
						srvList.add(srv);
					}
				}
				
				if (srvList.size() > 0){
					CiorderAggDO rtnAggDO = new CiorderAggDO();
					rtnAggDO.setParentDO(agg.getParentDO());
					rtnAggDO.setOrdSrvDO(srvList.toArray(new OrdSrvDO[srvList.size()]));
					ordList.add(rtnAggDO);
				}
			}
		}
		
		return ordList.toArray(new CiorderAggDO[ordList.size()]);
		
	}
}
