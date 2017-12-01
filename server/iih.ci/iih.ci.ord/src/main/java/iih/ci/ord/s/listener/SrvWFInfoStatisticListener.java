package iih.ci.ord.s.listener;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.ICIMQConst;
import iih.ci.ord.pub.listener.ICiEventConst;
import xap.lui.core.mq.MQMessage;
import xap.lui.core.mq.MQSender;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 临床医嘱签署后，医疗服务词频信息收集监听器
 */
public class SrvWFInfoStatisticListener implements IBusinessListener {

	public void doAction(IBusinessEvent event) throws BizException {
		
		//事件源及事件类型判断
		if(!(event.getSourceID().equals(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID)
			&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;
			
		//签署成功的医嘱数据及空判断逻辑
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(ArrayUtils.isEmpty(newObjs))return;
		
		//获得医嘱主键字符串及空判断逻辑
		String idors=getIdOrsStr(newObjs);
		if(CiOrdUtils.isEmpty(idors))return;
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("idors", idors);
		map.put("ctx", CiOrdAppUtils.getEnvContext());
		
		MQMessage message=new MQMessage(ICIMQConst.MSGTYPE_CI_SRV_WORD_FREQ, map);
		MQSender.sendMsgForLocal(message);
	}
	
	/**
	 * 获得医嘱主键字符串
	 * @param newObjs
	 * @return
	 */
	private String getIdOrsStr(Object[] newObjs){
		CiOrderDO ordo;
		int iN=0;
		StringBuffer sb=new StringBuffer();
		
		//遍历
		for(Object obj: newObjs ){
			ordo=(CiOrderDO) obj;
			if(!CiOrdUtils.isOrSign(ordo))continue;
			iN+=1;
			sb.append(CiOrdUtils.getSqlCondStrWithComma(ordo.getId_or()));
		}
		
		if(iN==0)return null;
		
		//返回值
		return sb.toString().substring(1);
	}
}
