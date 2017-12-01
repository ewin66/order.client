package iih.ci.ord.s.bp.iemsg.qry;

import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.ci.ord.s.bp.iemsg.ICiIEMsgRelSqlConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiOpDrugPres8idenQry implements ITransQry {

	private String _iden;
	
	public CiOpDrugPres8idenQry(String id_en){
		this._iden = id_en;
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
//		 return String.format(formatsql, "p.id_en='"+_iden+"'");
		 return String.format(formatsql, "p.id_or in (select id_or from ci_order where id_en='"+_iden+"'  and fg_sign='Y' and fg_canc='N' and sd_srvtp like '01%') "
		 		+ " and p.id_su_bl in('"+ICiDictCodeTypeConst.ID_SU_BL_1+"','"+ICiDictCodeTypeConst.ID_SU_BL_0+"')");
	 }

}
