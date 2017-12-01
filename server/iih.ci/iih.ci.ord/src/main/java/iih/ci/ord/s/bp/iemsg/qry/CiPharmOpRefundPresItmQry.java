package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.ICiIEMsgRelSqlConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiPharmOpRefundPresItmQry implements ITransQry {

	private String _id_preses;
	private String _id_orsrvs;
	
	public CiPharmOpRefundPresItmQry(String id_preses,String id_orsrvs){
		this._id_preses = id_preses;
		this._id_orsrvs = id_orsrvs;
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
		 String formatsql=ICiIEMsgRelSqlConst.CI_IE_ORDRUGWC_OP_SQL;
		 String id_pres4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_preses)+getFilterSql();
		 String id_orsrvs4sql = CiOrdUtils.getSqlInOrEqualStrs(_id_orsrvs);
		 return String.format(formatsql, "A1.Id_Pres"+id_pres4sql+" and A1.id_orsrv" + id_orsrvs4sql);
	//	 return formatsql+ " and A1.Id_Pres"+id_pres4sql;
	 }
	 
	 private String getFilterSql(){
		 
		 return " and (A1.sd_srvtp like '0102%' or A1.sd_srvtp like '0101%')";
	 }
	 

}
