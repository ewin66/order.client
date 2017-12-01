/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/10 10:53:47
* Filename    : OrderSingleRender
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 医嘱模板-单一药品（多药品）的渲染模板
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.ciorder.render.common;
using iih.ci.ord.ciorder.render.interfaces;
using xap.cli.sdk.chart;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using xap.rui.engine.xactions;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciorder.render.order
{
    /// <summary>
    /// 医嘱模板-单一药品（多药品）的渲染模板
    /// </summary>
    public class OrderSingleRender : XAPTreeNodeRender, IExtOrder
    {
        #region 属性

        //服务停用标识Render
        private OrderServerStopRender _serverStopRender;

        /// <summary>
        /// 医嘱节点单击事件
        /// </summary>
        public event EventHandler OrderNodeClick;

        /// <summary>
        /// 是否取消当前操作
        /// </summary>
        public bool IsCanel { get; set; }

        /// <summary>
        /// 树节点的选中状态发生变更时
        /// </summary>
        public event EventHandler SelectValueChanged;

        /// <summary>
        /// 树节点双击时触发
        /// </summary>
        public event EventHandler DoubleClick;


        /// <summary>
        /// 创建当前树节点的辅助工具
        /// </summary>
        public OrderExtAssist ExtAssist { get; set; }

        /// <summary>
        /// 可以从外面设置文本框是否选中
        /// </summary>
        public bool IsFirstChecked
        {
            get { return this.NodeCheckBox.Checked; }
            set { this.NodeCheckBox.Checked = value; }
        }

        /// <summary>
        /// 树节点的总的宽度
        /// </summary>
        public int TotalWidth { get; set; }

        /// <summary>
        /// 标识是不是第一次加载
        /// </summary>
        public bool IsFirstLoad { get; set; }

        /// <summary>
        /// 医嘱模板-单一药品（多药品）--兄弟节点的集合（包含本身）
        /// </summary>
        public List<OrderSingleRender> BrotherOrderCollecions { get; set; } 


        private OrTplNItmDO _itemDo;

        /// <summary>
        /// 医嘱单项数据源
        /// </summary>
        public OrTplNItmDO ItemDo
        {
            get { return _itemDo; }
            set
            {
                this._itemDo = value;
                ItemDoChanged();
            }
        }

        //服务名称 单价承载元素
        private OrderLabel _serverNameLabel;

        //使用剂量承载元素
        private OrderTextUnit _xUnitTextBox;

        /// <summary>
        /// 使用天数承载元素
        /// </summary>

        private OrderLabel _label;

        public override Point Location
        {
            get { return base.Location; }
            set
            {
                base.Location = value;
                LocationChanged();
            }
        }


        public override Size Size
        {
            get { return base.Size; }
            set
            {
                base.Size = value;
                SizeChanged(value);
            }
        }

        #endregion

        #region 构造

        public OrderSingleRender()
        {
            Init();
        }


        void Init()
        {
            _serverStopRender = new OrderServerStopRender();
            _serverStopRender.TreeNodeKeyDownEvent += new OrderLabel.TreeNodeKeyDownDelegate(TreeNodeKeyDown);
	        _serverStopRender.MouseLeave += OrderRenderLeave;
            this.AddRender(_serverStopRender);

            this.IsFirstLoad = true;

            _serverNameLabel = new OrderLabel();
            _serverNameLabel.TreeNodeKeyDownEvent += new OrderLabel.TreeNodeKeyDownDelegate(TreeNodeKeyDown);
	        _serverNameLabel.MouseLeave += OrderRenderLeave;
            this.AddRender(_serverNameLabel);

            _xUnitTextBox = new OrderTextUnit();
	        _xUnitTextBox.MouseLeave += OrderRenderLeave;
            _xUnitTextBox.ValueTextChanged += _xUnitTextBox_ValueTextChanged;
            _xUnitTextBox.GotFocus += new EventHandler(_xUnitTextBox_GotFocus);
            _xUnitTextBox.MouseEnter += _xUnitTextBox_MouseEnter;
            _xUnitTextBox.MouseLeave += _xUnitTextBox_MouseLeave;
            _xUnitTextBox.TreeNodeKeyDownEvent += new OrderLabel.TreeNodeKeyDownDelegate(TreeNodeKeyDown);
            this.AddRender(_xUnitTextBox);

            _label = new OrderLabel();
            this.AddRender(_label);


            this.IsDrawTreeIcon = false;
            this.IsExtTreeNode = true;
            this.IsUserDefinedItemHeight = true;
            this.UserDefinedItemHeight = OrderConstAssist.UserDefineItemHeight;
            this.Text = "";

            this.NodeCheckBox.ValueTextChanged += TreatmentOrder_ValueChanged;
            this.MouseDoubleClick+=OrderSingleRender_MouseDoubleClick;
            this.NodeCheckBoxMouseClick += NodeCheckBox_MouseClick;
            this.LostFocus += OrderSingleRender_LostFocus;


        }

        void OrderSingleRender_LostFocus(object sender, EventArgs e)
        {
           
        }

        #endregion

        #region 内部处理

		//简易模板树节点上的"控件"的leave事件,需要转发至基类去处理
		void OrderRenderLeave(object sender, EventArgs e)
		{
			this.OnMouseLeave(this, e);
		}


        //在当前节点上添加的Render的点击操作，转发
        void TreeNodeKeyDown(Keys keyData)
        {
            this.ExecuteDialogKey(keyData);
        }

        //鼠标移出单位控件的渲染区域
        void _xUnitTextBox_MouseLeave(object sender, EventArgs e)
        {
            this.CanFocus = true;
        }

        //鼠标进入单位控件的边界
        void _xUnitTextBox_MouseEnter(object sender, EventArgs e)
        {
            this.CanFocus = false;
        }

        //获取焦点
        void _xUnitTextBox_GotFocus(object sender, EventArgs e)
        {
            this.Checked = true;
        }

        //单击事件
        void NodeCheckBox_MouseClick(object sender, EventArgs e)
        {
            if (OrderNodeClick != null)
            {
                OrderNodeClick(this,EventArgs.Empty);
            }
        }

        //使用剂量的数值发生变更时，回写到数据源
        void _xUnitTextBox_ValueTextChanged(object sender, EventArgs e)
        {
            if (_xUnitTextBox.ValueText!=null)
                 _itemDo.Quan_med = Convert.ToDouble(_xUnitTextBox.ValueText);
        }

        //双击事件
        void OrderSingleRender_MouseDoubleClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
			if (this.DoubleClick != null && !this.NodeCheckBox.Bound.Contains(e.Location))
            {
                DoubleClick(this, EventArgs.Empty);
            }
        }


        //单选事件
        void TreatmentOrder_ValueChanged(object sender, EventArgs e)
        {
            if (!IsCanel&&this.SelectValueChanged != null && !IsFirstLoad)
            {
                SelectValueChanged(this, EventArgs.Empty);
            }
        }

        //数据源发生变更
        void ItemDoChanged()
        {


            _serverNameLabel.ValueText = _itemDo.Ortplnitm_srv_name + "[￥ " + (_itemDo.Price == null ? "0.00": _itemDo.Price.ToString("0.00")) + "]" + "  " + _itemDo.Ortplnitm_freq_name + "  " + _itemDo.Ortplnitm_route_name;
            _xUnitTextBox.ValueText = _itemDo.Quan_med.ToString();
            _xUnitTextBox.UnitText = _itemDo.Ortplnitm_unit_name;

            if (_itemDo.Days_or.HasValue)
                _label.ValueText = _itemDo.Days_or+"天";

            if (String.IsNullOrEmpty(_label.ValueText))
            {
                _label.Visible = false;
            }
            else
            {
                _label.Visible = true;
            }

            if (_itemDo.Fg_active.HasValue)
            {
                this.CheckBoxEnable = (bool)_itemDo.Fg_active;

                _serverNameLabel.Enabled = this.CheckBoxEnable;
            }


            if (!this.CheckBoxEnable)
            {
                _serverNameLabel.Enabled = false;
                _xUnitTextBox.Enabled = false;
                _serverStopRender.StopReason = _itemDo.Description;
                _serverStopRender.Visible = true;
                _label.Enabled = false;

            }

            this.IsFirstLoad = false;
        }


        //位置发生变更时
        void LocationChanged()
        {
            int preX = 0;
            if (_serverStopRender.Visible)//计算服务停用标识占据的宽度
            {
                _serverStopRender.Size = new Size(OrderContext.ServerStopWidth, OrderConstAssist.OrderRenderHeight);
                preX = OrderContext.ServerStopWidth + OrderContext.ServerStopPreX;
            }

            _xUnitTextBox.Size = new Size(70, 24);

            SizeF serverNameSie = TextCellRender.MeasureText(this._serverNameLabel.ValueText, this._serverNameLabel.Font);//服务器名称

            SizeF userDaySize = TextCellRender.MeasureText(this._label.ValueText, this._serverNameLabel.Font);//使用天数

            int preXLabel = 0;//使用天数的偏移，因为使用天数为空，不需要拼接。。。故
            if (!_label.Visible)
            {
                userDaySize=new SizeF(0,0);
                preXLabel = -OrderContext.ElementSpaceWidth;
            }

            _label.Size = new Size((int)userDaySize.Width+1, 24);

            int serverNameLabelWidth = 0;

            if (this.DrawLeftPre + serverNameSie.Width + OrderContext.ElementSpaceWidth + _xUnitTextBox.Size.Width + OrderContext.ElementSpaceWidth + _label.Size.Width + preX + OrderContext.ElementSpaceWidth + preXLabel > this.TotalWidth)
            {
                serverNameLabelWidth = this.TotalWidth - (int)(this.DrawLeftPre + OrderContext.ElementSpaceWidth * 3 + _xUnitTextBox.Size.Width + _label.Size.Width + preX + preXLabel);
                _serverNameLabel.IsShowTip = true;
            }
            else
            {
                serverNameLabelWidth = (int) (serverNameSie.Width)+1;
            }
            _serverNameLabel.Size = new Size(serverNameLabelWidth, 24);

            _serverNameLabel.Location = new Point(this.Location.X + this.DrawLeftPre, this.Location.Y + OrderConstAssist.SimpleUserDefinePreY);
            _xUnitTextBox.Location = new Point(_serverNameLabel.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y + OrderConstAssist.SimpleUnitPreY);
            _label.Location = new Point(_xUnitTextBox.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y + OrderConstAssist.SimpleUserDefinePreY);
            _serverStopRender.Location = new Point(_label.Bound.Right + OrderContext.ServerStopPreX, this.Location.Y + OrderConstAssist.ServerStopPre);
        }

        void SizeChanged(Size size)
        {
            
        }


        #endregion
        
    }
}
