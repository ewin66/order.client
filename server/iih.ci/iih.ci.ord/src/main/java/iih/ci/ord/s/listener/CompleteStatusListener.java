package iih.ci.ord.s.listener;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.listener.OrMpStatusModTimerGenListener;
import iih.mp.nr.foreign.i.IForeignService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.scheduler.itf.ISchedulerServiceAPI;

/**
 * 下达用血医嘱侦听器插件
 */
public class CompleteStatusListener extends OrMpStatusModTimerGenListener {

	@Override
	protected void doYourActionAfterOrStopCheck(CiOrderDO[] ors) throws BizException {

		List<CiOrderDO> listOrder = new ArrayList<CiOrderDO>();
		// 在此处增加你的代码实现
		for (CiOrderDO ciOrderDO : ors) {

			if (ciOrderDO.getDt_chk_stop().compareTo(ciOrderDO.getDt_end()) >= 0) {
				
				listOrder.add(ciOrderDO);
				
			} else {

				FMap2 variableValueMap = new FMap2();
				variableValueMap.put("idor", ciOrderDO.getId_or());
				variableValueMap.put("dtlast", ciOrderDO.getDt_last_mp().toString());
				//BackgroundWorkUtil.createBgWorkByAlertTypeCode("CompleteStatus", variableValueMap, ciOrderDO.getDt_end());
				
				ISchedulerServiceAPI api = ServiceFinder.find(ISchedulerServiceAPI.class);
				String taskId =api.submitTask0("CompleteStatus", ciOrderDO.getDt_end(), variableValueMap);
				
			}
		}

		if (listOrder.size()>0) {
			
			//ToDo
			List<String> list=new ArrayList<String>();
			for (CiOrderDO ciOrderDO : listOrder) {
				list.add(ciOrderDO.getId_or());
			}
			IForeignService service=ServiceFinder.find(IForeignService.class);
			service.UpdateOrderStatus(list.toArray(new String[1]));

		}
		
	}

}
