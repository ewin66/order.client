package iih.ci.ord.s.ems.biz.op.tmpl.std.ortmpl;


import java.util.HashMap;
import java.util.Map;

import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.ci.ord.d.ems.tmpl.TmplRstDTO;
import iih.ci.ord.d.ems.tmpl.TmplSaveDTO;
import iih.ci.ord.d.ems.tmpl.UiTmplModelDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.ems.biz.itf.bp.ITmplSaveBP;
import iih.ci.ord.s.ems.define.StringObjectMap;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.sf.core.util.ServiceFinder;

public class TmplSaveAction implements ITmplSaveBP {

	@Override
	public TmplRstDTO save(TmplSaveDTO arg) throws BizException {
		SrvMatchEmsParamDTO[] szSrvMatchEmsParamDTO = new SrvMatchEmsParamDTO[arg.getDocument().size()];
		int index = 0;
		StringObjectMap uiModelCache = new StringObjectMap();
		for (Object objInfo : arg.getDocument()){
			UiTmplModelDTO uiTmplInfo = (UiTmplModelDTO)objInfo;
			SrvMatchEmsParamDTO param = new SrvMatchEmsParamDTO();
			param.setCode_entp(arg.getEnContext().getCode_entp());
			param.setDt_or(CiOrdAppUtils.getServerDateTime());
			param.setId_dept(arg.getEnContext().getId_dep_or());
			param.setId_emp(arg.getEnContext().getId_emp_or());
			param.setId_grp(arg.getEnContext().getId_grp());
			param.setId_org(arg.getEnContext().getId_org());
			param.setId_srv(uiTmplInfo.getId_srv());
			param.setSd_srvtp(uiTmplInfo.getSd_srvtp());
			szSrvMatchEmsParamDTO[index++] = param;
			uiModelCache.put(uiTmplInfo.getId_srv(), uiTmplInfo);
		}
		Map<String,FArrayList> tmpGroupMap = new HashMap<String,FArrayList>();
		FMap rstMap = ServiceFinder.find(IEmsManagementService.class).medSrvMatchEms(szSrvMatchEmsParamDTO);
		for (String id_srv : rstMap.keySet()){
			SrvMatchEmsRstDTO srvMatchEmsRstDTO = (SrvMatchEmsRstDTO)rstMap.get(id_srv);
			if (!tmpGroupMap.containsKey(srvMatchEmsRstDTO.getFuncclassstr())){
				tmpGroupMap.put(srvMatchEmsRstDTO.getFuncclassstr(), new FArrayList());
			}
			tmpGroupMap.get(srvMatchEmsRstDTO.getFuncclassstr()).add(uiModelCache.get(id_srv));
		}
		// 处理分组
//		IOrderEmsDriver drv = EmsDriverFactory.GetInstance().find(arg.getEmsDriver());
//		if (null != drv){
//			return drv.save(arg);
//			}
		return null;
	}

}
