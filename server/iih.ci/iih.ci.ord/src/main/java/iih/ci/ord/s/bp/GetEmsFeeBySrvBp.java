package iih.ci.ord.s.bp;

import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.pp.primd.d.PrimdDO;
import iih.bd.pp.primd.i.IPrimdRService;
import iih.ci.ord.ciordems.d.AddFeeDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class GetEmsFeeBySrvBp {

	public AddFeeDTO exec(AddFeeDTO fee, OrWfExDeptParamDTO param)
			throws BizException {

		ICiOrdQryService qryservice = ServiceFinder
				.find(ICiOrdQryService.class);

		IMeterialMDORService service = ServiceFinder
				.find(IMeterialMDORService.class);
		if (fee.getFg_mm() == FBoolean.TRUE) {
			MeterialDO[] mms = service.find(MeterialDODesc.TABLE_ALIAS_NAME
					+ " .id_srv  = '" + fee.getId_srv() + "'", null,
					FBoolean.TRUE);
			if (mms.length > 0) {
				fee.setId_mm(mms[0].getId_mm());
				fee.setName_mm(mms[0].getName());
				fee.setSpec_mm(mms[0].getSpec());
				fee.setId_unit_base(mms[0].getId_unit_pkgbase());
				fee.setId_unit_sale(mms[0].getId_unit_pkgsp());
				fee.setId_unit_med(mms[0].getId_unit_med());
				fee.setPrice(mms[0].getPrice());
				fee.setFactor_mb(mms[0].getFactor_mb());
				fee.setFactor_cb(mms[0].getFactor_sb());

			}

		}
		IPrimdRService priservice = ServiceFinder.find(IPrimdRService.class);
		PrimdDO pri = priservice.findById(fee.getId_primd());
		if (pri.getCode().equals("00")) {

			// 本服务定价

			FDouble pv = CiOrdAppUtils.getPriCalService().CalSingleSrvStdPrice(
					fee.getId_srv());
			fee.setPrice(pv);

		} else if (pri.getCode().equals("04")) {

		} else if (pri.getCode().equals("99")) {

		}
//		if (drug.getId_hpsrvtp() != null) {
//			String sql = "select * from bd_udidoc u  where u.id_udidoc='"
//					+ drug.getId_hpsrvtp() + "'  ";
//			DAFacade da = new DAFacade();
//			UdidocDO udi = (UdidocDO) da.execQuery(sql, new BeanHandler(
//					UdidocDO.class));
//			if (udi != null)
//				drug.setName_heath(udi.getName());
//		}
		param.setId_mm(fee.getId_mm());
		OrWfDeptInfoDTO ow = qryservice.getExeDepts4CiOrSrvN(param);

		if (ow != null) {
			// ow.getOrwfexedepts();
			// ow.getPharmwfwhdepts();
			if (ow.getOrwfexedepts().size() > 0) {
				OrWfExDeptDTO orwf = (OrWfExDeptDTO) ow.getOrwfexedepts()
						.get(0);
				fee.setId_dep(orwf.getId_dept());// = ow[0].Id_dept;
				fee.setName_dep(orwf.getName_dept());
			}
			if(ow.getPharmwfwhdepts().size()>0){
				
				OrWfExDeptDTO orwf = (OrWfExDeptDTO) ow.getOrwfexedepts()
						.get(0);
				fee.setId_dep_wh(orwf.getId_dept());
			}
			

		}
		return fee;
	}

}
