package iih.ci.ord.dto.blexorder.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱服务分解医嘱回写参数数据 DTO数据 
 * 
 */
public class OrSrvSplitOrModParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱服务项目
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务项目
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 拆分结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_split_end() {
		return ((FDateTime) getAttrVal("Dt_split_end"));
	}
	/**
	 * 拆分结束时间
	 * @param Dt_split_end
	 */
	public void setDt_split_end(FDateTime Dt_split_end) {
		setAttrVal("Dt_split_end", Dt_split_end);
	}
	/**
	 * 床边数量
	 * @return FDouble
	 */
	public FDouble getQuan_bed_ap_medu() {
		return ((FDouble) getAttrVal("Quan_bed_ap_medu"));
	}
	/**
	 * 床边数量
	 * @param Quan_bed_ap_medu
	 */
	public void setQuan_bed_ap_medu(FDouble Quan_bed_ap_medu) {
		setAttrVal("Quan_bed_ap_medu", Quan_bed_ap_medu);
	}
	/**
	 * 医嘱生成拆分类型
	 * @return Integer
	 */
	public Integer getEu_orgensplittp() {
		return ((Integer) getAttrVal("Eu_orgensplittp"));
	}
	/**
	 * 医嘱生成拆分类型
	 * @param Eu_orgensplittp
	 */
	public void setEu_orgensplittp(Integer Eu_orgensplittp) {
		setAttrVal("Eu_orgensplittp", Eu_orgensplittp);
	}
	/**
	 * 是否已记费
	 * @return FBoolean
	 */
	public FBoolean getFg_charged() {
		return ((FBoolean) getAttrVal("Fg_charged"));
	}
	/**
	 * 是否已记费
	 * @param Fg_charged
	 */
	public void setFg_charged(FBoolean Fg_charged) {
		setAttrVal("Fg_charged", Fg_charged);
	}
}