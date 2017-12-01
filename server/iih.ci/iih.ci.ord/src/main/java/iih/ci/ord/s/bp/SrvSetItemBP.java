package iih.ci.ord.s.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.s.bp.qry.SrvSetItemQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class SrvSetItemBP {
	
	 /**
	 * 取得服务套的项目的服务
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	 public  MedSrvDO[] exec(String id_srv) throws BizException {
		 
		 SrvSetItemQry srvsetitemQry = new SrvSetItemQry(id_srv);
		 MedSrvDO[] medSrvList = (MedSrvDO[])AppFwUtil.getDORstWithDao(srvsetitemQry, MedSrvDO.class);
	     return medSrvList;
	 }

}
