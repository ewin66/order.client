using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.render;
using xap.cli.sdk.controls.SuspendForm;
using xap.cli.sdk.render.Items;
using xap.cli.context.token;
using xap.sys.xbd.udi.d;
using xap.sys.xbd.udi.i;
using xap.mw.serviceframework;
using xap.mw.coreitf.d;
using xap.cli.sdk.controls;
using xap.cli.sdk.form;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.dto.ordinput.d;
using xap.sys.orgfw.dept.d;
using xap.cli.context;
using iih.bd.srv.srvortpl.d;
using iih.bd.srv.srvortplitem.d;
using xap.cli.sdk.common;
using xap.rui.engine;
using xap.rui.engine.registers;
using xap.rui.control.basecontrol;
using iih.ci.ord.ciorder.render;

namespace iih.ci.ord.ciorder.cards
{
    public partial class OrdChildfrm : XDialog,IXEventPublication, IRegister, IXapBaseControl
    {
        public XButton btnOk;
        public XButton btnCancel;
        protected XapBaseControl pannel;
        public event MouseEventHandler btnClick;
        public event MouseEventHandler btnCancelClick;
       // public List<MenuRender> RenderList = new List<MenuRender>();
        public Dictionary<string, OrderRender> SelectOrder = new Dictionary<string, OrderRender>();
        public Dictionary<string, OrderRender> OrderRenderlist = new Dictionary<string, OrderRender>();
        protected List<MenuRender> Menulist = new List<MenuRender>();
        protected OrdInputDto[] first;
        protected SrvOrdTplDO[] Second;
        protected SrvOrTplItemDO[] Thread;
        public bool Twoflag { get; set; }
        private OrdChildfrmModel model;
        MenuRender selectMenu;
        public MenuRender SelectMenu
        {
            get { return selectMenu; }
            set
            {
                if (selectMenu != value)
                {
                    if (selectMenu != null)
                    {
                        selectMenu.IsSelect = false;
                        selectMenu.FontBrush = new SolidBrush(Color.Black);
                        selectMenu.Invalidate();
                    }
                    selectMenu = value;
                    selectMenu.IsSelect = true;
                    selectMenu.FontBrush = new SolidBrush(Color.White);
                    selectMenu.Invalidate();
                }
            }
        }
        Brush selectBrush;
        public Brush SelectBrush
        {
            get { return selectBrush; }
            set { selectBrush = value; }
        }
        Brush moveBrush;

        public Brush MoveBrush
        {
            get { return moveBrush; }
            set { moveBrush = value; }
        }
        private OrderInputRender selectRender;
        public OrderInputRender SelectRender
        {
            get { return selectRender; }
            set
            {
                if (selectRender != value)
                {
                    if (selectRender != null)
                    {
                        selectRender.IsSelect = false;
                    }
                    selectRender = value;
                    selectRender.IsSelect = true;
                    //向模型发起切换请求
                    // nodeChanged();
                }
            }
        }
        public OrdChildfrm()
        {
            xap.mw.serviceframework.NetModule.init();
            
            this.Text = "";
            this.Size = new Size(401, 451);
            //this.TitleHeight = 0;
            this.Location = new Point(100, 10);
           // this.DarkEdgeBrush = new SolidBrush(Color.FromArgb(0, 153, 229));
            Twoflag = false;
            btnOk = new XButton();
            pannel = new XapBaseControl();
            btnOk.Text = "确认";
            btnOk.MouseClick += new MouseEventHandler(btnOk_MouseClick);
            btnOk.Location = new Point(this.Width - btnOk.Size.Width * 2 - 50, this.Size.Height - btnOk.Size.Height - 6);
            btnCancel = new XButton();
            btnCancel.Text = "取消";
            btnCancel.MouseClick += new MouseEventHandler(btnCancel_MouseClick);
            btnCancel.Location = new Point(btnOk.Location.X + btnOk.Size.Width + 25, btnOk.Location.Y);
            pannel.AddRender(btnOk);
            pannel.AddRender(btnCancel);
            pannel.SizeChanged += new EventHandler(pannel_SizeChanged);
          //  this.MouseClick += new MouseEventHandler(OrdChildfrm_MouseClick);
            pannel.Dock = DockStyle.Fill;
            pannel.MouseClick += new MouseEventHandler(pannel_MouseClick);
            pannel.Paint += new PaintEventHandler(Panel_Paint);
            pannel.BackColor = Color.FromArgb(240,240,240);
            this.Panel=pannel;
            
            this.model = new OrdChildfrmModel();
            DeptDO dept = UserManager.getInstance().CurrentDept;
            selectBrush = new SolidBrush(Color.FromArgb(0,153,229));
            moveBrush =  new SolidBrush(Color.FromArgb(210,245,255));
            first = this.model.getOrdInputDto(null, null);
           
          //  Thread = this.model.getSrvOrTplItemDO(Second[1].Id_srvortpl);
            loaddata();
        }

