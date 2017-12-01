using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using iih.ci.ord.srvref.d;

namespace iih.ci.ord.i
{
    public class ICiSrvRefResultServiceImpl : ICiSrvRefResultService
    {

        private readonly ServiceInvocation si;

        private readonly string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.i.ICiSrvRefResultService";

         /// <summary>
        ///     构造函数
        /// </summary>
        public ICiSrvRefResultServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url_r;
        }

        /// <summarypublic
        /// 查询医嘱服务
        /// </summary>
        /// <param name="dto">医嘱服务参照入口参数数据</param>
        /// <returns>医嘱服务集合</returns>
        public CiSrvRefResultDTO[] getSrvRefResult(CiSrvRefParamDTO dto) 
        {
            CiSrvRefResultDTO[] srvResultDtos = new CiSrvRefResultDTO[0];
            si.url = url_r;
            try
            {
                srvResultDtos = si.invokeList<CiSrvRefResultDTO>("getSrvRefResult", dto);
                return srvResultDtos;
            }
            catch //(Exception e)
            {
                return srvResultDtos;                 
            }
            
            
        }
    }
}
