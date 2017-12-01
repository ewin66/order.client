namespace iih.ci.ord.oporder.view
{
    partial class OpOrderSrvListView
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
            xap.cli.sdk.render.XRenderGroup xRenderGroup1 = new xap.cli.sdk.render.XRenderGroup();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(OpOrderSrvListView));
            this.xapFormControl1 = new xap.rui.control.forms.view.XapFormControl();
            this.button3 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // xapFormControl1
            // 
            //this.xapFormControl1.ActiveRender = null;
            this.xapFormControl1.AutoSize = true;
            ////this.xapFormControl1.AutoValidate = System.Windows.Forms.AutoValidate.EnableAllowFocusChange;
            this.xapFormControl1.Context = null;
            this.xapFormControl1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.xapFormControl1.File = null;
            this.xapFormControl1.IsXapGrid = true;
            this.xapFormControl1.Location = new System.Drawing.Point(0, 0);
            this.xapFormControl1.Name = "xapFormControl1";
            //xRenderGroup1.ActiveRender = null;
            xRenderGroup1.Bound = new System.Drawing.Rectangle(0, 0, 0, 0);
            xRenderGroup1.CanFocus = true;
            xRenderGroup1.Enabled = true;
            //xRenderGroup1.IsContainer = false;
            xRenderGroup1.IsFocus = false;
            //xRenderGroup1.IsRender = false;
            xRenderGroup1.Location = new System.Drawing.Point(0, 0);
            //xRenderGroup1.Next = null;
            //xRenderGroup1.Previous = null;
            xRenderGroup1.Size = new System.Drawing.Size(0, 0);
            xRenderGroup1.TabIndex = 0;
            xRenderGroup1.Tag = null;
            xRenderGroup1.ValueObj = null;
            xRenderGroup1.Visible = true;
            this.xapFormControl1.RenderGroup = xRenderGroup1;
            this.xapFormControl1.Size = new System.Drawing.Size(203, 412);
            this.xapFormControl1.TabIndex = 0;
            this.xapFormControl1.ViewFile = null;
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(49, 444);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(129, 23);
            this.button3.TabIndex = 6;
            this.button3.Text = "测试3";
            this.button3.UseVisualStyleBackColor = true;
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(49, 412);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(129, 26);
            this.button2.TabIndex = 5;
            this.button2.Text = "测试2";
            this.button2.UseVisualStyleBackColor = true;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(49, 375);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(129, 31);
            this.button1.TabIndex = 4;
            this.button1.Text = "测试1";
            this.button1.UseVisualStyleBackColor = true;
            // 
            // OrderSrvListView
            // 
            //this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.xapFormControl1);
            this.Name = "OrderSrvListView";
            this.Size = new System.Drawing.Size(203, 412);
            this.Load += new System.EventHandler(this.OrderSerListView_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private xap.rui.control.forms.view.XapFormControl xapFormControl1;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button1;

    }
}
