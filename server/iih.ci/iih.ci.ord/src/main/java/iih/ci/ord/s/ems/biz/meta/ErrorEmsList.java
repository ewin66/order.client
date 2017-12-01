package iih.ci.ord.s.ems.biz.meta;

import java.util.ArrayList;

import iih.ci.ord.d.ems.tmpl.ErrorEmsDTO;
import xap.mw.core.data.FArrayList;

/**
 * 医疗单错误信息描述
 * @author wangqingzhu
 *
 */
public class ErrorEmsList extends ArrayList<ErrorEmsDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 返回可以远程传输列表对象
	 * @return
	 */
	public FArrayList asFArrayList(){
		FArrayList rst = new FArrayList();
		rst.addAll(this);
		return rst;
	}
	
	/**
	 * 从FArrayList对象中抽取数据
	 * @param c
	 * @return
	 */
	public ErrorEmsList fromFArrayList(FArrayList c){
		this.addAll(c);
		return this;
	}
	
	/**
	 * 获取错误原始数据对象集合
	 * @return
	 */
	public ObjectList asMetaDataList(){
		ObjectList objectList = new ObjectList();
		for (ErrorEmsDTO o : this){
			objectList.addAll(o.getDocument());
		}
		return objectList;
	}
}
