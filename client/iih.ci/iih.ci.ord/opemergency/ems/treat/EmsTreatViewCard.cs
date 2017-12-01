using System;
using xap.rui.control.basecontrol;
using xap.cli.sdk.controls.herbalPrescription;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.validate;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view;
using iih.ci.ord.opemergency.view.basic;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.opemergency.ems
{
    /// <summary>
    /// <para>描    述 :  治疗医疗单选项卡          	</para>
    /// <para>说    明 :  简洁              			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems    </para>    
    /// <para>类 名 称 :  EmsTreatViewCard					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  7/28/2016 5:13:42 PM             </para>
    /// <para>更新时间 :  7/28/2016 5:13:42 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EmsTreatViewCard : BaseEmsFormView
    {
        #region 变量定义区域
        //HerBalMedicineCtr her;

        //private EmsOrDrug selectDrugDo;
      
        #endregion

        #region 构造函数区域
        public EmsTreatViewCard(IEventDelegate o )
            : base(o)
        {
            this.srvItemViewType = EmsViewType.EmsTreatViewType;
            this.iValidate = new EmsTreatValidate();

        }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsTreatViewCard/*"201606070751084765ID"*/);

            this.RegisteFormEventImpl();
        }
        #endregion


        #region 内部事件区域

        protected override void OnXapFormControl_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

       
        #endregion

        #region 辅助处理函数
        
        public override void SetDataPolicy(bool flag)
        {
            //this.GetXapFormControl().SetEditPolicy(flag);

            //allowEdit = flag;
            this.allowEdit = flag;
            this.GetXapFormControl().SetEditable(flag);
        }
        #endregion

        
    }
}
