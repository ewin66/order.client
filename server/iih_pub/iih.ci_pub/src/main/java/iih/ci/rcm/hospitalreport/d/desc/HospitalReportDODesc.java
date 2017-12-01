
package iih.ci.rcm.hospitalreport.d.desc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import xap.sys.appfw.orm.desc.db.ColumnDesc;
import xap.sys.appfw.orm.desc.db.DsColumn;
import xap.sys.appfw.orm.desc.db.SvColumn;
import xap.sys.appfw.orm.desc.db.TableDesc;
import xap.sys.appfw.orm.desc.ent.dataobject.Attr;
import xap.sys.appfw.orm.desc.ent.dataobject.DODesc;
import xap.sys.appfw.orm.desc.ent.dataobject.DsAttr;
import xap.sys.appfw.orm.desc.ent.dataobject.SvAttr;
import xap.mw.coreitf.i.IAttrDesc;
import xap.mw.coreitf.i.IColumnDesc;
import xap.mw.coreitf.i.ITableDesc;
import xap.mw.coreitf.d.FType;
import java.math.BigDecimal;

/**
 * 院感上报 DO 元数据信息
 */
public class HospitalReportDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.hospitalreport.d.HospitalReportDO";
	public static final String CLASS_DISPALYNAME = "院感上报";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_HOS_REPORT";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_hospitalreport";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HospitalReportDODesc(){
		init();
	}
	
	/**
	 * 数据初始化
	 */
	private void init(){		
		this.setResID(CLASS_RESID);
		this.setResNode(CLASS_RESMODULE);
		this.setLabel(CLASS_DISPALYNAME);
		this.setEntityName(CLASS_FULLNAME);
		ITableDesc tblDesc=getTableDesc();
		this.setKeyDesc(getId_hospitalreportADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_hospitalreportADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getAdmission_dateADesc(tblDesc));
		this.add(getDischarge_dateADesc(tblDesc));
		this.add(getIn_hospital_daysADesc(tblDesc));
		this.add(getMonitor_dateADesc(tblDesc));
		this.add(getId_di_diagnosisADesc(tblDesc));
		this.add(getSd_di_diagnosisADesc(tblDesc));
		this.add(getName_di_diagnosisADesc(tblDesc));
		this.add(getId_disease_outcomeADesc(tblDesc));
		this.add(getSd_disease_outcomeADesc(tblDesc));
		this.add(getName_disease_outcomeADesc(tblDesc));
		this.add(getId_rela_with_deathADesc(tblDesc));
		this.add(getSd_rela_with_deathADesc(tblDesc));
		this.add(getName_rela_with_deathADesc(tblDesc));
		this.add(getInfectious_diseaseADesc(tblDesc));
		this.add(getDiagnosis_basisADesc(tblDesc));
		this.add(getIs_treatment_in_icuADesc(tblDesc));
		this.add(getId_icu_typeADesc(tblDesc));
		this.add(getSd_icu_typeADesc(tblDesc));
		this.add(getName_icu_typeADesc(tblDesc));
		this.add(getHospital_occurrence_dateADesc(tblDesc));
		this.add(getId_infection_factorsADesc(tblDesc));
		this.add(getSd_infection_factorsADesc(tblDesc));
		this.add(getName_infection_factorsADesc(tblDesc));
		this.add(getIs_surgeryADesc(tblDesc));
		this.add(getDi_of_hosp_infectionADesc(tblDesc));
		this.add(getIs_etiol_examinationADesc(tblDesc));
		this.add(getIs_use_antibioticsADesc(tblDesc));
		this.add(getIs_lateADesc(tblDesc));
		this.add(getFill_in_personADesc(tblDesc));
		this.add(getFill_in_dateADesc(tblDesc));
		this.add(getTitleADesc(tblDesc));
		this.add(getId_stageADesc(tblDesc));
		this.add(getSd_stageADesc(tblDesc));
		this.add(getName_stageADesc(tblDesc));
		this.add(getReject_reasonADesc(tblDesc));
		this.add(getDelete_reasonADesc(tblDesc));
		this.add(getDeletebyADesc(tblDesc));
		this.add(getCode_deletebyADesc(tblDesc));
		this.add(getName_deletebyADesc(tblDesc));
		this.add(getDeletetimeADesc(tblDesc));
		this.add(getDi_diagnosis_codeADesc(tblDesc));
		this.add(getDi_diagnosis_nameADesc(tblDesc));
		this.add(getDisease_outcome_codeADesc(tblDesc));
		this.add(getDisease_outcome_nameADesc(tblDesc));
		this.add(getRelationship_with_death_codeADesc(tblDesc));
		this.add(getRelationship_with_death_nameADesc(tblDesc));
		this.add(getIcu_type_codeADesc(tblDesc));
		this.add(getIcu_type_nameADesc(tblDesc));
		this.add(getInfection_factors_codeADesc(tblDesc));
		this.add(getInfection_factors_nameADesc(tblDesc));
		this.add(getStage_codeADesc(tblDesc));
		this.add(getStage_nameADesc(tblDesc));
		this.add(getDeleteby_codeADesc(tblDesc));
		this.add(getDeleteby_nameADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		this.setIsRefTableInfo(true);
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_hospitalreportCDesc(tblDesc));
		tblDesc.add(getId_hospitalreportCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getAdmission_dateCDesc(tblDesc));
		tblDesc.add(getDischarge_dateCDesc(tblDesc));
		tblDesc.add(getIn_hospital_daysCDesc(tblDesc));
		tblDesc.add(getMonitor_dateCDesc(tblDesc));
		tblDesc.add(getId_di_diagnosisCDesc(tblDesc));
		tblDesc.add(getSd_di_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_di_diagnosisCDesc(tblDesc));
		tblDesc.add(getId_disease_outcomeCDesc(tblDesc));
		tblDesc.add(getSd_disease_outcomeCDesc(tblDesc));
		tblDesc.add(getName_disease_outcomeCDesc(tblDesc));
		tblDesc.add(getId_rela_with_deathCDesc(tblDesc));
		tblDesc.add(getSd_rela_with_deathCDesc(tblDesc));
		tblDesc.add(getName_rela_with_deathCDesc(tblDesc));
		tblDesc.add(getInfectious_diseaseCDesc(tblDesc));
		tblDesc.add(getDiagnosis_basisCDesc(tblDesc));
		tblDesc.add(getIs_treatment_in_icuCDesc(tblDesc));
		tblDesc.add(getId_icu_typeCDesc(tblDesc));
		tblDesc.add(getSd_icu_typeCDesc(tblDesc));
		tblDesc.add(getName_icu_typeCDesc(tblDesc));
		tblDesc.add(getHospital_occurrence_dateCDesc(tblDesc));
		tblDesc.add(getId_infection_factorsCDesc(tblDesc));
		tblDesc.add(getSd_infection_factorsCDesc(tblDesc));
		tblDesc.add(getName_infection_factorsCDesc(tblDesc));
		tblDesc.add(getIs_surgeryCDesc(tblDesc));
		tblDesc.add(getDi_of_hosp_infectionCDesc(tblDesc));
		tblDesc.add(getIs_etiol_examinationCDesc(tblDesc));
		tblDesc.add(getIs_use_antibioticsCDesc(tblDesc));
		tblDesc.add(getIs_lateCDesc(tblDesc));
		tblDesc.add(getFill_in_personCDesc(tblDesc));
		tblDesc.add(getFill_in_dateCDesc(tblDesc));
		tblDesc.add(getTitleCDesc(tblDesc));
		tblDesc.add(getId_stageCDesc(tblDesc));
		tblDesc.add(getSd_stageCDesc(tblDesc));
		tblDesc.add(getName_stageCDesc(tblDesc));
		tblDesc.add(getReject_reasonCDesc(tblDesc));
		tblDesc.add(getDelete_reasonCDesc(tblDesc));
		tblDesc.add(getDeletebyCDesc(tblDesc));
		tblDesc.add(getCode_deletebyCDesc(tblDesc));
		tblDesc.add(getName_deletebyCDesc(tblDesc));
		tblDesc.add(getDeletetimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 院感上报主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hospitalreportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hospitalreport",  getId_hospitalreportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("院感上报主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊号");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdmission_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Admission_date",  getAdmission_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("入院日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDischarge_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Discharge_date",  getDischarge_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("出院日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_hospital_daysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_hospital_days",  getIn_hospital_daysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("住院天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 监测日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMonitor_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Monitor_date",  getMonitor_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("监测日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_di_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_di_diagnosis",  getId_di_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疾病诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_di_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_di_diagnosis",  getSd_di_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_di_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_di_diagnosis",  getName_di_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病转归属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_disease_outcomeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_disease_outcome",  getId_disease_outcomeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病转归");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疾病转归编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_disease_outcomeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_disease_outcome",  getSd_disease_outcomeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病转归编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病转归名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_disease_outcomeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_disease_outcome",  getName_disease_outcomeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病转归名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与死亡的关系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rela_with_deathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rela_with_death",  getId_rela_with_deathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与死亡的关系");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 与死亡的关系编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rela_with_deathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rela_with_death",  getSd_rela_with_deathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与死亡的关系编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与死亡的关系名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rela_with_deathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rela_with_death",  getName_rela_with_deathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与死亡的关系名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染性疾病病程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfectious_diseaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infectious_disease",  getInfectious_diseaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染性疾病病程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断依据属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiagnosis_basisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diagnosis_basis",  getDiagnosis_basisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断依据");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 在ICU治疗过属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_treatment_in_icuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_treatment_in_icu",  getIs_treatment_in_icuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("在ICU治疗过");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ICU科别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_icu_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_icu_type",  getId_icu_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ICU科别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * ICU科别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_icu_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_icu_type",  getSd_icu_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ICU科别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ICU科别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_icu_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_icu_type",  getName_icu_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ICU科别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 院感发生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHospital_occurrence_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hospital_occurrence_date",  getHospital_occurrence_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("院感发生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染因素属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infection_factorsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infection_factors",  getId_infection_factorsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染因素");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 感染因素编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_infection_factorsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infection_factors",  getSd_infection_factorsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染因素编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染因素名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infection_factorsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infection_factors",  getName_infection_factorsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染因素名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_surgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_surgery",  getIs_surgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否有手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 院内感染诊断依据属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_of_hosp_infectionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_of_hosp_infection",  getDi_of_hosp_infectionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("院内感染诊断依据");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病原学检查属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_etiol_examinationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_etiol_examination",  getIs_etiol_examinationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("病原学检查");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用抗生素属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_use_antibioticsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_use_antibiotics",  getIs_use_antibioticsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("使用抗生素");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否迟报属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_lateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_late",  getIs_lateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否迟报");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填报人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFill_in_personADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fill_in_person",  getFill_in_personCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("填报人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填报日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFill_in_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fill_in_date",  getFill_in_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("填报日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 院感上报标题属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Title",  getTitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("院感上报标题");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审签阶段属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stage",  getId_stageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审签阶段");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 审签阶段编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stage",  getSd_stageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审签阶段编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审签阶段名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stage",  getName_stageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审签阶段名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 驳回原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReject_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reject_reason",  getReject_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("驳回原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 删除原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDelete_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Delete_reason",  getDelete_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("删除原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 删除人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeletebyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deleteby",  getDeletebyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("删除人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 删除人编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_deletebyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_deleteby",  getCode_deletebyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("删除人编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 删除人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deletebyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_deleteby",  getName_deletebyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("删除人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 删除时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeletetimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deletetime",  getDeletetimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("删除时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_diagnosis_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_diagnosis_code",  getDi_diagnosis_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b2","id_di_diagnosis=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_diagnosis_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_diagnosis_name",  getDi_diagnosis_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b2","id_di_diagnosis=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDisease_outcome_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Disease_outcome_code",  getDisease_outcome_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_disease_outcome=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDisease_outcome_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Disease_outcome_name",  getDisease_outcome_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_disease_outcome=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelationship_with_death_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Relationship_with_death_code",  getRelationship_with_death_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_rela_with_death=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelationship_with_death_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Relationship_with_death_name",  getRelationship_with_death_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_rela_with_death=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIcu_type_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Icu_type_code",  getIcu_type_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_icu_type=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIcu_type_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Icu_type_name",  getIcu_type_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_icu_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfection_factors_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infection_factors_code",  getInfection_factors_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_infection_factors=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfection_factors_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infection_factors_name",  getInfection_factors_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_infection_factors=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStage_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Stage_code",  getStage_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_stage=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStage_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Stage_name",  getStage_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_stage=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeleteby_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deleteby_code",  getDeleteby_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b7","deleteby=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeleteby_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deleteby_name",  getDeleteby_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b7","deleteby=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取院感上报主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hospitalreportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hospitalreport");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("院感上报主键"); 
		return column;
	}
	/**
	 * 获取就诊号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊号"); 
		return column;
	}
	/**
	 * 获取入院日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdmission_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Admission_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院日期"); 
		return column;
	}
	/**
	 * 获取出院日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDischarge_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Discharge_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出院日期"); 
		return column;
	}
	/**
	 * 获取住院天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_hospital_daysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_hospital_days");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("住院天数"); 
		return column;
	}
	/**
	 * 获取监测日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMonitor_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Monitor_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("监测日期"); 
		return column;
	}
	/**
	 * 获取疾病诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_di_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_di_diagnosis");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病诊断"); 
		return column;
	}
	/**
	 * 获取疾病诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_di_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_di_diagnosis");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病诊断编码"); 
		return column;
	}
	/**
	 * 获取疾病诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_di_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_di_diagnosis");
		column.setLength(5000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病诊断名称"); 
		return column;
	}
	/**
	 * 获取疾病转归表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_disease_outcomeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_disease_outcome");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病转归"); 
		return column;
	}
	/**
	 * 获取疾病转归编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_disease_outcomeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_disease_outcome");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病转归编码"); 
		return column;
	}
	/**
	 * 获取疾病转归名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_disease_outcomeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_disease_outcome");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病转归名称"); 
		return column;
	}
	/**
	 * 获取与死亡的关系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rela_with_deathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rela_with_death");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与死亡的关系"); 
		return column;
	}
	/**
	 * 获取与死亡的关系编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rela_with_deathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rela_with_death");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与死亡的关系编码"); 
		return column;
	}
	/**
	 * 获取与死亡的关系名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rela_with_deathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rela_with_death");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与死亡的关系名称"); 
		return column;
	}
	/**
	 * 获取感染性疾病病程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfectious_diseaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infectious_disease");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染性疾病病程"); 
		return column;
	}
	/**
	 * 获取诊断依据表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiagnosis_basisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diagnosis_basis");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断依据"); 
		return column;
	}
	/**
	 * 获取在ICU治疗过表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_treatment_in_icuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_treatment_in_icu");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("在ICU治疗过"); 
		return column;
	}
	/**
	 * 获取ICU科别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_icu_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_icu_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ICU科别"); 
		return column;
	}
	/**
	 * 获取ICU科别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_icu_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_icu_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ICU科别编码"); 
		return column;
	}
	/**
	 * 获取ICU科别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_icu_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_icu_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ICU科别名称"); 
		return column;
	}
	/**
	 * 获取院感发生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHospital_occurrence_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hospital_occurrence_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("院感发生日期"); 
		return column;
	}
	/**
	 * 获取感染因素表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infection_factorsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infection_factors");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染因素"); 
		return column;
	}
	/**
	 * 获取感染因素编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_infection_factorsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infection_factors");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染因素编码"); 
		return column;
	}
	/**
	 * 获取感染因素名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_infection_factorsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infection_factors");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染因素名称"); 
		return column;
	}
	/**
	 * 获取是否有手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_surgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_surgery");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否有手术"); 
		return column;
	}
	/**
	 * 获取院内感染诊断依据表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_of_hosp_infectionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_of_hosp_infection");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("院内感染诊断依据"); 
		return column;
	}
	/**
	 * 获取病原学检查表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_etiol_examinationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_etiol_examination");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病原学检查"); 
		return column;
	}
	/**
	 * 获取使用抗生素表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_use_antibioticsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_use_antibiotics");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("使用抗生素"); 
		return column;
	}
	/**
	 * 获取是否迟报表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_lateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_late");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否迟报"); 
		return column;
	}
	/**
	 * 获取填报人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFill_in_personCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fill_in_person");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("填报人"); 
		return column;
	}
	/**
	 * 获取填报日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFill_in_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fill_in_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("填报日期"); 
		return column;
	}
	/**
	 * 获取院感上报标题表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Title");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("院感上报标题"); 
		return column;
	}
	/**
	 * 获取审签阶段表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stage");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审签阶段"); 
		return column;
	}
	/**
	 * 获取审签阶段编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审签阶段编码"); 
		return column;
	}
	/**
	 * 获取审签阶段名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审签阶段名称"); 
		return column;
	}
	/**
	 * 获取驳回原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReject_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reject_reason");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("驳回原因"); 
		return column;
	}
	/**
	 * 获取删除原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDelete_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Delete_reason");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("删除原因"); 
		return column;
	}
	/**
	 * 获取删除人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeletebyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deleteby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("删除人"); 
		return column;
	}
	/**
	 * 获取删除人编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_deletebyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_deleteby");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("删除人编码"); 
		return column;
	}
	/**
	 * 获取删除人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deletebyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_deleteby");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("删除人姓名"); 
		return column;
	}
	/**
	 * 获取删除时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeletetimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deletetime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("删除时间"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_diagnosis_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_diagnosis_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_diagnosis_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_diagnosis_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDisease_outcome_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Disease_outcome_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDisease_outcome_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Disease_outcome_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelationship_with_death_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Relationship_with_death_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelationship_with_death_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Relationship_with_death_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIcu_type_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Icu_type_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIcu_type_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Icu_type_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfection_factors_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infection_factors_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfection_factors_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infection_factors_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStage_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Stage_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStage_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Stage_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeleteby_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deleteby_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员编码"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeleteby_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deleteby_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
	}

	/**
	 * 设置实体审计信息数据映射关系
	 */
	private void setIAuditInfoFldMap(){
	}
	
}
