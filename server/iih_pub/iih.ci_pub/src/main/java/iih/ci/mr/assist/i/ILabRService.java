package iih.ci.mr.assist.i;

import iih.ci.ord.cirptobs.d.CiRptObsDO;
import xap.mw.core.data.BizException;

public interface ILabRService {

	//检查
	public CiRptObsDO[] getCiRptObsDO(String id_ent) throws BizException;
}
