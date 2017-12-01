using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.srvref.d;

namespace iih.ci.ord.i
{
    public interface ICiSrvRefResultService
    {
        /// <summary>
        /// 查询医嘱服务
        /// </summary>
        /// <param name="dto">医嘱服务参照入口参数数据</param>
        /// <returns>医嘱服务集合</returns>
        CiSrvRefResultDTO[] getSrvRefResult(CiSrvRefParamDTO dto);
    }
}
