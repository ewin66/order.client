/**
 * 
 */
package iih.ci.ord.pub;

import java.util.HashMap;
import java.util.Map;

import xap.mw.coreitf.d.FDateTime;

/**
 * @ClassName: TeatMain
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年4月30日 下午5:27:53
 * @Package iih.ci.ord.pub
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class TeatMain {

	 public String name="王琪";
	 public int num = 0;
	 
	 public void  method(){
		 
	 }
	 
 
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //System.out.println(String.format("%ss","aaa"));
       // System.out.println(TeatMain.class);
        //Class.forName(TeatMain.class);
		TeatMain test = new TeatMain();
		FDateTime f =  new FDateTime();
		System.out.println(f.getDateTimeBefore(2));
		System.out.println(f.getDateTimeAfter(2));
		String sql =",wewe,wewe,wew";
		System.out.println(sql.substring(1));
		mapkeyset();
	}
    public static void mapkeyset(){
    	Map map = new HashMap();
    	map.put("0001", "001");
    	map.put("0002", "002");
    	map.put("0003", "003");
    	map.put("0004", "004");
    	String[] str = (String[]) map.keySet().toArray(new String[map.size()]);
    	for(String id:str){
    		System.out.println(id);
    	}
    
    }
}
