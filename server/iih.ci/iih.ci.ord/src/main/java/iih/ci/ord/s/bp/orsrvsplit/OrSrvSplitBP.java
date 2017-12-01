package iih.ci.ord.s.bp.orsrvsplit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.s.bp.orsrvsplit.help.OrSrvSetQuanMeduBp;
import iih.ci.ord.s.bp.orsrvsplit.help.OrSrvSplitHandleByFrepBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;

/***
 * 对有效医嘱服务结果进行医嘱服务拆分操作BP
 */
public class OrSrvSplitBP {
	/***
	 * 对有效医嘱服务结果进行医嘱服务拆分
	 * 
	 * @param srvsplitorders
	 * @param s
	 * @param e
	 * @param orgensplittp
	 * @return
	 * @throws BizException
	 */
	public SrvSplitOrderDTO[] exec(SrvSplitOrderDTO[] srvsplitorders, FDateTime s, FDateTime e, Integer orgensplittp) throws BizException {
		// 空处理逻辑
		if (srvsplitorders == null || srvsplitorders.length == 0)
			return null;

		// 逐一处理
		ArrayList<SrvSplitOrderDTO> list = new ArrayList<SrvSplitOrderDTO>();
		FDateTime[] validSE = null;
		Hashtable freqHt = new Hashtable();

		OrSrvSplitHandleByFrepBP frepBp = new OrSrvSplitHandleByFrepBP();

		boolean isLogicSplit = s != null;// 2016-06-13 xuxing 区分实际拆分与逻辑拆分
		for (int i = 0; i < srvsplitorders.length; i++) {

			// 获得有效开始时间 2016-06-08 xu_xing 修改(开始时间为空：实际拆分，开始时间不为空：逻辑拆分)
			FDateTime lastTime = null;
			if (!isLogicSplit) {
				lastTime = srvsplitorders[i].getDt_last_bl();
			} else {
				lastTime = s;
			}

			// 获得有效时间
			validSE = OrSrvSplitUtil.getValidStartEndDT(new FDateTime[] { srvsplitorders[i].getDt_effe(), srvsplitorders[i].getDt_end() }, new FDateTime[] { lastTime, e });
			// validSE=OrSrvSplitUtil.getValidStartEndDT(new
			// FDateTime[]{srvsplitorders[i].getDt_effe(),srvsplitorders[i].getDt_end()},new
			// FDateTime[]{getStartTime(s,lastTime),e});
			// validSE=OrSrvSplitUtil.getValidStartEndDT(new
			// FDateTime[]{srvsplitorders[i].getDt_effe(),srvsplitorders[i].getDt_end()},new
			// FDateTime[]{getStartTime(s,srvsplitorders[i].getDt_last_bl()),e});
			if (validSE == null)
				continue;

			// 特例处理逻辑 2016-06-13 增加实际与逻辑拆分标识参数
			if (specialCaseHandle(list, srvsplitorders[i], validSE, isLogicSplit))
				continue;

			// 频次拆分逻辑
			// splitHandleByFreq(list,srvsplitorders[i],validSE,freqHt);
			// ly 修改
			frepBp.exec(list, srvsplitorders[i], validSE, freqHt);
		}

		return (SrvSplitOrderDTO[]) list.toArray((SrvSplitOrderDTO[]) Array.newInstance(SrvSplitOrderDTO.class, 0));
	}

	/***
	 * 获得有效开始时间
	 * 
	 * @param s
	 * @param dt_last
	 * @return
	 */
	private FDateTime getStartTime(FDateTime s, FDateTime dt_last) {
		if (s == null) {
			return dt_last;
		} else if (dt_last == null) {
			return s;
		} else if (s.before(dt_last)) {
			return dt_last;
		}
		return s;
	}

