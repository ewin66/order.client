package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.d.desc.OrdApTransDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 转科申请查询操作BP
 */
public class CiOrapptransdepGetBP {
	/**
	 * 转科申请查询
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public OrdApTransDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		String whereStr=OrdApTransDODesc.TABLE_ALIAS_NAME+".id_or='"+id_or+"'";
		OrdApTransDO[] dos=CiOrdAppUtils.getOrapptransdepQryService().find(whereStr, "", FBoolean.FALSE);

		return dos;
	}
}
