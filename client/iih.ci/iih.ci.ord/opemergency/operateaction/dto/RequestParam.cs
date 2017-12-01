
using iih.ci.ord.opemergency.operateaction.baseoperate;
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.operateaction.dto
{
    /// <summary>
    /// <para>描    述 :  事件链请求参数</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.operateaction.dto</para>    
    /// <para>类 名 称 :  RequestParam</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/10/28 18:06:48</para>
    /// <para>更新时间 :  2016/10/28 18:06:48</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class RequestParam
    {
        /// <summary>
        /// 当前环境信息
        /// </summary>
        public BaseContext context { get; set; }

        /// <summary>
        /// banner对象
        /// </summary>
        public Ent4BannerDTO ent4BannerDTO { get; set; }

        /// <summary>
        ///  与外出交互的事件
        /// </summary>
        public OpActionChainHandler opActionChainHandler { get;set;}

        /// <summary>
        /// 触发事件的（菜单、按钮）名称，如果后续逻辑需要通过该值进行判断就加，否则可以不加
        /// </summary>
        public String actionName { get; set; }

        /// <summary>
        /// 参数对象
        /// </summary>
        public Dictionary<string, object> ParamDic { get; set; }
    }
}
