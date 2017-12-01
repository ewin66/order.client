package iih.ci.mr.i;

public class ICiMrNSysParamConst {
	
	//region 编辑器用
	
	public static final String SYS_PARAM_MrWordStartBorderChar="CIMR0005";//元素边界符起始字符
	public static final String SYS_PARAM_MrWordEndBorderChar="CIMR0010";//元素边界符结束字符
	public static final String SYS_PARAM_MrWordShowRule="CIMR0015";//是否显示标尺 true:显示；false:不显示
	public static final String SYS_PARAM_MrWordBorderStyle="CIMR0020";//控件边框样式  1:三维边框；2:单行边框；3:无边框
	public static final String SYS_PARAM_MrWordBackColor="CIMR0025";//控件背景色 可为空 value格式为：#ffffff
	public static final String SYS_PARAM_MrWordCurrentPageBorderColor="CIMR0030";//当前页边框颜色 可为空 value格式为：#ffffff
	public static final String SYS_PARAM_MrWordPageBorderColor="CIMR0035";//页边框颜色 可为空 value格式为：#ffffff
	public static final String SYS_PARAM_MrWordShowParagraphFlag="CIMR0040";//默认是否显示段落标记 true:显示；false:不显示
	public static final String SYS_PARAM_MrWordFieldBackColor="CIMR0045";//输入域默认背景色 可为空 value格式为：#ffffff
	public static final String SYS_PARAM_MrWordFieldHoverBackColor="CIMR0050";//输入域默认鼠标悬浮背景色 可为空 value格式为：#ffffff
	public static final String SYS_PARAM_MrWordFieldFocusedBackColor="CIMR0055";//输入域默认获得焦点背景色 可为空 value格式为：#ffffff
	public static final String SYS_PARAM_MrWordFieldInvalidateValueForeColor="CIMR0060";//输入域内容校验不通过时的文本颜色 可为空 value格式为：#ffffff 
	public static final String SYS_PARAM_MrWordFieldInvalidateValueBackColor="CIMR0065";//输入域内容校验不通过时的背景色 可为空 value格式为：#ffffffs
	public static final String SYS_PARAM_MrWordReadonlyFieldBorderColor="CIMR0070";//内容只读的输入域的边界元素颜色 可为空 value为#ffffff
	public static final String SYS_PARAM_MrWordUneditableFieldBorderColor="CIMR0075";//内容不能直接修改的边界元素颜色 可为空 value为#ffffff
	public static final String SYS_PARAM_MrWordNormalFieldBorderColor="CIMR0080";//常规的输入域的边界元素颜色 可为空 value格式为：#ffffff
	public static final String SYS_PARAM_MrWordTagColorForModifiedField="CIMR0085";//元素修改后状态标识颜色 可为空 value格式为：#ffffff
	public static final String SYS_PARAM_MrWordTagColorForNormalField="CIMR0090";//元素未修改状态标识颜色 可为空 value格式为：#ffffff
	public static final String SYS_PARAM_MrWordTagColorForReadonlyField="CIMR0095";//元素只读状态标识颜色 可为空 value格式为：#ffffff
	public static final String SYS_PARAM_MrWordTagColorForValueInvalidateField="CIMR0100";//元素验证错误状态标识颜色 可为空 value格式为：#ffffff
	public static final String SYS_PARAM_MrWordShowInputFieldStateTag="CIMR0105";// 是否显示状态标识颜色 true：显示；false：不显示。
	public static final String SYS_PARAM_MrWordCopyModel="CIMR0110";//数据复制粘贴模式 0：系统范围复制粘贴；1：程序范围复制粘贴；2：编辑器控件范围复制粘贴。
	public static final String SYS_PARAM_MrWordShowCellNoneBorder="CIMR0115";//隐藏表格边框 true：显示；false：隐藏
	public static final String SYS_PARAM_MrWordShowFormButton="CIMR0120";//是否显示表单控件 true：显示；false：不显示
	public static final String SYS_PARAM_MrWordParagraphFlagFollowTableOrSection="CIMR0125";//表格后是否紧跟段落符号 true：是；false：否
	public static final String SYS_PARAM_MrWordAutoAssistInsertString="CIMR0130";//是否输入联想 true：开启联想；false：关闭联想
	public static final String SYS_PARAM_MrWordAutoSaveSecond="CIMR0135";//自动保存无操作时间，以秒为单位，若时间为0则不启用
	public static final String SYS_PARAM_MrWordRegisterCode="CIMR0140";//注册码
	
	//endregion
	
	
	//region 业务使用
	
	//endregion
	
	
	//region 基础数据
	
	//endregion
	

	//region 编辑器档案定义
	
	/**
	 * CIMR0020
	 * 控件边框样式  
	 */
	public static final String PARAM_MrWordBorderStyle_Data3d ="1";//三维边框
	public static final String PARAM_MrWordBorderStyle_Single="2";//单行边框
	public static final String PARAM_MrWordBorderStyle_Nothing="3";//无边框
	
	/**
	 * CIMR0105
	 * 数据复制粘贴模式
	 */
	public static final String PARAM_MrWordCopyModel_System = "0"; //系统范围复制粘贴
	public static final String PARAM_MrWordCopyModel_Program = "1"; //程序范围复制粘贴
	public static final String PARAM_MrWordCopyModel_Word = "2"; //编辑器控件范围复制粘贴
	
	//endregion
	
	
	//region 业务档案定义
	
	//endregion
	
	
	//region 基础数据档案定义
	
	//endregion
	
}
