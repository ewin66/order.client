package iih.ci.ord.s.ems.biz.op.tmpl.gj.ortmpl.lis;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.tmpl.gj.ortmpl.lis.bp.TmplLisSaveBP;

public class TmplLisAction extends EmsBaseAction {
	
	
	public TmplLisAction() {
//		setEmsLoadBP(new TmplLisLoadBP());
		setEmsSaveBP(new TmplLisSaveBP());
	}


}
