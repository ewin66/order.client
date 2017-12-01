package iih.ci.ord.s.utils;

import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

public class GetDrugTotalQuan4HerbsBP {
	public FDouble exec(CiEmsSrvDTO srvDO, int orders) throws BizException {
		
		// 草药剂量允许为空
		if(srvDO.getQuan_med() == null){
			return new FDouble(0);
		}
		
		int times = orders;// 总次数
		FDouble factor = getSaleFactor(srvDO.getId_mm(),srvDO.getId_unit_sale());
		if (factor == FDouble.ZERO_DBL){
			throw new BizException("总量单位的换算系数为0");
		}
		if (srvDO.getSd_roundmd() == "0") {
			return new FDouble(Math.ceil((double) (Math
					.ceil((double) (srvDO.getQuan_med().doubleValue() / srvDO.getFactor_mb().doubleValue()))
					/ factor.doubleValue())) * times);
		} else if (srvDO.getSd_roundmd() == "1"){
			return new FDouble( Math.ceil((double) (srvDO.getQuan_med().intValue() / srvDO.getFactor_mb().doubleValue() * times
					/ factor.doubleValue())));
		}else{
			return new FDouble( (double) (srvDO.getQuan_med().intValue() / srvDO.getFactor_mb().doubleValue() * times
					/ factor.doubleValue()));
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
