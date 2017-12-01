package iih.ci.ord.s.bp.ems;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获得医嘱相关的皮试医嘱集合数据信息操作BP
 */
public class GetCiOrRelSkinTestOrAggsBP {
	/**
	 * 获得医嘱相关的皮试医嘱集合数据信息
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public  CiorderAggDO[] exec(CiorderAggDO oragg) throws BizException{
		//有效性校验
		if(!isValidate(oragg))return null;
		
		//参数设置
		String id_or=oragg.getParentDO().getId_or();
		String whereStr=CiOrderDODesc.TABLE_ALIAS_NAME+".id_or_rel='"+id_or+"' and "
				       +CiOrderDODesc.TABLE_ALIAS_NAME+".sd_reltp='"+ICiDictCodeConst.SD_RELTYPE_SKINTEST+"'";
		
		//查询医嘱关联的皮试医嘱
		CiorderAggDO[] aggdos=CiOrdAppUtils.getOrAggQryService().find(whereStr, "", FBoolean.FALSE);
		
		//返回值处理
		return aggdos;
	}
	
	/**
	 * 有效性校验
	 * @param oragg
	 * @return
	 */
	private boolean isValidate(CiorderAggDO oragg){
		if(oragg==null || oragg.getParentDO()==null)return false;
		if(CiOrdUtils.isDONew(oragg.getParentDO()))return false;
		if(CiOrdUtils.isEmpty(oragg.getParentDO().getId_or()))return false;
		
		return true;
	}
}
