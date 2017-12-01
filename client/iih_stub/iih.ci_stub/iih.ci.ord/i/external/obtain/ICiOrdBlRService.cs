
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.coreitf.d;

namespace iih.ci.iih.ci.ord.i.external.obtain
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.i.external.obtain</para>    
    /// <para>类 名 称 :  ICiOrdBlRService</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2017/6/27 13:46:14</para>
    /// <para>更新时间 :  2017/6/27 13:46:14</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public interface ICiOrdBlRService
    {

        /// <summary>
        /// 患者是否允许使用预付费标识
        /// </summary>
        /// <param name="patId">患者id</param>
        /// <param name="entId">就诊id</param>
        /// <param name="bizType">业务场景类型，暂为空，（后续可参考：iih.bl.pay.prepay.d.EuPrepayBizType）</param>
        /// <returns></returns>
        FBoolean IsPatUsePrePay(String id_pat, String id_en, String bizType);
       
    }
}
