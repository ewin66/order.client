package iih.ci.ord.s.ems.biz.ip;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.i.ICiorappbtRService;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.d.ems.ems.EmsSaveDTO;
import iih.ci.ord.dto.d.CiordubDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsApBuAction extends EmsApBtAction {
	@Override
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		// TODO Auto-generated method stub
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO rst = new EmsRstDTO();
		// 获取主服务信息
		MedsrvAggDO aggDO = getMedSrvInfo(emsarray[0].getId_srv());
		
		if(CiOrdUtils.isEmpty(emsarray[0].getExtension().get("CustomInfo"))){
			throw new BizException ("用血模板为空，开用血医疗单失败");
		}
		
		
		
		
		rst.setEmsDriver(EmsType.BTUSE.toString());
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

	
	@Override
	public EmsRstDTO save(EmsSaveDTO ems) throws BizException {
		// TODO Auto-generated method stub
		return super.save(ems);
	}

	
	
}
