package iih.ci.ord.s.ems.biz.op.emsv1.ris;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.ems.ris.bp.EmsRisCreateBP;
import iih.ci.ord.s.ems.biz.op.ems.ris.bp.EmsRisLoadBP;
import iih.ci.ord.s.ems.biz.op.ems.ris.bp.EmsRisSaveBP;

public class EmsRisAction extends EmsBaseAction {
	
	public EmsRisAction() {
		super();
		setEmsValidate(new EmsRisValidate());
		setEmsCreateBP(new EmsRisCreateBP());
		setEmsLoadBP(new EmsRisLoadBP());
		setEmsSaveBP(new EmsRisSaveBP());
	}


	
}
