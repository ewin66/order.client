using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using iih.ci.ord.ciorder.viewmodel;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.bd.srv.medsrv.d;
using xap.cli.sdk.controls;
using xap.cli.sdk.render.Items;

namespace iih.ci.ord.ciorder.cards
{
    public partial class OrderDrugDesView : XAPScrollBarPanel
    {
        private XBaseControl panel;
        public OrderDrugDesView()
        {
            InitializeComponent();
            this.Load += new EventHandler(OrderDrugDesView_Load);
            //flowLayoutPanel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            panel = new XBaseControl();
            panel.Location = new Point(10, 0);
            panel.Size = new Size(this.Size.Width, this.Size.Height);
            this.AddRender(panel);
        }

        OrderDrugDesViewModel viewModel = new OrderDrugDesViewModel();


        void OrderDrugDesView_Load(object sender, EventArgs e)
        {

        }


        public void ShowDrugDes(string id_srv)
        {
            //string[] des =viewModel.GetDrugDes(id_srv).Split('|');
            //lbl_caption.Text=des[0];
            //lbl_des.Text =des[1] ;
        }

        public void ShowDrugDes(XapDataList<EmsOrDrug> drugList)
        {
              if(this.panel != null)
              {
                    this.panel.RemoveRenderAll();
                    List<XLabel> labelList = new List<XLabel>();
                    foreach (EmsOrDrug p in drugList)
                    {
                        MedSrvDO md = new GetMedSrvImpl().GetMedSrvById(p.Id_srv);
                        string str = viewModel.GetDrugDes(p.Id_srv);
                        XLabel lbltitle = new XLabel();
                        lbltitle.Font = new System.Drawing.Font("微软雅黑", 18.75F);
                        lbltitle.ValueText = p.Name_srv + "说明书";
                        lbltitle.Size = lbltitle.GetPreferredSize(new Size(this.Width - 20, 0));
                        lbltitle.CanFocus = true;

                        XLabel lblDes = new XLabel();
                        lblDes.Font = new System.Drawing.Font("微软雅黑", 10.75F);
                        lblDes.ValueText = str;
                        lblDes.Size = lblDes.GetPreferredSize(new Size(this.Width - 20, 0));
                        lblDes.CanFocus = true;

                        this.panel.AddRender(lbltitle);
                        this.panel.AddRender(lblDes);
                        labelList.Add(lbltitle);
                        labelList.Add(lblDes);
                    };
                    ReLocation(labelList);
              }
            this.getScrollBarRect();
        }

        private void ReLocation(List<XLabel> labelList)
        {
            XLabel pre = null;
            if (labelList != null && labelList.Count != 0)
            {
                int y = 0;
                int height = 0;
                foreach (XLabel label in labelList)
                {
                    if (pre == null)
                    {
                        label.Location = new Point(0, 0);
                    }
                    else
                    {
                        y = y + pre.Size.Height;
                        label.Location = new Point(0, y);
                    }
                    pre = label;
                    height = height + label.Size.Height;
                }
                this.panel.Size = new Size(this.Width-10, height);
            }
           
            this.Invalidate();
        }

    }
}
