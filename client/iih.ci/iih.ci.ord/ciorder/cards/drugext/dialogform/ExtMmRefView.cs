using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.viewmodel;
using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.forms.control;
using iih.ci.ord.ciorder.utils;
using xap.rui.appfw;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.forms.model;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.controls.DataView.Model;
using xap.rui.bizcontrol.BillFormTmplConst;
/********************************************************************************

** 作者： 张万青

** 创始时间：

** 修改人：张万青

** 修改时间：2016-6-30

** 描述： 加载物品弹窗框的表单


*********************************************************************************/
namespace iih.ci.ord.ciorder.cards.extend
{
    public partial class ExtMmRefView : XapBaseControl
    {
       
        #region 变量定义区域
        public XapFormControl xapFormControl;
        XLabelBaseUserRender cr;//自备复选框
        XLabel warncard;//红字提示内容
        private MmRefViewModel model;
        XapFormGridControl gridView;
        XapDataList<EmsOrDrug> mms;
        EmsOrDrug emsordrug;
        private LogicEx cof = LogicEx.GetInstance(); // new LogicEx();
        public event EventHandler DoubleClickEvent;
        public event EventHandler<XSelectedRowChangedEventArgs> Event_SelectChanged;
        //自备药控件是否显示
        private bool isDisplaySelfRender = true;

        #endregion

        #region 构造函数区域

        public ExtMmRefView()
        {
            //InitializeComponent();
            this.Load += new EventHandler(MmRefView_Load);
            xapFormControl=new XapFormControl();
            this.Controls.Add(xapFormControl);
            this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
            this.xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            
        }
        void xapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            if (e.PropName == "Fg_self")
            {
                //gridView.DataTable.SelectedRowChanged -= OnGridView_RowSelectChanged;
                if (e.Input != null && e.Input.Equals("true"))
                {
                    warncard.Visible = true;

                    List<XDataRow> selectRows = gridView.GetSelectedRows();//.DataTable.GetSelectedRows();
                    if (selectRows != null)
                    {
                        selectRows.ForEach(p => p.Selected = false);
                    }
                    gridView.Enabled = false;
                    if (Event_SelectChanged != null)
                    {
                        this.setFgSelfValue();
                        XSelectedRowChangedEventArgs rowChanged = new XSelectedRowChangedEventArgs();
                        rowChanged.Data = SelectedDrug;
                        Event_SelectChanged(gridView, rowChanged);
                    }
                }
                else { 
                    warncard.Visible = false;
                    gridView.Enabled = true;
                    XDataRow row = gridView.DataTable.GetFirstRow();
                    if (row != null) {
                        row.Selected = true;
                        row.Focus();
                        if (Event_SelectChanged != null && SelectedDrug != null)
                        {
                            cr.Checked = false;
                            this.setFgSelfValue();
                            XSelectedRowChangedEventArgs rowChanged = new XSelectedRowChangedEventArgs();
                            rowChanged.Data = SelectedDrug;
                            Event_SelectChanged(gridView, rowChanged);
                        }
                    }
                }
                //gridView.DataTable.SelectedRowChanged += OnGridView_RowSelectChanged;
            }
            //this.xapFormControl.Refresh();
        }
        void xapFormControl_DataDisplay(object sender, xap.cli.sdk.controls.DataView.Model.XDataDisplayEventArgs e)
        {
            var row = sender as XDataRow;
            var drug = e.Object as EmsOrDrug;
            if (drug.Fact_count == 0) {
                row.TextColor = Color.Red;
            }
            // 更新用户自定义列信息
            this.updateCustomerControlInfo(row, drug);
        }

