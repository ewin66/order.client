package iih.ci.mr.nu.obstetrics.birthregis.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.birthregis.d.desc.BirthRegistrationDODesc;
import java.math.BigDecimal;

/**
 * 分娩登记薄 DO数据 
 * 
 */
public class BirthRegistrationDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BIRTH_REG= "Id_birth_reg";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String SORTNO= "Sortno";
	public static final String DT_DATE= "Dt_date";
	public static final String DT_TIME= "Dt_time";
	public static final String AGE= "Age";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String NUM_PREG= "Num_preg";
	public static final String NUM_BIRTH= "Num_birth";
	public static final String WEEK_PREG= "Week_preg";
	public static final String ID_DELIVERY= "Id_delivery";
	public static final String SD_DELIVERY= "Sd_delivery";
	public static final String ID_POSITION= "Id_position";
	public static final String SD_POSITION= "Sd_position";
	public static final String NAME_OPER= "Name_oper";
	public static final String COMPLICATION= "Complication";
	public static final String NUM_BLEED_INTRAP= "Num_bleed_intrap";
	public static final String NUM_BLEED_POSTP= "Num_bleed_postp";
	public static final String RES_BLEED= "Res_bleed";
	public static final String ID_PERINEUM_STATUS= "Id_perineum_status";
	public static final String SD_PERINEUM_STATUS= "Sd_perineum_status";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String WEIGHT= "Weight";
	public static final String HEIGHT= "Height";
	public static final String SITUATION_SPECIAL= "Situation_special";
	public static final String SCORE_MINUTE_ONE= "Score_minute_one";
	public static final String SCORE_MINUTE_FIVE= "Score_minute_five";
	public static final String SCORE_MINUTE_TEN= "Score_minute_ten";
	public static final String EU_ANMELDEN= "Eu_anmelden";
	public static final String EU_CONSULTHIV= "Eu_consulthiv";
	public static final String EU_FILTRATEHIV= "Eu_filtratehiv";
	public static final String ID_ASSAYTESTHIV= "Id_assaytesthiv";
	public static final String SD_ASSAYTESTHIV= "Sd_assaytesthiv";
	public static final String EU_SYPHILIS= "Eu_syphilis";
	public static final String EU_HBSAG= "Eu_hbsag";
	public static final String OTHER_SEXILLNESS= "Other_sexillness";
	public static final String NUM_FETUS= "Num_fetus";
	public static final String NUM_DEAD_FETUS= "Num_dead_fetus";
	public static final String NUM_DEAD_BIRTH= "Num_dead_birth";
	public static final String NUM_DEAD_NEWBORN= "Num_dead_newborn";
	public static final String DEFECTS_BIRTH= "Defects_birth";
	public static final String SUE_SEND= "Sue_send";
	public static final String ID_EMP_MIDWIVES= "Id_emp_midwives";
	public static final String ID_EMP_REG= "Id_emp_reg";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_DELIVERY= "Name_delivery";
	public static final String NAME_POSITION= "Name_position";
	public static final String NAME_PERINEUM_STATUS= "Name_perineum_status";
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_ASSAYTESTHIV= "Name_assaytesthiv";
	public static final String NAME_EMP_MIDWIVES= "Name_emp_midwives";
	public static final String NAME_EMP_REG= "Name_emp_reg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_birth_reg() {
		return ((String) getAttrVal("Id_birth_reg"));
	}	
	public void setId_birth_reg(String Id_birth_reg) {
		setAttrVal("Id_birth_reg", Id_birth_reg);
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
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public FDate getDt_date() {
		return ((FDate) getAttrVal("Dt_date"));
	}	
	public void setDt_date(FDate Dt_date) {
		setAttrVal("Dt_date", Dt_date);
	}
	public FTime getDt_time() {
		return ((FTime) getAttrVal("Dt_time"));
	}	
	public void setDt_time(FTime Dt_time) {
		setAttrVal("Dt_time", Dt_time);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public Integer getNum_preg() {
		return ((Integer) getAttrVal("Num_preg"));
	}	
	public void setNum_preg(Integer Num_preg) {
		setAttrVal("Num_preg", Num_preg);
	}
	public Integer getNum_birth() {
		return ((Integer) getAttrVal("Num_birth"));
	}	
	public void setNum_birth(Integer Num_birth) {
		setAttrVal("Num_birth", Num_birth);
	}
	public Integer getWeek_preg() {
		return ((Integer) getAttrVal("Week_preg"));
	}	
	public void setWeek_preg(Integer Week_preg) {
		setAttrVal("Week_preg", Week_preg);
	}
	public String getId_delivery() {
		return ((String) getAttrVal("Id_delivery"));
	}	
	public void setId_delivery(String Id_delivery) {
		setAttrVal("Id_delivery", Id_delivery);
	}
	public String getSd_delivery() {
		return ((String) getAttrVal("Sd_delivery"));
	}	
	public void setSd_delivery(String Sd_delivery) {
		setAttrVal("Sd_delivery", Sd_delivery);
	}
	public String getId_position() {
		return ((String) getAttrVal("Id_position"));
	}	
	public void setId_position(String Id_position) {
		setAttrVal("Id_position", Id_position);
	}
	public String getSd_position() {
		return ((String) getAttrVal("Sd_position"));
	}	
	public void setSd_position(String Sd_position) {
		setAttrVal("Sd_position", Sd_position);
	}
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}	
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
	}
	public String getComplication() {
		return ((String) getAttrVal("Complication"));
	}	
	public void setComplication(String Complication) {
		setAttrVal("Complication", Complication);
	}
	public Integer getNum_bleed_intrap() {
		return ((Integer) getAttrVal("Num_bleed_intrap"));
	}	
	public void setNum_bleed_intrap(Integer Num_bleed_intrap) {
		setAttrVal("Num_bleed_intrap", Num_bleed_intrap);
	}
	public Integer getNum_bleed_postp() {
		return ((Integer) getAttrVal("Num_bleed_postp"));
	}	
	public void setNum_bleed_postp(Integer Num_bleed_postp) {
		setAttrVal("Num_bleed_postp", Num_bleed_postp);
	}
	public String getRes_bleed() {
		return ((String) getAttrVal("Res_bleed"));
	}	
	public void setRes_bleed(String Res_bleed) {
		setAttrVal("Res_bleed", Res_bleed);
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
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	public Integer getHeight() {
		return ((Integer) getAttrVal("Height"));
	}	
	public void setHeight(Integer Height) {
		setAttrVal("Height", Height);
	}
	public String getSituation_special() {
		return ((String) getAttrVal("Situation_special"));
	}	
	public void setSituation_special(String Situation_special) {
		setAttrVal("Situation_special", Situation_special);
	}
	public Integer getScore_minute_one() {
		return ((Integer) getAttrVal("Score_minute_one"));
	}	
	public void setScore_minute_one(Integer Score_minute_one) {
		setAttrVal("Score_minute_one", Score_minute_one);
	}
	public Integer getScore_minute_five() {
		return ((Integer) getAttrVal("Score_minute_five"));
	}	
	public void setScore_minute_five(Integer Score_minute_five) {
		setAttrVal("Score_minute_five", Score_minute_five);
	}
	public Integer getScore_minute_ten() {
		return ((Integer) getAttrVal("Score_minute_ten"));
	}	
	public void setScore_minute_ten(Integer Score_minute_ten) {
		setAttrVal("Score_minute_ten", Score_minute_ten);
	}
	public Integer getEu_anmelden() {
		return ((Integer) getAttrVal("Eu_anmelden"));
	}	
	public void setEu_anmelden(Integer Eu_anmelden) {
		setAttrVal("Eu_anmelden", Eu_anmelden);
	}
	public Integer getEu_consulthiv() {
		return ((Integer) getAttrVal("Eu_consulthiv"));
	}	
	public void setEu_consulthiv(Integer Eu_consulthiv) {
		setAttrVal("Eu_consulthiv", Eu_consulthiv);
	}
	public Integer getEu_filtratehiv() {
		return ((Integer) getAttrVal("Eu_filtratehiv"));
	}	
	public void setEu_filtratehiv(Integer Eu_filtratehiv) {
		setAttrVal("Eu_filtratehiv", Eu_filtratehiv);
	}
	public String getId_assaytesthiv() {
		return ((String) getAttrVal("Id_assaytesthiv"));
	}	
	public void setId_assaytesthiv(String Id_assaytesthiv) {
		setAttrVal("Id_assaytesthiv", Id_assaytesthiv);
	}
	public String getSd_assaytesthiv() {
		return ((String) getAttrVal("Sd_assaytesthiv"));
	}	
	public void setSd_assaytesthiv(String Sd_assaytesthiv) {
		setAttrVal("Sd_assaytesthiv", Sd_assaytesthiv);
	}
	public Integer getEu_syphilis() {
		return ((Integer) getAttrVal("Eu_syphilis"));
	}	
	public void setEu_syphilis(Integer Eu_syphilis) {
		setAttrVal("Eu_syphilis", Eu_syphilis);
	}
	public Integer getEu_hbsag() {
		return ((Integer) getAttrVal("Eu_hbsag"));
	}	
	public void setEu_hbsag(Integer Eu_hbsag) {
		setAttrVal("Eu_hbsag", Eu_hbsag);
	}
	public String getOther_sexillness() {
		return ((String) getAttrVal("Other_sexillness"));
	}	
	public void setOther_sexillness(String Other_sexillness) {
		setAttrVal("Other_sexillness", Other_sexillness);
	}
	public Integer getNum_fetus() {
		return ((Integer) getAttrVal("Num_fetus"));
	}	
	public void setNum_fetus(Integer Num_fetus) {
		setAttrVal("Num_fetus", Num_fetus);
	}
	public Integer getNum_dead_fetus() {
		return ((Integer) getAttrVal("Num_dead_fetus"));
	}	
	public void setNum_dead_fetus(Integer Num_dead_fetus) {
		setAttrVal("Num_dead_fetus", Num_dead_fetus);
	}
	public Integer getNum_dead_birth() {
		return ((Integer) getAttrVal("Num_dead_birth"));
	}	
	public void setNum_dead_birth(Integer Num_dead_birth) {
		setAttrVal("Num_dead_birth", Num_dead_birth);
	}
	public Integer getNum_dead_newborn() {
		return ((Integer) getAttrVal("Num_dead_newborn"));
	}	
	public void setNum_dead_newborn(Integer Num_dead_newborn) {
		setAttrVal("Num_dead_newborn", Num_dead_newborn);
	}
	public String getDefects_birth() {
		return ((String) getAttrVal("Defects_birth"));
	}	
	public void setDefects_birth(String Defects_birth) {
		setAttrVal("Defects_birth", Defects_birth);
	}
	public String getSue_send() {
		return ((String) getAttrVal("Sue_send"));
	}	
	public void setSue_send(String Sue_send) {
		setAttrVal("Sue_send", Sue_send);
	}
	public String getId_emp_midwives() {
		return ((String) getAttrVal("Id_emp_midwives"));
	}	
	public void setId_emp_midwives(String Id_emp_midwives) {
		setAttrVal("Id_emp_midwives", Id_emp_midwives);
	}
	public String getId_emp_reg() {
		return ((String) getAttrVal("Id_emp_reg"));
	}	
	public void setId_emp_reg(String Id_emp_reg) {
		setAttrVal("Id_emp_reg", Id_emp_reg);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_delivery() {
		return ((String) getAttrVal("Name_delivery"));
	}	
	public void setName_delivery(String Name_delivery) {
		setAttrVal("Name_delivery", Name_delivery);
	}
	public String getName_position() {
		return ((String) getAttrVal("Name_position"));
	}	
	public void setName_position(String Name_position) {
		setAttrVal("Name_position", Name_position);
	}
	public String getName_perineum_status() {
		return ((String) getAttrVal("Name_perineum_status"));
	}	
	public void setName_perineum_status(String Name_perineum_status) {
		setAttrVal("Name_perineum_status", Name_perineum_status);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getName_assaytesthiv() {
		return ((String) getAttrVal("Name_assaytesthiv"));
	}	
	public void setName_assaytesthiv(String Name_assaytesthiv) {
		setAttrVal("Name_assaytesthiv", Name_assaytesthiv);
	}
	public String getName_emp_midwives() {
		return ((String) getAttrVal("Name_emp_midwives"));
	}	
	public void setName_emp_midwives(String Name_emp_midwives) {
		setAttrVal("Name_emp_midwives", Name_emp_midwives);
	}
	public String getName_emp_reg() {
		return ((String) getAttrVal("Name_emp_reg"));
	}	
	public void setName_emp_reg(String Name_emp_reg) {
		setAttrVal("Name_emp_reg", Name_emp_reg);
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
		return "Id_birth_reg";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_BIRTH_REG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BirthRegistrationDODesc.class);
	}
	
}