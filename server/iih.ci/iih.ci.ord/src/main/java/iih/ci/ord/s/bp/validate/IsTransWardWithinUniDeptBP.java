package iih.ci.ord.s.bp.validate;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.d.desc.OrdApTransDODesc;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
  * 是否在相同就诊科室内部进行病区的转移判断操作BP
  * 大科室小病区管理时，转病区业务在同一科室内进行的业务判断
 */
public class IsTransWardWithinUniDeptBP {
	/**
	 * 是否在相同就诊科室内部进行病区的转移判断
	 * 大科室小病区管理时，转病区业务在同一科室内进行的业务判断
	 * @param ordo
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(CiOrderDO ordo)  throws BizException{
		//有效性判断
		if(CiOrdUtils.isEmpty(ordo))return FBoolean.FALSE;
		
		//是否是转科医嘱
		if(!CiOrdUtils.isCapitalInStr(ordo.getSd_srvtp(), 
				IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT))return FBoolean.FALSE;
		
		//获得转科申请
		OrdApTransDO[] transdeptdos=getOrdApTransDOs(ordo.getId_or());
		if(CiOrdUtils.isEmpty(transdeptdos))return FBoolean.FALSE;
		
		//是否是同一就诊科室下转病区医嘱判断
		if(CiOrdUtils.isStrRealEquals(transdeptdos[0].getId_dep_from(),transdeptdos[0].getId_dep_to()))return FBoolean.TRUE;
		
		//返回值
		return FBoolean.FALSE;
	}
	
	/**
	 * 获得转科申请
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	private OrdApTransDO[] getOrdApTransDOs(String id_or) throws BizException{
		String aliasTblName=OrdApTransDODesc.TABLE_ALIAS_NAME;
		String whereStr=CiOrdUtils.getSqlPart4StringV(aliasTblName,OrdApTransDO.ID_OR,id_or);
		return  CiOrdAppUtils.getCiorapptransdeptQryService().find(whereStr, "", FBoolean.FALSE);

	}
	

}
