package iih.ci.ord.tmpl.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 临床医嘱模板套内项目 DTO数据 
 * 
 */
public class CiOrTmplSetItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 临床医嘱模板套内项目主键标识
	 * @return String
	 */
	public String getId_ciortmplsetitm() {
		return ((String) getAttrVal("Id_ciortmplsetitm"));
	}	
	/**
	 * 临床医嘱模板套内项目主键标识
	 * @param Id_ciortmplsetitm
	 */
	public void setId_ciortmplsetitm(String Id_ciortmplsetitm) {
		setAttrVal("Id_ciortmplsetitm", Id_ciortmplsetitm);
	}
	/**
	 * 临床医嘱模板项目
	 * @return String
	 */
	public String getId_ciortmplsrv() {
		return ((String) getAttrVal("Id_ciortmplsrv"));
	}	
	/**
	 * 临床医嘱模板项目
	 * @param Id_ciortmplsrv
	 */
	public void setId_ciortmplsrv(String Id_ciortmplsrv) {
		setAttrVal("Id_ciortmplsrv", Id_ciortmplsrv);
	}
	/**
	 * 套内项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 套内项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
}