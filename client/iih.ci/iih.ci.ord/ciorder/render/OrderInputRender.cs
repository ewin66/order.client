using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;
using xap.cli.sdk.common;
using xap.rui.engine.xactions;
using xap.cli.sdk.render;
using System.Reflection;


namespace iih.ci.ord.ciorder.render
{
    /*

* ==============================================================================
*
* Filename: 树伟
* Description: 
*
* Version: 1.0
* Created: 2015/11/4 10:24:21
* Compiler: Visual Studio 2010
*
* Author: 常树伟
* Company: 北大医信
*
* ==============================================================================
*/
    public class OrderInputRender : SelectRender
    {
        #region 常量
        /// <summary>
        /// 行高，包括边框在内
        /// </summary>
        private const float cellHeight = 30F;
        #endregion

        #region 成员变量

        /// <summary>
        /// 从什么位置开始画,X坐标
        /// </summary>
        private float left;
        private float top;//Y坐标
        private const float colSpace = 10F;//每一列左右多出10像素

        /// <summary>
        /// 
        /// </summary>
        //private Rectangle bounds;//render的区域

        /// <summary>
        /// menu的级别，0-是二级模块，1-分类，2-三级功能点
        /// </summary>
        private int menuLevel;
        private Font font;//0、1级别菜单的字体
        private Font itemFont;//2级菜单字体
        private String text;//菜单名字
        private TextRender textRender;//菜单render

        internal TextRender TextRender
        {
            get { return textRender; }
            set { textRender = value; }
        }
        private Brush textBrush;//0、2级字体颜色
        private Brush menuTitleBrush;//1级字体颜色
        private int menuItemLeft;//2级菜单的左边距
        //private int menuTitleLeft;//1级菜单的左边距
        private Point location;//render位置
        private int width;//0级render的宽度
        private int height;//1级render的高度
        private int itemWidth;//2级render宽度
        private int itemHeight;//2级render高度
        private List<UserRender> items = new List<UserRender>();
        //   private xap.sys.devcfg.func.d.MenuItem menuItem;//render对应的菜单信息

        //private bool selected;//是否选中
        private bool isMoveOn;//鼠标是否移动到该render上
        private bool isMarked;//是否已创建快捷菜单
        #endregion

        #region 构造及初始化

        public OrderInputRender()
        {
            Initialize();
        }

        private void Initialize()
        {
            this.top = 15;
            this.left = 19;
            this.height = 39;
            this.width = 160;
            this.itemHeight = 31;
            this.itemWidth = 238;
            this.textBrush = SkinFactory.Instance().CurrentSkin.MenuViewMain_Fore_Brush;
            this.menuTitleBrush = SkinFactory.Instance().CurrentSkin.MenuViewChild_Title_Brush;
            this.menuItemLeft = 20;
            //this.menuTitleLeft = 20;
            this.font = new Font("微软雅黑", 12F, GraphicsUnit.Pixel);
            this.itemFont = new Font("微软雅黑", 10);
            // this.menuItem = new xap.sys.devcfg.func.d.MenuItem();
            //this.selected = false;
            this.isMoveOn = false;
            this.isMarked = false;
            this.textRender = new TextRender();
        }

