package iih.ci.ord.emsdi.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PvStatusQryRstEnum {

    @DmEnumDesc(name="临床就诊信息数据参数校验空",description="临床就诊信息数据参数校验空")
	public static final Integer PVINFOPARAMCHECKNULL=1; //临床就诊信息数据参数校验空
    @DmEnumDesc(name="患者就诊登记信息查询数据空",description="患者就诊登记信息查询数据空")
	public static final Integer PVINFOQRYDONULL=2; //患者就诊登记信息查询数据空
    @DmEnumDesc(name="已退诊患者",description="已退诊患者")
	public static final Integer CANCELEDPATI=3; //已退诊患者
    @DmEnumDesc(name="已出院患者",description="已出院患者")
	public static final Integer OUTHOSPPATI=4; //已出院患者
    @DmEnumDesc(name="已转科患者",description="已转科患者")
	public static final Integer TRANSDEPTPATI=5; //已转科患者
    @DmEnumDesc(name="正常",description="正常")
	public static final Integer NORMAL=99; //正常
}	
