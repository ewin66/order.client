
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.ciorder.ciorderprn.viewmodel
{
    /// <summary>
    /// <para>描    述 : 医嘱打印相关常量</para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.ciorderprn.viewmodel    </para>    
    /// <para>类 名 称 :  OrdPrintConstant					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/8/19 13:35:47</para>
    /// <para>更新时间 :  2016/8/19 13:35:47</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OrdPrintConst
    {
        #region 打印模式

        /// <summary>
        /// 一般打印
        /// </summary>
        public const string PRINT_MODE_CONTINUE = "1";

        /// <summary>
        /// 重整打印
        /// </summary>
        public const string PRINT_MODE_RESET = "2";

        /// <summary>
        /// 撤销打印（作废）
        /// </summary>
        public const string PRINT_MODE_CANCEL = "3";

        /// <summary>
        /// 停止打印
        /// </summary>
        public const string PRINT_MODE_STOP = "4";

        /// <summary>
        /// 单页补打
        /// </summary>
        public const string PRINT_MODE_SINGLE = "5";

        /// <summary>
        /// 浏览全部已打数据
        /// </summary>
        public const string PRINT_MODE_ALLBROWSE = "6";

        #endregion

        public const string ORDERACTION = "OrderAction";
        public const string LONGACTION = "LongAction";
        public const string TEMPACTION = "TempAction";

        public const string DOPREVIEW = "DoPreview";
        public const string DOPRINT = "DoPrint";
        public const string DOSORT = "DoSort";
        public const string DOCLEAR = "DoClear";

        public const string CLEARDATAPREVIEW = "ClearDataPreview";
        public const string ONLONGTEMPCHANGE = "OnLongTempChange";

    }
}
