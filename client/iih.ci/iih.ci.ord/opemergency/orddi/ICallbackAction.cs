
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.orddi
{
    /// <summary>
    /// <para>描    述 :  处理内部逻辑完成后的回调动作   </para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.orddi    </para>    
    /// <para>类 名 称 :  ICallbackAction					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  11/2/2016 1:49:13 PM             </para>
    /// <para>更新时间 :  11/2/2016 1:49:13 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public interface ICallbackAction
    {
        void OnAddAction(Object param=null);
        void OnDeleteAction(Object param = null);
        void OnSaveAction(Object param = null);

        void OnCancelAction(Object param = null);
    }
}
