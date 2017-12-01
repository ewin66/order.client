package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/**
 * 根据服务类型获得默认医疗单类型操作BP
 */
public class GetDefaultEmsTp8SrvtpBP {
	/**
	 * 根据服务类型获得默认医疗单类型
	 * @param sd_srvtp
	 * @return
	 * @throws BizException
	 */
	public Integer  exec(String sd_srvtp)  throws BizException{
		if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
			return EmsType.HERB;
		}else if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX) || 
				CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY) ||
				CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_REPL)
				){
			return EmsType.IV;
		}else if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_DRUG)){  //药品其它
			return EmsType.COMMONDRUG;
		}else if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)){  //
			return EmsType.PATHGY;
		}else if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_RIS)){  //
			return EmsType.RIS;
		}else if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST)){  //
			return EmsType.SKINTEST;
		}else if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_LIS)){  //
			return EmsType.LIS;
		}else if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_OP)){  //
			return EmsType.OPER;
		}else if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE)){  //
			return EmsType.BT;
		}else if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE)){  //
			return EmsType.BTUSE;
		}else if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS)){  //
			return EmsType.CONS;
		}else if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT)||
				CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CROSSDEPT)){  //
			return EmsType.TRANSDEPT;
		}else if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSWARD)){  //
			return EmsType.TRANSDEPT;//EmsType.TRANSWARD;			
		}else if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_LEAVEHOS) ||
				CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH)){  //
			return EmsType.OUTHOSP;
		}else if(CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_TREAT_NORMAL) || 
				CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_TREAT_XIYANG) ||
				CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_NURSE_NSGREED) ||
				CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_NURSE_TREATNS) ||
				CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_NURSE_VS) ||
				CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_ENTRUST_A) ||
				//CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH) ||
				CiOrdUtils.isCapitalInStr(sd_srvtp, IBdSrvDictCodeConst.SD_SRVTP_OTHER) 
				){
			return EmsType.COMMON;
		}
		
		return -1;
	}
}
