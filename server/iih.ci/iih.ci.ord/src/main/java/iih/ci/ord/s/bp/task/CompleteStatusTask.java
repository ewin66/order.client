package iih.ci.ord.s.bp.task;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.orsrvsplitorder.d.WriteBackOrDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.s.CiOrdMaintainServiceImpl;
import iih.mp.nr.foreign.i.IForeignService;
import iih.mp.nr.mporplan.d.ExecuteStatusEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

public class CompleteStatusTask   implements IBackgroundWorkPlugin{

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0)
			throws BizException {
		// TODO Auto-generated method stub
		
		String idor = null;
		String dtlast = null;
				
		Map<String,Object> variableValueMap = arg0.getKeyMap();
		idor = (String) variableValueMap.get("idor");
		dtlast= (String) variableValueMap.get("dtlast");
		WriteBackOrDTO wbo=new WriteBackOrDTO();
		wbo.setId_or(idor);
		wbo.setDt_last_mp(new FDateTime(dtlast));
		wbo.setMp_tp(ExecuteStatusEnum.ENDEXECUTED);		
	
		IForeignService service=ServiceFinder.find(IForeignService.class);
		service.UpdateOrderStatus(new String[]{idor});
//		ICiOrdMaintainService service=ServiceFinder.find(ICiOrdMaintainService.class);
//		service.UpdateOrderSdMp(new WriteBackOrDTO[]{wbo});
		return null;
	}

}
