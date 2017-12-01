package iih.ci.ord.s.bp.reportstatus.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetUdidocByCodeSql implements ITransQry {

	private String ListCode;
	private String ItmCode;

	public GetUdidocByCodeSql(String listCode, String itmCode) {

		ListCode = listCode;
		ItmCode = itmCode;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam Param = new SqlParam();

		Param.addParam(ListCode);
		
		if (StringUtil.isEmptyWithTrim(ItmCode)) {

			Param.addParam(ItmCode);
		}

		return Param;
	}

	@Override
	public String getQrySQLStr() {

		return getSqlStr();
	}

	public String getSqlStr() {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append(" select doc.* from bd_udidoc doc             ");
		SqlStr.append(" left join bd_udidoclist doclist             ");
		SqlStr.append(" on doc.id_udidoclist=doclist.id_udidoclist  ");
		SqlStr.append(" where doclist.code=?                        ");
		
		if (StringUtil.isEmptyWithTrim(ItmCode)) {

			SqlStr.append(" and doc.code=? ");
		}
		

		return SqlStr.toString();
	}

}