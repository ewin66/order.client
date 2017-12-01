package iih.ci.ord.s.bp.ordfeebill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.hp.d.BdHpCtrDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmCudService;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.ems.CiOrDtLastBlCal4OpenBP;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class OrdFeeBillHandleBP {
	public CiEmsSrvDTO[] save(CiEmsSrvDTO[] szSrv, CiEnContextDTO ctx) throws BizException {
		ICiorderRService orservice = CiOrdAppUtils.getOrAggQryService();
		IOrdSrvDOCudService service = CiOrdAppUtils.getOrSrvService();
		IOrdsrvmmCudService mmservice = CiOrdAppUtils.getOrsrvmmService();
		Context context = CiOrdAppUtils.getEnvContext();
		CiorderAggDO[] aggs = orservice.findByBIds(getidors(szSrv), FBoolean.FALSE);
		if(aggs==null||aggs.length==0)return null;
		Map<String, CiorderAggDO> map=this.getAggDic(aggs);
		for (CiEmsSrvDTO srv : szSrv) {
			// 没有改变跳过、医嘱id为空跳过、医嘱id无效跳过
			CiorderAggDO agg = null;
			if (srv.getStatus() == DOStatus.UNCHANGED || StringUtils.isEmpty(srv.getId_or())||(!map.containsKey(srv.getId_or()))) {// ||null
																							// ==																							// (agg=orservice.findById(srv.getId_or()))){
				continue;
			}
			agg=map.get(srv.getId_or());
			//li_cheng 当医嘱为已签署时，不能进行补费
			if(agg.getParentDO().getFg_sign()==FBoolean.TRUE)continue;
			OrdSrvDO srvdo = new OrdSrvDO();
			srvdo.setId_or(srv.getId_or());
			// 新建
			if (srv.getId_orsrv() == null) {
				srvdo.setStatus(DOStatus.NEW);
				srvdo.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIANFEEADD);
				srv.setId_org_srv(context.getOrgId());
				srv.setId_dep_srv(context.getDeptId());
				srv.setId_emp_srv(context.getUserId());
			} else if (srv.getStatus() == DOStatus.UPDATED) {
				srvdo.setStatus(DOStatus.UPDATED);
				srvdo.setId_orsrv(srv.getId_orsrv());
				// 更新记录时候，找到正确的sv值
				for (OrdSrvDO orsrv : agg.getOrdSrvDO()) {
					if (orsrv.getId_orsrv().equals(srv.getId_orsrv())) {
						srvdo.setSv(orsrv.getSv());
						break;
					}
				}
			} else {
				srvdo.setStatus(DOStatus.DELETED);
				srvdo.setId_orsrv(srv.getId_orsrv());
				// 更新记录时候，找到正确的sv值
				for (OrdSrvDO orsrv : agg.getOrdSrvDO()) {
					if (orsrv.getId_orsrv().equals(srv.getId_orsrv())) {
						srvdo.setSv(orsrv.getSv());
						break;
					}
				}
			}
			// 装配转换模型
			handleOrSrvDO(srvdo, agg.getParentDO(), srv);
			// 保存服务项目
			OrdSrvDO[] srvs = service.save(new OrdSrvDO[] { srvdo });
			if (srvs != null) {
				srvdo = srvs[0];
				srv.setId_orsrv(srvdo.getId_orsrv());
			}

			// 是否为补录物品
			if (srv.getId_mm() != null && srv.getFg_mm().booleanValue()) {

				OrdSrvMmDO mmdo = new OrdSrvMmDO();
				if (srv.getId_orsrvmm() == null)
					mmdo.setStatus(DOStatus.NEW);
				else {
					mmdo.setStatus(DOStatus.UPDATED);
				}

				mmdo.setId_orsrv(srv.getId_orsrv());
				handleOrdSrvMmDO(mmdo, agg.getParentDO(), srv);
				OrdSrvMmDO[] ordm = mmservice.save(new OrdSrvMmDO[] { mmdo });
				mmdo = ordm[0];
				srv.setId_orsrvmm(mmdo.getId_orsrvmm());
			}
			srv.setStatus(DOStatus.UNCHANGED);
		}
		
		validateTotalFees(orservice.findByBIds(getidors(szSrv), FBoolean.FALSE),ctx.getEnt4BannerDTO());
		return szSrv;
	}

	protected void handleOrSrvDO(OrdSrvDO srvdo, CiOrderDO cider, CiEmsSrvDTO fee) throws BizException {

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
		srvdo.setId_srv_src(fee.getId_srv_src());
		srvdo.setQuan_medu(fee.getQuan_med());
		srvdo.setQuan_total_medu(fee.getQuan_total_medu());
		srvdo.setId_medu(fee.getId_unit_med());
		srvdo.setId_freq(cider.getId_freq());
		srvdo.setPri(fee.getPrice());
		srvdo.setId_dep_wh(fee.getId_dep_wh());
		srvdo.setId_hpsrvtp(fee.getId_hpsrvtp());
		srvdo.setId_hp(fee.getId_hp());
		srvdo.setSd_hpsrvtp(fee.getSd_hpsrvtp());
		srvdo.setFg_indic(fee.getFg_indic());
		srvdo.setFg_selfpay(fee.getFg_selfpay());
		srvdo.setFg_mm(fee.getFg_mm());
		if(fee.getFg_or()!=null){//by li_cheng  针对修改医保适应症的情况
			srvdo.setFg_or(fee.getFg_or());
		}else{
			srvdo.setFg_or(FBoolean.FALSE);
		}
			
		
		srvdo.setSd_su_bl("0");
		srvdo.setSd_su_mp("0");
		srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);  
		srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID); // 
		srvdo.setFg_bl(FBoolean.TRUE);
		srvdo.setId_route(fee.getId_route());
		srvdo.setId_routedes(fee.getId_routedes());
		srvdo.setId_org_srv(fee.getId_org_srv());
		srvdo.setId_dep_srv(fee.getId_dep_srv());
		srvdo.setId_emp_srv(fee.getId_emp_srv());
		srvdo.setId_primd(fee.getId_primd());
		srvdo.setFg_feertnable(FBoolean.TRUE);
		srvdo.setFg_base(fee.getFg_base());
		srvdo.setId_org_srv(fee.getId_org_srv());
		srvdo.setId_dep_srv(fee.getId_dep_srv());
		srvdo.setId_emp_srv(fee.getId_emp_srv());
		srvdo.setFg_hpindicjudged(fee.getFg_hpindicjudged());

		CiOrDtLastBlCal4OpenBP bp = new CiOrDtLastBlCal4OpenBP();

		FDateTime curtime = bp.exec(cider.getId_freq(), cider.getDt_effe(), cider.getQuan_firday_mp(), cider.getFg_long());
		srvdo.setDt_last_cg(curtime);
		srvdo.setDt_last_bl(curtime);
		String orgid = CiOrdAppUtils.getEnvContext().getOrgId(); // 组织id
		String depid = CiOrdAppUtils.getEnvContext().getDeptId(); // 组织id
		String grpid = CiOrdAppUtils.getEnvContext().getGroupId(); // 集团id
		srvdo.setId_org_mp(orgid);
		srvdo.setId_org(orgid);
		srvdo.setId_grp(grpid);
		if (fee.getId_dep() == null)
			srvdo.setId_dep_mp(depid);
		else {
			srvdo.setId_dep_mp(fee.getId_dep());
		}

		srvdo.setSortno(fee.getSortno());
	}

	protected void handleOrdSrvMmDO(OrdSrvMmDO mmdo, CiOrderDO cider, CiEmsSrvDTO fee) {

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

	}

	private String[] getidors(CiEmsSrvDTO[] srvs) {

		Map<String, Object> ormap = new HashMap<>();
		List<String> sb = new ArrayList<>();

		for (CiEmsSrvDTO ordSrvDO : srvs) {

			if (!ormap.containsKey(ordSrvDO.getId_or())) {

				ormap.put(ordSrvDO.getId_or(), new Object());

				sb.add(ordSrvDO.getId_or());
			}
		}

		return sb.toArray(new String[0]);

	}

	private Map<String, CiorderAggDO> getAggDic(CiorderAggDO[] aggs) {

		Map<String, CiorderAggDO> map=new HashMap<>();
		for (CiorderAggDO ciorderAggDO : aggs) {
			if(!map.containsKey(ciorderAggDO.getParentDO().getId_or())){
				map.put(ciorderAggDO.getParentDO().getId_or(), ciorderAggDO);
			}
		}
		return map;
	}


	private void validateTotalFees(CiorderAggDO[] szOrdAgg,Ent4BannerDTO banner) throws BizException{
		 
		if( banner != null && (banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) ||
				banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET))
				&& banner.getSd_hptp() != null && banner.getSd_hptp().startsWith("2")){
			//高端商保标志·
			//FBoolean IsHPcg = CiOrdAppUtils.getEnOutQryService().isHpcg(id_ent);
			 String id_hp = "id_hp ='"+banner.getId_hp()+"'";
			 BdHpCtrDO[] hpctr = CiOrdAppUtils.getIBdHpCtrDORService().find(id_hp, "", FBoolean.FALSE);
			if(hpctr != null &&  hpctr.length >0){
				BdHpCtrDO hpctrdo = hpctr[0];
				StringBuilder sb = new StringBuilder();
				for (CiorderAggDO ordAggInfo : szOrdAgg){
					if(hpctrdo.getOr_limit_amt() !=null && !hpctrdo.getOr_limit_amt().isTrimZero()){
						FDouble sumprice =  getSumPrice(ordAggInfo);
						if(Double.compare(sumprice.getDouble(), hpctrdo.getOr_limit_amt().getDouble()) >0){
							 //throw new BizException("医嘱的金额超出限制 "+hpctrdo.getOr_limit_amt().getDouble());
							 
							 sb.append(String.format("医嘱[%s]的金额超出限制 : %.2f。\n", ordAggInfo.getParentDO().getName_or(),hpctrdo.getOr_limit_amt().getDouble()));
						}
					}
				}
				if (sb.length() > 0){
					throw new BizException(sb.toString(),CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_TOTALFEE_OVERFLOW);
				}
			}
			
		}
	}
	/**
	 * 每条医嘱的总金额
	 * @param aggdo
	 * @return
	 * @throws BizException 
	 */
	private FDouble  getSumPrice(CiorderAggDO aggdo) throws BizException{
		IOrdsrvmmRService ordsrvmmRService = ServiceFinder.find(IOrdsrvmmRService.class);
		FDouble fSumPrice = FDouble.ZERO_DBL;
		if(aggdo != null && aggdo.getOrdSrvDO() != null && aggdo.getOrdSrvDO().length >0){
			 OrdSrvDO[] ordsrvDO = aggdo.getOrdSrvDO();
			
			 for(OrdSrvDO srvdo: ordsrvDO){
				if(srvdo.getFg_bl() == FBoolean.TRUE && 
						(srvdo.getEu_sourcemd()==OrSrvSourceFromEnum.PHYSIAN||
						srvdo.getEu_sourcemd() == OrSrvSourceFromEnum.AGENTFROMPRIMD||
						srvdo.getEu_sourcemd() == OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD) && 
						srvdo.getPri() != null ){
					
					if (srvdo.getFg_mm() == FBoolean.TRUE && null != ordsrvmmRService)
					{
						OrdSrvMmDO[] szOrdSrvMmDO = ordsrvmmRService.find(String.format(" id_orsrv ='%s'", srvdo.getId_orsrv()), "", FBoolean.FALSE);
						if (null != szOrdSrvMmDO && szOrdSrvMmDO.length != 0) {
							fSumPrice = fSumPrice.add(szOrdSrvMmDO[0].getPrice_pgku_cur().multiply(szOrdSrvMmDO[0].getQuan_cur()));
						}
					}
					else{
						if ( srvdo.getQuan_total_medu() != null){
							fSumPrice = fSumPrice.add(srvdo.getPri().multiply(srvdo.getQuan_total_medu()));
						}
					}
					 
				}
				 
			} 
		 }
	     return fSumPrice;
	}
}
