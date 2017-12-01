using System;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using System.Windows.Forms;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.bannercontrol;
using System.ComponentModel.DataAnnotations;
using iih.ci.ord.ciorder.utils;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/10/27

** 修改人：杨敬本

** 修改时间：2016/10/27

** 描述：诊断证明体系窗体（住院）

*********************************************************************************/

namespace iih.ci.ord.dicertificate.view
{
    public partial class DiCertificateView : XapCardControl
    {
        [Display(Name = "算法，接口调用集合", Description = "各种算法的汇集")]
        public LogicEx cof = LogicEx.GetInstance();

        private XUserControl userControl;
        private Ent4BannerDTO ent4BannerDTO;

        public DiCertificateView()
        {
            InitializeComponent();

            this.Load += new EventHandler(DiCertificateView_Load);
            
        }

        private void DiCertificateView_Load(object sender, EventArgs e)
        {
            userControl = new XUserControl();
            userControl.Init(Application.StartupPath + "\\modules\\iihci\\ui\\dicertificate\\dicertificate_config.xml");
            userControl.Dock = DockStyle.Fill;
            userControl.Size = this.Size;
            userControl.Location = this.Location;
            userControl.LoadData();

            this.Controls.Add(userControl);
        }

        public override void HandleState(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            string uiEvent = e.Data[UIConst.UI_EVENT] as string;
            string newState = e.Data[UIConst.NEW_STATE] as string;

            switch (uiEvent)
            {
                case UIEvent.LOAD:
                    this.ent4BannerDTO = (this.Context["PatientData"] as BannerData).Ent4BannerDTO;
                    //树列表
                    DiCertificateTreeView leftView = userControl.GetConfig().GetInstance("leftView") as DiCertificateTreeView;
                    if (leftView != null)
                    {
                        leftView.ent4BannerDTO = this.ent4BannerDTO;
                        leftView.parentUserControl = this.Parent.Parent as XUserControl;
                    }

                    //编辑界面
                    DiCertificateEditView rightView = userControl.GetConfig().GetInstance("rightView") as DiCertificateEditView;
                    if (rightView != null)
                    {
                        rightView.ent4BannerDTO = this.ent4BannerDTO;
                    }

                    userControl.Enabled = cof.viewEditState8EntSd(ent4BannerDTO.Entpattp);
                    break;
                default:
                    break;
            }
        }

    }
}
