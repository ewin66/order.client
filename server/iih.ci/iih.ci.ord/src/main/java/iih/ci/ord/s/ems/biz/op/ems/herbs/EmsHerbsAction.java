package iih.ci.ord.s.ems.biz.op.ems.herbs;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.ems.herbs.bp.EmsHerbsCreateBP;
import iih.ci.ord.s.ems.biz.op.ems.herbs.bp.EmsHerbsLoadBP;
import iih.ci.ord.s.ems.biz.op.ems.herbs.bp.EmsHerbsSaveBP;

public class EmsHerbsAction extends EmsBaseAction {

	public EmsHerbsAction() {
		super();
		setEmsValidate(new EmsHerbsValidate());
		setEmsCreateBP(new EmsHerbsCreateBP());
		setEmsLoadBP(new EmsHerbsLoadBP());
		setEmsSaveBP(new EmsHerbsSaveBP());
	}

	
}
