using xap.rui.control.forms.view;
namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    partial class EntHistoryFrame
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

        protected override void DisposeManaged()
        {
            this.EntHistoryInitEvent.IsEntHistoryFrameOpen = false;
            this.EntHistoryInitEvent.EntpHistoryFrame = null;
            this.EntHistoryInitEvent = null;
            base.DisposeManaged();
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
            this.Text = "辅助录入-就诊历史";
            this.Load += new System.EventHandler(EntpHistoryFrame_Load);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.DoReSize = false;
        }

        XapFormControl xapFormControl;

        #endregion
    }
}