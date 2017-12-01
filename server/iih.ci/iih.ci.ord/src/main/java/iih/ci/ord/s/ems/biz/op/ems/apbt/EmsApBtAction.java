package iih.ci.ord.s.ems.biz.op.ems.apbt;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.ems.apbt.bp.EmsApBtCreateBP;
import iih.ci.ord.s.ems.biz.op.ems.apbt.bp.EmsApBtLoadBP;
import iih.ci.ord.s.ems.biz.op.ems.apbt.bp.EmsApBtSaveBP;

/**
 * 备血医疗单逻辑执行器
 * @author wangqingzhu
 *
 */
public class EmsApBtAction extends EmsBaseAction {
	
	public EmsApBtAction() {
		setEmsCreateBP(new EmsApBtCreateBP());
		setEmsLoadBP(new EmsApBtLoadBP());
		setEmsSaveBP(new EmsApBtSaveBP(new EmsApBtValidate()));
	}

}
