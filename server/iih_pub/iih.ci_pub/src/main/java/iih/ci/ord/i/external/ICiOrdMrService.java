package iih.ci.ord.i.external;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.ordermr.d.OrderMrDto;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

/**
 * 临床提供给病历的对外接口
 * 
 * @author HUMS
 *
 */
public interface ICiOrdMrService {
	/**
	 * 处置手动刷新到病历 by yzh 2017-06-06 09:56:54
	 * 
	 * @param id_ent
	 * @param code_entp
	 * @param orders
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 getOrderMrDtoFlushList(String id_ent, String code_entp) throws BizException;
	
	/**
	 * 诊断刷新到病历 by yzh 2017-06-06 11:30:15
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract String getDiagList(String id_ent) throws BizException;
}
