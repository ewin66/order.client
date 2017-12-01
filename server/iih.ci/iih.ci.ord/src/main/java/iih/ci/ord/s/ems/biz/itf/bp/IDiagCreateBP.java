package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.di.DiagCrtDTO;
import iih.ci.ord.d.ems.di.DiagRstDTO;

/**
 * 
 * @author wangqingzhu
 *
 */
public interface IDiagCreateBP {
	/**
	 * 诊断创建接口逻辑
	 * @param diCreateInfo
	 * @return
	 */
	abstract DiagRstDTO create(DiagCrtDTO diCreateInfo);
}
