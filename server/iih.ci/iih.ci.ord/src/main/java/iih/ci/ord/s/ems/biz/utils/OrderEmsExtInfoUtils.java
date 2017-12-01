package iih.ci.ord.s.ems.biz.utils;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.dto.d.CiordubDTO;
import iih.ci.ord.dto.d.SkinTestRstDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;

public class OrderEmsExtInfoUtils {
	
	/**
	 * 设置返回结果错误信息
	 * @param ems
	 * @param msg
	 */
	public static void SetErrMsg(EmsRstDTO ems, FArrayList v){
		FMap2 emsExtension = ems.getExtension();
		if (null == emsExtension){
			emsExtension = new FMap2();
			ems.setExtension(emsExtension);
			
		}
		FArrayList errList = (FArrayList)emsExtension.get("ErrMsgList");
		if (null == errList){
			errList = new FArrayList();
			emsExtension.put("ErrMsgList", errList);
		}
		errList.add(v);
	}
	
	public static void SetDiInfo(EmsRstDTO ems, FMap v){
		FMap2 emsExtension = ems.getExtension();
		if (null == emsExtension){
			emsExtension = new FMap2();
			ems.setExtension(emsExtension);
		}
		emsExtension.put("DiInfo", v);
	}
	
	public static void SetMpDepFilter(EmsRstDTO ems, String v){
		FMap2 emsExtension = ems.getExtension();
		if (null == emsExtension){
			emsExtension = new FMap2();
			ems.setExtension(emsExtension);
		}
		emsExtension.put("MpDepFilter", v);
	}
	/**
	 * 设置主服务对象
	 * @param rst
	 * @param v
	 */
	public static void SetCustomInfo(EmsRstDTO rst, MedSrvDO v){
		FMap2 emsExtension = rst.getExtension();
		if (null == emsExtension){
			emsExtension = new FMap2();
			rst.setExtension(emsExtension);
		}
		emsExtension.put("MedSrvDO", v);
	}
	
	/**
	 * 设置医疗单对象
	 * @param rst
	 * @param v
	 */
	public static void SetCustomInfo(EmsRstDTO rst, CiEmsDTO v){
		FMap2 emsExtension = rst.getExtension();
		if (null == emsExtension){
			emsExtension = new FMap2();
			rst.setExtension(emsExtension);
		}
		emsExtension.put("CiEmsDTO", v);
	}
	
	
	public static void SetWhDepFilter(EmsRstDTO ems, String v){
		FMap2 emsExtension = ems.getExtension();
		if (null == emsExtension){
			emsExtension = new FMap2();
			ems.setExtension(emsExtension);
		}
		emsExtension.put("WhDepFilter", v);
	}
	
	public static void SetWhDepId(EmsRstDTO ems, String v){
		FMap2 emsExtension = ems.getExtension();
		if (null == emsExtension){
			emsExtension = new FMap2();
			ems.setExtension(emsExtension);
		}
		emsExtension.put("WhDepId", v);
	}
	
	public static void SetWhDepName(EmsRstDTO ems, String v){
		FMap2 emsExtension = ems.getExtension();
		if (null == emsExtension){
			emsExtension = new FMap2();
			ems.setExtension(emsExtension);
		}   
		emsExtension.put("WhDepName", v);
	}
	
	public static void SetDiFilter(EmsRstDTO ems, String v){
		FMap2 emsExtension = ems.getExtension();
		if (null == emsExtension){
			emsExtension = new FMap2();
			ems.setExtension(emsExtension);
		}
		emsExtension.put("DiFilter", v);
	}
	
	public static void SetDosagesFilter(EmsRstDTO ems, String v){
		FMap2 emsExtension = ems.getExtension();
		if (null == emsExtension){
			emsExtension = new FMap2();
			ems.setExtension(emsExtension);
		}
		emsExtension.put("DosagesFilter", v);
	}
	
	public static void SetSkinTestRstDTO(EmsRstDTO ems, SkinTestRstDTO v){
		FMap2 emsExtension = ems.getExtension();
		if (null == emsExtension){
			emsExtension = new FMap2();
			ems.setExtension(emsExtension);
		}
		emsExtension.put("SkinTestRstDTO", v);
	}
	public static void SetIsShowWarnInfo(EmsRstDTO ems, boolean v){
		FMap2 emsExtension = ems.getExtension();
		if (null == emsExtension){
			emsExtension = new FMap2();
			ems.setExtension(emsExtension);
		}
		emsExtension.put("IsShowWarnInfo", v);
	} 
	public static void SetSpecialDrugWarnInfo(EmsRstDTO ems, String v){
		FMap2 emsExtension = ems.getExtension();
		if (null == emsExtension){
			emsExtension = new FMap2();
			ems.setExtension(emsExtension);
		}
		emsExtension.put("SpecilDrugWarnInfo", v);
	} 
	
	/**
	 * 设置医疗单对象
	 * @param rst
	 * @param v
	 */
	public static void SetCustomInfo(EmsRstDTO rst, CiordubDTO v){
		FMap2 emsExtension = rst.getExtension();
		if (null == emsExtension){
			emsExtension = new FMap2();
			rst.setExtension(emsExtension);
		}
		emsExtension.put("CiordubDTO", v);
	}
}
