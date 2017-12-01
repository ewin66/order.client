package iih.ci.ord.s.bp;

import iih.ci.ord.s.bp.qry.GetEntDiDOListQry;
import iih.en.pv.entdi.d.EntDiDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class getEntDiDOListBP {

	/**
	 * 当前诊断
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public EntDiDO[] exec(String id_ent)throws BizException{
		GetEntDiDOListQry qry = new GetEntDiDOListQry(id_ent);
		EntDiDO[] rtn = (EntDiDO[])AppFwUtil.getDORstWithDao(qry,EntDiDO.class);
		return rtn;
	}
}
