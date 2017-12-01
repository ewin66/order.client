using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.iih.ci.mrqry.mrtplusagerate.i;
using xap.mw.serviceframework;
using xap.mw.core.data;
using iih.ci.mr.d;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.iih.ci.mrqry.mrtplusagerate.i
{
    public class IMrTplUsageRateServiceImpl : IMrTplUsageRateService
    {
          /// <summary>
        /// 接口地址
        /// </summary>
        private string url = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.i.IMrTplUsageRateService";
        /// <summary>
        /// 调接口服务
        /// </summary>
        private ServiceInvocation si;

        /// <summary>
        /// 构造函数 
        /// 初始化数据
        /// </summary>
        public IMrTplUsageRateServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        public PagingRtnData<MrTplUsageRateDTO> GetMrTplUsageRateDTO(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> lstObj = new List<object>();
            lstObj.Add(qryRootNodeDTO);
            lstObj.Add(paginationInfo);
            PagingRtnData<MrTplUsageRateDTO> lst;
            try
            {
                lst = si.invokePaging<MrTplUsageRateDTO>("getMrTplUsageRateDTO", lstObj.ToArray());
            }
            catch (Exception)
            {
                
                throw;
            }

            return lst;
        }

    }
}
