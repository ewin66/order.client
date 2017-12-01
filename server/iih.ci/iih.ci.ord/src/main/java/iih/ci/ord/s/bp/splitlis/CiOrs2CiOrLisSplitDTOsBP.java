package iih.ci.ord.s.bp.splitlis;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.GetOrderDrugsSplitDateNewQry;
import iih.ci.ord.s.bp.splitlis.Qry.GetOrderLisSplitQry;
import iih.ci.ord.splitlis.d.LisOrderSplitDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 分方医嘱格式化为分方数据DTO操作BP
 */
public class CiOrs2CiOrLisSplitDTOsBP {
	/**
	 * 分方医嘱格式化为分方数据DTO
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	public LisOrderSplitDTO[] exec(CiOrderDO[] ciors)throws BizException{
		//获得医嘱集合对应的ID_or主键标识sql串片段
		String id_ors=getIdOrsSqlStr(ciors);
		if(CiOrdUtils.isEmpty(id_ors))return null;
			
		//获得查询结果并返回
		GetOrderLisSplitQry qry = new GetOrderLisSplitQry(ciors[0].getId_en(),id_ors,ciors[0].getCode_entp());
		 LisOrderSplitDTO[] rtn = (LisOrderSplitDTO[])AppFwUtil.getDORstWithDao(qry, OrderPresSplitDTO.class);
		 return  rtn;
	}
	
	/**
	 * 获得医嘱集合对应的ID_or主键标识sql串片段
	 * @param ciors
	 * @return
	 */
	private String getIdOrsSqlStr(CiOrderDO[] ciors){
		if(ciors==null && ciors.length==0 )return null;
		StringBuilder builder = new StringBuilder();
		Boolean first = true;
		for (CiOrderDO ci : ciors) {
			if (first) {
				first = false;
			} else {
				builder.append(',');
			}
			builder.append(String.format("'%s'", ci.getId_or()));
		}
		
		return builder.toString();
	}
	

	
}
