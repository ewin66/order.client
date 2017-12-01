using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using iih.ci.mr.cimrvt.i;
using iih.ci.mr.cimrpatsigns.d;

namespace iih.ci.mr.cimrvt.s
{
    public class CiVitalSignsServiceImpl : ICiVitalSignsService
    {
        private string url = XapSvrConfig.BaseUrl + "iih.ci.mr/iih.ci.mr.i.ICiVitalSignsService";
        private string url_r = XapSvrConfig.BaseUrl + "iih.ci.mr/iih.ci.mr.assist.i.IVitalSignRService";

        private ServiceInvocation si;

        public CiVitalSignsServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        public VitalSignsDTO[] GetVitalSignsDTOList(string Id_ent, string BeginDate, string EndDate)
        {
            List<object> param = new List<object>();
            param.Add(Id_ent);
            param.Add(BeginDate);
            param.Add(EndDate);
            si.url = url_r;
            VitalSignsDTO[] rtn = si.invokeList<VitalSignsDTO>("GetVitalSignsDTOList", param.ToArray());
            return rtn;
        }
    }
}
