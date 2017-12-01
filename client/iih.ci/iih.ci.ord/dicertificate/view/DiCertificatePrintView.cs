using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.extentions;
using iih.en.pv.dto.d;
using xap.dp.rptview.viewer;
using System.Windows.Forms;
using iih.en.pv.entdiprove.d;
using System.Collections.Generic;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/10/27

** 修改人：杨敬本

** 修改时间：2016/10/28

** 描述：诊断证明预览模板

*********************************************************************************/

namespace iih.ci.ord.dicertificate.view
{
    public partial class DiCertificatePrintView : XapCardControl
    {
        #region 变量定义区域
        //打印模板视图
        private ReportViewer rpt_viewer;

        //打印报表路径（门诊）
        private const string FILE_DI_M = "iih_report/461010_menzhenyishengzhan/ZDZM.xml";//诊断证明
        private const string FILE_VA_M = "iih_report/461010_menzhenyishengzhan/XJZM.xml";//休假证明

        //打印报表路径（住院）
        private const string FILE_DI_Z = "iih_report/461010_menzhenyishengzhan/ZDZM.xml";//诊断证明
        private const string FILE_VA_Z = "iih_report/461010_menzhenyishengzhan/XJZM.xml";//休假证明

        private Ent4BannerDTO ent4BannerDTO;
        private EntDiProveDO entDiProveDO;
        #endregion

        public DiCertificatePrintView(Ent4BannerDTO ent4BannerDTO, EntDiProveDO entDiProveDO)
        {
            InitializeComponent();

            this.ent4BannerDTO = ent4BannerDTO;
            this.entDiProveDO = entDiProveDO;

            //加载模板视图
            this.rpt_viewer = new ReportViewer(DockStyle.Top, ReportViewer.Zoom_FitWidth, true);
            Control panel = this.rpt_viewer.GetViewPanel();
            panel.Dock = DockStyle.Fill;
            this.xapFormControl.Controls.Add(panel);

            ToPreview();
        }

        /// <summary>
        /// 执行预览
        /// </summary>
        private void ToPreview()
        {
            bool res = false;
            string strFile = "";
            if (ent4BannerDTO.Code_entp == "00")
            {
                //门诊
                switch (this.entDiProveDO.Sd_diprovetp)
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
                switch (this.entDiProveDO.Sd_diprovetp)
                {
                    case "01":
                        strFile = FILE_DI_Z;//诊断证明报表
                        break;
                    case "02":
                        strFile = FILE_VA_Z;//休假证明报表
                        break;
                    default:
                        break;
                }
            }
            
            Dictionary<string, string> qryParams = new Dictionary<string, string>();
            qryParams.Add("$id_diprove", this.entDiProveDO.Id_diprove);

            res |= this.rpt_viewer.LoadReport(strFile, qryParams, true);

            if (!res)
            {
                this.ShowInfo(this.rpt_viewer.GetLastMsg());
                return;
            }
            // 生成报表并刷新到界面上
            res = this.rpt_viewer.FillReport();
        }
    }
}
