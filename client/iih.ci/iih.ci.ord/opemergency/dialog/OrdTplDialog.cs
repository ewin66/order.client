using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciorder.cards.extend;
using iih.ci.ord.doctorhelper;
using iih.ci.ord.doctorhelper.past.viewmodel;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.form;
using xap.cli.sdk.render;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using xap.sys.devcfg.func.d;

namespace iih.ci.ord.opemergency.dialog
{
    public partial class OrdTplDialog : XSingleDialog
    {
        public OrScArgs Args { get; set; }
        //public OrScArgs Args
        //{
        //    set
        //    {
        //        Args = value;
        //    }
        //    get {  }
        //}
        private XTabControl tabControl;
        private XButton saveButton;
        private XButton cancelButton;
        public OrdTplDialog()
        {
            InitializeComponent();
            this.Size = new Size(1164, 800);
            saveButton = new XButton();
            saveButton.Size = new Size(80, 24);
            saveButton.Text = "确认";
            saveButton.MouseClick += new MouseEventHandler(saveButton_MouseClick);
            cancelButton = new XButton();
            cancelButton.Size = new Size(80, 24);
            cancelButton.Text = "取消";
            cancelButton.MouseClick += new MouseEventHandler(cancelButton_MouseClick);
            this.AddRender_Btn(saveButton, cancelButton);
            this.Load += new EventHandler(OrdTplDialog_Load);
        }
        /// <summary>
        /// 取消 关闭
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void cancelButton_MouseClick(object sender, MouseEventArgs e)
        {
            this.Close();
        }
        /// <summary>
        /// 确认 保存
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void saveButton_MouseClick(object sender, MouseEventArgs e)
        {
            if (tabControl != null)
            {
                if (tabControl.SelectedPage.PageControl != null)
                {
                    foreach (Control control in tabControl.SelectedPage.PageControl.Controls)
                    {  

                        if (control is IViewSave)
                        {
                            (control as IViewSave).SaveData();
                        }
                    }
                }
               
            }
         
            //this.EventSent(this, de);
        }

        void OrdTplDialog_Load(object sender, EventArgs e)
        {
            
            XUserControl xUserControl = new XUserControl();
            xUserControl.Init(Application.StartupPath + "\\modules\\iihci\\ui\\OrderHelper\\Helper.xml");
            xUserControl.Dock = DockStyle.None;
            xUserControl.Location = this.Panel.Location;
            xUserControl.Size = this.Panel.Size;
            this.Panel = xUserControl;
            xUserControl.LoadData();
            Control content = xUserControl.GetControl();
            foreach (Control obj in content.Controls)
            {
                if (obj is XTabControl)
                {
                    tabControl = obj as XTabControl;
                    foreach (XTabPage page in tabControl.XTabPages)
                    {  
                       // Visible(page, tabControl);
                    }
                }
            }
        }
 

        public OrdTplDialog(XapBaseControl owner):this()
        {
            this.Text = "医嘱模板";
            
 
            //this.Panel = 

        }
    }
}
