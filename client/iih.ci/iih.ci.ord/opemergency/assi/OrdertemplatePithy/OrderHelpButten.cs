using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.opemergency.assi.OrderTemplate.view;
using iih.en.pv.dto.d;
using xap.cli.sdk.controls;
using xap.cli.sdk.form;
using xap.cli.sdk.render;
using xap.rui.bizcontrol.Historyofrecords.card;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.assi.OrdertemplatePithy
{
    public partial class OrderHelpButten : XapBaseControl
    {
        public OpTemplateFramePithy parentFrame;
        /// <summary>
        /// banner数据
        /// </summary>
        private Ent4BannerDTO BannerDTO;
        //切换按钮
        private XButton xBtnSwitch;
        // 确定、取消按钮
        private XButton xBtnOK;
        private XButton xBtnPrint;
        private XButton xBtnPrintView;
        private XButton xBtnClose;

        // 门诊、住院图例
        //private StateRender stateRenderOP;
        //private StateRender stateRenderIP;
        // 控件布局
        //private XBaseControl leftBaseCtrl;
        private XBaseControl rightBaseCtrl;
        private XLayoutPanel xLayoutPanel;

        /// <summary>
        /// 医嘱模板内容显示
        /// </summary>
        //private OpOrderTemplateListView templateListView;

        public OrderHelpButten()
        {
            InitializeComponent();
            this.Load += new EventHandler(OrderHelpButten_Load);
            intButten();
        }

        void OrderHelpButten_Load(object sender, EventArgs e)
        {
            //templateListView = this.Context.Config.GetInstance("OpOrderTemplateListView") as OpOrderTemplateListView;
            this.BannerDTO = this.Context["ent4BannerDTO"] as Ent4BannerDTO;
        }


        private void intButten()
        {
            // 确定、打印病历、病历打印预览，取消（关闭）按钮
            this.xBtnOK = new XButton();
            this.xBtnPrint = new XButton();
            this.xBtnPrintView = new XButton();
            this.xBtnClose = new XButton();
            this.xBtnSwitch = new XButton();
           
            // 左右布局控件 展现按钮、图例
            //this.leftBaseCtrl = new XBaseControl();
            this.rightBaseCtrl = new XBaseControl();
            this.xLayoutPanel = new XLayoutPanel();
            this.SuspendLayout();

            ///
            /// xLayoutPanel
            ///
            this.xLayoutPanel.Dock = System.Windows.Forms.DockStyle.Fill;

           
            ///
            /// rightBaseCtrl 按钮区域
            ///
            this.xLayoutPanel.AddControl(this.rightBaseCtrl, ControlPosition.Right, 474);          

            Size btnSize = new Size(86, 30);

            this.xBtnSwitch.Text = "切换";
            this.xBtnSwitch.Size = new Size(86, 30);
            this.xBtnSwitch.Location = new Point(190, 8);
            this.xBtnSwitch.MouseClick += new MouseEventHandler(xBtnSwitch_MouseClick);
            this.rightBaseCtrl.AddRender(this.xBtnSwitch);
            ///
            /// xBtnInovke
            ///
            this.xBtnOK.Text = "确定";
            this.xBtnOK.Size = new Size(86, 30);
            this.xBtnOK.Location = new Point(284, 8);
            this.xBtnOK.MouseClick += new MouseEventHandler(xBtnOK_MouseClick);
            this.rightBaseCtrl.AddRender(this.xBtnOK);


            ///
            /// xBtnClose
            ///
            this.xBtnClose.Text = "取消";
            this.xBtnClose.Size = new Size(86, 30);
            this.xBtnClose.Location = new Point(378, 8);
            this.xBtnClose.MouseClick += new MouseEventHandler(xBtnClose_MouseClick);
             this.rightBaseCtrl.AddRender(this.xBtnClose);

            ///
            /// this
            ///
            this.BackColor = Color.FromArgb(245, 245, 245);
            this.Controls.Add(this.xLayoutPanel);
        

            this.ResumeLayout(false);

        }
        //关闭
        void xBtnClose_MouseClick(object sender, MouseEventArgs e)
        {
            //this.templateListView.close();
            if(this.parentFrame!=null){
                this.FindForm().Close();
            }
        }
         //保存数据
        void xBtnOK_MouseClick(object sender, MouseEventArgs e)
        {
            //this.templateListView.Save();
            if (this.parentFrame != null)
            {
                this.parentFrame.saveData();
            }
        }
        //切换到复杂版数据
        void xBtnSwitch_MouseClick(object sender, MouseEventArgs e)
        {
            //this.templateListView.Save();
            if (this.parentFrame != null)
            {
                this.parentFrame.switchToComplex();
            }
        }




        public XForm AssiViewFrame { get; set; }

        public Ent4BannerDTO Ent4BannerDTO { get; set; }
        /// <summary>
        /// 当前环境信息
        /// </summary>
        public BaseContext BaseContext { get; set; }
        /// <summary>
        /// 就诊类型 门诊 00、急诊 01 、体检 02 、住院 10、家庭病床 20
        /// </summary>
        public string Code_entp { get; set; }
    }
}
