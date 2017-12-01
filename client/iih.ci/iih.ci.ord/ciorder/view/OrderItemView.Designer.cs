using System.Windows.Forms;
using xap.cli.sdk.controls;

namespace iih.ci.ord.ciorder.view
{
    partial class OrderItemView
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
            this.xapFormControl1 = new xap.rui.control.forms.view.XapFormControl();
            panel= new XLayoutPanel();
            this.SuspendLayout();
            // 
            // xapFormControl1
            // 
            this.xapFormControl1.AutoSize = true;
            
            panel.Dock = DockStyle.Fill;
            ////this.xapFormControl1.AutoValidate = System.Windows.Forms.AutoValidate.EnableAllowFocusChange;
            //this.xapFormControl1.CanShowing = null;
            this.xapFormControl1.Context = null;
            //this.xapFormControl1.Dock = DockStyle.Fill;
            this.xapFormControl1.File = null;
            this.xapFormControl1.Location = new System.Drawing.Point(0, 0);
            this.xapFormControl1.Name = "xapFormControl1";
            this.xapFormControl1.Size = new System.Drawing.Size(592, 365);
            this.xapFormControl1.TabIndex = 0;
            this.xapFormControl1.ViewFile = null;
            // 
            // OrderItemView
            // 
            ////this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 14F);
            ////this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            //this.Dock = DockStyle.Fill;
            //panel.AddControl(new XBaseControl(), ControlPosition.Right, 1);
            panel.AddControl(this.xapFormControl1,ControlPosition.Center);
            this.AddRender(panel);
            this.Name = "OrderItemView";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private XLayoutPanel panel;
        private xap.rui.control.forms.view.XapFormControl xapFormControl1;
    }
}
