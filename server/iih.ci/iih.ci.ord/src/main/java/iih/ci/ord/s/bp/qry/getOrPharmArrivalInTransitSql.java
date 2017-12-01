package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getOrPharmArrivalInTransitSql implements ITransQry {

	private String[] Id_orsrvs;

	public getOrPharmArrivalInTransitSql(String[] id_orsrvs) {
		Id_orsrvs = id_orsrvs;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam Param = new SqlParam();

		if (Id_orsrvs != null && Id_orsrvs.length > 0) {

			for (String id_orsrv : Id_orsrvs) {

				Param.addParam(id_orsrv);
			}
		}

		return Param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}

	public String getSqlStr() {
		
		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append(" select                                                          ");
		SqlStr.append(" orsrvmm.*                                                       ");
		SqlStr.append(" from ci_or_srv_mm orsrvmm                                       ");
		SqlStr.append(" inner join ci_or_srv orsrv on orsrvmm.id_orsrv=orsrv.id_orsrv   ");
		SqlStr.append(" and orsrv.fg_mm='Y'                                             ");

		if (Id_orsrvs != null && Id_orsrvs.length > 0) {

			String whereStr = "";

			for (int i = 0; i < Id_orsrvs.length; i++) {

				whereStr += (whereStr.length() == 0 ? "" : ",") + "?";
			}

			SqlStr.append(" and orsrv.id_orsrv in(" + whereStr + ")                      ");

		} else {

			SqlStr.append(" where 1=2");
		}

		return SqlStr.toString();

	}
}
