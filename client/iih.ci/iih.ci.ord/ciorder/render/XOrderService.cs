using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.render.Items;
using System.Drawing;
using System.Windows.Forms;
using xap.cli.sdk.common;
using xap.cli.sdk.controls;
using xap.cli.sdk.layouts;
using System.Drawing.Drawing2D;
using xap.rui.engine.xactions;
using xap.cli.sdk.render;
using System.Reflection;
using xap.sys.xbd.udi.d;
using xap.cli.context.token;
using xap.sys.xbd.udi.i;
using xap.mw.serviceframework;
using xap.mw.coreitf.d;
using iih.ci.ord.ciorder.cards;

namespace iih.ci.ord.ciorder.render
{
    /*

* ==============================================================================
*
* Filename: 树伟
* Description: 
*
* Version: 1.0
* Created: 2015/11/4 15:04:39
* Compiler: Visual Studio 2010
*
* Author: 常树伟
* Company: 北大医信
*
* ==============================================================================
*/
    public class XOrderService : XSearch
    {
        #region Filed 字段


        //protected Image Icon;
        private IUdidocCrudService udidocService;
        public override event EventHandler SelectValueChanged;
        protected new Doctoradvices dropdownForm;
        #endregion


        #region Property 属性
        //private OrderInputRender selectRender;
        //public OrderInputRender SelectRender
        //{
        //    get { return selectRender; }
        //    set
        //    {
        //        if (selectRender != value)
        //        {
        //            if (selectRender != null)
        //            {
        //                selectRender.IsSelect = false;
        //            }
        //            selectRender = value;
        //            selectRender.IsSelect = true;
        //            //向模型发起切换请求
        //            // nodeChanged();
        //        }
        //    }
        //}
        #endregion
        #region 构造函数

        public XOrderService()
        {
            Initialize();
        }
        public XOrderService(Control parentForm)
            : this()
        {
            this.ParentForm = parentForm;
        }

        protected new void Initialize()
        {
            xap.mw.serviceframework.NetModule.init();
           
            udidocService = XapServiceMgr.find<IUdidocCrudService>();
            GetSrvtp();
            //			this.ButtonIcon = Bitmap.FromStream(Shared.AssemblyRes.GetManifestResourceStream("xap.cli.sdk.Resources.菜单栏icon.搜索-02.png"));
        }
        #endregion

        protected override void LoadData()
        {
            if (this.displayNames == null)
                return;

            if (this.displayNames.Count > 0)
            {
                int startY = 1;
                for (int i = 0; i < displayNames.Count; i++)
                {
                    DoctorRender render = new DoctorRender();
                    render.Id = i;
                    render.Location = new Point(0, startY);
                    render.Size = new System.Drawing.Size(75, 24);
                    render.SendMsg += new SendMsgHandler(render_SendMsg);
                    render.Click += new MouseEventHandler(render_MouseClick);
                    //在这里设定各个元素的索引值
                    startY = render.Bound.Bottom;
                    render.Text = displayNames[i];
                    this.dropdownForm.AddRender(render);
                    if (render.Text == "药品")
                    {
                        AddChild(render);
                    }
                }

            }
        }

        void render_MouseClick(object sender, MouseEventArgs e)
        {
            if (sender != null)
            {
                //this.Text = sender.Text;
                //this.ValueCode = sender.ValueCode;
                //sender.Selected = true;
                string oldText = this.SearchText;
                string newText = (sender as DoctorRender).Text;

                //this.ValueText = sender.Text;
                this.newIndex = (sender as DoctorRender).Id;

                string oldValue = datasource[oldIndex].ToString();
                string newValue = datasource[newIndex].ToString();
                ChangingEventArgs args = new ChangingEventArgs(oldValue, newValue);
                if (this.SelectValueChanged != null && newIndex != oldIndex)
                    this.SelectValueChanged(this, new EventArgs());
                if (args.Cancel)
                {
                    this.SelectIndex = (sender as DoctorRender).Id = oldIndex;
                }
                else
                {
                    SelectIndex = oldIndex = newIndex;
                    this.SearchText = (sender as DoctorRender).Text;
                }
                this.dropdownForm.Close();
                this.SelectedItem = datasource[SelectIndex];
                this.Invalidate();
                this.ParentForm.Invalidate();
            }
        }

        void render_SendMsg(DoctorRender sender, List<UserRender> renderlist)
        {
            int startY = 15;
            foreach (UserRender item in dropdownForm.RenderList)
            {
                dropdownForm.RemoveRender(item);
            }
            foreach (UserRender item in dropdownForm.OrderRenderlist)
            {
                dropdownForm.RemoveRender(item);
            }
            dropdownForm.OrderRenderlist.Clear();
            dropdownForm.Twoflag = false;
            foreach (UserRender item in renderlist)
            {
                item.Location = new Point(76, startY);
                startY = item.Bound.Bottom;
                dropdownForm.Twoflag = true;
                if (item is OrderInputRender)
                {
                    OrderInputRender Render = item as OrderInputRender;
                    if (Render.IsSelect)
                    {
                        foreach (OrderRender userreder in Render.Items)
                        {
                            dropdownForm.AddRender(userreder);
                        }
                    }
                }
                dropdownForm.AddRender(item);
            }
            dropdownForm.Invalidate();
        }



