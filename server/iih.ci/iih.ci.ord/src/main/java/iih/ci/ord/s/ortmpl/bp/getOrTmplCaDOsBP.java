package iih.ci.ord.s.ortmpl.bp;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import iih.bd.srv.ortpl.d.OrTmplCaDO;
import iih.ci.ord.s.ortmpl.bp.qry.getOrTmplCaDOsQry;

/**
 * 查询医嘱模板分类
 * @author Young
 *
 */
public class getOrTmplCaDOsBP {

	public OrTmplCaDO[] exec(String id_grp, String id_org, String id_dep, String id_emp, String sd_ortmpltp) throws BizException{
		long  startTime1 = System.currentTimeMillis();
		ITransQry qry=new getOrTmplCaDOsQry(id_grp, id_org, id_dep, id_emp, sd_ortmpltp);
		OrTmplCaDO[] rtn = (OrTmplCaDO[]) AppFwUtil.getDORstWithDao(qry, OrTmplCaDO.class);
		long  startTime2 = System.currentTimeMillis();
		iih.ci.ord.pub.CiOrdUtils.LogerOutInfo("医嘱模板-查询分类集合 耗时：" +(startTime2-startTime1));
		return rtn;
	}
}
