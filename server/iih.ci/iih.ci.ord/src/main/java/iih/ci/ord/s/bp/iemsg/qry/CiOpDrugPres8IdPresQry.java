package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.ICiIEMsgRelSqlConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiOpDrugPres8IdPresQry implements ITransQry {

	private String _id_orsrvs;
	
	public CiOpDrugPres8IdPresQry(String id_orsrvs){
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
		 String formatsql=ICiIEMsgRelSqlConst.CI_IE_ORPHARM_OP_PRES8IDEN_SQL;
		 return String.format(formatsql, "p.id_orsrv in ('"+_id_orsrvs.replaceAll(",", "','")+"')");
	 }

}
