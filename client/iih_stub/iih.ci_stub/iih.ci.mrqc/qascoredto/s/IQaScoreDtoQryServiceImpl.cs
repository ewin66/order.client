using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.qaflt.d;
using iih.ci.mrqc.qascoredto.d;
using xap.mw.serviceframework;

namespace iih.ci.iih.ci.mrqc.qascoredto.i
{
    public class IQaScoreDtoQryServiceImpl : IQaScoreDtoQryService
    {
        private string url = XapSvrConfig.BaseUrl + "iih.ci.mrqc/iih.ci.mrqc.qascoredto.i.IQaScoreDtoQryService";

        private ServiceInvocation si;

        public IQaScoreDtoQryServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        public QaScoreDTO[] getQaScoreDtos(string id_ent, string id_qc_type)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            ps.Add(id_qc_type);
            si.url = url;
            QaScoreDTO[] rt = si.invokeList<QaScoreDTO>("getQaScoreDtos", ps.ToArray());
            return rt;
        }

        public QaFltDTO[] getQaFltForScoreDtos(string id_ent, string id_qc_type)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            ps.Add(id_qc_type);
            si.url = url;
            QaFltDTO[] rt = si.invokeList<QaFltDTO>("getQaFltForScoreDtos", ps.ToArray());
            return rt;
        }
    }
}
