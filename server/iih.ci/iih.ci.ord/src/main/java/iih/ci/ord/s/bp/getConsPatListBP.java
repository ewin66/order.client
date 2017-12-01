package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.s.bp.qry.GetConsPatListQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 会诊患者
 * @author li_zheng
 *
 */
public class getConsPatListBP {

	public CiOrderDO[] exec(String id_dept,String id_emp)throws BizException{
		CiOrderDO[] rtn = null;
		if(id_dept != null && id_dept != "" && id_emp != null && id_emp !=""){
			GetConsPatListQry qry = new GetConsPatListQry(id_dept,id_emp);
		    rtn = (CiOrderDO[])AppFwUtil.getDORstWithDao(qry, CiOrderDO.class);
		}
		return rtn;
	}
}
