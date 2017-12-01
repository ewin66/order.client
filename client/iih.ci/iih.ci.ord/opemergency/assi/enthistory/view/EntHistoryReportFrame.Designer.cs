using xap.rui.control.forms.view;
namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    partial class EntHistoryReportFrame
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.xapFormControl = new XapFormControl();
            this.SuspendLayout();

            //
            // xapFormControl
            //
            this.xapFormControl.Dock = System.Windows.Forms.DockStyle.Fill;

            // 
            // EntHistoryReportFrame
            // 
            //this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 262);
            this.Name = "EntHistoryReportFrame";
            this.Text = "EntHistoryReportFrame";

            this.Controls.Add(xapFormControl);
            this.Load += new System.EventHandler(EntHistoryReportFrame_Load);
            this.ResumeLayout(false);

        }



        private XapFormControl xapFormControl;

        #endregion

    }
}