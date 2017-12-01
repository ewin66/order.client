package iih.ci.rcm.pub.listener;

import iih.ci.rcm.hospitalreport.d.HospitalReportDO;
import iih.ci.rcm.hospitalreport.d.desc.HospitalReportDODesc;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public abstract class AbstractHospitalReportDOUpdateAfterListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//修改时候触发
				if(!(event.getSourceID().equals(HospitalReportDODesc.CLASS_FULLNAME)
					&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;
				
				
				HospitalReportDO[] hospitalReportDOs = (HospitalReportDO[])((BDCommonEvent)event).getNewObjs();
				
				
				if(ArrayUtil.isEmpty(hospitalReportDOs))return;
				
				//执行修改命令
				this.doActionCiMrDOChange(hospitalReportDOs);
	}
	
	protected abstract void doActionCiMrDOChange(HospitalReportDO[] hospitalReportDos) throws BizException;

}
