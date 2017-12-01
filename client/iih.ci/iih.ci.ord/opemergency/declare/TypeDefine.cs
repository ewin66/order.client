using iih.ci.ord.ciorder.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.opemergency.ems.common;
using System;
using System.Collections.Generic;

namespace iih.ci.ord.opemergency.declare
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  xap.rui.bizcontrol.BillFormTmplConst    </para>    
    /// <para>类 名 称 :  TypeDefine					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  9/13/2016 5:07:31 PM             </para>
    /// <para>更新时间 :  9/13/2016 5:07:31 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class StringObjectMap:Dictionary<String,Object> {}

    public partial class StringList : List<String> { }

    public partial class ObjectList : List<Object> { }

   

    #region 医疗单创建参数结构定义
    public partial class EmsCreatedParamList : List<EmsCreatedParameter> 
    { 
        public const String TAGKEY = "EmsCreatedParamList"; 
    }

    public partial class CiOderDOList : List<CiOrderDO> 
    {
        public CiOderDOList() { }
        public CiOderDOList(IEnumerable<CiOrderDO> collection) : base(collection) { } 
    }
    #endregion

    #region 医嘱编辑参数结构定义
    public partial class OrderEditParameter
    {
        public const String TAGKEY = "OrderEditParameter";
        public CiOrderDO OrderItem;
    }

    public partial class OrderEditParamList : List<OrderEditParameter> { 
        public const String TAGKEY = "OrderEditParamList";
        public OrderEditParamList() { }
        public OrderEditParamList(IEnumerable<OrderEditParameter> collection) : base(collection) { } 
    }
    #endregion

    #region 医疗单编辑参数结构定义
    public partial class EmsEditParameter
    {
        public const String TAGKEY = "EmsEditParameter";
        public CiEmsDTO EmsDTO { get; set; }
    }

    public partial class EmsEditParamList : List<EmsEditParameter>
    {
        public const String TAGKEY = "EmsEditParamList";
        public EmsEditParamList() { }
        public EmsEditParamList(IEnumerable<EmsEditParameter> collection) : base(collection) { }
    }
    #endregion
}
