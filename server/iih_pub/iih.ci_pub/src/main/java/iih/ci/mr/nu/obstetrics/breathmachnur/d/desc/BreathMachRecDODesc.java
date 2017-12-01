
package iih.ci.mr.nu.obstetrics.breathmachnur.d.desc;

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
 * 呼吸治疗观察护理记录单 DO 元数据信息
 */
public class BreathMachRecDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.obstetrics.breathmachnur.d.BreathMachRecDO";
	public static final String CLASS_DISPALYNAME = "呼吸治疗观察护理记录单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_NU_BTHMACH_REC";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_bthmachrec";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BreathMachRecDODesc(){
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
		this.setKeyDesc(getId_bthmachrecADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_bthmachADesc(tblDesc));
		this.add(getId_bthmachrecADesc(tblDesc));
		this.add(getId_bthmachADesc(tblDesc));
		this.add(getDt_recADesc(tblDesc));
		this.add(getId_mechanical_ventilationADesc(tblDesc));
		this.add(getSd_mechanical_ventilationADesc(tblDesc));
		this.add(getFrADesc(tblDesc));
		this.add(getPipADesc(tblDesc));
		this.add(getPADesc(tblDesc));
		this.add(getPeepADesc(tblDesc));
		this.add(getMapADesc(tblDesc));
		this.add(getRr_machineADesc(tblDesc));
		this.add(getFADesc(tblDesc));
		this.add(getItADesc(tblDesc));
		this.add(getIeADesc(tblDesc));
		this.add(getFio2ADesc(tblDesc));
		this.add(getTemADesc(tblDesc));
		this.add(getHeart_rateADesc(tblDesc));
		this.add(getRespiratory_frequencyADesc(tblDesc));
		this.add(getDbpADesc(tblDesc));
		this.add(getSbpADesc(tblDesc));
		this.add(getSpo2ADesc(tblDesc));
		this.add(getName_drugADesc(tblDesc));
		this.add(getDose_drugsADesc(tblDesc));
		this.add(getId_route_drugADesc(tblDesc));
		this.add(getSd_route_drugADesc(tblDesc));
		this.add(getSpped_drugADesc(tblDesc));
		this.add(getId_unit_speedADesc(tblDesc));
		this.add(getSd_unit_speedADesc(tblDesc));
		this.add(getId_dietADesc(tblDesc));
		this.add(getSd_dietADesc(tblDesc));
		this.add(getId_dosein_wayADesc(tblDesc));
		this.add(getSd_dosein_wayADesc(tblDesc));
		this.add(getDose_drinkADesc(tblDesc));
		this.add(getShitADesc(tblDesc));
		this.add(getA_skitADesc(tblDesc));
		this.add(getUrineADesc(tblDesc));
		this.add(getA_urineADesc(tblDesc));
		this.add(getId_suction_wayADesc(tblDesc));
		this.add(getSd_suction_wayADesc(tblDesc));
		this.add(getNatureADesc(tblDesc));
		this.add(getId_skin_colorADesc(tblDesc));
		this.add(getSd_skin_colorADesc(tblDesc));
		this.add(getId_skinADesc(tblDesc));
		this.add(getSd_skinADesc(tblDesc));
		this.add(getId_pipeADesc(tblDesc));
		this.add(getSd_pipeADesc(tblDesc));
		this.add(getBqbhjclADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_mechanical_ventilationADesc(tblDesc));
		this.add(getName_route_drugADesc(tblDesc));
		this.add(getName_unit_speedADesc(tblDesc));
		this.add(getName_dietADesc(tblDesc));
		this.add(getName_dosein_wayADesc(tblDesc));
		this.add(getName_suction_wayADesc(tblDesc));
		this.add(getName_skin_colorADesc(tblDesc));
		this.add(getName_skinADesc(tblDesc));
		this.add(getName_pipeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_bthmachrecCDesc(tblDesc));
		tblDesc.add(getId_bthmachrecCDesc(tblDesc));
		tblDesc.add(getId_bthmachCDesc(tblDesc));
		tblDesc.add(getDt_recCDesc(tblDesc));
		tblDesc.add(getId_mechanical_ventilationCDesc(tblDesc));
		tblDesc.add(getSd_mechanical_ventilationCDesc(tblDesc));
		tblDesc.add(getFrCDesc(tblDesc));
		tblDesc.add(getPipCDesc(tblDesc));
		tblDesc.add(getPCDesc(tblDesc));
		tblDesc.add(getPeepCDesc(tblDesc));
		tblDesc.add(getMapCDesc(tblDesc));
		tblDesc.add(getRr_machineCDesc(tblDesc));
		tblDesc.add(getFCDesc(tblDesc));
		tblDesc.add(getItCDesc(tblDesc));
		tblDesc.add(getIeCDesc(tblDesc));
		tblDesc.add(getFio2CDesc(tblDesc));
		tblDesc.add(getTemCDesc(tblDesc));
		tblDesc.add(getHeart_rateCDesc(tblDesc));
		tblDesc.add(getRespiratory_frequencyCDesc(tblDesc));
		tblDesc.add(getDbpCDesc(tblDesc));
		tblDesc.add(getSbpCDesc(tblDesc));
		tblDesc.add(getSpo2CDesc(tblDesc));
		tblDesc.add(getName_drugCDesc(tblDesc));
		tblDesc.add(getDose_drugsCDesc(tblDesc));
		tblDesc.add(getId_route_drugCDesc(tblDesc));
		tblDesc.add(getSd_route_drugCDesc(tblDesc));
		tblDesc.add(getSpped_drugCDesc(tblDesc));
		tblDesc.add(getId_unit_speedCDesc(tblDesc));
		tblDesc.add(getSd_unit_speedCDesc(tblDesc));
		tblDesc.add(getId_dietCDesc(tblDesc));
		tblDesc.add(getSd_dietCDesc(tblDesc));
		tblDesc.add(getId_dosein_wayCDesc(tblDesc));
		tblDesc.add(getSd_dosein_wayCDesc(tblDesc));
		tblDesc.add(getDose_drinkCDesc(tblDesc));
		tblDesc.add(getShitCDesc(tblDesc));
		tblDesc.add(getA_skitCDesc(tblDesc));
		tblDesc.add(getUrineCDesc(tblDesc));
		tblDesc.add(getA_urineCDesc(tblDesc));
		tblDesc.add(getId_suction_wayCDesc(tblDesc));
		tblDesc.add(getSd_suction_wayCDesc(tblDesc));
		tblDesc.add(getNatureCDesc(tblDesc));
		tblDesc.add(getId_skin_colorCDesc(tblDesc));
		tblDesc.add(getSd_skin_colorCDesc(tblDesc));
		tblDesc.add(getId_skinCDesc(tblDesc));
		tblDesc.add(getSd_skinCDesc(tblDesc));
		tblDesc.add(getId_pipeCDesc(tblDesc));
		tblDesc.add(getSd_pipeCDesc(tblDesc));
		tblDesc.add(getBqbhjclCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 唯一标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bthmachrecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bthmachrec",  getId_bthmachrecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("唯一标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bthmachADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bthmach",  getId_bthmachCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rec",  getDt_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 机械方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mechanical_ventilationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mechanical_ventilation",  getId_mechanical_ventilationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机械方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 机械通气方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mechanical_ventilationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mechanical_ventilation",  getSd_mechanical_ventilationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机械通气方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * FR属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fr",  getFrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("FR");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * PIP属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pip",  getPipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("PIP");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * P属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("P",  getPCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("P");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * PEEP属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPeepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Peep",  getPeepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("PEEP");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * MAP属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Map",  getMapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("MAP");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 机械通气RR属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRr_machineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rr_machine",  getRr_machineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("机械通气RR");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * f属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("F",  getFCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("f");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * IT属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getItADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("It",  getItCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("IT");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * I/E属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ie",  getIeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("I/E");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * FiO2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFio2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fio2",  getFio2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("FiO2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * T℃属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tem",  getTemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("T℃");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HR（心率）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeart_rateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heart_rate",  getHeart_rateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("HR（心率）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体征RR（呼吸）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRespiratory_frequencyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Respiratory_frequency",  getRespiratory_frequencyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体征RR（呼吸）");
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
	private IAttrDesc getDbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dbp",  getDbpCDesc(tblDesc), this);
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
	 * 收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sbp",  getSbpCDesc(tblDesc), this);
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
	 * SpO2（血氧饱和度）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpo2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spo2",  getSpo2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("SpO2（血氧饱和度）");
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
	private IAttrDesc getName_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drug",  getName_drugCDesc(tblDesc), this);
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
	private IAttrDesc getDose_drugsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dose_drugs",  getDose_drugsCDesc(tblDesc), this);
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
	private IAttrDesc getId_route_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_route_drug",  getId_route_drugCDesc(tblDesc), this);
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
	private IAttrDesc getSd_route_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_route_drug",  getSd_route_drugCDesc(tblDesc), this);
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
	private IAttrDesc getSpped_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spped_drug",  getSpped_drugCDesc(tblDesc), this);
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
	 * 饮食编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_diet",  getSd_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食编码");
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
	private IAttrDesc getId_dosein_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dosein_way",  getId_dosein_wayCDesc(tblDesc), this);
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
	private IAttrDesc getSd_dosein_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dosein_way",  getSd_dosein_wayCDesc(tblDesc), this);
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
	 * 饮量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDose_drinkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dose_drink",  getDose_drinkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("饮量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便总量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getShitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Shit",  getShitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("大便总量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getA_skitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("A_skit",  getA_skitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("大便次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小便总量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUrineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Urine",  getUrineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("小便总量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小便次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getA_urineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("A_urine",  getA_urineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("小便次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸痰途径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_suction_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_suction_way",  getId_suction_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸痰途径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 吸痰途径编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_suction_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_suction_way",  getSd_suction_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸痰途径编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nature",  getNatureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性质");
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
	private IAttrDesc getId_skin_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin_color",  getId_skin_colorCDesc(tblDesc), this);
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
	private IAttrDesc getSd_skin_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin_color",  getSd_skin_colorCDesc(tblDesc), this);
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
	 * 皮肤编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin",  getSd_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管路属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipe",  getId_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管路");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 管路编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipe",  getSd_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管路编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情变化及处理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBqbhjclADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bqbhjcl",  getBqbhjclCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情变化及处理");
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
	 * 机械通气方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mechanical_ventilationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mechanical_ventilation",  getName_mechanical_ventilationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机械通气方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b8","id_mechanical_ventilation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入量用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_route_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_route_drug",  getName_route_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入量用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b14","id_route_drug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 给药速度单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unit_speedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit_speed",  getName_unit_speedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("给药速度单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b9","id_unit_speed=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diet",  getName_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b3","id_diet=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入量途径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dosein_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dosein_way",  getName_dosein_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入量途径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b12","id_dosein_way=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸痰途径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_suction_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_suction_way",  getName_suction_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸痰途径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b13","id_suction_way=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肤色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skin_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skin_color",  getName_skin_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肤色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_skin_color=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b10","id_skin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管路属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipe",  getName_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管路");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b11","id_pipe=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b5","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取唯一标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bthmachrecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bthmachrec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("唯一标识"); 
		return column;
	}
	/**
	 * 获取患者信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bthmachCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bthmach");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者信息"); 
		return column;
	}
	/**
	 * 获取时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rec");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("时间"); 
		return column;
	}
	/**
	 * 获取机械方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mechanical_ventilationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mechanical_ventilation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机械方式"); 
		return column;
	}
	/**
	 * 获取机械通气方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mechanical_ventilationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mechanical_ventilation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机械通气方式编码"); 
		return column;
	}
	/**
	 * 获取FR表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fr");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("FR"); 
		return column;
	}
	/**
	 * 获取PIP表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pip");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("PIP"); 
		return column;
	}
	/**
	 * 获取P表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"P");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("P"); 
		return column;
	}
	/**
	 * 获取PEEP表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPeepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Peep");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("PEEP"); 
		return column;
	}
	/**
	 * 获取MAP表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Map");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("MAP"); 
		return column;
	}
	/**
	 * 获取机械通气RR表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRr_machineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rr_machine");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("机械通气RR"); 
		return column;
	}
	/**
	 * 获取f表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"F");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("f"); 
		return column;
	}
	/**
	 * 获取IT表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getItCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"It");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("IT"); 
		return column;
	}
	/**
	 * 获取I/E表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ie");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("I/E"); 
		return column;
	}
	/**
	 * 获取FiO2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFio2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fio2");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("FiO2"); 
		return column;
	}
	/**
	 * 获取T℃表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tem");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("T℃"); 
		return column;
	}
	/**
	 * 获取HR（心率）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeart_rateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heart_rate");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("HR（心率）"); 
		return column;
	}
	/**
	 * 获取体征RR（呼吸）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRespiratory_frequencyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Respiratory_frequency");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体征RR（呼吸）"); 
		return column;
	}
	/**
	 * 获取舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压"); 
		return column;
	}
	/**
	 * 获取收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压"); 
		return column;
	}
	/**
	 * 获取SpO2（血氧饱和度）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpo2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spo2");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("SpO2（血氧饱和度）"); 
		return column;
	}
	/**
	 * 获取给药名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drug");
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
	private IColumnDesc getDose_drugsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dose_drugs");
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
	private IColumnDesc getId_route_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_route_drug");
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
	private IColumnDesc getSd_route_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_route_drug");
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
	private IColumnDesc getSpped_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spped_drug");
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
	 * 获取饮食编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_diet");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食编码"); 
		return column;
	}
	/**
	 * 获取入量途径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dosein_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dosein_way");
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
	private IColumnDesc getSd_dosein_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dosein_way");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入量途径编码"); 
		return column;
	}
	/**
	 * 获取饮量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDose_drinkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dose_drink");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("饮量"); 
		return column;
	}
	/**
	 * 获取大便总量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getShitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Shit");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("大便总量"); 
		return column;
	}
	/**
	 * 获取大便次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getA_skitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"A_skit");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("大便次数"); 
		return column;
	}
	/**
	 * 获取小便总量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUrineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Urine");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("小便总量"); 
		return column;
	}
	/**
	 * 获取小便次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getA_urineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"A_urine");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("小便次数"); 
		return column;
	}
	/**
	 * 获取吸痰途径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_suction_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_suction_way");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸痰途径"); 
		return column;
	}
	/**
	 * 获取吸痰途径编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_suction_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_suction_way");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸痰途径编码"); 
		return column;
	}
	/**
	 * 获取性质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nature");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性质"); 
		return column;
	}
	/**
	 * 获取肤色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skin_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin_color");
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
	private IColumnDesc getSd_skin_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin_color");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肤色编码"); 
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
	 * 获取皮肤编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤编码"); 
		return column;
	}
	/**
	 * 获取管路表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipe");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管路"); 
		return column;
	}
	/**
	 * 获取管路编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管路编码"); 
		return column;
	}
	/**
	 * 获取病情变化及处理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBqbhjclCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bqbhjcl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情变化及处理"); 
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
	 * 获取机械通气方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mechanical_ventilationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mechanical_ventilation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机械通气方式"); 
		return column;
	}
	/**
	 * 获取入量用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_route_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_route_drug");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入量用法"); 
		return column;
	}
	/**
	 * 获取给药速度单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unit_speedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit_speed");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药速度单位"); 
		return column;
	}
	/**
	 * 获取饮食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diet");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食"); 
		return column;
	}
	/**
	 * 获取入量途径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dosein_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dosein_way");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入量途径"); 
		return column;
	}
	/**
	 * 获取吸痰途径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_suction_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_suction_way");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸痰途径"); 
		return column;
	}
	/**
	 * 获取肤色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skin_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skin_color");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肤色"); 
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
	 * 获取管路表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管路"); 
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
