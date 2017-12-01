using System;
using System.Drawing;
using System.Windows.Forms;
using xap.cli.sdk.render;
using xap.cli.sdk.render.labelcontrol;
using iih.ci.ord.opemergency.ems.dp;
using xap.cli.sdk.common;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.Render.Items;
using iih.ci.ord.opemergency.view.basic;
using iih.ci.ord.opemergency.ems.stomatology;
using iih.ci.ord.ciorder.utils;
using xap.cli.sdk.render.Items;
using iih.ci.ord.opemergency.tool;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.opemergency.ems
{

    /// <summary>
    /// <para>描    述 : CBCT-NEW【00010734】                     </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.ems  </para>    
    /// <para>类 名 称 : EmsRisViewCard               </para> 
    /// <para>版 本 号 : v1.0.0.0                        </para> 
    /// <para>作    者 : qzwang                           </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05              </para>
    /// <para>修 改 人 :                                  </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05             </para> 
    /// <para>说    明 :                     </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EmsStomatologyCBCTNEWViewCard : EmsRisViewCard
    {
        #region 构造函数区域
        public EmsStomatologyCBCTNEWViewCard(IEventDelegate owner)
            : base(owner)
        {
        }
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsStomatologyCBCTNEWViewCard/*"20170629075510039000"*/);
        }

        #endregion
    }
}
