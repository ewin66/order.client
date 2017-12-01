package iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.drugs;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.drugs.bp.TmplDrugsSaveBP;


public class TmplDrugsAction extends EmsBaseAction {
	
	public TmplDrugsAction() {
		
//		setEmsLoadBP(new TmplDrugsLoadBP());
		setEmsSaveBP(new TmplDrugsSaveBP(new TmplDrugsValidate()));
	}


	
}
