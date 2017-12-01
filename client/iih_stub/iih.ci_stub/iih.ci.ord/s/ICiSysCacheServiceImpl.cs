using iih.ci.ord.ems.d;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using iih.ci.ord.i;

namespace iih.ci.ord.i
{
    public class ICiSysCacheServiceImpl : ICiSysCacheService
    {
        private readonly string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.i.ems.ICiSysCacheService";
        private ServiceInvocation si;

        public ICiSysCacheServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url_r;
        }

        public FBoolean clearL1Cache(CiEnContextDTO ctx)
        {
            return si.invoke<FBoolean>("clearL1Cache", new object[] { ctx });
        }

        public FBoolean clearL2Cache(CiEnContextDTO ctx)
        {
            return si.invoke<FBoolean>("clearL2Cache", new object[] { ctx });
        }

        public FBoolean clearL3Cache(CiEnContextDTO ctx)
        {
            return si.invoke<FBoolean>("clearL3Cache", new object[] { ctx });
        }

        public FBoolean prepareL2Cache(CiEnContextDTO ctx)
        {
            return si.invoke<FBoolean>("prepareL2Cache", new object[] { ctx });
        }

        public FBoolean prepareL3Cache(CiEnContextDTO ctx)
        {
            return si.invoke<FBoolean>("prepareL3Cache", new object[] { ctx });
        }
    }
}
