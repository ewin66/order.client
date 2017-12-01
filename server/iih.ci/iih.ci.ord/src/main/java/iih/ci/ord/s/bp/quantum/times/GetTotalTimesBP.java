package iih.ci.ord.s.bp.quantum.times;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.bd.srv.freqdef.d.FreqdefAggDO;
import iih.ci.ord.ciordems.d.QuantumParamDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 计算总次数的类入口
 * @author 张万青
 *
 */
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
public class GetTotalTimesBP {
	/**
	 * 草药：需要传入参数数据（服务类型sd_srvtp,代煎付数orders）其余参数可不传<BR/>
	 * 草药代煎费：需要传入参数数据 服务来源Eu_sourcemd，代煎付数Orders_boil 其余参数可不传<BR/>
	 * 备用医嘱：需要传入参数数据    备用医嘱标识 Fg_pmor 其余参数可不传<BR/>
	 * 频次类型为一次，总次数1<BR/>
	 * 需要通过计算获得总次数 传入参数：频次id_freq,使用天数use_day<BR/>
	 * 用法关联费用：总次数  =  在院执行次数。<BR/>
	 * 标本采集关联费用：总次数 =临床医嘱总次数。<BR/>
	 * 标本容器耗材费：总次数 = 临床医嘱总次数<BR/>
	 * 关联策略生成费用：总次数 = 1。
	 * @param QuantumParamDTO
	 * @return
	 * @throws BizException 
	 */
	public Integer getTotalTimesBP(QuantumParamDTO param) throws BizException{
		if (validate(param).booleanValue()) {
			// 草药类药品,总次数=医嘱付数
			if (!CiOrdUtils.isEmpty(param.getSd_srvtp())
					&& param.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				return param.getOrders();
			}
			// 非草药类 ,通过计算获得
			else {
				return getTotalTimes(param.getId_freq(), param.getUse_day());
			}

		}
		return 0;
	}
	/**
	 * 通过频次和使用天数计算获得总次数
	 * @param id_freq
	 * @param use_day
	 * @return
	 * @throws BizException
	 */
	public Integer getTotalTimes(String id_freq, Integer use_day) throws BizException {
		if (CiOrdUtils.isEmpty(id_freq)) {
			return 0;
		}
		FreqdefAggDO freqdefAgg = CiOrdUtils.getFreqAggDO(id_freq);
		FreqDefDO freqParent = freqdefAgg.getParentDO();
		FreqTimeDO[] freqTimes = freqdefAgg.getFreqTimeDO();

		String sd_frequnitct = freqParent.getSd_frequnitct();// 频次周期类型编码
		Integer freqct = freqParent.getFreqct();// 频次周期下次数
		Integer frequnitct = freqParent.getFrequnitct();// 频次周期数

		Integer totalTimes = 0;
		// 备用医嘱,总次数为=1
		if (!CiOrdUtils.isEmpty(freqParent.getFg_prnor()) && freqParent.getFg_prnor().booleanValue()) {
			totalTimes = 1;
		}else{
			switch (sd_frequnitct) {
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE:// 频次周期类型为一次:总次数=1
				totalTimes = 1;
				break;
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR:// 频次周期类型为小时:总次数 =使用天数*24/周期数（除不尽时，直接取整数，不做进位处理）
				totalTimes = use_day * 24 / frequnitct;
				break;
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY:// 频次周期类型为天:
				if (use_day != null) {
					totalTimes = use_day / frequnitct * freqct;// 总次数=（使用天数 /周期数）*周期下次数  （使用天数 /周期数=整数）
					Integer remainder = use_day % frequnitct;
					if (remainder != 0) {
						// 总次数=（除法后整数部分*周期下次数）+（取小于等于除法后余数的频次下执行时刻数量）（使用天数 /周期数!=整数）
						for (FreqTimeDO freqtime : freqTimes) {
							Integer execDay = freqtime.getDay();
							if (!CiOrdUtils.isEmpty(execDay) && execDay <= remainder) {
								totalTimes++;
							}
						}
					}
				}
				break;
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK:// 频次周期类型为周:
				if (use_day != null) {
					totalTimes = use_day / 7 * freqct;// 总次数=（使用天数 /周期数）*周期下次数   （使用天数 /周期数=整数）
					Integer remainder = use_day % 7;
					if (remainder != 0) {
						// 总次数=（除法后整数部分*周期下次数）+（取小于等于除法后余数的频次下执行时刻数量）（使用天数 /周期数!=整数）
						for (FreqTimeDO freqtime : freqTimes) {
							Integer execWeek = freqtime.getWeek();
							if (!CiOrdUtils.isEmpty(execWeek) && execWeek <= remainder) {
								totalTimes++;
							}
						}
					}
				}
				break;
			}
		}

		return totalTimes;
	}

