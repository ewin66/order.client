using System;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.newconfirm.view.baseview;
using iih.ci.ord.newconfirm.viewmodel.bp;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.controls.DataView.Model;
using xap.mw.coreitf.d;
using xap.rui.control.basecontrol;
using xap.rui.control.engine.attributes;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.bizcontrol.BillFormTmplConst;

/*
********************************************************************************

** 作者： 李程

** 创始时间：2016-6-30

** 修改人：李程

** 修改时间：2016-6-30

** 描述： 医嘱确认显示页面


*********************************************************************************
*/

namespace iih.ci.ord.ciorder.view
{
    public partial class OrderConfirmView : CiorderBaseControl
    {
        #region 变量定义区域

        private readonly string gvor = "ordlist";
        private readonly XapFormControl xapFormControl;
        private bool addfeeflag=false;
        private XapFormGridControl gv_or;
        private OrderConfirmViewModel model;
        private XDataRow oldrow;
        private FeeInpputBaseView feeview;

        #endregion

        #region 构造函数区域

        public OrderConfirmView()
        {
            InitializeComponent();
            xapFormControl = new XapFormControl {Dock = DockStyle.Fill};
            Controls.Add(xapFormControl);
            Load += OrderConfirmView_Load;
            xapFormControl.FormCreated += xapFormControl_FormCreated;
            xapFormControl.ModelFilled += xapFormControl_ModelFilled;
            xapFormControl.IsShowWarnForm = false;
            
            
        }

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令区域

        [XapCommand(Name = "Ordfirm")]
        public void OnConfirm()
        {
        }

        [XapCommand(Name = "Srvfirm")]
        public void OnaddSrv()
        {
           
        }

        [XapCommand(Name = "Cancel")]
        public void OnCancel()
        {
            if (feeview != null)
            {
                if (feeview.IsCancel())
                {
                    if (!this.IsContinue("提示", "费用页签有修改,是否继续？"))
                    {
                        return;
                    }

                }
            }
            addfeeflag = false;
            if (oldrow != null && oldrow.ColumnCellDict.ContainsKey("customercolumn_addfeecell"))
            {
                oldrow.UserForeColor = Color.Black;
                (oldrow.ColumnCellDict["customercolumn_addfeecell"] as XCellRender).Value = "";
            }
            this.FireSelected(OrderConfirmUtils.GetConfirmEvent("uneditable"));
            if (feeview != null)
            {
                feeview.CancelFee();
            }

        }
        [XapCommand(Name = "Refresh")]
        public void OnRefresh()
        {
          //  reFreshData();
        }

        #endregion

        #region 父类继承区域

        /// <summary>
        ///     获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            model = new OrderConfirmViewModel(Context.Org.Id_org, xapFormControl);
        }

