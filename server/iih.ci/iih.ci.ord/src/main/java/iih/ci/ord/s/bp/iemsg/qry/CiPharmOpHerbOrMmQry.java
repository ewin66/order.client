package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.ICiIEMsgRelSqlConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiPharmOpHerbOrMmQry implements ITransQry {

	private String _id_preses;
	
	public CiPharmOpHerbOrMmQry(String id_preses){
		this._id_preses = id_preses;
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
		 String formatsql=ICiIEMsgRelSqlConst.CI_IE_ORDRUGHERB_MM_OP_SQL;
		 String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_preses)+getFilterSql();
		 return String.format(formatsql, "A1.Id_Pres"+id_or4sql);
	 }
	 
	 private String getFilterSql(){
		 
		 return " and (A1.sd_srvtp like '0103%' )";
	 }

}
