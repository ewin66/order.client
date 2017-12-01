using System.Windows.Forms;
using xap.rui.control.tree.otree;

namespace iih.ci.ord.cilab.view
{
    partial class LabDateTree
    {
        /// <summary> 
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        private OTree otree;

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
            this.otree = new xap.rui.control.tree.otree.OTree();
            this.treeView1 = new System.Windows.Forms.TreeView();
            this.SuspendLayout();
            // 
            // otree
            // 
            //this.otree.ActiveRender = null;
            //this.otree.AutoScaleDimensions = new System.Drawing.SizeF(0F, 0F);
            //this.otree.AutoScaleMode = System.Windows.Forms.AutoScaleMode.None;
            //this.otree.AutoValidate = System.Windows.Forms.AutoValidate.Disable;
            this.otree.BackColor = System.Drawing.Color.White;
            this.otree.Dock = System.Windows.Forms.DockStyle.Fill;
            focusOptions1.NodeFocusOnRefresh = xap.rui.control.tree.options.FocusOnRefreshMode.KeepFocus;
            this.otree.FocusOption = focusOptions1;
            this.otree.Location = new System.Drawing.Point(0, 0);
            this.otree.Name = "otree";
            this.otree.ShowCheckBox = false;
            this.otree.Size = new System.Drawing.Size(290, 166);
            this.otree.TabIndex = 0;
            // 
            // treeView1
            // 
            this.treeView1.LineColor = System.Drawing.Color.Empty;
            this.treeView1.Location = new System.Drawing.Point(0, 0);
            this.treeView1.Name = "treeView1";
            this.treeView1.Size = new System.Drawing.Size(121, 97);
            this.treeView1.TabIndex = 0;
            // 
            // LabDateTree
            // 
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.otree);
            this.ResumeLayout(false);

        }

        #endregion

        private TreeView treeView1;
    }
}
