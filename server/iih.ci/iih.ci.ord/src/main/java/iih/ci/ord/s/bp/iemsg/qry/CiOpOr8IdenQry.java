package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.s.bp.iemsg.ICiIEMsgRelSqlConst;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊检查查询对象
 *
 */
public class CiOpOr8IdenQry implements ITransQry {

	private String _id_en;
	
	public CiOpOr8IdenQry(String id_en){
		this._id_en = id_en;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		try {
			return getSql();
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
   
	/**
	 * 获得查询sql串
	 * @return
	 * @throws BizException 
	 */
	 private String getSql() throws BizException{
		String condition = " A.id_en = '" + _id_en + "' and A.fg_sign = 'Y' and A.fg_canc='N' and A.sd_srvtp like '01%'";
		String formatsql = String.format(ICiIEMsgRelSqlConst.CI_IE_OP_8IDEN_SQL, condition);

		return formatsql;
	 }

}
