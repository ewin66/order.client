package iih.ci.ord.s.bp.qry;

import iih.ci.ord.cior.d.CiOrLastMpDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiOrLastMpJudgeQry implements ITransQry {

	private CiOrLastMpDTO[] _param;

	public CiOrLastMpJudgeQry(CiOrLastMpDTO[] param) {
		this._param = param;
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
	 * 
	 * @return
	 */
	private String getSql() {

		StringBuffer sqlStr = new StringBuffer();

		sqlStr.append(" select A.id_or,A.code_entp,A.fg_long,A.sd_srvtp,A.id_freq,B.Sd_Frequnitct as sd_frequnit,");
		sqlStr.append(" B.frequnitct,B.freqct,A.dt_effe,A.dt_end,null as dt_mp_plan,3 as eu_last,A.fg_pres_outp");
		sqlStr.append(" from ci_order A left outer join bd_freq B ON A.Id_Freq=B.Id_Freq");
		sqlStr.append(" where A.id_or ");
		sqlStr.append(getIdOrSQlStr());

		return sqlStr.toString();

		// return
		// " select A.id_or,A.code_entp,A.fg_long,A.sd_srvtp,A.id_freq,B.Sd_Frequnitct as sd_frequnit, "
		// +
		// " B.frequnitct,B.freqct,A.dt_effe,A.dt_end,null as dt_mp_plan,3 as eu_last,A.fg_pres_outp "
		// + " from ci_order A left outer join bd_freq B ON A.Id_Freq=B.Id_Freq"
		// + " where A.id_or "
		// + getIdOrSQlStr();
	}

	/**
	 * 获得条件sql片段串
	 * 
	 * @param param
	 * @return
	 */
	private String getIdOrSQlStr() {
		int iN = 0;
		// StringBuffer sb = new StringBuffer();

		String whereStr = "";
		for (CiOrLastMpDTO param : _param) {
			iN++;
			whereStr += ((whereStr.length() == 0 ? "" : ",") + "'" + param.getId_or() + "'");
		}

		if (iN == 0) {
			return null;
		}

		if (iN == 1) {
			return "=" + whereStr;
		} else {
			return "in (" + whereStr + ")";
		}

		// // 遍历
		// for (CiOrLastMpDTO lastmpdto : this._param) {
		// iN += 1;
		// //
		// sb.append(CiOrdUtils.getSqlCondStrWithComma(lastmpdto.getId_or()));
		// sb.append("," + lastmpdto.getId_or());// 2016-08-26字符串不应该加单引号
		// }
		//
		// if (iN == 0)
		// return null; // 判断
		// String idsStr = sb.toString().substring(1);
		//
		// if (iN == 1)
		// return CiOrdUtils.EQUAL_STR + CiOrdUtils.getSqlCondStr(idsStr);
		// // return CiOrdUtils.IN_STR_WITHBLANK +
		// // CiOrdUtils.getSqlInStrsWithOutIn(idsStr);
		// return CiOrdUtils.IN_STR_WITHBLANK + "(" + idsStr + ")";
	}
}
