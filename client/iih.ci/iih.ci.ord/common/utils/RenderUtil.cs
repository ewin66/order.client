
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Reflection;

namespace iih.ci.ord.common.utils
{
    /// <summary>
    /// <para>描    述 : 字符串转换工具类</para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.ord.common.utils    </para>    
    /// <para>类 名 称 :  RenderUtil					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/8/23 14:49:56</para>
    /// <para>更新时间 :  2016/8/23 14:49:56</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class RenderUtil
    {
        /// <summary>
        /// 将对象属性按转换为对应格式的字符串
        /// </summary>
        /// <param name="format"></param>
        /// <param name="obj"></param>
        public static string Render(string renderStr, object obj)
        {
            BindingFlags flag = BindingFlags.Public | BindingFlags.IgnoreCase | BindingFlags.Instance;

            object proeprtyVal = null;
            string propertyName = null;
            Regex reg = new Regex(@"\{\{:([^\{^\}]*)\}\}");
            var matches = reg.Matches(renderStr);
            Type type = obj.GetType();

            foreach (Match match in matches)
            {

                propertyName = match.Groups[1].Value;
                PropertyInfo info = type.GetProperty(propertyName, flag);

                if (info != null)
                {
                    proeprtyVal = BeanUtils.GetValue(obj, info.Name);
                    if (proeprtyVal == null)
                    {
                        renderStr = renderStr.Replace(match.Groups[0].Value, "");
                    }
                    else
                    {
                        renderStr = renderStr.Replace(match.Groups[0].Value, proeprtyVal.ToString());
                    }
                }
            }

            return renderStr;
        }
    }
}
