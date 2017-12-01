using System.Drawing;
using System.Windows.Forms;
using xap.rui.control.forms.view;

namespace iih.ci.ord.ciorder.cards
{
    partial class OrdApBuView
    {
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
            this.xapFormControl=new XapFormControl();
            components = new System.ComponentModel.Container();
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Size=new Size(500,500);
            this.xapFormControl.Dock=DockStyle.Fill;
            this.xapFormControl.Padding = new Padding(0, 4, 0, 0);
            this.AddRender(this.xapFormControl);
        }

        #endregion
    }
}
