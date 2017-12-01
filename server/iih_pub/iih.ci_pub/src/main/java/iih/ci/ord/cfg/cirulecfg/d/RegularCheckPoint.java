package iih.ci.ord.cfg.cirulecfg.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface RegularCheckPoint {

    @DmEnumDesc(name="保存医嘱",description="医嘱保存（校验规则）")
    public static final String SAVE="10"; //保存医嘱
    @DmEnumDesc(name="医嘱签署",description="医嘱签署（校验规则）")
    public static final String SIGN="11"; //医嘱签署
    @DmEnumDesc(name="医嘱撤回",description="医嘱撤回（校验规则）")
    public static final String REVOKE="12"; //医嘱撤回
    @DmEnumDesc(name="医嘱停止",description="医嘱停止（校验规则）")
    public static final String STOP="13"; //医嘱停止
    @DmEnumDesc(name="医嘱作废",description="医嘱作废（校验规则）")
    public static final String CANCEL="14"; //医嘱作废
    @DmEnumDesc(name="医嘱删除",description="医嘱删除（校验规则）")
    public static final String DELETE="15"; //医嘱删除
    @DmEnumDesc(name="服务启用",description="服务启用（校验规则）")
    public static final String ENABLE="20"; //服务启用
    @DmEnumDesc(name="超天数开单校验",description="超天数开单校验（校验规则）")
    public static final String EXCESSIVE="25"; //超天数开单校验
    @DmEnumDesc(name="合单规则",description="合单规则（业务路基规则）")
    public static final String MERGE_BILL="A1"; //合单规则
    @DmEnumDesc(name="分方规则",description="分方规则（业务路基规则）")
    public static final String HANDLE_PRES="A2"; //分方规则
    @DmEnumDesc(name="草药分方规则",description="草药分方规则（业务路基规则）")
    public static final String HANDLE_HERBS_PRES="A21"; //草药分方规则
}	
