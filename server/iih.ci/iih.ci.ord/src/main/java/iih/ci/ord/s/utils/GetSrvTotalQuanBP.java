package iih.ci.ord.s.utils;

import java.math.BigDecimal;

import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 计算非药品服务总量
 * 
 * @author qzwang
 *
 */
public class GetSrvTotalQuanBP {

	public FDouble exec(CiEmsSrvDTO srvDO, int use_day) throws BizException {
		if (StringUtil.isEmpty(srvDO.getId_freq())) {
			throw new BizException(srvDO.getName_srv() + " 频次为空");
		}
		IFreqdefMDORService freqdef = ServiceFinder.find(IFreqdefMDORService.class); // XapServiceMgr.find<IFreqdefMDORService>();
		FreqDefDO fq = freqdef.findById(srvDO.getId_freq());
		if (fq != null) {
			int frect = (fq.getFreqct() == null || fq.getFreqct() == 0) ? 1 : fq.getFreqct();
			int quan_med = (srvDO.getQuan_med() == null || srvDO.getQuan_med().doubleValue() == 0) ? 1
					: srvDO.getQuan_med().intValue();
			int useday = (use_day == 0 ? 1 : use_day);
			return new FDouble(quan_med * frect * useday).setScale(0, BigDecimal.ROUND_HALF_UP);
		}
		return FDouble.ZERO_DBL;
	}
}
