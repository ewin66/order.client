package iih.ci.ord.pub.listener;

public interface ICiEventConst {
	public static final String CIOR_STATUS_EVENT_SOURCEID="iih.ci.ord.ciorder.CiOrStatusShift";  //临床医嘱状态迁移
	public static final String CIOR_STATUS_SIGN2OPEN_EVENT_SOURCEID="iih.ci.ord.ciorder.CiOrStatusShift_SIGNCANCEL";  //临床医嘱状态迁移_签署到OPEN
	public static final String CIOR_AGAIN_DEL="iih.ci.ord.mr_cxff_del";  //门诊重分方删除
	public static final String CIOR_AGAIN_NEW="iih.ci.ord.mr_cxff_new";  //门诊重分方新增
}
