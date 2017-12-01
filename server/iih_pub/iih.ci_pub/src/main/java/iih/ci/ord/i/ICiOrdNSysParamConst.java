package iih.ci.ord.i;
/**
 * 临床医嘱系统参数
 * 这是新整理后的参数常量
 * 暂时都先使用这里的参数值
 */
public class ICiOrdNSysParamConst {
	/**
	 * 临床医嘱参数常量
	 */
	public static final String SYS_PARAM_OrEarlyEntryMaxHours="CIOR0005"; //医嘱可提前录入最大小时数（医嘱生效时间）	OrEarlyEntryMaxHours"
	public static final String SYS_PARAM_TemporaryPrnOrValidTime="CIOR0010"; //临时备用医嘱有效时间（小时）	TemporaryPrnOrValidTime"
	public static final String SYS_PARAM_OpOrValidTime="CIOR0015"; //门诊医嘱有效时间范围（小时）	OpOrValidTime"
	public static final String SYS_PARAM_ORSRVSPLITDTENDMAXALLOWDAYS="CIOR0020"; //医嘱或服务拆分截止时间与当前时间最大允许的天数间隔	OrSrvSplitDtEndMaxAllowDays"
	public static final String SYS_PARAM_ClinicalDiagSysCfg="CIOR0025"; //临床诊断系统设置（组织）	ClinicalDiagSysCfg11  西医、12  中医、13  蒙医	11,12则页签显示   西医页签和中医页签                        空则无页签显示"
	public static final String SYS_PARAM_ClinicalDiagSysCfg_D="CIOR0025"; //临床诊断系统设置（部门）	ClinicalDiagSysCfg	11  西医、12  中医、13  蒙医	11,12则页签显示   西医页签和中医页签                        空则无页签显示"
	public static final String SYS_PARAM_OrSignChkMaxLeadTime="CIOR0030"; //护士医嘱签署确认时，医嘱签署确认最大可提前时间（分钟）	OrSignChkMaxLeadTime	空时不受限制"
	public static final String SYS_PARAM_OrStopChkMaxLeadTime="CIOR0035"; //护士医嘱停止确认时，医嘱停止确认最大可提前时间（分钟）	OrStopChkMaxLeadTime"
	public static final String SYS_PARAM_OrChkSrvScope4MakeupFee="CIOR0040"; //护士医嘱确认补录费用时，可录入服务范围设置（组织）	OrChkSrvScope4MakeupFee"
	public static final String SYS_PARAM_OrChkSrvScope4MakeupFee_D="CIOR0040"; //护士医嘱确认补录费用时，可录入服务范围设置（部门）	OrChkSrvScope4MakeupFee"
	public static final String SYS_PARAM_DtCalEffModeWithinNDays="CIOR0045"; //N天内有效业务表达时，时间计算的有效模式	DtCalEffModeWithinNDays	0 24小时模式	1 日开始时间模式"""
	public static final String SYS_PARAM_OrSignOrEffTimeTolerance="CIOR0050"; //医嘱签署与医嘱生效时间间的有效允差（分钟）	OrSignOrEffTimeTolerance"
	public static final String SYS_PARAM_AllergyQryYearLimit="CIOR0055"; //药品过敏史查询年限（皮试判断用）	AllergyQryYearLimit"
	public static final String SYS_PARAM_PharmAllergyHandleMode="CIOR0060"; //药物过敏的处理模式（皮试判断用）	PharmAllergyHandleMode	0 药品禁用	1 再皮试	2 强制使用"""
	public static final String SYS_PARAM_AllergicSkinTestValidPeriodStr="CIOR0065"; //过敏皮试效期字串（年龄月，效期天）	AllergicSkinTestValidPeriodStr	默认值：0~168,1;169~,3      0到168月效期1天（14岁以下含14岁效期1天 ）;169月以上效期3天（14岁以上效期3天）"	
	public static final String SYS_PARAM_OrConsPatVisDays="CIOR0070"; //会诊患者系统可见天数	OrConsPatVisDays"
	public static final String SYS_PARAM_OpDocBillOperationMode="CIOR0075";		//门诊医生费用操作模式	枚举	2	0 不需查看 1 可查看但不可编辑 2 可编辑费用"
	public static final String SYS_PARAM_OpSrvScope4DocMakeupFee="CIOR0080";	//门诊医生补录费用时，可录入服务范围设置（组织）	字符串	空	
	public static final String SYS_PARAM_OpSrvScope4DocMakeupFee_D="CIOR0080";	//门诊医生补录费用时，可录入服务范围设置（部门）	字符串	空	
	public static final String SYS_PARAM_OpListMarshalSequenceMode="CIOR0085";	//医嘱列表排列顺序模式	1 倒序  2 顺序
	public static final String SYS_PARAM_OpMrMgmtMode="CIOR0090";	//门诊病历管理模式	0医生打印	1病案统一打印	2无纸化模式  3医生手写
	public static final String SYS_PARAM_OpLisShareTubeRuleActive = "CIOR0095"; // 诊疗视图可预看天数 默认值0
	public static final String SYS_PARAM_CiViewCanPreDays = "CIOR0100"; // 诊疗视图可预看天数 默认值0
	//public static final String SYS_PARAM_CiPharmMpInUsageScope = "CIOR0105"; // 常规在院执行药品给药途径范围设置 去掉参数CIOR0105 改为使用CIOR0115
	public static final String SYS_PARAM_CiOrFgMpInDefaultVPlugin = "CIOR0110"; // 临床医嘱在院执行标识默认值设置插件
	public static final String SYS_PARAM_CiPharmGrpableUsageScope = "CIOR0115"; // 药品可成组使用用法范围设置
	public static final String SYS_PARAM_CiOrSplit4PresTransPlugin = "CIOR0120"; // 临床医嘱分方业务插件设置
	public static final String SYS_PARAM_IsMedInsuranceCheckUse = "CIOR0125"; // 临床医嘱是否启用医保校验逻辑
	public static final String SYS_PARAM_IsRationalPharmUseCheck = "CIOR0130"; // 临床医嘱是否启用合理用药校验逻辑
	public static final String SYS_PARAM_OpThisPatVisitFinishMode = "CIOR0135"; // 门诊就诊诊毕的管理模式       0无诊毕   1仅诊毕   2诊毕与取消
	public static final String SYS_PARAM_OpOrSysncro2MrHandleMode = "CIOR0140"; // 门诊医嘱处置同步到病历操作模式   0自动  1手动
	public static final String SYS_PARAM_IsRemind4FgIndicFalseConfirmed = "CIOR0145"; // 确认为非适应症时是否提醒医生  默认值False
	public static final String SYS_PARAM_IsMedicalInsuranceEnable = "CIOR0150"; // 是否启用医保标识  默认值True
	public static final String SYS_PARAM_OpMedInsuranceAuditHandleMode = "CIOR0155"; // 门诊医保审核处理模式  0  实时交互模式	1  集中交互模式	2  医保部门审核模式 默认值 
	public static final String SYS_PARAM_IpMedInsuranceAuditHandleMode = "CIOR0160"; // 住院医保审核处理模式  0  实时交互模式	1  集中交互模式	2  医保部门审核模式 默认值
	public static final String SYS_PARAM_IsAutoGenSkinTestOrEnable = "CIOR0165"; // 是否开启皮试医嘱自动生成逻辑  默认值true
	public static final String SYS_PARAM_CiOrExFlowDeptHandleMode = "CIOR0170"; // 医嘱执行流向科室处理模式  默认值1 0 流向配置模式	1 流向配置+模式
	public static final String SYS_PARAM_CiOrExFlowDefaultDeptSet4Op = "CIOR0175"; // 门诊执行流向默认科室设置  默认值0   0 就诊科室	1 开单科室
	public static final String SYS_PARAM_CiOrExFlowDefaultDeptSet4Ip = "CIOR0180"; // 住院执行流向默认科室设置  默认值2   0 就诊科室	1 开单科室     2就诊病区
	public static final String SYS_PARAM_CiOrExFlowDefaultDeptSet4Er = "CIOR0185"; // 急诊执行流向默认科室设置  默认值0   0 就诊科室	1 开单科室     2就诊病区
	public static final String SYS_PARAM_CiOrExFlowDefaultDeptSet4Pe = "CIOR0190"; // 体检执行流向默认科室设置    科室选项待确定
	public static final String SYS_PARAM_CiOrExFlowDefaultDeptSet4Fm = "CIOR0195"; // 家床执行流向默认科室设置    科室选项待确定
	public static final String SYS_PARAM_IsAdmitDrugOrBeforeSkinTestRst = "CIOR0200"; // 无皮试结果是否可先开立用药医嘱 默认值  true
	public static final String SYS_PARAM_CiOrChargeListDataRangeSet = "CIOR0205"; // 医嘱费用清单数据范围设置参数 01 申请单模式下的临床项目费用	02  申请单模式下的治疗操作费用	03  治疗费用模式下的临床项目费用 04 治疗费用模式下的治疗操作费用
    public static final String SYS_PARAM_CiOrAssMultiEmsHandleMode = "CIOR0215";//住院多医疗单的0  仅生成医疗单UI数据（非自动生成医嘱模式）     1  后台自动生成医嘱模式
	
