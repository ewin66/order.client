package iih.ci.ord.s.bp.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBttestCodeSql implements ITransQry {

	private String Id_rptbttest;
	private String[] Codes;

	public GetBttestCodeSql(String id_rptbttest, String[] codes) {

		Id_rptbttest = id_rptbttest;
		Codes = codes;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();

		if (!StringUtil.isEmptyWithTrim(Id_rptbttest)) {

			param.addParam(Id_rptbttest);
		}

		if (Codes != null && Codes.length > 0) {

			for (String code : Codes) {

				param.addParam(code);
			}
		}

		return param;
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append(" select *  ");
		SqlStr.append(" from CI_RPT_BTTESTITM ");
		SqlStr.append(" where ds=0 ");

		if (!StringUtil.isEmptyWithTrim(Id_rptbttest)) {

			SqlStr.append(" and Id_rptbttest<>? ");
		}

		if (Codes != null && Codes.length > 0) {

			String whereStr = "";

			for (int i = 0; i < Codes.length; i++) {

				whereStr += (whereStr.length() == 0 ? "" : ",") + "?";
			}

			SqlStr.append(" and barcode_bb in(" + whereStr + ") ");
			
		} else {
			
			SqlStr.append(" and 1=2 ");
		}

		return SqlStr.toString();
	}
}
