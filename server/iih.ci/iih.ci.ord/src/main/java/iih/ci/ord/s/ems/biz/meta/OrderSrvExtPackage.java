package iih.ci.ord.s.ems.biz.meta;

import java.util.Arrays;

import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdUtils;

/**
 * 医嘱服务信息和医嘱套内项目信息
 * @author wangqingzhu
 *
 */
public class OrderSrvExtPackage {
	/**
	 * 服务套ID
	 */
	private String id_srv;
	/**
	 * 医嘱服务套信息列表
	 */
	private OrderSrvSetList ordSrvSetInfoList;
	
	/**
	 * 医嘱服务和物品信息列表
	 */
	private OrderSrvMmList ordSrvMmInfoList;
	
	/**
	 * 默认构造方法
	 */
	public OrderSrvExtPackage(){}
	
	/**
	 * 构造方法
	 * @param id_srv
	 * @param szOrdSrvInfo
	 */
	public OrderSrvExtPackage(String id_srv,OrderSrvMmInfo[] szOrdSrvInfo){
		this.id_srv = id_srv;
		this.ordSrvMmInfoList = new OrderSrvMmList(szOrdSrvInfo);
	}
	
	public OrderSrvExtPackage(String id_srv,OrderSrvMmList ordSrvInfoList){
		this.id_srv = id_srv;
		this.ordSrvMmInfoList = ordSrvInfoList;
	}
	public OrderSrvExtPackage(String id_srv,OrderSrvMmList ordSrvInfoList, OrderSrvSetList ordSrvSetInfoList){
		this.id_srv = id_srv;
		this.ordSrvMmInfoList = ordSrvInfoList;
		this.ordSrvSetInfoList = ordSrvSetInfoList;
	}
	
	public OrderSrvExtPackage(String id_srv,OrderSrvMmList ordSrvMmInfoList,OrdSrvSetDO[] szOrdSrvSetInfo){
		this.id_srv = id_srv;
		this.ordSrvMmInfoList = ordSrvMmInfoList;
		this.ordSrvSetInfoList = (OrderSrvSetList) Arrays.asList(szOrdSrvSetInfo);
	}
	
	public String getId_srv() {
		return id_srv;
	}
	
	public void setId_srv(String id_srv) {
		this.id_srv = id_srv;
	}
	
	public OrderSrvSetList getOrdSrvSetInfoList() {
		return ordSrvSetInfoList;
	}
	
	public void setOrdSrvSetInfoList(OrderSrvSetList ordSrvSetInfoList) {
		this.ordSrvSetInfoList = ordSrvSetInfoList;
	}
	
	public OrderSrvMmList getOrderSrvMmList() {
		return ordSrvMmInfoList;
	}
	
	public void setOrdSrvMmInfoList(OrderSrvMmList ordSrvMmInfoList) {
		this.ordSrvMmInfoList = ordSrvMmInfoList;
	}

	public void merge(OrderSrvExtPackage orderSrvExtPackage) {
		if (CiOrdUtils.isEmpty(this.ordSrvMmInfoList)){
			this.ordSrvMmInfoList = orderSrvExtPackage.getOrderSrvMmList();
		}
		else{
			this.ordSrvMmInfoList.append(orderSrvExtPackage.getOrderSrvMmList());
		}
		if (CiOrdUtils.isEmpty(this.ordSrvSetInfoList)){
			this.ordSrvSetInfoList = orderSrvExtPackage.getOrdSrvSetInfoList();
		}
		else{
			this.ordSrvSetInfoList.append(orderSrvExtPackage.getOrdSrvSetInfoList());
		}
	}
}
