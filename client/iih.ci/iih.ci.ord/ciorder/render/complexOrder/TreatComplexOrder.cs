/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description :复杂模板（诊疗）渲染实体
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
using iih.ci.ord.ciorder.render.order;
using iih.ci.ord.dto.newordertemplatedto.d;
using xap.cli.sdk.chart;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using iih.ci.iih.ci.ord.dto.newordertemplatedto.d;

namespace iih.ci.ord.ciorder.render.complexOrder
{
    /// <summary>
    /// 复杂模板（诊疗）
    /// </summary>
    public class TreatComplexOrder:XRenderGroup,IComplexExtOrder
    {
        #region 属性


        ///<summary>
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

        private OrTplNItmDO _itemDo;

        /// <summary>
        /// 树节点双击时触发
        /// </summary>
        public event EventHandler OrderDoubleClick;

        /// <summary>
        /// 选中状态发生变更
        /// </summary>
        public event EventHandler ItemCheckChangd;

        /// <summary>
        /// 是否是顶级节点
        /// </summary>
        public bool IsTopLevelNode { get; set; }

        /// <summary>
        /// 承载当前Render的容器
        /// </summary>
        public Control Owner
        {
            get { return this._freqXComboBox.ParentForm; }
            set { this._freqXComboBox.ParentForm = value; }
        }

        /// <summary>
        /// 是否是第一次的加载
        /// </summary>
        public bool IsFirstLoad { get; set; }

        /// <summary>
        /// 是否选中
        /// </summary>
        public bool IsChecked {
            get { return this._treatNameCheckBox.Checked; }
            set { this._treatNameCheckBox.Checked = value; }

        }

        /// <summary>
        /// 复选框文字的颜色
        /// </summary>
        public Color CheekBoxForeColor
        {
            get { return this._treatNameCheckBox.ForeColor; }
            set { this._treatNameCheckBox.ForeColor = value; }
        }

        /// <summary>
        /// 诊疗属于那种模式
        /// </summary>
        public String TreatStyle { get; set; }

        /// <summary>
        /// 诊疗名称
        /// </summary>
        private OrderCheckBox _treatNameCheckBox;//诊疗名称

        /// <summary>
        /// （单价，医保目录）
        /// </summary>
        private OrderLabel _orderLabel;

        /// <summary>
        /// 剂量
        /// </summary>
        private OrderTextUnit _userNum;//剂量

        /// <summary>
        /// 频次
        /// </summary>
        private XComboBox _freqXComboBox;//频次

        /// <summary>
        /// 使用天数
        /// </summary>
        private OrderTextUnit _userDays;

        /// <summary>
        /// 执行科室
        /// </summary>
        private OrderLabel _excuteProject;//执行科室


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

        public TreatComplexOrder(String treatStyle)
        {
            Init(treatStyle);
        }

        void Init(String treatStyle)
        {
            this.TreatStyle = treatStyle;
            this.IsFirstLoad = true;

            _treatNameCheckBox = new OrderCheckBox();
            _treatNameCheckBox.ValueTextChanged += _treatNameCheckBox_ValueTextChanged;
            

            _userNum = new OrderTextUnit();
            _userNum.GotFocus += new EventHandler(_userNum_GotFocus);
            _userNum.MaxUnitWidth = 40;

            _freqXComboBox = new XComboBox();
            _freqXComboBox.GotFocus += new EventHandler(_userNum_GotFocus);

            _userDays = new OrderTextUnit();
            _userDays.GotFocus += new EventHandler(_userNum_GotFocus);
            _userDays.IsOnlyNum = true;
            _userDays.MaxUnitWidth = 40;

            _excuteProject = new OrderLabel();
            _excuteProject.IsSuitScreenRelative = true;

            _orderLabel=new OrderLabel();
            _orderLabel.TextBrush = OrderContext.TitleBrush;

            if (String.IsNullOrEmpty(this.TreatStyle)||(this.TreatStyle.Equals("1")))//诊疗模式为1或者空（默认）
            {
                this.AddRender(_treatNameCheckBox);
                this.AddRender(_orderLabel);
                this.AddRender(_userNum);
                this.AddRender(_excuteProject);
            }
            else if (this.TreatStyle.Equals("0"))
            {
                this.AddRender(_treatNameCheckBox);
               // this.AddRender(_orderLabel);
                this.AddRender(_userNum);
                this.AddRender(_freqXComboBox);
                this.AddRender(_userDays);
                this.AddRender(_excuteProject);
            }

            this._treatNameCheckBox.MouseDoubleClick += new MouseEventHandler(_treatNameCheckBox_MouseDoubleClick);
        }

        #endregion

        #region 内部处理

        void _treatNameCheckBox_MouseDoubleClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            // CheckBox(复选框)文字区域 双击发出双击事件
            if (OrderDoubleClick != null && _treatNameCheckBox.TextRect.Contains(e.Location))
            {
                OrderDoubleClick(this, e);
            }
        }
        void _userNum_GotFocus(object sender, EventArgs e)
        {
            this._treatNameCheckBox.Checked = true;
        }


