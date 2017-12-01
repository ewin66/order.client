package iih.ci.ord.s.bp.assi.impl.cimes.op;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 皮试专用
 * @author HUMS
 *
 */
public class OpCopyTreatSkinTestPropertyImpl extends OpCopyTreatPropertyImpl {
	
	@Override
	protected void afterCalcuateCustomProperty(CiEmsDTO ciEms) throws BizException {
		
		super.afterCalcuateCustomProperty(ciEms);
		this.setSkintestStatus(ciEms);

	}

	/**
	 * 设置皮试状态
	 * 
	 * @param ciEms
	 */
	private void setSkintestStatus(CiEmsDTO ciEms) {

		FArrayList emssrvList = ciEms.getEmssrvs();
		for (Object obj : emssrvList) {
			CiEmsSrvDTO srvDTO = (CiEmsSrvDTO) obj;
			if (srvDTO.getFg_skintest() == FBoolean.TRUE) {
				ciEms.setFg_skintest(FBoolean.TRUE);
				break;
			}
		}
	}
}
