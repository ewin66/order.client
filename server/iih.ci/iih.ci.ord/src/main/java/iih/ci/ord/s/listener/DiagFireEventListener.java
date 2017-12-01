/**
 * 
 */
package iih.ci.ord.s.listener;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.ord.iemsg.d.IEOpPvDiagEnDTO;
import iih.ci.ord.iemsg.d.IEPvDiagEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfoDiagBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfoDiagBP;

import org.apache.commons.lang3.ArrayUtils;

import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * BS301：住院诊断
 * 
 * @ClassName: DiagFireEventListener
 * @Description: 临床事件
 * @author Comsys-li_zheng
 * @date 2016年9月28日 上午11:36:09
 * @Package iih.ci.ord.s.listener Copyright: Copyright (c) 2011 Company: 北大医疗信息技术有限责任公司
 */
public class DiagFireEventListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {

		// 事件源及事件类型判断
		if (!(event.getSourceID().equals(IBizPlugInSourecIDConst.CIDIAGAGGDO_FULLCLASSNAME)
				&& (event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)
						|| event.getEventType().equals(IEventType.TYPE_INSERT_AFTER))))
			return;

		// 签署诊断的诊断数据及空判断逻辑
		BDCommonEvent dbevent = (BDCommonEvent) event;
		Object[] newObjs = dbevent.getNewObjs();
		if (ArrayUtils.isEmpty(newObjs))
			return;

		// 获得诊断主键字符串及空判断逻辑
		CidiagAggDO[] aggDO = getCidiagAggDO(newObjs);
		if (aggDO != null && aggDO.length > 0 && aggDO[0].getParentDO() != null
				&& aggDO[0].getParentDO().getFg_sign() != null && aggDO[0].getParentDO().getFg_sign().booleanValue()) {

			CiDiagDO cidiagDO = aggDO[0].getParentDO();
			
			// 住院
			if (IEnDictCodeConst.SD_DIAGTYPE_HOSPITAL_IN.equals(cidiagDO.getCode_entp())) {
				GetIEMsgInfoDiagBP bp = new GetIEMsgInfoDiagBP();
				IEPvDiagEnDTO[] pvDiagenDTO = bp.exec(aggDO[0], cidiagDO.getId_en());
				// 触发事件
				for (IEPvDiagEnDTO d : pvDiagenDTO) {
					DomainBusinessUserObj dbuo = new DomainBusinessUserObj(d, BusiType.ZY, d.getBedno(), "");
					MsgObj msg = new MsgObj();
					msg.setInteractionCode("new");
					dbuo.setMsgObj(msg);
					CiOrdUtils.fireEvent(ICiIEEventConst.EVENT_IE_CIDIAG_SIGN, IEventType.TYPE_UPDATE_AFTER,
							new BaseDO[] { dbuo });
				}
			} /*else if (IEnDictCodeConst.SD_DIAGTYPE_OUTPATIENT.equals(cidiagDO.getCode_entp())) {
				// 门诊
				GetIEOpMsgInfoDiagBP bp = new GetIEOpMsgInfoDiagBP();
				IEOpPvDiagEnDTO[] OpPvDiagDTO = bp.exec(aggDO[0], cidiagDO.getId_en());
				// 触发事件
				for (IEOpPvDiagEnDTO d : OpPvDiagDTO) {
					DomainBusinessUserObj buo = new DomainBusinessUserObj(d, BusiType.MZ, d.getBedno(), "");
					MsgObj msg = new MsgObj();
					msg.setInteractionCode("new");
					buo.setMsgObj(msg);
					//CiOrdUtils.fireEvent(ICiIEEventConst.EVENT_IE_CIDIAG_OP_SIGN,
					//		IEventType.TYPE_UPDATE_AFTER, new BaseDO[] { buo });
				}

			}*/ else {
				// 暂时不处理
			}
		}
	}

	/**
	 * 诊断数据
	 * 
	 * @param newObjs
	 * @return
	 * @throws BizException
	 */
	private CidiagAggDO[] getCidiagAggDO(Object[] newObjs) throws BizException {

		if (newObjs != null && newObjs.length > 0) {
			CidiagAggDO[] aggDO = (CidiagAggDO[]) newObjs;
			return aggDO;
		}
		return null;
	}
}
