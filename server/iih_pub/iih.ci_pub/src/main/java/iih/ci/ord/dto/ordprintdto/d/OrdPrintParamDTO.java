package iih.ci.ord.dto.ordprintdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 临床医嘱打印参数 DTO数据 
 * 
 */
public class OrdPrintParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 患者Id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者Id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊Id
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊Id
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 打印模式
	 * @return String
	 */
	public String getPrint_mode() {
		return ((String) getAttrVal("Print_mode"));
	}
	/**
	 * 打印模式
	 * @param Print_mode
	 */
	public void setPrint_mode(String Print_mode) {
		setAttrVal("Print_mode", Print_mode);
	}
	/**
	 * 页号
	 * @return Integer
	 */
	public Integer getPage_num() {
		return ((Integer) getAttrVal("Page_num"));
	}
	/**
	 * 页号
	 * @param Page_num
	 */
	public void setPage_num(Integer Page_num) {
		setAttrVal("Page_num", Page_num);
	}
}