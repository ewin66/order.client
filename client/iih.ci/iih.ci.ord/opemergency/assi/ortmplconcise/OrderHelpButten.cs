
using System;
using xap.rui.control.basecontrol;
using iih.en.pv.dto.d;
using xap.cli.sdk.render;
using xap.cli.sdk.controls;
using System.Drawing;
using System.Windows.Forms;
using xap.cli.sdk.form;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.assi.ortmplconcise
{
    /// <summary>
    /// <para>描    述 :  按钮控件	</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.ortmplconcise    </para>    
    /// <para>类 名 称 :  OrderHelpButten					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Young         				</para> 
    /// <para>修 改 人 :  Young         				</para> 
    /// <para>创建时间 :  2017/10/23 17:47:51             </para>
    /// <para>更新时间 :  2017/10/23 17:47:51             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public partial class OrderHelpButten :  XapBaseControl
    {
        public OrTmplConciseFrame parentFrame;
        /// <summary>
        /// banner数据
        /// </summary>
        private Ent4BannerDTO BannerDTO;
        /// <summary>
        /// 切换按钮
        /// </summary>
        private XButton xBtnSwitch;
        /// <summary>
        /// 确定、取消按钮
        /// </summary>
        private XButton xBtnOK;
        private XButton xBtnPrint;
        private XButton xBtnPrintView;
        private XButton xBtnClose;

        /// <summary>
        /// 控件布局
        /// </summary>
        private XBaseControl rightBaseCtrl;
        private XLayoutPanel xLayoutPanel;

        public OrderHelpButten()
        {
            InitializeComponent();
            this.Load += new EventHandler(OrderHelpButten_Load);
            intButten();
        }

        private void OrderHelpButten_Load(object sender, EventArgs e)
        {
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
        private void xBtnClose_MouseClick(object sender, MouseEventArgs e)
        {
            //this.templateListView.close();
            if (this.parentFrame != null)
            {
                this.FindForm().Close();
            }
        }
        //保存数据
        private void xBtnOK_MouseClick(object sender, MouseEventArgs e)
        {
            //this.templateListView.Save();
            if (this.parentFrame != null)
            {
                this.parentFrame.saveData();
            }
        }
        //切换到复杂版数据
        private void xBtnSwitch_MouseClick(object sender, MouseEventArgs e)
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
