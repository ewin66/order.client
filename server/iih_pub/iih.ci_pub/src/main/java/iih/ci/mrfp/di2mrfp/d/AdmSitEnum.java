package iih.ci.mrfp.di2mrfp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface AdmSitEnum {

    @DmEnumDesc(name="有",description="有")
	public static final Integer YOU=1; //有
    @DmEnumDesc(name="临床未确定",description="临床未确定")
	public static final Integer LINCHUANGWEIQUEDING=2; //临床未确定
    @DmEnumDesc(name="情况不明",description="情况不明")
	public static final Integer QINGKUANGBUMING=3; //情况不明
    @DmEnumDesc(name="无",description="无")
	public static final Integer WU=4; //无
}	
