package iih.ci.ord.pub;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.i.IBdSrvSysParamConst;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.srv.srvcate.i.ISrvcateRService;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiOrPubUtils {
	public static final String COMMA_STR=",";
	
	/***
	 * 是否为TRUE
	 * 
	 * @param isA
	 * @return
	 */
	public static boolean isTrue(FBoolean isA) {
		if (isA == null)
			return false;
		return isA.booleanValue();
	}
	
	/**
	 * 英文逗号是否在字串中的判断
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isCommaInStr(String input) {
		if (input.indexOf(COMMA_STR) >= 0)
			return true;
		return false;

	}
	
	/**
	 * 字母匹配判断
	 */
	public static boolean isInStr(String input,String matchstr){
		if(isEmpty(matchstr) || isEmpty(input))return false;
		if(input.indexOf(matchstr)>=0)return true;
		return false;
	}
	
	/**
	 * 首字母匹配判断
	 */
	public static boolean isCapitalInStr(String input,String matchstr){
		if(isEmpty(matchstr) || isEmpty(input))return false;
		if(input.trim().indexOf(matchstr.trim())==0)return true;
		return false;
	}
	
	/**
	 * 是否为医嘱签署
	 * @param or
	 * @return
	 */
	public static boolean isOrOpen(CiOrderDO or){
		if(or==null)return false;
		if(!isTrue(or.getFg_sign()))return true;
		return false;
	}
	/**
	 * 是否为医嘱签署撤销
	 * @param or
	 * @return
	 */
	public static boolean isOrSignCancel(CiOrderDO newor,CiOrderDO oldor){
		try{
			if(ICiDictCodeConst.SD_SU_OPEN.equals(oldor.getSd_su_or())
					&& ICiDictCodeConst.SD_SU_SIGN.equals(oldor.getSd_su_or())){
				return true;
			}
			return false;
		}catch(Exception e){
			return false;
		}		

	}
	
	/**
	 * 是否为医嘱签署
	 * @param or
	 * @return
	 */
	public static boolean isOrSign(CiOrderDO or){
		if(or==null)return false;
		if(isTrue(or.getFg_sign()) 
				&& !isTrue(or.getFg_chk())
				&& ICiDictCodeConst.SD_SU_BL_NONE.equals(or.getSd_su_bl())
				&& ICiDictCodeConst.SD_SU_MP_NONE.equals(or.getSd_su_mp()))return true;
		return false;
	}
	
	/**
	 * 是否为医嘱核对
	 * @param or
	 * @return
	 */
	public static boolean isOrCheck(CiOrderDO or){
		if(or==null)return false;
		if(isTrue(or.getFg_chk()) 
				&& !isTrue(or.getFg_canc())
				&&!isTrue(or.getFg_chk_stop())
				&&!isTrue(or.getFg_chk_canc())
				&& ICiDictCodeConst.SD_SU_BL_NONE.equals(or.getSd_su_bl())
				&& ICiDictCodeConst.SD_SU_MP_NONE.equals(or.getSd_su_mp()))return true;
		return false;
	}
	
	/**
	 * 是否为医嘱停止核对
	 * @param or
	 * @return
	 */
	public static boolean isOrStopCheck(CiOrderDO or){
		if(or==null)return false;
		if(isTrue(or.getFg_chk_stop())
				&& !isTrue(or.getFg_canc()))return true;
		return false;
	}
	
	/**
	 * 是否为医嘱作废
	 * @param or
	 * @return
	 */
	public static boolean isOrCancel(CiOrderDO or){
		if(or==null)return false;
		if(isTrue(or.getFg_canc())
				&& isTrue(or.getFg_sign()))return true;
		return false;
	}
	
	/**
	 * 是否为医嘱作废核对
	 * @param or
	 * @return
	 */
	public static boolean isOrCancelCheck(CiOrderDO or){
		if(or==null)return false;
		if(isTrue(or.getFg_canc())
				&& isTrue(or.getFg_sign()) && isTrue(or.getFg_chk_canc()))return true;
		return false;
	}
	
	/**
	 * 是否为空串判断
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(String input) {

		return StringUtils.isBlank(input);
	}
	
	/**
	 * 获得临床医嘱类型 
	 * CiOrderTypeEnum
	 * @param ordo
	 * @return CiOrderTypeEnum
	 * @throws BizException 
	 */
	public static Integer getCiOrderType(CiOrderDO ordo){
		//空判断 
		if(ordo==null)return CiOrderTypeEnum.UNKNOWNORDER;
		String ortp=ordo.getSd_srvtp();
		if(isEmpty(ortp))return CiOrderTypeEnum.UNKNOWNORDER;
		
		//基本判断逻辑
		if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS)){//会诊医嘱  0902
			return CiOrderTypeEnum.CONSULTORDER;
		}else if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT)){//转科医嘱 1201
			return CiOrderTypeEnum.DEPT2DEPTORDER;
		}else if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_OP)){//手术医嘱 04
			if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_OP_TAICI)){//台次手术医嘱 0401
				return CiOrderTypeEnum.OPERATIONORDER;
			}else if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_OP_BESIDEDEB)){//床边手术医嘱 0402
				return CiOrderTypeEnum.BEDOPORDER;
			}
			return CiOrderTypeEnum.ALLOPORDER;
		}else if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH)){//死亡医嘱 1203
			return CiOrderTypeEnum.DEATHORDER;
		}else if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_LEAVEHOS)){//出院医嘱 1202
			return CiOrderTypeEnum.OUTHOSPORDER;
		}else if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_TREAT_RESCUE)){//抢救医嘱 0507
			return CiOrderTypeEnum.RESCUEORDER;
		}else if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_NURSE_NSGREED)){//护理医嘱0601
			return CiOrderTypeEnum.NSGRADEORDER;
		}else if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_TREAT_NUT)){//营养膳食医嘱0505
			return CiOrderTypeEnum.NUTRIONDIETORDER;
		}else if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_TREAT_FANGLIAO)){//放疗0502
			return CiOrderTypeEnum.RIDIOTHERAPYORDER;
		}else if(isChemotherapyOrder(ordo)){//化疗
			return CiOrderTypeEnum.CHEMOTHERAPYORDER;
		}else if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_TREAT_TOUXI)){//透析0508
			return CiOrderTypeEnum.DIALYSISORDER;
		}else if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE)){//用血 14 
			return CiOrderTypeEnum.USEBTORDER;
		}else if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CROSSDEPT)){//跨科 
			return CiOrderTypeEnum.CROSSDEPTORDER;
		}else if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_ENTRUST_ILLSTATE)){//病情 
			return CiOrderTypeEnum.ILLSTATEORDER;
		}else if(isCapitalInStr(ortp,IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH)){//死亡
			return CiOrderTypeEnum.DEATHORDER;
		}
		
		return CiOrderTypeEnum.UNKNOWNORDER;
	}
	
	/**
	 * 是否为化疗的判断逻辑
	 * @param ordo
	 * @return
	 */
	private static boolean isChemotherapyOrder(CiOrderDO ordo){
		String v=null;
		try{
			v=ParamsetQryUtil.getParaString(ordo.getId_org(), IBdSrvSysParamConst.SYS_PARAM_AntiTumorPharmRelSrvCa);
			SrvCateDO cado=getSrvcateQryService().findById(v);
			if(cado==null)return false;
			v=cado.getInnercode();
		}catch(Exception e){
			return false;
		}
		 
		return isCapitalInStr(ordo.getInnercode_srvca(),v);
	}
	
	/**
	 * 获得基本服务分类
	 * @return
	 */
	public static ISrvcateRService getSrvcateQryService(){
		return (ISrvcateRService)ServiceFinder.find(ISrvcateRService.class);
	}
	
	/**
	 * 是否门急诊 
	 * @param sd_entp
	 * @return
	 */
	public static boolean isOpUrgentWf(String sd_entp){
		if(isEmpty(sd_entp))return false;
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(sd_entp)  || IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(sd_entp))return true;
		return false;
		
	}
	
	/**
	 * 是否门诊
	 * @param sd_entp
	 * @return
	 */
	public static boolean isOpWf(String sd_entp){
		if(isEmpty(sd_entp))return false;
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(sd_entp))return true;
		return false;
		
	}
	
	/**
	 * 是否急诊
	 * @param sd_entp
	 * @return
	 */
	public static boolean isUrgentWf(String sd_entp){
		if(isEmpty(sd_entp))return false;
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(sd_entp))return true;
		return false;
		
	}
	
	/**
	 * 是否住院
	 * @param sd_entp
	 * @return
	 */
	public static boolean isIpWf(String sd_entp){
		if(isEmpty(sd_entp))return false;
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(sd_entp))return true;
		return false;
	}
}
