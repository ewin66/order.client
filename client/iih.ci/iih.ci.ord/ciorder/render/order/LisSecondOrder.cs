/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/9 19:51:37
* Filename    : LisThirdOrder
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 检查检验非套的二级节点
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
using xap.cli.sdk.controls.navbar.renders;
using xap.cli.sdk.controls.treeview;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;

namespace iih.ci.ord.ciorder.render.order
{
    /// <summary>
    /// 检查检验非套的二级节点
    /// </summary>
    public class LisSecondOrder : XAPTreeNodeRender, IExtOrder
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
        /// 检查检验二级节点的父节点
        /// </summary>
        public LisFirstOrdrRender ParentRender { get; set; }

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
        /// 检查检验二级节点兄弟节点的集合（包含本身）
        /// </summary>
        public List<LisSecondOrder> BrotherOrderCollecions { get; set; }

        /// <summary>
        /// 标识是不是第一次加载
        /// </summary>
        public bool IsFirstLoad { get; set; }


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
                this.IsFirstLoad = false;
            }
        }

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

        private OrderLabel _srvNameLabel;


        #endregion

        #region 构造

        public LisSecondOrder()
        {
            Init();
        }

        void Init()
        {
            this._serverStopRender = new OrderServerStopRender();
            this._serverStopRender.TreeNodeKeyDownEvent += new OrderLabel.TreeNodeKeyDownDelegate(TreeNodeKeyDown);
	        this._serverStopRender.MouseLeave += OrderRenderLeave;
            this.AddRender(this._serverStopRender);

            this.IsFirstLoad = true;

            _srvNameLabel = new OrderLabel();
	        _srvNameLabel.MouseLeave += OrderRenderLeave;
            this._srvNameLabel.TreeNodeKeyDownEvent += new OrderLabel.TreeNodeKeyDownDelegate(TreeNodeKeyDown);
            this._srvNameLabel.TreeNodeKeyDownEvent += new OrderLabel.TreeNodeKeyDownDelegate(TreeNodeKeyDown);
            this.AddRender(_srvNameLabel);

            this.IsDrawTreeIcon = false;
            this.IsExtTreeNode = true;
            this.IsUserDefinedItemHeight = true;
            this.UserDefinedItemHeight = OrderConstAssist.UserDefineItemHeight;
            this.Text = "";
            

            this.NodeCheckBox.ValueTextChanged += TreatmentOrder_ValueChanged;

            this.MouseDoubleClick += LisSecondOrder_MouseClick;

            this.NodeCheckBoxMouseClick += NodeCheckBox_MouseClick;
        }

    

       
        #endregion

        #region 内部处理

		//简易模板树节点上的"控件"的leave事件,需要转发至基类去处理
		void OrderRenderLeave(object sender, EventArgs e)
		{
			this.OnMouseLeave(this, e);
		}

        //单击事件
        void NodeCheckBox_MouseClick(object sender, EventArgs e)
        {
            if (OrderNodeClick != null)
            {
                OrderNodeClick(this, EventArgs.Empty);
            }
        }

        //在当前节点上添加的Render的点击操作，转发
        void TreeNodeKeyDown(Keys keyData)
        {
            this.ExecuteDialogKey(keyData);
        }

        //双击事件
        void LisSecondOrder_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
			if (this.DoubleClick != null && !this.NodeCheckBox.Bound.Contains(e.Location))
            {
                DoubleClick(this, EventArgs.Empty);
            }
        }

        //选中发生变更
        void TreatmentOrder_ValueChanged(object sender, EventArgs e)
        {
            if (!IsCanel&&SelectValueChanged != null && !this.IsFirstLoad)
            {
                SelectValueChanged(this, EventArgs.Empty);
            }
        }

        //数据源发生变更时
        void ItemDoChanged()
        {
           

            _srvNameLabel.ValueText = this._itemDo.Ortplnitm_srv_name;
            if (this.ExtAssist!=null&&this.ExtAssist.OrderDto != null)
            {
                if (this.ExtAssist.OrderDto.Fg_active.HasValue&&!(bool)this.ExtAssist.OrderDto.Fg_active)
                {
                    this.CheckBoxEnable = false;
                }
                else
                {
                    if (this.ItemDo.Fg_active.HasValue)
                    {
                        this.CheckBoxEnable = (bool) this.ItemDo.Fg_active;
                    }
                }

                if (this._itemDo.Fg_edit.HasValue&&!(bool)this._itemDo.Fg_edit)//医嘱-套的模式下-fg_edit为false，同样置灰控件
                {
                    this.NodeCheckBox.ReadOnly = true;
                    _srvNameLabel.Enabled = false;
                }

                if (!this.CheckBoxEnable)
                {
                    _srvNameLabel.Enabled = false;
                    _serverStopRender.StopReason = _itemDo.Description;
                    _serverStopRender.Visible = true;
                }
            }
        }

        //位置发生变更时
        void LocationChanged()
        {
            int preX = 0;
            if (_serverStopRender.Visible)
            {
                _serverStopRender.Size = new Size(OrderContext.ServerStopWidth, OrderConstAssist.OrderRenderHeight);
                preX = OrderContext.ServerStopWidth + OrderContext.ServerStopPreX;
            }


            SizeF sizeF = TextCellRender.MeasureText(this._srvNameLabel.ValueText, this._srvNameLabel.Font);

            if (this.TotalWidth - this.DrawLeftPre - preX > 0)
            {
                _srvNameLabel.Size = new Size((int)sizeF.Width + 1, 24);
            }
            else
            {
                _srvNameLabel.Size = new Size(this.TotalWidth - this.DrawLeftPre - preX, 24);
                _srvNameLabel.IsShowTip = true;
            }

            _srvNameLabel.Location = new Point(this.Location.X + this.DrawLeftPre, this.Location.Y + OrderConstAssist.SimpleUserDefinePreY);
            _serverStopRender.Location = new Point(_srvNameLabel.Bound.Right+OrderContext.ServerStopPreX, this.Location.Y + OrderConstAssist.ServerStopPre);

        }

        //大小变更时
        void SizeChanged(Size size)
        {
           
        }
        
        #endregion

	    protected override void OnMouseMove(object sender, MouseEventArgs e)
	    {
		    base.OnMouseMove(sender, e);
	    }
    }
}
