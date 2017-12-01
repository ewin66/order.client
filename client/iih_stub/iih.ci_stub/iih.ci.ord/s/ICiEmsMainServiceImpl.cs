using iih.ci.ord.i;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.dto.emsmain;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ems.d;
using xap.mw.serviceframework;

namespace iih.ci.ord.i
{
    public class ICiEmsMainServiceImpl : ICiEmsMainService
    {
        private readonly string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.i.ems.ICiEmsMainService";
        private ServiceInvocation si;

        public ICiEmsMainServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url_r;
        }
        public EmsRstDTO[] create(EmsCrtDTO[] ems)
        {
            List<object> param1 = new List<object>();
            param1.Add(ems);
            si.url = url_r;
            EmsRstDTO[] rtn = si.invokeList<EmsRstDTO>("create", param1.ToArray());
            return rtn;

            //return si.invoke<EmsRstDTO[]>("create", new object[] { ems });
        }

        public EmsRstDTO[] load(EmsLoadDTO[] ems)
        {
            List<object> param1 = new List<object>();
            param1.Add(ems);
            si.url = url_r;
            EmsRstDTO[] rtn = si.invokeList<EmsRstDTO>("load", param1.ToArray());
            return rtn;
        }

        public EmsRstDTO save(EmsSaveDTO ems)
        {
            return si.invoke<EmsRstDTO>("save", new object[] { ems });
        }

    }
}
