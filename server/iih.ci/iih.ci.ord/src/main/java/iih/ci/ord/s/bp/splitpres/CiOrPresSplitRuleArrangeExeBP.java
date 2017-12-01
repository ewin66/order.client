package iih.ci.ord.s.bp.splitpres;

import java.util.List;
import xap.mw.core.data.BizException;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.i.splitpres.ICiOrPresSplitRuleArrangePlugin;
import iih.ci.ord.pub.CiOrdUtils;

/**
 *  获得分方规则编排插件并执行编排操作BP
 */
public class CiOrPresSplitRuleArrangeExeBP {

	/**
	 * 获得分方规则编排插件并执行编排
	 * @param orpressplitlists
	 * @throws BizException
	 */
	public List<CiOrPresSplitList> exec(List<CiOrPresSplitList> orpressplitlists) throws BizException {
		//空判断
		if (CiOrdUtils.isEmpty(orpressplitlists))
			return null;

		//获得分方规则编排插件并执行
		ICiOrPresSplitRuleArrangePlugin arrangeplugin = CiOrdUtils.getCiOrPresSplitRuleArrangePlugin();
		orpressplitlists = arrangeplugin.exec(orpressplitlists);

		//返回值
		return orpressplitlists;
	}
	

	 
}
