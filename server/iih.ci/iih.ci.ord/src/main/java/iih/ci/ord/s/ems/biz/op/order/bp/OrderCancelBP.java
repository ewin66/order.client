package iih.ci.ord.s.ems.biz.op.order.bp;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAFacade;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciprn.i.ICiprintExtService;
import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.MOdOrdsrv4PresBP;
import iih.ci.ord.s.bp.OpLatelySessionOrsGetBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderCancelBP;

/**
 * 医嘱作废
 * 
 * @author Young
 *
 */
public class OrderCancelBP implements IOrderCancelBP {

	@Override
	public OrderRstDTO cancel(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		OrderRstDTO rstDTO = new OrderRstDTO();
		FArrayList paramList = arg.getDocument();
		FMap2 map = arg.getExtension();
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
			throw new BizException("没有符合操作的数据，请刷新列表！");
		}

		List<CiOrderDO> lstCiOrderDOs = new ArrayList<CiOrderDO>();
		lstIdors.clear();
		for (CiOrderDO cior : ciors) {
			if (!cior.getSd_su_or().equals(map.get(cior.getId_or())))
				throw new BizException("医嘱状态已经发生变化，请刷新列表！");

			if (FBoolean.TRUE.equals(cior.getFg_sign())
					&& FBoolean.FALSE.equals(cior.getFg_canc())
					&& FBoolean.FALSE.equals(cior.getFg_uncancelable())
					&& (ICiDictCodeConst.SD_SU_BL_NONE.equals(cior.getSd_su_bl()) 
							|| ICiDictCodeConst.SD_SU_BL_REFOUND.equals(cior.getSd_su_bl()))) {
				lstCiOrderDOs.add(cior);
				lstIdors.add(cior.getId_or());
			}
		}

		if (lstCiOrderDOs.size() < 1) {
			throw new BizException("所选的医嘱已经执行或已经收费，不能作废！");
		}

		ciors = lstCiOrderDOs.toArray(new CiOrderDO[lstCiOrderDOs.size()]);

		// 对应会话区间撤销状态信息修改
		OpLatelySessionOrsGetBP bpOpLatelySession = new OpLatelySessionOrsGetBP();
		bpOpLatelySession.exec(ciors[0].getId_en(), lstIdors.toArray(new String[lstIdors.size()]));

		// 清医嘱项目中处方标识
		MOdOrdsrv4PresBP bpMOdOrdsrv = new MOdOrdsrv4PresBP();
		bpMOdOrdsrv.exec(lstIdors.toArray(new String[lstIdors.size()]));

		// 更新医嘱状态
		updateOrderStatus(ciors);

		// 删除打印数据
		clearPrintData(lstIdors.toArray(new String[lstIdors.size()]));

		//		Runnable r = new OrderDeleteDataRunnable(lstIdors.toArray(new String[lstIdors.size()]), ciors);
		//		ExecutorUtil.startRunnable(r);

		//集成平台消息发送
		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_SIGN2OPEN_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciors);

		rstDTO.setIsSuccess(FBoolean.TRUE);
		return rstDTO;
	}

	/**
	 * 更新医嘱状态
	 * 
	 * @param orders
	 * @throws BizException
	 */
	private void updateOrderStatus(CiOrderDO[] orders) throws BizException {
		String[] arrayFieldNames = new String[] { CiOrderDO.ID_SU_OR, CiOrderDO.SD_SU_OR, CiOrderDO.ID_EMP_CANC,
				CiOrderDO.ID_DEP_CANC, CiOrderDO.FG_CANC, CiOrderDO.DT_CANC };
		FDateTime dt = CiOrdAppUtils.getServerDateTime();
		for (CiOrderDO order : orders) {
			order.setId_su_or(ICiDictCodeConst.SD_SU_ID_CANCEL);//医嘱状态
			order.setSd_su_or(ICiDictCodeConst.SD_SU_CANCEL);
			order.setId_emp_canc(order.getId_emp_sign());//作废人信息，只有签署的可作废，只有签署人才可作废本人签署的医嘱
			order.setId_dep_canc(order.getId_dep_sign());//作废科室信息
			order.setFg_canc(FBoolean.TRUE);//作废标识
			order.setDt_canc(dt);//作废日期
		}
		new DAFacade().updateDOArray(orders, arrayFieldNames);
	}

	/**
	 * 删除打印数据
	 * 
	 * @param ids
	 * @throws BizException
	 */
	private void clearPrintData(String[] ids) throws BizException {
		ICiprintExtService service = ServiceFinder.find(ICiprintExtService.class);
		service.DeleteAppLisData(ids);
		service.DeleteAppRisData(ids);
		service.DeleteAppPathgyData(ids);
		service.DeleteFeeBillsData(ids);
		service.DeleteTreateExecData(ids);
	}
}
