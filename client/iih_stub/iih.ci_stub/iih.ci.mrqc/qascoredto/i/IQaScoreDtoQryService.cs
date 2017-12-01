using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.qaflt.d;
using iih.ci.mrqc.qascoredto.d;

namespace iih.ci.iih.ci.mrqc.qascoredto.i
{
    public interface IQaScoreDtoQryService
    {
        QaScoreDTO[] getQaScoreDtos(String id_ent, String id_qc_type);
        QaFltDTO[] getQaFltForScoreDtos(String id_ent, String id_qc_type);
    }
}
