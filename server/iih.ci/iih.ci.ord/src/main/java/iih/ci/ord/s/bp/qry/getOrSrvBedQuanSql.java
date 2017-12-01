package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getOrSrvBedQuanSql implements ITransQry {

	private String[] Id_ors;

	public getOrSrvBedQuanSql(String[] id_ors) {
		Id_ors = id_ors;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam Param = new SqlParam();
		
		Param.addParam(ICiDictCodeConst.SD_MUPKGUTP_QUAN);
		if (Id_ors != null && Id_ors.length > 0) {

			for (String id_or : Id_ors) {

				Param.addParam(id_or);
			}
		}
		return Param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}

	public String getSqlStr() {
		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append(" select                                                             ");
		SqlStr.append(" orsrv.*                                                            ");
		SqlStr.append(" from ci_or_srv orsrv                                               ");
		SqlStr.append(" left join ci_or_srv_mm orsrvmm on orsrvmm.id_orsrv=orsrv.id_orsrv  ");
		SqlStr.append(" and orsrv.fg_mm='Y'                                                ");
		SqlStr.append(" left join bd_mm mm on mm.id_mm=orsrvmm.id_mm                       ");
		SqlStr.append(" where mm.sd_mupkgutp=?                                             ");

		if (Id_ors != null && Id_ors.length > 0) {

			String whereStr = "";

			for (int i = 0; i < Id_ors.length; i++) {

				whereStr += (whereStr.length() == 0 ? "" : ",") + "?";
			}

			SqlStr.append(" and orsrv.id_or in(" + whereStr + ")");

		} else {

			SqlStr.append(" and 1=2");
		}

		return SqlStr.toString();

	}

}
