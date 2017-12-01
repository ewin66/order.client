/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/15 17:34:16
* Filename    : ServerStopRender
* Project     : iih.ci.ord.ciorder.render.common
* Username    : f
* Description : 服务停用-渲染实体标识
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.render;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.render.common
{
    /// <summary>
    /// 服务停用-渲染实体标识
    /// </summary>
    public class OrderServerStopRender:UserRender
    {
        #region 事件

        /// <summary>
        /// 树节点键盘按下事件，在ExecuteDialogKey转发
        /// </summary>
        public OrderLabel.TreeNodeKeyDownDelegate TreeNodeKeyDownEvent;

        #endregion

        #region 属性
        
        /// <summary>
        /// 服务停用的原因
        /// </summary>
        public String StopReason { get; set; }


        public override Point Location
        {
            get { return base.Location; }
            set
            {
                base.Location = value;
                TooltipManager.Instance.HideTooltip();
            }
        }

        private Image _serveStopImage;

        //private readonly String _serveStopImagePath = "iih.ci.ord.res.image.ci.报错.png";


        #endregion

        #region 构造

        public OrderServerStopRender()
        {
            Init();
        }

        void Init()
        {
            _serveStopImage = Bitmap.FromStream(Assembly.GetCallingAssembly().GetManifestResourceStream("iih.ci.ord.res.image.ci.报错.png"));
            this.Visible = false;
            this.StopReason = "停用";
        }

        #endregion

        #region 内部处理

        public override void Render(Graphics g)
        {
            if (_serveStopImage != null)
            {
                g.DrawImage(_serveStopImage,this.Location.X,this.Location.Y);
            }
            

            base.Render(g);
        }

        #endregion

        #region 对外接口

        #endregion

        #region 重写

        protected override void OnMouseMove(object sender, MouseEventArgs e)
        {
            if (!String.IsNullOrEmpty(this.StopReason))
            {
                if (this.Bound.Contains(e.Location))
                {
                    TooltipManager.Instance.ShowCurrentTooltip(this.StopReason);
                }
                
            }
            base.OnMouseMove(sender, e);
        }

        protected override void OnMouseLeave(object sender, EventArgs e)
        {
            TooltipManager.Instance.HideTooltip();

            base.OnMouseLeave(sender, e);
        }

        //重写ExcutedKeyDown，将事件转发到树节点那一层去处理
        public override bool ExecuteDialogKey(Keys keyData)
        {
            if (TreeNodeKeyDownEvent != null)
            {
                TreeNodeKeyDownEvent(keyData);
            }
            return base.ExecuteDialogKey(keyData);
        }

        #endregion

        #region 内部类 控制Tooltip显示

        /// <summary>
        /// 共享同一个鼠标提示。带有显示延迟，当鼠标进入按钮时，不立刻显示。
        /// </summary>
        private sealed class TooltipManager
        {
            [ThreadStatic]
            private static TooltipManager _instance;

            /// <summary>
            /// 单例实例
            /// </summary>
            public static TooltipManager Instance
            {
                get
                {
                    if (_instance == null)
                        _instance = new TooltipManager();
                    return _instance;
                }
            }

            public bool IsShowingToolTip
            {
                get { return _toolTip.IsShowing; }
            }

            private XToolTipRender _toolTip;
            //private Timer _reshowDelayTimer;

            private const int DefaultReShowDelay = 300;

            private String _text = "";

            /// <summary>
            /// 初始化 <see cref="T:System.Object"/> 类的新实例。
            /// </summary>
            private TooltipManager()
            {
                _toolTip = new XToolTipRender();
            }


            /// <summary>
            /// 隐藏当前的鼠标提示
            /// </summary>
            public void HideTooltip()
            {
                _toolTip.Hide();
            }

            /// <summary>
            /// 如果传入的值和当前ToolTip显示的值不相等的话，初始化_text的值
            /// </summary>
            /// <param name="text"></param>
            public void ResetText(String text)
            {
                if (!this._text.Equals(text))
                {
                    _toolTip.Hide();
                    _text = "";
                }
            }

            /// <summary>
            /// 显示当前XImageButton的鼠标提示
            /// </summary>
            public void ShowCurrentTooltip(String text)
            {
                if (!_toolTip.IsShowing)
                    _toolTip.Show(text, Control.MousePosition);

                this._text = text;
            }

        }

        #endregion

        #region Dispose

        #endregion
    }
}
