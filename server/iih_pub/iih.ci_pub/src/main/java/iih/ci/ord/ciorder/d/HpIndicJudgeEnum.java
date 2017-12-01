package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface HpIndicJudgeEnum {

    @DmEnumDesc(name="不需要判断",description="不需要医保逻辑判断")
	public static final Integer NONEEDJUDGE=0; //不需要判断
    @DmEnumDesc(name="待判断",description="需医生根据医保限制条件做适应与否医保判断")
	public static final Integer WAITINGJUDGE=1; //待判断
    @DmEnumDesc(name="已判断",description="医生已根据医保限制条件做适应症与否结论")
	public static final Integer JUDGED=2; //已判断
    @DmEnumDesc(name="自费",description="医疗单勾选自费")
   	public static final Integer SELFPAY=9; //自费
}	
