package iih.ci.ord.s.bp;

import iih.bd.srv.oth.d.BizCntDTO;
import iih.ci.ord.s.bp.qry.GetEntUseStatisticCntQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获得实体使用个数数量统计信息数据操作BP
 */
public class GetEntUseStatisticCntBP {
	/**
	 * 获得实体使用个数数量统计信息数据
	 * @param ids
	 * @param tbl
	 * @param keyfld
	 * @param condfld
	 * @return
	 * @throws BizException
	 */
	public BizCntDTO[] exec(String ids,String tbl,String keyfld,String condfld)throws BizException{
		GetEntUseStatisticCntQry qry = new GetEntUseStatisticCntQry(ids,tbl,keyfld,condfld);
		BizCntDTO[] rtn = (BizCntDTO[])AppFwUtil.getDORstWithDao(qry,BizCntDTO.class);
		return rtn;
	}
}
