using xap.rui.control.basecontrol;
using iih.en.pv.dto.d;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using iih.en.pv.entdiprove.d;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using iih.ci.ord.dicertificate.viewmodel;
using xap.sys.xbd.udi.d;
using xap.rui.control.extentions;
using xap.rui.control.engine.attributes;
using xap.dp.rptview.viewer;
using System.Collections.Generic;
using xap.dp.libcomm.print.args;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.bizcontrol.BillFormTmplConst;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/10/27

** 修改人：杨敬本

** 修改时间：2016/10/28

** 描述：诊断证明编辑

*********************************************************************************/

namespace iih.ci.ord.dicertificate.view
{
    public partial class DiCertificateEditView : XapBaseControl
    {
        #region 变量定义区域
        public Ent4BannerDTO ent4BannerDTO;

        private EntDiProveDO dataSource;
        private UdidocDO currUdi;

        private XLabel xLabTitl;
        private XLabel xLabAtte;

        private XCalendarTimerComboBox diproveDateTiem;

        //private bool bCanSave;
        private string status = "";

        //打印模板视图
        private ReportViewer rpt_viewer;

        //打印报表路径（门诊）
        private const string FILE_DI_M = "iih_report/461010_menzhenyishengzhan/ZDZM.xml";//诊断证明
        private const string FILE_VA_M = "iih_report/461010_menzhenyishengzhan/XJZM.xml";//休假证明

        //打印报表路径（住院）
        private const string FILE_DI_Z = "iih_report/461010_menzhenyishengzhan/ZDZM.xml";//诊断证明
        private const string FILE_VA_Z = "iih_report/461010_menzhenyishengzhan/XJZM.xml";//休假证明
        #endregion

        #region 构造函数区域
        public DiCertificateEditView()
        {
            InitializeComponent();

            this.Load += new System.EventHandler(DiCertificateEditView_Load);
        }
        #endregion

        #region 命令定义区域
        public void OnSave()
        {
            if (dataSource.Advice != null && dataSource.Advice.Length > 300)
            {
                this.ShowAlert("长度不可超过300字！");
                return;
            }

            if (this.dataSource != null)
            {
                onFireEventSent(Utils.TOSAVE, dataSource);
            }
        }
        
        public void OnPrint()
        {
            bool res = false;
            string strFile = "";
            if (ent4BannerDTO.Code_entp == "00")
            {
                //门诊
                switch (this.dataSource.Sd_diprovetp)
                {
                    case "01":
                        strFile = FILE_DI_M;//诊断证明报表
                        break;
                    case "02":
                        strFile = FILE_VA_M;//休假证明报表
                        break;
                    default:
                        break;
                }
            }
            else
            {
                //住院
                switch (this.dataSource.Sd_diprovetp)
                {
                    case "01":
                        strFile = FILE_DI_M;//诊断证明报表
                        break;
                    case "02":
                        strFile = FILE_VA_M;//休假证明报表
                        break;
                    default:
                        break;
                }
            }

            Dictionary<string, string> qryParams = new Dictionary<string, string>();
            qryParams.Add("$id_diprove", this.dataSource.Id_diprove);

            res = this.rpt_viewer.PrintRptFile(strFile, qryParams, true);

            if (res)
            {
                this.dataSource.Num_print++;
                onFireEventSent(Utils.PRINTSUCESS, null);
                this.LoadData();
            }
        }
        #endregion

        #region 内部事件区域
        private void DiCertificateEditView_Load(object sender, System.EventArgs e)
        {
            //加载模板视图
            this.rpt_viewer = new ReportViewer(true);

            this.xapFormControl.FormCreated += new System.EventHandler(xapFormControl_FormCreated);

            this.OnInit();
        }

        private void xapFormControl_FormCreated(object sender, System.EventArgs e)
        {
            xLabTitl = this.xapFormControl.GetUserRender("entprove", "title") as XLabel;
            xLabTitl.ValueText = "诊断证明";

            xLabAtte = this.xapFormControl.GetUserRender("entprove", "labAttention") as XLabel;

            diproveDateTiem = this.xapFormControl.GetUserRender("entprove", "dt_diprove").Renders[0] as XCalendarTimerComboBox;
        }
        #endregion

