package iih.ci.ord.s.ems.biz.meta;

import xap.mw.core.data.FMap;
/**
 * 诊断概要信息，用于后台内部的逻辑处理
 * @author wangqingzhu
 *
 */
public class DiagOutlineInfo extends FMap {

	private static final long serialVersionUID = 1L;

	public void setId_di(String id_di){
		put("Id_di", id_di);
	}
	public String getId_di(){
		return (String)this.get("Id_di");
	}
	public void setId_diitm(String Id_diitm){
		put("Id_diitm", Id_diitm);
	}
	public String getId_diitm(){
		return (String)this.get("Id_diitm");
	}
	public void setName_diag(String Name_diag){
		put("Name_diag", Name_diag);
	}
	public String getName_diag(){
		return (String)this.get("Name_diag");
	}
	public void setStr_code_di(String Str_code_di){
		put("Str_code_di", Str_code_di);
	}
	public String getStr_code_di(){
		return (String)this.get("Str_code_di");
	}
	public void setStr_name_di(String Str_name_di){
		put("Str_name_di", Str_name_di);
	}
	public String getStr_name_di(){
		return (String)this.get("Str_name_di");
	}
	public void setStr_id_diitm(String Str_id_diitm){
		put("Str_id_diitm", Str_id_diitm);
	}
	public String getStr_id_diitm(){
		return (String)this.get("Str_id_diitm");
	}
	public FMap toFMap(){
		FMap fMap = new FMap();
		fMap.deSerializeJson(this.serializeJson());
		return fMap;
	}
	
}
