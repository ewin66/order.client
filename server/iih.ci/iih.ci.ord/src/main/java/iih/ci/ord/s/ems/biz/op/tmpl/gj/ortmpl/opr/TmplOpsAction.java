package iih.ci.ord.s.ems.biz.op.tmpl.gj.ortmpl.opr;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.tmpl.gj.ortmpl.opr.bp.TmplOprSaveBP;

/**
 * 手术医疗单业务逻辑执行器
 * @author wangqingzhu
 *
 */
public class TmplOpsAction extends EmsBaseAction {


	public TmplOpsAction() {
		
//		setEmsLoadBP(new TmplOprLoadBP());
		setEmsSaveBP(new TmplOprSaveBP());
	}

	
}
