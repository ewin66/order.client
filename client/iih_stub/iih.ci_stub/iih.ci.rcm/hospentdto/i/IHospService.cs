
using System;
using iih.ci.rcm.hospentdto.d;
using iih.en.pv.pativisit.d;
using xap.sys.appfw.tmpl.qryscheme.qrydto;


namespace iih.ci.rcm.hospentdto.i
{
    public interface IHospService
    {
        HospEntDTO[] GetHospEntList(String idGrp, String idOrg, String idDept);

        PatiVisitDO[] GetHospMissingList(String idGrp, String idOrg, String idDept);

        HospEntDTO[] GetHospEntList2(QryRootNodeDTO qryRootNodeDTO);

        HospEntDTO[] GetDeleteHospList();

        HospEntDTO[] GetAllPageData();
    }
}
