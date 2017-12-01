package iih.ci.ord.s.bp.ciprn.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetTreateExecIdorQry implements ITransQry {

	private String idors;
	public GetTreateExecIdorQry(String idors){
		this.idors = idors;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String strSql = "SELECT id_or FROM ci_app_treatexec_or "
				+ "WHERE id_or in(" + idors + ")";
		return strSql;
	}

}
