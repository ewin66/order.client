using iih.ci.ord.opemergency.action.costant;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    public class OpPreCalcFeeAction : XBroadcastAction
    {
        public OpPreCalcFeeAction()
            : base(OpActionConstant.OP_PRECALC_FEE_ACTION, OpActionConstant.OP_PRECALC_FEE_ACTION, Keys.F3, "预付费", "期初记账")
        { }
    }
}
