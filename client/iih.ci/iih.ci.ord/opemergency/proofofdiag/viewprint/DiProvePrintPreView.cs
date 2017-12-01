using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using xap.dp.rptview.viewer;
using System.Windows.Forms;
using xap.rui.control.extentions;
using xap.rui.control.forms.view;
using System.Drawing;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/10/21

** 修改人：杨敬本

** 修改时间：2016/10/21

** 描述：诊断证明预览模板

*********************************************************************************/

namespace iih.ci.ord.opemergency.proofofdiag.viewprint
{
    public partial class DiProvePrintPreView : XapCardControl
    {
        private XapFormControl xapFormControl;

        //打印模板视图
        private ReportViewer rpt_viewer;

        private const string FILE_DI = "iih_report/461010_menzhenyishengzhan/dicertify.xml";
        private const string FILE_VA = "iih_report/461010_menzhenyishengzhan/vacertify.xml";

        public string id_ent { get; set; }

        #region 构造函数区域
        public DiProvePrintPreView()
        {
            InitializeComponent();

            //加载模板视图
            this.rpt_viewer = new ReportViewer(DockStyle.Top, ReportViewer.Zoom_FitWidth, true);

            Control panel = this.rpt_viewer.GetViewPanel();
            panel.Dock = DockStyle.Fill;
            this.xapFormControl.Controls.Add(panel);
        }

        private void InitializeComponent()
        {
            this.xapFormControl = new XapFormControl();
            this.SuspendLayout();
            // 
            // xapFormControl
            // 
            this.xapFormControl.Context = null;
            this.xapFormControl.Dock = DockStyle.Fill;
            this.xapFormControl.IsXapGrid = true;
            this.xapFormControl.Location = new Point(0, 0);
            this.xapFormControl.Name = "xapFormControl";
            this.xapFormControl.Size = new Size(150, 150);
            this.xapFormControl.TabIndex = 0;
            // 
            // DiProvePrintPreView
            // 
            //this.AutoScaleDimensions = new SizeF(6F, 12F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.xapFormControl);
            this.Margin = new System.Windows.Forms.Padding(3, 6, 3, 6);
            this.Name = "DiProvePrintPreView";
            this.ResumeLayout(false);
          

            this.ResumeLayout(false);
        }

        #endregion

        private void ToPreview(string strType)
        {
            bool res = false;
            string strFile = "";
            switch (strType)
            {
                case "01":
                    strFile = FILE_DI;//诊断证明报表
                    break;
                case "02":
                    strFile = FILE_VA;//休假证明报表
                    break;
                default:
                    break;
            }

            Dictionary<string, string> qryParams = new Dictionary<string, string>();
            qryParams.Add("$id_ent", id_ent);

            res |= this.rpt_viewer.LoadReport(strFile, qryParams, true);

            if (!res)
            {
                this.ShowInfo(this.rpt_viewer.GetLastMsg());
                return;
            }
            // 生成报表并刷新到界面上
            res = this.rpt_viewer.FillReport();
        }

        #region 状态处理区域
        /// <summary>
        /// 接收响应事件发送
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="eventArgs"></param>
        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case "SelectType":
                    string strType = sender as string;
                    ToPreview(strType);
                    break;
                default:
                    break;
            }
        }
        #endregion

    }
}
