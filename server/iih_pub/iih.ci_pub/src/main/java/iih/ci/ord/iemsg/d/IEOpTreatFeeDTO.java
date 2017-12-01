package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊治疗已收费信息DTO DTO数据 
 * 
 */
public class IEOpTreatFeeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE治疗已收费主键标识
	 * @return String
	 */
	public String getId_ietreatfee() {
		return ((String) getAttrVal("Id_ietreatfee"));
	}	
	/**
	 * IE治疗已收费主键标识
	 * @param Id_ietreatfee
	 */
	public void setId_ietreatfee(String Id_ietreatfee) {
		setAttrVal("Id_ietreatfee", Id_ietreatfee);
	}
	/**
	 * IE治疗医嘱就诊主键标识
	 * @return String
	 */
	public String getId_ietreatoren() {
		return ((String) getAttrVal("Id_ietreatoren"));
	}	
	/**
	 * IE治疗医嘱就诊主键标识
	 * @param Id_ietreatoren
	 */
	public void setId_ietreatoren(String Id_ietreatoren) {
		setAttrVal("Id_ietreatoren", Id_ietreatoren);
	}
	/**
	 * 诊疗处方号
	 * @return String
	 */
	public String getPres_no() {
		return ((String) getAttrVal("Pres_no"));
	}	
	/**
	 * 诊疗处方号
	 * @param Pres_no
	 */
	public void setPres_no(String Pres_no) {
		setAttrVal("Pres_no", Pres_no);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getPres_item_no() {
		return ((String) getAttrVal("Pres_item_no"));
	}	
	/**
	 * 医嘱号
	 * @param Pres_item_no
	 */
	public void setPres_item_no(String Pres_item_no) {
		setAttrVal("Pres_item_no", Pres_item_no);
	}
}