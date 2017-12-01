package iih.ci.ord.s.bp.splitpres;

import java.util.List;

import xap.mw.core.data.BizException;
/**
 * 分方的基类
 * @author li_zheng
 *
 */
public interface PresSplitBaseRule {
	/**
	 * exec
	 * @param list
	 * @return List<OrderPresSplitList>
	 * @throws BizException
	 */
	public List<OrderPresSplitList> exec(List<OrderPresSplitList> list)throws BizException;

}
