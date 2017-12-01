
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.dto.ordprintdto.d;
using iih.ci.ord.ordprn.d;
using iih.ci.iih.ci.ord.dto.ordprintdto.d;
using xap.mw.coreitf.d;

namespace iih.ci.iih.ci.ord.ordprn.i
{

    public interface IOrdprintExtService
    {
        /// <summary>
        /// 获取医嘱打印对象
        /// </summary>
        /// <returns></returns>
        OrdPrintDataDTO[] GetOrdPrintDataDTOs(OrdPrintParamDTO paramDTO);

        /// <summary>
        /// 获取已打印医嘱的页码集合
        /// </summary>
        /// <param name="paramDTO"></param>
        /// <returns></returns>
        int[] GetPageNums(OrdPrintParamDTO paramDTO);

        /// <summary>
        /// 根据待打印作废医嘱，获取在已打印医嘱中所在页的数据
        /// </summary>
        /// <param name="paramDTO">就诊id、长临标识</param>
        /// <param name="printDataDTOs">待打印医嘱</param>
        /// <returns>返回已打印的医嘱</returns>
        OrdPrintDO[] GetOrdPrintDOs(OrdPrintParamDTO paramDTO, OrdPrintDataDTO[] printDataDTOs);

        /// <summary>
        /// 保存重整打印数据
        /// </summary>
        /// <param name="idEn">就诊断id</param>
        /// <param name="fgLong">长临标识</param>
        /// <param name="ordPrintDOs">重整后打印数据</param>
        /// <returns></returns>
        OrdPrintDO[] SaveResetOrdPrintDOs(OrdPrintParamDTO paramDTO, OrdPrintDO[] ordPrintDOs);

        void DeleteOrdPrintDOs(OrdPrintDO[] ordPrintDOs);
    }
}
