
package iih.ci.rcm.contagion.d.desc;

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
 * 艾滋病附卡 DO 元数据信息
 */
public class AidsDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.contagion.d.AidsDO";
	public static final String CLASS_DISPALYNAME = "艾滋病附卡";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_CONTAGION_CARD_AIDS";
	public static final String TABLE_ALIAS_NAME = "a5";
	public static final String PRIMARYKEY_FIELDNAME="Id_aids";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public AidsDODesc(){
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
		this.setKeyDesc(getId_aidsADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_contagionADesc(tblDesc));
		this.add(getId_aidsADesc(tblDesc));
		this.add(getId_contagionADesc(tblDesc));
		this.add(getId_formADesc(tblDesc));
		this.add(getDiseaseADesc(tblDesc));
		this.add(getDisease_codeADesc(tblDesc));
		this.add(getDisease_nameADesc(tblDesc));
		this.add(getIs_aids_historyADesc(tblDesc));
		this.add(getSd_aids_historyADesc(tblDesc));
		this.add(getName_aids_historyADesc(tblDesc));
		this.add(getId_contact_historyADesc(tblDesc));
		this.add(getSd_contact_historyADesc(tblDesc));
		this.add(getName_contact_historyADesc(tblDesc));
		this.add(getId_infection_wayADesc(tblDesc));
		this.add(getSd_infection_wayADesc(tblDesc));
		this.add(getName_infection_wayADesc(tblDesc));
		this.add(getId_sample_sourceADesc(tblDesc));
		this.add(getSd_sample_sourceADesc(tblDesc));
		this.add(getName_sample_sourceADesc(tblDesc));
		this.add(getId_conclusionADesc(tblDesc));
		this.add(getSd_conclusionADesc(tblDesc));
		this.add(getName_conclusionADesc(tblDesc));
		this.add(getDt_aidsADesc(tblDesc));
		this.add(getCard_noADesc(tblDesc));
		this.add(getPat_nameADesc(tblDesc));
		this.add(getParent_nameADesc(tblDesc));
		this.add(getId_marryADesc(tblDesc));
		this.add(getCode_marryADesc(tblDesc));
		this.add(getName_marryADesc(tblDesc));
		this.add(getHjdzADesc(tblDesc));
		this.add(getCode_hjdzADesc(tblDesc));
		this.add(getName_hjdzADesc(tblDesc));
		this.add(getTownADesc(tblDesc));
		this.add(getVillageADesc(tblDesc));
		this.add(getHouse_noADesc(tblDesc));
		this.add(getId_cultureADesc(tblDesc));
		this.add(getName_cultureADesc(tblDesc));
		this.add(getCode_cultureADesc(tblDesc));
		this.add(getDt_contagionADesc(tblDesc));
		this.add(getId_emp_entryADesc(tblDesc));
		this.add(getSd_emp_entryADesc(tblDesc));
		this.add(getName_emp_entryADesc(tblDesc));
		this.add(getId_nationADesc(tblDesc));
		this.add(getSd_nationADesc(tblDesc));
		this.add(getName_nationADesc(tblDesc));
		this.add(getConfirm_detection_uniteADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getCode_diseaseADesc(tblDesc));
		this.add(getName_diseaseADesc(tblDesc));
		this.add(getSd_history_codeADesc(tblDesc));
		this.add(getSd_history_nameADesc(tblDesc));
		this.add(getContact_history_codeADesc(tblDesc));
		this.add(getContact_history_nameADesc(tblDesc));
		this.add(getInfection_codeADesc(tblDesc));
		this.add(getInfection_nameADesc(tblDesc));
		this.add(getSample_codeADesc(tblDesc));
		this.add(getSample_nameADesc(tblDesc));
		this.add(getConclusion_codeADesc(tblDesc));
		this.add(getConclusion_nameADesc(tblDesc));
		this.add(getMarry_codeADesc(tblDesc));
		this.add(getMarry_nameADesc(tblDesc));
		this.add(getAreacodeADesc(tblDesc));
		this.add(getAreanameADesc(tblDesc));
		this.add(getCulturecodeADesc(tblDesc));
		this.add(getCulturenameADesc(tblDesc));
		this.add(getDoctorcodeADesc(tblDesc));
		this.add(getDoctornameADesc(tblDesc));
		this.add(getNation_codeADesc(tblDesc));
		this.add(getNation_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aidsCDesc(tblDesc));
		tblDesc.add(getId_aidsCDesc(tblDesc));
		tblDesc.add(getId_contagionCDesc(tblDesc));
		tblDesc.add(getId_formCDesc(tblDesc));
		tblDesc.add(getDiseaseCDesc(tblDesc));
		tblDesc.add(getDisease_codeCDesc(tblDesc));
		tblDesc.add(getDisease_nameCDesc(tblDesc));
		tblDesc.add(getIs_aids_historyCDesc(tblDesc));
		tblDesc.add(getSd_aids_historyCDesc(tblDesc));
		tblDesc.add(getName_aids_historyCDesc(tblDesc));
		tblDesc.add(getId_contact_historyCDesc(tblDesc));
		tblDesc.add(getSd_contact_historyCDesc(tblDesc));
		tblDesc.add(getName_contact_historyCDesc(tblDesc));
		tblDesc.add(getId_infection_wayCDesc(tblDesc));
		tblDesc.add(getSd_infection_wayCDesc(tblDesc));
		tblDesc.add(getName_infection_wayCDesc(tblDesc));
		tblDesc.add(getId_sample_sourceCDesc(tblDesc));
		tblDesc.add(getSd_sample_sourceCDesc(tblDesc));
		tblDesc.add(getName_sample_sourceCDesc(tblDesc));
		tblDesc.add(getId_conclusionCDesc(tblDesc));
		tblDesc.add(getSd_conclusionCDesc(tblDesc));
		tblDesc.add(getName_conclusionCDesc(tblDesc));
		tblDesc.add(getDt_aidsCDesc(tblDesc));
		tblDesc.add(getCard_noCDesc(tblDesc));
		tblDesc.add(getPat_nameCDesc(tblDesc));
		tblDesc.add(getParent_nameCDesc(tblDesc));
		tblDesc.add(getId_marryCDesc(tblDesc));
		tblDesc.add(getCode_marryCDesc(tblDesc));
		tblDesc.add(getName_marryCDesc(tblDesc));
		tblDesc.add(getHjdzCDesc(tblDesc));
		tblDesc.add(getCode_hjdzCDesc(tblDesc));
		tblDesc.add(getName_hjdzCDesc(tblDesc));
		tblDesc.add(getTownCDesc(tblDesc));
		tblDesc.add(getVillageCDesc(tblDesc));
		tblDesc.add(getHouse_noCDesc(tblDesc));
		tblDesc.add(getId_cultureCDesc(tblDesc));
		tblDesc.add(getName_cultureCDesc(tblDesc));
		tblDesc.add(getCode_cultureCDesc(tblDesc));
		tblDesc.add(getDt_contagionCDesc(tblDesc));
		tblDesc.add(getId_emp_entryCDesc(tblDesc));
		tblDesc.add(getSd_emp_entryCDesc(tblDesc));
		tblDesc.add(getName_emp_entryCDesc(tblDesc));
		tblDesc.add(getId_nationCDesc(tblDesc));
		tblDesc.add(getSd_nationCDesc(tblDesc));
		tblDesc.add(getName_nationCDesc(tblDesc));
		tblDesc.add(getConfirm_detection_uniteCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 艾滋病附卡ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aidsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aids",  getId_aidsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("艾滋病附卡ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 父卡ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_contagionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_contagion",  getId_contagionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("父卡ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 表单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_formADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_form",  getId_formCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("表单");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiseaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Disease",  getDiseaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疾病编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDisease_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Disease_code",  getDisease_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDisease_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Disease_name",  getDisease_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性病史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_aids_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_aids_history",  getIs_aids_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性病史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 性病史编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_aids_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_aids_history",  getSd_aids_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性病史编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性病史名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_aids_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_aids_history",  getName_aids_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性病史名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接触史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_contact_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_contact_history",  getId_contact_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接触史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 接触史编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_contact_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_contact_history",  getSd_contact_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接触史编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接触史名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_contact_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_contact_history",  getName_contact_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接触史名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染途径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infection_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infection_way",  getId_infection_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染途径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 感染途径编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_infection_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infection_way",  getSd_infection_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染途径编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染途径名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infection_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infection_way",  getName_infection_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染途径名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 样本来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sample_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sample_source",  getId_sample_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("样本来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 样本来源编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sample_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sample_source",  getSd_sample_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("样本来源编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 样本来源名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sample_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sample_source",  getName_sample_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("样本来源名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实验室检测结论属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_conclusionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_conclusion",  getId_conclusionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实验室检测结论");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实验室检测结论编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_conclusionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_conclusion",  getSd_conclusionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实验室检测结论编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实验室检测结论名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_conclusionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_conclusion",  getName_conclusionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实验室检测结论名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 艾滋病确诊时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_aidsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_aids",  getDt_aidsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("艾滋病确诊时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡片编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_no",  getCard_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡片编号");
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
	private IAttrDesc getPat_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_name",  getPat_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家长姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getParent_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Parent_name",  getParent_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家长姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婚姻属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_marryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_marry",  getId_marryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 婚姻编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_marryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_marry",  getCode_marryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婚姻名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_marryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_marry",  getName_marryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 户籍地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHjdzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hjdz",  getHjdzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("户籍地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 户籍地址编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hjdzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hjdz",  getCode_hjdzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("户籍地址编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 户籍地址名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hjdzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hjdz",  getName_hjdzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("户籍地址名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 乡镇属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTownADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Town",  getTownCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("乡镇");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 村属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVillageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Village",  getVillageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("村");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门牌号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHouse_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("House_no",  getHouse_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门牌号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文化属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cultureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_culture",  getId_cultureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 文化名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cultureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_culture",  getName_cultureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文化编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_cultureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_culture",  getCode_cultureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填卡日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_contagionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_contagion",  getDt_contagionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("填卡日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报卡医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_entry",  getId_emp_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报卡医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 报卡医生编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emp_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emp_entry",  getSd_emp_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报卡医生编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报卡医生名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_entry",  getName_emp_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报卡医生名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民族属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nation",  getId_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 民族编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nation",  getSd_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民族名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nation",  getName_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 确诊单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConfirm_detection_uniteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Confirm_detection_unite",  getConfirm_detection_uniteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("确诊单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自定义属性属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自定义属性");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_diseaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_disease",  getCode_diseaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b2","disease=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diseaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_disease",  getName_diseaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b2","disease=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_history_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_history_code",  getSd_history_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b3","is_aids_history=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_history_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_history_name",  getSd_history_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b3","is_aids_history=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContact_history_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Contact_history_code",  getContact_history_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b4","id_contact_history=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContact_history_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Contact_history_name",  getContact_history_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b4","id_contact_history=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfection_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infection_code",  getInfection_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b5","id_infection_way=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfection_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infection_name",  getInfection_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b5","id_infection_way=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSample_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sample_code",  getSample_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b6","id_sample_source=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSample_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sample_name",  getSample_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b6","id_sample_source=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConclusion_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Conclusion_code",  getConclusion_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b7","id_conclusion=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConclusion_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Conclusion_name",  getConclusion_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b7","id_conclusion=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMarry_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Marry_code",  getMarry_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b9","id_marry=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMarry_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Marry_name",  getMarry_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b9","id_marry=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAreacodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Areacode",  getAreacodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a5b8","hjdz=id_adminarea","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAreanameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Areaname",  getAreanameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a5b8","hjdz=id_adminarea","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCulturecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Culturecode",  getCulturecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b10","id_culture=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCulturenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Culturename",  getCulturenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b10","id_culture=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoctorcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doctorcode",  getDoctorcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a5b11","id_emp_entry=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoctornameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doctorname",  getDoctornameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a5b11","id_emp_entry=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNation_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nation_code",  getNation_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b12","id_nation=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nation_name",  getNation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b12","id_nation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取艾滋病附卡ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aidsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aids");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("艾滋病附卡ID"); 
		return column;
	}
	/**
	 * 获取父卡ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_contagionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_contagion");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("父卡ID"); 
		return column;
	}
	/**
	 * 获取表单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_formCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_form");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("表单"); 
		return column;
	}
	/**
	 * 获取疾病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiseaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Disease");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病"); 
		return column;
	}
	/**
	 * 获取疾病编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDisease_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Disease_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病编码"); 
		return column;
	}
	/**
	 * 获取疾病名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDisease_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Disease_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病名称"); 
		return column;
	}
	/**
	 * 获取性病史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_aids_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_aids_history");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性病史"); 
		return column;
	}
	/**
	 * 获取性病史编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_aids_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_aids_history");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性病史编码"); 
		return column;
	}
	/**
	 * 获取性病史名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_aids_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_aids_history");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性病史名称"); 
		return column;
	}
	/**
	 * 获取接触史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_contact_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_contact_history");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接触史"); 
		return column;
	}
	/**
	 * 获取接触史编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_contact_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_contact_history");
		column.setLength(512);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接触史编码"); 
		return column;
	}
	/**
	 * 获取接触史名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_contact_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_contact_history");
		column.setLength(512);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接触史名称"); 
		return column;
	}
	/**
	 * 获取感染途径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infection_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infection_way");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染途径"); 
		return column;
	}
	/**
	 * 获取感染途径编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_infection_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infection_way");
		column.setLength(512);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染途径编码"); 
		return column;
	}
	/**
	 * 获取感染途径名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_infection_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infection_way");
		column.setLength(512);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染途径名称"); 
		return column;
	}
	/**
	 * 获取样本来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sample_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sample_source");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("样本来源"); 
		return column;
	}
	/**
	 * 获取样本来源编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sample_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sample_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("样本来源编码"); 
		return column;
	}
	/**
	 * 获取样本来源名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sample_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sample_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("样本来源名称"); 
		return column;
	}
	/**
	 * 获取实验室检测结论表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_conclusionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_conclusion");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实验室检测结论"); 
		return column;
	}
	/**
	 * 获取实验室检测结论编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_conclusionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_conclusion");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实验室检测结论编码"); 
		return column;
	}
	/**
	 * 获取实验室检测结论名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_conclusionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_conclusion");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实验室检测结论名称"); 
		return column;
	}
	/**
	 * 获取艾滋病确诊时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_aidsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_aids");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("艾滋病确诊时间"); 
		return column;
	}
	/**
	 * 获取卡片编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡片编号"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取家长姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getParent_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Parent_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家长姓名"); 
		return column;
	}
	/**
	 * 获取婚姻表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_marryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_marry");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻"); 
		return column;
	}
	/**
	 * 获取婚姻编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_marryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_marry");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻编码"); 
		return column;
	}
	/**
	 * 获取婚姻名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_marryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_marry");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻名称"); 
		return column;
	}
	/**
	 * 获取户籍地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHjdzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hjdz");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("户籍地址"); 
		return column;
	}
	/**
	 * 获取户籍地址编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hjdzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hjdz");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("户籍地址编码"); 
		return column;
	}
	/**
	 * 获取户籍地址名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hjdzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hjdz");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("户籍地址名称"); 
		return column;
	}
	/**
	 * 获取乡镇表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTownCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Town");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("乡镇"); 
		return column;
	}
	/**
	 * 获取村表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVillageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Village");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("村"); 
		return column;
	}
	/**
	 * 获取门牌号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHouse_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"House_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门牌号"); 
		return column;
	}
	/**
	 * 获取文化表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cultureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_culture");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化"); 
		return column;
	}
	/**
	 * 获取文化名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cultureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_culture");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化名称"); 
		return column;
	}
	/**
	 * 获取文化编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_cultureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_culture");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化编码"); 
		return column;
	}
	/**
	 * 获取填卡日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_contagionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_contagion");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("填卡日期"); 
		return column;
	}
	/**
	 * 获取报卡医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_entry");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡医生"); 
		return column;
	}
	/**
	 * 获取报卡医生编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emp_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emp_entry");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡医生编码"); 
		return column;
	}
	/**
	 * 获取报卡医生名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_entry");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡医生名称"); 
		return column;
	}
	/**
	 * 获取民族表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族"); 
		return column;
	}
	/**
	 * 获取民族编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族编码"); 
		return column;
	}
	/**
	 * 获取民族名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族名称"); 
		return column;
	}
	/**
	 * 获取确诊单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getConfirm_detection_uniteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Confirm_detection_unite");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("确诊单位"); 
		return column;
	}
	/**
	 * 获取自定义属性表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自定义属性"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_diseaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_disease");
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
	private IColumnDesc getName_diseaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_disease");
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
	private IColumnDesc getSd_history_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_history_code");
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
	private IColumnDesc getSd_history_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_history_name");
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
	private IColumnDesc getContact_history_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Contact_history_code");
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
	private IColumnDesc getContact_history_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Contact_history_name");
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
	private IColumnDesc getInfection_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infection_code");
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
	private IColumnDesc getInfection_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infection_name");
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
	private IColumnDesc getSample_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sample_code");
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
	private IColumnDesc getSample_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sample_name");
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
	private IColumnDesc getConclusion_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Conclusion_code");
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
	private IColumnDesc getConclusion_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Conclusion_name");
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
	private IColumnDesc getMarry_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Marry_code");
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
	private IColumnDesc getMarry_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Marry_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取行政区划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAreacodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Areacode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划编码"); 
		return column;
	}
	/**
	 * 获取行政区划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAreanameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Areaname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCulturecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Culturecode");
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
	private IColumnDesc getCulturenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Culturename");
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
	private IColumnDesc getDoctorcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doctorcode");
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
	private IColumnDesc getDoctornameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doctorname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNation_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nation_code");
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
	private IColumnDesc getNation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nation_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
