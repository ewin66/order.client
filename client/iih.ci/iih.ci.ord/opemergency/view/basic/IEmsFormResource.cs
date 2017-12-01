using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.view.basic
{
    /// <summary>
    /// <para>描    述 :  表单资源ID接口                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.view.basic    </para>    
    /// <para>类 名 称 :  IEmsFormResource					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  8/30/2016 8:37:33 PM             </para>
    /// <para>更新时间 :  8/30/2016 8:37:33 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    interface IEmsFormResource
    {
        String GetFromID(int emsType, object param = null);
    }
}
