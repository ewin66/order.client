using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.render;
using System.Drawing;
using iih.bd.srv.medsrv.d;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.render
{
    /// <summary>
    /// 字母表集合
    /// </summary>
    public class AlphabetRenderGroup : XRenderGroup
    {
        
        #region 属性
        public event MouseEventHandler RenderMouseClick;
        public const int ConstHeight = 28;

        private AlphabetRender render;
        private List<AlphabetRender> renderList;
        private Dictionary<string, AlphabetRender> renderDict;
        public Dictionary<string, AlphabetRender> RenderDict 
        {
            get 
            {
                return this.renderDict;
            } 
        }

        private Dictionary<string, AlphabetRender> alphabetRenderDict;
        private List<AlphabetRender> alphabetRenderList;  //可用状态按钮集合
        /// <summary>
        /// 当前容器处于可用状态的字母集合
        /// </summary>
        public Dictionary<string, AlphabetRender> AlphabetRenderDict 
        {
            get
            {
                return this.alphabetRenderDict;
            }
        }

        public void SetEnabled(Dictionary<string, List<MedSrvDO>> alphabetDict)
        {
            if (this.renderDict != null)
            {
                alphabetRenderDict = new Dictionary<string, AlphabetRender>();
                alphabetRenderList = new List<AlphabetRender>();
                foreach (AlphabetRender render in renderList)
                {
                    render.IsSelected = false;
                    if (alphabetDict.ContainsKey(render.Text))
                    {
                        render.Enabled = true;
                        if (!alphabetRenderDict.ContainsKey(render.Text))
                        {
                            alphabetRenderDict.Add(render.Text, render);
                        }
                        alphabetRenderList.Add(render);
                    }
                    else
                    {
                        render.Enabled = false;
                    }
                }
                this.Invalidate();
            }
        }

        private int selectedIndex;
        public int SelectedIndex 
        {
            get 
            {
                return selectedIndex;
            }
            set
            {
                if (this.alphabetRenderList == null || this.alphabetRenderList.Count < 1)
                {
                    this.selectedIndex = -1;
                    return;
                }
                if (value < 0)
                {
                    this.selectedIndex = 0;
                }
                else if (value > this.alphabetRenderList.Count)
                {
                    this.selectedIndex = 0;
                }
                else
                {
                    this.selectedIndex = value;
                }
                this.alphabetRenderList[this.selectedIndex].IsSelected = true;
                if (RenderMouseClick != null)
                {
                    RenderMouseClick(this.alphabetRenderList[this.selectedIndex], null);
                }
            }
        }

        #endregion

        #region 方法

        public AlphabetRenderGroup()
        {
            this.Size = new Size(700,28);
            this.renderList = new List<AlphabetRender>();
            this.renderDict = new Dictionary<string, AlphabetRender>();
            string text = "A";
            //添加26个英文首字母
            for (int i = 0; i < 26;i++ )
            {
                render = new AlphabetRender();
                render.Enabled = false;
                render.Text = text;
                this.AddRender(render);
                this.renderList.Add(render);
                if (!this.renderDict.ContainsKey(render.Text))
                {
                    this.renderDict.Add(render.Text,render);
                }
                text = Convert.ToChar(Convert.ToInt16(text.ToCharArray()[0]) + 1).ToString();
            }
            //添加其他
            text = "OTHER";
            render = new AlphabetRender();
            render.Enabled = false;
            render.Text = text;
            render.Size = new Size(40,24);
            this.AddRender(render);
            this.renderList.Add(render);
            if (!this.renderDict.ContainsKey(render.Text))
            {
                this.renderDict.Add(render.Text, render);
            }
            Relocation();
        }

        public AlphabetRenderGroup(Size size)
        {
            this.Size = size;
            this.renderList = new List<AlphabetRender>();
            this.renderDict = new Dictionary<string, AlphabetRender>();
            string text = "A";
            //添加26个英文首字母
            for (int i = 0; i < 26; i++)
            {
                render = new AlphabetRender();
                render.Enabled = false;
                render.Text = text;
                this.AddRender(render);
                this.renderList.Add(render);
                if (!this.renderDict.ContainsKey(render.Text))
                {
                    this.renderDict.Add(render.Text, render);
                }
                text = Convert.ToChar(Convert.ToInt16(text.ToCharArray()[0]) + 1).ToString();
            }
            //添加其他
            text = "OTHER";
            render = new AlphabetRender();
            render.Enabled = false;
            render.Text = text;
            render.Size = new Size(40, 24);
            this.AddRender(render);
            this.renderList.Add(render);
            if (!this.renderDict.ContainsKey(render.Text))
            {
                this.renderDict.Add(render.Text, render);
            }
            Relocation();
        }

        public override Point Location
        {
            get
            {
                return base.Location;
            }
            set
            {
                base.Location = value;
                Relocation();
            }
        }

        private void Relocation() 
        {
            AlphabetRender pre = null;
            if (renderList != null && renderList.Count != 0)
            {
                // 确定默认的绘制内容的纵坐标
                int x = 10;
                int y = (this.Size.Height - renderList[0].Size.Height )/2;

                int width = 0;
                int height = ConstHeight;
                // 遍历需要绘制的内容
                foreach (AlphabetRender render in renderList)
                {
                    if (pre == null)
                    {
                        // 如果是第一个内容
                        render.Location = new Point(this.Location.X + x, this.Location.Y + y);
                    }
                    else
                    {
                        // 根据前一个内容的位置信息，确定当前显示内容的坐标位置
                        render.Location = new Point(pre.Location.X + pre.Size.Width, this.Location.Y + y);
                    }
                    // 记录前一个绘制内容
                    pre = render;

                    if (pre.Location.X + pre.Size.Width > this.Size.Width - pre.Size.Width/2)
                    {
                        width = 0;
                        pre = null;
                        y += ConstHeight;
                        height += ConstHeight;
                    }
                    else
                    {
                        // 累加当前内容的绘制占用总宽度
                        width += pre.Size.Width;
                    }
                }
                // 更新当前容器的大小
                // this.Size = new Size(width, this.Size.Height);
                this.Size = new Size(this.Size.Width, height);
            }
            this.Invalidate();
        }

        protected override void OnMouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (alphabetRenderList != null && alphabetRenderList.Count >0)
            {
                for (int i = 0; i < alphabetRenderList.Count; i++)
                {
                    if (alphabetRenderList[i].Bound.Contains(e.Location))
                    {
                        alphabetRenderList[i].IsSelected = true;
                        this.SelectedIndex = i;
                    }
                    else
                    {
                        alphabetRenderList[i].IsSelected = false;
                    }
                }
                this.Invalidate();
            }
            base.OnMouseClick(sender, e);
        }

        #endregion
    }
}
