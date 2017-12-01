using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mr.i;
using xap.mw.serviceframework;

namespace iih.ci.mr.i
{
    public class ICiMrParamServiceImpl : ICiMrParamService
    {
        /// <summary>
        /// 接口地址
        /// </summary>
        private string url = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.i.ICiMrParamService";
        /// <summary>
        /// 调接口服务
        /// </summary>
        private ServiceInvocation si;

        /// <summary>
        /// 构造函数 
        /// 初始化数据
        /// </summary>
        public ICiMrParamServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 获取编辑器配置参数
        /// </summary>
        /// <returns></returns>
        public string GetEditorConfig(string id_org)
        {
            List<object> ps = new List<object>();
            ps.Add(id_org);
            return si.invokeString("GetEditorConfig", ps.ToArray());
        }

        /// <summary>
        /// 获取门诊病历保存时是否判断必填项标识
        /// </summary>
        /// <param name="id_org"></param>
        /// <returns></returns>
        public bool GetCiMrRequiredField(String id_org)
        {
            List<object> ps = new List<object>();
            ps.Add(id_org);
            return si.invoke<Boolean>("getCiMrRequiredField", ps.ToArray());
        }

        /// <summary>
        /// 获取门诊病历保存时是否判断互斥项标识
        /// </summary>
        /// <param name="id_org"></param>
        /// <returns></returns>
        public bool GetCiMrMutexField(String id_org)
        {
            List<object> ps = new List<object>();
            ps.Add(id_org);
            return si.invoke<Boolean>("getCiMrMutexField", ps.ToArray());
        }

        /// <summary>
        /// 获取门诊病历打印时是否预览
        /// </summary>
        /// <param name="id_org"></param>
        /// <returns></returns>
        public bool GetSysParamCiMrPrintPreView(String id_org)
        {
            List<object> ps = new List<object>();
            ps.Add(id_org);
            return si.invoke<Boolean>("getSysParamCiMrPrintPreView", ps.ToArray());
        }
    }
}
