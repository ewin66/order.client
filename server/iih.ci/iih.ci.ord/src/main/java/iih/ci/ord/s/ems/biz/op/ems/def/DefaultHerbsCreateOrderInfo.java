package iih.ci.ord.s.ems.biz.op.ems.def;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import xap.mw.core.data.BizException;

/**
 * 默认草药创建医嘱
 * @author wangqingzhu
 *
 */
public class DefaultHerbsCreateOrderInfo extends DefaultDrugsCreateOrderInfo {

	@Override
	protected DefaultBaseCreateOrderInfo createOrderInfo(OrderPackageInfo orderPakageInfo, MedSrvDO mainBdSrvInfo)
			throws BizException {
		//by yzh 2017-08-23 19:04:50  添加医嘱付数和用法
		EmsDrugItemDO uiModel = (EmsDrugItemDO) orderPakageInfo.getUiModel();
		orderPakageInfo.getOrderInfo().setOrders(uiModel.getOrders());
		orderPakageInfo.getOrderInfo().setId_boil(uiModel.getId_boil());
		orderPakageInfo.getOrderInfo().setId_srvof(uiModel.getId_srvof());
		return super.createOrderInfo(orderPakageInfo, mainBdSrvInfo);
	}
	
}
