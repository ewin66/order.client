
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;
using iih.ci.ord.opemergency.action.costant;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.action    </para>    
    /// <para>类 名 称 :  OpOrderCancelAction					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/8/16 19:17:38             </para>
    /// <para>更新时间 :  2017/8/16 19:17:38             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class OpOrderCancelAction : XBroadcastAction
    {
        public OpOrderCancelAction()
            : base(OpActionConstant.OP_ORDER_CANCEL_ACTION, OpActionConstant.OP_ORDER_CANCEL_ACTION, Keys.None, "处置作废", "取消提交")
        { }
    }
}
