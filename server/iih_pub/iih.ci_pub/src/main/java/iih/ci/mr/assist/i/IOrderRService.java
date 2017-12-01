package iih.ci.mr.assist.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.ordermr.d.OrderMrDto;

public interface IOrderRService {
	public OrderMrDto[] getOrderMrDtoList(String id_ent,String code_entp) throws BizException;
	public OrderMrDto[] getOrderMrDtoFlush2MrList(String id_ent,String code_entp,CiOrderDO[] orders) throws BizException;
}