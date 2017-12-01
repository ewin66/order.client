/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 复杂模板（单药品）第二行渲染实体
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
using xap.cli.sdk.render.Items;
using iih.ci.iih.ci.ord.dto.newordertemplatedto.d;

namespace iih.ci.ord.ciorder.render.complexOrder
{
    /// <summary>
    /// 复杂模板（单药品）第二行渲染实体
    /// </summary>
    public class SingleComplexOrderRender : XRenderGroup, IComplexExtOrder
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

        public event EventHandler OrderDoubleClick;
        private void FireOrderDoubleClick()
        {
            if (OrderDoubleClick != null)
            {
                OrderDoubleClick(this, null);
            }
        }

        public event EventHandler ItemCheckChangd;
        private void FireItemCheckChangd()
        {
            if (ItemCheckChangd != null)
            {
                ItemCheckChangd(this, null);
            }
        }

        public bool IsTopLevelNode { get; set; }

        public System.Windows.Forms.Control Owner
        {
            get { return _comboBox.ParentForm; }
            set { _comboBox.ParentForm = value; }
        }
        //一级药品
        public  SingleComplexTopOrderRender  ParentSingleOrder { get; set; }

        private OrderLabel _userMethod;//用法

        private OrderComboBox _comboBox;//频次

        private OrderTextUnit _userDaysTextBox;//使用天数

       private OrTplNItmDO _itemDo;

       private OrderLabel _excuteDepartment;//执行科室


       /// <summary>
       /// 是否是第一次的加载
       /// </summary>
       public bool IsFirstLoad { get; set; }

       /// <summary>
       /// 是否选中
       /// </summary>
       public bool IsChecked { get; set; }

        /// <summary>
        /// 医嘱实体
        /// </summary>
        public NewOrderTemplateDTO OrderDTo { get; set; }

        /// <summary>
        /// 主要用于频次，用法，煎法数据源的获得
        /// </summary>
        public OrderTemplateRstDTO templatRstDTo { get; set; }

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

        public SingleComplexOrderRender()
        {
            Init();
        }


        void Init()
        {
           
            _userMethod=new OrderLabel();
            _userMethod.IsSuitScreenRelative = true;
            this.AddRender(_userMethod);

            _comboBox = new OrderComboBox();
            _comboBox.GotFocus += _comboBox_GotFocus;
            this.AddRender(_comboBox);

            _userDaysTextBox=new OrderTextUnit();
            _userDaysTextBox.GotFocus += _comboBox_GotFocus;
            _userDaysTextBox.IsOnlyNum = true;
            this.AddRender(_userDaysTextBox);
            //执行科室先不显示
            _excuteDepartment=new OrderLabel();
            _excuteDepartment.IsSuitScreenRelative = true;
            this.AddRender(_excuteDepartment);
        }

      
     
        #endregion 

        #region 内部处理

        //控件获取焦点，，回写数据源wei true
        void _comboBox_GotFocus(object sender, EventArgs e)
        {
            if (ParentSingleOrder != null)
            {
                ParentSingleOrder.IsChecked = true;
            }
        }


        void UpdateDatasourceToRender()
        {
            string routedes = "";
            if (!string.IsNullOrEmpty(_itemDo.Ortplnitm_routedes_name)) {
               routedes = "(" + _itemDo.Ortplnitm_routedes_name + ")";
            }
            _userMethod.ValueText = _itemDo.Ortplnitm_route_name + routedes;

            if (this.templatRstDTo != null)
                _comboBox.DataSource = this.templatRstDTo.getFreqdefdo();
            _comboBox.ValueTextChanged += _comboBox_ValueTextChanged;
            _comboBox.ValueText = _itemDo.Ortplnitm_freq_name;

            _userDaysTextBox.Text = _itemDo.Days_or.ToString();
            _userDaysTextBox.UnitText = "天";
            _userDaysTextBox.ValueTextChanged += _userDaysTextBox_ValueTextChanged;
            if (_itemDo.Fg_active.HasValue) {
                _comboBox.Enabled = (bool)_itemDo.Fg_active;
                _userDaysTextBox.Enabled = (bool)_itemDo.Fg_active;
            }

            _excuteDepartment.ValueText = _itemDo.Ortplnitm_mp_name;


        }

        //频次的值发生变更--回写到数据源 TODO
        void _comboBox_ValueTextChanged(object sender, EventArgs e)
        {
            
        }

        //使用天数的值发生变化--回写到数据源
        void _userDaysTextBox_ValueTextChanged(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(_userDaysTextBox.Text))
            {
                _itemDo.Days_or = null;
            }
            else
            {
                _itemDo.Days_or = Convert.ToInt32(_userDaysTextBox.Text);
            }
        }

        void ItemDoChanged()
        {
            UpdateDatasourceToRender();
        }

        void LocationChanged()
        {
            _userDaysTextBox.Size = new Size(OrderContext.UserDaysWidth, this.Size.Height);
            _comboBox.Size = new Size(OrderContext.FreqOrderWidth, this.Size.Height);
            _excuteDepartment.Size = new Size(OrderContext.ExecuteDepartmentWidth, this.Size.Height);

            int userMethodWidth = (int) TextCellRender.MeasureText(_userMethod.ValueText, _userMethod.Font).Width + 1;

            int totalWidth = OrderContext.UserDaysWidth + OrderContext.FreqOrderWidth + OrderContext.ExecuteDepartmentWidth + userMethodWidth + OrderContext.ElementSpaceWidth * 3;

            if (totalWidth>this.Size.Width)
            {
                _userMethod.Size = new Size(this.Size.Width - _userDaysTextBox.Size.Width - _comboBox.Size.Width - _excuteDepartment.Size.Width - OrderContext.ElementSpaceWidth * 3, this.Size.Height);
            }
            else
            {
                _userMethod.Size = new Size(userMethodWidth,this.Size.Height);
            }
            _userMethod.Location = new Point(this.Location.X,this.Location.Y);
            _comboBox.Location = new Point(_userMethod.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);
            _userDaysTextBox.Location = new Point(_comboBox.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);
            _excuteDepartment.Location = new Point(_userDaysTextBox.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);

           
           
            
        }

        void SizeChanged()
        {
           
        }



        #endregion
        
    }
}
