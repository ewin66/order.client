using System;
using System.Windows.Forms;
using System.Collections.Generic;
using xap.cli.sdk.form;
using iih.en.pv.dto.d;
using xap.rui.engine;
using System.Drawing;
using xap.rui.control.basecontrol;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/10/27

** 修改人：杨敬本

** 修改时间：2016/10/27

** 描述：诊断证明体系窗体（门急诊）

*********************************************************************************/

namespace iih.ci.ord.dicertificate.view
{
    public partial class DiCertificateDialog : XSingleDialog
    {
        private Ent4BannerDTO ent4BannerDTO;
        private XapBaseControl parentControl;

        public DiCertificateDialog(Ent4BannerDTO ent4BannerDTO, XapBaseControl parentControl)
        {
            InitializeComponent();

            this.Formsize = FormSize.ExtraLarge;
            this.AutoScaleDimensions = new SizeF(7.6F, 13.6F);

            this.Text = "诊断证明";
            this.HasbtnBackRec = false;

            this.ent4BannerDTO = ent4BannerDTO;
            this.parentControl = parentControl;

            this.Load += new EventHandler(DiCertificateDialog_Load);
        }

        private void DiCertificateDialog_Load(object sender, EventArgs e)
        {
            XUserControl userControl = new XUserControl();
            userControl.Init(Application.StartupPath + "\\modules\\iihci\\ui\\dicertificate\\dicertificate_config.xml");
            userControl.Dock = DockStyle.Fill;
            userControl.Size = this.Panel.Size;
            userControl.Location = this.Panel.Location;
            this.Panel = userControl;

            //树列表
            DiCertificateTreeView leftView = userControl.GetConfig().GetInstance("leftView") as DiCertificateTreeView;
            if (leftView != null)
            {
                leftView.ent4BannerDTO = this.ent4BannerDTO;
                leftView.parentBaseControl = this.parentControl;
            }

            //编辑界面
            DiCertificateEditView rightView = userControl.GetConfig().GetInstance("rightView") as DiCertificateEditView;
            if (rightView != null)
            {
                rightView.ent4BannerDTO = this.ent4BannerDTO;
            }

            userControl.LoadData();
        }
    }
}
