package iih.ci.ord.i.external;

import iih.ci.ord.dto.appobsdto.d.AppObsDto;
import iih.ci.ord.dto.enappointmentdto.d.EnappointmentDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;

/**
 * 就诊预约接口
 * @author li_zheng
 *
 */
public interface ICiOrdEnService {

	
	/**
	 * 取消接诊校验是否存在有效医嘱
	 * @param id_en 就诊号
	 * @param Mode4CheckExistValidOrdersEnum 判断类型：ORDERSTATUS0，是否存在未作废未退费医嘱；ORDERSTATUS1，是否存在有效医嘱；ORDERSTATUS2，是否存在已交费的有效医嘱
	 * @return
	 */
	public abstract FBoolean IsExistValidOrders(String id_en, String mode) throws DAException;
	
	/**
	 * 诊毕校验是否存在开立医嘱
	 * @param id_en 就诊号
	 * @return
	 */
	public abstract FBoolean IsExistOpenOrders(String id_en) throws DAException;
	/**
	 * 就诊预约接口：按照患者查询未预约的申请单
	 * @param enappointmentDTO
	 * @return
	 */
	public abstract AppObsDto[] GetAllAppRequisitionByIdPat(EnappointmentDTO enappointmentDTO)throws BizException;
	/**
	 * 就诊预约接口：按照执行科室查询未预约的申请单
	 * @param enappointmentDTO
	 * @return
	 */
	public abstract AppObsDto[] GetAllAppRequisitionByIdDept(EnappointmentDTO enappointmentDTO)throws BizException;
	
	/**
	 * 更新申请单状态
	 * @param id_or
	 * @param status Y 预约 N  取消预约（申请状态）
	 * @return
	 * @throws Exception
	 */
	public abstract String UpdateAppStatus(String id_or,Boolean status )throws BizException;
	
}
