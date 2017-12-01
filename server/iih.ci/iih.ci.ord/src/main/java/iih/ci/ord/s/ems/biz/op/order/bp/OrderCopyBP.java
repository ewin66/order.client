package iih.ci.ord.s.ems.biz.op.order.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.OrderBaseCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.OrderCopyFactory;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.apbt.OrderApbtCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.apbu.OrderApbuCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.cons.OrderConsCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.drugs.OrderDrugsCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.herbs.OrderHerbsCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.lis.OrderLisCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.pathgy.OrderPathgyCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.ris.OrderRisCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.treat.OrderTreatCopyBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱复制
 * 
 * @author Young
 *
 */
public class OrderCopyBP implements IOrderCopyBP {

	@Override
	public OrderRstDTO copy(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		OrderRstDTO rstDTO = new OrderRstDTO();
		FArrayList paramList = arg.getDocument();
		if (paramList == null || paramList.size() <= 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		List<String> lstIdors = new ArrayList<String>();
		for (Object obj : paramList) {
			if (CiOrdUtils.isEmpty(obj))
				continue;
			lstIdors.add(obj.toString());
		}
		if (lstIdors.size() == 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		// 获得医嘱集合
		CiOrderDO[] ciors = CiOrdAppUtils.getOrQryService().findByBIds(lstIdors.toArray(new String[lstIdors.size()]),
				FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(ciors)) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		
		List<CiOrderDO> lstCiOrderDOs = new ArrayList<CiOrderDO>();
		lstIdors.clear();
		for (CiOrderDO cior : ciors) {
			if (ICiDictCodeConst.SD_SU_CANCEL.equals(cior.getSd_su_or())
					&& FBoolean.TRUE.equals(cior.getFg_sign())
					&& FBoolean.TRUE.equals(cior.getFg_canc())
					&& FBoolean.FALSE.equals(cior.getFg_uncancelable())
					&& (ICiDictCodeConst.SD_SU_BL_NONE.equals(cior.getSd_su_bl()) 
							|| ICiDictCodeConst.SD_SU_BL_REFOUND.equals(cior.getSd_su_bl()))) {
				lstCiOrderDOs.add(cior);
				lstIdors.add(cior.getId_or());
			}
		}

		if (lstCiOrderDOs.size() < 1) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		OrderCopyFactory factory = new OrderCopyFactory();
		Map<String, List<String>> mapIdors = factory.getMapIdors(lstCiOrderDOs.toArray(new CiOrderDO[] {}));

		for (String key : mapIdors.keySet()) {
			OrderBaseCopyBP bp = factory.getOrderCopyBP(key);
			bp.copy(mapIdors.get(key).toArray(new String[] {}));
		}

		rstDTO.setIsSuccess(FBoolean.TRUE);
		return rstDTO;
	}
}
