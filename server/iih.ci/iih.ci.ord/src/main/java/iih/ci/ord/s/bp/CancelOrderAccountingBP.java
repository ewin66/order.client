package iih.ci.ord.s.bp;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;

public class CancelOrderAccountingBP {
	
	public BlOrderAppendBillParamDTO[] getPrescriptionConstAccounting(String id_ent, String[] sd_su_bl) throws BizException {
		
		PrescriptionConstBaseDto baseDTO  =  CiOrdAppUtils.getCiOrdQryService().getPrescriptionConstAccounting(id_ent, sd_su_bl);
	    return  null;
	}

}
