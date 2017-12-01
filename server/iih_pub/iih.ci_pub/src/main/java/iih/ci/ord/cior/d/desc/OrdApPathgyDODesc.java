
package iih.ci.ord.cior.d.desc;

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
 * 病理申请单 DO 元数据信息
 */
public class OrdApPathgyDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.cior.d.OrdApPathgyDO";
	public static final String CLASS_DISPALYNAME = "病理申请单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_ap_pathgy";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_appathgy";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OrdApPathgyDODesc(){
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
		this.setKeyDesc(getId_appathgyADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_appathgyADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getNo_applyformADesc(tblDesc));
		this.add(getId_samptpADesc(tblDesc));
		this.add(getSd_samptpADesc(tblDesc));
		this.add(getQuanADesc(tblDesc));
		this.add(getSd_colltpADesc(tblDesc));
		this.add(getId_colltpADesc(tblDesc));
		this.add(getDes_labsampADesc(tblDesc));
		this.add(getFg_urgentADesc(tblDesc));
		this.add(getId_diADesc(tblDesc));
		this.add(getStr_code_diADesc(tblDesc));
		this.add(getStr_name_diADesc(tblDesc));
		this.add(getAnnouncementsADesc(tblDesc));
		this.add(getDes_sympsignADesc(tblDesc));
		this.add(getFg_outerADesc(tblDesc));
		this.add(getNo_pathgy_oldADesc(tblDesc));
		this.add(getDt_pathgy_oldADesc(tblDesc));
		this.add(getDi_pathgy_oldADesc(tblDesc));
		this.add(getOrg_pathgy_oldADesc(tblDesc));
		this.add(getCollectdesADesc(tblDesc));
		this.add(getId_empADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getDt_collADesc(tblDesc));
		this.add(getId_su_pathgyADesc(tblDesc));
		this.add(getSd_su_pathgyADesc(tblDesc));
		this.add(getNo_pathgyADesc(tblDesc));
		this.add(getDt_rptpathgyADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_diagADesc(tblDesc));
		this.add(getStr_id_diitmADesc(tblDesc));
		this.add(getId_diitmADesc(tblDesc));
		this.add(getFg_prnADesc(tblDesc));
		this.add(getCnt_prnADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getDef6ADesc(tblDesc));
		this.add(getDef7ADesc(tblDesc));
		this.add(getDef8ADesc(tblDesc));
		this.add(getDef9ADesc(tblDesc));
		this.add(getDef10ADesc(tblDesc));
		this.add(getDef11ADesc(tblDesc));
		this.add(getDef12ADesc(tblDesc));
		this.add(getDef13ADesc(tblDesc));
		this.add(getDef14ADesc(tblDesc));
		this.add(getDef15ADesc(tblDesc));
		this.add(getDef16ADesc(tblDesc));
		this.add(getDef17ADesc(tblDesc));
		this.add(getDef18ADesc(tblDesc));
		this.add(getDef19ADesc(tblDesc));
		this.add(getDef20ADesc(tblDesc));
		this.add(getDef21ADesc(tblDesc));
		this.add(getDef22ADesc(tblDesc));
		this.add(getDef23ADesc(tblDesc));
		this.add(getDef24ADesc(tblDesc));
		this.add(getDef25ADesc(tblDesc));
		this.add(getDef26ADesc(tblDesc));
		this.add(getDef27ADesc(tblDesc));
		this.add(getDef28ADesc(tblDesc));
		this.add(getDef29ADesc(tblDesc));
		this.add(getDef30ADesc(tblDesc));
		this.add(getDef31ADesc(tblDesc));
		this.add(getDef32ADesc(tblDesc));
		this.add(getDef33ADesc(tblDesc));
		this.add(getDef34ADesc(tblDesc));
		this.add(getDef35ADesc(tblDesc));
		this.add(getDef36ADesc(tblDesc));
		this.add(getDef37ADesc(tblDesc));
		this.add(getDef38ADesc(tblDesc));
		this.add(getDef39ADesc(tblDesc));
		this.add(getDef40ADesc(tblDesc));
		this.add(getDef41ADesc(tblDesc));
		this.add(getDef42ADesc(tblDesc));
		this.add(getDef43ADesc(tblDesc));
		this.add(getDef44ADesc(tblDesc));
		this.add(getDef45ADesc(tblDesc));
		this.add(getDef46ADesc(tblDesc));
		this.add(getDef47ADesc(tblDesc));
		this.add(getDef48ADesc(tblDesc));
		this.add(getDef49ADesc(tblDesc));
		this.add(getDef50ADesc(tblDesc));
		this.add(getName_samptpADesc(tblDesc));
		this.add(getName_cooltpADesc(tblDesc));
		this.add(getName_coll_empADesc(tblDesc));
		this.add(getName_depADesc(tblDesc));
		this.add(getName_suADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_appathgyCDesc(tblDesc));
		tblDesc.add(getId_appathgyCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getNo_applyformCDesc(tblDesc));
		tblDesc.add(getId_samptpCDesc(tblDesc));
		tblDesc.add(getSd_samptpCDesc(tblDesc));
		tblDesc.add(getQuanCDesc(tblDesc));
		tblDesc.add(getSd_colltpCDesc(tblDesc));
		tblDesc.add(getId_colltpCDesc(tblDesc));
		tblDesc.add(getDes_labsampCDesc(tblDesc));
		tblDesc.add(getFg_urgentCDesc(tblDesc));
		tblDesc.add(getId_diCDesc(tblDesc));
		tblDesc.add(getStr_code_diCDesc(tblDesc));
		tblDesc.add(getStr_name_diCDesc(tblDesc));
		tblDesc.add(getAnnouncementsCDesc(tblDesc));
		tblDesc.add(getDes_sympsignCDesc(tblDesc));
		tblDesc.add(getFg_outerCDesc(tblDesc));
		tblDesc.add(getNo_pathgy_oldCDesc(tblDesc));
		tblDesc.add(getDt_pathgy_oldCDesc(tblDesc));
		tblDesc.add(getDi_pathgy_oldCDesc(tblDesc));
		tblDesc.add(getOrg_pathgy_oldCDesc(tblDesc));
		tblDesc.add(getCollectdesCDesc(tblDesc));
		tblDesc.add(getId_empCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getDt_collCDesc(tblDesc));
		tblDesc.add(getId_su_pathgyCDesc(tblDesc));
		tblDesc.add(getSd_su_pathgyCDesc(tblDesc));
		tblDesc.add(getNo_pathgyCDesc(tblDesc));
		tblDesc.add(getDt_rptpathgyCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getName_diagCDesc(tblDesc));
		tblDesc.add(getStr_id_diitmCDesc(tblDesc));
		tblDesc.add(getId_diitmCDesc(tblDesc));
		tblDesc.add(getFg_prnCDesc(tblDesc));
		tblDesc.add(getCnt_prnCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getDef6CDesc(tblDesc));
		tblDesc.add(getDef7CDesc(tblDesc));
		tblDesc.add(getDef8CDesc(tblDesc));
		tblDesc.add(getDef9CDesc(tblDesc));
		tblDesc.add(getDef10CDesc(tblDesc));
		tblDesc.add(getDef11CDesc(tblDesc));
		tblDesc.add(getDef12CDesc(tblDesc));
		tblDesc.add(getDef13CDesc(tblDesc));
		tblDesc.add(getDef14CDesc(tblDesc));
		tblDesc.add(getDef15CDesc(tblDesc));
		tblDesc.add(getDef16CDesc(tblDesc));
		tblDesc.add(getDef17CDesc(tblDesc));
		tblDesc.add(getDef18CDesc(tblDesc));
		tblDesc.add(getDef19CDesc(tblDesc));
		tblDesc.add(getDef20CDesc(tblDesc));
		tblDesc.add(getDef21CDesc(tblDesc));
		tblDesc.add(getDef22CDesc(tblDesc));
		tblDesc.add(getDef23CDesc(tblDesc));
		tblDesc.add(getDef24CDesc(tblDesc));
		tblDesc.add(getDef25CDesc(tblDesc));
		tblDesc.add(getDef26CDesc(tblDesc));
		tblDesc.add(getDef27CDesc(tblDesc));
		tblDesc.add(getDef28CDesc(tblDesc));
		tblDesc.add(getDef29CDesc(tblDesc));
		tblDesc.add(getDef30CDesc(tblDesc));
		tblDesc.add(getDef31CDesc(tblDesc));
		tblDesc.add(getDef32CDesc(tblDesc));
		tblDesc.add(getDef33CDesc(tblDesc));
		tblDesc.add(getDef34CDesc(tblDesc));
		tblDesc.add(getDef35CDesc(tblDesc));
		tblDesc.add(getDef36CDesc(tblDesc));
		tblDesc.add(getDef37CDesc(tblDesc));
		tblDesc.add(getDef38CDesc(tblDesc));
		tblDesc.add(getDef39CDesc(tblDesc));
		tblDesc.add(getDef40CDesc(tblDesc));
		tblDesc.add(getDef41CDesc(tblDesc));
		tblDesc.add(getDef42CDesc(tblDesc));
		tblDesc.add(getDef43CDesc(tblDesc));
		tblDesc.add(getDef44CDesc(tblDesc));
		tblDesc.add(getDef45CDesc(tblDesc));
		tblDesc.add(getDef46CDesc(tblDesc));
		tblDesc.add(getDef47CDesc(tblDesc));
		tblDesc.add(getDef48CDesc(tblDesc));
		tblDesc.add(getDef49CDesc(tblDesc));
		tblDesc.add(getDef50CDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 病理申请单主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_appathgyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_appathgy",  getId_appathgyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病理申请单主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病理申请号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_applyformADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_applyform",  getNo_applyformCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病理申请号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_samptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_samptp",  getId_samptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 标本类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_samptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_samptp",  getSd_samptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本需求量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan",  getQuanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("标本需求量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 采集方法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_colltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_colltp",  getSd_colltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("采集方法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 采集方法id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_colltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_colltp",  getId_colltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("采集方法id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 标本说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_labsampADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_labsamp",  getDes_labsampCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 加急属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_urgentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_urgent",  getFg_urgentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("加急");
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
	private IAttrDesc getId_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_di",  getId_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断编码拼接属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_code_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_code_di",  getStr_code_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码拼接");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称拼接属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_name_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_name_di",  getStr_name_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称拼接");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查要求属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnnouncementsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Announcements",  getAnnouncementsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查要求");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_sympsignADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_sympsign",  getDes_sympsignCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否外院标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_outerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_outer",  getFg_outerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否外院标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 既往病理号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_pathgy_oldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_pathgy_old",  getNo_pathgy_oldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("既往病理号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 既往检查日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_pathgy_oldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_pathgy_old",  getDt_pathgy_oldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("既往检查日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 既往检查诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_pathgy_oldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_pathgy_old",  getDi_pathgy_oldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("既往检查诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 既往检查医院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_pathgy_oldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_pathgy_old",  getOrg_pathgy_oldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("既往检查医院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 采集所见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCollectdesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Collectdes",  getCollectdesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("采集所见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 采集者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp",  getId_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("采集者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 采集者科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("采集者科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 标本采集时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_collADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_coll",  getDt_collCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("标本采集时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病理申请状态id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_su_pathgyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_su_pathgy",  getId_su_pathgyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病理申请状态id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病理申请状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_su_pathgyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_su_pathgy",  getSd_su_pathgyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病理申请状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病理号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_pathgyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_pathgy",  getNo_pathgyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病理号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告发布时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_rptpathgyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rptpathgy",  getDt_rptpathgyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("报告发布时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diag",  getName_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床诊断id拼接属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_id_diitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_id_diitm",  getStr_id_diitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床诊断id拼接");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床诊断子项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diitm",  getId_diitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床诊断子项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prn",  getFg_prnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("打印标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCnt_prnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cnt_prn",  getCnt_prnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("打印次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段6属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def6",  getDef6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段6");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段7属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def7",  getDef7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段7");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段8属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def8",  getDef8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段8");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段9属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def9",  getDef9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段9");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段10属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def10",  getDef10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段10");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段11属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef11ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def11",  getDef11CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段11");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段12属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef12ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def12",  getDef12CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段12");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段13属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef13ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def13",  getDef13CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段13");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段14属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef14ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def14",  getDef14CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段14");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段15属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef15ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def15",  getDef15CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段15");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段16属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef16ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def16",  getDef16CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段16");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段17属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef17ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def17",  getDef17CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段17");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段18属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef18ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def18",  getDef18CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段18");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段19属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef19ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def19",  getDef19CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段19");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段20属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef20ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def20",  getDef20CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段20");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段21属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef21ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def21",  getDef21CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段21");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段22属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef22ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def22",  getDef22CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段22");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段23属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef23ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def23",  getDef23CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段23");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段24属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef24ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def24",  getDef24CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段24");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段25属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef25ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def25",  getDef25CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段25");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段26属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef26ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def26",  getDef26CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段26");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段27属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef27ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def27",  getDef27CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段27");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段28属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef28ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def28",  getDef28CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段28");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段29属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef29ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def29",  getDef29CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段29");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段30属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef30ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def30",  getDef30CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段30");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段31属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef31ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def31",  getDef31CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段31");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段32属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef32ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def32",  getDef32CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段32");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段33属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef33ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def33",  getDef33CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段33");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段34属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef34ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def34",  getDef34CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段34");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段35属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef35ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def35",  getDef35CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段35");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段36属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef36ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def36",  getDef36CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段36");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段37属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef37ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def37",  getDef37CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段37");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段38属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef38ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def38",  getDef38CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段38");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段39属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef39ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def39",  getDef39CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段39");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段40属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef40ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def40",  getDef40CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段40");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段41属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef41ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def41",  getDef41CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段41");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段42属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef42ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def42",  getDef42CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段42");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段43属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef43ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def43",  getDef43CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段43");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段44属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef44ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def44",  getDef44CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段44");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段45属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef45ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def45",  getDef45CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段45");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段46属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef46ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def46",  getDef46CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段46");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段47属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef47ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def47",  getDef47CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段47");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段48属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef48ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def48",  getDef48CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段48");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段49属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef49ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def49",  getDef49CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段49");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段50属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef50ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def50",  getDef50CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段50");
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
	private IAttrDesc getName_samptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_samptp",  getName_samptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_samptp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cooltpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cooltp",  getName_cooltpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_colltp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_coll_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_coll_emp",  getName_coll_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_emp=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep",  getName_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dep=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_suADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_su",  getName_suCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_su_pathgy=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取病理申请单主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_appathgyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_appathgy");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病理申请单主键标识"); 
		return column;
	}
	/**
	 * 获取医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱"); 
		return column;
	}
	/**
	 * 获取病理申请号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_applyformCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_applyform");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病理申请号"); 
		return column;
	}
	/**
	 * 获取标本类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_samptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_samptp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本类型"); 
		return column;
	}
	/**
	 * 获取标本类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_samptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_samptp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本类型编码"); 
		return column;
	}
	/**
	 * 获取标本需求量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("标本需求量"); 
		return column;
	}
	/**
	 * 获取采集方法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_colltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_colltp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("采集方法编码"); 
		return column;
	}
	/**
	 * 获取采集方法id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_colltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_colltp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("采集方法id"); 
		return column;
	}
	/**
	 * 获取标本说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_labsampCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_labsamp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本说明"); 
		return column;
	}
	/**
	 * 获取加急表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_urgentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_urgent");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("加急"); 
		return column;
	}
	/**
	 * 获取诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_di");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断"); 
		return column;
	}
	/**
	 * 获取诊断编码拼接表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_code_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_code_di");
		column.setLength(1500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码拼接"); 
		return column;
	}
	/**
	 * 获取诊断名称拼接表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_name_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_name_di");
		column.setLength(800);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称拼接"); 
		return column;
	}
	/**
	 * 获取检查要求表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnnouncementsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Announcements");
		column.setLength(800);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查要求"); 
		return column;
	}
	/**
	 * 获取病情描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_sympsignCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_sympsign");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情描述"); 
		return column;
	}
	/**
	 * 获取是否外院标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_outerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_outer");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否外院标志"); 
		return column;
	}
	/**
	 * 获取既往病理号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_pathgy_oldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_pathgy_old");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("既往病理号"); 
		return column;
	}
	/**
	 * 获取既往检查日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_pathgy_oldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_pathgy_old");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("既往检查日期"); 
		return column;
	}
	/**
	 * 获取既往检查诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_pathgy_oldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_pathgy_old");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("既往检查诊断"); 
		return column;
	}
	/**
	 * 获取既往检查医院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_pathgy_oldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_pathgy_old");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("既往检查医院"); 
		return column;
	}
	/**
	 * 获取采集所见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCollectdesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Collectdes");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("采集所见"); 
		return column;
	}
	/**
	 * 获取采集者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("采集者编码"); 
		return column;
	}
	/**
	 * 获取采集者科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("采集者科室"); 
		return column;
	}
	/**
	 * 获取标本采集时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_collCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_coll");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("标本采集时间"); 
		return column;
	}
	/**
	 * 获取病理申请状态id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_su_pathgyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_su_pathgy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病理申请状态id"); 
		return column;
	}
	/**
	 * 获取病理申请状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_su_pathgyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_su_pathgy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病理申请状态"); 
		return column;
	}
	/**
	 * 获取病理号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_pathgyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_pathgy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病理号"); 
		return column;
	}
	/**
	 * 获取报告发布时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_rptpathgyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rptpathgy");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("报告发布时间"); 
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
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diag");
		column.setLength(1500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取临床诊断id拼接表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_id_diitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_id_diitm");
		column.setLength(1500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床诊断id拼接"); 
		return column;
	}
	/**
	 * 获取临床诊断子项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diitm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床诊断子项"); 
		return column;
	}
	/**
	 * 获取打印标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prn");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("打印标识"); 
		return column;
	}
	/**
	 * 获取打印次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCnt_prnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cnt_prn");
		column.setLength(5);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("打印次数"); 
		return column;
	}
	/**
	 * 获取客户扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段1"); 
		return column;
	}
	/**
	 * 获取客户扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段2"); 
		return column;
	}
	/**
	 * 获取客户扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段3"); 
		return column;
	}
	/**
	 * 获取客户扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段4"); 
		return column;
	}
	/**
	 * 获取客户扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段5"); 
		return column;
	}
	/**
	 * 获取客户扩展字段6表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def6");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段6"); 
		return column;
	}
	/**
	 * 获取客户扩展字段7表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def7");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段7"); 
		return column;
	}
	/**
	 * 获取客户扩展字段8表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def8");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段8"); 
		return column;
	}
	/**
	 * 获取客户扩展字段9表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def9");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段9"); 
		return column;
	}
	/**
	 * 获取客户扩展字段10表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def10");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段10"); 
		return column;
	}
	/**
	 * 获取客户扩展字段11表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef11CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def11");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段11"); 
		return column;
	}
	/**
	 * 获取客户扩展字段12表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef12CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def12");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段12"); 
		return column;
	}
	/**
	 * 获取客户扩展字段13表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef13CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def13");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段13"); 
		return column;
	}
	/**
	 * 获取客户扩展字段14表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef14CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def14");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段14"); 
		return column;
	}
	/**
	 * 获取客户扩展字段15表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef15CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def15");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段15"); 
		return column;
	}
	/**
	 * 获取客户扩展字段16表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef16CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def16");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段16"); 
		return column;
	}
	/**
	 * 获取客户扩展字段17表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef17CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def17");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段17"); 
		return column;
	}
	/**
	 * 获取客户扩展字段18表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef18CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def18");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段18"); 
		return column;
	}
	/**
	 * 获取客户扩展字段19表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef19CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def19");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段19"); 
		return column;
	}
	/**
	 * 获取客户扩展字段20表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef20CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def20");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段20"); 
		return column;
	}
	/**
	 * 获取客户扩展字段21表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef21CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def21");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段21"); 
		return column;
	}
	/**
	 * 获取客户扩展字段22表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef22CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def22");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段22"); 
		return column;
	}
	/**
	 * 获取客户扩展字段23表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef23CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def23");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段23"); 
		return column;
	}
	/**
	 * 获取客户扩展字段24表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef24CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def24");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段24"); 
		return column;
	}
	/**
	 * 获取客户扩展字段25表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef25CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def25");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段25"); 
		return column;
	}
	/**
	 * 获取客户扩展字段26表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef26CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def26");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段26"); 
		return column;
	}
	/**
	 * 获取客户扩展字段27表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef27CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def27");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段27"); 
		return column;
	}
	/**
	 * 获取客户扩展字段28表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef28CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def28");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段28"); 
		return column;
	}
	/**
	 * 获取客户扩展字段29表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef29CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def29");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段29"); 
		return column;
	}
	/**
	 * 获取客户扩展字段30表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef30CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def30");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段30"); 
		return column;
	}
	/**
	 * 获取客户扩展字段31表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef31CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def31");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段31"); 
		return column;
	}
	/**
	 * 获取客户扩展字段32表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef32CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def32");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段32"); 
		return column;
	}
	/**
	 * 获取客户扩展字段33表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef33CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def33");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段33"); 
		return column;
	}
	/**
	 * 获取客户扩展字段34表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef34CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def34");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段34"); 
		return column;
	}
	/**
	 * 获取客户扩展字段35表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef35CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def35");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段35"); 
		return column;
	}
	/**
	 * 获取客户扩展字段36表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef36CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def36");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段36"); 
		return column;
	}
	/**
	 * 获取客户扩展字段37表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef37CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def37");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段37"); 
		return column;
	}
	/**
	 * 获取客户扩展字段38表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef38CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def38");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段38"); 
		return column;
	}
	/**
	 * 获取客户扩展字段39表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef39CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def39");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段39"); 
		return column;
	}
	/**
	 * 获取客户扩展字段40表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef40CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def40");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段40"); 
		return column;
	}
	/**
	 * 获取客户扩展字段41表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef41CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def41");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段41"); 
		return column;
	}
	/**
	 * 获取客户扩展字段42表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef42CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def42");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段42"); 
		return column;
	}
	/**
	 * 获取客户扩展字段43表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef43CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def43");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段43"); 
		return column;
	}
	/**
	 * 获取客户扩展字段44表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef44CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def44");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段44"); 
		return column;
	}
	/**
	 * 获取客户扩展字段45表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef45CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def45");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段45"); 
		return column;
	}
	/**
	 * 获取客户扩展字段46表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef46CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def46");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段46"); 
		return column;
	}
	/**
	 * 获取客户扩展字段47表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef47CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def47");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段47"); 
		return column;
	}
	/**
	 * 获取客户扩展字段48表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef48CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def48");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段48"); 
		return column;
	}
	/**
	 * 获取客户扩展字段49表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef49CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def49");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段49"); 
		return column;
	}
	/**
	 * 获取客户扩展字段50表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef50CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def50");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段50"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_samptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_samptp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cooltpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cooltp");
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
	private IColumnDesc getName_coll_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_coll_emp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_suCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_su");
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
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
}
