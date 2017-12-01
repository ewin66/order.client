package iih.ci.ord.s.ems.biz.op.tmpl.std.ortmpl.apbt;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.tmpl.std.ortmpl.apbt.bp.TmplApBtSaveBP;

/**
 * 备血医疗单逻辑执行器
 * @author wangqingzhu
 *
 */
public class TmplApBtAction extends EmsBaseAction {
	
	public TmplApBtAction() {
		
//		setEmsLoadBP(new TmplApBtLoadBP());
		setEmsSaveBP(new TmplApBtSaveBP());
	}

}
