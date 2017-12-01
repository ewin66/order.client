/* =======================================================
 * FileName：PrintConstant
 * Date：2017-08-19 08:50:02
 * Compiler：Microsoft Visual Studio 2010
 * Author：yzh
 * Company：Copyright 2016 by PKU healthcare IT Co.,Ltd.
 * Description：病理医疗单标本打印常量
 * =======================================================
 */

namespace iih.ci.ord.opemergency.tool
{
    /// <summary>
    /// 病理医疗单标本打印
    /// author：yzh 2017-08-19 08:49:49
    /// reviewer：
    /// </summary>
    class PrintConstant
    {
        public const int TYPE_BODY_CARD = 1;//标本卡
        // 报表查询参数间隔符
        public const string RPT_QRY_SYMBOL = "_";

        // 报表打印界面初始化显示大小
        public const string rptInitZoom = "75%";

     
        // 腕带打印报表模板路径
        public const string URL_REPORT_SAMPCARD = "iih_report/sampcardprint/sampcardprint.xml";

    }
}
