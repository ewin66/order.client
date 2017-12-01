package iih.ci.ord.s.bp.ordprn;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import iih.ci.ord.s.bp.ordprn.qry.GetOrdData4PrintQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取已打印的医嘱数据BP
 * @author hums
 *
 */
public class GetOrdData4PrintBP {
	
	public OrdPrintDataDTO[] exec(OrdPrintParamDTO paramDTO) throws BizException {

		// 校验参数合法性
		if (!validateParam(paramDTO)) {
			throw new BizException("传递医嘱打印参数失败");
		}
		
		GetOrdData4PrintQry qry = new GetOrdData4PrintQry(paramDTO);
		OrdPrintDataDTO[] rtn = (OrdPrintDataDTO[]) AppFwUtil.getDORstWithDao(qry, OrdPrintDataDTO.class);
		return rtn;
	}

	// 验证参数是否正确
	private boolean validateParam(OrdPrintParamDTO printParam) {

		return true;
	}
}
