package iih.ci.mr.nu.obstetrics.opernurecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.opernurecord.d.desc.OperNuRecordDODesc;
import java.math.BigDecimal;

/**
 * 手术护理记录单 DO数据 
 * 
 */
public class OperNuRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPRCOD= "Id_oprcod";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String AGE= "Age";
	public static final String WEIGHT= "Weight";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_OPER_ROOM= "Name_oper_room";
	public static final String DT_OPER= "Dt_oper";
	public static final String DT_IN= "Dt_in";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String DT_OUT= "Dt_out";
	public static final String PREOPERATIVE_DIAGNOSIS= "Preoperative_diagnosis";
	public static final String NAME_OPER= "Name_oper";
	public static final String ID_ANESTHESIA_METHOD= "Id_anesthesia_method";
	public static final String SD_ANESTHESIA_METHOD= "Sd_anesthesia_method";
	public static final String POSITION_OPER= "Position_oper";
	public static final String SKIN_BEFOREOPER= "Skin_beforeoper";
	public static final String NAME_ALLERGY= "Name_allergy";
	public static final String EU_LZDN= "Eu_lzdn";
	public static final String EU_NGCT= "Eu_ngct";
	public static final String ID_URINE_COLOR= "Id_urine_color";
	public static final String SD_URINE_COLOR= "Sd_urine_color";
	public static final String BLOODINOPER= "Bloodinoper";
	public static final String DOSE_URINE= "Dose_urine";
	public static final String INFUSION= "Infusion";
	public static final String REDBLOODCELL= "Redbloodcell";
	public static final String PLASMA= "Plasma";
	public static final String EU_SHYSQK= "Eu_shysqk";
	public static final String SKIN_AFTEROPER= "Skin_afteroper";
	public static final String EU_YLG= "Eu_ylg";
	public static final String DRAINAGE_TUBE= "Drainage_tube";
	public static final String EU_BB= "Eu_bb";
	public static final String SDB= "Sdb";
	public static final String DBP= "Dbp";
	public static final String PLUSE= "Pluse";
	public static final String BREATH= "Breath";
	public static final String SPECIALREC= "Specialrec";
	public static final String ID_EMP_WASH= "Id_emp_wash";
	public static final String ID_EMP_APPLY= "Id_emp_apply";
	public static final String STERILE= "Sterile";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String DT_BIRTH_PAT= "Dt_birth_pat";
	public static final String NAME_SEX= "Name_sex";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String NAME_ANESTHESIA_METHOD= "Name_anesthesia_method";
	public static final String NAME_URINE_COLOR= "Name_urine_color";
	public static final String NAME_WASH= "Name_wash";
	public static final String NAME_APPLY= "Name_apply";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_oprcod() {
		return ((String) getAttrVal("Id_oprcod"));
	}	
	public void setId_oprcod(String Id_oprcod) {
		setAttrVal("Id_oprcod", Id_oprcod);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_oper_room() {
		return ((String) getAttrVal("Name_oper_room"));
	}	
	public void setName_oper_room(String Name_oper_room) {
		setAttrVal("Name_oper_room", Name_oper_room);
	}
	public FDate getDt_oper() {
		return ((FDate) getAttrVal("Dt_oper"));
	}	
	public void setDt_oper(FDate Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	public FDateTime getDt_in() {
		return ((FDateTime) getAttrVal("Dt_in"));
	}	
	public void setDt_in(FDateTime Dt_in) {
		setAttrVal("Dt_in", Dt_in);
	}
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public FDateTime getDt_out() {
		return ((FDateTime) getAttrVal("Dt_out"));
	}	
	public void setDt_out(FDateTime Dt_out) {
		setAttrVal("Dt_out", Dt_out);
	}
	public String getPreoperative_diagnosis() {
		return ((String) getAttrVal("Preoperative_diagnosis"));
	}	
	public void setPreoperative_diagnosis(String Preoperative_diagnosis) {
		setAttrVal("Preoperative_diagnosis", Preoperative_diagnosis);
	}
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}	
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
	}
	public String getId_anesthesia_method() {
		return ((String) getAttrVal("Id_anesthesia_method"));
	}	
	public void setId_anesthesia_method(String Id_anesthesia_method) {
		setAttrVal("Id_anesthesia_method", Id_anesthesia_method);
	}
	public String getSd_anesthesia_method() {
		return ((String) getAttrVal("Sd_anesthesia_method"));
	}	
	public void setSd_anesthesia_method(String Sd_anesthesia_method) {
		setAttrVal("Sd_anesthesia_method", Sd_anesthesia_method);
	}
	public String getPosition_oper() {
		return ((String) getAttrVal("Position_oper"));
	}	
	public void setPosition_oper(String Position_oper) {
		setAttrVal("Position_oper", Position_oper);
	}
	public String getSkin_beforeoper() {
		return ((String) getAttrVal("Skin_beforeoper"));
	}	
	public void setSkin_beforeoper(String Skin_beforeoper) {
		setAttrVal("Skin_beforeoper", Skin_beforeoper);
	}
	public String getName_allergy() {
		return ((String) getAttrVal("Name_allergy"));
	}	
	public void setName_allergy(String Name_allergy) {
		setAttrVal("Name_allergy", Name_allergy);
	}
	public Integer getEu_lzdn() {
		return ((Integer) getAttrVal("Eu_lzdn"));
	}	
	public void setEu_lzdn(Integer Eu_lzdn) {
		setAttrVal("Eu_lzdn", Eu_lzdn);
	}
	public Integer getEu_ngct() {
		return ((Integer) getAttrVal("Eu_ngct"));
	}	
	public void setEu_ngct(Integer Eu_ngct) {
		setAttrVal("Eu_ngct", Eu_ngct);
	}
	public String getId_urine_color() {
		return ((String) getAttrVal("Id_urine_color"));
	}	
	public void setId_urine_color(String Id_urine_color) {
		setAttrVal("Id_urine_color", Id_urine_color);
	}
	public String getSd_urine_color() {
		return ((String) getAttrVal("Sd_urine_color"));
	}	
	public void setSd_urine_color(String Sd_urine_color) {
		setAttrVal("Sd_urine_color", Sd_urine_color);
	}
	public FDouble getBloodinoper() {
		return ((FDouble) getAttrVal("Bloodinoper"));
	}	
	public void setBloodinoper(FDouble Bloodinoper) {
		setAttrVal("Bloodinoper", Bloodinoper);
	}
	public FDouble getDose_urine() {
		return ((FDouble) getAttrVal("Dose_urine"));
	}	
	public void setDose_urine(FDouble Dose_urine) {
		setAttrVal("Dose_urine", Dose_urine);
	}
	public FDouble getInfusion() {
		return ((FDouble) getAttrVal("Infusion"));
	}	
	public void setInfusion(FDouble Infusion) {
		setAttrVal("Infusion", Infusion);
	}
	public FDouble getRedbloodcell() {
		return ((FDouble) getAttrVal("Redbloodcell"));
	}	
	public void setRedbloodcell(FDouble Redbloodcell) {
		setAttrVal("Redbloodcell", Redbloodcell);
	}
	public FDouble getPlasma() {
		return ((FDouble) getAttrVal("Plasma"));
	}	
	public void setPlasma(FDouble Plasma) {
		setAttrVal("Plasma", Plasma);
	}
	public Integer getEu_shysqk() {
		return ((Integer) getAttrVal("Eu_shysqk"));
	}	
	public void setEu_shysqk(Integer Eu_shysqk) {
		setAttrVal("Eu_shysqk", Eu_shysqk);
	}
	public String getSkin_afteroper() {
		return ((String) getAttrVal("Skin_afteroper"));
	}	
	public void setSkin_afteroper(String Skin_afteroper) {
		setAttrVal("Skin_afteroper", Skin_afteroper);
	}
	public Integer getEu_ylg() {
		return ((Integer) getAttrVal("Eu_ylg"));
	}	
	public void setEu_ylg(Integer Eu_ylg) {
		setAttrVal("Eu_ylg", Eu_ylg);
	}
	public String getDrainage_tube() {
		return ((String) getAttrVal("Drainage_tube"));
	}	
	public void setDrainage_tube(String Drainage_tube) {
		setAttrVal("Drainage_tube", Drainage_tube);
	}
	public Integer getEu_bb() {
		return ((Integer) getAttrVal("Eu_bb"));
	}	
	public void setEu_bb(Integer Eu_bb) {
		setAttrVal("Eu_bb", Eu_bb);
	}
	public Integer getSdb() {
		return ((Integer) getAttrVal("Sdb"));
	}	
	public void setSdb(Integer Sdb) {
		setAttrVal("Sdb", Sdb);
	}
	public Integer getDbp() {
		return ((Integer) getAttrVal("Dbp"));
	}	
	public void setDbp(Integer Dbp) {
		setAttrVal("Dbp", Dbp);
	}
	public Integer getPluse() {
		return ((Integer) getAttrVal("Pluse"));
	}	
	public void setPluse(Integer Pluse) {
		setAttrVal("Pluse", Pluse);
	}
	public Integer getBreath() {
		return ((Integer) getAttrVal("Breath"));
	}	
	public void setBreath(Integer Breath) {
		setAttrVal("Breath", Breath);
	}
	public String getSpecialrec() {
		return ((String) getAttrVal("Specialrec"));
	}	
	public void setSpecialrec(String Specialrec) {
		setAttrVal("Specialrec", Specialrec);
	}
	public String getId_emp_wash() {
		return ((String) getAttrVal("Id_emp_wash"));
	}	
	public void setId_emp_wash(String Id_emp_wash) {
		setAttrVal("Id_emp_wash", Id_emp_wash);
	}
	public String getId_emp_apply() {
		return ((String) getAttrVal("Id_emp_apply"));
	}	
	public void setId_emp_apply(String Id_emp_apply) {
		setAttrVal("Id_emp_apply", Id_emp_apply);
	}
	public String getSterile() {
		return ((String) getAttrVal("Sterile"));
	}	
	public void setSterile(String Sterile) {
		setAttrVal("Sterile", Sterile);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}	
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getName_anesthesia_method() {
		return ((String) getAttrVal("Name_anesthesia_method"));
	}	
	public void setName_anesthesia_method(String Name_anesthesia_method) {
		setAttrVal("Name_anesthesia_method", Name_anesthesia_method);
	}
	public String getName_urine_color() {
		return ((String) getAttrVal("Name_urine_color"));
	}	
	public void setName_urine_color(String Name_urine_color) {
		setAttrVal("Name_urine_color", Name_urine_color);
	}
	public String getName_wash() {
		return ((String) getAttrVal("Name_wash"));
	}	
	public void setName_wash(String Name_wash) {
		setAttrVal("Name_wash", Name_wash);
	}
	public String getName_apply() {
		return ((String) getAttrVal("Name_apply"));
	}	
	public void setName_apply(String Name_apply) {
		setAttrVal("Name_apply", Name_apply);
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
		return "Id_oprcod";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_nu_oprcod";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OperNuRecordDODesc.class);
	}
	
}