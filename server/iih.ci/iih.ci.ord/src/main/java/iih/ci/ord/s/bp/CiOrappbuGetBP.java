package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 用血申请查询操作BP
 */
public class CiOrappbuGetBP {
	/**
	 * 用血申请查询
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public  OrdAppBtUseDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		String whereStr=OrdApBtDODesc.TABLE_ALIAS_NAME+".id_or='"+id_or+"'";
		OrdAppBtUseDO[] dos=CiOrdAppUtils.getOrappbuQryService().find(whereStr, "", FBoolean.FALSE);

		return dos;
	}
}
