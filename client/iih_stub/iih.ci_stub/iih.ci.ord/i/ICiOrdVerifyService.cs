using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.dto.orderverify.d;
using xap.mw.coreitf.d;

namespace iih.ci.ord.i
{
    public interface ICiOrdVerifyService
    {
        /// <summary>
        /// 医嘱审核检索患者列表
        /// </summary>
        /// <param name="cond"></param>
        /// <returns></returns>
        OrderVerifyPatDTO[] getVerifyPat(OrderVerifyCondDTO cond);

        /// <summary>
        /// 通过医嘱id检索医嘱信息
        /// </summary>
        /// <param name="idOrs"></param>
        /// <returns></returns>
        OrderVerifyDTO[] getPatOrderByIds(String idOrs);

        /// <summary>
        /// 系统自动审核医嘱
        /// </summary>
        /// <param name="orderIds"></param>
        /// <returns></returns>
        OrderVerifyDTO[] verifyOrderBySys(string[] orderIds);

        /// <summary>
        /// 医嘱审核确认
        /// </summary>
        /// <param name="orders"></param>
        void verifyOrder(OrderVerifyDTO[] orders);

        /// <summary>
        /// 医生核对异常医嘱
        /// </summary>
        /// <param name="ordId"></param>
        /// <param name="ifAccept"></param>
        /// <param name="explain"></param>
        void confirmVerifyResult(string ordId, FBoolean ifAccept, string explain);
    }
}
