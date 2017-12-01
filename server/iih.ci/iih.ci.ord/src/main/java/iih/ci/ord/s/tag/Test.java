package iih.ci.ord.s.tag;

import java.io.FileInputStream;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
    	//FieldTagVUtils.getTagContent("iih.ci.ord.s.tag.TestEnum");
    	String sql = "select role.pk_group, ur.* from sm_role as role, sm_user_role as ur where role.pk_role=ur.pk_role and ((ur.enabledate>= {begindate? 'ddbegindate'  'ffff'} and ur.enabledate < {enddate?}) or (ur.disabledate >= {begindate?} and ur.disabledate < {enddate?})) and ur.ts < {begindate?}";
    	Pattern pattern = Pattern.compile("\\{(.*?)\\}"); 
    	   
		Matcher matcher = pattern.matcher(sql);
		
		while(matcher.find())
		{
			String expression = matcher.group(0);
			String name = matcher.group(1);
			String nd="";
		}
    	  // System.out.println(rand.nextFloat());
    	  // System.out.println(rand.nextLong()%);
           
          

       
    	//关于TimeLog的使用举例 CompareOperatorTemplate
	    //TimeLog.logStart();
	    //doAAAA();
	    //TimeLog.info("业务处理前执行业务规则"); /*-=notranslate=-*/
   	
    }
    
    public void readByText() throws Exception { 
    	 /* FileInputStream in = new FileInputStream("C://test.doc "); 
    	  WordExtractor extractor = new WordExtractor(); 
    	  String str = extractor.extractText(in); 
    	  System.out.println(str); */
    	 } 
}
