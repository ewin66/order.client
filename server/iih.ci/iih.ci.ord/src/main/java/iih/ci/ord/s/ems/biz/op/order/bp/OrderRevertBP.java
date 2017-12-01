package iih.ci.ord.s.ems.biz.op.order.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciprn.i.ICiprintExtService;
import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.MOdOrdsrv4PresBP;
import iih.ci.ord.s.bp.OpLatelySessionOrsGetBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderRevertBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医嘱撤回
 * 
 * @author Young
 *
 */
public class OrderRevertBP implements IOrderRevertBP {

	@Override
	public OrderRstDTO revert(OrderOperateDTO arg) throws BizException {
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

			if (ICiDictCodeConst.SD_SU_SIGN.equals(cior.getSd_su_or()) && FBoolean.TRUE.equals(cior.getFg_sign())
					&& ICiDictCodeConst.SD_SU_MP_NONE.equals(cior.getSd_su_mp())
					&& ICiDictCodeConst.SD_SU_BL_NONE.equals(cior.getSd_su_bl())) {
				//				ICiDictCodeConst.SD_SU_BL_REFOUND.equals(cior.getSd_su_bl()) 已退费的医嘱不可撤回，如可撤回则可以删除医嘱，费用与对应项目找不到对应的医嘱项目，妍妍确认20170802
				lstCiOrderDOs.add(cior);
				lstIdors.add(cior.getId_or());
			}
		}

		if (lstCiOrderDOs.size() < 1) {
			throw new BizException("所选的医嘱已经执行或已经收费，不能撤销！");
		}

		ciors = lstCiOrderDOs.toArray(new CiOrderDO[lstCiOrderDOs.size()]);

		// 对应会话区间撤销状态信息修改
		OpLatelySessionOrsGetBP bpOpLatelySession = new OpLatelySessionOrsGetBP();
		bpOpLatelySession.exec(ciors[0].getId_en(), lstIdors.toArray(new String[lstIdors.size()]));

		// 清医嘱项目中处方标识
		MOdOrdsrv4PresBP bpMOdOrdsrv = new MOdOrdsrv4PresBP();
		bpMOdOrdsrv.exec(lstIdors.toArray(new String[lstIdors.size()]));

		// 医嘱状态修改
		this.updateOrderStatus(ciors);

		// 撤回时，如果存在服务已经判断过特殊病标志，应该将特殊病标志设置为N未判断状态
		this.resetSpecil(lstIdors.toArray(new String[lstIdors.size()]));

		// 清除打印数据
		this.clearPrintData(lstIdors.toArray(new String[lstIdors.size()]));

		//		Runnable r = new OrderDeleteDataRunnable(lstIdors.toArray(new String[lstIdors.size()]), ciors);
		//		ExecutorUtil.startRunnable(r);

		// 集成平台消息发送
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
		String[] arrayFieldNames = new String[] { CiOrderDO.ID_SU_OR, CiOrderDO.SD_SU_OR, CiOrderDO.FG_SIGN,
				CiOrderDO.DT_SIGN, CiOrderDO.ID_DEP_SIGN, CiOrderDO.ID_EMP_SIGN, CiOrderDO.DT_LAST_BL,
				CiOrderDO.ID_SU_BL, CiOrderDO.SD_SU_BL, CiOrderDO.FG_FLUSH2MR };
		for (CiOrderDO order : orders) {
			order.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);//医嘱状态
			order.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);
			order.setFg_sign(new FBoolean(false));//签署标识
			order.setDt_sign(null);//签署日期
			order.setId_dep_sign(null);//签署科室
			order.setId_emp_sign(null);//签署医生
			order.setDt_last_bl(order.getDt_effe());//最新计费日期
			order.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);//计费状态
			order.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
			order.setFg_flush2mr(FBoolean.FALSE);//写回病历标识
		}
		new DAFacade().updateDOArray(orders, arrayFieldNames);
	}

	/**
	 * 重置特殊病标志
	 * 
	 * @param id_ors_temp
	 * @throws BizException
	 */
	private void resetSpecil(String[] id_ors_temp) throws BizException {
		if (CiOrdUtils.isEmpty(id_ors_temp))
			return;
		StringBuffer sb = new StringBuffer();
		for (String id : id_ors_temp) {
			sb.append(",'" + id + "'");
		}
		OrdSrvDO[] ordSrvDOs = CiOrdAppUtils.getOrSrvQryService().find(
				String.format("id_or in (%s) and fg_specill='Y'", sb.toString().substring(1)), "", FBoolean.FALSE);

		if (ordSrvDOs.length > 0) {
			for (OrdSrvDO srv : ordSrvDOs) {
				srv.setFg_specill(FBoolean.FALSE);
			}
			//			CiOrdAppUtils.getOrSrvService().update(ordSrvDOs);
			new DAFacade().updateDOArray(ordSrvDOs, new String[] { OrdSrvDO.FG_SPECILL });
		}
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