	public static final String SPLITRS_GRPRANGEMODE_BYBATCH="???????";   //医嘱拆解算法时，药品批次取整时归类范围模式
	public static final String SPLITRS_GRPRANGEMODE_REMAINS="???????";   //医嘱拆解算法时，余量法时归类范围模式
	
	//医保共享参数
	public static final String SYS_PARAM_IsOrgEnableOrDatumShared= "CIOR0220"; // 是否启用患者医保数据共享（组织及启用）默认是 true 启用
    public static final String SYS_PARAM_IsDeptEnableOrDatumShared = "CIOR0225";//是否启用患者医保数据共享（组织启用后科室是否启用） 默认是 true 启用
	//门诊医嘱助手内容拼接时，执行科室是否显示
    public static final String IsExecDeptShow4OpenHelper ="CIOR0230";//门诊医嘱助手内容拼接时，执行科室是否显示
    
    public static final String OrTmplTypeAndSeqSet4OPOrHelper = "CIOR0235";//门诊助手中，登录科室显示模板类型以及顺序设置
    public  static final String IsShowOphelperWhenOrOpen = "CIOR0240"; //门诊医嘱开立时，光标在输入区，是否弹出医嘱助手
    public static final String OPDiagTreatTmplOrOpenMode = "CIOR0245";//诊疗模板的开立方式  0 先开单后执行   1 先执行后开单   2  先开单后执行（无明确执行计划）
    public static final String SYS_PARAM_OpDocBillListOperationMode = "CIOR0250";//门诊费用清单操作模式：0,不可见；1,只读；2,可编辑
    public static final String SYS_PARAM_OrHelperOpenOrCountLimitSet = "CIOR0255";// 助手开立医嘱时开立的医嘱最大限制设置 默认值  10 ，取值区间 0--20；
	public static final String SYS_PARAM_OpSignedOrExecMode = "CIOR0260";//机构级别参数，参数值为00撤回模式-独立撤回功能、01撤回模式-操作合并到删除功能、10作废模式 – 独立作废功能、11作废模式 – 操作合并到删除功能，默认值为：11作废模式 – 操作合并到删除功能。
	public static final String SYS_PARAM_MedInsuranceIndicInfoModelSet = "CIOR0265"; //医保适应症提示信息模式设置   0  医保适应症医保限制条件提示信息 ，1 医保适应症 院内限制提示信息 ，2 医保适应症 医保限制+院内限制 信息
	public static final String SYS_PARAM_IsAdmintHpIndicJudgeFeeItemUnDrugOR ="CIOR0270";//d)	增加【非药品医嘱费用是否允许明细适应症选择】机构级别参数，默认赋值不允许，表示非药品医嘱只能批量设置适应和不适应。【允许】表示非药品医嘱下费用允许针对各条费用单独选择适应和不适应
	/**
	 * CIOR0005
	 * 医嘱或服务拆分截止时间与当前时间最大允许的天数间隔
	 */
	public static final Integer PARAMV_ORSRVSPLITDTENDMAXALLOWDAYS_DefaultV=15;
	
