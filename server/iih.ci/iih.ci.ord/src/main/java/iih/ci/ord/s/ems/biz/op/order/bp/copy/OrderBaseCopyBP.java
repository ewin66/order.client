package iih.ci.ord.s.ems.biz.op.order.bp.copy;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 复制基类
 * 
 * @author Young
 *
 */
public class OrderBaseCopyBP {

	/**
	 * 执行复制
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public final Boolean copy(String[] id_ors) throws BizException {
		Map<String, String> mapIdors = new HashMap<String, String>();
		Map<String, String> mapIdorsrvs = new HashMap<String, String>();
		CiorderAggDO[] aggDOs = getCiorderAggDOs(id_ors);
		if (CiOrdUtils.isEmpty(aggDOs))
			return false;
		FDateTime dt = CiOrdAppUtils.getServerDateTime();
		setCiorderAggDOs(aggDOs, mapIdors, mapIdorsrvs, dt);
		saveCiorderAggDOs(aggDOs);

		copyCiorSrvMM(mapIdorsrvs, dt);
		copyCiorSrvSet(mapIdors, dt);
		copyCiorderAppInfo(mapIdors, dt);
		return true;
	}

	/**
	 * 查询CiorderAggDO
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	protected CiorderAggDO[] getCiorderAggDOs(String[] id_ors) throws BizException {
		if (CiOrdUtils.isEmpty(id_ors))
			return null;
		return CiOrdAppUtils.getOrAggQryService().findByIds(id_ors, FBoolean.FALSE);
	}

	/**
	 * 重置CiorderAggDO
	 * 
	 * @param aggDOs
	 */
	protected void setCiorderAggDOs(CiorderAggDO[] aggDOs, Map<String, String> mapIdors, Map<String, String> mapIdorsrvs, FDateTime dt) {
		if (CiOrdUtils.isEmpty(aggDOs))
			return;
		//生成ID
		String[] idors = new DBUtil().getOIDs(aggDOs.length);
		int i = 0;
		for (CiorderAggDO aggDO : aggDOs) {
			CiOrderDO ciOrderDO = aggDO.getParentDO();
			mapIdors.put(ciOrderDO.getId_or(), idors[i]);
			ciOrderDO.setId_or(idors[i]);
			ciOrderDO.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);
			ciOrderDO.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);
			ciOrderDO.setDt_entry(dt);
			ciOrderDO.setDt_effe(dt);
			ciOrderDO.setDt_end(dt.addSeconds(ciOrderDO.getDays_or() != null ? ciOrderDO.getDays_or() * 24 * 3600 : 0));
			ciOrderDO.setFg_sign(new FBoolean(false));
			ciOrderDO.setDt_sign(null);
			ciOrderDO.setId_dep_sign(null);
			ciOrderDO.setId_emp_sign(null);
			ciOrderDO.setDt_last_bl(dt);
			ciOrderDO.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
			ciOrderDO.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
			ciOrderDO.setFg_flush2mr(FBoolean.FALSE);
			ciOrderDO.setFg_canc(FBoolean.FALSE);
			ciOrderDO.setDt_canc(null);
			ciOrderDO.setId_emp_canc(null);
			ciOrderDO.setId_dep_canc(null);
			
			// 获取执行科室
//			OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ems.getEnContext(), ciOrderDO, "", "");
//			if (null != wf) {
//				ciOrderDO.setId_dep_mp(wf.getFirstid_mp_dept());//执行科室
//			}
			
			ciOrderDO.setDt_last_mp(null);
			ciOrderDO.setStatus(DOStatus.NEW);

			OrdSrvDO[] ordSrvDOs = aggDO.getOrdSrvDO();
			if (CiOrdUtils.isEmpty(ordSrvDOs))
				continue;
			String[] idorsrvs = new DBUtil().getOIDs(ordSrvDOs.length);
			int j = 0;
			for (OrdSrvDO ordSrvDO : ordSrvDOs) {
				if (FBoolean.TRUE.equals(ordSrvDO.getFg_mm())) {
					mapIdorsrvs.put(ordSrvDO.getId_orsrv(), idorsrvs[j]);
				}
				ordSrvDO.setId_orsrv(idorsrvs[j]);
				ordSrvDO.setId_or(idors[i]);
				ordSrvDO.setId_pres(null);
				//				ordSrvDO.setId_su_mp(Sd_su_mp);
				//				ordSrvDO.setId_su_bl(Sd_su_bl);
				//				ordSrvDO.setSd_su_mp(Sd_su_mp);
				//				ordSrvDO.setSd_su_bl(Sd_su_bl);
				//				ordSrvDO.setDt_last_bl(Dt_last_bl);
				//				ordSrvDO.setDt_last_mp(Dt_last_mp);
				//				ordSrvDO.setDt_last_cg(Dt_last_cg);
				
				ordSrvDO.setDt_create(dt);
//				ordSrvDO.setQuan_medu(Quan_medu);
//				ordSrvDO.setQuan_total_medu(Quan_total_medu);

				ordSrvDO.setStatus(DOStatus.NEW);

				j++;
			}

			i++;
		}
	}

	/**
	 * 保存CiorderAggDO
	 * 
	 * @param aggDOs
	 * @return
	 * @throws BizException
	 */
	protected CiorderAggDO[] saveCiorderAggDOs(CiorderAggDO[] aggDOs) throws BizException {
		if (CiOrdUtils.isEmpty(aggDOs))
			return null;
		return CiOrdAppUtils.getOrAggService().save(aggDOs);
	}

	/**
	 * 复制临床服务物品
	 * 
	 * @param mapIdorsrvs
	 * @return
	 * @throws BizException
	 */
	private Boolean copyCiorSrvMM(Map<String, String> mapIdorsrvs, FDateTime dt) throws BizException {
		OrderSrvMMCopyBP srvMMCopyBP = new OrderSrvMMCopyBP();
		return srvMMCopyBP.copy(mapIdorsrvs, dt);
	}

	/**
	 * 复制临床服务套
	 * 
	 * @param mapIdors
	 * @return
	 * @throws BizException
	 */
	private Boolean copyCiorSrvSet(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		OrderSrvSetCopyBP srvSetCopyBP = new OrderSrvSetCopyBP();
		return srvSetCopyBP.copy(mapIdors, dt);
	}

	/**
	 * 复制医嘱相关申请单
	 * 
	 * @param id_ors
	 */
	protected Boolean copyCiorderAppInfo(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		return true;
	}
}
