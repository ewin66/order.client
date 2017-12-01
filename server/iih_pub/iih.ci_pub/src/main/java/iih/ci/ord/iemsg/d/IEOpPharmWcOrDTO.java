package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊西成药医嘱信息DTO DTO数据 
 * 
 */
public class IEOpPharmWcOrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE西成药医嘱主键标识
	 * @return String
	 */
	public String getId_iepharmwcor() {
		return ((String) getAttrVal("Id_iepharmwcor"));
	}	
	/**
	 * IE西成药医嘱主键标识
	 * @param Id_iepharmwcor
	 */
	public void setId_iepharmwcor(String Id_iepharmwcor) {
		setAttrVal("Id_iepharmwcor", Id_iepharmwcor);
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
	public String getOrdertypecode() {
		return ((String) getAttrVal("Ordertypecode"));
	}	
	/**
	 * 处方类型编码
	 * @param Ordertypecode
	 */
	public void setOrdertypecode(String Ordertypecode) {
		setAttrVal("Ordertypecode", Ordertypecode);
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
	 * 医保类型编码
	 * @return String
	 */
	public String getYbtypecode() {
		return ((String) getAttrVal("Ybtypecode"));
	}	
	/**
	 * 医保类型编码
	 * @param Ybtypecode
	 */
	public void setYbtypecode(String Ybtypecode) {
		setAttrVal("Ybtypecode", Ybtypecode);
	}
	/**
	 * 医保类型名称
	 * @return String
	 */
	public String getYbtypename() {
		return ((String) getAttrVal("Ybtypename"));
	}	
	/**
	 * 医保类型名称
	 * @param Ybtypename
	 */
	public void setYbtypename(String Ybtypename) {
		setAttrVal("Ybtypename", Ybtypename);
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
	 * 天数
	 * @return String
	 */
	public String getPersdays() {
		return ((String) getAttrVal("Persdays"));
	}	
	/**
	 * 天数
	 * @param Persdays
	 */
	public void setPersdays(String Persdays) {
		setAttrVal("Persdays", Persdays);
	}
	/**
	 * 给药途径编码
	 * @return String
	 */
	public String getDrugscode() {
		return ((String) getAttrVal("Drugscode"));
	}	
	/**
	 * 给药途径编码
	 * @param Drugscode
	 */
	public void setDrugscode(String Drugscode) {
		setAttrVal("Drugscode", Drugscode);
	}
	/**
	 * 给药途径名称
	 * @return String
	 */
	public String getDrugsname() {
		return ((String) getAttrVal("Drugsname"));
	}	
	/**
	 * 给药途径名称
	 * @param Drugsname
	 */
	public void setDrugsname(String Drugsname) {
		setAttrVal("Drugsname", Drugsname);
	}
	/**
	 * 次剂量
	 * @return String
	 */
	public String getDosage() {
		return ((String) getAttrVal("Dosage"));
	}	
	/**
	 * 次剂量
	 * @param Dosage
	 */
	public void setDosage(String Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	/**
	 * 次剂量单位
	 * @return String
	 */
	public String getDosageunit() {
		return ((String) getAttrVal("Dosageunit"));
	}	
	/**
	 * 次剂量单位
	 * @param Dosageunit
	 */
	public void setDosageunit(String Dosageunit) {
		setAttrVal("Dosageunit", Dosageunit);
	}
	/**
	 * 总药量
	 * @return String
	 */
	public String getAmount() {
		return ((String) getAttrVal("Amount"));
	}	
	/**
	 * 总药量
	 * @param Amount
	 */
	public void setAmount(String Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 总药量单位
	 * @return String
	 */
	public String getAmountunit() {
		return ((String) getAttrVal("Amountunit"));
	}	
	/**
	 * 总药量单位
	 * @param Amountunit
	 */
	public void setAmountunit(String Amountunit) {
		setAttrVal("Amountunit", Amountunit);
	}
	/**
	 * 领药量
	 * @return String
	 */
	public String getGetamount() {
		return ((String) getAttrVal("Getamount"));
	}	
	/**
	 * 领药量
	 * @param Getamount
	 */
	public void setGetamount(String Getamount) {
		setAttrVal("Getamount", Getamount);
	}
	/**
	 * 领药量单位
	 * @return String
	 */
	public String getGetunit() {
		return ((String) getAttrVal("Getunit"));
	}	
	/**
	 * 领药量单位
	 * @param Getunit
	 */
	public void setGetunit(String Getunit) {
		setAttrVal("Getunit", Getunit);
	}
	/**
	 * 药品编码
	 * @return String
	 */
	public String getYpcode() {
		return ((String) getAttrVal("Ypcode"));
	}	
	/**
	 * 药品编码
	 * @param Ypcode
	 */
	public void setYpcode(String Ypcode) {
		setAttrVal("Ypcode", Ypcode);
	}
	/**
	 * 包装序号
	 * @return String
	 */
	public String getPackserial() {
		return ((String) getAttrVal("Packserial"));
	}	
	/**
	 * 包装序号
	 * @param Packserial
	 */
	public void setPackserial(String Packserial) {
		setAttrVal("Packserial", Packserial);
	}
	/**
	 * 父医嘱号
	 * @return String
	 */
	public String getParentno() {
		return ((String) getAttrVal("Parentno"));
	}	
	/**
	 * 父医嘱号
	 * @param Parentno
	 */
	public void setParentno(String Parentno) {
		setAttrVal("Parentno", Parentno);
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
	 * 执行科室编码
	 * @return String
	 */
	public String getExunitcode() {
		return ((String) getAttrVal("Exunitcode"));
	}	
	/**
	 * 执行科室编码
	 * @param Exunitcode
	 */
	public void setExunitcode(String Exunitcode) {
		setAttrVal("Exunitcode", Exunitcode);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getExunitname() {
		return ((String) getAttrVal("Exunitname"));
	}	
	/**
	 * 执行科室名称
	 * @param Exunitname
	 */
	public void setExunitname(String Exunitname) {
		setAttrVal("Exunitname", Exunitname);
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