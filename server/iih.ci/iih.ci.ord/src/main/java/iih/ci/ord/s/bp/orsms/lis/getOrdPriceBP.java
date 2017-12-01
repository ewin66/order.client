package iih.ci.ord.s.bp.orsms.lis;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.s.bp.orsms.lis.qry.CiLisOpOrSmsOrdSrvQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;

public class getOrdPriceBP {
	
	
public OrdSrvDO[] exec(String id_ors)throws BizException{
		
		ITransQry qry = new CiLisOpOrSmsOrdSrvQry(id_ors);
		OrdSrvDO[] rtn = (OrdSrvDO[]) AppFwUtil.getDORstWithDao(qry,OrdSrvDO.class);
		return rtn;
		
	}

}
