package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetNurAreaOfDepQry  implements ITransQry{

	private String _id_dep;
	
	public GetNurAreaOfDepQry(String _id_dep){
		this._id_dep=_id_dep;
	}
	
	 
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(_id_dep);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return "select d2.id_dep from bd_depl_dep d1 inner join bd_depl_dep d2 "+
			      " on d1.id_depl=d2.id_depl where d1.id_dep=?";   
	}
}
