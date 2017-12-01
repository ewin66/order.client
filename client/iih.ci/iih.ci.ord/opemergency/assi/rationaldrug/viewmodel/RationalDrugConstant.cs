
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.assi.rationaldrug.viewmodel
{
    /// <summary>
    /// <para>描    述 : 合理用药常量类</para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.rationaldrug.viewmodel    </para>    
    /// <para>类 名 称 :  RationalDrugConstant					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/9/12 19:30:54</para>
    /// <para>更新时间 :  2016/9/12 19:30:54</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class RationalDrugConstant
    {
        #region 事件常量

        /// <summary>
        /// 合理用药数据
        /// </summary>
        public const string RATIONAL_USE_DATA = "RationalUseData";

        /// <summary>
        /// 药品编码
        /// </summary>
        public const string CODE_MM = "CodeMm";

        /// <summary>
        /// 药品名称
        /// </summary>
        public const string NAME_MM = "NameMm";


        /// <summary>
        /// 要点提示事件
        /// </summary>
        public const string MAIN_POINTS_EVENT = "MainPointsEvent";

        /// <summary>
        /// 发送要点提示事件
        /// </summary>
        public const string FIRE_MAIN_POINTS_EVENT = "FireMainPointsEvent";

        /// <summary>
        /// 要点提示反馈事件
        /// </summary>
        public const string FIRE_MAIN_POINTS_RESULT_EVENT = "FireMainPointsResultEvent";

        #endregion

    }
}