	/***
	 * 特例情况拆分处理逻辑
	 * 
	 * @param list
	 * @param srvsplitorder
	 * @return
	 * @throws BizException
	 */
	private boolean specialCaseHandle(ArrayList<SrvSplitOrderDTO> list, SrvSplitOrderDTO srvsplitorder, FDateTime[] validSE, boolean isLogicSplit) throws BizException {

		if (isLogicSplit) {

			// 出院带药逻辑
			if (OrSrvSplitUtil.isTrue(srvsplitorder.getFg_pres_outp())) {
				srvsplitorder.setDt_mp_plan(null);
				list.add(srvsplitorder);
				return true;
			}

			// 草药逻辑
			if (OrSrvSplitUtil.isDtSrvTypeSame(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG, srvsplitorder.getSd_srvtp(), true)) {
				srvsplitorder.setDt_mp_plan(null);
				list.add(srvsplitorder);
				return true;
			}

			// 持续逻辑
			if (OrSrvSplitUtil.isAlwaysFreq1(srvsplitorder.getSd_frequnit())) {
				srvsplitorder.setDt_mp_plan(null);
				srvsplitorder.setQuan_medu(new FDouble(OrSrvSplitUtil.getDateTimeLengthBySeconds(validSE[0], validSE[1])));

				// 根据计量单位，换算医学数量 2016-05-07 xuxing
				OrSrvSetQuanMeduBp bp = new OrSrvSetQuanMeduBp();
				bp.exec(srvsplitorder);

				list.add(srvsplitorder);
				return true;
			}
		} else {//2016-06-13 针对出院带药之拆分一次，aways频次的，只拆分一次

			// 出院带药逻辑
			if (OrSrvSplitUtil.isTrue(srvsplitorder.getFg_pres_outp())) {
				if (srvsplitorder.getDt_effe().compareTo(validSE[0]) >= 0 && srvsplitorder.getDt_effe().compareTo(validSE[1]) <= 0) {
					srvsplitorder.setDt_mp_plan(srvsplitorder.getDt_effe());
					list.add(srvsplitorder);
					return true;
				}
				return true;
			}

			// 持续逻辑
			if (OrSrvSplitUtil.isAlwaysFreq1(srvsplitorder.getSd_frequnit())) {
				if (srvsplitorder.getDt_effe().compareTo(validSE[0]) >= 0 && srvsplitorder.getDt_effe().compareTo(validSE[1]) <= 0) {
					srvsplitorder.setDt_mp_plan(srvsplitorder.getDt_effe());
					srvsplitorder.setQuan_medu(new FDouble(OrSrvSplitUtil.getDateTimeLengthBySeconds(validSE[0], validSE[1])));
					OrSrvSetQuanMeduBp bp = new OrSrvSetQuanMeduBp();// 根据计量单位，换算医学数量 2016-05-07 xuxing
					bp.exec(srvsplitorder);
					list.add(srvsplitorder);
					return true;
				}
				return true;
			}
		}
		return false;
	}

