
using iih.ci.diag.dto.d;
using iih.ci.ord.ciorder.d;
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.coreitf.d;
using xap.rui.engine;

namespace iih.ci.ord.common.log
{
    /// <summary>
    /// <para>描    述 :  构造日志输出字符串</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.common.log</para>    
    /// <para>类 名 称 :  LogManagerUtil</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2017/10/14 9:24:52</para>
    /// <para>更新时间 :  2017/10/14 9:24:52</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class LogManagerUtil
    {
        /// <summary>
        /// 根据当前上下文环境输出患者日志
        /// </summary>
        /// <param name="context">当前环境上下文</param>
        /// <param name="msg">日志内容</param>
        public static string GetEnInfo(string msg, BaseContext context)
        {
            return GetWriteLog(msg, context, null);
        }

        /// <summary>
        /// 根据患者就诊情况输入日志
        /// </summary>
        /// <param name="banner">患者banner</param>
        /// <param name="msg">日志内容</param>
        public static string GetEnInfo(string msg, Ent4BannerDTO banner)
        {
            return GetWriteLog(msg, null, banner);
        }

        /// <summary>
        /// 根据就诊环境输出日志
        /// </summary>
        /// <param name="context">上下文环境</param>
        /// <param name="banner">患者banner</param>
        /// <param name="msg">日志内容</param>
        public static string GetEnInfo(string msg, BaseContext context, Ent4BannerDTO banner)
        {
            return GetWriteLog(msg, context, banner);
        }

        /// <summary>
        /// 获取医嘱日志信息
        /// </summary>
        /// <param name="ciOrders">医嘱集合</param>
        /// <param name="msg"></param>
        /// <returns></returns>
        public static string GetCiOrdInfo(string msg, CiOrderDO[] ciOrders)
        {
            StringBuilder builder = new StringBuilder();
            if (!string.IsNullOrEmpty(msg))
            {
                builder.Append(msg);
            }

            if (ciOrders != null)
            {
                foreach (CiOrderDO ciOrder in ciOrders)
                {
                    builder.Append(" 医嘱ID:" + ciOrder.Id_or + "; 签署：" + ciOrder.Fg_sign + "; 医嘱状态： " + ciOrder.Sd_su_or + "; 执行：" + ciOrder.Sd_su_mp + "; 记账：" + ciOrder.Sd_su_bl);
                }
            }

            return builder.ToString();
        }

        /// <summary>
        /// 构造诊断日志字符串
        /// </summary>
        /// <param name="didtos"></param>
        /// <returns></returns>
        public static string GetCiDiInfo(string msg, DIDTO[] didtos)
        {
            StringBuilder builder = new StringBuilder();
            if (string.IsNullOrEmpty(msg))
            {
                builder.Append("消息：" + msg);
            }

            if (didtos != null)
            {
                foreach (DIDTO didto in didtos)
                {
                    if (string.IsNullOrEmpty(didto.Id_di))
                    {
                        builder.Append("诊断ID:" + didto.Id_di);
                    }
                    else if (string.IsNullOrEmpty(didto.Id_didef))
                    {
                        builder.Append("诊断定义ID:" + didto.Id_didef);
                    }

                    if (string.IsNullOrEmpty(didto.Id_didef_syn))
                    {
                        builder.Append("症候诊断ID:" + didto.Id_didef);
                    }
                }
            }

            return builder.ToString();
        }

        /// <summary>
        /// 输出日志
        /// </summary>
        /// <param name="context"></param>
        /// <param name="banner"></param>
        /// <param name="msg"></param>
        private static string GetWriteLog(string msg, BaseContext context, Ent4BannerDTO banner)
        {
            StringBuilder builder = new StringBuilder();
            builder.Append("【CI】：" + msg);
            if (context != null)
            {
                builder.Append("；医生：" + context.User.Name + ";就诊部门ID：" + context.Dept.Id_dep);
            }
            if (banner != null)
            {
                builder.Append("；患者：" + banner.Name_pat + "; 就诊ID：" + banner.Id_ent + "；就诊类型：" + banner.Code_entp + "；初诊：" + banner.Fg_first);
                if (!string.IsNullOrEmpty(banner.Code_ent))
                {
                    builder.Append("； 就诊号：" + banner.Code_ent);
                }
                else
                {
                    builder.Append("；病案号：" + banner.Code_amr_ip);
                }

                if (string.IsNullOrEmpty(banner.Id_hp))
                {
                    builder.Append("； ID_HP：[" + banner.Code_amr_ip+"]");
                }

                if (banner.Fg_hpfundpay == FBoolean.True)
                {
                    builder.Append("(基金支付)");
                }
            }
            

            return builder.ToString();
        }
    }
}
