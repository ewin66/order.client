/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 复杂模板-检查检验而级节点
*****************************************************************************/

using System;
using System.Collections.Generic;
using System.Diagnostics.Eventing.Reader;
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
    ///  检查检验（复杂版） 二级节点
   /// </summary>
    public class LisComplexSecondOrder:XRenderGroup,IComplexExtOrder
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
        /// 双击时触发
        /// </summary>
        public event EventHandler OrderDoubleClick;

        /// <summary>
        /// 选中状态发生变更时
        /// </summary>
        public event EventHandler ItemCheckChangd;

        /// <summary>
        /// 是否是顶级节点
        /// </summary>
        public bool IsTopLevelNode { get; set; }

        /// <summary>
        /// 当前Render的承载容器
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
        /// 检查检验二级节点兄弟节点的集合（包含本身）
        /// </summary>
        public List<LisComplexSecondOrder> BrotherOrderCollecions { get; set; }


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

        private OrderCheckBox _checkBox;

        /// <summary>
        /// 父节点
        /// </summary>
        public LisComplexFirstOrdrRender ParentOrderRender { get; set; }


        #endregion

        #region 构造

        public LisComplexSecondOrder()
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
            this.CanFocus = false;
            this._checkBox.MouseDoubleClick += LisSecondOrder_MouseClick;
        }

        #endregion

        #region 内部处理

        //选中状态发生变更
        void _checkBox_ValueTextChanged(object sender, EventArgs e)
        {
            this.IsCanelProptypeChanged = true;

            this._itemDo.Fg_checked = this._checkBox.Checked;//将控件的值回写到数据源
            if (!IsCanel && ItemCheckChangd != null && !IsFirstLoad)
            {
                ItemCheckChangd(this,EventArgs.Empty);
            }

            this.IsCanelProptypeChanged = false;
        }

        //双击
        void LisSecondOrder_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            // CheckBox(复选框)文字区域 双击发出双击事件
            if (OrderDoubleClick != null && _checkBox.TextRect.Contains(e.Location))
            {
                OrderDoubleClick(this, EventArgs.Empty);
            }
        }

        //数据源发生变更时
        void ItemDoChanged()
        {
            this._itemDo.PropertyChanged += _itemDo_PropertyChanged;
            UpdateDatasourceToRender();
            IsFirstLoad = false;
        }

        //将数据源与控件进行绑定
       void UpdateDatasourceToRender()
       {
           _checkBox.Text = this._itemDo.Ortplnitm_srv_name;

           
           if (this.OrderDTo.Fg_active.HasValue && !(bool) this.OrderDTo.Fg_active)
           {
              // this._checkBox.Enabled = false;
           }
           else
           {
               if (_itemDo.Fg_active.HasValue) //检查，设置是否启用CheckBox，默认启用
               {
                 //  this._checkBox.Enabled = (bool)_itemDo.Fg_active;
               }
           }
           if (!(this.OrderDTo.Fg_active.HasValue && !(bool)this.OrderDTo.Fg_active))
           {
               if (this._itemDo.Fg_checked.HasValue)
               {
                   this._checkBox.Checked = (bool)this._itemDo.Fg_checked;
               }
           }
           if (this._itemDo.Fg_edit.HasValue&&!((bool)this._itemDo.Fg_edit))
           {
               this._checkBox.ReadOnly = true;
               this._checkBox.Enabled = false;
           }
          
       }


        //Do数据源的某个属性发生变更
        void _itemDo_PropertyChanged(object sender, System.ComponentModel.PropertyChangedEventArgs e)
        {
            if (!this.IsCanelProptypeChanged)
                 UpdateDatasourceToRender();
        }

        //Location发生变更时
        void LocationChanged()
        {
            _checkBox.Location = new Point(this.Location.X + 2, this.Location.Y + 4);
        }

        //Size发生变更时
        void SizeChanged()
        {
            _checkBox.Size = new Size(this.Size.Width - 2 - 1, 24);
            if (TextCellRender.MeasureText(_checkBox.Text, _checkBox.Font).Width > this._checkBox.Size.Width)
            {
                _checkBox.IsShowToolTip = true;
            }
        }

       public override void Render(Graphics g)
       {
           base.Render(g);
       }

       #endregion

    }
}
