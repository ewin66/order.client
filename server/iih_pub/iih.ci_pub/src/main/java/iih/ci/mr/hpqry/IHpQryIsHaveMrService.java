package iih.ci.mr.hpqry;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

public interface IHpQryIsHaveMrService {

	/**
	 * 判断指定就诊号 和 病历文书类型编码，在指定时间区域内的书写签署状态
	 * @param id_ent 就诊号
	 * @param code 病历文书类型编码
	 * @param dt_begin 时间左区域
	 * @param dt_end 时间 右区域
	 * @return
	 * @throws BizException
	 */
	public abstract int IsHaveMr(String id_ent, String code,
			FDateTime dt_begin, FDateTime dt_end) throws BizException;
}