        #endregion
        protected override void OnMouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (this.Bound.Contains(e.Location))
            {
                IsSelect = true;
            }
            else
                IsSelect = false;
            base.OnMouseClick(sender, e);
        }
        protected override void OnMouseMove(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (this.Bound.Contains(e.Location))
            {
                isMoveOn = true;
            }
            else
            {
                isMoveOn = false;
            }
            this.Invalidate();
            base.OnMouseMove(sender, e);
        }
        protected override void OnMouseLeave(object sender, EventArgs e)
        {
            isMoveOn = false;
            this.Invalidate();
            base.OnMouseLeave(sender, e);
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="g"></param>


        public void DoMenuRendering(System.Drawing.Graphics g)
        {
            if (this.MenuLevel == 0)
            {
                SizeF textSize = g.MeasureString(this.Text, this.Font);
                string imgSrc = "iih.ci.ord.Resources.蓝-01.png";
                Image img = Bitmap.FromStream(Assembly.GetCallingAssembly().GetManifestResourceStream(imgSrc));
                float startX = this.mouseBound.X + 10;
                float startY = (float)this.mouseBound.Y + (this.mouseBound.Height - img.Height) / 2;
                float startY2 = (float)this.mouseBound.Y + (this.mouseBound.Height - textSize.Height) / 2;

                g.DrawImage(img, new PointF(startX, startY));
                g.DrawString(this.Text, font, SkinFactory.Instance().CurrentSkin.MenuViewMain_Fore_Brush, startX + img.Width + 2, startY2);

                Pen pen = SkinFactory.Instance().CurrentSkin.NaviMenu_SplitLine_Pen;
                Point p1 = new Point(this.mouseBound.Left, this.mouseBound.Bottom);
                Point p2 = new Point(this.mouseBound.Right-1, this.mouseBound.Bottom);
               // g.DrawLine(pen, p1, p2);
            }
            else if (this.MenuLevel == 1)
            {
                SizeF textSize = g.MeasureString(this.Text, this.Font);
                float startX = (float)this.mouseBound.X;//(this.mouseBound.Width - textSize.Width) / 2;
                float startY = (float)this.mouseBound.Y + (this.mouseBound.Height - textSize.Height) / 2;
                g.DrawString(this.Text, font, SkinFactory.Instance().CurrentSkin.MenuViewChild_Title_Brush, startX, startY);
            }
            else if (this.MenuLevel == 2)
            {
                SizeF textSize = g.MeasureString(this.Text, this.itemFont);
                float startX = (float)this.mouseBound.X + menuItemLeft;
                float startY = (float)this.mouseBound.Y + (this.mouseBound.Height - textSize.Height) / 2;

                StringFormat format = new StringFormat();
                format.Trimming = StringTrimming.EllipsisCharacter;
                textRender.ForeBrush = SkinFactory.Instance().CurrentSkin.MenuViewMain_Fore_Brush;
                textRender.Font = this.itemFont;
                textRender.Name = this.Text;
                textRender.Render(g);
               // g.DrawString(this.Text, this.itemFont, textBrush, new RectangleF(startX,startY,this.Bound.Right - 30 -startX,textSize.Height),format);
            }
        }
        public void Add(UserRender render)
        {
            this.Items.Add(render);
        }
        public override void Render(Graphics g)
        {
            if (isMoveOn)
            {
                DoRenderingWidhMoveEnter(g);
            }
            if (IsSelect)
            {
                DoRenderingWidhSelected(g);
            }
            if (isMarked)
            {
                DoRenderingWidhMark(g);
            }
            DoMenuRendering(g);
            // g.DrawRectangle(new Pen(Color.Red),this.Bound);
           // base.Render(g);
        }
        public void DoRendering(System.Drawing.Graphics g)
        {
            if (isMoveOn)
            {
                DoRenderingWidhMoveEnter(g);
            }
            else
            {

            }
            if (IsSelect)
            {
                DoRenderingWidhSelected(g);
            }
            if (isMarked)
            {
                DoRenderingWidhMark(g);
            }
            DoMenuRendering(g);
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="g"></param>
        public void DoRenderingWidhSelected(System.Drawing.Graphics g)
        {
            if (this.MenuLevel != 1)
            {
                if (menuLevel == 0)
                {
                    //g.FillRectangle(PaintToolBox.selectedBrush, this.mouseBound);
                    g.FillRectangle(new SolidBrush(Color.FromArgb(255, 255, 255)), this.mouseBound);

                    SizeF textSize = g.MeasureString(this.Text, this.Font);
                    string imgSrc = "iih.ci.ord.Resources.蓝-02.png";
                    Image img = Bitmap.FromStream(Assembly.GetCallingAssembly().GetManifestResourceStream(imgSrc));
                    float startX = this.mouseBound.X + 10;
                    float startY = (float)this.mouseBound.Y + (this.mouseBound.Height - img.Height) / 2;

                    g.DrawImage(img, new PointF(startX, startY));
                }
                else if (menuLevel == 2)
                {
                    //g.FillRectangle(PaintToolBox.itemSelectedBrush, this.mouseBound);
                    g.FillRectangle(SkinFactory.Instance().CurrentSkin.MenuViewChild_Select_Back_Brush, this.mouseBound);
                    DoRenderingWidhFloatMark(g);
                }
            }
        }

        /// <summary>
        /// 描绘分割线
        /// </summary>
        /// <param name = "g"></param>
        public void DoRenderingWithSplitLine(System.Drawing.Graphics g)
        {
            //Pen pen = new Pen(PaintToolBox.SolidBrush7, 2);
            Pen pen = SkinFactory.Instance().CurrentSkin.MenuViewChild_SplitLine_Pen;// new Pen(SkinFactory.Instance().CurrentSkin.MenuViewChild_SplitLine_Brush, 2);
            Point startP = new Point((this.mouseBound.Right + Convert.ToInt32(this.Left)), Convert.ToInt32(this.Top));
            Point endP = new Point((this.mouseBound.Right + Convert.ToInt32(this.Left)), this.mouseBound.Bottom);
            g.DrawLine(pen, startP, endP);
        }

        /// <summary>
        /// 描绘浮动mark
        /// </summary>
        /// <param name = "g"></param>
        public void DoRenderingWidhMoveEnter(System.Drawing.Graphics g)
        {
            if (this.MenuLevel != 1)
            {
                if (menuLevel == 0)
                {
                    //g.FillRectangle(PaintToolBox.moveBrush, this.mouseBound);
                    g.FillRectangle(SkinFactory.Instance().CurrentSkin.MenuViewMain_Hover_Brush, this.mouseBound);
                }
                else if (menuLevel == 2)
                {
                    //g.FillRectangle(PaintToolBox.itemMoveBrush, this.mouseBound);
                    g.FillRectangle(SkinFactory.Instance().CurrentSkin.MenuViewChild_Hover_Brush, this.mouseBound);
                    DoRenderingWidhFloatMark(g);
                    this.textRender.IsMoveOn = true;
                    //if (!this.textRender.timer.Enabled)
                    {
                        this.textRender.StartRolling();
                    }
                }
            }
        }

        /// <summary>
        /// 描绘浮动mark
        /// </summary>
        /// <param name = "g"></param>
        public void DoRenderingWidhMark(System.Drawing.Graphics g)
        {
            // Image img = Bitmap.FromStream(Shared.AssemblyRes.GetManifestResourceStream("xap.cli.Resources.indicatoricon.五星-02.png"));
            //    float startY = (float)this.mouseBound.Y + (this.mouseBound.Height - img.Height) / 2;
            //  g.DrawImage(img, new PointF(this.mouseBound.Right - 26, startY));
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="g"></param>
        /// <param name="isMarked"></param>
        public void DoRenderingWidhFloatMark(System.Drawing.Graphics g)
        {
            //   Image img = Bitmap.FromStream(Shared.AssemblyRes.GetManifestResourceStream("xap.cli.Resources.indicatoricon.五星-01.png"));
            // float startY = (float)this.mouseBound.Y + (this.mouseBound.Height - img.Height) / 2;

            //  g.DrawImage(img, new PointF(this.mouseBound.Right - 26, startY));
        }

        #region 属性
        public float Left
        {
            get { return left; }
            set { left = value; }
        }

        public float Top
        {
            get { return top; }
            set { top = value; }
        }

        public float CellHeight
        {
            get { return cellHeight; }
        }

        public float ColSpace
        {
            get { return colSpace; }
        }

        //public Brush SelectedBrush {
        //    get { return PaintToolBox.selectedBrush; }
        //    set { PaintToolBox.selectedBrush = value; }
        //}
        public List<UserRender> Items
        {
            get { return items; }
            set { items = value; }
        }
        public String Text
        {
            get { return text; }
            set { text = value; }
        }

        public int MenuLevel
        {
            get { return menuLevel; }
            set { menuLevel = value; }
        }

        public Font Font
        {
            get { return font; }
            set { font = value; }
        }

        public Brush TextBrush
        {
            get { return textBrush; }
            set { textBrush = value; }
        }

        public Brush MenuTitleBrush
        {
            get { return menuTitleBrush; }
            set { menuTitleBrush = value; }
        }

        public override Point Location
        {
            get { return location; }
            set
            {
                //this.location = value;
                location = value;
                this.mouseBound.Location = value;
                //  this.location = value;
                this.textRender.Location = new Point(value.X + 20, value.Y + 5);
            }
        }

        public int Width
        {
            get
            {
                return this.width;
            }
            set
            {
                this.width = value;
            }
        }

        public int Height
        {
            get
            {
                return this.height;
            }
            set
            {
                this.height = value;
            }
        }

        public int ItemWidth
        {
            get { return itemWidth; }
            set { itemWidth = value; }
        }
        public int ItemHeight
        {
            get { return itemHeight; }
            set { itemHeight = value; }
        }
        public override Size Size
        {
            get
            {
                return this.mouseBound.Size;
            }
            set
            {
                if (!this.mouseBound.Size.Equals(value))
                {
                    this.mouseBound.Size = value;
                    this.textRender.Size = new Size(value.Width - 60, this.font.Height);
                    //this.DoResizeEvent();
                }
            }
        }

        public bool IsMarked
        {
            get { return isMarked; }
            set { isMarked = value; }
        }

        //private Rectangle bounds;
        //public Rectangle Bounds {
        //    get {
        //        return this.mouseBound;
        //    }
        //    //set
        //    //{
        //    //    if (!this.mouseBound.Equals(value))
        //    //    {
        //    //        if (!this.mouseBound.Size.Equals(value.Size))
        //    //        {
        //    //            this.Size = value.Size;
        //    //        }
        //    //        this.mouseBound.Location = value.Location;
        //    //        //this.textRender.Location = value.Location;
        //    //    }
        //    //}
        //}
        //public xap.sys.devcfg.func.d.MenuItem MenuItem
        //{
        //    get { return menuItem; }
        //    set { menuItem = value; }
        //}

        //public bool Selected
        //{
        //    get { return selected; }
        //    set { selected = value; }
        //}
        public bool IsMoveOn
        {
            get { return isMoveOn; }
            set { isMoveOn = value; }
        }
        #endregion
    }
}
