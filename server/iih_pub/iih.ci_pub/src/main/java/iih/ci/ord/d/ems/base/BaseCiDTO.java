package iih.ci.ord.d.ems.base;

import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.FArrayList;

public class BaseCiDTO extends BaseXapJsonSerialization {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CiEnContextDTO getEnContext(){
		return ((CiEnContextDTO) getAttrVal("EnContext"));
	}
	
	public void setEnContext(CiEnContextDTO ctx){
		setAttrVal("EnContext", ctx);
	}
	
	/**
	 * 数据档案
	 * @return String
	 */
	public FArrayList getDocument() {
		return ((FArrayList) getAttrVal("Document"));
	}
	/**
	 * 数据档案
	 * @param Document
	 */
	public void setDocument(FArrayList document) {
		setAttrVal("Document", document);
	}
	
	
	/**
	 * 数据操作来源
	 * @return String
	 */
	public String getOperateSourceFrom() {
		return ((String) getAttrVal("OperateSourceFrom"));
	}
	/**
	 * 数据操作来源
	 * @param OperateSourceFrom
	 */
	public void setOperateSourceFrom(String OperateSourceFrom) {
		setAttrVal("OperateSourceFrom", OperateSourceFrom);
	}

	
}
