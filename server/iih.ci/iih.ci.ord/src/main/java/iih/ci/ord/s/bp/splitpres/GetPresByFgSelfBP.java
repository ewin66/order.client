package iih.ci.ord.s.bp.splitpres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
/**
 * 自定义服务分方
  * @ClassName: GetPresByFgSelfBP
  * @Description: TODO
  * @author Comsys-li_zheng
  * @date 2016年10月9日 下午3:15:33
  * @Package iih.ci.ord.s.bp.splitpres
  * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class GetPresByFgSelfBP implements PresSplitBaseRule {
	   
		List<OrderPresSplitList> outList;
		
		
		 List<OrderPresSplitDTO>   OrdinaryList = new ArrayList<OrderPresSplitDTO>();
		 
		 
		
		@Override
		public List<OrderPresSplitList> exec(List<OrderPresSplitList> list)
				throws BizException {
			// TODO Auto-generated method stub
			// 根据是否是自定义  TODO
			
			outList = new ArrayList<OrderPresSplitList>();
			if(list != null)
			  {
				 AnalyzeOrderPresSplitList(list);
			  }
			return outList;
		}

		/**
		 * 
		 * @param orderpresSplitList
		 */
		 private  void AnalyzeOrderPresSplitList(List<OrderPresSplitList> orderpresSplitList){
			   for(OrderPresSplitList orderPresSplit:orderpresSplitList){
				   if(orderPresSplit.isAppRule){
					   List<OrderPresSplitDTO> orderList =  orderPresSplit.getOrderList();
					   AnalyzeOrderPresSplitDTO(orderList);
				   }
			   }
		 }
		 /**
		  * 
		  * @param orderPresSplitDTOList
		  */
		 private  void AnalyzeOrderPresSplitDTO(List<OrderPresSplitDTO> orderPresSplitDTOList){
			 
			
			    for(OrderPresSplitDTO  dto : orderPresSplitDTOList){
			    	
			    	FBoolean fgself=dto.getFg_self();
			    	
			    	
			    	
			    	//非自定义项
					 if(fgself==FBoolean.FALSE){
						 
						 OrdinaryList.add(dto);
					 }
					 
				
			    }
			    
			   
			    if(!ListUtil.isEmpty(OrdinaryList)){
				    OrderPresSplitList Ordinary = new OrderPresSplitList();
				    Ordinary.setName(PresConstant.ORDINARY);
				    Ordinary.setSd_pres(PresConstant.SD_ORDINARY);
				    Ordinary.setId_pres(PresConstant.ID_ORDINARY);
				    Ordinary.setCode(OrdinaryList.get(0).getSd_srvtp());
				    Ordinary.isAppRule=true;
				    Ordinary.setOrderList(OrdinaryList);
				    outList.add(Ordinary);
			    }
		 }

}
