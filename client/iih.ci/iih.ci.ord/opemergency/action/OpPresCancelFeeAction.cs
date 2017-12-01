using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.opemergency.action.costant;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    public class OpPresCancelFeeAction : XBroadcastAction
    {
        public OpPresCancelFeeAction()
            : base(OpActionConstant.OP_PRESCANCEL_FEE_ACTION, OpActionConstant.OP_PRESCANCEL_FEE_ACTION, Keys.None, "取消预付费", "取消记账")
        { }
    }
}
