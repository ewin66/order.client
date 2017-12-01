
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.emreditor.viewmodel
{
    /// <summary>
    /// <para>描    述 : </para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.emreditor.viewmodel    </para>    
    /// <para>类 名 称 :  EmrEditorConst					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/8/9 15:52:24</para>
    /// <para>更新时间 :  2016/8/9 15:52:24</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public static class EmrEditorConst
    {

        #region  撤回按钮状态

        /// <summary>
        /// OpRevokeEnAction按钮状态为只读
        /// </summary>
        public const string OPREVOKEEN_ACTION_READONLY = "OpRevokeEn_Action_Readonly";
        /// <summary>
        /// OpRevokeEnAction按钮状态为可操作状态
        /// </summary>
        public const string OPREVOKEEN_ACTION_OPERABLE = "OpRevokeEn_Action_Operable";
        /// <summary>
        /// OpRevokeEnAction按钮状态为不可见
        /// </summary>
        public const string OPREVOKEEN_ACTION_HIDDEN = "OpRevokeEn_Action_Hidden";

        #endregion

        #region  按钮名称

        /// <summary>
        /// 就诊撤回按钮
        /// </summary>
        public const string OP_REVOKEEN_ACTION = "OpRevokeEnAction";

        #endregion

        #region  常量属性

        // 门诊病历管理模式:医生打印=0,病案统一打印=1,无纸化模式=2,医生手写=3
        /// <summary>
        /// 医生打印=0
        /// </summary>
        public const string OMR_MGMT_MD_0 = "0";
        /// <summary>
        /// 病案统一打印=1
        /// </summary>
        public const string OMR_MGMT_MD_1 = "1";
        /// <summary>
        /// 无纸化模式=2
        /// </summary>
        public const string OMR_MGMT_MD_2 = "2";
        /// <summary>
        /// 医生手写=3
        /// </summary>
        public const string OMR_MGMT_MD_3 = "3";

        #endregion

        #region 事件名称


        /// <summary>
        /// 传递病历对象Mr参数key值
        /// </summary>
        public const string PARAM_CIMRDO = "CiMrDo";

        /// <summary>
        /// banner设置常量参数,用与Dictionary中key值
        /// </summary>
        public const string PARAM_ENT4BANNERDTO = "Ent4BannerDto";


        /// <summary>
        /// 加载病历事件
        /// </summary>
        public const string LOAD_EMR_EDITOR_CIMR_EVENT = "LoadEmrEditorCimrEvent";

        /// <summary>
        /// 加载初复诊病历事件
        /// </summary>
        public const string LOAD_FIRST_VISIT_EMR_EVENT = "LoadFirstVisitEmrEvent";

        /// <summary>
        /// 刷新门诊病历选择下拉框事件
        /// </summary>
        public const string REFSH_EMR_LIST_EVENT = "RefshEmrListEvent";

        #endregion

    }
}