        void btnCancel_MouseClick(object sender, MouseEventArgs e)
        { 
            this.Hide();
            if (this.btnCancelClick != null)
            {
                btnCancelClick(sender,e);
            }
        }

        void btnOk_MouseClick(object sender, MouseEventArgs e)
        {
            if (this.btnClick != null)
            {
                this.SelectOrder.Clear();
                foreach (var dic in this.OrderRenderlist)
                {
                    if (dic.Value.Check)
                    {
                        this.SelectOrder.Add(dic.Key,dic.Value);
                    }
                }
                btnClick(sender,e);
            }
        }
        void pannel_MouseClick(object sender, MouseEventArgs e)
        {
        
            for (int i = 0; i < Menulist .Count; i++)
            {
                MenuRender menu = Menulist[i];
                if (menu.Bound.Contains(e.Location))
                {
                    foreach (OrderRender Ur in this.OrderRenderlist.Values)
                    {
                        this.pannel.RemoveRender(Ur);
                    }
                    this.OrderRenderlist.Clear();
                   
                    #region 添加子菜单panel使用
                    if (menu.Contains(e.Location))
                    {
                        UnFoldMenuPanel(i);
                    }
                    #endregion
                    else
                        UpdateContentPanel(menu);
                    if (menu.IsUnfold)
                    {
                foreach (var sub in menu.SubMenuList)
                {
                    if (sub.Value.IsSelect)
                    {
                        foreach (OrderRender Ur in this.OrderRenderlist.Values)
                        {
                            this.pannel.RemoveRender(Ur);
                        }
                        this.OrderRenderlist.Clear();
                        UpdateContentPanel(sub.Value);
                        Thread = Thread = this.model.getSrvOrTplItemDO(sub.Key);
                        //  Dictionary<string,string> dic=new Dictionary<string,string> ();
                        int startX = 85;
                        int startY = 10; 
                        OrderRender TMP = new OrderRender(this);
                        foreach (SrvOrTplItemDO tpl in Thread)
                        {
                            Dictionary<string, string> dic = new Dictionary<string, string>();
                            dic.Add(tpl.Id_srv, tpl.Name_srv);
                            OrderRender ThreadRender = new OrderRender(this);
                           // ThreadRender.Datasource = dic;
                            ThreadRender.Size = new Size(170, 40);
                            if (startX + ThreadRender.Size.Width > this.Size.Width)
                            {
                                startX = 85;
                                startY = TMP.Bound.Bottom;
                            }
                            ThreadRender.Location = new Point(startX, startY);
                            startX += ThreadRender.Size.Width + 5;
                            this.OrderRenderlist.Add(tpl.Id_srv, ThreadRender);
                            this.pannel.AddRender(ThreadRender);
                            TMP = ThreadRender;
                        }
                        this.pannel.Invalidate();
                    }
                }
                }
                    return;
                }
                foreach (var  sub in menu.SubMenuList)
                {

                    if (sub.Value.Bound.Contains(e.Location))
                    {
                        foreach (OrderRender Ur in this.OrderRenderlist.Values)
                        {
                            this.pannel.RemoveRender(Ur);
                        }
                        this.OrderRenderlist.Clear();
                        UpdateContentPanel(sub.Value);
                        Thread = Thread = this.model.getSrvOrTplItemDO(sub.Key);
                      //  Dictionary<string,string> dic=new Dictionary<string,string> ();
                        int startX = 85;
                        int startY = 10;
                        OrderRender TMP = new OrderRender(this);
                        foreach (SrvOrTplItemDO tpl in Thread)
                        {
                            Dictionary<string, string> dic = new Dictionary<string, string>();
                            dic.Add(tpl.Id_srv, tpl.Name_srv);
                            OrderRender ThreadRender = new OrderRender(this);
                           // ThreadRender.Datasource = dic;
                            ThreadRender.Size = new Size(170, 40);
                            if (startX + ThreadRender.Size.Width  > this.Size.Width)
                            {
                                startX = 85;
                                startY= TMP.Bound.Bottom;
                            }
                            ThreadRender.Location = new Point(startX, startY);
                            startX += ThreadRender.Size.Width+5;
                            this.OrderRenderlist.Add(tpl.Id_srv, ThreadRender);
                            this.pannel.AddRender(ThreadRender);
                            TMP = ThreadRender;
                        }
                        this.pannel.Invalidate();
                        return;
                    }
                }
            }
            
        }
        void UpdateContentPanel(MenuRender menu)
        {
            if (selectMenu != menu)
            {
                SelectMenu = menu;
                DictionaryEventArgs args = new DictionaryEventArgs();
                //if (SwitchFuncPage != null)
                //    SwitchFuncPage(menu, args);
                this.Invalidate();
            }
        }
        /// <summary>
        /// 折叠或展开子菜单
        /// </summary>
        /// <param name="index"></param>
        void UnFoldMenuPanel(int index)
        {
            MenuRender unfoldMenu = Menulist[index] as MenuRender;
            if (unfoldMenu.IsUnfold)
            {
                unfoldMenu.IsUnfold = false;
                foreach (MenuRender sub in unfoldMenu.SubMenuList.Values)
                {
                    sub.Visible = false;
                    this.pannel.RemoveRender(sub);
                }
            }
            else
            {
                unfoldMenu.IsUnfold = true;
                foreach (MenuRender sub in unfoldMenu.SubMenuList.Values)
                {
                    sub.Visible = true;
                    this.pannel.AddRender(sub);
                }
            }
            if (index < Menulist.Count - 1)
            {
                int x = 0;
                for (int j = index + 1; j < Menulist.Count; j++)
                {
                    MenuRender t = Menulist[j] as MenuRender;
                    if (Menulist[j - 1].SubMenuList.Count == 0 || !Menulist[j - 1].IsUnfold)
                        t.Location = new Point(x, Menulist[j - 1].Bound.Bottom);
                    else if (Menulist[j - 1].IsUnfold)
                    {
                        int count = Menulist[j - 1].SubMenuList.Count;
                        t.Location = new Point(x, Menulist[j - 1].SubMenuList.Last().Value.Bound.Bottom);
                    }
                    if (t.IsUnfold)
                    {
                        int y = t.Bound.Bottom;
                        foreach (MenuRender sub in t.SubMenuList.Values)
                        {
                            sub.Location = new Point(x, y);
                            y = y + sub.Bound.Height;
                        }
                    }
                }
            }
            pannel.Invalidate();
        }
        protected void loaddata()
        {
            int x = 0; int y = 0;
            foreach(OrdInputDto dto in first)
            {

                MenuRender render = new MenuRender();
                render.Text = dto.Name;
                render.Size = new System.Drawing.Size(84, 24);
                int xx = 0, yy = y + render.Size.Height;
                Second = this.model.getSrvOrdTplDO(dto.Id);
                if (Second != null)
                {
                    render.IsParent = true;
                    foreach (SrvOrdTplDO tpl in Second)
                    {
                        MenuRender render1 = new MenuRender();
                        render1.Text = tpl.Name;
                        render1.Location = new Point(xx, yy);
                        render1.Size = new System.Drawing.Size(render.Size.Width, render.Size.Height);
                       // render1.DownButtonBrush = selectBrush;
                        //render1.MoveButtonBrush = moveBrush;
                       //render1.FontBrush =new SolidBrush( Color.White);
                        yy = render1.Bound.Bottom;
                        render.SubMenuList.Add(tpl.Id_srvortpl,render1);
                    }
                }
                render.Location = new Point(x, y);
                render.DownButtonBrush = selectBrush;
                render.MoveButtonBrush = moveBrush;
                y = render.Bound.Bottom;
                Menulist.Add(render);
                this.pannel.AddRender(render);
            }
           
        }
        void pannel_SizeChanged(object sender, EventArgs e)
        {
            btnOk.Location = new Point(this.pannel.Width - btnOk.Size.Width * 2 - 50, this.pannel.Size.Height - btnOk.Size.Height-2);
            btnCancel.Location = new Point(btnOk.Location.X + btnOk.Size.Width + 25, btnOk.Location.Y);
        }

