package iih.ci.ord.s.ems.biz.op.emsv1.drugs;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.ems.drugs.bp.EmsDrugsCreateBP;
import iih.ci.ord.s.ems.biz.op.ems.drugs.bp.EmsDrugsLoadBP;
import iih.ci.ord.s.ems.biz.op.ems.drugs.bp.EmsDrugsSaveBP;


public class EmsDrugsAction extends EmsBaseAction {
	
	public EmsDrugsAction() {
		super();
		
		setEmsValidate(new EmsDrugsValidate());
		setEmsCreateBP(new EmsDrugsCreateBP());
		setEmsLoadBP(new EmsDrugsLoadBP());
		setEmsSaveBP(new EmsDrugsSaveBP());
	}


	
}
