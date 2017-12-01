/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.ci.ord.dto.unchargeordinfo.d.UnchargeOrdSrvDTO;
import iih.ci.ord.s.bp.qry.UnchargeOrderSrvQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @ClassName: UnchargeOrderSrvBP
 * @Description: 为计费的医嘱信息
 * @author Comsys-li_zheng
 * @date 2016年8月30日 下午5:09:22
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class UnchargeOrderSrvBP {

	public UnchargeOrdSrvDTO[] exec(String id_or)throws BizException{
		 UnchargeOrderSrvQry srvQry = new UnchargeOrderSrvQry(id_or);
		 UnchargeOrdSrvDTO[] ordSrvArr = (UnchargeOrdSrvDTO[])AppFwUtil.getDORstWithDao(srvQry, UnchargeOrdSrvDTO.class);
	     return  ordSrvArr;
	   }
	
}
