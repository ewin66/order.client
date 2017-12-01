package iih.ci.ord.s.bp;

import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 医嘱物品删除操作BP
 */
public class CiOrSrvDoseDeleteBP {
	/**
	 * 医嘱物品删除
	 * @param id_or
	 * @throws BizException
	 */
	public void exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return;
		CiOrSrvDoseGetBP bp=new CiOrSrvDoseGetBP();
		OrdSrvDoseDO[] dos=bp.exec(id_or);
		if(CiOrdUtils.isEmpty(dos))return;
		CiOrdAppUtils.getOrsrvdoseService().delete(dos);
	}
}
