package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface LastOfMpRstTp {

    @DmEnumDesc(name="最后一顿",description="最后一顿")
	public static final Integer THELASTOFMP=1; //最后一顿
    @DmEnumDesc(name="非最后一顿",description="非最后一顿")
	public static final Integer NOTTHELASTOFMP=2; //非最后一顿
    @DmEnumDesc(name="尚未计算",description="尚未计算")
	public static final Integer UNKNOWN=3; //尚未计算
}	
