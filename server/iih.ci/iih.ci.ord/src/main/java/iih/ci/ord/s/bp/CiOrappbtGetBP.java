package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.cior.d.desc.OrdApConsDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 备血申请查询操作BP
 */
public class CiOrappbtGetBP {
	/**
	 * 备血申请查询
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public CiorappbtAggDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		String whereStr=OrdApBtDODesc.TABLE_ALIAS_NAME+".id_or='"+id_or+"'";
		CiorappbtAggDO[] dos=CiOrdAppUtils.getOrappbtQryService().find(whereStr, "", FBoolean.FALSE);
		return dos;
	}
}
