/* =======================================================
 * Filename: OpAddTicketsAction
 * Date: 2016/7/25 14:21:13
 * Compiler: Microsoft Visual Studio 2010
 * Author: 刘 斌
 * Company: Copyright 2016 by PKU heaithcare IT Co.,Ltd
 * Description: 诊间加号按钮
 * =======================================================
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// 诊间加号
    /// </summary>
    class OpAddTicketsAction:XBroadcastAction
    {
        public OpAddTicketsAction()
            : base("OpAddTickets", "OpAddTickets", Keys.None, "诊间加号",
                "诊间加号"
                ) { }
    }
}
