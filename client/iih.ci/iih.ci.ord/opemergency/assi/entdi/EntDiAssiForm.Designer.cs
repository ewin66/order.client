using xap.rui.control.forms.view;
using xap.cli.sdk.form;
using System.Windows.Forms;
namespace iih.ci.ord.opemergency.assi.entdi
{
    partial class EntDiAssiForm
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
            xapFormControl = new XapFormControl();
            xapFormControl.Dock = System.Windows.Forms.DockStyle.Fill;
            this.Controls.Add(xapFormControl);

            this.Text = "诊断辅助录入";
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.StartPosition = FormStartPosition.Manual;
            this.FormBorderStyle = FormBorderStyle.None;
            this.DoReSize = false;
            this.ShowInTaskbar = false;// 设置窗口在任务栏上是否显示图标，弹出窗口不显示图标
            components = new System.ComponentModel.Container();
        }

        private XapFormControl xapFormControl;

        #endregion
    }
}
