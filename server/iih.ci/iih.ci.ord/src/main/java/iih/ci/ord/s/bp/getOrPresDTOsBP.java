package iih.ci.ord.s.bp;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.s.bp.qry.getOrPresDTOsQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;

public class getOrPresDTOsBP {
	
	public OrderPresSplitDTO[] exec(String id_en)throws BizException{

		ITransQry qry = new getOrPresDTOsQry(id_en);
		OrderPresSplitDTO[] rtn = (OrderPresSplitDTO[]) AppFwUtil.getDORstWithDao(qry,OrderPresSplitDTO.class);
		return rtn;
	}

}
