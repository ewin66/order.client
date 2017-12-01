package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.s.bp.iemsg.ICiIEMsgRelSqlConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiOpDrugPresMesg8IdPresQry implements ITransQry {

	private String _id_preses;
	
	public CiOpDrugPresMesg8IdPresQry(String id_preses){
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
		 String formatsql=ICiIEMsgRelSqlConst.CI_IE_ORPHARM_OP_IDPRES_SQL;
		 return String.format(formatsql, "'"+_id_preses.replaceAll(",", "','")+"'");
	 }

}
