package iih.ci.ord.s.bp.skintest;

import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.d.desc.PiPatAlDODesc;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获得患者药品过敏史信息操作BP
 */
public class GetPatiAllergicHisBP {
	/**
	 * 获得患者药品过敏史数据信息
	 * @param id_empi   患者主索引
	 * @param id_pharm_master  药品主数据
	 * @param dt_min   查询时间范围的最小值
	 * @param dt_max   查询时间范围的最大值    
	 * @return
	 * @throws BizException
	 */
	public PiPatAlDO[] exec(String id_empi,String id_pharm_master,String dt_min,String dt_max)  throws BizException{ 
		//有效性判断
		if(CiOrdUtils.isEmpty(id_empi))return null;

		//获得条件串
		String tblalias=PiPatAlDODesc.TABLE_ALIAS_NAME+CiOrdUtils.FULLSTOP_STR;
		String whereStr=getWhereStr(id_empi,id_pharm_master,dt_min,dt_max,tblalias);
		
		//查询结果返回
		return CiOrdAppUtils.getIPiPatAlDORService().find(whereStr, PiPatAlDODesc.TABLE_ALIAS_NAME+CiOrdUtils.FULLSTOP_STR+PiPatAlDO.DT_ACT +" desc", FBoolean.FALSE);
	}
	
	/**
	 * 获得条件串
	 * @param id_empi
	 * @param id_pharm_master
	 * @param dt_min
	 * @param dt_max
	 * @param tblalias
	 * @return
	 */
	private String getWhereStr(String id_empi,String id_pharm_master,String dt_min,String dt_max,String tblalias){
		String whereStr=tblalias+PiPatAlDO.ID_PAT+CiOrdUtils.EQUAL_STR+"'"+id_empi+"'";
		if(!CiOrdUtils.isEmpty(id_pharm_master)){
			whereStr+=CiOrdUtils.AND_STR+tblalias+PiPatAlDO.ID_MM+CiOrdUtils.EQUAL_STR+"'"+id_pharm_master+"'";
		}
		if(!CiOrdUtils.isEmpty(dt_min)){
			whereStr+=CiOrdUtils.AND_STR+tblalias+PiPatAlDO.DT_ACT+CiOrdUtils.GREATTHAN_EQUAL_STR+"'"+dt_min+"'";
		}
//		if(!CiOrdUtils.isEmpty(dt_max)){
//			whereStr+=CiOrdUtils.AND_STR+tblalias+PiPatAlDO.DT_ACT+CiOrdUtils.LESSTHAN_EQUAL_STR+"'"+dt_max+"'";
//		}
		return whereStr;
	}
}
