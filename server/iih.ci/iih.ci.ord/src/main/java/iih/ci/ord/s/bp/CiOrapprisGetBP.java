package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.desc.OrdApObsDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 检查申请查询操作BP
 */
public class CiOrapprisGetBP {
	/**
	 * 检查申请查询
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public OrdApObsDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		String whereStr=OrdApObsDODesc.TABLE_ALIAS_NAME+".id_or='"+id_or+"'";
		OrdApObsDO[] dos=CiOrdAppUtils.getOrapprisQryService().find(whereStr, "", FBoolean.FALSE);

		return dos;
	}
}