        //数据源发生变更时
        void ItemDoChanged()
        {
           
            UpdateDatasourceToRender();
            this._itemDo.PropertyChanged += _itemDo_PropertyChanged;
            this.IsFirstLoad = false;

        }

        //数据源的某个属性发生变更时
        void _itemDo_PropertyChanged(object sender, System.ComponentModel.PropertyChangedEventArgs e)
        {
            if (!IsCanelProptypeChanged)
                UpdateDatasourceToRender();
        }

        //位置变化时
        void LocationChanged()
        {
            if (String.IsNullOrEmpty(this.TreatStyle) || (this.TreatStyle.Equals("1")))//诊疗模式为1或者空（默认）
            {
                _userNum.Size = new Size(OrderContext.SingleDrugDosageWidth, this.Size.Height);

                _excuteProject.Size = new Size(OrderContext.ExecuteDepartmentWidth, this.Size.Height);

                int orderLabelWidth = (int)TextCellRender.MeasureText(_orderLabel.ValueText, _orderLabel.Font).Width+1;

                int treatCheckBoxWidth = (int)TextCellRender.MeasureText(_treatNameCheckBox.Text, _treatNameCheckBox.Font).Width+1;

                int totalWidth = OrderContext.SingleDrugDosageWidth + OrderContext.ExecuteDepartmentWidth + orderLabelWidth + treatCheckBoxWidth + OrderContext.ElementSpaceWidth * 3 + OrderContext.CheckBoxWidth;//16复选框的宽度

                if (totalWidth > this.Size.Width)
                {
                    int surplusWidth = this.Size.Width - (OrderContext.SingleDrugDosageWidth + OrderContext.ExecuteDepartmentWidth+orderLabelWidth+ OrderContext.ElementSpaceWidth * 3 );//16复选框的宽度

                     //如果除了CheckBox自身宽度   剩余宽度 <（_treatNameCheckBox）服务名称的安全宽度的话
                    if (surplusWidth < (OrderContext.OrderNameMinWidth + OrderContext.CheckBoxWidth)) 
                    {
                        _treatNameCheckBox.Size=new Size(OrderContext.OrderNameMinWidth + OrderContext.CheckBoxWidth,this.Size.Height);

                        int orderLabelMinWidth = this.Size.Width - OrderContext.SingleDrugDosageWidth - OrderContext.ExecuteDepartmentWidth - OrderContext.ElementSpaceWidth * 3 - _treatNameCheckBox.Size.Width;

                        _orderLabel.Size = new Size(orderLabelMinWidth,this.Size.Height);

                       
                    }
                    else
                    {
                        int trateNameMinWidth= this.Size.Width - OrderContext.SingleDrugDosageWidth - OrderContext.ExecuteDepartmentWidth - OrderContext.ElementSpaceWidth * 3 - orderLabelWidth;

                        _treatNameCheckBox.Size = new Size(trateNameMinWidth, this.Size.Height);

                        _orderLabel.Size = new Size(orderLabelWidth, this.Size.Height);
                    }

                    _treatNameCheckBox.IsShowToolTip = true;

                }
                else
                {
                    _treatNameCheckBox.Size = new Size(treatCheckBoxWidth + OrderContext.CheckBoxWidth, this.Size.Height);

                    _orderLabel.Size = new Size(this.Size.Width - (totalWidth - orderLabelWidth ),this.Size.Height);

                }

                //_treatNameCheckBox.Size = new Size(this.Size.Width - 70 - 4 - _excuteProject.Bound.Width, this.Size.Height);

                _treatNameCheckBox.Location = new Point(this.Location.X, this.Location.Y);
                _orderLabel.Location = new Point(_treatNameCheckBox.Bound.Right+ OrderContext.ElementSpaceWidth, this.Location.Y);
                _userNum.Location = new Point(_orderLabel.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);
                _excuteProject.Location = new Point(_userNum.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);
                
            }
            //TODO 后续如果支持这种模式的话，再去调整
            else if (this.TreatStyle.Equals("0"))
            {
                _userNum.Size = new Size(60, this.Size.Height);
                _freqXComboBox.Size = new Size(70, this.Size.Height);
                _userDays.Size = new Size(60, this.Size.Height);
                _excuteProject.Size = new Size(OrderContext.ExecuteDepartmentWidth, this.Size.Height);
                _treatNameCheckBox.Size = new Size(this.Size.Width - 70 - 70 - 48 - 4 * 3 - _excuteProject.Bound.Width, this.Size.Height);

                if (TextCellRender.MeasureText(_treatNameCheckBox.Text, _treatNameCheckBox.Font).Width > _treatNameCheckBox.Size.Width)
                {
                    _treatNameCheckBox.IsShowToolTip = true;
                }

                _treatNameCheckBox.Location = new Point(this.Location.X, this.Location.Y);
                _userNum.Location = new Point(_treatNameCheckBox.Bound.Right + 4, this.Location.Y);
                _freqXComboBox.Location = new Point(_userNum.Bound.Right+4, this.Location.Y);
                _userDays.Location = new Point(_freqXComboBox.Bound.Right+4, this.Location.Y);
                _excuteProject.Location = new Point(_userDays.Bound.Right + 4, this.Location.Y);
            }

           
        }

