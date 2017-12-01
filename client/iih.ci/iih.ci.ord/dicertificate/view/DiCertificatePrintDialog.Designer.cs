using xap.rui.control.forms.view;
using xap.cli.sdk.form;
using System.Drawing;
namespace iih.ci.ord.dicertificate.view
{
    partial class DiCertificatePrintDialog
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

            //this.AutoScaleDimensions = new SizeF(6F, 12F);
            this.Name = "DiCertificatePrintDialog";
            this.Text = "打印预览";
            this.Formsize = FormSize.ExtraLarge;
            this.ResumeLayout(false);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;

            xapFormControl = new XapFormControl
            {
                Location = Panel.Location,
                Width = Panel.Width,
                Height = Panel.Height
            };
            xapFormControl.SetEditPolicy(true);
            Panel = xapFormControl;
        }

        private XapFormControl xapFormControl;

        #endregion
    }
}
