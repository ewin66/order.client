package iih.ci.ord.s.ortmpl.bp;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import iih.bd.srv.ortpl.dto.OrTmplDTO;
import iih.ci.ord.s.ortmpl.bp.qry.getOrTmplDTOsQry;

/**
 * 查询医嘱模板分类关系
 * @author Young
 *
 */
public class getOrTmplDTOsBP {

	public OrTmplDTO[] exec(String id_ortmplca,String sd_ortmpltp) throws BizException{
		long  startTime1 = System.currentTimeMillis();
		ITransQry qry = new getOrTmplDTOsQry(id_ortmplca, sd_ortmpltp);
		OrTmplDTO[] rtn = (OrTmplDTO[]) AppFwUtil.getDORstWithDao(qry, OrTmplDTO.class);
		long  startTime2 = System.currentTimeMillis();
		iih.ci.ord.pub.CiOrdUtils.LogerOutInfo("医嘱模板-查询模板集合 耗时：" +(startTime2-startTime1));
		return rtn;
	}
}
