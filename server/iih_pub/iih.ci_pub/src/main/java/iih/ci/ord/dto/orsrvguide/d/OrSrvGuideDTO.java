package iih.ci.ord.dto.orsrvguide.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱服务内容 DTO数据 
 * 
 */
public class OrSrvGuideDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱主键
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱主键
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱服务主键
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务主键
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 剂型编码
	 * @return String
	 */
	public String getDosecode() {
		return ((String) getAttrVal("Dosecode"));
	}
	/**
	 * 剂型编码
	 * @param Dosecode
	 */
	public void setDosecode(String Dosecode) {
		setAttrVal("Dosecode", Dosecode);
	}
	/**
	 * 医保计划下剂型编码
	 * @return String
	 */
	public String getDosecode_hp() {
		return ((String) getAttrVal("Dosecode_hp"));
	}
	/**
	 * 医保计划下剂型编码
	 * @param Dosecode_hp
	 */
	public void setDosecode_hp(String Dosecode_hp) {
		setAttrVal("Dosecode_hp", Dosecode_hp);
	}
	/**
	 * 医保计划下剂型名称
	 * @return String
	 */
	public String getDosename_hp() {
		return ((String) getAttrVal("Dosename_hp"));
	}
	/**
	 * 医保计划下剂型名称
	 * @param Dosename_hp
	 */
	public void setDosename_hp(String Dosename_hp) {
		setAttrVal("Dosename_hp", Dosename_hp);
	}
	/**
	 * 用药频次编码
	 * @return String
	 */
	public String getFreqcode() {
		return ((String) getAttrVal("Freqcode"));
	}
	/**
	 * 用药频次编码
	 * @param Freqcode
	 */
	public void setFreqcode(String Freqcode) {
		setAttrVal("Freqcode", Freqcode);
	}
	/**
	 * 医保计划下用药频次编码
	 * @return String
	 */
	public String getFreqcode_hp() {
		return ((String) getAttrVal("Freqcode_hp"));
	}
	/**
	 * 医保计划下用药频次编码
	 * @param Freqcode_hp
	 */
	public void setFreqcode_hp(String Freqcode_hp) {
		setAttrVal("Freqcode_hp", Freqcode_hp);
	}
	/**
	 * 单次用量
	 * @return String
	 */
	public String getDosage() {
		return ((String) getAttrVal("Dosage"));
	}
	/**
	 * 单次用量
	 * @param Dosage
	 */
	public void setDosage(String Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	/**
	 * 用药天数
	 * @return String
	 */
	public String getDays() {
		return ((String) getAttrVal("Days"));
	}
	/**
	 * 用药天数
	 * @param Days
	 */
	public void setDays(String Days) {
		setAttrVal("Days", Days);
	}
	/**
	 * 医保计划下频次名称
	 * @return String
	 */
	public String getFreqname_hp() {
		return ((String) getAttrVal("Freqname_hp"));
	}
	/**
	 * 医保计划下频次名称
	 * @param Freqname_hp
	 */
	public void setFreqname_hp(String Freqname_hp) {
		setAttrVal("Freqname_hp", Freqname_hp);
	}
	/**
	 * 药品批准文号
	 * @return String
	 */
	public String getDrugapprovalnumber() {
		return ((String) getAttrVal("Drugapprovalnumber"));
	}
	/**
	 * 药品批准文号
	 * @param Drugapprovalnumber
	 */
	public void setDrugapprovalnumber(String Drugapprovalnumber) {
		setAttrVal("Drugapprovalnumber", Drugapprovalnumber);
	}
	/**
	 * 医疗单位主键
	 * @return String
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}
	/**
	 * 医疗单位主键
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	/**
	 * 医疗单位名称
	 * @return String
	 */
	public String getName_medu() {
		return ((String) getAttrVal("Name_medu"));
	}
	/**
	 * 医疗单位名称
	 * @param Name_medu
	 */
	public void setName_medu(String Name_medu) {
		setAttrVal("Name_medu", Name_medu);
	}
	/**
	 * 持有量天数
	 * @return String
	 */
	public String getDays_available() {
		return ((String) getAttrVal("Days_available"));
	}
	/**
	 * 持有量天数
	 * @param Days_available
	 */
	public void setDays_available(String Days_available) {
		setAttrVal("Days_available", Days_available);
	}
	/**
	 * 药品类型
	 * @return String
	 */
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}
	/**
	 * 药品类型
	 * @param Sd_mmtp
	 */
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}
	/**
	 * 医基换算系数
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}
	/**
	 * 医基换算系数
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 零基换算系数
	 * @return FDouble
	 */
	public FDouble getFactor_sb() {
		return ((FDouble) getAttrVal("Factor_sb"));
	}
	/**
	 * 零基换算系数
	 * @param Factor_sb
	 */
	public void setFactor_sb(FDouble Factor_sb) {
		setAttrVal("Factor_sb", Factor_sb);
	}
	/**
	 * 门诊取整模式
	 * @return String
	 */
	public String getSd_opmutp() {
		return ((String) getAttrVal("Sd_opmutp"));
	}
	/**
	 * 门诊取整模式
	 * @param Sd_opmutp
	 */
	public void setSd_opmutp(String Sd_opmutp) {
		setAttrVal("Sd_opmutp", Sd_opmutp);
	}
	/**
	 * 换算率
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}
	/**
	 * 换算率
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	/**
	 * 频次周期下次数
	 * @return Integer
	 */
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}
	/**
	 * 频次周期下次数
	 * @param Freqct
	 */
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	/**
	 * 服务总量
	 * @return FDouble
	 */
	public FDouble getQuan_total_medu() {
		return ((FDouble) getAttrVal("Quan_total_medu"));
	}
	/**
	 * 服务总量
	 * @param Quan_total_medu
	 */
	public void setQuan_total_medu(FDouble Quan_total_medu) {
		setAttrVal("Quan_total_medu", Quan_total_medu);
	}
}