package iih.ci.ord.s.bp.qry;

import iih.ci.ord.ciorder.d.FeeReverseType;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取本次就诊中关联保外诊断的医嘱
 * 
 * @author HUMS
 *
 */
public class CiOrdersUsedHpCidiQry implements ITransQry {

	private String id_en;
	private String id_didef;

	public CiOrdersUsedHpCidiQry(String id_en, String id_didef) {
		this.id_en = id_en;
		this.id_didef = id_didef;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		param.addParam(id_en);
		param.addParam("%" + id_didef + "%");
		return param;

	}

	@Override
	public String getQrySQLStr() {

		return "select id_or,name_or from ci_order where id_en = ? and des_bhpjudgerst like ? and fg_canc = 'N' and  (eu_feereversetp is null or eu_feereversetp != '"
				+ FeeReverseType.BLCGCANCEL + "' ) ";
	}
}
