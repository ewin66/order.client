package iih.ci.ord.s.ems.biz.op.fee;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.itf.IEmsValidate;
import iih.ci.ord.s.ems.biz.meta.ErrorEmsList;
import xap.mw.core.data.BizException;

/**
 * 费用清单保存校验
 * @author wangqingzhu
 *
 */
public class FeeListValidate implements IEmsValidate {

	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErrorEmsList beforeSaveValidate(Object[] szOrderPackage) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

}
