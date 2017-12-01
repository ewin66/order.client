package iih.ci.ord.ordprn.s;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import iih.ci.ord.ordprn.d.OrdPrintDO;
import iih.ci.ord.ordprn.i.IOrdprintExtService;
import iih.ci.ord.s.bp.ordprn.GetOrdData4PrintBP;
import iih.ci.ord.s.bp.ordprn.GetOrdPrintDOBP;
import iih.ci.ord.s.bp.ordprn.GetOrdPrintPageNumsBP;
import iih.ci.ord.s.bp.ordprn.OrdPrintDODeleteBP;
import iih.ci.ord.s.bp.ordprn.OrdPrintDOResetSaveBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IOrdprintExtService.class }, binding = Binding.JSONRPC)
public class OrdprintExtServiceImpl implements IOrdprintExtService {

	/**
	 * 获取医嘱打印对象
	 * 
	 * @param printParam 查询打印医嘱的参数
	 */
	@Override
	public OrdPrintDataDTO[] getOrdPrintDataDTOs(OrdPrintParamDTO printParam) throws BizException {

		GetOrdData4PrintBP bp = new GetOrdData4PrintBP();
		return bp.exec(printParam);
	}

	@Override
	public int[] getPageNums(OrdPrintParamDTO paramDTO) throws BizException {

		GetOrdPrintPageNumsBP bp = new GetOrdPrintPageNumsBP();
		return bp.exec(paramDTO);
	}

	@Override
	public OrdPrintDO[] GetOrdPrintDOs(OrdPrintParamDTO paramDTO, OrdPrintDataDTO[] printDataDTOs) throws BizException {

		GetOrdPrintDOBP bp = new GetOrdPrintDOBP();
		return bp.exec(paramDTO, printDataDTOs);
	}

	@Override
	public OrdPrintDO[] SaveResetOrdPrintDOs(OrdPrintParamDTO paramDTO, OrdPrintDO[] printDOs) throws BizException {

		OrdPrintDOResetSaveBP bp = new OrdPrintDOResetSaveBP();
		return bp.exec(paramDTO, printDOs);
	}
	
	@Override
	public void DeleteOrdPrintDOs(OrdPrintDO[] ordPrintDOs) throws BizException {
		
		OrdPrintDODeleteBP bp=new OrdPrintDODeleteBP();
		bp.exec(ordPrintDOs);
	}

}
