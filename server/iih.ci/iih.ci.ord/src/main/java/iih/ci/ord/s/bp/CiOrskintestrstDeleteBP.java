package iih.ci.ord.s.bp;

import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import xap.mw.core.data.BizException;

/*
 * 皮试医嘱对应的结果删除操作BP
 */
public class CiOrskintestrstDeleteBP {
	/**
	 * 皮试医嘱对应的结果删除
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public void exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return;
		CiOrskintestrstGetBP bp=new CiOrskintestrstGetBP();
		CiSkinTestRstDO[] dos=bp.exec(id_or);
		CiOrdAppUtils.getCiskintestrstService().delete(dos);
	}
}
