package iih.ci.ord.d.ems.tmpl;

import xap.mw.core.data.FArrayList;

/**
 * 模板UI模型对象
 * @author wangqingzhu
 *
 */
public class UiTmplModelDTO extends UiCaModelDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public String getId_srv(){
		return ((String) getAttrVal("Id_srv"));
	}
	
	public void setId_srv(String Id_srv){
		setAttrVal("Id_srv", Id_srv);
	}
	
	public String getSd_srvtp(){
		return ((String) getAttrVal("Sd_srvtp"));
	}
	
	public void setSd_srvtp(String Sd_srvtp){
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	
	public FArrayList getErrors(){
		return ((FArrayList) getAttrVal("Errors"));
	}
	
	public void setErrors(FArrayList Errors){
		setAttrVal("Errors", Errors);
	}
	
	
	
}
