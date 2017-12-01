
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.ciorder.orreport
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.orreport    </para>    
    /// <para>类 名 称 :  ReportCodeDict					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/11/1 11:33:50             </para>
    /// <para>更新时间 :  2016/11/1 11:33:50             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class ReportCodeDict
    {
        /// <summary>
        /// 医保审核
        /// </summary>
        public const int HP_REPORT_CODE = 1;
        /// <summary>
        /// 临床路径审核
        /// </summary>
        public const int UNCPOR_REPORT_CODE = 2;

        public const string HP_REPORT_TITLE = "医保审核";
        public const string UNCPOR_REPORT_TITLE = "临床路径审核";

        public const string HP_TREAT_ALL_SELECT = "适应症全选";
        public const string HP_TREAT_ALL_BLANK = "适应症全不选";

        public static Dictionary<int, string> REPORT_DICT = new Dictionary<int, string>()
        {
            {ReportCodeDict.HP_REPORT_CODE,ReportCodeDict.HP_REPORT_TITLE},{ReportCodeDict.UNCPOR_REPORT_CODE,ReportCodeDict.UNCPOR_REPORT_TITLE}
        };
    }
}
