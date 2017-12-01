
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.action.costant
{
    /// <summary>
    /// <para>描    述 :  按钮常量定义</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.action.costant</para>    
    /// <para>类 名 称 :  OpActionConstant</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/10/28 17:52:08</para>
    /// <para>更新时间 :  2016/10/28 17:52:08</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OpActionConstant
    {
        // 注意，维护按钮常量时，按照按钮在目录中显示的顺序进行添加，
        // 常量定义与按钮的类文件名一致，按单词拆分，常量值为按钮的UIEvent，并添加对应注释信息

        /// <summary>
        /// 会诊（调用第三方会诊）
        /// </summary>
        public const string CONS_REPORT_ACTION = "ConsReportAction";

        /// <summary>
        /// 数据中心（调用第三方数据中心）
        /// </summary>
        public const string DATA_CENTER_ACTION = "DataCenterAction";
        /// <summary>
        /// 删除病历
        /// </summary>
        public const string EMR_DELETE_ACTION = "EmrDeleteAction";

        /// <summary>
        /// 打印病历
        /// </summary>
        public const string EMR_PRINT_ACTION = "EmrPrintAction";

        /// <summary>
        /// 病历预览打印
        /// </summary>
        public const string EMR_PRINT_VIEW_ACTION = "EmrPrintViewAction";

        /// <summary>
        /// 病历保存
        /// </summary>
        public const string EMR_SAVE_ACTION = "EmrSaveAction";

        /// <summary>
        /// 处置/诊断同步到病历
        /// </summary>
        public const string EMR_SYNC_CIDI_CIORD_ACTION = "EmrSyncCidiCiordAction";

        /// <summary>
        /// 处置回写到病历
        /// </summary>
        public const string EMR_SYNC_CIORD_ACTION = "EmrSyncCiordAction";

        /// <summary>
        /// 诊断回写到病历
        /// </summary>
        public const string EMR_SYNC_CIDI_ACTION = "EmrSyncCidiAction";

        /// <summary>
        /// 诊间预约取消
        /// </summary>
        public const string ENT_APPOINT_CANCEL_ACTION = "EntAppointCancelAction";
        /// <summary>
        /// 诊间预约
        /// </summary>
        public const string ENT_APPOINTMENT_ACTION = "entAppointmentAction";

        /// <summary>
        /// 住院通知
        /// </summary>
        public const string HOSPITAL_NOTICE_ACTION = "HospitalNoticeAction";

        /// <summary>
        /// 检验报告（调用第三方检验报告）
        /// </summary>
        public const string LIS_HISTORY_REPORT_ACTION = "LisHistoryReportAction";

        /// <summary>
        /// 处置删除
        /// </summary>
        public const string OP_ORDER_DELETE_ACTION = "OpOrderDeleteAction";

        /// <summary>
        /// 处置撤回
        /// </summary>
        public const string OP_ORDER_REVERT_SIGN_ACTION = "RevertSignAction";

        /// <summary>
        /// 处置作废
        /// </summary>
        public const string OP_ORDER_CANCEL_ACTION = "OpOrderCancelAction";

        /// <summary>
        /// 处置作废复制（显示撤回）
        /// </summary>
        public const string OP_ORDER_CANCELCOPY_ACTION = "OpOrderCancelCopyAction"; 

        /// <summary>
        /// 处置签署
        /// </summary>
        public const string OP_ORDER_SIGN_ACTION = "OpOrderSignAction"; 
        /// <summary>
        /// 记账
        /// </summary>
        public const string OP_PRECALC_FEE_ACTION = "OpPreCalcFeeAction";
        /// <summary>
        /// 取消记账
        /// </summary>
        public const string OP_PRESCANCEL_FEE_ACTION = "OpPresCancelFeeAction";

        /// <summary>
        /// 医保共享数据
        /// </summary>
        public const string HISTORY_MEDICAL_SHARING_DATE = "HistorymedicalsharingDataAction"; 
        /// <summary>
        /// 其他
        /// </summary>
        public const string OP_OTHER_ACTION = "OpOther";
       
        /// <summary>
        /// 诊毕（完成）按钮
        /// </summary>
        public const string OP_COMPLETE_ACTION = "OpComplete";

        /// <summary>
        /// 完成并下一个
        /// </summary>
        public const string OP_COMPLETE_AND_NEXT_ACTION = "OpCompleteAndNextAction";

        /// <summary>
        /// 取消接诊
        /// </summary>
        public const string OP_CANCEL_ACTION = "OpCancelDi";

        /// <summary>
        /// 取消接诊（发送给就诊）
        /// </summary>
        public const string EN_PAT_CANCEL = "OpCancel";

        /// <summary>
        /// 工作表单
        /// </summary>
        public const string OP_EMR_DOC_ACTION = "OpEmrDoc";

        /// <summary>
        /// 牙周组织检查表
        /// </summary>
        public const string OP_EMR_PER_ACTION = "EmrPer";

        /// <summary>
        /// 医保转诊单
        /// </summary>
        public const string OP_HP_TRANSFORM_EN_FILE_ACTION = "HpTransformEnFile";

        /// <summary>
        /// 诊断证明
        /// </summary>
        public const string OP_PROOF_OF_DIAGNOSIS = "OPProofOfDiagnosis";

        /// <summary>
        /// 打印事件
        /// </summary>
        public const string OP_PRINT_ACTION = "OpPrintAction";

        /// <summary>
        /// 诊毕打印事件
        /// </summary>
        public const string OP_COMPLETE_PRINT_ACTION = "OpCompletePrintAction";

        /// <summary>
        /// 校验有效医嘱
        /// </summary>
        public const string OP_CI_ORD_SEND_ACTION = "OpCiOrdSendAction";

        /// <summary>
        /// 校验有效医嘱
        /// </summary>
        public const string OP_CI_ORD_RECEIVE_ACTION = "OpCiOrdReceiveAction";

        /// <summary>
        /// 诊毕校验诊断
        /// </summary>
        public const string OP_COMPLETE_DI_SEND_ACTION = "OpCompleteDiSendAction";

        /// <summary>
        /// 诊毕校验诊断
        /// </summary>
        public const string OP_COMPLETE_DI_RECEIVE_ACTION = "OpCompleteDiReceiveAction";

        /// <summary>
        /// 诊毕校验医嘱
        /// </summary>
        public const string OP_COMPLETE_OR_SEND_ACTION = "OpCompleteOrSendAction";

        /// <summary>
        /// 诊毕校验医嘱
        /// </summary>
        public const string OP_COMPLETE_OR_RECEIVE_ACTION = "OpCompleteOrReceiveAction";

        /// <summary>
        /// 取消接诊校验诊断
        /// </summary>
        public const string OP_CANCEL_DI_SEND_ACTION = "OpCancelDiSendAction";

        /// <summary>
        /// 取消接诊校验诊断
        /// </summary>
        public const string OP_CANCEL_DI_RECEIVE_ACTION = "OpCancelDiReceiveAction";

        /// <summary>
        /// 校验诊断（签署医嘱）
        /// </summary>
        public const string OP_DI_CHECK_OR_SIGN_ACTION = "OpDiCheck4OrSignAction";

        /// <summary>
        /// 校验诊断（签署医嘱）
        /// </summary>
        public const string OP_DI_SEND_OR_SIGN_ACTION = "OpDiSend4OrSignAction";

        /// <summary>
        /// 校验诊断（签署医嘱）
        /// </summary>
        public const string OP_DI_RECEIVE_OR_SIGN_ACTION = "OpDiReceive4OrSignAction";

        /// <summary>
        /// 校验诊断响应（签署医嘱）
        /// </summary>
        public const string OP_DI_RESPONSE_SEND_OR_SIGN_ACTION = "OpDiResponseSend4OrSignAction";

        /// <summary>
        /// 校验诊断（开立医嘱）
        /// </summary>
        public const string OP_DI_CHECK_OR_OPEN_ACTION = "OpDiCheck4OrOpenAction";

        /// <summary>
        /// 校验诊断（开立医嘱）
        /// </summary>
        public const string OP_DI_SEND_OR_OPEN_ACTION = "OpDiSend4OrOpenAction";

        /// <summary>
        /// 校验诊断（开立医嘱）
        /// </summary>
        public const string OP_DI_RECEIVE_OR_OPEN_ACTION = "OpDiReceive4OrOpenAction";

        /// <summary>
        /// 校验诊断响应（开立医嘱）
        /// </summary>
        public const string OP_DI_RESPONSE_SEND_OR_OPEN_ACTION = "OpDiResponseSend4OrOpenAction";








        /// <summary>
        /// 门诊刷新
        /// </summary>
        public const string OP_REFRESH_ALL_ACTION = "OpRefreshAllAction";

        /// <summary>
        /// 就诊撤回
        /// </summary>
        public const string OP_REVOKE_EN_ACTION = "OpRetrieve";

        /// <summary>
        /// 待回诊
        /// </summary>
        public const string OP_SUSPEND_ACTION = "OpSuspend";

        /// <summary>
        /// 处方打印
        /// </summary>
        public const string ORD_PRES_PRINT_ACTION = "OrdPresPrint";        

        /// <summary>
        /// 报告查看
        /// </summary>
        public const string REPORT_VIEW_ACTION = "ReportViewAction";

        /// <summary>
        /// 检查报告（调用第三方检查报告）
        /// </summary>
        public const string RIS_HISTORY_REPORT_ACTION = "RisHistoryReportAction";

        /// <summary>
        /// 诊断智能助手
        /// </summary>
        public const string OP_DI_ASSI_ACTION = "GetDiFromAssi";

        /// <summary>
        /// 控制医嘱操作按钮可见性
        /// </summary>
        public const string OP_CANCEL_REVERT_VISIBLE_ACTION = "OpCancelRevertVisibleAction";

        /// <summary>
        /// 控制医嘱操作按钮可用性
        /// </summary>
        public const string OP_CANCEL_REVERT_ENABLE_ACTION = "OpCancelRevertEnableAction";

        /// <summary>
        /// 签署当前医嘱
        /// </summary>
        public const string OpCurrOrderSignAction = "OpCurrOrderSignAction";
        /// <summary>
        /// 删除当前医嘱
        /// </summary>
        public const string OpCurrOrderDeleteAction = "OpCurrOrderDeleteAction";
        /// <summary>
        /// 作废复制当前医嘱
        /// </summary>
        public const string OpCurrOrderCancelCopyAction = "OpCurrOrderCancelCopyAction";
        /// <summary>
        /// 撤回当前医嘱
        /// </summary>
        public const string OpCurrOrderRevertAction = "OpCurrOrderRevertAction";
        /// <summary>
        /// 作废全部医嘱
        /// </summary>
        public const string OpCurrOrderCancelAction = "OpCurrOrderCancelAction";

        /// <summary>
        /// 签署全部医嘱
        /// </summary>
        public const string OpAllOrderSignAction = "OpAllOrderSignAction";
        /// <summary>
        /// 删除全部医嘱
        /// </summary>
        public const string OpAllOrderDeleteAction = "OpAllOrderDeleteAction";
        /// <summary>
        /// 作废复制全部医嘱
        /// </summary>
        public const string OpAllOrderCancelCopyAction = "OpAllOrderCancelCopyAction";
        /// <summary>
        /// 撤回全部医嘱
        /// </summary>
        public const string OpAllOrderRevertAction = "OpAllOrderRevertAction";
        /// <summary>
        /// 作废全部医嘱
        /// </summary>
        public const string OpAllOrderCancelAction = "OpAllOrderCancelAction";
        /// <summary>
        /// 全部医嘱另存为模板
        /// </summary>
        public const string OpAllOrderSaveasAction = "OpAllOrderSaveasAction";
    }
}
