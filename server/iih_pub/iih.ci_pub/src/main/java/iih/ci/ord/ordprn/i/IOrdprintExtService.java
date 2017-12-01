package iih.ci.ord.ordprn.i;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import iih.ci.ord.ordprn.d.OrdPrintDO;
import xap.mw.core.data.BizException;

/**
 * 扩展医嘱打印服务接口
 * @author hums
 *
 */
public interface IOrdprintExtService {

	/**
	 * 获取医嘱打印对象集合
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	public abstract OrdPrintDataDTO[] getOrdPrintDataDTOs(OrdPrintParamDTO printParam) throws BizException;
	
	/**
	 * 获取已打印医嘱的页码集合
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	public abstract int[] getPageNums(OrdPrintParamDTO paramDTO) throws BizException;
	
	/**
	 * 根据待打印医嘱，获取对应已打印医嘱中所在页的数据
	 * @param paramDTO 就诊id、长临标识
	 * @param printDataDTOs 待打印医嘱
	 * @return 已打印医嘱（返回需要打印所在页的全部已打印医嘱）
	 * @throws BizException
	 */
	public abstract OrdPrintDO[] GetOrdPrintDOs(OrdPrintParamDTO paramDTO, OrdPrintDataDTO[] printDataDTOs) throws BizException;

	/**
	 * 保存重置打印医嘱
	 * @param paramDTO
	 * @param ordPrintDOs 重整后待打印的医嘱
	 * @return
	 * @throws BizException
	 */
	public abstract OrdPrintDO[] SaveResetOrdPrintDOs(OrdPrintParamDTO paramDTO, OrdPrintDO[] ordPrintDOs) throws BizException;
	
	/**
	 * 删除已打印医嘱
	 * @param ordPrintDOs 医嘱
	 * @return
	 * @throws BizException
	 */
	public abstract void DeleteOrdPrintDOs(OrdPrintDO[] ordPrintDOs) throws BizException;
	
}
