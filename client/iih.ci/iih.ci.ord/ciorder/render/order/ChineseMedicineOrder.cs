/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/10 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 医嘱模板--中药
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

namespace iih.ci.ord.ciorder.render.order
{
    /// <summary>
    ///  医嘱模板--中药
    /// </summary>
    public class ChineseMedicineOrder : XAPTreeNodeRender, IExtOrder
    {
        #region 属性
        /// <summary>
        /// 草药剂量发生变化触发
        /// </summary>
        public event EventHandler DataValueChanged;

        /// <summary>
        /// 医嘱节点单击事件
        /// </summary>
        public event EventHandler OrderNodeClick;

        /// <summary>
        /// 是否取消当前操作
        /// </summary>
        public bool IsCanel { get; set; }

        //服务停用标识Render
        private OrderServerStopRender _serverStopRender;

        /// <summary>
        /// 创建当前树节点的辅助工具
        /// </summary>
        public OrderExtAssist ExtAssist { get; set; }

        /// <summary>
        /// 树节点的选中状态发生变更时
        /// </summary>
        public event EventHandler SelectValueChanged;

        /// <summary>
        /// 树节点双击时触发
        /// </summary>
        public event EventHandler DoubleClick;

        /// <summary>
        /// 可以从外面设置文本框是否选中
        /// </summary>
        public bool IsFirstChecked
        {
            get { return this.NodeCheckBox.Checked; }
            set { this.NodeCheckBox.Checked = value; }
        }

        /// <summary>
        /// 标识是不是第一次加载
        /// </summary>
        public bool IsFirstLoad { get; set; }

        /// <summary>
        /// 树节点的总的宽度
        /// </summary>
        public int TotalWidth { get; set; }

