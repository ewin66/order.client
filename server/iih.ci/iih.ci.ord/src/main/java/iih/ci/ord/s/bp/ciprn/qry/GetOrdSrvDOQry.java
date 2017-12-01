package iih.ci.ord.s.bp.ciprn.qry;

import iih.bd.utils.BdEnvContextUtil;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.s.bp.ciprn.CiprnUtils;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 诊疗收费清单服务数据查询
 * @author YANG
 *
 */
public class GetOrdSrvDOQry implements ITransQry {
	private String strIdors;

	public GetOrdSrvDOQry(String strIdors) {
		this.strIdors = strIdors;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		//		SqlParam param = new SqlParam();
		//		param.addParam(this.strIdors);
		//		return param;
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String orgsql = BdEnvContextUtil.processEnvContext(new OrdSrvDO(), "ci_or_srv");
		String strSql = "SELECT ci_or_srv.id_orsrv FROM ci_or_srv " 
		+ " LEFT JOIN ci_order ON ci_order.id_or=ci_or_srv.id_or "
		+ " WHERE ci_or_srv.ds<1 " 
		+ " AND ci_or_srv.id_or in(" + this.strIdors + ") "
		+ " AND ci_or_srv.fg_bl='Y' "
		+ " AND (ci_or_srv.eu_feereversetp not in (1) or ci_or_srv.eu_feereversetp is null) ";
		try {
			String strRange = CiprnUtils.GetCostListDataRangeSql();
			if (!StringUtils.isNullOrEmpty(strRange))
				strSql += " AND " + strRange;
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strSql + " AND " + orgsql;
	}
}
