using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciorder.cards.extend;
using iih.ci.ord.doctorhelper;
using iih.ci.ord.doctorhelper.past.viewmodel;
using iih.ci.ord.opemergency.view;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.form;
using xap.cli.sdk.render;
using xap.rui.engine;
using iih.bd.bc.udi;
using iih.en.pv.dto.d;
using iih.ci.ord.opemergency.tool;

namespace iih.ci.ord.opemergency.assi.medsrvclass
{
    public partial class MedsrvClassForm : XSingleDialog
    {
        public OrScArgs Args
        {
            set
            {
                if (view != null)
                {
                    view.Args = value;
                }
            }
        }
       // protected List<PageDO> list;
       
        public AssButtonView view;
       // public Ent4BannerDTO patDo = new Ent4BannerDTO();
      //  public xap.rui.control.basecontrol.XapBaseControl.Base  context;
        //下边按钮区
        private XButton saveButton;
        private XButton cancelButton;
        private XTabControl tabControl;
        //private PastTreeViewModel model;
        public MedsrvClassForm(AssButtonView Buttonview)
        {
            view = Buttonview;
            InitializeComponent();
            this.Text = "医疗服务分类";
            this.Size = new Size(800, 488);
            this.Formsize = FormSize.ExtraLarge;
            this.Load += new EventHandler(helperForm_Load);
            saveButton = new XButton();
            saveButton.Size = new Size(80, 24);
            saveButton.Text = "确定";
            saveButton.MouseClick += new MouseEventHandler(saveButton_MouseClick);

            cancelButton = new XButton();
            cancelButton.Size = new Size(80, 24);
            cancelButton.Text = "取消";
            cancelButton.MouseClick += new MouseEventHandler(cancelButton_MouseClick);

            this.AddRender_Btn(saveButton, cancelButton);
        }

        void saveButton_MouseClick(object sender, MouseEventArgs e)
        {
            if (tabControl != null)
            {
                if (tabControl.SelectedPage.PageControl != null) 
                {
                    foreach(Control control in tabControl.SelectedPage.PageControl.Controls)
                    {
                        if (control is IViewSave)
                       {
                           (control as IViewSave).SaveData();
                       }
                    }
                }
            }
        }

        void cancelButton_MouseClick(object sender, MouseEventArgs e)
        {
            this.Close();
        }
       
        void helperForm_Load(object sender, EventArgs e)
        {
           // HelperViewModel model = new HelperViewModel(null,null,null);

           
            XUserControl xUserControl = new XUserControl();
            xUserControl.Init(Application.StartupPath + "\\modules\\iihci\\ui\\medsrvclass\\Helper.xml");
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

        //protected void Visible(XTabPage Tab,XTabControl tabParent)
        //{
        //    if (this.list.Count > 0)
        //    {
        //        foreach (PageDO TabDO in this.list)
        //        {
        //            if (TabDO.Name == Tab.Text)
        //            {
        //                Tab.Name = TabDO.Code;
        //                //Tab.Parent = tabParent;
        //                Tab.Visible = true;
        //            }
        //            if (Tab.Text == "患者既往")
        //            {
        //                if (this.patDo != null && this.patDo.Id_pat != null)
        //                {
        //                    this.model = new PastTreeViewModel(patDo.Id_pat);
        //                }
        //                if (this.model == null || (this.model.ListEntHisDiDTO != null && this.model.ListEntHisDiDTO.Count == 0))
        //                {
        //                    //Tab.Parent = null;
        //                    Tab.Visible = false;
        //                }
        //            }
        //        }
        //    }
        //}

        //private void helperForm_Load(object sender, EventArgs e)
        //{
        //    XTabControl tabControl = new XTabControl();
        //    for (int i = 0; i < 4; i++)
        //    {

        //        XTabPage tabpage = new XTabPage();
        //        tabpage.Text = "测试+"+i.ToString()+"";
        //        tabpage.Size = new Size(100, 30);
        //        tabControl.XTabPages.Add(tabpage);
        //    }
        //    tabControl.PerformLayouts();
        //    this.Panel = tabControl;
        //}
    }
}
