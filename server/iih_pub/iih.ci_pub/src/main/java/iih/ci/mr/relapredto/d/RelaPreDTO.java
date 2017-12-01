package iih.ci.mr.relapredto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 关联医嘱信息DTO DTO数据 
 * 
 */
public class RelaPreDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getId_pre() {
		return ((String) getAttrVal("Id_pre"));
	}
	/**
	 * 医嘱号
	 * @param Id_pre
	 */
	public void setId_pre(String Id_pre) {
		setAttrVal("Id_pre", Id_pre);
	}
}