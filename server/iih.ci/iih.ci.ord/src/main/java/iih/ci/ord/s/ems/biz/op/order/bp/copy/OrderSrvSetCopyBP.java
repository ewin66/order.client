package iih.ci.ord.s.ems.biz.op.order.bp.copy;

import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.d.desc.OrdSrvSetDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 服务套复制
 * @author Young
 *
 */
public class OrderSrvSetCopyBP {

	public Boolean copy(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(mapIdors))
			return false;
		OrdSrvSetDO[] ordSrvSetDOs = getOrdSrvSetDOs(mapIdors.keySet().toArray(new String[] {}));
		if (CiOrdUtils.isEmpty(ordSrvSetDOs))
			return false;
		setOrdSrvSetDOs(ordSrvSetDOs, mapIdors);
		return saveOrdSrvSetDOs(ordSrvSetDOs);
	}
	
	/**
	 * 查询OrdSrvSetDO
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private OrdSrvSetDO[] getOrdSrvSetDOs(String[] idors) throws BizException {
		if (CiOrdUtils.isEmpty(idors))
			return null;
		String strIdors = "";
		for (String id_or : idors) {
			strIdors += ",'" + id_or + "'";
		}
		return CiOrdAppUtils.getOrsrvsetQryService()
				.find(OrdSrvSetDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "",
						FBoolean.FALSE);
	}
	
	/**
	 * 设置OrdSrvSetDO
	 * @param ordSrvSetDOs
	 * @param mapIdors
	 */
	private void setOrdSrvSetDOs(OrdSrvSetDO[] ordSrvSetDOs, Map<String, String> mapIdors){
		if (CiOrdUtils.isEmpty(ordSrvSetDOs))
			return;
		for (OrdSrvSetDO ordSrvSetDO : ordSrvSetDOs) {
			ordSrvSetDO.setId_orsrvset(null);
			ordSrvSetDO.setId_orsrv(null);
			ordSrvSetDO.setId_or(mapIdors.get(ordSrvSetDO.getId_or()));
			ordSrvSetDO.setStatus(DOStatus.NEW);
		}
	}
	
	/**
	 * 保存OrdSrvSetDO
	 * @param ordSrvSetDOs
	 * @return
	 * @throws BizException
	 */
	private Boolean saveOrdSrvSetDOs(OrdSrvSetDO[] ordSrvSetDOs) throws BizException{
		if (CiOrdUtils.isEmpty(ordSrvSetDOs))
			return false;
		ordSrvSetDOs = CiOrdAppUtils.getOrsrvsetService().save(ordSrvSetDOs);
		return !CiOrdUtils.isEmpty(ordSrvSetDOs);
	}
}
