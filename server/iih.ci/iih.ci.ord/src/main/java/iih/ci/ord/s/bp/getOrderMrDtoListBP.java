package iih.ci.ord.s.bp;

import iih.ci.ord.dto.ordermr.d.OrderMrDto;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.getOrderMrDtoListQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 病历读取医嘱的信息
 * @author li_zheng
 *
 */
public class getOrderMrDtoListBP {
	/**
	 * 医嘱信息 orderMrdto
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public OrderMrDto[] exec(String id_ent,String type)throws BizException{
		getOrderMrDtoListQry qry = new getOrderMrDtoListQry(id_ent,type);
		OrderMrDto[] rtn =(OrderMrDto[])AppFwUtil.getDORstWithDao(qry, OrderMrDto.class);
		if(rtn != null && rtn.length>0){
		  for(OrderMrDto dto: rtn){
			  if(dto.getDt_end() != null && (CiOrdUtils.MAX_SYS_DATETIME.before(dto.getDt_end()) ||CiOrdUtils.MAX_SYS_DATETIME.equals(dto.getDt_end()))){
				  dto.setDt_end(null);
				  //System.out.println( dto.getDt_end());
			  }
		  }	
		}
		return rtn;
		
	}

}
