package iih.ci.ord.content.d;

public class ICiOrContentConst {
	
	public static final String ORContent_TYPE_HERB="0103";
	public static final String ORContent_TYPE_DRUGDEFAULT="0101";
	public static final String ORContent_TYPE_DRUGDEFAULT2="0102";
	public static final String ORContent_TYPE_RISBINGLI="0201";
	public static final String ORContent_TYPE_RISDEFAULT="0202";
	public static final String ORContent_TYPE_LISSKINTEST="0301";
	public static final String ORContent_TYPE_LISDEFAULT="0302";
	public static final String ORContent_TYPE_OP="";
	public static final String ORContent_TYPE_DEFAULT="OTH";
	public static final String ORContent_TYPE_NULL="NULL";
	
	
	 //转义字符
	 private static final String separator1 = "|";
     private static final String separator2 = "&";
     private static final String separator3 = "^";
     private static final String separator4 = "\\";
     
     private static final String escapeChara1 = "\\F\\";
     private static final String escapeChara2 = "\\T\\";
     private static final String escapeChara3 = "\\S\\";
     private static final String escapeChara4 = "\\E\\";
     
     /**
      * 特殊分隔符切换到转义符
      * @param text
      * @return
      */
     public  static String ChangeToEscapeCharacter(String  text){
    	 if(text == null || text == "") return "";
    	 String temptext =  text;
    	 temptext= temptext.replace(separator4, escapeChara4);
    	 temptext=temptext.replace(separator1, escapeChara1);
    	 temptext=temptext.replace(separator2, escapeChara2);
    	 temptext=temptext.replace(separator3, escapeChara3);
        return temptext;
     }
}