package iih.ci.ord.pub.listener;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
/**
 * 医嘱下达侦听器抽象类
 */
public abstract class AbstractOrSignListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		
		//事件源及事件类型判断    ICiEventConst.CIOR_STATUS_EVENT_SOURCEID   2016-08-26forlc
		if(!(event.getSourceID().equals(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID)
			&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;
		
		//签署成功的医嘱数据及空判断逻辑
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(ArrayUtils.isEmpty(newObjs))return;
		
		//获得签署后医嘱数据信息
		CiOrderDO[] ors=getOrdInfo8Status(newObjs);
		if(ors==null || ors.length==0)
			return;
		
		//医嘱签署后，实现自身业务逻辑
		doYourActionAfterOrSign(ors);
		
	}
	
	/**
	 * 医嘱签署后，实现自身业务逻辑
	 * @param ors
	 * @throws BizException 
	 */
	protected abstract void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException;
	
	/**
	 * 是否为特定医嘱判断
	 * 用户可重写该方法
	 * 判断逻辑可调用CiOrPubUtils.getCiOrderType(or)
	 * @param ors
	 * @return
	 */
	protected boolean isSpecificOrder(CiOrderDO or){return true;}
	
	/**
	 * 按医嘱状态过滤检查
	 * @param ordo
	 * @return
	 */
	protected boolean isOrStatusCheck(CiOrderDO ordo){
		return CiOrPubUtils.isOrSign(ordo);
	}


	/**
	 * 获得签署医嘱信息
	 * @param newObjs
	 * @return
	 */
	protected CiOrderDO[] getOrdInfo8Status(Object[] newObjs){
		CiOrderDO ordo;
		ArrayList<CiOrderDO> rtn=new ArrayList<CiOrderDO>();
		
		//遍历
		for(Object obj: newObjs ){
			ordo=(CiOrderDO) obj;
			//是否为下达医嘱
			//if(!CiOrPubUtils.isOrSign(ordo))continue;
			if(!isOrStatusCheck(ordo))continue;
			
			//是否为特定类型医嘱
			if(!isSpecificOrder(ordo))continue;
			
			//加入列表中
			rtn.add(ordo);
		}
		
		//空判断
		if(rtn==null || rtn.size()==0)return null;
		
		//返回值
		return rtn.toArray(new CiOrderDO[0]);
	}


}
