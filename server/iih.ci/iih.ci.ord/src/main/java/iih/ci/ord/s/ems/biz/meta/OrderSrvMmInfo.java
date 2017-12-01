package iih.ci.ord.s.ems.biz.meta;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;

/**
 * 医嘱服务物品信息集合
 * @author wangqingzhu
 *
 */
public class OrderSrvMmInfo {
	private OrdSrvDO orderSrvInfo;
	
	private OrdSrvMmDO orderSrvMmInfo;
	
	private Object uiModel;
	
	
	public OrderSrvMmInfo(){}
	
	public OrderSrvMmInfo(OrdSrvDO orderSrvInfo, Object uiModel){
		this.orderSrvInfo = orderSrvInfo;
		this.uiModel = uiModel;
	}
	
	public OrderSrvMmInfo(OrdSrvDO srvInfo, OrdSrvMmDO srvMmInfo, Object uiModel){
		this.orderSrvInfo = srvInfo;
		this.orderSrvMmInfo = srvMmInfo;
		this.uiModel = uiModel;
	}

	public OrdSrvDO getOrderSrvInfo() {
		return orderSrvInfo;
	}

	public void setOrderSrvInfo(OrdSrvDO orderSrvInfo) {
		this.orderSrvInfo = orderSrvInfo;
	}

	public OrdSrvMmDO getOrderSrvMmInfo() {
		return orderSrvMmInfo;
	}

	public void setOrderSrvMmInfo(OrdSrvMmDO orderSrvMmInfo) {
		this.orderSrvMmInfo = orderSrvMmInfo;
	}

	public Object getUiModel() {
		return uiModel;
	}

	public void setUiModel(Object uiModel) {
		this.uiModel = uiModel;
	}
	
	
}
