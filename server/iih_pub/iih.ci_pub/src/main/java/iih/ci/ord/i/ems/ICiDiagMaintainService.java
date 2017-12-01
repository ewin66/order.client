/**
 * 
 */
package iih.ci.ord.i.ems;

import iih.ci.ord.d.ems.di.DiagCrtDTO;
import iih.ci.ord.d.ems.di.DiagLoadDTO;
import iih.ci.ord.d.ems.di.DiagRstDTO;
import iih.ci.ord.d.ems.di.DiagSaveDTO;

/**
 * 诊断主服务接口
 * @author wangqingzhu
 *
 */
public interface ICiDiagMaintainService {
	/**
	 * 新建诊断
	 * @param diCreateInfo
	 * @return
	 */
	abstract DiagRstDTO create(DiagCrtDTO diCreateInfo);
	/**
	 * 加载诊断
	 * @param diLoadInfo
	 * @return
	 */
	abstract DiagRstDTO load(DiagLoadDTO diLoadInfo);
	/**
	 * 保存诊断
	 * @param diSaveInfo
	 * @return
	 */
	abstract DiagRstDTO save(DiagSaveDTO diSaveInfo);
	/**
	 * 签署诊断
	 * @param diSaveInfo
	 * @return
	 */
	abstract DiagRstDTO sign(DiagSaveDTO diSaveInfo);
}
