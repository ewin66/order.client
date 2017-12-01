package iih.ci.ord.s.bp.ciprn;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciprn.d.CiPrnDO;
import iih.ci.ord.ciprn.d.CiPrnItmDO;
import iih.ci.ord.ciprn.d.CiprintAggDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class CiprnSaveFeeBillsDataBP {

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
//		CiprnDeleteFeeBillsDataBP bp = new CiprnDeleteFeeBillsDataBP();
//		bp.exec(idors, false);
		OrdSrvDO[] srvDOs = CiprnUtils.GetOrdSrvDOByIdorFee(idors);
		if (srvDOs == null || srvDOs.length == 0)
			return null;
		List<String> lstIdorsrvs = new ArrayList<String>();
		for (OrdSrvDO srvDO : srvDOs) {
			lstIdorsrvs.add(srvDO.getId_orsrv());
		}
		OrdSrvDO[] srvDos = getNewPrintData(lstIdorsrvs);
		if (srvDos == null || srvDos.length <= 0)
			return null;
		
		List<String> lstIdors=new ArrayList<String>();
		for (OrdSrvDO srv : srvDos) {
			if(!lstIdors.contains(srv.getId_or())){
				lstIdors.add(srv.getId_or());
			}
		}
		CiOrderDO[] ciorders = CiprnUtils.GetCiOrderDOByIds(lstIdors.toArray(new String[] {}));
		Map<String, CiOrderDO> mapCiOrderDOs = new HashMap<String, CiOrderDO>();
		for (CiOrderDO ciorder : ciorders) {
			mapCiOrderDOs.put(ciorder.getId_or(), ciorder);
		}
		
		List<List<String>> typelist = getPrintBillData(srvDos, mapCiOrderDOs);
		if (typelist == null || typelist.size() <= 0)
			return null;
		List<CiprintAggDO> aggDOs = getCiprintAggDOs(srvDos, typelist, Id_hp, Sd_hptp, mapCiOrderDOs);
		if (aggDOs == null || aggDOs.size() <= 0)
			return null;
		CiprintAggDO[] result = CiprnUtils.SaveCiprintAggDO(aggDOs.toArray(new CiprintAggDO[aggDOs.size()]));

		return result != null ? FBoolean.TRUE : FBoolean.FALSE;
	}

	/**
	 * 获取需要打印的所有数据（未打过的）
	 * 
	 * @param idorsrvs
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO[] getNewPrintData(List<String> idorsrvs) throws BizException {
		if (idorsrvs == null || idorsrvs.size() <= 0)
			return null;
		CiPrnItmDO[] ciPrnItmDOs = CiprnUtils.GetCiPrnItmDOByIdorsrv(idorsrvs);
		if (ciPrnItmDOs != null && ciPrnItmDOs.length > 0) {
			//去除已打印的
			for (CiPrnItmDO itmDO : ciPrnItmDOs) {
				if (idorsrvs.contains(itmDO.getId_biz()))
					idorsrvs.remove(itmDO.getId_biz());
			}
		}
		//获取新增打印的医嘱服务DO集合
		OrdSrvDO[] srvDos = CiprnUtils.GetOrdSrvDOById(idorsrvs.toArray(new String[idorsrvs.size()]));

		return srvDos;
	}

	/**
	 * 构造分单依据集合
	 * 
	 * @param srvDos
	 * @param MapIdorsrvsprnd
	 * @param bCheckprn
	 * @return
	 * @throws BizException
	 */
	private List<List<String>> getPrintBillData(OrdSrvDO[] srvDos, Map<String, CiOrderDO> mapCiOrderDOs) throws BizException {
		if (srvDos == null || srvDos.length == 0)
			return null;
		List<List<String>> typelist = new ArrayList<List<String>>();//以Id_orsrv代表OrdSrvDO进行分单组合
		//构造分单依据集合，依据  Id_emp_sign签署医生/Id_dep_mp执行科室/Fg_selfpay是否医保内  进行分单，List<String>存储这三个值，每一个List<String>对应一个单据
		CONTAINS: for (OrdSrvDO srv : srvDos) {
			//判断是否签署
			CiOrderDO ciorder = mapCiOrderDOs.get(srv.getId_or());
			if (ciorder.getFg_sign() != null && ciorder.getFg_sign().equals(FBoolean.FALSE))
				continue;

			if (typelist.size() > 0) {
				for (List<String> lst : typelist) {
					if (lst.contains(StringUtils.isNullOrEmpty(ciorder.getId_emp_sign()) ? "" : ciorder
							.getId_emp_sign())
							&& lst.contains(StringUtils.isNullOrEmpty(srv.getId_dep_mp()) ? "" : srv.getId_dep_mp())
							&& lst.contains(srv.getFg_selfpay().equals(FBoolean.TRUE) ? "Y" : "N")) {
						continue CONTAINS;
					}
				}
			}
			List<String> idslist = new ArrayList<String>();
			idslist.add(StringUtils.isNullOrEmpty(ciorder.getId_emp_sign()) ? "" : ciorder.getId_emp_sign());
			idslist.add(StringUtils.isNullOrEmpty(srv.getId_dep_mp()) ? "" : srv.getId_dep_mp());
			idslist.add(srv.getFg_selfpay().equals(FBoolean.TRUE) ? "Y" : "N");
			typelist.add(idslist);
		}
		return typelist;
	}

	/**
	 * 根据分单依据集合构造打印对象集合
	 * 
	 * @param srvDos
	 * @param typelist
	 * @param MapIdorsrvsprnd
	 * @return
	 * @throws BizException
	 */
	private List<CiprintAggDO> getCiprintAggDOs(OrdSrvDO[] srvDos, List<List<String>> typelist, String Id_hp,
			String Sd_hptp, Map<String, CiOrderDO> mapCiOrderDOs) throws BizException {
		List<CiprintAggDO> aggdolist = new ArrayList<CiprintAggDO>();
		String idor = "";
		CiOrderDO ciorder = new CiOrderDO();
		
		String strIdorsrvs = "";
		for (OrdSrvDO srv : srvDos) {
			strIdorsrvs += ",'" + srv.getId_orsrv() + "'";
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
		
		idor = srvDos[0].getId_or();
		ciorder = mapCiOrderDOs.get(idor);
		
		String strDi = CiprnUtils.GetStr_name_di(ciorder.getId_en());
		
		CiPrnDO prnDO4NO = new CiPrnDO();
		prnDO4NO.setId_en(ciorder.getId_en());
		String[] presNOs = CiOrdUtils.generateNormNOs(typelist.size(), prnDO4NO, 1, 21);
		int i = 0;
		for (List<String> lst : typelist) {
			CiprintAggDO aggDO = new CiprintAggDO();
			CiPrnDO prnDO = new CiPrnDO();
			List<CiPrnItmDO> prnItmDOs = new ArrayList<CiPrnItmDO>();

			//第一次打印的单据（新增）
			for (OrdSrvDO srv : srvDos) {
				//获取签署医生ID
				if (!srv.getId_or().equals(idor)) {
					idor = srv.getId_or();
					ciorder = mapCiOrderDOs.get(idor);
				}

				if (lst.contains(StringUtils.isNullOrEmpty(ciorder.getId_emp_sign()) ? "" : ciorder.getId_emp_sign())
						&& lst.contains(StringUtils.isNullOrEmpty(srv.getId_dep_mp()) ? "" : srv.getId_dep_mp())
						&& lst.contains(srv.getFg_selfpay().equals(FBoolean.TRUE) ? "Y" : "N")) {
					CiPrnItmDO prnItmDO = new CiPrnItmDO();
					prnItmDO.setId_biz(srv.getId_orsrv());
					//业务金额
					if (srv.getFg_bl().equals(FBoolean.TRUE)) {
						if (srv.getFg_mm().equals(FBoolean.TRUE)) {
							OrdSrvMmDO[] srvMmDOs = mapOrdSrvMmDOs.get(srv.getId_orsrv()).toArray(new OrdSrvMmDO[0]);
							if (srvMmDOs != null && srvMmDOs.length > 0) {
								if (srvMmDOs[0].getQuan_cur() == null || srvMmDOs[0].getPrice_pgku_cur() == null) {
									prnItmDO.setAmt_biz(new FDouble("0.00"));
								} else {
									prnItmDO.setAmt_biz(srvMmDOs[0].getQuan_cur().multiply(
											srvMmDOs[0].getPrice_pgku_cur()));
								}
							}
						} else {
							if (srv.getQuan_total_medu() == null || srv.getPri() == null) {
								prnItmDO.setAmt_biz(new FDouble("0.00"));
							} else {
								prnItmDO.setAmt_biz(srv.getQuan_total_medu().multiply(srv.getPri()));
							}
						}
					} else {
						prnItmDO.setAmt_biz(new FDouble("0.00"));
					}
					prnItmDO.setStatus(DOStatus.NEW);
					prnItmDOs.add(prnItmDO);
				}
			}
			prnDO.setId_grp(ciorder.getId_grp());
			prnDO.setId_org(ciorder.getId_org());
			prnDO.setId_en(ciorder.getId_en());
			prnDO.setId_entp(ciorder.getId_entp());
			prnDO.setCode_entp(ciorder.getCode_entp());
			//			prnDO.setId_di(Id_di);
			//			prnDO.setId_diitm(Id_diitm);
			//			prnDO.setStr_id_diitm(Str_id_diitm);
			//			prnDO.setStr_code_di(Str_code_di);
			prnDO.setStr_name_di(strDi);
			//			prnDO.setName_diag(Name_diag);
			prnDO.setId_pat(ciorder.getId_pat());
			prnDO.setFg_bb(ciorder.getFg_bb());
			prnDO.setNo_bb(ciorder.getNo_bb());
			prnDO.setCode_prn(presNOs[i]);
			prnDO.setName_prn("门诊诊疗项目收费清单");
			prnDO.setId_org_prn(Context.get().getOrgId());
			prnDO.setId_dep_prn(Context.get().getDeptId());
			prnDO.setId_emp_prn(Context.get().getUserId());
			prnDO.setDt_prn(new FDateTime());
			prnDO.setId_dep_mp(ciorder.getId_dep_mp());
			prnDO.setId_ciprntp(IBdSrvDictCodeConst.SD_CIPRNTP_COSTBILL_ID);
			prnDO.setSd_ciprntp(IBdSrvDictCodeConst.SD_CIPRNTP_COSTBILL);
			prnDO.setFg_prn(FBoolean.FALSE);
			prnDO.setCnt_prn(0);
			prnDO.setFg_hp(ciorder.getFg_orhp());
			prnDO.setFg_prepay(ciorder.getFg_prepay());
			prnDO.setFg_hecominsur(CiEnContextUtil.isHeComInsurPat(Id_hp, Sd_hptp) ? FBoolean.TRUE : FBoolean.FALSE);
			//			prnDO.setHecominsurinfo(Hecominsurinfo);
			prnDO.setFg_vip(ciorder.getFg_vip());
			prnDO.setFg_blsettled(FBoolean.FALSE);
			prnDO.setStatus(DOStatus.NEW);

			aggDO.setParentDO(prnDO);
			aggDO.setCiPrnItmDO(prnItmDOs.toArray(new CiPrnItmDO[prnItmDOs.size()]));
			aggdolist.add(aggDO);
			i++;
		}

		return aggdolist;
	}

}
