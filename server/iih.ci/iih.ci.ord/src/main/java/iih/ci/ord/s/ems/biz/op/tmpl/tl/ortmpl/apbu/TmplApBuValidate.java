package iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.apbu;

import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.cior.i.ICiorappbtMDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.ErrorEmsList;
import iih.ci.ord.s.ems.biz.op.tmpl.base.apbu.TmplBaseApBuValidate;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 用血医疗单有效性检查
 * @author wangqingzhu
 *
 */
public class TmplApBuValidate extends TmplBaseApBuValidate {

	public ErrorEmsList beforeSaveValidate(Object objEms) throws BizException {
		return null;
	}

	public ErrorEmsList viewModelValidate(Object objEms, CiEnContextDTO ctx)
			throws BizException {
		
		return null;
	}
	
	private OrdApBtDO getAppBtDO(String id_or) throws BizException {

		ICiorappbtMDORService service = ServiceFinder.find(ICiorappbtMDORService.class);
		OrdApBtDO[] apbts = service.find(OrdApBtDODesc.TABLE_ALIAS_NAME + ".id_or='" + id_or + "'", null, FBoolean.FALSE);
		if (apbts != null && apbts.length > 0)
			return apbts[0];
		else {
			return null;
		}
	}
}
