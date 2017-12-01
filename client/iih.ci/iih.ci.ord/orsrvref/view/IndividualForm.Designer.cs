using xap.rui.control.basecontrol;
using System.Windows.Forms;
using System.Collections.Generic;
namespace iih.ci.ord.orsrvref.view
{
    partial class IndividualForm
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
            this.personalListView = new System.Windows.Forms.ListView();
            this.SuspendLayout();
            // 
            // personalListView
            // 
            this.personalListView.CheckBoxes = true;
            this.personalListView.Dock = System.Windows.Forms.DockStyle.Fill;
            this.personalListView.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.None;
            this.personalListView.Location = new System.Drawing.Point(0, 0);
            this.personalListView.Name = "personalListView";
            this.personalListView.Size = new System.Drawing.Size(185, 379);
            this.personalListView.TabIndex = 0;
            this.personalListView.UseCompatibleStateImageBehavior = false;
            this.personalListView.ItemCheck += new System.Windows.Forms.ItemCheckEventHandler(this.personalListView_ItemCheck);
            this.personalListView.ItemChecked += new System.Windows.Forms.ItemCheckedEventHandler(this.personalListView_ItemChecked);
            // 
            // IndividualForm
            // 
            //this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(185, 379);
            this.Controls.Add(this.personalListView);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "IndividualForm";
            this.Text = "IndividualForm";
            this.Deactivate += new System.EventHandler(this.IndividualForm_Deactivate);
            this.Load += new System.EventHandler(this.IndividualForm_Load);
            this.ResumeLayout(false);

        }

       
        

        

        

        #endregion


        private ListView personalListView;






    }
}