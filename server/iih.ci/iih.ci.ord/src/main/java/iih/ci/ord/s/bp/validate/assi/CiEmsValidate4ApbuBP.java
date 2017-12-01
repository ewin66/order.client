package iih.ci.ord.s.bp.validate.assi;

import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.cior.i.ICiorappbtMDORService;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 用血医疗单检查
 * 
 * @author qzwang
 *
 */
public class CiEmsValidate4ApbuBP extends BaseEmsValidate4OtherBP {

	@Override
	public boolean exec(CiEmsDTO emsDTO, List<String> errorList) throws BizException {
		// TODO Auto-generated method stub

		CiEmsSrvDTO srv = getEmsSrvs(emsDTO);
		OrdApBtDO apbt = getAppBtDO(emsDTO.getId_or_rel());

		if (srv.getQuan_med()==null||srv.getQuan_med().doubleValue() <= 0 || srv.getQuan_med().doubleValue() > apbt.getNum_margin_bu().doubleValue()) {

			errorList.add("本次用血量的值无效！");

		}
		return errorList.size()==0;
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

	private CiEmsSrvDTO getEmsSrvs(CiEmsDTO emsDTO) {

		FArrayList m = emsDTO.getEmssrvs();
		CiEmsSrvDTO srv = null;
		srv = (CiEmsSrvDTO) m.get(0);
		return srv;
	}
}
