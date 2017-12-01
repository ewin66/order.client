package iih.ci.ord.s.bp.ciprn;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppPathgySheetDO;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.CiAppTreatExecDO;
import iih.ci.ord.ciprn.d.CiPrnDO;
import iih.ci.ord.pres.d.CiPresDO;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

import com.mysql.jdbc.StringUtils;

public class UpdateCiPrintPrepayBP {

	/**
	 * 更新临床打印表预付费标志
	 * 
	 * @param id_en
	 * @param map_billtp_billNOs
	 * @param Fg_hecominsur
	 * @param Fg_prepay
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String id_en, Map<String, String[]> map_billtp_billNOs, FBoolean fg_hecominsur,
			FBoolean fg_prepay) throws BizException {
		if (StringUtils.isNullOrEmpty(id_en) || map_billtp_billNOs == null || map_billtp_billNOs.size() <= 0
				|| fg_prepay == null || fg_prepay.equals(FBoolean.FALSE))
			return FBoolean.FALSE;

		for (String key : map_billtp_billNOs.keySet()) {
			if (StringUtils.isNullOrEmpty(key) || map_billtp_billNOs.get(key) == null
					|| map_billtp_billNOs.get(key).length <= 0)
				continue;
			String sql = getSQL(id_en, map_billtp_billNOs.get(key));
			switch (key) {
			case IBdSrvDictCodeConst.DRUG_TYPE:
				UpdateCiPrintPrepay_Pres(sql);
				break;
			case IBdSrvDictCodeConst.RIS_TYPE:
				UpdateCiPrintPrepay_Ris(sql);
				UpdateCiPrintPrepay_Pathgy(sql);
				break;
			case IBdSrvDictCodeConst.LIS_TYPE:
				UpdateCiPrintPrepay_Lis(sql);
				break;
			case IBdSrvDictCodeConst.TREATMENT_TYPE:
				UpdateCiPrintPrepay_Fee(sql);
				break;
			}
		}
		return FBoolean.TRUE;
	}

	/**
	 * 更新处方费用预付费标识
	 * 
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	private CiPresDO[] UpdateCiPrintPrepay_Pres(String sql) throws BizException {
		if (StringUtils.isNullOrEmpty(sql))
			return null;
		CiPresDO[] presDOs = CiprnUtils.GetCiPresDOs(sql);
		if (presDOs == null || presDOs.length <= 0)
			return null;
		for (CiPresDO presDO : presDOs) {
			presDO.setFg_prepay(FBoolean.TRUE);
			presDO.setStatus(DOStatus.UPDATED);
		}

		return CiprnUtils.UpdateCiPresDOs(presDOs);
	}

	/**
	 * 更新检查费用预付费标识
	 * 
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	private CiAppRisSheetDO[] UpdateCiPrintPrepay_Ris(String sql) throws BizException {
		if (StringUtils.isNullOrEmpty(sql))
			return null;
		String sqlsry = sql.replaceAll("code", "code_app");
		CiAppRisSheetDO[] risDOs = CiprnUtils.GetCiAppRisSheetDOs(sqlsry);
		if (risDOs == null || risDOs.length <= 0)
			return null;
		for (CiAppRisSheetDO risDO : risDOs) {
			risDO.setFg_prepay(FBoolean.TRUE);
			risDO.setStatus(DOStatus.UPDATED);
		}
		return CiprnUtils.UpdateCiAppRisSheetDOs(risDOs);
	}

	/**
	 * 更新病理费用预付费标识
	 * 
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	private CiAppPathgySheetDO[] UpdateCiPrintPrepay_Pathgy(String sql) throws BizException {
		if (StringUtils.isNullOrEmpty(sql))
			return null;
		String sqlsry = sql.replaceAll("code", "code_app");
		CiAppPathgySheetDO[] pathgyDOs = CiprnUtils.GetCiAppPathgySheetDOs(sqlsry);
		if (pathgyDOs == null || pathgyDOs.length <= 0)
			return null;
		for (CiAppPathgySheetDO pathgyDO : pathgyDOs) {
			pathgyDO.setFg_prepay(FBoolean.TRUE);
			pathgyDO.setStatus(DOStatus.UPDATED);
		}
		return CiprnUtils.UpdateCiAppPathgySheetDOs(pathgyDOs);
	}

	/**
	 * 更新检验费用预付费标识
	 * 
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	private CiAppLisSheetDO[] UpdateCiPrintPrepay_Lis(String sql) throws BizException {
		if (StringUtils.isNullOrEmpty(sql))
			return null;
		String sqlsry = sql.replaceAll("code", "code_app");
		CiAppLisSheetDO[] lisDOs = CiprnUtils.GetCiAppLisSheetDOs(sqlsry);
		if (lisDOs == null || lisDOs.length <= 0)
			return null;
		for (CiAppLisSheetDO lisDO : lisDOs) {
			lisDO.setFg_prepay(FBoolean.TRUE);
			lisDO.setStatus(DOStatus.UPDATED);
		}
		return CiprnUtils.UpdateCiAppLisSheetDOs(lisDOs);
	}

	/**
	 * 更新治疗预付费标识
	 * 
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	private CiAppTreatExecDO[] UpdateCiPrintPrepay_Treate(String sql) throws BizException {
		if (StringUtils.isNullOrEmpty(sql))
			return null;
		String sqlsry = sql.replaceAll("code", "code_app");
		CiAppTreatExecDO[] treateDOs = CiprnUtils.GetCiAppTreatExecDOs(sqlsry);
		if (treateDOs == null || treateDOs.length <= 0)
			return null;
		for (CiAppTreatExecDO treateDO : treateDOs) {
			treateDO.setFg_prepay(FBoolean.TRUE);
			treateDO.setStatus(DOStatus.UPDATED);
		}
		return CiprnUtils.UpdateCiAppTreatExecDOs(treateDOs);
	}

	/**
	 * 更新诊疗费用预付费标识
	 * 
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	private CiPrnDO[] UpdateCiPrintPrepay_Fee(String sql) throws BizException {
		if (StringUtils.isNullOrEmpty(sql))
			return null;
		String sqlsry = sql.replaceAll("code", "code_prn");
		CiPrnDO[] prnDOs = CiprnUtils.GetCiPrnDOs(sqlsry);
		if (prnDOs == null || prnDOs.length <= 0)
			return null;
		for (CiPrnDO prnDO : prnDOs) {
			prnDO.setFg_prepay(FBoolean.TRUE);
			prnDO.setStatus(DOStatus.UPDATED);
		}
		return CiprnUtils.UpdateCiPrnDOs(prnDOs);
	}

	/**
	 * 拼接打印单据编码
	 * 
	 * @param id_en
	 * @param billNOs
	 * @return
	 */
	private String getSQL(String id_en, String[] billNOs) {
		String str = "";
		for (String billNO : billNOs) {
			str += "'" + billNO + "',";
		}
		return String.format(" id_en = '%s' and code in (%s) ", id_en, str.substring(0, str.length() - 1));
	}
}
