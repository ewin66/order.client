package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 备血申请删除操作BP
 */
public class CiOrappbtDeleteBP {
	/**
	 * 备血申请删除
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public CiorappbtAggDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		CiOrappbtGetBP bp=new CiOrappbtGetBP();
		CiorappbtAggDO[] dos=bp.exec(id_or);
		CiOrdAppUtils.getOrappbtService().delete(dos);
		return dos;
	}
}
