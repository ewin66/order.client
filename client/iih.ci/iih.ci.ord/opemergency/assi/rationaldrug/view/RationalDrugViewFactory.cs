
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.assi.rationaldrug.view
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.rationaldrug.view    </para>    
    /// <para>类 名 称 :  RationalDrugViewFactory					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/9/29 19:22:52             </para>
    /// <para>更新时间 :  2016/9/29 19:22:52             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class RationalDrugViewFactory : XapBaseControl
    {
        //private BaseContext context = null;
        private static RationalDrugView view = null;

        public RationalDrugViewFactory()
        {            
            InitializeComponent();
        }

        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (view == null) {
                view = this.Context.Config.GetInstance("RationalDrugView") as RationalDrugView;
            }
        }


        public static RationalDrugView GetInstance() {

            
            if (view == null)
            {                
                view = new RationalDrugView();
            }

            return view;
            
        }

        public override void HandleState(object sender, DictionaryEventArgs e)
        {
            
        }

    }
}
