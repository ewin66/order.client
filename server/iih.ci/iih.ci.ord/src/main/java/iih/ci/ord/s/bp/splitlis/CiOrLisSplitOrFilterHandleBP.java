package iih.ci.ord.s.bp.splitlis;

import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床医嘱分方时，分方医嘱过滤与处理操作BP
 */
public class CiOrLisSplitOrFilterHandleBP {
	/**
	 * 临床医嘱分方时，分方医嘱过滤与处理
	 * @param ciorder
	 * @param session
	 * @return
	 * @throws BizException
	 */
	public CiOrderDO[] exec(CiOrderDO[] ciorder )throws BizException{
		String code_entp=ciorder[0].getCode_entp();
		if(CiOrdUtils.isEmpty(ciorder) || !CiOrdUtils.isOpUrgentWf(ciorder[0].getCode_entp()))
		{
			
				if(CiOrdUtils.isEmpty(ciorder))return null;
			}else{
				return null;
			}
		
		
		//返回
		return ciorder;
	}
	
	/**
	 * 住院医嘱时,获得需分方医嘱集合
	 * @param ciors
	 * @return
	 */
    private CiOrderDO[] getIpHerbFgpresoutpOr(CiOrderDO[] ciors){
   	 List<CiOrderDO> list=new ArrayList<CiOrderDO>();
   	 for (CiOrderDO ciOrderDO : ciors) {
			if(ciOrderDO.getFg_pres_outp()==FBoolean.TRUE || ciOrderDO.getSd_srvtp().startsWith("0103")){			
				list.add(ciOrderDO);
			}
		}
   	 if(list.size()>0)
   		 return list.toArray(new CiOrderDO[0]);
   	 return null;
    }
}
