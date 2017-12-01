package iih.ci.ord.s.bp.ciprn;

import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppPathgySheetDO;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.CiAppTreatExecDO;
import iih.ci.ord.app.i.ICiapplissheetMDOCudService;
import iih.ci.ord.app.i.ICiapplissheetMDORService;
import iih.ci.ord.app.i.ICiapppathgysheetMDOCudService;
import iih.ci.ord.app.i.ICiapppathgysheetMDORService;
import iih.ci.ord.app.i.ICiapptreatexecMDOCudService;
import iih.ci.ord.app.i.ICiapptreatexecMDORService;
import iih.ci.ord.ciprn.d.CiPrnDO;
import iih.ci.ord.ciprn.i.ICiprintMDOCudService;
import iih.ci.ord.ciprn.i.ICiprintMDORService;
import iih.ci.ord.pres.d.CiPresDO;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

import com.mysql.jdbc.StringUtils;

/**
 * 更新临床打印表费用结算标识
 * 
 * @author YANG
 *
 */
public class UpdateCiPrintBlsettledBP {

	/**
	 * 更新临床打印表费用结算标识
	 * @param map_iden_strBillNOs (key:id_en; value:'billNO','billNO','billNO'...)
	 * @param fg_blsettled
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(Map<String,String> map_iden_strBillNOs, FBoolean fg_blsettled) throws BizException {
		if (map_iden_strBillNOs == null || map_iden_strBillNOs.size() <= 0)
			return FBoolean.FALSE;
		String sql="";
		for (String key : map_iden_strBillNOs.keySet()) {
			if (StringUtils.isNullOrEmpty(key) || map_iden_strBillNOs.get(key) == null)
				continue;
			if (sql.length() > 0)
				sql += " or ";
			sql += getSQL(key, map_iden_strBillNOs.get(key).toString());
		}
		if (StringUtils.isNullOrEmpty(sql))
			return FBoolean.TRUE;
		
		UpdateCiPrintBlsettledBP_Pres(sql, fg_blsettled);
		UpdateCiPrintBlsettledBP_Ris(sql, fg_blsettled);
		UpdateCiPrintBlsettledBP_Pathgy(sql, fg_blsettled);
		UpdateCiPrintBlsettledBP_Lis(sql, fg_blsettled);
		UpdateCiPrintBlsettledBP_Fee(sql, fg_blsettled);
		UpdateCiPrintBlsettledBP_Treate(sql, fg_blsettled);
		
		return FBoolean.TRUE;
	}

	/**
	 * 更新处方费用结算标识
	 * 
	 * @param sql
	 * @param fg_blsettled
	 * @return
	 * @throws BizException
	 */
	private CiPresDO[] UpdateCiPrintBlsettledBP_Pres(String sql, FBoolean fg_blsettled)
			throws BizException {
		if (StringUtils.isNullOrEmpty(sql))
			return null;
		CiPresDO[] presDOs = CiprnUtils.GetCiPresDOs(sql);
		if (presDOs == null || presDOs.length <= 0)
			return null;
		for (CiPresDO presDO : presDOs) {
			presDO.setFg_blsettled(fg_blsettled);
			presDO.setStatus(DOStatus.UPDATED);
		}
		
		return CiprnUtils.UpdateCiPresDOs(presDOs);
	}

	/**
	 * 更新检查费用结算标识
	 * 
	 * @param sql
	 * @param fg_blsettled
	 * @return
	 * @throws BizException
	 */
	private CiAppRisSheetDO[] UpdateCiPrintBlsettledBP_Ris(String sql, FBoolean fg_blsettled)
			throws BizException {
		if (StringUtils.isNullOrEmpty(sql))
			return null;
		String sqlsry = sql.replaceAll("code", "code_app");
		CiAppRisSheetDO[] risDOs = CiprnUtils.GetCiAppRisSheetDOs(sqlsry);
		if (risDOs == null || risDOs.length <= 0)
			return null;
		for (CiAppRisSheetDO risDO : risDOs) {
			risDO.setFg_blsettled(fg_blsettled);
			risDO.setStatus(DOStatus.UPDATED);
		}
		return CiprnUtils.UpdateCiAppRisSheetDOs(risDOs);
	}
	
