using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.pp.primd.i;
using xap.mw.serviceframework;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
    /// <summary>
    /// 定价模式接口
    /// </summary>
    /// Author:admin
    /// Date:2015-09-25
    class GetprimdPriceImp
    {
        IPriCalService service;
        public GetprimdPriceImp()
        {
            service = XapServiceMgr.find<IPriCalService>();
        }
        /// <summary>
        /// 根据服务id 获取参考价格
        /// </summary>
        /// <param name="id_srv">The id_srv服务id.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-09-25
        public double GetPrice(string id_srv)
        {
           //return service.CalSingleSrvStdPrice(id_srv);
            return 0.0;
        }
    }
}
