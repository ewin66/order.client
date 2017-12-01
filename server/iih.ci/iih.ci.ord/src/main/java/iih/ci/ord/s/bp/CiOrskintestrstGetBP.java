package iih.ci.ord.s.bp;

import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import iih.ci.ord.skintest.d.desc.CiSkinTestRstDODesc;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
/*
 * 皮试医嘱对应的结果查询操作BP
 */
public class CiOrskintestrstGetBP {
	/**
	 * 皮试医嘱对应的结果查询
	 * @param id_or
	 * @throws BizException
	 */
	public CiSkinTestRstDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		String condstr=CiSkinTestRstDODesc.TABLE_ALIAS_NAME+".id_or='"+id_or+"'";
		CiSkinTestRstDO[] dos=CiOrdAppUtils.getCiskintestrstQryService().find(condstr, "", FBoolean.FALSE);
		return dos;
	}
}
