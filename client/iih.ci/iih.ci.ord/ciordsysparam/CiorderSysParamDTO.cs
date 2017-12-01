using System;
using iih.ci.iih.ci.ord.i;
using iih.bd.iih.bd.pp.paramconst;
using System.Collections.Generic;
using xap.rui.engine;

namespace iih.ci.ord.ciordsysparam
{
    public class CiorderSysParamDTO 
    {
        private Dictionary<String, GetSysParamDTO> sysParamCache = new Dictionary<string, GetSysParamDTO>();
        private BaseContext ctx = new BaseContext();
        /// <summary>
        /// CIOR0005 医嘱可提前录入最大小时数（医嘱生效时间）
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OrEarlyEntryMaxHours
        {
            get
            {
                return getParam("SYS_PARAM_OrEarlyEntryMaxHours",
                ICiOrdNSysParamConst.SYS_PARAM_OrEarlyEntryMaxHours);
            }
        }


        /// <summary>
        /// CIOR0010 临时备用医嘱有效时间（小时）
        /// </summary>
        public GetSysParamDTO SYS_PARAM_TemporaryPrnOrValidTime
        {
            get
            {
                return getParam("SYS_PARAM_TemporaryPrnOrValidTime",
                ICiOrdNSysParamConst.SYS_PARAM_TemporaryPrnOrValidTime);
            }
        }


        /// <summary>
        /// CIOR0015 门诊医嘱有效时间范围（小时）
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OpOrValidTime
        {
            get
            {
                return getParam("SYS_PARAM_OpOrValidTime",
                ICiOrdNSysParamConst.SYS_PARAM_OpOrValidTime);
            }
        }

        /// <summary>
        /// CIOR0020 医嘱或服务拆分截止时间与当前时间最大允许的天数间隔
        /// </summary>
        public GetSysParamDTO SYS_PARAM_ORSRVSPLITDTENDMAXALLOWDAYS
        {
            get
            {
                return getParam("SYS_PARAM_ORSRVSPLITDTENDMAXALLOWDAYS",
                ICiOrdNSysParamConst.SYS_PARAM_ORSRVSPLITDTENDMAXALLOWDAYS);
            }
        }

        /// <summary>
        /// CIOR0025 临床诊断系统设置（组织）11  西医、12  中医、13  蒙医
        /// </summary>
        public GetSysParamDTO SYS_PARAM_ClinicalDiagSysCfg
        {
            get
            {
                return getParam("SYS_PARAM_ClinicalDiagSysCfg",
                    ICiOrdNSysParamConst.SYS_PARAM_ClinicalDiagSysCfg);
            }
        }

        /// <summary>
        /// CIOR0025_D 临床诊断系统设置（部门）	ClinicalDiagSysCfg	11  西医、12  中医、13  蒙医
        /// </summary>
        public GetSysParamDTO SYS_PARAM_ClinicalDiagSysCfg_D
        {
            get
            {
                return getParam("SYS_PARAM_ClinicalDiagSysCfg_D",
                    ICiOrdNSysParamConst.SYS_PARAM_ClinicalDiagSysCfg_D);
            }
        }

        /// <summary>
        /// CIOR0030 护士医嘱签署确认时，医嘱签署确认最大可提前时间（分钟）
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OrSignChkMaxLeadTime
        {
            get
            {
                return getParam("SYS_PARAM_OrSignChkMaxLeadTime",
                    ICiOrdNSysParamConst.SYS_PARAM_OrSignChkMaxLeadTime);
            }
        }

        /// <summary>
        /// CIOR0035 护士医嘱停止确认时，医嘱停止确认最大可提前时间（分钟）
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OrStopChkMaxLeadTime
        {
            get
            {
                return getParam("SYS_PARAM_OrStopChkMaxLeadTime",
                    ICiOrdNSysParamConst.SYS_PARAM_OrStopChkMaxLeadTime);
            }
        }

        /// <summary>
        /// CIOR0040 护士医嘱确认补录费用时，可录入服务范围设置（组织）
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OrChkSrvScope4MakeupFee
        {
            get
            {
                return getParam("SYS_PARAM_OrChkSrvScope4MakeupFee",
                    ICiOrdNSysParamConst.SYS_PARAM_OrChkSrvScope4MakeupFee);
            }
        }

        /// <summary>
        /// CIOR0040_D 护士医嘱确认补录费用时，可录入服务范围设置（部门）
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OrChkSrvScope4MakeupFee_D
        {
            get
            {
                return getParam("SYS_PARAM_OrChkSrvScope4MakeupFee_D",
                    ICiOrdNSysParamConst.SYS_PARAM_OrChkSrvScope4MakeupFee_D);
            }
        }