	/***
	 * 按频次进行服务拆分处理逻辑
	 * 
	 * @param list
	 * @param srvsplitorder
	 * @param validSE
	 * @param freqHt
	 * @throws BizException
	 */
	private void splitHandleByFreq(ArrayList<SrvSplitOrderDTO> list, SrvSplitOrderDTO srvsplitorder, FDateTime[] validSE, Hashtable freqHt) throws BizException {
		String sd_frequnit = srvsplitorder.getSd_frequnit();
		String id_freq = srvsplitorder.getId_freq();

		// 按频次单位类型进行分类处理
		if (OrSrvSplitUtil.isTemporaryFreq(sd_frequnit)) {// 临时频次医嘱的处理逻辑
			cloneAndAddToList(list, srvsplitorder, srvsplitorder.getDt_effe());
		} else if (OrSrvSplitUtil.isPeriodHourFreq(sd_frequnit)) {// 周期性小时频次医嘱处理逻辑
																	// 不会出现3小时2次的概念只能是N小时1次
			FDateTime[] dts = OrSrvSplitUtil.getDateArrayByHour(validSE[0], validSE[1], srvsplitorder.getFrequnitcnt());
			cloneAndAddToList(list, srvsplitorder, dts);
		} else if (OrSrvSplitUtil.isPeriodFreq(sd_frequnit)) {// 周期性频次医嘱处理逻辑 天 周
																// 月
			FreqTimeDO[] freqtimedos = getFreqTimeDOs(id_freq, freqHt);
			FDateTime[] dts = getPeriodFreqTimes(validSE, freqtimedos, sd_frequnit);
			if (OrSrvSplitUtil.isTrue(srvsplitorder.getFg_dose_anoma())) {
				cloneAndAddToList(list, srvsplitorder, dts, OrSrvSplitUtil.getOrdSrvDoseDOs(srvsplitorder.getId_orsrv()));
			} else {
				cloneAndAddToList(list, srvsplitorder, dts);
			}
		} else if (OrSrvSplitUtil.isPlanFreq(sd_frequnit)) {// 计划频次医嘱的处理逻辑
			planFreqHandle(list, srvsplitorder, validSE);
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
	 * @param srvsplitorder
	 * @param dt_plan
	 * @throws BizException
	 */
	private void cloneAndAddToList(ArrayList<SrvSplitOrderDTO> list, SrvSplitOrderDTO srvsplitorder, FDateTime dt_plan) throws BizException {
		SrvSplitOrderDTO nsrvsplitorder = clone(srvsplitorder);
		nsrvsplitorder.setDt_mp_plan(dt_plan);
		list.add(nsrvsplitorder);
	}

	/***
	 * 克隆并添加到拆分列表中
	 * 
	 * @param list
	 * @param srvsplitorder
	 * @param dt_plan
	 * @throws BizException
	 */
	private void cloneAndAddToList(ArrayList<SrvSplitOrderDTO> list, SrvSplitOrderDTO srvsplitorder, FDateTime[] dt_plans) throws BizException {
		if (dt_plans == null)
			return;
		for (int i = 0; i < dt_plans.length; i++) {
			cloneAndAddToList(list, srvsplitorder, dt_plans[i]);
		}
	}

	/***
	 * 克隆并添加到拆分列表中
	 * 
	 * @param list
	 * @param srvsplitorder
	 * @param dt_plan
	 * @throws BizException
	 */
	private void cloneAndAddToList(ArrayList<SrvSplitOrderDTO> list, SrvSplitOrderDTO srvsplitorder, FDateTime[] dt_plans, OrdSrvDoseDO[] dosedos) throws BizException {
		if (dt_plans == null)
			return;
		for (int i = 0; i < dt_plans.length; i++) {
			cloneAndAddToList(list, srvsplitorder, dt_plans[i], dosedos[i]);
		}
	}

	/***
	 * 计划频次的处理
	 * 
	 * @param list
	 * @param srvsplitorder
	 * @param dtSE
	 * @throws BizException
	 */
	private void planFreqHandle(ArrayList<SrvSplitOrderDTO> list, SrvSplitOrderDTO srvsplitorder, FDateTime[] dtSE) throws BizException {
		OrdSrvDoseDO[] plandos = getOrdSrvDoseDOs(srvsplitorder.getId_orsrv());
		if (plandos == null || plandos.length == 0)
			return;
		FDateTime[] dt = null;
		for (int i = 0; i < plandos.length; i++) {
			dt = OrSrvSplitUtil.getValidDateArray(dtSE, new FDateTime[] { plandos[i].getDt_freq() });
			if (dt == null || dt.length == 0)
				continue;
			cloneAndAddToList(list, srvsplitorder, dt[0], plandos[i]);
		}
	}

	/****
	 * 克隆并增加到拆分列表中
	 * 
	 * @param list
	 * @param srvsplitorder
	 * @param dt_mp_plan
	 * @param dosedo
	 * @throws BizException
	 */
	private void cloneAndAddToList(ArrayList<SrvSplitOrderDTO> list, SrvSplitOrderDTO srvsplitorder, FDateTime dt_mp_plan, OrdSrvDoseDO dosedo) throws BizException {
		SrvSplitOrderDTO nsrvsplitorder = clone(srvsplitorder);
		nsrvsplitorder.setId_medu(dosedo.getId_unit_dose());
		nsrvsplitorder.setQuan_medu(dosedo.getQuan_dose());
		nsrvsplitorder.setDt_mp_plan(dt_mp_plan);
		if (OrSrvSplitUtil.isTrue(nsrvsplitorder.getFg_mm())) {
			int[] numden = OrSrvSplitUtil.getNumDen(dosedo.getQuan_dose(), nsrvsplitorder.getFactor_mb());
			nsrvsplitorder.setQuan_num_base(numden[0]);
			nsrvsplitorder.setQuan_den_base(numden[1]);
		}
		list.add(nsrvsplitorder);
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
	 * 客隆算法
	 * 
	 * @param orsplitorder
	 * @return
	 * @throws BizException
	 */
	private SrvSplitOrderDTO clone(SrvSplitOrderDTO srvsplitorder) throws BizException {
		SrvSplitOrderCloneBP bp = new SrvSplitOrderCloneBP();
		return bp.exec(srvsplitorder);
	}

	/***
	 * 获得变动剂量信息数组
	 * 
	 * @param id_orsrv
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDoseDO[] getOrdSrvDoseDOs(String id_orsrv) throws BizException {
		return OrSrvSplitUtil.getOrdSrvDoseDOs(id_orsrv);

	}

	/***
	 * 变动剂量处理逻辑
	 * 
	 * @param list
	 * @param srvsplitorder
	 * @param dts
	 * @throws BizException
	 */
	private void orSrvDoseHandle(ArrayList<SrvSplitOrderDTO> list, SrvSplitOrderDTO srvsplitorder, FDateTime[] dts) throws BizException {
		OrdSrvDoseDO[] dosedos = getOrdSrvDoseDOs(srvsplitorder.getId_orsrv());
		if (dosedos == null)
			return;

		/*
		 * //不规则剂量处理逻辑
		 * if(OrSrvSplitUtil.isTrue(srvsplitorder.getFg_dose_anoma())){
		 * orSrvDoseHandle(list,srvsplitorder,validSE); return true; }
		 */

	}
}
