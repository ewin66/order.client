package iih.ci.ord.s.bp.orsms.lis.qry;

import iih.ci.ord.s.bp.orsms.lis.rule.CiLisOrSmsUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiLisOpOrSmsOrdSrvQry implements ITransQry {

	private String _id_ors;
	
	public CiLisOpOrSmsOrdSrvQry(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
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
		 String formatsql=CiLisOrSmsUtils.CILISOR_SMS_ORSRV_SQL+" where id_or in ("+_id_ors+")";
		 return formatsql;
	 }

}
