package iih.ci.ord.s.bp.orsrvsplit;

import iih.ci.ord.dto.blexorder.d.OrGenSplitTpEnum;
import xap.mw.core.data.BizException;

/***
 * 
 * 获得医嘱拆分基础sql串操作BP
 */
public class GetOrSrvSplitBaseSqlBP {
	/***
	 * 获得医嘱拆分基础sql串
	 * @param orgensplittp
	 * @return
	 * @throws BizException
	 */
	public  String exec(Integer orgensplittp)  throws BizException{
		if(orgensplittp.equals(OrGenSplitTpEnum.SPLITBYOR)){return getOrSplitBaseStr();}
		else if(orgensplittp.equals(OrGenSplitTpEnum.SPLITBYFEESRV)){return getOrSrvMmSplitBaseStr();}
		else if(orgensplittp.equals(OrGenSplitTpEnum.SPLITBYSRVMM)){return getOrSrvMmSplitBaseStr();}
		return null;
	}
	
	/**
	 * 获得医嘱拆分基础拆分sql串
	 * @return
	 */
	private String getOrSplitBaseStr(){
		return IOrAndSrvSplitConst.ORSRVSPLIT_OR_BASE_SSQL
				+OrSrvSplitUtil.getPubOrSrvSqlStr(true)
				+IOrAndSrvSplitConst.ORSRVSPLIT_ORSPLIT_BASE_FSQL;
	}
	
	/**
	 * 获得医嘱服务物品拆分基础拆分sql串
	 * @return
	 */
	private String getOrSrvMmSplitBaseStr(){
		return IOrAndSrvSplitConst.ORSRVSPLIT_OR_BASE_SSQL
				+IOrAndSrvSplitConst.ORSRVSPLIT_SRV_BASE_SSQL
				+IOrAndSrvSplitConst.ORSRVSPLIT_MM_BASE_SSQL
				+OrSrvSplitUtil.getPubOrSrvSqlStr(true)
				+IOrAndSrvSplitConst.ORSRVSPLIT_PUB_OTH_SSQL
				+IOrAndSrvSplitConst.ORSRVMMSPLIT_SRVSPLIT_BASE_FSQL;
	}

	/**
	 * 获得医嘱服务拆分基础拆分sql串
	 * @return
	 */
	private String getOrSrvSplitBaseStr(){
		return IOrAndSrvSplitConst.ORSRVSPLIT_OR_BASE_SSQL
				+IOrAndSrvSplitConst.ORSRVSPLIT_SRV_BASE_SSQL
				+OrSrvSplitUtil.getPubOrSrvSqlStr(true)
				+IOrAndSrvSplitConst.ORSRVSPLIT_PUB_OTH_SSQL
				+IOrAndSrvSplitConst.ORSRVSPLIT_SRVSPLIT_BASE_FSQL;
	}


}