        /// <summary>
        /// 医嘱模板--中药兄弟节点的集合（包含本身）
        /// </summary>
        public List<ChineseMedicineOrder> BrotherOrderCollecions { get; set; } 


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
                this._itemDo.PropertyChanged += _itemDo_PropertyChanged;
                ItemDoChanged();
            }
        }

        //
        void _itemDo_PropertyChanged(object sender, System.ComponentModel.PropertyChangedEventArgs e)
        {
            if (this.ItemDo.Orders.HasValue)
                this._xUnitTextBox.ValueText = this.ItemDo.Orders.ToString();
            else
                this._xUnitTextBox.ValueText = "";
        }

        /// <summary>
        /// 服务名称 单价承载元素
        /// </summary>
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

        #endregion

        #region 构造

        public ChineseMedicineOrder()
        {
            Init();
        }


        void Init()
        {
            _serverStopRender=new OrderServerStopRender();
            _serverStopRender.TreeNodeKeyDownEvent += new OrderLabel.TreeNodeKeyDownDelegate(TreeNodeKeyDown);
	        _serverStopRender.MouseLeave += OrderRenderLeave;
            this.AddRender(_serverStopRender);

            IsFirstLoad = true;

            _serverNameLabel = new OrderLabel();
	        _serverNameLabel.MouseLeave += OrderRenderLeave;
            _serverNameLabel.TreeNodeKeyDownEvent += new OrderLabel.TreeNodeKeyDownDelegate(TreeNodeKeyDown);
           
            this.AddRender(_serverNameLabel);

            _xUnitTextBox = new OrderTextUnit();
			_xUnitTextBox.MouseLeave += OrderRenderLeave;
            _xUnitTextBox.IsOnlyNum = true;
            _xUnitTextBox.ValueTextChanged += _xUnitTextBox_ValueTextChanged;
            _xUnitTextBox.GotFocus += new EventHandler(_xUnitTextBox_GotFocus);
            _xUnitTextBox.MouseEnter+=_xUnitTextBox_MouseEnter;
            _xUnitTextBox.MouseLeave += _xUnitTextBox_MouseEnter;
            _xUnitTextBox.TreeNodeKeyDownEvent += new OrderLabel.TreeNodeKeyDownDelegate(TreeNodeKeyDown);
            this.AddRender(_xUnitTextBox);


            this.IsDrawTreeIcon = false;
            this.IsExtTreeNode = true;
            this.IsUserDefinedItemHeight = true;
           
            this.UserDefinedItemHeight = OrderConstAssist.UserDefineItemHeight;
            this.Text = "";
          


            this.NodeCheckBox.ValueTextChanged += TreatmentOrder_ValueChanged;
            this.MouseDoubleClick+=ChineseMedicineOrder_MouseDoubleClick;
            this.NodeCheckBoxMouseClick += NodeCheckBox_MouseClick;

        }

        void _xUnitTextBox_GotFocus(object sender, EventArgs e)
        {
            this.Checked = true;
        }


      

        #endregion

        #region 内部处理

		//简易模板树节点上的"控件"的leave事件,需要转发至基类去处理
		void OrderRenderLeave(object sender, EventArgs e)
		{
			this.OnMouseLeave(this, e);
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
                this.OrderNodeClick(sender,EventArgs.Empty);
            }
        }


        //双击
        void ChineseMedicineOrder_MouseDoubleClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
			if (this.DoubleClick != null && !this.NodeCheckBox.Bound.Contains(e.Location))
            {
                DoubleClick(this, EventArgs.Empty);
            }
        }

        //单选
        void TreatmentOrder_ValueChanged(object sender, EventArgs e)
        {
            if (!IsCanel&&this.SelectValueChanged != null && !IsFirstLoad)
            {
                SelectValueChanged(this, EventArgs.Empty);
            }
        }

        //数据源发送变更时
        void ItemDoChanged()
        {
            

            _serverNameLabel.ValueText = _itemDo.Ortplnitm_srv_name + "  " + _itemDo.Ortplnitm_freq_name + "  ";

            if (_itemDo.Orders.HasValue)
                 _xUnitTextBox.ValueText = _itemDo.Orders.ToString();

            _xUnitTextBox.UnitText = "剂";

            if (_itemDo.Fg_active.HasValue)
            {
                this.CheckBoxEnable = (bool)_itemDo.Fg_active;

                if (!this.CheckBoxEnable)
                {
                    _serverNameLabel.ReadOnly = true;
                    _xUnitTextBox.ReadOnly = true;
                    _serverStopRender.StopReason = _itemDo.Description;
                    _serverStopRender.Visible = true;

                }
            }

            IsFirstLoad = false;


        }

        //使用剂量的值发生变更时，回写到数据源
        void _xUnitTextBox_ValueTextChanged(object sender, EventArgs e)
        {
            if (_xUnitTextBox.ValueText != null)
                _itemDo.Orders = Convert.ToInt32(_xUnitTextBox.ValueText);
            if (DataValueChanged != null&&!IsFirstLoad)
            {
                DataValueChanged(this,EventArgs.Empty);
            }
        }



        void LocationChanged()
        {
            int preX = 0;
            if (_serverStopRender.Visible)//计算服务停用标识占据的宽度
            {
                _serverStopRender.Size = new Size(OrderContext.ServerStopWidth, OrderConstAssist.OrderRenderHeight);
                preX = OrderContext.ServerStopWidth + OrderContext.ServerStopPreX;
            }

            //剂量宽度
            _xUnitTextBox.Size = new Size(70, 24);
            SizeF serverNameSie = TextCellRender.MeasureText(this._serverNameLabel.ValueText, this._serverNameLabel.Font);
           
            int serverNameLabelWidth = 0;
            if (this.DrawLeftPre + serverNameSie.Width + OrderContext.ElementSpaceWidth + _xUnitTextBox.Size.Width + preX > this.TotalWidth)
            {
                serverNameLabelWidth = this.TotalWidth - (int)(OrderContext.ElementSpaceWidth + _xUnitTextBox.Size.Width + this.DrawLeftPre + preX);
                _serverNameLabel.IsShowTip = true;
            }
            else
            {
                serverNameLabelWidth = (int)(serverNameSie.Width) + 1;
            }

            _serverNameLabel.Location = new Point(this.Location.X + this.DrawLeftPre, this.Location.Y + OrderConstAssist.SimpleUserDefinePreY);
            _serverNameLabel.Size = new Size(serverNameLabelWidth, 24);

            _xUnitTextBox.Location = new Point(_serverNameLabel.Bound.Right +OrderContext.ElementSpaceWidth , this.Location.Y + OrderConstAssist.SimpleUnitPreY);
            _serverStopRender.Location = new Point(_xUnitTextBox.Bound.Right + OrderContext.ServerStopWidth, this.Location.Y + OrderConstAssist.ServerStopPre);

        }

        void SizeChanged(Size size)
        {
            
        }


        #endregion
    }
}
