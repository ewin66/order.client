/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 中药（复杂模板）一级标题渲染实体
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
    /// 中药
    /// </summary>
    public class ChineseComplexTopRender : XRenderGroup, IComplexExtOrder
    {

        #region 属性


        public event EventHandler OrderDoubleClick;

        public event EventHandler ItemCheckChangd;

        // <summary>
        /// 是否不执行属性变更引发的操作
        /// </summary>
        public bool IsCanelProptypeChanged { get; set; }

        /// <summary>
        /// 是否顶级实体
        /// </summary>
        public bool IsTopLevelNode { get; set; }

        public System.Windows.Forms.Control Owner
        {
            get { return _comboBox.ParentForm; }
            set { _comboBox.ParentForm = value; }
        }


        /// <summary>
        /// 是否是第一次的加载
        /// </summary>
        public bool IsFirstLoad { get; set; }

        /// <summary>
        /// 是否选中
        /// </summary>
        public bool IsChecked
        {
            get { return this._medicalNameCheckBox.Checked; }
            set { this._medicalNameCheckBox.Checked = value; }
        }

        /// <summary>
        /// 复选框文字的颜色
        /// </summary>
        public Color CheekBoxForeColor
        {
            get { return this._medicalNameCheckBox.ForeColor; }
            set { this._medicalNameCheckBox.ForeColor = value; }
        }

        /// <summary>
        /// 是否撤销选中操作
        /// 成组药品的模式下。，选择父，子全选
        /// 选择子，父选中，但是此时父选中有多个字的话其他的子也会选中，这种交互有问题
        /// 故特意加属性控制
        /// 可以在设置父选中之前设置IsCanel=true,然后再让父选中，禁止往外发ValueChanged的事件
        /// </summary>
        public bool IsCanel { get; set; }

        /// <summary>
        /// 草药名称
        /// </summary>
        private OrderCheckBox _medicalNameCheckBox;//草药名称

        /// <summary>
        /// 剂数
        /// </summary>
        private OrderTextUnit _useNum;//使用剂数--剂数

        /// <summary>
        /// 煎法
        /// </summary>
        private OrderLabel _userMethod;//煎法

        /// <summary>
        /// 频次
        /// </summary>
        private OrderComboBox _comboBox;//频次

        /// <summary>
        /// 用法
        /// </summary>
        private OrderLabel _userMethod1;//用法

        /// <summary>
        /// 执行科室
        /// </summary>
        private OrderLabel _excuteDepartment;//执行科室

        private NewOrderTemplateDTO _itemDo;
        /// <summary>
        /// 主要用于频次，用法，煎法数据源的获得
        /// </summary>
        public OrderTemplateRstDTO templatRstDTo { get; set; }


        public List<ChineseComplexSecondOrder> SecondOrderCollections { get; set; }

        /// <summary>
        /// 医嘱实体
        /// </summary>
        public NewOrderTemplateDTO OrderDTo { get; set; }

        /// <summary>
        /// 医嘱单项数据源
        /// </summary>
        public NewOrderTemplateDTO ItemDo
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

        #endregion

        #region 构造

        public ChineseComplexTopRender()
        {
            Init();
        }


        void Init()
        {
            this.SecondOrderCollections = new List<ChineseComplexSecondOrder>();
            this.IsFirstLoad = true;

            _medicalNameCheckBox = new OrderCheckBox();
            _medicalNameCheckBox.ValueTextChanged += _userMethodCheckBox_ValueTextChanged;
            this.AddRender(_medicalNameCheckBox);

            _useNum = new OrderTextUnit();
            _useNum.GotFocus += new EventHandler(_userMethod_GotFocus);
            this.AddRender(_useNum);

            _userMethod = new OrderLabel();
            _userMethod.IsSuitScreenRelative = true;
            this.AddRender(_userMethod);

            _comboBox = new OrderComboBox();
            _comboBox.GotFocus += new EventHandler(_userMethod_GotFocus);
            this.AddRender(_comboBox);

            _userMethod1 = new OrderLabel();
            _userMethod.IsSuitScreenRelative = true;
            this.AddRender(_userMethod1);
            //执行科室先不显示
            _excuteDepartment = new OrderLabel();
            _excuteDepartment.IsSuitScreenRelative = true;
            _excuteDepartment.Format=new StringFormat()
            {
                Alignment = StringAlignment.Far,
                LineAlignment = StringAlignment.Center
            };
            this.AddRender(_excuteDepartment);

            this._medicalNameCheckBox.MouseDoubleClick += new MouseEventHandler(_medicalNameCheckBox_MouseDoubleClick);
        }

        #endregion

        #region 内部处理
        //双击事件
        void _medicalNameCheckBox_MouseDoubleClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            // CheckBox(复选框)文字区域 双击发出双击事件
            if (OrderDoubleClick != null && this._medicalNameCheckBox.TextRect.Contains(e.Location))
            {
                OrderDoubleClick(this, e);
            }
        }
        //获取焦点事件
        void _userMethod_GotFocus(object sender, EventArgs e)
        {
            _medicalNameCheckBox.Checked = true;
        }
        //属性变更时
        void _itemDo_PropertyChanged(object sender, System.ComponentModel.PropertyChangedEventArgs e)
        {
            UpdateDatasourceToRender();
        }


        //将数据源与控件进行绑定
        void UpdateDatasourceToRender()
        {
            _medicalNameCheckBox.Text = _itemDo.Name;

            if (_itemDo.Orders.HasValue)
                _useNum.ValueText = _itemDo.Orders.ToString();
            _useNum.UnitText = "剂";
            _useNum.ValueTextChanged += _useNum_ValueTextChanged;

            _userMethod.ValueText = _itemDo.Name_boil;

            if (this.templatRstDTo != null)
                _comboBox.DataSource = this.templatRstDTo.getFreqdefdo();
            _comboBox.ValueText = this.OrderDTo.Name_freq;
            _comboBox.ValueTextChanged += _comboBox_ValueTextChanged;

            _userMethod1.ValueText = _itemDo.Name_route;

            _excuteDepartment.ValueText = _itemDo.Ortplnitm_mp_name;

            if (this._itemDo.Fg_active.HasValue)
            {
                _medicalNameCheckBox.Enabled = (bool)this._itemDo.Fg_active;
                _useNum.Enabled = (bool)this._itemDo.Fg_active;
                _userMethod.Enabled = (bool)this._itemDo.Fg_active;
                _comboBox.Enabled = (bool)this._itemDo.Fg_active;
                _userMethod1.Enabled = (bool)this._itemDo.Fg_active;
                _excuteDepartment.Enabled = (bool)this._itemDo.Fg_active;
            }
            if (_medicalNameCheckBox.Enabled)
            {
                if (this._itemDo.Fg_checked.HasValue)
                {
                    _medicalNameCheckBox.Checked = (bool)this._itemDo.Fg_checked;
                }
            }

           


        }


        //cheekBox的选中状态发生变更时--回写到数据源
        void _userMethodCheckBox_ValueTextChanged(object sender, EventArgs e)
        {
            this._itemDo.Fg_checked = _medicalNameCheckBox.Checked;
            if (!IsCanel && !this.IsFirstLoad && this.ItemCheckChangd != null && !IsCanel)
            {
                this.ItemCheckChangd(this, EventArgs.Empty);
            }
        }

        //频次-的值发生变更的时候-回写到自身的数据源-以及子的数据源
        void _comboBox_ValueTextChanged(object sender, EventArgs e)
        {
            this.OrderDTo.Id_freq = this._comboBox.ValueText;
            this.OrderDTo.Name_freq = this._comboBox.ShowText;

            foreach (var item in this.OrderDTo.Itemlist)
            {
                if (item is OrTplNItmDO)
                {
                    (item as OrTplNItmDO).Id_freq = this._comboBox.ValueText;
                    (item as OrTplNItmDO).Ortplnitm_freq_name = this._comboBox.ShowText;
                }

            }
        }

        //剂数-的值发生变更-回写到数据源-以及子的数据源
        void _useNum_ValueTextChanged(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(_useNum.Text))
            {
                _itemDo.Orders = null;
            }
            else
            {
                _itemDo.Orders = Convert.ToInt32(_useNum.Text);

                foreach (var item in this.OrderDTo.Itemlist)
                {
                    if (item is OrTplNItmDO)
                    {
                        (item as OrTplNItmDO).Orders = _itemDo.Orders;
                    }

                }
            }
        }

        //数据源发生变更时
        void ItemDoChanged()
        {
            UpdateDatasourceToRender();

        }

        //位置发生变化，重设上面的其他Render的位置
        void LocationChanged()
        {
            //_excuteDepartment.ValueText = "中医科";

            _useNum.Size = new Size(48, this.Size.Height);

            _userMethod.Size = new Size(60, this.Size.Height);

            _comboBox.Size = new Size(80, this.Size.Height);

            _userMethod1.Size = new Size(48, this.Size.Height);

            int executeDepartWidth = (int)TextCellRender.MeasureText(_excuteDepartment.ValueText, _excuteDepartment.Font).Width + 1;

            _excuteDepartment.Size = new Size(executeDepartWidth, this.Size.Height);

            int checkBoxWidth = (int)TextCellRender.MeasureText(_medicalNameCheckBox.Text, _medicalNameCheckBox.Font).Width+1;

            int totalWidth = 48 + 60 + 80 + 48 + executeDepartWidth + OrderContext.ElementSpaceWidth * 5 + (checkBoxWidth + OrderContext.CheckBoxWidth);

            if (totalWidth<this.Size.Width)
            {
                 _medicalNameCheckBox.Size = new Size(checkBoxWidth+OrderContext.CheckBoxWidth, this.Size.Height);
            }
            else
            {
                _medicalNameCheckBox.Size = new Size(this.Size.Width - 48 - 60 - 80 - 48 - executeDepartWidth - OrderContext.ElementSpaceWidth * 5, this.Size.Height);
                 _medicalNameCheckBox.IsShowToolTip = true;
            }

          /*  if ( > this._medicalNameCheckBox.Size.Width)
            {
               
            }*/

            _medicalNameCheckBox.Location = new Point(this.Location.X, this.Location.Y);

            _useNum.Location = new Point(_medicalNameCheckBox.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);

            _userMethod.Location = new Point(_useNum.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);

            _comboBox.Location = new Point(_userMethod.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);

            _userMethod1.Location = new Point(_comboBox.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);

            _excuteDepartment.Location = new Point(this.Bound.Right - executeDepartWidth, this.Location.Y);

        }

        void SizeChanged()
        {

        }

        #endregion

    }
}
