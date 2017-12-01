package iih.ci.ord.s.ems.biz.op.tmpl.gj.ortmpl.ris;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.tmpl.gj.ortmpl.ris.bp.TmplRisSaveBP;

public class TmplRisAction extends EmsBaseAction {
	
	public TmplRisAction() {
		
//		setEmsLoadBP(new TmplRisLoadBP());
		setEmsSaveBP(new TmplRisSaveBP());
	}


	
}
