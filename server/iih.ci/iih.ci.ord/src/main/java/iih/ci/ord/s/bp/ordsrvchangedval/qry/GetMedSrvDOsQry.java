package iih.ci.ord.s.bp.ordsrvchangedval.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医疗服务查询
 * 
 * @author YANG
 *
 */
public class GetMedSrvDOsQry implements ITransQry {

	private String sql = "select t.*,t.rowid from bd_srv t where t.id_srv in( %s )";

	private String[] ids;

	public GetMedSrvDOsQry(String[] ids) {
		this.ids = ids;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam sqlparam = new SqlParam();
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer sqlBuffer = new StringBuffer();
		StringBuffer idsBuffer = new StringBuffer();

		for (int i = 0; i < ids.length; i++) {

			idsBuffer.append(",'" + ids[i] + "'");
			if ((i > 0 && i % 900 == 0) || i == ids.length - 1) {

				String tempSql = String.format(sql, idsBuffer.substring(1));
				sqlBuffer.append(" union " + tempSql);
				idsBuffer.setLength(0);
			}
		}

		return sqlBuffer.substring(6);
	}
}
