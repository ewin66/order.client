package iih.ci.ord.cior.refs;

import java.util.List;

import iih.ci.ord.cior.d.OrdApPathgyDO;
import xap.mw.core.data.Context;
import xap.sys.appfw.refinfo.RefGridModel;

public class OrdApPathgyNORefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[]{OrdApPathgyDO.NO_PATHGY};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{OrdApPathgyDO.DT_RPTPATHGY,OrdApPathgyDO.NAME_DIAG};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"病理号"};
	}
	
	@Override
	public String getPkFieldCode() {
		return OrdApPathgyDO.NO_PATHGY;
	}
	@Override
	public String getRefCodeField() {
		return OrdApPathgyDO.NO_PATHGY;
	}
	@Override
	public String getRefNameField() {
		return OrdApPathgyDO.NO_PATHGY;
	}

	@Override
	public String getTableName() {
		return "A";
	}
	
	@Override
	public void addWherePart(String wherePart) {

		getWherePart().add(wherePart);
	}
	
	@Override
	public String getRefSql() {
		
//		String sd_srvtp = (String) getExtendAttributeValue("SDSrvtp");
//		String str_id_srvs = (String) getExtendAttributeValue("IDSrvs");

		String refSql = "select A.no_pathgy, A.dt_rptpathgy, A.str_name_di from ci_ap_pathgy A"
				+ " left join ci_order B on A.id_or=B.id_or "
				+ String.format("where B.id_grp = '%s' and B.id_org = '%s' and A.ds = 0 ", 
						Context.get().getGroupId(), Context.get().getOrgId());
		
		StringBuilder sb = new StringBuilder(refSql);
		
		List<String> oldWherepartArr = this.getWherePart();
		for (String strWhere : oldWherepartArr) {
			sb.append(" and "+strWhere);
		}
		
		sb.append(" order by A.dt_rptpathgy");

		return sb.toString();
	}
	 
	@Override
	public String[] getBlurFields() {
		return new String[]{OrdApPathgyDO.NO_PATHGY};
	}
}
