package iih.ci.ord.s.bp.srvpri;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 临床医嘱服务价格计算操作BP
 */
public class CiOrBdSrvPricesCalBP {
	/**
	 * 临床医嘱服务价格计算
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public FDouble[] exec(BdSrvPriCalParamDTO[] params)  throws BizException{
		//有效性判断处理
		if(!validateCheck(params))return null;
		
		//参数设置
		int iN=params.length;
		FDouble[] rtns=new FDouble[iN];
		
		//遍历
		for(int i=0;i<iN;i++){
			rtns[i]=getCiOrSrvPrice(params[i]);
		}
		
		return rtns;
	}
	
	/**
	 * 有效性校验
	 * @param id_srv
	 * @param id_primd
	 * @return
	 */
	private boolean validateCheck(BdSrvPriCalParamDTO[] params){
		if(CiOrdUtils.isEmpty(params))return false;

		return true;
	}
	
	/**
	 * 获得医嘱项目参考价格
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private FDouble getCiOrSrvPrice(BdSrvPriCalParamDTO param) throws BizException{
		CiOrBdSrvPriceCalBP bp=new CiOrBdSrvPriceCalBP();
		return bp.exec(param);
	}
}
