package iih.ci.ord.s.bp.reportstatus;

import iih.ci.ord.s.bp.reportstatus.qry.GetUdidocByCodeSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 获取字典
 * 
 * @author xuxing_2016-11-18
 *
 */
public class GetUdidocByCodeBp {

	public UdidocDO[] exec(String listCode, String itmCode) throws BizException {

		GetUdidocByCodeSql Sql = new GetUdidocByCodeSql(listCode, itmCode);

		UdidocDO[] rtn = (UdidocDO[]) AppFwUtil.getDORstWithDao(Sql, UdidocDO.class);

		return rtn;
	}

}
