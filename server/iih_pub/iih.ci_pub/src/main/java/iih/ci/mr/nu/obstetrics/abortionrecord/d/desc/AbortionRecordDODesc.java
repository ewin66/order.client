
package iih.ci.mr.nu.obstetrics.abortionrecord.d.desc;

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
 * 中期妊娠流产记录 DO 元数据信息
 */
public class AbortionRecordDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.obstetrics.abortionrecord.d.AbortionRecordDO";
	public static final String CLASS_DISPALYNAME = "中期妊娠流产记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mr_nu_abortionrecord";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_abortion";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public AbortionRecordDODesc(){
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
		this.setKeyDesc(getId_abortionADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_abortionADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getDt_inADesc(tblDesc));
		this.add(getDt_contractionsADesc(tblDesc));
		this.add(getDt_amnioticfluid_ruptureADesc(tblDesc));
		this.add(getId_rupturetpADesc(tblDesc));
		this.add(getSd_rupturetpADesc(tblDesc));
		this.add(getId_amnioticfluid_colorADesc(tblDesc));
		this.add(getSd_amnioticfluid_colorADesc(tblDesc));
		this.add(getDt_abortionADesc(tblDesc));
		this.add(getId_childbirth_abortiontpADesc(tblDesc));
		this.add(getSd_childbirth_abortiontpADesc(tblDesc));
		this.add(getId_child_situationADesc(tblDesc));
		this.add(getSd_child_situationADesc(tblDesc));
		this.add(getLength_childADesc(tblDesc));
		this.add(getWeight_childADesc(tblDesc));
		this.add(getId_child_appearancesADesc(tblDesc));
		this.add(getSd_child_appearancesADesc(tblDesc));
		this.add(getFg_malformationADesc(tblDesc));
		this.add(getId_deliverytpADesc(tblDesc));
		this.add(getSd_deliverytpADesc(tblDesc));
		this.add(getDt_deliveryADesc(tblDesc));
		this.add(getId_placenta_birthtpADesc(tblDesc));
		this.add(getSd_placenta_birthtpADesc(tblDesc));
		this.add(getId_placenta_situationADesc(tblDesc));
		this.add(getSd_placenta_situationADesc(tblDesc));
		this.add(getId_caul_situationADesc(tblDesc));
		this.add(getSd_caul_situationADesc(tblDesc));
		this.add(getNum_bleedingADesc(tblDesc));
		this.add(getId_contractions_agentADesc(tblDesc));
		this.add(getSd_contractions_agentADesc(tblDesc));
		this.add(getId_routeADesc(tblDesc));
		this.add(getNum_bleedingedADesc(tblDesc));
		this.add(getHeightpressureADesc(tblDesc));
		this.add(getLowpressureADesc(tblDesc));
		this.add(getPulseADesc(tblDesc));
		this.add(getFg_full_bladderADesc(tblDesc));
		this.add(getId_birth_canal_chkADesc(tblDesc));
		this.add(getSd_birth_canal_chkADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getNum_bleeding_vaginaADesc(tblDesc));
		this.add(getId_order_drugADesc(tblDesc));
		this.add(getSd_order_drugADesc(tblDesc));
		this.add(getDosageADesc(tblDesc));
		this.add(getId_complicationADesc(tblDesc));
		this.add(getSd_complicationADesc(tblDesc));
		this.add(getId_emp_delyADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_rupturetpADesc(tblDesc));
		this.add(getName_amnioticfluid_colorADesc(tblDesc));
		this.add(getName_childbirth_abortiontpADesc(tblDesc));
		this.add(getName_child_situationADesc(tblDesc));
		this.add(getName_child_appearancesADesc(tblDesc));
		this.add(getName_deliverytpADesc(tblDesc));
		this.add(getName_placenta_birthtpADesc(tblDesc));
		this.add(getName_placenta_situationADesc(tblDesc));
		this.add(getName_caul_situationADesc(tblDesc));
		this.add(getName_contractions_agentADesc(tblDesc));
		this.add(getName_routeADesc(tblDesc));
		this.add(getName_birth_canal_chkADesc(tblDesc));
		this.add(getName_order_drugADesc(tblDesc));
		this.add(getName_complicationADesc(tblDesc));
		this.add(getName_emp_delyADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_abortionCDesc(tblDesc));
		tblDesc.add(getId_abortionCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getSd_sexCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getDt_inCDesc(tblDesc));
		tblDesc.add(getDt_contractionsCDesc(tblDesc));
		tblDesc.add(getDt_amnioticfluid_ruptureCDesc(tblDesc));
		tblDesc.add(getId_rupturetpCDesc(tblDesc));
		tblDesc.add(getSd_rupturetpCDesc(tblDesc));
		tblDesc.add(getId_amnioticfluid_colorCDesc(tblDesc));
		tblDesc.add(getSd_amnioticfluid_colorCDesc(tblDesc));
		tblDesc.add(getDt_abortionCDesc(tblDesc));
		tblDesc.add(getId_childbirth_abortiontpCDesc(tblDesc));
		tblDesc.add(getSd_childbirth_abortiontpCDesc(tblDesc));
		tblDesc.add(getId_child_situationCDesc(tblDesc));
		tblDesc.add(getSd_child_situationCDesc(tblDesc));
		tblDesc.add(getLength_childCDesc(tblDesc));
		tblDesc.add(getWeight_childCDesc(tblDesc));
		tblDesc.add(getId_child_appearancesCDesc(tblDesc));
		tblDesc.add(getSd_child_appearancesCDesc(tblDesc));
		tblDesc.add(getFg_malformationCDesc(tblDesc));
		tblDesc.add(getId_deliverytpCDesc(tblDesc));
		tblDesc.add(getSd_deliverytpCDesc(tblDesc));
		tblDesc.add(getDt_deliveryCDesc(tblDesc));
		tblDesc.add(getId_placenta_birthtpCDesc(tblDesc));
		tblDesc.add(getSd_placenta_birthtpCDesc(tblDesc));
		tblDesc.add(getId_placenta_situationCDesc(tblDesc));
		tblDesc.add(getSd_placenta_situationCDesc(tblDesc));
		tblDesc.add(getId_caul_situationCDesc(tblDesc));
		tblDesc.add(getSd_caul_situationCDesc(tblDesc));
		tblDesc.add(getNum_bleedingCDesc(tblDesc));
		tblDesc.add(getId_contractions_agentCDesc(tblDesc));
		tblDesc.add(getSd_contractions_agentCDesc(tblDesc));
		tblDesc.add(getId_routeCDesc(tblDesc));
		tblDesc.add(getNum_bleedingedCDesc(tblDesc));
		tblDesc.add(getHeightpressureCDesc(tblDesc));
		tblDesc.add(getLowpressureCDesc(tblDesc));
		tblDesc.add(getPulseCDesc(tblDesc));
		tblDesc.add(getFg_full_bladderCDesc(tblDesc));
		tblDesc.add(getId_birth_canal_chkCDesc(tblDesc));
		tblDesc.add(getSd_birth_canal_chkCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getNum_bleeding_vaginaCDesc(tblDesc));
		tblDesc.add(getId_order_drugCDesc(tblDesc));
		tblDesc.add(getSd_order_drugCDesc(tblDesc));
		tblDesc.add(getDosageCDesc(tblDesc));
		tblDesc.add(getId_complicationCDesc(tblDesc));
		tblDesc.add(getSd_complicationCDesc(tblDesc));
		tblDesc.add(getId_emp_delyCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 流产记录主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_abortionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_abortion",  getId_abortionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("流产记录主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
		attrDesc.setRefType(false);
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
	 * 性别ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex",  getId_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex",  getSd_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
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
	 * 住院病案号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病案号");
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
	private IAttrDesc getName_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diagnosis",  getName_diagnosisCDesc(tblDesc), this);
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
	 * 产房入室时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_in",  getDt_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("产房入室时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫缩开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_contractionsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_contractions",  getDt_contractionsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("宫缩开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 破水时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_amnioticfluid_ruptureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_amnioticfluid_rupture",  getDt_amnioticfluid_ruptureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("破水时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 破水方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rupturetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rupturetp",  getId_rupturetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("破水方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 破水方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rupturetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rupturetp",  getSd_rupturetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("破水方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水颜色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_amnioticfluid_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_amnioticfluid_color",  getId_amnioticfluid_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水颜色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 羊水颜色编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_amnioticfluid_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_amnioticfluid_color",  getSd_amnioticfluid_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水颜色编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流产时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_abortionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_abortion",  getDt_abortionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("流产时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流产分娩方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_childbirth_abortiontpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_childbirth_abortiontp",  getId_childbirth_abortiontpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("流产分娩方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 流产分娩方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_childbirth_abortiontpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_childbirth_abortiontp",  getSd_childbirth_abortiontpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("流产分娩方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_child_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_child_situation",  getId_child_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎儿情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_child_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_child_situation",  getSd_child_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLength_childADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Length_child",  getLength_childCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("身长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeight_childADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight_child",  getWeight_childCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿外观属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_child_appearancesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_child_appearances",  getId_child_appearancesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿外观");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎儿外观编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_child_appearancesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_child_appearances",  getSd_child_appearancesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿外观编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否畸形 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_malformationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_malformation",  getFg_malformationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否畸形 ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 娩出类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_deliverytpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_deliverytp",  getId_deliverytpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("娩出类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 娩出类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_deliverytpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_deliverytp",  getSd_deliverytpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("娩出类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 娩出时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_deliveryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_delivery",  getDt_deliveryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("娩出时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘娩出方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_placenta_birthtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_placenta_birthtp",  getId_placenta_birthtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘娩出方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 胎盘娩出方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_placenta_birthtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_placenta_birthtp",  getSd_placenta_birthtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘娩出方式编码");
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
	private IAttrDesc getId_placenta_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_placenta_situation",  getId_placenta_situationCDesc(tblDesc), this);
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
	private IAttrDesc getSd_placenta_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_placenta_situation",  getSd_placenta_situationCDesc(tblDesc), this);
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
	private IAttrDesc getId_caul_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_caul_situation",  getId_caul_situationCDesc(tblDesc), this);
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
	private IAttrDesc getSd_caul_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_caul_situation",  getSd_caul_situationCDesc(tblDesc), this);
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
	 * 产时出血量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_bleedingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_bleeding",  getNum_bleedingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产时出血量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫缩剂属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_contractions_agentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_contractions_agent",  getId_contractions_agentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宫缩剂");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 宫缩剂编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_contractions_agentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_contractions_agent",  getSd_contractions_agentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宫缩剂编码");
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
	private IAttrDesc getId_routeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_route",  getId_routeCDesc(tblDesc), this);
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
	 * 产后0.5h出血量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_bleedingedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_bleedinged",  getNum_bleedingedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产后0.5h出血量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 高压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeightpressureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heightpressure",  getHeightpressureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("高压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 低压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLowpressureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lowpressure",  getLowpressureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("低压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脉搏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pulse",  getPulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脉搏");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否膀胱充盈属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_full_bladderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_full_bladder",  getFg_full_bladderCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否膀胱充盈");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产道检查属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_birth_canal_chkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_birth_canal_chk",  getId_birth_canal_chkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产道检查");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 产道检查编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_birth_canal_chkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_birth_canal_chk",  getSd_birth_canal_chkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产道检查编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 阴道出血量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_bleeding_vaginaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_bleeding_vagina",  getNum_bleeding_vaginaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("阴道出血量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 遵医嘱给予属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_order_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_order_drug",  getId_order_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("遵医嘱给予");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 遵医嘱给予编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_order_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_order_drug",  getSd_order_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("遵医嘱给予编码");
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
	private IAttrDesc getDosageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dosage",  getDosageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("剂量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 并发症属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_complicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_complication",  getId_complicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("并发症");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 并发症编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_complicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_complication",  getSd_complicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("并发症编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接生医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_delyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_dely",  getId_emp_delyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接生医生");
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dep_nur=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 破水方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rupturetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rupturetp",  getName_rupturetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("破水方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_rupturetp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 羊水颜色名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_amnioticfluid_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_amnioticfluid_color",  getName_amnioticfluid_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("羊水颜色名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_amnioticfluid_color=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_childbirth_abortiontpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_childbirth_abortiontp",  getName_childbirth_abortiontpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_childbirth_abortiontp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_child_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_child_situation",  getName_child_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_child_situation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎儿外观名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_child_appearancesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_child_appearances",  getName_child_appearancesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎儿外观名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_child_appearances=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 娩出类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deliverytpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_deliverytp",  getName_deliverytpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("娩出类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_deliverytp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘娩出方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_placenta_birthtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_placenta_birthtp",  getName_placenta_birthtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘娩出方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_placenta_birthtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎盘情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_placenta_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_placenta_situation",  getName_placenta_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎盘情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_placenta_situation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎膜情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_caul_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_caul_situation",  getName_caul_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("胎膜情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_caul_situation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫缩剂名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_contractions_agentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_contractions_agent",  getName_contractions_agentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宫缩剂名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_contractions_agent=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_routeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_route",  getName_routeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_route a0b20","id_route=id_route","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产道检查名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_birth_canal_chkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_birth_canal_chk",  getName_birth_canal_chkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产道检查名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_birth_canal_chk=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 遵医嘱给予名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_order_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_order_drug",  getName_order_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("遵医嘱给予名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_order_drug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 并发症名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_complicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_complication",  getName_complicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("并发症名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_complication=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接生医生姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_delyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_dely",  getName_emp_delyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接生医生姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b24","id_emp_dely=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取流产记录主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_abortionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_abortion");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("流产记录主键标识"); 
		return column;
	}
	/**
	 * 获取集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织"); 
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
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
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
	 * 获取性别ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别ID"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
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
	 * 获取住院病案号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院病案号"); 
		return column;
	}
	/**
	 * 获取诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagnosis");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断"); 
		return column;
	}
	/**
	 * 获取产房入室时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_in");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("产房入室时间"); 
		return column;
	}
	/**
	 * 获取宫缩开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_contractionsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_contractions");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("宫缩开始时间"); 
		return column;
	}
	/**
	 * 获取破水时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_amnioticfluid_ruptureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_amnioticfluid_rupture");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("破水时间"); 
		return column;
	}
	/**
	 * 获取破水方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rupturetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rupturetp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("破水方式"); 
		return column;
	}
	/**
	 * 获取破水方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rupturetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rupturetp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("破水方式编码"); 
		return column;
	}
	/**
	 * 获取羊水颜色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_amnioticfluid_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_amnioticfluid_color");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水颜色"); 
		return column;
	}
	/**
	 * 获取羊水颜色编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_amnioticfluid_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_amnioticfluid_color");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水颜色编码"); 
		return column;
	}
	/**
	 * 获取流产时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_abortionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_abortion");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("流产时间"); 
		return column;
	}
	/**
	 * 获取流产分娩方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_childbirth_abortiontpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_childbirth_abortiontp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("流产分娩方式"); 
		return column;
	}
	/**
	 * 获取流产分娩方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_childbirth_abortiontpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_childbirth_abortiontp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("流产分娩方式编码"); 
		return column;
	}
	/**
	 * 获取胎儿情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_child_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_child_situation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿情况"); 
		return column;
	}
	/**
	 * 获取胎儿情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_child_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_child_situation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿情况编码"); 
		return column;
	}
	/**
	 * 获取身长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLength_childCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Length_child");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身长"); 
		return column;
	}
	/**
	 * 获取体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeight_childCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight_child");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体重"); 
		return column;
	}
	/**
	 * 获取胎儿外观表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_child_appearancesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_child_appearances");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿外观"); 
		return column;
	}
	/**
	 * 获取胎儿外观编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_child_appearancesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_child_appearances");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿外观编码"); 
		return column;
	}
	/**
	 * 获取是否畸形 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_malformationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_malformation");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否畸形 "); 
		return column;
	}
	/**
	 * 获取娩出类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_deliverytpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_deliverytp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("娩出类型"); 
		return column;
	}
	/**
	 * 获取娩出类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_deliverytpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_deliverytp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("娩出类型编码"); 
		return column;
	}
	/**
	 * 获取娩出时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_deliveryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_delivery");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("娩出时间"); 
		return column;
	}
	/**
	 * 获取胎盘娩出方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_placenta_birthtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_placenta_birthtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘娩出方式"); 
		return column;
	}
	/**
	 * 获取胎盘娩出方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_placenta_birthtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_placenta_birthtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘娩出方式编码"); 
		return column;
	}
	/**
	 * 获取胎盘情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_placenta_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_placenta_situation");
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
	private IColumnDesc getSd_placenta_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_placenta_situation");
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
	private IColumnDesc getId_caul_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_caul_situation");
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
	private IColumnDesc getSd_caul_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_caul_situation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜情况编码"); 
		return column;
	}
	/**
	 * 获取产时出血量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_bleedingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_bleeding");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产时出血量"); 
		return column;
	}
	/**
	 * 获取宫缩剂表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_contractions_agentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_contractions_agent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宫缩剂"); 
		return column;
	}
	/**
	 * 获取宫缩剂编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_contractions_agentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_contractions_agent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宫缩剂编码"); 
		return column;
	}
	/**
	 * 获取给药途径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_route");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药途径"); 
		return column;
	}
	/**
	 * 获取产后0.5h出血量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_bleedingedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_bleedinged");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产后0.5h出血量"); 
		return column;
	}
	/**
	 * 获取高压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeightpressureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heightpressure");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("高压"); 
		return column;
	}
	/**
	 * 获取低压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLowpressureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lowpressure");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("低压"); 
		return column;
	}
	/**
	 * 获取脉搏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pulse");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脉搏"); 
		return column;
	}
	/**
	 * 获取是否膀胱充盈表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_full_bladderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_full_bladder");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否膀胱充盈"); 
		return column;
	}
	/**
	 * 获取产道检查表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_birth_canal_chkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_birth_canal_chk");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产道检查"); 
		return column;
	}
	/**
	 * 获取产道检查编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_birth_canal_chkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_birth_canal_chk");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产道检查编码"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取阴道出血量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_bleeding_vaginaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_bleeding_vagina");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("阴道出血量"); 
		return column;
	}
	/**
	 * 获取遵医嘱给予表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_order_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_order_drug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("遵医嘱给予"); 
		return column;
	}
	/**
	 * 获取遵医嘱给予编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_order_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_order_drug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("遵医嘱给予编码"); 
		return column;
	}
	/**
	 * 获取剂量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDosageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dosage");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("剂量"); 
		return column;
	}
	/**
	 * 获取并发症表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_complicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_complication");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("并发症"); 
		return column;
	}
	/**
	 * 获取并发症编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_complicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_complication");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("并发症编码"); 
		return column;
	}
	/**
	 * 获取接生医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_delyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_dely");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接生医生"); 
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
	 * 获取病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区"); 
		return column;
	}
	/**
	 * 获取破水方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rupturetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rupturetp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("破水方式名称"); 
		return column;
	}
	/**
	 * 获取羊水颜色名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_amnioticfluid_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_amnioticfluid_color");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("羊水颜色名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_childbirth_abortiontpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_childbirth_abortiontp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取胎儿情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_child_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_child_situation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿情况"); 
		return column;
	}
	/**
	 * 获取胎儿外观名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_child_appearancesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_child_appearances");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎儿外观名称"); 
		return column;
	}
	/**
	 * 获取娩出类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deliverytpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_deliverytp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("娩出类型"); 
		return column;
	}
	/**
	 * 获取胎盘娩出方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_placenta_birthtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_placenta_birthtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘娩出方式"); 
		return column;
	}
	/**
	 * 获取胎盘情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_placenta_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_placenta_situation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎盘情况名称"); 
		return column;
	}
	/**
	 * 获取胎膜情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_caul_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_caul_situation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("胎膜情况名称"); 
		return column;
	}
	/**
	 * 获取宫缩剂名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_contractions_agentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_contractions_agent");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宫缩剂名称"); 
		return column;
	}
	/**
	 * 获取用法名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_routeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_route");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法名称"); 
		return column;
	}
	/**
	 * 获取产道检查名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_birth_canal_chkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_birth_canal_chk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产道检查名称"); 
		return column;
	}
	/**
	 * 获取遵医嘱给予名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_order_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_order_drug");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("遵医嘱给予名称"); 
		return column;
	}
	/**
	 * 获取并发症名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_complicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_complication");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("并发症名称"); 
		return column;
	}
	/**
	 * 获取接生医生姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_delyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_dely");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接生医生姓名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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
