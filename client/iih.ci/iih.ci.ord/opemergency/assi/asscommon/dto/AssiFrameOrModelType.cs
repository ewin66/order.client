
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.assi.asscommon.dto
{
    /// <summary>
    /// <para>描    述 :  助手弹出医嘱模板类型</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.asscommon.dto</para>    
    /// <para>类 名 称 :  AssiFrameOpenModel</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  zwq</para> 
    /// <para>修 改 人 :  zwq</para> 
    /// <para>创建时间 :  2016/12/15 15:28:03</para>
    /// <para>更新时间 :  2016/12/15 15:28:03</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public enum AssiFrameOrModelType
    {
        /// <summary>
        /// 综合模板
        /// </summary>
        [Description("综合模板")]
        dSYNTHESISTEMPLATE = 11,
        /// <summary>
        /// 检查模板
        /// </summary>
        [Description("检查模板")]
        OBSTEMPLATE = 12,
        /// <summary>
        /// 检验模板
        /// </summary>
        [Description("检验模板")]
        LABTEMPLATE = 13,
        /// <summary>
        /// 诊疗模板
        /// </summary>
        [Description("诊疗模板")]
        TREATMENTTEMPLATE = 14,
        /// <summary>
        /// 西成药
        /// </summary>
        [Description("西成药模板")]
        WESTDRUGTEMPLATE = 01
    }
}
