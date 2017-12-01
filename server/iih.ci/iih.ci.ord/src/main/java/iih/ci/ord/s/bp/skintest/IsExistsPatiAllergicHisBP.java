package iih.ci.ord.s.bp.skintest;

import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.DateUtils;
import iih.pi.overview.overview.d.PiPatAlDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 患者是否存在药品过敏史数据信息操作BP
 */
public class IsExistsPatiAllergicHisBP {
	/**
	 * 是否存在药品过敏史数据
	 * 
	 * @param id_empi
	 *            患者（主索引）
	 * @param id_pharm_master
	 *            药品（主数据）
	 * @return
	 * @throws BizException
	 */
	public PiPatAlDO exec(String id_org, String id_empi, String id_pharm_master)
			throws BizException {
		// 有效性判断
		if (CiOrdUtils.isEmpty(id_empi) || CiOrdUtils.isEmpty(id_pharm_master))
			return null;

		// 获得过敏史的有效最小最大时间数据
		String[] dt_minmax = getDtMinMax(id_org);

		// 获得患者药品过敏史数据信息
		PiPatAlDO[] pialdos = getPatiAllergicHisInfo(id_empi, id_pharm_master,
				dt_minmax[0], dt_minmax[1]);

		// 返回值处理
		if (CiOrdUtils.isEmpty(pialdos))
			return null;
		return pialdos[0];
	}

	/**
	 * 获得过敏史有效最小最大时间数据信息
	 * 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	private String[] getDtMinMax(String id_org) throws BizException {
		Integer qryrange = ParamsetQryUtil.getParaInt(id_org,
				ICiOrdNSysParamConst.SYS_PARAM_AllergyQryYearLimit);
		if (qryrange == null)
			qryrange = 10; // 空则设置默认年值
		FDateTime endTime = CiOrdAppUtils.getServerDateTime();
		FDateTime beginTime = DateUtils.getDateTime(endTime.getYear()
				- qryrange, null, null);

		String formatStr = DateUtils.dateFormatStr;
		return new String[] {
				DateUtils.getDateTimeStr(beginTime.toStdString(), formatStr),
				DateUtils.getDateTimeStr(endTime.toStdString(), formatStr) };
	}

	/**
	 * 获得患者药品过敏史数据信息
	 * @param id_empi
	 * @param id_pharm_master
	 * @param dt_min
	 * @param dt_max
	 * @return
	 * @throws BizException
	 */
	private PiPatAlDO[] getPatiAllergicHisInfo(String id_empi,
			String id_pharm_master, String dt_min, String dt_max)
			throws BizException {
		GetPatiAllergicHisBP bp = new GetPatiAllergicHisBP();
		return bp.exec(id_empi, id_pharm_master, dt_min, dt_max);
	}
}
