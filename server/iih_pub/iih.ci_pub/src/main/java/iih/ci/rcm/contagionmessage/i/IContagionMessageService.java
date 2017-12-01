package iih.ci.rcm.contagionmessage.i;

import iih.ci.rcm.contagion.d.ContagionDO;
import xap.mw.core.data.BizException;

public interface IContagionMessageService {
	public int sentMessage(ContagionDO condo) throws BizException;

}
