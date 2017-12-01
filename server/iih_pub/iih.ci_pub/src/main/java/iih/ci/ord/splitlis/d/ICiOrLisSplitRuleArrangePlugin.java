package iih.ci.ord.splitlis.d;

import java.util.List;
import xap.mw.core.data.BizException;

/**
 * 临床医嘱分方规则编排插件接口
 */
public interface ICiOrLisSplitRuleArrangePlugin {
	/**
	 * 临床医嘱分方规则编排
	 * @param orpressplitlist
	 * @return
	 * @throws BizException
	 */
	public List<CiOrdLisSplitList> exec(List<CiOrdLisSplitList> orpressplitlist)throws BizException; 

}
