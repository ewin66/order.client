package iih.ci.ord.s.bp.ems;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.d.desc.OrdSrvDoseDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 获得删除医嘱项目对应的变动用药数据操作BP
 */
public class CiOrSrvDosesDelGetBP {
	/**
	 * 获得删除医嘱项目对应的变动用药数据
	 * @param orsrvdo
	 * @return
	 * @throws BizException
	 */
	public  OrdSrvDoseDO[] exec(OrdSrvDO orsrvdo)  throws BizException{
		if(orsrvdo==null)return null;
		//医嘱项目对应的变动用药数据信息处理
		if(OrSrvSplitUtil.isTrue(orsrvdo.getFg_dose_anoma())){
			return getCiSrvDoseDOs(orsrvdo.getId_orsrv());
		}
		return null;
	}
	
	/**
	 * 医嘱项目关联变动剂量数据集合
	 * @param id_or
	 * @throws BizException
	 */
	private OrdSrvDoseDO[] getCiSrvDoseDOs(String id_orsrv) throws BizException{
		String condstr=OrdSrvDoseDODesc.TABLE_ALIAS_NAME+".id_orsrv='"+id_orsrv+"'";
		OrdSrvDoseDO[] orsrvdoses=CiOrdAppUtils.getOrsrvdoseQryService().find(condstr, "", FBoolean.FALSE);
		CiOrdUtils.setDelStatus(orsrvdoses);
		if(orsrvdoses==null || orsrvdoses.length==0)return null;
		return orsrvdoses;
	}
}
