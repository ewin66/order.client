package iih.ci.ord.s.bp.event;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.iemsg.d.IEOpOrCancStpEnDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfoRefund4LisRisBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfoRefund4PresBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfoRefund4TreatBP;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.ip.cfg.XipCfg;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 检查检验退费事件侦听并进行集成平台门诊事件发送 （集成平台事件）
 * 
 * @author 张万青
 *
 */
public class FireOpOrLisRisRefundEvent4IeListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrLisRisRefundEvent4IeListener]医嘱退费签署集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		// 如果inDb=disable，那么所有的消息不入库
		if (!XipCfg.instance().isEnableInDb()) {
			return;
		}
		// 事件源及事件类型判断
		if (!(event.getSourceID().equals(IBlEventConst.EVENT_SOURCE_OP_REFUND_FOR_IP)
				&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))
			return;
		// 退费成功的服务项目数据及空判断逻辑
		BusinessEvent dbevent = (BusinessEvent) event;
		Object newObjs = dbevent.getUserObject();
		if (newObjs == null)
			return;
		OpRefund4IpEsDTO[] refundDTOs = getRefundDTOs(newObjs);
		if (refundDTOs == null || refundDTOs.length == 0)
			return;
		List<OpRefund4IpEsDTO[]> pickRefunds = pickRefundSrv(refundDTOs);
		OrdBizLogger.info(ctx, String.format("[FireOpOrLisRisRefundEvent4IeListener]分组数据完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		// 处方类
		presRefundAction(pickRefunds.get(0));
		// 检查和检验
		lisRisRefundAction(pickRefunds.get(1));
		// 诊疗类
		treatRefundAction(pickRefunds.get(2));
	}

	/**
	 * 诊疗类，组装集成平台的数据，并发送事件
	 * 
	 * @param refundsIpEs
	 * @throws BizException
	 */
	private void treatRefundAction(OpRefund4IpEsDTO[] refundsIpEs) throws BizException {
		 GetIEOpMsgInfoRefund4TreatBP presBp = new GetIEOpMsgInfoRefund4TreatBP();
		 BaseDTO[] msgdos = presBp.exec(refundsIpEs);
		 if (CiOrdUtils.isEmpty(msgdos))
		 return;
		 // 触发事件
		 for (BaseDTO d : msgdos) {
		 // 获取执行科室
		 IEOpTreatOrEnDTO ierisdto = (IEOpTreatOrEnDTO) d;
		 DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",
		 ierisdto.getExec_sn(),
		 "0");
		 MsgObj mbx = new MsgObj();
		 mbx.setInteractionCode("new");
		 mbx.setPatientCode(ierisdto.getPatient_id());
		 if (ierisdto.getAdmiss_times() == null || ierisdto.getAdmiss_times().equals("")) {
			 mbx.setEntimes(0);
		 }else{
			 mbx.setEntimes(Integer.parseInt(ierisdto.getAdmiss_times()));
		 }
		 mbx.setEnNO(ierisdto.getP_bar_code());
		 userobj.setMsgObj(mbx);
		 CiOrdUtils.fireEvent(ICiIEEventConst.EVENT_IE_CIOR_OP_TREAT,
		 IEventType.TYPE_UPDATE_AFTER,
		 new BaseDTO[] { userobj });
		 }
	}

	/**
	 * 药品类，组装集成平台的数据，并发送事件
	 * 
	 * @param refundsIpEs
	 * @throws BizException
	 */
	private void presRefundAction(OpRefund4IpEsDTO[] refundsIpEs) throws BizException {
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrLisRisRefundEvent4IeListener]药品医嘱退费集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEOpMsgInfoRefund4PresBP presBp = new GetIEOpMsgInfoRefund4PresBP();
		BaseDTO[] msgdos = presBp.exec(refundsIpEs);
		OrdBizLogger.info(ctx, String.format("[FireOpOrLisRisRefundEvent4IeListener]药品医嘱退费集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			// 获取执行科室
			IEOpPharmOrEnDTO ierisdto = (IEOpPharmOrEnDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01", ierisdto.getDept_code(), "0");
			MsgObj mbx = new MsgObj();
			mbx.setInteractionCode("renew");
			mbx.setPatientCode(ierisdto.getPatientid());
			if (ierisdto.getTimes() == null || ierisdto.getTimes().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ierisdto.getTimes()));
			}
			mbx.setEnNO(ierisdto.getP_bar_code());
			userobj.setMsgObj(mbx);
			CiOrdUtils.fireEvent(ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG, IEventType.TYPE_UPDATE_AFTER,
					new BaseDTO[] { userobj });
		}
		OrdBizLogger.info(ctx, String.format("[FireOpOrLisRisRefundEvent4IeListener]药品医嘱退费集中平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}

	/**
	 * 检查和检验类，组装集成平台的数据，并发送事件
	 * 
	 * @param refundsIpEs
	 * @throws BizException
	 */
	private void lisRisRefundAction(OpRefund4IpEsDTO[] refundsIpEs) throws BizException {
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrLisRisRefundEvent4IeListener]检查检验医嘱退费集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEOpMsgInfoRefund4LisRisBP lisRisBp = new GetIEOpMsgInfoRefund4LisRisBP();
		// 将传入参数进行分类 检查检验类
		BaseDTO[] msgdos = lisRisBp.exec(refundsIpEs);
		OrdBizLogger.info(ctx, String.format("[FireOpOrLisRisRefundEvent4IeListener]检查检验医嘱退费集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			// 获取执行科室
			IEOpOrCancStpEnDTO ierisdto = (IEOpOrCancStpEnDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01", ierisdto.getExec_unit(),
					ierisdto.getIemsgca_code());
			MsgObj mbx = new MsgObj();
			mbx.setInteractionCode("cancel");
			mbx.setPatientCode(ierisdto.getPatient_id());
			if (ierisdto.getTimes() == null || ierisdto.getTimes().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ierisdto.getTimes()));
			}
			userobj.setMsgObj(mbx);
			CiOrdUtils.fireEvent(ICiIEEventConst.EVENT_IE_CIOR_OP_CANC_STOP, IEventType.TYPE_UPDATE_AFTER,
					new BaseDTO[] { userobj });
		}
		OrdBizLogger.info(ctx, String.format("[FireOpOrLisRisRefundEvent4IeListener]检查检验医嘱退费集中平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}

	/**
	 * 分拣处方类型
	 * 
	 * @param refundDTOs
	 * @return
	 */
	private List<OpRefund4IpEsDTO[]> pickRefundSrv(OpRefund4IpEsDTO[] refundDTOs) throws BizException{
		List<OpRefund4IpEsDTO> drugs = new ArrayList<OpRefund4IpEsDTO>();// 处方类
		List<OpRefund4IpEsDTO> lisRiss = new ArrayList<OpRefund4IpEsDTO>();// 检查检验类
		List<OpRefund4IpEsDTO> treats = new ArrayList<OpRefund4IpEsDTO>();// 诊疗类
		DAFacade dafacade = new DAFacade();
		StringBuffer sqlb = new StringBuffer();
		int total = 0;
		for (OpRefund4IpEsDTO refund : refundDTOs) {
			String id_or = refund.getId_or();
			String presType = refund.getCode_applytp();
			if (CiOrdUtils.isEmpty(presType)) {
				continue;
			}
			if (!CiOrdUtils.isEmpty(id_or)) {
				sqlb.delete(0, sqlb.length());
				sqlb.append(" select  count(1) from ci_app_ris where id_or= '"+id_or+"'");
				List<String> list_ris = (List<String>) dafacade.execQuery(sqlb.toString(), new ColumnListHandler());
				
				if (list_ris != null && list_ris.size() > 0) {
					Object o = list_ris.get(0);
					total = Integer.parseInt(o.toString());
				}
				if (total > 0) {
					presType = "02";
				}else{
					total = 0;
					sqlb.delete(0, sqlb.length());
					sqlb.append(" select  count(1) from ci_app_lis_or where id_or='"+id_or+"'");
					List<String> list_lis = (List<String>) dafacade.execQuery(sqlb.toString(), new ColumnListHandler());
					if (list_lis != null && list_lis.size() > 0) {
						Object o = list_lis.get(0);
						total = Integer.parseInt(o.toString());
					}
					if (total > 0) {
						presType = "03";
					}else{
						total = 0;
						sqlb.delete(0, sqlb.length());
						sqlb.append(" select count(1) from ci_app_pathgy where id_or ='"+id_or+"'");
						List<String> list_pathgy = (List<String>) dafacade.execQuery(sqlb.toString(), new ColumnListHandler());
						if (list_pathgy != null && list_pathgy.size() > 0) {
							Object o = list_pathgy.get(0);
							total = Integer.parseInt(o.toString());
						}
						if (total > 0) {
							presType = "02";
						}
					}
				}
				refund.setCode_applytp(presType);
			}
			// 药品
			if (presType.equals("01")) {
				drugs.add(refund);
			} else if (presType.equals("02") || presType.equals("03")) {// 检查或检验
				lisRiss.add(refund);
			} else if (presType.equals("04")) {// 诊疗
				treats.add(refund);
			}
		}
		List<OpRefund4IpEsDTO[]> pickSrvs = new ArrayList<OpRefund4IpEsDTO[]>();
		pickSrvs.add(drugs.toArray(new OpRefund4IpEsDTO[0]));
		pickSrvs.add(lisRiss.toArray(new OpRefund4IpEsDTO[0]));
		pickSrvs.add(treats.toArray(new OpRefund4IpEsDTO[0]));
		return pickSrvs;
	}

	/**
	 * 获得事件中的入参DTO
	 * 
	 * @param newObjs
	 * @return
	 */
	private OpRefund4IpEsDTO[] getRefundDTOs(Object newObjs) {
		BusinessUserObj business = (BusinessUserObj) newObjs;
		OpRefund4IpEsDTO[] bloeps = (OpRefund4IpEsDTO[]) business.getUserObj();
		return bloeps;
	}

	/**
	 * 获得医嘱id_or，以，隔开
	 * 
	 * @param refund4IpEsDTOs
	 * @return
	 */
	private String getIdOrs(OpRefund4IpEsDTO[] refund4IpEsDTOs) {
		String idors = "";
		for (OpRefund4IpEsDTO es : refund4IpEsDTOs) {
			idors += es.getId_or() + CiOrdUtils.COMMA_STR;
		}
		if (idors.length() > 0) {
			idors = idors.substring(0, idors.length() - 1);
		}
		return idors;
	}
}
