
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.coreitf.d;

namespace iih.ci.ord.opemergency.operateaction.dto
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.operateaction.dto</para>    
    /// <para>类 名 称 :  ResponseParam</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/10/28 18:07:18</para>
    /// <para>更新时间 :  2016/10/28 18:07:18</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class ResponseParam
    {
        // 操作状态，True 成功， False 失败
        private FBoolean succFlag = FBoolean.True;

        /// <summary>
        /// 返回的提示信息
        /// </summary>
        public string msg { get; set; }
        /// <summary>
        /// 返回参数处理集合
        /// </summary>
        public Dictionary<string, object> ParamDic { get; set; }

        public FBoolean SuccFlag
        {
            get
            {
                return succFlag;
            }

            set
            {
                succFlag = value;
            }
        }
    }
}
