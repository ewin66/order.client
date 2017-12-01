using iih.ci.mr.nu.i;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;
using xap.mw.serviceframework;

namespace iih.ci.mr.nu.i
{
    public class ICimrNuQueryServiceImpl : ICimrNuQueryService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.nu.i.ICimrNuQueryService";//ConfigUtil.getServiceUrl();
        private ServiceInvocation si;

        /// <summary>
        /// 构造函数
        /// </summary>
        public ICimrNuQueryServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 实例化护理文书实体类
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="fullClassName"></param>
        /// <returns></returns>
        public BaseDO initData(string id_ent, string fullClassName)
        {
            List<object> param = new List<object>();
            param.Add(id_ent);
            param.Add(fullClassName);
            si.url = url;
            FArrayList rtn = si.invoke<FArrayList>("initData", param.ToArray());
            if (rtn != null && rtn.Count > 0)
            {
                return (BaseDO)rtn[0];
            }
            return null;
        }

        /// <summary>
        /// 刷新文书相关患者数据
        /// </summary>
        /// <param name="baseDo"></param>
        /// <returns></returns>
        public BaseDO refreshData(BaseDO baseDo)
        {
            List<object> param = new List<object>();
            param.Add(baseDo);
            si.url = url;
            FArrayList rtn = si.invoke<FArrayList>("refreshData", param.ToArray());
            if (rtn != null && rtn.Count > 0)
            {
                return (BaseDO)rtn[0];
            }
            return null;
        }
    }
}
