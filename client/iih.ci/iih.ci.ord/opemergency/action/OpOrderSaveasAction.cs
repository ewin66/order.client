
using System;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    public class OpOrderSaveasAction : XBroadcastAction
    {
        public OpOrderSaveasAction()
            : base("OrderSaveasAction", "OrderSaveasAction", Keys.None, "另存为医嘱模板", "保存")
        { }
    }
}