        /// <summary>
        /// CIOR0045 N天内有效业务表达时，时间计算的有效模式 0 24小时模式	1 日开始时间模式
        /// </summary>
        public GetSysParamDTO SYS_PARAM_DtCalEffModeWithinNDays
        {
            get
            {
                return getParam("SYS_PARAM_DtCalEffModeWithinNDays",
                    ICiOrdNSysParamConst.SYS_PARAM_DtCalEffModeWithinNDays);
            }
        }

        /// <summary>
        /// CIOR0050 医嘱签署与医嘱生效时间间的有效允差（分钟）
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OrSignOrEffTimeTolerance
        {
            get
            {
                return getParam("SYS_PARAM_OrSignOrEffTimeTolerance",
                    ICiOrdNSysParamConst.SYS_PARAM_OrSignOrEffTimeTolerance);
            }
        }

        /// <summary>
        /// CIOR0055 药品过敏史查询年限（皮试判断用）
        /// </summary>
        public GetSysParamDTO SYS_PARAM_AllergyQryYearLimit
        {
            get
            {
                return getParam("SYS_PARAM_AllergyQryYearLimit",
                    ICiOrdNSysParamConst.SYS_PARAM_AllergyQryYearLimit);
            }
        }

        /// <summary>
        /// CIOR0060 药物过敏的处理模式（皮试判断用）	0 药品禁用	1 再皮试	2 强制使用
        /// </summary>
        public GetSysParamDTO SYS_PARAM_PharmAllergyHandleMode
        {
            get
            {
                return getParam("SYS_PARAM_PharmAllergyHandleMode",
                    ICiOrdNSysParamConst.SYS_PARAM_PharmAllergyHandleMode);
            }
        }

        /// <summary>
        /// CIOR0065 过敏皮试效期字串（年龄月，效期天）默认值：0~168,1;169~,3      0到168月效期1天（14岁以下含14岁效期1天 ）;169月以上效期3天（14岁以上效期3天）
        /// </summary>
        public GetSysParamDTO SYS_PARAM_AllergicSkinTestValidPeriodStr
        {
            get
            {
                return getParam("SYS_PARAM_AllergicSkinTestValidPeriodStr",
                    ICiOrdNSysParamConst.SYS_PARAM_AllergicSkinTestValidPeriodStr);
            }
        }

        /// <summary>
        /// CIOR0070 会诊患者系统可见天数
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OrConsPatVisDays
        {
            get
            {
                return getParam("SYS_PARAM_OrConsPatVisDays",
                    ICiOrdNSysParamConst.SYS_PARAM_OrConsPatVisDays);
            }
        }

        /// <summary>
        /// CIOR0075 门诊医生费用操作模式	枚举	2	0 不需查看 1 可查看但不可编辑 2 可编辑费用
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OpDocBillOperationMode
        {
            get
            {
                return getParam("SYS_PARAM_OpDocBillOperationMode",
                    ICiOrdNSysParamConst.SYS_PARAM_OpDocBillOperationMode);
            }
        }

        /// <summary>
        /// CIOR0080 门诊医生补录费用时，可录入服务范围设置（组织）
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OpSrvScope4DocMakeupFee
        {
            get
            {
                return getParam("SYS_PARAM_OpSrvScope4DocMakeupFee",
                    ICiOrdNSysParamConst.SYS_PARAM_OpSrvScope4DocMakeupFee);
            }
        }

        /// <summary>
        /// CIOR0080_D 门诊医生补录费用时，可录入服务范围设置（部门）
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OpSrvScope4DocMakeupFee_D
        {
            get
            {
                return getParam("SYS_PARAM_OpSrvScope4DocMakeupFee_D",
                    ICiOrdNSysParamConst.SYS_PARAM_OpSrvScope4DocMakeupFee_D);
            }
        }

        /// <summary>
        /// CIOR0090 门诊病历管理模式:医生打印=0,病案统一打印=1,无纸化模式=2,医生手写=3
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OMRMgmtMd
        {
            get
            {
                return getParam("SYS_PARAM_OMRMgmtMd",
                    ICiOrdNSysParamConst.SYS_PARAM_OMRMgmtMd);
            }
        }

        /// <summary>
        /// CIOR0110 临床医嘱在院执行标识默认值设置插件
        /// </summary>
        public GetSysParamDTO SYS_PARAM_CiOrFgMpInDefaultVPlugin
        {
            get
            {
                return getParam("SYS_PARAM_CiOrFgMpInDefaultVPlugin",
                    ICiOrdNSysParamConst.SYS_PARAM_CiOrFgMpInDefaultVPlugin);
            }
        }

        /// <summary>
        /// CIOR0115 药品可成组使用用法范围设置
        /// </summary>
        public GetSysParamDTO SYS_PARAM_CiPharmGrpableUsageScope
        {
            get
            {
                return getParam("SYS_PARAM_CiPharmGrpableUsageScope",
                    ICiOrdNSysParamConst.SYS_PARAM_CiPharmGrpableUsageScope);
            }
        }

