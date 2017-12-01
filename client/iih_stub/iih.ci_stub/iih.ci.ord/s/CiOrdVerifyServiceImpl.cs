using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.dto.orderverify.d;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;

namespace iih.ci.ord.i
{
    public class ICiOrdVerifyServiceImpl : ICiOrdVerifyService
    {
        private string url_r = XapSvrConfig.BaseUrl + "iihci.ord/iih.ci.ord.i.ICiOrdVerifyService";//ConfigUtil.getServiceUrl();
        
        private ServiceInvocation si;
		
        /// <summary>
        /// 构造函数
        /// </summary>
        public ICiOrdVerifyServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url_r;
        }

        /// <summary>
        /// 医嘱审核检索患者列表
        /// </summary>
        /// <param name="cond"></param>
        /// <returns></returns>
        public OrderVerifyPatDTO[] getVerifyPat(OrderVerifyCondDTO cond)
        {
            List<object> param = new List<object>();
            param.Add(cond);
            si.url = url_r;
            var result = si.invokeList<OrderVerifyPatDTO>("getVerifyPat", param.ToArray());
            return result;
        }

        /// <summary>
        /// 通过医嘱id检索医嘱信息
        /// </summary>
        /// <param name="idOrs"></param>
        /// <returns></returns>
        public OrderVerifyDTO[] getPatOrderByIds(String idOrs)
        {
            List<object> param = new List<object>();
            param.Add(idOrs);
            si.url = url_r;
            var result = si.invokeList<OrderVerifyDTO>("getPatOrderByIds", param.ToArray());
            return result;
        }

        /// <summary>
        /// 系统自动审核医嘱
        /// </summary>
        /// <param name="orderIds"></param>
        /// <returns></returns>
        public OrderVerifyDTO[] verifyOrderBySys(string[] orderIds) 
        {
            List<object> param = new List<object>();
            param.Add(orderIds);
            si.url = url_r;
            var result = si.invokeList<OrderVerifyDTO>("verifyOrderBySys", param.ToArray());
            return result;
        }

        /// <summary>
        /// 医嘱审核确认
        /// </summary>
        /// <param name="orders"></param>
        public void verifyOrder(OrderVerifyDTO[] orders) 
        {
            List<object> param = new List<object>();
            param.Add(orders);
            si.url = url_r;
            si.invoke<string>("verifyOrder", param.ToArray());
        }

        /// <summary>
        /// 医生核对异常医嘱
        /// </summary>
        /// <param name="ordId"></param>
        /// <param name="ifAccept"></param>
        /// <param name="explain"></param>
        public void confirmVerifyResult(string ordId, FBoolean ifAccept, string explain) 
        {
            List<object> param = new List<object>();
            param.Add(ordId);
            param.Add(ifAccept);
            param.Add(explain);
            si.url = url_r;
            si.invoke<string>("confirmVerifyResult", param.ToArray());
        }
    }
}
