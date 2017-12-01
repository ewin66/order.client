using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.dto.newordertemplatedto.d;

namespace iih.ci.ord.ciorder.render.complexOrder
{
    /// <summary>
    /// 复杂医嘱模板扩展接口
    /// </summary>
    public interface IComplexExtOrder
    {
        /// <summary>
        /// 树节点双击时触发
        /// </summary>
        event EventHandler DoubleClick;

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
    }
}
