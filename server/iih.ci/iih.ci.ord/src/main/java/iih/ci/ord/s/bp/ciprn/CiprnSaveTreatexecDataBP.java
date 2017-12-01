package iih.ci.ord.s.bp.ciprn;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.app.d.CiAppTreatExecDO;
import iih.ci.ord.app.d.CiAppTreatExecOrDO;
import iih.ci.ord.app.d.CiapptreatexecAggDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.bp.ciprn.qry.GetTreateExecIdorQry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;

public class CiprnSaveTreatexecDataBP {

	/**
	 * 执行
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String[] idors, String Id_hp, String Sd_hptp) throws BizException {
		if (idors == null || idors.length <= 0)
			return FBoolean.TRUE;
		CiOrderDO[] orderDOs = getNewPrintData(idors);
		if (orderDOs == null || orderDOs.length == 0)
			return null;
		List<CiapptreatexecAggDO> aggDOs = getCiapptreatexecAggDOs(orderDOs, Id_hp, Sd_hptp);
		if (aggDOs == null || aggDOs.size() == 0)
			return null;
		CiapptreatexecAggDO[] result = CiprnUtils.SaveCiapptreatexecAggDO(aggDOs.toArray(new CiapptreatexecAggDO[aggDOs.size()]));
		return result != null ? FBoolean.TRUE : FBoolean.FALSE;
	}

	/**
	 * 获取需要打印的所有数据（未打过的）
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO[] getNewPrintData(String[] idors) throws BizException {
		if (idors == null || idors.length <= 0)
			return null;
		List<String> lstIdors = new ArrayList<String>();
		String strIdors = "";
		for (String idor : idors) {
			lstIdors.add(idor);
			strIdors += ",'" + idor + "'";
		}
		ITransQry qry = new GetTreateExecIdorQry(strIdors.substring(1));
		CiAppTreatExecOrDO[] treatExecOrDOs = (CiAppTreatExecOrDO[]) AppFwUtil.getDORstWithDao(qry, CiAppTreatExecOrDO.class);

		if (treatExecOrDOs != null && treatExecOrDOs.length > 0) {
			for (CiAppTreatExecOrDO treatExecOrDO : treatExecOrDOs) {
				//去除已打印的
				if (lstIdors.contains(treatExecOrDO.getId_or()))
					lstIdors.remove(treatExecOrDO.getId_or());
			}
		}
		CiOrderDO[] orderDOs = CiprnUtils.GetCiOrderDOByIds(lstIdors.toArray(new String[lstIdors.size()]));
		return orderDOs;
	}

	/**
	 * 保存
	 * @param orderDOs
	 * @param Id_hp
	 * @param Sd_hptp
	 * @return
	 * @throws BizException
	 */
	private List<CiapptreatexecAggDO> getCiapptreatexecAggDOs(CiOrderDO[] orderDOs, String Id_hp, String Sd_hptp)
			throws BizException {
		List<CiapptreatexecAggDO> aggDOs = new ArrayList<CiapptreatexecAggDO>();
		
		String[] idors = new String[orderDOs.length];
		for (int i = 0; i < orderDOs.length; i++) {
			idors[i] = orderDOs[i].getId_or();
		}
		OrdSrvDO[] srvDOs = CiprnUtils.GetOrdSrvDOByIdor(idors);
		Map<String, List<OrdSrvDO>> mapOrdSrvDOs = new HashMap<String, List<OrdSrvDO>>();
		String strIdorsrvs = "";
		for (OrdSrvDO srvDO : srvDOs) {
			if (mapOrdSrvDOs.containsKey(srvDO.getId_or())) {
				mapOrdSrvDOs.get(srvDO.getId_or()).add(srvDO);
			} else {
				List<OrdSrvDO> lst = new ArrayList<OrdSrvDO>();
				lst.add(srvDO);
				mapOrdSrvDOs.put(srvDO.getId_or(), lst);
			}
			strIdorsrvs += ",'" + srvDO.getId_orsrv() + "'";
		}
		
		IOrdsrvmmRService srvmmRService = ServiceFinder.find(IOrdsrvmmRService.class);
		OrdSrvMmDO[] ordSrvMmDOs = srvmmRService.find(" id_orsrv in (" + strIdorsrvs.substring(1) + ")", null,
				FBoolean.FALSE);
		Map<String, List<OrdSrvMmDO>> mapOrdSrvMmDOs = new HashMap<String, List<OrdSrvMmDO>>();
		if (ordSrvMmDOs != null && ordSrvMmDOs.length > 0) {
			for (OrdSrvMmDO ordSrvMmDO : ordSrvMmDOs) {
				if (mapOrdSrvMmDOs.containsKey(ordSrvMmDO.getId_orsrv())) {
					mapOrdSrvMmDOs.get(ordSrvMmDO.getId_orsrv()).add(ordSrvMmDO);
				} else {
					List<OrdSrvMmDO> lst = new ArrayList<OrdSrvMmDO>();
					lst.add(ordSrvMmDO);
					mapOrdSrvMmDOs.put(ordSrvMmDO.getId_orsrv(), lst);
				}
			}
		}
		
		//第一次打印的单据(新增)
		for (CiOrderDO orderDO : orderDOs) {
			CiapptreatexecAggDO aggDO = new CiapptreatexecAggDO();
			CiAppTreatExecDO treatExecDO = new CiAppTreatExecDO();
			List<CiAppTreatExecOrDO> lstTreatExecOrDOs = new ArrayList<CiAppTreatExecOrDO>();

			CiAppTreatExecOrDO treatExecOrDO = new CiAppTreatExecOrDO();
			
			FDouble amtall = new FDouble("0.00");
			for (OrdSrvDO srv : mapOrdSrvDOs.get(orderDO.getId_or())) {
				//业务金额
				FDouble amt = new FDouble("0.00");
				if (srv.getFg_bl().equals(FBoolean.TRUE)) {
					if (srv.getFg_mm().equals(FBoolean.TRUE)) {
						List<OrdSrvMmDO> srvMmDOs = mapOrdSrvMmDOs.get(srv.getId_orsrv());
						if (srvMmDOs != null && srvMmDOs.size() > 0) {
							if (srvMmDOs.get(0).getQuan_cur() != null && srvMmDOs.get(0).getPrice_pgku_cur() != null) {
								amt = srvMmDOs.get(0).getQuan_cur().multiply(srvMmDOs.get(0).getPrice_pgku_cur());
							}
						}
					} else {
						if (srv.getQuan_total_medu() != null && srv.getPri() != null) {
							amt = srv.getQuan_total_medu().multiply(srv.getPri());
						}
					}
				}
				amtall.add(amt);
			}
			treatExecOrDO.setId_or(orderDO.getId_or());
			treatExecOrDO.setAmt_or(amtall);
			treatExecOrDO.setStatus(DOStatus.NEW);
			lstTreatExecOrDOs.add(treatExecOrDO);

			treatExecDO.setId_group(orderDO.getId_grp());
			treatExecDO.setId_org(orderDO.getId_org());
			treatExecDO.setId_pat(orderDO.getId_pat());
			treatExecDO.setId_entp(orderDO.getId_entp());
			treatExecDO.setCode_entp(orderDO.getCode_entp());
			treatExecDO.setId_en(orderDO.getId_en());
			treatExecDO.setFg_bb(orderDO.getFg_bb());
			treatExecDO.setNo_bb(orderDO.getNo_bb());
//			treatExecDO.setCode_app(CiOrdUtils.generateTreatPrintNo(orderDO.getId_en()));
			treatExecDO.setName_app("门诊注射治疗单");
			treatExecDO.setId_apptreatexectp(IBdSrvDictCodeConst.SD_APPTREATEXECTP_INJECTION_ID);
			treatExecDO.setSd_apptreatexectp(IBdSrvDictCodeConst.SD_APPTREATEXECTP_INJECTION);
			treatExecDO.setId_dep_mp(orderDO.getId_dep_mp());
			treatExecDO.setId_emp_app(orderDO.getId_emp_sign());
			treatExecDO.setId_org_app(orderDO.getId_org_or());
			treatExecDO.setId_dep_app(orderDO.getId_dep_sign());
			treatExecDO.setDt_app(orderDO.getDt_sign());
			treatExecDO.setStr_name_di(CiprnUtils.GetStr_name_di(orderDO.getId_en()));
			treatExecDO.setFg_prn(FBoolean.FALSE);
			treatExecDO.setCnt_prn(0);
			treatExecDO.setFg_hecominsur(CiEnContextUtil.isHeComInsurPat(Id_hp, Sd_hptp) ? FBoolean.TRUE
					: FBoolean.FALSE);
			//			treatExecDO.setHecominsurinfo(Hecominsurinfo);
			//			treatExecDO.setFg_hp(orderDO.getFg_hp());
			treatExecDO.setFg_prepay(orderDO.getFg_prepay());
			treatExecDO.setFg_vip(orderDO.getFg_vip());
			//			treatExecDO.setFg_hpbirth(orderDO.getFg_hpbirth());
			//			treatExecDO.setResearchinfo(orderDO.getResearchinfo());
			//			treatExecDO.setFg_opspecial(orderDO.getFg_opspecial());
			treatExecDO.setFg_blsettled(FBoolean.FALSE);
			treatExecDO.setStatus(DOStatus.NEW);

			aggDO.setParentDO(treatExecDO);
			aggDO.setCiAppTreatExecOrDO(lstTreatExecOrDOs.toArray(new CiAppTreatExecOrDO[lstTreatExecOrDOs.size()]));
			aggDOs.add(aggDO);
		}
		return aggDOs;
	}
}
