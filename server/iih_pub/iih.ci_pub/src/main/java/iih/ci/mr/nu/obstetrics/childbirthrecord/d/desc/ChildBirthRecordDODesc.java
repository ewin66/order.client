
package iih.ci.mr.nu.obstetrics.childbirthrecord.d.desc;

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
 * 分娩记录 DO 元数据信息
 */
public class ChildBirthRecordDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.obstetrics.childbirthrecord.d.ChildBirthRecordDO";
	public static final String CLASS_DISPALYNAME = "分娩记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mr_nu_childbirth";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_childbirth";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ChildBirthRecordDODesc(){
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
		this.setKeyDesc(getId_childbirthADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_childbirthADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getDt_zsksADesc(tblDesc));
		this.add(getDt_tmplADesc(tblDesc));
		this.add(getDt_gkqkADesc(tblDesc));
		this.add(getDt_firstADesc(tblDesc));
		this.add(getId_first_cbtpADesc(tblDesc));
		this.add(getSd_first_cbtpADesc(tblDesc));
		this.add(getId_first_protpADesc(tblDesc));
		this.add(getSd_first_protpADesc(tblDesc));
		this.add(getDt_secondADesc(tblDesc));
		this.add(getId_second_cbtpADesc(tblDesc));
		this.add(getSd_second_cbtpADesc(tblDesc));
		this.add(getId_second_protpADesc(tblDesc));
		this.add(getSd_second_protpADesc(tblDesc));
		this.add(getDt_placenta_birthADesc(tblDesc));
		this.add(getId_placenta_birthtpADesc(tblDesc));
		this.add(getSd_placenta_birthtpADesc(tblDesc));
		this.add(getId_placenta_strippingADesc(tblDesc));
		this.add(getSd_placenta_strippingADesc(tblDesc));
		this.add(getNum_amniotic_fluidADesc(tblDesc));
		this.add(getId_amniotic_fluid_charADesc(tblDesc));
		this.add(getSd_amniotic_fluid_charADesc(tblDesc));
		this.add(getNum_uterus_heightADesc(tblDesc));
		this.add(getId_perineum_statusADesc(tblDesc));
		this.add(getSd_perineum_statusADesc(tblDesc));
		this.add(getId_perineum_seriousADesc(tblDesc));
		this.add(getSd_perineum_seriousADesc(tblDesc));
		this.add(getEu_vaginal_injuryADesc(tblDesc));
		this.add(getEu_cervical_injuryADesc(tblDesc));
		this.add(getId_bloodmeasureADesc(tblDesc));
		this.add(getSd_bloodmeasureADesc(tblDesc));
		this.add(getNum_blood_afterbirthADesc(tblDesc));
		this.add(getNum_forthlabor_bloodADesc(tblDesc));
		this.add(getId_drug_afterbirthADesc(tblDesc));
		this.add(getSd_drug_afterbirthADesc(tblDesc));
		this.add(getLabor_firstADesc(tblDesc));
		this.add(getLabor_secondADesc(tblDesc));
		this.add(getLabor_thirdADesc(tblDesc));
		this.add(getLabor_totalADesc(tblDesc));
		this.add(getId_sex_aADesc(tblDesc));
		this.add(getSd_sex_aADesc(tblDesc));
		this.add(getWeigth_aADesc(tblDesc));
		this.add(getHeight_aADesc(tblDesc));
		this.add(getId_child_birth_aADesc(tblDesc));
		this.add(getSd_child_birth_aADesc(tblDesc));
		this.add(getId_asphyxia_aADesc(tblDesc));
		this.add(getSd_asphyxia_aADesc(tblDesc));
		this.add(getNum_apgar_one_aADesc(tblDesc));
		this.add(getNum_apgar_five_aADesc(tblDesc));
		this.add(getNum_apgar_ten_aADesc(tblDesc));
		this.add(getEu_skin_aADesc(tblDesc));
		this.add(getEu_breath_aADesc(tblDesc));
		this.add(getEu_heartbeat_aADesc(tblDesc));
		this.add(getEu_muscle_aADesc(tblDesc));
		this.add(getEu_reflection_aADesc(tblDesc));
		this.add(getId_umbilicalcord_part_aADesc(tblDesc));
		this.add(getSd_umbilicalcord_part_aADesc(tblDesc));
		this.add(getNum_umbilicalcord_part_aADesc(tblDesc));
		this.add(getId_umbilicalcord_ligation_aADesc(tblDesc));
		this.add(getSd_umbilicalcord_ligation_aADesc(tblDesc));
		this.add(getId_eyes_handle_aADesc(tblDesc));
		this.add(getSd_eyes_handle_aADesc(tblDesc));
		this.add(getLength_umbilicalcord_aADesc(tblDesc));
		this.add(getDes_unusual_aADesc(tblDesc));
		this.add(getId_sex_bADesc(tblDesc));
		this.add(getSd_sex_bADesc(tblDesc));
		this.add(getWeigth_bADesc(tblDesc));
		this.add(getHeight_bADesc(tblDesc));
		this.add(getId_child_birth_bADesc(tblDesc));
		this.add(getSd_child_birth_bADesc(tblDesc));
		this.add(getId_asphyxia_bADesc(tblDesc));
		this.add(getSd_asphyxia_bADesc(tblDesc));
		this.add(getNum_apgar_one_bADesc(tblDesc));
		this.add(getNum_apgar_five_bADesc(tblDesc));
		this.add(getNum_apgar_ten_bADesc(tblDesc));
		this.add(getEu_skin_bADesc(tblDesc));
		this.add(getEu_breath_bADesc(tblDesc));
		this.add(getEu_heartbeat_bADesc(tblDesc));
		this.add(getEu_muscle_bADesc(tblDesc));
		this.add(getEu_reflection_bADesc(tblDesc));
		this.add(getId_umbilicalcord_part_bADesc(tblDesc));
		this.add(getSd_umbilicalcord_part_bADesc(tblDesc));
		this.add(getNum_umbilicalcord_part_bADesc(tblDesc));
		this.add(getId_umbilicalcord_ligation_bADesc(tblDesc));
		this.add(getSd_umbilicalcord_ligation_bADesc(tblDesc));
		this.add(getId_eyes_handle_bADesc(tblDesc));
		this.add(getSd_eyes_handle_bADesc(tblDesc));
		this.add(getLength_umbilicalcord_bADesc(tblDesc));
		this.add(getDes_unusual_bADesc(tblDesc));
		this.add(getId_placenta_statusADesc(tblDesc));
		this.add(getSd_placenta_statusADesc(tblDesc));
		this.add(getId_membranes_statusADesc(tblDesc));
		this.add(getSd_membranes_statusADesc(tblDesc));
		this.add(getMembranes_ruptureADesc(tblDesc));
		this.add(getLength_plaADesc(tblDesc));
		this.add(getWidth_plaADesc(tblDesc));
		this.add(getHeight_plaADesc(tblDesc));
		this.add(getId_perineum_cutADesc(tblDesc));
		this.add(getSd_perineum_cutADesc(tblDesc));
		this.add(getId_childbirth_narcosis_typeADesc(tblDesc));
		this.add(getSd_childbirth_narcosis_typeADesc(tblDesc));
		this.add(getId_childbirth_narcosis_drugADesc(tblDesc));
		this.add(getSd_childbirth_narcosis_drugADesc(tblDesc));
		this.add(getNum_drug_leftADesc(tblDesc));
		this.add(getNum_drug_rightADesc(tblDesc));
		this.add(getIndicationsADesc(tblDesc));
		this.add(getId_suture_typeADesc(tblDesc));
		this.add(getSd_suture_typeADesc(tblDesc));
		this.add(getId_childbirth_operationADesc(tblDesc));
		this.add(getSd_childbirth_operationADesc(tblDesc));
		this.add(getIndications_operADesc(tblDesc));
		this.add(getSpecial_caseADesc(tblDesc));
		this.add(getDiagnosisADesc(tblDesc));
		this.add(getId_emp_deliveringADesc(tblDesc));
		this.add(getId_dep_sutureADesc(tblDesc));
		this.add(getId_dep_assistADesc(tblDesc));
		this.add(getId_dep_countingADesc(tblDesc));
		this.add(getId_dep_recordADesc(tblDesc));
		this.add(getId_groupADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getDt_birth_patADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_depADesc(tblDesc));
		this.add(getName_bithtp_aADesc(tblDesc));
		this.add(getName_protp_aADesc(tblDesc));
		this.add(getName_birthtp_bADesc(tblDesc));
		this.add(getName_proptp_bADesc(tblDesc));
		this.add(getName_placenta_birthtpADesc(tblDesc));
		this.add(getName_placenta_strippingADesc(tblDesc));
		this.add(getName_amniotic_fluid_charADesc(tblDesc));
		this.add(getName_perineum_statusADesc(tblDesc));
		this.add(getName_perineum_seriousADesc(tblDesc));
		this.add(getName_bloodmeasureADesc(tblDesc));
		this.add(getName_drug_afterbirthADesc(tblDesc));
		this.add(getName_sex_aADesc(tblDesc));
		this.add(getName_child_birth_aADesc(tblDesc));
		this.add(getName_asphyxia_aADesc(tblDesc));
		this.add(getName_umbilicalcord_part_aADesc(tblDesc));
		this.add(getName_umbilicalcord_ligation_aADesc(tblDesc));
		this.add(getName_eyes_handle_aADesc(tblDesc));
		this.add(getName_sex_bADesc(tblDesc));
		this.add(getName_child_birth_bADesc(tblDesc));
		this.add(getName_asphyxia_bADesc(tblDesc));
		this.add(getName_umbilicalcord_part_bADesc(tblDesc));
		this.add(getName_umbilicalcord_ligation_bADesc(tblDesc));
		this.add(getNam_eyes_handle_bADesc(tblDesc));
		this.add(getName_placenta_statusADesc(tblDesc));
		this.add(getName_membranes_statusADesc(tblDesc));
		this.add(getName_perineum_cutADesc(tblDesc));
		this.add(getName_childbirth_narcosis_typeADesc(tblDesc));
		this.add(getName_narcosis_drugADesc(tblDesc));
		this.add(getName_suture_typeADesc(tblDesc));
		this.add(getName_childbirth_operationADesc(tblDesc));
		this.add(getName_deliveringADesc(tblDesc));
		this.add(getName_sutureADesc(tblDesc));
		this.add(getName_assistADesc(tblDesc));
		this.add(getName_countingADesc(tblDesc));
		this.add(getName_mrrecordADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_childbirthCDesc(tblDesc));
		tblDesc.add(getId_childbirthCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getDt_zsksCDesc(tblDesc));
		tblDesc.add(getDt_tmplCDesc(tblDesc));
		tblDesc.add(getDt_gkqkCDesc(tblDesc));
		tblDesc.add(getDt_firstCDesc(tblDesc));
		tblDesc.add(getId_first_cbtpCDesc(tblDesc));
		tblDesc.add(getSd_first_cbtpCDesc(tblDesc));
		tblDesc.add(getId_first_protpCDesc(tblDesc));
		tblDesc.add(getSd_first_protpCDesc(tblDesc));
		tblDesc.add(getDt_secondCDesc(tblDesc));
		tblDesc.add(getId_second_cbtpCDesc(tblDesc));
		tblDesc.add(getSd_second_cbtpCDesc(tblDesc));
		tblDesc.add(getId_second_protpCDesc(tblDesc));
		tblDesc.add(getSd_second_protpCDesc(tblDesc));
		tblDesc.add(getDt_placenta_birthCDesc(tblDesc));
		tblDesc.add(getId_placenta_birthtpCDesc(tblDesc));
		tblDesc.add(getSd_placenta_birthtpCDesc(tblDesc));
		tblDesc.add(getId_placenta_strippingCDesc(tblDesc));
		tblDesc.add(getSd_placenta_strippingCDesc(tblDesc));
		tblDesc.add(getNum_amniotic_fluidCDesc(tblDesc));
		tblDesc.add(getId_amniotic_fluid_charCDesc(tblDesc));
		tblDesc.add(getSd_amniotic_fluid_charCDesc(tblDesc));
		tblDesc.add(getNum_uterus_heightCDesc(tblDesc));
		tblDesc.add(getId_perineum_statusCDesc(tblDesc));
		tblDesc.add(getSd_perineum_statusCDesc(tblDesc));
		tblDesc.add(getId_perineum_seriousCDesc(tblDesc));
		tblDesc.add(getSd_perineum_seriousCDesc(tblDesc));
		tblDesc.add(getEu_vaginal_injuryCDesc(tblDesc));
		tblDesc.add(getEu_cervical_injuryCDesc(tblDesc));
		tblDesc.add(getId_bloodmeasureCDesc(tblDesc));
		tblDesc.add(getSd_bloodmeasureCDesc(tblDesc));
		tblDesc.add(getNum_blood_afterbirthCDesc(tblDesc));
		tblDesc.add(getNum_forthlabor_bloodCDesc(tblDesc));
		tblDesc.add(getId_drug_afterbirthCDesc(tblDesc));
		tblDesc.add(getSd_drug_afterbirthCDesc(tblDesc));
		tblDesc.add(getLabor_firstCDesc(tblDesc));
		tblDesc.add(getLabor_secondCDesc(tblDesc));
		tblDesc.add(getLabor_thirdCDesc(tblDesc));
		tblDesc.add(getLabor_totalCDesc(tblDesc));
		tblDesc.add(getId_sex_aCDesc(tblDesc));
		tblDesc.add(getSd_sex_aCDesc(tblDesc));
		tblDesc.add(getWeigth_aCDesc(tblDesc));
		tblDesc.add(getHeight_aCDesc(tblDesc));
		tblDesc.add(getId_child_birth_aCDesc(tblDesc));
		tblDesc.add(getSd_child_birth_aCDesc(tblDesc));
		tblDesc.add(getId_asphyxia_aCDesc(tblDesc));
		tblDesc.add(getSd_asphyxia_aCDesc(tblDesc));
		tblDesc.add(getNum_apgar_one_aCDesc(tblDesc));
		tblDesc.add(getNum_apgar_five_aCDesc(tblDesc));
		tblDesc.add(getNum_apgar_ten_aCDesc(tblDesc));
		tblDesc.add(getEu_skin_aCDesc(tblDesc));
		tblDesc.add(getEu_breath_aCDesc(tblDesc));
		tblDesc.add(getEu_heartbeat_aCDesc(tblDesc));
		tblDesc.add(getEu_muscle_aCDesc(tblDesc));
		tblDesc.add(getEu_reflection_aCDesc(tblDesc));
		tblDesc.add(getId_umbilicalcord_part_aCDesc(tblDesc));
		tblDesc.add(getSd_umbilicalcord_part_aCDesc(tblDesc));
		tblDesc.add(getNum_umbilicalcord_part_aCDesc(tblDesc));
		tblDesc.add(getId_umbilicalcord_ligation_aCDesc(tblDesc));
		tblDesc.add(getSd_umbilicalcord_ligation_aCDesc(tblDesc));
		tblDesc.add(getId_eyes_handle_aCDesc(tblDesc));
		tblDesc.add(getSd_eyes_handle_aCDesc(tblDesc));
		tblDesc.add(getLength_umbilicalcord_aCDesc(tblDesc));
		tblDesc.add(getDes_unusual_aCDesc(tblDesc));
		tblDesc.add(getId_sex_bCDesc(tblDesc));
		tblDesc.add(getSd_sex_bCDesc(tblDesc));
		tblDesc.add(getWeigth_bCDesc(tblDesc));
		tblDesc.add(getHeight_bCDesc(tblDesc));
		tblDesc.add(getId_child_birth_bCDesc(tblDesc));
		tblDesc.add(getSd_child_birth_bCDesc(tblDesc));
		tblDesc.add(getId_asphyxia_bCDesc(tblDesc));
		tblDesc.add(getSd_asphyxia_bCDesc(tblDesc));
		tblDesc.add(getNum_apgar_one_bCDesc(tblDesc));
		tblDesc.add(getNum_apgar_five_bCDesc(tblDesc));
		tblDesc.add(getNum_apgar_ten_bCDesc(tblDesc));
		tblDesc.add(getEu_skin_bCDesc(tblDesc));
		tblDesc.add(getEu_breath_bCDesc(tblDesc));
		tblDesc.add(getEu_heartbeat_bCDesc(tblDesc));
		tblDesc.add(getEu_muscle_bCDesc(tblDesc));
		tblDesc.add(getEu_reflection_bCDesc(tblDesc));
		tblDesc.add(getId_umbilicalcord_part_bCDesc(tblDesc));
		tblDesc.add(getSd_umbilicalcord_part_bCDesc(tblDesc));
		tblDesc.add(getNum_umbilicalcord_part_bCDesc(tblDesc));
		tblDesc.add(getId_umbilicalcord_ligation_bCDesc(tblDesc));
		tblDesc.add(getSd_umbilicalcord_ligation_bCDesc(tblDesc));
		tblDesc.add(getId_eyes_handle_bCDesc(tblDesc));
		tblDesc.add(getSd_eyes_handle_bCDesc(tblDesc));
		tblDesc.add(getLength_umbilicalcord_bCDesc(tblDesc));
		tblDesc.add(getDes_unusual_bCDesc(tblDesc));
		tblDesc.add(getId_placenta_statusCDesc(tblDesc));
		tblDesc.add(getSd_placenta_statusCDesc(tblDesc));
		tblDesc.add(getId_membranes_statusCDesc(tblDesc));
		tblDesc.add(getSd_membranes_statusCDesc(tblDesc));
		tblDesc.add(getMembranes_ruptureCDesc(tblDesc));
		tblDesc.add(getLength_plaCDesc(tblDesc));
		tblDesc.add(getWidth_plaCDesc(tblDesc));
		tblDesc.add(getHeight_plaCDesc(tblDesc));
		tblDesc.add(getId_perineum_cutCDesc(tblDesc));
		tblDesc.add(getSd_perineum_cutCDesc(tblDesc));
		tblDesc.add(getId_childbirth_narcosis_typeCDesc(tblDesc));
		tblDesc.add(getSd_childbirth_narcosis_typeCDesc(tblDesc));
		tblDesc.add(getId_childbirth_narcosis_drugCDesc(tblDesc));
		tblDesc.add(getSd_childbirth_narcosis_drugCDesc(tblDesc));
		tblDesc.add(getNum_drug_leftCDesc(tblDesc));
		tblDesc.add(getNum_drug_rightCDesc(tblDesc));
		tblDesc.add(getIndicationsCDesc(tblDesc));
		tblDesc.add(getId_suture_typeCDesc(tblDesc));
		tblDesc.add(getSd_suture_typeCDesc(tblDesc));
		tblDesc.add(getId_childbirth_operationCDesc(tblDesc));
		tblDesc.add(getSd_childbirth_operationCDesc(tblDesc));
		tblDesc.add(getIndications_operCDesc(tblDesc));
		tblDesc.add(getSpecial_caseCDesc(tblDesc));
		tblDesc.add(getDiagnosisCDesc(tblDesc));
		tblDesc.add(getId_emp_deliveringCDesc(tblDesc));
		tblDesc.add(getId_dep_sutureCDesc(tblDesc));
		tblDesc.add(getId_dep_assistCDesc(tblDesc));
		tblDesc.add(getId_dep_countingCDesc(tblDesc));
		tblDesc.add(getId_dep_recordCDesc(tblDesc));
		tblDesc.add(getId_groupCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 分娩记录主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_childbirthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_childbirth",  getId_childbirthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩记录主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_entp",  getCode_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age",  getAgeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理单元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 床号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bed",  getName_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 阵缩开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_zsksADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_zsks",  getDt_zsksCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("阵缩开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜破裂时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_tmplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_tmpl",  getDt_tmplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("胎膜破裂时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫口全开时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_gkqkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_gkqk",  getDt_gkqkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("宫口全开时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿娩出时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_firstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_first",  getDt_firstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("A胎儿娩出时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿娩出方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_first_cbtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_first_cbtp",  getId_first_cbtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿娩出方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * A胎儿娩出方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_first_cbtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_first_cbtp",  getSd_first_cbtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿娩出方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿产式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_first_protpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_first_protp",  getId_first_protpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿产式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * A胎儿产式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_first_protpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_first_protp",  getSd_first_protpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿产式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿娩出时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_secondADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_second",  getDt_secondCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("B胎儿娩出时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿娩出方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_second_cbtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_second_cbtp",  getId_second_cbtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿娩出方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * B胎儿娩出方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_second_cbtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_second_cbtp",  getSd_second_cbtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿娩出方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿产式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_second_protpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_second_protp",  getId_second_protpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿产式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * B胎儿产式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_second_protpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_second_protp",  getSd_second_protpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿产式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘娩出时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_placenta_birthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_placenta_birth",  getDt_placenta_birthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("胎盘娩出时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘分娩方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_placenta_birthtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_placenta_birthtp",  getId_placenta_birthtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘分娩方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎盘分娩方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_placenta_birthtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_placenta_birthtp",  getSd_placenta_birthtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘分娩方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘剥离属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_placenta_strippingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_placenta_stripping",  getId_placenta_strippingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘剥离");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎盘剥离编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_placenta_strippingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_placenta_stripping",  getSd_placenta_strippingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘剥离编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_amniotic_fluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_amniotic_fluid",  getNum_amniotic_fluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("羊水量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水性状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_amniotic_fluid_charADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_amniotic_fluid_char",  getId_amniotic_fluid_charCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水性状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 羊水性状编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_amniotic_fluid_charADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_amniotic_fluid_char",  getSd_amniotic_fluid_charCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水性状编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫底高度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_uterus_heightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_uterus_height",  getNum_uterus_heightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("宫底高度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perineum_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perineum_status",  getId_perineum_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会阴状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_perineum_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_perineum_status",  getSd_perineum_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴状况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴严重程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perineum_seriousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perineum_serious",  getId_perineum_seriousCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴严重程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会阴严重程度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_perineum_seriousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_perineum_serious",  getSd_perineum_seriousCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴严重程度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 阴道伤裂属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_vaginal_injuryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_vaginal_injury",  getEu_vaginal_injuryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("阴道伤裂");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫颈伤裂属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_cervical_injuryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_cervical_injury",  getEu_cervical_injuryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("宫颈伤裂");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后出血测定属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodmeasureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodmeasure",  getId_bloodmeasureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产后出血测定");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 产后出血测定编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodmeasureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodmeasure",  getSd_bloodmeasureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产后出血测定编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后出血量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_blood_afterbirthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_blood_afterbirth",  getNum_blood_afterbirthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产后出血量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 第四程出血量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_forthlabor_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_forthlabor_blood",  getNum_forthlabor_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("第四程出血量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后用药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drug_afterbirthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drug_afterbirth",  getId_drug_afterbirthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产后用药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 产后用药编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_drug_afterbirthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_drug_afterbirth",  getSd_drug_afterbirthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产后用药编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 一程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLabor_firstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Labor_first",  getLabor_firstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("一程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 二程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLabor_secondADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Labor_second",  getLabor_secondCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("二程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 三程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLabor_thirdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Labor_third",  getLabor_thirdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("三程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总产程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLabor_totalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Labor_total",  getLabor_totalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总产程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sex_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex_a",  getId_sex_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * A胎儿性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_a",  getSd_sex_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeigth_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weigth_a",  getWeigth_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("A胎儿体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿身长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeight_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Height_a",  getHeight_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("A胎儿身长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿分娩方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_child_birth_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_child_birth_a",  getId_child_birth_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿分娩方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * A胎儿分娩方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_child_birth_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_child_birth_a",  getSd_child_birth_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿分娩方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿窒息情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_asphyxia_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_asphyxia_a",  getId_asphyxia_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿窒息情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * A胎儿窒息情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_asphyxia_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_asphyxia_a",  getSd_asphyxia_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿窒息情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿Apgar评估1分钟属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_apgar_one_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_apgar_one_a",  getNum_apgar_one_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("A胎儿Apgar评估1分钟");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿Apgar评估5分钟属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_apgar_five_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_apgar_five_a",  getNum_apgar_five_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("A胎儿Apgar评估5分钟");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿Apgar评估10分钟属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_apgar_ten_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_apgar_ten_a",  getNum_apgar_ten_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("A胎儿Apgar评估10分钟");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿皮肤扣分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_skin_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_skin_a",  getEu_skin_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("A胎儿皮肤扣分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿呼吸扣分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_breath_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_breath_a",  getEu_breath_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("A胎儿呼吸扣分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿心跳扣分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_heartbeat_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_heartbeat_a",  getEu_heartbeat_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("A胎儿心跳扣分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿肌张力扣分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_muscle_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_muscle_a",  getEu_muscle_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("A胎儿肌张力扣分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿反射扣分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_reflection_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_reflection_a",  getEu_reflection_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("A胎儿反射扣分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿脐带缠绕部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_umbilicalcord_part_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_umbilicalcord_part_a",  getId_umbilicalcord_part_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿脐带缠绕部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * A胎儿脐带缠绕部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_umbilicalcord_part_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_umbilicalcord_part_a",  getSd_umbilicalcord_part_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿脐带缠绕部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿脐带缠绕周数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_umbilicalcord_part_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_umbilicalcord_part_a",  getNum_umbilicalcord_part_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("A胎儿脐带缠绕周数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿脐带结扎方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_umbilicalcord_ligation_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_umbilicalcord_ligation_a",  getId_umbilicalcord_ligation_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿脐带结扎方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * A胎儿脐带结扎方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_umbilicalcord_ligation_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_umbilicalcord_ligation_a",  getSd_umbilicalcord_ligation_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿脐带结扎方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿眼处理方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eyes_handle_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eyes_handle_a",  getId_eyes_handle_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿眼处理方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * A胎儿眼处理方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_eyes_handle_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_eyes_handle_a",  getSd_eyes_handle_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿眼处理方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿脐带长度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLength_umbilicalcord_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Length_umbilicalcord_a",  getLength_umbilicalcord_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("A胎儿脐带长度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿异常及并发症属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_unusual_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_unusual_a",  getDes_unusual_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿异常及并发症");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sex_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex_b",  getId_sex_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * B胎儿性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_b",  getSd_sex_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeigth_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weigth_b",  getWeigth_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("B胎儿体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿身长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeight_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Height_b",  getHeight_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("B胎儿身长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿分娩方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_child_birth_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_child_birth_b",  getId_child_birth_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿分娩方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * B胎儿分娩方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_child_birth_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_child_birth_b",  getSd_child_birth_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿分娩方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿窒息情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_asphyxia_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_asphyxia_b",  getId_asphyxia_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿窒息情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * B胎儿窒息情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_asphyxia_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_asphyxia_b",  getSd_asphyxia_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿窒息情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿Apgar评估1分钟属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_apgar_one_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_apgar_one_b",  getNum_apgar_one_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("B胎儿Apgar评估1分钟");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿Apgar评估5分钟属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_apgar_five_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_apgar_five_b",  getNum_apgar_five_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("B胎儿Apgar评估5分钟");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿Apgar评估10分钟属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_apgar_ten_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_apgar_ten_b",  getNum_apgar_ten_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("B胎儿Apgar评估10分钟");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿皮肤扣分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_skin_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_skin_b",  getEu_skin_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("B胎儿皮肤扣分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿呼吸扣分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_breath_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_breath_b",  getEu_breath_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("B胎儿呼吸扣分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿心跳扣分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_heartbeat_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_heartbeat_b",  getEu_heartbeat_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("B胎儿心跳扣分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿肌张力扣分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_muscle_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_muscle_b",  getEu_muscle_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("B胎儿肌张力扣分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿发射扣分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_reflection_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_reflection_b",  getEu_reflection_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("B胎儿发射扣分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿脐带缠绕部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_umbilicalcord_part_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_umbilicalcord_part_b",  getId_umbilicalcord_part_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿脐带缠绕部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * B胎儿脐带缠绕部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_umbilicalcord_part_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_umbilicalcord_part_b",  getSd_umbilicalcord_part_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿脐带缠绕部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿脐带缠绕周数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_umbilicalcord_part_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_umbilicalcord_part_b",  getNum_umbilicalcord_part_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("B胎儿脐带缠绕周数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿脐带结扎方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_umbilicalcord_ligation_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_umbilicalcord_ligation_b",  getId_umbilicalcord_ligation_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿脐带结扎方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * B胎儿脐带结扎方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_umbilicalcord_ligation_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_umbilicalcord_ligation_b",  getSd_umbilicalcord_ligation_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿脐带结扎方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿眼处理方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eyes_handle_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eyes_handle_b",  getId_eyes_handle_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿眼处理方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * B胎儿眼处理方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_eyes_handle_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_eyes_handle_b",  getSd_eyes_handle_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿眼处理方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿脐带长度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLength_umbilicalcord_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Length_umbilicalcord_b",  getLength_umbilicalcord_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("B胎儿脐带长度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿异常及并发症属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_unusual_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_unusual_b",  getDes_unusual_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿异常及并发症");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_placenta_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_placenta_status",  getId_placenta_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎盘情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_placenta_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_placenta_status",  getSd_placenta_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_membranes_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_membranes_status",  getId_membranes_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎膜情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_membranes_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_membranes_status",  getSd_membranes_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜破裂部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMembranes_ruptureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Membranes_rupture",  getMembranes_ruptureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜破裂部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLength_plaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Length_pla",  getLength_plaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宽属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWidth_plaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Width_pla",  getWidth_plaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("宽");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 高属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeight_plaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Height_pla",  getHeight_plaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("高");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴切开方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perineum_cutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perineum_cut",  getId_perineum_cutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴切开方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会阴切开方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_perineum_cutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_perineum_cut",  getSd_perineum_cutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴切开方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_childbirth_narcosis_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_childbirth_narcosis_type",  getId_childbirth_narcosis_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 麻醉方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_childbirth_narcosis_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_childbirth_narcosis_type",  getSd_childbirth_narcosis_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩麻醉药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_childbirth_narcosis_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_childbirth_narcosis_drug",  getId_childbirth_narcosis_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩麻醉药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 分娩麻醉药编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_childbirth_narcosis_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_childbirth_narcosis_drug",  getSd_childbirth_narcosis_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩麻醉药编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左侧用药量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_drug_leftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_drug_left",  getNum_drug_leftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("左侧用药量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右侧用药量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_drug_rightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_drug_right",  getNum_drug_rightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("右侧用药量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 适应症属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIndicationsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Indications",  getIndicationsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("适应症");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 缝合类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_suture_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_suture_type",  getId_suture_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("缝合类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 缝合类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_suture_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_suture_type",  getSd_suture_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("缝合类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_childbirth_operationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_childbirth_operation",  getId_childbirth_operationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_childbirth_operationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_childbirth_operation",  getSd_childbirth_operationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术适应症属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIndications_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Indications_oper",  getIndications_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术适应症");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特殊情况及处理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecial_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Special_case",  getSpecial_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊情况及处理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diagnosis",  getDiagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接生者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_deliveringADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_delivering",  getId_emp_deliveringCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接生者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 缝合者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_sutureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_suture",  getId_dep_sutureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("缝合者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 辅助者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_assistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_assist",  getId_dep_assistCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("辅助者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 纱布清点者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_countingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_counting",  getId_dep_countingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("纱布清点者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病历记录着属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_record",  getId_dep_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历记录着");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_groupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_group",  getId_groupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 创建人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdby",  getCreatedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("创建人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 创建时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdtime",  getCreatedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("创建时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后修改人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedby",  getModifiedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最后修改人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最后修改时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedtime",  getModifiedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("最后修改时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b2","id_pat=id_pat","code_amr_ip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者出生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_birth_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_birth_pat",  getDt_birth_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("患者出生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b3","id_ent=id_ent","dt_birth_pat"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b3","id_ent=id_ent","name_pat"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理单元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep",  getName_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b4","id_dep_nur=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿娩出方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bithtp_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bithtp_a",  getName_bithtp_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿娩出方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_first_cbtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿产式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_protp_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_protp_a",  getName_protp_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿产式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_first_protp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿分娩方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_birthtp_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_birthtp_b",  getName_birthtp_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿分娩方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_second_cbtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿产式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_proptp_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_proptp_b",  getName_proptp_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿产式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_second_protp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘分娩方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_placenta_birthtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_placenta_birthtp",  getName_placenta_birthtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘分娩方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_placenta_birthtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘剥离属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_placenta_strippingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_placenta_stripping",  getName_placenta_strippingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘剥离");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_placenta_stripping=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水性状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_amniotic_fluid_charADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_amniotic_fluid_char",  getName_amniotic_fluid_charCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水性状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_amniotic_fluid_char=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_perineum_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_perineum_status",  getName_perineum_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_perineum_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴严重程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_perineum_seriousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_perineum_serious",  getName_perineum_seriousCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴严重程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_perineum_serious=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后出血测定属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodmeasureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodmeasure",  getName_bloodmeasureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产后出血测定");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b39","id_bloodmeasure=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后用药称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drug_afterbirthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drug_afterbirth",  getName_drug_afterbirthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产后用药称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b36","id_drug_afterbirth=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sex_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex_a",  getName_sex_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_sex_a=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿分娩方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_child_birth_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_child_birth_a",  getName_child_birth_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿分娩方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b37","id_child_birth_a=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 窒息情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_asphyxia_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_asphyxia_a",  getName_asphyxia_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("窒息情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b38","id_asphyxia_a=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿脐带缠绕部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_umbilicalcord_part_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_umbilicalcord_part_a",  getName_umbilicalcord_part_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿脐带缠绕部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_umbilicalcord_part_a=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿脐带结扎方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_umbilicalcord_ligation_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_umbilicalcord_ligation_a",  getName_umbilicalcord_ligation_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿脐带结扎方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_umbilicalcord_ligation_a=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * A胎儿眼处理方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_eyes_handle_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_eyes_handle_a",  getName_eyes_handle_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("A胎儿眼处理方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_eyes_handle_a=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sex_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex_b",  getName_sex_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_sex_b=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿分娩方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_child_birth_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_child_birth_b",  getName_child_birth_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿分娩方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_child_birth_b=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿窒息程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_asphyxia_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_asphyxia_b",  getName_asphyxia_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿窒息程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b30","id_asphyxia_b=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿脐带缠绕部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_umbilicalcord_part_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_umbilicalcord_part_b",  getName_umbilicalcord_part_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿脐带缠绕部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b31","id_umbilicalcord_part_b=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿脐带结扎方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_umbilicalcord_ligation_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_umbilicalcord_ligation_b",  getName_umbilicalcord_ligation_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿脐带结扎方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b32","id_umbilicalcord_ligation_b=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * B胎儿眼处理方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNam_eyes_handle_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nam_eyes_handle_b",  getNam_eyes_handle_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("B胎儿眼处理方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b33","id_eyes_handle_b=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_placenta_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_placenta_status",  getName_placenta_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b34","id_placenta_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_membranes_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_membranes_status",  getName_membranes_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b35","id_membranes_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴切开方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_perineum_cutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_perineum_cut",  getName_perineum_cutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴切开方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_perineum_cut=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩麻醉方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_childbirth_narcosis_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_childbirth_narcosis_type",  getName_childbirth_narcosis_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩麻醉方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_childbirth_narcosis_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩麻醉药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_narcosis_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_narcosis_drug",  getName_narcosis_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩麻醉药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_childbirth_narcosis_drug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_suture_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_suture_type",  getName_suture_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_suture_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_childbirth_operationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_childbirth_operation",  getName_childbirth_operationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_childbirth_operation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接生者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deliveringADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_delivering",  getName_deliveringCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接生者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b19","id_emp_delivering=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 缝合者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sutureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_suture",  getName_sutureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("缝合者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b20","id_dep_suture=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 辅助者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_assistADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_assist",  getName_assistCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("辅助者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b21","id_dep_assist=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清点者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_countingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_counting",  getName_countingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清点者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b22","id_dep_counting=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mrrecordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mrrecord",  getName_mrrecordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b23","id_dep_record=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取分娩记录主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_childbirthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_childbirth");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("分娩记录主键标识"); 
		return column;
	}
	/**
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
		return column;
	}
	/**
	 * 获取就诊ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊ID"); 
		return column;
	}
	/**
	 * 获取就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_entp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型"); 
		return column;
	}
	/**
	 * 获取年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄"); 
		return column;
	}
	/**
	 * 获取护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元"); 
		return column;
	}
	/**
	 * 获取床号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床号"); 
		return column;
	}
	/**
	 * 获取阵缩开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_zsksCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_zsks");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("阵缩开始时间"); 
		return column;
	}
	/**
	 * 获取胎膜破裂时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_tmplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_tmpl");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("胎膜破裂时间"); 
		return column;
	}
	/**
	 * 获取宫口全开时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_gkqkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_gkqk");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("宫口全开时间"); 
		return column;
	}
	/**
	 * 获取A胎儿娩出时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_firstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_first");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("A胎儿娩出时间"); 
		return column;
	}
	/**
	 * 获取A胎儿娩出方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_first_cbtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_first_cbtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿娩出方式"); 
		return column;
	}
	/**
	 * 获取A胎儿娩出方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_first_cbtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_first_cbtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿娩出方式编码"); 
		return column;
	}
	/**
	 * 获取A胎儿产式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_first_protpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_first_protp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿产式"); 
		return column;
	}
	/**
	 * 获取A胎儿产式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_first_protpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_first_protp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿产式编码"); 
		return column;
	}
	/**
	 * 获取B胎儿娩出时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_secondCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_second");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("B胎儿娩出时间"); 
		return column;
	}
	/**
	 * 获取B胎儿娩出方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_second_cbtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_second_cbtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿娩出方式"); 
		return column;
	}
	/**
	 * 获取B胎儿娩出方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_second_cbtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_second_cbtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿娩出方式编码"); 
		return column;
	}
	/**
	 * 获取B胎儿产式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_second_protpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_second_protp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿产式"); 
		return column;
	}
	/**
	 * 获取B胎儿产式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_second_protpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_second_protp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿产式编码"); 
		return column;
	}
	/**
	 * 获取胎盘娩出时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_placenta_birthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_placenta_birth");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("胎盘娩出时间"); 
		return column;
	}
	/**
	 * 获取胎盘分娩方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_placenta_birthtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_placenta_birthtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘分娩方式"); 
		return column;
	}
	/**
	 * 获取胎盘分娩方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_placenta_birthtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_placenta_birthtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘分娩方式编码"); 
		return column;
	}
	/**
	 * 获取胎盘剥离表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_placenta_strippingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_placenta_stripping");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘剥离"); 
		return column;
	}
	/**
	 * 获取胎盘剥离编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_placenta_strippingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_placenta_stripping");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘剥离编码"); 
		return column;
	}
	/**
	 * 获取羊水量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_amniotic_fluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_amniotic_fluid");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("羊水量"); 
		return column;
	}
	/**
	 * 获取羊水性状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_amniotic_fluid_charCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_amniotic_fluid_char");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水性状"); 
		return column;
	}
	/**
	 * 获取羊水性状编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_amniotic_fluid_charCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_amniotic_fluid_char");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水性状编码"); 
		return column;
	}
	/**
	 * 获取宫底高度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_uterus_heightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_uterus_height");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("宫底高度"); 
		return column;
	}
	/**
	 * 获取会阴状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perineum_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perineum_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴状况"); 
		return column;
	}
	/**
	 * 获取会阴状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_perineum_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_perineum_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴状况编码"); 
		return column;
	}
	/**
	 * 获取会阴严重程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perineum_seriousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perineum_serious");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴严重程度"); 
		return column;
	}
	/**
	 * 获取会阴严重程度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_perineum_seriousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_perineum_serious");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴严重程度编码"); 
		return column;
	}
	/**
	 * 获取阴道伤裂表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_vaginal_injuryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_vaginal_injury");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("阴道伤裂"); 
		return column;
	}
	/**
	 * 获取宫颈伤裂表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_cervical_injuryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_cervical_injury");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("宫颈伤裂"); 
		return column;
	}
	/**
	 * 获取产后出血测定表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodmeasureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodmeasure");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产后出血测定"); 
		return column;
	}
	/**
	 * 获取产后出血测定编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodmeasureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodmeasure");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产后出血测定编码"); 
		return column;
	}
	/**
	 * 获取产后出血量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_blood_afterbirthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_blood_afterbirth");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产后出血量"); 
		return column;
	}
	/**
	 * 获取第四程出血量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_forthlabor_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_forthlabor_blood");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("第四程出血量"); 
		return column;
	}
	/**
	 * 获取产后用药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drug_afterbirthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drug_afterbirth");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产后用药"); 
		return column;
	}
	/**
	 * 获取产后用药编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_drug_afterbirthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_drug_afterbirth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产后用药编码"); 
		return column;
	}
	/**
	 * 获取一程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLabor_firstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Labor_first");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("一程"); 
		return column;
	}
	/**
	 * 获取二程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLabor_secondCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Labor_second");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("二程"); 
		return column;
	}
	/**
	 * 获取三程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLabor_thirdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Labor_third");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("三程"); 
		return column;
	}
	/**
	 * 获取总产程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLabor_totalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Labor_total");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总产程"); 
		return column;
	}
	/**
	 * 获取A胎儿性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sex_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex_a");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿性别"); 
		return column;
	}
	/**
	 * 获取A胎儿性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_a");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿性别编码"); 
		return column;
	}
	/**
	 * 获取A胎儿体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeigth_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weigth_a");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("A胎儿体重"); 
		return column;
	}
	/**
	 * 获取A胎儿身长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeight_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Height_a");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("A胎儿身长"); 
		return column;
	}
	/**
	 * 获取A胎儿分娩方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_child_birth_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_child_birth_a");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿分娩方式"); 
		return column;
	}
	/**
	 * 获取A胎儿分娩方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_child_birth_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_child_birth_a");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿分娩方式编码"); 
		return column;
	}
	/**
	 * 获取A胎儿窒息情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_asphyxia_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_asphyxia_a");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿窒息情况"); 
		return column;
	}
	/**
	 * 获取A胎儿窒息情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_asphyxia_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_asphyxia_a");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿窒息情况编码"); 
		return column;
	}
	/**
	 * 获取A胎儿Apgar评估1分钟表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_apgar_one_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_apgar_one_a");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("A胎儿Apgar评估1分钟"); 
		return column;
	}
	/**
	 * 获取A胎儿Apgar评估5分钟表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_apgar_five_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_apgar_five_a");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("A胎儿Apgar评估5分钟"); 
		return column;
	}
	/**
	 * 获取A胎儿Apgar评估10分钟表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_apgar_ten_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_apgar_ten_a");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("A胎儿Apgar评估10分钟"); 
		return column;
	}
	/**
	 * 获取A胎儿皮肤扣分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_skin_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_skin_a");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("A胎儿皮肤扣分"); 
		return column;
	}
	/**
	 * 获取A胎儿呼吸扣分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_breath_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_breath_a");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("A胎儿呼吸扣分"); 
		return column;
	}
	/**
	 * 获取A胎儿心跳扣分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_heartbeat_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_heartbeat_a");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("A胎儿心跳扣分"); 
		return column;
	}
	/**
	 * 获取A胎儿肌张力扣分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_muscle_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_muscle_a");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("A胎儿肌张力扣分"); 
		return column;
	}
	/**
	 * 获取A胎儿反射扣分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_reflection_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_reflection_a");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("A胎儿反射扣分"); 
		return column;
	}
	/**
	 * 获取A胎儿脐带缠绕部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_umbilicalcord_part_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_umbilicalcord_part_a");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿脐带缠绕部位"); 
		return column;
	}
	/**
	 * 获取A胎儿脐带缠绕部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_umbilicalcord_part_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_umbilicalcord_part_a");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿脐带缠绕部位编码"); 
		return column;
	}
	/**
	 * 获取A胎儿脐带缠绕周数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_umbilicalcord_part_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_umbilicalcord_part_a");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("A胎儿脐带缠绕周数"); 
		return column;
	}
	/**
	 * 获取A胎儿脐带结扎方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_umbilicalcord_ligation_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_umbilicalcord_ligation_a");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿脐带结扎方式"); 
		return column;
	}
	/**
	 * 获取A胎儿脐带结扎方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_umbilicalcord_ligation_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_umbilicalcord_ligation_a");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿脐带结扎方式编码"); 
		return column;
	}
	/**
	 * 获取A胎儿眼处理方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eyes_handle_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eyes_handle_a");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿眼处理方式"); 
		return column;
	}
	/**
	 * 获取A胎儿眼处理方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_eyes_handle_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_eyes_handle_a");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿眼处理方式编码"); 
		return column;
	}
	/**
	 * 获取A胎儿脐带长度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLength_umbilicalcord_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Length_umbilicalcord_a");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("A胎儿脐带长度"); 
		return column;
	}
	/**
	 * 获取A胎儿异常及并发症表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_unusual_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_unusual_a");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿异常及并发症"); 
		return column;
	}
	/**
	 * 获取B胎儿性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sex_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex_b");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿性别"); 
		return column;
	}
	/**
	 * 获取B胎儿性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_b");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿性别编码"); 
		return column;
	}
	/**
	 * 获取B胎儿体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeigth_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weigth_b");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("B胎儿体重"); 
		return column;
	}
	/**
	 * 获取B胎儿身长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeight_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Height_b");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("B胎儿身长"); 
		return column;
	}
	/**
	 * 获取B胎儿分娩方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_child_birth_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_child_birth_b");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿分娩方式"); 
		return column;
	}
	/**
	 * 获取B胎儿分娩方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_child_birth_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_child_birth_b");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿分娩方式编码"); 
		return column;
	}
	/**
	 * 获取B胎儿窒息情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_asphyxia_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_asphyxia_b");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿窒息情况"); 
		return column;
	}
	/**
	 * 获取B胎儿窒息情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_asphyxia_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_asphyxia_b");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿窒息情况编码"); 
		return column;
	}
	/**
	 * 获取B胎儿Apgar评估1分钟表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_apgar_one_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_apgar_one_b");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("B胎儿Apgar评估1分钟"); 
		return column;
	}
	/**
	 * 获取B胎儿Apgar评估5分钟表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_apgar_five_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_apgar_five_b");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("B胎儿Apgar评估5分钟"); 
		return column;
	}
	/**
	 * 获取B胎儿Apgar评估10分钟表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_apgar_ten_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_apgar_ten_b");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("B胎儿Apgar评估10分钟"); 
		return column;
	}
	/**
	 * 获取B胎儿皮肤扣分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_skin_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_skin_b");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("B胎儿皮肤扣分"); 
		return column;
	}
	/**
	 * 获取B胎儿呼吸扣分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_breath_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_breath_b");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("B胎儿呼吸扣分"); 
		return column;
	}
	/**
	 * 获取B胎儿心跳扣分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_heartbeat_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_heartbeat_b");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("B胎儿心跳扣分"); 
		return column;
	}
	/**
	 * 获取B胎儿肌张力扣分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_muscle_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_muscle_b");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("B胎儿肌张力扣分"); 
		return column;
	}
	/**
	 * 获取B胎儿发射扣分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_reflection_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_reflection_b");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("B胎儿发射扣分"); 
		return column;
	}
	/**
	 * 获取B胎儿脐带缠绕部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_umbilicalcord_part_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_umbilicalcord_part_b");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿脐带缠绕部位"); 
		return column;
	}
	/**
	 * 获取B胎儿脐带缠绕部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_umbilicalcord_part_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_umbilicalcord_part_b");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿脐带缠绕部位编码"); 
		return column;
	}
	/**
	 * 获取B胎儿脐带缠绕周数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_umbilicalcord_part_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_umbilicalcord_part_b");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("B胎儿脐带缠绕周数"); 
		return column;
	}
	/**
	 * 获取B胎儿脐带结扎方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_umbilicalcord_ligation_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_umbilicalcord_ligation_b");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿脐带结扎方式"); 
		return column;
	}
	/**
	 * 获取B胎儿脐带结扎方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_umbilicalcord_ligation_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_umbilicalcord_ligation_b");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿脐带结扎方式编码"); 
		return column;
	}
	/**
	 * 获取B胎儿眼处理方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eyes_handle_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eyes_handle_b");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿眼处理方式"); 
		return column;
	}
	/**
	 * 获取B胎儿眼处理方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_eyes_handle_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_eyes_handle_b");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿眼处理方式编码"); 
		return column;
	}
	/**
	 * 获取B胎儿脐带长度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLength_umbilicalcord_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Length_umbilicalcord_b");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("B胎儿脐带长度"); 
		return column;
	}
	/**
	 * 获取B胎儿异常及并发症表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_unusual_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_unusual_b");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿异常及并发症"); 
		return column;
	}
	/**
	 * 获取胎盘情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_placenta_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_placenta_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘情况"); 
		return column;
	}
	/**
	 * 获取胎盘情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_placenta_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_placenta_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘情况编码"); 
		return column;
	}
	/**
	 * 获取胎膜情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_membranes_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_membranes_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜情况"); 
		return column;
	}
	/**
	 * 获取胎膜情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_membranes_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_membranes_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜情况编码"); 
		return column;
	}
	/**
	 * 获取胎膜破裂部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMembranes_ruptureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Membranes_rupture");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜破裂部位"); 
		return column;
	}
	/**
	 * 获取长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLength_plaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Length_pla");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("长"); 
		return column;
	}
	/**
	 * 获取宽表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWidth_plaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Width_pla");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("宽"); 
		return column;
	}
	/**
	 * 获取高表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeight_plaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Height_pla");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("高"); 
		return column;
	}
	/**
	 * 获取会阴切开方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perineum_cutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perineum_cut");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴切开方式"); 
		return column;
	}
	/**
	 * 获取会阴切开方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_perineum_cutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_perineum_cut");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴切开方式编码"); 
		return column;
	}
	/**
	 * 获取麻醉方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_childbirth_narcosis_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_childbirth_narcosis_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式"); 
		return column;
	}
	/**
	 * 获取麻醉方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_childbirth_narcosis_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_childbirth_narcosis_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式编码"); 
		return column;
	}
	/**
	 * 获取分娩麻醉药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_childbirth_narcosis_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_childbirth_narcosis_drug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩麻醉药"); 
		return column;
	}
	/**
	 * 获取分娩麻醉药编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_childbirth_narcosis_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_childbirth_narcosis_drug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩麻醉药编码"); 
		return column;
	}
	/**
	 * 获取左侧用药量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_drug_leftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_drug_left");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("左侧用药量"); 
		return column;
	}
	/**
	 * 获取右侧用药量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_drug_rightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_drug_right");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("右侧用药量"); 
		return column;
	}
	/**
	 * 获取适应症表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIndicationsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Indications");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("适应症"); 
		return column;
	}
	/**
	 * 获取缝合类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_suture_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_suture_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("缝合类型"); 
		return column;
	}
	/**
	 * 获取缝合类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_suture_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_suture_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("缝合类型编码"); 
		return column;
	}
	/**
	 * 获取手术类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_childbirth_operationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_childbirth_operation");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术类别"); 
		return column;
	}
	/**
	 * 获取手术类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_childbirth_operationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_childbirth_operation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术类别编码"); 
		return column;
	}
	/**
	 * 获取手术适应症表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIndications_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Indications_oper");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术适应症"); 
		return column;
	}
	/**
	 * 获取特殊情况及处理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecial_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Special_case");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊情况及处理"); 
		return column;
	}
	/**
	 * 获取诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diagnosis");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断"); 
		return column;
	}
	/**
	 * 获取接生者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_deliveringCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_delivering");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接生者"); 
		return column;
	}
	/**
	 * 获取缝合者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_sutureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_suture");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("缝合者"); 
		return column;
	}
	/**
	 * 获取辅助者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_assistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_assist");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("辅助者"); 
		return column;
	}
	/**
	 * 获取纱布清点者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_countingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_counting");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("纱布清点者"); 
		return column;
	}
	/**
	 * 获取病历记录着表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_record");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历记录着"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_groupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_group");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取创建人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("创建人"); 
		return column;
	}
	/**
	 * 获取创建时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("创建时间"); 
		return column;
	}
	/**
	 * 获取最后修改人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后修改人"); 
		return column;
	}
	/**
	 * 获取最后修改时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最后修改时间"); 
		return column;
	}
	/**
	 * 获取住院号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院号"); 
		return column;
	}
	/**
	 * 获取患者出生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_birth_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_birth_pat");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者出生日期"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元"); 
		return column;
	}
	/**
	 * 获取A胎儿娩出方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bithtp_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bithtp_a");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿娩出方式"); 
		return column;
	}
	/**
	 * 获取A胎儿产式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_protp_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_protp_a");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿产式"); 
		return column;
	}
	/**
	 * 获取B胎儿分娩方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_birthtp_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_birthtp_b");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿分娩方式"); 
		return column;
	}
	/**
	 * 获取B胎儿产式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_proptp_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_proptp_b");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿产式"); 
		return column;
	}
	/**
	 * 获取胎盘分娩方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_placenta_birthtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_placenta_birthtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘分娩方式"); 
		return column;
	}
	/**
	 * 获取胎盘剥离表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_placenta_strippingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_placenta_stripping");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘剥离"); 
		return column;
	}
	/**
	 * 获取羊水性状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_amniotic_fluid_charCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_amniotic_fluid_char");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水性状"); 
		return column;
	}
	/**
	 * 获取会阴状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_perineum_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_perineum_status");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴状况"); 
		return column;
	}
	/**
	 * 获取会阴严重程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_perineum_seriousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_perineum_serious");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴严重程度"); 
		return column;
	}
	/**
	 * 获取产后出血测定表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodmeasureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodmeasure");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产后出血测定"); 
		return column;
	}
	/**
	 * 获取产后用药称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drug_afterbirthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drug_afterbirth");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产后用药称"); 
		return column;
	}
	/**
	 * 获取A胎儿性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sex_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex_a");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿性别"); 
		return column;
	}
	/**
	 * 获取A胎儿分娩方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_child_birth_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_child_birth_a");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿分娩方式"); 
		return column;
	}
	/**
	 * 获取窒息情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_asphyxia_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_asphyxia_a");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("窒息情况"); 
		return column;
	}
	/**
	 * 获取A胎儿脐带缠绕部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_umbilicalcord_part_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_umbilicalcord_part_a");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿脐带缠绕部位"); 
		return column;
	}
	/**
	 * 获取A胎儿脐带结扎方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_umbilicalcord_ligation_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_umbilicalcord_ligation_a");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿脐带结扎方式"); 
		return column;
	}
	/**
	 * 获取A胎儿眼处理方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_eyes_handle_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_eyes_handle_a");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("A胎儿眼处理方式"); 
		return column;
	}
	/**
	 * 获取B胎儿性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sex_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex_b");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿性别"); 
		return column;
	}
	/**
	 * 获取B胎儿分娩方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_child_birth_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_child_birth_b");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿分娩方式"); 
		return column;
	}
	/**
	 * 获取B胎儿窒息程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_asphyxia_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_asphyxia_b");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿窒息程度"); 
		return column;
	}
	/**
	 * 获取B胎儿脐带缠绕部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_umbilicalcord_part_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_umbilicalcord_part_b");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿脐带缠绕部位"); 
		return column;
	}
	/**
	 * 获取B胎儿脐带结扎方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_umbilicalcord_ligation_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_umbilicalcord_ligation_b");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿脐带结扎方式"); 
		return column;
	}
	/**
	 * 获取B胎儿眼处理方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNam_eyes_handle_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nam_eyes_handle_b");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("B胎儿眼处理方式"); 
		return column;
	}
	/**
	 * 获取胎盘情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_placenta_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_placenta_status");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘情况"); 
		return column;
	}
	/**
	 * 获取胎膜情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_membranes_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_membranes_status");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜情况"); 
		return column;
	}
	/**
	 * 获取会阴切开方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_perineum_cutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_perineum_cut");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴切开方式"); 
		return column;
	}
	/**
	 * 获取分娩麻醉方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_childbirth_narcosis_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_childbirth_narcosis_type");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩麻醉方式"); 
		return column;
	}
	/**
	 * 获取分娩麻醉药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_narcosis_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_narcosis_drug");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩麻醉药"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_suture_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_suture_type");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取分娩手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_childbirth_operationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_childbirth_operation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩手术"); 
		return column;
	}
	/**
	 * 获取接生者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deliveringCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_delivering");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接生者姓名"); 
		return column;
	}
	/**
	 * 获取缝合者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sutureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_suture");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("缝合者姓名"); 
		return column;
	}
	/**
	 * 获取辅助者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_assistCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_assist");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("辅助者姓名"); 
		return column;
	}
	/**
	 * 获取清点者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_countingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_counting");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清点者姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mrrecordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mrrecord");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_group");
	}

	/**
	 * 设置实体审计信息数据映射关系
	 */
	private void setIAuditInfoFldMap(){
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
}
