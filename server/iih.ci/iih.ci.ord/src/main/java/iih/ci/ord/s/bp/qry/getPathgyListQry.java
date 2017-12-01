package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getPathgyListQry implements ITransQry{
	
	public String  _id_ent;
	public getPathgyListQry(String id_ent){
		this._id_ent= id_ent;

	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam  sqlParam = new SqlParam();
		sqlParam.addParam(this._id_ent);

		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		
		return "  select  ci.name_or name , appa.id_appathgy  , ca.ID_SRVCA ,ci.dt_effe "
		  		+ " from ci_rpt_pathgy appa left join CI_ORDER ci on appa.ID_OR=ci.ID_OR left join bd_srv srv on srv.ID_SRV=ci.id_srv "
				  +"   left join bd_srvca ca on ca.ID_SRVCA=srv.ID_SRVCA  "
				  +"  where ci.id_en =? order by ci.dt_effe desc ";
	}
	
}
