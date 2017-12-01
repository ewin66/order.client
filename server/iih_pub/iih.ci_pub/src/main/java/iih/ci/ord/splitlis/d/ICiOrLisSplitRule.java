package iih.ci.ord.splitlis.d;

import java.util.List;
import xap.mw.core.data.BizException;

/**
 * 医嘱分方规则接口
 */
public interface ICiOrLisSplitRule {
	/**
	 * 医嘱分方规则接口
	 * @param list
	 * @return
	 * @throws BizException
	 */
	public List<CiOrdLisSplitList> exec(List<CiOrdLisSplitList> list)throws BizException;
}
