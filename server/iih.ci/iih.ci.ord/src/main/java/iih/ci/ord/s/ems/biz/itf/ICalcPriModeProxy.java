package iih.ci.ord.s.ems.biz.itf;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import xap.mw.core.data.BizException;

/**
 * 调用费用计价模式接口代理
 * @author wangqingzhu
 *
 */
public interface ICalcPriModeProxy {
	abstract PriStdSrvDTO[] Calc() throws BizException;
	abstract int getEuSource();
	abstract String toDesction();
}
