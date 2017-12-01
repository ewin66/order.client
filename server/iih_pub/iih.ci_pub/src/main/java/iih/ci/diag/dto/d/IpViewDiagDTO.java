package iih.ci.diag.dto.d;

import xap.mw.core.data.BaseDTO;

public class IpViewDiagDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;


	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	
	public String getName() {
		return ((String) getAttrVal("name"));
	}
	public void setName(String name) {
		setAttrVal("name", name);
	}
}
