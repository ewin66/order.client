package iih.ci.ord.s.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppPathgySheetDO;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.desc.CiAppLisSheetDODesc;
import iih.ci.ord.app.d.desc.CiAppPathgySheetDODesc;
import iih.ci.ord.app.d.desc.CiAppRisSheetDODesc;
import iih.ci.ord.ciprn.d.CiPrnDO;
import iih.ci.ord.ciprn.d.desc.CiPrnDODesc;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pres.d.desc.CiPresDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 获取记账结果BP
 * 
 * @author HUMS
 *
 */
public class GetOpPreCalcFeeRstBP {

	// 更新处方的预付费标识
	private static final String UPDATE_CI_PRES_PREPAY = "update " + CiPresDODesc.TABLE_NAME + " set "
			+ CiPresDO.FG_PREPAY + " = 'Y' where " + CiPresDO.ID_EN + " = '%s' and " + CiPresDO.CODE + " in (%s) ";

	// 更新检查打印单预付费标识
		private static final String UPDATE_CI_APP_RIS_PREPAY = "update " + CiAppRisSheetDODesc.TABLE_NAME + " set "
				+ CiAppRisSheetDO.FG_PREPAY + " = 'Y' where " + CiAppRisSheetDO.ID_EN + " = '%s' and "
				+ CiAppRisSheetDO.CODE_APP + " in (%s) ";
		
	// 更新病理打印单预付费标识
	private static final String UPDATE_CI_APP_PATHGY_PREPAY = "update " + CiAppPathgySheetDODesc.TABLE_NAME + " set "
				+ CiAppPathgySheetDO.FG_PREPAY + " = 'Y' where " + CiAppPathgySheetDO.ID_EN + " = '%s' and "
				+ CiAppPathgySheetDO.CODE_APP + " in (%s) ";
		
	// 更新检验打印单预付费标识
	private static final String UPDATE_CI_APP_LIS_PREPAY = "update " + CiAppLisSheetDODesc.TABLE_NAME + " set "
			+ CiAppLisSheetDO.FG_PREPAY + " = 'Y' where " + CiAppLisSheetDO.ID_EN + " = '%s' and "
			+ CiAppLisSheetDO.CODE_APP + " in (%s) ";

	// 更新临床打印单预付费标识
	private static final String UPDATE_CI_PRN_PREPAY = "update " + CiPrnDODesc.TABLE_NAME + " set " + CiPrnDO.FG_PREPAY
			+ " = 'Y' where " + CiPrnDO.ID_EN + " = '%s' and " + CiPrnDO.CODE_PRN + " in (%s) ";	

	// 缓存打印单类型与更新语句对应关系
	private static final Map<String, String> UPDATE_FG_PREPAY_MAP = new HashMap<String, String>();
	static {
		UPDATE_FG_PREPAY_MAP.put(IBdSrvDictCodeConst.DRUG_TYPE, UPDATE_CI_PRES_PREPAY);// 更新ci_pres.fg_prepay
		UPDATE_FG_PREPAY_MAP.put(IBdSrvDictCodeConst.RIS_TYPE, UPDATE_CI_APP_RIS_PREPAY);// 更新ci_app_ris.fg_prepay
		UPDATE_FG_PREPAY_MAP.put(IBdSrvDictCodeConst.LIS_TYPE, UPDATE_CI_APP_LIS_PREPAY);// 更新ci_app_lis.fg_prepay
		UPDATE_FG_PREPAY_MAP.put(IBdSrvDictCodeConst.TREATMENT_TYPE, UPDATE_CI_PRN_PREPAY);// 更新ci_prn.fg_prepay		
		UPDATE_FG_PREPAY_MAP.put(IBdSrvDictCodeConst.PATHGY_TYPE,UPDATE_CI_APP_PATHGY_PREPAY);// 更新ci_app_pathgy.fg_prepay
	}

	/**
	 * 医生站记账
	 * 
	 * @param id_en 就诊id
	 * @param code_entp
	 * @param acctountType 记账类型
	 * @param id_psndoc 当前操作人
	 * @DmEnumDesc(name="预交金记账",description="预交金记账") public static final String CG_PREPAY="1"; //预交金记账
	 * @DmEnumDesc(name="高端商保记账",description="高端商保记账") public static final String CG_HPCG="2"; //高端商保记账
	 * 
	 * @return
	 * @throws BizException
	 */
	public String exec(String id_en, String code_entp, String acctountType, String id_psndoc) throws BizException {

		// 返回到客户端的操作提示信息
		String rstMsg = null;
		BlOrderAppendBillParamDTO[] rst = CiOrdAppUtils.getIBLOrderAppendBillService()
				.SetOrderAppendBill_ByItms_ci_kljz_new(id_en, code_entp, acctountType, id_psndoc);

		if (rst != null && rst.length > 0) {

			// 申请单类型,申请单号map集合，用于更新申请单中的预付费标识
			Map<String, List<String>> appCodeMap = new HashMap<String, List<String>>();
			FDouble sumAmtRation = new FDouble(0);
			for (BlOrderAppendBillParamDTO billParam : rst) {

				//  申请单类型,申请单号map集合，值保存预交金账户
				if (StringUtils.isNotEmpty(billParam.getCode_applytp()) && billParam.getOutpBillDTO() != null && billParam.getOutpBillDTO().getFg_acc() == FBoolean.TRUE) {
					List<String> codeAppList = null;
					if (!appCodeMap.containsKey(billParam.getCode_applytp())) {
						codeAppList = new ArrayList<String>();
						codeAppList.add(billParam.getCode_apply());

						appCodeMap.put(billParam.getCode_applytp(), codeAppList);
					} else {
						codeAppList = appCodeMap.get(billParam.getCode_applytp());
						if (!codeAppList.contains(billParam.getCode_apply())) {
							codeAppList.add(billParam.getCode_apply());
						}
					}
				}

				if (billParam.getAmt_ratio() != null) {
					sumAmtRation = sumAmtRation.add(billParam.getAmt_ratio());
				}
			}

			// 更新预付费标识
			this.updateFgPrePay(id_en, appCodeMap);

			rstMsg = "记账成功，记账金额%s元！";
			rstMsg = String.format(rstMsg, sumAmtRation.setScale(-2, BigDecimal.ROUND_HALF_UP));
		} else {
			rstMsg = "记账失败！";
		}

		return rstMsg;
	}

	/**
	 * 更新打印单预付费标识
	 * 
	 * @param id_en 就诊id
	 * @param appCodeMap 打印单类型与打印单号map集合 key 打印单类型，value 申请单打印单号list集合
	 */
	private void updateFgPrePay(String id_en, Map<String, List<String>> appCodeMap) {

		if (appCodeMap == null || appCodeMap.size() == 0) {
			return;
		}

		String tempSql = null;
		StringBuffer codeBuffer = new StringBuffer();
		DAFacade daf = new DAFacade();

		// 遍历待更新数据的打印单类型，按类型生成更新语句
		for (String key : appCodeMap.keySet()) {

			tempSql = UPDATE_FG_PREPAY_MAP.get(key);
			List<String> codeApplyList = appCodeMap.get(key);
			for (String codeApply : codeApplyList) {
				codeBuffer.append(",'"+codeApply+"'");
			}
			
			tempSql = String.format(tempSql, id_en, codeBuffer.substring(1));
			// 使用完后清空buffer
			codeBuffer.setLength(0);
			try {
				daf.execUpdate(tempSql);
			} catch (DAException e) {
				throw new BizRuntimeException("更新打印单预付费标识失败！", e);
			}
		}
	
	}

}
