/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/13 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 医嘱模板渲染常量定义
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;

namespace iih.ci.ord.ciorder.render.common
{
    /// <summary>
    /// 医嘱模板渲染常量定义
    /// </summary>
    public static class OrderContext
    {
     

        /// <summary>
        /// 服务停用的画笔颜色
        /// </summary>
        public static Color ServIceStopColor = Color.FromArgb(245, 0, 0);


        /// <summary>
        /// 服务停止标志宽度
        /// </summary>
        public static int ServerStopWidth = 14;


        /// <summary>
        /// 服务停止标志距离左侧的偏移
        /// </summary>
        public static int ServerStopPreX = 4;

        /// <summary>
        /// 大屏下服务停用距离上方的距离
        /// </summary>
        public static int LargeServerStopPre = 10;

        /// <summary>
        /// 大屏下服务停用距离上方的距离
        /// </summary>
        public static int SmallServerStopPre = 8;


        /// <summary>
        /// 大屏下的单位控件的起始偏移
        /// </summary>
        public static int LargeSimpleUnitPreY = 2;

        /// <summary>
        ///大屏下- 简易模板-自定义的OrderLabel起始偏移
        /// </summary>
        public static int LargeSimpleUserDefinePreY = 2;


        /// <summary>
        /// 小屏下的单位控件的起始偏移
        /// </summary>
        public static int SmallSimpleUnitPreY = 2;

        /// <summary>
        ///小屏下- 简易模板-自定义的OrderLabel起始偏移
        /// </summary>
        public static int SmallSimpleUserDefinePreY = 4;




        /// <summary>
        /// 小屏下-简易模板-用户自定义行高
        /// </summary>
        public static int SmallUserDefinedItemHeight = 29;

        /// <summary>
        /// 大屏下-简易模板-用户自定义行高
        /// </summary>
        public static int LargeUserDefinedItemHeight = 33;




        /// <summary>
        /// 医嘱字体(简易模板)
        /// </summary>
        public static Font OrderFont = new Font("微软雅黑", 12, GraphicsUnit.Pixel);

        /// <summary>
        /// 医嘱模板（大屏下的字体）
        /// </summary>
        public static Font OrderLargeFont = new Font("微软雅黑", 14, GraphicsUnit.Pixel);

        /// <summary>
        /// 医嘱模板（小屏下的字体）
        /// </summary>
        public static Font OrderSmallFont = new Font("微软雅黑", 12, GraphicsUnit.Pixel);

        /// <summary>
        /// 小屏下的控件高度 
        /// </summary>
        public static int SmallRenderHeight = 24;

        /// <summary>
        // /大屏下的控件高度 
        /// </summary>
        public static int LargeRenderHeight = 28;

      
        /// <summary>
        /// 单行行高(复杂模板)
        /// </summary>
        public static int ComplexSingleHeight = 24;

        /// <summary>
        /// 单行行高(复杂模板)
        /// </summary>
        public static int ComplexSingleBigScreenHeight = 28;

        /// <summary>
        /// 行与行之间间距（复杂模板）
        /// </summary>
        public static int ComplexSingleRowHeight = 4;



        /// <summary>
        /// 留白宽度-一级（复杂模板）
        /// </summary>
        public static int ComplexFirstEmptyWidth = 20;

        /// <summary>
        /// 留白高度--上方（复杂模板）
        /// </summary>
        public static int ComplexTopEmptyHeight = 10;

        /// <summary>
        /// 留白宽度-二级（复杂模板）
        /// </summary>
        public static int ComplexSecondEmptyWidth = 20;

        /// <summary>
        /// 医嘱服务单列的宽度（复杂模板）
        /// </summary>
        public static int ServerSingleColWidth = 430;

        /// <summary>
        ///  医嘱服务单列之间的间隔(复杂模板)
        /// </summary>
        public static int ComplexColSpace = 20;

        /// <summary>
        /// 频次宽度
        /// </summary>
        public static int FreqOrderWidth = 80;

        /// <summary>
        /// 使用天数宽度
        /// </summary>
        public static int UserDaysWidth = 60;

        /// <summary>
        /// 执行科室宽度
        /// </summary>
        public static int ExecuteDepartmentWidth = 100;

        /// <summary>
        /// 单次使用剂量的宽度
        /// </summary>
        public static int SingleDrugDosageWidth = 70;

        /// <summary>
        /// 使用天数，频次等元素之间的间隔
        /// </summary>
        public static int ElementSpaceWidth = 8;

        /// <summary>
        /// 医嘱名称最小宽度
        /// </summary>
        public static int OrderNameMinWidth = 30;

        /// <summary>
        /// 复选框小方块的宽度
        /// </summary>
        public static int CheckBoxWidth = 16;

        /// <summary>
        /// 标题的刷子
        /// </summary>
        public static SolidBrush TitleBrush=new SolidBrush(Color.FromArgb(0,153,229));
    }
}
