
package iih.ci.rcm.operinciinfect.d.desc;

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
 * 手术切口感染 DO 元数据信息
 */
public class OperIncInfectDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.operinciinfect.d.OperIncInfectDO";
	public static final String CLASS_DISPALYNAME = "手术切口感染";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_CONTAGION_CARD_INCISION";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_operinciinfect";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OperIncInfectDODesc(){
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
		this.setKeyDesc(getId_operinciinfectADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_operinciinfectADesc(tblDesc));
		this.add(getId_hospitalreportADesc(tblDesc));
		this.add(getId_operADesc(tblDesc));
		this.add(getSd_operADesc(tblDesc));
		this.add(getName_operADesc(tblDesc));
		this.add(getIsemergencyADesc(tblDesc));
		this.add(getId_oper_typeADesc(tblDesc));
		this.add(getSd_oper_typeADesc(tblDesc));
		this.add(getName_oper_typeADesc(tblDesc));
		this.add(getId_type_surinciADesc(tblDesc));
		this.add(getSd_type_surinciADesc(tblDesc));
		this.add(getName_type_surinciADesc(tblDesc));
		this.add(getIscauseinciADesc(tblDesc));
		this.add(getDt_startADesc(tblDesc));
		this.add(getDt_endADesc(tblDesc));
		this.add(getId_anes_methodsADesc(tblDesc));
		this.add(getSd_anes_methodsADesc(tblDesc));
		this.add(getName_anes_methodsADesc(tblDesc));
		this.add(getOper_doctorADesc(tblDesc));
		this.add(getTech_titleADesc(tblDesc));
		this.add(getId_incision_typeADesc(tblDesc));
		this.add(getSd_incision_typeADesc(tblDesc));
		this.add(getName_incision_typeADesc(tblDesc));
		this.add(getId_heal_conditionADesc(tblDesc));
		this.add(getSd_heal_conditionADesc(tblDesc));
		this.add(getName_heal_conditionADesc(tblDesc));
		this.add(getIs_inci_infectionADesc(tblDesc));
		this.add(getId_type_surg_siteinfeADesc(tblDesc));
		this.add(getSd_type_surg_siteinfeADesc(tblDesc));
		this.add(getName_type_surg_siteinfeADesc(tblDesc));
		this.add(getCount_white_cellADesc(tblDesc));
		this.add(getId_asa_scoreADesc(tblDesc));
		this.add(getSd_asa_scoreADesc(tblDesc));
		this.add(getName_asa_scoreADesc(tblDesc));
		this.add(getId_class_phy_conditionADesc(tblDesc));
		this.add(getSd_class_phy_conditionADesc(tblDesc));
		this.add(getName_class_phy_conditionADesc(tblDesc));
		this.add(getId_mult_operADesc(tblDesc));
		this.add(getSd_mult_operADesc(tblDesc));
		this.add(getName_mult_operADesc(tblDesc));
		this.add(getId_endos_surgADesc(tblDesc));
		this.add(getSd_endos_surgADesc(tblDesc));
		this.add(getName_endos_surgADesc(tblDesc));
		this.add(getId_pros_graftADesc(tblDesc));
		this.add(getSd_pros_graftADesc(tblDesc));
		this.add(getName_pros_graftADesc(tblDesc));
		this.add(getId_surg_site_nfeADesc(tblDesc));
		this.add(getSd_surg_site_nfeADesc(tblDesc));
		this.add(getName_surg_site_nfeADesc(tblDesc));
		this.add(getOper_codeADesc(tblDesc));
		this.add(getOper_nameADesc(tblDesc));
		this.add(getOper_type_codeADesc(tblDesc));
		this.add(getOper_type_nameADesc(tblDesc));
		this.add(getType_surinci_codeADesc(tblDesc));
		this.add(getType_surinci_nameADesc(tblDesc));
		this.add(getAnes_methods_codeADesc(tblDesc));
		this.add(getAnes_methods_nameADesc(tblDesc));
		this.add(getIncision_type_codeADesc(tblDesc));
		this.add(getIncision_type_nameADesc(tblDesc));
		this.add(getHeal_condition_codeADesc(tblDesc));
		this.add(getHeal_condition_nameADesc(tblDesc));
		this.add(getType_surg_siteinfe_codeADesc(tblDesc));
		this.add(getType_surg_siteinfe_nameADesc(tblDesc));
		this.add(getAsa_score_codeADesc(tblDesc));
		this.add(getAsa_score_nameADesc(tblDesc));
		this.add(getClass_phy_condition_codeADesc(tblDesc));
		this.add(getClass_phy_condition_nameADesc(tblDesc));
		this.add(getMult_oper_codeADesc(tblDesc));
		this.add(getMult_oper_nameADesc(tblDesc));
		this.add(getEndos_surg_codeADesc(tblDesc));
		this.add(getEndos_surg_nameADesc(tblDesc));
		this.add(getPros_graft_codeADesc(tblDesc));
		this.add(getPros_graft_nameADesc(tblDesc));
		this.add(getSurg_site_nfe_codeADesc(tblDesc));
		this.add(getSurg_site_nfe_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_operinciinfectCDesc(tblDesc));
		tblDesc.add(getId_operinciinfectCDesc(tblDesc));
		tblDesc.add(getId_hospitalreportCDesc(tblDesc));
		tblDesc.add(getId_operCDesc(tblDesc));
		tblDesc.add(getSd_operCDesc(tblDesc));
		tblDesc.add(getName_operCDesc(tblDesc));
		tblDesc.add(getIsemergencyCDesc(tblDesc));
		tblDesc.add(getId_oper_typeCDesc(tblDesc));
		tblDesc.add(getSd_oper_typeCDesc(tblDesc));
		tblDesc.add(getName_oper_typeCDesc(tblDesc));
		tblDesc.add(getId_type_surinciCDesc(tblDesc));
		tblDesc.add(getSd_type_surinciCDesc(tblDesc));
		tblDesc.add(getName_type_surinciCDesc(tblDesc));
		tblDesc.add(getIscauseinciCDesc(tblDesc));
		tblDesc.add(getDt_startCDesc(tblDesc));
		tblDesc.add(getDt_endCDesc(tblDesc));
		tblDesc.add(getId_anes_methodsCDesc(tblDesc));
		tblDesc.add(getSd_anes_methodsCDesc(tblDesc));
		tblDesc.add(getName_anes_methodsCDesc(tblDesc));
		tblDesc.add(getOper_doctorCDesc(tblDesc));
		tblDesc.add(getTech_titleCDesc(tblDesc));
		tblDesc.add(getId_incision_typeCDesc(tblDesc));
		tblDesc.add(getSd_incision_typeCDesc(tblDesc));
		tblDesc.add(getName_incision_typeCDesc(tblDesc));
		tblDesc.add(getId_heal_conditionCDesc(tblDesc));
		tblDesc.add(getSd_heal_conditionCDesc(tblDesc));
		tblDesc.add(getName_heal_conditionCDesc(tblDesc));
		tblDesc.add(getIs_inci_infectionCDesc(tblDesc));
		tblDesc.add(getId_type_surg_siteinfeCDesc(tblDesc));
		tblDesc.add(getSd_type_surg_siteinfeCDesc(tblDesc));
		tblDesc.add(getName_type_surg_siteinfeCDesc(tblDesc));
		tblDesc.add(getCount_white_cellCDesc(tblDesc));
		tblDesc.add(getId_asa_scoreCDesc(tblDesc));
		tblDesc.add(getSd_asa_scoreCDesc(tblDesc));
		tblDesc.add(getName_asa_scoreCDesc(tblDesc));
		tblDesc.add(getId_class_phy_conditionCDesc(tblDesc));
		tblDesc.add(getSd_class_phy_conditionCDesc(tblDesc));
		tblDesc.add(getName_class_phy_conditionCDesc(tblDesc));
		tblDesc.add(getId_mult_operCDesc(tblDesc));
		tblDesc.add(getSd_mult_operCDesc(tblDesc));
		tblDesc.add(getName_mult_operCDesc(tblDesc));
		tblDesc.add(getId_endos_surgCDesc(tblDesc));
		tblDesc.add(getSd_endos_surgCDesc(tblDesc));
		tblDesc.add(getName_endos_surgCDesc(tblDesc));
		tblDesc.add(getId_pros_graftCDesc(tblDesc));
		tblDesc.add(getSd_pros_graftCDesc(tblDesc));
		tblDesc.add(getName_pros_graftCDesc(tblDesc));
		tblDesc.add(getId_surg_site_nfeCDesc(tblDesc));
		tblDesc.add(getSd_surg_site_nfeCDesc(tblDesc));
		tblDesc.add(getName_surg_site_nfeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 手术切口感染主键ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_operinciinfectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_operinciinfect",  getId_operinciinfectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术切口感染主键ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
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
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oper",  getId_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper",  getSd_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术编码");
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
	private IAttrDesc getName_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper",  getName_operCDesc(tblDesc), this);
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
	 * 急诊手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIsemergencyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Isemergency",  getIsemergencyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("急诊手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_oper_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oper_type",  getId_oper_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_type",  getSd_oper_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_type",  getName_oper_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术切口类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_type_surinciADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_type_surinci",  getId_type_surinciCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术切口类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术切口类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_type_surinciADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_type_surinci",  getSd_type_surinciCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术切口类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术切口类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_type_surinciADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_type_surinci",  getName_type_surinciCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术切口类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引起院内感染属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIscauseinciADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Iscauseinci",  getIscauseinciCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("引起院内感染");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_startADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_start",  getDt_startCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end",  getDt_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("结束时间");
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
	private IAttrDesc getId_anes_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_anes_methods",  getId_anes_methodsCDesc(tblDesc), this);
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
	private IAttrDesc getSd_anes_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_anes_methods",  getSd_anes_methodsCDesc(tblDesc), this);
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
	 * 麻醉方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_anes_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_anes_methods",  getName_anes_methodsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_doctorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_doctor",  getOper_doctorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTech_titleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tech_title",  getTech_titleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_incision_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_incision_type",  getId_incision_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 切口类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_incision_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_incision_type",  getSd_incision_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_incision_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_incision_type",  getName_incision_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 愈合情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_heal_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_heal_condition",  getId_heal_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("愈合情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 愈合情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_heal_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_heal_condition",  getSd_heal_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("愈合情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 愈合情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_heal_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_heal_condition",  getName_heal_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("愈合情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口感染属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_inci_infectionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_inci_infection",  getIs_inci_infectionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("切口感染");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位感染类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_type_surg_siteinfeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_type_surg_siteinfe",  getId_type_surg_siteinfeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位感染类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术部位感染类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_type_surg_siteinfeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_type_surg_siteinfe",  getSd_type_surg_siteinfeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位感染类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位感染类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_type_surg_siteinfeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_type_surg_siteinfe",  getName_type_surg_siteinfeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位感染类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前白细胞数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCount_white_cellADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Count_white_cell",  getCount_white_cellCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术前白细胞数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ASA评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_asa_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_asa_score",  getId_asa_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ASA评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * ASA评分编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_asa_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_asa_score",  getSd_asa_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ASA评分编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ASA评分名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_asa_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_asa_score",  getName_asa_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ASA评分名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 美国麻醉学会体质状况分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_class_phy_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_class_phy_condition",  getId_class_phy_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("美国麻醉学会体质状况分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 美国麻醉学会体质状况分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_class_phy_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_class_phy_condition",  getSd_class_phy_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("美国麻醉学会体质状况分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 美国麻醉学会体质状况分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_class_phy_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_class_phy_condition",  getName_class_phy_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("美国麻醉学会体质状况分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 多种操作属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mult_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mult_oper",  getId_mult_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("多种操作");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 多种操作编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mult_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mult_oper",  getSd_mult_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("多种操作编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 多种操作名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mult_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mult_oper",  getName_mult_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("多种操作名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 腔镜手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_endos_surgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_endos_surg",  getId_endos_surgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("腔镜手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 腔镜手术编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_endos_surgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_endos_surg",  getSd_endos_surgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("腔镜手术编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 腔镜手术名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_endos_surgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_endos_surg",  getName_endos_surgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("腔镜手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 假体或移植物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pros_graftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pros_graft",  getId_pros_graftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("假体或移植物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 假体或移植物编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pros_graftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pros_graft",  getSd_pros_graftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("假体或移植物编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 假体或移植物名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pros_graftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pros_graft",  getName_pros_graftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("假体或移植物名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术感染部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_surg_site_nfeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_surg_site_nfe",  getId_surg_site_nfeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术感染部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术感染部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_surg_site_nfeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_surg_site_nfe",  getSd_surg_site_nfeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术感染部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术感染部位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_surg_site_nfeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_surg_site_nfe",  getName_surg_site_nfeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术感染部位名称");
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
	private IAttrDesc getOper_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_code",  getOper_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b2","id_oper=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_name",  getOper_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b2","id_oper=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_type_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_type_code",  getOper_type_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_oper_type=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_type_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_type_name",  getOper_type_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_oper_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getType_surinci_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Type_surinci_code",  getType_surinci_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_type_surinci=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getType_surinci_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Type_surinci_name",  getType_surinci_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_type_surinci=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnes_methods_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Anes_methods_code",  getAnes_methods_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_anes_methods=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnes_methods_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Anes_methods_name",  getAnes_methods_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_anes_methods=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncision_type_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incision_type_code",  getIncision_type_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_incision_type=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncision_type_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incision_type_name",  getIncision_type_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_incision_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeal_condition_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heal_condition_code",  getHeal_condition_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_heal_condition=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeal_condition_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heal_condition_name",  getHeal_condition_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_heal_condition=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getType_surg_siteinfe_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Type_surg_siteinfe_code",  getType_surg_siteinfe_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_type_surg_siteinfe=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getType_surg_siteinfe_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Type_surg_siteinfe_name",  getType_surg_siteinfe_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_type_surg_siteinfe=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAsa_score_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Asa_score_code",  getAsa_score_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_asa_score=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAsa_score_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Asa_score_name",  getAsa_score_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_asa_score=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getClass_phy_condition_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Class_phy_condition_code",  getClass_phy_condition_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_class_phy_condition=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getClass_phy_condition_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Class_phy_condition_name",  getClass_phy_condition_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_class_phy_condition=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMult_oper_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mult_oper_code",  getMult_oper_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_mult_oper=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMult_oper_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mult_oper_name",  getMult_oper_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_mult_oper=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEndos_surg_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Endos_surg_code",  getEndos_surg_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_endos_surg=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEndos_surg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Endos_surg_name",  getEndos_surg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_endos_surg=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPros_graft_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pros_graft_code",  getPros_graft_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_pros_graft=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPros_graft_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pros_graft_name",  getPros_graft_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_pros_graft=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSurg_site_nfe_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Surg_site_nfe_code",  getSurg_site_nfe_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_surg_site_nfe=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSurg_site_nfe_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Surg_site_nfe_name",  getSurg_site_nfe_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_surg_site_nfe=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取手术切口感染主键ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_operinciinfectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_operinciinfect");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术切口感染主键ID"); 
		return column;
	}
	/**
	 * 获取院感上报主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hospitalreportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hospitalreport");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("院感上报主键"); 
		return column;
	}
	/**
	 * 获取手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术"); 
		return column;
	}
	/**
	 * 获取手术编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术编码"); 
		return column;
	}
	/**
	 * 获取手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术名称"); 
		return column;
	}
	/**
	 * 获取急诊手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIsemergencyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Isemergency");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("急诊手术"); 
		return column;
	}
	/**
	 * 获取手术类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_oper_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oper_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术类型"); 
		return column;
	}
	/**
	 * 获取手术类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术类型编码"); 
		return column;
	}
	/**
	 * 获取手术类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术类型名称"); 
		return column;
	}
	/**
	 * 获取手术切口类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_type_surinciCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_type_surinci");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术切口类型"); 
		return column;
	}
	/**
	 * 获取手术切口类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_type_surinciCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_type_surinci");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术切口类型编码"); 
		return column;
	}
	/**
	 * 获取手术切口类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_type_surinciCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_type_surinci");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术切口类型名称"); 
		return column;
	}
	/**
	 * 获取引起院内感染表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIscauseinciCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Iscauseinci");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("引起院内感染"); 
		return column;
	}
	/**
	 * 获取开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_startCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_start");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开始时间"); 
		return column;
	}
	/**
	 * 获取结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结束时间"); 
		return column;
	}
	/**
	 * 获取麻醉方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_anes_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_anes_methods");
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
	private IColumnDesc getSd_anes_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_anes_methods");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式编码"); 
		return column;
	}
	/**
	 * 获取麻醉方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_anes_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_anes_methods");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式名称"); 
		return column;
	}
	/**
	 * 获取手术医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_doctorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_doctor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术医生"); 
		return column;
	}
	/**
	 * 获取职称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTech_titleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tech_title");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职称"); 
		return column;
	}
	/**
	 * 获取切口类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_incision_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_incision_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口类型"); 
		return column;
	}
	/**
	 * 获取切口类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_incision_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_incision_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口类型编码"); 
		return column;
	}
	/**
	 * 获取切口类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_incision_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_incision_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口类型名称"); 
		return column;
	}
	/**
	 * 获取愈合情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_heal_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_heal_condition");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("愈合情况"); 
		return column;
	}
	/**
	 * 获取愈合情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_heal_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_heal_condition");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("愈合情况编码"); 
		return column;
	}
	/**
	 * 获取愈合情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_heal_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_heal_condition");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("愈合情况名称"); 
		return column;
	}
	/**
	 * 获取切口感染表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_inci_infectionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_inci_infection");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("切口感染"); 
		return column;
	}
	/**
	 * 获取手术部位感染类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_type_surg_siteinfeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_type_surg_siteinfe");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位感染类型"); 
		return column;
	}
	/**
	 * 获取手术部位感染类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_type_surg_siteinfeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_type_surg_siteinfe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位感染类型编码"); 
		return column;
	}
	/**
	 * 获取手术部位感染类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_type_surg_siteinfeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_type_surg_siteinfe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位感染类型名称"); 
		return column;
	}
	/**
	 * 获取术前白细胞数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCount_white_cellCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Count_white_cell");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术前白细胞数"); 
		return column;
	}
	/**
	 * 获取ASA评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_asa_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_asa_score");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ASA评分"); 
		return column;
	}
	/**
	 * 获取ASA评分编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_asa_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_asa_score");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ASA评分编码"); 
		return column;
	}
	/**
	 * 获取ASA评分名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_asa_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_asa_score");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ASA评分名称"); 
		return column;
	}
	/**
	 * 获取美国麻醉学会体质状况分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_class_phy_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_class_phy_condition");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("美国麻醉学会体质状况分类"); 
		return column;
	}
	/**
	 * 获取美国麻醉学会体质状况分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_class_phy_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_class_phy_condition");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("美国麻醉学会体质状况分类编码"); 
		return column;
	}
	/**
	 * 获取美国麻醉学会体质状况分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_class_phy_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_class_phy_condition");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("美国麻醉学会体质状况分类名称"); 
		return column;
	}
	/**
	 * 获取多种操作表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mult_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mult_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("多种操作"); 
		return column;
	}
	/**
	 * 获取多种操作编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mult_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mult_oper");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("多种操作编码"); 
		return column;
	}
	/**
	 * 获取多种操作名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mult_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mult_oper");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("多种操作名称"); 
		return column;
	}
	/**
	 * 获取腔镜手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_endos_surgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_endos_surg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("腔镜手术"); 
		return column;
	}
	/**
	 * 获取腔镜手术编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_endos_surgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_endos_surg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("腔镜手术编码"); 
		return column;
	}
	/**
	 * 获取腔镜手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_endos_surgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_endos_surg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("腔镜手术名称"); 
		return column;
	}
	/**
	 * 获取假体或移植物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pros_graftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pros_graft");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("假体或移植物"); 
		return column;
	}
	/**
	 * 获取假体或移植物编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pros_graftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pros_graft");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("假体或移植物编码"); 
		return column;
	}
	/**
	 * 获取假体或移植物名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pros_graftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pros_graft");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("假体或移植物名称"); 
		return column;
	}
	/**
	 * 获取手术感染部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_surg_site_nfeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_surg_site_nfe");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术感染部位"); 
		return column;
	}
	/**
	 * 获取手术感染部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_surg_site_nfeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_surg_site_nfe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术感染部位编码"); 
		return column;
	}
	/**
	 * 获取手术感染部位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_surg_site_nfeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_surg_site_nfe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术感染部位名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_code");
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
	private IColumnDesc getOper_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_name");
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
	private IColumnDesc getOper_type_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_type_code");
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
	private IColumnDesc getOper_type_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_type_name");
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
	private IColumnDesc getType_surinci_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Type_surinci_code");
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
	private IColumnDesc getType_surinci_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Type_surinci_name");
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
	private IColumnDesc getAnes_methods_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Anes_methods_code");
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
	private IColumnDesc getAnes_methods_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Anes_methods_name");
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
	private IColumnDesc getIncision_type_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incision_type_code");
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
	private IColumnDesc getIncision_type_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incision_type_name");
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
	private IColumnDesc getHeal_condition_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heal_condition_code");
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
	private IColumnDesc getHeal_condition_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heal_condition_name");
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
	private IColumnDesc getType_surg_siteinfe_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Type_surg_siteinfe_code");
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
	private IColumnDesc getType_surg_siteinfe_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Type_surg_siteinfe_name");
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
	private IColumnDesc getAsa_score_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Asa_score_code");
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
	private IColumnDesc getAsa_score_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Asa_score_name");
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
	private IColumnDesc getClass_phy_condition_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Class_phy_condition_code");
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
	private IColumnDesc getClass_phy_condition_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Class_phy_condition_name");
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
	private IColumnDesc getMult_oper_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mult_oper_code");
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
	private IColumnDesc getMult_oper_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mult_oper_name");
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
	private IColumnDesc getEndos_surg_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Endos_surg_code");
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
	private IColumnDesc getEndos_surg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Endos_surg_name");
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
	private IColumnDesc getPros_graft_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pros_graft_code");
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
	private IColumnDesc getPros_graft_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pros_graft_name");
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
	private IColumnDesc getSurg_site_nfe_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Surg_site_nfe_code");
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
	private IColumnDesc getSurg_site_nfe_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Surg_site_nfe_name");
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
