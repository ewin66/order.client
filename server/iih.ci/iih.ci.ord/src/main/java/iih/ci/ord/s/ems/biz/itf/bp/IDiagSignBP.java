package iih.ci.ord.s.ems.biz.itf.bp;

import xap.mw.core.data.BizException;
import iih.ci.ord.d.ems.di.DiagRstDTO;
import iih.ci.ord.d.ems.di.DiagSaveDTO;

public interface IDiagSignBP {
	public abstract DiagRstDTO sign(DiagSaveDTO diSignInfo)  throws BizException;
}
