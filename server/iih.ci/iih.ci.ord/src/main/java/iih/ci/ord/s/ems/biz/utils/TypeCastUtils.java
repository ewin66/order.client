package iih.ci.ord.s.ems.biz.utils;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.FArrayList;

public class TypeCastUtils {

	public static <T> T Cast(Object obj){
		return (T)obj;
	}
	
	
	
	public static  CiEmsSrvDTO[] Cast(FArrayList listObj){
		CiEmsSrvDTO[] szCiEmsSrvDTO = new CiEmsSrvDTO[listObj.size()];
		int index = 0;
		for (Object o : listObj){
			szCiEmsSrvDTO[index++] = (CiEmsSrvDTO)o;
		}
		return szCiEmsSrvDTO;
	}
	
	
}
