package iih.ci.ord.s.ems.biz.utils;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class OrderEmsPriceUtils {
	/**
	   * 医嘱服务计算价格（非物品计价）
	   * @param medsrv
	   * @return
	   * @throws BizException
	   */
	    public static FDouble calculatePrice(MedSrvDO medsrv,String id_pripat) throws BizException
	    {
	        BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();
	   
	        priParam.setId_srv( medsrv.getId_srv() );
	        priParam.setId_primd ( medsrv.getId_primd());
	        priParam.setNum(  0 );
	        // 远程调用
	        MedSrvPriceDO price = ServiceFinder.find(ICiOrdQryService.class).ciOrBdSrvPriceCalByPriMode(priParam, id_pripat);
	        
	        return price != null?price.getPrice_ratio():FDouble.ZERO_DBL;
	    }
	    /**
	     * 本服务计算价格
	     * @param id_srv
	     * @param id_primd
	     * @param id_pripat
	     * @return
	     * @throws BizException
	     */
	    public static MedSrvPriceDO calculatePrice(String id_srv,String id_primd,String id_pripat) throws BizException
	    {
	        BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();
	   
	        priParam.setId_srv( id_srv);
	        priParam.setId_primd ( id_primd);
	        priParam.setNum(  0 );
	        // 远程调用
	        return ServiceFinder.find(ICiOrdQryService.class).ciOrBdSrvPriceCalByPriMode(priParam, id_pripat);
	        
	      
	    }
	    /**
		 * 医嘱服务计算价格（非物品计价）
		 * @param medsrv
		 * @param emsOrObsList
		 * @return
		 * @throws BizException
		 */
	    public static MedSrvPriceDO CalculatePrice(MedSrvDO medsrv,String id_pripat, FArrayList emsOrObsList) throws BizException {
			BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();
			int iNumber = 0;

			priParam.setId_srv(medsrv.getId_srv());
			priParam.setId_primd(medsrv.getId_primd());
			priParam.setNum(iNumber);
			if (emsOrObsList != null) {
				FArrayList setItemSrvList = new FArrayList();
				for (Object obLap : emsOrObsList) {
					EmsObsLap lap = (EmsObsLap) obLap;
					if (CiOrdUtils.isTrue(lap.getFg_chk())) {
						iNumber++;
						BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
						param.setId_srv(lap.getId_srv());
						param.setId_primd(lap.getId_primd());
						param.setNum(1);
						setItemSrvList.add(param);
					}
				}
				priParam.setNum(iNumber);
				priParam.setSrvsetitms(setItemSrvList);
			}
			// 单选模式下，服务套的临床项目没有被选中默认项目时候，不计算价格
			if (priParam.getSrvsetitms().size() == 0 &&  CiOrdUtils.isTrue(medsrv.getFg_set())){
				MedSrvPriceDO mspd = new MedSrvPriceDO();
				mspd.setRatio(FDouble.ONE_DBL);
				mspd.setPrice_ratio(FDouble.ZERO_DBL);
				mspd.setPrice_std(FDouble.ZERO_DBL);
				mspd.setId_pripat(id_pripat);
				return mspd;
			}

			MedSrvPriceDO price = ServiceFinder.find(ICiOrdQryService.class).ciOrBdSrvPriceCalByPriMode(priParam, id_pripat);//.ciOrBdSrvPriceCal(priParam);
			
			return price;
		}
	    
	    /**
	     * 计算价格的代理模式
	     * @author wangqingzhu
	     *
	     */
	    public static interface IBdSrvPriCalParamFrom{
	    	public FArrayList getBdSrvPriCalParamList(FArrayList emsOrObsList);
	    }
	    
	    /**
	     * 计算价格
	     * @param medsrv
	     * @param id_pripat
	     * @param emsOrObsList
	     * @param iDelegate
	     * @return
	     * @throws BizException
	     */
	    public static MedSrvPriceDO CalculatePrice(MedSrvDO medsrv,String id_pripat, FArrayList emsOrObsList,IBdSrvPriCalParamFrom iDelegate) throws BizException {
			BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();
			
			priParam.setId_srv(medsrv.getId_srv());
			priParam.setId_primd(medsrv.getId_primd());
			priParam.setNum(0);
			if (!CiOrdUtils.isEmpty(emsOrObsList)) {
				FArrayList setItemSrvList = iDelegate.getBdSrvPriCalParamList(emsOrObsList);
				priParam.setNum(setItemSrvList.size());
				priParam.setSrvsetitms(setItemSrvList);
			}
			// 单选模式下，服务套的临床项目没有被选中默认项目时候，不计算价格
			if (priParam.getSrvsetitms().size() == 0 &&  CiOrdUtils.isTrue(medsrv.getFg_set())){
				MedSrvPriceDO mspd = new MedSrvPriceDO();
				mspd.setRatio(FDouble.ONE_DBL);
				mspd.setPrice_ratio(FDouble.ZERO_DBL);
				mspd.setPrice_std(FDouble.ZERO_DBL);
				mspd.setId_pripat(id_pripat);
				return mspd;
			}
			
			return ServiceFinder.find(ICiOrdQryService.class).ciOrBdSrvPriceCalByPriMode(priParam, id_pripat);
		}
	    
	    /**
	     * 获取物品价格
	     * @param id_mm
	     * @param id_unit_sale
	     * @return
	     * @throws BizException
	     */
	    public static FDouble getMaterialPrice(String id_mm, String id_unit_sale) throws BizException
	    {
	        GetStockReqDTO reqDto = new GetStockReqDTO();
	        reqDto.setId_mm ( id_mm);
	        reqDto.setReq_unit_id ( id_unit_sale);
	        GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
	        reqDtoArr[0] = reqDto;
	        IMaterialStockService service = ServiceFinder.find(IMaterialStockService.class);
	        MaterialStockDTO[] materials =  service.getMaterialStocks(reqDtoArr);
	        if (materials != null && materials.length > 0)
	        {
	            return materials[0].getPrice_act();
	        }
	        else {
	            return FDouble.ZERO_DBL;
	        }
	     }
	
}
