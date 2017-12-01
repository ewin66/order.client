package iih.ci.ord.s.ems.biz.op.emsv1.lis;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.ems.lis.bp.EmsLisCreateBP;
import iih.ci.ord.s.ems.biz.op.ems.lis.bp.EmsLisLoadBP;
import iih.ci.ord.s.ems.biz.op.ems.lis.bp.EmsLisSaveBP;

public class EmsLisAction extends EmsBaseAction {
	
	
	public EmsLisAction() {
		super();
		setEmsValidate(new EmsLisValidate());
		setEmsCreateBP(new EmsLisCreateBP());
		setEmsLoadBP(new EmsLisLoadBP());
		setEmsSaveBP(new EmsLisSaveBP());
	}


}
