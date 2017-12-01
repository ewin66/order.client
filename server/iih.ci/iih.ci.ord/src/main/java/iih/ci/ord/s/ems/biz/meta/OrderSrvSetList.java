package iih.ci.ord.s.ems.biz.meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.DOStatus;

/**
 * 医嘱临床套列表
 * 
 * @author wangqingzhu
 *
 */
public class OrderSrvSetList extends ArrayList<OrdSrvSetDO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderSrvSetList() {
	}
	
	public OrderSrvSetList(List<OrdSrvSetDO> ls){
		this.addAll(ls);
	}

	public OrderSrvSetList(OrdSrvSetDO[] szInfo){
		this.addAll(Arrays.asList(szInfo));
		
	}
	
	public OrderSrvSetList append(OrdSrvSetDO[] szInfo){
		this.addAll(Arrays.asList(szInfo));
		return this;
	}
	
	public OrderSrvSetList append(OrderSrvSetList szInfo){
		this.addAll(szInfo);
		return this;
	}
	
	public OrdSrvSetDO[] asArray(){
		return this.toArray(new OrdSrvSetDO[size()]);
	}

	public OrderSrvSetMap asMap() {
		return new OrderSrvSetMap(this);
	}

	/**
	 * 设置逻辑删除标志
	 */
	public void logicDelete() {
		OrderSrvSetList removedList = new OrderSrvSetList();
		for (OrdSrvSetDO ordSrvSetDO : this) {

			if (!CiOrdUtils.isEmpty(ordSrvSetDO.getId_or())) {
				ordSrvSetDO.setStatus(DOStatus.DELETED);
			} else {
				removedList.add(ordSrvSetDO);
			}

		}
		if (removedList.size() > 0) {
			this.removeAll(removedList);
		}
	}
}
