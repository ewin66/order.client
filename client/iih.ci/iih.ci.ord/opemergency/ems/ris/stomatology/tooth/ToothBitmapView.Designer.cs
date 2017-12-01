using xap.cli.sdk.controls;
using xap.cli.sdk.render;
using xap.cli.sdk.controls.tabControl;
using System.Drawing;
using xap.cli.sdk.render.Items;
using System.Collections.Generic;
namespace iih.ci.ord.opemergency.ems.stomatology
{
    partial class ToothBitmapView
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

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {

            this.controlCenter = new XBaseControl();
            this.xLayoutPanel1 = new XLayoutPanel();
            this.tab = new XTabControl();
            this.priLabel = new XLabel();
            this.adultLabel = new XLabel();
            this.priTeeth = new XLabel();
            this.adultTeeth = new XLabel();
            this.dirLabel = new XLabel();
            this.connectLabel = new XLabel();
            this.blendconnectLabel = new XLabel();

            ///
            /// this.tab
            ///
            this.tab.Size = new Size(620, 470);
            this.tab.Location = new Point(5, 5);
            ///
            ///   this.adultTeeth
            /// 
            this.adultTeeth.Size = new Size(300, 24);
            this.adultTeeth.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            this.adultTeeth.ForeColor = Color.Black;
            this.adultTeeth.Tag = 1;
            this.adultTeeth.ValueText = "牙齿:12345678";
            this.noteList.Add(adultTeeth);
            ///
            ///   this.adultLabel
            /// 
            this.adultLabel.Size = new Size(300, 24);
            this.adultLabel.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            this.adultLabel.ForeColor = Color.Black;
            this.adultLabel.Tag = 3;
            this.adultLabel.ValueText = "恒牙:12345678";
            this.noteList.Add(adultLabel);
            ///
            ///   this.priTeeth
            /// 
            this.priTeeth.Size = new Size(300, 24);
            this.priTeeth.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            this.priTeeth.Tag = 2;
            this.priTeeth.ForeColor = Color.Black;
            this.priTeeth.ValueText = "牙齿:12345";
            this.noteList.Add(priTeeth);

            ///
            ///   this.priLabel
            /// 
            this.priLabel.Size = new Size(300, 24);
            this.priLabel.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            this.priLabel.ForeColor = Color.Black;
            this.priLabel.Tag = 3;
            this.priLabel.ValueText = "乳牙:ABCDE";
            this.noteList.Add(priLabel);
            ///
            ///   this.dirLabel
            /// 
            this.dirLabel.Size = new Size(300, 24);
            this.dirLabel.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            this.dirLabel.ForeColor = Color.Black;
            this.dirLabel.ValueText = "牙面:MODBLP";
            this.noteList.Add(dirLabel);
            ///
            ///   this.connectLabel
            /// 
            this.connectLabel.Size = new Size(300, 24);
            this.connectLabel.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            this.connectLabel.Tag = 2;
            this.connectLabel.ForeColor = Color.Black;
            this.connectLabel.ValueText = "连接符:-";
            this.noteList.Add(connectLabel);

            ///
            ///   this.blendconnectLabel
            /// 
            this.blendconnectLabel.Size = new Size(300, 24);
            this.blendconnectLabel.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            this.blendconnectLabel.ForeColor = Color.Black;
            this.blendconnectLabel.Tag = 3;
            this.blendconnectLabel.ValueText = "连接符:-    空格";
            this.noteList.Add(blendconnectLabel);

            ///
            /// this.quicklyInput
            ///
            this.quicklyInput = new XTabPage();
            this.quicklyInput.Text = "快捷录入";


            ///
            /// this.photoInput
            ///
            this.photoInput = new XTabPage();
            this.photoInput.Text = "图片模式";
            this.photoInput.BackColor = Color.Blue;
            ///
            /// controlCenter
            ///
            this.controlCenter.Location = new System.Drawing.Point(248, 0);
            this.controlCenter.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.controlCenter.Name = "controlCenter";
            this.controlCenter.Size = new System.Drawing.Size(463, 385);
            this.controlCenter.TabIndex = 3;
            // 
            // xLayoutPanel1
            // 
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
            this.xLayoutPanel1.RightMaxWidth = 300;
            this.xLayoutPanel1.RightMinWidth = 50;
            this.xLayoutPanel1.RightPadding = null;
            this.xLayoutPanel1.RightPercent = 0;
            this.xLayoutPanel1.RightWidth = 50;
            this.xLayoutPanel1.SingleBorderStyle = false;
            this.xLayoutPanel1.Size = new System.Drawing.Size(812, 383);
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
            ///
            // Form1
            //
            //this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 17F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Size = new System.Drawing.Size(1266, 728);
            this.Controls.Add(this.xLayoutPanel1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Margin = new System.Windows.Forms.Padding(2, 4, 2, 4);
            this.Name = "XApForm_PrintPreview";
            this.Text = "牙位图的录入与编辑";
            this.MinimizeBox = false;
            this.MaximizeBox = false;
            //this.DoReSize = false;
            this.ResumeLayout(false);
        }

        #endregion
        private XLabel priLabel;
        private XLabel adultLabel;
        private XLabel priTeeth;
        private XLabel adultTeeth;
        private XLabel dirLabel;
        private XLabel blendconnectLabel;
        private XLabel connectLabel;
        private XTabControl tab;
        private XTabPage quicklyInput;
        private XTabPage photoInput;
        private XBaseControl controlCenter;
        private XLayoutPanel xLayoutPanel1;
        private List<XLabel> noteList = new List<XLabel>();
    }
}

