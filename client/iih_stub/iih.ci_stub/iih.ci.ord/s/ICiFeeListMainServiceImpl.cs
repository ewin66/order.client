using System;
using System.Collections.Generic;
using iih.ci.ord.ems.d;
using xap.mw.serviceframework;


namespace iih.ci.ord.i
{
    public class ICiFeeListMainServiceImpl : ICiFeeListMainService
    {
        private readonly ServiceInvocation si;

        private readonly string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.i.ems.ICiFeeListMainService";


        /// <summary>
        ///     构造函数
        /// </summary>
        public ICiFeeListMainServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url_r;
        }
        /// <summary>
        /// 加载费用清单数据
        /// </summary>
        /// <param name="ld"></param>
        /// <returns></returns>
        public FeeListRstDTO load(FeeListLoadDTO ld)
        {
            var param = new List<object> { ld };
            si.url = url_r;
            FeeListRstDTO rtn = si.invoke<FeeListRstDTO>("load", param.ToArray());
            return rtn;
        }


    }
}