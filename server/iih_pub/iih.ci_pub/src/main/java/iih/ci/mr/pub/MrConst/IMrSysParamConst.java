package iih.ci.mr.pub.MrConst;

public class IMrSysParamConst {

	/**
	 *  编辑器参数
	 */
	
	public static final String SYS_PARAM_EDITOR_STARTBORDERCHAR="CIMR0005"; //元素边界起始字符
	
	public static final String SYS_PARAM_EDITOR_ENDBORDERCHAR="CIMR0010"; //元素边界结束字符
	
	public static final String SYS_PARAM_EDITOR_SHOWRULE="CIMR0015"; //默认是否显示标尺 true:显示；false:不显示
	
	public static final String SYS_PARAM_EDITOR_BORDERSTYLE="CIMR0020"; //控件边框样式 1:三维边框；2:单行边框；3:无边框
	
	public static final String SYS_PARAM_EDITOR_BACKCOLOR="CIMR0025"; //控件背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_CURRENTPAGEBORDERCOLOR="CIMR0030"; //当前页边框颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_PAGEBORDERCOLOR="CIMR0035"; //页边框颜色 可为空 value格式为：#ffffff 
	
	public static final String SYS_PARAM_EDITOR_SHOWPARAGRAPHFLAG="CIMR0040"; //默认是否显示段落标记 true:显示；false:不显示
	
	public static final String SYS_PARAM_EDITOR_FIELDBACKCOLOR="CIMR0045"; //输入域默认背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDHOVERBACKCOLOR="CIMR0050"; //输入域默认鼠标悬浮背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDFOCUSEDBACKCOLOR="CIMR0055"; //输入域默认获得焦点背景色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEFORECOLOR="CIMR0060"; //输入域内容校验不通过时的文本颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_FIELDINVALIDATEVALUEBACKCOLOR="CIMR0065"; //输入域内容校验不通过时的背景色 可为空 value格式为：#ffffff 
	
	public static final String SYS_PARAM_EDITOR_READONLYFIELDBORDERCOLOR="CIMR0070"; //内容只读的输入域的边界元素颜色 可为空 value为#ffffff
	
	public static final String SYS_PARAM_EDITOR_UNEDITABLEFIELDBORDERCOLOR="CIMR0075"; //内容不能直接修改的边界元素颜色
	
	public static final String SYS_PARAM_EDITOR_NORMALFIELDBORDERCOLOR="CIMR0080"; //常规的输入域的边界元素颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORMODIFIEDFIELD="CIMR0085"; //元素修改后状态标识颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORNORMALFIELD="CIMR0090"; //元素未修改状态标识颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORREADONLYFIELD="CIMR0095"; //元素只读状态标识颜色 可为空 value格式为：#ffffff 
	
	public static final String SYS_PARAM_EDITOR_TAGCOLORFORVALUEINVALIDATEFIELD="CIMR0100"; //元素验证错误状态标识颜色 可为空 value格式为：#ffffff
	
	public static final String SYS_PARAM_EDITOR_SHOWINPUTFIELDSTATETAG="CIMR0105"; //是否显示状态标识颜色 true：显示；false：不显示
	
	public static final String SYS_PARAM_EDITOR_COPYMODEL="CIMR0110"; //数据复制粘贴模式 0：系统范围复制粘贴；1：程序范围复制粘贴；2：编辑器控件范围复制粘贴
	
	public static final String SYS_PARAM_EDITOR_SHOWCELLNONEBORDER="CIMR0115"; //隐藏表格边框 true：显示；false：隐藏
	
	public static final String SYS_PARAM_EDITOR_SHOWFORMBUTTON="CIMR0120"; //是否显示表单控件 true：显示；false：不显示
	
	public static final String SYS_PARAM_EDITOR_PARAGRAPHFLAGFOLLOWTABLEORSECTION="CIMR0125"; //表格后是否紧跟段落符号 true：是；false：否
	
	public static final String SYS_PARAM_EDITOR_AUTOASSISTINSERTSTRING="CIMR0130"; //是否输入联想 true：开启联想；false：关闭联想

	public static final String SYS_PARAM_EDITOR_AUTOSAVESECOND="CIMR0135"; //自动保存无操作时间，以秒为单位，若时间为0则不启用
	
