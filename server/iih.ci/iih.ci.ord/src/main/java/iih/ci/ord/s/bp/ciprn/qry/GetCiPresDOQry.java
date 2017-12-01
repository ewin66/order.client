package iih.ci.ord.s.bp.ciprn.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetCiPresDOQry implements ITransQry {

	private String idpres;
	public GetCiPresDOQry(String idpres){
		this.idpres = idpres;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String strSql = "SELECT id_pres,sd_prestpword,sd_prestp FROM ci_pres "
				+ "WHERE id_pres in(" + idpres + ")";
		return strSql;
	}

}
