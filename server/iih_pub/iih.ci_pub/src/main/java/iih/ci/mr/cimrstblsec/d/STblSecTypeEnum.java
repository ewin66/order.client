package iih.ci.mr.cimrstblsec.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface STblSecTypeEnum {

    @DmEnumDesc(name="表头",description="")
	public static final Integer TBLHEAD=0; //表头
    @DmEnumDesc(name="表体",description="")
	public static final Integer TBLBODY=1; //表体
    @DmEnumDesc(name="表尾",description="")
	public static final Integer TBLTAIL=2; //表尾
}	
