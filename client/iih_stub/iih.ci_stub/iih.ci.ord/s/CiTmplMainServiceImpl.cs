using iih.ci.iih.ci.ord.i;
using iih.ci.ord.dto.emsmain.tmpl;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using xap.mw.serviceframework;

namespace iih.ci.ord.i
{
    public class ICiTmplMainServiceImpl : ICiTmplMainService
    {
        private readonly string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.i.ems.ICiTmplMainService";
        private ServiceInvocation si;

        public ICiTmplMainServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url_r;
        }

        public TmplRstDTO load(TmplLoadDTO ems)
        {
            return si.invoke<TmplRstDTO>("load", new object[] { ems });
        }

        public TmplRstDTO save(TmplSaveDTO ems)
        {
            return si.invoke<TmplRstDTO>("save", new object[] { ems });
        }
    }
}
