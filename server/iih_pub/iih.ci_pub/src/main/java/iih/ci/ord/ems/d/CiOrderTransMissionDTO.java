package iih.ci.ord.ems.d;

import iih.ci.ord.ciorder.d.CiorderAggDO;

import java.util.List;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
/**
 * 保存医嘱返回信息 DTO数据 
 * @author li_zheng
 *
 */
public class CiOrderTransMissionDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 提示信息
	 * @return FMap2
	 */
	public FMap2 getFmap2() {
		return ((FMap2) getAttrVal("Fmap2"));
	}
	/**
	 * 提示信息
	 * @param Fmap2
	 */
	public void setFmap2(FMap2 Fmap2) {
		setAttrVal("Fmap2", Fmap2);
	}
	/**
	 * 错误信息
	 * @return FArrayList2
	 */
	public FArrayList2 getErrlist() {
		return ((FArrayList2) getAttrVal("Errlist"));
	}
	/**
	 * 错误信息
	 * @param Errlist
	 */
	public void setErrlist(FArrayList Errlist) {
		setAttrVal("Errlist", Errlist);
	}
	/**
	 * 医嘱集合
	 * @return FArrayList2
	 */
	public FArrayList getCiorderaggdo() {
		return ((FArrayList) getAttrVal("Ciorderaggdo"));
	}
	
	/**
	 * 医嘱集合
	 * @param Ciorderaggdo
	 */
	public void setCiorderaggdo(FArrayList Ciorderaggdo) {
		setAttrVal("Ciorderaggdo", Ciorderaggdo);
	}
	/**
	 * 临床上下文信息
	 * @return String
	 */
	public CiEnContextDTO getCiencontextdto() {
		return ((CiEnContextDTO) getAttrVal("Ciencontextdto"));
	}
	/**
	 * 临床上下文信息
	 * @param Ciencontextdto
	 */
	public void setCiencontextdto(CiEnContextDTO Ciencontextdto) {
		setAttrVal("Ciencontextdto", Ciencontextdto);
	}
	
 
	/**
	 * 医疗单类型
	 * @return Integer
	 */
	public Integer getCiemstype() {
		return ((Integer) getAttrVal("Ciemstype"));
	}
	/**
	 * 医疗单类型
	 * @param Ciemstype
	 */
	public void setCiemstype(Integer Ciemstype) {
		setAttrVal("Ciemstype", Ciemstype);
	}
	/**
	 * displaynam7
	 * @return String
	 */
	public String getName7() {
		return ((String) getAttrVal("Name7"));
	}
	/**
	 * displaynam7
	 * @param Name7
	 */
	public void setName7(String Name7) {
		setAttrVal("Name7", Name7);
	}
	/**
	 * displaynam8
	 * @return String
	 */
	public String getName8() {
		return ((String) getAttrVal("Name8"));
	}
	/**
	 * displaynam8
	 * @param Name8
	 */
	public void setName8(String Name8) {
		setAttrVal("Name8", Name8);
	}
	/**
	 * displaynam9
	 * @return String
	 */
	public String getName9() {
		return ((String) getAttrVal("Name9"));
	}
	/**
	 * displaynam9
	 * @param Name9
	 */
	public void setName9(String Name9) {
		setAttrVal("Name9", Name9);
	}
	/**
	 * displaynam10
	 * @return String
	 */
	public String getName10() {
		return ((String) getAttrVal("Name10"));
	}
	/**
	 * displaynam10
	 * @param Name10
	 */
	public void setName10(String Name10) {
		setAttrVal("Name10", Name10);
	}
	/**
	 * displaynam11
	 * @return String
	 */
	public String getName11() {
		return ((String) getAttrVal("Name11"));
	}
	/**
	 * displaynam11
	 * @param Name11
	 */
	public void setName11(String Name11) {
		setAttrVal("Name11", Name11);
	}
 
	
}
