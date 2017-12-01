package iih.ci.ord.s.bp.orsrvsplit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.ci.ord.ciorder.d.OrdFreqTimeDO;
import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/***
 * 对有效医嘱结果进行医嘱拆分操作BP
 */
public class OrSplitBP {
	/***
	 * 对有效医嘱结果进行医嘱拆分
	 * 
	 * @param orsplitorders
	 * @param s
	 * @param e
	 * @param orgensplittp
	 * @return
	 * @throws BizException
	 */
	public OrSplitOrderDTO[] exec(OrSplitOrderDTO[] orsplitorders, FDateTime s, FDateTime e) throws BizException {
		// 空处理逻辑
		if (orsplitorders == null || orsplitorders.length == 0)
			return null;

		// 逐一处理
		ArrayList<OrSplitOrderDTO> list = new ArrayList<OrSplitOrderDTO>();
		FDateTime[] validSE = null;
		Hashtable freqHt = new Hashtable();
		for (int i = 0; i < orsplitorders.length; i++) {

			// 2016-06-08 xuxing 有效开始时间取医嘱的最近生成时间(开始时间为空：实际拆分，开始时间不为空：逻辑拆分)
			FDateTime lastTime = null;
			if (s == null) {
				lastTime = orsplitorders[i].getDt_last_bl_or();
			} else {
				lastTime = s;
			}

			// 获得有效时间
			validSE = OrSrvSplitUtil.getValidStartEndDT(new FDateTime[] { orsplitorders[i].getDt_effe(), orsplitorders[i].getDt_end() }, new FDateTime[] { lastTime, e });
			if (validSE == null)
				continue;

			// 特例处理逻辑
			if (specialCaseHandle(list, orsplitorders[i], validSE))
				continue;

			// 频次拆分逻辑
			splitHandleByFreq(list, orsplitorders[i], validSE, freqHt);
		}

		return (OrSplitOrderDTO[]) list.toArray((OrSplitOrderDTO[]) Array.newInstance(OrSplitOrderDTO.class, 0));
	}

	/***
	 * 特例情况拆分处理逻辑
	 * 
	 * @param list
	 * @param orsplitorder
	 * @return
	 * @throws BizException
	 */
	private boolean specialCaseHandle(ArrayList<OrSplitOrderDTO> list, OrSplitOrderDTO orsplitorder, FDateTime[] validSE) throws BizException {
		// 持续逻辑
		if (OrSrvSplitUtil.isAlwaysFreq1(orsplitorder.getSd_frequnit())) {
			FDateTime[] dts = OrSrvSplitUtil.getDateArray(validSE[0], validSE[1]);
			alwaysFreqHandle(list, orsplitorder, dts, validSE);
			return true;
		}

		// 出院带药逻辑， 针对出院带药之拆分一次
		if (OrSrvSplitUtil.isTrue(orsplitorder.getFg_pres_outp())) {
			if (orsplitorder.getDt_effe().compareTo(validSE[0]) >= 0 && orsplitorder.getDt_effe().compareTo(validSE[1]) <= 0) {
				orsplitorder.setDt_mp_plan(orsplitorder.getDt_effe());
				list.add(orsplitorder);
				return true;
			}
			return true;
		}
		return false;
	}

