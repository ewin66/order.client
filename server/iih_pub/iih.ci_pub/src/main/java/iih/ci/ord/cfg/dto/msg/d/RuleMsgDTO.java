package iih.ci.ord.cfg.dto.msg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行规则消息 DTO数据 
 * 
 */
public class RuleMsgDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 消息编码
	 * @return String
	 */
	public String getMsg_code() {
		return ((String) getAttrVal("Msg_code"));
	}
	/**
	 * 消息编码
	 * @param Msg_code
	 */
	public void setMsg_code(String Msg_code) {
		setAttrVal("Msg_code", Msg_code);
	}
	/**
	 * 消息类型
	 * @return String
	 */
	public String getMsg_type() {
		return ((String) getAttrVal("Msg_type"));
	}
	/**
	 * 消息类型
	 * @param Msg_type
	 */
	public void setMsg_type(String Msg_type) {
		setAttrVal("Msg_type", Msg_type);
	}
	/**
	 * 功能编码
	 * @return String
	 */
	public String getModule_code() {
		return ((String) getAttrVal("Module_code"));
	}
	/**
	 * 功能编码
	 * @param Module_code
	 */
	public void setModule_code(String Module_code) {
		setAttrVal("Module_code", Module_code);
	}
	/**
	 * 功能模块名称
	 * @return String
	 */
	public String getModule_name() {
		return ((String) getAttrVal("Module_name"));
	}
	/**
	 * 功能模块名称
	 * @param Module_name
	 */
	public void setModule_name(String Module_name) {
		setAttrVal("Module_name", Module_name);
	}
	/**
	 * 消息内容
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}
	/**
	 * 消息内容
	 * @param Content
	 */
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 扩展信息
	 * @return FMap
	 */
	public FMap getExt_content() {
		return ((FMap) getAttrVal("Ext_content"));
	}
	/**
	 * 扩展信息
	 * @param Ext_content
	 */
	public void setExt_content(FMap Ext_content) {
		setAttrVal("Ext_content", Ext_content);
	}
}