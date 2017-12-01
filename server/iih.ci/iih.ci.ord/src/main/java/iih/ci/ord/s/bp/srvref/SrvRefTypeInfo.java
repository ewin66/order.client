package iih.ci.ord.s.bp.srvref;

public class SrvRefTypeInfo {
	private Integer tp;        //类型
	private String[] tpFields; //类型所属属性字段
	private String[] tpRelFields;//属性字段对应的字段
	private String tpTableBasic;//基本表
	private String[] tpTblFeatures;//表特征
	private String[] tpTableRel;  //表关联 
	
	public Integer getTp() {
		return tp;
	}
	public void setTp(Integer tp) {
		this.tp = tp;
	}
	public String[] getTpFields() {
		return tpFields;
	}
	public void setTpFields(String[] tpFields) {
		this.tpFields = tpFields;
	}
	public String[] getTpRelFields() {
		return tpRelFields;
	}
	public void setTpRelFields(String[] tpRelFields) {
		this.tpRelFields = tpRelFields;
	}
	public String getTpTableBasic() {
		return tpTableBasic;
	}
	public void setTpTableBasic(String tpTableBasic) {
		this.tpTableBasic = tpTableBasic;
	}
	public String[] getTpTblFeatures() {
		return tpTblFeatures;
	}
	public void setTpTblFeatures(String[] tpTblFeatures) {
		this.tpTblFeatures = tpTblFeatures;
	}
	public String[] getTpTableRel() {
		return tpTableRel;
	}
	public void setTpTableRel(String[] tpTableRel) {
		this.tpTableRel = tpTableRel;
	}

	
}
