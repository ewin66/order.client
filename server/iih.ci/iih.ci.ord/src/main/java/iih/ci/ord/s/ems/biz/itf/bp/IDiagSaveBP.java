package iih.ci.ord.s.ems.biz.itf.bp;

import xap.mw.core.data.BizException;
import iih.ci.ord.d.ems.di.DiagRstDTO;
import iih.ci.ord.d.ems.di.DiagSaveDTO;

/**
 * 诊断保存逻辑接口
 * @author wangqingzhu
 *
 */
public interface IDiagSaveBP {

	/**
	 * 诊断保存逻辑处理方法
	 * @param diSaveInfo
	 * @return
	 */
	abstract DiagRstDTO save(DiagSaveDTO diSaveInfo)throws BizException;
}
