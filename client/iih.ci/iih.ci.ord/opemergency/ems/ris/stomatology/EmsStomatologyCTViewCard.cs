using System;
using System.Drawing;
using System.Windows.Forms;
using iih.ci.ord.opemergency.dialog;
using xap.rui.control.basecontrol;
using xap.cli.sdk.render;
using xap.cli.sdk.render.labelcontrol;
using iih.ci.ord.ciorder.utils;
using xap.rui.control.refcontrol.events;
using iih.ci.ord.opemergency.validate;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view;
using iih.ci.ord.opemergency.view.basic;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.opemergency.ems
{

    /// <summary>
    /// <para>描    述 : 口腔CT检查医疗单                     </para> 
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
    public partial class EmsStomatologyCTViewCard : EmsRisViewCard
    {

        #region 构造函数区域
        public EmsStomatologyCTViewCard(IEventDelegate owner)
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
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsStomatologyCTViewCard/*"20160914073523360000"*/);
        }

        #endregion
        #region 内部事件区域
        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            if (this.GetViewModel() != null)
            {
                EmsStomatologyCTViewModel tmpModel = this.GetViewModel() as EmsStomatologyCTViewModel;
                //this.detailButton.Visible = tmpModel.isSet();
            }
        }
        #endregion
    }
}
