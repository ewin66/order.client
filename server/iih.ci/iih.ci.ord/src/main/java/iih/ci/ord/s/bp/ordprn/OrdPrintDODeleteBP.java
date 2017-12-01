package iih.ci.ord.s.bp.ordprn;

import iih.ci.ord.ordprn.d.OrdPrintDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

public class OrdPrintDODeleteBP {

	public void exec(OrdPrintDO[] printDos) throws BizException {

		this.delete(printDos);
	}
	
	private void delete(OrdPrintDO[] printDos) throws BizException {
		
		new DAFacade().deleteDOs(printDos);
	}
}
