package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.desc.OrdApLabDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 检验申请查询操作BP
 */
public class CiOrapplisGetBP {
	/**
	 * 检验申请查询
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public OrdApLabDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		String whereStr=OrdApLabDODesc.TABLE_ALIAS_NAME+".id_or='"+id_or+"'";
		OrdApLabDO[] dos=CiOrdAppUtils.getOrapplisQryService().find(whereStr, "", FBoolean.FALSE);

		return dos;
	}
}
