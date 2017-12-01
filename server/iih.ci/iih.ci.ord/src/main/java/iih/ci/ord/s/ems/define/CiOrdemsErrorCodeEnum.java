package iih.ci.ord.s.ems.define;

public interface CiOrdemsErrorCodeEnum {

	// 医疗单错误编码
	public static final int ERRORCODE_EMS_ISNULL = 1000;
	public static final String ERRORMSG_EMS_ISNULL = "医疗单为空";
	public static final int ERRORCODE_EMS_APPSHEET_NULL = ERRORCODE_EMS_ISNULL+1;
	public static final String ERRORMSG_EMS_APPSHEET_NULL = "申请单为空";
	public static final int ERRORCODE_EMS_MAINSRV_NULL = ERRORCODE_EMS_ISNULL+2;
	public static final String ERRORMSG_EMS_MAINSRV_NULL = "主服务信息为空";
	public static final int ERRORCODE_EMS_APBU_TMPL_NULL = ERRORCODE_EMS_ISNULL+3;
	public static final String ERRORMSG_EMS_APBU_TMPL_NULL = "用血模板为空";
	
	
	// 医嘱相关的错误代码
	public static final int ERRORCODE_ORDER_ISNULL = 2000;
	public static final String ERRORMSG_ORDER_ISNULL = "未能获取医嘱信息";
	public static final int ERRORCODE_ORDER_BTAPPSHEET_NULL = ERRORCODE_ORDER_ISNULL + 1;
	public static final String ERRORMSG_ORDER_BTAPPSHEET_NULL = "备血申请单为空";
	public static final int ERRORCODE_ORDER_SETITEMS_NULL = ERRORCODE_ORDER_ISNULL + 2;
	public static final String ERRORMSG_ORDER_SETITEMS_NULL = "医嘱服务套项目为空";
	public static final int ERRORCODE_ORDER_TOTALFEE_OVERFLOW = ERRORCODE_ORDER_ISNULL + 3;
	public static final String ERRORMSG_ORDER_TOTALFEE_OVERFLOW = "费用不足";
	
	
	// 科室相关错误代码
	public static final int ERRORCODE_DEPT_NULL = 3000;
	public static final String ERRORMSG_DEPT_NULL = "科室信息为空";
	public static final int ERRORCODE_DEPT_MP_NULL = ERRORCODE_DEPT_NULL+1;
	public static final String ERRORMSG_DEPT_MP_NULL = "执行科室为空";
	public static final int ERRORCODE_DEPT_WH_NULL = ERRORCODE_DEPT_NULL+2;
	public static final String ERRORMSG_DEPT_WH_NULL = "物资流向科室为空";
	
	// 基础数据错误
	public static final int ERRORCODE_BDSRV_NULL = 4000;
	public static final int ERRORCODE_BDSRV_PROPERTY_NULL = ERRORCODE_BDSRV_NULL + 1;
	
	// 医疗单默认创建逻辑中存在的错误
	public static final int ERRORCODE_EMS_DEFCREATE_DIFFMODELSIZE = 5000;
	public static final String ERRORMSG_EMS_DEFCREATE_DIFFMODELSIZE = "获取的服务数据与用户数据大小不一致";
}
