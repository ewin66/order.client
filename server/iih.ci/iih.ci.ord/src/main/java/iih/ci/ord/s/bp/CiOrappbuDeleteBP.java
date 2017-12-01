package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 用血申请删除操作BP
 */
public class CiOrappbuDeleteBP {
	/**
	 * 用血申请删除
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public  OrdAppBtUseDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		CiOrappbuGetBP bp=new CiOrappbuGetBP();
		OrdAppBtUseDO[] dos=bp.exec(id_or);
		CiOrdAppUtils.getOrappbuService().delete(dos);

		return dos;
	}
}
