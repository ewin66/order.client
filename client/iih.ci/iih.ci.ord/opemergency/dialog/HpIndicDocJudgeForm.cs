using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.form;
using iih.ci.ord.ciorder.orreport.scrollpanel.view;
using xap.cli.sdk.controls;
using xap.rui.control.extentions;
using xap.rui.appfw;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.orreport.scrollpanel.model;
using iih.ci.ord.opemergency.tool;

namespace iih.ci.ord.opemergency.dialog
{
    public partial class HpIndicDocJudgeForm : XForm
    {
        private HealthCheckRepoatView reportView;
        private bool isCanClose = false;
        public string[] id_ors;
        public bool fg_selfpay { get; set; }
        public string orderType { get; set; }

        public HpIndicDocJudgeForm(string[] id_ors,string OrderType)
        {
            
            this.MinimizeBox = false;
             this.Height = 520;
            this.Width = 750;
            this.IsShowButton = false;
            this.id_ors = id_ors;
            this.orderType = OrderType;
            this.InitializeComponent();
            this.Text = "医保适应症判断";
            saveButton.MouseClick += new MouseEventHandler(saveButton_MouseClick);
        }
        protected override void OnFormClosing(FormClosingEventArgs e)
        {
            base.OnFormClosing(e);
            if (!isCanClose) {
                e.Cancel = true;
            }
        }
        void saveButton_MouseClick(object sender, MouseEventArgs e)
        {
            string errorInfo = reportView.isDocJudgedOver();
            fg_selfpay = reportView.fg_selfpay;
            medicalInfoCache.setRepeatMessageDic(this.id_ors[0], fg_selfpay);
            if (errorInfo != null) {
                this.ShowInfo(errorInfo);
                return;
            }
            this.isCanClose = true;
            reportView.save();
            this.Close();
        }

        internal void loadFormView(view.OrdEmsView ordEmsView)
        {
            XapDataList<OrdSrvDO> dataSource = new HealthCheckReportModel().getDataSource(this.id_ors);
            if (dataSource != null && dataSource.Count() > 0) {
                reportView = new HealthCheckRepoatView(dataSource,this.id_ors,this.orderType);
                xLayoutPanel.AddControl(reportView, ControlPosition.Center);
                this.ShowDialog(ordEmsView);
            }
        }
    }
}
