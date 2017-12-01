using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.opemergency.viewmodel;
using xap.dp.rptview.viewer;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.engine;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.assi.asscommon.viewmodel;
using xap.dp.libcomm.print.args;
using iih.ci.iih.ci.ord.i;
using xap.dp.rptview.viewer.rptparams;
using xap.cli.sdk.form;
using System.Drawing;
using xap.rui.control.waiting;

namespace iih.ci.ord.opemergency.view.printmanage
{
    public partial class PrintPreviewView : XapCardControl
    {
        //打印模板视图
        private MultiReportsViewer rpt_viewer;

        private PrintManageViewModel viewModel;

        //父级容器
        public XapBaseControl OwnerView { set; get; }
        public int SelectedIndex { set; get; }
        public List<String> LstIdor { set; get; }
        public List<String> LstIdpres { set; get; }
        public String Id_hp { set; get; }
        public String Sd_hptp { set; get; }
        public bool bShowTools { set; get; }

        private Dictionary<string, string> dicParam;

        private List<String> lsttps = new List<string>();

        private bool isPrtSucc;

        #region 构造函数区域
        public PrintPreviewView()
        {
            InitializeComponent();
            this.Load += new EventHandler(PrintPreviewView_Load);
        }
        #endregion

        #region 父类继承区域
        protected override void OnLoadData()
        {
            
        }

        protected override void OnFillData()
        {
            
        }

        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if ((e.Object is Dictionary<string, string>))
            {
                this.dicParam = e.Object as Dictionary<string, string>;
                this.toLoadData();
                this.toFillData();
            }
        }
        #endregion

        #region 内部事件区域
        private void PrintPreviewView_Load(object sender, EventArgs e)
        {
             //Loading _loading = new Loading();
            //_loading.TopMost = true;
            //Form owerForm = this.FindForm().ParentForm;
            //_loading.Owner = owerForm;
            //_loading.Show();

                var t1 = new AssCostTimeTool("门急诊临床单据打印，匹配打印模板耗时：", false);
                this.viewModel = new PrintManageViewModel(this.Context.PsnInfo.Id_psndoc, this.Context.Dept.Id_dep, this.Context.Org.Id_org, this.Context.Group.Id_grp,
                    this.Context.GetOrgParam<string>(ICiOrdNSysParamConst.SYS_PARAM_CiPharmGrpableUsageScope), this.SelectedIndex, this.LstIdor, this.LstIdpres, this.Id_hp, this.Sd_hptp, this.bShowTools);
                t1.SaveTimeLog();

                var t2 = new AssCostTimeTool("门急诊临床单据打印，读取小票打印机耗时：", false);
                //加载辅助打印机（非小票单据操作系统默认打印机打印，小票单据在此指定辅助打印机）
                QiPrintArgs qiPrintArgs = new QiPrintArgs();
                qiPrintArgs.AddAltertivePrinter(QiPrintArgs.StripPpSzNO, this.viewModel.GetPrinterName());
                qiPrintArgs.ShowtipOnDocSzChanged = true;
                t2.SaveTimeLog();

                //装载模板视图
                this.rpt_viewer = new MultiReportsViewer();
                this.rpt_viewer.InitHasView(navBarDock: DockStyle.Top, useAlone: !bShowTools);
                this.rpt_viewer.CopyPrintArgs(qiPrintArgs);
                this.rpt_viewer.SetDefaultZoomRatio("100%");//指定显示比例

                Control panel = this.rpt_viewer.GetViewPanel();
                panel.Dock = DockStyle.Fill;
                this.xapFormControl.Controls.Add(panel);

                this.OnInit();

                AppWaiting waiting = new AppWaiting();
                waiting.AsynchronousStart(this, delegate
                {
                    this.toLoadData();
                });
                
                this.toFillData();
         

            //loading.Close();
        }

        #endregion

