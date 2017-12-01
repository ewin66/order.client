package iih.ci.ord.s.ems.biz.op.order.bp.copy;

import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 临床服务物品复制
 * @author Young
 *
 */
public class OrderSrvMMCopyBP {

	public Boolean copy(Map<String, String> mapIdorsrvs, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(mapIdorsrvs))
			return false;
		OrdSrvMmDO[] ordSrvMmDOs = getOrdSrvMmDOs(mapIdorsrvs.keySet().toArray(new String[] {}));
		setOrdSrvMmDOs(ordSrvMmDOs, mapIdorsrvs);
		return saveOrdSrvMmDOs(ordSrvMmDOs);
	}

	/**
	 * 查询OrdSrvMmDO
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private OrdSrvMmDO[] getOrdSrvMmDOs(String[] id_orsrvs) throws BizException {
		if (CiOrdUtils.isEmpty(id_orsrvs))
			return null;
		String strIdorsrvs = "";
		for (String id_orsrv : id_orsrvs) {
			strIdorsrvs += ",'" + id_orsrv + "'";
		}
		return CiOrdAppUtils.getOrSrvMmQryService()
				.find(OrdSrvMmDODesc.TABLE_ALIAS_NAME + ".id_orsrv in (" + strIdorsrvs.substring(1) + ")", "",
						FBoolean.FALSE);
	}

	/**
	 * 设置OrdSrvMmDO
	 * @param ordSrvMmDOs
	 * @param mapIdorsrvs
	 */
	private void setOrdSrvMmDOs(OrdSrvMmDO[] ordSrvMmDOs, Map<String, String> mapIdorsrvs) {
		if (CiOrdUtils.isEmpty(ordSrvMmDOs))
			return;
		for (OrdSrvMmDO ordSrvMmDO : ordSrvMmDOs) {
			ordSrvMmDO.setId_orsrvmm(null);
			ordSrvMmDO.setId_orsrv(mapIdorsrvs.get(ordSrvMmDO.getId_orsrv()));
			ordSrvMmDO.setStatus(DOStatus.NEW);
		}
	}
	
	/**
	 * 保存OrdSrvMmDO
	 * @param ordSrvMmDOs
	 * @return
	 * @throws BizException
	 */
	private Boolean saveOrdSrvMmDOs(OrdSrvMmDO[] ordSrvMmDOs) throws BizException{
		if (CiOrdUtils.isEmpty(ordSrvMmDOs))
			return false;
		ordSrvMmDOs = CiOrdAppUtils.getOrsrvmmService().save(ordSrvMmDOs);
		return !CiOrdUtils.isEmpty(ordSrvMmDOs);
	}
}
