package iih.ci.ord.s.ems.biz.op.emsv1.cons;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.ems.cons.bp.EmsConsCreateBP;
import iih.ci.ord.s.ems.biz.op.ems.cons.bp.EmsConsLoadBP;
import iih.ci.ord.s.ems.biz.op.ems.cons.bp.EmsConsSaveBP;

public class EmsConsAction extends EmsBaseAction {

    public EmsConsAction() {
		super();
		// TODO Auto-generated constructor stub
		setEmsValidate(new EmsConsValidate());
		setEmsCreateBP(new EmsConsCreateBP());
		setEmsLoadBP(new EmsConsLoadBP());
		setEmsSaveBP(new EmsConsSaveBP());
	}

}
