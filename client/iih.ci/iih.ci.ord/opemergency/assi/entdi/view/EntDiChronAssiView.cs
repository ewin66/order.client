
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.assi.entdi.view
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.entdi.view    </para>    
    /// <para>类 名 称 :  EntDiChronAssiView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/4/11 11:41:56             </para>
    /// <para>更新时间 :  2017/4/11 11:41:56             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class EntDiChronAssiView : EntDiAssiView
    {
        public EntDiChronAssiView()
            : base()
        { }

        protected override void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.xapFormControl_FormCreated(sender, e);

            urDeptDica.Visible = false;
            urDiQuery.Location = urDeptDica.Location;
        }
    }
}
