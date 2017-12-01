using iih.ci.mr.cimrvt.d;
using iih.ci.mr.cimrvt.i;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;

namespace iih.ci.mr.cimrvt.i
{
    public class VitalSignSaveServiceImpl : VitalSignSaveService
    {
        private string url = XapSvrConfig.BaseUrl + "iih.ci.mr/iih.ci.mr.i.VitalSignSaveService";

        private ServiceInvocation si;

        public VitalSignSaveServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        public VitalSignSave[] VatilSignSave(VitalSignSave[] ListSaveDTOS)
        {
            List<object> param = new List<object>();
            param.Add(ListSaveDTOS);
            si.url = url;
            VitalSignSave[] rtn = si.invokeList<VitalSignSave>("VatilSignSave", param.ToArray());
            return rtn;
        }
    }
}
