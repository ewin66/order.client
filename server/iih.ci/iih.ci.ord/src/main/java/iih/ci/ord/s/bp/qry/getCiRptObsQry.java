package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getCiRptObsQry implements ITransQry {
	public String _id_ent;
	
	public getCiRptObsQry(String id_ent){
		this._id_ent = id_ent;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this._id_ent);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return GetSql();
	}

	
	private String  GetSql(){
		
		return " select  * from ci_rpt_obs lab where lab.id_or in ( "
				+ "  select id_or from ci_order where id_en =? and   sd_srvtp like '02%' "
				+" ) ";
	}
}
