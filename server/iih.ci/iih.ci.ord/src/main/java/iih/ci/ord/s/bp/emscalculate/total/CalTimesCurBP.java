package iih.ci.ord.s.bp.emscalculate.total;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.bd.srv.freqdef.i.IFreqTimeDORService;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;

/**
 * 计算总次数BP
 * 
 * @author HUMS
 *
 */
public class CalTimesCurBP {

	// 频次下执行时刻
	private IFreqTimeDORService ifreqTimeDORService;

	public CalTimesCurBP() {
		ifreqTimeDORService = CiOrdAppUtils.getFreqTimeDORService();
	}

	/**
	 * 获取总次数
	 * 
	 * @return 总次数
	 */
	public int exec(CiEmsDTO ciEmsDto) throws BizException {

		if (ciEmsDto == null) {
			throw new BizException("计算总次数时参数不能为空");
		}

		// 总次数
		int timesCur = 0;

		Integer orders = ciEmsDto.getOrders();

		// 草药
		if (IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG.equals(ciEmsDto.getSd_srvtp())) {
			if (!isValid(orders)) {
				throw new BizException("计算草药总付数数时参数异常！");
			}
			return orders;
		}

		String id_freq = ciEmsDto.getId_freq();
		// 医嘱天数
		Integer days_or = ciEmsDto.getDays_or();
		// 频次下次数
		Integer freqct = ciEmsDto.getFreqct();
		// 频次周期数
		Integer frequnitct = ciEmsDto.getFrequnitct();
		// 频次周期类型编码
		String sd_frequnitct = ciEmsDto.getSd_frequnitct();
		
		if(!isValid(days_or)){
			return 1;
		}

		if (!isValid(freqct) || StringUtils.isBlank(sd_frequnitct) || !isValid(frequnitct)) {
			throw new BizException("计算总次数时医嘱天数、频次下次数、频次周期数、频次周期类型不能为空！");
		}

		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE.equals(ciEmsDto.getSd_frequnitct())) { // 一次

			return 1;
		} else if (IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR.equals(ciEmsDto.getSd_frequnitct())) { // 小时
			// 24小时除以一个周期的小时，算出24小时的次数
			return (24 / frequnitct) * days_or;
		} else if (IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY.equals(ciEmsDto.getSd_frequnitct())) { // 天
			// 频次为天时频次*天数计算总次数
			return freqct * days_or;
		} else if (IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK.equals(ciEmsDto.getSd_frequnitct())) { // 周

			return getTimesCurOfWeek(id_freq, days_or, freqct);
		}

		return timesCur;
	}

	/**
	 * 按周计算总次数
	 * 
	 * @param days
	 * @param freqct
	 * @return
	 * @throws BizException
	 */
	private int getTimesCurOfWeek(String id_freq, int days, int freqct) throws BizException {

		if (days % 7 == 0) {
			return freqct * days / 7;
		} else {
			int times = this.getResidualFrequency(id_freq);
			return freqct * (days / 7) + times;
		}
	}

	/**
	 * 获取当执行频次下剩余的执行次数
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	private int getResidualFrequency(String id_freq) throws BizException {

		// 获取服务器时间
		FDateTime fdateTime = CiOrdAppUtils.getServerDateTime();
		int dayOfWeek = fdateTime.getDate().getDayOfWeek();
		FTime fTime = fdateTime.getUFTime();
		

		String whereStr = "id_freq = '" + id_freq + "'";
		FreqTimeDO[] freqTimeDOs = ifreqTimeDORService.find(whereStr, "sortno", FBoolean.FALSE);
		if (freqTimeDOs == null || freqTimeDOs.length == 0) {
			throw new BizException("未获取到频次id为" + id_freq + "下的执行时刻");
		}

		int times = freqTimeDOs.length;
		for (FreqTimeDO freqTimeDO : freqTimeDOs) {
			if (dayOfWeek > freqTimeDO.getWdno()) {
				times--;
				continue;
			}

			if (fTime.after(freqTimeDO.getTime_mp())) {
				times--;
				continue;
			}

			break;
		}

		return times;
	}

	private boolean isValid(Integer param) {

		if (param != null && param > 0) {
			return true;
		}

		return false;
	}
}
