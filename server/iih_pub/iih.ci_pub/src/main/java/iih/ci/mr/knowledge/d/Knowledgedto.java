package iih.ci.mr.knowledge.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class Knowledgedto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 类别
	 * @return String
	 */
	public String getCategory() {
		return ((String) getAttrVal("Category"));
	}
	/**
	 * 类别
	 * @param Category
	 */
	public void setCategory(String Category) {
		setAttrVal("Category", Category);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 所属
	 * @return String
	 */
	public String getAttribute() {
		return ((String) getAttrVal("Attribute"));
	}
	/**
	 * 所属
	 * @param Attribute
	 */
	public void setAttribute(String Attribute) {
		setAttrVal("Attribute", Attribute);
	}
	/**
	 * 个人
	 * @return FBoolean
	 */
	public FBoolean getPersonal() {
		return ((FBoolean) getAttrVal("Personal"));
	}
	/**
	 * 个人
	 * @param Personal
	 */
	public void setPersonal(FBoolean Personal) {
		setAttrVal("Personal", Personal);
	}
	/**
	 * 科室
	 * @return FBoolean
	 */
	public FBoolean getAdministrative() {
		return ((FBoolean) getAttrVal("Administrative"));
	}
	/**
	 * 科室
	 * @param Administrative
	 */
	public void setAdministrative(FBoolean Administrative) {
		setAttrVal("Administrative", Administrative);
	}
	/**
	 * 所属用户
	 * @return String
	 */
	public String getId_user() {
		return ((String) getAttrVal("Id_user"));
	}
	/**
	 * 所属用户
	 * @param Id_user
	 */
	public void setId_user(String Id_user) {
		setAttrVal("Id_user", Id_user);
	}
	/**
	 * 知识内容
	 * @return String
	 */
	public String getKnowledge_content() {
		return ((String) getAttrVal("Knowledge_content"));
	}
	/**
	 * 知识内容
	 * @param Knowledge_content
	 */
	public void setKnowledge_content(String Knowledge_content) {
		setAttrVal("Knowledge_content", Knowledge_content);
	}
	/**
	 * 知识库编码
	 * @return String
	 */
	public String getId_knowledge() {
		return ((String) getAttrVal("Id_knowledge"));
	}
	/**
	 * 知识库编码
	 * @param Id_knowledge
	 */
	public void setId_knowledge(String Id_knowledge) {
		setAttrVal("Id_knowledge", Id_knowledge);
	}
	/**
	 * ds
	 * @return String
	 */
	public String getDs() {
		return ((String) getAttrVal("Ds"));
	}
	/**
	 * ds
	 * @param Ds
	 */
	public void setDs(String Ds) {
		setAttrVal("Ds", Ds);
	}
}