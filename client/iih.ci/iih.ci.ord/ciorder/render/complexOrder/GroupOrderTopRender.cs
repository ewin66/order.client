/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 复杂版的医嘱模板--成组医嘱--首行渲染实体
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
    /// 成组药品首行渲染实体
    /// </summary>
    public class GroupOrderTopRender : XRenderGroup, IComplexExtOrder
    {
        #region 属性


        public event EventHandler OrderDoubleClick;

        public event EventHandler ItemCheckChangd;

        /// <summary>
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
        /// 是否撤销选中操作
        /// 成组药品的模式下。，选择父，子全选
        /// 选择子，父选中，但是此时父选中有多个字的话其他的子也会选中，这种交互有问题
        /// 故特意加属性控制
        /// 可以在设置父选中之前设置IsCanel=true,然后再让父选中，禁止往外发ValueChanged的事件
        /// </summary>
        public bool IsCanel { get; set; }


        /// <summary>
        /// 是否是第一次的加载
        /// </summary>
        public  bool IsFirstLoad { get; set; }

        /// <summary>
        /// 是否选中
        /// </summary>
        public bool IsChecked
        {
            get { return this._userMethodCheckBox.Checked; }
            set { this._userMethodCheckBox.Checked = value; }
        }

        /// <summary>
        /// 复选框文字的颜色
        /// </summary>
        public Color CheekBoxForeColor
        {
            get { return this._userMethodCheckBox.ForeColor; }
            set { this._userMethodCheckBox.ForeColor = value; }
        }

        private OrderCheckBox _userMethodCheckBox;//用法

        private OrderComboBox _comboBox;//频次

        private OrderTextUnit _userDaysTextBox;//使用天数

        private NewOrderTemplateDTO _itemDo;

       private OrderLabel _excuteDepartment;//执行科室

       public List<GroupOrderSecondRender> SecondOrderCollections { get; set; }

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

        public GroupOrderTopRender()
        {
            Init();
        }

        void Init()
        {
            this.SecondOrderCollections = new List<GroupOrderSecondRender>();
            this.IsFirstLoad = true;
            _userMethodCheckBox = new OrderCheckBox();
            _userMethodCheckBox.ValueTextChanged += _userMethodCheckBox_ValueTextChanged;
            this.AddRender(_userMethodCheckBox);

            _comboBox = new OrderComboBox();
            _comboBox.GotFocus += new EventHandler(_comboBox_GotFocus);
            this.AddRender(_comboBox);

            _userDaysTextBox=new OrderTextUnit();
            _userDaysTextBox.IsOnlyNum = true;
            _userDaysTextBox.GotFocus += new EventHandler(_comboBox_GotFocus);
            this.AddRender(_userDaysTextBox);
            //执行科室先不显示
            _excuteDepartment=new OrderLabel();
            _excuteDepartment.IsSuitScreenRelative = true;
            _excuteDepartment.Format=new StringFormat()
            {
                Alignment = StringAlignment.Far,
                LineAlignment = StringAlignment.Center
            };
            this.AddRender(_excuteDepartment);

            this._userMethodCheckBox.MouseDoubleClick += new System.Windows.Forms.MouseEventHandler(_userMethodCheckBox_MouseDoubleClick);
        }


        #endregion 
        
        void _userMethodCheckBox_MouseDoubleClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            // CheckBox(复选框)文字区域 双击发出双击事件
            if (OrderDoubleClick != null && _userMethodCheckBox.TextRect.Contains(e.Location))
            {
                OrderDoubleClick(sender, e);
            }
        }
        #region 内部处理
        //鼠标双击是事件
        void _checkBox_MouseDoubleClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (OrderDoubleClick != null)
            {
                OrderDoubleClick(this, e);
            }
        }
        //获得焦点事件
        void _comboBox_GotFocus(object sender, EventArgs e)
        {
            _userMethodCheckBox.Checked = true;
        }

        //属性变更时
        void _itemDo_PropertyChanged(object sender, System.ComponentModel.PropertyChangedEventArgs e)
        {
            if (!this.IsCanelProptypeChanged)
                 UpdateDatasourceToRender();
        }


        //将数据源与控件进行绑定
        void UpdateDatasourceToRender()
        {
            if (!String.IsNullOrEmpty(_itemDo.Name_routedes))
                _userMethodCheckBox.Text = _itemDo.Name_route+ "(" + _itemDo.Name_routedes + ")";
            else
            {
                _userMethodCheckBox.Text = _itemDo.Name_route;
            }

            if (this.templatRstDTo != null)
                _comboBox.DataSource = this.templatRstDTo.getFreqdefdo();
            _comboBox.ValueText = this.OrderDTo.Name_freq;
            _comboBox.ValueTextChanged += _comboBox_ValueTextChanged;

            if (_itemDo.Days_or.HasValue)
                _userDaysTextBox.ValueText = _itemDo.Days_or.ToString();
            _userDaysTextBox.UnitText = "天";
            _userDaysTextBox.ValueTextChanged += _userDaysTextBox_ValueTextChanged;

            _excuteDepartment.ValueText = _itemDo.Ortplnitm_mp_name;

            if (_itemDo.Fg_active.HasValue)//控制是否启用
            {
                _userMethodCheckBox.Enabled = (bool) (_itemDo.Fg_active);
                _comboBox.Enabled = (bool)(_itemDo.Fg_active);
                _userDaysTextBox.Enabled = (bool)(_itemDo.Fg_active);
                _excuteDepartment.Enabled = (bool)(_itemDo.Fg_active);
            }
            if (_userMethodCheckBox.Enabled)
            {
                if (this._itemDo.Fg_checked.HasValue)
                {
                    _userMethodCheckBox.Checked = (bool)this._itemDo.Fg_checked;
                }
            }
        }

        //频次-下拉-值发生变更的时候回写到数据源
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

        //使用天数-文本框内的值发生改变--回写值到数据源(为父，同时回写到子的Do中)
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
           

            foreach (var temp in this._itemDo.Itemlist)
            {
                if (temp is OrTplNItmDO)
                {
                    if (String.IsNullOrEmpty(_userDaysTextBox.Text))
                    {
                          (temp as OrTplNItmDO).Days_or = null;
                    }
                    else
                    {
                          (temp as OrTplNItmDO).Days_or = Convert.ToInt32(_userDaysTextBox.Text);
                    }
                }
            }

        }

        //cheekBox的选中状态发生变更时--回写值到数据源
        void _userMethodCheckBox_ValueTextChanged(object sender, EventArgs e)
        {
            this.IsCanelProptypeChanged = true;
            _itemDo.Fg_checked = _userMethodCheckBox.Checked;
            if (!IsCanel && !this.IsFirstLoad && this.ItemCheckChangd != null && !IsCanel)
            {
                this.ItemCheckChangd(this, EventArgs.Empty);
            }
            this.IsCanelProptypeChanged = false;
        }


        
        //数据源发生变更时
        void ItemDoChanged()
        {
            UpdateDatasourceToRender();

        }

        //位置发生变化，重设上面的其他Render的位置
        void LocationChanged()
        {
            int userMethodWidth = (int)TextCellRender.MeasureText(_userMethodCheckBox.Text, _userMethodCheckBox.Font).Width + 1;

            int executeDepaerMentWidth = (int)TextCellRender.MeasureText(_excuteDepartment.ValueText, _excuteDepartment.Font).Width + 1;

            int totalWidth = OrderContext.UserDaysWidth + OrderContext.FreqOrderWidth + executeDepaerMentWidth 
                + (userMethodWidth+OrderContext.CheckBoxWidth) + OrderContext.ElementSpaceWidth * 3;

            if (totalWidth < this.Size.Width)
            {
                _userMethodCheckBox.Size = new Size((userMethodWidth + OrderContext.CheckBoxWidth),this.Size.Height);
                _userDaysTextBox.Size = new Size(OrderContext.UserDaysWidth, this.Size.Height);
                _comboBox.Size = new Size(OrderContext.FreqOrderWidth, this.Size.Height);
                _excuteDepartment.Size = new Size(executeDepaerMentWidth, this.Size.Height);
            }
            else
            {
                int minCheckBoxWidth = this.Size.Width - OrderContext.UserDaysWidth - OrderContext.FreqOrderWidth -
                                       OrderContext.ElementSpaceWidth*3;

                _userMethodCheckBox.Size = new Size(minCheckBoxWidth, this.Size.Height);
                _userDaysTextBox.Size = new Size(OrderContext.UserDaysWidth, this.Size.Height);
                _comboBox.Size = new Size(OrderContext.FreqOrderWidth, this.Size.Height);
                _excuteDepartment.Size = new Size(executeDepaerMentWidth, this.Size.Height);



            }
            
          

          //  _userMethodCheckBox.Size = new Size(this.Size.Width - _userDaysTextBox.Size.Width - _comboBox.Size.Width - _excuteDepartment.Size.Width - OrderContext.ElementSpaceWidth * 3, this.Size.Height);

            if (TextCellRender.MeasureText(_userMethodCheckBox.Text, _userMethodCheckBox.Font).Width > this._userMethodCheckBox.Size.Width)
            {
                _userMethodCheckBox.IsShowToolTip = true;
            }

            _userMethodCheckBox.Location = new Point(this.Location.X, this.Location.Y);
            _comboBox.Location = new Point(_userMethodCheckBox.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);
            _userDaysTextBox.Location = new Point(_comboBox.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);
            _excuteDepartment.Location = new Point(this.Bound.Right - executeDepaerMentWidth, this.Location.Y);
        }

        void SizeChanged()
        {
           
        }

        #endregion
    }
}