	/**
	 * 药品领量天数计算，只有药品非草药类才需要计算
	 * 
	 * @param quan_cur
	 *            总量
	 * @param quan_medu
	 *            剂量
	 * @param factor
	 *            基本包装单位和总量单位间的换算系数
	 * @param factor_mb
	 *            医基换算系数
	 * @param id_freq
	 *            频次
	 * @return
	 * @throws BizException
	 */
	public Integer getDaysAvalidate(String sd_mupakgu, FDouble quan_cur, FDouble quan_medu, FDouble factor, FDouble factor_mb, String id_freq) 
			throws BizException {
		if (CiOrdUtils.isEmpty(id_freq) || CiOrdUtils.isEmpty(quan_cur) || CiOrdUtils.isEmpty(quan_medu)
				|| CiOrdUtils.isEmpty(factor_mb) || CiOrdUtils.isEmpty(factor)) {
			return 0;
		}
		FreqdefAggDO freqdefAgg = CiOrdUtils.getFreqAggDO(id_freq);
		FreqDefDO freqParent = freqdefAgg.getParentDO();
		FreqTimeDO[] freqTimes = freqdefAgg.getFreqTimeDO();
		
		String sd_frequnitct = freqParent.getSd_frequnitct();// 频次周期类型编码
		Integer freqct = freqParent.getFreqct();// 频次周期下次数
		Integer frequnitct = freqParent.getFrequnitct();// 频次周期数

		Integer totalTimes = 0;
		// 走舍位//考虑取整模式
		Integer times = this.calTimes(quan_cur, sd_mupakgu, quan_medu, factor_mb, factor).intValue();
		
		//频次的备用标志位true，走一日一次的逻辑
		if(!CiOrdUtils.isEmpty(freqParent.getFg_prnor()) && freqParent.getFg_prnor().booleanValue()){
			totalTimes = times;
		}else{
			switch(sd_frequnitct){
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE:// 频次周期类型为一次（once），走一日一次的逻辑
				totalTimes = times;
				break;
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR:// 频次周期类型为小时:领量天数 =总次数/频次下次数*周期数/24
				totalTimes = (times / freqct * frequnitct % 24) == 0 ? (times / freqct * frequnitct / 24) 
						: (times / freqct * frequnitct % 24 + 1);
				break;
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY:// 频次周期类型为天:
				totalTimes = times;
				Integer remainder_day = times % freqct;
				// 使用天数与周期数能整除
				if (remainder_day == 0 || frequnitct == 1) {
					// 领量天数 =总次数/频次下次数*周期数
					totalTimes = times / freqct * frequnitct;
				}
				// 不能整除
				else {
					int count = 0;
					// 排序
					CiOrdUtils.SortFreqTimeDO(freqTimes, "Day");
					for (FreqTimeDO freqtime : freqTimes) {
						if (++count == remainder_day) {
							totalTimes = times / freqct * frequnitct + freqtime.getDay();
						}
					}
				}
				break;
			case IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK:// 频次周期类型为周:
				totalTimes = times;
				Integer remainder_week = times % freqct;
				// 使用天数与周期数能整除
				if (remainder_week == 0) {
					totalTimes = times / freqct * 7;
				}
				// 不能整除
				else {
					int count = 0;
					// 排序
					CiOrdUtils.SortFreqTimeDO(freqTimes, "Week");
					for (FreqTimeDO freqtime : freqTimes) {
						if (++count == remainder_week) {
							totalTimes = times / freqct * 7 + freqtime.getWeek();
						}
					}
				}
				break;
			}
		}

		return totalTimes;
	}

	/**
	 * 按取整模式
	 * @param quan_cur
	 * @param sd_mupakgu
	 * @param quan_medu
	 * @param factor_mb
	 * @param factor
	 * @return
	 * @throws BizException
	 */
	private FDouble calTimes(FDouble quan_cur, String sd_mupakgu, FDouble quan_medu, FDouble factor_mb, FDouble factor)
			throws BizException {
		if (CiOrdUtils.isEmpty(sd_mupakgu) || CiOrdUtils.isEmpty(quan_medu) || CiOrdUtils.isEmpty(factor_mb)
				|| CiOrdUtils.isEmpty(factor))
			return new FDouble(0);
		// 按次取整
		if (sd_mupakgu.equals("0")) {
			return quan_cur.div(Math.ceil(quan_medu.div(factor_mb.multiply(factor)).getDouble()));
		}
		// 按批取整或不取整
		else if (sd_mupakgu.equals("1") || sd_mupakgu.equals("4")) {
			return quan_cur.multiply((factor_mb.multiply(factor))).div(quan_medu);
		} else {
			throw new BizException("计算药品领量总次数，取整模式配置错误，无法计算！");
		}
	}
	
	/**
	 * 校验参数
	 * @param param
	 * @return
	 */
	protected FBoolean validate(QuantumParamDTO param) {
		if (CiOrdUtils.isEmpty(param))
			return FBoolean.FALSE;
		return FBoolean.TRUE;
	}
}
