package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 转科申请删除操作BP
 */
public class CiOrapptransdepDeleteBP {
	/**
	 * 转科申请删除
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public OrdApTransDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		CiOrapptransdepGetBP bp=new CiOrapptransdepGetBP();
		OrdApTransDO[] dos=bp.exec(id_or);
		CiOrdAppUtils.getOrapptransdepService().delete(dos);;

		return dos;
	}
}
