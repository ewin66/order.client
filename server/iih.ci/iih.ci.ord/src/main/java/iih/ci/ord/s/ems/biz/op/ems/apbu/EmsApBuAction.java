package iih.ci.ord.s.ems.biz.op.ems.apbu;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.ems.apbu.bp.EmsApBuCreateBP;
import iih.ci.ord.s.ems.biz.op.ems.apbu.bp.EmsApBuLoadBP;
import iih.ci.ord.s.ems.biz.op.ems.apbu.bp.EmsApBuSaveBP;

public class EmsApBuAction extends EmsBaseAction {
	
	
	public EmsApBuAction() {
		super();
		setEmsValidate(new EmsApBuValidate());
		setEmsCreateBP(new EmsApBuCreateBP());
		setEmsLoadBP(new EmsApBuLoadBP());
		setEmsSaveBP(new EmsApBuSaveBP());
	}


}
