namespace iih.ci.ord.medicaresharing
{
    partial class MedicalSharingInfoForm
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
            this.Text = "医保共享信息";
            this.Formsize = xap.cli.sdk.form.FormSize.Large;
            confirmBtn = new xap.cli.sdk.render.XButton();
            confirmBtn.Size = new System.Drawing.Size(80, 26);
            confirmBtn.Text = "自费";
            this.AddRender_Btn(confirmBtn);
            this.MouseButton = confirmBtn;
            cancelBtn = new xap.cli.sdk.render.XButton();
            cancelBtn.Size = new System.Drawing.Size(80, 26);
            cancelBtn.Text = "放弃";
            this.AddRender_Btn(cancelBtn);
        }
        public xap.cli.sdk.render.XButton confirmBtn;
        public xap.cli.sdk.render.XButton cancelBtn;
        #endregion
    }
}