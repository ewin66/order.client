using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.chart;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciorder.cards.extend
{
    public partial class INSLineChartView : CiorderBaseControl
    {
        private LineChartRender lineChart;
        //private List<Reportlab> datasourceList;
        //private List<> 


        public INSLineChartView()
        {
            InitializeComponent();
            lineChart = new LineChartRender(this.xapFormControl1);
            lineChart.IsRight = false;
            lineChart.Size=this.xapFormControl1.Size;
            lineChart.Location=new Point(5,0);
            this.xapFormControl1.AddRender(lineChart);
            this.xapFormControl1_FormCreated();
            this.SizeChanged += new EventHandler(INSLineChartView_SizeChanged);
        }

        void INSLineChartView_SizeChanged(object sender, EventArgs e)
        {
            Size size = (sender as INSLineChartView).Size;
            this.xapFormControl1.Size = size;
            lineChart.Size = this.xapFormControl1.Size;
            this.lineChart.Invalidate();
        }

       
        
       

        void xapFormControl1_FormCreated()
        {
            string time = cof.GetSystemDateTime().AddDays(-1).ToShortDateString();
            //string time = new DateTime().AddDays(-1).ToShortDateString();
            //List<LabPoint> pointList=new List<LabPoint>();
            //LabPoint point=new LabPoint();
            //point.Xvalue
            #region 第一条折线数据
            List<LabPoint> list = new List<LabPoint>();
            LabPoint r = new LabPoint();
            r.Xvalue = new FDateTime(time + " 03:00:00");
            r.Yvalue = 6.0;
            r.FlagException = true;
            list.Add(r);
            LabPoint r1 = new LabPoint();
            r1.Xvalue = new FDateTime(time + " 07:30:00");
            r1.Yvalue = 5.5;
            list.Add(r1);

            LabPoint r2 = new LabPoint();
            r2.Xvalue = new FDateTime(time + " 10:00:00");
            r2.Yvalue = 8.5;
            r2.FlagException = true;
            list.Add(r2);

            LabPoint r3 = new LabPoint();
            r3.Xvalue = new FDateTime(time + " 11:30:00");
            r3.Yvalue = 6.1;
            list.Add(r3);

            LabPoint r4 = new LabPoint();
            r4.Xvalue = new FDateTime(time + " 14:00:00");
            r4.Yvalue = 9.5;
            r4.FlagException = true;
            list.Add(r4);
            LabPoint r5 = new LabPoint();
            r5.Xvalue = new FDateTime(time + " 17:30:00");
            r5.Yvalue = 5.7;
            list.Add(r5);

            LabPoint r6 = new LabPoint();
            r6.Xvalue = new FDateTime(time + " 20:00:00");
            r6.Yvalue = 8.5;
            r6.FlagException = true;
            list.Add(r6);

            LabPoint r7 = new LabPoint();
            r7.Xvalue = new FDateTime(time + " 23:00:00");
            r7.Yvalue = 6.7;
            list.Add(r7);
            #endregion
            #region 第二条折线数据
            List<LabPoint> list1 = new List<LabPoint>();
            LabPoint y = new LabPoint();
            //r.XName = "一";
            y.Xvalue = new FDateTime(time + " 07:55:00");
            y.Yvalue = 12;
            list1.Add(y);
            LabPoint y1 = new LabPoint();
            y1.Xvalue = new FDateTime(time + " 11:50:00");
            y1.Yvalue = 6;
            list1.Add(y1);

            LabPoint y2 = new LabPoint();
            y2.Xvalue = new FDateTime(time + " 17:55:00");
            y2.Yvalue = 10;
            list1.Add(y2);

            //LabPoint y3 = new LabPoint();
            //r7.Xvalue = new FDateTime("2016-12-18 14:47:08");
            //r7.Yvalue = 300;
            //list1.Add(y3);
            #endregion
            #region 第一条折线
            List<Reportlab> listReList = new List<Reportlab>();
            Reportlab cc1 = new Reportlab();
            cc1.points = list;    //点的集合
            cc1.YUnit = "mmlo/L";
            cc1.XUnit = "时间";
            cc1.Name = "血糖";
            listReList.Add(cc1);
            #endregion

            #region 第二条折线


            Reportlab cc2 = new Reportlab();
            cc2.points = list1;
            cc2.YUnit = "U";
            cc2.XUnit = "时间";
            cc2.Name = "胰岛素";
            listReList.Add(cc2);
            #endregion
            lineChart.DataSource = listReList;
            lineChart.DefaultSelectLine = 0;

        }
    }
}
