package iih.ci.rcm.pub.listener;

import iih.ci.rcm.contagion.d.ContagionDO;
import iih.ci.rcm.contagion.d.desc.ContagionDODesc;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public abstract class AbstractContagionDOUpdateAfterListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//修改时候触发
				if(!(event.getSourceID().equals(ContagionDODesc.CLASS_FULLNAME)
					&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;
				
				
				ContagionDO[] contagionDOs = (ContagionDO[])((BDCommonEvent)event).getNewObjs();
				
				
				if(ArrayUtil.isEmpty(contagionDOs))return;
				
				//执行修改命令
				this.doActionCiMrDOChange(contagionDOs);
	}
	
	protected abstract void doActionCiMrDOChange(ContagionDO[] contagionDOs) throws BizException;

}
