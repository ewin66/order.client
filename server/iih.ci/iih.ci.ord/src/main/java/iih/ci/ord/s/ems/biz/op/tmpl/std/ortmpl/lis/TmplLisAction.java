package iih.ci.ord.s.ems.biz.op.tmpl.std.ortmpl.lis;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.tmpl.std.ortmpl.lis.bp.TmplLisSaveBP;

public class TmplLisAction extends EmsBaseAction {
	
	
	public TmplLisAction() {
//		setEmsLoadBP(new TmplLisLoadBP());
		setEmsSaveBP(new TmplLisSaveBP());
	}


}
