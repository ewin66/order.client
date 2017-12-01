using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.qaflt.d;
using iih.ci.mrqc.qared.d;
using iih.ci.mrqc.revisionnotice.d;
using xap.mw.coreitf.d;
using iih.ci.mrqc.d;

namespace iih.ci.mrqc.i
{
    public interface IMrqcMaintainService
    {
        FBoolean saveRevNotice(RevisionNoticeDO revnotice, QaFltDTO[] qaflt, QaRecordDO qarecord,string id_amr);
        
        FBoolean updateStatus(QaFltDTO[] qaflt);

        Cidiagdto[] getCidiagdto(String id_ent);
    }
}
