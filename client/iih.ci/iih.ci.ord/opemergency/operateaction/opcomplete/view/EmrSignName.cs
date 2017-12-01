
using iih.ci.ord.opemergency.operateaction.baseoperate;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.opemergency.operateaction.dto;
using iih.ci.ord.common.utils.msg;

namespace iih.ci.ord.opemergency.operateaction.opcomplete.view
{
    /// <summary>
    /// <para>描    述 :  病历签名</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.operateaction.opcomplete.view</para>    
    /// <para>类 名 称 :  EmrSignName</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/11/1 15:02:37</para>
    /// <para>更新时间 :  2016/11/1 15:02:37</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmrSignName : AbstractActionHandler
    {
        /// <summary>
        /// 对外发送病历签名事件 
        /// </summary>
        /// <param name="request"></param>
        /// <param name="response"></param>
        protected override void DoSendAction(RequestParam request, ResponseParam response)
        {
            this.FireBizEventSent(this, OpOperateActionEvent.EMR_SIGN_NAME, OpOperateActionEvent.EMR_SIGN_NAME_RESULT, null);
        }

        /// <summary>
        /// 接收外部事件处理之后的返回结果
        /// </summary>
        /// <param name="dataDic"></param>
        public override void ReceiveBizEvent(Dictionary<string, object> dataDic)
        {

            //包括key值 代表签名成功
            if (dataDic.ContainsKey(OpOperateActionEvent.EMR_SIGN_NAME_RESULT))
            {
                // 0: 签名失败，1：签名成功 ，2:拒绝签名
                int result = (int)dataDic[OpOperateActionEvent.EMR_SIGN_NAME_RESULT];

                switch (result)
                {
                    case OpOperateActionEvent.EMR_SIGN_NAME_FAILED:
                        //string msg = "";
                        //if (dataDic.ContainsKey(OpOperateActionEvent.MSG))
                        //{
                        //    msg = dataDic[OpOperateActionEvent.MSG] as string;
                        //}
                        //else
                        //{
                        //    msg = "病历操作失败！";
                        //}

                        //BizAssMessageBoxUtil.ShowIn//forMsg(msg);
                        break;
                    case OpOperateActionEvent.EMR_SIGN_NAME_SUCC:
                        this.DoReceiveAction(this.request, this.response);
                        break;
                    case OpOperateActionEvent.EMR_SIGN_NAME_REFUSE:
                        //BizAssMessageBoxUtil.ShowInforMsg("当前病历由其他医生书写，您不能对该病历签名！");
                        break;

                }
            }
        }
    }
}
