package iih.ci.ord.s.bp.srvpri;

import java.util.Map;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.ci.ord.pub.CiOrSrvPriHelper;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.SrvPluginPrimdUnImplementException;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 临床医嘱选择服务，服务价格计算操作BP
 */
public class CiOrBdSrvPriceCalBP {
	/**
	 * 临床医嘱选择服务，服务价格计算
	 * @param id_srv  医疗服务id
	 * @param id_primd 付款策略
	 * @param num      套时，的个数定价 或个数加收的个数数量
	 * @param srvsetitms      套合计价时，套内项目信息 BdSrvPriCalParamDTO
	 * @return
	 * @throws BizException
	 */
	public FDouble exec(BdSrvPriCalParamDTO param)  throws BizException{
		//有效性判断处理
		if(!validateCheck(param))return null;
		if(CiOrdUtils.isEmpty(param.getId_primd()))
		{
			param.setId_primd(CiOrdAppUtils.getMedsrvMDORService().findById(param.getId_srv()).getId_primd());
		}
		String id_primd=param.getId_primd(),id_srv=param.getId_srv();
		Integer num=param.getNum();
		
		IPriCalService ipricalsrv=CiOrdAppUtils.getPriCalService();
		CiOrSrvSetNotClinicalItemsBP itemsBp = new CiOrSrvSetNotClinicalItemsBP();
		if(CiOrSrvPriHelper.isSrvSelfPrimd(id_primd)){//本服务定价
			return ipricalsrv.CalSingleSrvStdPrice(id_srv);
		}else if(CiOrSrvPriHelper.isSrvsetMemberSumPrimd(id_primd)){//合计价
			//传入的主要参数应为 srvsetitms
			if(CiOrdUtils.isEmpty(param.getSrvsetitms())){
				//前台只传入id_srv,需要计算出所有临床和非临床的价格
				itemsBp.exec(param);
				return getSrvSetSumPri(param);
			}else{
				//前台传入了临床项目，还要计算非临床的服务项目
				FDouble price = getSrvSetSumPri(param);
				price = price==null?new FDouble(0):price;
				itemsBp.notClinicalItems(param);
				FDouble notClinicalPrice = getSrvSetSumPri(param);
				notClinicalPrice = notClinicalPrice==null?new FDouble(0):notClinicalPrice;
				return price.add(notClinicalPrice);
			}
		}else if(CiOrSrvPriHelper.isSrvsetMemCntAdditionalPrimd(id_primd)){//个数加收
			FDouble sumPrice = getPriceSum(ipricalsrv.CalSrvSetMUPrices(id_srv, num));
			if(sumPrice == null){
				throw new BizException("个数加收计算总价失败，请检查费用对照配置是否正确！");
			}
			//FDouble price = new FDouble(num).multiply(getPriceSum(ipricalsrv.CalSrvSetMUPrices(id_srv, num)));//2016-09-12 修改 num*单价为总价
			FDouble price = new FDouble(num).multiply(sumPrice);
			//price = price==null?new FDouble(0):price;
			itemsBp.notClinicalItems(param);
			FDouble notClinicalPrice = getSrvSetSumPri(param);
			notClinicalPrice = notClinicalPrice==null?new FDouble(0):notClinicalPrice;
			return price.add(notClinicalPrice);
		}else if(CiOrSrvPriHelper.isSrvsetMemberCntPrimd(id_primd)){//个数定价
			int i = 0;
			FDouble price = getPriceSum(ipricalsrv.CalSrvSetFIXPrices(id_srv, num));
			price = price==null?new FDouble(0):price;
			FDouble notClinicalPrice = getSrvSetSumPri(param);
			notClinicalPrice = notClinicalPrice==null?new FDouble(0):notClinicalPrice;
			return price.add(notClinicalPrice);
		}else if(CiOrSrvPriHelper.isSrvRelMmPrimd(id_primd)){//对应物品价格
			//return getPriceSum(ipricalsrv.CalSrvSetFIXPrices(id_srv, num));
			//调用对应药品价格计算接口
		}else if(CiOrSrvPriHelper.isSrvCompPrimd(id_primd)){//组合定价
			return getPriceSum(ipricalsrv.CalSrvCompPrice(id_srv));
		}else if(CiOrSrvPriHelper.isSrvFreePrimd(id_primd)){//不收费
			return new FDouble(0);
		}else if(CiOrSrvPriHelper.isSrvPluginPrimd(id_primd)){//外挂插件
			throw new SrvPluginPrimdUnImplementException();
		}
		
		return null;
		
	}
	
