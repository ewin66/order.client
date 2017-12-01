using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using xap.cli.sdk.chart;
using xap.cli.sdk.form;

namespace iih.ci.ord.cilab.view
{
    public partial class Rptimg : XForm
    {
        private readonly LineChartRender lineChart;

        public Rptimg()
        {
            InitializeComponent();
            Size = new Size(762, 500);
            Resize += Rptimg_Resize;

            lineChart = new LineChartRender(this);
            lineChart.Location = new Point(50, 60);
            lineChart.Size = new Size(Size.Width - 100, Height - 80);
       
        }

        public List<Reportlab> listReList { get; set; }

        private void Rptimg_Resize(object sender, EventArgs e)
        {
            if (Size.Height < 483)
            {
                Size = new Size(Size.Width, 483);
            }
            lineChart.Size = new Size(Size.Width - 100, Height - 80);
        }

        public void drawImg()
        {
            lineChart.DataSource = listReList;
            lineChart.DefaultSelectLine = 0;
            AddRender(lineChart);
            StartPosition = FormStartPosition.CenterScreen; //设置弹窗在屏幕中心弹出
        }
    }
}