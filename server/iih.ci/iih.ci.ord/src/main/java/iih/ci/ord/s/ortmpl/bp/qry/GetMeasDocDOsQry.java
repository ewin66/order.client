package iih.ci.ord.s.ortmpl.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医疗单位
 * @author Young
 *
 */
public class GetMeasDocDOsQry implements ITransQry {

	public GetMeasDocDOsQry() {
		
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String sql = "select Id_measdoc,Name from bd_measdoc where ds<1";
		return sql;
	}

}
