package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class SrvSetItemQry implements ITransQry {
	
	private String _id_srv;
	
    public SrvSetItemQry(String id_srv){
    	this._id_srv = id_srv;
    	
    }
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(_id_srv);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}
	
     private String getSql(){
    	 
    	 return " select srv.* from bd_srv srv, bd_srvset_def def "+
				  "  where srv.id_srv = def.id_srv_itm "+
				  " and  def.id_srv = ?";
     }
}
