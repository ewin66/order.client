package iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.apbu;

import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.apbu.bp.TmplApBuSaveBP;

public class TmplApBuAction extends EmsBaseAction {
	
	
	public TmplApBuAction() {
		
//		setEmsLoadBP(new TmplApBuLoadBP());	
		setEmsSaveBP(new TmplApBuSaveBP(new TmplApBuValidate()));
	}


}
