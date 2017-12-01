package iih.ci.ord.s.bp;

import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class CiOrSkintestDeleteBP {
	public void exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or)) return;
		CiSkinTestRstDO[] skintest = CiOrdAppUtils.getCiskintestrstQryService().find(String.format("id_or='%s'",id_or),"", FBoolean.FALSE);;
		if(!CiOrdUtils.isEmpty(skintest)&&skintest.length>0){
			CiOrdAppUtils.getCiskintestrstService().delete(skintest);
		}
	}
}
