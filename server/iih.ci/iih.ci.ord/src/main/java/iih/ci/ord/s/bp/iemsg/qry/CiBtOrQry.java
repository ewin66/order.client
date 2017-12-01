package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.ICiIEMsgRelSqlConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiBtOrQry implements ITransQry {

	private String _id_ors;
	
	public CiBtOrQry(String id_ors){
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
		 String formatsql=ICiIEMsgRelSqlConst.CI_IE_ORBU_SQL;
		 String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_ors);
		 return String.format(formatsql, "A.id_or"+id_or4sql+" and A1.Sd_Srvtp like '14%'");
	 }

}
