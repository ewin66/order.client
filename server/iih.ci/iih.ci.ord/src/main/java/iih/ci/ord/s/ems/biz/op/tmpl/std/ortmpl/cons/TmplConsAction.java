package iih.ci.ord.s.ems.biz.op.tmpl.std.ortmpl.cons;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.tmpl.std.ortmpl.cons.bp.TmplConsSaveBP;

public class TmplConsAction extends EmsBaseAction {

    public TmplConsAction() {
		
//		setEmsLoadBP(new TmplConsLoadBP());
		setEmsSaveBP(new TmplConsSaveBP());
	}

}
