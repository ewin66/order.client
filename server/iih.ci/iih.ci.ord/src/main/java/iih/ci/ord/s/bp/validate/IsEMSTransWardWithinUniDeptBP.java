package iih.ci.ord.s.bp.validate;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
  * 是否在相同就诊科室内部进行病区的转移判断操作BP
  * 大科室小病区管理时，转病区业务在同一科室内进行的业务判断
 */
public class IsEMSTransWardWithinUniDeptBP {

	
	
	/**
	 * 是否在相同就诊科室内部进行病区的转移判断
	 * 大科室小病区管理时，转病区业务在同一科室内进行的业务判断
	 * @param ordo
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(CiEmsDTO ems)  throws BizException{
		//有效性判断
		if(CiOrdUtils.isEmpty(ems))return FBoolean.FALSE;
		
		//是否是转科医嘱
		if(!CiOrdUtils.isCapitalInStr(ems.getSd_srvtp(), 
				IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT))return FBoolean.FALSE;
		
		//获得转科申请
		OrdApTransDO transdeptdos=getOrdApTransDOs(ems);
		if(CiOrdUtils.isEmpty(transdeptdos))return FBoolean.FALSE;
		
		//是否是同一就诊科室下转病区医嘱判断
		if(CiOrdUtils.isStrRealEquals(transdeptdos.getId_dep_from(),transdeptdos.getId_dep_to()))return FBoolean.TRUE;
		
		//返回值
		return FBoolean.FALSE;
	}
	
	/**
	 * 获得转科申请
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	private OrdApTransDO getOrdApTransDOs(CiEmsDTO ems) throws BizException{
		if(ems.getOrapplysheet() == null){
 			throw new BizException("未获取服务【"+ems.getName()+"】对应的申请单，请在申请单维护中进行配置！");
		}
		OrdApTransDO aptrans=(OrdApTransDO) ems.getOrapplysheet().get("13");		
		return  aptrans;

	}
	
	

}
