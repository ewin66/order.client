package iih.ci.mr.nu.obstetrics.abortionrecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.abortionrecord.d.desc.AbortionRecordDODesc;
import java.math.BigDecimal;

/**
 * 中期妊娠流产记录 DO数据 
 * 
 */
public class AbortionRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ABORTION= "Id_abortion";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_PAT= "Name_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String AGE= "Age";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String NAME_BED= "Name_bed";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String DT_IN= "Dt_in";
	public static final String DT_CONTRACTIONS= "Dt_contractions";
	public static final String DT_AMNIOTICFLUID_RUPTURE= "Dt_amnioticfluid_rupture";
	public static final String ID_RUPTURETP= "Id_rupturetp";
	public static final String SD_RUPTURETP= "Sd_rupturetp";
	public static final String ID_AMNIOTICFLUID_COLOR= "Id_amnioticfluid_color";
	public static final String SD_AMNIOTICFLUID_COLOR= "Sd_amnioticfluid_color";
	public static final String DT_ABORTION= "Dt_abortion";
	public static final String ID_CHILDBIRTH_ABORTIONTP= "Id_childbirth_abortiontp";
	public static final String SD_CHILDBIRTH_ABORTIONTP= "Sd_childbirth_abortiontp";
	public static final String ID_CHILD_SITUATION= "Id_child_situation";
	public static final String SD_CHILD_SITUATION= "Sd_child_situation";
	public static final String LENGTH_CHILD= "Length_child";
	public static final String WEIGHT_CHILD= "Weight_child";
	public static final String ID_CHILD_APPEARANCES= "Id_child_appearances";
	public static final String SD_CHILD_APPEARANCES= "Sd_child_appearances";
	public static final String FG_MALFORMATION= "Fg_malformation";
	public static final String ID_DELIVERYTP= "Id_deliverytp";
	public static final String SD_DELIVERYTP= "Sd_deliverytp";
	public static final String DT_DELIVERY= "Dt_delivery";
	public static final String ID_PLACENTA_BIRTHTP= "Id_placenta_birthtp";
	public static final String SD_PLACENTA_BIRTHTP= "Sd_placenta_birthtp";
	public static final String ID_PLACENTA_SITUATION= "Id_placenta_situation";
	public static final String SD_PLACENTA_SITUATION= "Sd_placenta_situation";
	public static final String ID_CAUL_SITUATION= "Id_caul_situation";
	public static final String SD_CAUL_SITUATION= "Sd_caul_situation";
	public static final String NUM_BLEEDING= "Num_bleeding";
	public static final String ID_CONTRACTIONS_AGENT= "Id_contractions_agent";
	public static final String SD_CONTRACTIONS_AGENT= "Sd_contractions_agent";
	public static final String ID_ROUTE= "Id_route";
	public static final String NUM_BLEEDINGED= "Num_bleedinged";
	public static final String HEIGHTPRESSURE= "Heightpressure";
	public static final String LOWPRESSURE= "Lowpressure";
	public static final String PULSE= "Pulse";
	public static final String FG_FULL_BLADDER= "Fg_full_bladder";
	public static final String ID_BIRTH_CANAL_CHK= "Id_birth_canal_chk";
	public static final String SD_BIRTH_CANAL_CHK= "Sd_birth_canal_chk";
	public static final String NOTE= "Note";
	public static final String NUM_BLEEDING_VAGINA= "Num_bleeding_vagina";
	public static final String ID_ORDER_DRUG= "Id_order_drug";
	public static final String SD_ORDER_DRUG= "Sd_order_drug";
	public static final String DOSAGE= "Dosage";
	public static final String ID_COMPLICATION= "Id_complication";
	public static final String SD_COMPLICATION= "Sd_complication";
	public static final String ID_EMP_DELY= "Id_emp_dely";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_RUPTURETP= "Name_rupturetp";
	public static final String NAME_AMNIOTICFLUID_COLOR= "Name_amnioticfluid_color";
	public static final String NAME_CHILDBIRTH_ABORTIONTP= "Name_childbirth_abortiontp";
	public static final String NAME_CHILD_SITUATION= "Name_child_situation";
	public static final String NAME_CHILD_APPEARANCES= "Name_child_appearances";
	public static final String NAME_DELIVERYTP= "Name_deliverytp";
	public static final String NAME_PLACENTA_BIRTHTP= "Name_placenta_birthtp";
	public static final String NAME_PLACENTA_SITUATION= "Name_placenta_situation";
	public static final String NAME_CAUL_SITUATION= "Name_caul_situation";
	public static final String NAME_CONTRACTIONS_AGENT= "Name_contractions_agent";
	public static final String NAME_ROUTE= "Name_route";
	public static final String NAME_BIRTH_CANAL_CHK= "Name_birth_canal_chk";
	public static final String NAME_ORDER_DRUG= "Name_order_drug";
	public static final String NAME_COMPLICATION= "Name_complication";
	public static final String NAME_EMP_DELY= "Name_emp_dely";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_abortion() {
		return ((String) getAttrVal("Id_abortion"));
	}	
	public void setId_abortion(String Id_abortion) {
		setAttrVal("Id_abortion", Id_abortion);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
	}
	public FDateTime getDt_in() {
		return ((FDateTime) getAttrVal("Dt_in"));
	}	
	public void setDt_in(FDateTime Dt_in) {
		setAttrVal("Dt_in", Dt_in);
	}
	public FDateTime getDt_contractions() {
		return ((FDateTime) getAttrVal("Dt_contractions"));
	}	
	public void setDt_contractions(FDateTime Dt_contractions) {
		setAttrVal("Dt_contractions", Dt_contractions);
	}
	public FDateTime getDt_amnioticfluid_rupture() {
		return ((FDateTime) getAttrVal("Dt_amnioticfluid_rupture"));
	}	
	public void setDt_amnioticfluid_rupture(FDateTime Dt_amnioticfluid_rupture) {
		setAttrVal("Dt_amnioticfluid_rupture", Dt_amnioticfluid_rupture);
	}
	public String getId_rupturetp() {
		return ((String) getAttrVal("Id_rupturetp"));
	}	
	public void setId_rupturetp(String Id_rupturetp) {
		setAttrVal("Id_rupturetp", Id_rupturetp);
	}
	public String getSd_rupturetp() {
		return ((String) getAttrVal("Sd_rupturetp"));
	}	
	public void setSd_rupturetp(String Sd_rupturetp) {
		setAttrVal("Sd_rupturetp", Sd_rupturetp);
	}
	public String getId_amnioticfluid_color() {
		return ((String) getAttrVal("Id_amnioticfluid_color"));
	}	
	public void setId_amnioticfluid_color(String Id_amnioticfluid_color) {
		setAttrVal("Id_amnioticfluid_color", Id_amnioticfluid_color);
	}
	public String getSd_amnioticfluid_color() {
		return ((String) getAttrVal("Sd_amnioticfluid_color"));
	}	
	public void setSd_amnioticfluid_color(String Sd_amnioticfluid_color) {
		setAttrVal("Sd_amnioticfluid_color", Sd_amnioticfluid_color);
	}
	public FDateTime getDt_abortion() {
		return ((FDateTime) getAttrVal("Dt_abortion"));
	}	
	public void setDt_abortion(FDateTime Dt_abortion) {
		setAttrVal("Dt_abortion", Dt_abortion);
	}
	public String getId_childbirth_abortiontp() {
		return ((String) getAttrVal("Id_childbirth_abortiontp"));
	}	
	public void setId_childbirth_abortiontp(String Id_childbirth_abortiontp) {
		setAttrVal("Id_childbirth_abortiontp", Id_childbirth_abortiontp);
	}
	public String getSd_childbirth_abortiontp() {
		return ((String) getAttrVal("Sd_childbirth_abortiontp"));
	}	
	public void setSd_childbirth_abortiontp(String Sd_childbirth_abortiontp) {
		setAttrVal("Sd_childbirth_abortiontp", Sd_childbirth_abortiontp);
	}
	public String getId_child_situation() {
		return ((String) getAttrVal("Id_child_situation"));
	}	
	public void setId_child_situation(String Id_child_situation) {
		setAttrVal("Id_child_situation", Id_child_situation);
	}
	public String getSd_child_situation() {
		return ((String) getAttrVal("Sd_child_situation"));
	}	
	public void setSd_child_situation(String Sd_child_situation) {
		setAttrVal("Sd_child_situation", Sd_child_situation);
	}
	public Integer getLength_child() {
		return ((Integer) getAttrVal("Length_child"));
	}	
	public void setLength_child(Integer Length_child) {
		setAttrVal("Length_child", Length_child);
	}
	public Integer getWeight_child() {
		return ((Integer) getAttrVal("Weight_child"));
	}	
	public void setWeight_child(Integer Weight_child) {
		setAttrVal("Weight_child", Weight_child);
	}
	public String getId_child_appearances() {
		return ((String) getAttrVal("Id_child_appearances"));
	}	
	public void setId_child_appearances(String Id_child_appearances) {
		setAttrVal("Id_child_appearances", Id_child_appearances);
	}
	public String getSd_child_appearances() {
		return ((String) getAttrVal("Sd_child_appearances"));
	}	
	public void setSd_child_appearances(String Sd_child_appearances) {
		setAttrVal("Sd_child_appearances", Sd_child_appearances);
	}
	public FBoolean getFg_malformation() {
		return ((FBoolean) getAttrVal("Fg_malformation"));
	}	
	public void setFg_malformation(FBoolean Fg_malformation) {
		setAttrVal("Fg_malformation", Fg_malformation);
	}
	public String getId_deliverytp() {
		return ((String) getAttrVal("Id_deliverytp"));
	}	
	public void setId_deliverytp(String Id_deliverytp) {
		setAttrVal("Id_deliverytp", Id_deliverytp);
	}
	public String getSd_deliverytp() {
		return ((String) getAttrVal("Sd_deliverytp"));
	}	
	public void setSd_deliverytp(String Sd_deliverytp) {
		setAttrVal("Sd_deliverytp", Sd_deliverytp);
	}
	public FDateTime getDt_delivery() {
		return ((FDateTime) getAttrVal("Dt_delivery"));
	}	
	public void setDt_delivery(FDateTime Dt_delivery) {
		setAttrVal("Dt_delivery", Dt_delivery);
	}
	public String getId_placenta_birthtp() {
		return ((String) getAttrVal("Id_placenta_birthtp"));
	}	
	public void setId_placenta_birthtp(String Id_placenta_birthtp) {
		setAttrVal("Id_placenta_birthtp", Id_placenta_birthtp);
	}
	public String getSd_placenta_birthtp() {
		return ((String) getAttrVal("Sd_placenta_birthtp"));
	}	
	public void setSd_placenta_birthtp(String Sd_placenta_birthtp) {
		setAttrVal("Sd_placenta_birthtp", Sd_placenta_birthtp);
	}
	public String getId_placenta_situation() {
		return ((String) getAttrVal("Id_placenta_situation"));
	}	
	public void setId_placenta_situation(String Id_placenta_situation) {
		setAttrVal("Id_placenta_situation", Id_placenta_situation);
	}
	public String getSd_placenta_situation() {
		return ((String) getAttrVal("Sd_placenta_situation"));
	}	
	public void setSd_placenta_situation(String Sd_placenta_situation) {
		setAttrVal("Sd_placenta_situation", Sd_placenta_situation);
	}
	public String getId_caul_situation() {
		return ((String) getAttrVal("Id_caul_situation"));
	}	
	public void setId_caul_situation(String Id_caul_situation) {
		setAttrVal("Id_caul_situation", Id_caul_situation);
	}
	public String getSd_caul_situation() {
		return ((String) getAttrVal("Sd_caul_situation"));
	}	
	public void setSd_caul_situation(String Sd_caul_situation) {
		setAttrVal("Sd_caul_situation", Sd_caul_situation);
	}
	public Integer getNum_bleeding() {
		return ((Integer) getAttrVal("Num_bleeding"));
	}	
	public void setNum_bleeding(Integer Num_bleeding) {
		setAttrVal("Num_bleeding", Num_bleeding);
	}
	public String getId_contractions_agent() {
		return ((String) getAttrVal("Id_contractions_agent"));
	}	
	public void setId_contractions_agent(String Id_contractions_agent) {
		setAttrVal("Id_contractions_agent", Id_contractions_agent);
	}
	public String getSd_contractions_agent() {
		return ((String) getAttrVal("Sd_contractions_agent"));
	}	
	public void setSd_contractions_agent(String Sd_contractions_agent) {
		setAttrVal("Sd_contractions_agent", Sd_contractions_agent);
	}
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	public Integer getNum_bleedinged() {
		return ((Integer) getAttrVal("Num_bleedinged"));
	}	
	public void setNum_bleedinged(Integer Num_bleedinged) {
		setAttrVal("Num_bleedinged", Num_bleedinged);
	}
	public Integer getHeightpressure() {
		return ((Integer) getAttrVal("Heightpressure"));
	}	
	public void setHeightpressure(Integer Heightpressure) {
		setAttrVal("Heightpressure", Heightpressure);
	}
	public Integer getLowpressure() {
		return ((Integer) getAttrVal("Lowpressure"));
	}	
	public void setLowpressure(Integer Lowpressure) {
		setAttrVal("Lowpressure", Lowpressure);
	}
	public Integer getPulse() {
		return ((Integer) getAttrVal("Pulse"));
	}	
	public void setPulse(Integer Pulse) {
		setAttrVal("Pulse", Pulse);
	}
	public FBoolean getFg_full_bladder() {
		return ((FBoolean) getAttrVal("Fg_full_bladder"));
	}	
	public void setFg_full_bladder(FBoolean Fg_full_bladder) {
		setAttrVal("Fg_full_bladder", Fg_full_bladder);
	}
	public String getId_birth_canal_chk() {
		return ((String) getAttrVal("Id_birth_canal_chk"));
	}	
	public void setId_birth_canal_chk(String Id_birth_canal_chk) {
		setAttrVal("Id_birth_canal_chk", Id_birth_canal_chk);
	}
	public String getSd_birth_canal_chk() {
		return ((String) getAttrVal("Sd_birth_canal_chk"));
	}	
	public void setSd_birth_canal_chk(String Sd_birth_canal_chk) {
		setAttrVal("Sd_birth_canal_chk", Sd_birth_canal_chk);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public Integer getNum_bleeding_vagina() {
		return ((Integer) getAttrVal("Num_bleeding_vagina"));
	}	
	public void setNum_bleeding_vagina(Integer Num_bleeding_vagina) {
		setAttrVal("Num_bleeding_vagina", Num_bleeding_vagina);
	}
	public String getId_order_drug() {
		return ((String) getAttrVal("Id_order_drug"));
	}	
	public void setId_order_drug(String Id_order_drug) {
		setAttrVal("Id_order_drug", Id_order_drug);
	}
	public String getSd_order_drug() {
		return ((String) getAttrVal("Sd_order_drug"));
	}	
	public void setSd_order_drug(String Sd_order_drug) {
		setAttrVal("Sd_order_drug", Sd_order_drug);
	}
	public Integer getDosage() {
		return ((Integer) getAttrVal("Dosage"));
	}	
	public void setDosage(Integer Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	public String getId_complication() {
		return ((String) getAttrVal("Id_complication"));
	}	
	public void setId_complication(String Id_complication) {
		setAttrVal("Id_complication", Id_complication);
	}
	public String getSd_complication() {
		return ((String) getAttrVal("Sd_complication"));
	}	
	public void setSd_complication(String Sd_complication) {
		setAttrVal("Sd_complication", Sd_complication);
	}
	public String getId_emp_dely() {
		return ((String) getAttrVal("Id_emp_dely"));
	}	
	public void setId_emp_dely(String Id_emp_dely) {
		setAttrVal("Id_emp_dely", Id_emp_dely);
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
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_rupturetp() {
		return ((String) getAttrVal("Name_rupturetp"));
	}	
	public void setName_rupturetp(String Name_rupturetp) {
		setAttrVal("Name_rupturetp", Name_rupturetp);
	}
	public String getName_amnioticfluid_color() {
		return ((String) getAttrVal("Name_amnioticfluid_color"));
	}	
	public void setName_amnioticfluid_color(String Name_amnioticfluid_color) {
		setAttrVal("Name_amnioticfluid_color", Name_amnioticfluid_color);
	}
	public String getName_childbirth_abortiontp() {
		return ((String) getAttrVal("Name_childbirth_abortiontp"));
	}	
	public void setName_childbirth_abortiontp(String Name_childbirth_abortiontp) {
		setAttrVal("Name_childbirth_abortiontp", Name_childbirth_abortiontp);
	}
	public String getName_child_situation() {
		return ((String) getAttrVal("Name_child_situation"));
	}	
	public void setName_child_situation(String Name_child_situation) {
		setAttrVal("Name_child_situation", Name_child_situation);
	}
	public String getName_child_appearances() {
		return ((String) getAttrVal("Name_child_appearances"));
	}	
	public void setName_child_appearances(String Name_child_appearances) {
		setAttrVal("Name_child_appearances", Name_child_appearances);
	}
	public String getName_deliverytp() {
		return ((String) getAttrVal("Name_deliverytp"));
	}	
	public void setName_deliverytp(String Name_deliverytp) {
		setAttrVal("Name_deliverytp", Name_deliverytp);
	}
	public String getName_placenta_birthtp() {
		return ((String) getAttrVal("Name_placenta_birthtp"));
	}	
	public void setName_placenta_birthtp(String Name_placenta_birthtp) {
		setAttrVal("Name_placenta_birthtp", Name_placenta_birthtp);
	}
	public String getName_placenta_situation() {
		return ((String) getAttrVal("Name_placenta_situation"));
	}	
	public void setName_placenta_situation(String Name_placenta_situation) {
		setAttrVal("Name_placenta_situation", Name_placenta_situation);
	}
	public String getName_caul_situation() {
		return ((String) getAttrVal("Name_caul_situation"));
	}	
	public void setName_caul_situation(String Name_caul_situation) {
		setAttrVal("Name_caul_situation", Name_caul_situation);
	}
	public String getName_contractions_agent() {
		return ((String) getAttrVal("Name_contractions_agent"));
	}	
	public void setName_contractions_agent(String Name_contractions_agent) {
		setAttrVal("Name_contractions_agent", Name_contractions_agent);
	}
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}	
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	public String getName_birth_canal_chk() {
		return ((String) getAttrVal("Name_birth_canal_chk"));
	}	
	public void setName_birth_canal_chk(String Name_birth_canal_chk) {
		setAttrVal("Name_birth_canal_chk", Name_birth_canal_chk);
	}
	public String getName_order_drug() {
		return ((String) getAttrVal("Name_order_drug"));
	}	
	public void setName_order_drug(String Name_order_drug) {
		setAttrVal("Name_order_drug", Name_order_drug);
	}
	public String getName_complication() {
		return ((String) getAttrVal("Name_complication"));
	}	
	public void setName_complication(String Name_complication) {
		setAttrVal("Name_complication", Name_complication);
	}
	public String getName_emp_dely() {
		return ((String) getAttrVal("Name_emp_dely"));
	}	
	public void setName_emp_dely(String Name_emp_dely) {
		setAttrVal("Name_emp_dely", Name_emp_dely);
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
		return "Id_abortion";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_nu_abortionrecord";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AbortionRecordDODesc.class);
	}
	
}