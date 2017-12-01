/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 中药（复杂模板）子项渲染实体
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
using System.Windows.Forms;
using iih.ci.iih.ci.ord.dto.newordertemplatedto.d;

namespace iih.ci.ord.ciorder.render.complexOrder
{
    /// <summary>
    /// 中药（复杂模板）子项渲染实体
    /// </summary>
   public  class ChineseComplexSecondOrder:XRenderGroup,IComplexExtOrder
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
        ///服务名称
       /// </summary>
        private OrderCheckBox _checkBox;//（规格，单价，医保目录）


       /// <summary>
        ///  (规格，单价，医保目录）
       /// </summary>
        private OrderLabel _priceLabel;

       /// <summary>
        /// 剂量+单位
       /// </summary>
        private OrderTextUnit _unitTextBox;//剂量+单位

       /// <summary>
        /// 煎法要求
       /// </summary>
        private OrderLabel _orderLabel;//煎法要求

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

        public bool IsChecked
        {
            get { return this._checkBox.Checked; }
            set { this._checkBox.Checked = value; }
            
        }

        /// <summary>
        /// 是否第一次加载
        /// </summary>
        public bool IsFirstLoad { get; set; }

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
                SizeChanged();
            }
        }

        public ChineseComplexTopRender ParentOrderRender { get; set; }

        #endregion

        #region 构造

        public ChineseComplexSecondOrder()
        {
            Init();
        }


        void Init()
        {
            this.IsFirstLoad = true;
            _checkBox = new OrderCheckBox();
           _checkBox.ValueTextChanged += _checkBox_ValueTextChanged;
           
            this.AddRender(_checkBox);

            _priceLabel=new OrderLabel();
            this.AddRender(_priceLabel);


            _unitTextBox = new OrderTextUnit();
            _unitTextBox.GotFocus += new EventHandler(_unitTextBox_GotFocus);
            this.AddRender(_unitTextBox);

            _orderLabel=new OrderLabel();
            _orderLabel.IsSuitScreenRelative = true;
            this.AddRender(_orderLabel);

            this._checkBox.MouseDoubleClick += new MouseEventHandler(_checkBox_MouseDoubleClick);
        }
        #endregion 

        #region 内部处理
       /// <summary>
       /// 双击事件
       /// </summary>
       /// <param name="sender"></param>
       /// <param name="e"></param>
        void _checkBox_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            // CheckBox(复选框)文字区域 双击发出双击事件
            if (OrderDoubleClick != null && this._checkBox.TextRect.Contains(e.Location))
            {
                OrderDoubleClick(this, e);
            }
        }

        void _unitTextBox_GotFocus(object sender, EventArgs e)
        {
            if (ParentOrderRender != null)
            {
                ParentOrderRender.OrderDTo.Fg_checked = true;
            }
        }

        //属性变更
        void _itemDo_PropertyChanged(object sender, System.ComponentModel.PropertyChangedEventArgs e)
        {
            if (!IsCanelProptypeChanged)
                UpdateDatasourceToRender();
        }
        
        //更新数据源到当前控件
        void UpdateDatasourceToRender()
        {
            _checkBox.Text = _itemDo.Ortplnitm_srv_name;

            _priceLabel.ValueText = "(" + _itemDo.Ortplnitm_mm_spec + "," + _itemDo.Price +
                                    (_itemDo.Name_hp == null ? "" : "," + _itemDo.Name_hp) + ")";

            _unitTextBox.Text = _itemDo.Quan_med.ToString();
             _unitTextBox.UnitText = _itemDo.Ortplnitm_unit_name;
             _unitTextBox.ValueTextChanged += _unitTextBox_ValueTextChanged;

            if (this.OrderDTo.Fg_active.HasValue && !(bool) this.OrderDTo.Fg_active)
            {
                _checkBox.Enabled = false;
                _priceLabel.Enabled = false;
                _unitTextBox.Enabled = false;
                _orderLabel.Enabled = false;
            }
            else
            {
                if (_itemDo.Fg_active.HasValue)
                {
                    _checkBox.Enabled = (bool)_itemDo.Fg_active;
                    _priceLabel.Enabled = (bool)_itemDo.Fg_active;
                    _unitTextBox.Enabled = (bool)_itemDo.Fg_active;
                    _orderLabel.Enabled = (bool)_itemDo.Fg_active;
                }
            }
            if (_checkBox.Enabled)
            {
                if (_itemDo.Fg_checked.HasValue)
                {
                    _checkBox.Checked = (bool)_itemDo.Fg_checked;
                }
            }
            _orderLabel.ValueText = _itemDo.Ortplnitm_boildes_name;

           
        }

       //草药使用剂量的值发生变更-（回写到数据源）
        void _unitTextBox_ValueTextChanged(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(_unitTextBox.Text))
            {
                this._itemDo.Quan_med = null;
            }
            else
            {
                this._itemDo.Quan_med = Convert.ToDouble(_unitTextBox.Text);
            }
          
        }

        //选中状态发生变更--回写到数据源
        void _checkBox_ValueTextChanged(object sender, EventArgs e)
        {
            this.IsCanelProptypeChanged = true;

            _itemDo.Fg_checked= _checkBox.Checked ;
            if (!IsCanel&&!this.IsFirstLoad && this.ItemCheckChangd != null)
            {
                this.ItemCheckChangd(this, EventArgs.Empty);
            }

            this.IsCanelProptypeChanged = false;
        }

        //数据源发生变更
        void ItemDoChanged()
        {
            UpdateDatasourceToRender();
        }

        //位置变化触发
        void LocationChanged()
        {
           

            int orderLabelWidth = (int)TextCellRender.MeasureText(_orderLabel.ValueText, _orderLabel.Font).Width+1;

            int priceLabelWidth = (int)TextCellRender.MeasureText(_priceLabel.ValueText, _orderLabel.Font).Width + 1;

            int checkBoxWidth=(int)TextCellRender.MeasureText(_checkBox.Text, _checkBox.Font).Width + 1;

            int totalWidth = orderLabelWidth + priceLabelWidth + OrderContext.SingleDrugDosageWidth + (checkBoxWidth + OrderContext.CheckBoxWidth)
                + OrderContext.ElementSpaceWidth * 3;

            if (totalWidth < this.Size.Width)
            {
                _checkBox.Size = new Size(checkBoxWidth + OrderContext.CheckBoxWidth, this.Size.Height);
                _priceLabel.Size = new Size(priceLabelWidth,this.Size.Height);
                _unitTextBox.Size = new Size(OrderContext.SingleDrugDosageWidth, this.Size.Height);
                _orderLabel.Size = new Size(orderLabelWidth, this.Size.Height);

            }
            else
            {
                _checkBox.Size = new Size(this.Size.Width - OrderContext.SingleDrugDosageWidth - orderLabelWidth - OrderContext.ElementSpaceWidth * 3, this.Size.Height);
            }

            if (TextCellRender.MeasureText(_checkBox.Text, _checkBox.Font).Width > this._checkBox.Size.Width)
            {
                _checkBox.IsShowToolTip = true;
            }

            _checkBox.Location = new Point(this.Location.X, this.Location.Y);
            _priceLabel.Location = new Point(_checkBox.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);
            _unitTextBox.Location = new Point(_priceLabel.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);
            _orderLabel.Location = new Point(_unitTextBox.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);
        }

        //大小发生变更触发
        void SizeChanged()
        {
           
        }

        public override void Render(Graphics g)
        {
            //g.FillRectangle(new SolidBrush(Color.Orange),this.Bound );
            base.Render(g);
        }

        #endregion
    }
}
