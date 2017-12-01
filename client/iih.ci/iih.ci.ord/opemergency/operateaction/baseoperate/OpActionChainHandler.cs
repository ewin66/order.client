
using iih.ci.iih.ci.ord.i;
using iih.ci.ord.opemergency.action.costant;
using iih.ci.ord.opemergency.operateaction.dto;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.controls;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.bizcontrol.bannerview;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.eventbroker.Handlers;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.operateaction.baseoperate
{
    /// <summary>
    /// <para>描    述 :  门诊事件链初始化类</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.operateaction.baseoperate</para>    
    /// <para>类 名 称 :  OpActionChainHandler</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/10/31 14:17:27</para>
    /// <para>更新时间 :  2016/10/31 14:17:27</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OpActionChainHandler : XapBaseControl
    {
        #region 变量定义区域

        /// <summary>
        /// 事件链请求参数
        /// </summary>
        private RequestParam request;
        
        /// <summary>
        /// 诊毕处理链开始节点集合
        /// </summary>
        private Dictionary<string, AbstractActionHandler> actionHandlerDic = new Dictionary<string, AbstractActionHandler>();

        /// <summary>
        /// 任务链处理相关的xml
        /// </summary>
        private Dictionary<string, string> configPathDic = new Dictionary<string, string>() {
            { OpActionConstant.OP_COMPLETE_ACTION,"modules\\iihci\\ui\\optrdocstation\\actionchain\\OPCompleteAndRevokeConfig.xml"},// 诊毕
            { OpActionConstant.OP_COMPLETE_AND_NEXT_ACTION,"modules\\iihci\\ui\\optrdocstation\\actionchain\\OPCompleteAndRevokeConfig.xml"}, // 诊毕并下一个
            { OpActionConstant.OP_SUSPEND_ACTION,"modules\\iihci\\ui\\optrdocstation\\actionchain\\OPSuppendConfig.xml"},// 待回诊
            { OpOperateActionEvent.BANNER_SWITCHING_USER,"modules\\iihci\\ui\\optrdocstation\\actionchain\\OPBannerSwitchingUserConfig.xml"},// 切换用户触发诊毕
            { OpActionConstant.OP_CANCEL_ACTION,"modules\\iihci\\ui\\optrdocstation\\actionchain\\OPCancelConfig.xml"},// 取消接诊
            { OpActionConstant.OP_DI_CHECK_OR_SIGN_ACTION,"modules\\iihci\\ui\\optrdocstation\\actionchain\\OPDiCheck4OrSignConfig.xml"},// 校验诊断（签署医嘱）
            { OpActionConstant.OP_DI_CHECK_OR_OPEN_ACTION,"modules\\iihci\\ui\\optrdocstation\\actionchain\\OPDiCheck4OrOpenConfig.xml"}// 校验诊断（签署医嘱）
        };

        /// <summary>
        /// 按钮集合
        /// </summary>
        private List<XBroadcastAction> menuActionList = new List<XBroadcastAction>();

        /// <summary>
        /// 缓存与外部进行事件交互的对象集合，key 
        /// </summary>
        private Dictionary<string, AbstractActionHandler> handlerReceiveDic = new Dictionary<string, AbstractActionHandler>();
        
        #endregion

        #region 构造函数区域

        public OpActionChainHandler()
        {
            request = new RequestParam();
        }

        #endregion

        #region 事件发送区域

        /// <summary>
        /// 对外发送事件，不需要返回事件
        /// </summary>
        /// <param name="uiEvent"></param>
        /// <param name="dataDic"></param>
        public void FireBizEventSent(string uiEvent, Dictionary<string, object> dataDic)
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, uiEvent);
            args.Data.Add(UIConst.DATA, dataDic);
            this.FireEventSent(this, args);
        }

        /// <summary>
        /// 对外发送事件，需要接收返回事件
        /// </summary>
        /// <param name="sender">事件发送对象</param>
        /// <param name="uiEvent">发送事件的UIEvent</param>
        /// <param name="receiveUiEvent">事件接收的UIEvent</param>
        /// <param name="dataDic">发的数据</param>
        public void FireBizEventSent(AbstractActionHandler sender, string uiEvent, string receiveUiEvent, Dictionary<string, object> dataDic)
        {
            // 接收返回处理事件的对象只加一次
            if (!string.IsNullOrEmpty(receiveUiEvent) && !handlerReceiveDic.ContainsKey(receiveUiEvent))
            {
                handlerReceiveDic.Add(receiveUiEvent, sender);
            }

            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, uiEvent);  //uiEvent = clearBanner
            args.Data.Add(UIConst.DATA, dataDic); //dataDic :key = clearBanner value = "OpComplete" 诊毕清空， value= "OpCompleteAndNextAction" 完成下一个清空           
            this.FireEventSent(sender, args);
        }

        #endregion

        #region 事件接收区域

        /// <summary>
        /// 接收返回事件
        /// </summary>
        /// <param name="uiEvent"></param>
        /// <param name="dataDic">返回的数据对象</param>
        private void ReceiveActionHandleState(string uiEvent, Dictionary<string, object> dataDic)
        {
            if (handlerReceiveDic.ContainsKey(uiEvent))
            {
                handlerReceiveDic[uiEvent].ReceiveBizEvent(dataDic);
                handlerReceiveDic.Remove(uiEvent);// 诊毕后清空缓存接收事件的key ，否则会导致重复触发
            }
        }       
        
        #endregion

        #region 父类继承区域

        /// <summary>
        ///  根据选择的患者获取的属性信息
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            bannerOpdocstation banner = sender as bannerOpdocstation;

            if (banner != null) {
                BannerData bannerData = e.Object as BannerData;
                if (bannerData != null && bannerData.Ent4BannerDTO != null)
                {
                    request.ent4BannerDTO = bannerData.Ent4BannerDTO;
                    request.context = this.Context;
                    request.opActionChainHandler = this;
                }
                else {
                    request.ent4BannerDTO = null;
                    request.context = null;
                }
            }
            
        }

        private void GetActionView()
        {
            List<XBaseControl> xBaseCtrlList = this.Context.Config.GetViews();
            foreach (XBaseControl xBaseCtrl in xBaseCtrlList)
            {
                XBroadcastAction action = new XBroadcastAction();
                menuActionList.Add(action);
            }
        }

        #endregion

        #region 辅助处理函数   

        /// <summary>
        /// 诊毕流程
        /// </summary>
        /// <param name="actionName">触发事件的（菜单、按钮）名称，如果后续逻辑需要判断就加，不需要可以不加</param>
        private void CreateCompleteHandlerChain(string actionName)
        {
            if (request.context == null || request.ent4BannerDTO == null) {
                return;
            }

            AbstractActionHandler startCompleteHandler = null;
            string idDep = this.Context.Dept.Id_dep;
            // 诊毕状态 0 无诊毕 可以去掉诊毕按钮，任何业务部受限制
            // 1 仅诊毕 通过点击诊毕按钮，进行批量业务处理（是否处理按业务场景确定，比如是否修改诊毕状态，是否调用打印）
            // 2 诊毕撤回，严格控制诊毕后不允许做其他业务，只有进行撤回后才能继续
            //string finishMode = this.Context.GetParam<string>(idDep, ICiOrdNSysParamConst.SYS_PARAM_OpThisPatVisitFinishMode);

            // 设置按钮事件名称
            request.actionName = actionName;

            startCompleteHandler = this.GetStartCompleteHandler(actionName);
            if (startCompleteHandler != null)
            {
                startCompleteHandler.DoSendAction(request, null, startCompleteHandler);
            }
        }

        /// <summary>
        /// 获取任务处理链的对象
        /// </summary>
        /// <param name="actionName"></param>
        /// <returns></returns>
        private AbstractActionHandler GetStartCompleteHandler(string actionName) {

            if (actionHandlerDic.ContainsKey(actionName)) {
                return actionHandlerDic[actionName];
            }

            string xmlCfgPath = null;
            if (this.configPathDic.ContainsKey(actionName)) {
                xmlCfgPath = configPathDic[actionName];
            }

            if (xmlCfgPath == null) {
                return null;
            }

            return this.CreateActionHandlerChain(xmlCfgPath);
        }

        /// <summary>
        /// 创建诊毕逻辑链，返回链中起始节点
        /// </summary>
        private AbstractActionHandler CreateActionHandlerChain(string xmlCfgPath)
        {
            // 责任链第一个节点
            AbstractActionHandler startHandler = null;
            AbstractActionHandler preActionHandler = null;
            AbstractActionHandler nextActionHandler = null;            

            XUserControl xUserControl = new XUserControl();
            xUserControl.Init(xmlCfgPath);

            List<XBaseControl> xbaseCtrlList = xUserControl.GetConfig().GetViews();
            if (xbaseCtrlList != null)
            {
                foreach (XBaseControl xBaseCtrl in xbaseCtrlList)
                {
                    nextActionHandler = xBaseCtrl as AbstractActionHandler;
                    preActionHandler = this.AddNextActionHandler(preActionHandler, nextActionHandler);
                    if (startHandler == null)
                    {
                        startHandler = nextActionHandler;
                    }
                }
            }

            return startHandler;
        }

        private AbstractActionHandler AddNextActionHandler(AbstractActionHandler preHandler, AbstractActionHandler nextHandler)
        {
            if (nextHandler == null)
            {
                return preHandler;
            }

            if (preHandler != null)
            {
                preHandler = preHandler.AddActionHandler(nextHandler);
            }
            else
            {
                preHandler = nextHandler;
            }
            return preHandler;
        }


        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs e)
        {
            // 获取事件类型
            string uiEvent = e.Data[UIConst.UI_EVENT] as string;
            Dictionary<string, object> dataDic = e.Data[UIConst.DATA] as Dictionary<string, object>;

            switch (uiEvent)
            {
                case UIEvent.LOAD:
                    break;
                case OpActionConstant.OP_COMPLETE_ACTION: // 诊毕 bannner中按钮点击事件
                    this.CreateCompleteHandlerChain(OpActionConstant.OP_COMPLETE_ACTION);
                    break;
                case OpActionConstant.OP_COMPLETE_AND_NEXT_ACTION: // 诊毕并下一个
                    this.CreateCompleteHandlerChain(OpActionConstant.OP_COMPLETE_AND_NEXT_ACTION);
                    break;
                case OpActionConstant.OP_SUSPEND_ACTION:// 待回诊
                    this.CreateCompleteHandlerChain(OpActionConstant.OP_SUSPEND_ACTION);
                    break;
                case OpOperateActionEvent.BANNER_SWITCHING_USER:// banner切换用户触发的诊毕
                    this.CreateCompleteHandlerChain(OpOperateActionEvent.BANNER_SWITCHING_USER);
                    break;
                case OpActionConstant.OP_CANCEL_ACTION:// 取消接诊
                    this.CreateCompleteHandlerChain(OpActionConstant.OP_CANCEL_ACTION);
                    break;
                case OpActionConstant.OP_DI_CHECK_OR_SIGN_ACTION:// 校验诊断（签署医嘱）
                    this.CreateCompleteHandlerChain(OpActionConstant.OP_DI_CHECK_OR_SIGN_ACTION);
                    break;
                case OpActionConstant.OP_DI_CHECK_OR_OPEN_ACTION:// 校验诊断（开立医嘱）
                    this.CreateCompleteHandlerChain(OpActionConstant.OP_DI_CHECK_OR_OPEN_ACTION);
                    break;
                default:
                    this.ReceiveActionHandleState(uiEvent, dataDic);
                    break;
            }
        }
        #endregion
    }
}
