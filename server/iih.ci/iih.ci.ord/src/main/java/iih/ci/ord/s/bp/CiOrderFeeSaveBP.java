package iih.ci.ord.s.bp;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciordems.d.AddFeeDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmCudService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.ems.CiOrDtLastBlCal4OpenBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class CiOrderFeeSaveBP {
	private Integer _sourcein;

	public AddFeeDTO[] exe(String id_or, AddFeeDTO[] fees, Integer sourcein) throws BizException {
		this._sourcein = sourcein;
		ICiorderRService orservice = CiOrdAppUtils.getOrAggQryService();
		CiorderAggDO agg = orservice.findById(id_or);
		if (agg == null)
			return null;
		IOrdSrvDOCudService service = CiOrdAppUtils.getOrSrvService();
		IOrdsrvmmCudService mmservice = CiOrdAppUtils.getOrsrvmmService();
		for (AddFeeDTO fe : fees) {
			if (fe.getStatus() == DOStatus.UNCHANGED)
				continue;			
			if(fe.getQuan_med().compareTo(new FDouble(0))<=0)
				throw new BizException(fe.getName_srv()+"的剂量不能小于或等于0");
			OrdSrvDO srvdo = new OrdSrvDO();
			srvdo.setId_or(id_or);
			if (fe.getId_orsrv() == null) {
				srvdo.setStatus(DOStatus.NEW);
				srvdo.setEu_sourcemd(sourcein);
			} else if (fe.getStatus() == DOStatus.UPDATED) {
				srvdo.setStatus(DOStatus.UPDATED);
				srvdo.setId_orsrv(fe.getId_orsrv());

				for (OrdSrvDO orsrv : agg.getOrdSrvDO()) {
					if (orsrv.getId_orsrv().equals(fe.getId_orsrv())) {
						srvdo.setSv(orsrv.getSv());
					}
				}

			}
			setSrvDO(agg.getParentDO(), srvdo, fe);

			OrdSrvDO[] srvs = service.save(new OrdSrvDO[] { srvdo });
			srvdo = srvs[0];
			fe.setId_orsrv(srvdo.getId_orsrv());
			if (fe.getFg_mm() == FBoolean.TRUE && fe.getId_mm() != null) {
				OrdSrvMmDO mmdo = new OrdSrvMmDO();
				if (fe.getId_orsrvmm() == null)
					mmdo.setStatus(DOStatus.NEW);
				else {
					mmdo.setStatus(DOStatus.UPDATED);
				}

				mmdo.setId_orsrv(fe.getId_orsrv());
				setMmDo(agg.getParentDO(), mmdo, fe);
				OrdSrvMmDO[] ordm = mmservice.save(new OrdSrvMmDO[] { mmdo });
				mmdo = ordm[0];
				fe.setId_orsrvmm(mmdo.getId_orsrvmm());
			}

			fe.setStatus(DOStatus.UNCHANGED);
		}

		return fees;
	}

	private void setMmDo(CiOrderDO cider, OrdSrvMmDO mmdo, AddFeeDTO fee) {

		mmdo.setId_mm(fee.getId_mm());
		mmdo.setName_mm(fee.getName_mm());
		mmdo.setPrice_pgku_cur(fee.getPrice());
		mmdo.setId_pgku_cur(fee.getId_unit_sale());
		mmdo.setQuan_cur(fee.getQuan_cur());
		mmdo.setFactor_mb(fee.getFactor_mb());
		mmdo.setQuan_num_base(fee.getQuan_num_base());
		mmdo.setQuan_den_base(fee.getQuan_den_base());
		mmdo.setQuan_bed_medu(fee.getQuan_bed_medu());
		mmdo.setId_dosage(fee.getId_dosage());
		mmdo.setId_val(fee.getId_val());
		mmdo.setSd_pois(fee.getSd_pois());
		mmdo.setId_anti(fee.getId_anti());
		mmdo.setSd_anti(fee.getSd_anti());
		mmdo.setId_mmtp(fee.getId_mmtp());
		mmdo.setSd_mmtp(fee.getSd_mmtp());
		mmdo.setId_pgku_base(fee.getId_unit_base());
		mmdo.setFactor(fee.getFactor_cb());
		mmdo.setFg_otc(fee.getFg_otc());

	}

	private void setSrvDO(CiOrderDO cider, OrdSrvDO srvdo, AddFeeDTO fee) throws BizException {
		IMedsrvMDORService medsrv=ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO med=medsrv.findById(fee.getId_srv());
		srvdo.setInnercode_srvca(med.getSrvca_innercode());
		srvdo.setId_pat(cider.getId_pat());
		srvdo.setId_entp(cider.getId_entp());
		srvdo.setCode_entp(cider.getCode_entp());
		srvdo.setId_en(cider.getId_en());
		srvdo.setSd_srvtp(fee.getSd_srvtp());
		srvdo.setCode_srv(fee.getCode_srv());
		srvdo.setId_srvtp(fee.getId_srvtp());
		srvdo.setId_srvca(fee.getId_srvca());
		srvdo.setName(fee.getName_srv());
		srvdo.setId_srv(fee.getId_srv());
		srvdo.setQuan_medu(fee.getQuan_med());
		//医嘱确认和医嘱确认查询界面，草药补费项目，总量=剂量 张万青2017-3-10添加
//		if(!CiOrdUtils.isEmpty(cider.getSd_srvtp())&&cider.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
//			srvdo.setQuan_total_medu(srvdo.getQuan_medu());
//		}else{
			srvdo.setQuan_total_medu(fee.getQuan_total_medu());
//		}
		srvdo.setId_medu(fee.getId_unit_med());
		srvdo.setId_freq(cider.getId_freq());
		srvdo.setPri(fee.getPrice());
		srvdo.setId_dep_wh(fee.getId_dep_wh());
		srvdo.setId_hpsrvtp(fee.getId_hpsrvtp());
		srvdo.setFg_mm(fee.getFg_mm());
		srvdo.setFg_or(FBoolean.FALSE);
		srvdo.setSd_su_bl("0");
		srvdo.setSd_su_mp("0");
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID); // ICiDictCodeConst.SD_SU_MP_NONE_ID  "0001AA1000000004KRCA"
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID); // 
		srvdo.setFg_bl(FBoolean.TRUE);
		srvdo.setId_route(fee.getId_route());
		srvdo.setId_routedes(fee.getId_routedes());

		srvdo.setId_dep_srv(fee.getId_dep_srv());
		srvdo.setId_emp_srv(fee.getId_emp_srv());
		srvdo.setId_primd(fee.getId_primd());
		srvdo.setFg_feertnable(FBoolean.TRUE);
		srvdo.setFg_base(fee.getFg_base());
