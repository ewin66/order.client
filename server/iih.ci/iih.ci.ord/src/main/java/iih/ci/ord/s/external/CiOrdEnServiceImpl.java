package iih.ci.ord.s.external;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import iih.ci.ord.dto.appobsdto.d.AppObsDto;
import iih.ci.ord.dto.enappointmentdto.d.EnappointmentDTO;
import iih.ci.ord.i.external.ICiOrdEnService;
import iih.ci.ord.s.external.bp.ExistOpenOrdersBp;
import iih.ci.ord.s.external.bp.ExistValidOrdersBp;
import iih.ci.ord.s.external.bp.UpdateAppStatusBP;
import iih.ci.ord.s.external.bp.getAllAppByIdDeptBP;
import iih.ci.ord.s.external.bp.getAllAppByIdPatBP;

@Service(serviceInterfaces={ICiOrdEnService.class}, binding=Binding.JSONRPC)
public class CiOrdEnServiceImpl implements ICiOrdEnService{
	
	/**
	 * 取消接诊校验是否存在有效医嘱
	 * @throws DAException 
	 */
	@Override
	public FBoolean IsExistValidOrders(String id_en, String mode) throws DAException{
		ExistValidOrdersBp bp = new ExistValidOrdersBp();
		return bp.exec(id_en, mode);
	}
	/**
	 * 诊毕校验是否存在开立医嘱
	 * @throws DAException 
	 */
	@Override
	public FBoolean IsExistOpenOrders(String id_en) throws DAException{
		ExistOpenOrdersBp bp = new ExistOpenOrdersBp();
		return bp.exec(id_en);
	}
	/**
	 * 就诊预约接口：按照患者查询未预约的申请单
	 * @param enappointmentDTO
	 * @return
	 */
	@Override
	public AppObsDto[] GetAllAppRequisitionByIdPat(
			EnappointmentDTO enappointmentDTO)throws BizException {
		// TODO Auto-generated method stub
		 if(enappointmentDTO == null || enappointmentDTO.getId_pat()== null) return  null;
		return getAllAppByIdPatBP.getInstance().getAllAppRequisitionByIdPatBP(enappointmentDTO);
	}
	/**
	 * 就诊预约接口：按照执行科室查询未预约的申请单
	 * @param enappointmentDTO
	 * @return
	 */
	@Override
	public AppObsDto[] GetAllAppRequisitionByIdDept(
			EnappointmentDTO enappointmentDTO) throws BizException{
		// TODO Auto-generated method stub
		 if(enappointmentDTO == null || enappointmentDTO.getId_dept() == null) return  null;
		return getAllAppByIdDeptBP.getInstance().getAllAppRequisitionByIdDeptBP(enappointmentDTO);
	}

	
	/**
	 * 更新申请单状态
	 * @param id_or
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public   String UpdateAppStatus(String id_or,Boolean status)throws BizException{
		UpdateAppStatusBP bp =new UpdateAppStatusBP();
		return bp.UpdateAppStatus(id_or,status);
	}
	
}