        private void updateCustomerControlInfo(XDataRow row, EmsOrDrug drug)
        {
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_stock"))
            {

                if (drug.Fact_count == null)
                    drug.Fact_count = 0;
                if (drug.Name_unit_sale == null)
                    drug.Name_unit_sale = "";
                string strMed_unit = drug.Fact_count + drug.Name_unit_sale;
                row.ColumnCellDict["customercolumn_stock"].SetValue(strMed_unit);
            }
        }
        public ExtMmRefView(XapDataList<EmsOrDrug> list): this()
        {
            this.mms = list;
        }
        public ExtMmRefView(XapDataList<EmsOrDrug> list,EmsOrDrug emsordrug,bool isDisplaySelfRender = true):this()
        {
            this.mms = list;
            this.emsordrug = emsordrug;
            this.isDisplaySelfRender = isDisplaySelfRender;
        }

        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            gridView = this.xapFormControl.GetGridView("mm");
            this.Size = new Size(475, 450);
            gridView.DoubleClick += new EventHandler(gridView_DoubleClick);
            //gridView.DataTable.SelectedRowChanged += OnGridView_RowSelectChanged;
            
           // gridView.DataTable.GotFocus += new EventHandler(gridView_GotFocus);
            this.xapFormControl.Dock = DockStyle.Fill;
            this.xapFormControl.SetEditPolicy(true);
            cr = this.xapFormControl.GetUserRender("card", "fg_self") as XLabelBaseUserRender;
            cr.Visible = this.isDisplaySelfRender;
            warncard = this.xapFormControl.GetUserRender("card", "warn") as XLabel;
            warncard.ForeColor = Color.Red;
            gridView.ReadOnly = true;
            this.xapFormControl.DataDisplay += new EventHandler<xap.cli.sdk.controls.DataView.Model.XDataDisplayEventArgs>(xapFormControl_DataDisplay);
        }

        //protected void OnGridView_RowSelectChanged(Object sender, XSelectedRowChangedEventArgs e)
        //{
        //    if (null != Event_SelectChanged)
        //    {
        //        this.setFgSelfValue();
        //        this.Event_SelectChanged(sender, e);
        //    }
        //}
        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            if (this.emsordrug.Fg_self == true)
            {
                cr.Checked = true;
                gridView.Enabled = false;
            }
            else {
                cr.Checked = false;
                gridView.Enabled = true;
                warncard.Visible = false;
               
                //设置表格选中行
                EmsOrDrug focusDrug = this.mms.FirstOrDefault(p => p.Id_mm == this.emsordrug.Id_mm);
                if (focusDrug != null)
                {
                    XDataRow row = gridView.DataTable.GetRow(focusDrug);
                    row.Selected = true;
                    row.Focus();
                } 
            }
            this.xapFormControl.DataChanged -= new EventHandler<DataChangedEventArgs>(xapFormControl_DataChanged);
            this.xapFormControl.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl_DataChanged);
        }
        void gridView_DoubleClick(object sender, EventArgs e)
        {
            if (this.xapFormControl.GetSelected<EmsOrDrug>().Length == 0)
                return;
            if (this.DoubleClickEvent != null)
            {
                cr.Checked = false;
                DoubleClickEvent(SelectedDrug, e);
            }
            if (Event_SelectChanged != null&&SelectedDrug!=null)
            {
                cr.Checked = false;
                this.setFgSelfValue();
                XSelectedRowChangedEventArgs rowChanged =  new XSelectedRowChangedEventArgs();
                rowChanged.Data = SelectedDrug;
                Event_SelectChanged(gridView, rowChanged);
            }
        }

        #endregion

        #region 公开属性区域

        public EmsOrDrug SelectedDrug
        {
            get
            {
                if (xapFormControl == null)
                    return null;

                return xapFormControl.GetSelected<EmsOrDrug>().FirstOrDefault();
            }
        }

        #endregion



        #region 父类继承区域
        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            this.model=new MmRefViewModel();
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_ExtMmRefView;// "20160523104254305NIW";
            file.ViewModel =  this.mms ;// this.model.mms;
            file.FormStyle = FormStyle.Card;
            this.xapFormControl.ViewFile = file;

        }



        #endregion

        #region 内部事件区域

        void MmRefView_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        #endregion

        #region 辅助处理函数
        public void setFgSelfValue() {
           
            this.emsordrug.Fg_self = cr.Checked;
           
        }
        #endregion

        #region 状态处理区域

       

        #endregion
    }
}
