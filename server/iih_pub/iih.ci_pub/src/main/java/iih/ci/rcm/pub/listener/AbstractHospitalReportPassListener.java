package iih.ci.rcm.pub.listener;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.rcm.hospitalinfecteddto.d.HospitalInfectedDTO;
import iih.ci.rcm.hospitalreport.d.HospitalReportDO;
import iih.ci.rcm.pub.ReportConst.IReportPubConst;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

public class AbstractHospitalReportPassListener extends
		AbstractHospitalReportDOUpdateAfterListener {

	@Override
	protected void doActionCiMrDOChange(HospitalReportDO[] hospitalReportDos)
			throws BizException {
		HospitalReportDO hospitalReportDO = hospitalReportDos[0];

		if (hospitalReportDO == null
				|| hospitalReportDO.getSd_stage() == null
				|| !IReportPubConst.STAGE_PASS_CODE.equals(hospitalReportDO
						.getSd_stage())) {
			return;
		}
		HospitalInfectedDTO hospitalInfectedDTO = new HospitalInfectedDTO();
		hospitalInfectedDTO.setId_hospitalreport(hospitalReportDO
				.getId_hospitalreport());

		// BusinessEvent mrEvent = new
		// BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_REPORT_PASS,
		// IEventType.TYPE_UPDATE_AFTER, hospitalInfectedDTO);
		// EventDispatcher.fireEvent(mrEvent);

		// BS363
		DomainBusinessUserObj buo = new DomainBusinessUserObj(
				hospitalInfectedDTO, IMrPubConst.ZY, "0", "0");
		BusinessEvent event = new BusinessEvent(
				IMrEventConst.EVENT_SOURCE_MR_REPORT_PASS,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder
				.find(BusinessEventListener.class);
		beListener.doAction(event);

		// BS376
		buo = new DomainBusinessUserObj(hospitalInfectedDTO, IMrPubConst.ZY,
				"0", "0");
		event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_REPORT_PASS,
				IMrEventConst.EVENT_SOURCE_MR_REPORT_PASS2, buo);
		beListener.doAction(event);

		// try {
		// EventDispatcher.fireEvent(event);
		// } catch (BizException e) {
		// e.printStackTrace();
		// }

	}

}
