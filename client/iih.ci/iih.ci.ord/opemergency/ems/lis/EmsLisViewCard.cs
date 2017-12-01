using System;
using xap.rui.control.refcontrol.events;
using xap.cli.sdk.render;
using System.Windows.Forms;
using xap.cli.sdk.render.labelcontrol;
using iih.ci.ord.opemergency.dialog;
using iih.ci.ord.opemergency.validate;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view;
using xap.rui.control.basecontrol;
using iih.ci.ord.opemergency.view.basic;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.opemergency.tool;
using xap.rui.control.forms.view;
using xap.rui.control.forms.model;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.ems
{

    /// <summary>
    /// <para>描    述 : 检验医疗单选项卡                     </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.ems  </para>    
    /// <para>类 名 称 : EmsLisViewCard               </para> 
    /// <para>版 本 号 : v1.0.0.0                        </para> 
    /// <para>作    者 : qzwang                           </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05              </para>
    /// <para>修 改 人 :                                  </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05             </para> 
    /// <para>说    明 :                     </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EmsLisViewCard : BaseEmsFormView
    {
        #region 变量定义区域
        //private UserRender detailButton;

        #endregion

        #region 构造函数区域
        public EmsLisViewCard(IEventDelegate owner = null)
            : base(owner)
        {
            this.srvItemViewType = EmsViewType.EmsLisViewType;
            this.iValidate = new EmsLisValidate();
            

        }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsLisViewCard/*"20170614034620245000"*/);

            this.RegisteFormEventImpl();
        }

        //protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        //{
        //    if (this.GetViewModel() != null)
        //    {
        //        //getControlByName("card", "name_samptp").EnterFlag = false;
        //        //getControlByName("card", "name_sampcoltime").EnterFlag = false;
        //        //this.GetXapFormControl().GetUserRender("card", "detail").Visible = (this.GetViewModel() as EmsLisViewModel).isSet();
        //    }
        //}


        #endregion

        #region 父类继承区域

        public override void SetDataPolicy(bool flag)
        {
            //this.GetXapFormControl().SetEditPolicy(flag);

            //this.allowEdit = flag;  
            this.allowEdit = flag;
            this.GetXapFormControl().SetEditable(flag);
            this.GetXapFormControl().EnterKeyDown += EmsRisViewCard_EnterKeyDown;

        }

        void EmsRisViewCard_EnterKeyDown(object sender, KeyEventArgs e)
        {
            XLabelBaseUserRender render = sender as XLabelBaseUserRender;
            if(render==null)return;
            switch (render.UserRender.Name)
            {
                case "card_name_samptp":
                    getControlByName("card", "name_sampcoltime").UserRender.Focus();
                    break;
                case "card_name_sampcoltime":
                    this.SentNotify(EventCodeType.NM_EMS_SAVE_FOCUS);
                    break;
                default:
                    break;
                    
            }
            
        
        }

        #endregion

        #region 内部事件区域
        protected override void OnXapFormControl_Load(object sender, EventArgs e)
        {
            base.OnXapFormControl_Load(sender, e);
            this.OnInit();
        }

       
        protected override void OnXapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            base.OnXapFormControl_DataChanged(sender, e);
            if (this.GetViewModel() == null)
                return;
            this.GetViewModel().OnDataChanged(e.Data, e.PropName, e.Input == null ? null : e.Input.ToString());
        }
        void OnDetailButton_MouseClick(object sender, MouseEventArgs e)
        {
            AplabsSetItemDialog dialog = new AplabsSetItemDialog(this, (this.GetViewModel() as EmsLisViewModel).getEmsOrObsList(), this.allowEdit, (this.GetViewModel() as EmsLisViewModel).checkRadio())
            {
                Dock = DockStyle.Fill,
                Size = new System.Drawing.Size(400, 300)
            };
            dialog.ShowDialog();
        }

        protected override void OnXapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            if (this.GetViewModel() != null)
            {
                e.WherePart = this.GetViewModel().OnRefFilterData(e.BindingFieldName);
                if (e.BindingFieldName.Equals("Name_diag")) {
                    e.RefParams.AddParam("id_ent", (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).PatInfo.Id_ent);
                }
            }
            else
            {
                e.WherePart = "";
            }
        }

        public override bool OnEventHandle(object sender, DictionaryEventArgs e)
        {
            switch (AssToolEx.EventCodeOfEventArgs(e))
            {
                case EventCodeType.EVENT_EMS_CARDFOCUS:
                    if (getControlByName("card", "name_samptp").Enabled == false)
                    {
                        getControlByName("card", "name_sampcoltime").UserRender.Focus();
                    }
                    else
                    {
                        getControlByName("card", "name_samptp").UserRender.Focus();
                    }
                    break;
                default:
                    break;
            }
            return base.OnEventHandle(sender, e);
        }

        #endregion

        #region 辅助处理函数
        private XLabelBaseUserRender getControlByName(string tableKey, string name)
        {
            XLabelBaseUserRender tmpUserRender = this.GetXapFormControl().GetUserRender(tableKey, name) as XLabelBaseUserRender;
            return tmpUserRender;
        }
        #endregion

    }
}
