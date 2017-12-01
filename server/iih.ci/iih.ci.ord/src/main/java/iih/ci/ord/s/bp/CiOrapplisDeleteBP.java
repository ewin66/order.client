package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 检验申请删除操作BP
 */
public class CiOrapplisDeleteBP {
	/**
	 * 检验申请删除
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public OrdApLabDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		CiOrapplisGetBP bp=new CiOrapplisGetBP();
		OrdApLabDO[] dos=bp.exec(id_or);
		CiOrdAppUtils.getOrapplisService().delete(dos);

		return dos;
	}
}
