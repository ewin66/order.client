package iih.ci.mr.assist.i;

import iih.ci.ord.cirptlab.d.CirptlabAggDO;
import xap.mw.core.data.BizException;

public interface IObservationRService {

	//检验
	public CirptlabAggDO[] getCirptlabAggDO(String id_ent) throws BizException;
}