	/**
	 * 折扣价计算方法
	 * @param param
	 * @param id_pripat
	 * @return
	 * @throws BizException
	 */
	public MedSrvPriceDO exec(BdSrvPriCalParamDTO param,String id_pripat)  throws BizException{
		//有效性判断处理
		if(!validateCheck(param))return null;
		if(CiOrdUtils.isEmpty(param.getId_primd()))
		{
			param.setId_primd(CiOrdAppUtils.getMedsrvMDORService().findById(param.getId_srv()).getId_primd());
		}
		String id_primd=param.getId_primd(),id_srv=param.getId_srv();
		Integer num=param.getNum();
		
		IPriCalService ipricalsrv=CiOrdAppUtils.getPriCalService();
		CiOrSrvSetNotClinicalItemsBP itemsBp = new CiOrSrvSetNotClinicalItemsBP();
		
		MedSrvPriceDO medSrvPriceDO = new MedSrvPriceDO();
		medSrvPriceDO.setId_pripat(id_pripat);
		medSrvPriceDO.setPrice_ratio(FDouble.ZERO_DBL);
		medSrvPriceDO.setPrice_std(FDouble.ZERO_DBL);
		medSrvPriceDO.setDes_pri("");
		
		if(CiOrSrvPriHelper.isSrvSelfPrimd(id_primd)){//本服务定价
			SrvPricalRateAndPriceDTO o =ipricalsrv.CalSingleSrvPriceByIdPripat_NameTip(id_srv,param.getName_srv(),id_pripat);
			
			medSrvPriceDO.setPrice_ratio(o.getPrice_ratio());
			medSrvPriceDO.setPrice_std(o.getPrice());
			medSrvPriceDO.setDes_pri("");
			medSrvPriceDO.setRatio(o.getRate());
			return medSrvPriceDO;
		}
		
		else if(CiOrSrvPriHelper.isSrvsetMemberSumPrimd(id_primd)){//合计价
			//传入的主要参数应为 srvsetitms
			if(CiOrdUtils.isEmpty(param.getSrvsetitms())){
				//前台只传入id_srv,需要计算出所有临床和非临床的价格
				itemsBp.exec(param);
				FDouble szPrice[] = getSrvSetSumPri(param,id_pripat);
				
				medSrvPriceDO.setId_srv(param.getId_srv());
				if(!CiOrdUtils.isEmpty(szPrice)){
					medSrvPriceDO.setPrice_ratio(szPrice[0]);
					medSrvPriceDO.setPrice_std(szPrice[1]);
				}
				return medSrvPriceDO;
			}else{
				
				//前台传入了临床项目，还要计算非临床的服务项目
				FDouble[] szPrice = getSrvSetSumPri(param,id_pripat);
				
				itemsBp.notClinicalItems(param);
				//FDouble notClinicalPrice = getSrvSetSumPri(param);
				FDouble szNotClinicalPrice[] = getSrvSetSumPri(param,id_pripat);
				if(!CiOrdUtils.isEmpty(szNotClinicalPrice)){
					szPrice[0] = szPrice[0].add(szNotClinicalPrice[0]);
					szPrice[1] = szPrice[1].add(szNotClinicalPrice[1]);
				}
				medSrvPriceDO.setId_srv(param.getId_srv());
				medSrvPriceDO.setPrice_ratio(szPrice[0]);
				medSrvPriceDO.setPrice_std(szPrice[1]);
				return medSrvPriceDO;
			}
		}else if(CiOrSrvPriHelper.isSrvsetMemCntAdditionalPrimd(id_primd)){//个数加收
			Map<String,Map<String,SrvPricalRateAndPriceDTO>> rstMap = ipricalsrv.CalSrvSetMUPricesByIdPripat_map(id_srv, num, id_pripat);
			if (null == rstMap || rstMap.values().size() == 0){
				throw new BizException("个数加收计算总价失败，请检查费用对照配置是否正确！");
			}
			Map<String,SrvPricalRateAndPriceDTO> srvPricalRateAndPriceMap =  rstMap.get(id_srv);
			if (null == srvPricalRateAndPriceMap){
				throw new BizException("个数加收计算总价失败，请检查费用对照配置是否正确！");
			}
			FDouble[] sumPrice = getPriceSum(srvPricalRateAndPriceMap.values().toArray(new SrvPricalRateAndPriceDTO[srvPricalRateAndPriceMap.values().size()]));
			if(sumPrice == null){
				throw new BizException("个数加收计算总价失败，请检查费用对照配置是否正确！");
			}

			itemsBp.notClinicalItems(param);
			FDouble[] szNotClinicalPrice = getSrvSetSumPri(param,id_pripat);
			if (!CiOrdUtils.isEmpty(szNotClinicalPrice) && szNotClinicalPrice.length == 2){
				FDouble price_ratio = new FDouble(num).multiply(sumPrice[0]);// 折扣价
				FDouble price_std = new FDouble(num).multiply(sumPrice[1]);// 标准价
				medSrvPriceDO.setPrice_ratio(price_ratio.add(szNotClinicalPrice[0]));
				medSrvPriceDO.setPrice_std(price_std.add(szNotClinicalPrice[1]));
			}
			medSrvPriceDO.setId_srv(param.getId_srv());
			
			return medSrvPriceDO;
		}else if(CiOrSrvPriHelper.isSrvsetMemberCntPrimd(id_primd)){//个数定价
			Map<String,Map<String,SrvPricalRateAndPriceDTO>> rstMap = ipricalsrv.CalSrvSetFIXPricesByIdPripat_map(id_srv, num,id_pripat);
			if (null == rstMap || rstMap.values().size() == 0){
				throw new BizException("个数定价计算总价失败，请检查费用对照配置是否正确！");
			}
			int i = 0;
			Map<String,SrvPricalRateAndPriceDTO> srvPricalRateAndPriceMap =  rstMap.get(id_srv);
			if (null == srvPricalRateAndPriceMap){
				throw new BizException("个数定价计算总价失败，请检查费用对照配置是否正确！");
			}
			FDouble[] sumPrice = getPriceSum(srvPricalRateAndPriceMap.values().toArray(new SrvPricalRateAndPriceDTO[srvPricalRateAndPriceMap.values().size()]));
			sumPrice = sumPrice==null?new FDouble[]{new FDouble(0),new FDouble(0)}:sumPrice;
		
			FDouble[] szNotClinicalPrice = getSrvSetSumPri(param,id_pripat);
			szNotClinicalPrice = szNotClinicalPrice==null?new FDouble[]{new FDouble(0),new FDouble(0)}:szNotClinicalPrice;
			if (szNotClinicalPrice.length == 2){
				medSrvPriceDO.setPrice_ratio(sumPrice[0].add(szNotClinicalPrice[0]));
				medSrvPriceDO.setPrice_std(sumPrice[1].add(szNotClinicalPrice[1]));
			}
			medSrvPriceDO.setId_srv(param.getId_srv());
			
			return medSrvPriceDO;
		}else if(CiOrSrvPriHelper.isSrvRelMmPrimd(id_primd)){//对应物品价格
			//return getPriceSum(ipricalsrv.CalSrvSetFIXPrices(id_srv, num));
			//调用对应药品价格计算接口
		}else if(CiOrSrvPriHelper.isSrvCompPrimd(id_primd)){//组合定价
			Map<String,SrvPricalRateAndPriceDTO> srvPricalRateAndPriceMap = ipricalsrv.CalSrvCompPriceByIdPripat_map(id_srv,id_pripat);
			if (null == srvPricalRateAndPriceMap){
				throw new BizException("组合定价计算总价失败，请检查费用对照配置是否正确！");
			}
			SrvPricalRateAndPriceDTO[] szSrvPricalRateAndPriceInfo = srvPricalRateAndPriceMap.values().toArray(new SrvPricalRateAndPriceDTO[srvPricalRateAndPriceMap.values().size()]);
			FDouble[] sumPrice = getPriceSum(szSrvPricalRateAndPriceInfo);
			if(!CiOrdUtils.isEmpty(sumPrice)){
				medSrvPriceDO.setPrice_ratio(sumPrice[0]);
				medSrvPriceDO.setPrice_std(sumPrice[1]);
			}
			medSrvPriceDO.setId_srv(id_srv);
			medSrvPriceDO.setRatio(szSrvPricalRateAndPriceInfo[0].getRate());
			return medSrvPriceDO;
		}else if(CiOrSrvPriHelper.isSrvFreePrimd(id_primd)){//不收费
			medSrvPriceDO.setPrice_ratio(FDouble.ZERO_DBL);
			medSrvPriceDO.setPrice_std(FDouble.ZERO_DBL);
			medSrvPriceDO.setId_srv(id_srv);
			medSrvPriceDO.setRatio(FDouble.ONE_DBL);
			return medSrvPriceDO;
		}else if(CiOrSrvPriHelper.isSrvPluginPrimd(id_primd)){//外挂插件
			throw new SrvPluginPrimdUnImplementException();
		}
		
		return medSrvPriceDO;
		
	}
	
