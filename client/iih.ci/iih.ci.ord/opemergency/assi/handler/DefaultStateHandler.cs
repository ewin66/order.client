
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine;
using xap.rui.engine.statehandlers;
using xap.rui.engine.xlayouts;

namespace iih.ci.ord.opemergency.assi.handler
{
    /// <summary>
    /// <para>描    述 :  LayoutPanelManager状态处理类</para>
    /// <para>说    明 :  助手配置文件中使用，控件组提供的默认配置有问题</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.handler</para>    
    /// <para>类 名 称 :  DefaultStateHandler</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/12/16 20:03:25</para>
    /// <para>更新时间 :  2016/12/16 20:03:25</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class DefaultStateHandler : IXStateHandler
    {
        public void HandleState(object component, string oldState, string uiEvent, string newState, Dictionary<string, object> data, BaseContext baseContext)
        { }
    }
}
