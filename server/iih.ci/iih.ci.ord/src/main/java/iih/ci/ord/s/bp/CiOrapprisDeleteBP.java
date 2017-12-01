package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 检查申请删除操作BP
 */
public class CiOrapprisDeleteBP {
	/**
	 * 检查申请删除
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public OrdApObsDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		CiOrapprisGetBP bp=new CiOrapprisGetBP();
		OrdApObsDO[] dos=bp.exec(id_or);
		CiOrdAppUtils.getOrapprisService().logicDelete(dos);;

		return dos;
	}
}
