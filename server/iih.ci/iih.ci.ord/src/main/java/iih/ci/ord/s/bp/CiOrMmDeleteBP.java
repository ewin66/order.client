package iih.ci.ord.s.bp;

import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 医嘱物品删除操作BP
 */
public class CiOrMmDeleteBP {
	/**
	 * 医嘱物品删除
	 * @param id_or
	 * @throws BizException
	 */
	public void exec(String[] id_orsrvs) throws BizException{
		if(CiOrdUtils.isEmpty(id_orsrvs))return;
		CiOrMmGetBP bp=new CiOrMmGetBP();
			for(String id_orsrv : id_orsrvs){
				OrdSrvMmDO[] dos=bp.exec(id_orsrv);
				if(CiOrdUtils.isEmpty(dos))return;
				CiOrdAppUtils.getOrsrvmmService().logicDelete(dos);
				
			}
	}
}
