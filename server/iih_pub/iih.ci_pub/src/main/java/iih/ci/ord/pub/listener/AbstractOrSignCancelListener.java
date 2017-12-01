package iih.ci.ord.pub.listener;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
/**
 * 医嘱签署撤回侦听器抽象类
 */
public abstract class AbstractOrSignCancelListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		
		if(!(event.getSourceID().equals(ICiEventConst.CIOR_STATUS_SIGN2OPEN_EVENT_SOURCEID)
			&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;
		
		//签署撤回成功的医嘱数据及空判断逻辑
		BDCommonEvent dbevent=(BDCommonEvent) event;

		Object[] newObjs=dbevent.getNewObjs();
		//Object[] oldObjs=dbevent.getOldObjs();
		if(ArrayUtils.isEmpty(newObjs))return;
		
		//获得签署撤回医嘱集合
		CiOrderDO[] ors=getOrdInfo4SignCancel(newObjs);
		if(ors==null || ors.length==0)
			return;
		
		//医嘱签署撤回后，实现自身业务逻辑
		doYourActionAfterOrSignCancel(ors);
		
	}
	
	/**
	 * 医嘱撤销签署后，实现自身业务逻辑
	 * @param ors
	 * @throws BizException 
	 */
	protected abstract void doYourActionAfterOrSignCancel(CiOrderDO[] ors) throws BizException;
	
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
	protected boolean isOrSignCancelCheck(CiOrderDO newor,CiOrderDO oldor){
		return CiOrPubUtils.isOrSignCancel(newor,oldor);
	}


	/**
	 * 获得签署医嘱信息
	 * @param newObjs
	 * @return
	 */
	private CiOrderDO[] getOrdInfo4SignCancel(Object[] newObjs){
		CiOrderDO ordo=null;
		CiOrderDO oldordo=null;
		int iN=newObjs.length;  //oldObjs与 newObjs  同长同序
		ArrayList<CiOrderDO> rtn=new ArrayList<CiOrderDO>();
	//	if(oldObjs == null || newObjs == null ) return null;
		//遍历  Object obj: newObjs
		for(int i=0;i<iN;i++ ){
//			oldordo=(CiOrderDO)oldObjs[i];
			ordo=(CiOrderDO)newObjs[i];
			
//			//是否为下达医嘱
//			if(!isOrSignCancelCheck(ordo,oldordo))continue;
//			
//			//是否为特定类型医嘱
//			if(!isSpecificOrder(ordo))continue;
			
			//加入列表中
			rtn.add(ordo);
		}
		
		//空判断
		if(rtn==null || rtn.size()==0)return null;
		
		//返回值
		return rtn.toArray(new CiOrderDO[0]);
	}


}
