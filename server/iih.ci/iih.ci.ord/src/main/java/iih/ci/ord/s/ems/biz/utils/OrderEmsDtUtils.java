package iih.ci.ord.s.ems.biz.utils;

import xap.mw.coreitf.d.FDateTime;

public class OrderEmsDtUtils {
	/**
	 * 计算停止时间（已使用）
	 * @param statTime
	 * @param usedays
	 * @return
	 */
	public static FDateTime GetEndDateTime(FDateTime statTime, int usedays) {
		if (statTime == null || usedays == 0)
			return null;

		return statTime.getDateTimeAfter(usedays);
	}
}
