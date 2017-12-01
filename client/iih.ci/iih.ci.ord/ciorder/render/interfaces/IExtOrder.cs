/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description :简易版本-医嘱扩展接口
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.render.order;

namespace iih.ci.ord.ciorder.render.interfaces
{
    /// <summary>
    /// 简易版本-医嘱扩展接口
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

        /// <summary>
        /// 是否取消当前操作
        /// </summary>
        bool IsCanel { get; set; }
       
    }
}
