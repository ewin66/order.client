using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.dto.OrderPresSplitDTO.d;
using xap.dp.rptview.viewer;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;

namespace iih.ci.ord.oporder.cards
{
    public partial class OpOrderPresPrinView : XapCardControl
    {
        public OrderPresSplitDTO presdto { get; set; }
        private ReportViewer rpt_viewer = null;
        private string serv_rptfile = "iih_report/46105510_cfdy/cfdyXy.xml";
        public OpOrderPresPrinView()
        {
            InitializeComponent();
            this.rpt_viewer = new ReportViewer();
            Control panel = this.rpt_viewer.GetViewPanel();
            this.xapFormControl.Controls.Add(panel);
        //    this.xapFormControl.Load += new EventHandler(xapFormControl_Load);
        }

        public void PrintPres()
        {
            //throw new NotImplementedException();
            this.OnFillData();
        }

        //protected override void OnLoadData()
        //{
        //    base.OnLoadData();
        //}

        protected override void OnFillData()
        {
            // 填充报表查询参数
            Dictionary<string, string> qry_params = new Dictionary<string, string>();
            qry_params.Add("presId", presdto.Id_pres);
          //  qry_params.Add("presId", presdto.Id_pres);
            // 生成报表并刷新到界面上
            bool res = this.rpt_viewer.ShowRptFile(serv_rptfile, qry_params);
            if (!res)
            {
                // 打印提示信息
                this.ShowInfo(this.rpt_viewer.GetLastMsg());
                return;
            }
        }
    }
}
