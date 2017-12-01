using System.Windows.Forms;
namespace iih.ci.ord.ciconsresponse.view
{
    partial class ConResHosView
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
            this.SuspendLayout();
            this.xapFormControl1 = new xap.rui.control.forms.view.XapFormControl();
            this.xapFormControl1.AutoSize = true;
            //this.xapFormControl1.AutoValidate = System.Windows.Forms.AutoValidate.EnableAllowFocusChange;
            //this.xapFormControl1.CanShowing = null;
            this.xapFormControl1.Context = null;
            this.xapFormControl1.File = null;
            this.xapFormControl1.Dock = DockStyle.Fill;
            this.xapFormControl1.Location = new System.Drawing.Point(3, 3);
            this.xapFormControl1.Name = "xapFormControl1";
            // 
            // ConResHosView
            // 
            //this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.xapFormControl1);
            this.Name = "ConResHosView";
            this.Size = new System.Drawing.Size(268, 229);
            this.ResumeLayout(false);

        }
        private xap.rui.control.forms.view.XapFormControl xapFormControl1;
        #endregion
    }
}
