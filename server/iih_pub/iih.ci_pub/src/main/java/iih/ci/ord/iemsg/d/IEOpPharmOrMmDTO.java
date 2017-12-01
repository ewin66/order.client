package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊草药医嘱成份信息DTO DTO数据 
 * 
 */
public class IEOpPharmOrMmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE药品医嘱药品主键标识
	 * @return String
	 */
	public String getId_iepharmormm() {
		return ((String) getAttrVal("Id_iepharmormm"));
	}	
	/**
	 * IE药品医嘱药品主键标识
	 * @param Id_iepharmormm
	 */
	public void setId_iepharmormm(String Id_iepharmormm) {
		setAttrVal("Id_iepharmormm", Id_iepharmormm);
	}
	/**
	 * IE药品医嘱
	 * @return String
	 */
	public String getId_iepharmor() {
		return ((String) getAttrVal("Id_iepharmor"));
	}	
	/**
	 * IE药品医嘱
	 * @param Id_iepharmor
	 */
	public void setId_iepharmor(String Id_iepharmor) {
		setAttrVal("Id_iepharmor", Id_iepharmor);
	}
	/**
	 * 重量
	 * @return String
	 */
	public String getWeight() {
		return ((String) getAttrVal("Weight"));
	}	
	/**
	 * 重量
	 * @param Weight
	 */
	public void setWeight(String Weight) {
		setAttrVal("Weight", Weight);
	}
	/**
	 * 重量单位
	 * @return String
	 */
	public String getWeightunit() {
		return ((String) getAttrVal("Weightunit"));
	}	
	/**
	 * 重量单位
	 * @param Weightunit
	 */
	public void setWeightunit(String Weightunit) {
		setAttrVal("Weightunit", Weightunit);
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
	 * 草药煎熬法编码
	 * @return String
	 */
	public String getMethocode() {
		return ((String) getAttrVal("Methocode"));
	}	
	/**
	 * 草药煎熬法编码
	 * @param Methocode
	 */
	public void setMethocode(String Methocode) {
		setAttrVal("Methocode", Methocode);
	}
	/**
	 * 草药煎熬法名称
	 * @return String
	 */
	public String getMethoname() {
		return ((String) getAttrVal("Methoname"));
	}	
	/**
	 * 草药煎熬法名称
	 * @param Methoname
	 */
	public void setMethoname(String Methoname) {
		setAttrVal("Methoname", Methoname);
	}
	/**
	 * 与付数无关标记
	 * @return String
	 */
	public String getNmwamount() {
		return ((String) getAttrVal("Nmwamount"));
	}	
	/**
	 * 与付数无关标记
	 * @param Nmwamount
	 */
	public void setNmwamount(String Nmwamount) {
		setAttrVal("Nmwamount", Nmwamount);
	}
	/**
	 * 是否与付数无关标记结果
	 * @return FBoolean
	 */
	public FBoolean getIsnmwamount() {
		return ((FBoolean) getAttrVal("Isnmwamount"));
	}	
	/**
	 * 是否与付数无关标记结果
	 * @param Isnmwamount
	 */
	public void setIsnmwamount(FBoolean Isnmwamount) {
		setAttrVal("Isnmwamount", Isnmwamount);
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
}