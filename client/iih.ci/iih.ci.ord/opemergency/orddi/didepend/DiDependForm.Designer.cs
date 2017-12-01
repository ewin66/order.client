namespace iih.ci.ord.opemergency.orddi.didepend
{
    partial class DiDependForm
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
            this.components = new System.ComponentModel.Container();
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Formsize = xap.cli.sdk.form.FormSize.Large;
            this.Text = "删除诊断判断";

            cancelBtn = new xap.cli.sdk.render.XButton();
            cancelBtn.Size = new System.Drawing.Size(80, 26);
            cancelBtn.Text = "关闭";
            this.AddRender_Btn(cancelBtn);
            this.MouseButton = cancelBtn;
        }
          public xap.cli.sdk.render.XButton cancelBtn;

        #endregion
    }
}