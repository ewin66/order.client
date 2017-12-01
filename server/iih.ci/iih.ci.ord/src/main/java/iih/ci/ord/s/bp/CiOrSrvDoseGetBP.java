package iih.ci.ord.s.bp;

import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.d.desc.OrdSrvDoseDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 医嘱项目变动用药查询操作BP
 */
public class CiOrSrvDoseGetBP {
	/**
	 * 医嘱项目变动用药查询
	 * @param id_or
	 * @throws BizException
	 */
	public OrdSrvDoseDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		String condstr=OrdSrvDoseDODesc.TABLE_ALIAS_NAME+".id_or='"+id_or+"'";
		OrdSrvDoseDO[] dos=CiOrdAppUtils.getOrsrvdoseQryService().find(condstr, "", FBoolean.FALSE);
		return dos;
	}
}
