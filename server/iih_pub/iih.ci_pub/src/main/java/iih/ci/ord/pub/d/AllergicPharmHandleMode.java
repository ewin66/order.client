package iih.ci.ord.pub.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface AllergicPharmHandleMode {

    @DmEnumDesc(name="过敏用药禁用",description="过敏用药禁用")
	public static final Integer ALLERGICPHARMFORBIDDEN=0;
    @DmEnumDesc(name="过敏再皮试",description="过敏再皮试")
	public static final Integer ALLERGICRESKINTEST=1;
    @DmEnumDesc(name="皮肤过敏试验",description="皮肤过敏试验")
	public static final Integer SKINALLERGICTEST=3;
    @DmEnumDesc(name="过敏强制使用",description="过敏强制使用")
	public static final Integer ALLERGICFORCEDUSE=2;
    @DmEnumDesc(name="过敏排除后直接使用（本次不需再皮试）",description="过敏排除后直接使用（本次不需再皮试）")
	public static final Integer DIRECTUSEEXCLUDEALLERGIC=4;
    @DmEnumDesc(name="过敏皮试结果未出",description="过敏皮试结果未出，需提示并做人工选择")
	public static final Integer WAITSKINTESTRPT=5;
    @DmEnumDesc(name="未知",description="未知")
	public static final Integer UNKNOWN=9;
}	
