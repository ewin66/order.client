package iih.ci.ord.s.utils;

import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 计算变动用药总量
 * @author qzwang
 *
 */
public class GetDrugTotalQuan4DoseBP {
	public FDouble exec(CiEmsSrvDTO srvDO, int use_day)
	{
		// 暂时注销，等待变动用药需求推演明确之后，在计算算法
//		if (srvDO.getSd_roundmd() == "0")
//        {
//            //变动用药按次取整
//            kgutpDoseDrugTotal(srvDO, use_day,emsOrDoseDrug);
//        }
//        else
//        {
//            //按批取整
//            opmutpDoseDrugTotal(srvDO, use_day,emsOrDoseDrug);
//
//        }
		return FDouble.ZERO_DBL;
	}
	/**
	 * 住院医嘱变动用药计算方法
	 * @param srvDO
	 * @param use_day
	 * @param emsOrDoseDrug
	 * @throws BizException 
	 */
	private void kgutpDoseDrugTotal( CiEmsSrvDTO srvDO, int use_day, List<FDouble[]> emsOrDoseDrug ) throws BizException
    {
        if ( use_day == 0) 
        	return;
        double quanCount = 0;
        // 计算总量单位的换算系数
        FDouble factor = new GetDrugSaleFactor().exec(srvDO.getId_mm(),srvDO.getId_unit_sale());
		if (factor == FDouble.ZERO_DBL){
			throw new BizException("总量单位的换算系数为0");
		}
        switch (srvDO.getSd_frequnitct())
        {
            case IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY:// "天"
                
                for (FDouble[] emsdrug : emsOrDoseDrug)
                {
                	// quan_med / factor_mb
                    quanCount += Math.ceil((double)(Math.ceil((emsdrug[0].doubleValue() / emsdrug[1].doubleValue())) / factor.doubleValue())) * use_day;
                }
                srvDO.setQuan_cur( new FDouble(quanCount));
                break;
            case IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK: //"星期"
            	
                for (FDouble[] emsdrug : emsOrDoseDrug)
                {
                    quanCount += Math.ceil((double)(Math.ceil((emsdrug[0].doubleValue() / emsdrug[1].doubleValue())) / factor.doubleValue())) * use_day / 7;
                }
                srvDO.setQuan_cur( new FDouble(quanCount));
                break;
            default:
               
                break;
        }
    }
	
	/**
	 * 门诊医嘱，变动用药计算方法
	 * @param srvDO
	 * @param use_day
	 * @param emsOrDoseDrug
	 * @throws BizException 
	 */
	private void opmutpDoseDrugTotal(CiEmsSrvDTO srvDO, int use_day, List<FDouble[]> emsOrDoseDrug) throws BizException
    {
		if ( use_day == 0) 
        	return;
		double quanCount = 0;
		FDouble factor = new GetDrugSaleFactor().exec(srvDO.getId_mm(),srvDO.getId_unit_sale());
		if (factor == FDouble.ZERO_DBL){
			throw new BizException("总量单位的换算系数为0");
		}
        switch (srvDO.getSd_frequnitct())
        {
            case IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY:// "天"
                
            	for (FDouble[] emsdrug : emsOrDoseDrug)
                {
            		quanCount += (emsdrug[0].doubleValue() / emsdrug[1].doubleValue()) * use_day ;
                }
            	srvDO.setQuan_cur( new FDouble( Math.ceil((double)quanCount / factor.doubleValue())));
                break;
            case IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK: //"星期"
            	
            	for (FDouble[] emsdrug : emsOrDoseDrug)
                {
            		quanCount += (emsdrug[0].doubleValue() / emsdrug[1].doubleValue()) * use_day / 7;
                }
            	srvDO.setQuan_cur( new FDouble( Math.ceil((double)quanCount / factor.doubleValue())));
                break;
            default:
                //this.ShowInfo("只有按天或按周执行的频次可设置变动用药！");
                break;
        }
    }
	
	
}
