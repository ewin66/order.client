package iih.ci.ord.s.bp.event;

import java.util.Hashtable;
import java.util.Map;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.ci.ord.iemsg.d.IEBtOrEnDTO;
import iih.ci.ord.iemsg.d.IEBtUseOrDTO;
import iih.ci.ord.iemsg.d.IENsOrDTO;
import iih.ci.ord.iemsg.d.IENsOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrItmDTO;
import iih.ci.ord.iemsg.d.IEOpOrEnDTO;
import iih.ci.ord.iemsg.d.IEOrCancStpEnDTO;
import iih.ci.ord.iemsg.d.IEPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IERisOrDTO;
import iih.ci.ord.iemsg.d.IERisOrEnDTO;
import iih.ci.ord.iemsg.d.IETreatOrDTO;
import iih.ci.ord.iemsg.d.IETreatOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4CancStpBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4ConBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4LisBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4NsBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4OpBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4OthBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4PBtBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4PharmBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4RisBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4TranDepsBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4TreatBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4UBtBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgNsConfirmBP;
import xap.ip.cfg.XipCfg;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 发送医嘱护士核对确认事件操作BP
 * （集成平台事件）
 */
public class FireOrNsCheckEvent4IeBP {
	/**
	 * 发送医嘱护士核对确认事件
	 * 含：签署核对、作废核对、停止核对
	 * （集成平台事件）
	 * @param htors8ieevent  按集成平台事件类型粒度组织的医嘱数据
	 * @throws BizException
	 */
	public void exec(Hashtable<String,String> htors8ieevent,String id_or) throws BizException{
		// 如果inDb=disable，那么所有的消息不入库
		if (!XipCfg.instance().isEnableInDb()) {
			return;
		}
	//	if(true)return;   //暂时先如此
		if(CiOrdUtils.isEmpty(htors8ieevent))return;
		
		Map<String,Object> confirminfo=getIEMsgNsConfirmInfo(id_or);
		
		//集成平台药品医嘱消息体数据生成并触发相应事件
		fireEvent4Pharm(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_DRUG,confirminfo);
		
		//集成平台检查申请消息体数据生成并触发相应事件
		fireEvent4Ris(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_RIS);
		
		//集成平台检验申请消息体数据生成并触发相应事件
		fireEvent4Lis(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_LIS);
		
		//集成平台手术申请消息体数据生成并触发相应事件
		fireEvent4Op(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_OP);
		
		//集成平台会诊消息体数据生成并触发相应事件
	//	fireEvent4Con(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_CON,confirminfo);
		
		//集成平台备血消息体数据生成并触发相应事件
		fireEvent4PBt(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_PBT,confirminfo);
		
		//集成平台用血消息体数据生成并触发相应事件
		fireEvent4UBt(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_UBT,confirminfo);
		
		//集成平台出院消息体数据生成并触发相应事件
		//fireEvent4Out(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_OUT);
		
		//集成平台护理消息体数据生成并触发相应事件
		fireEvent4Ns(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_NS,confirminfo);
		
		//集成平台治疗消息体数据生成并触发相应事件
		fireEvent4Treat(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_TREAT);
		
		//集成平台转科消息体数据生成并触发相应事件
	//	fireEvent4TranDep(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_TRANDEP,confirminfo);
		
		//集成平台其它医嘱消息体数据生成并触发相应事件
		fireEvent4Oth(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_OTH);
		
		//集成平台作废与停止消息体数据生成并触发相应事件
		fireEvent4CancStp(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_CANC_STOP);
	}
	
