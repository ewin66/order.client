package iih.ci.ord.ordprn.refs;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.ordprn.d.OrdPrintDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class CiorderPrintPageRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{OrdPrintDO.PAGE_NUM};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{OrdPrintDO.ID_ORPRN};
	}

	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[]{"页号"};
	}

	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return OrdPrintDO.ID_ORPRN;
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return OrdPrintDO.ID_ORPRN;
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return OrdPrintDO.PAGE_NUM;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return new OrdPrintDO().getTableName();
	}
	
	@Override
	public String getRefSql() {
		// TODO Auto-generated method stub
		String refSql = "SELECT DISTINCT page_num+1,id_en||'_'||cast(page_num as VARCHAR2(20)) FROM ci_or_prn ";
		
        StringBuilder sb = new StringBuilder(refSql);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" WHERE ").append(where);
			}
		}
		
		sb.append(" order by page_num+1");
		return sb.toString();
	}
	
}
