package iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.opr;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.opr.bp.TmplOprSaveBP;

/**
 * 手术医疗单业务逻辑执行器
 * @author wangqingzhu
 *
 */
public class TmplOprAction extends EmsBaseAction {


	public TmplOprAction() {
		
//		setEmsLoadBP(new TmplOprLoadBP());
		setEmsSaveBP(new TmplOprSaveBP(new TmplOprValidate()));
	}

	
}
