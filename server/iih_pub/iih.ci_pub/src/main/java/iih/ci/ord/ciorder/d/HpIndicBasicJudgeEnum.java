package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface HpIndicBasicJudgeEnum {

    @DmEnumDesc(name="非医保就诊",description="患者本次就诊为非医保就诊（项目级的结论还得看项目的保内外标识即自费标识）")
    public static final String NOTHPPV="00"; //非医保就诊
    @DmEnumDesc(name="医保就诊",description="患者本次就诊为医保就诊（项目级的结论还得看项目的保内外标识即自费标识）")
    public static final String HPPV="10"; //医保就诊
    @DmEnumDesc(name="医保保内诊断",description="患者本次就诊为医保就诊且诊断在医保规定范围内（项目级的结论还得看项目的保内外标识即自费标识）")
    public static final String HPPVANDDIINHP="11"; //医保保内诊断
    @DmEnumDesc(name="医保保外诊断",description="患者本次就诊为医保就诊且诊断不在医保规定范围内（项目级的结论还得看项目的保内外标识即自费标识）")
    public static final String HPPVANDDINOTINHP="12"; //医保保外诊断
}	
