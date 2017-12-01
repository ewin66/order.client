package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 备血申请保存操作BP
 */
public class CiOrappbtSaveBP {
	/**
	 * 备血申请保存
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public void exec(CiorappbtAggDO orappmap,String id_or) throws BizException{
		if(orappmap==null || orappmap.getParentDO()==null)return;
		if(CiOrdUtils.isEmpty(orappmap.getParentDO().getId_or())){orappmap.getParentDO().setId_or(id_or);}
		CiOrdAppUtils.getOrappbtService().save(new CiorappbtAggDO[]{orappmap});
	}
}
