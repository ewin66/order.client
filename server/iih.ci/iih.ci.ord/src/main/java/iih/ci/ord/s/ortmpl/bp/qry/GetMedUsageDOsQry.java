package iih.ci.ord.s.ortmpl.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医疗用法
 * @author Young
 *
 */
public class GetMedUsageDOsQry implements ITransQry {

	private String id_dosage;

	public GetMedUsageDOsQry(String id_dosage) {
		this.id_dosage = id_dosage;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String sql = "select distinct a.Id_route,a.Name from bd_route a "
				+ "	left join bd_route_dosage_ref b on a.id_route = b.id_route " 
				+ " where b.id_dosage = '" + this.id_dosage + "' and b.ds=0 and a.ds=0";
		return sql;
	}

}
