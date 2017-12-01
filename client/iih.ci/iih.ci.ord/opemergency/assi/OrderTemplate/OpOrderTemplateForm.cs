using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using xap.cli.sdk.form;
using xap.cli.sdk.controls.tabControl;
using xap.rui.engine;
using iih.ci.ord.ciorder.cards.extend;
using iih.ci.ord.doctorhelper;
using xap.sys.devcfg.func.d;
using iih.en.pv.dto.d;
using xap.cli.sdk.render;
using iih.ci.ord.doctorhelper.past.viewmodel;
using iih.ci.ord.opemergency.view;
using iih.bd.bc.udi;
using iih.ci.ord.opemergency.tool;
using xap.mw.coreitf.d;
using xap.rui.control.basecontrol;

namespace iih.ci.ord.opemergency.assi.OrderTemplate
{
    public partial class OpOrderTemplateForm : XSingleDialog
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
        public event MouseEventHandler SaveClick;
        public AssButtonView view;
        public int SelectedIndex = 0;
        // public Ent4BannerDTO patDo = new Ent4BannerDTO();
        //  public xap.rui.control.basecontrol.XapBaseControl.Base  context;
        //下边按钮区
        private XButton saveButton;
        private XButton cancelButton;
        private XTabControl tabControl;
        //private PastTreeViewModel model;
        public OpOrderTemplateForm(AssButtonView Buttonview, int Index)
        {
            view = Buttonview;
            this.SelectedIndex = Index;

            InitializeComponent();
            this.Text = "医嘱模板";
            this.Size = new Size(500, 700);
            this.Formsize = FormSize.Large;
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
                    foreach (Control control in tabControl.SelectedPage.PageControl.Controls)
                    {
                        if (control is IViewSave)
                        {
                            (control as IViewSave).SaveData();
                        }
                    }
                }
            }
            if (SaveClick != null)
            {
                SaveClick(null, e);
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
            xUserControl.Init(Application.StartupPath + "\\modules\\iihci\\ui\\opordertemplate\\Helper.xml");
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
                    if (tabControl.XTabPages.Count > 2)
                    {
                        tabControl.SelectedIndex = SelectedIndex;
                    }
                    //foreach (XTabPage page in tabControl.XTabPages)
                    //{
                    //    if (page.TabIndex == 2)
                    //    {
                    //        page.IsSelected = FBoolean.True;
                    //    }
                    //    // Visible(page, tabControl);
                    //}
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

