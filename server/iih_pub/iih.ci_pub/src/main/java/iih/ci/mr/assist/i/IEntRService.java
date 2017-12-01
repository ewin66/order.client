package iih.ci.mr.assist.i;

import xap.mw.core.data.BizException;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.pativisit.d.PatiVisitDO;

public interface IEntRService {
	public PatiVisitDO[] queryByEnt(String id_pat) throws BizException;

}