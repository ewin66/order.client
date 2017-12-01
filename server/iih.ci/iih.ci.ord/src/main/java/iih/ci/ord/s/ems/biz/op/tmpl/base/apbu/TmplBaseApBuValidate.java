package iih.ci.ord.s.ems.biz.op.tmpl.base.apbu;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.cior.i.ICiorappbtMDORService;
import iih.ci.ord.dto.d.CiordubDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.ErrorEmsList;
import iih.ci.ord.s.ems.biz.op.base.action.EmsBaseValidate;

/**
 * 用血医疗单有效性检查
 * @author wangqingzhu
 *
 */
public class TmplBaseApBuValidate extends EmsBaseValidate {

	public ErrorEmsList beforeSaveValidate(Object objEms) throws BizException {
		return null;
	}

	public ErrorEmsList viewModelValidate(Object objEms, CiEnContextDTO ctx)
			throws BizException {
		CiordubDTO ubdo=(CiordubDTO)objEms;
		if(ubdo==null)return null;
		FArrayList errorList=new FArrayList();
		OrdApBtDO apbt = getAppBtDO(ubdo.getId_or_rel());
		// 用血量小于等于备血量
        if (ubdo.getQuan_medu_ub().toDouble() > ubdo.getQuan_medu().toDouble())
        {
            errorList.add("用血量不能大于备血量！");
        }
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
