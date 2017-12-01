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
using xap.mw.coreitf.d;

namespace iih.ci.ord.opemergency.trorder
{
    /// <summary>
    /// <para>描    述 :  口腔X线透视检查医疗单视图                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.trorder    </para>    
    /// <para>类 名 称 :  TrOrderRisView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  7/28/2016 3:59:51 PM             </para>
    /// <para>更新时间 :  7/28/2016 3:59:51 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class TrOrderStomatologyUltrasonicView : TrOrderBaseView
    {
        public TrOrderStomatologyUltrasonicView(IEventDelegate owner = null)
            : base(owner)
        {
        }
        protected override BaseEmsView CreateEmsGridView(IEventDelegate owner = null)
        {
            return new EmsRisViewGrid(owner);
        }

        protected override BaseEmsView CreateEmsCardView(IEventDelegate owner = null)
        {
            //this.GetTableViewControl().GetXapFormControl().AllowEditing += TrOrderRisView_AllowEditing;
            return new EmsStomatologyUltrasonicViewCard(owner);
        }

        //void TrOrderRisView_AllowEditing(object sender, xap.rui.control.formcontrol.model.AllowEditingEventArgs e)
        //{
        //    if (e.PropName.Equals("Use_days") || e.PropName.Equals("customercolumn_sale_unit"))
        //    {
        //        // 当频次下次数是一次的时候，检查的使用天数、总量都不能修改
        //        EmsOrDrug ds = e.Object as EmsOrDrug;
        //        e.Cancel = (ds.Freqct != null && ds.Sd_frequnitct == BdSrvDictCodeConst.SD_FREQUNIT_ONCE);
        //    }


        //}

        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            EmsObsItemDO model = this.GetViewModel().GetFormDataSource() as EmsObsItemDO;
            if (model != null && model.Fg_set != FBoolean.True && e.PropName.Equals("customercolumn_details"))
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
                    case "Name_srv":
                        if ((this.GetViewModel().GetEmsUIDTO() as EmsUIDTO) != null && (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).MedSrvDO.Fg_set == true)
                        {
                            result = false;
                        }
                        else
                        {
                            row.ColumnCellDict["Name_pps"].Focus();
                            row.DataTable.ParentControl.ShowEditor();
                        }

                        break;
                    case "Dt_plan":
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
