package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class TransferStatusUpdatesQry  implements ITransQry {
   private String _id_ortrans;
   private String  _status;
   
	public TransferStatusUpdatesQry(String id_ortrans,String status){
		this._id_ortrans = id_ortrans;
		this._status = status;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(this._status);
		rtnParam.addParam(this._id_ortrans);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
 
	 private String getSql(){
		 return   "  update CI_AP_TRANS "
		 		+ "  set sd_su_trans  =  ?  "
		 		+ "  where id_ortrans =? ";
	 }
}
