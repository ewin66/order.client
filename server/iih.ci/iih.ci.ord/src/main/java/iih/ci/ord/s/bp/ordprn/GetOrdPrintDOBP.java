package iih.ci.ord.s.bp.ordprn;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import iih.ci.ord.ordprn.d.OrdPrintDO;
import iih.ci.ord.s.bp.ordprn.qry.GetOrdPrintDOQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取已打印的医嘱BP
 * @author hums
 *
 */
public class GetOrdPrintDOBP {
	
	public OrdPrintDO[] exec(OrdPrintParamDTO paramDTO, OrdPrintDataDTO[] printDataDTOs) throws BizException {
		
		if(printDataDTOs == null || printDataDTOs.length ==0){
			return new OrdPrintDO[0];
		}
		
		GetOrdPrintDOQry qry = new GetOrdPrintDOQry(paramDTO,printDataDTOs);
		OrdPrintDO[] rtn = (OrdPrintDO[])AppFwUtil.getDORstWithDao(qry,OrdPrintDO.class);
		return rtn;
	}
}
