
package iih.ci.mr.nu.obstetrics.birthregis.d.desc;

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
 * 分娩登记薄 DO 元数据信息
 */
public class BirthRegistrationDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.obstetrics.birthregis.d.BirthRegistrationDO";
	public static final String CLASS_DISPALYNAME = "分娩登记薄";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_NU_BIRTH_REG";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_birth_reg";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BirthRegistrationDODesc(){
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
		this.setKeyDesc(getId_birth_regADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_birth_regADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getDt_dateADesc(tblDesc));
		this.add(getDt_timeADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getNum_pregADesc(tblDesc));
		this.add(getNum_birthADesc(tblDesc));
		this.add(getWeek_pregADesc(tblDesc));
		this.add(getId_deliveryADesc(tblDesc));
		this.add(getSd_deliveryADesc(tblDesc));
		this.add(getId_positionADesc(tblDesc));
		this.add(getSd_positionADesc(tblDesc));
		this.add(getName_operADesc(tblDesc));
		this.add(getComplicationADesc(tblDesc));
		this.add(getNum_bleed_intrapADesc(tblDesc));
		this.add(getNum_bleed_postpADesc(tblDesc));
		this.add(getRes_bleedADesc(tblDesc));
		this.add(getId_perineum_statusADesc(tblDesc));
		this.add(getSd_perineum_statusADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getWeightADesc(tblDesc));
		this.add(getHeightADesc(tblDesc));
		this.add(getSituation_specialADesc(tblDesc));
		this.add(getScore_minute_oneADesc(tblDesc));
		this.add(getScore_minute_fiveADesc(tblDesc));
		this.add(getScore_minute_tenADesc(tblDesc));
		this.add(getEu_anmeldenADesc(tblDesc));
		this.add(getEu_consulthivADesc(tblDesc));
		this.add(getEu_filtratehivADesc(tblDesc));
		this.add(getId_assaytesthivADesc(tblDesc));
		this.add(getSd_assaytesthivADesc(tblDesc));
		this.add(getEu_syphilisADesc(tblDesc));
		this.add(getEu_hbsagADesc(tblDesc));
		this.add(getOther_sexillnessADesc(tblDesc));
		this.add(getNum_fetusADesc(tblDesc));
		this.add(getNum_dead_fetusADesc(tblDesc));
		this.add(getNum_dead_birthADesc(tblDesc));
		this.add(getNum_dead_newbornADesc(tblDesc));
		this.add(getDefects_birthADesc(tblDesc));
		this.add(getSue_sendADesc(tblDesc));
		this.add(getId_emp_midwivesADesc(tblDesc));
		this.add(getId_emp_regADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_deliveryADesc(tblDesc));
		this.add(getName_positionADesc(tblDesc));
		this.add(getName_perineum_statusADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getName_assaytesthivADesc(tblDesc));
		this.add(getName_emp_midwivesADesc(tblDesc));
		this.add(getName_emp_regADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_birth_regCDesc(tblDesc));
		tblDesc.add(getId_birth_regCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getDt_dateCDesc(tblDesc));
		tblDesc.add(getDt_timeCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getNum_pregCDesc(tblDesc));
		tblDesc.add(getNum_birthCDesc(tblDesc));
		tblDesc.add(getWeek_pregCDesc(tblDesc));
		tblDesc.add(getId_deliveryCDesc(tblDesc));
		tblDesc.add(getSd_deliveryCDesc(tblDesc));
		tblDesc.add(getId_positionCDesc(tblDesc));
		tblDesc.add(getSd_positionCDesc(tblDesc));
		tblDesc.add(getName_operCDesc(tblDesc));
		tblDesc.add(getComplicationCDesc(tblDesc));
		tblDesc.add(getNum_bleed_intrapCDesc(tblDesc));
		tblDesc.add(getNum_bleed_postpCDesc(tblDesc));
		tblDesc.add(getRes_bleedCDesc(tblDesc));
		tblDesc.add(getId_perineum_statusCDesc(tblDesc));
		tblDesc.add(getSd_perineum_statusCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getSd_sexCDesc(tblDesc));
		tblDesc.add(getWeightCDesc(tblDesc));
		tblDesc.add(getHeightCDesc(tblDesc));
		tblDesc.add(getSituation_specialCDesc(tblDesc));
		tblDesc.add(getScore_minute_oneCDesc(tblDesc));
		tblDesc.add(getScore_minute_fiveCDesc(tblDesc));
		tblDesc.add(getScore_minute_tenCDesc(tblDesc));
		tblDesc.add(getEu_anmeldenCDesc(tblDesc));
		tblDesc.add(getEu_consulthivCDesc(tblDesc));
		tblDesc.add(getEu_filtratehivCDesc(tblDesc));
		tblDesc.add(getId_assaytesthivCDesc(tblDesc));
		tblDesc.add(getSd_assaytesthivCDesc(tblDesc));
		tblDesc.add(getEu_syphilisCDesc(tblDesc));
		tblDesc.add(getEu_hbsagCDesc(tblDesc));
		tblDesc.add(getOther_sexillnessCDesc(tblDesc));
		tblDesc.add(getNum_fetusCDesc(tblDesc));
		tblDesc.add(getNum_dead_fetusCDesc(tblDesc));
		tblDesc.add(getNum_dead_birthCDesc(tblDesc));
		tblDesc.add(getNum_dead_newbornCDesc(tblDesc));
		tblDesc.add(getDefects_birthCDesc(tblDesc));
		tblDesc.add(getSue_sendCDesc(tblDesc));
		tblDesc.add(getId_emp_midwivesCDesc(tblDesc));
		tblDesc.add(getId_emp_regCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 分娩登记薄实体主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_birth_regADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_birth_reg",  getId_birth_regCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩登记薄实体主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_date",  getDt_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("分娩日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_time",  getDt_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("分娩时间");
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 孕次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_pregADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_preg",  getNum_pregCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("孕次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_birthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_birth",  getNum_birthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 孕周属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeek_pregADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Week_preg",  getWeek_pregCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("孕周");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_deliveryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_delivery",  getId_deliveryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 分娩方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_deliveryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_delivery",  getSd_deliveryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩方位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_position",  getId_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩方位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 分娩方位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_position",  getSd_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩方位编码");
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
	 * 合并症属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComplicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Complication",  getComplicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("合并症");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产时出血ml属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_bleed_intrapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_bleed_intrap",  getNum_bleed_intrapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产时出血ml");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产后出血ml属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_bleed_postpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_bleed_postp",  getNum_bleed_postpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产后出血ml");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出血原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRes_bleedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Res_bleed",  getRes_bleedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出血原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perineum_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perineum_status",  getId_perineum_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会阴情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_perineum_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_perineum_status",  getSd_perineum_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴情况编码");
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
	private IAttrDesc getId_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex",  getId_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别");
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
	 * 体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight",  getWeightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体重");
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
	private IAttrDesc getHeightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Height",  getHeightCDesc(tblDesc), this);
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
	 * 特殊情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSituation_specialADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Situation_special",  getSituation_specialCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 1分钟评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_minute_oneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_minute_one",  getScore_minute_oneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("1分钟评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 5分钟评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_minute_fiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_minute_five",  getScore_minute_fiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("5分钟评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 10分钟评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_minute_tenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_minute_ten",  getScore_minute_tenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("10分钟评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 户口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_anmeldenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_anmelden",  getEu_anmeldenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("户口");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HIV咨询属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_consulthivADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_consulthiv",  getEu_consulthivCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("HIV咨询");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HIV筛查属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_filtratehivADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_filtratehiv",  getEu_filtratehivCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("HIV筛查");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HIV化验属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_assaytesthivADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_assaytesthiv",  getId_assaytesthivCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HIV化验");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * HIV化验编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_assaytesthivADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_assaytesthiv",  getSd_assaytesthivCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HIV化验编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 梅毒属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_syphilisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_syphilis",  getEu_syphilisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("梅毒");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HBsAg属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_hbsagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_hbsag",  getEu_hbsagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("HBsAg");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他性病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_sexillnessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_sexillness",  getOther_sexillnessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他性病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_fetusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_fetus",  getNum_fetusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死胎属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_dead_fetusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_dead_fetus",  getNum_dead_fetusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("死胎");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死产属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_dead_birthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_dead_birth",  getNum_dead_birthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("死产");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新生儿死亡属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_dead_newbornADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_dead_newborn",  getNum_dead_newbornCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("新生儿死亡");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出生缺陷属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDefects_birthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Defects_birth",  getDefects_birthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出生缺陷");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 送休属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSue_sendADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sue_send",  getSue_sendCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("送休");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接生者签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_midwivesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_midwives",  getId_emp_midwivesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接生者签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 登记者签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_regADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_reg",  getId_emp_regCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("登记者签名");
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
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b13","id_ent=id_ent","name_pat"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deliveryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_delivery",  getName_deliveryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_delivery=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分娩方位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_position",  getName_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分娩方位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_position=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会阴状况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_perineum_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_perineum_status",  getName_perineum_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会阴状况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_perineum_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HIV化验结果名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_assaytesthivADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_assaytesthiv",  getName_assaytesthivCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HIV化验结果名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_assaytesthiv=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接生者名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_midwivesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_midwives",  getName_emp_midwivesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接生者名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_emp_midwives=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 登记者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_regADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_reg",  getName_emp_regCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("登记者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b7","id_emp_reg=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取分娩登记薄实体主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_birth_regCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_birth_reg");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("分娩登记薄实体主键"); 
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
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
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
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取分娩日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("分娩日期"); 
		return column;
	}
	/**
	 * 获取分娩时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_time");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("分娩时间"); 
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
	 * 获取住院号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院号"); 
		return column;
	}
	/**
	 * 获取孕次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_pregCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_preg");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("孕次"); 
		return column;
	}
	/**
	 * 获取产次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_birthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_birth");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产次"); 
		return column;
	}
	/**
	 * 获取孕周表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeek_pregCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Week_preg");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("孕周"); 
		return column;
	}
	/**
	 * 获取分娩方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_deliveryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_delivery");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩方式"); 
		return column;
	}
	/**
	 * 获取分娩方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_deliveryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_delivery");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩方式编码"); 
		return column;
	}
	/**
	 * 获取分娩方位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_position");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩方位"); 
		return column;
	}
	/**
	 * 获取分娩方位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_position");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩方位编码"); 
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
	 * 获取合并症表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComplicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Complication");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("合并症"); 
		return column;
	}
	/**
	 * 获取产时出血ml表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_bleed_intrapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_bleed_intrap");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产时出血ml"); 
		return column;
	}
	/**
	 * 获取产后出血ml表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_bleed_postpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_bleed_postp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产后出血ml"); 
		return column;
	}
	/**
	 * 获取出血原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRes_bleedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Res_bleed");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出血原因"); 
		return column;
	}
	/**
	 * 获取会阴情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perineum_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perineum_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴情况"); 
		return column;
	}
	/**
	 * 获取会阴情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_perineum_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_perineum_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴情况编码"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
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
	 * 获取体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体重"); 
		return column;
	}
	/**
	 * 获取身长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Height");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身长"); 
		return column;
	}
	/**
	 * 获取特殊情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSituation_specialCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Situation_special");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊情况"); 
		return column;
	}
	/**
	 * 获取1分钟评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_minute_oneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_minute_one");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("1分钟评分"); 
		return column;
	}
	/**
	 * 获取5分钟评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_minute_fiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_minute_five");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("5分钟评分"); 
		return column;
	}
	/**
	 * 获取10分钟评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_minute_tenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_minute_ten");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("10分钟评分"); 
		return column;
	}
	/**
	 * 获取户口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_anmeldenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_anmelden");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("户口"); 
		return column;
	}
	/**
	 * 获取HIV咨询表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_consulthivCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_consulthiv");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("HIV咨询"); 
		return column;
	}
	/**
	 * 获取HIV筛查表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_filtratehivCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_filtratehiv");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("HIV筛查"); 
		return column;
	}
	/**
	 * 获取HIV化验表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_assaytesthivCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_assaytesthiv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HIV化验"); 
		return column;
	}
	/**
	 * 获取HIV化验编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_assaytesthivCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_assaytesthiv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HIV化验编码"); 
		return column;
	}
	/**
	 * 获取梅毒表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_syphilisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_syphilis");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("梅毒"); 
		return column;
	}
	/**
	 * 获取HBsAg表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_hbsagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_hbsag");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("HBsAg"); 
		return column;
	}
	/**
	 * 获取其他性病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_sexillnessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_sexillness");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他性病"); 
		return column;
	}
	/**
	 * 获取胎数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_fetusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_fetus");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎数"); 
		return column;
	}
	/**
	 * 获取死胎表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_dead_fetusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_dead_fetus");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("死胎"); 
		return column;
	}
	/**
	 * 获取死产表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_dead_birthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_dead_birth");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("死产"); 
		return column;
	}
	/**
	 * 获取新生儿死亡表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_dead_newbornCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_dead_newborn");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("新生儿死亡"); 
		return column;
	}
	/**
	 * 获取出生缺陷表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDefects_birthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Defects_birth");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出生缺陷"); 
		return column;
	}
	/**
	 * 获取送休表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSue_sendCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sue_send");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("送休"); 
		return column;
	}
	/**
	 * 获取接生者签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_midwivesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_midwives");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接生者签名"); 
		return column;
	}
	/**
	 * 获取登记者签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_regCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_reg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("登记者签名"); 
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
	 * 获取分娩方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deliveryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_delivery");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩方式"); 
		return column;
	}
	/**
	 * 获取分娩方位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_position");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分娩方位名称"); 
		return column;
	}
	/**
	 * 获取会阴状况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_perineum_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_perineum_status");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会阴状况名称"); 
		return column;
	}
	/**
	 * 获取性别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别名称"); 
		return column;
	}
	/**
	 * 获取HIV化验结果名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_assaytesthivCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_assaytesthiv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HIV化验结果名称"); 
		return column;
	}
	/**
	 * 获取接生者名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_midwivesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_midwives");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接生者名称"); 
		return column;
	}
	/**
	 * 获取登记者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_regCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_reg");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("登记者姓名"); 
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
