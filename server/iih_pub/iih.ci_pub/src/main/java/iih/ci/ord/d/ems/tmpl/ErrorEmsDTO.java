package iih.ci.ord.d.ems.tmpl;

import java.util.List;

import iih.ci.ord.d.ems.base.BaseCiDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.FArrayList;

/**
 * 错误医疗单对象
 * @author wangqingzhu
 *
 */
public class ErrorEmsDTO extends BaseCiDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ErrorEmsDTO(){}
	
	public ErrorEmsDTO(CiEnContextDTO ctx,Object docObj,List<String> msgList){
		setEnContext(ctx);
		FArrayList doc = new FArrayList();
		doc.add(docObj);
		setDocument(doc);
		FArrayList msg = new FArrayList();
		msg.addAll(msgList);
		setErrorInfo(msg);
	}

	/**
	 * 错误信息
	 * @return FArrayList
	 */
	public FArrayList getErrorInfo() {
		return ((FArrayList) getAttrVal("ErrorInfo"));
	}
	/**
	 * 错误信息
	 * @param ErrorInfo
	 */
	public void setErrorInfo(FArrayList ErrorInfo) {
		setAttrVal("ErrorInfo", ErrorInfo);
	}
	
	
}
