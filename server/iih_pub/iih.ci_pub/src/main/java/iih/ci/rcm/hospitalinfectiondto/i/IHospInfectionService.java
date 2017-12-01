package iih.ci.rcm.hospitalinfectiondto.i;

import iih.ci.rcm.hospitalinfectiondto.d.HospitalInfectionDTO;
import xap.mw.core.data.BizException;

public interface IHospInfectionService {
	HospitalInfectionDTO[] getHospInfecDto(String id_ent) throws BizException;
}
