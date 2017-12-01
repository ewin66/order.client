package iih.ci.ord.s.bp.splitpres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;

/**
 * 取得分方的数据
 * @author li_zheng
 *
 */
public class GetOrderDrugsSplitDateBP {
	
	public List<OrderPresSplitList> exec(String id_en,String id_pat)throws BizException{
		
		List<OrderPresSplitList> list = new  ArrayList<OrderPresSplitList>();
		OrderPresSplitDTO dto = new OrderPresSplitDTO();
		List<OrderPresSplitDTO>  orderList = new ArrayList<OrderPresSplitDTO>();
		orderList.add(dto);
		list.get(0).setOrderList(orderList);
		return list;
		
	}

}
