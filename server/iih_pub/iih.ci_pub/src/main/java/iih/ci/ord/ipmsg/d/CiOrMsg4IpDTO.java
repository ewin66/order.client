package iih.ci.ord.ipmsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 临床医嘱集成平台消息DTO DTO数据 
 * 
 */
public class CiOrMsg4IpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 集成平台医嘱消息体主键标识
	 * @return String
	 */
	public String getId_ipormsg() {
		return ((String) getAttrVal("Id_ipormsg"));
	}	
	/**
	 * 集成平台医嘱消息体主键标识
	 * @param Id_ipormsg
	 */
	public void setId_ipormsg(String Id_ipormsg) {
		setAttrVal("Id_ipormsg", Id_ipormsg);
	}
	/**
	 * 消息体项目集合
	 * @return FArrayList
	 */
	public FArrayList getIpmsgitems() {
		return ((FArrayList) getAttrVal("Ipmsgitems"));
	}	
	/**
	 * 消息体项目集合
	 * @param Ipmsgitems
	 */
	public void setIpmsgitems(FArrayList Ipmsgitems) {
		setAttrVal("Ipmsgitems", Ipmsgitems);
	}
}