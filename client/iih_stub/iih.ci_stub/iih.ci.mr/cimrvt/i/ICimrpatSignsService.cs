using iih.bd.srv.medsrv.d;
using iih.bd.srv.mrtplvt.d;
using iih.ci.mr.cimrpatsigns.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.mr.i
{
    public interface ICiMrServiceExt
    {
        PatDTO[] FindPatDTO(Patparam patparam);

        MedSrvVtDO[] getMedSrvVtDO(string id_mrvtca);

        MrtplVtItmDO[] getMrtplVtItmDO(string id_vtca);

        CiMrHisDataDTO[] getCiMrHisData(string id_ent, string id_mrtplvt, string dt_vt);

    }
}
