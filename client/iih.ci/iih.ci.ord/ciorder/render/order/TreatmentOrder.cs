/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/10 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 医嘱模板--治疗
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Windows.Forms;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.ciorder.render.common;
using iih.ci.ord.ciorder.render.interfaces;
using xap.cli.sdk.chart;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciorder.render.order
{
    /// <summary>
    /// 医嘱模板--治疗
    /// </summary>
    public class TreatmentOrder : XAPTreeNodeRender, IExtOrder
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
        /// 医嘱模板--治疗兄弟节点的集合（包含本身）
        /// </summary>
        public List<TreatmentOrder> BrotherOrderCollecions { get; set; }

        /// <summary>
        /// 标识是不是第一次加载
        /// </summary>
        public bool IsFirstLoad { get; set; }

        private OrTplNItmDO _itemDo;
        /// <summary>
        /// 诊疗属于那种模式
        /// </summary>
        public String TreatStyle { get; set; }

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

        private bool? Ismuldose { get; set; }
        #endregion

        #region 构造

        public TreatmentOrder(bool? Ismuldose)
        {
            this.Ismuldose = Ismuldose;
            Init();
        }


        void Init()
        {
            this.IsFirstLoad = true;

            _serverStopRender = new OrderServerStopRender();
			_serverStopRender.MouseLeave += OrderRenderLeave;
            _serverStopRender.TreeNodeKeyDownEvent += new OrderLabel.TreeNodeKeyDownDelegate(TreeNodeKeyDown);
            this.AddRender(_serverStopRender);

            _serverNameLabel = new OrderLabel();
            _serverNameLabel.TreeNodeKeyDownEvent += new OrderLabel.TreeNodeKeyDownDelegate(TreeNodeKeyDown);
			_serverNameLabel.MouseLeave += OrderRenderLeave;
            this.AddRender(_serverNameLabel);

            _xUnitTextBox = new OrderTextUnit();
			_xUnitTextBox.MouseLeave += OrderRenderLeave;
            if (Ismuldose != null && Ismuldose.Value)
            {
                _xUnitTextBox.Font = OrderConstAssist.OrderFont;
                _xUnitTextBox.ValueTextChanged += _xUnitTextBox_ValueTextChanged;
                _xUnitTextBox.GotFocus += new EventHandler(_xUnitTextBox_GotFocus);
                _xUnitTextBox.TreeNodeKeyDownEvent += new OrderLabel.TreeNodeKeyDownDelegate(TreeNodeKeyDown);
                _xUnitTextBox.MouseEnter += _xUnitTextBox_MouseEnter;
                _xUnitTextBox.MouseLeave += _xUnitTextBox_MouseLeave;
                this.AddRender(_xUnitTextBox);
            }

            this.IsDrawTreeIcon = false;
            this.IsExtTreeNode = true;
            this.IsUserDefinedItemHeight = true;
            this.UserDefinedItemHeight = OrderConstAssist.UserDefineItemHeight;
            this.Text = "";
           // this.CanFocus = false;

            this.NodeCheckBox.ValueTextChanged += TreatmentOrder_ValueChanged;

            this.MouseDoubleClick += TreatmentOrder_MouseDoubleClick;

            this.NodeCheckBoxMouseClick += NodeCheckBox_MouseClick;

        }

		

        #endregion

        #region 内部处理

		//简易模板树节点上的"控件"的leave事件,需要转发至基类去处理
		void OrderRenderLeave(object sender, EventArgs e)
		{
			this.OnMouseLeave(this, e);
		}

        //获取焦点
        void _xUnitTextBox_GotFocus(object sender, EventArgs e)
        {
            this.Checked = true;
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

        //在当前节点上添加的Render的点击操作，转发
        void TreeNodeKeyDown(Keys keyData)
        {
            this.ExecuteDialogKey(keyData);
        }


        //单击
        void NodeCheckBox_MouseClick(object sender, EventArgs e)
        {
            if (this.OrderNodeClick != null)
            {
                OrderNodeClick(sender,EventArgs.Empty);
                
            }
        }

        //数据源发生变更时
        void ItemDoChanged()
        {
            if (String.IsNullOrEmpty(this.TreatStyle) || (this.TreatStyle.Equals("1")))//诊疗模式为1或者空（默认）
            {
                _serverNameLabel.ValueText = _itemDo.Ortplnitm_srv_name + "[￥" + (_itemDo.Price == null ? "0.00" : _itemDo.Price.ToString("0.00")) + "]";
            }
            else {
                _serverNameLabel.ValueText = _itemDo.Ortplnitm_srv_name + "[￥" + (_itemDo.Price == null ? "0.00" : _itemDo.Price.ToString("0.00")) + "]" + "  " + _itemDo.Ortplnitm_freq_name + "  ";
            }
            _xUnitTextBox.ValueText = _itemDo.Quan_med.ToString();
            _xUnitTextBox.UnitText = _itemDo.Ortplnitm_unit_name;
            if (_itemDo.Fg_active.HasValue)
            {
                this.CheckBoxEnable = (bool)_itemDo.Fg_active;
            }

            if (!this.CheckBoxEnable)
            {
                _serverNameLabel.ReadOnly = true;
                _xUnitTextBox.Enabled = false;
                _serverStopRender.Visible = true;
                _serverStopRender.StopReason = _itemDo.Description;
            }

            this.IsFirstLoad = false;
        }

        //文本框内使用剂量的值发生变更时触发
        void _xUnitTextBox_ValueTextChanged(object sender, EventArgs e)
        {
            if (_xUnitTextBox.ValueText != null)
                _itemDo.Quan_med = Convert.ToDouble(_xUnitTextBox.ValueText);
        }

        //双击
        void TreatmentOrder_MouseDoubleClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (this.DoubleClick != null&&!this.NodeCheckBox.Bound.Contains(e.Location))
            {
                DoubleClick(this,EventArgs.Empty);
            }
        }

        //单选
        void TreatmentOrder_ValueChanged(object sender, EventArgs e)
        {
            if (!IsCanel&&this.SelectValueChanged != null && !this.IsFirstLoad)
            {
                SelectValueChanged(this, EventArgs.Empty);
            }
        }

        //位置发生偏移时
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
            int serverNameLabelWidth = 0;

            if (this.DrawLeftPre + serverNameSie.Width + OrderContext.ElementSpaceWidth + _xUnitTextBox.Size.Width + preX > this.TotalWidth)
            {
                serverNameLabelWidth = this.TotalWidth - (int)(OrderContext.ElementSpaceWidth + _xUnitTextBox.Size.Width + preX + this.DrawLeftPre);
                _serverNameLabel.IsShowTip = true;
            }
            else
            {
                serverNameLabelWidth = (int)(serverNameSie.Width) + 1;
            }

            
            _serverNameLabel.Size = new Size(serverNameLabelWidth, 24);

            _serverNameLabel.Location = new Point(this.Location.X + this.DrawLeftPre, this.Location.Y + OrderConstAssist.SimpleUserDefinePreY);
            _xUnitTextBox.Location = new Point(_serverNameLabel.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y + OrderConstAssist.SimpleUnitPreY);
            _serverStopRender.Location = new Point(_xUnitTextBox.Bound.Right + OrderContext.ServerStopPreX, this.Location.Y + OrderConstAssist.ServerStopPre);
            
        }

        //大小发生变更时
        void SizeChanged(Size size)
        {
            
        }
        #endregion
    }
}
