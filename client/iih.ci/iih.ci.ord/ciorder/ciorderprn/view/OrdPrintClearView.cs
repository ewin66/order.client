
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.cli.sdk.form;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.cli.sdk.render;
using System.Windows.Forms;
using iih.ci.ord.ordprn.d;
using xap.cli.sdk.render.Items;
using System.Drawing;
using xap.rui.bizcontrol.BillFormTmplConst;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/9/13

** 修改人：杨敬本

** 修改时间：2016/9/14

** 描述：医嘱单打印数据清空面板

*********************************************************************************/

namespace iih.ci.ord.ciorder.ciorderprn.view
{
    public partial class OrdPrintClearView : XDialog
    {
        #region 变量定义区域
        protected XapFormControl xapFormControl1 = new XapFormControl();
        private UserRender userRenderPage;//页号下拉框
        private XLabel labText;
        private UserRender btnOK;
        private UserRender btnCancel;

        private OrdPrintDO dataSource = new OrdPrintDO();
        #endregion

        #region 构造函数区域
        public OrdPrintClearView()
        {
            InitializeComponent();

            this.Load += new EventHandler(OrdPrintClearView_Load);
        }

        public OrdPrintClearView(string id_en, bool? isLong)
            : this()
        {
            this.dataSource.Id_en = id_en;
            this.dataSource.Fg_long = isLong;
        }
        #endregion

        public int? GetPageNum()
        {
            return this.dataSource.Page_num;
        }

        #region 内部事件区域
        private void OrdPrintClearView_Load(object sender, EventArgs e)
        {
            xapFormControl1.Dock = DockStyle.Fill;
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            xapFormControl1.RefFilter += new EventHandler<xap.rui.control.refcontrol.events.RefActivatingEventArgs>(xapFormControl1_RefFilter);
            xapFormControl1.RefResult += new EventHandler<xap.rui.control.refcontrol.events.RefResultEventArgs>(xapFormControl1_RefResult);
            xapFormControl1.SetToilHeight(30);
            this.Panel = xapFormControl1;

            this.onLoad();
        }

        private void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            userRenderPage = xapFormControl1.GetUserRender("page", "page_num");
            userRenderPage.Enabled = true;

            labText = xapFormControl1.GetUserRender("page", "labInfo") as XLabel;
            labText.ForeColor = Color.FromArgb(255, 0, 0);
            labText.Enabled = true;
            labText.ValueText = "";

            btnOK = xapFormControl1.GetUserRender("page", "btnOK");
            btnOK.Enabled = true;
            btnCancel = xapFormControl1.GetUserRender("page", "btnCancel");
            btnCancel.Enabled = true;

            btnOK.MouseClick += new MouseEventHandler(btnOK_MouseClick);
            btnCancel.MouseClick += new MouseEventHandler(btnCancel_MouseClick);
        }

        /// <summary>
        /// 页码参照条件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl1_RefFilter(object sender, xap.rui.control.refcontrol.events.RefActivatingEventArgs e)
        {
            if (e.BindingFieldName == "Page_num")
            {
                //根据患者就诊信息获取页码
                e.WherePart = String.Format(" id_en='{0}' and fg_long='{1}'", this.dataSource.Id_en,
                    (this.dataSource.Fg_long == null || this.dataSource.Fg_long == true) ? 'Y' : 'N');
            } 
        }

        /// <summary>
        /// 页码参照结果
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl1_RefResult(object sender, xap.rui.control.refcontrol.events.RefResultEventArgs e)
        {
            if (e.RefResultSet.FirstData != null)
            {
                labText.ValueText = "确定清空此页之后的数据吗？(包含此页)";
            }
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
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrdPrintClearView;// "20160919084321447000";
            file.FormStyle = FormStyle.List;

            file.ViewModel = this.dataSource;
            this.xapFormControl1.ViewFile = file;
        }
        #endregion

    }
}