        /// <summary>
        /// CIOR0120 临床医嘱分方业务插件设置
        /// </summary>
        public GetSysParamDTO SYS_PARAM_CiOrSplit4PresTransPlugin
        {
            get
            {
                return getParam("SYS_PARAM_CiOrSplit4PresTransPlugin",
                    ICiOrdNSysParamConst.SYS_PARAM_CiOrSplit4PresTransPlugin);
            }
        }

        /// <summary>
        /// CIOR0125 临床医嘱是否启用医保校验逻辑
        /// </summary>
        public GetSysParamDTO SYS_PARAM_IsMedInsuranceCheckUse
        {
            get
            {
                return getParam("SYS_PARAM_IsMedInsuranceCheckUse",
                    ICiOrdNSysParamConst.SYS_PARAM_IsMedInsuranceCheckUse);
            }
        }

        /// <summary>
        /// CIOR0130 临床医嘱是否启用合理用药校验逻辑
        /// </summary>
        public GetSysParamDTO SYS_PARAM_IsRationalPharmUseCheck
        {
            get
            {
                return getParam("SYS_PARAM_IsRationalPharmUseCheck",
                    ICiOrdNSysParamConst.SYS_PARAM_IsRationalPharmUseCheck);
            }
        }

        /// <summary>
        /// CIOR0135 门诊就诊诊毕的管理模式       0无诊毕   1仅诊毕   2诊毕与取消
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OpThisPatVisitFinishMode
        {
            get
            {
                return getParam("SYS_PARAM_OpThisPatVisitFinishMode",
                    ICiOrdNSysParamConst.SYS_PARAM_OpThisPatVisitFinishMode);
            }
        }

        /// <summary>
        /// CIOR0140 门诊医嘱处置同步到病历操作模式   0自动  1手动
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OpOrSysncro2MrHandleMode
        {
            get
            {
                return getParam("SYS_PARAM_OpOrSysncro2MrHandleMode",
                    ICiOrdNSysParamConst.SYS_PARAM_OpOrSysncro2MrHandleMode);
            }
        }

        /// <summary>
        /// CIOR0145 确认为非适应症时是否提醒医生  默认值False
        /// </summary>
        public GetSysParamDTO SYS_PARAM_IsRemind4FgIndicFalseConfirmed
        {
            get
            {
                return getParam("SYS_PARAM_IsRemind4FgIndicFalseConfirmed",
                    ICiOrdNSysParamConst.SYS_PARAM_IsRemind4FgIndicFalseConfirmed);
            }
        }

        /// <summary>
        /// CIOR0150 是否启用医保标识  默认值True
        /// </summary>
        public GetSysParamDTO SYS_PARAM_IsMedicalInsuranceEnable
        {
            get
            {
                return getParam("SYS_PARAM_IsMedicalInsuranceEnable",
                    ICiOrdNSysParamConst.SYS_PARAM_IsMedicalInsuranceEnable);
            }
        }

        /// <summary>
        /// CIOR0155 门诊医保审核处理模式  0  实时交互模式	1  集中交互模式	2  医保部门审核模式 默认值 
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OpMedInsuranceAuditHandleMode
        {
            get
            {
                return getParam("SYS_PARAM_OpMedInsuranceAuditHandleMode",
                    ICiOrdNSysParamConst.SYS_PARAM_OpMedInsuranceAuditHandleMode);
            }
        }

        /// <summary>
        /// CIOR0160 住院医保审核处理模式  0  实时交互模式	1  集中交互模式	2  医保部门审核模式 默认值 
        /// </summary>
        public GetSysParamDTO SYS_PARAM_IpMedInsuranceAuditHandleMode
        {
            get
            {
                return getParam("SYS_PARAM_IpMedInsuranceAuditHandleMode",
                    ICiOrdNSysParamConst.SYS_PARAM_IpMedInsuranceAuditHandleMode);
            }
        }

        /// <summary>
        /// CIOR0210 门诊总量编辑控制模式  0 不可编辑 默认值 0
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OpTotalQuanEditControlMode
        {
            get
            {
                return getParam("SYS_PARAM_OpTotalQuanEditControlMode",
                    ICiOrdNSysParamConst.SYS_PARAM_OpTotalQuanEditControlMode);
            }
        }

        /// <summary>
        /// CIOR0230 门诊医嘱助手内容拼接时，执行科室是否显示
        /// </summary>
        public GetSysParamDTO IsExecDeptShow4OpenHelper
        {
            get
            {
                return getParam("IsExecDeptShow4OpenHelper",
                    ICiOrdNSysParamConst.IsExecDeptShow4OpenHelper);
            }
        }

