using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.rcm.hospitalinfectiondto.d;

namespace iih.ci.rcm.hospitalinfectiondto.i
{
    public interface IHospInfectionService
    {
        HospitalInfectionDTO[] GetHospInfecDto(string id_ent);
    }
}
