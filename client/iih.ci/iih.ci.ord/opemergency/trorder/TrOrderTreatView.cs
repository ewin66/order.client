using System.Windows.Forms;
using iih.bd.bc.udi;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.opemergency.ems;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view.basic;
using xap.cli.sdk.controls.DataView;
using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using iih.bd.srv.medsrv.d;
using System;

namespace iih.ci.ord.opemergency.trorder
{
    /// <summary>
    /// <para>描    述 :  治疗医疗单视图                   	</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.trorder    </para>    
    /// <para>类 名 称 :  TrOrderTreatView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  7/28/2016 4:12:04 PM             </para>
    /// <para>更新时间 :  7/28/2016 4:12:04 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class TrOrderTreatView : TrOrderBaseView
    {
        public TrOrderTreatView(IEventDelegate owner = null)
            : base(owner)
        {
        }

        protected override BaseEmsView CreateEmsGridView(IEventDelegate owner = null)
        {
            return new EmsTreatViewGrid(owner);
        }

        protected override BaseEmsView CreateEmsCardView(IEventDelegate owner = null)
        {
            
            return new EmsTreatViewCard(owner);
        }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();
            //enter键调整光标位置
            this.GetTableViewControl().GetXapFormControl().EnterKeyDown += TrOrderDrugsView_EnterKeyDown;
        }

        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {

            var ds = e.Object as EmsOrDrug;
            if (e.PropName.Equals("Price") )
            {
                e.Cancel = !(ds.Eu_blmd == Convert.ToInt32(MedSrvBlModeEnum.MANUALBL));
            }
           else if (e.PropName.Equals("Name_srv") && null != this.GetViewModel() && !System.String.IsNullOrEmpty(GetViewModel().getCiEmsDTO().Id_or))
            {
                e.Cancel = true;
            }
            else
            {
                base.OnXapFormControl_AllowEditing(sender, e);
            }
        }

        void TrOrderDrugsView_EnterKeyDown(object sender, KeyEventArgs e)
        {
            XDataRow row = sender as XDataRow;
            bool result = true;
            if (row != null && row.DataTable.ParentControl.FocusedCell != null)
            {
                switch (row.DataTable.ParentControl.FocusedCell.FieldName)
                {
                    case "customercolumn_med_unit":
                        row.ColumnCellDict["Name_mp_dep"].Focus();
                        row.DataTable.ParentControl.ShowEditor();
                        break;
                    case "Name_mp_dep":
                        if (row.RowData["Name_srv"] == null)
                        {
                            row.ColumnCellDict["Name_srv"].Focus();
                            row.DataTable.ParentControl.ShowEditor();
                        }
                        else
                        {
                            var ds = row.DataSource as EmsOrDrug;
                            if (ds.Eu_blmd == Convert.ToInt32(MedSrvBlModeEnum.MANUALBL))
                            {
                                row.ColumnCellDict["Price"].Focus();
                                row.DataTable.ParentControl.ShowEditor();
                            }
                            else
                            {
                            if (row.IsLast)
                            {

                                this.SentNotify(EventCodeType.NM_EMS_SAVE_FOCUS);
                            }
                        }
                            
                        }
                        break;
                    case "Price":
                        if (row.IsLast)
                        {

                            this.SentNotify(EventCodeType.NM_EMS_SAVE_FOCUS);
                        }
                        break;
                    default:
                        result = false;
                        break;
                }
            }

            e.Handled = result;
        }
    }
}
