package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 用血申请保存操作BP
 */
public class CiOrappbuSaveBP {
	/**
	 * 用血申请保存
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public  void exec(OrdAppBtUseDO orappmap,String id_or) throws BizException{
		if(orappmap==null)return;
		if(CiOrdUtils.isEmpty(orappmap.getId_or())){orappmap.setId_or(id_or);}
		CiOrdAppUtils.getOrappbuService().save(new OrdAppBtUseDO[]{orappmap});
	}
}
