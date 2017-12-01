package iih.ci.ord.s.ems.biz.itf.bp;

import iih.ci.ord.d.ems.tmpl.TmplLoadDTO;
import iih.ci.ord.d.ems.tmpl.TmplRstDTO;
import xap.mw.core.data.BizException;

/**
 * 辅助录入助手前台数据加载接口
 * @author wangqingzhu
 *
 */
public interface ITmplLoadBP {
	/**
	 * 加载模板UI数据
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract TmplRstDTO load(TmplLoadDTO arg) throws BizException;
}
