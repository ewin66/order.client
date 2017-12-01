/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 复杂模板-检查检验一级节点
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
using xap.rui.control.extentions;

namespace iih.ci.ord.ciorder.render.complexOrder
{
    /// <summary>
    /// 检查检验（套--一级节点）非套（节点）
    /// </summary>
    public class LisComplexFirstOrdrRender : XRenderGroup, IComplexExtOrder 
    {
        
        #region 属性


        /// <summary>
        /// 是否撤销选中操作
        /// 成组药品的模式下。，选择父，子全选
        /// 选择子，父选中，但是此时父选中有多个字的话其他的子也会选中，这种交互有问题
        /// 故特意加属性控制
        /// 可以在设置父选中之前设置IsCanel=true,然后再让父选中，禁止往外发ValueChanged的事件
        /// </summary>
        public bool IsCanel { get; set; }

        /// <summary>
        /// 是否不执行属性变更引发的操作
        /// </summary>
        public bool IsCanelProptypeChanged { get; set; }

        /// <summary>
        /// 医嘱实体
        /// </summary>
        public NewOrderTemplateDTO OrderDTo { get; set; }

        /// <summary>
        /// 主要用于频次，用法，煎法数据源的获得
        /// </summary>
        public OrderTemplateRstDTO templatRstDTo { get; set; }
        /// <summary>
        /// 检查检验 套的二级节点的集合
        /// </summary>
        public List<LisComplexSecondOrder> SecondOrderCollections { get; set; }


        /// <summary>
        /// 检查检验兄弟节点的集合（包含本身）
        /// </summary>
        public List<LisComplexFirstOrdrRender> BrotherOrderCollecions { get; set; }

        /// <summary>
        /// 承载容器
        /// </summary>
        public System.Windows.Forms.Control Owner { get; set; }

        /// <summary>
        /// 是否是顶级节点
        /// </summary>
        public bool IsTopLevelNode { get; set; }


        /// <summary>
        /// 树节点双击时触发
        /// </summary>
        public event EventHandler OrderDoubleClick;

        /// <summary>
        /// 选中状态发生变更
        /// </summary>
        public event EventHandler ItemCheckChangd;

