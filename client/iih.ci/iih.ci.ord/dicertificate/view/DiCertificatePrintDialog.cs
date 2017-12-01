using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using System.Windows.Forms;
using iih.en.pv.dto.d;
using iih.en.pv.entdiprove.d;

/********************************************************************************

** 作者： 杨敬本

** 创始时间：2016/10/27

** 修改人：杨敬本

** 修改时间：2016/10/27

** 描述：诊断证明预览窗体

*********************************************************************************/

namespace iih.ci.ord.dicertificate.view
{
    public partial class DiCertificatePrintDialog : XBaseDialog
    {
        private Ent4BannerDTO ent4BannerDTO;
        private EntDiProveDO entDiProveDO;

        public DiCertificatePrintDialog(Ent4BannerDTO ent4BannerDTO, EntDiProveDO entDiProveDO)
        {
            InitializeComponent();

            this.ent4BannerDTO = ent4BannerDTO;
            this.entDiProveDO = entDiProveDO;

            this.Load += new EventHandler(DiCertificatePrintDialog_Load);
        }

        private void DiCertificatePrintDialog_Load(object sender, EventArgs e)
        {
            DiCertificatePrintView view = new DiCertificatePrintView(this.ent4BannerDTO, this.entDiProveDO);
            view.Dock = DockStyle.Fill;
            this.Panel = view;
        }
    }
}
