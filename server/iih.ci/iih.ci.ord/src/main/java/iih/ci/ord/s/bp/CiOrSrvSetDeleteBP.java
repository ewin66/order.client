package iih.ci.ord.s.bp;

import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 医嘱或项目对应套项目删除操作BP
 */
public class CiOrSrvSetDeleteBP {
	/**
	 * 医嘱或项目对应套项目删除
	 * @param id_or
	 * @throws BizException
	 */
	public void exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return;
		CiOrSrvSetGetBP bp=new CiOrSrvSetGetBP();
		OrdSrvSetDO[] dos=bp.exec(id_or);
		if(CiOrdUtils.isEmpty(dos))return;
		CiOrdAppUtils.getOrsrvsetService().delete(dos);
	}
}
