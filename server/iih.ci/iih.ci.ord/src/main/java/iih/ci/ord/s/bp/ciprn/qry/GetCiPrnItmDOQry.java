package iih.ci.ord.s.bp.ciprn.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 诊疗收费清单打印明细数据查询
 * 
 * @author YANG
 *
 */
public class GetCiPrnItmDOQry implements ITransQry {

	private String stridsrvs;
	private boolean isPrn;

	public GetCiPrnItmDOQry(String stridsrvs, boolean isPrn) {
		this.stridsrvs = stridsrvs;
		this.isPrn = isPrn;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String strSql = "SELECT ci_prn_item.* FROM ci_prn_item "
				+ "LEFT JOIN ci_prn ON ci_prn_item.id_ciprn=ci_prn.id_ciprn " + "WHERE ci_prn_item.ds<1 "
				+ "AND ci_prn_item.id_biz in(" + this.stridsrvs + ") " + "AND ci_prn.fg_prn="
				+ (this.isPrn ? "'Y' " : "'N' ");
		return strSql;
	}

}
