
package iih.ci.rcm.au.d.desc;

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
 * 抗菌用药 DO 元数据信息
 */
public class AntibioticUseDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.au.d.AntibioticUseDO";
	public static final String CLASS_DISPALYNAME = "抗菌用药";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_CONTAGION_CARD_AU";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_au";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public AntibioticUseDODesc(){
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
		this.setKeyDesc(getId_auADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_auADesc(tblDesc));
		this.add(getId_hospitalreportADesc(tblDesc));
		this.add(getIsuseantibiADesc(tblDesc));
		this.add(getId_drugADesc(tblDesc));
		this.add(getSd_drugADesc(tblDesc));
		this.add(getName_drugADesc(tblDesc));
		this.add(getId_route_adminisADesc(tblDesc));
		this.add(getSd_route_adminisADesc(tblDesc));
		this.add(getName_route_adminisADesc(tblDesc));
		this.add(getDoseADesc(tblDesc));
		this.add(getId_dose_unitADesc(tblDesc));
		this.add(getSd_dose_unitADesc(tblDesc));
		this.add(getName_dose_unitADesc(tblDesc));
		this.add(getUsageADesc(tblDesc));
		this.add(getDt_startADesc(tblDesc));
		this.add(getDt_endADesc(tblDesc));
		this.add(getId_medi_methodsADesc(tblDesc));
		this.add(getSd_medi_methodsADesc(tblDesc));
		this.add(getName_medi_methodsADesc(tblDesc));
		this.add(getId_objectiveADesc(tblDesc));
		this.add(getSd_objectiveADesc(tblDesc));
		this.add(getName_objectiveADesc(tblDesc));
		this.add(getId_treat_methodsADesc(tblDesc));
		this.add(getSd_treat_methodsADesc(tblDesc));
		this.add(getName_treat_methodsADesc(tblDesc));
		this.add(getId_pre_methodsADesc(tblDesc));
		this.add(getSd_pre_methodsADesc(tblDesc));
		this.add(getName_pre_methodsADesc(tblDesc));
		this.add(getIs_pre_drug_useADesc(tblDesc));
		this.add(getId_pre_effectADesc(tblDesc));
		this.add(getSd_pre_effectADesc(tblDesc));
		this.add(getName_pre_effectADesc(tblDesc));
		this.add(getId_com_mediADesc(tblDesc));
		this.add(getSd_com_mediADesc(tblDesc));
		this.add(getName_com_mediADesc(tblDesc));
		this.add(getPre_medi_timeADesc(tblDesc));
		this.add(getDays_after_operADesc(tblDesc));
		this.add(getAdv_drug_reactionsADesc(tblDesc));
		this.add(getDouble_infectionADesc(tblDesc));
		this.add(getDrug_codeADesc(tblDesc));
		this.add(getDrug_nameADesc(tblDesc));
		this.add(getRoute_adminis_codeADesc(tblDesc));
		this.add(getRoute_adminis_nameADesc(tblDesc));
		this.add(getDose_unit_codeADesc(tblDesc));
		this.add(getDose_unit_nameADesc(tblDesc));
		this.add(getMedi_methods_codeADesc(tblDesc));
		this.add(getMedi_methods_nameADesc(tblDesc));
		this.add(getObjective_codeADesc(tblDesc));
		this.add(getObjective_nameADesc(tblDesc));
		this.add(getTreat_methods_codeADesc(tblDesc));
		this.add(getTreat_methods_nameADesc(tblDesc));
		this.add(getPre_methods_codeADesc(tblDesc));
		this.add(getPre_methods_nameADesc(tblDesc));
		this.add(getPre_effect_codeADesc(tblDesc));
		this.add(getPre_effect_nameADesc(tblDesc));
		this.add(getCom_medi_codeADesc(tblDesc));
		this.add(getCom_medi_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_auCDesc(tblDesc));
		tblDesc.add(getId_auCDesc(tblDesc));
		tblDesc.add(getId_hospitalreportCDesc(tblDesc));
		tblDesc.add(getIsuseantibiCDesc(tblDesc));
		tblDesc.add(getId_drugCDesc(tblDesc));
		tblDesc.add(getSd_drugCDesc(tblDesc));
		tblDesc.add(getName_drugCDesc(tblDesc));
		tblDesc.add(getId_route_adminisCDesc(tblDesc));
		tblDesc.add(getSd_route_adminisCDesc(tblDesc));
		tblDesc.add(getName_route_adminisCDesc(tblDesc));
		tblDesc.add(getDoseCDesc(tblDesc));
		tblDesc.add(getId_dose_unitCDesc(tblDesc));
		tblDesc.add(getSd_dose_unitCDesc(tblDesc));
		tblDesc.add(getName_dose_unitCDesc(tblDesc));
		tblDesc.add(getUsageCDesc(tblDesc));
		tblDesc.add(getDt_startCDesc(tblDesc));
		tblDesc.add(getDt_endCDesc(tblDesc));
		tblDesc.add(getId_medi_methodsCDesc(tblDesc));
		tblDesc.add(getSd_medi_methodsCDesc(tblDesc));
		tblDesc.add(getName_medi_methodsCDesc(tblDesc));
		tblDesc.add(getId_objectiveCDesc(tblDesc));
		tblDesc.add(getSd_objectiveCDesc(tblDesc));
		tblDesc.add(getName_objectiveCDesc(tblDesc));
		tblDesc.add(getId_treat_methodsCDesc(tblDesc));
		tblDesc.add(getSd_treat_methodsCDesc(tblDesc));
		tblDesc.add(getName_treat_methodsCDesc(tblDesc));
		tblDesc.add(getId_pre_methodsCDesc(tblDesc));
		tblDesc.add(getSd_pre_methodsCDesc(tblDesc));
		tblDesc.add(getName_pre_methodsCDesc(tblDesc));
		tblDesc.add(getIs_pre_drug_useCDesc(tblDesc));
		tblDesc.add(getId_pre_effectCDesc(tblDesc));
		tblDesc.add(getSd_pre_effectCDesc(tblDesc));
		tblDesc.add(getName_pre_effectCDesc(tblDesc));
		tblDesc.add(getId_com_mediCDesc(tblDesc));
		tblDesc.add(getSd_com_mediCDesc(tblDesc));
		tblDesc.add(getName_com_mediCDesc(tblDesc));
		tblDesc.add(getPre_medi_timeCDesc(tblDesc));
		tblDesc.add(getDays_after_operCDesc(tblDesc));
		tblDesc.add(getAdv_drug_reactionsCDesc(tblDesc));
		tblDesc.add(getDouble_infectionCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 抗菌用药主键ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_auADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_au",  getId_auCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗菌用药主键ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 院感上报主卡主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hospitalreportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hospitalreport",  getId_hospitalreportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("院感上报主卡主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用抗菌药物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIsuseantibiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Isuseantibi",  getIsuseantibiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("使用抗菌药物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药名（化学名）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drug",  getId_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药名（化学名）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药名（化学名）编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_drug",  getSd_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药名（化学名）编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药名（化学名）名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drug",  getName_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药名（化学名）名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 给药途径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_route_adminisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_route_adminis",  getId_route_adminisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("给药途径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 给药途径编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_route_adminisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_route_adminis",  getSd_route_adminisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("给药途径编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 给药途径名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_route_adminisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_route_adminis",  getName_route_adminisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("给药途径名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 剂量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dose",  getDoseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("剂量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 剂量单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dose_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dose_unit",  getId_dose_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("剂量单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 剂量单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dose_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dose_unit",  getSd_dose_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("剂量单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 剂量单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dose_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dose_unit",  getName_dose_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("剂量单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUsageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Usage",  getUsageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 起始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_startADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_start",  getDt_startCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("起始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 截至时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end",  getDt_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("截至时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用药方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_medi_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_medi_methods",  getId_medi_methodsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用药方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 用药方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_medi_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_medi_methods",  getSd_medi_methodsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用药方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用药方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_medi_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_medi_methods",  getName_medi_methodsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用药方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 目的属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_objectiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_objective",  getId_objectiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目的");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 目的编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_objectiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_objective",  getSd_objectiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目的编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 目的名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_objectiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_objective",  getName_objectiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目的名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 治疗用药方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_treat_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_treat_methods",  getId_treat_methodsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("治疗用药方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 治疗用药方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_treat_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_treat_methods",  getSd_treat_methodsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("治疗用药方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 治疗用药方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_treat_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_treat_methods",  getName_treat_methodsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("治疗用药方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预防用药方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pre_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pre_methods",  getId_pre_methodsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预防用药方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 预防用药方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pre_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pre_methods",  getSd_pre_methodsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预防用药方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预防用药方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pre_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pre_methods",  getName_pre_methodsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预防用药方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预防用药指征属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_pre_drug_useADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_pre_drug_use",  getIs_pre_drug_useCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("预防用药指征");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预防用药效果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pre_effectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pre_effect",  getId_pre_effectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预防用药效果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 预防用药效果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pre_effectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pre_effect",  getSd_pre_effectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预防用药效果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预防用药效果名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pre_effectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pre_effect",  getName_pre_effectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预防用药效果名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联合用药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_com_mediADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_com_medi",  getId_com_mediCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联合用药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 联合用药编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_com_mediADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_com_medi",  getSd_com_mediCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联合用药编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联合用药名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_com_mediADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_com_medi",  getName_com_mediCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联合用药名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前用药时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPre_medi_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pre_medi_time",  getPre_medi_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前用药时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后用药天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDays_after_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Days_after_oper",  getDays_after_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后用药天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药物不良反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdv_drug_reactionsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Adv_drug_reactions",  getAdv_drug_reactionsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("药物不良反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 二重感染属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDouble_infectionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Double_infection",  getDouble_infectionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("二重感染");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrug_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drug_code",  getDrug_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b10","id_drug=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrug_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drug_name",  getDrug_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b10","id_drug=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoute_adminis_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Route_adminis_code",  getRoute_adminis_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_route_adminis=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoute_adminis_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Route_adminis_name",  getRoute_adminis_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_route_adminis=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDose_unit_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dose_unit_code",  getDose_unit_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_dose_unit=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDose_unit_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dose_unit_name",  getDose_unit_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_dose_unit=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMedi_methods_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Medi_methods_code",  getMedi_methods_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_medi_methods=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMedi_methods_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Medi_methods_name",  getMedi_methods_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_medi_methods=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getObjective_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Objective_code",  getObjective_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_objective=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getObjective_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Objective_name",  getObjective_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_objective=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTreat_methods_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Treat_methods_code",  getTreat_methods_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_treat_methods=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTreat_methods_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Treat_methods_name",  getTreat_methods_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_treat_methods=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPre_methods_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pre_methods_code",  getPre_methods_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_pre_methods=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPre_methods_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pre_methods_name",  getPre_methods_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_pre_methods=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPre_effect_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pre_effect_code",  getPre_effect_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_pre_effect=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPre_effect_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pre_effect_name",  getPre_effect_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_pre_effect=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCom_medi_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Com_medi_code",  getCom_medi_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_com_medi=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCom_medi_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Com_medi_name",  getCom_medi_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_com_medi=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取抗菌用药主键ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_auCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_au");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("抗菌用药主键ID"); 
		return column;
	}
	/**
	 * 获取院感上报主卡主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hospitalreportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hospitalreport");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("院感上报主卡主键"); 
		return column;
	}
	/**
	 * 获取使用抗菌药物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIsuseantibiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Isuseantibi");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("使用抗菌药物"); 
		return column;
	}
	/**
	 * 获取药名（化学名）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药名（化学名）"); 
		return column;
	}
	/**
	 * 获取药名（化学名）编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_drug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药名（化学名）编码"); 
		return column;
	}
	/**
	 * 获取药名（化学名）名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药名（化学名）名称"); 
		return column;
	}
	/**
	 * 获取给药途径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_route_adminisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_route_adminis");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药途径"); 
		return column;
	}
	/**
	 * 获取给药途径编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_route_adminisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_route_adminis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药途径编码"); 
		return column;
	}
	/**
	 * 获取给药途径名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_route_adminisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_route_adminis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药途径名称"); 
		return column;
	}
	/**
	 * 获取剂量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDoseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dose");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("剂量"); 
		return column;
	}
	/**
	 * 获取剂量单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dose_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dose_unit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("剂量单位"); 
		return column;
	}
	/**
	 * 获取剂量单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dose_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dose_unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("剂量单位编码"); 
		return column;
	}
	/**
	 * 获取剂量单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dose_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dose_unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("剂量单位名称"); 
		return column;
	}
	/**
	 * 获取用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUsageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Usage");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("用法"); 
		return column;
	}
	/**
	 * 获取起始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_startCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_start");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("起始时间"); 
		return column;
	}
	/**
	 * 获取截至时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("截至时间"); 
		return column;
	}
	/**
	 * 获取用药方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_medi_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_medi_methods");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用药方式"); 
		return column;
	}
	/**
	 * 获取用药方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_medi_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_medi_methods");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用药方式编码"); 
		return column;
	}
	/**
	 * 获取用药方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_medi_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_medi_methods");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用药方式名称"); 
		return column;
	}
	/**
	 * 获取目的表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_objectiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_objective");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目的"); 
		return column;
	}
	/**
	 * 获取目的编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_objectiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_objective");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目的编码"); 
		return column;
	}
	/**
	 * 获取目的名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_objectiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_objective");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目的名称"); 
		return column;
	}
	/**
	 * 获取治疗用药方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_treat_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_treat_methods");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("治疗用药方式"); 
		return column;
	}
	/**
	 * 获取治疗用药方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_treat_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_treat_methods");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("治疗用药方式编码"); 
		return column;
	}
	/**
	 * 获取治疗用药方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_treat_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_treat_methods");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("治疗用药方式名称"); 
		return column;
	}
	/**
	 * 获取预防用药方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pre_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pre_methods");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预防用药方式"); 
		return column;
	}
	/**
	 * 获取预防用药方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pre_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pre_methods");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预防用药方式编码"); 
		return column;
	}
	/**
	 * 获取预防用药方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pre_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pre_methods");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预防用药方式名称"); 
		return column;
	}
	/**
	 * 获取预防用药指征表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_pre_drug_useCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_pre_drug_use");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预防用药指征"); 
		return column;
	}
	/**
	 * 获取预防用药效果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pre_effectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pre_effect");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预防用药效果"); 
		return column;
	}
	/**
	 * 获取预防用药效果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pre_effectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pre_effect");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预防用药效果编码"); 
		return column;
	}
	/**
	 * 获取预防用药效果名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pre_effectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pre_effect");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预防用药效果名称"); 
		return column;
	}
	/**
	 * 获取联合用药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_com_mediCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_com_medi");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联合用药"); 
		return column;
	}
	/**
	 * 获取联合用药编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_com_mediCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_com_medi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联合用药编码"); 
		return column;
	}
	/**
	 * 获取联合用药名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_com_mediCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_com_medi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联合用药名称"); 
		return column;
	}
	/**
	 * 获取术前用药时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPre_medi_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pre_medi_time");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前用药时间"); 
		return column;
	}
	/**
	 * 获取术后用药天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDays_after_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days_after_oper");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后用药天数"); 
		return column;
	}
	/**
	 * 获取药物不良反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdv_drug_reactionsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Adv_drug_reactions");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("药物不良反应"); 
		return column;
	}
	/**
	 * 获取二重感染表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDouble_infectionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Double_infection");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("二重感染"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrug_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drug_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrug_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drug_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRoute_adminis_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Route_adminis_code");
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
	private IColumnDesc getRoute_adminis_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Route_adminis_name");
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
	private IColumnDesc getDose_unit_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dose_unit_code");
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
	private IColumnDesc getDose_unit_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dose_unit_name");
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
	private IColumnDesc getMedi_methods_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Medi_methods_code");
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
	private IColumnDesc getMedi_methods_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Medi_methods_name");
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
	private IColumnDesc getObjective_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Objective_code");
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
	private IColumnDesc getObjective_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Objective_name");
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
	private IColumnDesc getTreat_methods_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Treat_methods_code");
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
	private IColumnDesc getTreat_methods_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Treat_methods_name");
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
	private IColumnDesc getPre_methods_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pre_methods_code");
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
	private IColumnDesc getPre_methods_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pre_methods_name");
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
	private IColumnDesc getPre_effect_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pre_effect_code");
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
	private IColumnDesc getPre_effect_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pre_effect_name");
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
	private IColumnDesc getCom_medi_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Com_medi_code");
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
	private IColumnDesc getCom_medi_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Com_medi_name");
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
