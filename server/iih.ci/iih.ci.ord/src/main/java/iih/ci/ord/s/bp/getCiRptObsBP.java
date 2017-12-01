package iih.ci.ord.s.bp;

import iih.ci.ord.cirptobs.d.CiRptObsDO;
import iih.ci.ord.s.bp.qry.getCiRptObsQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 检查的服务
 * @author li_zheng
 *
 */
public class getCiRptObsBP  {

	 /**
	  * 检验结果集
	  * @param id_ent
	  * @return
	  * @throws BizException
	  */
	 public CiRptObsDO[]  exec(String id_ent)throws BizException{
		 if(id_ent == null ) return null;
		 getCiRptObsQry qry = new getCiRptObsQry(id_ent);
		 CiRptObsDO[] rtn =  (CiRptObsDO[])AppFwUtil.getDORstWithDao(qry, CiRptObsDO.class);
		 return rtn;
	 }
 
}
