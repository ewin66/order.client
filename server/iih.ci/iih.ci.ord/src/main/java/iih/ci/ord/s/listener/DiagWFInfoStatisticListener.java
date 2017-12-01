package iih.ci.ord.s.listener;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.ICIMQConst;
import xap.lui.core.mq.MQMessage;
import xap.lui.core.mq.MQSender;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 临床诊断签署后，医疗诊断词频信息收集监听器
 */
public class DiagWFInfoStatisticListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		
		//事件源及事件类型判断
		if(!(event.getSourceID().equals(IBizPlugInSourecIDConst.CIDIAGAGGDO_FULLCLASSNAME)
			&& event.getEventType().equals(IEventType.TYPE_INSERT_AFTER)))return;
			
		//签署诊断的诊断数据及空判断逻辑
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(ArrayUtils.isEmpty(newObjs))return;
		
		//获得诊断主键字符串及空判断逻辑
		String[] idendiinfos=getIdEnDiDefInfo(newObjs);
		if(CiOrdUtils.isEmpty(idendiinfos))return;
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("idendiinfos", idendiinfos);
		map.put("context", CiOrdAppUtils.getEnvContext());
		
		MQMessage message=new MQMessage(ICIMQConst.MSGTYPE_CI_DIAG_WORD_FREQ, map);
		MQSender.sendMsgForLocal(message);
		
		//词频使用统计信息数据保存更新
	    //wordFreqInfoSave(bizcntinfos);
		
	}
	
	
	/**
	 * 获得就诊主键
	 * @param newObj
	 * @return
	 */
	private String getIdEnStr(Object newObj){
		if(CiOrdUtils.isEmpty(newObj))return null;
		CiDiagDO diagdo=((CidiagAggDO) newObj).getParentDO();
		if(!CiOrdUtils.isDiagSign(diagdo))return null;
		String idens=CiOrdUtils.getSqlCondStrWithComma(diagdo.getId_en());
		return idens.substring(1);
	}
	
	/**
	 * 获得诊断就诊与诊断数据信息
	 * @param newObjs
	 * @return
	 */
	private String[] getIdEnDiDefInfo(Object[] newObjs){
		//有效性校验
		if(CiOrdUtils.isEmpty(newObjs))return null;
		String[] rtn=new String[2];  //就诊主键  诊断主键串
		
		//获得就诊主键
		rtn[0]=getIdEnStr(newObjs[0]);
		if(CiOrdUtils.isEmpty(rtn[0]))return null;
		
		int iN=0;
		StringBuffer sb=new StringBuffer();
		CiDiagItemDO[] diagitmdos=((CidiagAggDO)newObjs[0]).getCiDiagItemDO();
		if(CiOrdUtils.isEmpty(diagitmdos))return null;
		
		
		//遍历  
		for(CiDiagItemDO diagitm: diagitmdos ){
			iN+=1;
			sb.append(CiOrdUtils.getSqlCondStrWithComma(diagitm.getId_didef()));
		}
		
		if(iN==0)return null; //判断
		
		//返回值
		rtn[1]=sb.toString().substring(1);
		return rtn;
	}
}
