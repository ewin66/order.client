package iih.ci.ord.s.bp.ems;

import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/*
 * 计算服务（非套）的单价操作BP
 */
public class CiOrCalSrvPriceBP {
	/**
	 * 计算服务（非套）的单价操作
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public  FDouble exec(String id_srv,String id_primd)  throws BizException{
		if(IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)){//本服务定价
			return CiOrdAppUtils.getPriCalService().CalSingleSrvStdPrice(id_srv);
		}else if(IBdPrimdCodeConst.ID_PRI_RES.equals(id_primd)){//对应物品定价
			
		}
		//CalSingleSrvStdPrice
		return null;
	}
}
