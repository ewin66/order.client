
using System.Windows.Forms;
using iih.ci.ord.opemergency.ems;
using iih.ci.ord.opemergency.ems.common;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using iih.ci.ord.opemergency.trorder;
using iih.ci.ord.opemergency.tool;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.view.basic;
using iih.ci.ord.opemergency.view;
using iih.ci.ord.opemergency.declare;
using xap.cli.sdk.controls.DataView;
using xap.rui.control.formcontrol.model;
using iih.ci.ord.ciordems.d;
using System;
using iih.bd.srv.medsrv.d;

namespace iih.ci.ord.opemergency.troeder
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.medicalbills    </para>    
    /// <para>类 名 称 :  Component1					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/5 9:25:51             </para>
    /// <para>更新时间 :  2016/7/5 9:25:51             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class TrOrderDrugsView : TrOrderBaseView
    {

        public TrOrderDrugsView(IEventDelegate owner = null)
            : base(owner)
        {
        }

        protected override BaseEmsView CreateEmsGridView(IEventDelegate owner = null)
        {
            return new EmsDrugsViewGrid(owner);
        }

        protected override BaseEmsView CreateEmsCardView(IEventDelegate owner = null)
        {
            return new EmsDrugsViewCard(owner);
        }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();
            //enter键调整光标位置
            this.GetTableViewControl().GetXapFormControl().EnterKeyDown += TrOrderDrugsView_EnterKeyDown;
        }

        void TrOrderDrugsView_EnterKeyDown(object sender, KeyEventArgs e)
        {
            XDataRow row = sender as XDataRow;
            bool result = true;
            if (row != null && row.DataTable.ParentControl.FocusedCell != null)
            {
                switch (row.DataTable.ParentControl.FocusedCell.FieldName)
                {
                    //case "Name_srv":
                    //    row.ColumnCellDict["customercolumn_med_unit"].Focus();
                    //    row.DataTable.ParentControl.ShowEditor();
                    //    break;
                    case "Name_dep_wh":
                        if (row.RowData["Name_srv"] == null)
                        {
                            row.ColumnCellDict["Name_srv"].Focus();
                            row.DataTable.ParentControl.ShowEditor();
                        }
                        else
                        {
                            if (row.IsLast)
                            {
                                
                                this.SentNotify(EventCodeType.NM_EMS_SAVE_FOCUS);
                            }
                        }
                        break;
                    default:
                        result = false;
                        break;
                }
            }

            e.Handled = result;
        }

        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            var ds = e.Object as EmsOrDrug;
            if (e.PropName.Equals("Price"))
            {
                e.Cancel = !(ds.Eu_blmd == Convert.ToInt32(MedSrvBlModeEnum.MANUALBL));
            }
            else
            {
                base.OnXapFormControl_AllowEditing(sender, e);
            }
      
        }

        public override bool OnChildNotify(object sender, DictionaryEventArgs e)
        {
            // 药品选项卡需要处理表格中发出的通知消息事件
            if (EventCodeType.NM_EMS_ORSRV_SELECTCHANGED == AssToolEx.EventCodeOfEventArgs(e))
            {
                if (null != this.GetCardViewControl())
                {
                    return GetCardViewControl().OnEventHandle(sender, e);
                }
            }
            else if (EventCodeType.NM_EMS_ORSRV_DATACHANGED == AssToolEx.EventCodeOfEventArgs(e)) {
               GetCardViewControl().OnEventHandle(sender, e);
            }
            // 该消息继续广播
            return base.OnChildNotify(sender, e);
        }

       

    }
}
