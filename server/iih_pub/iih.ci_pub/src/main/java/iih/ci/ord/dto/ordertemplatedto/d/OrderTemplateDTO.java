package iih.ci.ord.dto.ordertemplatedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 助手医嘱模板DTO DTO数据 
 * 
 */
public class OrderTemplateDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_template() {
		return ((String) getAttrVal("Id_template"));
	}
	/**
	 * 主键
	 * @param Id_template
	 */
	public void setId_template(String Id_template) {
		setAttrVal("Id_template", Id_template);
	}
	/**
	 * 医嘱模板
	 * @return FMap
	 */
	public FMap getSrvortplitemaggdo() {
		return ((FMap) getAttrVal("Srvortplitemaggdo"));
	}
	/**
	 * 医嘱模板
	 * @param Srvortplitemaggdo
	 */
	public void setSrvortplitemaggdo(FMap Srvortplitemaggdo) {
		setAttrVal("Srvortplitemaggdo", Srvortplitemaggdo);
	}
	/**
	 * 频次
	 * @return FMap
	 */
	public FMap getFreqdefdo() {
		return ((FMap) getAttrVal("Freqdefdo"));
	}
	/**
	 * 频次
	 * @param Freqdefdo
	 */
	public void setFreqdefdo(FMap Freqdefdo) {
		setAttrVal("Freqdefdo", Freqdefdo);
	}
	/**
	 * 剂量单位
	 * @return FMap
	 */
	public FMap getMeasdocdo() {
		return ((FMap) getAttrVal("Measdocdo"));
	}
	/**
	 * 剂量单位
	 * @param Measdocdo
	 */
	public void setMeasdocdo(FMap Measdocdo) {
		setAttrVal("Measdocdo", Measdocdo);
	}
}