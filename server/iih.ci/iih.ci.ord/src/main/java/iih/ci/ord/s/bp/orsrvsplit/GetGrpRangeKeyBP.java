package iih.ci.ord.s.bp.orsrvsplit;

import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;


import xap.mw.core.data.BizException;

/***
 * 根据分组归类模式获得分组归类key值操作BP 
 */
public class GetGrpRangeKeyBP {
	/***
	 * 根据分组归类模式获得分组归类key值操作
	 * @param splitorder
	 * @param grouprangemode
	 * @return
	 * @throws BizException
	 */
	public String  exec(SrvSplitOrderDTO splitorder,String grouprangemode)  throws BizException{
		//有效性校验
		if(splitorder==null)return null;
		
		//按归类模式返回
		String itmkey=splitorder.getId_srv();
		if(IOrAndSrvSplitConst.SPLITRS_GRPRANGEMODE_WD.equals(grouprangemode)){
			return splitorder.getId_dep_mp()+itmkey;
		}else if(IOrAndSrvSplitConst.SPLITRS_GRPRANGEMODE_PI.equals(grouprangemode)){
			return splitorder.getId_pat()+itmkey;
		}else if(IOrAndSrvSplitConst.SPLITRS_GRPRANGEMODE_PV.equals(grouprangemode)){
			return splitorder.getId_en()+itmkey;
		}else if(IOrAndSrvSplitConst.SPLITRS_GRPRANGEMODE_OR.equals(grouprangemode)){
			return splitorder.getId_or()+itmkey;
		}else if(IOrAndSrvSplitConst.SPLITRS_GRPRANGEMODE_ORSRV.equals(grouprangemode)){
			return splitorder.getId_orsrv();
		}
		
		return null;
	}
}
