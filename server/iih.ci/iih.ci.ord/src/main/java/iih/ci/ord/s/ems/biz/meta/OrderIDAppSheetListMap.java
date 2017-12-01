package iih.ci.ord.s.ems.biz.meta;

import java.util.HashMap;

public class OrderIDAppSheetListMap extends HashMap<String, ObjectList> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String[] asKeyArray(){
		return this.keySet().toArray(new String[size()]);
	}

	@Override
	public Object clone() {
		// TODO Auto-generated method stub
		return super.clone();
	}

	
}