//		srvdo.setId_org_srv(fee.getId_org_srv());
//		srvdo.setId_dep_srv(fee.getId_dep_srv());
//		srvdo.setId_emp_srv(fee.getId_emp_srv());
        srvdo.setSortno(1000);
		CiOrDtLastBlCal4OpenBP bp = new CiOrDtLastBlCal4OpenBP();

		FDateTime curtime = bp.exec(cider.getId_freq(), cider.getDt_effe(), cider.getQuan_firday_mp(),
				cider.getFg_long());
		srvdo.setDt_last_cg(curtime);
		srvdo.setDt_last_bl(fee.getDt_last_bl() == null ? curtime : fee.getDt_last_bl());
		String orgid = CiOrdAppUtils.getEnvContext().getOrgId(); // 组织id
		String depid = CiOrdAppUtils.getEnvContext().getDeptId(); // 组织id
		String grpid = CiOrdAppUtils.getEnvContext().getGroupId(); // 集团id
		srvdo.setId_org_srv(orgid);
		srvdo.setId_dep_nur_srv(depid);
		srvdo.setId_org_mp(orgid);
		srvdo.setDt_create(fee.getDt_create_srv());//刘羽 要求加的
		srvdo.setId_org(orgid);
		srvdo.setId_grp(grpid);
		if (fee.getId_dep() == null)
			srvdo.setId_dep_mp(depid);
		else {
			srvdo.setId_dep_mp(fee.getId_dep());
		}
		// empid=CiOrdAppUtils.getEnvContext().getUserId(); //人员id
		// empid=CiOrdUtils.getPsnDocID(empid);
		// srvdo.

	}

}