        void Panel_Paint(object sender, PaintEventArgs e)
        {
           
            //int width = 0;
            //e.Graphics.FillRectangle(new SolidBrush(Color.FromArgb(212,246,255)), new Rectangle(0, 0, 85, this.Height - 35));
            //if (Twoflag)
            //{
            //    e.Graphics.FillRectangle(new SolidBrush(Color.FromArgb(228, 249, 255)), new Rectangle(84, 0, 85, this.Height - 35));
            //    width = 85;
            //}
            e.Graphics.FillRectangle(new SolidBrush(Color.FromArgb(255, 255, 255)), new Rectangle(0, 0, this.Size.Width, this.Height-this.TitleHeight-35 ));
            e.Graphics.DrawLine(new Pen(Color.FromArgb(138, 138, 138)), new Point(84, 0), new Point(84, this.Size.Height-this.TitleHeight- 35));
        }

        //void OrdChildfrm_MouseClick(object sender, MouseEventArgs e)
        //{

        //    foreach (OrderInputRender render in this.RenderList)
        //    {
        //        if (render.Bound.Contains(e.Location) && render.Visible)
        //        {
        //            SelectRender = render;
        //            int StartY = 10;
        //            int StartX = 84;
        //            if (Twoflag)
        //            {
        //                StartX = 84 + 85;
        //            }
        //            foreach (OrderRender Ur in this.OrderRenderlist)
        //            {
        //                this.RemoveRender(Ur);
        //            }
        //            this.OrderRenderlist.Clear();

        //            foreach (OrderRender item in render.Items)
        //            {
        //                item.Size = new System.Drawing.Size(223, item.Size.Height);
        //                item.Location = new Point(StartX, StartY);
        //                StartY = item.Bound.Bottom;
        //                this.AddRender(item);
        //            }
        //        }
        //    }
        //    Invalidate();
        //}


        //public override void AddRender(object obj, string ID)
        //{
        //    if (obj is OrderRender)
        //    {
        //        this.OrderRenderlist.Add(ID, (obj as OrderRender));
        //    }
        //    base.AddRender(obj);
        //}
        public event EventHandler<DictionaryEventArgs> EventSent;
        private void FireEventSent()
        {
            if (EventSent != null)
            {
                EventSent(this, null);
            }
        }
        void Doctoradvice_MouseClick(object sender, MouseEventArgs e)
        {

        }


        public object GetRegister()
        {
            return this;
        }
        public void OnInit()
        {

        }
        public void LoadData()
        {

        }
    }
}
