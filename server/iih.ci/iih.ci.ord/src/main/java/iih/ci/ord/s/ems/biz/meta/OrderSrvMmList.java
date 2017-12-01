package iih.ci.ord.s.ems.biz.meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.define.StringList;
import xap.mw.core.data.DOStatus;

/**
 * 医嘱物品列表
 * @author wangqingzhu
 *
 */
public class OrderSrvMmList extends ArrayList<OrderSrvMmInfo>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public OrderSrvMmList(){}
	
	public OrderSrvMmList(List<OrderSrvMmInfo> ls){
		this.addAll(ls);
	}
	
	public OrderSrvMmList(OrderSrvMmList ls){
		this.addAll(ls);
	}
	
	public OrderSrvMmList(OrderSrvMmInfo[] szInfo){
		this.addAll(Arrays.asList(szInfo));
	}
	
	public OrderSrvMmList(OrdSrvDO[] szInfo){
		this.append(szInfo);
	}
	
	public OrderSrvMmList append(OrderSrvMmInfo[] szInfo){
		this.addAll(Arrays.asList(szInfo));
		return this;
	}
	
	public OrderSrvMmList append(OrderSrvMmList ls){
		this.addAll(ls);
		return this;
	}
	
	/**
	 * 转化为对象数组
	 * @return
	 */
	public OrdSrvMmDO[] asArray(){
		return this.toArray(new OrdSrvMmDO[size()]);
	}
	/**
	 * 获取服务id的集合
	 * @return
	 */
	public String[] asSrvKeyArray(){
		StringList srvKeyList = new StringList();
		for (OrderSrvMmInfo srvMmInfo : this){
			srvKeyList.add(srvMmInfo.getOrderSrvInfo().getId_srv());
		}
	
		return srvKeyList.asArray();
	}
	/**
	 * 追加医嘱服务集合
	 * @param szInfo
	 * @return
	 */
	public OrderSrvMmList append(OrdSrvDO[] szInfo){
		for (OrdSrvDO srvInfo : szInfo){
			this.add(new OrderSrvMmInfo(srvInfo,null));
		}
		return this;
	}
	/**
	 * 设置逻辑删除标志
	 */
	public void logicDelete(){
	
		for (OrderSrvMmInfo srvMmInfo : this){
			if (!CiOrdUtils.isEmpty(srvMmInfo.getOrderSrvInfo())){
				if(!CiOrdUtils.isEmpty(srvMmInfo.getOrderSrvInfo().getId_orsrv())){
					srvMmInfo.getOrderSrvInfo().setStatus(DOStatus.DELETED);
				}
				
				if (!CiOrdUtils.isEmpty(srvMmInfo.getOrderSrvMmInfo())){
					srvMmInfo.getOrderSrvMmInfo().setStatus(DOStatus.DELETED);
				}
			}
		}
		
	}
}
