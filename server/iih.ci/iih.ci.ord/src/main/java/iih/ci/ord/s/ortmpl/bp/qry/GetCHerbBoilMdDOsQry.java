package iih.ci.ord.s.ortmpl.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询草药煎法
 * @author Young
 *
 */
public class GetCHerbBoilMdDOsQry implements ITransQry {

	public GetCHerbBoilMdDOsQry() {

	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String sql = "select Id_boil,Name from bd_boil where ds<1";
		return sql;
	}

}
