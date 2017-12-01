package iih.ci.ord.s.ems.biz.op.order.bp.copy.lis;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.desc.OrdApLabDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.OrderBaseCopyBP;

/**
 * 检验复制
 * @author Young
 *
 */
public class OrderLisCopyBP extends OrderBaseCopyBP {

	/**
	 * 复制检验申请单
	 * 
	 * @param id_ors
	 */
	@Override
	protected Boolean copyCiorderAppInfo(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(mapIdors))
			return false;
		OrdApLabDO[] ordApLabDOs = getOrdApLabDOs(mapIdors.keySet().toArray(new String[] {}));
		if (CiOrdUtils.isEmpty(ordApLabDOs))
			return false;
		setOrdApLabDOs(ordApLabDOs, mapIdors);
		return saveOrdApLabDOs(ordApLabDOs);
	}
	
	/**
	 * 查询OrdApLabDO
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private OrdApLabDO[] getOrdApLabDOs(String[] idors) throws BizException {
		if (CiOrdUtils.isEmpty(idors))
			return null;
		String strIdors = "";
		for (String id_or : idors) {
			strIdors += ",'" + id_or + "'";
		}
		return CiOrdAppUtils.getOrapplisQryService()
				.find(OrdApLabDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "",
						FBoolean.FALSE);
	}
	
	/**
	 * 设置OrdApLabDO
	 * @param ordApLabDOs
	 * @param mapIdors
	 * @throws BizException 
	 */
	private void setOrdApLabDOs(OrdApLabDO[] ordApLabDOs, Map<String, String> mapIdors) throws BizException{
		if (CiOrdUtils.isEmpty(ordApLabDOs))
			return;
		for (OrdApLabDO ordApLabDO : ordApLabDOs) {
			ordApLabDO.setId_orlab(null);
			ordApLabDO.setId_or(mapIdors.get(ordApLabDO.getId_or()));
			ordApLabDO.setNo_applyform(CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_LIS));
			ordApLabDO.setStatus(DOStatus.NEW);
		}
	}
	
	/**
	 * 保存OrdApLabDO
	 * @param ordApLabDOs
	 * @return
	 * @throws BizException
	 */
	private Boolean saveOrdApLabDOs(OrdApLabDO[] ordApLabDOs) throws BizException{
		if (CiOrdUtils.isEmpty(ordApLabDOs))
			return false;
		ordApLabDOs = CiOrdAppUtils.getOrapplisService().save(ordApLabDOs);
		return !CiOrdUtils.isEmpty(ordApLabDOs);
	}
}
