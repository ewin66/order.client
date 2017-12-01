/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description :复杂模板-单药品的第一行渲染实体
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.ciorder.render.common;
using iih.ci.ord.ciorder.render.interfaces;
using iih.ci.ord.ciorder.render.order;
using iih.ci.ord.dto.newordertemplatedto.d;
using xap.cli.sdk.chart;
using xap.cli.sdk.render;
using iih.ci.iih.ci.ord.dto.newordertemplatedto.d;

namespace iih.ci.ord.ciorder.render.complexOrder
{
    /// <summary>
    /// 复杂模板-单药品的第一行渲染实体
    /// </summary>
    public class SingleComplexTopOrderRender : XRenderGroup, IComplexExtOrder
    {
        #region 属性

        /// <summary>
        /// 是否不执行属性变更引发的操作
        /// </summary>
        public bool IsCanelProptypeChanged { get; set; }


        /// <summary>
        /// 是否终止当前事件-不在继续往下传递
        /// </summary>
        public bool IsCanel { get; set; }


        /// <summary>
        /// 医嘱实体
        /// </summary>
        public NewOrderTemplateDTO OrderDTo { get; set; }
        /// <summary>
        /// 主要用于频次，用法，煎法数据源的获得
        /// </summary>
        public OrderTemplateRstDTO templatRstDTo { get; set; }

        /// <summary>
        /// 药品名
        /// </summary>
        private OrderCheckBox _checkBox;

        /// <summary>
        /// //（规格，单价，医保目录）
        /// </summary>
        private OrderLabel _orderLabel;

        private OrderTextUnit _unitTextBox;//剂量+单位

        private OrTplNItmDO _itemDo;

        /// <summary>
        /// 双击事件
        /// </summary>
        public event EventHandler OrderDoubleClick;

        /// <summary>
        /// 选择操作
        /// </summary>
        public event EventHandler ItemCheckChangd;

        /// <summary>
        /// 是否是顶级节点
        /// </summary>
        public bool IsTopLevelNode { get; set; }

        /// <summary>
        /// 承载容器
        /// </summary>
        public System.Windows.Forms.Control Owner { get; set; }



        /// <summary>
        /// 是否是第一次的加载
        /// </summary>
        public bool IsFirstLoad { get; set; }

