package iih.ci.ord.s.ems.biz.op.ems.treat;

import iih.ci.ord.s.ems.biz.op.base.action.EmsBaseSetAction;
import iih.ci.ord.s.ems.biz.op.ems.treat.bp.EmsTreatCreateBP;
import iih.ci.ord.s.ems.biz.op.ems.treat.bp.EmsTreatLoadBP;
import iih.ci.ord.s.ems.biz.op.ems.treat.bp.EmsTreatSaveBP;
/**
 * 治疗医疗单逻辑执行器
 * @author wangqingzhu
 *
 */
public class EmsTreatAction extends EmsBaseSetAction {

	public EmsTreatAction() {
		super();
		setEmsValidate(new EmsTreatValidate());
		setEmsCreateBP(new EmsTreatCreateBP());
		setEmsLoadBP(new EmsTreatLoadBP());
		setEmsSaveBP(new EmsTreatSaveBP());
	}
  
}
