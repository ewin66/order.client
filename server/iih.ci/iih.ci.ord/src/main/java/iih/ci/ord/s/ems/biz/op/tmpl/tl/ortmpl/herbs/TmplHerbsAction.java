package iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.herbs;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.herbs.bp.TmplHerbsSaveBP;

public class TmplHerbsAction extends EmsBaseAction {

	public TmplHerbsAction() {
//		setEmsLoadBP(new TmplHerbsLoadBP());
		setEmsSaveBP(new TmplHerbsSaveBP(new TmplHerbsValidate()));
	}

	
}
