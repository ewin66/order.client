
package iih.ci.mr.nu.obstetrics.gynurbefore.d.desc;

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
 * 护理记录 DO 元数据信息
 */
public class GyNurBeforeRecDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.obstetrics.gynurbefore.d.GyNurBeforeRecDO";
	public static final String CLASS_DISPALYNAME = "护理记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_NU_GYBEFOREREC";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_rec";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public GyNurBeforeRecDODesc(){
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
		this.setKeyDesc(getId_recADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_assADesc(tblDesc));
		this.add(getId_recADesc(tblDesc));
		this.add(getId_assADesc(tblDesc));
		this.add(getRqADesc(tblDesc));
		this.add(getTwtADesc(tblDesc));
		this.add(getMbpADesc(tblDesc));
		this.add(getHxrADesc(tblDesc));
		this.add(getSsysbpADesc(tblDesc));
		this.add(getSzydbpADesc(tblDesc));
		this.add(getXybhdsaoADesc(tblDesc));
		this.add(getTxADesc(tblDesc));
		this.add(getFtADesc(tblDesc));
		this.add(getId_ydcxADesc(tblDesc));
		this.add(getSd_ydcxADesc(tblDesc));
		this.add(getRlmcADesc(tblDesc));
		this.add(getRljlADesc(tblDesc));
		this.add(getId_rlyfADesc(tblDesc));
		this.add(getSd_rlyfADesc(tblDesc));
		this.add(getClnlADesc(tblDesc));
		this.add(getClotlADesc(tblDesc));
		this.add(getBqgcjcsADesc(tblDesc));
		this.add(getGcjlqmADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_ydcxADesc(tblDesc));
		this.add(getName_rlyfADesc(tblDesc));
		this.add(getName_psndocADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_recCDesc(tblDesc));
		tblDesc.add(getId_recCDesc(tblDesc));
		tblDesc.add(getId_assCDesc(tblDesc));
		tblDesc.add(getRqCDesc(tblDesc));
		tblDesc.add(getTwtCDesc(tblDesc));
		tblDesc.add(getMbpCDesc(tblDesc));
		tblDesc.add(getHxrCDesc(tblDesc));
		tblDesc.add(getSsysbpCDesc(tblDesc));
		tblDesc.add(getSzydbpCDesc(tblDesc));
		tblDesc.add(getXybhdsaoCDesc(tblDesc));
		tblDesc.add(getTxCDesc(tblDesc));
		tblDesc.add(getFtCDesc(tblDesc));
		tblDesc.add(getId_ydcxCDesc(tblDesc));
		tblDesc.add(getSd_ydcxCDesc(tblDesc));
		tblDesc.add(getRlmcCDesc(tblDesc));
		tblDesc.add(getRljlCDesc(tblDesc));
		tblDesc.add(getId_rlyfCDesc(tblDesc));
		tblDesc.add(getSd_rlyfCDesc(tblDesc));
		tblDesc.add(getClnlCDesc(tblDesc));
		tblDesc.add(getClotlCDesc(tblDesc));
		tblDesc.add(getBqgcjcsCDesc(tblDesc));
		tblDesc.add(getGcjlqmCDesc(tblDesc));
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
	private IAttrDesc getId_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rec",  getId_recCDesc(tblDesc), this);
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
	 * 护理记录评估单id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_assADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ass",  getId_assCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理记录评估单id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rq",  getRqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体温(T)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTwtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Twt",  getTwtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体温(T)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脉搏(P)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mbp",  getMbpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脉搏(P)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸(R)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHxrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hxr",  getHxrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呼吸(R)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收缩压(SBP)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSsysbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ssysbp",  getSsysbpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收缩压(SBP)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舒张压(DBP)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSzydbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Szydbp",  getSzydbpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("舒张压(DBP)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血氧饱和度(SaO2)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getXybhdsaoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Xybhdsao",  getXybhdsaoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("血氧饱和度(SaO2)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎心属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tx",  getTxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎心");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 腹痛属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ft",  getFtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("腹痛");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 阴道出血属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ydcxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ydcx",  getId_ydcxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("阴道出血");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 阴道出血编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ydcxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ydcx",  getSd_ydcxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("阴道出血编码");
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
	private IAttrDesc getRlmcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rlmc",  getRlmcCDesc(tblDesc), this);
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
	 * 入量剂量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRljlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rljl",  getRljlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("入量剂量");
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
	private IAttrDesc getId_rlyfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rlyf",  getId_rlyfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入量用法");
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
	private IAttrDesc getSd_rlyfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rlyf",  getSd_rlyfCDesc(tblDesc), this);
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
	 * 出量尿量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getClnlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Clnl",  getClnlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("出量尿量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出量呕吐量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getClotlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Clotl",  getClotlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("出量呕吐量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情观察及措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBqgcjcsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bqgcjcs",  getBqgcjcsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情观察及措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 观察记录签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGcjlqmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gcjlqm",  getGcjlqmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("观察记录签名");
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
	 * 阴道出血属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ydcxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ydcx",  getName_ydcxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("阴道出血");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_ydcx=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入量用法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rlyfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rlyf",  getName_rlyfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入量用法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_rlyf=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psndoc",  getName_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b2","gcjlqm=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取唯一标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("唯一标识"); 
		return column;
	}
	/**
	 * 获取护理记录评估单id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_assCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ass");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理记录评估单id"); 
		return column;
	}
	/**
	 * 获取日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rq");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期"); 
		return column;
	}
	/**
	 * 获取体温(T)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTwtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Twt");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体温(T)"); 
		return column;
	}
	/**
	 * 获取脉搏(P)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脉搏(P)"); 
		return column;
	}
	/**
	 * 获取呼吸(R)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHxrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hxr");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸(R)"); 
		return column;
	}
	/**
	 * 获取收缩压(SBP)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSsysbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ssysbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压(SBP)"); 
		return column;
	}
	/**
	 * 获取舒张压(DBP)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSzydbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Szydbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压(DBP)"); 
		return column;
	}
	/**
	 * 获取血氧饱和度(SaO2)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getXybhdsaoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Xybhdsao");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("血氧饱和度(SaO2)"); 
		return column;
	}
	/**
	 * 获取胎心表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tx");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎心"); 
		return column;
	}
	/**
	 * 获取腹痛表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ft");
		column.setLength(1);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("腹痛"); 
		return column;
	}
	/**
	 * 获取阴道出血表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ydcxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ydcx");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("阴道出血"); 
		return column;
	}
	/**
	 * 获取阴道出血编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ydcxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ydcx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("阴道出血编码"); 
		return column;
	}
	/**
	 * 获取入量名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRlmcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rlmc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入量名称"); 
		return column;
	}
	/**
	 * 获取入量剂量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRljlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rljl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("入量剂量"); 
		return column;
	}
	/**
	 * 获取入量用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rlyfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rlyf");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入量用法"); 
		return column;
	}
	/**
	 * 获取入量用法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rlyfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rlyf");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入量用法编码"); 
		return column;
	}
	/**
	 * 获取出量尿量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getClnlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Clnl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("出量尿量"); 
		return column;
	}
	/**
	 * 获取出量呕吐量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getClotlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Clotl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("出量呕吐量"); 
		return column;
	}
	/**
	 * 获取病情观察及措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBqgcjcsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bqgcjcs");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情观察及措施"); 
		return column;
	}
	/**
	 * 获取观察记录签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGcjlqmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gcjlqm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("观察记录签名"); 
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
	 * 获取阴道出血表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ydcxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ydcx");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("阴道出血"); 
		return column;
	}
	/**
	 * 获取入量用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rlyfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rlyf");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入量用法"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psndoc");
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
