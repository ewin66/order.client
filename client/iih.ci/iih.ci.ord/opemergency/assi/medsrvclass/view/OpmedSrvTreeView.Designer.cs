namespace iih.ci.ord.opemergency.assi.medsrvclass.view
{
    partial class OpmedSrvTreeView
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
            this.oTree1 = new xap.rui.control.tree.otree.OTree();
            this.SuspendLayout();
            // 
            // oTree1
            // 
            //this.oTree1.Appearance.BackColor = System.Drawing.Color.White;
            //this.oTree1.Appearance.Options.UseBackColor = true;
            this.oTree1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.oTree1.FocusedNode = null;
            this.oTree1.FocusedUserObject = null;
            this.oTree1.Location = new System.Drawing.Point(0, 0);
            this.oTree1.Name = "oTree1";
            this.oTree1.Size = new System.Drawing.Size(323, 299);
            this.oTree1.TabIndex = 0;
            // 
            // MedsrvTreeView
            // 
            //this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.oTree1);
            this.Name = "OpMedsrvTreeView";
            this.Size = new System.Drawing.Size(323, 299);
            this.ResumeLayout(false);
        }

        #endregion
    }
}