        protected new void SetDropDownForm()
        {
            if (datasource.Count < 1)
                return;
            if (this.dropdownForm == null || !this.dropdownForm.Created)
            {
                this.isButtonClick = true;

                this.dropdownForm = new Doctoradvices();
                //this.dropdownForm.IsSwitch = false;
               
                //  this.dropdownForm.Setwidth = (int)this.TextSize.Width + 20;
                //  this.dropdownForm.FormBorderWidth = 1;
                //this.dropdownForm.MaxItemCount = this.dipItemsCout;

                this.dropdownForm.ShowDirection = ShowDirection.Bottom;
                this.dropdownForm.CollisionDecision = CollisionDecision.Screen;
                if (dipItemsCout > 0)
                {
                    //this.dropdownForm.MaxItemCount = dipItemsCout;
                }
                //  this.dropdownForm.MouseClickEvent += new XAPDropDownForm.DepartMenuDelegate(DropDownForm_MouseClick);
                //  this.dropdownForm.Deactivate += new EventHandler(dropdownForm_Deactivate);
                LoadData();

                Point pt = this.ParentForm.PointToScreen(new Point(this.Location.X, this.Location.Y + this.Size.Height));
                dropdownForm.Location = pt;
                dropdownForm.Show();
                this.dropdownForm.Size = new Size(76/*this.ParentForm.Parent.Size.Width - this.Location.X*/, 400/*this.ParentForm.Parent.Size.Height - (this.Size.Height + this.Location.Y)*/);
                this.ParentForm.Invalidate();
            }
        }
        void dropdownForm_Deactivate(object sender, EventArgs e)
        {
            this.dropdownForm.Close();
            dropDownBackgroundBrush = brushCommonBrush;

            isButtonClick = false;

            this.Invalidate();
            //this.
            //throw new NotImplementedException();
        }

        protected override void OnMouseDown(object sender, MouseEventArgs e)
        {
            base.OnMouseDown(sender, e);
            if (new Rectangle(this.TitleRec.Location, new Size(this.TitleRec.Width + 20, this.Bound.Height)).Contains(e.Location))
            {
                SetDropDownForm();
            }
            else
            {
                if (this.dropdownForm != null)
                    this.dropdownForm.Close();
            }
            this.Invalidate();
        }

        protected override void OnMouseMove(object sender, MouseEventArgs e)
        {
            if (new Rectangle(this.Location.X, this.Location.Y, this.Size.Width, this.Size.Height).Contains(e.Location))
            {
                this.IsMoveOn = true;
                this.IsMouseEnterButtonArea = GetButtonRectangle().Contains(e.Location);
            }
          
            // base.OnMouseMove(sender, e);
        }

        protected override void OnMouseLeave(object sender, EventArgs e)
        {
            base.OnMouseLeave(sender, e);

            IsMoveOn = false;
            IsMouseEnterButtonArea = false;

            this.Invalidate();
        }

