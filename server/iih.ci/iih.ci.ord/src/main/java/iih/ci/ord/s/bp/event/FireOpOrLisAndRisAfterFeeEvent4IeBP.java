package iih.ci.ord.s.bp.event;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrItmDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4LisBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4RisBP;
import iih.ci.ord.s.ems.log.OrdBizLogger;

import java.util.Hashtable;

import xap.ip.cfg.XipCfg;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 门诊医嘱收费事件侦听并进行集成平台门诊事件发送 （集成平台事件）
 */
public class FireOpOrLisAndRisAfterFeeEvent4IeBP extends AbstractOpOrLisAndRisFeeAfterListener {

	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrLisAndRisAfterFeeEvent4IeBP]医嘱收费集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		// 如果inDb=disable，那么所有的消息不入库
		if (!XipCfg.instance().isEnableInDb()) {
			return;
		}
		// 空判断
		if (CiOrdUtils.isEmpty(ors))
			return;
		Hashtable<String, String> htors8ieevent = new Hashtable<String, String>(); // 参数定义

		// 医嘱数据分组组织
		int signcnt = orGrpHandle4IeEvent(htors8ieevent, ors);
		if (signcnt == 0)
			return;
		OrdBizLogger.info(ctx, String.format("[FireOpOrLisAndRisAfterFeeEvent4IeBP]分组组织设置就诊号完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		// 发布IE门诊医嘱开立事件
		fireEvent4Ie(htors8ieevent);

	}

	/**
	 * 医嘱数据分组组织
	 * 
	 * @param htors8ieevent
	 * @param ors
	 * @return
	 */
	private int orGrpHandle4IeEvent(Hashtable<String, String> htors8ieevent, CiOrderDO[] ors) {
		// 参数
		int iN = ors.length;
		int count = 0;

		// 遍历
		for (int i = 0; i < iN; i++) {
			if (!CiOrdUtils.isOpWf(ors[i].getCode_entp()))
				continue;
			count++;
			// 获得分组数据
			orGrpHandle4IeEvent(htors8ieevent, ors[i], false);
		}

		return count;
	}

	/**
	 * 医嘱数据组织
	 * 
	 * @param ht
	 * @param or
	 * @param iscancStp
	 */
	private void orGrpHandle4IeEvent(Hashtable<String, String> ht, CiOrderDO or, boolean iscancStp) {
		String ieeventtype = "";
		if (iscancStp) {
			ieeventtype = ICiIEEventConst.EVENT_IE_CIOR_OP_CANC_STOP;
		} else {
			ieeventtype = CiOrdUtils.getIeOpEventTypeStr(or.getSd_srvtp());
		}
		orGrpHandle4IeEvent(ht, or, ieeventtype);
	}

	/**
	 * 医嘱数据组织
	 * 
	 * @param ht
	 * @param or
	 */
	private void orGrpHandle4IeEvent(Hashtable<String, String> ht, CiOrderDO or, String ieeventtype) {
		// 有效性校验
		if (CiOrdUtils.isEmpty(ieeventtype))
			return;
		if (ht.containsKey(ieeventtype)) {
			String ors = ht.get(ieeventtype) + CiOrdUtils.COMMA_STR + or.getId_or();
			ht.put(ieeventtype, ors);
		} else {
			ht.put(ieeventtype, or.getId_or());
		}
	}

	/**
	 * 
	 * @param htors8ieevent
	 * @throws BizException
	 */
	private void fireEvent4Ie(Hashtable<String, String> htors8ieevent) throws BizException {

		// 有效性验证
		if (CiOrdUtils.isEmpty(htors8ieevent))
			return;

		// 集成平台检查申请消息体数据生成并触发相应事件
		fireEvent4Ris(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_RIS);

		// 集成平台检验申请消息体数据生成并触发相应事件
		fireEvent4Lis(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_LIS);

	}

	/**
	 * 事件发送 检查申请
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Ris(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台检查医嘱服务数据信息
//		GetIEOpMsgInfo4RisBP bp = new GetIEOpMsgInfo4RisBP();
//		BaseDTO[] msgdos = bp.exec(htors8ieevent.get(ieEventType));
//		if (CiOrdUtils.isEmpty(msgdos))
//			return;
		
		// 生成集成平台检查医嘱服务数据信息
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrLisAndRisAfterFeeEvent4IeBP]检查医嘱收费集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEOpMsgInfo4RisBP bp = new GetIEOpMsgInfo4RisBP();
		BaseDTO[] msgdos = bp.exec(htors8ieevent.get(ieEventType));
		OrdBizLogger.info(ctx, String.format("[FireOpOrLisAndRisAfterFeeEvent4IeBP]检查医嘱收费集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpRisOrEnDTO ierisdto =(IEOpRisOrEnDTO) d;
			IEOpRisOrDTO ierisordto=(IEOpRisOrDTO) (ierisdto.getIerisors()).get(0);
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ierisordto.getSqd_deptcode(),ierisordto.getIemsgca_code());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(ierisdto.getPatient_id());
			if (ierisdto.getTimes() == null || ierisdto.getTimes().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ierisdto.getTimes()));
			}
			mbx.setEnNO(ierisdto.getP_bar_code());
			mbx.setApplyNO(ierisordto.getApply_serial());
			mbx.setSpecimenNO(ierisordto.getSamp_bar_code());
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		OrdBizLogger.info(ctx, String.format("[FireOpOrLisAndRisAfterFeeEvent4IeBP]检查医嘱收费集中平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		// 触发事件
//		CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, msgdos);
	}

	/**
	 * 事件发送 检验申请
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Lis(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台药品医嘱服务数据信息
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrLisAndRisAfterFeeEvent4IeBP]检验医嘱收费集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEOpMsgInfo4LisBP bp = new GetIEOpMsgInfo4LisBP();
		BaseDTO[] msgdos = bp.exec(htors8ieevent.get(ieEventType));
		OrdBizLogger.info(ctx, String.format("[FireOpOrLisAndRisAfterFeeEvent4IeBP]检验医嘱收费集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		// 触发事件
		for (BaseDTO d : msgdos) {
			IEOpLisOrEnDTO ielisdto = (IEOpLisOrEnDTO) d;
			IEOpLisOrDTO ielisordto = (IEOpLisOrDTO) (ielisdto.getId_ielisors()).get(0);
			IEOpLisOrItmDTO ielisitemdto = (IEOpLisOrItmDTO) (ielisordto.getId_ielisoritms()).get(0);
			DomainBusinessUserObj userobj = null;
			if (ielisordto.getIemsgca_name() != null && ielisordto.getIemsgca_name().equals("099")) {
				userobj = new DomainBusinessUserObj(d, "01",ielisitemdto.getExec_code(),"099");
			}else{
				userobj = new DomainBusinessUserObj(d, "01",ielisitemdto.getExec_code(),ielisordto.getIemsgca_code());
			}
			
//			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01", ielisitemdto.getExec_code(), ielisordto.getIemsgca_code());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(ielisdto.getPatient_id());
			if (ielisdto.getTimes() == null || ielisdto.getTimes().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ielisdto.getTimes()));
			}
			mbx.setEnNO(ielisdto.getP_bar_code());
			mbx.setApplyNO(ielisordto.getJy_applyserial1());
			mbx.setOrderNO(ielisitemdto.getYz_no());
			mbx.setSpecimenNO(ielisitemdto.getSample_id());
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });

		}
		OrdBizLogger.info(ctx, String.format("[FireOpOrLisAndRisAfterFeeEvent4IeBP]检验医嘱收费集中平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}

}
