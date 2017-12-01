package iih.ci.ord.s.ems.biz.ip;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.cache.CiTimerCache;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialRService;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.routedosage.d.RouteDosageRefDO;
import iih.bd.srv.routedosage.i.IRoutedosageRService;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.dto.d.SkinTestParamDTO;
import iih.ci.ord.dto.d.SkinTestRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.hp.HpService;
import iih.ci.ord.hp.HpService.MedSrvHpParam;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.GetOrderBP;
import iih.ci.ord.s.bp.qry.CiorderDrugQry;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 普通药品医疗单处理逻辑
 * @author wangqingzhu
 *
 */
public class EmsCommDrugAction extends EmsBaseAction {

	
	@Override
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		List<EmsRstDTO> emsRsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO emsRst = new EmsRstDTO();

		CiEnContextDTO ctx = emsarray[0].getEnContext();

		

//		emsRst.setEmsType(EmsType.COMMONDRUG);
	
		emsRsts.add(emsRst);
		return (EmsRstDTO[]) emsRsts.toArray(new EmsRstDTO[emsRsts.size()]);
	}

	
}
