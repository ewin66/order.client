using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.declare
{
    /// <summary>
    /// <para>描    述 :  消息类型定义                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  xap.rui.bizcontrol.BillFormTmplConst    </para>    
    /// <para>类 名 称 :  Class1					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  8/24/2016 8:03:01 AM             </para>
    /// <para>更新时间 :  8/24/2016 8:03:01 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EventCodeType
    {
        
        #region 医疗单事件定义(在各自表单的 HandleState 中处理)
        #region 通知事件
        /// <summary>
        /// 创建医疗单通知
        /// </summary>
        public const String NM_EMS_CREATE = "NM_EMS_CREATE";
        /// <summary>
        /// 添加医疗单中服务项目通知
        /// </summary>
        public const String NM_EMS_APPEND = "NM_EMS_APPEND";
        /// <summary>
        /// 删除医疗单中服务项目通知
        /// </summary>
        public const String NM_EMS_DELETE = "NM_EMS_DELETE";
        /// <summary>
        /// 医疗单列表中医嘱项目被选中通知
        /// </summary>
        public const String NM_EMS_ORSRV_SELECTCHANGED = "NM_EMS_ORSRV_SELECTCHANGED";

        public const String NM_EMS_ORSRV_DATACHANGED = "NM_EMS_ORSRV_DATACHANGED";
        /// <summary>
        /// 保存医疗单通知
        /// </summary>
        public const String NM_EMS_SAVE = "NM_EMS_SAVE";
        /// <summary>
        /// 医疗单保存成功通知
        /// </summary>
        public const String NM_EMS_SAVESUCCESS = "NM_EMS_SAVESUCCESS";
        /// <summary>
        /// 关闭医疗单通知
        /// </summary>
        public const String NM_EMS_CLOSE = "NM_EMS_CLOSE";
        /// <summary>
        /// 添加用血医疗单通知
        /// </summary>
        public const String NM_EMS_APBU_ADD = "NM_EMS_APBU_ADD";
        /// <summary>
        /// 确定（保存）按钮设置焦点通知
        /// </summary>
        public const String NM_EMS_SAVE_FOCUS = "NM_EMS_SAVE_FOCUS";
        /// <summary>
        /// 列表焦点转到卡片通知
        /// </summary>
        public const String NM_EMS_CARDFOCUS = "NM_EMS_CARDFOCUS";
        /// <summary>
        /// 处置列表，参照返回通知
        /// </summary>
        public const String NM_EMS_REFRESULT = "NM_EMS_REFRESULT";
        #endregion

        #region 通用通知消息
        /// <summary>
        /// UI布局发生改变时候通知
        /// </summary>
        public const String NM_UIMSG_LAYOUTCHANGED = "NM_UIMSG_LAYOUTCHANGED";
        /// <summary>
        /// 创建医疗单按钮通知
        /// </summary>
        public const String NM_UIMSG_CREATE_BUTTONGROUP = "NM_UIMSG_CREATE_BUTTONGROUP";

        /// <summary>
        /// 禁止编辑
        /// </summary>
        public const String NM_UIMSG_DISABLE_EDIT = "NM_UIMSG_DISABLE_EDIT";

        /// <summary>
        /// 允许编辑
        /// </summary>
        public const String NM_UIMSG_ALLOW_EDIT = "NM_UIMSG_ALLOW_EDIT";
        /// <summary>
        /// 表格的点击事件
        /// </summary>
        public const String NM_TABLE_CLICK = "NM_TABLE_CLICK";
        public const String EVENT_TABLE_CLICK = "EVENT_TABLE_CLICK";
        /// <summary>
        /// UI布局发生改变时候通知
        /// </summary>
        public const String EVENT_UIMSG_LAYOUTCHANGED = "EVENT_UIMSG_LAYOUTCHANGED";
        /// <summary>
        /// 创建医疗单按钮通知
        /// </summary>
        public const String EVENT_EMS_CREATE_BUTTONGROUP = "EVENT_EMS_CREATE_BUTTONGROUP";

        /// <summary>
        /// 禁止编辑
        /// </summary>
        public const String EVENT_EMS_DISABLE_EDIT = "EVENT_EMS_DISABLE_EDIT";

        /// <summary>
        /// 允许编辑
        /// </summary>
        public const String EVENT_EMS_ALLOW_EDIT = "EVENT_UIMSG_ALLOW_EDIT";
        #endregion

        #region 费用相关的业务通知消息
        /// <summary>
        /// 添加费用项目通知
        /// </summary>
        public const String NM_EXPENSE_ADD = "NM_EXPENSE_ADD";
        /// <summary>
        /// 删除费用项目通知
        /// </summary>
        public const String NM_EXPENSE_DELETE = "NM_EXPENSE_DELETE";
        /// <summary>
        /// 保存费用项目通知
        /// </summary>
        public const String NM_EXPENSE_SAVE = "NM_EXPENSE_SAVE";
        public const String NM_EXPENSE_REFRESH = "NM_EXPENSE_REFRESH";
        /// <summary>
        /// 费用页签修改通知
        /// </summary>
        public const String NM_EXPENSE_DATACHANGED = "NM_EXPENSE_DATACHANGED";

        /// <summary>
        /// 打开医嘱诊断编辑器
        /// </summary>
        public const String NM_ORDI_EDIT = "NM_ORDI_EDIT";

        /// <summary>
        /// 添加费用项目事件
        /// </summary>
        public const String EVENT_EXPENSE_ADD = "EVENT_EXPENSE_ADD";
        /// <summary>
        /// 删除费用项目事件
        /// </summary>
        public const String EVENT_EXPENSE_DELETE = "EVENT_EXPENSE_DELETE";
        /// <summary>
        /// 保存费用项目事件
        /// </summary>
        public const String EVENT_EXPENSE_SAVE = "EVENT_EXPENSE_SAVE";

        public const String EVENT_EXPENSE_REFRESH = "EVENT_EXPENSE_REFRESH";
        /// <summary>
        /// 费用页签项目修改事件
        /// </summary>
        public const String EVENT_EXPENSE_DATACHANGED = "EVENT_EXPENSE_DATACHANGED";
        #endregion

        #region 执行事件定义  

        public const String EVENT_EMS_ORSRV_DATACHANGED = "EVENT_EMS_ORSRV_DATACHANGED";
        /// <summary>
        /// 医疗单医保数据修改事件
        /// </summary>
        public const String EVENT_EMS_ORSRV_HP_DATACHANGED = "EVENT_EMS_ORSRV_HP_DATACHANGED";
        /// <summary>
        /// 医疗单刷新事件
        /// </summary>
        public const String EVENT_EMS_REFRESH = "EVENT_EMS_REFRESH";
        /// <summary>
        /// 医疗单创建事件
        /// </summary>
        public const String EVENT_EMS_CREATE = "EVENT_EMS_CREATE";

        /// <summary>
        /// 编辑医嘱模板返回的EMS
        /// </summary>
        public const String EVENT_EMS_TMPL_EDIT = "ordertemplate";
        public const String ARGKEY_EMS_TMPL_EDIT = "order";

        public const String EVENT_EMS_MEDTECH_EDIT = "medicalTechnology";
        public const String ARGKEY_EMS_MEDTECH_EDIT = "medTech";
        /// <summary>
        /// 医疗单项目追加事件
        /// </summary>
        public const String EVENT_EMS_APPEND = "EVENT_EMS_APPEND";
        /// <summary>
        /// 医疗单删除项目事件
        /// </summary>
        public const String EVENT_EMS_DELETE = "EVENT_EMS_DELETE";
        /// <summary>
        /// 医疗单保存事件
        /// </summary>
        public const String EVENT_EMS_SAVE = "EVENT_EMS_SAVE";
        /// <summary>
        /// 医疗单保存成功事件
        /// </summary>
        public const String EVENT_EMS_SAVESUCCESS = "EVENT_EMS_SAVESUCCESS";
        /// <summary>
        /// 医疗单关闭事件
        /// </summary>
        public const String EVENT_EMS_CLOSE = "EVENT_EMS_CLOSE";
        /// <summary>
        /// 关闭清空所有医疗单
        /// </summary>
        public const String EVENT_EMS_CLOSEALL = "EVENT_EMS_CLOSEALL";
        /// <summary>
        /// 编辑医嘱事件
        /// </summary>
        public const String EVENT_EMS_ORDER_EDIT = "EVENT_EMS_ORDER_EDIT";
        /// <summary>
        /// 编辑医疗单，CiEmsDTO
        /// </summary>
        public const String EVENT_EMS_DIRECT_EDIT = "EVENT_EMS_DIRECT_EDIT";
        /// <summary>
        /// 打开门诊诊断事件
        /// </summary>
        public const String THIRD_EVENT_ORSRV_OPOD_OPEN = "OPProofOfDiagnosis";
        /// <summary>
        /// 门诊组套事件
        /// </summary>
        public const String THIRD_EVENT_MKRMS_ADD = "Mkrms";
        /// <summary>
        /// 医嘱诊断检查事件
        /// </summary>
        public const String EVENT_ORDI_CHECK = "EVENT_ORDI_CHECK";
        /// <summary>
        /// 医嘱诊断编辑事件
        /// </summary>
        public const String EVENT_ORDI_EDIT = "EVENT_ORDI_EDIT";
        /// <summary>
        /// 医嘱诊断刷新事件
        /// </summary>
        public const String EVENT_ORDI_REFRESH = "EVENT_ORDI_REFRESH";
        /// <summary>
        /// 医嘱诊断保存事件
        /// </summary>
        public const String EVENT_ORDI_SAVESUCCE = "EVENT_ORDI_SAVESUCCE";
       
        /// <summary>
        /// 执行医疗单添加用血
        /// </summary>
        public const String EVENT_EMS_APBU_ADD = "EVENT_EMS_APBU_ADD";

        /// <summary>
        /// 重新分方
        /// </summary>
        public const String EVENT_EMS_AGAIN_PRES = "OpAgainPresAction";
        /// <summary>
        /// 确定（保存）按钮设置焦点通知
        /// </summary>
        public const String EVENT_EMS_SAVE_FOCUS = "EVENT_EMS_SAVE_FOCUS";
        /// <summary>
        /// 列表焦点转到卡片通知
        /// </summary>
        public const String EVENT_EMS_CARDFOCUS = "EVENT_EMS_CARDFOCUS";

        /// <summary>
        /// 处置列表，参照返回通知
        /// </summary>
        public const String EVENT_EMS_REFRESULT = "EVENT_EMS_REFRESULT";

        /// <summary>
        //医保共享数据
        /// </summary>
        public const String History_medicalsharing = "HistorymedicalsharingDataAction";
        #endregion

        #region 医嘱列表事件定义
        public const String EVENT_ORDLIST_SWITCH2FEEBILL = "EVENT_ORDLIST_SWITCH2FEEBILL";
        public const String EVENT_ORDLIST_SWITCH2PRESS = "EVENT_ORDLIST_SWITCH2PRESS";
        public const String EVENT_ORDLIST_SWITCH2ORDLIST = "EVENT_ORDLIST_SWITCH2ORDLIST";
        public const String EVENT_ORDLIST_NEEDVALIDATE = "EVENT_ORDLIST_NEEDVALIDATE";
        public const String EVENT_OPSTATION_REFRESH = "OpRefreshAllAction";
        /// <summary>
        /// 删除指定 id_or 医嘱
        /// </summary>
        public const String NM_ORDLIST_DELETEORDER = "NM_ORDLIST_DELETEORDER";
        public const String EVENT_ORDLIST_DELETEORDER = "EVENT_ORDLIST_DELETEORDER";
        public const String ARGKEY_DELETEORDER = "ARGKEY_DELETEORDER";
        #endregion

        #region 费用清单事件
        public const String EVENT_FEEBILL_ALLOWEDIT = "EVENT_FEEBILL_ALLOWEDIT";
        public const String EVENT_FEEBILL_FORBIDEDIT = "EVENT_FEEBILL_FORBIDEDIT";
        #endregion

        #region 发送事件给第三方系统
        public const String EVENT_ORDLIST_DATAVALIDATE = "EVENT_ORDLIST_DATAVALIDATE";
        #endregion

        #region 就诊相关事件
        /// <summary>
        /// 初诊事件
        /// </summary>
        public const String EVENT_EMS_ENSTATUS_FIRST = "EVENT_EMS_ENSTATUS_FIRST";
        /// <summary>
        /// 复诊事件
        /// </summary>
        public const String EVENT_EMS_ENSTATUS_RETURN = "EVENT_EMS_ENSTATUS_RETURN";
        #endregion

        #region Action相关事件
        public const String EVENT_ACTION_REVETSUBMIT = "RevertSignAction";
        public const String EVENT_ACTION_ORDERDELETE = UIEvent.DELETE;
        public const String EVENT_ACTION_ORDERSUBMIT = "CiSubmit";
        public const String EVENT_ACTION_HPTRANSFORMFILE = "HpTransformEnFile";
        public const String EVENT_ACTION_ORDERSAVEAS = "OrderSaveasAction";
        #endregion
        #region 组手事件
        public const String EVENT_ASSI_SHOW_ORDERTEMPLATE_OR_EDIT = "EVENT_ASSI_SHOW_ORDERTEMPLATE_OR_EDIT";
        #endregion
        #endregion

        #region 热键定义事件
        #region 医疗单按钮热键
        public const String EVENT_HOTKEY_EMS_APPEND = EVENT_EMS_APPEND;
        public const String EVENT_HOTKEY_EMS_DELETE = EVENT_EMS_DELETE;
        public const String EVENT_HOTKEY_EMS_SAVE = EVENT_EMS_SAVE;
        public const String EVENT_HOTKEY_EMS_CANCEL = EVENT_EMS_CLOSE;
        public const String EVENT_HOTKEY_EMS_APPEND_APBU = EVENT_EMS_APBU_ADD;
        public const String EVENT_HOTKEY_EXP_APPEND = EVENT_EXPENSE_ADD;
        public const String EVENT_HOTKEY_EXP_DELETE = EVENT_EXPENSE_DELETE;
        public const String EVENT_HOTKEY_EXP_SAVE = EVENT_EXPENSE_SAVE;

        public const String EVENT_HOTKEY_ORLIST_REFRESH = "EVENT_ORLIST_REFRESH";
        #endregion

        #region 表格热键
        public const String EVENT_HOTKEY_GRID_CHECKALL = "EVENT_HOTKEY_GRID_CHECKALL";
        public const String EVENT_HOTKEY_GRID_UNCHECKALL = "EVENT_HOTKEY_GRID_UNCHECKALL";
        #endregion

        #region 复制|剪切|粘贴
        public const String EVENT_HOTKEY_EDIT_COPY = "EVENT_HOTKEY_EDIT_COPY";
        public const String EVENT_HOTKEY_EDIT_CUT = "EVENT_HOTKEY_EDIT_CUT";
        public const String EVENT_HOTKEY_EDIT_PASTE = "EVENT_HOTKEY_EDIT_PASTE";
        public const String EVENT_HOTKEY_GRID_SELECTALL = "EVENT_HOTKEY_GRID_SELECTALL";
        public const String EVENT_HOTKEY_GRID_UNSELECTALL = "EVENT_HOTKEY_GRID_UNSELECTALL";
        #endregion

        //增加医嘱热键
        public const String EVENT_EMS_ADD = "EVENT_EMS_ADD";
        //用法要求字典热键
        public const String EVENT_EMS_DRUG_USAGE = "EVENT_EMS_DRUG_USAGE";
        public const String EVENT_PRAPY = "EVENT_PRAPY";
        public const String EVENT_UN_PRAPY = "EVENT_UN_PRAPY";

        public const String EVENT_HP_PAT = "EVENT_HP_PAT";
        public const String EVENT_NOT_HP_PAT = "EVENT_NOT_HP_PAT";

        #endregion
    }
}
