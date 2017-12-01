
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.common.utils
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.common.utils</para>    
    /// <para>类 名 称 :  DictionaryUtil</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2017/10/19 10:08:33</para>
    /// <para>更新时间 :  2017/10/19 10:08:33</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class DictionaryUtil
    {
        /// <summary>
        /// Dictionary 字符串
        /// </summary>
        /// <param name="dic">待转换的Dictionary对象</param>
        /// <returns>返回key = value 对应的字符串</returns>
        public static string ToString(Dictionary<string, object> dic)
        {
            if (dic == null || dic.Count == 0)
            {
                return "";
            }
            StringBuilder builder = new StringBuilder();
            foreach (var item in dic)
            {
                builder.Append("；" + item.Key + " = " + item.Value + "；");
            }
            return builder.ToString(1, builder.Length-1);
        }
    }
}