	/**
	 * BS005： 医嘱撤销和停止服务</br>
	 * 医嘱停止、作废核对触发事件
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4CancStp(Hashtable<String,String> htors8ieevent,String ieEventType) throws BizException{
		//生成集成平台药品医嘱服务数据信息
		GetIEMsgInfo4CancStpBP bp=new GetIEMsgInfo4CancStpBP();
		BaseDTO[] msgdos=bp.exec(htors8ieevent.get(ieEventType));
		if(CiOrdUtils.isEmpty(msgdos))return;

		//触发事件
	//	CiOrdUtils.fireEvent(ieEventType,IEventType.TYPE_UPDATE_AFTER,msgdos);
		
		for (BaseDTO d : msgdos) {
			IEOrCancStpEnDTO ieusedto =(IEOrCancStpEnDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",ieusedto.getExec_dept_code(),"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(ieusedto.getPatientid());
			if (ieusedto.getAdmiss_times() == null || ieusedto.getAdmiss_times().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ieusedto.getAdmiss_times()));
			}
			userobj.setMsgObj(mbx);	
		//	DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ielisitemdto.getExec_code(),ielisordto.getOrder_type());
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
		}
	}
	
	/**
	 * 事件发送
	 * 转科
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4TranDep(Hashtable<String,String> htors8ieevent,String ieEventType,Map<String,Object> confirminfo) throws BizException{
		//生成集成平台药品医嘱服务数据信息
		GetIEMsgInfo4TranDepsBP bp=new GetIEMsgInfo4TranDepsBP();
		BaseDTO[] msgdos=bp.exec(htors8ieevent.get(ieEventType),confirminfo);
		if(CiOrdUtils.isEmpty(msgdos))return;

		//触发事件
		CiOrdUtils.fireEvent(ieEventType,IEventType.TYPE_UPDATE_AFTER,msgdos);
	}
	
	/**
	 * 事件发送
	 * 治疗
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Treat(Hashtable<String,String> htors8ieevent,String ieEventType) throws BizException{
		//生成集成平台药品医嘱服务数据信息
		GetIEMsgInfo4TreatBP bp=new GetIEMsgInfo4TreatBP();
		BaseDTO[] msgdos=bp.exec(htors8ieevent.get(ieEventType));
		if(CiOrdUtils.isEmpty(msgdos))return;

		//触发事件
//		CiOrdUtils.fireEvent(ieEventType,IEventType.TYPE_UPDATE_AFTER,msgdos); order_type_code
		
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IETreatOrEnDTO ielisdto =(IETreatOrEnDTO) d;
			IETreatOrDTO ielisordto=(IETreatOrDTO) (ielisdto.getId_ietreators()).get(0);			
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",ielisordto.getExe_dept_code(),ielisordto.getOrder_type_code());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });				
		}
	}
	
	/**
	 * 事件发送
	 * 其它
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Oth(Hashtable<String,String> htors8ieevent,String ieEventType) throws BizException{
		//生成集成平台其他医嘱服务数据信息
		GetIEMsgInfo4OthBP bp=new GetIEMsgInfo4OthBP();
		BaseDTO[] msgdos=bp.exec(htors8ieevent.get(ieEventType));
		if(CiOrdUtils.isEmpty(msgdos))return;
		for (Object object : msgdos) {
			DomainBusinessUserObj buo = new DomainBusinessUserObj(object, BusiType.ZY,
					"0", "0");
			//触发事件
			CiOrdUtils.fireEvent(ieEventType,IEventType.TYPE_UPDATE_AFTER,new BaseDTO[] { buo });
		}
		
	}
	
	/**
	 * 事件发送
	 * 护理
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Ns(Hashtable<String,String> htors8ieevent,String ieEventType,Map<String,Object> confirminfo) throws BizException{
		//生成集成平台护理医嘱服务数据信息
		GetIEMsgInfo4NsBP bp=new GetIEMsgInfo4NsBP();
		BaseDTO[] msgdos=bp.exec(htors8ieevent.get(ieEventType),confirminfo);
		if(CiOrdUtils.isEmpty(msgdos))return;

		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IENsOrEnDTO iensdto=(IENsOrEnDTO) d;
			IENsOrDTO iensordto=(IENsOrDTO) (iensdto.getId_iensors()).get(0);
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",iensordto.getExe_dept_code(),"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(iensdto.getPatientid());
			if (iensdto.getAdmiss_times() == null || iensdto.getAdmiss_times().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(iensdto.getAdmiss_times()));
			}
			mbx.setEnNO(iensdto.getPatientseqnum());
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
		}
	}
	
	/**
	 * 事件发送
	 * 用血
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
//	private void fireEvent4Out(Hashtable<String,String> htors8ieevent,String ieEventType,Map<String,Object> confirminfo) throws BizException{
//		//生成集成平台药品医嘱服务数据信息
//		GetIEMsgInfo4OutBP bp=new GetIEMsgInfo4OutBP();
//		BaseDTO[] msgdos=bp.exec(htors8ieevent.get(ieEventType));
//		if(CiOrdUtils.isEmpty(msgdos))return;
//
//		//触发事件
//		CiOrdUtils.fireEvent(ieEventType,IEventType.TYPE_UPDATE_AFTER,msgdos);
//	}
	
	/**
	 * 事件发送
	 * 用血
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4UBt(Hashtable<String,String> htors8ieevent,String ieEventType,Map<String,Object> confirminfo) throws BizException{
		//生成集成平台药品医嘱服务数据信息
		GetIEMsgInfo4UBtBP bp=new GetIEMsgInfo4UBtBP();
		BaseDTO[] msgdos=bp.exec(htors8ieevent.get(ieEventType),confirminfo);
		if(CiOrdUtils.isEmpty(msgdos))return;

		//触发事件
//		CiOrdUtils.fireEvent(ieEventType,IEventType.TYPE_UPDATE_AFTER,msgdos);
		for (BaseDTO d : msgdos) {
			IEBtUseOrDTO ieusedto =(IEBtUseOrDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",ieusedto.getDeptcode(),"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
		//	DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ielisitemdto.getExec_code(),ielisordto.getOrder_type());
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
		}
	}
	
	/**
	 * 事件发送
	 * 备血
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4PBt(Hashtable<String,String> htors8ieevent,String ieEventType,Map<String,Object> confirminfo) throws BizException{
		//生成集成平台备血医嘱服务数据信息
		GetIEMsgInfo4PBtBP bp=new GetIEMsgInfo4PBtBP();
		BaseDTO[] msgdos=bp.exec(htors8ieevent.get(ieEventType),confirminfo);
		if(CiOrdUtils.isEmpty(msgdos))return;

		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEBtOrEnDTO ieopdto =(IEBtOrEnDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",ieopdto.getDeptcode(),"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(ieopdto.getPatientid());
			if (ieopdto.getAdmiss_times() == null || ieopdto.getAdmiss_times().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ieopdto.getAdmiss_times()));
			}
			mbx.setEnNO(ieopdto.getPatientseqnum());
			mbx.setApplyNO(ieopdto.getSqdcode());
			mbx.setOrderNO(ieopdto.getOrdercode());
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
		}
	}
	
	/**
	 * 事件发送
	 * 会诊
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Con(Hashtable<String,String> htors8ieevent,String ieEventType,Map<String,Object> confirminfo) throws BizException{
		//生成集成平台药品医嘱服务数据信息
		GetIEMsgInfo4ConBP bp=new GetIEMsgInfo4ConBP();
		BaseDTO[] msgdos=bp.exec(htors8ieevent.get(ieEventType),confirminfo);
		if(CiOrdUtils.isEmpty(msgdos))return;

		//触发事件
		CiOrdUtils.fireEvent(ieEventType,IEventType.TYPE_UPDATE_AFTER,msgdos);
	}
	
	/**
	 * 事件发送
	 * 手术申请
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Op(Hashtable<String,String> htors8ieevent,String ieEventType) throws BizException{
		//生成集成平台手术医嘱服务数据信息
		GetIEMsgInfo4OpBP bp=new GetIEMsgInfo4OpBP();
		BaseDTO[] msgdos=bp.exec(htors8ieevent.get(ieEventType));
		if(CiOrdUtils.isEmpty(msgdos))return;
		
		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpOrEnDTO ieopdto =(IEOpOrEnDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",ieopdto.getExec_code(),"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(ieopdto.getPatientid());
			if (ieopdto.getAdmiss_times() == null || ieopdto.getAdmiss_times().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ieopdto.getAdmiss_times()));
			}
			mbx.setEnNO(ieopdto.getPatientseqnum());
			mbx.setApplyNO(ieopdto.getOp_record_id());
			mbx.setOrderNO(ieopdto.getYz_no());
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
		}
	}
	
	/**
	 * 事件发送
	 * 检验申请
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Lis(Hashtable<String,String> htors8ieevent,String ieEventType) throws BizException{
		//生成集成平台检验医嘱服务数据信息
		GetIEMsgInfo4LisBP bp=new GetIEMsgInfo4LisBP();
		IEOpLisOrEnDTO[] msgdos=bp.exec(htors8ieevent.get(ieEventType));
		if(CiOrdUtils.isEmpty(msgdos))return;

		//触发事件
	//	CiOrdUtils.fireEvent(ieEventType,IEventType.TYPE_UPDATE_AFTER,msgdos);
		
		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpLisOrEnDTO ielisdto =(IEOpLisOrEnDTO) d;
			IEOpLisOrDTO ielisordto=(IEOpLisOrDTO) (ielisdto.getId_ielisors()).get(0);
			IEOpLisOrItmDTO ielisitemdto=(IEOpLisOrItmDTO) (ielisordto.getId_ielisoritms()).get(0);
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",ielisitemdto.getExec_code(),ielisordto.getOrder_type());
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
		//	DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ielisitemdto.getExec_code(),ielisordto.getOrder_type());
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
	}
	
	/**
	 * 事件发送
	 * 检查申请
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Ris(Hashtable<String,String> htors8ieevent,String ieEventType) throws BizException{
		//生成集成平台检查医嘱服务数据信息
		GetIEMsgInfo4RisBP bp=new GetIEMsgInfo4RisBP();
		BaseDTO[] msgdos=bp.exec(htors8ieevent.get(ieEventType));
		if(CiOrdUtils.isEmpty(msgdos))return;

		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IERisOrEnDTO ierisdto=(IERisOrEnDTO) d;
			IERisOrDTO ierisordto=(IERisOrDTO) (ierisdto.getId_ierisors()).get(0);
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",ierisordto.getSqd_deptcode(),ierisordto.getSqd_ordertypecode());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
		}
	}
	
	/**
	 * 事件发送
	 * 药品医嘱
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Pharm(Hashtable<String,String> htors8ieevent,String ieEventType,Map<String,Object> confirminfo) throws BizException{
		//生成集成平台药品医嘱服务数据信息
		GetIEMsgInfo4PharmBP bp=new GetIEMsgInfo4PharmBP();
		IEPharmOrEnDTO[] msgdos = bp.exec(htors8ieevent
				.get(ICiIEEventConst.EVENT_IE_CIOR_NSCHK_DRUG_WC),
				htors8ieevent
						.get(ICiIEEventConst.EVENT_IE_CIOR_NSCHK_DRUG_HERB),confirminfo);
		if(CiOrdUtils.isEmpty(msgdos))return;

		//触发事件

	//	CiOrdUtils.fireEvent(ieEventType,IEventType.TYPE_UPDATE_AFTER,msgdos);
		// 触发事件
				for (BaseDTO d : msgdos) {
					//获取执行科室（就诊科室）
					IEPharmOrEnDTO endo=(IEPharmOrEnDTO) d;
					DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",endo.getDeptcode(),"0");
					MsgObj mbx=new MsgObj();
					mbx.setInteractionCode("new");
					mbx.setPatientCode(endo.getPatientid());
					if (endo.getAdmiss_times() == null || endo.getAdmiss_times().equals("")) {
						mbx.setEntimes(0);
					}else{
						mbx.setEntimes(Integer.parseInt(endo.getAdmiss_times()));
					}
					mbx.setEnNO(endo.getPatientseqnum());
//					mbx.setApplyNO(applyNO);
//					mbx.setOrderNO(orderNO);
//					mbx.setSpecimenNO(SpecimenNO);
					userobj.setMsgObj(mbx);	
					CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
					
				}
		
	}
	
	/**
	 * 确认数据信息
	 * 患者、就诊、确认
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	private Map<String,Object> getIEMsgNsConfirmInfo(String id_or) throws BizException{
		GetIEMsgNsConfirmBP bp=new GetIEMsgNsConfirmBP();
		return bp.exec(id_or);
	}

}
