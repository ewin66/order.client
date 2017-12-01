package iih.ci.mr.pub.listener;

import java.util.Arrays;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.auditdto.d.AuditDTO;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimripbasedto.d.CiMrIPBaseDTO;
import iih.ci.mr.diainfodto.d.DiaInfoDTO;
import iih.ci.mr.i.ICiMrIPService;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.mr.secinfodto.d.SecInfoDTO;
import iih.ci.ord.diag.ICiEnDiagInfoService;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IEventType;

public class AbstractCiMrDODeleteForIPListener extends AbstractCiMrDODeleteBeforeListener{

	@Override
	protected void doActionCiMrDODelete(CiMrDO[] ciMrDOsNew)
			throws BizException {
		// TODO Auto-generated method stub
		if(ciMrDOsNew==null||ciMrDOsNew.length<=0)
		{
			return;
		}
		
		// 取第一条数据，理论上只会存在一条
		CiMrDO ciMrDO = ciMrDOsNew[0];
		if (ciMrDO.getId_emp_submit()==null) {
			return;
		}
		// 文书集成平台dto服务
				ICiMrIPService service = ServiceFinder.find(ICiMrIPService.class);

				// 获取dto基本数据
				CiMrIPBaseDTO[] ciMrIPBaseDTOs = service.getCiMrIPBaseDTO(ciMrDO
						.getId_mr());

				// 数据不可为空
				if (ArrayUtil.isEmpty(ciMrIPBaseDTOs))
					return;

				// 取集合第一条数据，理论上只存在一条数据
				CiMrIPBaseDTO ciMrIPBaseDTO = ciMrIPBaseDTOs[0];

				// 如果不存在数据集则返回，根据数据集确定文书分类
				if (ciMrIPBaseDTO.getCode_set() == null
						|| ciMrIPBaseDTO.getCode_set() == "") {
					return;
				}
				ciMrIPBaseDTO.setType_message("-1");

				
				//填充其他信息
				IMrdocrefvalueRService mrdocrefvalueservice = ServiceFinder.find(IMrdocrefvalueRService.class);
				MrDocRefValueDO[] mrDocRefValueDOs = mrdocrefvalueservice.find("id_mr = '"+ ciMrIPBaseDTO.getId_mr() +"'","",FBoolean.FALSE);
				
				for(MrDocRefValueDO rDocRefValueDO:mrDocRefValueDOs)
				{
					if(rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZS))
					{
						ciMrIPBaseDTO.setCh_co(rDocRefValueDO.getContent());
					}else if(rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_XBS))
					{
						ciMrIPBaseDTO.setIll_ht(rDocRefValueDO.getContent());
					}else if(rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_JWS))
					{
						ciMrIPBaseDTO.setPa_ht(rDocRefValueDO.getContent());
					}else if(rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_GMS))
					{
						ciMrIPBaseDTO.setMe_al_ht(rDocRefValueDO.getContent());
					}else if(rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_JZS))
					{
						ciMrIPBaseDTO.setFa_ht(rDocRefValueDO.getContent());
					}else if(rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_GRS))
					{
						ciMrIPBaseDTO.setPe_ht(rDocRefValueDO.getContent());
					}else if(rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_HYS))
					{
						ciMrIPBaseDTO.setMa_ht(rDocRefValueDO.getContent());
					}else if(rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TGJC))
					{
						ciMrIPBaseDTO.setPh_ex_info(rDocRefValueDO.getContent());
					}else if(rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZKJC))
					{
						ciMrIPBaseDTO.setSp_ex(rDocRefValueDO.getContent());
					}else if(rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_FZJC))
					{
						ciMrIPBaseDTO.setSu_ex(rDocRefValueDO.getContent());
					}else if(rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_BCJL))
					{
						ciMrIPBaseDTO.setMr_area(rDocRefValueDO.getContent());
					}else if(rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZQGZ))
					{
						ciMrIPBaseDTO.setMr_area(rDocRefValueDO.getContent());
					}
					
				}
				//审签子DTO
				FArrayList list = new FArrayList();
				AuditDTO[] auditDTOs = service.getAuditDTO(ciMrDO.getId_mr());		
				list.addAll(Arrays.asList(auditDTOs));
				ciMrIPBaseDTO.setLs_audit(list);
				//章节内容子DTO 暂时不用
				FArrayList seclist = new FArrayList();
				SecInfoDTO[] secInfoDtos = service.getSecInfoDTO(ciMrDO.getId_mr());
				seclist.addAll(Arrays.asList(secInfoDtos));
				ciMrIPBaseDTO.setLs_sec(seclist);
				//诊断信息子DTO
				ICiEnDiagInfoService diagService = ServiceFinder.find(ICiEnDiagInfoService.class);		
				DiaInfoDTO[] diagInfoDtos = diagService.getCiEnDiagInfos(ciMrDO.getId_ent());
				if(diagInfoDtos!=null&&diagInfoDtos.length>0)
				{
				
				FArrayList diaglist = new FArrayList();
				diaglist.addAll(Arrays.asList(diagInfoDtos));
				ciMrIPBaseDTO.setLs_dia(diaglist);
				}
				
				if(ciMrIPBaseDTO.getDt_de()==null){
					ciMrIPBaseDTO.setDt_de(new FDateTime());
				}
				if(ciMrIPBaseDTO.getDt_ga_mh()==null){
					ciMrIPBaseDTO.setDt_ga_mh(new FDateTime());
				}

				switch (ciMrIPBaseDTO.getCode_set()) {
				case IMrPubConst.DS_RCY24:
					fireRCY24(ciMrIPBaseDTO, ciMrDO);
					break;
				case IMrPubConst.DS_RCY24SW:
					fireRCY24SW(ciMrIPBaseDTO, ciMrDO);
					break;
				case IMrPubConst.DS_RYJL:
					fireRYJL(ciMrIPBaseDTO, ciMrDO);
					break;
				case IMrPubConst.DS_CYXJ:
					fireCYXJ(ciMrIPBaseDTO, ciMrDO);
					break;
				case IMrPubConst.DS_SSJL:
					fireSSJL(ciMrIPBaseDTO, ciMrDO);
					break;
				case IMrPubConst.DS_SWJL:
					fireSWJL(ciMrIPBaseDTO, ciMrDO);
					break;
				case IMrPubConst.DS_RCBC:
					fireRCBC(ciMrIPBaseDTO, ciMrDO);
					break;
				case IMrPubConst.DS_ZQTY1:
				case IMrPubConst.DS_ZQTY2:
				case IMrPubConst.DS_ZQTY3:
				case IMrPubConst.DS_ZQTY4:
				case IMrPubConst.DS_ZQTY5:
				case IMrPubConst.DS_ZQTY6:
					fireZQTY(ciMrIPBaseDTO, ciMrDO);
					break;
				case IMrPubConst.DS_MJZBL:
					fireMJZBL(ciMrIPBaseDTO, ciMrDO);
					break;
				case IMrPubConst.DS_JZLG:
					fireJZLG(ciMrIPBaseDTO, ciMrDO);
					break;
				case IMrPubConst.DS_SQTL:
					fireSQTL(ciMrIPBaseDTO, ciMrDO);
					break;
				case IMrPubConst.DS_SWTL:
					fireSWTL(ciMrIPBaseDTO, ciMrDO);
					break;

				}

	}
	private void fireRCY24(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO)
			throws BizException {
		// 赋值采史时间,无对应取值，暂时取值文书创建时间
//		ciMrIPBaseDTO.setDt_ga_mh(ciMrDO.getCreatedtime());
//
//		BusinessEvent mrEvent = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_RCY24,
//				IEventType.TYPE_UPDATE_AFTER, ciMrIPBaseDTO);
//		EventDispatcher.fireEvent(mrEvent);
		ciMrIPBaseDTO.setId_server("BS344");
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO,IMrPubConst.NOCAT,"0","0");
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_RCY24,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
//		try {
//			EventDispatcher.fireEvent(event);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}

	}

	private void fireRCY24SW(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO)
			throws BizException {
		// 赋值采史时间,无对应取值，暂时取值文书创建时间
		ciMrIPBaseDTO.setDt_ga_mh(ciMrDO.getCreatedtime());

//		BusinessEvent mrEvent = new BusinessEvent(
//				IMrEventConst.EVENT_SOURCE_MR_MR_RCY24SW, IEventType.TYPE_UPDATE_AFTER,
//				ciMrIPBaseDTO);
//		EventDispatcher.fireEvent(mrEvent);
		ciMrIPBaseDTO.setId_server("BS345");
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO,IMrPubConst.NOCAT,"0","0");
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_RCY24SW,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
//		try {
//			EventDispatcher.fireEvent(event);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}
	}

	private void fireRYJL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO)
			throws BizException {
		//BusinessEvent mrEvent = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_RYJL,
				//IEventType.TYPE_UPDATE_AFTER, ciMrIPBaseDTO);
		//EventDispatcher.fireEvent(mrEvent);
		
		ciMrIPBaseDTO.setId_server("BS335");
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO,IMrPubConst.NOCAT,"0","0");
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_RYJL,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
//		try {
//			EventDispatcher.fireEvent(event);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}

	}

	private void fireCYXJ(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO)
			throws BizException {
//		BusinessEvent mrEvent = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_CYXJ,
//				IEventType.TYPE_UPDATE_AFTER, ciMrIPBaseDTO);
//		EventDispatcher.fireEvent(mrEvent);
		ciMrIPBaseDTO.setId_server("BS341");
		ciMrIPBaseDTO.setOr_le_ar("这个人要出院了");
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO,IMrPubConst.NOCAT,"0","0");
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_CYXJ,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
//		try {
//			EventDispatcher.fireEvent(event);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}
	}

	private void fireSSJL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO)
			throws BizException {
//		BusinessEvent mrEvent = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SSJL,
//				IEventType.TYPE_UPDATE_AFTER, ciMrIPBaseDTO);
//		EventDispatcher.fireEvent(mrEvent);
		ciMrIPBaseDTO.setId_server("BS337");
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO,IMrPubConst.NOCAT,"0","0");
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SSJL,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
//		try {
//			EventDispatcher.fireEvent(event);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}
	}

	private void fireSWJL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO)
			throws BizException {
//		BusinessEvent mrEvent = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SWJL,
//				IEventType.TYPE_UPDATE_AFTER, ciMrIPBaseDTO);
//		EventDispatcher.fireEvent(mrEvent);
		ciMrIPBaseDTO.setId_server("BS343");
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO,IMrPubConst.NOCAT,"0","0");
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SWJL,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
//		try {
//			EventDispatcher.fireEvent(event);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}
	}

	private void fireRCBC(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO)
			throws BizException {
//		BusinessEvent mrEvent = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_RCBC,
//				IEventType.TYPE_UPDATE_AFTER, ciMrIPBaseDTO);
//		EventDispatcher.fireEvent(mrEvent);
		ciMrIPBaseDTO.setId_server("BS336");
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO,IMrPubConst.NOCAT,"0","0");
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_RCBC,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
//		try {
//			EventDispatcher.fireEvent(event);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}
	}

	private void fireZQTY(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO)
			throws BizException {
//		BusinessEvent mrEvent = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_ZQTY,
//				IEventType.TYPE_UPDATE_AFTER, ciMrIPBaseDTO);
//		EventDispatcher.fireEvent(mrEvent);
		ciMrIPBaseDTO.setId_server("BS338");
		if(ciMrIPBaseDTO.getMr_area()==null){
			ciMrIPBaseDTO.setMr_area("知情同意书内容为空，请修改模板");
		}
		MsgObj msgobj=new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		if(ciMrIPBaseDTO.getCode_entp().equals("01")){
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
		}
		if(ciMrIPBaseDTO.getCode_entp().equals("03")){
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO,IMrPubConst.NOCAT,"0","0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_ZQTY,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
//		try {
//			EventDispatcher.fireEvent(event);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}
	}

	private void fireMJZBL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO)
			throws BizException {
//		BusinessEvent mrEvent = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_MJZBL,
//				IEventType.TYPE_UPDATE_AFTER, ciMrIPBaseDTO);
//		EventDispatcher.fireEvent(mrEvent);
		ciMrIPBaseDTO.setId_server("BS333");
		MsgObj msgobj=new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		if(ciMrIPBaseDTO.getCode_entp().equals("01")){
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
		}
		if(ciMrIPBaseDTO.getCode_entp().equals("03")){
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO,IMrPubConst.MZ,"0","0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_MJZBL,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
//		try {
//			EventDispatcher.fireEvent(event);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}
	}

	private void fireJZLG(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO)
			throws BizException {
//		BusinessEvent mrEvent = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_JZLG,
//				IEventType.TYPE_UPDATE_AFTER, ciMrIPBaseDTO);
//		EventDispatcher.fireEvent(mrEvent);
		
//		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO,IMrPubConst.MZ,ciMrIPBaseDTO.getCode_dept(),"0");
		ciMrIPBaseDTO.setId_server("BS339");
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO,IMrPubConst.MZ,"0","0");
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_JZLG,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
//		try {
//			EventDispatcher.fireEvent(event);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}
	}

	private void fireSQTL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO)
			throws BizException {
//		BusinessEvent mrEvent = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SQTL,
//				IEventType.TYPE_UPDATE_AFTER, ciMrIPBaseDTO);
//		EventDispatcher.fireEvent(mrEvent);
		ciMrIPBaseDTO.setId_server("BS370");
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO,IMrPubConst.ZY,"0","0");
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SQTL,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
//		try {
//			EventDispatcher.fireEvent(event);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}
	}

	private void fireSWTL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO)
			throws BizException {
//		BusinessEvent mrEvent = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SWTL,
//				IEventType.TYPE_UPDATE_AFTER, ciMrIPBaseDTO);
//		EventDispatcher.fireEvent(mrEvent);
		ciMrIPBaseDTO.setId_server("BS369");
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO,IMrPubConst.ZY,"0","0");
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SWTL,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
//		try {
//			EventDispatcher.fireEvent(event);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}
	}



}
