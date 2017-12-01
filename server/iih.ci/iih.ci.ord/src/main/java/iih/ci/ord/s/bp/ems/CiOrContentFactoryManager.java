package iih.ci.ord.s.bp.ems;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.content.d.BloodProdUseCiOrContentFactory;
import iih.ci.ord.content.d.BloodprodPrepareCiOrContentFactory;
import iih.ci.ord.content.d.CiOrContentObjFactory;
import iih.ci.ord.content.d.CiOrLeaveHosContentFactory;
import iih.ci.ord.content.d.CiOrTransDeptContentFactory;
import iih.ci.ord.content.d.DeathOrderContentFactory;
import iih.ci.ord.content.d.DefaultDrugOrContentFactory;
import iih.ci.ord.content.d.DefaultLisOrContentFactory;
import iih.ci.ord.content.d.DefaultOrContentFactory;
import iih.ci.ord.content.d.DefaultRisOrContentFactory;
import iih.ci.ord.content.d.HerbOrContentFactory;
import iih.ci.ord.content.d.NurseNsgreedCiOrContentFactory;
import iih.ci.ord.content.d.OPNormOrContentFactory;
import iih.ci.ord.content.d.OpTaiCiOrContentFactory;
import iih.ci.ord.content.d.PathologyOrContentFactory;
import iih.ci.ord.content.d.SkinTestOrContentFactory;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;

public class CiOrContentFactoryManager {
	/**
	 * 获得医嘱内容对象
	 * @param ems
	 * @return
	 */
	public static CiOrContentObjFactory getCiOrContentObjFactory(CiEmsDTO ems){
		String orsrvtp=getOrderType(ems);
		/**
		 *  重构  todo
		 */
		if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
			if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
				return new HerbOrContentFactory();// 草药
			}else{
				return new DefaultDrugOrContentFactory();// 其它药品
			}
		}else if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_RIS)){
			if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)){
				return new PathologyOrContentFactory();
			}else{
				return new DefaultRisOrContentFactory();
			}
		}else if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_LIS)){
			return new DefaultLisOrContentFactory();		//检验
	    }else if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE)){
			return new  BloodProdUseCiOrContentFactory ();	 //用血		
	    }else if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE)){
			return new  BloodprodPrepareCiOrContentFactory();	//备血		
	    }else if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_NORM) ||
	    		 CiOrdUtils.isCapitalInStr(orsrvtp,IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS)){//普通   //会诊 
			return new OPNormOrContentFactory();			
		}else if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_OP)){
			return new OpTaiCiOrContentFactory();//手术
		}else if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT) || 
				CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSWARD) ||
				CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CROSSDEPT)){//转科  转病区 跨科
			return new CiOrTransDeptContentFactory();
	    }else if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_LEAVEHOS)){//出院
			return new CiOrLeaveHosContentFactory();
	    }else if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST)
	    		|| orsrvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)  ){//治疗--->皮肤敏感性试验
			return new SkinTestOrContentFactory();
		}else if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_NURSE_NSGREED)){// 护理
			return new NurseNsgreedCiOrContentFactory();
		}else if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_OP_TAICI)){// 台次手术
			return new OpTaiCiOrContentFactory();
		}else if(CiOrdUtils.isCapitalInStr(orsrvtp, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH)){// 宣布死亡
			return new DeathOrderContentFactory();
		} else{
			return new DefaultOrContentFactory(); 
		}
	}
	
	/***
	 * 
	 * @param ems
	 * @return
	 */
	private static String getOrderType(CiEmsDTO ems){
		//if(OrSrvSplitUtil.isEmpty())return "";
		return ems.getSd_srvtp();
		
	}
}
