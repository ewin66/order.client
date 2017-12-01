package iih.ci.ord.s.ems.biz.ip;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.cache.CiTimerCache;
import iih.bd.srv.dto.d.EmsDynamicParamDTO;
import iih.bd.srv.ems.d.EmsDynamicIndexDTO;
import iih.bd.srv.ems.d.EmsregistryAggDO;
import iih.bd.srv.ems.i.IEmsregistryRService;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvOpDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvOpDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.ciordems.d.EmsOpitemDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.d.ems.ems.EmsSaveDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsOpsAction extends EmsBaseAction {
	@Override
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		EmsRstDTO[] rsts = super.create(emsarray);
		// 获取主服务信息
		MedsrvAggDO aggDO = getMedSrvInfo(emsarray[0].getId_srv());
		if (aggDO == null){
			throw new BizException("查询主服务信息失败！");
		}
		// 合成主UI模型对象
		EmsOpitemDO emsModel = null;
		
		
	
//		rst.setEmsType(EmsType.OPER);
		return rsts;
	}

	@Override
	public EmsRstDTO save(EmsSaveDTO ems) throws BizException {
		// TODO Auto-generated method stub
		return super.save(ems);
	}
	
	
}
