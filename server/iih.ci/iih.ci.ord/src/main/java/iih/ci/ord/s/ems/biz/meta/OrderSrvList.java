package iih.ci.ord.s.ems.biz.meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import xap.mw.core.data.FArrayList;

/**
 * 医嘱服务列表
 * @author wangqingzhu
 *
 */
public class OrderSrvList extends ArrayList<OrdSrvDO> {
	private static final long serialVersionUID = 1L;

	public OrderSrvList(){}
	
	public OrderSrvList(FArrayList ls){
		this.addAll(ls);
	}
	public OrderSrvList(List<OrdSrvDO> ls){
		this.addAll(ls);
	}
	public OrderSrvList(OrdSrvDO[] sz){
		this.addAll(Arrays.asList(sz));
	}
	
	public OrdSrvDO[] asArray(){
		return this.toArray(new OrdSrvDO[size()]);
	}
	
	public OrderSrvList append(OrdSrvDO[] szOrdSrvInfo){
		this.addAll(Arrays.asList(szOrdSrvInfo));
		
		return this;
	}
	
	public OrderSrvList append(List<OrdSrvDO> ordSrvInfoList){
		this.addAll(ordSrvInfoList);
		
		return this;
	}
}