	public static final String SYS_PARAM_EDITOR_REGISTERCODE="CIMR0140"; //注册码
	
	public static final String SYS_PARAM_EDITOR_SHOWTOOTH="CIMR0155";//科室病历工具条书否显示牙位图

	public static final String SYS_PARAM_EDITOR_CHINESECHILDDIAGINDENT="CIMR0180";//科室中医诊断子诊断是否缩进
	
	public static final String SYS_PARAM_EDITOR_CHINESEDIAGNUMBER="CIMR0185";//科室中医诊断是否带有序号
	
	public static final String SYS_PARAM_EDITOR_ENGLISHCHILDDIAGINDENT="CIMR0190";//科室西医诊断子诊断是否缩进
	
	public static final String SYS_PARAM_EDITOR_ENGLISHDIAGNUMBER="CIMR0195";//科室西医诊断是否带有序号
	
	public static final String SYS_PARAM_EDITOR_CHILD_DIAG_SPACE = "CIMR0200";//科室子诊断前空格
	
	public static final String SYS_PARAM_EDITOR_DIAG_SPACE = "CIMR0205";//科室诊断前空格
	
	public static final String SYS_PARAM_EDITOR_DIAG_SAME_LINE="CIMR0210";//科室诊断是否与标签同行
	
	/**
	 * 上报卡
	 */
	
	public static final String SYS_PARAM_CARD_CONTAGIONSENDMOBILE="CIMR0145";//传染病保存通知手机号集合，多个以逗号分隔
	
	
	/**
	 * 门诊召回
	 */
	public static final String SYS_PARAM_OP_RC_MAXDAYS="CIMR0150";//门诊病历召回最大申请天数
	
	public static final String SYS_PARAM_OP_RC_DEFAULTDAYS="CIMR0160";//门诊病历召回默认天数 
	
	/**
	 * 门诊病历自动归档标识
	 */
	public static final String SYS_PARAM_MRM_CI_AUTOPIGEONHOLE = "CIMRM0005";
	
	/**
	 * 门诊病历自动归档时间间隔（小时）
	 */
	public static final String SYS_PARAM_MRM_CI_PIGEONHOLEINTERVAL = "CIMRM0010";
	
	/**
	 * 住院病历自动归档标识
	 */
	public static final String SYS_PARAM_MRM_HO_AUTOPIGEONHOLE = "CIMRM0025";
	
	/**
	 * 住院病历自动归档时间间隔（天）
	 */
	public static final String SYS_PARAM_MRM_HO_PIGEONHOLEINTERVAL = "CIMRM0030";
	
	/**
	 * 住院病历自动完成标识
	 */
	public static final String SYS_PARAM_MRM_HO_AUTOCOMPLETE = "CIMRM0015";
	
	/**
	 * 住院病历自动完成时间间隔（天）
	 */
	public static final String SYS_PARAM_MRM_HO_COMPLETEINTERVAL = "CIMRM0020";
	
	/**
	 * 门诊病历保存是否判断必填项
	 */
	public static final String SYS_PARAM_MR_CIMR_REQUIREDFIELD = "CIMR0165";
	
	/**
	 * 门诊病历保存是否判断互斥
	 */
	public static final String SYS_PARAM_MR_CIMR_MUTEXFIELD = "CIMR0170";
	
	/**
	 * 门诊病历打印是否预览
	 */
	public static final String SYS_PARAM_MR_CIMR_PRINTPREVIEW = "CIMR0175";
	/**
	 * 是否启用自动质控
	 */
	public static final String SYS_PARAM_MR_CIMR_AUTOQC = "CIMR0230";
	/**
	 * 是否启用环节质控
	 */
	public static final String SYS_PARAM_MR_CIMR_INTERQC = "CIMR0215";
	/**
	 * 是否启用科室质控
	 */
	public static final String SYS_PARAM_MR_CIMR_DEPTQC = "CIMR0220";
	/**
	 * 是否启用终末质控
	 */
	public static final String SYS_PARAM_MR_CIMR_TERMINALQC = "CIMR0225";
	/**
	 * 编辑器粘贴格式
	 */
	public static final String SYS_PARAM_EDITOR_DATAFORMAT="CIMR0240";
}
