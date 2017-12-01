package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.dto.patundoorderdto.d.PatUnDoOrderdto;
import iih.ci.ord.s.bp.qry.getTreeOrdApConsDOQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 会诊树
 * @author li_zheng
 *
 */
public class getTreeOrdApConsDOBP {

	public OrdApConsDO[] exec(String id_ent)throws BizException{
		getTreeOrdApConsDOQry qry = new getTreeOrdApConsDOQry(id_ent);
		OrdApConsDO rtn[] = (OrdApConsDO[])AppFwUtil.getDORstWithDao(qry, OrdApConsDO.class);
	    
		
		return rtn;
	}
	
}
