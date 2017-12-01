package iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.apbt;

import java.util.Date;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.ErrorEmsList;
import iih.ci.ord.s.ems.biz.op.tmpl.base.apbt.TmplBaseApBtValidate;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 备血医疗单有效性检查
 * @author wangqingzhu
 *
 */
public class TmplApBtValidate extends TmplBaseApBtValidate {

	public ErrorEmsList beforeSaveValidate(Object objEms) throws BizException {
		return new ErrorEmsList();
	}

	public ErrorEmsList viewModelValidate(Object objEms, CiEnContextDTO ctx)
			throws BizException {
		
		return null;
	}

	private PatDO getPatDO(String id_pat) throws BizException {

		IPatiMDORService service = ServiceFinder.find(IPatiMDORService.class);
		PatDO pat = service.findById(id_pat);
		return pat;
	}

	// 女性年满18岁，生育史必填
	private boolean validateage(FDate birthdate) {

		Date d = new Date();
		FDate olddate = new FDate(new Date(d.getYear() - 18, d.getMonth(), d.getDay()));
		if (birthdate.before(olddate))
			return false;
		else {
			return true;
		}
	}
}