	/**
	 * 护士医嘱停止确认时，医嘱停止确认最大可提前时间（分钟）
	 */
	public static final Integer PARAMV_OrStopChkMaxLeadTime_DefaultV=1440;
	
	/**
	 * CIOR0165
	 * 是否开启皮试医嘱自动生成逻辑 
	 */
	public static final boolean PARAMV_IsAutoGenSkinTestOrEnable_DefaultV = true;//默认值常量
	
	/**
	 * CIOR0170
	 * 医嘱执行流向科室处理模式枚举值及默认值常量设置
	 */
	public static final String PARAMV_CiOrExFlowDeptHandleMode_DeptFlowCfg = "0"; // 0 流向配置模式
	public static final String PARAMV_CiOrExFlowDeptHandleMode_DeptFlowCfgPlus = "1"; //1 流向配置+模式  默认值
	public static final String PARAMV_CiOrExFlowDeptHandleMode_DefaultV = "1"; //默认值常量
	
	/**
	 * CIOR0175~CIOR0195
	 * 公共科室设置枚举值
	 */
	public static final String PARAMV_CiOrExFlowDefaultDeptSet_PvDept = "0"; // 0 就诊科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet_OrDept = "1"; // 1 开单科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet_NsDept = "2"; // 2 就诊病区
	
