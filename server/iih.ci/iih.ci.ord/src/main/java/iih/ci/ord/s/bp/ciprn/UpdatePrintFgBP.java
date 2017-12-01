package iih.ci.ord.s.bp.ciprn;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppLisSheetOrDO;
import iih.ci.ord.app.d.CiAppPathgySheetDO;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.CiAppTreatExecDO;
import iih.ci.ord.app.d.CiAppTreatExecOrDO;
import iih.ci.ord.app.i.ICiAppLisSheetOrDORService;
import iih.ci.ord.app.i.ICiAppTreatExecOrDORService;
import iih.ci.ord.app.i.ICiapplissheetMDOCudService;
import iih.ci.ord.app.i.ICiapplissheetMDORService;
import iih.ci.ord.app.i.ICiapppathgysheetMDOCudService;
import iih.ci.ord.app.i.ICiapppathgysheetMDORService;
import iih.ci.ord.app.i.ICiapprissheetCudService;
import iih.ci.ord.app.i.ICiapprissheetRService;
import iih.ci.ord.app.i.ICiapptreatexecMDOCudService;
import iih.ci.ord.app.i.ICiapptreatexecMDORService;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.cior.i.ICiorappbtMDOCudService;
import iih.ci.ord.cior.i.ICiorappbtMDORService;
import iih.ci.ord.cior.i.ICiorappbuCudService;
import iih.ci.ord.cior.i.ICiorappbuRService;
import iih.ci.ord.cior.i.ICiorappconsultMDOCudService;
import iih.ci.ord.cior.i.ICiorappconsultMDORService;
import iih.ci.ord.cior.i.ICiorappsurgeryMDOCudService;
import iih.ci.ord.cior.i.ICiorappsurgeryMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciprn.d.CiPrnDO;
import iih.ci.ord.ciprn.d.CiPrnItmDO;
import iih.ci.ord.ciprn.i.ICiPrnItmDORService;
import iih.ci.ord.ciprn.i.ICiprintMDOCudService;
import iih.ci.ord.ciprn.i.ICiprintMDORService;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pres.i.IPresCudService;
import iih.ci.ord.pres.i.IPresRService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class UpdatePrintFgBP {

	/**
	 * 更新单据打印信息
	 * 
	 * @param mapprnids
	 * @param fg_prn
	 * @return
	 * @throws BizException
	 */
	public void exe(FMap2 mapprnids) throws BizException {
		if (mapprnids == null)
			return;
		for (Entry<String, Object> item : mapprnids.entrySet()) {
			String strids = item.getValue().toString();
			if (strids.isEmpty())
				continue;
			String[] ids = strids.split(",");
			switch (item.getKey()) {
			case ICiDictCodeConst.SD_CIPRNSHEETTP_POISPRES://010101 毒麻处方
			case ICiDictCodeConst.SD_CIPRNSHEETTP_WESTPRES://010102 西药处方
			case ICiDictCodeConst.SD_CIPRNSHEETTP_HERBPRES://010103 草药处方
				updateCiPresPrnInfo(ids);
				break;
			case ICiDictCodeConst.SD_CIPRNSHEETTP_RISAPP://010201检查申请单
				updateRISAppPrnInfo("'" + strids.replaceAll(",", "','") + "'");
				updatePathgyAppPrnInfo("'" + strids.replaceAll(",", "','") + "'");
				break;
			case ICiDictCodeConst.SD_CIPRNSHEETTP_LISAPP://010202检验申请单
				updateLISAppPrnInfo("'" + strids.replaceAll(",", "','") + "'");
				break;
			case ICiDictCodeConst.SD_CIPRNSHEETTP_TREATAPP://010203诊疗申请单
			case ICiDictCodeConst.SD_CIPRNSHEETTP_INJECAPP://010301 注射治疗单
				updateTreatExecInfo(ids);
				break;
			case ICiDictCodeConst.SD_CIPRNSHEETTP_BTAPP://010204输血申请单
				setBTAppPrnInfo(ids);
				break;
			case ICiDictCodeConst.SD_CIPRNSHEETTP_BTUSEAPP://010205取血申请单
				setBTUSEAppPrnInfo(ids);
				break;
			case ICiDictCodeConst.SD_CIPRNSHEETTP_OPAPP://010206手术申请单
				setOPAppPrnInfo(ids);
				break;
			case ICiDictCodeConst.SD_CIPRNSHEETTP_COSTBILL://010302 门诊费用清单
				updateCostBillPrnInfo(ids);
				break;
			}
		}
	}

	public void exe(String[] ids, String sd_cirpnsheettp) throws BizException {
		switch (sd_cirpnsheettp) {
		case ICiDictCodeConst.SD_CIPRNSHEETTP_POISPRES://010101 毒麻处方
		case ICiDictCodeConst.SD_CIPRNSHEETTP_WESTPRES://010102 西药处方
		case ICiDictCodeConst.SD_CIPRNSHEETTP_HERBPRES://010103 草药处方
			updateCiPresPrnInfo(ids);
			break;
		case ICiDictCodeConst.SD_CIPRNSHEETTP_RISAPP://010201检查申请单
			updateRISAppPrnInfo(ids);
			updatePathgyAppPrnInfo(ids);
			break;
		case ICiDictCodeConst.SD_CIPRNSHEETTP_LISAPP://010202检验申请单
			updateLISAppPrnInfo(ids);
			break;
		case ICiDictCodeConst.SD_CIPRNSHEETTP_TREATAPP://010203诊疗申请单
		case ICiDictCodeConst.SD_CIPRNSHEETTP_INJECAPP://010301 注射治疗单
			updateTreatExecInfo(ids);
			break;
		case ICiDictCodeConst.SD_CIPRNSHEETTP_BTAPP://010204输血申请单
			setBTAppPrnInfo(ids);
			break;
		case ICiDictCodeConst.SD_CIPRNSHEETTP_BTUSEAPP://010205取血申请单
			setBTUSEAppPrnInfo(ids);
			break;
		case ICiDictCodeConst.SD_CIPRNSHEETTP_OPAPP://010206手术申请单
			setOPAppPrnInfo(ids);
			break;
		case ICiDictCodeConst.SD_CIPRNSHEETTP_COSTBILL://010302 门诊费用清单
			updateCostBillPrnInfo(ids);
			break;
		}
	}

	/**
	 * 更新处方单据打印信息
	 * 
	 * @param presids
	 * @return
	 * @throws BizException
	 */
	private void updateCiPresPrnInfo(String[] presids) throws BizException {
		IPresRService presrservice = ServiceFinder.find(IPresRService.class);
		CiPresDO[] presDos = presrservice.findByBIds(presids, FBoolean.FALSE);
		for (int i = 0; i < presDos.length; i++) {
			presDos[i].setStatus(DOStatus.UPDATED);
			presDos[i].setFg_prn(FBoolean.TRUE);
			if (presDos[i].getCnt_prn() == null) {
				presDos[i].setCnt_prn(0);
			}
			presDos[i].setCnt_prn(presDos[i].getCnt_prn() + 1);
		}
		IPresCudService pressaveservice = ServiceFinder.find(IPresCudService.class);
		pressaveservice.save(presDos);
	}

	/**
	 * 更新检查申请单据打印信息
	 * @param strids
	 * @throws BizException
	 */
	private void updateRISAppPrnInfo(String strids) throws BizException {
		ICiapprissheetRService risrservice = ServiceFinder.find(ICiapprissheetRService.class);
		CiAppRisSheetDO[] rissheets = risrservice.find(" id_or in (" + strids + ")", "", FBoolean.FALSE);
		updateRISAppPrnInfo(rissheets);
	}

	/**
	 * 更新检查申请单据打印信息
	 * 
	 * @param rissheetids
	 * @throws BizException
	 */
	private void updateRISAppPrnInfo(String[] rissheetids) throws BizException {
		ICiapprissheetRService risrservice = ServiceFinder.find(ICiapprissheetRService.class);
		CiAppRisSheetDO[] rissheets = risrservice.findByBIds(rissheetids, FBoolean.FALSE);
		updateRISAppPrnInfo(rissheets);
	}
	
	/**
	 * 更新检查申请单据打印信息
	 * @param rissheets
	 * @throws BizException
	 */
	private void updateRISAppPrnInfo(CiAppRisSheetDO[] rissheets) throws BizException {
		if (rissheets == null || rissheets.length == 0)
			return;
		List<CiAppRisSheetDO> updatelist = new ArrayList<CiAppRisSheetDO>();
		for (CiAppRisSheetDO risdo : rissheets) {
			if (risdo.getFg_prn().booleanValue()) {
				risdo.setCnt_prn(risdo.getCnt_prn() + 1);
			} else {
				risdo.setFg_prn(FBoolean.TRUE);
				risdo.setCnt_prn(1);
			}
			risdo.setStatus(DOStatus.UPDATED);
			updatelist.add(risdo);
		}
		if (updatelist.size() != 0) {
			ICiapprissheetCudService riscudservice = ServiceFinder.find(ICiapprissheetCudService.class);
			riscudservice.save(updatelist.toArray(new CiAppRisSheetDO[updatelist.size()]));
		}
	}
	
	/**
	 * 更新病理申请单据打印信息
	 * @param strids
	 * @throws BizException
	 */
	private void updatePathgyAppPrnInfo(String strids) throws BizException {
		ICiapppathgysheetMDORService service = ServiceFinder.find(ICiapppathgysheetMDORService.class);
		CiAppPathgySheetDO[] pathgysheets = service.find(" id_or in (" + strids + ")", "", FBoolean.FALSE);
		updatePathgyAppPrnInfo(pathgysheets);
	}
	
	/**
	 * 更新病理申请单据打印信息
	 * @param pathgysheetids
	 * @throws BizException
	 */
	private void updatePathgyAppPrnInfo(String[] pathgysheetids) throws BizException {
		ICiapppathgysheetMDORService service = ServiceFinder.find(ICiapppathgysheetMDORService.class);
		CiAppPathgySheetDO[] pathgysheets=service.findByBIds(pathgysheetids, FBoolean.FALSE);
		updatePathgyAppPrnInfo(pathgysheets);
	}
	
	/**
	 * 更新病理申请单据打印信息
	 * @param pathgysheets
	 * @throws BizException
	 */
	private void updatePathgyAppPrnInfo(CiAppPathgySheetDO[] pathgysheets) throws BizException {
		if (pathgysheets == null || pathgysheets.length == 0)
			return;
		List<CiAppPathgySheetDO> updatelist = new ArrayList<CiAppPathgySheetDO>();
		for (CiAppPathgySheetDO pathgydo : pathgysheets) {
			if (pathgydo.getFg_prn().booleanValue()) {
				pathgydo.setCnt_prn(pathgydo.getCnt_prn() + 1);
			} else {
				pathgydo.setFg_prn(FBoolean.TRUE);
				pathgydo.setCnt_prn(1);
			}
			pathgydo.setStatus(DOStatus.UPDATED);
			updatelist.add(pathgydo);
		}
		if (updatelist.size() != 0) {
			ICiapppathgysheetMDOCudService service = ServiceFinder.find(ICiapppathgysheetMDOCudService.class);
			service.save(updatelist.toArray(new CiAppPathgySheetDO[updatelist.size()]));
		}
	}

	/**
	 * 更新检验申请单据打印信息
	 * @param strids
	 * @throws BizException
	 */
	private void updateLISAppPrnInfo(String strids) throws BizException {
		ICiAppLisSheetOrDORService service = ServiceFinder.find(ICiAppLisSheetOrDORService.class);
		CiAppLisSheetOrDO[] lisSheetOrDOs = service.find(
				" a1.id_or in (" + strids + ")", null, FBoolean.FALSE);
		if(lisSheetOrDOs==null||lisSheetOrDOs.length<=0)return;
		List<String> lstids=new ArrayList<String>();
		for(CiAppLisSheetOrDO lisSheetOrDO:lisSheetOrDOs){
			if(!lstids.contains(lisSheetOrDO.getId_ciapplissheet()))
				lstids.add(lisSheetOrDO.getId_ciapplissheet());
		}
		updateLISAppPrnInfo(lstids.toArray(new String[lstids.size()]));
	}
	
	/**
	 * 更新检验申请单据打印信息
	 * 
	 * @param lissheetids
	 * @return
	 * @throws BizException
	 */
	private void updateLISAppPrnInfo(String[] lissheetids) throws BizException {
		ICiapplissheetMDORService lisrservice = ServiceFinder.find(ICiapplissheetMDORService.class);
		CiAppLisSheetDO[] lissheets = lisrservice.findByBIds(lissheetids, FBoolean.FALSE);
		updateLISAppPrnInfo(lissheets);
	}
	
	/**
	 * 更新检验申请单据打印信息
	 * @param lissheets
	 * @throws BizException
	 */
	private void updateLISAppPrnInfo(CiAppLisSheetDO[] lissheets) throws BizException {
		if (lissheets == null || lissheets.length == 0)
			return;
		List<CiAppLisSheetDO> updatelist = new ArrayList<CiAppLisSheetDO>();
		for (CiAppLisSheetDO lisdo : lissheets) {
			if (lisdo.getFg_prn().booleanValue()) {
				lisdo.setCnt_prn(lisdo.getCnt_prn() + 1);
			} else {
				lisdo.setFg_prn(FBoolean.TRUE);
				lisdo.setCnt_prn(1);
			}
			lisdo.setStatus(DOStatus.UPDATED);
			updatelist.add(lisdo);
		}
		if (updatelist.size() != 0) {
			ICiapplissheetMDOCudService liscudservice = ServiceFinder.find(ICiapplissheetMDOCudService.class);
			liscudservice.save(updatelist.toArray(new CiAppLisSheetDO[updatelist.size()]));
		}
	}

	/**
	 * 保存手术申请单据打印信息
	 * 
	 * @param ciorderids
	 * @return
	 * @throws BizException
	 */
	private void setOPAppPrnInfo(String[] ciorderids) throws BizException {
		CiOrderDO[] ordDos = getCiOrderDO(ciorderids);
		String idors_op = "";
		for (CiOrderDO ciord : ordDos) {
			idors_op += "'" + ciord.getId_or() + "',";
		}

		if (idors_op.length() != 0) {
			ICiorappsurgeryMDORService oprservice = ServiceFinder.find(ICiorappsurgeryMDORService.class);
			OrdApOpDO[] opDOs = oprservice.find("a0.id_or in (" + idors_op.substring(0, idors_op.length() - 1) + ") ",
					null, FBoolean.FALSE);
			for (OrdApOpDO op : opDOs) {
				op.setStatus(DOStatus.UPDATED);
				op.setFg_prn(FBoolean.TRUE);
				if (op.getCnt_prn() == null) {
					op.setCnt_prn(0);
				}
				op.setCnt_prn(op.getCnt_prn() + 1);
			}
			ICiorappsurgeryMDOCudService opsaveservice = ServiceFinder.find(ICiorappsurgeryMDOCudService.class);
			opsaveservice.save(opDOs);
		}
	}

	/**
	 * 保存输血申请单据打印信息
	 * 
	 * @param ciorderids
	 * @return
	 * @throws BizException
	 */
	private void setBTAppPrnInfo(String[] ciorderids) throws BizException {
		CiOrderDO[] ordDos = getCiOrderDO(ciorderids);
		String idors_bt = "";
		for (CiOrderDO ciord : ordDos) {
			idors_bt += "'" + ciord.getId_or() + "',";
		}

		if (idors_bt.length() != 0) {
			ICiorappbtMDORService btrservice = ServiceFinder.find(ICiorappbtMDORService.class);
			OrdApBtDO[] btDOs = btrservice.find("a0.id_or in (" + idors_bt.substring(0, idors_bt.length() - 1) + ") ",
					null, FBoolean.FALSE);
			for (OrdApBtDO bt : btDOs) {
				bt.setStatus(DOStatus.UPDATED);
				bt.setFg_prn(FBoolean.TRUE);
				if (bt.getCnt_prn() == null) {
					bt.setCnt_prn(0);
				}
				bt.setCnt_prn(bt.getCnt_prn() + 1);
			}
			ICiorappbtMDOCudService btsaveservice = ServiceFinder.find(ICiorappbtMDOCudService.class);
			btsaveservice.save(btDOs);
		}
	}

	/**
	 * 保存用血申请单据打印信息
	 * 
	 * @param ciorderids
	 * @return
	 * @throws BizException
	 */
	private void setBTUSEAppPrnInfo(String[] ciorderids) throws BizException {
		CiOrderDO[] ordDos = getCiOrderDO(ciorderids);
		String idors_btuse = "";
		for (CiOrderDO ciord : ordDos) {
			idors_btuse += "'" + ciord.getId_or() + "',";
		}

		if (idors_btuse.length() != 0) {
			ICiorappbuRService burservice = ServiceFinder.find(ICiorappbuRService.class);
			OrdAppBtUseDO[] btUseDOs = burservice.find(
					"a0.id_or in (" + idors_btuse.substring(0, idors_btuse.length() - 1) + ") ", null, FBoolean.FALSE);
			for (OrdAppBtUseDO bt : btUseDOs) {
				bt.setStatus(DOStatus.UPDATED);
				bt.setFg_prn(FBoolean.TRUE);
				if (bt.getCnt_prn() == null) {
					bt.setCnt_prn(0);
				}
				bt.setCnt_prn(bt.getCnt_prn() + 1);
			}
			ICiorappbuCudService busaveservice = ServiceFinder.find(ICiorappbuCudService.class);
			busaveservice.save(btUseDOs);
		}
	}

	/**
	 * 保存会诊申请单据打印信息（备用）
	 * 
	 * @param ciorderids
	 * @return
	 * @throws BizException
	 */
	private void setCONSAppPrnInfo(String[] ciorderids) throws BizException {
		CiOrderDO[] ordDos = getCiOrderDO(ciorderids);
		String idors_cons = "";
		for (CiOrderDO ciord : ordDos) {
			idors_cons += "'" + ciord.getId_or() + "',";
		}

		if (idors_cons.length() != 0) {
			ICiorappconsultMDORService consrservice = ServiceFinder.find(ICiorappconsultMDORService.class);
			OrdApConsDO[] consDOs = consrservice.find(
					"a0.id_or in (" + idors_cons.substring(0, idors_cons.length() - 1) + ") ", null, FBoolean.FALSE);
			for (OrdApConsDO cons : consDOs) {
				cons.setStatus(DOStatus.UPDATED);
				cons.setFg_prn(FBoolean.TRUE);
				if (cons.getCnt_prn() == null) {
					cons.setCnt_prn(0);
				}
				cons.setCnt_prn(cons.getCnt_prn() + 1);
			}
			ICiorappconsultMDOCudService conssaveservice = ServiceFinder.find(ICiorappconsultMDOCudService.class);
			conssaveservice.save(consDOs);
		}
	}

	/**
	 * 查询医嘱信息
	 * 
	 * @param ciorderids
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO[] getCiOrderDO(String[] ciorderids) throws BizException {
		ICiorderMDORService ciordrservice = ServiceFinder.find(ICiorderMDORService.class);
		return ciordrservice.findByBIds(ciorderids, FBoolean.FALSE);
	}

	/**
	 * 保存门诊诊疗执行单信息
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private void updateTreatExecInfo(String[] idors) throws BizException {
		if (idors == null || idors.length == 0)
			return;
		String stridors = "";
		for (String idor : idors) {
			stridors += "'" + idor + "',";
		}
		ICiAppTreatExecOrDORService treatexecorrservice = ServiceFinder.find(ICiAppTreatExecOrDORService.class);
		CiAppTreatExecOrDO[] treatExecOrDOs = treatexecorrservice.find(
				" a1.id_or in (" + stridors.substring(0, stridors.length() - 1) + ")", null, FBoolean.FALSE);
		if (treatExecOrDOs != null && treatExecOrDOs.length > 0) {
			//获取已打印的单据的ID集合
			List<String> id_ciapptreatsheets = new ArrayList<String>();
			for (CiAppTreatExecOrDO treatExecOrDO : treatExecOrDOs) {
				if (!id_ciapptreatsheets.contains(treatExecOrDO.getId_ciapptreatexec()))
					id_ciapptreatsheets.add(treatExecOrDO.getId_ciapptreatexec());
			}

			ICiapptreatexecMDORService treatexecrservice = ServiceFinder.find(ICiapptreatexecMDORService.class);
			CiAppTreatExecDO[] treatExecDOs = treatexecrservice.findByIds(
					id_ciapptreatsheets.toArray(new String[id_ciapptreatsheets.size()]), FBoolean.FALSE);

			for (CiAppTreatExecDO treatExecDO : treatExecDOs) {
				treatExecDO.setFg_prn(FBoolean.TRUE);
				treatExecDO.setCnt_prn(treatExecDO.getCnt_prn() + 1);
				treatExecDO.setStatus(DOStatus.UPDATED);
			}

			ICiapptreatexecMDOCudService treatexecCudService = ServiceFinder.find(ICiapptreatexecMDOCudService.class);
			treatexecCudService.update(treatExecDOs);
		}
	}

	/**
	 * 保存门诊费用清单打印信息
	 * 
	 * @param orsrvids
	 * @return
	 * @throws BizException
	 */
	private void updateCostBillPrnInfo(String[] idors) throws BizException {

		OrdSrvDO[] srvDOs = CiprnUtils.GetOrdSrvDOByIdorFee(idors);
		List<String> lstIds = new ArrayList<String>();
		for (OrdSrvDO srvDO : srvDOs) {
			lstIds.add(srvDO.getId_orsrv());
		}
		updateCiPrnInfo(lstIds.toArray(new String[lstIds.size()]));
	}

	/**
	 * 更新临床打印单信息
	 * 
	 * @param orsrvids
	 * @return
	 * @throws BizException
	 */
	private void updateCiPrnInfo(String[] orsrvids) throws BizException {
		if (orsrvids == null || orsrvids.length == 0)
			return;
		String idsrvs = "";
		for (String srvid : orsrvids) {
			idsrvs += "'" + srvid + "',";
		}
		ICiPrnItmDORService ciprnitmrservice = ServiceFinder.find(ICiPrnItmDORService.class);
		CiPrnItmDO[] ciPrnItmDOs = ciprnitmrservice.find(" id_biz in (" + idsrvs.substring(0, idsrvs.length() - 1)
				+ ")", null, FBoolean.FALSE);
		if (ciPrnItmDOs != null && ciPrnItmDOs.length > 0) {
			//获取已打印的单据的ID集合
			List<String> idciprns = new ArrayList<String>();
			for (CiPrnItmDO itmDO : ciPrnItmDOs) {
				if (!idciprns.contains(itmDO.getId_ciprn()))
					idciprns.add(itmDO.getId_ciprn());
			}

			ICiprintMDORService printRService = ServiceFinder.find(ICiprintMDORService.class);
			CiPrnDO[] prnDOs = printRService.findByIds(idciprns.toArray(new String[idciprns.size()]), FBoolean.FALSE);

			for (CiPrnDO prnDO : prnDOs) {
				prnDO.setFg_prn(FBoolean.TRUE);
				prnDO.setCnt_prn(prnDO.getCnt_prn() + 1);
				prnDO.setStatus(DOStatus.UPDATED);
			}

			ICiprintMDOCudService printCudService = ServiceFinder.find(ICiprintMDOCudService.class);
			printCudService.update(prnDOs);
		}
	}
}
