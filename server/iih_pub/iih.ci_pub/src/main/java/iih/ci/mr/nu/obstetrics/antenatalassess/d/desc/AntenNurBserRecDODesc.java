
package iih.ci.mr.nu.obstetrics.antenatalassess.d.desc;

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
 * 护理观察记录 DO 元数据信息
 */
public class AntenNurBserRecDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.obstetrics.antenatalassess.d.AntenNurBserRecDO";
	public static final String CLASS_DISPALYNAME = "护理观察记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_Mr_NU_ANTNURBSERREC";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_antenrec";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public AntenNurBserRecDODesc(){
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
		this.setKeyDesc(getId_antenrecADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_antenassADesc(tblDesc));
		this.add(getId_antenrecADesc(tblDesc));
		this.add(getId_antenassADesc(tblDesc));
		this.add(getDt_recADesc(tblDesc));
		this.add(getTempADesc(tblDesc));
		this.add(getPulseADesc(tblDesc));
		this.add(getBreathADesc(tblDesc));
		this.add(getSbpADesc(tblDesc));
		this.add(getDbpADesc(tblDesc));
		this.add(getSpoADesc(tblDesc));
		this.add(getId_fundushgtADesc(tblDesc));
		this.add(getSd_fundushgtADesc(tblDesc));
		this.add(getEu_uterus_pinchADesc(tblDesc));
		this.add(getColporrhagiaADesc(tblDesc));
		this.add(getUrinevolumeADesc(tblDesc));
		this.add(getDrinameADesc(tblDesc));
		this.add(getDridosageADesc(tblDesc));
		this.add(getDriusageADesc(tblDesc));
		this.add(getId_skincondADesc(tblDesc));
		this.add(getObserilnessADesc(tblDesc));
		this.add(getId_sign_psnADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_fundushgtADesc(tblDesc));
		this.add(getName_sign_psnADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_antenrecCDesc(tblDesc));
		tblDesc.add(getId_antenrecCDesc(tblDesc));
		tblDesc.add(getId_antenassCDesc(tblDesc));
		tblDesc.add(getDt_recCDesc(tblDesc));
		tblDesc.add(getTempCDesc(tblDesc));
		tblDesc.add(getPulseCDesc(tblDesc));
		tblDesc.add(getBreathCDesc(tblDesc));
		tblDesc.add(getSbpCDesc(tblDesc));
		tblDesc.add(getDbpCDesc(tblDesc));
		tblDesc.add(getSpoCDesc(tblDesc));
		tblDesc.add(getId_fundushgtCDesc(tblDesc));
		tblDesc.add(getSd_fundushgtCDesc(tblDesc));
		tblDesc.add(getEu_uterus_pinchCDesc(tblDesc));
		tblDesc.add(getColporrhagiaCDesc(tblDesc));
		tblDesc.add(getUrinevolumeCDesc(tblDesc));
		tblDesc.add(getDrinameCDesc(tblDesc));
		tblDesc.add(getDridosageCDesc(tblDesc));
		tblDesc.add(getDriusageCDesc(tblDesc));
		tblDesc.add(getId_skincondCDesc(tblDesc));
		tblDesc.add(getObserilnessCDesc(tblDesc));
		tblDesc.add(getId_sign_psnCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 观察记录标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_antenrecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_antenrec",  getId_antenrecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("观察记录标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 简要评估属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_antenassADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_antenass",  getId_antenassCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("简要评估");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 记录日期时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rec",  getDt_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("记录日期时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体温℃属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTempADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Temp",  getTempCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体温℃");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脉搏（次/分）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pulse",  getPulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脉搏（次/分）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸（次/分）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBreathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Breath",  getBreathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呼吸（次/分）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收缩压（mmhg）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sbp",  getSbpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收缩压（mmhg）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舒张压（mmhg）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dbp",  getDbpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("舒张压（mmhg）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血氧饱和度%属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spo",  getSpoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("血氧饱和度%");
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
	private IAttrDesc getId_fundushgtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fundushgt",  getId_fundushgtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宫底高度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 宫底高度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fundushgtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fundushgt",  getSd_fundushgtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宫底高度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 子宫收缩属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_uterus_pinchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_uterus_pinch",  getEu_uterus_pinchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("子宫收缩");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引导出血ml属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getColporrhagiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Colporrhagia",  getColporrhagiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("引导出血ml");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 尿量ml属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUrinevolumeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Urinevolume",  getUrinevolumeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("尿量ml");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入量名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrinameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Driname",  getDrinameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入量名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入量剂量（ml）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDridosageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dridosage",  getDridosageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("入量剂量（ml）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入量用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDriusageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Driusage",  getDriusageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入量用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skincondADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skincond",  getId_skincondCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("皮肤情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情观察属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getObserilnessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Obserilness",  getObserilnessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情观察");
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
	private IAttrDesc getId_sign_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign_psn",  getId_sign_psnCDesc(tblDesc), this);
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fundushgtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fundushgt",  getName_fundushgtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_fundushgt=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sign_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign_psn",  getName_sign_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b6","id_sign_psn=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取观察记录标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_antenrecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_antenrec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("观察记录标识"); 
		return column;
	}
	/**
	 * 获取简要评估表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_antenassCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_antenass");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("简要评估"); 
		return column;
	}
	/**
	 * 获取记录日期时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rec");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("记录日期时间"); 
		return column;
	}
	/**
	 * 获取体温℃表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTempCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Temp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体温℃"); 
		return column;
	}
	/**
	 * 获取脉搏（次/分）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pulse");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脉搏（次/分）"); 
		return column;
	}
	/**
	 * 获取呼吸（次/分）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBreathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Breath");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸（次/分）"); 
		return column;
	}
	/**
	 * 获取收缩压（mmhg）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压（mmhg）"); 
		return column;
	}
	/**
	 * 获取舒张压（mmhg）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压（mmhg）"); 
		return column;
	}
	/**
	 * 获取血氧饱和度%表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spo");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("血氧饱和度%"); 
		return column;
	}
	/**
	 * 获取宫底高度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fundushgtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fundushgt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宫底高度"); 
		return column;
	}
	/**
	 * 获取宫底高度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fundushgtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fundushgt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宫底高度编码"); 
		return column;
	}
	/**
	 * 获取子宫收缩表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_uterus_pinchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_uterus_pinch");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("子宫收缩"); 
		return column;
	}
	/**
	 * 获取引导出血ml表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getColporrhagiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Colporrhagia");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("引导出血ml"); 
		return column;
	}
	/**
	 * 获取尿量ml表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUrinevolumeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Urinevolume");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("尿量ml"); 
		return column;
	}
	/**
	 * 获取入量名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrinameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Driname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入量名称"); 
		return column;
	}
	/**
	 * 获取入量剂量（ml）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDridosageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dridosage");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("入量剂量（ml）"); 
		return column;
	}
	/**
	 * 获取入量用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDriusageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Driusage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入量用法"); 
		return column;
	}
	/**
	 * 获取皮肤情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skincondCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skincond");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("皮肤情况"); 
		return column;
	}
	/**
	 * 获取病情观察表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getObserilnessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Obserilness");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情观察"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sign_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign_psn");
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_fundushgtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fundushgt");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sign_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign_psn");
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
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
}
