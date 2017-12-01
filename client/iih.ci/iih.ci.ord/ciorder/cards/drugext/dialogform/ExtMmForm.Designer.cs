using xap.cli.sdk.render;
using xap.cli.sdk.controls;
using System.Drawing;
namespace iih.ci.ord.ciorder.cards.extend
{
    partial class ExtMmForm
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
            this.orCom = new XBaseControl();
            orCom.Size = new System.Drawing.Size(450, 75);
            saveButton = new XButton();
            saveButton.Size = new System.Drawing.Size(75, 25);
            saveButton.Location = new Point(150, 0);
            saveButton.Text = "确认";
            this.orCom.AddRender(saveButton);
            cancelButton = new XButton();
            cancelButton.Size = new System.Drawing.Size(75, 25);
            cancelButton.Location = new Point(245, 0);
            cancelButton.Text = "取消";
            this.orCom.AddRender(cancelButton);
            splitContainer1 = new XLayoutPanel();
            this.splitContainer1.Size = new System.Drawing.Size(475, 190);
            this.Text = "MmForm";
            
        }
        private XButton saveButton;
        private XButton cancelButton;
        public XLayoutPanel splitContainer1;
        public XBaseControl orCom;
        #endregion
    }
}