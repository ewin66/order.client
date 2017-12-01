package iih.ci.mr.nu.newbabypicc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.newbabypicc.d.desc.NewBabyPiccRecDODesc;
import java.math.BigDecimal;

/**
 * 新生儿科PICC护理记录 DO数据 
 * 
 */
public class NewBabyPiccRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PICCREC= "Id_piccrec";
	public static final String ID_PICC= "Id_picc";
	public static final String D_REC= "D_rec";
	public static final String T_REC= "T_rec";
	public static final String REDSWOLLEN= "Redswollen";
	public static final String SCLEROMA= "Scleroma";
	public static final String BLEEDING= "Bleeding";
	public static final String ID_PIPE_INFUSION= "Id_pipe_infusion";
	public static final String SD_PIPE_INFUSION= "Sd_pipe_infusion";
	public static final String CATHETER_INSERTION= "Catheter_insertion";
	public static final String CATHETER_EXPOSED= "Catheter_exposed";
	public static final String LENGTH_LEFTARM= "Length_leftarm";
	public static final String LENGTH_RIGHTARM= "Length_rightarm";
	public static final String REPLACE_FILM= "Replace_film";
	public static final String REPLACE_INFUSION_CONECTOR= "Replace_infusion_conector";
	public static final String WET_PACK= "Wet_pack";
	public static final String OINTMEN= "Ointmen";
	public static final String OTHER= "Other";
	public static final String ID_SIGN= "Id_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PIPE_INFUSION= "Name_pipe_infusion";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_piccrec() {
		return ((String) getAttrVal("Id_piccrec"));
	}	
	public void setId_piccrec(String Id_piccrec) {
		setAttrVal("Id_piccrec", Id_piccrec);
	}
	public String getId_picc() {
		return ((String) getAttrVal("Id_picc"));
	}	
	public void setId_picc(String Id_picc) {
		setAttrVal("Id_picc", Id_picc);
	}
	public FDate getD_rec() {
		return ((FDate) getAttrVal("D_rec"));
	}	
	public void setD_rec(FDate D_rec) {
		setAttrVal("D_rec", D_rec);
	}
	public FTime getT_rec() {
		return ((FTime) getAttrVal("T_rec"));
	}	
	public void setT_rec(FTime T_rec) {
		setAttrVal("T_rec", T_rec);
	}
	public Integer getRedswollen() {
		return ((Integer) getAttrVal("Redswollen"));
	}	
	public void setRedswollen(Integer Redswollen) {
		setAttrVal("Redswollen", Redswollen);
	}
	public Integer getScleroma() {
		return ((Integer) getAttrVal("Scleroma"));
	}	
	public void setScleroma(Integer Scleroma) {
		setAttrVal("Scleroma", Scleroma);
	}
	public Integer getBleeding() {
		return ((Integer) getAttrVal("Bleeding"));
	}	
	public void setBleeding(Integer Bleeding) {
		setAttrVal("Bleeding", Bleeding);
	}
	public String getId_pipe_infusion() {
		return ((String) getAttrVal("Id_pipe_infusion"));
	}	
	public void setId_pipe_infusion(String Id_pipe_infusion) {
		setAttrVal("Id_pipe_infusion", Id_pipe_infusion);
	}
	public String getSd_pipe_infusion() {
		return ((String) getAttrVal("Sd_pipe_infusion"));
	}	
	public void setSd_pipe_infusion(String Sd_pipe_infusion) {
		setAttrVal("Sd_pipe_infusion", Sd_pipe_infusion);
	}
	public Integer getCatheter_insertion() {
		return ((Integer) getAttrVal("Catheter_insertion"));
	}	
	public void setCatheter_insertion(Integer Catheter_insertion) {
		setAttrVal("Catheter_insertion", Catheter_insertion);
	}
	public Integer getCatheter_exposed() {
		return ((Integer) getAttrVal("Catheter_exposed"));
	}	
	public void setCatheter_exposed(Integer Catheter_exposed) {
		setAttrVal("Catheter_exposed", Catheter_exposed);
	}
	public FDouble getLength_leftarm() {
		return ((FDouble) getAttrVal("Length_leftarm"));
	}	
	public void setLength_leftarm(FDouble Length_leftarm) {
		setAttrVal("Length_leftarm", Length_leftarm);
	}
	public FDouble getLength_rightarm() {
		return ((FDouble) getAttrVal("Length_rightarm"));
	}	
	public void setLength_rightarm(FDouble Length_rightarm) {
		setAttrVal("Length_rightarm", Length_rightarm);
	}
	public Integer getReplace_film() {
		return ((Integer) getAttrVal("Replace_film"));
	}	
	public void setReplace_film(Integer Replace_film) {
		setAttrVal("Replace_film", Replace_film);
	}
	public Integer getReplace_infusion_conector() {
		return ((Integer) getAttrVal("Replace_infusion_conector"));
	}	
	public void setReplace_infusion_conector(Integer Replace_infusion_conector) {
		setAttrVal("Replace_infusion_conector", Replace_infusion_conector);
	}
	public Integer getWet_pack() {
		return ((Integer) getAttrVal("Wet_pack"));
	}	
	public void setWet_pack(Integer Wet_pack) {
		setAttrVal("Wet_pack", Wet_pack);
	}
	public Integer getOintmen() {
		return ((Integer) getAttrVal("Ointmen"));
	}	
	public void setOintmen(Integer Ointmen) {
		setAttrVal("Ointmen", Ointmen);
	}
	public String getOther() {
		return ((String) getAttrVal("Other"));
	}	
	public void setOther(String Other) {
		setAttrVal("Other", Other);
	}
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getName_pipe_infusion() {
		return ((String) getAttrVal("Name_pipe_infusion"));
	}	
	public void setName_pipe_infusion(String Name_pipe_infusion) {
		setAttrVal("Name_pipe_infusion", Name_pipe_infusion);
	}
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_piccrec";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_nu_picc_rec";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NewBabyPiccRecDODesc.class);
	}
	
}