package iih.ci.ord.dto.blexorder.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 诊疗视图数据DTO DTO数据 
 * 
 */
public class DiagTreatViewRntDataDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊疗视图数据主键
	 * @return String
	 */
	public String getId_diagtreat() {
		return ((String) getAttrVal("Id_diagtreat"));
	}
	/**
	 * 诊疗视图数据主键
	 * @param Id_diagtreat
	 */
	public void setId_diagtreat(String Id_diagtreat) {
		setAttrVal("Id_diagtreat", Id_diagtreat);
	}
	/**
	 * 用药数据
	 * @return FArrayList2
	 */
	public FArrayList2 getDrugdata() {
		return ((FArrayList2) getAttrVal("Drugdata"));
	}
	/**
	 * 用药数据
	 * @param Drugdata
	 */
	public void setDrugdata(FArrayList2 Drugdata) {
		setAttrVal("Drugdata", Drugdata);
	}
	/**
	 * 检验数据
	 * @return FArrayList2
	 */
	public FArrayList2 getLabdata() {
		return ((FArrayList2) getAttrVal("Labdata"));
	}
	/**
	 * 检验数据
	 * @param Labdata
	 */
	public void setLabdata(FArrayList2 Labdata) {
		setAttrVal("Labdata", Labdata);
	}
	/**
	 * 检查数据
	 * @return FArrayList2
	 */
	public FArrayList2 getObsdata() {
		return ((FArrayList2) getAttrVal("Obsdata"));
	}
	/**
	 * 检查数据
	 * @param Obsdata
	 */
	public void setObsdata(FArrayList2 Obsdata) {
		setAttrVal("Obsdata", Obsdata);
	}
	/**
	 * 生命体征数据
	 * @return FArrayList2
	 */
	public FArrayList2 getBodysignsdata() {
		return ((FArrayList2) getAttrVal("Bodysignsdata"));
	}
	/**
	 * 生命体征数据
	 * @param Bodysignsdata
	 */
	public void setBodysignsdata(FArrayList2 Bodysignsdata) {
		setAttrVal("Bodysignsdata", Bodysignsdata);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊号
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_start() {
		return ((FDateTime) getAttrVal("Dt_start"));
	}
	/**
	 * 开始时间
	 * @param Dt_start
	 */
	public void setDt_start(FDateTime Dt_start) {
		setAttrVal("Dt_start", Dt_start);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 医疗记录类型自定义分类
	 * @return FArrayList2
	 */
	public FArrayList2 getMrctmcas() {
		return ((FArrayList2) getAttrVal("Mrctmcas"));
	}
	/**
	 * 医疗记录类型自定义分类
	 * @param Mrctmcas
	 */
	public void setMrctmcas(FArrayList2 Mrctmcas) {
		setAttrVal("Mrctmcas", Mrctmcas);
	}
	/**
	 * 临床医疗记录
	 * @return FArrayList2
	 */
	public FArrayList2 getCimrs() {
		return ((FArrayList2) getAttrVal("Cimrs"));
	}
	/**
	 * 临床医疗记录
	 * @param Cimrs
	 */
	public void setCimrs(FArrayList2 Cimrs) {
		setAttrVal("Cimrs", Cimrs);
	}
}