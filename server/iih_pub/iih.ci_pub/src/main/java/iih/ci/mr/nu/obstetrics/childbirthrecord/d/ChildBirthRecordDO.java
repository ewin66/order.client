package iih.ci.mr.nu.obstetrics.childbirthrecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.childbirthrecord.d.desc.ChildBirthRecordDODesc;
import java.math.BigDecimal;

/**
 * 分娩记录 DO数据 
 * 
 */
public class ChildBirthRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CHILDBIRTH= "Id_childbirth";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String CODE_ENTP= "Code_entp";
	public static final String AGE= "Age";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String NAME_BED= "Name_bed";
	public static final String DT_ZSKS= "Dt_zsks";
	public static final String DT_TMPL= "Dt_tmpl";
	public static final String DT_GKQK= "Dt_gkqk";
	public static final String DT_FIRST= "Dt_first";
	public static final String ID_FIRST_CBTP= "Id_first_cbtp";
	public static final String SD_FIRST_CBTP= "Sd_first_cbtp";
	public static final String ID_FIRST_PROTP= "Id_first_protp";
	public static final String SD_FIRST_PROTP= "Sd_first_protp";
	public static final String DT_SECOND= "Dt_second";
	public static final String ID_SECOND_CBTP= "Id_second_cbtp";
	public static final String SD_SECOND_CBTP= "Sd_second_cbtp";
	public static final String ID_SECOND_PROTP= "Id_second_protp";
	public static final String SD_SECOND_PROTP= "Sd_second_protp";
	public static final String DT_PLACENTA_BIRTH= "Dt_placenta_birth";
	public static final String ID_PLACENTA_BIRTHTP= "Id_placenta_birthtp";
	public static final String SD_PLACENTA_BIRTHTP= "Sd_placenta_birthtp";
	public static final String ID_PLACENTA_STRIPPING= "Id_placenta_stripping";
	public static final String SD_PLACENTA_STRIPPING= "Sd_placenta_stripping";
	public static final String NUM_AMNIOTIC_FLUID= "Num_amniotic_fluid";
	public static final String ID_AMNIOTIC_FLUID_CHAR= "Id_amniotic_fluid_char";
	public static final String SD_AMNIOTIC_FLUID_CHAR= "Sd_amniotic_fluid_char";
	public static final String NUM_UTERUS_HEIGHT= "Num_uterus_height";
	public static final String ID_PERINEUM_STATUS= "Id_perineum_status";
	public static final String SD_PERINEUM_STATUS= "Sd_perineum_status";
	public static final String ID_PERINEUM_SERIOUS= "Id_perineum_serious";
	public static final String SD_PERINEUM_SERIOUS= "Sd_perineum_serious";
	public static final String EU_VAGINAL_INJURY= "Eu_vaginal_injury";
	public static final String EU_CERVICAL_INJURY= "Eu_cervical_injury";
	public static final String ID_BLOODMEASURE= "Id_bloodmeasure";
	public static final String SD_BLOODMEASURE= "Sd_bloodmeasure";
	public static final String NUM_BLOOD_AFTERBIRTH= "Num_blood_afterbirth";
	public static final String NUM_FORTHLABOR_BLOOD= "Num_forthlabor_blood";
	public static final String ID_DRUG_AFTERBIRTH= "Id_drug_afterbirth";
	public static final String SD_DRUG_AFTERBIRTH= "Sd_drug_afterbirth";
	public static final String LABOR_FIRST= "Labor_first";
	public static final String LABOR_SECOND= "Labor_second";
	public static final String LABOR_THIRD= "Labor_third";
	public static final String LABOR_TOTAL= "Labor_total";
	public static final String ID_SEX_A= "Id_sex_a";
	public static final String SD_SEX_A= "Sd_sex_a";
	public static final String WEIGTH_A= "Weigth_a";
	public static final String HEIGHT_A= "Height_a";
	public static final String ID_CHILD_BIRTH_A= "Id_child_birth_a";
	public static final String SD_CHILD_BIRTH_A= "Sd_child_birth_a";
	public static final String ID_ASPHYXIA_A= "Id_asphyxia_a";
	public static final String SD_ASPHYXIA_A= "Sd_asphyxia_a";
	public static final String NUM_APGAR_ONE_A= "Num_apgar_one_a";
	public static final String NUM_APGAR_FIVE_A= "Num_apgar_five_a";
	public static final String NUM_APGAR_TEN_A= "Num_apgar_ten_a";
	public static final String EU_SKIN_A= "Eu_skin_a";
	public static final String EU_BREATH_A= "Eu_breath_a";
	public static final String EU_HEARTBEAT_A= "Eu_heartbeat_a";
	public static final String EU_MUSCLE_A= "Eu_muscle_a";
	public static final String EU_REFLECTION_A= "Eu_reflection_a";
	public static final String ID_UMBILICALCORD_PART_A= "Id_umbilicalcord_part_a";
	public static final String SD_UMBILICALCORD_PART_A= "Sd_umbilicalcord_part_a";
	public static final String NUM_UMBILICALCORD_PART_A= "Num_umbilicalcord_part_a";
	public static final String ID_UMBILICALCORD_LIGATION_A= "Id_umbilicalcord_ligation_a";
	public static final String SD_UMBILICALCORD_LIGATION_A= "Sd_umbilicalcord_ligation_a";
	public static final String ID_EYES_HANDLE_A= "Id_eyes_handle_a";
	public static final String SD_EYES_HANDLE_A= "Sd_eyes_handle_a";
	public static final String LENGTH_UMBILICALCORD_A= "Length_umbilicalcord_a";
	public static final String DES_UNUSUAL_A= "Des_unusual_a";
	public static final String ID_SEX_B= "Id_sex_b";
	public static final String SD_SEX_B= "Sd_sex_b";
	public static final String WEIGTH_B= "Weigth_b";
	public static final String HEIGHT_B= "Height_b";
	public static final String ID_CHILD_BIRTH_B= "Id_child_birth_b";
	public static final String SD_CHILD_BIRTH_B= "Sd_child_birth_b";
	public static final String ID_ASPHYXIA_B= "Id_asphyxia_b";
	public static final String SD_ASPHYXIA_B= "Sd_asphyxia_b";
	public static final String NUM_APGAR_ONE_B= "Num_apgar_one_b";
	public static final String NUM_APGAR_FIVE_B= "Num_apgar_five_b";
	public static final String NUM_APGAR_TEN_B= "Num_apgar_ten_b";
	public static final String EU_SKIN_B= "Eu_skin_b";
	public static final String EU_BREATH_B= "Eu_breath_b";
	public static final String EU_HEARTBEAT_B= "Eu_heartbeat_b";
	public static final String EU_MUSCLE_B= "Eu_muscle_b";
	public static final String EU_REFLECTION_B= "Eu_reflection_b";
	public static final String ID_UMBILICALCORD_PART_B= "Id_umbilicalcord_part_b";
	public static final String SD_UMBILICALCORD_PART_B= "Sd_umbilicalcord_part_b";
	public static final String NUM_UMBILICALCORD_PART_B= "Num_umbilicalcord_part_b";
	public static final String ID_UMBILICALCORD_LIGATION_B= "Id_umbilicalcord_ligation_b";
	public static final String SD_UMBILICALCORD_LIGATION_B= "Sd_umbilicalcord_ligation_b";
	public static final String ID_EYES_HANDLE_B= "Id_eyes_handle_b";
	public static final String SD_EYES_HANDLE_B= "Sd_eyes_handle_b";
	public static final String LENGTH_UMBILICALCORD_B= "Length_umbilicalcord_b";
	public static final String DES_UNUSUAL_B= "Des_unusual_b";
	public static final String ID_PLACENTA_STATUS= "Id_placenta_status";
	public static final String SD_PLACENTA_STATUS= "Sd_placenta_status";
	public static final String ID_MEMBRANES_STATUS= "Id_membranes_status";
	public static final String SD_MEMBRANES_STATUS= "Sd_membranes_status";
	public static final String MEMBRANES_RUPTURE= "Membranes_rupture";
	public static final String LENGTH_PLA= "Length_pla";
	public static final String WIDTH_PLA= "Width_pla";
	public static final String HEIGHT_PLA= "Height_pla";
	public static final String ID_PERINEUM_CUT= "Id_perineum_cut";
	public static final String SD_PERINEUM_CUT= "Sd_perineum_cut";
	public static final String ID_CHILDBIRTH_NARCOSIS_TYPE= "Id_childbirth_narcosis_type";
	public static final String SD_CHILDBIRTH_NARCOSIS_TYPE= "Sd_childbirth_narcosis_type";
	public static final String ID_CHILDBIRTH_NARCOSIS_DRUG= "Id_childbirth_narcosis_drug";
	public static final String SD_CHILDBIRTH_NARCOSIS_DRUG= "Sd_childbirth_narcosis_drug";
	public static final String NUM_DRUG_LEFT= "Num_drug_left";
	public static final String NUM_DRUG_RIGHT= "Num_drug_right";
	public static final String INDICATIONS= "Indications";
	public static final String ID_SUTURE_TYPE= "Id_suture_type";
	public static final String SD_SUTURE_TYPE= "Sd_suture_type";
	public static final String ID_CHILDBIRTH_OPERATION= "Id_childbirth_operation";
	public static final String SD_CHILDBIRTH_OPERATION= "Sd_childbirth_operation";
	public static final String INDICATIONS_OPER= "Indications_oper";
	public static final String SPECIAL_CASE= "Special_case";
	public static final String DIAGNOSIS= "Diagnosis";
	public static final String ID_EMP_DELIVERING= "Id_emp_delivering";
	public static final String ID_DEP_SUTURE= "Id_dep_suture";
	public static final String ID_DEP_ASSIST= "Id_dep_assist";
	public static final String ID_DEP_COUNTING= "Id_dep_counting";
	public static final String ID_DEP_RECORD= "Id_dep_record";
	public static final String ID_GROUP= "Id_group";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String DT_BIRTH_PAT= "Dt_birth_pat";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_DEP= "Name_dep";
	public static final String NAME_BITHTP_A= "Name_bithtp_a";
	public static final String NAME_PROTP_A= "Name_protp_a";
	public static final String NAME_BIRTHTP_B= "Name_birthtp_b";
	public static final String NAME_PROPTP_B= "Name_proptp_b";
	public static final String NAME_PLACENTA_BIRTHTP= "Name_placenta_birthtp";
	public static final String NAME_PLACENTA_STRIPPING= "Name_placenta_stripping";
	public static final String NAME_AMNIOTIC_FLUID_CHAR= "Name_amniotic_fluid_char";
	public static final String NAME_PERINEUM_STATUS= "Name_perineum_status";
	public static final String NAME_PERINEUM_SERIOUS= "Name_perineum_serious";
	public static final String NAME_BLOODMEASURE= "Name_bloodmeasure";
	public static final String NAME_DRUG_AFTERBIRTH= "Name_drug_afterbirth";
	public static final String NAME_SEX_A= "Name_sex_a";
	public static final String NAME_CHILD_BIRTH_A= "Name_child_birth_a";
	public static final String NAME_ASPHYXIA_A= "Name_asphyxia_a";
	public static final String NAME_UMBILICALCORD_PART_A= "Name_umbilicalcord_part_a";
	public static final String NAME_UMBILICALCORD_LIGATION_A= "Name_umbilicalcord_ligation_a";
	public static final String NAME_EYES_HANDLE_A= "Name_eyes_handle_a";
	public static final String NAME_SEX_B= "Name_sex_b";
	public static final String NAME_CHILD_BIRTH_B= "Name_child_birth_b";
	public static final String NAME_ASPHYXIA_B= "Name_asphyxia_b";
	public static final String NAME_UMBILICALCORD_PART_B= "Name_umbilicalcord_part_b";
	public static final String NAME_UMBILICALCORD_LIGATION_B= "Name_umbilicalcord_ligation_b";
	public static final String NAM_EYES_HANDLE_B= "Nam_eyes_handle_b";
	public static final String NAME_PLACENTA_STATUS= "Name_placenta_status";
	public static final String NAME_MEMBRANES_STATUS= "Name_membranes_status";
	public static final String NAME_PERINEUM_CUT= "Name_perineum_cut";
	public static final String NAME_CHILDBIRTH_NARCOSIS_TYPE= "Name_childbirth_narcosis_type";
	public static final String NAME_NARCOSIS_DRUG= "Name_narcosis_drug";
	public static final String NAME_SUTURE_TYPE= "Name_suture_type";
	public static final String NAME_CHILDBIRTH_OPERATION= "Name_childbirth_operation";
	public static final String NAME_DELIVERING= "Name_delivering";
	public static final String NAME_SUTURE= "Name_suture";
	public static final String NAME_ASSIST= "Name_assist";
	public static final String NAME_COUNTING= "Name_counting";
	public static final String NAME_MRRECORD= "Name_mrrecord";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_childbirth() {
		return ((String) getAttrVal("Id_childbirth"));
	}	
	public void setId_childbirth(String Id_childbirth) {
		setAttrVal("Id_childbirth", Id_childbirth);
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
	public FDateTime getDt_zsks() {
		return ((FDateTime) getAttrVal("Dt_zsks"));
	}	
	public void setDt_zsks(FDateTime Dt_zsks) {
		setAttrVal("Dt_zsks", Dt_zsks);
	}
	public FDateTime getDt_tmpl() {
		return ((FDateTime) getAttrVal("Dt_tmpl"));
	}	
	public void setDt_tmpl(FDateTime Dt_tmpl) {
		setAttrVal("Dt_tmpl", Dt_tmpl);
	}
	public FDateTime getDt_gkqk() {
		return ((FDateTime) getAttrVal("Dt_gkqk"));
	}	
	public void setDt_gkqk(FDateTime Dt_gkqk) {
		setAttrVal("Dt_gkqk", Dt_gkqk);
	}
	public FDateTime getDt_first() {
		return ((FDateTime) getAttrVal("Dt_first"));
	}	
	public void setDt_first(FDateTime Dt_first) {
		setAttrVal("Dt_first", Dt_first);
	}
	public String getId_first_cbtp() {
		return ((String) getAttrVal("Id_first_cbtp"));
	}	
	public void setId_first_cbtp(String Id_first_cbtp) {
		setAttrVal("Id_first_cbtp", Id_first_cbtp);
	}
	public String getSd_first_cbtp() {
		return ((String) getAttrVal("Sd_first_cbtp"));
	}	
	public void setSd_first_cbtp(String Sd_first_cbtp) {
		setAttrVal("Sd_first_cbtp", Sd_first_cbtp);
	}
	public String getId_first_protp() {
		return ((String) getAttrVal("Id_first_protp"));
	}	
	public void setId_first_protp(String Id_first_protp) {
		setAttrVal("Id_first_protp", Id_first_protp);
	}
	public String getSd_first_protp() {
		return ((String) getAttrVal("Sd_first_protp"));
	}	
	public void setSd_first_protp(String Sd_first_protp) {
		setAttrVal("Sd_first_protp", Sd_first_protp);
	}
	public FDateTime getDt_second() {
		return ((FDateTime) getAttrVal("Dt_second"));
	}	
	public void setDt_second(FDateTime Dt_second) {
		setAttrVal("Dt_second", Dt_second);
	}
	public String getId_second_cbtp() {
		return ((String) getAttrVal("Id_second_cbtp"));
	}	
	public void setId_second_cbtp(String Id_second_cbtp) {
		setAttrVal("Id_second_cbtp", Id_second_cbtp);
	}
	public String getSd_second_cbtp() {
		return ((String) getAttrVal("Sd_second_cbtp"));
	}	
	public void setSd_second_cbtp(String Sd_second_cbtp) {
		setAttrVal("Sd_second_cbtp", Sd_second_cbtp);
	}
	public String getId_second_protp() {
		return ((String) getAttrVal("Id_second_protp"));
	}	
	public void setId_second_protp(String Id_second_protp) {
		setAttrVal("Id_second_protp", Id_second_protp);
	}
	public String getSd_second_protp() {
		return ((String) getAttrVal("Sd_second_protp"));
	}	
	public void setSd_second_protp(String Sd_second_protp) {
		setAttrVal("Sd_second_protp", Sd_second_protp);
	}
	public FDateTime getDt_placenta_birth() {
		return ((FDateTime) getAttrVal("Dt_placenta_birth"));
	}	
	public void setDt_placenta_birth(FDateTime Dt_placenta_birth) {
		setAttrVal("Dt_placenta_birth", Dt_placenta_birth);
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
	public String getId_placenta_stripping() {
		return ((String) getAttrVal("Id_placenta_stripping"));
	}	
	public void setId_placenta_stripping(String Id_placenta_stripping) {
		setAttrVal("Id_placenta_stripping", Id_placenta_stripping);
	}
	public String getSd_placenta_stripping() {
		return ((String) getAttrVal("Sd_placenta_stripping"));
	}	
	public void setSd_placenta_stripping(String Sd_placenta_stripping) {
		setAttrVal("Sd_placenta_stripping", Sd_placenta_stripping);
	}
	public FDouble getNum_amniotic_fluid() {
		return ((FDouble) getAttrVal("Num_amniotic_fluid"));
	}	
	public void setNum_amniotic_fluid(FDouble Num_amniotic_fluid) {
		setAttrVal("Num_amniotic_fluid", Num_amniotic_fluid);
	}
	public String getId_amniotic_fluid_char() {
		return ((String) getAttrVal("Id_amniotic_fluid_char"));
	}	
	public void setId_amniotic_fluid_char(String Id_amniotic_fluid_char) {
		setAttrVal("Id_amniotic_fluid_char", Id_amniotic_fluid_char);
	}
	public String getSd_amniotic_fluid_char() {
		return ((String) getAttrVal("Sd_amniotic_fluid_char"));
	}	
	public void setSd_amniotic_fluid_char(String Sd_amniotic_fluid_char) {
		setAttrVal("Sd_amniotic_fluid_char", Sd_amniotic_fluid_char);
	}
	public Integer getNum_uterus_height() {
		return ((Integer) getAttrVal("Num_uterus_height"));
	}	
	public void setNum_uterus_height(Integer Num_uterus_height) {
		setAttrVal("Num_uterus_height", Num_uterus_height);
	}
	public String getId_perineum_status() {
		return ((String) getAttrVal("Id_perineum_status"));
	}	
	public void setId_perineum_status(String Id_perineum_status) {
		setAttrVal("Id_perineum_status", Id_perineum_status);
	}
	public String getSd_perineum_status() {
		return ((String) getAttrVal("Sd_perineum_status"));
	}	
	public void setSd_perineum_status(String Sd_perineum_status) {
		setAttrVal("Sd_perineum_status", Sd_perineum_status);
	}
	public String getId_perineum_serious() {
		return ((String) getAttrVal("Id_perineum_serious"));
	}	
	public void setId_perineum_serious(String Id_perineum_serious) {
		setAttrVal("Id_perineum_serious", Id_perineum_serious);
	}
	public String getSd_perineum_serious() {
		return ((String) getAttrVal("Sd_perineum_serious"));
	}	
	public void setSd_perineum_serious(String Sd_perineum_serious) {
		setAttrVal("Sd_perineum_serious", Sd_perineum_serious);
	}
	public Integer getEu_vaginal_injury() {
		return ((Integer) getAttrVal("Eu_vaginal_injury"));
	}	
	public void setEu_vaginal_injury(Integer Eu_vaginal_injury) {
		setAttrVal("Eu_vaginal_injury", Eu_vaginal_injury);
	}
	public Integer getEu_cervical_injury() {
		return ((Integer) getAttrVal("Eu_cervical_injury"));
	}	
	public void setEu_cervical_injury(Integer Eu_cervical_injury) {
		setAttrVal("Eu_cervical_injury", Eu_cervical_injury);
	}
	public String getId_bloodmeasure() {
		return ((String) getAttrVal("Id_bloodmeasure"));
	}	
	public void setId_bloodmeasure(String Id_bloodmeasure) {
		setAttrVal("Id_bloodmeasure", Id_bloodmeasure);
	}
	public String getSd_bloodmeasure() {
		return ((String) getAttrVal("Sd_bloodmeasure"));
	}	
	public void setSd_bloodmeasure(String Sd_bloodmeasure) {
		setAttrVal("Sd_bloodmeasure", Sd_bloodmeasure);
	}
	public Integer getNum_blood_afterbirth() {
		return ((Integer) getAttrVal("Num_blood_afterbirth"));
	}	
	public void setNum_blood_afterbirth(Integer Num_blood_afterbirth) {
		setAttrVal("Num_blood_afterbirth", Num_blood_afterbirth);
	}
	public Integer getNum_forthlabor_blood() {
		return ((Integer) getAttrVal("Num_forthlabor_blood"));
	}	
	public void setNum_forthlabor_blood(Integer Num_forthlabor_blood) {
		setAttrVal("Num_forthlabor_blood", Num_forthlabor_blood);
	}
	public String getId_drug_afterbirth() {
		return ((String) getAttrVal("Id_drug_afterbirth"));
	}	
	public void setId_drug_afterbirth(String Id_drug_afterbirth) {
		setAttrVal("Id_drug_afterbirth", Id_drug_afterbirth);
	}
	public String getSd_drug_afterbirth() {
		return ((String) getAttrVal("Sd_drug_afterbirth"));
	}	
	public void setSd_drug_afterbirth(String Sd_drug_afterbirth) {
		setAttrVal("Sd_drug_afterbirth", Sd_drug_afterbirth);
	}
	public String getLabor_first() {
		return ((String) getAttrVal("Labor_first"));
	}	
	public void setLabor_first(String Labor_first) {
		setAttrVal("Labor_first", Labor_first);
	}
	public String getLabor_second() {
		return ((String) getAttrVal("Labor_second"));
	}	
	public void setLabor_second(String Labor_second) {
		setAttrVal("Labor_second", Labor_second);
	}
	public String getLabor_third() {
		return ((String) getAttrVal("Labor_third"));
	}	
	public void setLabor_third(String Labor_third) {
		setAttrVal("Labor_third", Labor_third);
	}
	public String getLabor_total() {
		return ((String) getAttrVal("Labor_total"));
	}	
	public void setLabor_total(String Labor_total) {
		setAttrVal("Labor_total", Labor_total);
	}
	public String getId_sex_a() {
		return ((String) getAttrVal("Id_sex_a"));
	}	
	public void setId_sex_a(String Id_sex_a) {
		setAttrVal("Id_sex_a", Id_sex_a);
	}
	public String getSd_sex_a() {
		return ((String) getAttrVal("Sd_sex_a"));
	}	
	public void setSd_sex_a(String Sd_sex_a) {
		setAttrVal("Sd_sex_a", Sd_sex_a);
	}
	public Integer getWeigth_a() {
		return ((Integer) getAttrVal("Weigth_a"));
	}	
	public void setWeigth_a(Integer Weigth_a) {
		setAttrVal("Weigth_a", Weigth_a);
	}
	public Integer getHeight_a() {
		return ((Integer) getAttrVal("Height_a"));
	}	
	public void setHeight_a(Integer Height_a) {
		setAttrVal("Height_a", Height_a);
	}
	public String getId_child_birth_a() {
		return ((String) getAttrVal("Id_child_birth_a"));
	}	
	public void setId_child_birth_a(String Id_child_birth_a) {
		setAttrVal("Id_child_birth_a", Id_child_birth_a);
	}
	public String getSd_child_birth_a() {
		return ((String) getAttrVal("Sd_child_birth_a"));
	}	
	public void setSd_child_birth_a(String Sd_child_birth_a) {
		setAttrVal("Sd_child_birth_a", Sd_child_birth_a);
	}
	public String getId_asphyxia_a() {
		return ((String) getAttrVal("Id_asphyxia_a"));
	}	
	public void setId_asphyxia_a(String Id_asphyxia_a) {
		setAttrVal("Id_asphyxia_a", Id_asphyxia_a);
	}
	public String getSd_asphyxia_a() {
		return ((String) getAttrVal("Sd_asphyxia_a"));
	}	
	public void setSd_asphyxia_a(String Sd_asphyxia_a) {
		setAttrVal("Sd_asphyxia_a", Sd_asphyxia_a);
	}
	public Integer getNum_apgar_one_a() {
		return ((Integer) getAttrVal("Num_apgar_one_a"));
	}	
	public void setNum_apgar_one_a(Integer Num_apgar_one_a) {
		setAttrVal("Num_apgar_one_a", Num_apgar_one_a);
	}
	public Integer getNum_apgar_five_a() {
		return ((Integer) getAttrVal("Num_apgar_five_a"));
	}	
	public void setNum_apgar_five_a(Integer Num_apgar_five_a) {
		setAttrVal("Num_apgar_five_a", Num_apgar_five_a);
	}
	public Integer getNum_apgar_ten_a() {
		return ((Integer) getAttrVal("Num_apgar_ten_a"));
	}	
	public void setNum_apgar_ten_a(Integer Num_apgar_ten_a) {
		setAttrVal("Num_apgar_ten_a", Num_apgar_ten_a);
	}
	public Integer getEu_skin_a() {
		return ((Integer) getAttrVal("Eu_skin_a"));
	}	
	public void setEu_skin_a(Integer Eu_skin_a) {
		setAttrVal("Eu_skin_a", Eu_skin_a);
	}
	public Integer getEu_breath_a() {
		return ((Integer) getAttrVal("Eu_breath_a"));
	}	
	public void setEu_breath_a(Integer Eu_breath_a) {
		setAttrVal("Eu_breath_a", Eu_breath_a);
	}
	public Integer getEu_heartbeat_a() {
		return ((Integer) getAttrVal("Eu_heartbeat_a"));
	}	
	public void setEu_heartbeat_a(Integer Eu_heartbeat_a) {
		setAttrVal("Eu_heartbeat_a", Eu_heartbeat_a);
	}
	public Integer getEu_muscle_a() {
		return ((Integer) getAttrVal("Eu_muscle_a"));
	}	
	public void setEu_muscle_a(Integer Eu_muscle_a) {
		setAttrVal("Eu_muscle_a", Eu_muscle_a);
	}
	public Integer getEu_reflection_a() {
		return ((Integer) getAttrVal("Eu_reflection_a"));
	}	
	public void setEu_reflection_a(Integer Eu_reflection_a) {
		setAttrVal("Eu_reflection_a", Eu_reflection_a);
	}
	public String getId_umbilicalcord_part_a() {
		return ((String) getAttrVal("Id_umbilicalcord_part_a"));
	}	
	public void setId_umbilicalcord_part_a(String Id_umbilicalcord_part_a) {
		setAttrVal("Id_umbilicalcord_part_a", Id_umbilicalcord_part_a);
	}
	public String getSd_umbilicalcord_part_a() {
		return ((String) getAttrVal("Sd_umbilicalcord_part_a"));
	}	
	public void setSd_umbilicalcord_part_a(String Sd_umbilicalcord_part_a) {
		setAttrVal("Sd_umbilicalcord_part_a", Sd_umbilicalcord_part_a);
	}
	public Integer getNum_umbilicalcord_part_a() {
		return ((Integer) getAttrVal("Num_umbilicalcord_part_a"));
	}	
	public void setNum_umbilicalcord_part_a(Integer Num_umbilicalcord_part_a) {
		setAttrVal("Num_umbilicalcord_part_a", Num_umbilicalcord_part_a);
	}
	public String getId_umbilicalcord_ligation_a() {
		return ((String) getAttrVal("Id_umbilicalcord_ligation_a"));
	}	
	public void setId_umbilicalcord_ligation_a(String Id_umbilicalcord_ligation_a) {
		setAttrVal("Id_umbilicalcord_ligation_a", Id_umbilicalcord_ligation_a);
	}
	public String getSd_umbilicalcord_ligation_a() {
		return ((String) getAttrVal("Sd_umbilicalcord_ligation_a"));
	}	
	public void setSd_umbilicalcord_ligation_a(String Sd_umbilicalcord_ligation_a) {
		setAttrVal("Sd_umbilicalcord_ligation_a", Sd_umbilicalcord_ligation_a);
	}
	public String getId_eyes_handle_a() {
		return ((String) getAttrVal("Id_eyes_handle_a"));
	}	
	public void setId_eyes_handle_a(String Id_eyes_handle_a) {
		setAttrVal("Id_eyes_handle_a", Id_eyes_handle_a);
	}
	public String getSd_eyes_handle_a() {
		return ((String) getAttrVal("Sd_eyes_handle_a"));
	}	
	public void setSd_eyes_handle_a(String Sd_eyes_handle_a) {
		setAttrVal("Sd_eyes_handle_a", Sd_eyes_handle_a);
	}
	public Integer getLength_umbilicalcord_a() {
		return ((Integer) getAttrVal("Length_umbilicalcord_a"));
	}	
	public void setLength_umbilicalcord_a(Integer Length_umbilicalcord_a) {
		setAttrVal("Length_umbilicalcord_a", Length_umbilicalcord_a);
	}
	public String getDes_unusual_a() {
		return ((String) getAttrVal("Des_unusual_a"));
	}	
	public void setDes_unusual_a(String Des_unusual_a) {
		setAttrVal("Des_unusual_a", Des_unusual_a);
	}
	public String getId_sex_b() {
		return ((String) getAttrVal("Id_sex_b"));
	}	
	public void setId_sex_b(String Id_sex_b) {
		setAttrVal("Id_sex_b", Id_sex_b);
	}
	public String getSd_sex_b() {
		return ((String) getAttrVal("Sd_sex_b"));
	}	
	public void setSd_sex_b(String Sd_sex_b) {
		setAttrVal("Sd_sex_b", Sd_sex_b);
	}
	public FDouble getWeigth_b() {
		return ((FDouble) getAttrVal("Weigth_b"));
	}	
	public void setWeigth_b(FDouble Weigth_b) {
		setAttrVal("Weigth_b", Weigth_b);
	}
	public FDouble getHeight_b() {
		return ((FDouble) getAttrVal("Height_b"));
	}	
	public void setHeight_b(FDouble Height_b) {
		setAttrVal("Height_b", Height_b);
	}
	public String getId_child_birth_b() {
		return ((String) getAttrVal("Id_child_birth_b"));
	}	
	public void setId_child_birth_b(String Id_child_birth_b) {
		setAttrVal("Id_child_birth_b", Id_child_birth_b);
	}
	public String getSd_child_birth_b() {
		return ((String) getAttrVal("Sd_child_birth_b"));
	}	
	public void setSd_child_birth_b(String Sd_child_birth_b) {
		setAttrVal("Sd_child_birth_b", Sd_child_birth_b);
	}
	public String getId_asphyxia_b() {
		return ((String) getAttrVal("Id_asphyxia_b"));
	}	
	public void setId_asphyxia_b(String Id_asphyxia_b) {
		setAttrVal("Id_asphyxia_b", Id_asphyxia_b);
	}
	public String getSd_asphyxia_b() {
		return ((String) getAttrVal("Sd_asphyxia_b"));
	}	
	public void setSd_asphyxia_b(String Sd_asphyxia_b) {
		setAttrVal("Sd_asphyxia_b", Sd_asphyxia_b);
	}
	public Integer getNum_apgar_one_b() {
		return ((Integer) getAttrVal("Num_apgar_one_b"));
	}	
	public void setNum_apgar_one_b(Integer Num_apgar_one_b) {
		setAttrVal("Num_apgar_one_b", Num_apgar_one_b);
	}
	public Integer getNum_apgar_five_b() {
		return ((Integer) getAttrVal("Num_apgar_five_b"));
	}	
	public void setNum_apgar_five_b(Integer Num_apgar_five_b) {
		setAttrVal("Num_apgar_five_b", Num_apgar_five_b);
	}
	public Integer getNum_apgar_ten_b() {
		return ((Integer) getAttrVal("Num_apgar_ten_b"));
	}	
	public void setNum_apgar_ten_b(Integer Num_apgar_ten_b) {
		setAttrVal("Num_apgar_ten_b", Num_apgar_ten_b);
	}
	public Integer getEu_skin_b() {
		return ((Integer) getAttrVal("Eu_skin_b"));
	}	
	public void setEu_skin_b(Integer Eu_skin_b) {
		setAttrVal("Eu_skin_b", Eu_skin_b);
	}
	public Integer getEu_breath_b() {
		return ((Integer) getAttrVal("Eu_breath_b"));
	}	
	public void setEu_breath_b(Integer Eu_breath_b) {
		setAttrVal("Eu_breath_b", Eu_breath_b);
	}
	public Integer getEu_heartbeat_b() {
		return ((Integer) getAttrVal("Eu_heartbeat_b"));
	}	
	public void setEu_heartbeat_b(Integer Eu_heartbeat_b) {
		setAttrVal("Eu_heartbeat_b", Eu_heartbeat_b);
	}
	public Integer getEu_muscle_b() {
		return ((Integer) getAttrVal("Eu_muscle_b"));
	}	
	public void setEu_muscle_b(Integer Eu_muscle_b) {
		setAttrVal("Eu_muscle_b", Eu_muscle_b);
	}
	public Integer getEu_reflection_b() {
		return ((Integer) getAttrVal("Eu_reflection_b"));
	}	
	public void setEu_reflection_b(Integer Eu_reflection_b) {
		setAttrVal("Eu_reflection_b", Eu_reflection_b);
	}
	public String getId_umbilicalcord_part_b() {
		return ((String) getAttrVal("Id_umbilicalcord_part_b"));
	}	
	public void setId_umbilicalcord_part_b(String Id_umbilicalcord_part_b) {
		setAttrVal("Id_umbilicalcord_part_b", Id_umbilicalcord_part_b);
	}
	public String getSd_umbilicalcord_part_b() {
		return ((String) getAttrVal("Sd_umbilicalcord_part_b"));
	}	
	public void setSd_umbilicalcord_part_b(String Sd_umbilicalcord_part_b) {
		setAttrVal("Sd_umbilicalcord_part_b", Sd_umbilicalcord_part_b);
	}
	public Integer getNum_umbilicalcord_part_b() {
		return ((Integer) getAttrVal("Num_umbilicalcord_part_b"));
	}	
	public void setNum_umbilicalcord_part_b(Integer Num_umbilicalcord_part_b) {
		setAttrVal("Num_umbilicalcord_part_b", Num_umbilicalcord_part_b);
	}
	public String getId_umbilicalcord_ligation_b() {
		return ((String) getAttrVal("Id_umbilicalcord_ligation_b"));
	}	
	public void setId_umbilicalcord_ligation_b(String Id_umbilicalcord_ligation_b) {
		setAttrVal("Id_umbilicalcord_ligation_b", Id_umbilicalcord_ligation_b);
	}
	public String getSd_umbilicalcord_ligation_b() {
		return ((String) getAttrVal("Sd_umbilicalcord_ligation_b"));
	}	
	public void setSd_umbilicalcord_ligation_b(String Sd_umbilicalcord_ligation_b) {
		setAttrVal("Sd_umbilicalcord_ligation_b", Sd_umbilicalcord_ligation_b);
	}
	public String getId_eyes_handle_b() {
		return ((String) getAttrVal("Id_eyes_handle_b"));
	}	
	public void setId_eyes_handle_b(String Id_eyes_handle_b) {
		setAttrVal("Id_eyes_handle_b", Id_eyes_handle_b);
	}
	public String getSd_eyes_handle_b() {
		return ((String) getAttrVal("Sd_eyes_handle_b"));
	}	
	public void setSd_eyes_handle_b(String Sd_eyes_handle_b) {
		setAttrVal("Sd_eyes_handle_b", Sd_eyes_handle_b);
	}
	public Integer getLength_umbilicalcord_b() {
		return ((Integer) getAttrVal("Length_umbilicalcord_b"));
	}	
	public void setLength_umbilicalcord_b(Integer Length_umbilicalcord_b) {
		setAttrVal("Length_umbilicalcord_b", Length_umbilicalcord_b);
	}
	public String getDes_unusual_b() {
		return ((String) getAttrVal("Des_unusual_b"));
	}	
	public void setDes_unusual_b(String Des_unusual_b) {
		setAttrVal("Des_unusual_b", Des_unusual_b);
	}
	public String getId_placenta_status() {
		return ((String) getAttrVal("Id_placenta_status"));
	}	
	public void setId_placenta_status(String Id_placenta_status) {
		setAttrVal("Id_placenta_status", Id_placenta_status);
	}
	public String getSd_placenta_status() {
		return ((String) getAttrVal("Sd_placenta_status"));
	}	
	public void setSd_placenta_status(String Sd_placenta_status) {
		setAttrVal("Sd_placenta_status", Sd_placenta_status);
	}
	public String getId_membranes_status() {
		return ((String) getAttrVal("Id_membranes_status"));
	}	
	public void setId_membranes_status(String Id_membranes_status) {
		setAttrVal("Id_membranes_status", Id_membranes_status);
	}
	public String getSd_membranes_status() {
		return ((String) getAttrVal("Sd_membranes_status"));
	}	
	public void setSd_membranes_status(String Sd_membranes_status) {
		setAttrVal("Sd_membranes_status", Sd_membranes_status);
	}
	public String getMembranes_rupture() {
		return ((String) getAttrVal("Membranes_rupture"));
	}	
	public void setMembranes_rupture(String Membranes_rupture) {
		setAttrVal("Membranes_rupture", Membranes_rupture);
	}
	public Integer getLength_pla() {
		return ((Integer) getAttrVal("Length_pla"));
	}	
	public void setLength_pla(Integer Length_pla) {
		setAttrVal("Length_pla", Length_pla);
	}
	public Integer getWidth_pla() {
		return ((Integer) getAttrVal("Width_pla"));
	}	
	public void setWidth_pla(Integer Width_pla) {
		setAttrVal("Width_pla", Width_pla);
	}
	public Integer getHeight_pla() {
		return ((Integer) getAttrVal("Height_pla"));
	}	
	public void setHeight_pla(Integer Height_pla) {
		setAttrVal("Height_pla", Height_pla);
	}
	public String getId_perineum_cut() {
		return ((String) getAttrVal("Id_perineum_cut"));
	}	
	public void setId_perineum_cut(String Id_perineum_cut) {
		setAttrVal("Id_perineum_cut", Id_perineum_cut);
	}
	public String getSd_perineum_cut() {
		return ((String) getAttrVal("Sd_perineum_cut"));
	}	
	public void setSd_perineum_cut(String Sd_perineum_cut) {
		setAttrVal("Sd_perineum_cut", Sd_perineum_cut);
	}
	public String getId_childbirth_narcosis_type() {
		return ((String) getAttrVal("Id_childbirth_narcosis_type"));
	}	
	public void setId_childbirth_narcosis_type(String Id_childbirth_narcosis_type) {
		setAttrVal("Id_childbirth_narcosis_type", Id_childbirth_narcosis_type);
	}
	public String getSd_childbirth_narcosis_type() {
		return ((String) getAttrVal("Sd_childbirth_narcosis_type"));
	}	
	public void setSd_childbirth_narcosis_type(String Sd_childbirth_narcosis_type) {
		setAttrVal("Sd_childbirth_narcosis_type", Sd_childbirth_narcosis_type);
	}
	public String getId_childbirth_narcosis_drug() {
		return ((String) getAttrVal("Id_childbirth_narcosis_drug"));
	}	
	public void setId_childbirth_narcosis_drug(String Id_childbirth_narcosis_drug) {
		setAttrVal("Id_childbirth_narcosis_drug", Id_childbirth_narcosis_drug);
	}
	public String getSd_childbirth_narcosis_drug() {
		return ((String) getAttrVal("Sd_childbirth_narcosis_drug"));
	}	
	public void setSd_childbirth_narcosis_drug(String Sd_childbirth_narcosis_drug) {
		setAttrVal("Sd_childbirth_narcosis_drug", Sd_childbirth_narcosis_drug);
	}
	public Integer getNum_drug_left() {
		return ((Integer) getAttrVal("Num_drug_left"));
	}	
	public void setNum_drug_left(Integer Num_drug_left) {
		setAttrVal("Num_drug_left", Num_drug_left);
	}
	public Integer getNum_drug_right() {
		return ((Integer) getAttrVal("Num_drug_right"));
	}	
	public void setNum_drug_right(Integer Num_drug_right) {
		setAttrVal("Num_drug_right", Num_drug_right);
	}
	public String getIndications() {
		return ((String) getAttrVal("Indications"));
	}	
	public void setIndications(String Indications) {
		setAttrVal("Indications", Indications);
	}
	public String getId_suture_type() {
		return ((String) getAttrVal("Id_suture_type"));
	}	
	public void setId_suture_type(String Id_suture_type) {
		setAttrVal("Id_suture_type", Id_suture_type);
	}
	public String getSd_suture_type() {
		return ((String) getAttrVal("Sd_suture_type"));
	}	
	public void setSd_suture_type(String Sd_suture_type) {
		setAttrVal("Sd_suture_type", Sd_suture_type);
	}
	public String getId_childbirth_operation() {
		return ((String) getAttrVal("Id_childbirth_operation"));
	}	
	public void setId_childbirth_operation(String Id_childbirth_operation) {
		setAttrVal("Id_childbirth_operation", Id_childbirth_operation);
	}
	public String getSd_childbirth_operation() {
		return ((String) getAttrVal("Sd_childbirth_operation"));
	}	
	public void setSd_childbirth_operation(String Sd_childbirth_operation) {
		setAttrVal("Sd_childbirth_operation", Sd_childbirth_operation);
	}
	public String getIndications_oper() {
		return ((String) getAttrVal("Indications_oper"));
	}	
	public void setIndications_oper(String Indications_oper) {
		setAttrVal("Indications_oper", Indications_oper);
	}
	public String getSpecial_case() {
		return ((String) getAttrVal("Special_case"));
	}	
	public void setSpecial_case(String Special_case) {
		setAttrVal("Special_case", Special_case);
	}
	public String getDiagnosis() {
		return ((String) getAttrVal("Diagnosis"));
	}	
	public void setDiagnosis(String Diagnosis) {
		setAttrVal("Diagnosis", Diagnosis);
	}
	public String getId_emp_delivering() {
		return ((String) getAttrVal("Id_emp_delivering"));
	}	
	public void setId_emp_delivering(String Id_emp_delivering) {
		setAttrVal("Id_emp_delivering", Id_emp_delivering);
	}
	public String getId_dep_suture() {
		return ((String) getAttrVal("Id_dep_suture"));
	}	
	public void setId_dep_suture(String Id_dep_suture) {
		setAttrVal("Id_dep_suture", Id_dep_suture);
	}
	public String getId_dep_assist() {
		return ((String) getAttrVal("Id_dep_assist"));
	}	
	public void setId_dep_assist(String Id_dep_assist) {
		setAttrVal("Id_dep_assist", Id_dep_assist);
	}
	public String getId_dep_counting() {
		return ((String) getAttrVal("Id_dep_counting"));
	}	
	public void setId_dep_counting(String Id_dep_counting) {
		setAttrVal("Id_dep_counting", Id_dep_counting);
	}
	public String getId_dep_record() {
		return ((String) getAttrVal("Id_dep_record"));
	}	
	public void setId_dep_record(String Id_dep_record) {
		setAttrVal("Id_dep_record", Id_dep_record);
	}
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}	
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getName_bithtp_a() {
		return ((String) getAttrVal("Name_bithtp_a"));
	}	
	public void setName_bithtp_a(String Name_bithtp_a) {
		setAttrVal("Name_bithtp_a", Name_bithtp_a);
	}
	public String getName_protp_a() {
		return ((String) getAttrVal("Name_protp_a"));
	}	
	public void setName_protp_a(String Name_protp_a) {
		setAttrVal("Name_protp_a", Name_protp_a);
	}
	public String getName_birthtp_b() {
		return ((String) getAttrVal("Name_birthtp_b"));
	}	
	public void setName_birthtp_b(String Name_birthtp_b) {
		setAttrVal("Name_birthtp_b", Name_birthtp_b);
	}
	public String getName_proptp_b() {
		return ((String) getAttrVal("Name_proptp_b"));
	}	
	public void setName_proptp_b(String Name_proptp_b) {
		setAttrVal("Name_proptp_b", Name_proptp_b);
	}
	public String getName_placenta_birthtp() {
		return ((String) getAttrVal("Name_placenta_birthtp"));
	}	
	public void setName_placenta_birthtp(String Name_placenta_birthtp) {
		setAttrVal("Name_placenta_birthtp", Name_placenta_birthtp);
	}
	public String getName_placenta_stripping() {
		return ((String) getAttrVal("Name_placenta_stripping"));
	}	
	public void setName_placenta_stripping(String Name_placenta_stripping) {
		setAttrVal("Name_placenta_stripping", Name_placenta_stripping);
	}
	public String getName_amniotic_fluid_char() {
		return ((String) getAttrVal("Name_amniotic_fluid_char"));
	}	
	public void setName_amniotic_fluid_char(String Name_amniotic_fluid_char) {
		setAttrVal("Name_amniotic_fluid_char", Name_amniotic_fluid_char);
	}
	public String getName_perineum_status() {
		return ((String) getAttrVal("Name_perineum_status"));
	}	
	public void setName_perineum_status(String Name_perineum_status) {
		setAttrVal("Name_perineum_status", Name_perineum_status);
	}
	public String getName_perineum_serious() {
		return ((String) getAttrVal("Name_perineum_serious"));
	}	
	public void setName_perineum_serious(String Name_perineum_serious) {
		setAttrVal("Name_perineum_serious", Name_perineum_serious);
	}
	public String getName_bloodmeasure() {
		return ((String) getAttrVal("Name_bloodmeasure"));
	}	
	public void setName_bloodmeasure(String Name_bloodmeasure) {
		setAttrVal("Name_bloodmeasure", Name_bloodmeasure);
	}
	public String getName_drug_afterbirth() {
		return ((String) getAttrVal("Name_drug_afterbirth"));
	}	
	public void setName_drug_afterbirth(String Name_drug_afterbirth) {
		setAttrVal("Name_drug_afterbirth", Name_drug_afterbirth);
	}
	public String getName_sex_a() {
		return ((String) getAttrVal("Name_sex_a"));
	}	
	public void setName_sex_a(String Name_sex_a) {
		setAttrVal("Name_sex_a", Name_sex_a);
	}
	public String getName_child_birth_a() {
		return ((String) getAttrVal("Name_child_birth_a"));
	}	
	public void setName_child_birth_a(String Name_child_birth_a) {
		setAttrVal("Name_child_birth_a", Name_child_birth_a);
	}
	public String getName_asphyxia_a() {
		return ((String) getAttrVal("Name_asphyxia_a"));
	}	
	public void setName_asphyxia_a(String Name_asphyxia_a) {
		setAttrVal("Name_asphyxia_a", Name_asphyxia_a);
	}
	public String getName_umbilicalcord_part_a() {
		return ((String) getAttrVal("Name_umbilicalcord_part_a"));
	}	
	public void setName_umbilicalcord_part_a(String Name_umbilicalcord_part_a) {
		setAttrVal("Name_umbilicalcord_part_a", Name_umbilicalcord_part_a);
	}
	public String getName_umbilicalcord_ligation_a() {
		return ((String) getAttrVal("Name_umbilicalcord_ligation_a"));
	}	
	public void setName_umbilicalcord_ligation_a(String Name_umbilicalcord_ligation_a) {
		setAttrVal("Name_umbilicalcord_ligation_a", Name_umbilicalcord_ligation_a);
	}
	public String getName_eyes_handle_a() {
		return ((String) getAttrVal("Name_eyes_handle_a"));
	}	
	public void setName_eyes_handle_a(String Name_eyes_handle_a) {
		setAttrVal("Name_eyes_handle_a", Name_eyes_handle_a);
	}
	public String getName_sex_b() {
		return ((String) getAttrVal("Name_sex_b"));
	}	
	public void setName_sex_b(String Name_sex_b) {
		setAttrVal("Name_sex_b", Name_sex_b);
	}
	public String getName_child_birth_b() {
		return ((String) getAttrVal("Name_child_birth_b"));
	}	
	public void setName_child_birth_b(String Name_child_birth_b) {
		setAttrVal("Name_child_birth_b", Name_child_birth_b);
	}
	public String getName_asphyxia_b() {
		return ((String) getAttrVal("Name_asphyxia_b"));
	}	
	public void setName_asphyxia_b(String Name_asphyxia_b) {
		setAttrVal("Name_asphyxia_b", Name_asphyxia_b);
	}
	public String getName_umbilicalcord_part_b() {
		return ((String) getAttrVal("Name_umbilicalcord_part_b"));
	}	
	public void setName_umbilicalcord_part_b(String Name_umbilicalcord_part_b) {
		setAttrVal("Name_umbilicalcord_part_b", Name_umbilicalcord_part_b);
	}
	public String getName_umbilicalcord_ligation_b() {
		return ((String) getAttrVal("Name_umbilicalcord_ligation_b"));
	}	
	public void setName_umbilicalcord_ligation_b(String Name_umbilicalcord_ligation_b) {
		setAttrVal("Name_umbilicalcord_ligation_b", Name_umbilicalcord_ligation_b);
	}
	public String getNam_eyes_handle_b() {
		return ((String) getAttrVal("Nam_eyes_handle_b"));
	}	
	public void setNam_eyes_handle_b(String Nam_eyes_handle_b) {
		setAttrVal("Nam_eyes_handle_b", Nam_eyes_handle_b);
	}
	public String getName_placenta_status() {
		return ((String) getAttrVal("Name_placenta_status"));
	}	
	public void setName_placenta_status(String Name_placenta_status) {
		setAttrVal("Name_placenta_status", Name_placenta_status);
	}
	public String getName_membranes_status() {
		return ((String) getAttrVal("Name_membranes_status"));
	}	
	public void setName_membranes_status(String Name_membranes_status) {
		setAttrVal("Name_membranes_status", Name_membranes_status);
	}
	public String getName_perineum_cut() {
		return ((String) getAttrVal("Name_perineum_cut"));
	}	
	public void setName_perineum_cut(String Name_perineum_cut) {
		setAttrVal("Name_perineum_cut", Name_perineum_cut);
	}
	public String getName_childbirth_narcosis_type() {
		return ((String) getAttrVal("Name_childbirth_narcosis_type"));
	}	
	public void setName_childbirth_narcosis_type(String Name_childbirth_narcosis_type) {
		setAttrVal("Name_childbirth_narcosis_type", Name_childbirth_narcosis_type);
	}
	public String getName_narcosis_drug() {
		return ((String) getAttrVal("Name_narcosis_drug"));
	}	
	public void setName_narcosis_drug(String Name_narcosis_drug) {
		setAttrVal("Name_narcosis_drug", Name_narcosis_drug);
	}
	public String getName_suture_type() {
		return ((String) getAttrVal("Name_suture_type"));
	}	
	public void setName_suture_type(String Name_suture_type) {
		setAttrVal("Name_suture_type", Name_suture_type);
	}
	public String getName_childbirth_operation() {
		return ((String) getAttrVal("Name_childbirth_operation"));
	}	
	public void setName_childbirth_operation(String Name_childbirth_operation) {
		setAttrVal("Name_childbirth_operation", Name_childbirth_operation);
	}
	public String getName_delivering() {
		return ((String) getAttrVal("Name_delivering"));
	}	
	public void setName_delivering(String Name_delivering) {
		setAttrVal("Name_delivering", Name_delivering);
	}
	public String getName_suture() {
		return ((String) getAttrVal("Name_suture"));
	}	
	public void setName_suture(String Name_suture) {
		setAttrVal("Name_suture", Name_suture);
	}
	public String getName_assist() {
		return ((String) getAttrVal("Name_assist"));
	}	
	public void setName_assist(String Name_assist) {
		setAttrVal("Name_assist", Name_assist);
	}
	public String getName_counting() {
		return ((String) getAttrVal("Name_counting"));
	}	
	public void setName_counting(String Name_counting) {
		setAttrVal("Name_counting", Name_counting);
	}
	public String getName_mrrecord() {
		return ((String) getAttrVal("Name_mrrecord"));
	}	
	public void setName_mrrecord(String Name_mrrecord) {
		setAttrVal("Name_mrrecord", Name_mrrecord);
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
		return "Id_childbirth";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_nu_childbirth";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ChildBirthRecordDODesc.class);
	}
	
}