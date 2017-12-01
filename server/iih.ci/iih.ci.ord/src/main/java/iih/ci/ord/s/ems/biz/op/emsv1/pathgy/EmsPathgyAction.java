package iih.ci.ord.s.ems.biz.op.emsv1.pathgy;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.ems.pathgy.bp.EmsPathgyCreateBP;
import iih.ci.ord.s.ems.biz.op.ems.pathgy.bp.EmsPathgyLoadBP;
import iih.ci.ord.s.ems.biz.op.ems.pathgy.bp.EmsPathgySaveBP;

public class EmsPathgyAction extends EmsBaseAction {
	
	public EmsPathgyAction() {
		super();
		setEmsValidate(new EmsPathgyValidate());
		setEmsCreateBP(new EmsPathgyCreateBP());
		setEmsLoadBP(new EmsPathgyLoadBP());
		setEmsSaveBP(new EmsPathgySaveBP());
	}


}
