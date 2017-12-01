using xap.mw.serviceframework;
using iih.ci.rcm.coninfodto.d;
using System.Collections.Generic;
namespace iih.ci.rcm.coninfodto.i
{
    public class IConInfoServiceImpl : IConInfoService
    {
        private readonly string _url   = XapSvrConfig.BaseUrl + "iihci.rcm/iih.ci.rcm.coninfodto.i.ConInfoService";
   
        private readonly ServiceInvocation _si;
        /// <summary>
        /// 构造函数
        /// </summary>
        public IConInfoServiceImpl()
        {
            _si = new ServiceInvocationImpl();
            _si.url = _url;
        }

        public ConInfoDTO[] GetContagions()
        {
            _si.url = _url;
            List<object> param = new List<object>();
            ConInfoDTO[] rtn = _si.invokeList<ConInfoDTO>("GetContagions", param.ToArray());
            return rtn;
        }
       
    }
}