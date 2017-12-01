package iih.ci.ord.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 人员权限判断
 * @author YANG
 *
 */
public interface IPsnAuthorityCertifyService {

	/**
	 * 人员处方权判断
	 * @param id_psn 人员ID
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean CertifyPsnPresAuthority(String id_psn) throws BizException;
}
