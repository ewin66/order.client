package iih.ci.ord.s.ems.biz.op.emsv1.herbs.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.op.ems.drugs.bp.EmsDrugsCreateBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class EmsHerbsCreateBP extends EmsDrugsCreateBP {

	@Override
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		// TODO Auto-generated method stub
		EmsRstDTO[] rsts = super.create(emsarray);
		
		rsts[0].setEmsDriver(EmsType.HERB.toString());
		return rsts
				;
	}

	@Override
	protected EmsDrugItemDO emsModelFrom(MedSrvDO medSrv, CiEnContextDTO ctx) throws BizException {
		// TODO Auto-generated method stub
		EmsDrugItemDO emsDrugItem = super.emsModelFrom(medSrv, ctx);
		emsDrugItem.setName_boil(medSrv.getBoil_name());// 煎法名称
		emsDrugItem.setId_boil(medSrv.getId_boil()); // 煎法
		emsDrugItem.setOrders(7); // 医嘱付数
		emsDrugItem.setFg_boil(FBoolean.FALSE);// 代煎标识
		emsDrugItem.setOrders_boil(0);// 代煎付数
		return emsDrugItem;
	}
}
