package iih.ci.ord.s.utils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.core.xstream.FDoubleConverter;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 计算非变动用药的总量
 * 
 * @author qzwang
 *
 */
public class GetDrugTotalQuanBP {
	public FDouble exec(CiEmsSrvDTO srvDO, int use_day) throws BizException {
		if (StringUtil.isEmpty(srvDO.getId_freq())){
			throw new BizException(srvDO.getName_srv() +" 频次为空");
		}
		IFreqdefMDORService freqdef = ServiceFinder.find(IFreqdefMDORService.class); //XapServiceMgr.find<IFreqdefMDORService>();
        FreqDefDO fq = freqdef.findById(srvDO.getId_freq());
		if (fq != null){
			int times = getTotalCount(fq.getSd_frequnitct(), fq.getFreqct(), use_day<=0?1:use_day, 0);// 总次数
			FDouble factor = getSaleFactor(srvDO.getId_mm(),srvDO.getId_unit_sale());
			if(CiOrdUtils.isEmpty(srvDO.getId_mm())){
				return new FDouble(0);
			}
			if (factor == FDouble.ZERO_DBL){
				throw new BizException("总量单位的换算系数为0");
			}
			if ( "0".equals(srvDO.getSd_roundmd())) { // 按次取整
				return new FDouble(Math.ceil((double) (Math
						.ceil((double) (srvDO.getQuan_med().doubleValue() / srvDO.getFactor_mb().doubleValue()))
						/ factor.doubleValue())) * times);
			} else if( "1".equals(srvDO.getSd_roundmd())){ // 按批取整
				return new FDouble(Math.ceil((double) (srvDO.getQuan_med().doubleValue() / srvDO.getFactor_mb().doubleValue() * times
						/ factor.doubleValue())));
			}else{// 不取整
				return new FDouble((double) (srvDO.getQuan_med().doubleValue() / srvDO.getFactor_mb().doubleValue() * times
						/ factor.doubleValue()));
			}
		}
		
		return FDouble.ZERO_DBL;
	}

	private int getTotalCount(String sd_frequnitct, int freqct, int use_day, int ifirstdayadjust) {
		switch (sd_frequnitct) {
		case IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR:// "小时":
			// ，药品使用总次数=[（@开始日期-@停止日期） 换算出小时时间]÷BD_FREQ. frequnitct频次周期数。
			// 说明：先取得总小时数，再除以频次周期数，取计算结果商数。
			return use_day * 24 / freqct;

		case IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY:// "天"
			// 药品使用总次数= BD_FREQ. freqct频次周期下次数*@使用天数；
			int ucount = use_day * freqct;
			// "首日量调整"
			ucount = ucount - ifirstdayadjust;
			ucount = ucount < 0 ? 0 : ucount;
			return ucount;

		case IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK: // "星期"
			// 药品使用总次数= BD_FREQ. freqct频次周期下次数*@使用天数/7
			// 如果X÷7能整除，显示值=X；
			// 如果X÷7不能整除，显示值=商数+7
			int Weekcount = 0;
			if (freqct * use_day % 7 == 0) {
				Weekcount = use_day / 7;
			} else {
				Weekcount = use_day / 7 + 1;
			}

			return Weekcount * freqct;
		default:
			return 1;
		}
	}
	/**
	 * 获取物品总量单位的换算系数
	 * @param meterial
	 * @param id_unit_sale
	 * @return
	 * @throws BizException 
	 */
	private FDouble getSaleFactor(String id_mm ,String id_unit_sale) throws BizException{
		MeterialAggDO meterial = CiOrdAppUtils.getIMeterialRService().findById(id_mm);
		 
		if(meterial != null && id_unit_sale != null)
		{
			for (MMPackageUnitDO item : meterial.getMMPackageUnitDO()){
				if(item.getId_unit_pkg().equals(id_unit_sale)){
					return item.getFactor();
				}
			}
		}
		return FDouble.ONE_DBL;
	}
}
