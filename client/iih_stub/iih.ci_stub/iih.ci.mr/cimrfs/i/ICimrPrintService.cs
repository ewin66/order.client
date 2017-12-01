using System;
using iih.ci.mr.cimr.d;
using iih.ci.mr.cimrfs.d;

namespace iih.ci.mr.cimrfs.i
{
    public interface ICimrPrintService
    {
        /// <summary>
        /// 获取打印流
        /// </summary>
        /// <param name="dos"> CiMrDO[]</param>
        /// <returns></returns>
        CiMrFsDO[] getCimrStream(CiMrDO[] dos);
    }
}
