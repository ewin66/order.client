using xap.rui.control.basecontrol;
using xap.cli.sdk.controls;
using xap.cli.sdk.render;
using System.Windows.Forms;
using System.Drawing;
namespace iih.ci.ord.opemergency.dialog
{
    partial class HpIndicDocJudgeForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.Text = "HpIndicDocJudgeForm";
            this.components = new System.ComponentModel.Container();
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            xLayoutPanel = new XLayoutPanel();
            this.xLayoutPanel.Dock = System.Windows.Forms.DockStyle.Fill;
            this.xLayoutPanel.Location = new System.Drawing.Point(5, 37);
            this.xLayoutPanel.CenterPadding = "10,0,0,0";
            buttonControl = new XapBaseControl();
            saveButton = new XButton { Size = new Size(90, 25), Text = "确认" };
            saveButton.Location = new Point(this.Bounds.Width - 120, 0);
            buttonControl.AddRender(saveButton);

            xLayoutPanel.AddControl(buttonControl, ControlPosition.Bottom, 35);
            this.AddRender(xLayoutPanel);
            //lblDes.Size = lblDes.GetPreferredSize(new Size(this.Width - 30, 60));
            this.StartPosition = FormStartPosition.CenterScreen;
        }
        private XapBaseControl buttonControl;
        private XLayoutPanel xLayoutPanel;
        private XButton saveButton;
        #endregion
    }
}