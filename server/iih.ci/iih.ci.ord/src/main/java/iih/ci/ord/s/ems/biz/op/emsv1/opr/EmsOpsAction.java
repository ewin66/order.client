package iih.ci.ord.s.ems.biz.op.emsv1.opr;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.ems.opr.bp.EmsOprCreateBP;
import iih.ci.ord.s.ems.biz.op.ems.opr.bp.EmsOprLoadBP;
import iih.ci.ord.s.ems.biz.op.ems.opr.bp.EmsOprSaveBP;

/**
 * 手术医疗单业务逻辑执行器
 * @author wangqingzhu
 *
 */
public class EmsOpsAction extends EmsBaseAction {


	public EmsOpsAction() {
		super();
		setEmsValidate(new EmsOprValidate());
		setEmsCreateBP(new EmsOprCreateBP());
		setEmsLoadBP(new EmsOprLoadBP());
		setEmsSaveBP(new EmsOprSaveBP());
	}

	
}
