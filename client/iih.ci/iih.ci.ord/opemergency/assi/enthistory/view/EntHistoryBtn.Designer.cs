using System.Drawing;
using xap.cli.sdk.render;
using xap.rui.bizcontrol.Historyofrecords.card;
using xap.cli.sdk.controls;
namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    partial class EntHistoryBtn
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region 组件设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            // 确定、打印病历、病历打印预览，取消（关闭）按钮
            this.xBtnOK = new XButton();
            this.xBtnPrint = new XButton();
            this.xBtnPrintView = new XButton();
            this.xBtnClose = new XButton();

            // 住院、门诊图例
            //this.stateRenderIP = new StateRender { ForeColor = Color.FromArgb(0, 153, 229), ExplainName = "门诊" };
            //this.stateRenderOP = new StateRender { ForeColor = Color.FromArgb(36, 159, 131), ExplainName = "住院" };

            // 左右布局控件 展现按钮、图例
            this.leftBaseCtrl = new XBaseControl();
            this.rightBaseCtrl = new XBaseControl();
            this.xLayoutPanel = new XLayoutPanel();
            this.SuspendLayout();

            ///
            /// xLayoutPanel
            ///
            this.xLayoutPanel.Dock = System.Windows.Forms.DockStyle.Fill;

            ///
            /// leftBaseCtrl 图例区域
            ///            
            this.xLayoutPanel.AddControl(this.leftBaseCtrl, ControlPosition.Left, 300);

            ///
            /// rightBaseCtrl 按钮区域
            ///
            //this.xLayoutPanel.AddControl(this.rightBaseCtrl, ControlPosition.Right, 308);
            this.xLayoutPanel.AddControl(this.rightBaseCtrl, ControlPosition.Right, 474);

            ///
            /// stateRenderOP
            ///
            //this.stateRenderOP.Location = new Point(73, 15);
            //this.leftBaseCtrl.AddRender(this.stateRenderOP);

            ///
            /// stateRenderIP
            ///
            //this.stateRenderIP.Location = new Point(160, 15);
            //this.leftBaseCtrl.AddRender(this.stateRenderIP);

            Size btnSize = new Size(86, 30);

            ///
            /// xBtnInovke
            ///
            this.xBtnOK.Text = "确定";
            this.xBtnOK.Size = new Size(86, 30);
            this.xBtnOK.Location = new Point(10, 8);
            this.xBtnOK.MouseClick += new System.Windows.Forms.MouseEventHandler(XBtnOK_MouseClick);
            this.rightBaseCtrl.AddRender(this.xBtnOK);

            ///
            /// xBtnPrint
            ///
            this.xBtnPrint.Text = "打印病历";
            this.xBtnPrint.Size = new Size(126, 30);
            this.xBtnPrint.Location = new Point(106,8);
            this.xBtnPrint.MouseClick += new System.Windows.Forms.MouseEventHandler(XBtnPrint_MouseClick);
            this.rightBaseCtrl.AddRender(this.xBtnPrint);

            ///
            /// xBtnPrint
            ///
            this.xBtnPrintView.Text = "病历预览打印";
            this.xBtnPrintView.Size = new Size(126, 30);
            this.xBtnPrintView.Location = new Point(242,8);
            this.xBtnPrintView.MouseClick += new System.Windows.Forms.MouseEventHandler(XBtnPrintView_MouseClick);
            this.rightBaseCtrl.AddRender(this.xBtnPrintView);

            ///
            /// xBtnClose
            ///
            this.xBtnClose.Text = "取消";
            this.xBtnClose.Size = new Size(86, 30);
            this.xBtnClose.Location = new Point(378, 8);
            this.xBtnClose.MouseClick += new System.Windows.Forms.MouseEventHandler(XBtnClose_MouseClick);
            this.rightBaseCtrl.AddRender(this.xBtnClose);

            ///
            /// this
            ///
            this.BackColor = Color.FromArgb(245, 245, 245);
            this.Controls.Add(this.xLayoutPanel);
            this.Load += EntHistoryBtn_Load;

            this.ResumeLayout(false);

        }

        // 确定、取消按钮
        private XButton xBtnOK;
        private XButton xBtnPrint;
        private XButton xBtnPrintView;
        private XButton xBtnClose;

        // 门诊、住院图例
        //private StateRender stateRenderOP;
        //private StateRender stateRenderIP;

        // 控件布局
        private XBaseControl leftBaseCtrl;
        private XBaseControl rightBaseCtrl;
        private XLayoutPanel xLayoutPanel;

        //private XButton btn;

        #endregion
    }
}
