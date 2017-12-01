package iih.ci.mr.knowledgetype.refs;

import iih.ci.mr.knowledgetype.d.KnowledgeTypeDO;
import iih.ci.mr.knowledgetype.d.desc.KnowledgeTypeDODesc;
import xap.sys.appfw.refinfo.RefGridModel;

public class KnowledgeTypeDOModel extends RefGridModel{

	@Override
	public String[] getShowFieldName() {
		return  new String[]{"名称","类别"};
	}

	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{KnowledgeTypeDO.NAME,KnowledgeTypeDO.ATTRIBUTE};
	}

	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{KnowledgeTypeDO.ID_KNOWLEDGE_TYPE,KnowledgeTypeDO.ID_USER};
	}

	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return KnowledgeTypeDO.ID_KNOWLEDGE_TYPE;
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return KnowledgeTypeDO.NAME;
	}

//	@Override
//	public String getRefAttributeField() {
//		// TODO Auto-generated method stub
//		return KnowledgeTypeDO.ATTRIBUTE;
//	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return KnowledgeTypeDODesc.TABLE_NAME;
	}
}
