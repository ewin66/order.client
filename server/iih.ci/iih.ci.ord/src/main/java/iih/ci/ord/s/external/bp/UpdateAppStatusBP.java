package iih.ci.ord.s.external.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 更新身亲单状态
 * @author li_zheng
 *
 */
public class UpdateAppStatusBP {
    /**
     * 
     * @param id_or
     * @param status
     * @return
     * @throws BizException
     */
	public String  UpdateAppStatus(String id_or,Boolean status)throws BizException{
	    String messInfo =null;
		if(id_or== null || status== null) return null;
		CiOrderDO ciorder=	 CiOrdAppUtils.getCiorderMDORService().findById(id_or);
		if(ciorder ==null || ciorder.getSd_srvtp() ==null) return null;
		if(ciorder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)){
			//更新病理申请表
			messInfo = UpdateAppBingLi(id_or,status);
		}else{
			if(ciorder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)){
				//更新检查申请表
				messInfo = UpdateAppObs(id_or,status);
			}else if(ciorder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)){
				//更新检验申请表
				messInfo = UpdateAppLab(id_or,status);
			}else if(ciorder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)){
				//更新手术申请表
				messInfo = UpdateAppOP(id_or,status);
			}else if(ciorder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)){
				//更新治疗申请表
				messInfo = UpdateAppTreat(id_or,status);
			} 
		}
		return  messInfo;
	}
	/**
	 * 更新检查申请表
	 * @param id_or
	 * @param status
	 * @return
	 * @throws BizException
	 */
	private String UpdateAppObs(String id_or,Boolean status)throws BizException{
		String whereStr =  " ID_OR ='"+id_or+"'";
		OrdApObsDO[] obsdDO = CiOrdAppUtils.getOrapprisQryService().find(whereStr, "", FBoolean.FALSE);
		if(status!= null && status){
			for(OrdApObsDO apobs:obsdDO){
				apobs.setStatus(DOStatus.UPDATED);
				apobs.setSd_su_obs(ICiDictCodeConst.SD_CI_OBS_YAP);
				apobs.setId_su_obs(ICiDictCodeConst.ID_CI_OBS_YAP);
			}
		}else{
			for(OrdApObsDO apobs:obsdDO){
				apobs.setStatus(DOStatus.UPDATED);
				apobs.setSd_su_obs(ICiDictCodeConst.SD_CI_OBS_SQ);
				apobs.setId_su_obs(ICiDictCodeConst.ID_CI_OBS_SQ);
			}
		}
	 
		CiOrdAppUtils.getOrapprisService().save(obsdDO);
		return null;
	}
	/**
	 * 更新检验申请表
	 * @param id_or
	 * @param status
	 * @return
	 * @throws BizException
	 */
	private String UpdateAppLab(String id_or,Boolean status)throws BizException{
		
		String whereStr =  " ID_OR ='"+id_or+"'";
		OrdApLabDO[] obsdDO = CiOrdAppUtils.getOrapplisQryService().find(whereStr, "", FBoolean.FALSE);
		if(status!= null && status){
			for(OrdApLabDO apobs:obsdDO){
				apobs.setStatus(DOStatus.UPDATED);
				apobs.setSd_su_lab(ICiDictCodeConst.SD_CI_LAB_YY);
				apobs.setId_su_lab(ICiDictCodeConst.ID_CI_LAB_YY);
			}
		}else{
			for(OrdApLabDO apobs:obsdDO){
				apobs.setStatus(DOStatus.UPDATED);
				apobs.setSd_su_lab(ICiDictCodeConst.SD_CI_LAB_SQ);
				apobs.setId_su_lab(ICiDictCodeConst.ID_CI_LAB_SQ);
			}
		}
	 
		CiOrdAppUtils.getOrapplisService().save(obsdDO);
		return null;
	}
	/**
	 * 更新手术申请表
	 * @param id_or
	 * @param status
	 * @return
	 * @throws BizException
	 */
	private String UpdateAppOP(String id_or,Boolean status)throws BizException{
		String whereStr =  " ID_OR ='"+id_or+"'";
		OrdApOpDO[] obsdDO = CiOrdAppUtils.getICiorappsurgeryMDORService().find(whereStr, "", FBoolean.FALSE);
		if(status!= null && status){
			for(OrdApOpDO apobs:obsdDO){
				apobs.setStatus(DOStatus.UPDATED);
				apobs.setSd_su_op(ICiDictCodeConst.SD_CI_OPER_YYY);
				apobs.setId_su_op(ICiDictCodeConst.ID_CI_OPER_YYY);
			}
		}else{
			for(OrdApOpDO apobs:obsdDO){
				apobs.setStatus(DOStatus.UPDATED);
				apobs.setSd_su_op(ICiDictCodeConst.SD_CI_OPER_YSQ);
				apobs.setId_su_op(ICiDictCodeConst.ID_CI_OPER_YSQ);
			}
		}
		CiOrdAppUtils.getICiorappsurgeryMDOCudService().save(obsdDO);
		return null;
	}
	
	/**
	 * 更新治疗申请表
	 * @param id_or
	 * @param status
	 * @return
	 * @throws BizException
	 */
	private String UpdateAppTreat(String id_or,Boolean status)throws BizException{
	
		return null;
	}
	/**
	 * 更新病理申请表
	 * @param id_or
	 * @param status
	 * @return
	 * @throws BizException
	 */
	private String UpdateAppBingLi(String id_or,Boolean status)throws BizException{
		
		String whereStr =  " ID_OR ='"+id_or+"'";
		OrdApPathgyDO[] obsdDO = CiOrdAppUtils.getICiorapppathgyMDORService().find(whereStr, "", FBoolean.FALSE);
		if(status!= null && status){
			for(OrdApPathgyDO apobs:obsdDO){
				apobs.setStatus(DOStatus.UPDATED);
				apobs.setSd_su_pathgy(ICiDictCodeConst.SD_SU_PATHGY_YAP);
				apobs.setId_su_pathgy(ICiDictCodeConst.ID_SU_PATHGY_YAP);
			}
		}else{
			for(OrdApPathgyDO apobs:obsdDO){
				apobs.setStatus(DOStatus.UPDATED);
				apobs.setSd_su_pathgy(ICiDictCodeConst.SD_SU_PATHGY_YSQ);
				apobs.setId_su_pathgy(ICiDictCodeConst.ID_SU_PATHGY_YSQ);
			}
		}
	 
		CiOrdAppUtils.getICiorapppathgyMDOCudService().save(obsdDO);
		return null;
	}
}
