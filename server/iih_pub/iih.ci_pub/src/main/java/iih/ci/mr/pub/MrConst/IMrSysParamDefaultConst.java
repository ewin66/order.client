package iih.ci.mr.pub.MrConst;

public class IMrSysParamDefaultConst {

	/**
	 *  编辑器参数
	 */
	public static final String SYS_PARAM_EDITOR_STARTBORDERCHAR_DEFAULT="{"; //元素边界起始字符
	
	public static final String SYS_PARAM_EDITOR_ENDBORDERCHAR_DEFAULT="}"; //元素边界结束字符
	
	public static final String SYS_PARAM_EDITOR_SHOWRULE_DEFAULT="true"; //默认是否显示标尺 true:显示；false:不显示
	
	public static final String SYS_PARAM_EDITOR_BORDERSTYLE_DEFAULT="1"; //控件边框样式 1:三维边框；2:单行边框；3:无边框
	
	public static final String SYS_PARAM_EDITOR_BACKCOLOR_DEFAULT=""; //控件背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_CURRENTPAGEBORDERCOLOR_DEFAULT=""; //当前页边框颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_PAGEBORDERCOLOR_DEFAULT=""; //页边框颜色 可为空 value格式为：#ffffff 
	
	public static final String SYS_PARAM_EDITOR_SHOWPARAGRAPHFLAG_DEFAULT="true"; //默认是否显示段落标记 true:显示；false:不显示
	
	public static final String SYS_PARAM_EDITOR_FIELDBACKCOLOR_DEFAULT=""; //输入域默认背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDHOVERBACKCOLOR_DEFAULT=""; //输入域默认鼠标悬浮背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDFOCUSEDBACKCOLOR_DEFAULT=""; //输入域默认获得焦点背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEFORECOLOR_DEFAULT=""; //输入域内容校验不通过时的文本颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEBACKCOLOR_DEFAULT=""; //输入域内容校验不通过时的背景色 可为空 value格式为：#ffffff 
	
	public static final String SYS_PARAM_EDITOR_READONLYFIELDBORDERCOLOR_DEFAULT=""; //内容只读的输入域的边界元素颜色 可为空 value为#ffffff
	
	public static final String SYS_PARAM_EDITOR_UNEDITABLEFIELDBORDERCOLOR_DEFAULT=""; //内容不能直接修改的边界元素颜色  可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_NORMALFIELDBORDERCOLOR_DEFAULT=""; //常规的输入域的边界元素颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORMODIFIEDFIELD_DEFAULT=""; //元素修改后状态标识颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORNORMALFIELD_DEFAULT=""; //元素未修改状态标识颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORREADONLYFIELD_DEFAULT=""; //元素只读状态标识颜色 可为空 value格式为：#ffffff 
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORVALUEINVALIDATEFIELD_DEFAULT=""; //元素验证错误状态标识颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_SHOWINPUTFIELDSTATETAG_DEFAULT="true"; //是否显示状态标识颜色 true：显示；false：不显示
	
	public static final String SYS_PARAM_EDITOR_COPYMODEL_DEFAULT="0"; //数据复制粘贴模式 0：系统范围复制粘贴；1：程序范围复制粘贴；2：编辑器控件范围复制粘贴
	
	public static final String SYS_PARAM_EDITOR_SHOWCELLNONEBORDER_DEFAULT="true"; //隐藏表格边框 true：显示；false：隐藏
	
	public static final String SYS_PARAM_EDITOR_SHOWFORMBUTTON_DEFAULT="false"; //是否显示表单控件 true：显示；false：不显示
	
	public static final String SYS_PARAM_EDITOR_PARAGRAPHFLAGFOLLOWTABLEORSECTION_DEFAULT="true"; //表格后是否紧跟段落符号 true：是；false：否
	
	public static final String SYS_PARAM_EDITOR_AUTOASSISTINSERTSTRING_DEFAULT="false"; //是否输入联想 true：开启联想；false：关闭联想

	public static final String SYS_PARAM_EDITOR_AUTOSAVESECOND_DEFAULT="0"; //自动保存无操作时间，以秒为单位，若时间为0则不启用
	
