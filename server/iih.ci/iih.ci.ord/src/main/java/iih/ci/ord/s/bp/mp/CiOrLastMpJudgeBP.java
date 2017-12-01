package iih.ci.ord.s.bp.mp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.ci.ord.cior.d.CiOrLastMpDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.bp.qry.CiOrLastMpJudgeQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 临床医嘱执行是否为最后一顿判断操作BP
 */
public class CiOrLastMpJudgeBP {

	/**
	 * 临床医嘱执行是否为最后一顿判断
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public CiOrLastMpDTO[] exec(CiOrLastMpDTO[] param) throws BizException {
		// 有效性判断
		if (!validateCheck(param))
			return null;

		// 医嘱数据信息查询
		CiOrLastMpJudgeQry qry = new CiOrLastMpJudgeQry(param);
		CiOrLastMpDTO[] lastmpdtos = (CiOrLastMpDTO[]) AppFwUtil.getDORstWithDao(qry, CiOrLastMpDTO.class);

		//将计划执行时间放回医嘱信息中
		CiOrLastMpDTO[] finallastmpdtos = megreMpDTO(param, lastmpdtos);

		// 结果空判断
		if (CiOrdUtils.isEmpty(finallastmpdtos))
			return null;

		// 最后一顿判断处理
		return orLastMpHandle(finallastmpdtos);
	}

	private CiOrLastMpDTO[] megreMpDTO(CiOrLastMpDTO[] param, CiOrLastMpDTO[] lastmpdtos) {

		List<CiOrLastMpDTO> reList = new ArrayList<CiOrLastMpDTO>();

		HashMap<String, CiOrLastMpDTO> map = new HashMap<String, CiOrLastMpDTO>();

		for (CiOrLastMpDTO dto : lastmpdtos) {
			map.put(dto.getId_or(), dto);
		}

		for (CiOrLastMpDTO paramDTO : param) {

			CiOrLastMpDTO orderinfoDTO = map.get(paramDTO.getId_or());
			CiOrLastMpDTO DTO = (CiOrLastMpDTO) orderinfoDTO.clone();
			DTO.setDt_mp_plan(paramDTO.getDt_mp_plan());
			reList.add(DTO);
		}
		return reList.toArray(new CiOrLastMpDTO[reList.size()]);
	}

	/**
	 * 有效性校验
	 * 
	 * @param param
	 * @return
	 */
	private boolean validateCheck(CiOrLastMpDTO[] param) {
		if (CiOrdUtils.isEmpty(param))
			return false;

		return true;
	}

	/**
	 * 医嘱执行最后一顿判断处理逻辑
	 * 
	 * @param lastmpdtos
	 * @throws BizException
	 */
	private CiOrLastMpDTO[] orLastMpHandle(CiOrLastMpDTO[] lastmpdtos) throws BizException {
		int iN = lastmpdtos.length;
		CiOrLastMpDTO[] rtnlist = new CiOrLastMpDTO[iN];
		String sd_frequnit = null;
		String id_freq = null;
		CiOrLastMpDTO tm = null;
		Hashtable freqHt = new Hashtable();
		FreqTimeDO[] freqtimedos = null;

		// 遍历
		for (int i = 0; i < iN; i++) {
			// 特例情况处理
			tm = specialCaseHandle(lastmpdtos[i]);
			if (!CiOrdUtils.isEmpty(tm)) {
				rtnlist[i] = tm;
				continue;
			}

			// 参数值设置
			sd_frequnit = lastmpdtos[i].getSd_frequnit();
			id_freq = lastmpdtos[i].getId_freq();

			// 按频次类型进行分类处理
			if (OrSrvSplitUtil.isTemporaryFreq(sd_frequnit)) {// 临时频次医嘱的处理逻辑
				rtnlist[i] = getCiOrLastMpDTO4TempOr(lastmpdtos[i]);
			} else if (OrSrvSplitUtil.isPeriodHourFreq(sd_frequnit)) {// 周期性小时频次医嘱处理逻辑
				rtnlist[i] = getCiOrLastMpDTO4PeriodHour(lastmpdtos[i]);
			} else if (OrSrvSplitUtil.isPeriodFreq(sd_frequnit)) {// 周期性频次医嘱处理逻辑
																	// 天 周
				if (OrSrvSplitUtil.isPeriodDayFreq(sd_frequnit)) {
					rtnlist[i] = getCiOrLastMpDTO4PeriodDay(lastmpdtos[i], freqHt);
				} else if (OrSrvSplitUtil.isPeriodWeekFreq(sd_frequnit)) {
					rtnlist[i] = getCiOrLastMpDTO4PeriodWeek(lastmpdtos[i], freqHt);
				} else if (OrSrvSplitUtil.isPeriodMonthFreq(sd_frequnit)) {
					rtnlist[i] = getCiOrLastMpDTO4PeriodMonth(lastmpdtos[i], freqHt);
				} else {// 暂时不支持
					rtnlist[i] = LastMpHelper.getUnknownLastMpInfoDTO(lastmpdtos[i]);
				}
			} else if (OrSrvSplitUtil.isPlanFreq(sd_frequnit)) {// 计划频次医嘱的处理逻辑
				rtnlist[i] = getCiOrLastMpDTO4Plan(lastmpdtos[i]);
			} else if (OrSrvSplitUtil.isAlwaysFreq1(sd_frequnit)) {// 持续医嘱处理
				rtnlist[i] = getCiOrLastMpDTO4Always(lastmpdtos[i]);
			} else {// 暂不支持
				rtnlist[i] = LastMpHelper.getUnknownLastMpInfoDTO(lastmpdtos[i]);
			}
		}

		return rtnlist;
	}

