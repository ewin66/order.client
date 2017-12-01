using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;

namespace iih.ci.ord.ciorder.ctlEx
{
    public partial class FrmChart : Form
    {
        public FrmChart()
        {
            InitializeComponent();
        }


  
        public string XValueMember { get; set; }
        public string  YValueMembers { get; set; }
        public object DataSource { get; set; }

        private void FrmChart_Load(object sender, EventArgs e)
        {
            chart1.Series[0].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Pie;



            DataTable dt = default(DataTable);
            dt = CreateDataTable();

            //设置图表的数据源
            chart1.DataSource = dt;
            Series ss = new Series("Date");
            //设置图表Y轴对应项
            ss.XValueMember = "Volume1";
            ss.YValueMembers = "Volume2";
            ss.ChartType = SeriesChartType.Line;
            ss.BorderWidth = 2;
            chart1.Series.Add(ss);
            ////设置图表Y轴对应项
            //chart1.Series[0].YValueMembers = "Volume1";
            //chart1.Series[1].YValueMembers = "Volume2";

            ////设置图表X轴对应项
            //chart1.Series[0].XValueMember = "Date";

            //绑定数据
            chart1.DataBind();


        }


        private DataTable CreateDataTable()
        {
            //Create a DataTable as the data source of the Chart control
            DataTable dt = new DataTable();

            //Add three columns to the DataTable
            dt.Columns.Add("Date");
            dt.Columns.Add("Volume1");
            dt.Columns.Add("Volume2");

            DataRow dr;

            //Add rows to the table which contains some random data for demonstration
            dr = dt.NewRow();
            dr["Date"] = "Jan";
            dr["Volume1"] = 3731;
            dr["Volume2"] = 4101;
            dt.Rows.Add(dr);

            dr = dt.NewRow();
            dr["Date"] = "Feb";
            dr["Volume1"] = 6024;
            dr["Volume2"] = 4324;
            dt.Rows.Add(dr);

            dr = dt.NewRow();
            dr["Date"] = "Mar";
            dr["Volume1"] = 4935;
            dr["Volume2"] = 2935;
            dt.Rows.Add(dr);

            dr = dt.NewRow();
            dr["Date"] = "Apr";
            dr["Volume1"] = 4466;
            dr["Volume2"] = 5644;
            dt.Rows.Add(dr);

            dr = dt.NewRow();
            dr["Date"] = "May";
            dr["Volume1"] = 5117;
            dr["Volume2"] = 5671;
            dt.Rows.Add(dr);

            dr = dt.NewRow();
            dr["Date"] = "Jun";
            dr["Volume1"] = 3546;
            dr["Volume2"] = 4646;
            dt.Rows.Add(dr);

            return dt;
        }

        private void chart1_DoubleClick(object sender, EventArgs e)
        {
            this.Close();
        }



    }
}