	/**
	 * 有效性校验
	 * @param id_srv
	 * @param id_primd
	 * @return
	 */
	private boolean validateCheck(BdSrvPriCalParamDTO param){
		if(CiOrdUtils.isEmpty(param))return false;
		if(CiOrdUtils.isEmpty(param.getId_srv()) || 
		   CiOrdUtils.isEmpty(param.getId_primd()))return false;
		return true;
	}
	
	/**
	 * 获得总价
	 * @param pridtos
	 * @return  Map<String,Map<String,SrvPricalRateAndPriceDTO>>
	 */
	private FDouble getPriceSum(PriStdSrvDTO[] pridtos){
		return CiOrSrvPriHelper.getPriceSum(pridtos);
	}
	private FDouble[] getPriceSum(SrvPricalRateAndPriceDTO[] pridtos){
		return CiOrSrvPriHelper.getPriceSum(pridtos);
	}
	
	
	/**
	 * 获得套合计价模式总价
	 * @param param
	 * @return
	 * @throws BizException
	 */
	
	private FDouble getSrvSetSumPri(BdSrvPriCalParamDTO param) throws BizException{
		CiOrSrvSetSumPriMdCalBP bp=new CiOrSrvSetSumPriMdCalBP();
		return bp.exec(param);
	}
	/**
	 * 
	 * @param param
	 * @param id_pripat
	 * @return
	 * @throws BizException
	 */
	private FDouble[] getSrvSetSumPri(BdSrvPriCalParamDTO param,String id_pripat) throws BizException{
		CiOrSrvSetSumPriMdCalBP bp=new CiOrSrvSetSumPriMdCalBP();
		return bp.exec(param,id_pripat);
	}
	
	public void getSetClinicalSrvItems(BdSrvPriCalParamDTO param){
		
	}

}
