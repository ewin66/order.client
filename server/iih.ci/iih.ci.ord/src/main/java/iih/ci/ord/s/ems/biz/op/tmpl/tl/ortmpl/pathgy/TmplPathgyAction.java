package iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.pathgy;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.pathgy.bp.TmplPathgySaveBP;

public class TmplPathgyAction extends EmsBaseAction {
	
	public TmplPathgyAction() {
		
//		setEmsLoadBP(new TmplPathgyLoadBP());
		setEmsSaveBP(new TmplPathgySaveBP(new TmplPathgyValidate()));
	}


}
