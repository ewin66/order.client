using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.scoreitmdto.d;
using iih.ci.mrqc_stub.scoreitmdto.i;
using xap.mw.serviceframework;

namespace iih.ci.mrqc_stub.scoreitmdto.i
{
    public class IScoreItmDtoServiceImpl : IScoreItmDtoService
    {
        private string url = XapSvrConfig.BaseUrl + "iih.ci.mrqc/iih.ci.mrqc.scoreitmdto.i.IScoreItmDtoService";

        private ServiceInvocation si;

        public IScoreItmDtoServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        public ScoreItmDto[] getScoreItmDtos(string id_ent, string id_qc_type)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            ps.Add(id_qc_type);
            si.url = url;
            ScoreItmDto[] rt = si.invokeList<ScoreItmDto>("getScoreItmDtos", ps.ToArray());
            return rt;
        }
    }
}
