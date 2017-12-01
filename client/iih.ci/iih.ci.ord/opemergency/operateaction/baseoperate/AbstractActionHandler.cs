
using iih.ci.ord.opemergency.operateaction.dto;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.form;
using xap.mw.coreitf.d;
using xap.rui.control.basecontrol;

namespace iih.ci.ord.opemergency.operateaction.baseoperate
{
    /// <summary>
    /// <para>描    述 :  抽象事件处理链</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.operateaction.baseoperate</para>    
    /// <para>类 名 称 :  AbstractActionHandler</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/10/31 15:11:35</para>
    /// <para>更新时间 :  2016/10/31 15:11:35</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public abstract class AbstractActionHandler : XapBaseControl
    {
        /// <summary>
        /// 事件处理抽象类
        /// </summary>
        private AbstractActionHandler handlerChain;
        /// <summary>
        /// 事件处理过程中的请求参数
        /// </summary>
        protected RequestParam request;
        /// <summary>
        /// 事件内容处理反馈参数
        /// </summary>
        protected ResponseParam response;


        #region 子类实现方法

        private void DoSend(RequestParam request, ResponseParam response, AbstractActionHandler handlerChain)
        {
            this.request = request;
            this.response = response = new ResponseParam();

            this.DoSendAction(request, response);
        }

        /// <summary>
        /// 子类处理业务逻辑方法
        /// </summary>
        /// <param name="request">请求参数</param>
        /// <param name="response">返回参数</param>
        protected abstract void DoSendAction(RequestParam request, ResponseParam response);

        /// <summary>
        /// 接收反馈结果，继续下几个节点的执行
        /// </summary>
        /// <param name="request">请求参数</param>
        /// <param name="response">返回参数</param>
        protected void DoReceiveAction(RequestParam request, ResponseParam response)
        {
            if (handlerChain == null)
            {
                return;
            }

            if (response != null && response.SuccFlag == FBoolean.False)
            {
                this.ShowMessage(response.msg);
                return;
            }

            handlerChain.DoSend(request, response, this.handlerChain);
        }

        /// <summary>
        /// 发送对外事件处理
        /// </summary>
        /// <param name="uiEvent"></param>
        /// <param name="dataDic"></param>
        protected void FireBizEventSent(string uiEvent, Dictionary<string, object> dataDic)
        {
            request.opActionChainHandler.FireBizEventSent(uiEvent, dataDic);
        }

        /// <summary>
        /// 对外发送事件，需要接收返回事件
        /// </summary>
        /// <param name="sender">事件发送对象</param>
        /// <param name="uiEvent">事件发送时对外传递的UIEvent</param>
        /// <param name="receiveUiEvent">接收发送事件反馈结果的UIEvent</param>
        /// <param name="dataDic">发的数据</param>
        protected void FireBizEventSent(AbstractActionHandler sender, string uiEvent, string receiveUiEvent, Dictionary<string, object> dataDic)
        {
            request.opActionChainHandler.FireBizEventSent(sender, uiEvent, receiveUiEvent, dataDic);
        }

        /// <summary>
        /// 外部返回事件处理类，如果需要接收外部类实现该方法
        /// </summary>
        /// <param name="uiEvent"></param>
        /// <param name="dataDic">返回数据</param>
        public virtual void ReceiveBizEvent(Dictionary<string, object> dataDic)
        {

        }

        #endregion

        #region 对外公共方法

        /// <summary>
        /// 追加到事件处理链
        /// </summary>
        /// <param name="handlerChain"></param>
        /// <returns></returns>
        public AbstractActionHandler AddActionHandler(AbstractActionHandler handlerChain)
        {
            this.handlerChain = handlerChain;
            return this.handlerChain;
        }

        /// <summary>
        /// 执行事件链中各个节点
        /// </summary>
        /// <param name="request"></param>
        /// <param name="responseParam"></param>
        /// <param name="handler"></param>
        public void DoSendAction(RequestParam request, ResponseParam response, AbstractActionHandler handler)
        {
            if (handler == null)
            {
                return;
            }
            this.request = request;

            if (!this.validate(this.request))
            {
                return;
            }

            response = new ResponseParam();
            handler.DoSendAction(this.request, this.response);
        }

        #endregion

        #region 私有方法

        /// <summary>
        /// 校验请求参数是否合法
        /// </summary>
        /// <param name="request"></param>
        /// <returns></returns>
        private bool validate(RequestParam request)
        {
            if (request == null)
            {
                this.ShowMessage("请求参数不能为空！");
                return false;
            }

            if (request.ent4BannerDTO == null || string.IsNullOrEmpty(request.ent4BannerDTO.Id_ent))
            {
                this.ShowMessage("未获取患者信息，请重新加载患者");
                return false;
            }
            return true;
        }

        /// <summary>
        /// 弹出提示信息
        /// </summary>
        /// <param name="msg"></param>
        private void ShowMessage(string msg)
        {
            MessageBoxEx.Show(msg, "操作提示", MessageBoxButtons.OK, MessageBoxIconEx.Information, MessageBoxDefaultButton.Button1);
        }

        #endregion

    }
}
