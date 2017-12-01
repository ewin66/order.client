using System.Windows.Forms;
using iih.bd.bc.udi;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.ems;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view.basic;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using iih.ci.ord.opemergency.tool;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.appfw;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.declare;
using xap.cli.sdk.controls.DataView;
using xap.mw.coreitf.d;
using xap.rui.control.formcontrol.model;
using System;
using iih.bd.srv.medsrv.d;

namespace iih.ci.ord.opemergency.trorder
{
    /// <summary>
    /// <para>描    述 :  检验医疗单视图                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.trorder    </para>    
    /// <para>类 名 称 :  TrOrderLisView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  7/28/2016 4:09:49 PM             </para>
    /// <para>更新时间 :  7/28/2016 4:09:49 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class TrOrderLisView : TrOrderBaseView
    {
        public TrOrderLisView(IEventDelegate owner = null)
            : base(owner)
        {
        }

        protected override BaseEmsView CreateEmsGridView(IEventDelegate owner = null)
        {
            return new EmsLisViewGrid(owner);
        }

        protected override BaseEmsView CreateEmsCardView(IEventDelegate owner = null)
        {
            
            return new EmsLisViewCard(owner);
        }
        public override bool OnChildNotify(object sender, DictionaryEventArgs e)
        {
            if (AssToolEx.EventCodeOfEventArgs(e).Equals(EventCodeType.NM_EMS_ORSRV_DATACHANGED))
            {
                var tableDataSource = this.GetTableViewControl().GetViewModel().GetTableDataSource() as XapDataList<EmsOrDrug>;
                if (null != tableDataSource)
                {
                    (this.GetViewModel() as EmsLisViewModel).ReCalcPriceInfo(tableDataSource[0]);
                }
            }
            return base.OnChildNotify(sender, e);
        }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();
            //enter键调整光标位置
            this.GetTableViewControl().GetXapFormControl().EnterKeyDown += TrOrderDrugsView_EnterKeyDown;
        }

        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            EmsObsItemDO model = this.GetViewModel().GetFormDataSource() as EmsObsItemDO;
            var ds = e.Object as EmsOrDrug;
            if (e.PropName.Equals("Price"))
            {
                e.Cancel = !(ds.Eu_blmd == Convert.ToInt32(MedSrvBlModeEnum.MANUALBL));
            }
            else if (model != null && model.Fg_set != FBoolean.True && e.PropName.Equals("customercolumn_details"))
            {
                e.Cancel = true;
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
                    case "Name_srv":
                        if ((this.GetViewModel().GetEmsUIDTO() as EmsUIDTO) != null && (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).MedSrvDO.Fg_set == true)
                        {
                            result = false;
                        }
                        else
                        {
                            row.ColumnCellDict["Name_samptp"].Focus();
                            row.DataTable.ParentControl.ShowEditor();
                        }

                        break;
                    case "Name_sampcoltime":
                        row.ColumnCellDict["Name_mp_dep"].Focus();
                        row.DataTable.ParentControl.ShowEditor();
                        break;
                    case "Name_mp_dep":
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