	/***
	 * 按频次进行医嘱拆分处理逻辑
	 * 
	 * @param list
	 * @param orsplitorder
	 * @param validSE
	 * @param freqHt
	 * @throws BizException
	 */
	private void splitHandleByFreq(ArrayList<OrSplitOrderDTO> list, OrSplitOrderDTO orsplitorder, FDateTime[] validSE, Hashtable freqHt) throws BizException {
		String sd_frequnit = orsplitorder.getSd_frequnit();
		String id_freq = orsplitorder.getId_freq();

		// 按频次单位类型进行分类处理
		if (OrSrvSplitUtil.isTemporaryFreq(sd_frequnit)) {// 临时频次医嘱的处理逻辑
			// 2016-06-13 xuxing 临时频次处理（临时频次为首次拆分），避免重复拆分
			if (orsplitorder.getDt_effe().compareTo(validSE[0]) >= 0 && orsplitorder.getDt_effe().compareTo(validSE[1]) <= 0) {
				cloneAndAddToList(list, orsplitorder, orsplitorder.getDt_effe());
			}
		} else if (OrSrvSplitUtil.isPeriodHourFreq(sd_frequnit)) {// 周期性小时频次医嘱处理逻辑
																	// 不会出现3小时2次的概念只能是N小时1次
			FDateTime[] dts = OrSrvSplitUtil.getDateArrayByHour(validSE[0], validSE[1], orsplitorder.getFrequnitcnt());
			cloneAndAddToList(list, orsplitorder, dts);
		} else if (OrSrvSplitUtil.isPeriodFreq(sd_frequnit)) {// 周期性频次医嘱处理逻辑 天 周
																// 月
			FreqTimeDO[] freqtimedos = getFreqTimeDOs(id_freq, freqHt);
			FDateTime[] dts = getPeriodFreqTimes(validSE, freqtimedos, sd_frequnit);
			cloneAndAddToList(list, orsplitorder, dts);
		} else if (OrSrvSplitUtil.isPlanFreq(sd_frequnit)) {// 计划频次医嘱的处理逻辑
			FDateTime[] dts = OrSrvSplitUtil.getOrdFreqTimeDateTimes(orsplitorder.getId_or());
			cloneAndAddToList(list, orsplitorder, dts);

		} else {
			// 暂不支持
		}

	}

	/***
	 * 获得周期频次类型时间序列数组数据
	 * 
	 * @param validSE
	 * @param freqtimedos
	 * @param sd_frequnit
	 * @return
	 * @throws BizException
	 */
	private FDateTime[] getPeriodFreqTimes(FDateTime[] validSE, FreqTimeDO[] freqtimedos, String sd_frequnit) throws BizException {
		FDateTime[] dts = null;
		if (OrSrvSplitUtil.isPeriodDayFreq(sd_frequnit)) {// 天处理逻辑 只支持1天N次
			dts = OrSrvSplitUtil.getDateArrayByDay(validSE[0], validSE[1], freqtimedos);
		} else if (OrSrvSplitUtil.isPeriodWeekFreq(sd_frequnit)) { // 周处理逻辑
																	// 业务上只支持1周N次的数据
			dts = OrSrvSplitUtil.getDateArrayByWeek(validSE[0], validSE[1], freqtimedos);
		} else if (OrSrvSplitUtil.isPeriodMonthFreq(sd_frequnit)) { // 月的处理逻辑
																	// 业务上只支持1月N次的数据
																	// 月末倒数第一天
																	// 1、2、3、4.。。。、-3-2、-1
			dts = OrSrvSplitUtil.getDateArrayByMonth(validSE[0], validSE[1], freqtimedos);
		}
		return dts;
	}

	/***
	 * 克隆并添加到拆分列表中
	 * 
	 * @param list
	 * @param orsplitorder
	 * @param dt_plan
	 * @throws BizException
	 */
	private void cloneAndAddToList(ArrayList<OrSplitOrderDTO> list, OrSplitOrderDTO orsplitorder, FDateTime dt_plan) throws BizException {
		OrSplitOrderDTO norsplitorder = clone(orsplitorder);
		norsplitorder.setDt_mp_plan(dt_plan);
		list.add(norsplitorder);
	}

	/***
	 * 克隆并添加到拆分列表中
	 * 
	 * @param list
	 * @param orsplitorder
	 * @param dt_plan
	 * @throws BizException
	 */
	private void cloneAndAddToList(ArrayList<OrSplitOrderDTO> list, OrSplitOrderDTO orsplitorder, FDateTime[] dt_plans) throws BizException {
		if (dt_plans == null)
			return;
		for (int i = 0; i < dt_plans.length; i++) {
			cloneAndAddToList(list, orsplitorder, dt_plans[i]);
		}
	}

