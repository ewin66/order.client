package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.s.CiorderMDOCrudServiceImpl;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class DischargeCheckBP {
	private static final String ERROR_NOT_HAS_DISCHARGE = "有有效医嘱，但无退院医嘱";
	private static final String ERROR_HAS_VALID = "有未停止或未作废的医嘱";
	public DischargeCheckBP(){}
	
	/**
	 * 是否可退院
	 * @param entId 就诊id
	 * @return 错误信息
	 * @throws BizException
	 */
	public String canDischarge(String entId) throws BizException{
		String errorMsg = "";
		//Integer dischargeCount = this.getDischarge(entId);
		
		Integer validCount = this.getDischarge(entId);
		 if(validCount>0){
			 errorMsg = "存在有效医嘱";
		 }
	/*	if(validCount>0){
			Integer dischargeCount = this.getDischarge(entId);
			
			if(dischargeCount>0){
				Integer validNotStoped = this.getValidNotStoped(entId);
				if(validNotStoped>0){
					errorMsg = ERROR_HAS_VALID;
				}
			}else{
				errorMsg = ERROR_NOT_HAS_DISCHARGE;
			}
		}*/		
		
		return errorMsg;
	}
	/**
	 * 获取有效医嘱总数（未作废的）
	 * @param entId
	 * @return
	 * @throws BizException 
	 */
	private Integer getValid(String entId) throws BizException{
		
		ICiorderMDORService ciorderService = ServiceFinder.find(ICiorderMDORService.class);
		
		CiOrderDO[] ciorderArray = ciorderService.find(CiOrderDODesc.TABLE_ALIAS_NAME+".id_en = '"+entId
				+"' and "+CiOrderDODesc.TABLE_ALIAS_NAME+".sd_su_or in("+ICiDictCodeConst.SD_SU_SIGN+","
				+ICiDictCodeConst.SD_SU_CHECKTHROUGH+","+ICiDictCodeConst.SD_SU_DOCTORSTOP+","
				+ICiDictCodeConst.SD_SU_CHECKSTOP+ ")", "", FBoolean.FALSE);
		if(ciorderArray!=null && ciorderArray.length!=0 )
		{
			return ciorderArray.length;
		}
		return 0;
	}
	/**
	 * 有效医嘱个数
	 * @param entId
	 * @return
	 * @throws DAException 
	 */
	private Integer getDischarge(String entId) throws DAException{
		StringBuilder builder = new StringBuilder();
		builder.append(" select count(*)  from ci_order or1 ");
		builder.append(" inner join ci_or_srv srv on or1.id_or = srv.id_or ");
		//医嘱状态需要修改
		builder.append(" where   or1.sd_su_or  in ('0','10','20','40','50','70')   and or1.id_en =? ");
		//builder.append(" where srv.sd_srvtp = ?  and or1.sd_su_or =?   and or1.id_en =? ");
		SqlParam param = new SqlParam();
		//param.addParam("1304");
		//param.addParam(ICiDictCodeConst.SD_SU_CHECKSTOP);
		param.addParam(entId);
		int result = (int) new DAFacade().execQuery(builder.toString(), param, new ColumnHandler());
		return result;
	}
	/**
	 * 获取未停止、且为作废的医嘱
	 * @param entId
	 * @return
	 * @throws BizException 
	 */
	private Integer getValidNotStoped(String entId) throws BizException{
		CiOrderDO[] ciorderArray = CiOrdAppUtils.getOrQryService().find(CiOrderDODesc.TABLE_ALIAS_NAME+".sd_su_or not in ("+ICiDictCodeConst.SD_SU_CHECKSTOP+","+ ICiDictCodeConst.SD_SU_CANCEL+") and "+CiOrderDODesc.TABLE_ALIAS_NAME+".fg_sign ='Y'  and "+CiOrderDODesc.TABLE_ALIAS_NAME+".id_en ='"+entId+"'", "", new FBoolean(false));
		if(ciorderArray!=null && ciorderArray.length!=0 )
		{
			return ciorderArray.length;
		}
		return 0;
	}
}
