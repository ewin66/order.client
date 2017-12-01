package iih.ci.mr.assist.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.d.Cidiagdto;
import iih.en.pv.entdi.d.EntDiDO;

public interface IDiagnosisRService {
	public EntDiDO[] queryByEnt(String id_ent) throws BizException;

	public Cidiagdto[] getCidiagdto(String id_ent) throws BizException;
}