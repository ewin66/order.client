using xap.cli.sdk.controls;
using xap.cli.sdk.render;
using System.Drawing;
using System.Windows.Forms;
namespace iih.ci.ord.ciorder.orreport
{
    partial class OrReport
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
            components = new System.ComponentModel.Container();
            this.leftXLayoutPanel = new XLayoutPanel();
            this.centerXLayoutPanel = new XLayoutPanel();
            this.centerXLayoutPanel.Padding = new Padding(15,0,0,0);
            this.xLayoutPanel1 = new XLayoutPanel();
            this.xLayoutPanel1.BottomBorder = 0;
            this.xLayoutPanel1.BottomCtrPriority = xap.cli.sdk.controls.ControlPriority.Lower;
            this.xLayoutPanel1.BottomGap = 0;
            this.xLayoutPanel1.BottomMaxWidth = 300;
            this.xLayoutPanel1.BottomMinWidth = 50;
            this.xLayoutPanel1.BottomPadding = null;
            this.xLayoutPanel1.BottomPercent = 0;
            this.xLayoutPanel1.BottomWidth = 50;

            this.xLayoutPanel1.CenterCtrPriority = xap.cli.sdk.controls.ControlPriority.Lower;
            this.xLayoutPanel1.CenterPadding = null;
            this.xLayoutPanel1.CenterPercent = 0;
            this.xLayoutPanel1.ControlBottom = null;
            this.xLayoutPanel1.ControlCenter = null;
            this.xLayoutPanel1.ControlLeft = null;
            this.xLayoutPanel1.ControlRight = null;
            this.xLayoutPanel1.ControlTop = null;
            this.xLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.xLayoutPanel1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Pixel);
            this.xLayoutPanel1.Gap = 1;
            this.xLayoutPanel1.IsContainerRender = true;
            this.xLayoutPanel1.LeftBorder = 0;
            this.xLayoutPanel1.LeftCtrPriority = xap.cli.sdk.controls.ControlPriority.Lower;
            this.xLayoutPanel1.LeftGap = 0;
            this.xLayoutPanel1.LeftMaxWidth = 300;
            this.xLayoutPanel1.LeftMinWidth = 50;
            this.xLayoutPanel1.LeftPadding = null;
            this.xLayoutPanel1.LeftPercent = 0;
            this.xLayoutPanel1.LeftWidth = 50;
            this.xLayoutPanel1.Location = new System.Drawing.Point(5, 37);
            this.xLayoutPanel1.Name = "xLayoutPanel1";
            this.xLayoutPanel1.RightBorder = 0;
            this.xLayoutPanel1.RightCtrPriority = xap.cli.sdk.controls.ControlPriority.Lower;
            this.xLayoutPanel1.RightGap = 0;
            this.xLayoutPanel1.RightPadding = null;
            this.xLayoutPanel1.RightPercent = 0;
            this.xLayoutPanel1.SingleBorderStyle = false;
            this.xLayoutPanel1.Size = new System.Drawing.Size(840, 383);
            this.xLayoutPanel1.TabIndex = 0;
            this.xLayoutPanel1.Text = "xLayoutPanel1";
            this.xLayoutPanel1.TopBorder = 0;
            this.xLayoutPanel1.TopCtrPriority = xap.cli.sdk.controls.ControlPriority.Lower;
            this.xLayoutPanel1.TopGap = 0;
            this.xLayoutPanel1.TopMaxWidth = 300;
            this.xLayoutPanel1.TopMinWidth = 50;
            this.xLayoutPanel1.TopPadding = null;
            this.xLayoutPanel1.TopPercent = 0;
            this.xLayoutPanel1.TopWidth = 50;
            this.Controls.Add(this.xLayoutPanel1);
            //this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 17F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Size = new System.Drawing.Size(830, 520);
            this.Controls.Add(this.xLayoutPanel1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Margin = new System.Windows.Forms.Padding(2, 4, 2, 4);
            this.Name = "or_report";
            this.Text = "医嘱报告";
            this.MinimizeBox = false;
            this.MaximizeBox = false;
            //this.DoReSize = false;
            this.ResumeLayout(false);
            xLayoutPanel1.CenterPadding = "10,0,0,0";
            this.xLayoutPanel1.AddControl(this.leftXLayoutPanel, ControlPosition.Left,185);
            this.xLayoutPanel1.AddControl(this.centerXLayoutPanel, ControlPosition.Center);
            //this.leftXLayoutPanel.Width = 185;
            this.leftXLayoutPanel.RightBorder = 2;
            buttonControl = new XBaseControl();
            buttonControl.Height = 40;
            saveButton = new XButton { Size = new Size(75, 25), Text = "保存" };
            cancelButton = new XButton { Size = new Size(75, 25), Text = "取消" };
            saveButton.Location = new Point(275, 0);
            cancelButton.Location = new Point(360, 0);
            buttonControl.AddRender(saveButton);
            buttonControl.AddRender(cancelButton);
            this.centerXLayoutPanel.AddControl(buttonControl, ControlPosition.Bottom);
            this.StartPosition = FormStartPosition.CenterScreen;
        }

        #endregion
        private XLayoutPanel xLayoutPanel1;
        private XLayoutPanel leftXLayoutPanel;
        private XLayoutPanel centerXLayoutPanel;
        private XButton saveButton;
        private XButton cancelButton;
        private XBaseControl buttonControl;
    }
}
