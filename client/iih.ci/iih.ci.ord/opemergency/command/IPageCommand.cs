
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.command
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.command    </para>    
    /// <para>类 名 称 :  IPageCommand					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  11/11/2016 4:42:22 PM             </para>
    /// <para>更新时间 :  11/11/2016 4:42:22 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public interface IPageCommand
    {
        void OnPageCommand(Object sender, EventArgs e);
    }
}
