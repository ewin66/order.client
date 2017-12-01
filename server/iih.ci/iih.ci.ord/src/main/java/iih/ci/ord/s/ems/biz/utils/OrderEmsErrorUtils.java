package iih.ci.ord.s.ems.biz.utils;

import iih.ci.ord.d.ems.ems.EmsRstDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;

public class OrderEmsErrorUtils {
	/**
	 * 设置返回结果错误信息
	 * @param ems
	 * @param msg
	 */
	public static void SetErrMsg(EmsRstDTO ems, String v){
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
}
