package iih.ci.ord.s.bp.qry;

import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiOrderSrvSplitUpdateQry implements ITransQry {

	private String[] idOrSrvKeys;
	private FDateTime Dt_last_bl;

	public CiOrderSrvSplitUpdateQry(String[] keys, FDateTime dt_last_bl) {

		idOrSrvKeys = keys;
		Dt_last_bl = dt_last_bl;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		param.addParam(Dt_last_bl);
		param.addParam(new FDateTime());

		if (idOrSrvKeys != null && idOrSrvKeys.length > 0) {

			for (String id_orsrv : idOrSrvKeys) {

				param.addParam(id_orsrv);
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}

	public String getSqlStr() {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append("update ci_or_srv set dt_last_bl=?,sv=? where 1=1 ");

		if (idOrSrvKeys != null && idOrSrvKeys.length > 0) {

			String whereStr = "";

			for (int i = 0; i < idOrSrvKeys.length; i++) {

				whereStr += (whereStr.length() == 0 ? "" : ",") + "?";
			}

			SqlStr.append(" and id_orsrv in (" + whereStr + ")");

		} else {

			SqlStr.append(" and 1=2");
		}

		return SqlStr.toString();
	}
}
