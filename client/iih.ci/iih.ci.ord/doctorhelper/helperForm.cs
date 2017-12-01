using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using xap.cli.sdk.form;
using xap.cli.sdk.controls.tabControl;
using xap.rui.engine;
using iih.ci.ord.ciorder.cards.extend;
using xap.sys.devcfg.func.d;
using iih.en.pv.dto.d;
using xap.cli.sdk.render;
using iih.ci.ord.doctorhelper.past.viewmodel;
using iih.ci.ord.opemergency.view;
using xap.cli.sdk.controls;

namespace iih.ci.ord.doctorhelper
{
    public partial class helperForm : XSingleDialog
    {
        public OrScArgs Args
        {
            set
            {
                if (View != null)
                {
                    View.Args = value;
                }
                if (view2 != null)
                {
                    view2.Args = value;
                }
               
            }
          
        }
        protected List<PageDO> list;
        public helperView View;
        public AssButtonView view2; 
        public Ent4BannerDTO Ent4BannerDTO { get; set; }
      //  public xap.rui.control.basecontrol.XapBaseControl.Base  context;
        //下边按钮区
        private XButton saveButton;
        private XButton cancelButton;
        private XTabControl tabControl;
        private PastTreeViewModel model;
        public helperForm(AssButtonView view)
        {
            view2 = view;
            InitializeComponent();
            this.Text = "智能助手(开发中)";
            this.Size = new Size(1164, 488);
            this.Formsize = FormSize.ExtraLarge;
            this.Load += new EventHandler(helperForm_Load);
            saveButton = new XButton();
            saveButton.Size = new Size(80, 24);
            saveButton.Text = "确认";
            saveButton.MouseClick += new MouseEventHandler(saveButton_MouseClick);

            cancelButton = new XButton();
            cancelButton.Size = new Size(80, 24);
            cancelButton.Text = "取消";
            cancelButton.MouseClick += new MouseEventHandler(cancelButton_MouseClick);

            this.AddRender_Btn(saveButton, cancelButton);
        }
        public helperForm(helperView view)
        {
            View = view;
            InitializeComponent();
            this.Text = "智能助手";
            this.Size = new Size(1164, 488);
            this.Formsize = FormSize.ExtraLarge;
            this.Load += new EventHandler(helperForm_Load);
            saveButton = new XButton();
            saveButton.Size = new Size(80, 24);
            saveButton.Text = "确认";
            saveButton.MouseClick += new MouseEventHandler(saveButton_MouseClick);

            cancelButton = new XButton();
            cancelButton.Size = new Size(80, 24);
            cancelButton.Text = "取消";
            cancelButton.MouseClick += new MouseEventHandler(cancelButton_MouseClick);

            this.AddRender_Btn(saveButton,cancelButton);
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
            HelperViewModel model = new HelperViewModel(null,null,null);

            this.list = model.pageList.ToList();
            XUserControl xUserControl = new XUserControl();
            xUserControl.Init("modules\\iihci\\ui\\OrderHelper\\Helper.xml");
            xUserControl.Dock = DockStyle.None;
            xUserControl.Location = this.Panel.Location;
            xUserControl.Padding = new Padding(4);
            xUserControl.Size = this.Panel.Size;
            List<XBaseControl> xBaseCtrlList = xUserControl.GetConfig().GetViews();
            foreach(XBaseControl xBaseCtrl in xBaseCtrlList) {
                BaseHelperView baseHelperView = xBaseCtrl as BaseHelperView;
                if (baseHelperView != null) {
                    baseHelperView.Ent4BannerDTO = Ent4BannerDTO;
                }
            }

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
                        Visible(page, tabControl);
                    }
                }
            }
        }

        protected new void Visible(XTabPage Tab,XTabControl tabParent)
        {
            if (this.list.Count > 0)
            {
                foreach (PageDO TabDO in this.list)
                {
                    if (TabDO.Name == Tab.Text)
                    {
                        Tab.Name = TabDO.Code;
                        //Tab.Parent = tabParent;
                        Tab.Visible = true;
                    }
                    if (Tab.Text == "患者既往")
                    {
                        if (this.Ent4BannerDTO != null && this.Ent4BannerDTO.Id_pat != null)
                        {
                            this.model = new PastTreeViewModel(Ent4BannerDTO.Id_pat);
                        }
                        if (this.model == null || (this.model.ListEntHisDiDTO != null && this.model.ListEntHisDiDTO.Count == 0))
                        {
                            //Tab.Parent = null;
                            Tab.Visible = true;
                        }
                    }
                }
            }
        }

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
