using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.ciorder.render.order
{
    /// <summary>
    /// 医嘱扩展接口
    /// </summary>
    public interface IExtOrder
    {
        /// <summary>
        /// 树节点的选中状态发生变更时
        /// </summary>
        event EventHandler SelectValueChanged;

        /// <summary>
        /// 树节点双击时触发
        /// </summary>
         event EventHandler DoubleClick;

         /// <summary>
         /// 创建当前树节点的辅助工具
         /// </summary>
          OrderExtAssist ExtAssist { get; set; }

        /// <summary>
        /// 复选框是否选中
        /// </summary>
         bool IsFirstChecked { get; set; } 

        /// <summary>
        /// 树节点的总的宽度
        /// </summary>
        int TotalWidth { get; set; }

        /// <summary>
        /// 是不是第一次加载
        /// </summary>
        bool IsFirstLoad { get; set; }

       
    }
}
