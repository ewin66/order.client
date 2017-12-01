
using iih.bd.bc.udi;
using iih.ci.ord.opemergency.action.costant;
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.opemergency.declare;
using xap.cli.sdk.controller.action;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.bizcontrol.bannerview;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using xap.rui.engine.statehandlers;
using xap.rui.engine.xactions;
using iih.ci.iih.ci.ord.i.external.obtain;
using xap.mw.serviceframework;
using xap.mw.coreitf.d;
using iih.ci.ord.i;

namespace iih.ci.ord.opemergency.action.statehandler
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.action.statehandler</para>    
    /// <para>类 名 称 :  OpActionsStatusHandler</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/11/2 14:32:11</para>
    /// <para>更新时间 :  2016/11/2 14:32:11</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OpActionsStatusHandler : XapBaseControl
    {

        private ICiOrdBlRService iCiOrdBlRService;
        
        public OpActionsStatusHandler()
        {            
            iCiOrdBlRService = XapServiceMgr.find<ICiOrdBlRService>();
        }

        /// <summary>
        /// 缓存按钮在不同状态下按钮的操作状态 第一层key 值为按钮的ActionId ,value 对应按钮不同状态下是否可操作
        /// </summary>
        private Dictionary<string, Dictionary<string, bool>> actionStatusDic = new Dictionary<string, Dictionary<string, bool>>();

        // 切换患者后不可用菜单集合
        private List<string> disabledMenuList = new List<string>();
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            bannerOpdocstation banner = sender as bannerOpdocstation;
            if (banner != null)
            {
                BannerData bannerData = e.Object as BannerData;
                if (bannerData != null && bannerData.Ent4BannerDTO != null)
                {
                    // 初始化菜单默认状态值
                    this.InitMenusFixedStatus(bannerData.Ent4BannerDTO);

                    this.SetActionsStatus(bannerData.Ent4BannerDTO.Sd_status);

                    if (bannerData.Ent4BannerDTO.Sd_hptp != null && bannerData.Ent4BannerDTO.Sd_hptp.Substring(0, 1).Equals("2"))
                    {
                       // this.SetActionsStatus(EventCodeType.EVENT_PRAPY);
                    }
                    else
                    {
                        this.SetActionsStatus(EventCodeType.EVENT_UN_PRAPY);
                    }
                    if (bannerData.Ent4BannerDTO.Sd_hptp != null && bannerData.Ent4BannerDTO.Sd_hptp.Substring(0, 1).Equals("1"))
                    {
                        this.SetActionsStatus(EventCodeType.EVENT_HP_PAT);
                    }
                    else
                    {
                        this.SetActionsStatus(EventCodeType.EVENT_NOT_HP_PAT);
                    }

                }
                else
                {
                    this.SetActionsStatus(UIEvent.LOAD);
                }
            }
        }


        public override void HandleState(object sender, DictionaryEventArgs e)
        {
            DictionaryEventArgs de = new DictionaryEventArgs();
            string uiEvent = e.Data[UIConst.UI_EVENT] as string;
            string newState = e.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.LOAD:

                    if (actionStatusDic.Count == 0)
                    {
                        this.InitActionStatusDic();
                    }

                    this.SetActionsStatus(UIEvent.LOAD);

                    break;
            }
        }

        /// <summary>
        /// 设置按钮状态
        /// </summary>
        /// <param name="state">当前</param>
        private void SetActionsStatus(string uiEvent)
        {
            List<IAction> actionList = this.Context.Config.GetActions();
            foreach (IAction action in actionList)
            {
                // 如果在确定结果中存在，根据确定结果设置按钮可操作状态
                if (disabledMenuList.Contains(action.ActionID))
                {
                    action.Enabled = false;
                    continue;
                }

                if (actionStatusDic.ContainsKey(action.ActionID))
                {
                    Dictionary<string, bool> dic = actionStatusDic[action.ActionID];
                    if (dic.ContainsKey(uiEvent))
                    {
                        action.Enabled = dic[uiEvent];
                    }
                }
            }
        }

        /// <summary>
        /// 初始化各按钮不同状态下的可操作性
        /// </summary>
        private void InitActionStatusDic()
        {
            // 加载时按钮允许编辑状态
            Dictionary<string, bool> loadStateDic = new Dictionary<string, bool>();
            loadStateDic.Add(UIEvent.LOAD, true);

            // 默认加载、诊毕、就诊状态时按钮对饮的状态
            Dictionary<string, bool> defaultEnStateDic = new Dictionary<string, bool>();
            defaultEnStateDic.Add(UIEvent.LOAD, false);// 默认加载
            defaultEnStateDic.Add(EnDictCodeConst.SD_ENSTATUS_OP_FINISH, false);// 门诊诊毕
            defaultEnStateDic.Add(EnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER, true);// 门诊就诊

            // 默认患者后就诊、诊毕按钮都可用状态
            Dictionary<string, bool> loadPatStateDic = new Dictionary<string, bool>();
            loadPatStateDic.Add(UIEvent.LOAD, false);// 默认加载
            loadPatStateDic.Add(EnDictCodeConst.SD_ENSTATUS_OP_FINISH, true);// 门诊诊毕
            loadPatStateDic.Add(EnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER, true);// 门诊就诊

            Dictionary<string, bool> loadFeeStatDic = new Dictionary<string, bool>();
            loadFeeStatDic.Add(UIEvent.LOAD, false);// 默认加载
            loadFeeStatDic.Add(EventCodeType.EVENT_PRAPY, false);
            loadFeeStatDic.Add(EventCodeType.EVENT_UN_PRAPY, true);
            loadFeeStatDic.Add(EnDictCodeConst.SD_ENSTATUS_OP_FINISH, false);// 门诊诊毕
            loadFeeStatDic.Add(EnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER, true);// 门诊就诊

            // 默认加载、诊毕、就诊状态时按钮对饮的状态
            Dictionary<string, bool> hpSharingStateDic = new Dictionary<string, bool>();
            hpSharingStateDic.Add(UIEvent.LOAD, false);// 默认加载
            hpSharingStateDic.Add(EventCodeType.EVENT_HP_PAT, true);// 社保患者
            hpSharingStateDic.Add(EventCodeType.EVENT_NOT_HP_PAT, false);// 非社保患者

            #region 病历保存

            // 病历保存
            actionStatusDic.Add(OpActionConstant.EMR_SAVE_ACTION, defaultEnStateDic);

            // 删除病历
            actionStatusDic.Add(OpActionConstant.EMR_DELETE_ACTION, defaultEnStateDic);

            #endregion

            #region 处置

            // 处置删除
            actionStatusDic.Add(OpActionConstant.OP_ORDER_DELETE_ACTION, defaultEnStateDic);

            // 处置签署
            actionStatusDic.Add(OpActionConstant.OP_ORDER_REVERT_SIGN_ACTION, defaultEnStateDic);

            // 处置撤回
            actionStatusDic.Add(OpActionConstant.OP_ORDER_SIGN_ACTION, defaultEnStateDic);

            // 门诊预交金
            actionStatusDic.Add(OpActionConstant.OP_PRECALC_FEE_ACTION, loadFeeStatDic);
            // 门诊取消记账
            actionStatusDic.Add(OpActionConstant.OP_PRESCANCEL_FEE_ACTION, loadFeeStatDic);
            //医嘱共享
            actionStatusDic.Add(OpActionConstant.HISTORY_MEDICAL_SHARING_DATE, hpSharingStateDic);
            #endregion


            #region 打印菜单

            // 打印
            actionStatusDic.Add(OpActionConstant.OP_PRINT_ACTION, loadPatStateDic);

            // 打印病历
            actionStatusDic.Add(OpActionConstant.EMR_PRINT_ACTION, loadPatStateDic);

            // 病历打印预览
            actionStatusDic.Add(OpActionConstant.EMR_PRINT_VIEW_ACTION, loadPatStateDic);

            // 处方打印
            actionStatusDic.Add(OpActionConstant.ORD_PRES_PRINT_ACTION, loadPatStateDic);

            #endregion

            #region 数据中心

            // 数据中心 加载时可用
            actionStatusDic.Add(OpActionConstant.DATA_CENTER_ACTION, loadPatStateDic);

            #endregion 

            #region 诊毕菜单

            // 诊毕
            actionStatusDic.Add(OpActionConstant.OP_COMPLETE_ACTION, defaultEnStateDic);

            // 完成并下一个
            actionStatusDic.Add(OpActionConstant.OP_COMPLETE_AND_NEXT_ACTION, defaultEnStateDic);

            #endregion


            #region 工作表单

            // 工作表单
            actionStatusDic.Add(OpActionConstant.OP_EMR_DOC_ACTION, defaultEnStateDic);

            // 诊断证明
            actionStatusDic.Add(OpActionConstant.OP_PROOF_OF_DIAGNOSIS, defaultEnStateDic);

            // 住院通知
            actionStatusDic.Add(OpActionConstant.HOSPITAL_NOTICE_ACTION, defaultEnStateDic);

            // 牙周检查表
            actionStatusDic.Add(OpActionConstant.OP_EMR_PER_ACTION, defaultEnStateDic);

            // 医保转诊单
            actionStatusDic.Add(OpActionConstant.OP_HP_TRANSFORM_EN_FILE_ACTION, defaultEnStateDic);

            #endregion


            #region 其他

            // 其他 加载时可用
            actionStatusDic.Add(OpActionConstant.OP_OTHER_ACTION, loadStateDic);

            // 诊间预约 加载时可用
            actionStatusDic.Add(OpActionConstant.ENT_APPOINTMENT_ACTION, loadStateDic);
            // 诊间预约取消 加载时可用
            actionStatusDic.Add(OpActionConstant.ENT_APPOINT_CANCEL_ACTION, loadStateDic);


            // 就诊撤回 病历诊毕状态需要根据病历打印策略进行单独控制
            //actionStatusDic.Add(OpActionConstant.OP_REVOKE_EN_ACTION, loadEncounterStateDic);

            //报告查看
            actionStatusDic.Add(OpActionConstant.REPORT_VIEW_ACTION, loadPatStateDic);
            // 检验报告
            actionStatusDic.Add(OpActionConstant.LIS_HISTORY_REPORT_ACTION, loadPatStateDic);
            // 检查报告
            actionStatusDic.Add(OpActionConstant.RIS_HISTORY_REPORT_ACTION, loadPatStateDic);

            #endregion

            #region 门诊刷新
            //门诊刷新
            actionStatusDic.Add(OpActionConstant.OP_REFRESH_ALL_ACTION, loadStateDic);
            #endregion
        }

        /// <summary>
        /// 初始化菜单固定状态值，key 菜单id，value 是否可用，true 可用，false 不可用
        /// </summary>
        /// <param name="ent4BannerDTO"></param>
        private void InitMenusFixedStatus(Ent4BannerDTO ent4BannerDTO)
        {

            disabledMenuList = new List<string>();

            FBoolean isUsePrePay = iCiOrdBlRService.IsPatUsePrePay(ent4BannerDTO.Id_pat, ent4BannerDTO.Id_ent, null);
            if (isUsePrePay != true)
            {
                disabledMenuList.Add(OpActionConstant.OP_PRECALC_FEE_ACTION);
            }
        }
    }
}
