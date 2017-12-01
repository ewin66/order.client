package iih.ci.ord.s.ems.define;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.FArrayList;

/**
 * 字符串列表工具类
 * @author wangqingzhu
 *
 */
public class StringList extends ArrayList<String> {
	private static final long serialVersionUID = 1L;

	public StringList(){}
	public StringList(FArrayList objList){
		for (Object o : objList){
			if (!CiOrdUtils.isEmpty(o))
				this.add(o.toString());
		}
	}

	public String[] asArray(){
		return this.toArray(new String[size()]);
	}
	
	public static String AsString(String[] szStrObject, String splc){
		StringBuilder sb = new StringBuilder();
		for (String str : szStrObject){
			sb.append(str).append(splc);
		}
		return sb.toString();
	}
	public static String AsString(List<String> szStrObject, char splc){
		StringBuilder sb = new StringBuilder();
		for (String str : szStrObject){
			sb.append(str).append(splc);
		}
		return sb.toString();
	}
	public static String AsString(ArrayList<String> szStrObject, char splc){
		StringBuilder sb = new StringBuilder();
		for (String str : szStrObject){
			sb.append(str).append(splc);
		}
		return sb.toString();
	}
	
	public StringList add(String[] szStr){
		for (String str : szStr){
			this.add(str);
		}
		return this;
	}
}
