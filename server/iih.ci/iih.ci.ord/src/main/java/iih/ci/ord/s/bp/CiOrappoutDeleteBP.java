package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 出院申请删除操作BP
 */
public class CiOrappoutDeleteBP {
	/**
	 * 出院申请删除
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public OrdApOutDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		CiOrappoutGetBP bp=new CiOrappoutGetBP();
		OrdApOutDO[] dos=bp.exec(id_or);
		CiOrdAppUtils.getOrappoutService().delete(dos);;

		return dos;
	}
}
