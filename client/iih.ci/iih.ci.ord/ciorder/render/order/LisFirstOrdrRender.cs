/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/10 8:44:57
* Filename    : LisFirstOrdrRender
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 医嘱模板检查检验一级渲染实体
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
using iih.ci.ord.dto.newordertemplatedto.d;
using xap.cli.sdk.chart;
using xap.cli.sdk.controls.navbar;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using xap.rui.engine.eventbroker;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciorder.render.order
{
    /// <summary>
    /// 医嘱模板检查检验一级节点渲染实体
    /// </summary>
    public class LisFirstOrdrRender : XAPTreeNodeRender, IExtOrder
    {
        #region 属性

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
        /// 树节点的选中状态发生变更时
        /// </summary>
        public  event EventHandler SelectValueChanged;

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
        /// 检查检验非套的一级节点数据源
        /// </summary>
        public OrTplNItmDO ItemDo
        {
            get { return this._itemDo; }
            set
            {
                this._itemDo = value;
                DataValueChanged(this._itemDo);
            }
        }


        /// <summary>
        /// 检查检验套的dto
        /// </summary>
        public NewOrderTemplateDTO LisGroupDo
        {
            get { return this._listGroupDo; }
            set
            {
                this._listGroupDo = value;
                DataValueChanged(this._listGroupDo);
            }
        }


        /// <summary>
        /// 检查检验 套的二级节点的集合
        /// </summary>
        public List<LisSecondOrder> SecondOrderCollections { get; set; }


        /// <summary>
        /// 检查检验兄弟节点的集合（包含本身）
        /// </summary>
        public List<LisFirstOrdrRender> BrotherOrderCollecions { get; set; }

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

        //检查检验非套的一级节点数据源
        private OrTplNItmDO _itemDo;

        //检查检验套的dto

        private NewOrderTemplateDTO _listGroupDo;

        //医嘱模板（检查检验）一级节点元素 
        private OrderLabel _serverNameLabel;

		//是否显示单位控件
        private bool? Ismuldose { get; set; }

        #endregion

        #region 构造

        public LisFirstOrdrRender(bool? Ismuldose)
        {
            this.Ismuldose = Ismuldose;
            Init();
        }

        void Init()
        {
            this._serverStopRender=new OrderServerStopRender();
	        this._serverStopRender.MouseLeave += OrderRenderLeave;
            this._serverStopRender.TreeNodeKeyDownEvent += new OrderLabel.TreeNodeKeyDownDelegate(TreeNodeKeyDown);
            this.AddRender(this._serverStopRender);

            this.IsFirstLoad = true;

            SecondOrderCollections=new List<LisSecondOrder>();
            BrotherOrderCollecions=new List<LisFirstOrdrRender>();

            _serverNameLabel = new OrderLabel();
	        _serverNameLabel.MouseLeave += OrderRenderLeave;
            _serverNameLabel.TreeNodeKeyDownEvent += new OrderLabel.TreeNodeKeyDownDelegate(TreeNodeKeyDown);
          
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
          //  this.CanFocus = false;

            this.NodeCheckBox.ValueTextChanged += TreatmentOrder_ValueChanged;
            this.MouseDoubleClick += LisFirstOrdrRender_MouseDoubleClick;

            this.NodeCheckBoxMouseClick += NodeCheckBox_MouseClick;

            this.GotFocus += LisFirstOrdrRender_GotFocus;
        }

    
        #endregion

        #region 内部处理

		//简易模板树节点上的"控件"的leave事件,需要转发至基类去处理
		void OrderRenderLeave(object sender, EventArgs e)
		{
			this.OnMouseLeave(this, e);
		}

		void LisFirstOrdrRender_GotFocus(object sender, EventArgs e)
		{
			_serverNameLabel.Focus();
		}



		//树节点上面的CheckBox的点击事件
		void NodeCheckBox_MouseClick(object sender, EventArgs e)
		{
			if (OrderNodeClick != null)
			{
				OrderNodeClick(this, EventArgs.Empty);
			}
		}

		void LisFirstOrdrRender_MouseDoubleClick(object sender, System.Windows.Forms.MouseEventArgs e)
		{
			if (this.DoubleClick != null && !this.NodeCheckBox.Bound.Contains(e.Location))
			{
				DoubleClick(this, EventArgs.Empty);
			}
		}

		//文本框内使用剂量的值发生变更时触发
		void _xUnitTextBox_ValueTextChanged(object sender, EventArgs e)
		{
			if (_xUnitTextBox.ValueText != null)
				_itemDo.Quan_med = Convert.ToDouble(_xUnitTextBox.ValueText);
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


        //单选事件
        void TreatmentOrder_ValueChanged(object sender, EventArgs e)
        {
            if (!IsCanel&&SelectValueChanged != null && !IsFirstLoad)
            {
                SelectValueChanged(this,EventArgs.Empty);
            }
        }


        //DO数据源发送变更时
        void DataValueChanged(Object obj)
        {
            if (obj is NewOrderTemplateDTO)//检查检验成套一级节点
            {
                NewOrderTemplateDTO tempDo = obj as NewOrderTemplateDTO;
                _serverNameLabel.ValueText = tempDo.Name + "[￥ " + (tempDo.Price==null?"0.00":tempDo.Price.ToString("0.00")) + "]";// +"  (" + tempDo.Ortplnitm_mp_name + ")";

                _xUnitTextBox.ValueText = tempDo.Quan_med.ToString();
                _xUnitTextBox.UnitText = tempDo.Ortplnitm_unit_name;
                if (tempDo.Fg_active.HasValue) //检查，设置是否启用CheckBox，默认启用
                {
                    this.CheckBoxEnable = (bool)tempDo.Fg_active;

                    if (!this.CheckBoxEnable)
                    {
                        _serverNameLabel.ReadOnly = true;
                        _xUnitTextBox.Enabled = false;
                        _serverStopRender.StopReason = tempDo.Description;
                        _serverStopRender.Visible = true;
                        
                    }
                }
            }
            else if (obj is OrTplNItmDO)//检查检验非套的一级节点
            {
                OrTplNItmDO tempDo = obj as OrTplNItmDO;
                _serverNameLabel.ValueText = tempDo.Ortplnitm_srv_name + "[￥ " + (tempDo.Price == null ? "0.00" : tempDo.Price.ToString("0.00")) + "]";// +"  (" + tempDo.Ortplnitm_mp_name + ")";

                _xUnitTextBox.ValueText = tempDo.Quan_med.ToString();
                _xUnitTextBox.UnitText = tempDo.Ortplnitm_unit_name;
                if (tempDo.Fg_active.HasValue) //check for a value
                {
                    this.CheckBoxEnable = (bool)tempDo.Fg_active;

                    if (!this.CheckBoxEnable)
                    {
                        _serverNameLabel.ReadOnly = true;
                        _xUnitTextBox.Enabled = false;
                        _serverStopRender.StopReason = tempDo.Description;
                        _serverStopRender.Visible = true;
                    }
                    
                }
            }
            this.IsFirstLoad = false;
        }

        //位置发生变更时,对上面的元素的位置同时进行调整
        void LocationChanged()
        {
            int preX = 0;
            if (_serverStopRender.Visible)
            {
                _serverStopRender.Size = new Size(OrderContext.ServerStopWidth, OrderConstAssist.OrderRenderHeight);
                preX = OrderContext.ServerStopWidth + OrderContext.ServerStopPreX;
            }

            _xUnitTextBox.Size = new Size(70, 24);

            SizeF sizeF = TextCellRender.MeasureText(this._serverNameLabel.ValueText, this._serverNameLabel.Font);

            if (this.TotalWidth - this.DrawLeftPre - preX > 0)
            {
                _serverNameLabel.Size = new Size((int)sizeF.Width + 1, 24);
            }
            else
            {
                _serverNameLabel.Size = new Size(this.Size.Width - this.DrawLeftPre - preX, 24);
                _serverNameLabel.IsShowTip = true;
            }

            _serverNameLabel.Location = new Point(this.Location.X + this.DrawLeftPre, this.Location.Y + OrderConstAssist.SimpleUserDefinePreY);
            _xUnitTextBox.Location = new Point(_serverNameLabel.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y + OrderConstAssist.SimpleUnitPreY);
            _serverStopRender.Location = new Point(_serverNameLabel.Bound.Right + OrderContext.ServerStopPreX, this.Location.Y + OrderConstAssist.ServerStopPre);
        }

        //控件大小发生变更时，对上面的元素的大小同时调整
        //之所以传值是因为树节点内部进行处理在获取Size时有部分操作，会造成递归调用
        void SizeChanged(Size size)
        {

        }

        #endregion
    }
}
