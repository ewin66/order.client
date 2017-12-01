package iih.ci.mr.mrfs.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医疗记录流DTO DTO数据 
 * 
 */
public class MrfsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗记录主键标识
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}
	/**
	 * 医疗记录主键标识
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 医疗记录名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 医疗记录名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 医疗记录编辑器
	 * @return String
	 */
	public String getId_mred() {
		return ((String) getAttrVal("Id_mred"));
	}
	/**
	 * 医疗记录编辑器
	 * @param Id_mred
	 */
	public void setId_mred(String Id_mred) {
		setAttrVal("Id_mred", Id_mred);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 前新起一页
	 * @return FBoolean
	 */
	public FBoolean getNewtop() {
		return ((FBoolean) getAttrVal("Newtop"));
	}
	/**
	 * 前新起一页
	 * @param Newtop
	 */
	public void setNewtop(FBoolean Newtop) {
		setAttrVal("Newtop", Newtop);
	}
	/**
	 * 后新起一页
	 * @return FBoolean
	 */
	public FBoolean getNewend() {
		return ((FBoolean) getAttrVal("Newend"));
	}
	/**
	 * 后新起一页
	 * @param Newend
	 */
	public void setNewend(FBoolean Newend) {
		setAttrVal("Newend", Newend);
	}
	/**
	 * 医疗记录显示数据流
	 * @return byte[]
	 */
	public byte[] getEmrfs() {
		return ((byte[]) getAttrVal("Emrfs"));
	}
	/**
	 * 医疗记录显示数据流
	 * @param Emrfs
	 */
	public void setEmrfs(byte[] Emrfs) {
		setAttrVal("Emrfs", Emrfs);
	}
	/**
	 * 编辑器编码
	 * @return String
	 */
	public String getMred_code() {
		return ((String) getAttrVal("Mred_code"));
	}
	/**
	 * 编辑器编码
	 * @param Mred_code
	 */
	public void setMred_code(String Mred_code) {
		setAttrVal("Mred_code", Mred_code);
	}
	/**
	 * 编辑器名称
	 * @return String
	 */
	public String getMred_name() {
		return ((String) getAttrVal("Mred_name"));
	}
	/**
	 * 编辑器名称
	 * @param Mred_name
	 */
	public void setMred_name(String Mred_name) {
		setAttrVal("Mred_name", Mred_name);
	}
}