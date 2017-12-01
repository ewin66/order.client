package iih.ci.ord.s.bp.splitlis;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.splitlis.d.CiOrdLisSplitList;
import iih.ci.ord.splitlis.d.LisOrderSplitDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;

/**
 * 分方医嘱到临床医嘱分方数据信息列表集合的转换操作BP
 */
public class CiOr2CiOrLisSplitListBP {
	/**
	 * 分方医嘱到临床医嘱分方数据信息列表集合的转换
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	public List<CiOrdLisSplitList> exec(CiOrderDO[] ciors)throws BizException{
		//分方医嘱格式化为分方数据DTO
		LisOrderSplitDTO[] orpressplitdtos=ciOrs2CiOrLisSplitDTOs(ciors);
		if(CiOrdUtils.isEmpty(orpressplitdtos))return null;
		
		//分方数据DTO到临床医嘱分方数据信息列表数据 并返回
		return CiOrLisSplitDTO2CiOrLisSplitList(orpressplitdtos);
	}
	
	/**
	 * 分方医嘱格式化为分方数据DTO
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	private LisOrderSplitDTO[] ciOrs2CiOrLisSplitDTOs(CiOrderDO[] ciors) throws BizException{
		CiOrs2CiOrLisSplitDTOsBP bp=new CiOrs2CiOrLisSplitDTOsBP();
		return bp.exec(ciors);
	}
	
	/**
	 * 分方数据DTO到临床医嘱分方数据信息列表数据
	 * @param orderlisdtos
	 * @return
	 */
    private List<CiOrdLisSplitList> CiOrLisSplitDTO2CiOrLisSplitList( LisOrderSplitDTO[] orderlisdtos){
   	 List<CiOrdLisSplitList> orderlisList = new ArrayList<CiOrdLisSplitList>();
   	 List Dtolist = new ArrayList<LisOrderSplitDTO>();
   	CiOrdLisSplitList orderLis = new CiOrdLisSplitList();
   	 if(orderlisdtos == null ) return orderlisList;
   	 for(LisOrderSplitDTO dto:orderlisdtos){
   		 Dtolist.add(dto);
   	 }
   	 orderLis.setOrderList(Dtolist);;
   	 orderlisList.add(orderLis) ;
   	 return orderlisList;
    }
	
}
