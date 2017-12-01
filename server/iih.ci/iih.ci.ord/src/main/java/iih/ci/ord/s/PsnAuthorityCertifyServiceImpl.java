package iih.ci.ord.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import iih.ci.ord.i.IPsnAuthorityCertifyService;
import iih.ci.ord.s.bp.CertifyPsnPresAuthorityBP;

/**
 * 人员权限判断
 * @author YANG
 *
 */
@Service(serviceInterfaces = { IPsnAuthorityCertifyService.class }, binding = Binding.JSONRPC)
public class PsnAuthorityCertifyServiceImpl implements IPsnAuthorityCertifyService {

	/**
	 * 人员处方权判断
	 * @param id_psn 人员ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean CertifyPsnPresAuthority(String id_psn) throws BizException {

		CertifyPsnPresAuthorityBP bp = new CertifyPsnPresAuthorityBP();
		boolean fg_pres = bp.exec(id_psn);
		return fg_pres ? FBoolean.TRUE : FBoolean.FALSE;
	}

}
