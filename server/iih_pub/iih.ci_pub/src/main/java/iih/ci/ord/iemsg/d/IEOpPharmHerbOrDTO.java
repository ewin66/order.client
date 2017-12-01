package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊草药医嘱信息DTO DTO数据 
 * 
 */
public class IEOpPharmHerbOrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE草药医嘱主键标识
	 * @return String
	 */
	public String getId_iepharmor() {
		return ((String) getAttrVal("Id_iepharmor"));
	}	
	/**
	 * IE草药医嘱主键标识
	 * @param Id_iepharmor
	 */
	public void setId_iepharmor(String Id_iepharmor) {
		setAttrVal("Id_iepharmor", Id_iepharmor);
	}
	/**
	 * IE药品处方
	 * @return String
	 */
	public String getId_iepharmpres() {
		return ((String) getAttrVal("Id_iepharmpres"));
	}	
	/**
	 * IE药品处方
	 * @param Id_iepharmpres
	 */
	public void setId_iepharmpres(String Id_iepharmpres) {
		setAttrVal("Id_iepharmpres", Id_iepharmpres);
	}
	/**
	 * IE药品医嘱药品集合
	 * @return FArrayList2
	 */
	public FArrayList2 getId_iepharmormms() {
		return ((FArrayList2) getAttrVal("Id_iepharmormms"));
	}	
	/**
	 * IE药品医嘱药品集合
	 * @param Id_iepharmormms
	 */
	public void setId_iepharmormms(FArrayList2 Id_iepharmormms) {
		setAttrVal("Id_iepharmormms", Id_iepharmormms);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getYzno() {
		return ((String) getAttrVal("Yzno"));
	}	
	/**
	 * 医嘱号
	 * @param Yzno
	 */
	public void setYzno(String Yzno) {
		setAttrVal("Yzno", Yzno);
	}
	/**
	 * 药物标识编码
	 * @return String
	 */
	public String getMedicine_type() {
		return ((String) getAttrVal("Medicine_type"));
	}	
	/**
	 * 药物标识编码
	 * @param Medicine_type
	 */
	public void setMedicine_type(String Medicine_type) {
		setAttrVal("Medicine_type", Medicine_type);
	}
	/**
	 * 处方类型编码
	 * @return String
	 */
	public String getOrdertypeno() {
		return ((String) getAttrVal("Ordertypeno"));
	}	
	/**
	 * 处方类型编码
	 * @param Ordertypeno
	 */
	public void setOrdertypeno(String Ordertypeno) {
		setAttrVal("Ordertypeno", Ordertypeno);
	}
	/**
	 * 处方类型名称
	 * @return String
	 */
	public String getOrdertypename() {
		return ((String) getAttrVal("Ordertypename"));
	}	
	/**
	 * 处方类型名称
	 * @param Ordertypename
	 */
	public void setOrdertypename(String Ordertypename) {
		setAttrVal("Ordertypename", Ordertypename);
	}
	/**
	 * 频次编码
	 * @return String
	 */
	public String getFrqcode() {
		return ((String) getAttrVal("Frqcode"));
	}	
	/**
	 * 频次编码
	 * @param Frqcode
	 */
	public void setFrqcode(String Frqcode) {
		setAttrVal("Frqcode", Frqcode);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getFrqname() {
		return ((String) getAttrVal("Frqname"));
	}	
	/**
	 * 频次名称
	 * @param Frqname
	 */
	public void setFrqname(String Frqname) {
		setAttrVal("Frqname", Frqname);
	}
	/**
	 * 总用量(付数)
	 * @return String
	 */
	public String getAmount() {
		return ((String) getAttrVal("Amount"));
	}	
	/**
	 * 总用量(付数)
	 * @param Amount
	 */
	public void setAmount(String Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 总用量单位(付)
	 * @return String
	 */
	public String getAmountunit() {
		return ((String) getAttrVal("Amountunit"));
	}	
	/**
	 * 总用量单位(付)
	 * @param Amountunit
	 */
	public void setAmountunit(String Amountunit) {
		setAttrVal("Amountunit", Amountunit);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getExecunitcode() {
		return ((String) getAttrVal("Execunitcode"));
	}	
	/**
	 * 执行科室编码
	 * @param Execunitcode
	 */
	public void setExecunitcode(String Execunitcode) {
		setAttrVal("Execunitcode", Execunitcode);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getExeunitname() {
		return ((String) getAttrVal("Exeunitname"));
	}	
	/**
	 * 执行科室名称
	 * @param Exeunitname
	 */
	public void setExeunitname(String Exeunitname) {
		setAttrVal("Exeunitname", Exeunitname);
	}
	/**
	 * 嘱托
	 * @return String
	 */
	public String getAdvice() {
		return ((String) getAttrVal("Advice"));
	}	
	/**
	 * 嘱托
	 * @param Advice
	 */
	public void setAdvice(String Advice) {
		setAttrVal("Advice", Advice);
	}
	/**
	 * 是否皮试
	 * @return String
	 */
	public String getIs_ps() {
		return ((String) getAttrVal("Is_ps"));
	}	
	/**
	 * 是否皮试
	 * @param Is_ps
	 */
	public void setIs_ps(String Is_ps) {
		setAttrVal("Is_ps", Is_ps);
	}
	/**
	 * 是否皮试结果
	 * @return String
	 */
	public String getIs_psresult() {
		return ((String) getAttrVal("Is_psresult"));
	}	
	/**
	 * 是否皮试结果
	 * @param Is_psresult
	 */
	public void setIs_psresult(String Is_psresult) {
		setAttrVal("Is_psresult", Is_psresult);
	}
	/**
	 * 是否适应
	 * @return String
	 */
	public String getIs_syz() {
		return ((String) getAttrVal("Is_syz"));
	}	
	/**
	 * 是否适应
	 * @param Is_syz
	 */
	public void setIs_syz(String Is_syz) {
		setAttrVal("Is_syz", Is_syz);
	}
	/**
	 * 是否适应结果
	 * @return String
	 */
	public String getIs_syzresult() {
		return ((String) getAttrVal("Is_syzresult"));
	}	
	/**
	 * 是否适应结果
	 * @param Is_syzresult
	 */
	public void setIs_syzresult(String Is_syzresult) {
		setAttrVal("Is_syzresult", Is_syzresult);
	}
	/**
	 * 是否加急
	 * @return String
	 */
	public String getIs_jj() {
		return ((String) getAttrVal("Is_jj"));
	}	
	/**
	 * 是否加急
	 * @param Is_jj
	 */
	public void setIs_jj(String Is_jj) {
		setAttrVal("Is_jj", Is_jj);
	}
	/**
	 * 是否加急结果
	 * @return String
	 */
	public String getIs_jjresult() {
		return ((String) getAttrVal("Is_jjresult"));
	}	
	/**
	 * 是否加急结果
	 * @param Is_jjresult
	 */
	public void setIs_jjresult(String Is_jjresult) {
		setAttrVal("Is_jjresult", Is_jjresult);
	}
	/**
	 * 是否药观
	 * @return String
	 */
	public String getIs_yg() {
		return ((String) getAttrVal("Is_yg"));
	}	
	/**
	 * 是否药观
	 * @param Is_yg
	 */
	public void setIs_yg(String Is_yg) {
		setAttrVal("Is_yg", Is_yg);
	}
	/**
	 * 是否药观结果
	 * @return String
	 */
	public String getIs_ygresult() {
		return ((String) getAttrVal("Is_ygresult"));
	}	
	/**
	 * 是否药观结果
	 * @param Is_ygresult
	 */
	public void setIs_ygresult(String Is_ygresult) {
		setAttrVal("Is_ygresult", Is_ygresult);
	}
}