        /// <summary>
        ///     CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            var f = new FormFile();
            //20160815012934772L07
            f.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderConfirmView;// "20161026093054112000";
            f.FormStyle = FormStyle.Card;
            f.ViewModel = model.OrderList;
            xapFormControl.ViewFile = f;
            xapFormControl.SetEditPolicy(true);
            oldrow = null;
        }


        public override void OnSelected(object sender, TargetEventArgs e)
        {
            var dto = e.Object as OrConfirm;
            if (dto != null)
            {

                if (dto.Id_confirm != null)
                    return;
                model.dto = dto;
                reFreshData();
            }
            else
            {
                var tmp = e.Object as FeeInpputBaseView;
                if (tmp != null)
                {
                    feeview = tmp;
                }
            }

        }

        public override bool CanClose()
        {
            return true;
        }

        public override void OnStatus()
        {//Refresh
            if (gv_or != null && (gv_or.SelectedRowsCount != 0||this.gv_or.DataTable.FocusedRow!=null))
            {
                if (gv_or.SelectedRowsCount != 0)
                {
                    SetEnable("Ordfirm", true);
                }
                else
                {
                    SetEnable("Ordfirm", false);
                }
                //SetEnable("Cancel", addfeeflag);
                //SetEnable("Refresh", !addfeeflag);
                if (this.gv_or.DataTable.FocusedRow != null)
                {
                    SetEnable("Srvfirm", true);
                }
                else
                {
                    SetEnable("Srvfirm", false);
                }
                SetEnable("Cancel", addfeeflag);
                SetEnable("Refresh", true);

            }
            else
            {
                SetEnable("Ordfirm", false);
                SetEnable("Srvfirm", false);
                SetEnable("Cancel", false);
                SetEnable("Refresh", true);
            }
        }

        #endregion

        #region 内部事件区域

        private void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            if (model.OrderList.Count() == 0)
            {
                // this.SetStatusMsg("没有查询到数据");   -- 周总 提的 Bug 去掉状态栏的提示，没有查到数据界面已经很明显了，所以不需要提示 -- add by wqz
            }
        }


        private void OrderConfirmView_Load(object sender, EventArgs e)
        {
            OnInit();
     //       this.SetText("Cancel", "返回确认");
        }

        private void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            gv_or = xapFormControl.GetGridView(gvor);
            gv_or.DataTable.DataDisplay += tabControl_DataDisplay;
            gv_or.DataTable.SelectedAllChanged += test;
           
            gv_or.DataTable.Rows.DefaultHeight = 36;
        }

        private void test(Object sender, EventArgs eventArgs)
        {
            //if (oldrow != null)
            //{
            //    oldrow.BackColor = Color.Empty;
            //    oldrow.UserForeColor = Color.Black;
            //    OrderConfirmUtils.SetDoctorCardColor(oldrow, Color.Black);
            //    oldrow = null;
            //}
            //this.FireSelected(OrderConfirmUtils.GetConfirmEvent("uneditable"));
        }

        private void tabControl_DataDisplay(Object sender, XDataDisplayEventArgs e)
        {
            var row = sender as XDataRow;
            OrderConfirmUtils.OrContentDisplay(row);

            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_addfeecell"))
            {
                (row.ColumnCellDict["customercolumn_addfeecell"] as XCellRender).Value = "";
            }
        }




        #endregion


        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            var uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            switch (uiEvent)
            {
                case "Ordfirm":
                    if (feeview != null)
                    {
                        if (feeview.IsCancel())
                        {
                            if (!this.IsContinue("提示", "费用页签有修改,是否继续？"))
                            {
                                return;
                            }

                        }
                    }
                    model.orderConfirm();
                    OnFillData();
                    addfeeflag = false;
                    if (feeview != null)
                    {
                       feeview.CancelFee();
                    }
                    break;
                case "Srvfirm":
                    addfee();
                    
                    break;
                case UIEvent.REFRESH:
                    reFreshData();
                    break;
                case UIEvent.CANCEL:
                    OnCancel();
                    break;
            }
        }

        #endregion

        #region 辅助处理函数

        private void reFreshData()
        {
            addfeeflag = false;
            if (model.dto != null)
            {
                if (model == null)
                    model = new OrderConfirmViewModel(Context.Org.Id_org, xapFormControl);
                if (model.dto.Fg_sign != FBoolean.False || model.dto.Fg_stop != FBoolean.False ||
                    model.dto.Fg_canc != FBoolean.False)
                {
                    model.GetOrConfirmList(model.dto);
                }
                else
                {
                    model.OrderList.Clear();
                }
                OnFillData();
            }
        }

        private void addfee()
        {
            if (feeview != null)
            {
                if (feeview.IsCancel())
                {
                    if (!this.IsContinue("提示", "费用页签有修改,是否继续？"))
                    {
                        return;
                    }

                }
            }

            //    XDataRow xor = gv_or.DataTable.SelectedRows[gv_or.SelectedRowsCount - 1];
            XDataRow xor = this.gv_or.DataTable.FocusedRow;
            if (xor == null) return;
            var or = xor.RowDataSource as OrConfirm;
            if (or == null)
                return;
            or.Id_dep_nur = this.model.dto.Id_dep_nur;
            if(oldrow!=null){
            var confirm = oldrow.RowDataSource as OrConfirm;
            if (confirm != null)
            {
                if (confirm.Id_confirm == or.Id_confirm && addfeeflag) return;
            }
            }
            //              this.freq =this.model.GetDefDo(this.or.Id_freq);
            if (or.Fg_sign == FBoolean.True && or.Fg_chk == FBoolean.False) //已签署  展开
            {
                if (gv_or.DataTable.Rows.DataSourceRow.ContainsKey(or))
                {
                    gv_or.DataTable.Rows[model.OrderList.IndexOf(or)].Selected = true;
                }
                XDataRow doubleClickRow = gv_or.DataTable.Rows.DataSourceRow[or];

                if (oldrow != null)
                {
                    oldrow.BackColor = Color.Empty;
                    oldrow.UserForeColor = Color.Black;
                    OrderConfirmUtils.SetDoctorCardColor(oldrow, Color.Black);
                    if (oldrow != null && oldrow.ColumnCellDict.ContainsKey("customercolumn_addfeecell"))
                    {
                        (oldrow.ColumnCellDict["customercolumn_addfeecell"] as XCellRender).Value = "";
                    }

                    //doubleClickRow.UserForeColor = Color.FromArgb(76, 76, 76);
                    doubleClickRow.UserForeColor = Color.Red;
                    OrderConfirmUtils.SetDoctorCardColor(doubleClickRow, Color.Red);
                    if (doubleClickRow != null && doubleClickRow.ColumnCellDict.ContainsKey("customercolumn_addfeecell"))
                    {
                        (doubleClickRow.ColumnCellDict["customercolumn_addfeecell"] as XCellRender).Value = "补费中";


                    }
                    oldrow = doubleClickRow;
                }
                else
                {
                  //  doubleClickRow.UserForeColor = Color.FromArgb(76, 76, 76);
                    doubleClickRow.UserForeColor = Color.Red;
                    OrderConfirmUtils.SetDoctorCardColor(doubleClickRow, Color.Red);
                    if (doubleClickRow != null && doubleClickRow.ColumnCellDict.ContainsKey("customercolumn_addfeecell"))
                    {
                        (doubleClickRow.ColumnCellDict["customercolumn_addfeecell"] as XCellRender).Value = "补费中";
                    }
                    oldrow = doubleClickRow;
                }

                FireSelected(or);
                this.FireSelected(OrderConfirmUtils.GetConfirmEvent("addfee"));
                addfeeflag = true;
            }
            else
            {
                
                //if (gv_or.DataTable.Rows.DataSourceRow.ContainsKey(or))
                //{
                //    gv_or.DataTable.Rows[model.OrderList.IndexOf(or)].Selected = true;
                //}
                this.ShowAlert("非签署医嘱不能补费");

                //if (oldrow != null)
                //{
                //    oldrow.BackColor = Color.Empty;
                //    oldrow.UserForeColor = Color.Black;
                //    OrderConfirmUtils.SetDoctorCardColor(oldrow, Color.Black);
                //}
            }
        }

        #endregion


        //private void xapFormControl_AfterFocused(object sender, DataFocusedEventArgs e)
        //{
        //    var oc = e.Data as OrConfirm;
        //    if (oc == null)
        //        return;
        //    oc.Id_dep_nur = this.model.dto.Id_dep_nur;
        //    oc.Id_dep_phy = this.model.dto.Id_dep_phy;
        //    if (oldrow != null)
        //    {
        //        var confirm = oldrow.RowDataSource as OrConfirm;
        //        if (confirm.Id_confirm != oc.Id_confirm)
        //        {
        //            oldrow.BackColor = Color.Empty;
        //            oldrow.UserForeColor = Color.Black;
        //            OrderConfirmUtils.SetDoctorCardColor(oldrow, Color.Black);
        //            oldrow = null;
        //            FireSelected(oc);
        //            this.FireSelected(OrderConfirmUtils.GetConfirmEvent("uneditable"));
        //        }

        //    }
        //    else
        //    {
        //        FireSelected(oc);
        //    }
        //}
    }
}