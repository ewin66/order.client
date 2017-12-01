
package iih.ci.mr.nu.highriskinfantscare.d.desc;

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
 * 高危儿童护理记录 DO 元数据信息
 */
public class ChildrenCareDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.highriskinfantscare.d.ChildrenCareDO";
	public static final String CLASS_DISPALYNAME = "高危儿童护理记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_NU_CHCARE";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_chcare";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ChildrenCareDODesc(){
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
		this.setKeyDesc(getId_chcareADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_chcareADesc(tblDesc));
		this.add(getChADesc(tblDesc));
		this.add(getZyhADesc(tblDesc));
		this.add(getXmADesc(tblDesc));
		this.add(getRlADesc(tblDesc));
		this.add(getBsADesc(tblDesc));
		this.add(getQmADesc(tblDesc));
		this.add(getQdADesc(tblDesc));
		this.add(getPfADesc(tblDesc));
		this.add(getGymcADesc(tblDesc));
		this.add(getTydzADesc(tblDesc));
		this.add(getXyfsADesc(tblDesc));
		this.add(getFsADesc(tblDesc));
		this.add(getZzhdADesc(tblDesc));
		this.add(getGyyfADesc(tblDesc));
		this.add(getGysdADesc(tblDesc));
		this.add(getGyjlADesc(tblDesc));
		this.add(getNrADesc(tblDesc));
		this.add(getJzlADesc(tblDesc));
		this.add(getYsADesc(tblDesc));
		this.add(getKsADesc(tblDesc));
		this.add(getFzADesc(tblDesc));
		this.add(getSxlADesc(tblDesc));
		this.add(getBqbhjczADesc(tblDesc));
		this.add(getYlmlADesc(tblDesc));
		this.add(getDbgcADesc(tblDesc));
		this.add(getPcfADesc(tblDesc));
		this.add(getRcfADesc(tblDesc));
		this.add(getSpo2ADesc(tblDesc));
		this.add(getOtmlADesc(tblDesc));
		this.add(getXyndADesc(tblDesc));
		this.add(getBpmmhgADesc(tblDesc));
		this.add(getXbmlcADesc(tblDesc));
		this.add(getYlADesc(tblDesc));
		this.add(getXwADesc(tblDesc));
		this.add(getSdADesc(tblDesc));
		this.add(getTADesc(tblDesc));
		this.add(getRqADesc(tblDesc));
		this.add(getSjADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_chcareCDesc(tblDesc));
		tblDesc.add(getId_chcareCDesc(tblDesc));
		tblDesc.add(getChCDesc(tblDesc));
		tblDesc.add(getZyhCDesc(tblDesc));
		tblDesc.add(getXmCDesc(tblDesc));
		tblDesc.add(getRlCDesc(tblDesc));
		tblDesc.add(getBsCDesc(tblDesc));
		tblDesc.add(getQmCDesc(tblDesc));
		tblDesc.add(getQdCDesc(tblDesc));
		tblDesc.add(getPfCDesc(tblDesc));
		tblDesc.add(getGymcCDesc(tblDesc));
		tblDesc.add(getTydzCDesc(tblDesc));
		tblDesc.add(getXyfsCDesc(tblDesc));
		tblDesc.add(getFsCDesc(tblDesc));
		tblDesc.add(getZzhdCDesc(tblDesc));
		tblDesc.add(getGyyfCDesc(tblDesc));
		tblDesc.add(getGysdCDesc(tblDesc));
		tblDesc.add(getGyjlCDesc(tblDesc));
		tblDesc.add(getNrCDesc(tblDesc));
		tblDesc.add(getJzlCDesc(tblDesc));
		tblDesc.add(getYsCDesc(tblDesc));
		tblDesc.add(getKsCDesc(tblDesc));
		tblDesc.add(getFzCDesc(tblDesc));
		tblDesc.add(getSxlCDesc(tblDesc));
		tblDesc.add(getBqbhjczCDesc(tblDesc));
		tblDesc.add(getYlmlCDesc(tblDesc));
		tblDesc.add(getDbgcCDesc(tblDesc));
		tblDesc.add(getPcfCDesc(tblDesc));
		tblDesc.add(getRcfCDesc(tblDesc));
		tblDesc.add(getSpo2CDesc(tblDesc));
		tblDesc.add(getOtmlCDesc(tblDesc));
		tblDesc.add(getXyndCDesc(tblDesc));
		tblDesc.add(getBpmmhgCDesc(tblDesc));
		tblDesc.add(getXbmlcCDesc(tblDesc));
		tblDesc.add(getYlCDesc(tblDesc));
		tblDesc.add(getXwCDesc(tblDesc));
		tblDesc.add(getSdCDesc(tblDesc));
		tblDesc.add(getTCDesc(tblDesc));
		tblDesc.add(getRqCDesc(tblDesc));
		tblDesc.add(getSjCDesc(tblDesc));
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
	private IAttrDesc getId_chcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_chcare",  getId_chcareCDesc(tblDesc), this);
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
	 * 床号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ch",  getChCDesc(tblDesc), this);
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
	 * 住院号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZyhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zyh",  getZyhCDesc(tblDesc), this);
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
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getXmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Xm",  getXmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 日龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rl",  getRlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("日龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 鼻饲属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bs",  getBsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("鼻饲");
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
	private IAttrDesc getQmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qm",  getQmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
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
	private IAttrDesc getQdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qd",  getQdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带");
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
	private IAttrDesc getPfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pf",  getPfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤");
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
	private IAttrDesc getGymcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gymc",  getGymcCDesc(tblDesc), this);
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
	 * 吞咽动作属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTydzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tydz",  getTydzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吞咽动作");
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
	private IAttrDesc getXyfsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Xyfs",  getXyfsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸氧方式");
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
	private IAttrDesc getFsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fs",  getFsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肤色");
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
	private IAttrDesc getZzhdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zzhd",  getZzhdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自主活动");
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
	private IAttrDesc getGyyfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gyyf",  getGyyfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("给药用法");
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
	private IAttrDesc getGysdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gysd",  getGysdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("给药速度");
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
	private IAttrDesc getGyjlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gyjl",  getGyjlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("给药剂量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 纳入属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nr",  getNrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("纳入");
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
	private IAttrDesc getJzlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Jzl",  getJzlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肌张力");
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
	private IAttrDesc getYsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ys",  getYsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食");
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
	private IAttrDesc getKsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ks",  getKsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("哭声");
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
	private IAttrDesc getFzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fz",  getFzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("腹胀");
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
	private IAttrDesc getSxlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sxl",  getSxlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吮吸力");
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
	private IAttrDesc getBqbhjczADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bqbhjcz",  getBqbhjczCDesc(tblDesc), this);
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
	 * 引流(ml)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYlmlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ylml",  getYlmlCDesc(tblDesc), this);
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
	 * 大便(g/次)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDbgcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dbgc",  getDbgcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("大便(g/次)");
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
	private IAttrDesc getPcfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pcf",  getPcfCDesc(tblDesc), this);
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
	private IAttrDesc getRcfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rcf",  getRcfCDesc(tblDesc), this);
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
	 * 呕吐(ml)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOtmlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Otml",  getOtmlCDesc(tblDesc), this);
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
	 * 吸氧浓度(%)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getXyndADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Xynd",  getXyndCDesc(tblDesc), this);
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
	 * BP(mmHg)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBpmmhgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bpmmhg",  getBpmmhgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("BP(mmHg)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小便（ml/次）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getXbmlcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Xbmlc",  getXbmlcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("小便（ml/次）");
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
	private IAttrDesc getYlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Yl",  getYlCDesc(tblDesc), this);
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
	 * 箱温（℃）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getXwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Xw",  getXwCDesc(tblDesc), this);
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
	private IAttrDesc getSdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd",  getSdCDesc(tblDesc), this);
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
	 * T（℃）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("T",  getTCDesc(tblDesc), this);
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
	 * 日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rq",  getRqCDesc(tblDesc), this);
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
	private IAttrDesc getSjADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sj",  getSjCDesc(tblDesc), this);
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
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b6","xm=id_ent","name_pat"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取高危儿护理记录ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_chcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_chcare");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("高危儿护理记录ID"); 
		return column;
	}
	/**
	 * 获取床号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ch");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床号"); 
		return column;
	}
	/**
	 * 获取住院号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZyhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zyh");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院号"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getXmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Xm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取日龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("日龄"); 
		return column;
	}
	/**
	 * 获取鼻饲表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bs");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("鼻饲"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
		return column;
	}
	/**
	 * 获取脐带表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带"); 
		return column;
	}
	/**
	 * 获取皮肤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pf");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤"); 
		return column;
	}
	/**
	 * 获取给药名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGymcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gymc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药名称"); 
		return column;
	}
	/**
	 * 获取吞咽动作表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTydzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tydz");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吞咽动作"); 
		return column;
	}
	/**
	 * 获取吸氧方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getXyfsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Xyfs");
		column.setLength(50);
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
	private IColumnDesc getFsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fs");
		column.setLength(50);
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
	private IColumnDesc getZzhdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zzhd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自主活动"); 
		return column;
	}
	/**
	 * 获取给药用法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGyyfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gyyf");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药用法"); 
		return column;
	}
	/**
	 * 获取给药速度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGysdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gysd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药速度"); 
		return column;
	}
	/**
	 * 获取给药剂量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGyjlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gyjl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("给药剂量"); 
		return column;
	}
	/**
	 * 获取纳入表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("纳入"); 
		return column;
	}
	/**
	 * 获取肌张力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJzlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Jzl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肌张力"); 
		return column;
	}
	/**
	 * 获取饮食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ys");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食"); 
		return column;
	}
	/**
	 * 获取哭声表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getKsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ks");
		column.setLength(50);
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
	private IColumnDesc getFzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fz");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("腹胀"); 
		return column;
	}
	/**
	 * 获取吮吸力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSxlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sxl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吮吸力"); 
		return column;
	}
	/**
	 * 获取病情变化及处置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBqbhjczCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bqbhjcz");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情变化及处置"); 
		return column;
	}
	/**
	 * 获取引流(ml)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYlmlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ylml");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("引流(ml)"); 
		return column;
	}
	/**
	 * 获取大便(g/次)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDbgcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dbgc");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("大便(g/次)"); 
		return column;
	}
	/**
	 * 获取P(次/分)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPcfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pcf");
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
	private IColumnDesc getRcfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rcf");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("R(次/分)"); 
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
	 * 获取呕吐(ml)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOtmlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Otml");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呕吐(ml)"); 
		return column;
	}
	/**
	 * 获取吸氧浓度(%)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getXyndCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Xynd");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("吸氧浓度(%)"); 
		return column;
	}
	/**
	 * 获取BP(mmHg)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBpmmhgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bpmmhg");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("BP(mmHg)"); 
		return column;
	}
	/**
	 * 获取小便（ml/次）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getXbmlcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Xbmlc");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("小便（ml/次）"); 
		return column;
	}
	/**
	 * 获取饮量（ml）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Yl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("饮量（ml）"); 
		return column;
	}
	/**
	 * 获取箱温（℃）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getXwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Xw");
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
	private IColumnDesc getSdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("湿度（%）"); 
		return column;
	}
	/**
	 * 获取T（℃）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"T");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("T（℃）"); 
		return column;
	}
	/**
	 * 获取日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rq");
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
	private IColumnDesc getSjCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sj");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("时间"); 
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
