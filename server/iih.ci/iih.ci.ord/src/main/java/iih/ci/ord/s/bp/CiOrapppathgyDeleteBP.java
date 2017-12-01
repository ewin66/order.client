package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 病理申请删除操作BP
 */
public class CiOrapppathgyDeleteBP {
	/**
	 * 病理申请删除
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public CiorapppathgyAggDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		CiOrapppathgyGetBP bp=new CiOrapppathgyGetBP();
		CiorapppathgyAggDO[] dos=bp.exec(id_or);
		CiOrdAppUtils.getOrapppathgyService().delete(dos);;

		return dos;
	}
}
