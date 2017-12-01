package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 当前诊断
 * @author li_zheng
 *
 */
public class GetEntDiDOListQry implements ITransQry {

	private String _id_ent;
	
	public GetEntDiDOListQry(String id_ent){
		this._id_ent = id_ent;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam  sqlparam = new SqlParam();
		sqlparam.addParam(this._id_ent);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}

	 private String getSql(){
		return "select * from en_ent_di where id_ent = ? "; 
		 
	 }
}
