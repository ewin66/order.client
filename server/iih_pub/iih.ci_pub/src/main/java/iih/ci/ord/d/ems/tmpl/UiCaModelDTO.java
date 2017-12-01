package iih.ci.ord.d.ems.tmpl;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 分类节点模型对象
 * @author wangqingzhu
 *
 */
public class UiCaModelDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String getType(){
		return ((String) getAttrVal("Type"));
	}
	
	public void setType(String Type){
		setAttrVal("Type", Type);
	}

	public FBoolean getEnable(){
		return ((FBoolean) getAttrVal("Enable"));
	}
	
	public void setEnable(FBoolean Enable){
		setAttrVal("Enable", Enable);
	}

	public String getCacheKey(){
		return ((String) getAttrVal("CacheKey"));
	}
	
	public void setCacheKey(String CacheKey){
		setAttrVal("CacheKey", CacheKey);
	}
	
	public String getName(){
		return ((String) getAttrVal("Name"));
	}
	
	public void setName(String Name){
		setAttrVal("Name", Name);
	}
	
	public String getTip(){
		return ((String) getAttrVal("Tip"));
	}
	
	public void setTip(String Tip){
		setAttrVal("Tip", Tip);
	}
	
	public FArrayList getChildren(){
		return ((FArrayList) getAttrVal("Children"));
	}
	
	public void setChildren(FArrayList Children){
		setAttrVal("Children", Children);
	}
}
