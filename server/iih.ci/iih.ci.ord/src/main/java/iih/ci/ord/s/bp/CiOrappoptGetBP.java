package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.desc.OrdApOpDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 手术申请查询操作BP
 */
public class CiOrappoptGetBP {
	/**
	 * 手术申请查询
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public CiorappsurgeryAggDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		String whereStr=OrdApOpDODesc.TABLE_ALIAS_NAME+".id_or='"+id_or+"'";
		CiorappsurgeryAggDO[] dos=CiOrdAppUtils.getOrappsurgeryQrytService().find(whereStr, "", FBoolean.FALSE);

		return dos;
	}
}
