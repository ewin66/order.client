package iih.ci.ord.s.ems.biz.op.order.bp.copy.opr;

import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.desc.OrdApOpDODesc;
import iih.ci.ord.cior.i.ICiorappsurgeryMDORService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.OrderBaseCopyBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 复制手术
 * @author Young
 *
 */
public class OrderOpCopyBP extends OrderBaseCopyBP {
	
	/**
	 * 复制手术申请单
	 * 
	 * @param id_ors
	 */
	@Override
	protected Boolean copyCiorderAppInfo(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(mapIdors))
			return false;
		OrdApOpDO[] OrdApOpDOs = getOrdApLabOpDOs(mapIdors.keySet().toArray(new String[] {}));
		if (CiOrdUtils.isEmpty(OrdApOpDOs))
			return false;
		setOrdApLabDOs(OrdApOpDOs, mapIdors);
		return saveOrdApOpDOs(OrdApOpDOs);
	}
	
	/**
	 * 查询OrdApLabDO
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private OrdApOpDO[] getOrdApLabOpDOs(String[] idors) throws BizException {
		if (CiOrdUtils.isEmpty(idors))
			return null;
		String strIdors = "";
		for (String id_or : idors) {
			strIdors += ",'" + id_or + "'";
		}
		ICiorappsurgeryMDORService iCiorappsurgeryMDORService = CiOrdAppUtils.getICiorappsurgeryMDORService(); 
		return iCiorappsurgeryMDORService
				.find(OrdApOpDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "",
						FBoolean.FALSE);
	}
	
	/**
	 * 设置OrdApLabDO
	 * @param ordApLabDOs
	 * @param mapIdors
	 * @throws BizException 
	 */
	private void setOrdApLabDOs(OrdApOpDO[] ordApOpDOs, Map<String, String> mapIdors) throws BizException{
		if (CiOrdUtils.isEmpty(ordApOpDOs))
			return;
		for (OrdApOpDO ordApOpDO : ordApOpDOs) {
			ordApOpDO.setId_apop(null);
			ordApOpDO.setId_or(mapIdors.get(ordApOpDO.getId_or()));
			ordApOpDO.setNo_applyform(CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_OP));
			ordApOpDO.setStatus(DOStatus.NEW);
		}
	}
	
	/**
	 * 保存OrdApLabDO
	 * @param ordApLabDOs
	 * @return
	 * @throws BizException
	 */
	private Boolean saveOrdApOpDOs(OrdApOpDO[] OrdApOpDOs) throws BizException{
		if (CiOrdUtils.isEmpty(OrdApOpDOs))
			return false;
		OrdApOpDOs = CiOrdAppUtils.getICiorappsurgeryMDOCudService().save(OrdApOpDOs);
		return !CiOrdUtils.isEmpty(OrdApOpDOs);
	}

}
