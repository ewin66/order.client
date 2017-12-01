package iih.ci.ord.s.ems.biz.utils;

import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.s.ems.biz.meta.DiagOutlineInfo;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class DiagInfoUtils {
	/**
	 * 处理诊断概要信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
    public static DiagOutlineInfo GetDiagOutLineInfo(String id_ent) throws BizException{
		String[] diagArray = ServiceFinder.find(ICiOrdQryService.class).getDiagArray(id_ent);
        if (diagArray != null)
        {
        	DiagOutlineInfo diagInfoMap = new DiagOutlineInfo();
    		diagInfoMap.setId_di(diagArray[7]); 
    		diagInfoMap.setId_diitm(diagArray[3]);
    		diagInfoMap.setName_diag(diagArray[4]);
    		diagInfoMap.setStr_code_di(diagArray[1]);
    		diagInfoMap.setStr_name_di(diagArray[0]);
    		diagInfoMap.put("Str_id_diitm", diagArray[2]);
    		return diagInfoMap;
        }
		return null;
	}
}
