package iih.ci.ord.s.bp.event;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.iemsg.d.IEOpBtOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpBtUseOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrItmDTO;
import iih.ci.ord.iemsg.d.IEOpOpOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.AbstractOrSignListener;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4LisNoAcountBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4OpBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4PBtBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4Pharm8idenBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4RisNoAcountBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4TreatNBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4UBtBP;
import iih.ci.ord.s.ems.log.OrdBizLogger;

import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.commons.lang3.ArrayUtils;

import xap.ip.cfg.XipCfg;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 门诊医嘱签署事件侦听并进行集成平台门诊事件发送 （集成平台事件）
 */
public class FireOpAgainNewEvent4IeBP extends AbstractOrSignListener {
	
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpAgainNewEvent4IeBP]医嘱重新分方集成平台事件逻辑开始");
		// 如果inDb=disable，那么所有的消息不入库
		if (!XipCfg.instance().isEnableInDb()) {
			return;
		}
		//事件源及事件类型判断    ICiEventConst.CIOR_STATUS_EVENT_SOURCEID   2016-08-26forlc
		if(!(event.getSourceID().equals(ICiEventConst.CIOR_AGAIN_NEW)
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

	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		// 空判断
		if (CiOrdUtils.isEmpty(ors))
			return;
		Hashtable<String, String> htors8ieevent = new Hashtable<String, String>(); // 参数定义
		
		// 医嘱数据分组组织
		int signcnt = orGrpHandle4IeEvent(htors8ieevent, ors);
		if (signcnt == 0)
			return;
       //设置就诊号
		htors8ieevent.put(ICiIEEventConst.EVENT_IE_ID_ENT, ors[0].getId_en());
		// 发布IE门诊医嘱开立事件   htors8ieevent的结构是[('iden',id_en),('iih.ci.ord.iemsg.d.IEOpPharmWcOrDTO',id_or='','','')]
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

		// 集成平台药品医嘱消息体数据生成并触发相应事件
		fireEvent4Pharm(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG);

		// 集成平台检查申请消息体数据生成并触发相应事件
		//fireEvent4Ris(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_RIS);

		// 集成平台检验申请消息体数据生成并触发相应事件
		//fireEvent4Lis(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_LIS);

		// 集成平台手术申请消息体数据生成并触发相应事件
		//fireEvent4Op(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_OP);

		// 集成平台备血消息体数据生成并触发相应事件
		//fireEvent4PBt(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_PBT);

		// 集成平台用血消息体数据生成并触发相应事件
		//fireEvent4UBt(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_UBT);

		// 集成平台治疗消息体数据生成并触发相应事件
		//fireEvent4Treat(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_TREAT);

	}

	/**
	 * 事件发送 药品医嘱
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Pharm(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台药品医嘱服务数据信息
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpAgainNewEvent4IeBP]医嘱重分方数据处理开始");
		long startTime = System.currentTimeMillis();
		GetIEOpMsgInfo4Pharm8idenBP bp = new GetIEOpMsgInfo4Pharm8idenBP();
		BaseDTO[] msgdos = bp.exec(htors8ieevent.get(ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG_WC), htors8ieevent.get(ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG_HERB),htors8ieevent.get(ICiIEEventConst.EVENT_IE_ID_ENT));
		OrdBizLogger.info(ctx, String.format("[FireOpAgainNewEvent4IeBP]医嘱重分方,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		
		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpPharmOrEnDTO endo=(IEOpPharmOrEnDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",endo.getDept_code(),"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(endo.getPatientid());
			if (endo.getTimes() == null || endo.getTimes().equals("")){
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(endo.getTimes()));
			}
			mbx.setEnNO(endo.getP_bar_code());
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		OrdBizLogger.info(ctx, String.format("[FireOpAgainNewEvent4IeBP]医嘱重分方集中平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
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
		GetIEOpMsgInfo4RisNoAcountBP bp = new GetIEOpMsgInfo4RisNoAcountBP();
		BaseDTO[] msgdos = bp.exec(htors8ieevent.get(ieEventType));
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpRisOrEnDTO ierisdto =(IEOpRisOrEnDTO) d;
			IEOpRisOrDTO ierisordto=(IEOpRisOrDTO) (ierisdto.getIerisors()).get(0);
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ierisordto.getSqd_deptcode(),"099");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
	}

	/**
	 * 事件发送 检验申请
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Lis(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台检验医嘱服务数据信息
		GetIEOpMsgInfo4LisNoAcountBP bp = new GetIEOpMsgInfo4LisNoAcountBP();
		BaseDTO[] msgdos = bp.exec(htors8ieevent.get(ieEventType));
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpLisOrEnDTO ielisdto =(IEOpLisOrEnDTO) d;
			IEOpLisOrDTO ielisordto=(IEOpLisOrDTO) (ielisdto.getId_ielisors()).get(0);
			IEOpLisOrItmDTO ielisitemdto=(IEOpLisOrItmDTO) (ielisordto.getId_ielisoritms()).get(0);
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ielisitemdto.getExec_code(),"099");
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
	}

	/**
	 * 事件发送 手术申请
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Op(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台手术医嘱服务数据信息
		GetIEOpMsgInfo4OpBP bp = new GetIEOpMsgInfo4OpBP();
		BaseDTO[] msgdos = bp.exec(htors8ieevent.get(ieEventType));
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpOpOrEnDTO ieopdto =(IEOpOpOrEnDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ieopdto.getExec_code(),"099");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(ieopdto.getPatient_id());
			if (ieopdto.getAdmit_times() == null || ieopdto.getAdmit_times().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ieopdto.getAdmit_times()));
			}
			mbx.setEnNO(ieopdto.getP_bar_code());
			mbx.setOrderNO(ieopdto.getYz_no());
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
	}

	/**
	 * 事件发送 备血
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4PBt(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台备血医嘱服务数据信息
		GetIEOpMsgInfo4PBtBP bp = new GetIEOpMsgInfo4PBtBP();
		BaseDTO[] msgdos = bp.exec(htors8ieevent.get(ieEventType));
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpBtOrEnDTO iebtdto =(IEOpBtOrEnDTO) d;			
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",iebtdto.getDeptcode(),"099");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });				
		}
	}

	/**
	 * 事件发送 用血
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4UBt(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台用血医嘱服务数据信息
		GetIEOpMsgInfo4UBtBP bp = new GetIEOpMsgInfo4UBtBP();
		BaseDTO[] msgdos = bp.exec(htors8ieevent.get(ieEventType));
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpBtUseOrDTO iebudto =(IEOpBtUseOrDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",iebudto.getApply_unit(),"099");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });				
		}
	}

	/**
	 * 事件发送 治疗
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Treat(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台治疗医嘱服务数据信息
		GetIEOpMsgInfo4TreatNBP bp = new GetIEOpMsgInfo4TreatNBP();
		BaseDTO[] msgdos = bp.exec(htors8ieevent.get(ieEventType));
		
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpTreatOrEnDTO ielisdto =(IEOpTreatOrEnDTO) d;
			IEOpTreatOrDTO ielisordto=(IEOpTreatOrDTO) (ielisdto.getIetreators()).get(0);			
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ielisordto.getExec_sn(),"099");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });				
		}
	}

}
