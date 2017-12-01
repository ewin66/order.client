using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.i;
using xap.mw.serviceframework;

namespace iih.ci.mrqc.i
{
    public class ICiMrQcParamServiceImpl : ICiMrQcParamService
    {
        /// <summary>
        /// 接口地址
        /// </summary>
        private string url = XapSvrConfig.BaseUrl + "iih.ci.mrqc/iih.ci.mrqc.i.ICiMrQcParamService";
        /// <summary>
        /// 调接口服务
        /// </summary>
        private ServiceInvocation si;

        /// <summary>
        /// 构造函数 
        /// 初始化数据
        /// </summary>
        public ICiMrQcParamServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 获取门诊病历召回最大申请天数
        /// </summary>
        /// <param name="id_org"></param>
        /// <returns></returns>
        public string GetSysParamOpRcMaxDays(string id_org)
        {
            List<object> ps = new List<object>();
            ps.Add(id_org);
            return si.invokeString("GetSysParamOpRcMaxDays", ps.ToArray());
        }

      /// <summary>
        /// 获取门诊病历召回默认天数
      /// </summary>
      /// <param name="id_org"></param>
      /// <returns></returns>
        public  string GetSysParamOpRcDefaultDays(String id_org)
        {
            List<object> ps = new List<object>();
            ps.Add(id_org);
            return si.invokeString("GetSysParamOpRcDefaultDays", ps.ToArray());
        }
    }
}
