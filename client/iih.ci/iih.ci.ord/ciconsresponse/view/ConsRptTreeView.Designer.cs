namespace iih.ci.ord.ciconsresponse.view
{
    partial class ConsRptTreeView
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
            xap.rui.control.tree.options.FocusOptions focusOptions1 = new xap.rui.control.tree.options.FocusOptions();
            this.oTree = new xap.rui.control.tree.otree.OTree();
            this.SuspendLayout();
            // 
            // oTree
            // 
            //this.oTree.ActiveRender = null;
            this.oTree.BackColor = System.Drawing.Color.White;
            this.oTree.Dock = System.Windows.Forms.DockStyle.Fill;
            focusOptions1.NodeFocusOnRefresh = xap.rui.control.tree.options.FocusOnRefreshMode.KeepFocus;
            this.oTree.FocusOption = focusOptions1;
            this.oTree.Location = new System.Drawing.Point(0, 0);
            this.oTree.Name = "oTree";
            this.oTree.ShowCheckBox = false;
            this.oTree.Size = new System.Drawing.Size(591, 345);
            this.oTree.TabIndex = 0;
            // 
            // IntermediateQcTree
            // 
            //this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.oTree);
            this.Name = "ConsRptTree";
            this.Size = new System.Drawing.Size(591, 345);
            this.ResumeLayout(false);

            components = new System.ComponentModel.Container();
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
        }

        private xap.rui.control.tree.otree.OTree oTree;
        #endregion
    }
}