	/***
	 * 获得医嘱频次时刻DO集合数据
	 * 
	 * @param id_freq
	 * @param freqHt
	 * @return
	 * @throws BizException
	 */
	private FreqTimeDO[] getFreqTimeDOs(String id_freq, Hashtable freqHt) throws BizException {
		GetFreqTimeDOsBP bp = new GetFreqTimeDOsBP();
		return bp.exec(id_freq, freqHt);
	}

	/***
	 * 持续频率类型的处理逻辑
	 * 
	 * @param list
	 * @param orsplitorder
	 * @param dts
	 * @param validSE
	 * @throws BizException
	 */
	private void alwaysFreqHandle(ArrayList<OrSplitOrderDTO> list, OrSplitOrderDTO orsplitorder, FDateTime[] dts, FDateTime[] validSE) throws BizException {
		int iLen = dts.length;
		if (iLen == 1) {
			alwaysFreqLen1Handle(list, orsplitorder, validSE);
			return;
		}// 一日内情形的处理
		Object[] o = null;

		// 遍历
		for (int i = 0; i < iLen; i++) {
			// 获得持续频次执行相关数据信息
			o = getAlwaysFreqExecInfo(dts, validSE, i, iLen);

			// 持续时间为0时的处理
			if (((int) o[1]) == 0)
				continue;

			// 创建新的拆分对象并赋值执行相关信息
			OrSplitOrderDTO tmp = clone(orsplitorder);
			tmp.setDt_mp_plan((FDateTime) o[0]); //
			tmp.setDurationsec((int) o[1]);

			// 拆分对象添加到列表中
			list.add(tmp);
		}
	}

	/**
	 * 获得持续频次执行相关数据信息 开始时间 0 持续时间秒数1
	 * 
	 * @param dts
	 * @param validSE
	 * @param i
	 * @param iLen
	 * @return
	 */
	private Object[] getAlwaysFreqExecInfo(FDateTime[] dts, FDateTime[] validSE, int i, int iLen) {
		Object[] rtns = new Object[2]; // 开始时间 0 持续时间秒数1
		if (i == 0) {// 首日逻辑
			rtns[0] = validSE[0];
			rtns[1] = IOrAndSrvSplitConst.TIME_DAY_SECONDS - FDateTime.getSecondsBetween(dts[i], validSE[0]);
		} else if (i == iLen - 1) {// 末日逻辑
			rtns[0] = dts[i];
			rtns[1] = FDateTime.getSecondsBetween(dts[i], validSE[1]);
		} else {// 原有逻辑 代码
			rtns[0] = dts[i];
			rtns[1] = IOrAndSrvSplitConst.TIME_DAY_SECONDS;
		}

		return rtns;
	}

	/**
	 * 持续频率类型的处理逻辑（一日内的持续）
	 * 
	 * @param list
	 * @param orsplitorder
	 * @param validSE
	 * @throws BizException
	 */
	private void alwaysFreqLen1Handle(ArrayList<OrSplitOrderDTO> list, OrSplitOrderDTO orsplitorder, FDateTime[] validSE) throws BizException {
		// 获得持续时间
		int durationsec = FDateTime.getSecondsBetween(validSE[0], validSE[1]);

		// 持续时间是否为0判断
		if (durationsec == 0)
			return;

		// 拆分对象赋值执行相关信息
		orsplitorder.setDt_mp_plan(validSE[0]);
		orsplitorder.setDurationsec(durationsec);

		// 拆分对象添加到列表中
		list.add(orsplitorder);
	}

	/***
	 * 客隆算法
	 * 
	 * @param orsplitorder
	 * @return
	 * @throws BizException
	 */
	private OrSplitOrderDTO clone(OrSplitOrderDTO orsplitorder) throws BizException {
		OrSplitOrderCloneBP bp = new OrSplitOrderCloneBP();
		return bp.exec(orsplitorder);
	}
}
