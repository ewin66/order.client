package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.cior.d.desc.OrdApOutDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 出院申请查询操作BP
 */
public class CiOrappoutGetBP {
	/**
	 * 出院申请查询
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public OrdApOutDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		String whereStr=OrdApOutDODesc.TABLE_ALIAS_NAME+".id_or='"+id_or+"'";
		OrdApOutDO[] dos=CiOrdAppUtils.getOrappoutQryService().find(whereStr, "", FBoolean.FALSE);

		return dos;
	}
}
