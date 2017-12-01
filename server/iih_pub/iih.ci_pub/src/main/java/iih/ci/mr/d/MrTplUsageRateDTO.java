package iih.ci.mr.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病历模板使用率 DTO数据 
 * 
 */
public class MrTplUsageRateDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 模板名称
	 * @return String
	 */
	public String getName_template() {
		return ((String) getAttrVal("Name_template"));
	}
	/**
	 * 模板名称
	 * @param Name_template
	 */
	public void setName_template(String Name_template) {
		setAttrVal("Name_template", Name_template);
	}
	/**
	 * 使用次数
	 * @return String
	 */
	public String getCount_usage() {
		return ((String) getAttrVal("Count_usage"));
	}
	/**
	 * 使用次数
	 * @param Count_usage
	 */
	public void setCount_usage(String Count_usage) {
		setAttrVal("Count_usage", Count_usage);
	}
	/**
	 * 门诊/住院记录总数
	 * @return String
	 */
	public String getCount_total() {
		return ((String) getAttrVal("Count_total"));
	}
	/**
	 * 门诊/住院记录总数
	 * @param Count_total
	 */
	public void setCount_total(String Count_total) {
		setAttrVal("Count_total", Count_total);
	}
	/**
	 * 使用率
	 * @return String
	 */
	public String getRate_usage() {
		return ((String) getAttrVal("Rate_usage"));
	}
	/**
	 * 使用率
	 * @param Rate_usage
	 */
	public void setRate_usage(String Rate_usage) {
		setAttrVal("Rate_usage", Rate_usage);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类型
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 模板分类
	 * @return String
	 */
	public String getName_doctype() {
		return ((String) getAttrVal("Name_doctype"));
	}
	/**
	 * 模板分类
	 * @param Name_doctype
	 */
	public void setName_doctype(String Name_doctype) {
		setAttrVal("Name_doctype", Name_doctype);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getName_mrtp_create() {
		return ((String) getAttrVal("Name_mrtp_create"));
	}
	/**
	 * 创建人
	 * @param Name_mrtp_create
	 */
	public void setName_mrtp_create(String Name_mrtp_create) {
		setAttrVal("Name_mrtp_create", Name_mrtp_create);
	}
	/**
	 * 主键
	 * @return String
	 */
	public String getId_mr_tpl_ur() {
		return ((String) getAttrVal("Id_mr_tpl_ur"));
	}
	/**
	 * 主键
	 * @param Id_mr_tpl_ur
	 */
	public void setId_mr_tpl_ur(String Id_mr_tpl_ur) {
		setAttrVal("Id_mr_tpl_ur", Id_mr_tpl_ur);
	}
}