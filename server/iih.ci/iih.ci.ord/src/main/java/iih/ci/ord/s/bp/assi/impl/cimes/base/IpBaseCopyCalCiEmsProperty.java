package iih.ci.ord.s.bp.assi.impl.cimes.base;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 住院动态复制属性基类
 * 
 * @author HUMS
 *
 */
public class IpBaseCopyCalCiEmsProperty extends BaseCalCiEmsProperty {

	/**
	 * 在执行计算开始时复制相关属性
	 * 
	 * @param t
	 * @throws BizException
	 */
	protected void beforeCalcuateCustomProperty(CiEmsDTO ciEms) throws BizException {
		ciEms.setFg_pres_outp(FBoolean.FALSE);
		// 设置开始时间
		ciEms.setDt_begin(CiOrdAppUtils.getServerDateTime());
		// 医嘱天数
		if (ciEms.getDays_or() != null && ciEms.getDays_or() > 0) {
			FDateTime endDateTime = ciEms.getDt_begin().getDateTimeAfter(ciEms.getDays_or());
			ciEms.setDt_end(endDateTime);
		}
	}

	@Override
	protected void setCalTimesCur(CiEmsDTO ciEms) throws BizException {

		/*if (ciEms.getDays_or() == null) {
			ciEms.setTimes_cur(1);
		
		} else {
			CalTimesCurBP bp = new CalTimesCurBP();
			int times_cur = bp.exec(ciEms);
			ciEms.setTimes_cur(times_cur);
		}*/
	}

	@Override
	protected void setFgMpIn(CiEmsDTO ciEms) throws BizException {

		ciEms.setFg_mp_in(FBoolean.TRUE);
	}
}
