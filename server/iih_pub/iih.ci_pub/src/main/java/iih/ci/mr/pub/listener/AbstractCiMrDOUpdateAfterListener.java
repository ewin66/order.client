package iih.ci.mr.pub.listener;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.d.desc.CiMrDODesc;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public abstract class AbstractCiMrDOUpdateAfterListener  implements IBusinessListener {

	/**
	 * 执行
	 * @param event 事件
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//修改时候触发
		if(!(event.getSourceID().equals(CiMrDODesc.CLASS_FULLNAME)
			&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;
		
		//病历文书记录
		CiMrDO[] ciMrDOsNew = (CiMrDO[])((BDCommonEvent)event).getNewObjs();
		CiMrDO[] ciMrDOsOld = (CiMrDO[])((BDCommonEvent)event).getOldObjs();
		
		if(ArrayUtil.isEmpty(ciMrDOsNew)||ArrayUtil.isEmpty(ciMrDOsOld))return;
		
		//执行修改命令
		this.doActionCiMrDOChange(ciMrDOsNew,ciMrDOsOld);
	}
	/**
	 * 出院后，执行其他业务处理
	 * @param ciMrDOs
	 * @throws BizException 
	 */
	protected abstract void doActionCiMrDOChange(CiMrDO[] ciMrDOsNew,CiMrDO[] ciMrDOsOld) throws BizException;
}
