package iih.ci.ord.s.ems.biz.op.tmpl.std.ortmpl.drugs;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.tmpl.std.ortmpl.drugs.bp.TmplDrugsSaveBP;


public class TmplDrugsAction extends EmsBaseAction {
	
	public TmplDrugsAction() {
		
//		setEmsLoadBP(new TmplDrugsLoadBP());
		setEmsSaveBP(new TmplDrugsSaveBP());
	}


	
}
