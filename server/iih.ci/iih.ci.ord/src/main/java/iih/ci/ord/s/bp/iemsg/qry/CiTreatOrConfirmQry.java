package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.s.bp.iemsg.ICiIEMsgRelSqlConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiTreatOrConfirmQry implements ITransQry {

	private String _id_or;
	
	public CiTreatOrConfirmQry(String id_or){
		this._id_or = id_or;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam(_id_or);
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}
   
	/**
	 * 获得查询sql串
	 * @return
	 */
	 private String getSql(){
		 return ICiIEMsgRelSqlConst.CI_IE_ORTREAT_CONFIRM_SQL;
	 }

}