	public static final String SYS_PARAM_EDITOR_REGISTERCODE_DEFAULT=""; //注册码
	
	public static final String SYS_PARAM_EDITOR_SHOWTOOTH_DEFAULT="false";//科室病历工具条书否显示牙位图

	public static final String SYS_PARAM_EDITOR_CHINESECHILDDIAGINDENT_DEFAULT="true";//科室中医诊断子诊断是否缩进
	
	public static final String SYS_PARAM_EDITOR_CHINESEDIAGNUMBER_DEFAULT="false";//科室中医诊断是否带有序号
	
	public static final String SYS_PARAM_EDITOR_ENGLISHCHILDDIAGINDENT_DEFAULT="true";//科室西医诊断子诊断是否缩进
	
	public static final String SYS_PARAM_EDITOR_ENGLISHDIAGNUMBER_DEFAULT="true";//科室西医诊断是否带有序号
	
	public static final String SYS_PARAM_EDITOR_CHILD_DIAG_SPACE_DEFAULT = "2";//科室子诊断前空格
	
	public static final String SYS_PARAM_EDITOR_DIAG_SPACE_DEFAULT = "2";//科室诊断前空格
	
	public static final String SYS_PARAM_EDITOR_DIAG_SAME_LINE_DEFAULT="false";//科室诊断是否与标签同行
	
	/**
	 * 上报卡
	 */
	public static final String SYS_PARAM_CARD_CONTAGIONSENDMOBILE_DEFAULT="";//传染病保存通知手机号集合，多个以逗号分隔
	
	/**
	 * 门诊召回最大天数
	 * 此数值需要不小于SYS_PARAM_OP_RC_DEFAULTDAYS_DEFAULT
	 */
	public static final String SYS_PARAM_OP_RC_MAXDAYS_DEFAULT="7";
	
	/**
	 * 病历召回默认天数
	 * 此数值需要不大于SYS_PARAM_OP_RC_MAXDAYS_DEFAULT
	 */
	public static final String SYS_PARAM_OP_RC_DEFAULTDAYS_DEFAULT="2";
	
	/**
	 * 门诊病历自动归档标识
	 */
	public static final Boolean SYS_PARAM_MRM_CI_AUTOPIGEONHOLE_DEFAULT = false;
	
	/**
	 * 门诊病历自动归档时间间隔（小时）
	 */
	public static final int SYS_PARAM_MRM_CI_PIGEONHOLEINTERVAL_DEFAULT = 3;
	
	/**
	 * 住院病历自动归档标识
	 */
	public static final Boolean SYS_PARAM_MRM_HO_AUTOPIGEONHOLE_DEFAULT = false;
	
	/**
	 * 住院病历自动归档时间间隔（天）
	 */
	public static final int SYS_PARAM_MRM_HO_PIGEONHOLEINTERVAL_DEFAULT = 7;
	
	/**
	 * 住院病历自动完成标识
	 */
	public static final Boolean SYS_PARAM_MRM_HO_AUTOCOMPLETE_DEFAULT = false;
	
	/**
	 * 住院病历自动完成时间间隔（天）
	 */
	public static final int SYS_PARAM_MRM_HO_COMPLETEINTERVAL_DEFAULT = 3;
	
	/**
	 * 门诊病历保存是否判断必填项
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_REQUIREDFIELD_DEFAULT =false;
	
	/**
	 * 门诊病历保存是否判断互斥
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_MUTEXFIELD_DEFAULT = false;
	
	/**
	 * 门诊病历打印是否预览
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_PRINTPREVIEW_DEFAULT = false;
	/**
	 * 是否启用自动质控
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_AUTOQC_DEFAULT = true;
	/**
	 * 是否启用环节质控
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_INTERQC_DEFAULT = true;
	/**
	 * 是否启用科室质控
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_DEPTQC_DEFAULT = true;
	/**
	 * 是否启用终末质控
	 */
	public static final Boolean SYS_PARAM_MR_CIMR_TERMINALQC_DEFAULT = true;
	/**
	 * 编辑器粘贴格式
	 */
	public static final String SYS_PARAM_EDITOR_DATAFORMAT_DEFAULT="0";
}
