package iih.ci.ord.s.ems.biz.op.base.bp;

import java.util.List;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.biz.utils.OrderSrvRefUtils;
import xap.mw.core.data.BizException;

public class EmsMedicinesSaveBP extends EmsBaseSaveBP {
	
	@Override
	protected OrderPackageInfo[] handleCreateOrderInfo(CiEnContextDTO ctx, List<Object> listUiModel)
			throws BizException {
		OrderPackageInfo[] orderPakageInfos = super.handleCreateOrderInfo(ctx, listUiModel);
		if(CiOrdUtils.isEmpty(orderPakageInfos))
			return null;
		// 处理用法关联服务
		for (OrderPackageInfo pInfo : orderPakageInfos) {
			handleOrderRouteInfo(pInfo,pInfo.getUiModel());
			handleOrderSrvRelInfo(pInfo, pInfo.getOrderSrvList());
		}
		return orderPakageInfos;
	}
	
	/**
	 * 处理医嘱关联服务的状态
	 * @param pInfo
	 * @param szOrdSrvInfo
	 * @throws BizException
	 */
	protected void handleOrderSrvRelInfo(OrderPackageInfo pInfo, OrdSrvDO[] szOrdSrvInfo) throws BizException {
		
	}
	
	/**
	 * 合并用户数据到默认医嘱中
	 * @param ctx 就诊上下文
	 * @param szOrderPakageInfo 批量医嘱包信息
	 * @return 批量医嘱包信息（合并过信息）
	 * @throws BizException 业务异常
	 */
	protected OrderPackageInfo[]  mergeOrderPakageInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPakageInfo) throws BizException{
		// 
		OrderPackageInfo[] rstOrderPackageInfo = super.mergeOrderPakageInfo(ctx, szOrderPakageInfo);
		for (OrderPackageInfo pInfo : szOrderPakageInfo) {
			
			// 合并医嘱服务变动用药
			if (pInfo.getOrderSrvDoseList() != null && pInfo.getOrderSrvDoseList().size() > 0) {
				//mergeOrderDoseInfo(ctx, pInfo.getOrderSrvDoseList(), pInfo.getUiModel());
			}
		}
		return rstOrderPackageInfo;
	}
	
	/**
	 * 合并变动用药信息
	 * 
	 * @param ctx
	 * @param doseList
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderDoseInfo(CiEnContextDTO ctx, OrdSrvDoseDO[] doseList, Object uiModel) throws BizException {

	}
	
	/**
	 * 处理服务用法描述信息
	 * 
	 * @param srvInfo
	 * @param uiModelInfo
	 */
	protected void handleOrderSrvRouteDesInfo(OrdSrvDO srvInfo, Object uiModelInfo) throws BizException {

	}

	/**
	 * 处理用法信息
	 * 
	 * @param srvInfo
	 * @param uiModelInfo
	 */
	protected void handleOrderRouteInfo(OrderPackageInfo opInfo,  Object uiModelInfo) throws BizException {
		// 获得用法关联费用项目
		OrdSrvDO[] routeRelFeeSrvs = OrderSrvRefUtils.RouteRelFeeSrvs(this.getEnContextInfo(), opInfo.getOrderInfo());
		// 将用法关联的费用添加到agg中
		OrderSrvMmList listOrderSrvInfo = opInfo.getOrderSrvMmList();
		if (!CiOrdUtils.isEmpty(routeRelFeeSrvs) && !CiOrdUtils.isEmpty(listOrderSrvInfo)) {
			
			// 合并后的数组
			listOrderSrvInfo.append(routeRelFeeSrvs);
			
		}
		
	}

	/**
	 * 处理药品属性信息
	 * 
	 * @param srvInfo
	 * @param uiModelInfo
	 */
	protected void handleOrderSrvDrugInfo(OrdSrvDO srvInfo, Object uiModelInfo) throws BizException {
		//		ordInfo.setFg_extdispense(FBoolean.FALSE) ;
		//		ordInfo.setFg_base(FBoolean Fg_base) ;
		//		ordInfo.setFg_dose_anoma(srvAgg.getParentDO().getFg_dose_anoma()) ;
		//		ordInfo.setFg_pres_outp(FBoolean.FALSE) ;
		//		ordInfo.setFg_self(FBoolean.FALSE);
	}
}
