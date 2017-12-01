using iih.ci.mr.cimrvt.i;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using xap.sys.xbd.udi.d;
using xap.mw.core.data;

namespace iih.ci.mr.cimrvt.s
{
    public class IUdidocServiceExtImpl : IUdidocServiceExt
    {
        private string url = XapSvrConfig.BaseUrl + "xap.sys.xbd/xap.sys.xbd.udi.i.IUdidocServiceExt";//ConfigUtil.getServiceUrl();

        private ServiceInvocation si;

        public IUdidocServiceExtImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 根据Code获取自定义档案集合
        /// </summary>
        /// <param name="code"></param>
        /// <returns></returns>
        public UdidocDO[] findByUdidoclistCode(string code)
        {
            List<object> param = new List<object>();
            param.Add(code);
            si.url = url;
            UdidocDO[] rtn = si.invokeList<UdidocDO>("findByUdidoclistCode", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 根据code组查询自定义档案数据
        /// </summary>
        /// <param name="codeArry"></param>
        /// <returns></returns>
        public UdidocDO[] findByUdidoclistCodes(FArrayList codeArry)
        {
            List<object> param = new List<object>();
            param.Add(codeArry);
            si.url = url;
            UdidocDO[] rtn = si.invokeList<UdidocDO>("findByUdidoclistCodes", param.ToArray());
            return rtn;
        }
    }
}
