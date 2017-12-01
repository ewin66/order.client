package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.s.bp.iemsg.ICiIEMsgRelSqlConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiOpDrugPres8idorQry implements ITransQry {

	private String _idor;
	
	public CiOpDrugPres8idorQry(String id_or){
		this._idor = id_or;
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
		 String formatsql=ICiIEMsgRelSqlConst.CI_IE_ORPHARM_OP_PRES8IDEN_SQL;
		 return String.format(formatsql, "p.id_or in("+_idor+") ");
	 }

}
