
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.iih.ci.ord.opemergency.i.command
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.opemergency.i.command</para>    
    /// <para>类 名 称 :  ICiCommand</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/11/17 10:22:14</para>
    /// <para>更新时间 :  2016/11/17 10:22:14</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public interface ICiCommand
    {
        String GetTitle();
        Object exec(object param);
    }
}
