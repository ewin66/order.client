
package iih.ci.mr.nu.obstetrics.operationnurvisit.d.desc;

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
 * 手术患者术前术后护理访视表 DO 元数据信息
 */
public class OperationNurVisitDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.obstetrics.operationnurvisit.d.OperationNurVisitDO";
	public static final String CLASS_DISPALYNAME = "手术患者术前术后护理访视表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mr_nu_opernur";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_opernur";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OperationNurVisitDODesc(){
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
		this.setKeyDesc(getId_opernurADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_opernurADesc(tblDesc));
		this.add(getId_groupADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_dep_phyADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getDt_operationADesc(tblDesc));
		this.add(getId_anesthesiaADesc(tblDesc));
		this.add(getSd_anesthesiaADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getName_operationADesc(tblDesc));
		this.add(getDt_beginvisitADesc(tblDesc));
		this.add(getId_liver_funADesc(tblDesc));
		this.add(getSd_liver_funADesc(tblDesc));
		this.add(getId_oADesc(tblDesc));
		this.add(getSd_oADesc(tblDesc));
		this.add(getName_diseasehisADesc(tblDesc));
		this.add(getName_oper_hisADesc(tblDesc));
		this.add(getName_allergyADesc(tblDesc));
		this.add(getId_phy_conADesc(tblDesc));
		this.add(getSd_phy_conADesc(tblDesc));
		this.add(getId_shapeADesc(tblDesc));
		this.add(getSd_shapeADesc(tblDesc));
		this.add(getId_mentalityADesc(tblDesc));
		this.add(getSd_mentalityADesc(tblDesc));
		this.add(getEu_dyskinesiaADesc(tblDesc));
		this.add(getId_blood_vesselADesc(tblDesc));
		this.add(getSd_blood_vesselADesc(tblDesc));
		this.add(getDes_operADesc(tblDesc));
		this.add(getId_emp_visitADesc(tblDesc));
		this.add(getDt_afteroperADesc(tblDesc));
		this.add(getDayafteroperADesc(tblDesc));
		this.add(getId_spiritADesc(tblDesc));
		this.add(getSd_spiritADesc(tblDesc));
		this.add(getEu_painADesc(tblDesc));
		this.add(getId_temADesc(tblDesc));
		this.add(getSd_temADesc(tblDesc));
		this.add(getId_wound_healingADesc(tblDesc));
		this.add(getSd_wound_healingADesc(tblDesc));
		this.add(getEu_skin_burnADesc(tblDesc));
		this.add(getId_oper_evalADesc(tblDesc));
		this.add(getSd_oper_evalADesc(tblDesc));
		this.add(getEu_visit_attiADesc(tblDesc));
		this.add(getSpecialopinionADesc(tblDesc));
		this.add(getId_emp_backADesc(tblDesc));
		this.add(getId_mental_stateADesc(tblDesc));
		this.add(getSd_mental_stateADesc(tblDesc));
		this.add(getId_pat_cooperADesc(tblDesc));
		this.add(getSd_pat_cooperADesc(tblDesc));
		this.add(getId_item_preADesc(tblDesc));
		this.add(getSd_item_preADesc(tblDesc));
		this.add(getEu_nurrecADesc(tblDesc));
		this.add(getSignature_nurADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getName_anesthesiaADesc(tblDesc));
		this.add(getName_liver_funADesc(tblDesc));
		this.add(getName_oADesc(tblDesc));
		this.add(getName_phy_conADesc(tblDesc));
		this.add(getName_shapeADesc(tblDesc));
		this.add(getName_mentalityADesc(tblDesc));
		this.add(getName_blood_vesselADesc(tblDesc));
		this.add(getName_emp_visitADesc(tblDesc));
		this.add(getName_spiritADesc(tblDesc));
		this.add(getName_temADesc(tblDesc));
		this.add(getName_wound_healingADesc(tblDesc));
		this.add(getName_oper_evalADesc(tblDesc));
		this.add(getName_emp_backADesc(tblDesc));
		this.add(getName_mental_stateADesc(tblDesc));
		this.add(getName_pat_cooperADesc(tblDesc));
		this.add(getName_item_preADesc(tblDesc));
		this.add(getName_nurADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_opernurCDesc(tblDesc));
		tblDesc.add(getId_opernurCDesc(tblDesc));
		tblDesc.add(getId_groupCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getSd_sexCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getDt_operationCDesc(tblDesc));
		tblDesc.add(getId_anesthesiaCDesc(tblDesc));
		tblDesc.add(getSd_anesthesiaCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_operationCDesc(tblDesc));
		tblDesc.add(getDt_beginvisitCDesc(tblDesc));
		tblDesc.add(getId_liver_funCDesc(tblDesc));
		tblDesc.add(getSd_liver_funCDesc(tblDesc));
		tblDesc.add(getId_oCDesc(tblDesc));
		tblDesc.add(getSd_oCDesc(tblDesc));
		tblDesc.add(getName_diseasehisCDesc(tblDesc));
		tblDesc.add(getName_oper_hisCDesc(tblDesc));
		tblDesc.add(getName_allergyCDesc(tblDesc));
		tblDesc.add(getId_phy_conCDesc(tblDesc));
		tblDesc.add(getSd_phy_conCDesc(tblDesc));
		tblDesc.add(getId_shapeCDesc(tblDesc));
		tblDesc.add(getSd_shapeCDesc(tblDesc));
		tblDesc.add(getId_mentalityCDesc(tblDesc));
		tblDesc.add(getSd_mentalityCDesc(tblDesc));
		tblDesc.add(getEu_dyskinesiaCDesc(tblDesc));
		tblDesc.add(getId_blood_vesselCDesc(tblDesc));
		tblDesc.add(getSd_blood_vesselCDesc(tblDesc));
		tblDesc.add(getDes_operCDesc(tblDesc));
		tblDesc.add(getId_emp_visitCDesc(tblDesc));
		tblDesc.add(getDt_afteroperCDesc(tblDesc));
		tblDesc.add(getDayafteroperCDesc(tblDesc));
		tblDesc.add(getId_spiritCDesc(tblDesc));
		tblDesc.add(getSd_spiritCDesc(tblDesc));
		tblDesc.add(getEu_painCDesc(tblDesc));
		tblDesc.add(getId_temCDesc(tblDesc));
		tblDesc.add(getSd_temCDesc(tblDesc));
		tblDesc.add(getId_wound_healingCDesc(tblDesc));
		tblDesc.add(getSd_wound_healingCDesc(tblDesc));
		tblDesc.add(getEu_skin_burnCDesc(tblDesc));
		tblDesc.add(getId_oper_evalCDesc(tblDesc));
		tblDesc.add(getSd_oper_evalCDesc(tblDesc));
		tblDesc.add(getEu_visit_attiCDesc(tblDesc));
		tblDesc.add(getSpecialopinionCDesc(tblDesc));
		tblDesc.add(getId_emp_backCDesc(tblDesc));
		tblDesc.add(getId_mental_stateCDesc(tblDesc));
		tblDesc.add(getSd_mental_stateCDesc(tblDesc));
		tblDesc.add(getId_pat_cooperCDesc(tblDesc));
		tblDesc.add(getSd_pat_cooperCDesc(tblDesc));
		tblDesc.add(getId_item_preCDesc(tblDesc));
		tblDesc.add(getSd_item_preCDesc(tblDesc));
		tblDesc.add(getEu_nurrecCDesc(tblDesc));
		tblDesc.add(getSignature_nurCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 手术护理访视表ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_opernurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_opernur",  getId_opernurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术护理访视表ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 患者就诊ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者就诊ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex",  getId_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex",  getSd_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age",  getAgeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病案号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科别ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_phy",  getId_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科别ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phy",  getName_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病室ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病室ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_operationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_operation",  getDt_operationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("手术日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉方式ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_anesthesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_anesthesia",  getId_anesthesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式ID");
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
	private IAttrDesc getSd_anesthesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_anesthesia",  getSd_anesthesiaCDesc(tblDesc), this);
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
	 * 入院诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diagnosis",  getName_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_operationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_operation",  getName_operationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前访问日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_beginvisitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_beginvisit",  getDt_beginvisitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("术前访问日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肝功属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_liver_funADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_liver_fun",  getId_liver_funCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肝功");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 肝功检测情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_liver_funADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_liver_fun",  getSd_liver_funCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肝功检测情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 澳抗属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_oADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_o",  getId_oCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("澳抗");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 澳抗编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_o",  getSd_oCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("澳抗编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 既往病史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diseasehisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diseasehis",  getName_diseasehisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("既往病史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_hisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_his",  getName_oper_hisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_allergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_allergy",  getName_allergyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_phy_conADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_phy_con",  getId_phy_conCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身体状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 身体状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_phy_conADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_phy_con",  getSd_phy_conCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身体状况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_shapeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_shape",  getId_shapeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_shapeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_shape",  getSd_shapeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心理状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mentalityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mentality",  getId_mentalityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心理状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 心理状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mentalityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mentality",  getSd_mentalityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心理状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肢体运动障碍属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_dyskinesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_dyskinesia",  getEu_dyskinesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("肢体运动障碍");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blood_vesselADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blood_vessel",  getId_blood_vesselCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血管情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_blood_vesselADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_blood_vessel",  getSd_blood_vesselCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血管情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特殊问题及注意事项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_oper",  getDes_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊问题及注意事项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 访视者ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_visitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_visit",  getId_emp_visitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("访视者ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后访问日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_afteroperADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_afteroper",  getDt_afteroperCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("术后访问日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDayafteroperADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dayafteroper",  getDayafteroperCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 精神属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_spiritADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_spirit",  getId_spiritCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("精神");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后精神状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_spiritADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_spirit",  getSd_spiritCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后精神状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_pain",  getEu_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("疼痛");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体温属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_temADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tem",  getId_temCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体温");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体温情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_temADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tem",  getSd_temCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体温情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤口愈合属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wound_healingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wound_healing",  getId_wound_healingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤口愈合");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 伤口愈合情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_wound_healingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_wound_healing",  getSd_wound_healingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤口愈合情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤破损灼伤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_skin_burnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_skin_burn",  getEu_skin_burnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("皮肤破损灼伤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者及家属对手术室工作评价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_oper_evalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oper_eval",  getId_oper_evalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者及家属对手术室工作评价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术室评价等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_evalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_eval",  getSd_oper_evalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术室评价等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者及家属对访视所持态度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_visit_attiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_visit_atti",  getEu_visit_attiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("患者及家属对访视所持态度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特殊意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecialopinionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specialopinion",  getSpecialopinionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊意见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 回访者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_backADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_back",  getId_emp_backCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("回访者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者入室后精神状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mental_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mental_state",  getId_mental_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者入室后精神状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入室后精神状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mental_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mental_state",  getSd_mental_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入室后精神状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者术中配合情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pat_cooperADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat_cooper",  getId_pat_cooperCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者术中配合情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者术中配合情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pat_cooperADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pat_cooper",  getSd_pat_cooperCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者术中配合情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士术中物品准备情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_item_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_item_pre",  getId_item_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士术中物品准备情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术中物品准备情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_item_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_item_pre",  getSd_item_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中物品准备情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士记录完成情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_nurrecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_nurrec",  getEu_nurrecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("护士记录完成情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士长签字属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSignature_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Signature_nur",  getSignature_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士长签字");
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
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b10","id_ent=id_ent","name_pat"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_anesthesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_anesthesia",  getName_anesthesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_anesthesia=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肝功属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_liver_funADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_liver_fun",  getName_liver_funCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肝功");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_liver_fun=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 澳抗属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_o",  getName_oCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("澳抗");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_o=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_phy_conADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_phy_con",  getName_phy_conCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身体状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_phy_con=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_shapeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_shape",  getName_shapeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_shape=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心理状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mentalityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mentality",  getName_mentalityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心理状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_mentality=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血管情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_blood_vesselADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_blood_vessel",  getName_blood_vesselCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血管情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_blood_vessel=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 访视者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_visitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_visit",  getName_emp_visitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("访视者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b7","id_emp_visit=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 精神属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_spiritADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_spirit",  getName_spiritCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("精神");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_spirit=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体温属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_temADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tem",  getName_temCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体温");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_tem=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤口愈合属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_wound_healingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_wound_healing",  getName_wound_healingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤口愈合");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_wound_healing=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者及家属对手术室工作评价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_evalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_eval",  getName_oper_evalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者及家属对手术室工作评价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_oper_eval=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 回访者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_backADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_back",  getName_emp_backCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("回访者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b8","id_emp_back=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者入室后精神状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mental_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mental_state",  getName_mental_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者入室后精神状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_mental_state=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者术中配合情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pat_cooperADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat_cooper",  getName_pat_cooperCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者术中配合情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_pat_cooper=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士术中物品准备情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_item_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_item_pre",  getName_item_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士术中物品准备情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_item_pre=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士长签字属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur",  getName_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士长签字");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b9","signature_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取手术护理访视表ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_opernurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_opernur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术护理访视表ID"); 
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
	 * 获取患者就诊ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者就诊ID"); 
		return column;
	}
	/**
	 * 获取患者id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者id"); 
		return column;
	}
	/**
	 * 获取患者性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者性别"); 
		return column;
	}
	/**
	 * 获取患者性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者性别编码"); 
		return column;
	}
	/**
	 * 获取患者年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者年龄"); 
		return column;
	}
	/**
	 * 获取病案号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案号"); 
		return column;
	}
	/**
	 * 获取科别ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_phy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科别ID"); 
		return column;
	}
	/**
	 * 获取科别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科别"); 
		return column;
	}
	/**
	 * 获取病室ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病室ID"); 
		return column;
	}
	/**
	 * 获取病室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病室"); 
		return column;
	}
	/**
	 * 获取手术日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_operationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_operation");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术日期"); 
		return column;
	}
	/**
	 * 获取麻醉方式ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_anesthesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_anesthesia");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式ID"); 
		return column;
	}
	/**
	 * 获取麻醉方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_anesthesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_anesthesia");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式编码"); 
		return column;
	}
	/**
	 * 获取入院诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagnosis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院诊断"); 
		return column;
	}
	/**
	 * 获取手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_operationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_operation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术名称"); 
		return column;
	}
	/**
	 * 获取术前访问日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_beginvisitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_beginvisit");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("术前访问日期"); 
		return column;
	}
	/**
	 * 获取肝功表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_liver_funCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_liver_fun");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肝功"); 
		return column;
	}
	/**
	 * 获取肝功检测情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_liver_funCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_liver_fun");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肝功检测情况编码"); 
		return column;
	}
	/**
	 * 获取澳抗表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_oCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_o");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("澳抗"); 
		return column;
	}
	/**
	 * 获取澳抗编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_o");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("澳抗编码"); 
		return column;
	}
	/**
	 * 获取既往病史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diseasehisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diseasehis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("既往病史"); 
		return column;
	}
	/**
	 * 获取手术史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_hisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_his");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术史"); 
		return column;
	}
	/**
	 * 获取过敏史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_allergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_allergy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏史"); 
		return column;
	}
	/**
	 * 获取身体状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_phy_conCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_phy_con");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身体状况"); 
		return column;
	}
	/**
	 * 获取身体状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_phy_conCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_phy_con");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身体状况编码"); 
		return column;
	}
	/**
	 * 获取体型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_shapeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_shape");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体型"); 
		return column;
	}
	/**
	 * 获取体型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_shapeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_shape");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体型编码"); 
		return column;
	}
	/**
	 * 获取心理状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mentalityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mentality");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心理状态"); 
		return column;
	}
	/**
	 * 获取心理状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mentalityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mentality");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心理状态编码"); 
		return column;
	}
	/**
	 * 获取肢体运动障碍表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_dyskinesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_dyskinesia");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("肢体运动障碍"); 
		return column;
	}
	/**
	 * 获取血管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blood_vesselCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blood_vessel");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血管"); 
		return column;
	}
	/**
	 * 获取血管情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_blood_vesselCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_blood_vessel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血管情况编码"); 
		return column;
	}
	/**
	 * 获取特殊问题及注意事项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_oper");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊问题及注意事项"); 
		return column;
	}
	/**
	 * 获取访视者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_visitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_visit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("访视者ID"); 
		return column;
	}
	/**
	 * 获取术后访问日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_afteroperCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_afteroper");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("术后访问日期"); 
		return column;
	}
	/**
	 * 获取术后天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDayafteroperCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dayafteroper");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后天数"); 
		return column;
	}
	/**
	 * 获取精神表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_spiritCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_spirit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("精神"); 
		return column;
	}
	/**
	 * 获取术后精神状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_spiritCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_spirit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后精神状态编码"); 
		return column;
	}
	/**
	 * 获取疼痛表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_pain");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("疼痛"); 
		return column;
	}
	/**
	 * 获取体温表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_temCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tem");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体温"); 
		return column;
	}
	/**
	 * 获取体温情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_temCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tem");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体温情况编码"); 
		return column;
	}
	/**
	 * 获取伤口愈合表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wound_healingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wound_healing");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤口愈合"); 
		return column;
	}
	/**
	 * 获取伤口愈合情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_wound_healingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_wound_healing");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤口愈合情况编码"); 
		return column;
	}
	/**
	 * 获取皮肤破损灼伤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_skin_burnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_skin_burn");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("皮肤破损灼伤"); 
		return column;
	}
	/**
	 * 获取患者及家属对手术室工作评价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_oper_evalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oper_eval");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者及家属对手术室工作评价"); 
		return column;
	}
	/**
	 * 获取手术室评价等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_evalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_eval");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术室评价等级编码"); 
		return column;
	}
	/**
	 * 获取患者及家属对访视所持态度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_visit_attiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_visit_atti");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("患者及家属对访视所持态度"); 
		return column;
	}
	/**
	 * 获取特殊意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecialopinionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specialopinion");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊意见"); 
		return column;
	}
	/**
	 * 获取回访者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_backCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_back");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("回访者"); 
		return column;
	}
	/**
	 * 获取患者入室后精神状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mental_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mental_state");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者入室后精神状态"); 
		return column;
	}
	/**
	 * 获取入室后精神状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mental_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mental_state");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入室后精神状态编码"); 
		return column;
	}
	/**
	 * 获取患者术中配合情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pat_cooperCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat_cooper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者术中配合情况"); 
		return column;
	}
	/**
	 * 获取患者术中配合情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pat_cooperCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pat_cooper");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者术中配合情况编码"); 
		return column;
	}
	/**
	 * 获取护士术中物品准备情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_item_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_item_pre");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士术中物品准备情况"); 
		return column;
	}
	/**
	 * 获取术中物品准备情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_item_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_item_pre");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中物品准备情况编码"); 
		return column;
	}
	/**
	 * 获取护士记录完成情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_nurrecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_nurrec");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("护士记录完成情况"); 
		return column;
	}
	/**
	 * 获取护士长签字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSignature_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Signature_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士长签字"); 
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
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_anesthesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_anesthesia");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取肝功表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_liver_funCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_liver_fun");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肝功"); 
		return column;
	}
	/**
	 * 获取澳抗表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_o");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("澳抗"); 
		return column;
	}
	/**
	 * 获取身体状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_phy_conCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_phy_con");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身体状况"); 
		return column;
	}
	/**
	 * 获取体型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_shapeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_shape");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体型"); 
		return column;
	}
	/**
	 * 获取心理状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mentalityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mentality");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心理状态"); 
		return column;
	}
	/**
	 * 获取血管情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_blood_vesselCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_blood_vessel");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血管情况"); 
		return column;
	}
	/**
	 * 获取访视者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_visitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_visit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("访视者"); 
		return column;
	}
	/**
	 * 获取精神表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_spiritCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_spirit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("精神"); 
		return column;
	}
	/**
	 * 获取体温表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_temCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tem");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体温"); 
		return column;
	}
	/**
	 * 获取伤口愈合表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_wound_healingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_wound_healing");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤口愈合"); 
		return column;
	}
	/**
	 * 获取患者及家属对手术室工作评价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_evalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_eval");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者及家属对手术室工作评价"); 
		return column;
	}
	/**
	 * 获取回访者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_backCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_back");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("回访者"); 
		return column;
	}
	/**
	 * 获取患者入室后精神状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mental_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mental_state");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者入室后精神状态"); 
		return column;
	}
	/**
	 * 获取患者术中配合情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pat_cooperCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat_cooper");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者术中配合情况"); 
		return column;
	}
	/**
	 * 获取护士术中物品准备情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_item_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_item_pre");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士术中物品准备情况"); 
		return column;
	}
	/**
	 * 获取护士长签字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士长签字"); 
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
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
}