        /// <summary>
        /// 是否选中
        /// </summary>
        public bool IsChecked
        {
            get { return this._checkBox.Checked; }
            set { this._checkBox.Checked = value; }
        }

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
                this._itemDo.PropertyChanged += _itemDo_PropertyChanged;
            }
        }


        /// <summary>
        /// 复选框文字的颜色
        /// </summary>
        public Color CheekBoxForeColor
        {
            get { return this._checkBox.ForeColor; }
            set { this._checkBox.ForeColor = value; }
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
                SizeChanged();
            }
        }

        #endregion

        #region 构造



        public SingleComplexTopOrderRender()
        {
            Init();
        }


        void Init()
        {
            this.IsFirstLoad = true;
            _checkBox = new OrderCheckBox();
           _checkBox.ValueTextChanged += _checkBox_ValueTextChanged;
            this.AddRender(_checkBox);

            _orderLabel=new OrderLabel();
            _orderLabel.TextBrush=new SolidBrush(Color.FromArgb(0,153,229));
            this.AddRender(_orderLabel);

            _unitTextBox = new OrderTextUnit();
            _unitTextBox.GotFocus += _unitTextBox_GotFocus;
            this.AddRender(_unitTextBox);

            this._checkBox.MouseDoubleClick += new System.Windows.Forms.MouseEventHandler(_checkBox_MouseDoubleClick);
        }
        #endregion 

        #region 内部处理

        void _checkBox_MouseDoubleClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            // CheckBox(复选框)文字区域 双击发出双击事件
            if (OrderDoubleClick != null && _checkBox.TextRect.Contains(e.Location))
            {
                OrderDoubleClick(this, e);
            }
        }
        void _unitTextBox_GotFocus(object sender, EventArgs e)
        {
            _itemDo.Fg_checked = true;
        }

        //选中状态发生变更时
        void _checkBox_ValueTextChanged(object sender, EventArgs e)
        {
            this.IsCanelProptypeChanged = true;
            _itemDo.Fg_checked = _checkBox.Checked;
            if (!IsCanel&&!this.IsFirstLoad && this.ItemCheckChangd != null)
            {
                this.ItemCheckChangd(this,EventArgs.Empty);
            }
            this.IsCanelProptypeChanged = false;
        }

        //属性变更
        void _itemDo_PropertyChanged(object sender, System.ComponentModel.PropertyChangedEventArgs e)
        {
            if(!this.IsCanelProptypeChanged)
                UpdateDatasourceToRender();
        }
        
        //更新数据源到当前控件
        void UpdateDatasourceToRender()
        {
            _checkBox.Text = _itemDo.Ortplnitm_srv_name;

            _orderLabel.ValueText = "(" + _itemDo.Ortplnitm_mm_spec + ",￥" + _itemDo.Price + (_itemDo.Name_hp == null ? "" : "," + _itemDo.Name_hp) + ")";
                                   
            _unitTextBox.Text = _itemDo.Quan_med.ToString();
             _unitTextBox.UnitText = _itemDo.Ortplnitm_unit_name;
             _unitTextBox.ValueTextChanged += _unitTextBox_ValueTextChanged;
            if (_itemDo.Fg_active.HasValue)
            {
                _checkBox.Enabled = (bool)_itemDo.Fg_active;
                _unitTextBox.Enabled = (bool)_itemDo.Fg_active;
            }
            if (_checkBox.Enabled)
            {
                if (_itemDo.Fg_checked.HasValue)
                {
                    _checkBox.Checked = (bool)_itemDo.Fg_checked;
                }
            }
           
        }

        //单次剂量--的值发生变更--回写到数据源
        void _unitTextBox_ValueTextChanged(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(_unitTextBox.Text))
            {
                this._itemDo.Quan_med = null;
            }
            else
            {
                this._itemDo.Quan_med = Convert.ToDouble(this._itemDo.Quan_med);
            }
          
        }

        //数据源发生变更
        void ItemDoChanged()
        {
            UpdateDatasourceToRender();
            this.IsFirstLoad = false;
        }

        //位置变化触发
        void LocationChanged()
        {
            SizeF checkSizeF = TextCellRender.MeasureText(_checkBox.Text, _checkBox.Font);//服务名称

            SizeF orderLabelSizeF = TextCellRender.MeasureText(_orderLabel.ValueText, _orderLabel.Font);//单价，分类

            _unitTextBox.Size = new Size(OrderContext.SingleDrugDosageWidth, this.Size.Height);

            if ((orderLabelSizeF.Width + 1) + (OrderContext.SingleDrugDosageWidth) + OrderContext.OrderNameMinWidth +
                OrderContext.ElementSpaceWidth * 2 + OrderContext.CheckBoxWidth > this.Size.Width)
            {

                _checkBox.Size = new Size(OrderContext.OrderNameMinWidth + 16, this.Size.Height);
                _checkBox.IsShowToolTip = true;
                _orderLabel.Size = new Size(this.Size.Width - (int)((70) + OrderContext.OrderNameMinWidth + OrderContext.ElementSpaceWidth * 2), this.Size.Height);
            }
            else
            {
                _checkBox.Size = new Size((int)checkSizeF.Width+16, this.Size.Height);
                _orderLabel.Size = new Size(this.Size.Width - (int)((70) + (_checkBox.Size.Width) + OrderContext.ElementSpaceWidth * 2), this.Size.Height);
            }
          
            //if (TextCellRender.MeasureText(_checkBox.Text, _checkBox.Font).Width > this._checkBox.Size.Width)
            //{
            //    _checkBox.IsShowToolTip = true;
            //}

            _checkBox.Location = new Point(this.Location.X , this.Location.Y);
            _orderLabel.Location = new Point(_checkBox.Bound.Right + OrderContext.ElementSpaceWidth,this.Location.Y);
            _unitTextBox.Location = new Point(_orderLabel.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);
        }

        //大小发生变更触发
        void SizeChanged()
        {
           
        }

        public override void Render(Graphics g)
        {
           // g.FillRectangle(new SolidBrush(Color.Orange),this.Bound );
            base.Render(g);
        }

        #endregion
      
    }
}
