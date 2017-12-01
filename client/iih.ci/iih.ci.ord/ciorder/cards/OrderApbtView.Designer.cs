using System.Windows.Forms;
using xap.cli.sdk.bindings;
namespace iih.ci.ord.ciorder.cards
{
    partial class OrderApbtView
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
            this.xapFormControl = new xap.rui.control.forms.view.XapFormControl();
            this.SuspendLayout();
            this.xapFormControl.Padding = new Padding(0, 4, 0, 0);
            XBindingList bindingList = new XBindingList();
            indicatorControl = new xap.rui.bizcontrol.IndicatorControl.XIndicatorControl();
            indicatorControl.Location = new System.Drawing.Point();
            bindingList.Add(new XBinding("ValueText", "Val_rstrptla"));
            //indicatorControl.BindingList = bindingList;
            indicatorControl.Category = "Val_restrptlab";
            indicatorControl.TitleName = "Name_srv";
            indicatorControl.Type = "Sd_restrptlabtp";
            indicatorControl.ValueString = "Val_rstrptla";
            indicatorControl.Unit = "Name_unit";

            System.Collections.Generic.Dictionary<string, System.Windows.Forms.Control> controls = new System.Collections.Generic.Dictionary<string, System.Windows.Forms.Control>();
            controls.Add("checkitem", indicatorControl);

            // 
            // xapFormControl1
            // 
            this.xapFormControl.AutoSize = true;
            //this.xapFormControl.AutoValidate = System.Windows.Forms.AutoValidate.EnableAllowFocusChange;
            //this.xapFormControl1.CanShowing = null;
            this.xapFormControl.Context = null;
            this.xapFormControl.Dock = System.Windows.Forms.DockStyle.Fill;
            this.xapFormControl.File = null;
            this.xapFormControl.Location = new System.Drawing.Point(0, 0);
            this.xapFormControl.Name = "xapFormControl";
            this.xapFormControl.Size = new System.Drawing.Size(592, 365);
            this.xapFormControl.TabIndex = 0;
            this.xapFormControl.ViewFile = null;
            this.xapFormControl.RegisterControl(controls);

            components = new System.ComponentModel.Container();
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Size = new System.Drawing.Size(573, 468);
            this.AddRender(xapFormControl);
            this.Name = "OrderApbtView";
            this.ResumeLayout(false);
            this.PerformLayout();
 
        }

        #endregion

        private xap.rui.control.forms.view.XapFormControl xapFormControl;
    }
}
