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
using xap.rui.control.forms.view;
using iih.ci.ord.opemergency.view.basic;
using iih.ci.ord.ciordems.d;
using xap.rui.engine;
using iih.ci.ord.opemergency.tool;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.control.forms.model;
using System.Collections.Generic;
using iih.ci.ord.opemergency.declare;
using xap.cli.sdk.controls.DataView;

namespace iih.ci.ord.opemergency.ems
{

    /// <summary>
    /// <para>描    述 : 检查医疗单                     </para> 
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
    public partial class EmsRisViewCard : BaseEmsFormView
    {
        #region 变量定义区域

        //protected UserRender detailButton;

        #endregion

        #region 构造函数区域
        public EmsRisViewCard(IEventDelegate owner)
            : base(owner)
        {

            this.srvItemViewType = EmsViewType.EmsRisViewType;
            this.iValidate = new EmsRisValidate();
          
        }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsRisViewCard/*"20170614034643663000"*/);

            this.RegisteFormEventImpl();
            this.GetXapFormControl().EnterKeyDown += EmsRisViewCard_EnterKeyDown;

        }

        void EmsRisViewCard_EnterKeyDown(object sender, KeyEventArgs e)
        {
            XLabelBaseUserRender render = sender as XLabelBaseUserRender;
            if(render==null)return;
            switch (render.UserRender.Name)
            {
                case "card_des_pps":
                    this.SentNotify(EventCodeType.NM_EMS_SAVE_FOCUS);
                    break;
                default:
                    break;
                    
            }
            
        }

      

        protected override void OnXapFormControl_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        #endregion

        #region 父类继承区域

        public override void SetDataPolicy(bool flag)
        {
            this.allowEdit = flag;
            this.GetXapFormControl().SetEditable(flag);

            // 
            //if (detailButton != null) {
               // detailButton.Enabled = true;
           // }
            
        }

        #endregion

        #region 内部事件区域

        protected override void OnXapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            base.OnXapFormControl_DataChanged(sender, e);
            if (this.GetViewModel() == null)
                return;
            this.GetViewModel().OnDataChanged(e.Data, e.PropName, e.Input==null?null:e.Input.ToString());
        }
       

        void OnDetailButton_MouseClick(object sender, MouseEventArgs e)
        {
            if (this.GetViewModel() == null)
                return;

            // 建立套明细对话框
            ApobsSetItemDialog dialog = new ApobsSetItemDialog(this, (this.GetViewModel() as EmsRisViewModel).getEmsOrObsList(), allowEdit, (this.GetViewModel() as EmsRisViewModel).checkRadio())
            {
                Dock = DockStyle.Fill,
                Size = new Size(400, 300)

            };
            dialog.ShowDialog();

        }

        

        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
       {
           base.OnXapFormControl_ModelFilled(sender, e);
            UserRender us = AssXapFormUtils.GetUserRender( this.GetXapFormControl(),"card.dt_plan");

            if (this.GetViewModel() != null)
            {
                EmsRisViewModel tmpModel = this.GetViewModel() as EmsRisViewModel;
                //this.detailButton.Visible = tmpModel.isSet();
            }
            //getControlByName("card", "des_pps").EnterFlag = false;
            //xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_begin = us.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;
            //dt_begin.MinDate = this.GetLogicEx().GetServerDataTime();
            //dt_begin.MaxDate = this.GetLogicEx().GetServerDataTime().AddDays(OrdParam.GetOrdParam.orBeforStartDays);
       }


        protected override void OnXapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
       {
            if (null != this.GetViewModel())
            {
                var sbm = new StringObjectMap();
                e.WherePart = this.GetViewModel().OnRefFilterData(e.BindingFieldName, sbm);
                foreach (KeyValuePair<string, object> item in sbm)
                {
                    e.RefParams.AddParam(item.Key, item.Value);
                }
            }
            else
            {
                e.WherePart = "";
            }

        }

        protected override void OnXapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            base.OnXapFormControl_RefResult(sender, e);
        }

         public override bool OnEventHandle(object sender, DictionaryEventArgs e)
        {
            switch (AssToolEx.EventCodeOfEventArgs(e))
            {
                case EventCodeType.EVENT_EMS_CARDFOCUS:
                    getControlByName("card", "des_pps").UserRender.Focus();
                    break;
                default:
                    break;
            }
            return base.OnEventHandle(sender, e);
        }

        #endregion

        #region 辅助处理函数

        protected XLabelBaseUserRender getControlByName(string tableKey, string name)
        {
            XLabelBaseUserRender tmpUserRender = this.GetXapFormControl().GetUserRender(tableKey, name) as XLabelBaseUserRender;
            return tmpUserRender;
        }
        #endregion

    }
}
