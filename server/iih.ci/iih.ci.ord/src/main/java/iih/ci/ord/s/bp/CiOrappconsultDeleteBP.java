package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 会诊申请删除操作BP
 */
public class CiOrappconsultDeleteBP {
	/**
	 * 会诊申请删除
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public CiorappconsultAggDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		CiOrappconsultGetBP bp=new CiOrappconsultGetBP();
		CiorappconsultAggDO[] dos=bp.exec(id_or);
		CiOrdAppUtils.getOrappconsultService().delete(dos);;

		return dos;
	}
}
