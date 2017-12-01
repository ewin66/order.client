package iih.ci.ord.s.bp;

import iih.ci.ord.ciordems.d.AddFeeDTO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciordems.d.OrConfirm;
import iih.ci.ord.s.bp.qry.getCiOrdDrugQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;

public class getCiOrdFeeBp {
	
public AddFeeDTO[] exec(OrConfirm confirm)throws BizException{
		
		ITransQry qry = new getCiOrdDrugQry(confirm);
		AddFeeDTO[] rtn = (AddFeeDTO[]) AppFwUtil.getDORstWithDao(qry,AddFeeDTO.class);
		return rtn;
		
	}

}
