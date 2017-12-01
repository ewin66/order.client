package iih.ci.ord.i.splitpres;

import java.util.List;
import xap.mw.core.data.BizException;

/**
 * 医嘱分方规则接口
 */
public interface ICiOrPresSplitRule {
	/**
	 * 医嘱分方规则接口
	 * @param list
	 * @return
	 * @throws BizException
	 */
	public List<CiOrPresSplitList> exec(List<CiOrPresSplitList> list)throws BizException;
}
