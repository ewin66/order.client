package iih.ci.ord.s.bp.ciprn;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import iih.ci.ord.pub.CiOrdUtils;

public class CheckAllOrsBlRefoundBP {

	public FBoolean exec(String[] idors) throws BizException {
		if (idors == null || idors.length <= 0)
			return FBoolean.FALSE;
		String stridors = "";
		int n = 0;
		for (String idor : idors) {
			stridors += ",'" + idor + "'";
			n++;
		}

		String strSql = "SELECT count(*) as num_bl FROM ci_order "
				+ "WHERE id_or in(" + stridors.substring(1) + ") and sd_su_bl='2'";
		List<Map<String, Object>> sqlRst = CiOrdUtils.getRsMapList(strSql);

		if (sqlRst == null || sqlRst.size() <= 0)
			return FBoolean.FALSE;
		Integer num_bl = Integer.valueOf(sqlRst.get(0).get("num_bl").toString());
		return num_bl.intValue() == n ? FBoolean.TRUE : FBoolean.FALSE;
	}
}
