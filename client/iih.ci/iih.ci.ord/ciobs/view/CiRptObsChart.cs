using System;
using System.Drawing;
using System.Windows.Forms;
using xap.cli.sdk.form;

namespace iih.ci.ord.ciobs.view
{
    public partial class CiRptObsChart : XDialog
    {
        public CiRptObsChart()
        {
            InitializeComponent();
            this.BackgroundImage = Image.FromFile("D:\\新建文件夹\\检验报告.jpg");
            this.Panel.BackgroundImage = Image.FromFile("D:\\新建文件夹\\QQ图片20151112190621.png");
            this.Panel.BackgroundImageLayout = ImageLayout.Stretch;
        }

        private void CiRptObsChart_Load(object sender, EventArgs e)
        {

        }
    }
}
