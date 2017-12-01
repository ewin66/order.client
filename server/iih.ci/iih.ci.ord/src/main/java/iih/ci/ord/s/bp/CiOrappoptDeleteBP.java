package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 手术申请删除操作BP
 */
public class CiOrappoptDeleteBP {
	/**
	 * 手术申请删除
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public CiorappsurgeryAggDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		CiOrappoptGetBP bp=new CiOrappoptGetBP();
		CiorappsurgeryAggDO[] dos=bp.exec(id_or);
		CiOrdAppUtils.getOrappsurgerytService().delete(dos);;

		return dos;
	}
}
