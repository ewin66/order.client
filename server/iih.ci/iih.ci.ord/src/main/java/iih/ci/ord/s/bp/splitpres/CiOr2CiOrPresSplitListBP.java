package iih.ci.ord.s.bp.splitpres;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 分方医嘱到临床医嘱分方数据信息列表集合的转换操作BP
 */
public class CiOr2CiOrPresSplitListBP {
	/**
	 * 分方医嘱到临床医嘱分方数据信息列表集合的转换
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	public List<CiOrPresSplitList> exec(CiOrderDO[] ciors)throws BizException{
		//分方医嘱格式化为分方数据DTO
		OrderPresSplitDTO[] orpressplitdtos=ciOrs2CiOrPresSplitDTOs(ciors);
		if(CiOrdUtils.isEmpty(orpressplitdtos))return null;
		
		//分方数据DTO到临床医嘱分方数据信息列表数据 并返回
		return CiOrPresSplitDTO2CiOrPresSplitList(orpressplitdtos);
	}
	
	/**
	 * 分方医嘱格式化为分方数据DTO
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	private OrderPresSplitDTO[] ciOrs2CiOrPresSplitDTOs(CiOrderDO[] ciors) throws BizException{
		CiOrs2CiOrPresSplitDTOsBP bp=new CiOrs2CiOrPresSplitDTOsBP();
		return bp.exec(ciors);
	}
	
	/**
	 * 分方数据DTO到临床医嘱分方数据信息列表数据
	 * 
	 * @param orderpresdtos
	 * @return
	 */
	private List<CiOrPresSplitList> CiOrPresSplitDTO2CiOrPresSplitList(OrderPresSplitDTO[] orderpresdtos) {
		List<CiOrPresSplitList> orderpresList = new ArrayList<CiOrPresSplitList>();
		if (orderpresdtos == null)
			return orderpresList;
		List<OrderPresSplitDTO> Dtolist = new ArrayList<OrderPresSplitDTO>();
		for (OrderPresSplitDTO dto : orderpresdtos) {
			if (dto.getFg_or() != null && dto.getFg_or() == FBoolean.TRUE)
				Dtolist.add(dto);
		}
		CiOrPresSplitList orderPres = new CiOrPresSplitList();
		orderPres.setOrderList(Dtolist);
		orderpresList.add(orderPres);
		return orderpresList;
	}	
}
