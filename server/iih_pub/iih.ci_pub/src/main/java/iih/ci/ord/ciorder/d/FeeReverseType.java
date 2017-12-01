package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface FeeReverseType {

    @DmEnumDesc(name="记账后",description="【记账状态】=已记账，冲账类型 = 0")
	public static final Integer NOBLCANCEL=0; //记账后
    @DmEnumDesc(name="销账",description="记账未结算后的销账")
	public static final Integer BLCGCANCEL=1; //销账
    @DmEnumDesc(name="结算后冲账",description="记账并结算后的冲账")
	public static final Integer BLSTREVERSE=2; //结算后冲账
}	
