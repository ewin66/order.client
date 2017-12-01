package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface OrSrvSourceFromEnum {

    @DmEnumDesc(name="医生开立",description="医生开立")
	public static final Integer PHYSIAN=0; //医生开立
    @DmEnumDesc(name="用法关联费用派生",description="用法关联费用派生")
	public static final Integer USAGERELFEE=1; //用法关联费用派生
    @DmEnumDesc(name="付款策略派生价格代理（套）",description="付款策略派生价格代理（套）")
	public static final Integer AGENTFROMPRIMD=2; //付款策略派生价格代理（套）
    @DmEnumDesc(name="护士核对补录",description="护士核对补录")
	public static final Integer NURSECHECKADD=3; //护士核对补录
    @DmEnumDesc(name="医技执行补录",description="医技执行补录")
	public static final Integer MTEXECADD=4; //医技执行补录
    @DmEnumDesc(name="煎法关联费用派生",description="煎法关联费用派生")
	public static final Integer BOILRELFEE=5; //煎法关联费用派生
    @DmEnumDesc(name="临床路径执行（废弃不用）",description="临床路径执行（废弃不用）")
	public static final Integer CP=7; //临床路径执行（废弃不用）
    @DmEnumDesc(name="床边执行",description="床边执行")
	public static final Integer BEDMP=6; //床边执行
    @DmEnumDesc(name="付款策略派生价格代理（组合）",description="付款策略派生价格代理（组合）")
	public static final Integer AGENTFROMCOMPPRIMD=8; //付款策略派生价格代理（组合）
    @DmEnumDesc(name="会诊受邀科室费用派生",description="会诊受邀科室费用派生")
	public static final Integer FROMCONSDEPFEE=9; //会诊受邀科室费用派生
    @DmEnumDesc(name="关联服务策略派生",description="关联服务派生")
	public static final Integer RELSRVTACTIC=10; //关联服务策略派生
    @DmEnumDesc(name="医生费用补录",description="医生费用补录")
	public static final Integer PHYSIANFEEADD=11; //医生费用补录
    @DmEnumDesc(name="标本关联费用派生",description="标本关联费用派生")
	public static final Integer SPECIMENRELFEE=12; //标本关联费用派生
    @DmEnumDesc(name="标本容器关联派生",description="标本容器关联派生")
	public static final Integer SPECIMENVESSELRELFEE=13; //标本容器关联派生
    @DmEnumDesc(name="其它",description="其它")
	public static final Integer OTHER=99; //其它
}	
