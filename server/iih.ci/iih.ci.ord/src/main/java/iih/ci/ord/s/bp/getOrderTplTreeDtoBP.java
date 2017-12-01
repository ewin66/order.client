/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.bd.srv.dto.d.Emp2Dep2GroupDTO;
import iih.ci.ord.dto.ordermr.d.OrderMrDto;
import iih.ci.ord.dto.ordertpltree.d.OrderTplTreeDto;
import iih.ci.ord.s.bp.qry.getOrderTplTreeDtoQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @ClassName: getOrderTplTreeDtoBP
 * @Description: 医嘱助手模板树
 * @author Comsys-li_zheng
 * @date 2016年3月5日 上午11:38:20
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getOrderTplTreeDtoBP {

	 
	public OrderTplTreeDto[] getOrderTplTreeDto(String id_ortpltp,Emp2Dep2GroupDTO edg)throws BizException{
		getOrderTplTreeDtoQry qry = new getOrderTplTreeDtoQry(id_ortpltp,edg);
		return (OrderTplTreeDto[])AppFwUtil.getDORstWithDao(qry, OrderTplTreeDto.class);
	}
	
}
