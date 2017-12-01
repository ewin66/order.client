using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.view.basic
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.view.basic    </para>    
    /// <para>类 名 称 :  IEventDelegate					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  9/20/2016 7:31:57 PM             </para>
    /// <para>更新时间 :  9/20/2016 7:31:57 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public interface IEventDelegate
    {
        bool OnEventSelected(object sender, object bannerData);

        bool OnChildNotify(object sender, xap.rui.engine.DictionaryEventArgs e);

        bool OnEventHandle(object sender, xap.rui.engine.DictionaryEventArgs e);

        IEventDelegate GetEventDelegate();

        BaseContext GetContext();
    }
}
