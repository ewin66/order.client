package iih.ci.ord.s.bp;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.srv.mrctmca.d.docornur;
import iih.bd.srv.mrctmca.i.IMrctmcaMDORService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class GetCiMr4DiagTreatBP {
	/**
	 * 获取病历文书信息
	 * @throws BizException 
	 */
	public Map<String,FArrayList2> exe(String id_en,FDateTime start,FDateTime end) throws BizException{
		Map<String,FArrayList2> map=new HashMap<String, FArrayList2>();
		FArrayList2 fa1=new FArrayList2();
		FArrayList2 fa2=new FArrayList2();
		IMrctmcaMDORService caservice=ServiceFinder.find(IMrctmcaMDORService.class);
		ICiemrRService ciemservice=ServiceFinder.find(ICiemrRService.class);
		MrCtmCaDO[] mrcas=caservice.find(" code_entp='10' and docornur='"+docornur.DOCTOR+"'", null, FBoolean.FALSE);
		CiMrDO[] cimrs=ciemservice.find(" id_ent='"+id_en+"' and dt_rd>='"+start+"' and dt_rd<='"+end+"'", null, FBoolean.FALSE);
		if(mrcas!=null && mrcas.length>0)
		Collections.addAll(fa1, mrcas);
		if(cimrs!=null && cimrs.length>0)
		Collections.addAll(fa2, cimrs);
		map.put("CiMrDO", fa2);
		map.put("MrCtmCaDO", fa1);
		return map;
	}

}
