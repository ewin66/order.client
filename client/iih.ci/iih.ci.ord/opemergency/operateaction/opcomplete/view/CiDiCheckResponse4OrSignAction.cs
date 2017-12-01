
using System;
using System.Collections.Generic;
using iih.ci.ord.opemergency.operateaction.baseoperate;
using iih.ci.ord.opemergency.operateaction.dto;
using iih.ci.ord.opemergency.action.costant;

namespace iih.ci.ord.opemergency.operateaction.opcomplete.view
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.operateaction.opcomplete.view    </para>    
    /// <para>类 名 称 :  CiDiCheckResponse4OrSignAction					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/10/31 17:17:40             </para>
    /// <para>更新时间 :  2017/10/31 17:17:40             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class CiDiCheckResponse4OrSignAction : AbstractActionHandler
    {
        /// <summary>
        /// 
        /// </summary>
        /// <param name="request"></param>
        protected override void DoSendAction(RequestParam request, ResponseParam response)
        {
            this.FireBizEventSent(this, OpActionConstant.OP_DI_RESPONSE_SEND_OR_SIGN_ACTION, null, null);
            this.DoReceiveAction(request, response);
        }
    }
}
