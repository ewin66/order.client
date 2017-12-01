
package iih.ci.mr.nu.chidrenass.d.desc;

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
 * 高危儿护理观察记录 DO 元数据信息
 */
public class ChildrenInAsseNurRecordDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.chidrenass.d.ChildrenInAsseNurRecordDO";
	public static final String CLASS_DISPALYNAME = "高危儿护理观察记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_NU_CHASS_REC";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_chass_rec";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ChildrenInAsseNurRecordDODesc(){
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
		this.setKeyDesc(getId_chass_recADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_chassADesc(tblDesc));
		this.add(getId_chass_recADesc(tblDesc));
		this.add(getId_chassADesc(tblDesc));
		this.add(getD_recADesc(tblDesc));
		this.add(getT_recADesc(tblDesc));
		this.add(getTemADesc(tblDesc));
		this.add(getPulseADesc(tblDesc));
		this.add(getBreathADesc(tblDesc));
		this.add(getSys_pressureADesc(tblDesc));
		this.add(getDia_pressureADesc(tblDesc));
		this.add(getSpo2ADesc(tblDesc));
		this.add(getId_oxy_typeADesc(tblDesc));
		this.add(getSd_oxy_typeADesc(tblDesc));
		this.add(getOxyADesc(tblDesc));
		this.add(getId_skincolorADesc(tblDesc));
		this.add(getSd_skincolorADesc(tblDesc));
		this.add(getId_autoactivityADesc(tblDesc));
		this.add(getSd_autoactivityADesc(tblDesc));
		this.add(getId_muscle_tensionADesc(tblDesc));
		this.add(getSd_muscle_tensionADesc(tblDesc));
		this.add(getId_cry_voiceADesc(tblDesc));
		this.add(getSd_cry_voiceADesc(tblDesc));
		this.add(getId_abd_disADesc(tblDesc));
		this.add(getSd_abd_disADesc(tblDesc));
		this.add(getId_umbilicalADesc(tblDesc));
		this.add(getSd_umbilicalADesc(tblDesc));
		this.add(getName_medicineADesc(tblDesc));
		this.add(getMeteringADesc(tblDesc));
		this.add(getId_routeADesc(tblDesc));
		this.add(getSd_routeADesc(tblDesc));
		this.add(getSpeed_drugADesc(tblDesc));
		this.add(getId_unit_speedADesc(tblDesc));
		this.add(getSd_unit_speedADesc(tblDesc));
		this.add(getId_dietADesc(tblDesc));
		this.add(getSd_dietADesc(tblDesc));
		this.add(getId_bringinto_wayADesc(tblDesc));
		this.add(getSd_bringinto_wayADesc(tblDesc));
		this.add(getDrinkADesc(tblDesc));
		this.add(getId_suckpowerADesc(tblDesc));
		this.add(getSd_suckpowerADesc(tblDesc));
		this.add(getId_swallow_activeADesc(tblDesc));
		this.add(getSd_swallow_activeADesc(tblDesc));
		this.add(getVomitADesc(tblDesc));
		this.add(getDrainageADesc(tblDesc));
		this.add(getShitADesc(tblDesc));
		this.add(getA_shitADesc(tblDesc));
		this.add(getUrineADesc(tblDesc));
		this.add(getA_urineADesc(tblDesc));
		this.add(getId_skinADesc(tblDesc));
		this.add(getSd_skinADesc(tblDesc));
		this.add(getBoxtemADesc(tblDesc));
		this.add(getHumADesc(tblDesc));
		this.add(getManagementADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_oxy_typeADesc(tblDesc));
		this.add(getName_skincolorADesc(tblDesc));
		this.add(getName_autoactivityADesc(tblDesc));
		this.add(getName_muscle_tensionADesc(tblDesc));
		this.add(getName_cry_voiceADesc(tblDesc));
		this.add(getName_abd_disADesc(tblDesc));
		this.add(getName_umbilicalADesc(tblDesc));
		this.add(getName_routeADesc(tblDesc));
		this.add(getName_unit_speedADesc(tblDesc));
		this.add(getName_dietADesc(tblDesc));
		this.add(getName_bringinto_wayADesc(tblDesc));
		this.add(getName_suckpowerADesc(tblDesc));
		this.add(getName_swallow_activeADesc(tblDesc));
		this.add(getName_skinADesc(tblDesc));
		this.add(getName_signADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_chass_recCDesc(tblDesc));
		tblDesc.add(getId_chass_recCDesc(tblDesc));
		tblDesc.add(getId_chassCDesc(tblDesc));
		tblDesc.add(getD_recCDesc(tblDesc));
		tblDesc.add(getT_recCDesc(tblDesc));
		tblDesc.add(getTemCDesc(tblDesc));
		tblDesc.add(getPulseCDesc(tblDesc));
		tblDesc.add(getBreathCDesc(tblDesc));
		tblDesc.add(getSys_pressureCDesc(tblDesc));
		tblDesc.add(getDia_pressureCDesc(tblDesc));
		tblDesc.add(getSpo2CDesc(tblDesc));
		tblDesc.add(getId_oxy_typeCDesc(tblDesc));
		tblDesc.add(getSd_oxy_typeCDesc(tblDesc));
		tblDesc.add(getOxyCDesc(tblDesc));
		tblDesc.add(getId_skincolorCDesc(tblDesc));
		tblDesc.add(getSd_skincolorCDesc(tblDesc));
		tblDesc.add(getId_autoactivityCDesc(tblDesc));
		tblDesc.add(getSd_autoactivityCDesc(tblDesc));
		tblDesc.add(getId_muscle_tensionCDesc(tblDesc));
		tblDesc.add(getSd_muscle_tensionCDesc(tblDesc));
		tblDesc.add(getId_cry_voiceCDesc(tblDesc));
		tblDesc.add(getSd_cry_voiceCDesc(tblDesc));
		tblDesc.add(getId_abd_disCDesc(tblDesc));
		tblDesc.add(getSd_abd_disCDesc(tblDesc));
		tblDesc.add(getId_umbilicalCDesc(tblDesc));
		tblDesc.add(getSd_umbilicalCDesc(tblDesc));
		tblDesc.add(getName_medicineCDesc(tblDesc));
		tblDesc.add(getMeteringCDesc(tblDesc));
		tblDesc.add(getId_routeCDesc(tblDesc));
		tblDesc.add(getSd_routeCDesc(tblDesc));
		tblDesc.add(getSpeed_drugCDesc(tblDesc));
		tblDesc.add(getId_unit_speedCDesc(tblDesc));
		tblDesc.add(getSd_unit_speedCDesc(tblDesc));
		tblDesc.add(getId_dietCDesc(tblDesc));
		tblDesc.add(getSd_dietCDesc(tblDesc));
		tblDesc.add(getId_bringinto_wayCDesc(tblDesc));
		tblDesc.add(getSd_bringinto_wayCDesc(tblDesc));
		tblDesc.add(getDrinkCDesc(tblDesc));
		tblDesc.add(getId_suckpowerCDesc(tblDesc));
		tblDesc.add(getSd_suckpowerCDesc(tblDesc));
		tblDesc.add(getId_swallow_activeCDesc(tblDesc));
		tblDesc.add(getSd_swallow_activeCDesc(tblDesc));
		tblDesc.add(getVomitCDesc(tblDesc));
		tblDesc.add(getDrainageCDesc(tblDesc));
		tblDesc.add(getShitCDesc(tblDesc));
		tblDesc.add(getA_shitCDesc(tblDesc));
		tblDesc.add(getUrineCDesc(tblDesc));
		tblDesc.add(getA_urineCDesc(tblDesc));
		tblDesc.add(getId_skinCDesc(tblDesc));
		tblDesc.add(getSd_skinCDesc(tblDesc));
		tblDesc.add(getBoxtemCDesc(tblDesc));
		tblDesc.add(getHumCDesc(tblDesc));
		tblDesc.add(getManagementCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
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
	 * 高危儿护理记录ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_chass_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_chass_rec",  getId_chass_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("高危儿护理记录ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入室评估ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_chassADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_chass",  getId_chassCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入室评估ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D_rec",  getD_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getT_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T_rec",  getT_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * T（℃）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tem",  getTemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("T（℃）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * P(次/分)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pulse",  getPulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("P(次/分)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * R(次/分)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBreathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Breath",  getBreathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("R(次/分)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSys_pressureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sys_pressure",  getSys_pressureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舒张压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDia_pressureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dia_pressure",  getDia_pressureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("舒张压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * SpO2(%)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpo2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spo2",  getSpo2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("SpO2(%)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸氧方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_oxy_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oxy_type",  getId_oxy_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸氧方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 吸氧方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oxy_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oxy_type",  getSd_oxy_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸氧方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸氧浓度(%)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOxyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oxy",  getOxyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("吸氧浓度(%)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肤色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skincolorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skincolor",  getId_skincolorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肤色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 肤色编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skincolorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skincolor",  getSd_skincolorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肤色编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自主活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_autoactivityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_autoactivity",  getId_autoactivityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自主活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 自主活动编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_autoactivityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_autoactivity",  getSd_autoactivityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自主活动编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肌张力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_muscle_tensionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_muscle_tension",  getId_muscle_tensionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肌张力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 肌张力情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_muscle_tensionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_muscle_tension",  getSd_muscle_tensionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肌张力情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 哭声属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cry_voiceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cry_voice",  getId_cry_voiceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("哭声");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 哭声状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cry_voiceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cry_voice",  getSd_cry_voiceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("哭声状况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 腹胀属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_abd_disADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_abd_dis",  getId_abd_disCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("腹胀");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 腹胀状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_abd_disADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_abd_dis",  getSd_abd_disCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("腹胀状况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐带属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_umbilicalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_umbilical",  getId_umbilicalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 脐带编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_umbilicalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_umbilical",  getSd_umbilicalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 给药名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_medicineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_medicine",  getName_medicineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("给药名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 给药剂量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMeteringADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Metering",  getMeteringCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("给药剂量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 给药用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_routeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_route",  getId_routeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("给药用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入量用法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_routeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_route",  getSd_routeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入量用法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 给药速度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpeed_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Speed_drug",  getSpeed_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("给药速度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 给药速度单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_speedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_speed",  getId_unit_speedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("给药速度单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 给药速度单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_unit_speedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_unit_speed",  getSd_unit_speedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("给药速度单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diet",  getId_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 新生儿饮食编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_diet",  getSd_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新生儿饮食编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入量途径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bringinto_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bringinto_way",  getId_bringinto_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入量途径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入量途径编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bringinto_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bringinto_way",  getSd_bringinto_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入量途径编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮量（ml）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrinkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drink",  getDrinkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("饮量（ml）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吮吸力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_suckpowerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_suckpower",  getId_suckpowerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吮吸力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 吮吸力状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_suckpowerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_suckpower",  getSd_suckpowerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吮吸力状况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吞咽动作属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_swallow_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_swallow_active",  getId_swallow_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吞咽动作");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 吞咽动作状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_swallow_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_swallow_active",  getSd_swallow_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吞咽动作状况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呕吐(ml)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVomitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vomit",  getVomitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呕吐(ml)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流(ml)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrainageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drainage",  getDrainageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("引流(ml)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便(g)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getShitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Shit",  getShitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("大便(g)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便（次）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getA_shitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("A_shit",  getA_shitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("大便（次）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小便（ml）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUrineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Urine",  getUrineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("小便（ml）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小便（次）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getA_urineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("A_urine",  getA_urineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("小便（次）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin",  getId_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin",  getSd_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤状况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 箱温（℃）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBoxtemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Boxtem",  getBoxtemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("箱温（℃）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 湿度（%）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hum",  getHumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("湿度（%）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情变化及处置属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getManagementADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Management",  getManagementCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情变化及处置");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign",  getId_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
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
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
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
	 * 吸氧方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oxy_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oxy_type",  getName_oxy_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸氧方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b11","id_oxy_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肤色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skincolorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skincolor",  getName_skincolorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肤色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b9","id_skincolor=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自主活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_autoactivityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_autoactivity",  getName_autoactivityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自主活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b12","id_autoactivity=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肌张力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_muscle_tensionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_muscle_tension",  getName_muscle_tensionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肌张力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b13","id_muscle_tension=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 哭声属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cry_voiceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cry_voice",  getName_cry_voiceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("哭声");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b14","id_cry_voice=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 腹胀属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_abd_disADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_abd_dis",  getName_abd_disCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("腹胀");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b15","id_abd_dis=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐带属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_umbilicalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_umbilical",  getName_umbilicalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b10","id_umbilical=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_routeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_route",  getName_routeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b16","id_route=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 给药速度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unit_speedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit_speed",  getName_unit_speedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("给药速度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b17","id_unit_speed=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新生儿饮食属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diet",  getName_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新生儿饮食");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b7","id_diet=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入量途径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bringinto_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bringinto_way",  getName_bringinto_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入量途径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b18","id_bringinto_way=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吮吸力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_suckpowerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_suckpower",  getName_suckpowerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吮吸力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b19","id_suckpower=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吞咽动作属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_swallow_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_swallow_active",  getName_swallow_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吞咽动作");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b20","id_swallow_active=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skin",  getName_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b21","id_skin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b8","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取高危儿护理记录ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_chass_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_chass_rec");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("高危儿护理记录ID"); 
		return column;
	}
	/**
	 * 获取入室评估ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_chassCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_chass");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入室评估ID"); 
		return column;
	}
	/**
	 * 获取日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D_rec");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期"); 
		return column;
	}
	/**
	 * 获取时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getT_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T_rec");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("时间"); 
		return column;
	}
	/**
	 * 获取T（℃）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tem");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("T（℃）"); 
		return column;
	}
	/**
	 * 获取P(次/分)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pulse");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("P(次/分)"); 
		return column;
	}
	/**
	 * 获取R(次/分)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBreathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Breath");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("R(次/分)"); 
		return column;
	}
	/**
	 * 获取收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSys_pressureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sys_pressure");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压"); 
		return column;
	}
	/**
	 * 获取舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDia_pressureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dia_pressure");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压"); 
		return column;
	}
	/**
	 * 获取SpO2(%)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpo2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spo2");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("SpO2(%)"); 
		return column;
	}
	/**
	 * 获取吸氧方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_oxy_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oxy_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸氧方式"); 
		return column;
	}
	/**
	 * 获取吸氧方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oxy_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oxy_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸氧方式编码"); 
		return column;
	}
	/**
	 * 获取吸氧浓度(%)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOxyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oxy");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("吸氧浓度(%)"); 
		return column;
	}
	/**
	 * 获取肤色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skincolorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skincolor");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肤色"); 
		return column;
	}
	/**
	 * 获取肤色编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skincolorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skincolor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肤色编码"); 
		return column;
	}
	/**
	 * 获取自主活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_autoactivityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_autoactivity");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自主活动"); 
		return column;
	}
	/**
	 * 获取自主活动编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_autoactivityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_autoactivity");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自主活动编码"); 
		return column;
	}
	/**
	 * 获取肌张力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_muscle_tensionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_muscle_tension");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肌张力"); 
		return column;
	}
	/**
	 * 获取肌张力情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_muscle_tensionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_muscle_tension");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肌张力情况编码"); 
		return column;
	}
	/**
	 * 获取哭声表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cry_voiceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cry_voice");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("哭声"); 
		return column;
	}
	/**
	 * 获取哭声状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cry_voiceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cry_voice");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("哭声状况编码"); 
		return column;
	}
	/**
	 * 获取腹胀表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_abd_disCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_abd_dis");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("腹胀"); 
		return column;
	}
	/**
	 * 获取腹胀状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_abd_disCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_abd_dis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("腹胀状况编码"); 
		return column;
	}
	/**
	 * 获取脐带表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_umbilicalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_umbilical");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带"); 
		return column;
	}
	/**
	 * 获取脐带编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_umbilicalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_umbilical");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带编码"); 
		return column;
	}
	/**
	 * 获取给药名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_medicineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_medicine");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药名称"); 
		return column;
	}
	/**
	 * 获取给药剂量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMeteringCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Metering");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("给药剂量"); 
		return column;
	}
	/**
	 * 获取给药用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_routeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_route");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药用法"); 
		return column;
	}
	/**
	 * 获取入量用法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_routeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_route");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入量用法编码"); 
		return column;
	}
	/**
	 * 获取给药速度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpeed_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Speed_drug");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("给药速度"); 
		return column;
	}
	/**
	 * 获取给药速度单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_speedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_speed");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药速度单位"); 
		return column;
	}
	/**
	 * 获取给药速度单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_unit_speedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_unit_speed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药速度单位编码"); 
		return column;
	}
	/**
	 * 获取饮食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diet");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食"); 
		return column;
	}
	/**
	 * 获取新生儿饮食编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_diet");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新生儿饮食编码"); 
		return column;
	}
	/**
	 * 获取入量途径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bringinto_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bringinto_way");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入量途径"); 
		return column;
	}
	/**
	 * 获取入量途径编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bringinto_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bringinto_way");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入量途径编码"); 
		return column;
	}
	/**
	 * 获取饮量（ml）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrinkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drink");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("饮量（ml）"); 
		return column;
	}
	/**
	 * 获取吮吸力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_suckpowerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_suckpower");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吮吸力"); 
		return column;
	}
	/**
	 * 获取吮吸力状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_suckpowerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_suckpower");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吮吸力状况编码"); 
		return column;
	}
	/**
	 * 获取吞咽动作表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_swallow_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_swallow_active");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吞咽动作"); 
		return column;
	}
	/**
	 * 获取吞咽动作状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_swallow_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_swallow_active");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吞咽动作状况编码"); 
		return column;
	}
	/**
	 * 获取呕吐(ml)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVomitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vomit");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呕吐(ml)"); 
		return column;
	}
	/**
	 * 获取引流(ml)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrainageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drainage");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("引流(ml)"); 
		return column;
	}
	/**
	 * 获取大便(g)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getShitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Shit");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("大便(g)"); 
		return column;
	}
	/**
	 * 获取大便（次）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getA_shitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"A_shit");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("大便（次）"); 
		return column;
	}
	/**
	 * 获取小便（ml）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUrineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Urine");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("小便（ml）"); 
		return column;
	}
	/**
	 * 获取小便（次）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getA_urineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"A_urine");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("小便（次）"); 
		return column;
	}
	/**
	 * 获取皮肤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤"); 
		return column;
	}
	/**
	 * 获取皮肤状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤状况编码"); 
		return column;
	}
	/**
	 * 获取箱温（℃）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBoxtemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Boxtem");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("箱温（℃）"); 
		return column;
	}
	/**
	 * 获取湿度（%）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hum");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("湿度（%）"); 
		return column;
	}
	/**
	 * 获取病情变化及处置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getManagementCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Management");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情变化及处置"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
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
	 * 获取吸氧方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oxy_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oxy_type");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸氧方式"); 
		return column;
	}
	/**
	 * 获取肤色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skincolorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skincolor");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肤色"); 
		return column;
	}
	/**
	 * 获取自主活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_autoactivityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_autoactivity");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自主活动"); 
		return column;
	}
	/**
	 * 获取肌张力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_muscle_tensionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_muscle_tension");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肌张力"); 
		return column;
	}
	/**
	 * 获取哭声表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cry_voiceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cry_voice");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("哭声"); 
		return column;
	}
	/**
	 * 获取腹胀表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_abd_disCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_abd_dis");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("腹胀"); 
		return column;
	}
	/**
	 * 获取脐带表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_umbilicalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_umbilical");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带"); 
		return column;
	}
	/**
	 * 获取用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_routeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_route");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用法"); 
		return column;
	}
	/**
	 * 获取给药速度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unit_speedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit_speed");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药速度"); 
		return column;
	}
	/**
	 * 获取新生儿饮食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diet");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新生儿饮食"); 
		return column;
	}
	/**
	 * 获取入量途径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bringinto_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bringinto_way");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入量途径"); 
		return column;
	}
	/**
	 * 获取吮吸力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_suckpowerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_suckpower");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吮吸力"); 
		return column;
	}
	/**
	 * 获取吞咽动作表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_swallow_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_swallow_active");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吞咽动作"); 
		return column;
	}
	/**
	 * 获取皮肤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skin");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
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
