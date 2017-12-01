using xap.cli.sdk.controls;
using xap.cli.sdk.render;
using System.Windows.Forms;
namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    partial class EntHistoryCiDiag
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
            this.ciXCheckBox = new XCheckBox();
            this.scrollBarPanel = new XAPScrollBarPanel();
            this.xLayoutPanel = new xap.cli.sdk.controls.XLayoutPanel();
            this.xLayoutPanel.SuspendLayout();
            this.SuspendLayout();
            //
            // ciXCheckBox
            //
            this.ciXCheckBox.Text = "临床诊断：";
            //this.ciXCheckBox.Alignment = System.Drawing.StringAlignment.Near;
            this.ciXCheckBox.Location = new System.Drawing.Point(20, 10);
            this.ciXCheckBox.ValueTextChanged += new System.EventHandler(ciXCheckBox_ValueTextChanged);
            this.ciXCheckBox.Size = new System.Drawing.Size(86, 24);

            // 
            // xLayoutPanel
            // 
            this.xLayoutPanel.Dock = DockStyle.Fill;
            this.xLayoutPanel.AddControl(this.scrollBarPanel, ControlPosition.Center);

            // 
            // EntpHistoryCiDiag
            // 
            this.AddRender(this.xLayoutPanel);
            this.xLayoutPanel.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        // 诊断左侧的复选框
        private XCheckBox ciXCheckBox;
        private XAPScrollBarPanel scrollBarPanel;
        private XLayoutPanel xLayoutPanel;

        #endregion


    }
}
