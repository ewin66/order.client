package iih.ci.ord.s.bp.ciprn.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPres8OrdSrvDOQry implements ITransQry {

	private String strIdors;

	public GetPres8OrdSrvDOQry(String strIdors) {
		this.strIdors = strIdors;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String strSql = "SELECT id_pres FROM ci_or_srv "
				+ "WHERE id_or in(" + strIdors + ")";
		return strSql;
	}

}