        #region 父类继承区域
        protected override void OnLoadData()
        {
            if (diproveDateTiem != null && dataSource != null)
                diproveDateTiem.MinDate = dataSource.Dt_acpt;
        }

        protected override void OnFillData()
        {
            FormFile f = new FormFile();
            //门诊or住院
            if (ent4BannerDTO.Code_entp == "00")
            {
                f.FormId = CiOrdBillFormTmplConst.CIORD_OP_DiCertificateEditView;// "20160617114459878FFP";//门急诊
            }
            else
            {
                f.FormId = CiOrdBillFormTmplConst.CIORD_IP_DiCertificateEditView;// "20151120040106530KAR";//住院
            }

            f.FormStyle = FormStyle.Card;
            f.ViewModel = dataSource;
            this.xapFormControl.ViewFile = f;

            if (dataSource == null)
            {
                this.xapFormControl.SetWaterMark("entprove", "   ");//设置水印
                this.xapFormControl.SetEditPolicy(false);
                return;
            }
            string str = "";
            if (dataSource.Num_print == null || dataSource.Num_print == 0)
                str = "未打印";
            else
                str = "已打印" + dataSource.Num_print.ToString() + "次";
            this.xapFormControl.SetWaterMark("entprove", str);//设置水印

            xLabAtte.Visible = this.currUdi.Ctrl1 == "0";

            if ((this.currUdi.Ctrl1 == "0" && this.dataSource.Num_print > 0) || (this.currUdi.Ctrl1 == "1" && status == Utils.SELECTROW && this.dataSource.Id_diprove == null))
            {
                this.xapFormControl.SetEditPolicy(false);
            }
            else
            {
                this.xapFormControl.SetEditPolicy(true);
            }
        }
        #endregion

        #region 辅助处理区域
        /// <summary>
        /// 响应树列表选中根节点
        /// </summary>
        private void onSelectRoot()
        {
            xLabTitl.ValueText = "诊断证明";

            this.LoadData();
        }

        /// <summary>
        /// 响应树列表选中
        /// </summary>
        private void onSelectRow()
        {
            if (xLabTitl != null)
            {
                //获取当前诊断证明分类
                currUdi = DiCertificateTreeViewModel.GetDiprovetTp(dataSource.Sd_diprovetp);
                xLabTitl.ValueText = currUdi.Name;

                this.LoadData();
            }
        }

        /// <summary>
        /// 发送事件
        /// </summary>
        /// <param name="strCommond"></param>
        /// <param name="sender"></param>
        protected void onFireEventSent(string strCommond, object sender)
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, strCommond);
            this.FireEventSent(sender, args);
        }
        #endregion

        #region 状态处理区域
        /// <summary>
        /// 接收响应事件发送
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="eventArgs"></param>
        public override void HandleState(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            string uiEvent = e.Data[UIConst.UI_EVENT] as string;

            switch (uiEvent)
            {
                case Utils.SELECTROOT:
                    status = Utils.SELECTROOT;
                    dataSource = sender as EntDiProveDO;
                    onSelectRoot();
                    break;
                case Utils.SELECTROWONLYNEW:
                case Utils.SELECTROWONLYSAVED:
                case Utils.SELECTROWONLYPRINTED:
                case Utils.SELECTROWNOTONLY:
                case Utils.SELECTROWITEM:
                    status = Utils.SELECTROW;
                    //bCanSave = true;
                    dataSource = sender as EntDiProveDO;
                    onSelectRow();
                    break;
                case Utils.TOADD:
                    status = Utils.TOADD;
                    //bCanSave = true;
                    dataSource = sender as EntDiProveDO;
                    this.LoadData();
                    break;
                case UIEvent.SAVE:
                    //bCanSave = false;
                    OnSave();
                    break;
                case Utils.SAVESUCESS:
                    //dataSource = sender as EntDiProveDO;
                    this.xapFormControl.SetEditPolicy(false);
                    break;
                case UIEvent.PRINT:
                    OnPrint();
                    break;
                default:
                    break;
            }
        }
        #endregion

    }
}