	/**
	 * 获得频次类型为持续Always时 最后一顿执行判断逻辑数据结果
	 * 
	 * @param param
	 * @return
	 */
	private CiOrLastMpDTO getCiOrLastMpDTO4Always(CiOrLastMpDTO param) {
		CiOrLastMp4AlwaysBP bp = new CiOrLastMp4AlwaysBP();
		return bp.exec(param);
	}

	/**
	 * 获得频次类型为周期性日时 最后一顿执行判断逻辑数据结果
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private CiOrLastMpDTO getCiOrLastMpDTO4PeriodDay(CiOrLastMpDTO param, Hashtable freqHt) throws BizException {
		CiOrLastMp4PeriodDayBP bp = new CiOrLastMp4PeriodDayBP();
		return bp.exec(param, freqHt);
	}

	/**
	 * 获得频次类型为周期性日时 最后一顿执行判断逻辑数据结果
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private CiOrLastMpDTO getCiOrLastMpDTO4Plan(CiOrLastMpDTO param) throws BizException {
		CiOrLastMp4PlanBP bp = new CiOrLastMp4PlanBP();
		return bp.exec(param);
	}

	/**
	 * 获得频次类型为周期性周时 最后一顿执行判断逻辑数据结果
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private CiOrLastMpDTO getCiOrLastMpDTO4PeriodWeek(CiOrLastMpDTO param, Hashtable freqHt) throws BizException {
		CiOrLastMp4PeriodWeekBP bp = new CiOrLastMp4PeriodWeekBP();
		return bp.exec(param, freqHt);
	}

	/**
	 * 获得频次类型为周期性月时 最后一顿执行判断逻辑数据结果
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private CiOrLastMpDTO getCiOrLastMpDTO4PeriodMonth(CiOrLastMpDTO param, Hashtable freqHt) throws BizException {
		CiOrLastMp4PeriodMonthBP bp = new CiOrLastMp4PeriodMonthBP();
		return bp.exec(param, freqHt);
	}

	/**
	 * 获得频次类型为周期性小时时 最后一顿执行判断逻辑数据结果
	 * 
	 * @param param
	 * @return
	 */
	private CiOrLastMpDTO getCiOrLastMpDTO4PeriodHour(CiOrLastMpDTO param) {
		CiOrLastMp4PeriodHourBP bp = new CiOrLastMp4PeriodHourBP();
		return bp.exec(param);
	}

	/**
	 * 获得频次类型为临时或一次性时 最后一顿执行判断逻辑数据结果
	 * 
	 * @param param
	 * @return
	 */
	private CiOrLastMpDTO getCiOrLastMpDTO4TempOr(CiOrLastMpDTO param) {
		return LastMpHelper.getLastMpInfoDTO(param);
	}

	/**
	 * 特例情况处理
	 * 
	 * @param inputdto
	 * @return
	 * @throws BizException
	 */
	private CiOrLastMpDTO specialCaseHandle(CiOrLastMpDTO param) throws BizException {
		IsOrLastMpSpecialCaseBP bp = new IsOrLastMpSpecialCaseBP();
		if (CiOrdUtils.isTrue(bp.exec(param)))
			return LastMpHelper.getLastMpInfoDTO(param);
		return null;
	}

}
