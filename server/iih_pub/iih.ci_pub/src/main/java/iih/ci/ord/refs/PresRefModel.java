package iih.ci.ord.refs;

import iih.ci.ord.pres.d.CiPresDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PresRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[]{CiPresDO.NAME,CiPresDO.CODE};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{CiPresDO.ID_PRES};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"服务名称","编码","助记码"};
	}
	
	@Override
	public String getPkFieldCode() {
		return CiPresDO.ID_PRES;
	}
	@Override
	public String getRefCodeField() {
		return CiPresDO.CODE;
	}
	@Override
	public String getRefNameField() {
		return CiPresDO.NAME;
	}

	@Override
	public String getTableName() {
		return new CiPresDO().getTableName();
	}


}
