package iih.ci.ord.s.ems.biz.ip;

import java.util.ArrayList;
import java.util.List;

import iih.bd.mm.meterial.i.IMeterialRService;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.routedosage.i.IRoutedosageRService;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.ems.biz.base.EmsBaseAction;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.material.i.IMaterialStockService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsHerbsAction extends EmsBaseAction {


	@Override
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		List<EmsRstDTO> emsRsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO emsRst = new EmsRstDTO();

		CiEnContextDTO ctx = emsarray[0].getEnContext();

//		emsRst.setEmsType(EmsType.HERB);
		emsRsts.add(emsRst);
		return (EmsRstDTO[]) emsRsts.toArray(new EmsRstDTO[emsRsts.size()]);
	}

	
}
