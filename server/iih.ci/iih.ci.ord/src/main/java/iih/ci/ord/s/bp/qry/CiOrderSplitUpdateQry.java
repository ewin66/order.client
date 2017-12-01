package iih.ci.ord.s.bp.qry;

import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiOrderSplitUpdateQry implements ITransQry {

	private String[] idOrKeys;
	private FDateTime Dt_last_bl;

	public CiOrderSplitUpdateQry(String[] keys, FDateTime dt_last_bl) {

		idOrKeys = keys;
		Dt_last_bl = dt_last_bl;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		param.addParam(Dt_last_bl);
		param.addParam(new FDateTime());

		if (idOrKeys != null && idOrKeys.length > 0) {

			for (String id_or : idOrKeys) {

				param.addParam(id_or);
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

		SqlStr.append("update ci_order set dt_last_bl=?,sv=? where 1=1 ");

		if (idOrKeys != null && idOrKeys.length > 0) {

			String whereStr = "";

			for (int i = 0; i < idOrKeys.length; i++) {

				whereStr += (whereStr.length() == 0 ? "" : ",") + "?";
			}

			SqlStr.append(" and id_or in (" + whereStr + ")");

		} else {

			SqlStr.append(" and 1=2");
		}

		return SqlStr.toString();

	}
}
