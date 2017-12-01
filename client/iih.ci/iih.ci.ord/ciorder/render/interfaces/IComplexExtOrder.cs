/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 复杂医嘱模板扩展接口
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.dto.newordertemplatedto.d;
using iih.ci.iih.ci.ord.dto.newordertemplatedto.d;

namespace iih.ci.ord.ciorder.render.interfaces
{
    /// <summary>
    /// 复杂医嘱模板扩展接口
    /// </summary>
    public interface IComplexExtOrder
    {
        // <summary>
        /// 是否不执行属性变更引发的操作
        /// </summary>
        bool IsCanelProptypeChanged { get; set; }

        /// <summary>
        /// 树节点双击时触发
        /// </summary>
        event EventHandler OrderDoubleClick;

        /// <summary>
        /// 选中状态发生变更
        /// </summary>
        event EventHandler ItemCheckChangd;

        /// <summary>
        /// 是否是顶级节点
        /// </summary>
        bool IsTopLevelNode { get; set; }

        /// <summary>
        /// 承载当前Render的容器
        /// </summary>
        Control Owner { get; set; }

        /// <summary>
        /// 是否是第一次的加载
        /// </summary>
        bool IsFirstLoad { get; set; }

        /// <summary>
        /// 是否选中
        /// </summary>
        bool IsChecked { get; set; }

        /// <summary>
        /// 医嘱实体
        /// </summary>
        NewOrderTemplateDTO OrderDTo { get; set; }
        /// <summary>
        /// 主要用于频次，用法，煎法数据源的获得
        /// </summary>
        OrderTemplateRstDTO templatRstDTo{get;set;}

        /// <summary>
        /// 是否终止当前事件-不在继续往下传递
        /// </summary>
        bool IsCanel { get; set; }
    
    }
}
