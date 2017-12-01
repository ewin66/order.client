/* =======================================================
 * FileName：PrintTool
 * Date：2016/7/21 17:37:23
 * Compiler：Microsoft Visual Studio 2010
 * Author：yzh
 * Company：Copyright 2016 by PKU healthcare IT Co.,Ltd.
 * Description：打印工具类
 * =======================================================
 */

using System;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.extentions;
using xap.rui.engine;
using xap.rui.control.engine.attributes;
using xap.rui.control.forms.model;
using xap.rui.control.forms.control;
using xap.dp.rptview.viewer;
using xap.rui.engine.eventbroker;
using xap.rui.engine.eventbroker.Handlers;
using xap.cli.sdk.form;
using xap.cli.sdk.controls;
using xap.rui.control.forms.view;
using System.Collections.Generic;


namespace iih.ci.ord.opemergency.tool
{
    /// <summary>
    /// 打印类
    /// author：yzh
    /// reviewer：
    /// </summary>
    internal class PrintTool
    {


        /// <summary>
        /// 标本卡打印（直接打印）
        /// </summary>
        /// <param name="ident">就诊ID</param>
        /// <param name="data">标本数据 类型(dto.name,dto.code)|(dto.name,dto.code),先以|拆分 dto在以,分割dto数据</param>
        /// /// <param name="data">卡类型：1（标本卡）</param>
        /// <param name="isShowPreview">是否显示预览</param>
        public static void PrintCard(string ident,string data, int cardType,bool isShowPreview,BaseContext context)
        {
            // 报表查询参数
            string paramIdent = ident;
            string paramData = data;
            if (paramIdent == null || paramIdent.Length == 0)
            {
                return;
            }

            // 创建打印报表
            ReportViewer rptview = new ReportViewer(DockStyle.Top, PrintConstant.rptInitZoom, true);

            // 生成报表并刷新到界面上
            Dictionary<string, string> qry_params = new Dictionary<string, string>();
            qry_params.Add("ident", paramIdent);
            qry_params.Add("data", paramData);
            bool res = false;
          
            if (cardType == PrintConstant.TYPE_BODY_CARD)//标本卡
            {
                res = rptview.ShowRptFile(PrintConstant.URL_REPORT_SAMPCARD, qry_params);
            }
            if (!res)
            {
                return;
            }
            // 打印
            rptview.PrintRptFile(isShowPreview);
        }
    }
}
