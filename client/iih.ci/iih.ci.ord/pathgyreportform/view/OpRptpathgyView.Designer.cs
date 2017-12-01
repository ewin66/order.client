using xap.cli.sdk.form;
namespace iih.ci.ord.pathgyreportform.view
{
    partial class OpRptpathgyView
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

            this.Size = new System.Drawing.Size(800, 750);
            this.Dock = System.Windows.Forms.DockStyle.Fill;
            this.xapFormControl1 = new xap.rui.control.forms.view.XapFormControl();
            this.SuspendLayout();
            this.xapFormControl1.Context = null;
            this.xapFormControl1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.xapFormControl1.File = null;
            this.xapFormControl1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Pixel);
            this.xapFormControl1.IsContainerRender = true;
            this.xapFormControl1.IsFirstFocus = true;
            this.xapFormControl1.IsShowWarnForm = true;
            this.xapFormControl1.IsXapGrid = true;
            this.xapFormControl1.Location = new System.Drawing.Point(0, 0);
            this.xapFormControl1.LstUserRenders = null;
            this.xapFormControl1.Name = "xapFormControl1";
            this.xapFormControl1.PageIndex = -1;
            this.xapFormControl1.SingleBorderStyle = false;
            this.xapFormControl1.Size = new System.Drawing.Size(800, 750);
            this.xapFormControl1.TabIndex = 0;
            this.xapFormControl1.Text = "xapFormControl1";
            this.xapFormControl1.ViewFile = null;
            // 
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Formsize = FormSize.Large;
            this.Controls.Add(this.xapFormControl1);
            this.Name = "OpRptpathgyView";
            this.Text = "病理报告";
            this.ResumeLayout(false);
        }

        #endregion

        private xap.rui.control.forms.view.XapFormControl xapFormControl1;
    }
}