        void SizeChanged()
        {

        }

        //更新数据源到当前控件
        void UpdateDatasourceToRender()
        {
            if (String.IsNullOrEmpty(this.TreatStyle) || (this.TreatStyle.Equals("1")))//诊疗模式为1或者空（默认）
            {

                _treatNameCheckBox.Text = this._itemDo.Ortplnitm_srv_name;

                _orderLabel.ValueText = OrdStrUtil.OrdStrMosaic(this._itemDo.Price == null ? null : this._itemDo.Price.ToString(), this._itemDo.Name_hp);
                
                if (_itemDo.Fg_active.HasValue) //检查，设置是否启用CheckBox，默认启用
                {
                    this._treatNameCheckBox.Checked = (bool)_itemDo.Fg_active;
                }
                _userNum.Text = this._itemDo.Quan_med.ToString();
                _userNum.UnitText = this._itemDo.Ortplnitm_unit_name;
                _userNum.ValueTextChanged+=_userNum_ValueTextChanged;
                _excuteProject.ValueText = this._itemDo.Ortplnitm_mp_name;

            }
            else if (this.TreatStyle.Equals("0"))
            {
                _treatNameCheckBox.Text = this._itemDo.Ortplnitm_srv_name + OrdStrUtil.OrdStrMosaic(this._itemDo.Price == null ? null : this._itemDo.Price.ToString(), this._itemDo.Name_hp);

                //_orderLabel.ValueText = OrdStrUtil.OrdStrMosaic(this._itemDo.Price == null ? null : this._itemDo.Price.ToString(), this._itemDo.Name_hp);

                if (_itemDo.Fg_active.HasValue) //检查，设置是否启用CheckBox，默认启用
                {
                    this._treatNameCheckBox.Checked = (bool)_itemDo.Fg_active;
                }
                _userNum.Text = this._itemDo.Quan_med.ToString();
                _userNum.UnitText = this._itemDo.Ortplnitm_unit_name;
                _userNum.ValueTextChanged+=_userNum_ValueTextChanged;

                if (this.templatRstDTo != null)
                    _freqXComboBox.DataSource = this.templatRstDTo.getFreqdefdo();
                _freqXComboBox.ValueText = this.OrderDTo.Name_freq;
                _freqXComboBox.ValueTextChanged += _freqXComboBox_ValueTextChanged;


                _userDays.Text = this._itemDo.Days_or.ToString();
                _userDays.UnitText = "天";
                _userDays.ValueTextChanged += _userDays_ValueTextChanged;

                
            }

            if (_itemDo.Fg_active.HasValue)
            {
                _treatNameCheckBox.Enabled = (bool)_itemDo.Fg_active;
                _userNum.Enabled = (bool)_itemDo.Fg_active;
                _freqXComboBox.Enabled = (bool)_itemDo.Fg_active;
                _userDays.Enabled = (bool)_itemDo.Fg_active;
            }
            if (_treatNameCheckBox.Enabled)
            {
                if (_itemDo.Fg_checked.HasValue)
                {
                    _treatNameCheckBox.Checked = (bool)_itemDo.Fg_checked;
                }
            }
        }

        //使用天数-值发生变更的时候-回写到数据源
        void _userDays_ValueTextChanged(object sender, EventArgs e)
        {

            if (String.IsNullOrEmpty(_userDays.Text))
            {
                _itemDo.Days_or = null;
            }
            else
            {
                _itemDo.Days_or = Convert.ToInt32(_userDays.Text);
            }
        }

        //频次的值发生变更的时候-回写到数据源 
        void _freqXComboBox_ValueTextChanged(object sender, EventArgs e)
        {

            this.OrderDTo.Id_freq = this._freqXComboBox.ValueText;
            this.OrderDTo.Name_freq = this._freqXComboBox.ShowText;

            foreach (var item in this.OrderDTo.Itemlist)
            {
                if (item is OrTplNItmDO)
                {
                    (item as OrTplNItmDO).Id_freq = this._freqXComboBox.ValueText;
                    (item as OrTplNItmDO).Ortplnitm_freq_name = this._freqXComboBox.ShowText;
                }

            }
        }

        //剂量-值发生变更-回写到数据源
        void _userNum_ValueTextChanged(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(_userNum.Text))
            {
                _itemDo.Quan_med = null;
            }
            else
            {
                _itemDo.Quan_med = Convert.ToDouble(_userNum.Text);
            }
        }


        //选中状态发生变更时--回写到数据源
        void _treatNameCheckBox_ValueTextChanged(object sender, EventArgs e)
        {
            this.IsCanelProptypeChanged = true;
            this.ItemDo.Fg_checked = this._treatNameCheckBox.Checked;
            if (!IsCanel && !this.IsFirstLoad && this.ItemCheckChangd != null)
            {
                ItemCheckChangd(this, EventArgs.Empty);
            }
            this.IsCanelProptypeChanged = false;
        }

        #endregion

    }
}
