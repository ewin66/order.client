using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.render.labelcontrol;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.form;

namespace iih.ci.ord.ciorder.cards.extend
{
    public partial class FrmSkinTest : XDialog
    {
        public FrmSkinTest()
        {
            InitializeComponent();
            //CreatUI();
        }

        XRadiobox radio = new XRadiobox() {Size=new Size(100,30),  Text="测试"};
        XLabelTextBox txt = new XLabelTextBox() {Size=new Size(100,30),Location=new Point(30,50) };

        //private void CreatUI()
        //{
        //    this.SuspendLayout();
        //    this.AddRender(radio);
        //    this.AddRender(txt);
        //    this.Panel.Controls.Add(radio);

        //    this.ResumeLayout(false);
        //}
        private void FrmSkinTest_Load(object sender, EventArgs e)
        {
           
        }
        public string ShowSkinTest()
        {
             OrSkinTest or = new OrSkinTest();
             or.btnOkClick += new EventHandler(or_btnOkClick);
            this.Panel = or;
            this.ShowDialog();
            return or.SkinTestInfo();
        }

        void or_btnOkClick(object sender, EventArgs e)
        {
            this.DialogResult = System.Windows.Forms.DialogResult.OK;
        }
        
    }
}
