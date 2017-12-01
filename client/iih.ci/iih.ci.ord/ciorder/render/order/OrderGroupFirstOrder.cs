/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/6/5 11:56:40
* Filename    : OrderGroupFirstOrder
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 成组药一级节点
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.render.interfaces;
using xap.cli.sdk.render;

namespace iih.ci.ord.ciorder.render.order
{
    /// <summary>
    /// 成组药一级节点
    /// </summary>
    public class OrderGroupFirstOrder : XAPTreeNodeRender, IExtOrder
    {
        public event EventHandler SelectValueChanged;

        private void FireSelectValueChanged()
        {
            if (SelectValueChanged != null)
            {
                SelectValueChanged(this, null);
            }
        }

        public event EventHandler DoubleClick;

        private void FireDoubleClick()
        {
            if (DoubleClick != null)
            {
                DoubleClick(this, null);
            }
        }

        public OrderExtAssist ExtAssist { get; set; }

        public bool IsFirstChecked { get; set; }

        public int TotalWidth { get; set; }

        public bool IsFirstLoad { get; set; }

        public bool IsCanel { get; set; }
    }
}