        private void toLoadData()
        {
            var t1 = new AssCostTimeTool("门急诊临床单据打印，报表加载数据耗时：", false);

            List<ReportLoadParams> rpt_load_params = new List<ReportLoadParams>();
            lsttps.Clear();
            if (this.dicParam != null)
            {
                string sd_sheettps = "";
                if (this.dicParam.ContainsKey("Sd_sheettp"))
                    sd_sheettps = dicParam["Sd_sheettp"] as string;
                if (string.IsNullOrEmpty(sd_sheettps))
                {
                    rpt_viewer.ClearRptLoaded(false, false);
                    return;
                }
                lsttps = sd_sheettps.Split(',').ToList();
                List<string> lstURLs = this.viewModel.GetPrntmplPathByPrntp(lsttps);
                if (lstURLs == null || lstURLs.Count == 0) return;
                foreach (string url in lstURLs)
                {
                    if (string.IsNullOrEmpty(url)) continue;

                    ReportLoadParams param = new ReportLoadParams();
                    param.RptFile = url;
                    param.QryParams = this.getRptParams(url);
                    rpt_load_params.Add(param);
                }

                rpt_viewer.LoadReportsByThreads(rpt_load_params, false); 
            }
            else
            {
                List<string> loadurl = new List<string>();
                foreach (string url in this.viewModel.dicUrlIDs.Keys)
                {
                    if (string.IsNullOrEmpty(url)) continue;
                    ReportLoadParams param = new ReportLoadParams();
                    param.RptFile = url;
                    param.QryParams = this.getRptParams(url);
                    rpt_load_params.Add(param);
                    loadurl.Add(url);
                }

                rpt_viewer.LoadReportsByThreads(rpt_load_params, false);

                if (loadurl.Count != 0)
                {
                    foreach(var rpt_load_param in rpt_load_params)
                    {
                        if (!String.IsNullOrEmpty(rpt_load_param.LoadErrMsg))
                            loadurl.Remove(rpt_load_param.RptFile);
                    }
                    lsttps = this.viewModel.FindPrntpByUrl(loadurl);
                }
            }
            t1.SaveTimeLog();
        }

        private void toFillData()
        {
            var t1 = new AssCostTimeTool("门急诊临床单据打印，报表刷新界面耗时：", false);

            if (lsttps != null && lsttps.Count > 0)
            {
                Dictionary<string, List<string>> dic = new Dictionary<string, List<string>>();
                dic.Add("sd_printtps", lsttps);
                this.FireSelected(dic);
            }

            this.rpt_viewer.FillReport();

            this.xapFormControl.SetEditable(true);

            t1.SaveTimeLog();
        }

        /// <summary>
        /// 根据模板路径匹配模板参数
        /// </summary>
        /// <param name="url">路径</param>
        /// <param name="qryParams"></param>
        private Dictionary<string, string> getRptParams(string url)
        {
            Dictionary<string, string> dicParams = new Dictionary<string, string>();
            string ids = "";
            if (this.viewModel.dicUrlIDs.ContainsKey(url))
            {
                foreach (string str in this.viewModel.dicUrlIDs[url])
                {
                    ids += "'" + str + "',";
                }
            }
            if (ids.Length > 0)
                dicParams.Add("ids", ids.Substring(0, ids.Length - 1));
            return dicParams;
        }

        /// <summary>
        /// 更新打印数据
        /// </summary>
        public void UpdatePrnInfo()
        {
            if (!isPrtSucc || this.lsttps == null || lsttps.Count <= 0) return;
            this.viewModel.UpdateFgprn(this.lsttps.ToArray());
        }

        #region 状态处理区域
        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            //string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.LOAD:
                    break;
                case "All_Print":
                    isPrtSucc = this.rpt_viewer.PrintRptFile();
                    //打印病历
                    Object objData = AssToolEx.ObjectOfEventArgs(eventArgs, "Print_Mr");
                    if (OwnerView != null && null != objData && (objData as String).Equals("true"))
                    {
                        AssToolEx.SentMessage(OwnerView, AssToolEx.DictionaryEventArgsWith(AssistantConstant.CI_EMR_PRINT_EVENT));
                    }
                    break;
                case "All_Export":
                    this.rpt_viewer.ExportRptFile();
                    break;
                default:
                    break;
            }
        }
        #endregion
    }
}
