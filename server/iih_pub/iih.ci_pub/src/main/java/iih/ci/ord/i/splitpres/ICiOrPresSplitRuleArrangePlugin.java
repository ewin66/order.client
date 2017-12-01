package iih.ci.ord.i.splitpres;

import java.util.List;
import xap.mw.core.data.BizException;

/**
 * 临床医嘱分方规则编排插件接口
 */
public interface ICiOrPresSplitRuleArrangePlugin {
	/**
	 * 临床医嘱分方规则编排
	 * @param orpressplitlist
	 * @return
	 * @throws BizException
	 */
	public List<CiOrPresSplitList> exec(List<CiOrPresSplitList> orpressplitlist)throws BizException; 

}
