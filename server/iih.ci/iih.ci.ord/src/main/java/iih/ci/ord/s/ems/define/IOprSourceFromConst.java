package iih.ci.ord.s.ems.define;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

/**
 * 医疗单符合接口操作数据来源
 * @author wangqingzhu
 *
 */
public interface IOprSourceFromConst {
	@DmEnumDesc(name="医疗单操作",description="标识当前接口发送的操作数据为基于医疗单的信息")
    public static final String IOSF_EMS="01"; // 医疗单
	@DmEnumDesc(name="助手操作",description="标识当前接口发送的操作数据为基于助手的信息")
    public static final String IOSF_HLP="10"; //助手
	@DmEnumDesc(name="模板操作",description="标识当前接口发送的操作数据为基于医疗单的信息")
    public static final String IOSF_HLP_TMPL="11"; //模板助手
	@DmEnumDesc(name="医技操作",description="标识当前接口发送的操作数据为基于医疗单的信息")
    public static final String IOSF_HLP_MEDTECTH="12"; //医技助手
	@DmEnumDesc(name="服务分类操作",description="标识当前接口发送的操作数据为基于医疗单的信息")
    public static final String IOSF_HLP_SRVCA="13"; //服务分类助手
	@DmEnumDesc(name="就诊历史操作",description="标识当前接口发送的操作数据为基于医疗单的信息")
    public static final String IOSF_HLP_HIS="14"; //就诊历史助手
	@DmEnumDesc(name="门诊组套操作",description="标识当前接口发送的操作数据为基于医疗单的信息")
    public static final String IOSF_HLP_GRP="15"; //门诊组套操作
	
}
