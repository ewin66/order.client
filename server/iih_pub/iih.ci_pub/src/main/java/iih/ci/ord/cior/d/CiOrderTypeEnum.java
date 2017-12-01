package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface CiOrderTypeEnum {

    @DmEnumDesc(name="会诊医嘱",description="会诊医嘱")
	public static final Integer CONSULTORDER=1; //会诊医嘱
    @DmEnumDesc(name="转科医嘱",description="转科医嘱")
	public static final Integer DEPT2DEPTORDER=2; //转科医嘱
    @DmEnumDesc(name="床边手术医嘱",description="床边手术医嘱")
	public static final Integer BEDOPORDER=3; //床边手术医嘱
    @DmEnumDesc(name="台次手术医嘱",description="台次手术医嘱")
	public static final Integer OPERATIONORDER=4; //台次手术医嘱
    @DmEnumDesc(name="抢救医嘱",description="抢救医嘱")
	public static final Integer RESCUEORDER=5; //抢救医嘱
    @DmEnumDesc(name="死亡医嘱",description="死亡医嘱")
	public static final Integer DEATHORDER=6; //死亡医嘱
    @DmEnumDesc(name="出院医嘱",description="出院医嘱")
	public static final Integer OUTHOSPORDER=7; //出院医嘱
    @DmEnumDesc(name="手术医嘱",description="手术医嘱（含台次与床边等手术）")
	public static final Integer ALLOPORDER=8; //手术医嘱
    @DmEnumDesc(name="未知医嘱类型",description="未知医嘱类型")
	public static final Integer UNKNOWNORDER=99; //未知医嘱类型
    @DmEnumDesc(name="护理等级医嘱",description="护理等级医嘱")
	public static final Integer NSGRADEORDER=9; //护理等级医嘱
    @DmEnumDesc(name="营养膳食医嘱",description="营养膳食医嘱")
	public static final Integer NUTRIONDIETORDER=10; //营养膳食医嘱
    @DmEnumDesc(name="用血医嘱",description="用血医嘱")
	public static final Integer USEBTORDER=11; //用血医嘱
    @DmEnumDesc(name="病情医嘱",description="病情医嘱")
	public static final Integer ILLSTATEORDER=12; //病情医嘱
    @DmEnumDesc(name="化疗医嘱",description="化疗医嘱")
	public static final Integer CHEMOTHERAPYORDER=13; //化疗医嘱
    @DmEnumDesc(name="放疗医嘱",description="放疗医嘱")
	public static final Integer RIDIOTHERAPYORDER=14; //放疗医嘱
    @DmEnumDesc(name="透析医嘱",description="透析医嘱")
	public static final Integer DIALYSISORDER=15; //透析医嘱
    @DmEnumDesc(name="跨科医嘱",description="跨科医嘱")
	public static final Integer CROSSDEPTORDER=16; //跨科医嘱
}	
