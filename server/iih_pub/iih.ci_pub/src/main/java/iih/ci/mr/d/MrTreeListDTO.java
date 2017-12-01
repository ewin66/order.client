package iih.ci.mr.d;

import xap.mw.core.data.BaseDTO;

public class MrTreeListDTO extends BaseDTO {
	
	private static final long serialVersionUID = 1L;
	 
	public static  String ID_MRTP= "Id_mrtp";
	public static  String NAME= "Name";	
	public static  String ID_PARENT= "Id_parent";
	public static  String CODE= "Code";
	public static  String NUM= "Num";
	public static String getID_MRTP() {
		return ID_MRTP;
	}
	public static void setID_MRTP(String iD_MRTP) {
		ID_MRTP = iD_MRTP;
	}
	public static String getNAME() {
		return NAME;
	}
	public static void setNAME(String nAME) {
		NAME = nAME;
	}
	public static String getID_PARENT() {
		return ID_PARENT;
	}
	public static void setID_PARENT(String iD_PARENT) {
		ID_PARENT = iD_PARENT;
	}
	public static String getCODE() {
		return CODE;
	}
	public static void setCODE(String cODE) {
		CODE = cODE;
	}
	public static String getNUM() {
		return NUM;
	}
	public static void setNUM(String nUM) {
		NUM = nUM;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	

}

