package iih.ci.ord.s.bp.assi.impl.cimes.op;

import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.s.bp.assi.impl.cimes.base.OpBaseCopyCalCiEmsProperty;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 复制检验属性
 * @author HUMS
 *
 */
public class OpCopyLisPropertyImpl extends OpBaseCopyCalCiEmsProperty{

	private IMedSrvLisDORService imedSrvLisRService;
	
	public OpCopyLisPropertyImpl(){
		imedSrvLisRService = (IMedSrvLisDORService) ServiceFinder.find(IMedSrvLisDORService.class);
	}
	
	@Override
	protected void afterCalcuateCustomProperty(CiEmsDTO ciEms) throws BizException {
		
		super.afterCalcuateCustomProperty(ciEms);
		this.setLisProperty(ciEms);
	}
	
	/**
	 * 检验单独处理属性
	 * @param ciEms
	 * @throws BizException
	 */
	private void setLisProperty(CiEmsDTO ciEms) throws BizException{
		
		if(ciEms.getFg_set() == FBoolean.TRUE){
			return ;
		}
		
		
		
		
	}
}
