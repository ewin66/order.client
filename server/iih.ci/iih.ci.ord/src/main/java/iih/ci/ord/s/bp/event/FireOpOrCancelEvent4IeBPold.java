package iih.ci.ord.s.bp.event;

import xap.ip.cfg.XipCfg;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IEventType;
import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.iemsg.d.IEOpOrCancStpEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.AbstractOrCancelListener;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4CancStpBP;

/**
 * 门诊医嘱作废事件侦听并进行集成平台门诊事件发送 （集成平台事件）
 */
public class FireOpOrCancelEvent4IeBPold extends AbstractOrCancelListener {

	@Override
	protected void doYourActionAfterOrCancel(CiOrderDO[] ors) throws BizException {
		// 如果inDb=disable，那么所有的消息不入库
		if (!XipCfg.instance().isEnableInDb()) {
			return;
		}
		// 空判断
		if (CiOrdUtils.isEmpty(ors))return;

		// 是否门诊医嘱作废  并获得门诊医嘱ID字串
		String id_ors = getOpWfOrIdStr(ors);
		if (CiOrdUtils.isEmpty(id_ors))return;
		
		// 发布IE门诊医嘱作废事件
	//	fireEvent4Ie(id_ors);
	}
	
	/**
	 * 获得门诊医嘱ID字串
	 * @param ors
	 * @return
	 */
	private String getOpWfOrIdStr(CiOrderDO[] ors) {
		//参数设置
		String rtnstr=null;
		
		// 遍历
		for (int i = 0; i < ors.length; i++) {
			//门诊医嘱判断
			if (!CiOrdUtils.isOpWf(ors[i].getCode_entp()))continue;
			
			rtnstr+=CiOrdUtils.COMMA_STR+ors[i].getId_or();
		}
		
		//空判断
		if(CiOrdUtils.isEmpty(rtnstr))return null;
		
		//返回值处理
		return rtnstr.substring(1);
	}

	/**
	 * 触发门诊作废事件
	 * 集成平台用
	 * @param id_ors
	 * @throws BizException
	 */
	private void fireEvent4Ie(String id_ors) throws BizException {
		// 有效性验证
		if (CiOrdUtils.isEmpty(id_ors))return;

		// 集成平台作废医嘱消息体数据生成并触发相应事件
		fireEvent4Cancel(id_ors, ICiIEEventConst.EVENT_IE_CIOR_OP_CANC_STOP);

	}
	
	/**
	 * 事件发送 门诊作废医嘱
	 * 
	 * @param id_ors
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Cancel(String id_ors, String ieEventType) throws BizException {
		// 生成集成平台门诊作废医嘱服务数据信息
		GetIEOpMsgInfo4CancStpBP bp = new GetIEOpMsgInfo4CancStpBP();
		IEOpOrCancStpEnDTO[] msgdos = bp.exec(id_ors);
		if (CiOrdUtils.isEmpty(msgdos))return;

		// 触发事件
		CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, msgdos);
	}


}