        /// <summary>
        /// 是否第一次加载
        /// </summary>
        public  bool IsFirstLoad { get; set; }

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
        /// 是否选中
        /// </summary>
        public bool IsChecked
        {
            get { return this._checkBox.Checked; }
            set
            {
                this._checkBox.Checked = value;
                
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

        //检查检验非套的一级节点数据源
        private OrTplNItmDO _itemDo;

        //检查检验套的dto

        private NewOrderTemplateDTO _listGroupDo;

        //医嘱模板（检查检验）一级节点元素(名称)
        private OrderCheckBox _checkBox;

        /// <summary>
        /// （单价，分类）---承载Label
        /// </summary>
        private OrderLabel _orderLabel;

        //执行科室->承载Label
        private OrderLabel _departmentLabel;

        /// <summary>
        /// 复选框文字的颜色
        /// </summary>
        public Color CheekBoxForeColor
        {
            get { return this._checkBox.ForeColor; }
            set { this._checkBox.ForeColor = value; }
        }


        #endregion

        #region 构造

        public LisComplexFirstOrdrRender()
        {
            Init();
        }

        void Init()
        {
            this.IsFirstLoad = true;
            this.IsTopLevelNode = true;

            _checkBox = new OrderCheckBox();
            _checkBox.ValueTextChanged += _checkBox_ValueTextChanged;
            this.AddRender(_checkBox);

            this._checkBox.MouseDoubleClick += LisFirstOrdrRender_MouseDoubleClick;

            _orderLabel=new OrderLabel();
            _orderLabel.TextBrush=new SolidBrush(Color.FromArgb(0,153,229));
            this.AddRender(_orderLabel);

            _departmentLabel=new OrderLabel();
            _departmentLabel.TextBrush = new SolidBrush(Color.FromArgb(0, 153, 229));
            _departmentLabel.Format=new StringFormat()
            {
                LineAlignment = StringAlignment.Center,
                Alignment = StringAlignment.Far
            };
            this.AddRender(_departmentLabel);
        }

        #endregion

        #region 内部处理

        //CheckBox选中操作，用于控制子
        void _checkBox_ValueTextChanged(object sender, EventArgs e)
        {
            IsCanelProptypeChanged = true;

            if (this._itemDo!=null)
                this._itemDo.Fg_checked = this.IsChecked;//控件状态发生变化时，回写控件的值到数据源

            if (this.LisGroupDo != null && !IsCanelProptypeChanged)
                this.LisGroupDo.Fg_checked = this.IsChecked;//控件状态发生变化时，回写控件的值到数据源

            if (ItemCheckChangd != null && !IsFirstLoad && !IsCanel)
            {
                ItemCheckChangd(this, EventArgs.Empty);
            }

            IsCanelProptypeChanged = false;
        }

        //双击
        void LisFirstOrdrRender_MouseDoubleClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            // CheckBox(复选框)文字区域 双击发出双击事件
            if (this.OrderDoubleClick != null && _checkBox.TextRect.Contains(e.Location))
            {
                OrderDoubleClick(this, EventArgs.Empty);
            }
        }

        //DO数据源发生变更时
        void DataValueChanged(Object obj)
        {
            if (!IsCanelProptypeChanged)
                //数据源变更时，为控件赋值
                UpdateDatasourceToRender(obj);
            this.IsFirstLoad = false;
        }


        //将数据源与控件绑定起来
        void UpdateDatasourceToRender(Object obj)
        {
            if (obj is NewOrderTemplateDTO)//检查检验成套一级节点
            {
                NewOrderTemplateDTO tempDo = obj as NewOrderTemplateDTO;
                tempDo.PropertyChanged += tempDo_PropertyChanged;

//                  _checkBox.Text = tempDo.Name + OrdStrUtil.OrdStrMosaic(tempDo.Price == null ? null : tempDo.Price.ToString(), tempDo.Name_hp) + "  " + tempDo.Ortplnitm_mp_name + "";

                //将服务名称-（单价，分类）-科室进行拆分

                _checkBox.Text = tempDo.Name;

                _orderLabel.ValueText = OrdStrUtil.OrdStrMosaic(tempDo.Price == null ? null : tempDo.Price.ToString(), tempDo.Name_hp);

                _departmentLabel.ValueText = tempDo.Ortplnitm_mp_name;
                    
                if (tempDo.Fg_active.HasValue) //检查，设置是否启用CheckBox，默认启用
                {
                    this._checkBox.Enabled = (bool)tempDo.Fg_active;
                }
                if (this._checkBox.Enabled)
                {
                    if (tempDo.Fg_checked.HasValue)
                    {
                        _checkBox.Checked = (bool)tempDo.Fg_checked;
                    }
                }
               
            }
            else if (obj is OrTplNItmDO)//检查检验非套的一级节点
            {
                OrTplNItmDO tempDo = obj as OrTplNItmDO;
                tempDo.PropertyChanged += tempDo_PropertyChanged;

                //将服务名称-（单价，分类）-科室进行拆分
                _checkBox.Text = tempDo.Ortplnitm_srv_name;

                _orderLabel.ValueText = OrdStrUtil.OrdStrMosaic(tempDo.Price == null ? null : tempDo.Price.ToString(), tempDo.Name_hp);
               
                _departmentLabel.ValueText = tempDo.Ortplnitm_mp_name;

              //  _checkBox.Text = tempDo.Ortplnitm_srv_name + OrdStrUtil.OrdStrMosaic(tempDo.Price == null ? null : tempDo.Price.ToString(), tempDo.Name_hp) + "  " + tempDo.Ortplnitm_mp_name + "";
                if (tempDo.Fg_active.HasValue) //check for a value
                {
                    this._checkBox.Enabled = (bool)tempDo.Fg_active;
                }
                if (this._checkBox.Enabled)
                {
                    if (tempDo.Fg_checked.HasValue)
                    {
                        _checkBox.Checked = (bool)tempDo.Fg_checked;
                    }
                }
                
            }
           
        }

        //Do的数据源的值发生变更时触发
        void tempDo_PropertyChanged(object sender, System.ComponentModel.PropertyChangedEventArgs e)
        {
            //数据源变更时，为控件赋值
            UpdateDatasourceToRender(sender);
        }

        //位置发生变更时,对上面的元素的位置同时进行调整
        void LocationChanged()
        {
            _checkBox.Location = new Point(this.Location.X + 2, this.Location.Y);

            int checkBoxWidth = (int)TextCellRender.MeasureText(_checkBox.Text, _checkBox.Font).Width+1;//服务名称

            int orderLabelWidth = (int)TextCellRender.MeasureText(_orderLabel.ValueText, _orderLabel.Font).Width+1;//单价，分类

            int departmentWidth = (int)TextCellRender.MeasureText(_departmentLabel.ValueText, _departmentLabel.Font).Width+1;//执行科室

            int totalWidth = (checkBoxWidth + OrderContext.CheckBoxWidth) + orderLabelWidth + departmentWidth + OrderContext.ElementSpaceWidth * 2;

            if (totalWidth < this.Size.Width)//展示元素的总宽度<可用于显示的宽度（科室居右对齐，其他元素从左往右平铺）
            {
                _checkBox.Size = new Size(checkBoxWidth + OrderContext.CheckBoxWidth, this.Size.Height);
                _orderLabel.Size = new Size(orderLabelWidth, this.Size.Height);
            }
            else
            {
                //分两种情况
                //1：如果用于服务名称可显示的宽度大于最小保留宽度（OrderContext.OrderNameMinWidth+ OrderContext.CheckBoxWidth) 则压缩服务名称（...）

                //2：如果用于服务名称可显示的宽度小于最小保留宽度（OrderContext.OrderNameMinWidth+ OrderContext.CheckBoxWidth) 则压缩(单价分类)的显示区域（...）

                _checkBox.IsShowToolTip = true;

                int minCheckBoxWidth = this.Size.Width - orderLabelWidth - departmentWidth - OrderContext.ElementSpaceWidth*2;

                if (minCheckBoxWidth >(OrderContext.OrderNameMinWidth+ OrderContext.CheckBoxWidth))
                {
                    _checkBox.Size = new Size(minCheckBoxWidth + OrderContext.CheckBoxWidth, this.Size.Height); 
                     _orderLabel.Size = new Size(orderLabelWidth, this.Size.Height);
                }
                else
                {
                    _checkBox.Size = new Size(OrderContext.OrderNameMinWidth + OrderContext.CheckBoxWidth,this.Size.Height);

                    int minOrderLabelWidth = this.Size.Width - (OrderContext.OrderNameMinWidth + OrderContext.CheckBoxWidth) - OrderContext.ElementSpaceWidth * 2 - orderLabelWidth - departmentWidth;

                    _orderLabel.Size = new Size(minOrderLabelWidth, this.Size.Height);
                }
                                      
              
            }

            _departmentLabel.Size = new Size(departmentWidth,this.Size.Height);

            _checkBox.Location = new Point(this.Location.X, this.Location.Y);

            _orderLabel.Location = new Point(_checkBox.Bound.Right + OrderContext.ElementSpaceWidth, this.Location.Y);

            _departmentLabel.Location = new Point(this.Bound.Right - departmentWidth, this.Location.Y);


        }

        //控件大小发生变更时，对上面的元素的大小同时调整
        //之所以传值是因为树节点内部进行处理在获取Size时有部分操作，会造成递归调用
        void SizeChanged()
        {
           /* _checkBox.Size = new Size(this.Size.Width - 2, this.Size.Height);
            if (TextCellRender.MeasureText(_checkBox.Text, _checkBox.Font).Width > this._checkBox.Size.Width)
            {
                _checkBox.IsShowToolTip = true;
            }*/
        }

        #endregion
      
    }
}
