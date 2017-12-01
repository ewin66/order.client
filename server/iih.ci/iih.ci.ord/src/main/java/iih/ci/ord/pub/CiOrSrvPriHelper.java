package iih.ci.ord.pub;

import xap.mw.coreitf.d.FDouble;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;

/**
 * 医疗服务计价模式助手类
 */
public class CiOrSrvPriHelper {
	/**
	 * 本服务定价模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvSelfPrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_SRV.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)){return true;}
		return false;
	}
	/**
	 * 套成员合计计价模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvsetMemberSumPrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_SRVSET_AMOUNT.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_SRVSET_AMOUNT.equals(id_primd)){return true;}
		return false;
	}
	/**
	 * 套成员个数加收计价模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvsetMemCntAdditionalPrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_SRVSET_MU.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_SRVSET_MU.equals(id_primd)){return true;}
		return false;
	}
	/**
	 * 套成员个数定价计价模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvsetMemberCntPrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_SRVSET_FIX.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_SRVSET_FIX.equals(id_primd)){return true;}
		return false;
	}
	/**
	 * 对应物品计价模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvRelMmPrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_RES.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_RES.equals(id_primd)){return true;}
		return false;
	}	
	/**
	 * 服务组合定价模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvCompPrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_SRV_COMP.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(id_primd)){return true;}
		return false;
	}
	/**
	 * 服务不付费模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvFreePrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_FREE.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_FREE.equals(id_primd)){return true;}
		return false;
	}
	/**
	 * 服务外挂插件计价模式
	 * @param id_primd
	 * @return
	 */
	public static boolean isSrvPluginPrimd(String id_primd){
		if(IBdPrimdCodeConst.CODE_PRI_PLUGIN.equals(id_primd) || 
		   IBdPrimdCodeConst.ID_PRI_PLUGIN.equals(id_primd)){return true;}
		return false;
	}
	
	/**
	 * 获得本服务定价对应的合计价
	 * @param pridtos
	 * @return
	 */
	public static FDouble getPriceSum(PriStdSrvDTO[] pridtos){
		if(CiOrdUtils.isEmpty(pridtos))return null;
		FDouble rtn = FDouble.ZERO_DBL;
		for(int i=0;i<pridtos.length;i++){
			if(CiOrdUtils.isEmpty(pridtos[i].getPrice()))continue;
			rtn=rtn.add(getPriStdSrvAmount(pridtos[i]));
		}
		
		return rtn;
	}
	
	/**
	 * 获得标准价对应的总金额
	 * @param pristdsrvdto
	 * @return
	 */
	public static FDouble getPriStdSrvAmount(PriStdSrvDTO pristdsrvdto){
		if(CiOrdUtils.isEmpty(pristdsrvdto))return new FDouble(0);
		FDouble quan=null,price=null;
		if(CiOrdUtils.isEmpty(pristdsrvdto.getQuan()))
		{quan=new FDouble(1);}else{quan=pristdsrvdto.getQuan();}
		if(CiOrdUtils.isEmpty(pristdsrvdto.getPrice()))
		{price=new FDouble(0);}else{price=pristdsrvdto.getPrice();}
		return 	quan.multiply(price);
	}
	
	public static FDouble[] getPriceSum(SrvPricalRateAndPriceDTO[] pridtos){
		if(CiOrdUtils.isEmpty(pridtos))return null;
		FDouble[] szRtn = new FDouble[]{FDouble.ZERO_DBL,FDouble.ZERO_DBL};
		for(int i=0;i<pridtos.length;i++){
			if(CiOrdUtils.isEmpty(pridtos[i].getPrice()))continue;
			FDouble[] tp = getPriStdSrvAmount(pridtos[i]);
			szRtn[0] = szRtn[0].add(tp[0]);
			szRtn[1] = szRtn[1].add(tp[1]);
		}
		
		return szRtn;
	}
	public static FDouble[] getPriStdSrvAmount(SrvPricalRateAndPriceDTO pristdsrvdto){
		if(CiOrdUtils.isEmpty(pristdsrvdto))return new FDouble[]{FDouble.ZERO_DBL,FDouble.ZERO_DBL};
		FDouble quan=null;
		FDouble[] szPrice = new FDouble[]{FDouble.ZERO_DBL,FDouble.ZERO_DBL};
		if(CiOrdUtils.isEmpty(pristdsrvdto.getQuan()))
		{quan=new FDouble(1);}else{quan=pristdsrvdto.getQuan();}
		if(CiOrdUtils.isEmpty(pristdsrvdto.getPrice()))
		{szPrice[1]=new FDouble(0);}else{szPrice[1]=pristdsrvdto.getPrice();}
		if(CiOrdUtils.isEmpty(pristdsrvdto.getPrice_ratio()))
		{szPrice[0]=new FDouble(0);}else{szPrice[0]=pristdsrvdto.getPrice_ratio();}
		szPrice[0] = szPrice[0].multiply(quan);
		szPrice[1] = szPrice[1].multiply(quan);
		return 	szPrice;
	}
	
	/**
	 * 获得标准价中的数量
	 * @param pristdsrvdto
	 * @return
	 */
	public static FDouble getPriStdSrvQuan(PriStdSrvDTO pristdsrvdto){
		if(CiOrdUtils.isEmpty(pristdsrvdto))return new FDouble(0);
		if(CiOrdUtils.isEmpty(pristdsrvdto.getQuan()))
		{
			return new FDouble(1);
		}else{
			return pristdsrvdto.getQuan();
		}
	}
	
}
