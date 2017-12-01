package iih.ci.ord.s.ems.biz.op.emsv1.apbt;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.emsv1.apbt.bp.EmsApBtCreateBP;
import iih.ci.ord.s.ems.biz.op.emsv1.apbt.bp.EmsApBtLoadBP;
import iih.ci.ord.s.ems.biz.op.emsv1.apbt.bp.EmsApBtSaveBP;


/**
 * 备血医疗单逻辑执行器
 * @author wangqingzhu
 *
 */
public class EmsApBtAction extends EmsBaseAction {
	
	public EmsApBtAction() {
		super();
		
		setEmsCreateBP(new EmsApBtCreateBP());
		setEmsLoadBP(new EmsApBtLoadBP());
		setEmsSaveBP(new EmsApBtSaveBP());
	}

}
