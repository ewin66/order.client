package iih.ci.ord.refs;

import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class CiorderRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[]{CiOrderDO.CONTENT_OR,CiOrderDO.CODE_OR};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{CiOrderDO.ID_OR};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"服务名称","编码","助记码"};
	}
	
	@Override
	public String getPkFieldCode() {
		return CiOrderDO.ID_OR;
	}
	@Override
	public String getRefCodeField() {
		return CiOrderDO.CONTENT_OR;
	}
	@Override
	public String getRefNameField() {
		return CiOrderDO.CONTENT_OR;
	}

	@Override
	public String getTableName() {
		return new CiOrderDO().getTableName();
	}

//	@Override
//	public void addWherePart(String wherePart) {
//		
//		getWherePart().add(wherePart);
//	}

}
