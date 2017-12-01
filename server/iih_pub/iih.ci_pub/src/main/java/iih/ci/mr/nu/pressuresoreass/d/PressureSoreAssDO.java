package iih.ci.mr.nu.pressuresoreass.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.pressuresoreass.d.desc.PressureSoreAssDODesc;
import java.math.BigDecimal;

/**
 * 压疮危险因素评估单 DO数据 
 * 
 */
public class PressureSoreAssDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PUAS= "Id_puas";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String NAME_BED= "Name_bed";
	public static final String AGE= "Age";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String ID_SORES_PHYSICAL= "Id_sores_physical";
	public static final String SD_SORES_PHYSICAL= "Sd_sores_physical";
	public static final String SORES_PHYSICAL= "Sores_physical";
	public static final String ID_SORES_SKIN= "Id_sores_skin";
	public static final String SD_SORES_SKIN= "Sd_sores_skin";
	public static final String SORES_SKIN= "Sores_skin";
	public static final String ID_SORES_SEX= "Id_sores_sex";
	public static final String SD_SORES_SEX= "Sd_sores_sex";
	public static final String SORES_SEX= "Sores_sex";
	public static final String ID_SORES_AGE= "Id_sores_age";
	public static final String SD_SORES_AGE= "Sd_sores_age";
	public static final String SORES_AGE= "Sores_age";
	public static final String ID_SORES_WGT_DEC= "Id_sores_wgt_dec";
	public static final String SD_SORES_WGT_DEC= "Sd_sores_wgt_dec";
	public static final String ID_SORES_WGT_SC= "Id_sores_wgt_sc";
	public static final String SD_SORES_WGT_SC= "Sd_sores_wgt_sc";
	public static final String SORES_WGT_SC= "Sores_wgt_sc";
	public static final String ID_SORES_LOSS_APPETITE= "Id_sores_loss_appetite";
	public static final String SD_SORES_LOSS_APPETITE= "Sd_sores_loss_appetite";
	public static final String SORES_LOSS_APPETITE= "Sores_loss_appetite";
	public static final String ID_SORES_INCONTINENCE= "Id_sores_incontinence";
	public static final String SD_SORES_INCONTINENCE= "Sd_sores_incontinence";
	public static final String SORES_INCONTINENCE= "Sores_incontinence";
	public static final String ID_SORES_SPORT= "Id_sores_sport";
	public static final String SD_SORES_SPORT= "Sd_sores_sport";
	public static final String SORES_SPORT= "Sores_sport";
	public static final String ID_SORES_NUTRITION= "Id_sores_nutrition";
	public static final String SD_SORES_NUTRITION= "Sd_sores_nutrition";
	public static final String SORES_NUTRITION= "Sores_nutrition";
	public static final String ID_SORES_NERVOUS= "Id_sores_nervous";
	public static final String SD_SORES_NERVOUS= "Sd_sores_nervous";
	public static final String SORES_NERVOUS= "Sores_nervous";
	public static final String ID_SORES_TRAUMA= "Id_sores_trauma";
	public static final String SD_SORES_TRAUMA= "Sd_sores_trauma";
	public static final String SORES_TRAUMA= "Sores_trauma";
	public static final String ID_SORES_DRUG= "Id_sores_drug";
	public static final String SD_SORES_DRUG= "Sd_sores_drug";
	public static final String SORES_DRUG= "Sores_drug";
	public static final String TOTAL_SCORE= "Total_score";
	public static final String ASS_RESULT= "Ass_result";
	public static final String DT_ASS= "Dt_ass";
	public static final String ID_NUR_PSN= "Id_nur_psn";
	public static final String ID_HEADNUR_PSN= "Id_headnur_psn";
	public static final String RELATION= "Relation";
	public static final String VIRUS_NERVE= "Virus_nerve";
	public static final String SPORT_NERVE= "Sport_nerve";
	public static final String HEM_NERVE= "Hem_nerve";
	public static final String CELL_MED= "Cell_med";
	public static final String LONG_MED= "Long_med";
	public static final String BIOTIC_MED= "Biotic_med";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_SORES_PHYSICAL= "Name_sores_physical";
	public static final String NAME_SORES_SKIN= "Name_sores_skin";
	public static final String NAME_SORES_SEX= "Name_sores_sex";
	public static final String NAME_SORES_AGE= "Name_sores_age";
	public static final String NAME_SORES_WGT_DEC= "Name_sores_wgt_dec";
	public static final String NAME_SORES_WGT_SC= "Name_sores_wgt_sc";
	public static final String NAME_SORES_LOSS= "Name_sores_loss";
	public static final String NAME_SORES_INCON= "Name_sores_incon";
	public static final String NAME_SORES_SPORT= "Name_sores_sport";
	public static final String NAME_SORES_NUTR= "Name_sores_nutr";
	public static final String NAME_SORES_NER= "Name_sores_ner";
	public static final String NAME_SORES_TRA= "Name_sores_tra";
	public static final String NAME_SORES_DRUG= "Name_sores_drug";
	public static final String NAME_NUR_PSN= "Name_nur_psn";
	public static final String NAME_HEADNUR_PSN= "Name_headnur_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_puas() {
		return ((String) getAttrVal("Id_puas"));
	}	
	public void setId_puas(String Id_puas) {
		setAttrVal("Id_puas", Id_puas);
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
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
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
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
	}
	public String getId_sores_physical() {
		return ((String) getAttrVal("Id_sores_physical"));
	}	
	public void setId_sores_physical(String Id_sores_physical) {
		setAttrVal("Id_sores_physical", Id_sores_physical);
	}
	public String getSd_sores_physical() {
		return ((String) getAttrVal("Sd_sores_physical"));
	}	
	public void setSd_sores_physical(String Sd_sores_physical) {
		setAttrVal("Sd_sores_physical", Sd_sores_physical);
	}
	public Integer getSores_physical() {
		return ((Integer) getAttrVal("Sores_physical"));
	}	
	public void setSores_physical(Integer Sores_physical) {
		setAttrVal("Sores_physical", Sores_physical);
	}
	public String getId_sores_skin() {
		return ((String) getAttrVal("Id_sores_skin"));
	}	
	public void setId_sores_skin(String Id_sores_skin) {
		setAttrVal("Id_sores_skin", Id_sores_skin);
	}
	public String getSd_sores_skin() {
		return ((String) getAttrVal("Sd_sores_skin"));
	}	
	public void setSd_sores_skin(String Sd_sores_skin) {
		setAttrVal("Sd_sores_skin", Sd_sores_skin);
	}
	public Integer getSores_skin() {
		return ((Integer) getAttrVal("Sores_skin"));
	}	
	public void setSores_skin(Integer Sores_skin) {
		setAttrVal("Sores_skin", Sores_skin);
	}
	public String getId_sores_sex() {
		return ((String) getAttrVal("Id_sores_sex"));
	}	
	public void setId_sores_sex(String Id_sores_sex) {
		setAttrVal("Id_sores_sex", Id_sores_sex);
	}
	public String getSd_sores_sex() {
		return ((String) getAttrVal("Sd_sores_sex"));
	}	
	public void setSd_sores_sex(String Sd_sores_sex) {
		setAttrVal("Sd_sores_sex", Sd_sores_sex);
	}
	public Integer getSores_sex() {
		return ((Integer) getAttrVal("Sores_sex"));
	}	
	public void setSores_sex(Integer Sores_sex) {
		setAttrVal("Sores_sex", Sores_sex);
	}
	public String getId_sores_age() {
		return ((String) getAttrVal("Id_sores_age"));
	}	
	public void setId_sores_age(String Id_sores_age) {
		setAttrVal("Id_sores_age", Id_sores_age);
	}
	public String getSd_sores_age() {
		return ((String) getAttrVal("Sd_sores_age"));
	}	
	public void setSd_sores_age(String Sd_sores_age) {
		setAttrVal("Sd_sores_age", Sd_sores_age);
	}
	public Integer getSores_age() {
		return ((Integer) getAttrVal("Sores_age"));
	}	
	public void setSores_age(Integer Sores_age) {
		setAttrVal("Sores_age", Sores_age);
	}
	public String getId_sores_wgt_dec() {
		return ((String) getAttrVal("Id_sores_wgt_dec"));
	}	
	public void setId_sores_wgt_dec(String Id_sores_wgt_dec) {
		setAttrVal("Id_sores_wgt_dec", Id_sores_wgt_dec);
	}
	public String getSd_sores_wgt_dec() {
		return ((String) getAttrVal("Sd_sores_wgt_dec"));
	}	
	public void setSd_sores_wgt_dec(String Sd_sores_wgt_dec) {
		setAttrVal("Sd_sores_wgt_dec", Sd_sores_wgt_dec);
	}
	public String getId_sores_wgt_sc() {
		return ((String) getAttrVal("Id_sores_wgt_sc"));
	}	
	public void setId_sores_wgt_sc(String Id_sores_wgt_sc) {
		setAttrVal("Id_sores_wgt_sc", Id_sores_wgt_sc);
	}
	public String getSd_sores_wgt_sc() {
		return ((String) getAttrVal("Sd_sores_wgt_sc"));
	}	
	public void setSd_sores_wgt_sc(String Sd_sores_wgt_sc) {
		setAttrVal("Sd_sores_wgt_sc", Sd_sores_wgt_sc);
	}
	public Integer getSores_wgt_sc() {
		return ((Integer) getAttrVal("Sores_wgt_sc"));
	}	
	public void setSores_wgt_sc(Integer Sores_wgt_sc) {
		setAttrVal("Sores_wgt_sc", Sores_wgt_sc);
	}
	public String getId_sores_loss_appetite() {
		return ((String) getAttrVal("Id_sores_loss_appetite"));
	}	
	public void setId_sores_loss_appetite(String Id_sores_loss_appetite) {
		setAttrVal("Id_sores_loss_appetite", Id_sores_loss_appetite);
	}
	public String getSd_sores_loss_appetite() {
		return ((String) getAttrVal("Sd_sores_loss_appetite"));
	}	
	public void setSd_sores_loss_appetite(String Sd_sores_loss_appetite) {
		setAttrVal("Sd_sores_loss_appetite", Sd_sores_loss_appetite);
	}
	public Integer getSores_loss_appetite() {
		return ((Integer) getAttrVal("Sores_loss_appetite"));
	}	
	public void setSores_loss_appetite(Integer Sores_loss_appetite) {
		setAttrVal("Sores_loss_appetite", Sores_loss_appetite);
	}
	public String getId_sores_incontinence() {
		return ((String) getAttrVal("Id_sores_incontinence"));
	}	
	public void setId_sores_incontinence(String Id_sores_incontinence) {
		setAttrVal("Id_sores_incontinence", Id_sores_incontinence);
	}
	public String getSd_sores_incontinence() {
		return ((String) getAttrVal("Sd_sores_incontinence"));
	}	
	public void setSd_sores_incontinence(String Sd_sores_incontinence) {
		setAttrVal("Sd_sores_incontinence", Sd_sores_incontinence);
	}
	public Integer getSores_incontinence() {
		return ((Integer) getAttrVal("Sores_incontinence"));
	}	
	public void setSores_incontinence(Integer Sores_incontinence) {
		setAttrVal("Sores_incontinence", Sores_incontinence);
	}
	public String getId_sores_sport() {
		return ((String) getAttrVal("Id_sores_sport"));
	}	
	public void setId_sores_sport(String Id_sores_sport) {
		setAttrVal("Id_sores_sport", Id_sores_sport);
	}
	public String getSd_sores_sport() {
		return ((String) getAttrVal("Sd_sores_sport"));
	}	
	public void setSd_sores_sport(String Sd_sores_sport) {
		setAttrVal("Sd_sores_sport", Sd_sores_sport);
	}
	public Integer getSores_sport() {
		return ((Integer) getAttrVal("Sores_sport"));
	}	
	public void setSores_sport(Integer Sores_sport) {
		setAttrVal("Sores_sport", Sores_sport);
	}
	public String getId_sores_nutrition() {
		return ((String) getAttrVal("Id_sores_nutrition"));
	}	
	public void setId_sores_nutrition(String Id_sores_nutrition) {
		setAttrVal("Id_sores_nutrition", Id_sores_nutrition);
	}
	public String getSd_sores_nutrition() {
		return ((String) getAttrVal("Sd_sores_nutrition"));
	}	
	public void setSd_sores_nutrition(String Sd_sores_nutrition) {
		setAttrVal("Sd_sores_nutrition", Sd_sores_nutrition);
	}
	public Integer getSores_nutrition() {
		return ((Integer) getAttrVal("Sores_nutrition"));
	}	
	public void setSores_nutrition(Integer Sores_nutrition) {
		setAttrVal("Sores_nutrition", Sores_nutrition);
	}
	public String getId_sores_nervous() {
		return ((String) getAttrVal("Id_sores_nervous"));
	}	
	public void setId_sores_nervous(String Id_sores_nervous) {
		setAttrVal("Id_sores_nervous", Id_sores_nervous);
	}
	public String getSd_sores_nervous() {
		return ((String) getAttrVal("Sd_sores_nervous"));
	}	
	public void setSd_sores_nervous(String Sd_sores_nervous) {
		setAttrVal("Sd_sores_nervous", Sd_sores_nervous);
	}
	public Integer getSores_nervous() {
		return ((Integer) getAttrVal("Sores_nervous"));
	}	
	public void setSores_nervous(Integer Sores_nervous) {
		setAttrVal("Sores_nervous", Sores_nervous);
	}
	public String getId_sores_trauma() {
		return ((String) getAttrVal("Id_sores_trauma"));
	}	
	public void setId_sores_trauma(String Id_sores_trauma) {
		setAttrVal("Id_sores_trauma", Id_sores_trauma);
	}
	public String getSd_sores_trauma() {
		return ((String) getAttrVal("Sd_sores_trauma"));
	}	
	public void setSd_sores_trauma(String Sd_sores_trauma) {
		setAttrVal("Sd_sores_trauma", Sd_sores_trauma);
	}
	public Integer getSores_trauma() {
		return ((Integer) getAttrVal("Sores_trauma"));
	}	
	public void setSores_trauma(Integer Sores_trauma) {
		setAttrVal("Sores_trauma", Sores_trauma);
	}
	public String getId_sores_drug() {
		return ((String) getAttrVal("Id_sores_drug"));
	}	
	public void setId_sores_drug(String Id_sores_drug) {
		setAttrVal("Id_sores_drug", Id_sores_drug);
	}
	public String getSd_sores_drug() {
		return ((String) getAttrVal("Sd_sores_drug"));
	}	
	public void setSd_sores_drug(String Sd_sores_drug) {
		setAttrVal("Sd_sores_drug", Sd_sores_drug);
	}
	public Integer getSores_drug() {
		return ((Integer) getAttrVal("Sores_drug"));
	}	
	public void setSores_drug(Integer Sores_drug) {
		setAttrVal("Sores_drug", Sores_drug);
	}
	public Integer getTotal_score() {
		return ((Integer) getAttrVal("Total_score"));
	}	
	public void setTotal_score(Integer Total_score) {
		setAttrVal("Total_score", Total_score);
	}
	public String getAss_result() {
		return ((String) getAttrVal("Ass_result"));
	}	
	public void setAss_result(String Ass_result) {
		setAttrVal("Ass_result", Ass_result);
	}
	public FDateTime getDt_ass() {
		return ((FDateTime) getAttrVal("Dt_ass"));
	}	
	public void setDt_ass(FDateTime Dt_ass) {
		setAttrVal("Dt_ass", Dt_ass);
	}
	public String getId_nur_psn() {
		return ((String) getAttrVal("Id_nur_psn"));
	}	
	public void setId_nur_psn(String Id_nur_psn) {
		setAttrVal("Id_nur_psn", Id_nur_psn);
	}
	public String getId_headnur_psn() {
		return ((String) getAttrVal("Id_headnur_psn"));
	}	
	public void setId_headnur_psn(String Id_headnur_psn) {
		setAttrVal("Id_headnur_psn", Id_headnur_psn);
	}
	public String getRelation() {
		return ((String) getAttrVal("Relation"));
	}	
	public void setRelation(String Relation) {
		setAttrVal("Relation", Relation);
	}
	public Integer getVirus_nerve() {
		return ((Integer) getAttrVal("Virus_nerve"));
	}	
	public void setVirus_nerve(Integer Virus_nerve) {
		setAttrVal("Virus_nerve", Virus_nerve);
	}
	public Integer getSport_nerve() {
		return ((Integer) getAttrVal("Sport_nerve"));
	}	
	public void setSport_nerve(Integer Sport_nerve) {
		setAttrVal("Sport_nerve", Sport_nerve);
	}
	public Integer getHem_nerve() {
		return ((Integer) getAttrVal("Hem_nerve"));
	}	
	public void setHem_nerve(Integer Hem_nerve) {
		setAttrVal("Hem_nerve", Hem_nerve);
	}
	public Integer getCell_med() {
		return ((Integer) getAttrVal("Cell_med"));
	}	
	public void setCell_med(Integer Cell_med) {
		setAttrVal("Cell_med", Cell_med);
	}
	public Integer getLong_med() {
		return ((Integer) getAttrVal("Long_med"));
	}	
	public void setLong_med(Integer Long_med) {
		setAttrVal("Long_med", Long_med);
	}
	public Integer getBiotic_med() {
		return ((Integer) getAttrVal("Biotic_med"));
	}	
	public void setBiotic_med(Integer Biotic_med) {
		setAttrVal("Biotic_med", Biotic_med);
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
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getName_sores_physical() {
		return ((String) getAttrVal("Name_sores_physical"));
	}	
	public void setName_sores_physical(String Name_sores_physical) {
		setAttrVal("Name_sores_physical", Name_sores_physical);
	}
	public String getName_sores_skin() {
		return ((String) getAttrVal("Name_sores_skin"));
	}	
	public void setName_sores_skin(String Name_sores_skin) {
		setAttrVal("Name_sores_skin", Name_sores_skin);
	}
	public String getName_sores_sex() {
		return ((String) getAttrVal("Name_sores_sex"));
	}	
	public void setName_sores_sex(String Name_sores_sex) {
		setAttrVal("Name_sores_sex", Name_sores_sex);
	}
	public String getName_sores_age() {
		return ((String) getAttrVal("Name_sores_age"));
	}	
	public void setName_sores_age(String Name_sores_age) {
		setAttrVal("Name_sores_age", Name_sores_age);
	}
	public String getName_sores_wgt_dec() {
		return ((String) getAttrVal("Name_sores_wgt_dec"));
	}	
	public void setName_sores_wgt_dec(String Name_sores_wgt_dec) {
		setAttrVal("Name_sores_wgt_dec", Name_sores_wgt_dec);
	}
	public String getName_sores_wgt_sc() {
		return ((String) getAttrVal("Name_sores_wgt_sc"));
	}	
	public void setName_sores_wgt_sc(String Name_sores_wgt_sc) {
		setAttrVal("Name_sores_wgt_sc", Name_sores_wgt_sc);
	}
	public String getName_sores_loss() {
		return ((String) getAttrVal("Name_sores_loss"));
	}	
	public void setName_sores_loss(String Name_sores_loss) {
		setAttrVal("Name_sores_loss", Name_sores_loss);
	}
	public String getName_sores_incon() {
		return ((String) getAttrVal("Name_sores_incon"));
	}	
	public void setName_sores_incon(String Name_sores_incon) {
		setAttrVal("Name_sores_incon", Name_sores_incon);
	}
	public String getName_sores_sport() {
		return ((String) getAttrVal("Name_sores_sport"));
	}	
	public void setName_sores_sport(String Name_sores_sport) {
		setAttrVal("Name_sores_sport", Name_sores_sport);
	}
	public String getName_sores_nutr() {
		return ((String) getAttrVal("Name_sores_nutr"));
	}	
	public void setName_sores_nutr(String Name_sores_nutr) {
		setAttrVal("Name_sores_nutr", Name_sores_nutr);
	}
	public String getName_sores_ner() {
		return ((String) getAttrVal("Name_sores_ner"));
	}	
	public void setName_sores_ner(String Name_sores_ner) {
		setAttrVal("Name_sores_ner", Name_sores_ner);
	}
	public String getName_sores_tra() {
		return ((String) getAttrVal("Name_sores_tra"));
	}	
	public void setName_sores_tra(String Name_sores_tra) {
		setAttrVal("Name_sores_tra", Name_sores_tra);
	}
	public String getName_sores_drug() {
		return ((String) getAttrVal("Name_sores_drug"));
	}	
	public void setName_sores_drug(String Name_sores_drug) {
		setAttrVal("Name_sores_drug", Name_sores_drug);
	}
	public String getName_nur_psn() {
		return ((String) getAttrVal("Name_nur_psn"));
	}	
	public void setName_nur_psn(String Name_nur_psn) {
		setAttrVal("Name_nur_psn", Name_nur_psn);
	}
	public String getName_headnur_psn() {
		return ((String) getAttrVal("Name_headnur_psn"));
	}	
	public void setName_headnur_psn(String Name_headnur_psn) {
		setAttrVal("Name_headnur_psn", Name_headnur_psn);
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
		return "Id_puas";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_PUSA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PressureSoreAssDODesc.class);
	}
	
}