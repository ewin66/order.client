package iih.ci.ord.s.bp.iemsg.reissue.dto;

import xap.mw.core.data.BaseDTO;

/**
 * 返回补发数据对象
 * 
 * @author HUMS
 *
 */
public class ReissueMsgDTO {

	/**
	 * 服务id，指检查BS002，检验BS006
	 */
	private String serviceId;

	/**
	 * 域Id 对应门诊 01 ；住院 02
	 */
	private String domainId;

	/**
	 * 服务分类(与集成平台对应的分类)
	 */
	private String iemsgca_code;

	/**
	 * 服务分类(与集成平台对应的分类)
	 */
	//private String srvca_code;

	

	/**
	 * 科室：执行科室或就诊科室，看具体业务
	 */
	private String id_dep;

	/**
	 * 返回的补发数据
	 */
	private BaseDTO dataDTO;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	
	public String getIemsgca_code() {
		return iemsgca_code;
	}

	public void setIemsgca_code(String iemsgca_code) {
		this.iemsgca_code = iemsgca_code;
	}
	/*public String getSrvca_code() {
		return srvca_code;
	}
	
	public void setSrvca_code(String srvca_code) {
		this.srvca_code = srvca_code;
	}*/

	public String getId_dep() {
		return id_dep;
	}

	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}

	public BaseDTO getDataDTO() {
		return dataDTO;
	}

	public void setDataDTO(BaseDTO dataDTO) {
		this.dataDTO = dataDTO;
	}

}
