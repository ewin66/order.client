package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.desc.OrdApConsDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 会诊申请查询操作BP
 */
public class CiOrappconsultGetBP {
	/**
	 * 会诊申请查询
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public CiorappconsultAggDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		String whereStr=OrdApConsDODesc.TABLE_ALIAS_NAME+".id_or='"+id_or+"'";
		CiorappconsultAggDO[] dos=CiOrdAppUtils.getOrappconsultQryService().find(whereStr, "", FBoolean.FALSE);

		return dos;
	}
}
