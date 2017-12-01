package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.tmpl.TmplRstDTO;
import iih.ci.ord.d.ems.tmpl.TmplSaveDTO;
import xap.mw.core.data.BizException;

/**
 * 辅助录入助手保存逻辑接口
 * @author wangqingzhu
 *
 */
public interface ITmplSaveBP {
	/**
	 * 模板保存医疗单
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract TmplRstDTO save(TmplSaveDTO arg) throws BizException;
}
