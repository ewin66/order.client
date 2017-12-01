/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.s.bp.qry.GetMedSrvItemDOBP;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @ClassName: GetMedSrvSetItemBP
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年12月1日 下午2:36:21
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class GetMedSrvSetItemBP {
 
	public MedSrvSetItemDO[] exec(String id_srv)throws BizException{
		 GetMedSrvItemDOBP qry = new GetMedSrvItemDOBP(id_srv);
		  MedSrvSetItemDO[] rtn = (MedSrvSetItemDO[])AppFwUtil.getDORstWithDao(qry, MedSrvSetItemDO.class);
		 return rtn;
	}
}
