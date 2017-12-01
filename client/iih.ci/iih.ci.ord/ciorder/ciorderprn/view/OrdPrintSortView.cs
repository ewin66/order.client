using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.form;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.ci.ord.ciorder.ciorderprn.viewmodel;
using xap.rui.control.forms.control;
using xap.cli.sdk.controls.tabControl;
using xap.mw.coreitf.d;
using xap.rui.control.forms.model;
using iih.ci.ord.ordprn.d;
using xap.cli.sdk.render;
using xap.rui.control.commands;
using xap.rui.bizcontrol.BillFormTmplConst;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/9/13

** 修改人：杨敬本

** 修改时间：2016/9/14

** 描述：医嘱单打印数据排序面板

*********************************************************************************/

namespace iih.ci.ord.ciorder.ciorderprn.view
{
    public partial class OrdPrintSortView : XDialog
    {
        #region 变量定义区域
        private OrdPrintViewModel viewModel;
        private FBoolean bLong;

        protected XapFormControl xapFormControl1 = new XapFormControl();
        private XTabPage tabPageLong;
        private XTabPage tabPageTemp;
        private XapFormGridControl gridOrdsLong;
        private XapFormGridControl gridOrdsTemp;
        private UserRender btnOK;
        private UserRender btnCancel;
        #endregion

        #region 构造函数区域
        public OrdPrintSortView()
        {
            InitializeComponent();

            this.Load += new EventHandler(OrdPrintSortView_Load);
        }

        public OrdPrintSortView(OrdPrintViewModel viewModel, FBoolean bLong)
            : this()
        {
            this.viewModel = viewModel;
            this.bLong = bLong;
        }
        #endregion

        #region 内部事件区域
        private void OrdPrintSortView_Load(object sender, EventArgs e)
        {
            this.xapFormControl1.Dock = DockStyle.Fill;
            this.xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            this.xapFormControl1.SetToilHeight(30);
            this.Panel = this.xapFormControl1;

            this.onLoad();
        }

        private void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            tabPageLong = xapFormControl1.GetTabPageByTabCode("ordsortlong");
            tabPageTemp = xapFormControl1.GetTabPageByTabCode("ordsorttemp");

            tabPageLong.Visible = bLong.ToTarget;
            tabPageTemp.Visible = !bLong.ToTarget;

            gridOrdsLong = xapFormControl1.GetGridView("ordsortlong"); 
            gridOrdsTemp = xapFormControl1.GetGridView("ordsorttemp");

            gridOrdsLong.ReadOnly = true;
            gridOrdsTemp.ReadOnly = true;

            btnOK = xapFormControl1.GetUserRender("ordsortctl", "btnOK");
            btnCancel = xapFormControl1.GetUserRender("ordsortctl", "btnCancel");

            btnOK.MouseClick += new MouseEventHandler(btnOK_MouseClick);
            btnCancel.MouseClick += new MouseEventHandler(btnCancel_MouseClick);
        }

        private void btnOK_MouseClick(object sender, MouseEventArgs e)
        {
            this.DialogResult = DialogResult.OK;
        }

        private void btnCancel_MouseClick(object sender, MouseEventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
        }
        #endregion

        #region 私有事件区域
        /// <summary>
        /// 加载数据
        /// </summary>
        private void onLoad()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrdPrintSortView;// "20160908090340385000";
            file.FormStyle = FormStyle.List;

            file.ViewModel = this.viewModel.LstOrdPrintDOsPreview;
            this.xapFormControl1.ViewFile = file;
            this.SetGridPolicy(true);
        }

        /// <summary>
        /// 设置表单编辑属性
        /// </summary>
        /// <param name="flag"></param>
        private void SetGridPolicy(bool flag)
        {
            DataPolicy dpItm = new DataPolicy
            {
                ClassName = typeof(OrdPrintDO).FullName,
                AllowNew = false,
                AllowCancel = false,
                AllowEdit = flag,
                AllowFilter = false,
                AllowRemove = false,
                AllowSave = false,
                AllowSearch = false,
                FullEdit = flag,
                InlineEdit = flag,
                MultiSelect = false,
                AutoNewRow = false,
                HideOther = false,
            };
            this.xapFormControl1.SetEditPolicy(flag, new[] { dpItm });

            if (this.gridOrdsLong != null)
                this.gridOrdsLong.ReadOnly = true;
            if (this.gridOrdsTemp != null)
                this.gridOrdsTemp.ReadOnly = true;
        }
        #endregion
    }
}
