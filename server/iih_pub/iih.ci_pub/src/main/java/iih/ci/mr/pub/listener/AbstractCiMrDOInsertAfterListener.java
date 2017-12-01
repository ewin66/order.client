package iih.ci.mr.pub.listener;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.d.desc.CiMrDODesc;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public abstract class AbstractCiMrDOInsertAfterListener implements IBusinessListener{
	/**
	 * 执行
	 * @param event 事件
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//修改时候触发
		if(!(event.getSourceID().equals(CiMrDODesc.CLASS_FULLNAME)
			&& event.getEventType().equals(IEventType.TYPE_INSERT_AFTER)))return;
		
		//病历文书记录
		CiMrDO[] ciMrDOsNew = (CiMrDO[])((BDCommonEvent)event).getNewObjs();
		
		if(ArrayUtil.isEmpty(ciMrDOsNew))return;
		
		//执行修改命令
		this.doActionCiMrDOInsert(ciMrDOsNew);
	}
	/**
	 * 出院后，执行其他业务处理
	 * @param ciMrDOs
	 * @throws BizException 
	 */
	protected abstract void doActionCiMrDOInsert(CiMrDO[] ciMrDOsNew) throws BizException;
}
