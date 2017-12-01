using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.cirptpathgy.d;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.model;
using xap.rui.control.engine.attributes;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.refcontrol.events;
using xap.rui.engine;
using iih.ci.ord.pathgyreportform.viewmodel;
using xap.cli.sdk.render.labelcontrol;
using xap.cli.sdk.form;
using xap.cli.sdk.render.Items;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.pathgyreportform.view
{
    /// <summary>
    /// 可供住院和门诊病理检查报告弹出窗使用
    /// </summary>
    public partial class OpRptpathgyView : XBaseDialog
    {
        #region 变量定义区域
        private OpRptpathgyViewModel model;
        private string id_or;
        #endregion

        #region 构造函数区域

        public OpRptpathgyView(string id_or)
        {
            this.id_or = id_or;
            InitializeComponent();
            this.Load += new EventHandler(CiCheckCardView_Load);
            this.xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            this.Panel = this.xapFormControl1;
        }

        #endregion

        #region 父类继承区域
        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            if (this.model == null)
                return;

            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OpRptpathgyView;// "20161228074222280000";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = this.model.getCiDO();
            this.xapFormControl1.ViewFile = file;
        }
        /// <summary>
        /// 加载事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void CiCheckCardView_Load(object sender, EventArgs e)
        {
            this.model = new OpRptpathgyViewModel(this.id_or);
            //this.SetEditable(false);
        }
        #endregion

        #region 辅助处理区域
        private void SetEditable(bool editable)
        {
            DataPolicy dpMain = new DataPolicy()
            {
                ClassName = typeof(CiRptPathgyDO).ToString(),
                InlineEdit = true,
                FullEdit = editable,
                AllowEdit = editable
            };
            this.xapFormControl1.SetEditPolicy(editable, new DataPolicy[1] { dpMain });
        }
        #endregion

        #region 内部事件
        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            CiRptPathgyDO ciDO = this.model.getCiDO();
            if (ciDO == null) return;
            XLabel srvName = xapFormControl1.GetUserRender("applyform", "srv_name") as XLabel;
            XLabel applyNoValue = xapFormControl1.GetUserRender("applyform", "apply_no_value") as XLabel;
            XLabel reportDateValue = xapFormControl1.GetUserRender("applyform", "report_date_value") as XLabel;
            XLabel reportStatusValue = xapFormControl1.GetUserRender("applyform", "report_status_value") as XLabel;
            if (srvName != null) {
                srvName.ValueText = ciDO.Name_or;
                applyNoValue.ValueText = ciDO.No_applyform;
                reportDateValue.ValueText = ciDO.Dt_rptpathgy==null?"":ciDO.Dt_rptpathgy.ToString();
                reportStatusValue.ValueText = ciDO.Su_name;
            }
        }
        #endregion

    }
}
