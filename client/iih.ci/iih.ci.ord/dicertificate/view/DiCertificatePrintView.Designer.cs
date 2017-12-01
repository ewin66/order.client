using xap.rui.control.forms.view;
using System.Windows.Forms;
using System.Drawing;
namespace iih.ci.ord.dicertificate.view
{
    partial class DiCertificatePrintView
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

            this.xapFormControl = new XapFormControl();
            this.SuspendLayout();
            // 
            // xapFormControl
            // 
            this.xapFormControl.Context = null;
            this.xapFormControl.Dock = DockStyle.Fill;
            this.xapFormControl.IsXapGrid = true;
            this.xapFormControl.Location = new Point(0, 0);
            this.xapFormControl.Name = "xapFormControl";
            this.xapFormControl.Size = new Size(150, 150);
            this.xapFormControl.TabIndex = 0;
            // 
            // DiCertificatePrintView
            // 
            this.Margin = new System.Windows.Forms.Padding(3, 6, 3, 6);
            this.Name = "DiCertificatePrintView";

            this.ResumeLayout(false);

            this.Controls.Add(this.xapFormControl);
        }

        private XapFormControl xapFormControl;

        #endregion
    }
}
