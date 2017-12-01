using xap.cli.sdk.render;
using xap.cli.sdk.controls;
using System.Drawing;
using xap.cli.sdk.render.labelcontrol;
using xap.cli.sdk.render.Items;
using xap.rui.control.forms.view;
namespace iih.ci.ord.ciorder.cards.extend
{
    partial class SkinTestDialog
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
            components = new System.ComponentModel.Container();
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            xapFormControl = new XapFormControl();
            this.Controls.Add(xapFormControl);
            
        }
        private XapFormControl xapFormControl;
        #endregion
    }
}