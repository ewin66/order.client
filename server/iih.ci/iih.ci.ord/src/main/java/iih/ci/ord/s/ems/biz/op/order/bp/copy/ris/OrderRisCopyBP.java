package iih.ci.ord.s.ems.biz.op.order.bp.copy.ris;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.desc.OrdApObsDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.OrderBaseCopyBP;

/**
 * 复制检查
 * @author Young
 *
 */
public class OrderRisCopyBP extends OrderBaseCopyBP {

	/**
	 * 复制检查申请单
	 * 
	 * @param id_ors
	 */
	@Override
	protected Boolean copyCiorderAppInfo(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(mapIdors))
			return false;
		OrdApObsDO[] ordApObsDOs = getOrdApObsDOs(mapIdors.keySet().toArray(new String[] {}));
		if (CiOrdUtils.isEmpty(ordApObsDOs))
			return false;
		setOrdApObsDOs(ordApObsDOs, mapIdors);
		return saveOrdApObsDOs(ordApObsDOs);
	}

	/**
	 * 查询OrdApObsDO
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private OrdApObsDO[] getOrdApObsDOs(String[] idors) throws BizException {
		if (CiOrdUtils.isEmpty(idors))
			return null;
		String strIdors = "";
		for (String id_or : idors) {
			strIdors += ",'" + id_or + "'";
		}
		return CiOrdAppUtils.getOrapprisQryService().find(
				OrdApObsDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "", FBoolean.FALSE);
	}

	/**
	 * 设置OrdApObsDO
	 * 
	 * @param OrdApObsDOs
	 * @param mapIdors
	 * @throws BizException 
	 */
	private void setOrdApObsDOs(OrdApObsDO[] OrdApObsDOs, Map<String, String> mapIdors) throws BizException {
		if (CiOrdUtils.isEmpty(OrdApObsDOs))
			return;
		for (OrdApObsDO ordApObsDO : OrdApObsDOs) {
			ordApObsDO.setId_orobs(null);
			ordApObsDO.setId_or(mapIdors.get(ordApObsDO.getId_or()));
			ordApObsDO.setNo_applyform(CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_RIS));
			ordApObsDO.setStatus(DOStatus.NEW);
		}
	}

	/**
	 * 保存OrdApObsDO
	 * 
	 * @param ordApObsDOs
	 * @return
	 * @throws BizException
	 */
	private Boolean saveOrdApObsDOs(OrdApObsDO[] ordApObsDOs) throws BizException {
		if (CiOrdUtils.isEmpty(ordApObsDOs))
			return false;
		ordApObsDOs = CiOrdAppUtils.getOrapprisService().save(ordApObsDOs);
		return !CiOrdUtils.isEmpty(ordApObsDOs);
	}
}
