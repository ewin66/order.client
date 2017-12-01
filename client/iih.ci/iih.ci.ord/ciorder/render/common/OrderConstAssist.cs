/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/15 14:49:30
* Filename    : OrderConstAssist
* Project     : iih.ci.ord.ciorder.render.common
* Username    : f
* Description : 医嘱模板常量定义--根据大小屏去适配得到最合适的字体
 * 
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using iih.common_stub.datong.data;
using xap.cli.sdk.common;

namespace iih.ci.ord.ciorder.render.common
{
    /// <summary>
    ///  医嘱模板常量定义--根据大小屏去适配
    /// </summary>
    public static class OrderConstAssist
    {
        #region 属性

        /// <summary>
        /// 医嘱模板-服务停用距离上方的偏移
        /// </summary>
        public static int ServerStopPre
        {
            get
            {
                if (RelativeUIParam.ScreenSize == ScreenSize.Large)
                {
                    return OrderContext.LargeServerStopPre;
                }
                else
                {
                    return OrderContext.SmallServerStopPre;
                }
            }
        }


        /// <summary>
        /// 医嘱模板的单位控件-距离上方的偏移
        /// </summary>
        public static int SimpleUnitPreY
        {
            get
            {
                if (RelativeUIParam.ScreenSize == ScreenSize.Large)
                {
                    return OrderContext.LargeSimpleUnitPreY;
                }
                else
                {
                    return OrderContext.SmallSimpleUnitPreY;
                }
            }
        }

        /// <summary>
        ///大屏下- 简易模板-自定义的OrderLabel起始偏移
        /// </summary>
        public static int SimpleUserDefinePreY
        {
            get
            {
                if (RelativeUIParam.ScreenSize == ScreenSize.Large)
                {
                    return OrderContext.LargeSimpleUserDefinePreY;
                }
                else
                {
                    return OrderContext.SmallSimpleUserDefinePreY;
                }
            }
        }


        /// <summary>
        /// 医嘱模板的字体
        /// </summary>
        public static Font OrderFont
        {
            get
            {
                if (RelativeUIParam.ScreenSize == ScreenSize.Large)
                {
                    return OrderContext.OrderLargeFont;
                }
                else
                {
                    return OrderContext.OrderSmallFont;
                }
               
            }
        }


        /// <summary>
        /// 医嘱模板控件行高
        /// </summary>
        public static int OrderRenderHeight
        {
            get
            {
                if (RelativeUIParam.ScreenSize == ScreenSize.Large)
                {
                    return OrderContext.LargeRenderHeight;
                }
                else
                {
                    return OrderContext.SmallRenderHeight;
                }
            }
        }

        /// <summary>
        /// 医嘱简易模板-用户自定义单项高度
        /// </summary>
        public static int UserDefineItemHeight
        {
            get
            {
                if (RelativeUIParam.ScreenSize == ScreenSize.Large)
                {
                    return OrderContext.LargeUserDefinedItemHeight;
                }
                else
                {
                    return OrderContext.SmallUserDefinedItemHeight;
                }
            }
        }




        #endregion

        #region 构造


        #endregion

        #region 内部处理

        #endregion

        #region 对外接口

        #endregion

        #region Dispose

        #endregion
    }
}
