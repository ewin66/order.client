package iih.ci.ord.s.utils;

import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class GetDrugDaysOfAvailable {
	public int exec(CiEmsSrvDTO srvDTO) throws BizException {
		if (StringUtil.isEmpty(srvDTO.getSd_srvtp()) || StringUtil.isEmpty(srvDTO.getId_mm())
				|| StringUtil.isEmpty(srvDTO.getId_unit_sale())) {
			return 0;
		}

		if (srvDTO.getSd_srvtp().startsWith("0101") || srvDTO.getSd_srvtp().startsWith("0102")) {
			if (StringUtil.isEmpty(srvDTO.getId_freq())) {
				throw new BizException(srvDTO.getName_srv() + " 频次为空");
			}
			IFreqdefMDORService freqdef = ServiceFinder.find(IFreqdefMDORService.class); // XapServiceMgr.find<IFreqdefMDORService>();
			FreqDefDO fq = freqdef.findById(srvDTO.getId_freq());
			if (fq != null) {
				// 变动用药
				if (srvDTO.getFg_dose_anoma() != null && srvDTO.getFg_dose_anoma().booleanValue()) {
					// 需要变动用药逻辑
				} else {
					// 取值总量单位的换算系数和物品的取整模式
					FDouble factor = new GetDrugSaleFactor().exec(srvDTO.getId_mm(), srvDTO.getId_unit_sale());

					if (null != fq.getFreqct() && 0 != fq.getFreqct() && null != srvDTO.getQuan_med()
							&& 0 != srvDTO.getQuan_med().doubleValue()) {
						double days = (srvDTO.getQuan_cur().doubleValue() * factor.doubleValue()
								* srvDTO.getFactor_mb().doubleValue())
								/ (fq.getFreqct().doubleValue() * srvDTO.getQuan_med().doubleValue());

						return (int) days;
					}
				}
			}
		}
		return 0;
	}
}
