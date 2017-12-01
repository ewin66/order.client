using System.Drawing;
using System.Windows.Forms;
using xap.cli.sdk.render;
using xap.rui.control.forms.view;

namespace iih.ci.ord.opemergency.view.printmanage
{
    partial class PrintChooseView
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
            this.xapFormControl = new XapFormControl();
            this.SuspendLayout();
            // 
            // xapFormControl
            // 
            //this.xapFormControl.AutoValidate = AutoValidate.EnableAllowFocusChange;
            this.xapFormControl.Context = null;
            this.xapFormControl.Dock = DockStyle.Fill;
            this.xapFormControl.File = null;
            this.xapFormControl.IsXapGrid = true;
            this.xapFormControl.Location = new Point(0, 0);
            this.xapFormControl.Name = "xapFormControl";
            this.xapFormControl.Size = new Size(150, 150);
            this.xapFormControl.TabIndex = 0;
            this.xapFormControl.ViewFile = null;
            // 
            // ConsCardView
            // 
            //this.AutoScaleDimensions = new SizeF(6F, 12F);
            //this.AutoScaleMode = AutoScaleMode.Font;
            this.Controls.Add(this.xapFormControl);
            this.Name = "PrintChooseView";
            this.ResumeLayout(false);
            components = new System.ComponentModel.Container();
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
        }

        #endregion
        private XapFormControl xapFormControl;
       
    }
}
