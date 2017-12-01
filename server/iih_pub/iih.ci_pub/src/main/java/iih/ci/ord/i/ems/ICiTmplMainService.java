package iih.ci.ord.i.ems;

import iih.ci.ord.d.ems.tmpl.TmplLoadDTO;
import iih.ci.ord.d.ems.tmpl.TmplRstDTO;
import iih.ci.ord.d.ems.tmpl.TmplSaveDTO;
import xap.mw.core.data.BizException;

public interface ICiTmplMainService {
	/**
	 * 加载模板
	 * @param ems
	 * @return
	 */
	public abstract TmplRstDTO load(TmplLoadDTO ems) throws BizException ;
	
	
	
	/**
	 * 保存模板
	 * @param ems
	 * @return
	 */
	public abstract TmplRstDTO save(TmplSaveDTO ems) throws BizException ;
}
