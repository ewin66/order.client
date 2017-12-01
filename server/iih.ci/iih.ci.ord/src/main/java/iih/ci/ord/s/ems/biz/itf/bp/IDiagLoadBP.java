package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.di.DiagLoadDTO;
import iih.ci.ord.d.ems.di.DiagRstDTO;

/**
 * 诊断加载逻辑
 * @author wangqingzhu
 *
 */
public interface IDiagLoadBP {
	/**
	 * 加载诊断信息逻辑
	 * @param diLoadInfo
	 * @return
	 */
	abstract DiagRstDTO load(DiagLoadDTO diLoadInfo);
}
