
package iih.ci.mrfp.sug2mrfp.d.desc;

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
 * 医疗记录_住院病历首页_手术 DO 元数据信息
 */
public class CiMrFpSugDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrfp.sug2mrfp.d.CiMrFpSugDO";
	public static final String CLASS_DISPALYNAME = "医疗记录_住院病历首页_手术";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_FP_SUG";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_mrfpsug";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiMrFpSugDODesc(){
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
		this.setKeyDesc(getId_mrfpsugADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_mrfpsugADesc(tblDesc));
		this.add(getId_mrfpADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_sugADesc(tblDesc));
		this.add(getSd_sugADesc(tblDesc));
		this.add(getName_sugADesc(tblDesc));
		this.add(getId_lvlsugADesc(tblDesc));
		this.add(getSd_lvlsugADesc(tblDesc));
		this.add(getName_lvlsugADesc(tblDesc));
		this.add(getDt_start_sugADesc(tblDesc));
		this.add(getDt_end_sugADesc(tblDesc));
		this.add(getId_emp_sugADesc(tblDesc));
		this.add(getSd_emp_sugADesc(tblDesc));
		this.add(getName_emp_sugADesc(tblDesc));
		this.add(getId_emp_asst1ADesc(tblDesc));
		this.add(getSd_emp_asst1ADesc(tblDesc));
		this.add(getName_emp_asst1ADesc(tblDesc));
		this.add(getId_emp_asst2ADesc(tblDesc));
		this.add(getSd_emp_asst2ADesc(tblDesc));
		this.add(getName_emp_asst2ADesc(tblDesc));
		this.add(getId_emp_anesADesc(tblDesc));
		this.add(getSd_emp_anesADesc(tblDesc));
		this.add(getName_emp_anesADesc(tblDesc));
		this.add(getId_incitpADesc(tblDesc));
		this.add(getSd_incitpADesc(tblDesc));
		this.add(getName_incitpADesc(tblDesc));
		this.add(getId_anestpADesc(tblDesc));
		this.add(getSd_anestpADesc(tblDesc));
		this.add(getName_anestpADesc(tblDesc));
		this.add(getId_incicondiADesc(tblDesc));
		this.add(getSd_incicondiADesc(tblDesc));
		this.add(getName_incicondiADesc(tblDesc));
		this.add(getSug_codeADesc(tblDesc));
		this.add(getSug_nameADesc(tblDesc));
		this.add(getLvlsug_codeADesc(tblDesc));
		this.add(getLvlsug_nameADesc(tblDesc));
		this.add(getEmp_sug_nameADesc(tblDesc));
		this.add(getEmp_sug_codeADesc(tblDesc));
		this.add(getEmp_asst1_nameADesc(tblDesc));
		this.add(getEmp_asst1_codeADesc(tblDesc));
		this.add(getEmp_asst2_nameADesc(tblDesc));
		this.add(getEmp_asst2_codeADesc(tblDesc));
		this.add(getEmp_anes_nameADesc(tblDesc));
		this.add(getEmp_anes_codeADesc(tblDesc));
		this.add(getIncitp_codeADesc(tblDesc));
		this.add(getIncitp_nameADesc(tblDesc));
		this.add(getAnestp_codeADesc(tblDesc));
		this.add(getAnestp_nameADesc(tblDesc));
		this.add(getIncicondi_codeADesc(tblDesc));
		this.add(getIncicondi_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mrfpsugCDesc(tblDesc));
		tblDesc.add(getId_mrfpsugCDesc(tblDesc));
		tblDesc.add(getId_mrfpCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_sugCDesc(tblDesc));
		tblDesc.add(getSd_sugCDesc(tblDesc));
		tblDesc.add(getName_sugCDesc(tblDesc));
		tblDesc.add(getId_lvlsugCDesc(tblDesc));
		tblDesc.add(getSd_lvlsugCDesc(tblDesc));
		tblDesc.add(getName_lvlsugCDesc(tblDesc));
		tblDesc.add(getDt_start_sugCDesc(tblDesc));
		tblDesc.add(getDt_end_sugCDesc(tblDesc));
		tblDesc.add(getId_emp_sugCDesc(tblDesc));
		tblDesc.add(getSd_emp_sugCDesc(tblDesc));
		tblDesc.add(getName_emp_sugCDesc(tblDesc));
		tblDesc.add(getId_emp_asst1CDesc(tblDesc));
		tblDesc.add(getSd_emp_asst1CDesc(tblDesc));
		tblDesc.add(getName_emp_asst1CDesc(tblDesc));
		tblDesc.add(getId_emp_asst2CDesc(tblDesc));
		tblDesc.add(getSd_emp_asst2CDesc(tblDesc));
		tblDesc.add(getName_emp_asst2CDesc(tblDesc));
		tblDesc.add(getId_emp_anesCDesc(tblDesc));
		tblDesc.add(getSd_emp_anesCDesc(tblDesc));
		tblDesc.add(getName_emp_anesCDesc(tblDesc));
		tblDesc.add(getId_incitpCDesc(tblDesc));
		tblDesc.add(getSd_incitpCDesc(tblDesc));
		tblDesc.add(getName_incitpCDesc(tblDesc));
		tblDesc.add(getId_anestpCDesc(tblDesc));
		tblDesc.add(getSd_anestpCDesc(tblDesc));
		tblDesc.add(getName_anestpCDesc(tblDesc));
		tblDesc.add(getId_incicondiCDesc(tblDesc));
		tblDesc.add(getSd_incicondiCDesc(tblDesc));
		tblDesc.add(getName_incicondiCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 住院病历首页手术ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrfpsugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrfpsug",  getId_mrfpsugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病历首页手术ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院病历首页属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrfpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrfp",  getId_mrfpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病历首页");
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
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术、操作编码ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sug",  getId_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术、操作编码ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术、操作编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sug",  getSd_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术、操作编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术、操作名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sug",  getName_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术、操作名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术级别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_lvlsugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_lvlsug",  getId_lvlsugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术级别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术级别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_lvlsugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_lvlsug",  getSd_lvlsugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术级别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术级别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lvlsugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_lvlsug",  getName_lvlsugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术级别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_start_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_start_sug",  getDt_start_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("手术及操作开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术、操作结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_end_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end_sug",  getDt_end_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("手术、操作结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_术者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_sug",  getId_emp_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_术者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_术者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emp_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emp_sug",  getSd_emp_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_术者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_术者名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_sug",  getName_emp_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_术者名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_I助属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_asst1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_asst1",  getId_emp_asst1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_I助");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_I助编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emp_asst1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emp_asst1",  getSd_emp_asst1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_I助编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_I助名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_asst1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_asst1",  getName_emp_asst1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_I助名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_II助属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_asst2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_asst2",  getId_emp_asst2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_II助");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_II助编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emp_asst2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emp_asst2",  getSd_emp_asst2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_II助编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_II助名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_asst2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_asst2",  getName_emp_asst2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_II助名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_anesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_anes",  getId_emp_anesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 麻醉医师编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emp_anesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emp_anes",  getSd_emp_anesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉医师编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉医师名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_anesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_anes",  getName_emp_anesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉医师名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_incitpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_incitp",  getId_incitpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 切口等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_incitpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_incitp",  getSd_incitpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口等级名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_incitpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_incitp",  getName_incitpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口等级名称");
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
	private IAttrDesc getId_anestpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_anestp",  getId_anestpCDesc(tblDesc), this);
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
	private IAttrDesc getSd_anestpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_anestp",  getSd_anestpCDesc(tblDesc), this);
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
	private IAttrDesc getName_anestpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_anestp",  getName_anestpCDesc(tblDesc), this);
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
	 * 切口愈合情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_incicondiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_incicondi",  getId_incicondiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口愈合情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 切口愈合情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_incicondiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_incicondi",  getSd_incicondiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口愈合情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口愈合情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_incicondiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_incicondi",  getName_incicondiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口愈合情况名称");
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
	private IAttrDesc getSug_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sug_code",  getSug_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b7","id_sug=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSug_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sug_name",  getSug_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b7","id_sug=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLvlsug_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lvlsug_code",  getLvlsug_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_lvlsug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLvlsug_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lvlsug_name",  getLvlsug_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_lvlsug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_sug_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_sug_name",  getEmp_sug_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b2","id_emp_sug=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_sug_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_sug_code",  getEmp_sug_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b2","id_emp_sug=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_asst1_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_asst1_name",  getEmp_asst1_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b8","id_emp_asst1=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_asst1_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_asst1_code",  getEmp_asst1_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b8","id_emp_asst1=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_asst2_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_asst2_name",  getEmp_asst2_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b9","id_emp_asst2=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_asst2_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_asst2_code",  getEmp_asst2_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b9","id_emp_asst2=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_anes_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_anes_name",  getEmp_anes_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b10","id_emp_anes=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_anes_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_anes_code",  getEmp_anes_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b10","id_emp_anes=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncitp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incitp_code",  getIncitp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_incitp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncitp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incitp_name",  getIncitp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_incitp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnestp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Anestp_code",  getAnestp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_anestp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnestp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Anestp_name",  getAnestp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_anestp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncicondi_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incicondi_code",  getIncicondi_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_incicondi=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncicondi_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incicondi_name",  getIncicondi_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_incicondi=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取住院病历首页手术ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrfpsugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrfpsug");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("住院病历首页手术ID"); 
		return column;
	}
	/**
	 * 获取住院病历首页表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrfpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrfp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院病历首页"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取就诊号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊号"); 
		return column;
	}
	/**
	 * 获取患者号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者号"); 
		return column;
	}
	/**
	 * 获取手术、操作编码ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术、操作编码ID"); 
		return column;
	}
	/**
	 * 获取手术、操作编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术、操作编码"); 
		return column;
	}
	/**
	 * 获取手术、操作名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术、操作名称"); 
		return column;
	}
	/**
	 * 获取手术级别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_lvlsugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_lvlsug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术级别"); 
		return column;
	}
	/**
	 * 获取手术级别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_lvlsugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_lvlsug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术级别编码"); 
		return column;
	}
	/**
	 * 获取手术级别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_lvlsugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_lvlsug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术级别名称"); 
		return column;
	}
	/**
	 * 获取手术及操作开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_start_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_start_sug");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术及操作开始时间"); 
		return column;
	}
	/**
	 * 获取手术、操作结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_end_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end_sug");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术、操作结束时间"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_术者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_sug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_术者"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_术者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emp_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emp_sug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_术者编码"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_术者名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_sug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_术者名称"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_I助表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_asst1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_asst1");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_I助"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_I助编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emp_asst1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emp_asst1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_I助编码"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_I助名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_asst1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_asst1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_I助名称"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_II助表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_asst2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_asst2");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_II助"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_II助编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emp_asst2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emp_asst2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_II助编码"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_II助名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_asst2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_asst2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_II助名称"); 
		return column;
	}
	/**
	 * 获取麻醉医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_anesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_anes");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉医师"); 
		return column;
	}
	/**
	 * 获取麻醉医师编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emp_anesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emp_anes");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉医师编码"); 
		return column;
	}
	/**
	 * 获取麻醉医师名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_anesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_anes");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉医师名称"); 
		return column;
	}
	/**
	 * 获取切口等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_incitpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_incitp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口等级"); 
		return column;
	}
	/**
	 * 获取切口等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_incitpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_incitp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口等级编码"); 
		return column;
	}
	/**
	 * 获取切口等级名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_incitpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_incitp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口等级名称"); 
		return column;
	}
	/**
	 * 获取麻醉方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_anestpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_anestp");
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
	private IColumnDesc getSd_anestpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_anestp");
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
	private IColumnDesc getName_anestpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_anestp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式名称"); 
		return column;
	}
	/**
	 * 获取切口愈合情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_incicondiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_incicondi");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口愈合情况"); 
		return column;
	}
	/**
	 * 获取切口愈合情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_incicondiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_incicondi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口愈合情况编码"); 
		return column;
	}
	/**
	 * 获取切口愈合情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_incicondiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_incicondi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口愈合情况名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSug_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sug_code");
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
	private IColumnDesc getSug_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sug_name");
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
	private IColumnDesc getLvlsug_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lvlsug_code");
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
	private IColumnDesc getLvlsug_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lvlsug_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_sug_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_sug_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户名称"); 
		return column;
	}
	/**
	 * 获取用户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_sug_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_sug_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_asst1_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_asst1_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户名称"); 
		return column;
	}
	/**
	 * 获取用户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_asst1_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_asst1_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_asst2_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_asst2_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户名称"); 
		return column;
	}
	/**
	 * 获取用户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_asst2_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_asst2_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_anes_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_anes_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户名称"); 
		return column;
	}
	/**
	 * 获取用户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_anes_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_anes_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIncitp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incitp_code");
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
	private IColumnDesc getIncitp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incitp_name");
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
	private IColumnDesc getAnestp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Anestp_code");
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
	private IColumnDesc getAnestp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Anestp_name");
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
	private IColumnDesc getIncicondi_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incicondi_code");
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
	private IColumnDesc getIncicondi_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incicondi_name");
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
