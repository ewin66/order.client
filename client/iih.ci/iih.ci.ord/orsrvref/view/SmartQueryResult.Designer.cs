using xap.rui.control.forms.view;
namespace iih.ci.ord.orsrvref.view
{
    partial class SmartQueryResult
    {
        //private XapFormControl resultControl;

        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        private XapFormControl xapFormControl;

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
            // 
            // xapFormControl
            // 
            //this.xapFormControl.ActiveRender = null;
            ////this.xapFormControl.AutoValidate = System.Windows.Forms.AutoValidate.EnableAllowFocusChange;
            this.xapFormControl.Context = null;
            this.xapFormControl.Dock = System.Windows.Forms.DockStyle.Fill;
            this.xapFormControl.File = null;
            this.xapFormControl.IsXapGrid = true;
            this.xapFormControl.Location = new System.Drawing.Point(0, 0);
            this.xapFormControl.Name = "xapFormControl";
            this.xapFormControl.Size = new System.Drawing.Size(590, 420);
            this.xapFormControl.TabIndex = 1;
            this.xapFormControl.ViewFile = null;
            // 
            // OrderScEx
            // 
            //this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.xapFormControl);
            this.Name = "SmartQuerySrvResult";
            this.Size = new System.Drawing.Size(590, 420);
            this.Load += new System.EventHandler(this.SmartQueryResult_Load);
            this.ResumeLayout(false);
        }

        #endregion
    }
}
