using xap.rui.control.forms.view;

namespace iih.ci.ord.opemergency.assi.asscommon.view
{
    partial class AssiViewFrame
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
            xapFormControl = new XapFormControl();
            xapFormControl.Dock = System.Windows.Forms.DockStyle.Fill;
            this.Controls.Add(xapFormControl);

            this.Text = "辅助录入";
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.DoReSize = false;
            this.Load += AssiViewFrame_Load;
            this.ShowInTaskbar = false;// 设置窗口在任务栏上是否显示图标，弹出窗口不显示图标
            components = new System.ComponentModel.Container();
        }

        private XapFormControl xapFormControl;

        #endregion
    }
}