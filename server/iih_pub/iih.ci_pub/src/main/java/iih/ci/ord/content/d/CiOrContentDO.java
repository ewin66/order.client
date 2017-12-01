package iih.ci.ord.content.d;

import java.util.ArrayList;

/**
 * 医嘱内容对象
 */
public class CiOrContentDO {
	private String typeId;
	private String title;
	private ArrayList<ArrayList<String>> itemInfos;
	private ArrayList<String> tailInfo;
	private static final String PROP_SPLIT_STR="|";
	private static final String ITEM_IN_SPLIT_STR="&";
	private static final String ITEMS_BETWEEN_SPLIT_STR="^";
	
	public String getTypeId() {
		return typeId;
	}
	public String getTitle() {
		return title;
	}
	public ArrayList<ArrayList<String>> getItemInfos() {
		return itemInfos;
	}
	public ArrayList<String> getTailInfo() {
		return tailInfo;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setItemInfos(ArrayList<ArrayList<String>> itemInfos) {
		this.itemInfos = itemInfos;
	}
	public void setTailInfo(ArrayList<String> tailInfo) {
		this.tailInfo = tailInfo;
	}
	
	@Override
	public String toString() {
		return getTypeId() + PROP_SPLIT_STR + getTitle() + PROP_SPLIT_STR
				+ getItemsStr(getItemInfos()) + PROP_SPLIT_STR
				+ getItemStr(getTailInfo());
	}
	
	private String getItemStr(ArrayList<String> list){
		if (list == null || list.size() == 0)
			return "";
		String rtn = "";
		String temp = "";
		for (int i = 0; i < list.size(); i++) {
			temp = list.get(i);
			if (temp != null) {
				rtn += ITEM_IN_SPLIT_STR + temp;
			}

		}
		if (rtn == null || rtn.length() == 0) {
			return "";
		} else {
			return rtn.substring(1);
		}
	}
	
	private String getItemsStr(ArrayList<ArrayList<String>> list){
		if (list == null || list.size() == 0)
			return "";
		String rtn = "";
		for (int j = 0; j < list.size(); j++) {
			rtn += getItemStr(list.get(j));
			rtn += ITEMS_BETWEEN_SPLIT_STR;
		}
		return rtn.substring(0, rtn.lastIndexOf(ITEMS_BETWEEN_SPLIT_STR));
	}
}
