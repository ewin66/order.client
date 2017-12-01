package iih.ci.ord.s.ems.biz.meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdUtils;
/**
 * 医嘱包列表
 * @author wangqingzhu
 *
 */
public class OrderPackageInfoList extends ArrayList<OrderPackageInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OrderPackageInfoList(){}
	
	public OrderPackageInfoList(OrderPackageInfo[] szInfo){
		this.addAll(Arrays.asList(szInfo));
	}
	
	/**
	 * 转化为数组
	 * @return
	 */
	public OrderPackageInfo[] asArray(){
		return this.toArray(new OrderPackageInfo[size()]);
	}

	/**
	 * 提取医嘱数组
	 * @return
	 */
	public CiOrderDO[] asOrderArray(){
		CiOrderDO[] szOrderInfo = new CiOrderDO[size()];
		int index = 0;
		for (OrderPackageInfo info : this){
			szOrderInfo[index++] = info.getOrderInfo();
		}
		return szOrderInfo;
	}
	/**
	 * 提取服务信息集合
	 * @return
	 */
	public OrdSrvDO[] asOrderSrvArray(){
		OrderSrvList orderSrvInfoList = new OrderSrvList();
		
		for (OrderPackageInfo info : this){
			orderSrvInfoList.append(info.getOrderSrvList());
		}
		return orderSrvInfoList.size() > 0? orderSrvInfoList.asArray() : null;
	}
	
	public OrdSrvMmDO[] asOrderSrvMmArray(){
		
		List<OrdSrvMmDO> listOrdSrvMmDO = new ArrayList<OrdSrvMmDO>();
		for (OrderPackageInfo info : this){
			if(!CiOrdUtils.isEmpty(info.getOrderSrvMmList())){
				for (OrderSrvMmInfo srvMmInfo : info.getOrderSrvMmList()){
					if (!CiOrdUtils.isEmpty(srvMmInfo.getOrderSrvMmInfo())){
						listOrdSrvMmDO.add(srvMmInfo.getOrderSrvMmInfo());
					}
				}
			}
		}
		return listOrdSrvMmDO.size() >0? listOrdSrvMmDO.toArray(new OrdSrvMmDO[listOrdSrvMmDO.size()]) : null;
	}
	
	public OrdSrvSetDO[] asOrderSrvSetArray(){
		OrderSrvSetList orderSrvSetInfoList = new OrderSrvSetList();
		
		for (OrderPackageInfo info : this){
			if (!CiOrdUtils.isEmpty(info.getOrderSrvSetList()))
				orderSrvSetInfoList.append(info.getOrderSrvSetList());
		}
		return orderSrvSetInfoList.size() > 0? orderSrvSetInfoList.asArray(): null;
	}
}
