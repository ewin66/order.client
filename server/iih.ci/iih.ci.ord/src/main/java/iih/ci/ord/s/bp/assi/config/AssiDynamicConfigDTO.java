package iih.ci.ord.s.bp.assi.config;

/**
 * 助手拷贝配置类
 * 
 * @author HUMS
 *
 */
public class AssiDynamicConfigDTO {

	/**
	 * 加入扩展功能点
	 */
	private ExtensionPointEu extensionPoint;

	/**
	 * 就诊类型
	 */
	private String code_entp;

	/**
	 * 服务类型（两位）
	 */
	private String sd_srvtp;

	/**
	 * 允许的服务类型（仅允许配置结果服务类型使用该配置结果,如果该值为空，则不限制）
	 */
	private String allowed_sd_srvtp;

	/**
	 * 拒绝的服务类型（排除配置结果的服务类型都允许使用该配置,如果该值为空，则不限制）
	 */
	private String exclude_sd_srvtp;

	/**
	 * 数据来源，取值范围是OrSourceFromEnum（允许的数据来源类型）
	 */
	private String allowed_orSourceFrom;

	/**
	 * 数据来源，取值范围是OrSourceFromEnum（排除的数据来源类型）
	 */
	private String refused_orSourceFrom;

	/**
	 * 执行拷贝的类路径
	 */
	private String fullClassPath;

	public ExtensionPointEu getExtensionPoint() {
		return extensionPoint;
	}

	public void setExtensionPoint(ExtensionPointEu extensionPoint) {
		this.extensionPoint = extensionPoint;
	}

	public String getCode_entp() {
		return code_entp;
	}

	public void setCode_entp(String code_entp) {
		this.code_entp = code_entp;
	}

	public String getSd_srvtp() {
		return sd_srvtp;
	}

	public void setSd_srvtp(String sd_srvtp) {
		this.sd_srvtp = sd_srvtp;
	}

	public String getAllowed_sd_srvtp() {
		return allowed_sd_srvtp;
	}

	public void setAllowed_sd_srvtp(String allowed_sd_srvtp) {
		this.allowed_sd_srvtp = allowed_sd_srvtp;
	}

	
	public String getExclude_sd_srvtp() {
		return exclude_sd_srvtp;
	}

	public void setExclude_sd_srvtp(String exclude_sd_srvtp) {
		this.exclude_sd_srvtp = exclude_sd_srvtp;
	}

	public String getAllowed_orSourceFrom() {
		return allowed_orSourceFrom;
	}

	public void setAllowed_orSourceFrom(String allowed_orSourceFrom) {
		this.allowed_orSourceFrom = allowed_orSourceFrom;
	}

	public String getRefused_orSourceFrom() {
		return refused_orSourceFrom;
	}

	public void setRefused_orSourceFrom(String refused_orSourceFrom) {
		this.refused_orSourceFrom = refused_orSourceFrom;
	}

	public String getFullClassPath() {
		return fullClassPath;
	}

	public void setFullClassPath(String fullClassPath) {
		this.fullClassPath = fullClassPath;
	}

}
