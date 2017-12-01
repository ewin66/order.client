package iih.ci.ord.s.ems.biz.meta;

import java.util.ArrayList;
import java.util.Arrays;

import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;

/**
 * 变动用药列表
 * @author wangqingzhu
 *
 */
public class OrderSrvDoseList extends ArrayList<OrdSrvDoseDO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public OrderSrvDoseList(OrdSrvDoseDO[] szInfo){
		this.addAll(Arrays.asList(szInfo));
	}
	
	public OrdSrvDoseDO[] asArray(){
		return this.toArray(new OrdSrvDoseDO[size()]);
	}

}