        /// <summary>
        /// CIOR0235 门诊助手中，登录科室显示模板类型以及顺序设置
        /// </summary>
        public GetSysParamDTO OrTmplTypeAndSeqSet4OPOrHelper
        {
            get
            {
                return getParam("OrTmplTypeAndSeqSet4OPOrHelper",
                    ICiOrdNSysParamConst.OrTmplTypeAndSeqSet4OPOrHelper);
            }
        }

        /// <summary>
        /// CIOR0240 门诊医嘱开立时，光标在输入区，是否弹出医嘱助手
        /// </summary>
        public GetSysParamDTO IsShowOphelperWhenOrOpen
        {
            get
            {
                return getParam("IsShowOphelperWhenOrOpen",
                    ICiOrdNSysParamConst.IsShowOphelperWhenOrOpen);
            }
        }

        /// <summary>
        /// CIOR0245 诊疗模板的开立方式  0 先开单后执行   1 先执行后开单   2  先开单后执行（无明确执行计划）
        /// </summary>
        public GetSysParamDTO OPDiagTreatTmplOrOpenMode
        {
            get
            {
                return getParam("OPDiagTreatTmplOrOpenMode",
                    ICiOrdNSysParamConst.OPDiagTreatTmplOrOpenMode);
            }
        }

        /// <summary>
        /// CIOR0205 费用清单数据范围参数,支持医院、科室级别: 01申请单模式下的临床项目费用 02申请单模式下的治疗操作费用 03治疗费用模式下的临床项目费用 04治疗费用模式下的治疗操作费用
        /// </summary>
        public GetSysParamDTO CostListDataRangeValue
        {
            get
            {
                return getParam("CostListDataRangeValue",
                    ICiOrdNSysParamConst.CostListDataRangeValue);
            }
        }

        /// <summary>
        /// CIOR0250 门诊费用清单操作模式：0,不可见；1,只读；2,可编辑
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OpDocBillListOperationMode
        {
            get
            {
                return getParam("SYS_PARAM_OpDocBillListOperationMode",
                    ICiOrdNSysParamConst.SYS_PARAM_OpDocBillListOperationMode);
            }
        }

        /// <summary>
        /// CIOR0260 机构级别参数，参数值为00撤回模式-独立撤回功能、
        /// 01撤回模式-操作合并到删除功能、
        /// 10作废模式 – 独立作废功能、
        /// 11作废模式 – 操作合并到删除功能，
        /// 默认值为：11作废模式 – 操作合并到删除功能。
        /// </summary>
        public GetSysParamDTO SYS_PARAM_OpSignedOrExecMode
        {
            get
            {
                return getParam("SYS_PARAM_OpSignedOrExecMode",
                    ICiOrdNSysParamConst.SYS_PARAM_OpSignedOrExecMode);
            }
        }

        /// <summary>
        /// CIOR0265 医保适应症提示信息模式设置
        /// 0  医保适应症医保限制条件提示信息 ，
        /// 1 医保适应症 院内限制提示信息 ，
        /// 2 医保适应症 医保限制+院内限制信息
        /// </summary>
        public GetSysParamDTO SYS_PARAM_HPInfoMode
        {
            get
            {
                return getParam("SYS_PARAM_HPInfoMode",
                    ICiOrdNSysParamConst.SYS_PARAM_HPInfoMode);
            }
        }

        /// <summary>
        /// 价表维护时计量单位是否可空
        /// </summary>
        public GetSysParamDTO BD_PP_FG_NULL_UNIT_PRICE
        {
            get
            {
                return getParam("BD_PP_FG_NULL_UNIT_PRICE",
                    BdPpParamConst.BD_PP_FG_NULL_UNIT_PRICE);
            }
        }

        /// <summary>
        /// 	增加【非药品医嘱费用是否允许明细适应症选择】机构级别参数，默认赋值不允许，表示非药品医嘱只能批量设置适应和不适应。
        /// 【允许】表示非药品医嘱下费用允许针对各条费用单独选择适应和不适应
        /// </summary>
        public GetSysParamDTO SYS_PARAM_IsAdmintHpIndicJudgeFeeItemUnDrugOR
        {
            get
            {
                return getParam("SYS_PARAM_IsAdmintHpIndicJudgeFeeItemUnDrugOR",
                    ICiOrdNSysParamConst.SYS_PARAM_IsAdmintHpIndicJudgeFeeItemUnDrugOR);
            }
        }

        private GetSysParamDTO getParam(string attrName,string sysCode)
        {
            if (!sysParamCache.ContainsKey(attrName))
            {
                sysParamCache.Add(attrName, new GetSysParamDTO(ctx,sysCode)); 
            }
            return sysParamCache[attrName];
        }

        public void Clear()
        {
           sysParamCache.Clear();
           ctx = new BaseContext();

        }
    

    }
}
