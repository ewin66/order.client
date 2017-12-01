/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.ci.ord.dto.ordersrvinfompdto.d.OrderSrvInfoMpDTO;
import iih.ci.ord.s.bp.qry.getOrderSrvInfoMpDTOQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @ClassName: getOrderSrvInfoMpDTOBP
 * @Description: 执行获取医嘱项目和物品信息
 * @author Comsys-li_zheng
 * @date 2016年5月25日 下午5:21:28
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getOrderSrvInfoMpDTOBP {
  
    public OrderSrvInfoMpDTO[] exe(String[] id_ors)throws BizException{
    	getOrderSrvInfoMpDTOQry qry = new getOrderSrvInfoMpDTOQry(id_ors);
    	OrderSrvInfoMpDTO[] orderSrvInfoMpDTO =(OrderSrvInfoMpDTO[])AppFwUtil.getDORstWithDao(qry, OrderSrvInfoMpDTO.class);
    	return orderSrvInfoMpDTO;
    }
}
