package iih.ci.mr.auditdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 审核人信息DTO DTO数据 
 * 
 */
public class AuditDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 审核日期
	 * @return FDateTime
	 */
	public FDateTime getDt_audit() {
		return ((FDateTime) getAttrVal("Dt_audit"));
	}
	/**
	 * 审核日期
	 * @param Dt_audit
	 */
	public void setDt_audit(FDateTime Dt_audit) {
		setAttrVal("Dt_audit", Dt_audit);
	}
	/**
	 * 审核医生编码
	 * @return String
	 */
	public String getCode_audit_doc() {
		return ((String) getAttrVal("Code_audit_doc"));
	}
	/**
	 * 审核医生编码
	 * @param Code_audit_doc
	 */
	public void setCode_audit_doc(String Code_audit_doc) {
		setAttrVal("Code_audit_doc", Code_audit_doc);
	}
	/**
	 * 审核医生名称
	 * @return String
	 */
	public String getAudit_doc() {
		return ((String) getAttrVal("Audit_doc"));
	}
	/**
	 * 审核医生名称
	 * @param Audit_doc
	 */
	public void setAudit_doc(String Audit_doc) {
		setAttrVal("Audit_doc", Audit_doc);
	}
}