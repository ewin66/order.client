
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.form;
using xap.mw.log;

namespace iih.ci.ord.common.utils.msg
{
    /// <summary>
    /// <para>描    述 :  业务提示信息</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.common.utils.msg</para>    
    /// <para>类 名 称 :  BizAssMessageBoxUtil</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2017/2/22 17:27:17</para>
    /// <para>更新时间 :  2017/2/22 17:27:17</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class BizAssMessageBoxUtil
    {/// <summary>
     /// 提示框默认标题
     /// </summary>
        private const string TITLE = "操作提示";

        /// <summary>
        /// 患者为空时弹出的提示信息
        /// </summary>
        /// <param name="ent4BannerDTO">banner对象</param>
        /// <param name="title">提示信息的title，默认为操作提示</param>
        /// <returns>true 弹出患者为空的提示，false 患者不为空</returns>
        public static bool ShowPatIsNullMsg(Ent4BannerDTO ent4BannerDTO, string title)
        {

            if (ent4BannerDTO == null || string.IsNullOrEmpty(ent4BannerDTO.Id_pat))
            {
                if (ent4BannerDTO == null)
                {
                    LogManager.GetLogger().DebugEx("BizAssMessageBoxUtil ent4BannerDTO == null");
                }
                else if (string.IsNullOrEmpty(ent4BannerDTO.Id_pat))
                {
                    LogManager.GetLogger().DebugEx("BizAssMessageBoxUtil ent4BannerDTO.Id_pat == null");
                }

                MessageBoxEx.Show("未获取到患者就诊信息，请选择患者！", GetDefaultTitle(title), MessageBoxButtons.OK, MessageBoxIconEx.Information, MessageBoxDefaultButton.Button1);
                return true;
            }
            return false;
        }

        /// <summary>
        /// 诊断为空时弹出提示信息
        /// </summary>
        /// <param name="title"></param>
        public static void ShowCidiIsNullMsg(string title)
        {

            MessageBoxEx.Show("请先下达诊断！", GetDefaultTitle(title), MessageBoxButtons.OK, MessageBoxIconEx.Information, MessageBoxDefaultButton.Button1);
        }

        /// <summary>
        /// 就诊结束提示信息
        /// </summary>
        public static void ShowEnCompleteMsg()
        {
            MessageBoxEx.Show("该患者已诊毕，无法使用此功能！", TITLE, MessageBoxButtons.OK, MessageBoxIconEx.Information, MessageBoxDefaultButton.Button1);
        }

        /// <summary>
        /// 仅有一个确定按钮
        /// </summary>
        public static void ShowInforMsg(string msg)
        {
            ShowInforMsg(TITLE, msg);
        }

        /// <summary>
        /// 就诊结束提示信息
        /// </summary>
        public static void ShowInforMsg(string title, string msg)
        {
            ShowMsg(title, msg, MessageBoxIconEx.Information);
        }

        /// <summary>
        /// 警告提示窗口
        /// </summary>
        /// <param name="msg">提示内容</param>
        public static void ShowWarningMsg(string msg)
        {
            ShowWarningMsg(TITLE, msg);
        }

        /// <summary>
        /// 警告提示窗口
        /// </summary>
        /// <param name="title">提示窗口标题</param>
        /// <param name="msg">提示窗口内容</param>
        public static void ShowWarningMsg(string title, string msg)
        {
            ShowMsg(title, msg, MessageBoxIconEx.Warning);
        }

        /// <summary>
        /// 是否提示信息
        /// </summary>
        /// <param name="msg"></param>
        /// <returns></returns>
        public static bool ShowConfirmMsg(string msg)
        {
            return ShowConfirmMsg(GetDefaultTitle(null), msg);
        }

        /// <summary>
        /// 弹出是否提示信息
        /// </summary>
        /// <param name="title">提示框标题</param>
        /// <param name="msg">提示内容</param>
        /// <returns></returns>
        public static bool ShowConfirmMsg(string title, string msg)
        {
            return (DialogResult.Yes == ShowMsg(title, msg, MessageBoxButtons.YesNo));
        }

        /// <summary>
        /// 提示信息
        /// </summary>
        /// <param name="title">提示框标题</param>
        /// <param name="msg">提示信息</param>
        /// <param name="btn">提示信息类型MessageBoxButtons</param>
        /// <returns></returns>
        public static bool ShowMsgInfo(string title, string msg,string[] str)
        {
            return  DialogResult.Yes ==MessageBoxEx.Show(msg, GetDefaultTitle(title),str);
        }


        /// <summary>
        /// 提示信息
        /// </summary>
        /// <param name="title">提示框标题</param>
        /// <param name="msg">提示信息</param>
        /// <param name="btn">提示信息类型MessageBoxButtons</param>
        /// <returns></returns>
        public static DialogResult ShowMsg(string title, string msg, MessageBoxButtons btn, MessageBoxIconEx ex = MessageBoxIconEx.Information)
        {
            return MessageBoxEx.Show(msg, GetDefaultTitle(title), btn, MessageBoxIconEx.Question, MessageBoxDefaultButton.Button1, null);
        }

        /// <summary>
        /// 提示窗口
        /// </summary>
        /// <param name="title">提示窗口标题</param>
        /// <param name="msg">提示内容</param>
        /// <param name="ex">提示图标，MessageBoxIconEx 提醒、警告、错误</param>
        private static void ShowMsg(string title, string msg, MessageBoxIconEx ex)
        {
            MessageBoxEx.Show(msg, GetDefaultTitle(title), MessageBoxButtons.OK, ex, MessageBoxDefaultButton.Button1);
        }

        /// <summary>
        /// 如果提示框标题为空，返回“操作提示”作为提示框标题
        /// </summary>
        /// <param name="title"></param>
        /// <returns></returns>
        private static string GetDefaultTitle(string title)
        {

            return string.IsNullOrEmpty(title) ? TITLE : title;
        }
    }
}
