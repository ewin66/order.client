package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.d.desc.OrdApPathgyDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 病理申请查询操作BP
 */
public class CiOrapppathgyGetBP {
	/**
	 * 病理申请查询
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public CiorapppathgyAggDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		String whereStr=OrdApPathgyDODesc.TABLE_ALIAS_NAME+".id_or='"+id_or+"'";
		CiorapppathgyAggDO[] dos=CiOrdAppUtils.getOrapppathgyQryService().find(whereStr, "", FBoolean.FALSE);

		return dos;
	}
}