	/**
	 * 更新病理费用结算标识
	 * 
	 * @param sql
	 * @param fg_blsettled
	 * @return
	 * @throws BizException
	 */
	private CiAppPathgySheetDO[] UpdateCiPrintBlsettledBP_Pathgy(String sql, FBoolean fg_blsettled)
			throws BizException {
		if (StringUtils.isNullOrEmpty(sql))
			return null;
		String sqlsry = sql.replaceAll("code", "code_app");
		CiAppPathgySheetDO[] pathgyDOs = CiprnUtils.GetCiAppPathgySheetDOs(sqlsry);
		if (pathgyDOs == null || pathgyDOs.length <= 0)
			return null;
		for (CiAppPathgySheetDO pathgyDO : pathgyDOs) {
			pathgyDO.setFg_blsettled(fg_blsettled);
			pathgyDO.setStatus(DOStatus.UPDATED);
		}
		return CiprnUtils.UpdateCiAppPathgySheetDOs(pathgyDOs);
	}

	/**
	 * 更新检验费用结算标识
	 * 
	 * @param sql
	 * @param fg_blsettled
	 * @return
	 * @throws BizException
	 */
	private CiAppLisSheetDO[] UpdateCiPrintBlsettledBP_Lis(String sql, FBoolean fg_blsettled)
			throws BizException {
		if (StringUtils.isNullOrEmpty(sql))
			return null;
		String sqlsry = sql.replaceAll("code", "code_app");
		CiAppLisSheetDO[] lisDOs = CiprnUtils.GetCiAppLisSheetDOs(sqlsry);
		if (lisDOs == null || lisDOs.length <= 0)
			return null;
		for (CiAppLisSheetDO lisDO : lisDOs) {
			lisDO.setFg_blsettled(fg_blsettled);
			lisDO.setStatus(DOStatus.UPDATED);
		}
		return CiprnUtils.UpdateCiAppLisSheetDOs(lisDOs);
	}

	/**
	 * 更新治疗结算标识
	 * 
	 * @param sql
	 * @param fg_blsettled
	 * @return
	 * @throws BizException
	 */
	private CiAppTreatExecDO[] UpdateCiPrintBlsettledBP_Treate(String sql, FBoolean fg_blsettled)
			throws BizException {
		if (StringUtils.isNullOrEmpty(sql))
			return null;
		String sqlsry = sql.replaceAll("code", "code_app");
		CiAppTreatExecDO[] treateDOs = CiprnUtils.GetCiAppTreatExecDOs(sqlsry);
		if (treateDOs == null || treateDOs.length <= 0)
			return null;
		for (CiAppTreatExecDO treateDO : treateDOs) {
			treateDO.setFg_blsettled(fg_blsettled);
			treateDO.setStatus(DOStatus.UPDATED);
		}
		return CiprnUtils.UpdateCiAppTreatExecDOs(treateDOs);
	}

	/**
	 * 更新诊疗费用结算标识
	 * 
	 * @param sql
	 * @param fg_blsettled
	 * @return
	 * @throws BizException
	 */
	private CiPrnDO[] UpdateCiPrintBlsettledBP_Fee(String sql, FBoolean fg_blsettled)
			throws BizException {
		if (StringUtils.isNullOrEmpty(sql))
			return null;
		String sqlsry = sql.replaceAll("code", "code_prn");
		CiPrnDO[] prnDOs = CiprnUtils.GetCiPrnDOs(sqlsry);
		if (prnDOs == null || prnDOs.length <= 0)
			return null;
		for (CiPrnDO prnDO : prnDOs) {
			prnDO.setFg_blsettled(fg_blsettled);
			prnDO.setStatus(DOStatus.UPDATED);
		}
		return CiprnUtils.UpdateCiPrnDOs(prnDOs);
	}

	/**
	 * 拼接打印单据编码
	 * 
	 * @param strBillNOs
	 * @return
	 */
	private String getSQL(String id_en, String strBillNOs) {
		String sql = "";
		sql += String.format(" (id_en = '%s' and code in (%s))", id_en, strBillNOs);
		return sql;
	}
}