	/**
	 * CIOR0175
	 * 门诊执行流向默认科室设置
	 */
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Op_PvDept = "0"; // 0 就诊科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Op_OrDept = "1"; // 1 开单科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Op_DefaultV = "0"; // 0 就诊科室

	/**
	 * CIOR0180
	 * 住院诊执行流向默认科室设置
	 */
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Ip_PvDept = "0"; // 0 就诊科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Ip_OrDept = "1"; // 1 开单科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Ip_NsDept = "2"; // 2 就诊病区
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Ip_DefaultV = "2"; // 默认值常量
	
	/**
	 * CIOR0185
	 * 急诊诊执行流向默认科室设置
	 */
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Er_PvDept = "0"; // 0 就诊科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Er_OrDept = "1"; // 1 开单科室
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Er_NsDept = "2"; // 2 就诊病区
	public static final String PARAMV_CiOrExFlowDefaultDeptSet4Er_DefaultV = "0"; // 默认值常量
	
	/**
	 * CIOR0200
	 * 无皮试结果是否可先开立用药医嘱 
	 */
	public static final boolean PARAMV_IsAdmitDrugOrBeforeSkinTestRst_DefaultV = true;//默认值常量
	
	/**
	 * CIOR0205
	 * 医嘱费用清单数据范围设置参数
	 */
	public static final String PARAMV_CiOrChargeListDataRangeSet_AppMdCiFee = "01"; // 01 申请单模式下的临床项目费用
	public static final String PARAMV_CiOrChargeListDataRangeSet_AppMdTreatFee = "02"; // 02  申请单模式下的治疗操作费用
	public static final String PARAMV_CiOrChargeListDataRangeSet_TreatMdCiFee = "03"; // 03  治疗费用模式下的临床项目费用
	public static final String PARAMV_CiOrChargeListDataRangeSet_TreatMdTreatFee = "04"; // 04 治疗费用模式下的治疗操作费用
	public static final String PARAMV_CiOrChargeListDataRangeSet_DefaultV = ""; // 默认值常量
	
	
	
	
	
}