        protected override void OnMouseClick(object sender, MouseEventArgs e)
        {
            if (GetButtonRectangle().Contains(e.Location))
            {
                rightButtonClick = true;
                this.parent.Refresh();

                OnButtonClick(sender, e);

                rightButtonClick = false;
                this.parent.Invalidate();
            }
            base.OnMouseClick(sender, e);
        }
        private Dictionary<Object, string> srvtps = new Dictionary<object, string>();
        public void GetSrvtp()
        {
            try
            {
                UdidocDO[] udidos = this.udidocService.find("id_udidoclist='0001ZZ2000000000000T' and id_parent='~'", "code", FBoolean.False);
                foreach (UdidocDO udido in udidos)
                {
                    srvtps.Add(udido.Code, udido.Name);

                }
                this.DataSource = srvtps;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }
        protected void AddChild(DoctorRender render)
        {
            OrderInputRender radio = new OrderInputRender();
            //  radio.BackColor = Color.White;
            radio.Size = new System.Drawing.Size(85, 24);
           // radio.MouseClick += new MouseEventHandler(radio_MouseClick);
            radio.MenuLevel = 0;
            radio.Text = "常用液体";
            this.AddChild(radio);

            OrderInputRender radio2 = new OrderInputRender();
            radio2.Size = new System.Drawing.Size(85, 24);
            // radio2.MouseClick += new MouseEventHandler(radio_MouseClick);
            radio2.MenuLevel = 0;
            radio2.Text = "常用片剂";

            OrderInputRender radio3 = new OrderInputRender();
            radio3.Size = new System.Drawing.Size(85, 24);
            //   radio3.MouseClick += new MouseEventHandler(radio_MouseClick);
            radio3.MenuLevel = 0;
            radio3.Text = "草药";
            render.Add(radio);
            render.Add(radio2);
            render.Add(radio3);
        }
        protected void AddChild(OrderInputRender render)
        {
            for (int i = 0; i < 10;i++ )
            {
                Dictionary<string,string> list=new Dictionary<string,string> ();
                list.Add("010101","葡萄糖注射针");
                list.Add("010102", "葡萄糖注射针啊啊");
                list.Add("010103", "葡萄糖注葡萄糖注射针");
                //OrderRender group1 = new OrderRender(this);
              //  group1.Size = new System.Drawing.Size(80, 10);
               // group1.Location = new Point(30, 15);
               // group1.Datasource = list;
               // render.Add(group1);
            }
        }
        #region ILayoutable接口实现

        private Size min = Size.Empty;
        private Size pref = Size.Empty;
        private Size max = Size.Empty;
        private int prefLength = 8;
        private LayoutPreferredSizeMode mode = LayoutPreferredSizeMode.FIXED_SIZE;
        private LayoutPreferredSizeTime time = LayoutPreferredSizeTime.ON_REQUEST;
        private float alignx = LayoutAlignment.LEFT;
        private float aligny = LayoutAlignment.CENTER;
        private static Size borderOffset = new Size(35, 8);
        private Size lastSize;

        public override Size LayoutMinimumSize
        {
            get
            {
                if (min == Size.Empty)
                {
                    Size s;
                    using (var g = new Control().CreateGraphics())
                    {
                        int temp_Width = LayoutMeasure.MeasureDisplayString(g, "#", Font).ToSize().Width;
                        int temp_Height = Font.Height;
                        s = new Size(temp_Width, temp_Height);
                    }
                    return s + borderOffset;
                }
                else
                {
                    return min;
                }
            }
            set
            {
                min = value;
            }
        }

        public override Size LayoutPreferredSize
        {
            get
            {
                if (pref == Size.Empty)
                {
                    return calculatePrefSize() + borderOffset;
                }
                else
                {
                    return pref;
                }
            }
            set
            {
                pref = value;
            }
        }

        private Size calculatePrefSize()
        {
            switch (mode)
            {
                case LayoutPreferredSizeMode.FIXED_SIZE:
                    return calculateSizeByLength();
                default:
                    return lastSize;
            }
        }

        private Size calculateSizeByLength()
        {
            var sb = new StringBuilder();
            Size s;
            sb.Append('#', prefLength);
            using (var g = new Control().CreateGraphics())
            {
                int temp_Width = LayoutMeasure.MeasureDisplayString(g, sb.ToString(), Font).ToSize().Width;
                int temp_Height = Font.Height;
                s = new Size(temp_Width, temp_Height);
            }
            return s;
        }

        public override Size LayoutMaximumSize
        {
            get
            {
                if (max == Size.Empty)
                {
                    return new Size(Int32.MaxValue,
                                    LayoutPreferredSize.Height);
                }
                else
                {
                    return max;
                }
            }
            set
            {
                max = value;
            }
        }

        public override float AlignmentX
        {
            get
            {
                return alignx;
            }
            set
            {
                if (value < 0.0 || value > 1.0)
                {
                    throw (new ArgumentOutOfRangeException(
                           "AlignmentX must be a value between 0.0 and 1.0"));
                }
                alignx = value;
            }
        }

        public override float AlignmentY
        {
            get
            {
                return aligny;
            }
            set
            {
                if (value < 0.0 || value > 1.0)
                {
                    throw (new ArgumentOutOfRangeException(
                           "AlignmentY must be a value between 0.0 and 1.0"));
                }
                aligny = value;
            }
        }

        protected new void OnFontChanged()
        {
            if (time == LayoutPreferredSizeTime.ON_DATACHANGE ||
                time == LayoutPreferredSizeTime.PROGRAMMATIC)
            {
                lastSize = calculatePrefSize();
            }
        }

        /// <summary>Sets or reads the mode for calculating
        /// the preferred size of the LayoutComboBox.</summary>
        /// <value>The <see cref="LayoutPreferredSizeMode">mode</see> to use.
        /// </value>
        public override LayoutPreferredSizeMode LayoutPreferredMode
        {
            get
            {
                return mode;
            }
            set
            {
                mode = value;
            }
        }
        /// <summary>The time when to recalculate the preferred
        /// size of the LayoutComboBox.</summary>
        /// <value>The <see cref="LayoutPreferredSizeTime">time</see> to use.
        /// </value>
        public override LayoutPreferredSizeTime LayoutPreferredTime
        {
            get
            {
                return time;
            }
            set
            {
                time = value;
            }
        }
        /// <summary>The number of hash characters for calculating
        /// the preferred size of the LayoutComboBox.</summary>
        /// <remarks>This value is only used in the mode
        /// <see cref="LayoutPreferredSizeMode.FIXED_SIZE">FIXED_SIZE</see>.
        /// </remarks>
        /// <value>Number of hash characters.</value>
        public override int LayoutPreferredLength
        {
            get
            {
                return prefLength;
            }
            set
            {
                prefLength = value;
            }
        }

        #endregion
    }
}