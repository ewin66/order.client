package iih.ci.ord.s.bp.orsms.lis.qry;

import iih.ci.ord.s.bp.orsms.lis.rule.CiLisOrSmsUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiLisOpOrSmsQry implements ITransQry {

	private String _id_en;
	
	public CiLisOpOrSmsQry(String id_en){
		this._id_en = id_en;
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
		 String formatsql=CiLisOrSmsUtils.CILISOR_SMS_EN_SQL;
		 return String.format(formatsql, _id_en);
	 }

}
