package iih.ci.ord.s.bp.ems;

import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.d.desc.OrdSrvDoseDODesc;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获得医嘱项目对应的变动剂量数据信息操作BP
 */
public class GetDoseOfCiOrSrvBP {
	/**
	 * 获得医嘱项目对应的变动剂量数据信息
	 * @param id_orsrv
	 * @param issetdelsign
	 * @return
	 * @throws BizException
	 */
	public OrdSrvDoseDO[] exec(String id_orsrv,boolean issetdelsign) throws BizException{
		if(CiOrdUtils.isEmpty(id_orsrv))return null;
		String condstr=OrdSrvDoseDODesc.TABLE_ALIAS_NAME+".id_orsrv='"+id_orsrv+"'";
		OrdSrvDoseDO[] orsrvdoses=CiOrdAppUtils.getOrsrvdoseQryService().find(condstr, "", FBoolean.FALSE);
		if(issetdelsign){CiOrdUtils.setDelStatus(orsrvdoses);}
		if(orsrvdoses==null || orsrvdoses.length==0)return null;
		return orsrvdoses;
	}
}
