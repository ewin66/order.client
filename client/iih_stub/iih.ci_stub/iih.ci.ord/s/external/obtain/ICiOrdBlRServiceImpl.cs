
using iih.ci.iih.ci.ord.i.external.obtain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;

namespace iih.ci.iih.ci.ord.i.external.obtain
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.s.external.obtain</para>    
    /// <para>类 名 称 :  ICiOrdBlRServiceImpl</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2017/6/27 17:09:18</para>
    /// <para>更新时间 :  2017/6/27 17:09:18</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class ICiOrdBlRServiceImpl : ICiOrdBlRService
    {
        private readonly ServiceInvocation si;

        private readonly string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.i.external.obtain.ICiOrdBlRService";   

        /// <summary>
        ///     构造函数
        /// </summary>
        public ICiOrdBlRServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url_r;
        }

        /// <summary>
        /// 患者是否允许使用预付费标识
        /// </summary>
        /// <param name="patId">患者id</param>
        /// <param name="entId"></param>
        /// <param name="bizType"></param>
        /// <returns></returns>
        public FBoolean IsPatUsePrePay(String id_pat, String id_en, String bizType)
        {
            var param = new List<object> { id_pat, id_en, bizType };
            si.url = url_r;
            return si.invoke<FBoolean>("isPatUsePrePay", param.ToArray());
        }
    }
}
