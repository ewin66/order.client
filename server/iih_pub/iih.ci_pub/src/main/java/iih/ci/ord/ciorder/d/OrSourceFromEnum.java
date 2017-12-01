package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface OrSourceFromEnum {

    @DmEnumDesc(name="服务参照",description="服务参照选择并确定医疗单保存生成")
    public static final String IIHSRVREF="01"; //服务参照
    @DmEnumDesc(name="服务分类",description="通过服务分类助手，选择服务并确定医疗单保存生成")
    public static final String IIHSRVCAHELPER="02"; //服务分类
    @DmEnumDesc(name="医嘱模板",description="通过医嘱模板助手，选择模板保存生成")
    public static final String IIHORTMPLHELPER="03"; //医嘱模板
    @DmEnumDesc(name="医技常规",description="通过医技常规助手，选择常规项保存生成")
    public static final String IIHMTROUTINEHELPER="04"; //医技常规
    @DmEnumDesc(name="患者既往",description="通过患者既往助手，选择医嘱处置项保存生成")
    public static final String IIHPATIPASTHELPER="05"; //患者既往
    @DmEnumDesc(name="组套",description="通过组套助手，选择医嘱处置项保存生成")
    public static final String IIHCLINICALKITHELPER="06"; //组套
    @DmEnumDesc(name="医嘱复制",description="通过本次就诊医嘱处置的选择，复制保存生成")
    public static final String IIHORCLONE="07"; //医嘱复制
    @DmEnumDesc(name="关联生成",description="通过医嘱关联，自动生成并保存生成")
    public static final String IIHORRELAUTOGEN="08"; //关联生成
    @DmEnumDesc(name="临床路径",description="通过临床路径CP助手，选择并保存生成")
    public static final String IIHCPHELPER="09"; //临床路径
    @DmEnumDesc(name="服务参照（语音）",description="语音服务参照选择并确定医疗单保存生成")
    public static final String IIHSRVREF8VOICE="0A"; //服务参照（语音）
    @DmEnumDesc(name="住院医嘱复制",description="住院医嘱复制功能")
    public static final String IIHOPORCOPY="0B"; //住院医嘱复制
    @DmEnumDesc(name="第三方系统",description="来源第三方系统")
    public static final String THIRDPARTYSYS="10"; //第三方系统
    @DmEnumDesc(name="医技补费",description="通过医技补录费用医嘱")
    public static final String IIHMEDTECHORDERS="0C"; //医技补费
}	
