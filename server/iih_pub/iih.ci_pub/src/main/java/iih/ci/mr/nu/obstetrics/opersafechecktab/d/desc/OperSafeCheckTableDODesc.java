
package iih.ci.mr.nu.obstetrics.opersafechecktab.d.desc;

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
 * 手术安全核查表 DO 元数据信息
 */
public class OperSafeCheckTableDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.obstetrics.opersafechecktab.d.OperSafeCheckTableDO";
	public static final String CLASS_DISPALYNAME = "手术安全核查表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mr_nu_opersafe";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_opersafe";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OperSafeCheckTableDODesc(){
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
		this.setKeyDesc(getId_opersafeADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_opersafeADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getId_dep_phyADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_anesthesiaADesc(tblDesc));
		this.add(getSd_anesthesiaADesc(tblDesc));
		this.add(getOper_methodADesc(tblDesc));
		this.add(getId_emp_operADesc(tblDesc));
		this.add(getDt_operADesc(tblDesc));
		this.add(getId_groupADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getEu_patinfobeforeanaADesc(tblDesc));
		this.add(getEu_opermodebeforeanaADesc(tblDesc));
		this.add(getEu_ssbwybsqADesc(tblDesc));
		this.add(getEu_sszqtyADesc(tblDesc));
		this.add(getEu_mzzqtyADesc(tblDesc));
		this.add(getEu_mzfsqrADesc(tblDesc));
		this.add(getEu_mzsbaqjcADesc(tblDesc));
		this.add(getEu_pfsfwzADesc(tblDesc));
		this.add(getEu_sqpfzbzqADesc(tblDesc));
		this.add(getEu_jmtdjlwcADesc(tblDesc));
		this.add(getEu_hzsfygmsADesc(tblDesc));
		this.add(getEu_kjywpsjgADesc(tblDesc));
		this.add(getEu_sqbxADesc(tblDesc));
		this.add(getId_item_preADesc(tblDesc));
		this.add(getSd_item_preADesc(tblDesc));
		this.add(getBf_ana_otherADesc(tblDesc));
		this.add(getEu_xmxbnlADesc(tblDesc));
		this.add(getEu_sqssfsqrADesc(tblDesc));
		this.add(getEu_sqssbwybADesc(tblDesc));
		this.add(getId_ssyscsADesc(tblDesc));
		this.add(getSd_ssyscsADesc(tblDesc));
		this.add(getId_mzyscsADesc(tblDesc));
		this.add(getSd_mzyscsADesc(tblDesc));
		this.add(getId_sshscsADesc(tblDesc));
		this.add(getSd_sshscsADesc(tblDesc));
		this.add(getEu_sfxyxgyxADesc(tblDesc));
		this.add(getBf_oper_otherADesc(tblDesc));
		this.add(getEu_shhzxmdxbdADesc(tblDesc));
		this.add(getEu_sjssfsqrADesc(tblDesc));
		this.add(getEu_ssyydsxdADesc(tblDesc));
		this.add(getEu_ssywqdzqADesc(tblDesc));
		this.add(getEu_ssbbqrADesc(tblDesc));
		this.add(getEu_shpfsfwzADesc(tblDesc));
		this.add(getId_gcglADesc(tblDesc));
		this.add(getSd_gcglADesc(tblDesc));
		this.add(getId_hzqxADesc(tblDesc));
		this.add(getSd_hzqxADesc(tblDesc));
		this.add(getPipe_otherADesc(tblDesc));
		this.add(getPat_lev_otherADesc(tblDesc));
		this.add(getId_sign_docADesc(tblDesc));
		this.add(getId_sign_anaerADesc(tblDesc));
		this.add(getId_sign_nurADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getName_anesthesiaADesc(tblDesc));
		this.add(getName_emp_operADesc(tblDesc));
		this.add(getName_item_preADesc(tblDesc));
		this.add(getName_ssyscsADesc(tblDesc));
		this.add(getName_mzyscsADesc(tblDesc));
		this.add(getName_sshscsADesc(tblDesc));
		this.add(getName_gcglADesc(tblDesc));
		this.add(getName_hzqxADesc(tblDesc));
		this.add(getName_sign_docADesc(tblDesc));
		this.add(getName_sign_anaerADesc(tblDesc));
		this.add(getName_sign_nurADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_opersafeCDesc(tblDesc));
		tblDesc.add(getId_opersafeCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getId_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getSd_sexCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_anesthesiaCDesc(tblDesc));
		tblDesc.add(getSd_anesthesiaCDesc(tblDesc));
		tblDesc.add(getOper_methodCDesc(tblDesc));
		tblDesc.add(getId_emp_operCDesc(tblDesc));
		tblDesc.add(getDt_operCDesc(tblDesc));
		tblDesc.add(getId_groupCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getEu_patinfobeforeanaCDesc(tblDesc));
		tblDesc.add(getEu_opermodebeforeanaCDesc(tblDesc));
		tblDesc.add(getEu_ssbwybsqCDesc(tblDesc));
		tblDesc.add(getEu_sszqtyCDesc(tblDesc));
		tblDesc.add(getEu_mzzqtyCDesc(tblDesc));
		tblDesc.add(getEu_mzfsqrCDesc(tblDesc));
		tblDesc.add(getEu_mzsbaqjcCDesc(tblDesc));
		tblDesc.add(getEu_pfsfwzCDesc(tblDesc));
		tblDesc.add(getEu_sqpfzbzqCDesc(tblDesc));
		tblDesc.add(getEu_jmtdjlwcCDesc(tblDesc));
		tblDesc.add(getEu_hzsfygmsCDesc(tblDesc));
		tblDesc.add(getEu_kjywpsjgCDesc(tblDesc));
		tblDesc.add(getEu_sqbxCDesc(tblDesc));
		tblDesc.add(getId_item_preCDesc(tblDesc));
		tblDesc.add(getSd_item_preCDesc(tblDesc));
		tblDesc.add(getBf_ana_otherCDesc(tblDesc));
		tblDesc.add(getEu_xmxbnlCDesc(tblDesc));
		tblDesc.add(getEu_sqssfsqrCDesc(tblDesc));
		tblDesc.add(getEu_sqssbwybCDesc(tblDesc));
		tblDesc.add(getId_ssyscsCDesc(tblDesc));
		tblDesc.add(getSd_ssyscsCDesc(tblDesc));
		tblDesc.add(getId_mzyscsCDesc(tblDesc));
		tblDesc.add(getSd_mzyscsCDesc(tblDesc));
		tblDesc.add(getId_sshscsCDesc(tblDesc));
		tblDesc.add(getSd_sshscsCDesc(tblDesc));
		tblDesc.add(getEu_sfxyxgyxCDesc(tblDesc));
		tblDesc.add(getBf_oper_otherCDesc(tblDesc));
		tblDesc.add(getEu_shhzxmdxbdCDesc(tblDesc));
		tblDesc.add(getEu_sjssfsqrCDesc(tblDesc));
		tblDesc.add(getEu_ssyydsxdCDesc(tblDesc));
		tblDesc.add(getEu_ssywqdzqCDesc(tblDesc));
		tblDesc.add(getEu_ssbbqrCDesc(tblDesc));
		tblDesc.add(getEu_shpfsfwzCDesc(tblDesc));
		tblDesc.add(getId_gcglCDesc(tblDesc));
		tblDesc.add(getSd_gcglCDesc(tblDesc));
		tblDesc.add(getId_hzqxCDesc(tblDesc));
		tblDesc.add(getSd_hzqxCDesc(tblDesc));
		tblDesc.add(getPipe_otherCDesc(tblDesc));
		tblDesc.add(getPat_lev_otherCDesc(tblDesc));
		tblDesc.add(getId_sign_docCDesc(tblDesc));
		tblDesc.add(getId_sign_anaerCDesc(tblDesc));
		tblDesc.add(getId_sign_nurCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 手术安全核查ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_opersafeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_opersafe",  getId_opersafeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术安全核查ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 就诊编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_entp",  getCode_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科别ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_phy",  getId_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科别ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phy",  getName_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex",  getId_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex",  getSd_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age",  getAgeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病案号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉方式ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_anesthesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_anesthesia",  getId_anesthesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式ID");
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
	private IAttrDesc getSd_anesthesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_anesthesia",  getSd_anesthesiaCDesc(tblDesc), this);
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
	 * 手术方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_methodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_method",  getOper_methodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_oper",  getId_emp_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_oper",  getDt_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("手术日期");
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
	private IAttrDesc getId_groupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_group",  getId_groupCDesc(tblDesc), this);
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
	 * 患者姓名丶性别丶年龄正确(麻醉前)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_patinfobeforeanaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_patinfobeforeana",  getEu_patinfobeforeanaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("患者姓名丶性别丶年龄正确(麻醉前)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术方式确认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_opermodebeforeanaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_opermodebeforeana",  getEu_opermodebeforeanaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("手术方式确认");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位与标识确认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ssbwybsqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ssbwybsq",  getEu_ssbwybsqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("手术部位与标识确认");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术知情同意属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_sszqtyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_sszqty",  getEu_sszqtyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("手术知情同意");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉知情同意属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_mzzqtyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_mzzqty",  getEu_mzzqtyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("麻醉知情同意");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉方式确认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_mzfsqrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_mzfsqr",  getEu_mzfsqrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("麻醉方式确认");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉设备安全检查完成属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_mzsbaqjcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_mzsbaqjc",  getEu_mzsbaqjcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("麻醉设备安全检查完成");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤是否完整属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_pfsfwzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_pfsfwz",  getEu_pfsfwzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("皮肤是否完整");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前皮肤准备正确属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_sqpfzbzqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_sqpfzbzq",  getEu_sqpfzbzqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术前皮肤准备正确");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉通道建立完成属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_jmtdjlwcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_jmtdjlwc",  getEu_jmtdjlwcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("静脉通道建立完成");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者是否有过敏史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_hzsfygmsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_hzsfygms",  getEu_hzsfygmsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("患者是否有过敏史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗菌药物皮试结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_kjywpsjgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_kjywpsjg",  getEu_kjywpsjgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("抗菌药物皮试结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前备血属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_sqbxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_sqbx",  getEu_sqbxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术前备血");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前物品准备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_item_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_item_pre",  getId_item_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前物品准备");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前物品准备编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_item_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_item_pre",  getSd_item_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前物品准备编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * （麻醉实施前）其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBf_ana_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bf_ana_other",  getBf_ana_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("（麻醉实施前）其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名丶性别丶年龄正确属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_xmxbnlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_xmxbnl",  getEu_xmxbnlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("患者姓名丶性别丶年龄正确");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * （术前）手术方式确认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_sqssfsqrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_sqssfsqr",  getEu_sqssfsqrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("（术前）手术方式确认");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * （术前）手术部位与标识确认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_sqssbwybADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_sqssbwyb",  getEu_sqssbwybCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("（术前）手术部位与标识确认");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术医师陈述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ssyscsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ssyscs",  getId_ssyscsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术医师陈述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术医师陈述编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ssyscsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ssyscs",  getSd_ssyscsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术医师陈述编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉医师陈述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mzyscsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mzyscs",  getId_mzyscsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉医师陈述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 麻醉医师陈述编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mzyscsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mzyscs",  getSd_mzyscsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉医师陈述编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术护士陈述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sshscsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sshscs",  getId_sshscsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术护士陈述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术护士陈述编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sshscsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sshscs",  getSd_sshscsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术护士陈述编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需要相关影像资料属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_sfxyxgyxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_sfxyxgyx",  getEu_sfxyxgyxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否需要相关影像资料");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * （术前）其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBf_oper_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bf_oper_other",  getBf_oper_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("（术前）其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名丶性别丶年龄正确（术后）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_shhzxmdxbdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_shhzxmdxbd",  getEu_shhzxmdxbdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("患者姓名丶性别丶年龄正确（术后）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际手术方式确认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_sjssfsqrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_sjssfsqr",  getEu_sjssfsqrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("实际手术方式确认");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术用药丶输血的核查属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ssyydsxdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ssyydsxd",  getEu_ssyydsxdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("手术用药丶输血的核查");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术用物清点正确属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ssywqdzqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ssywqdzq",  getEu_ssywqdzqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("手术用物清点正确");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术标本确认属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ssbbqrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ssbbqr",  getEu_ssbbqrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("手术标本确认");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * （术后）皮肤是否完整属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_shpfsfwzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_shpfsfwz",  getEu_shpfsfwzCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("（术后）皮肤是否完整");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 各种管路属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_gcglADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_gcgl",  getId_gcglCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("各种管路");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 各种管路编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_gcglADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_gcgl",  getSd_gcglCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("各种管路编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者去向属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hzqxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hzqx",  getId_hzqxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者去向");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者去向编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hzqxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hzqx",  getSd_hzqxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者去向编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * （管路）其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPipe_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pipe_other",  getPipe_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("（管路）其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * （患者离开前）其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_lev_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_lev_other",  getPat_lev_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("（患者离开前）其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术医师签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sign_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign_doc",  getId_sign_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术医师签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 麻醉医师签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sign_anaerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign_anaer",  getId_sign_anaerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉医师签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术室护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sign_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign_nur",  getId_sign_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术室护士签名");
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
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b14","id_ent=id_ent","name_pat"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_anesthesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_anesthesia",  getName_anesthesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_anesthesia=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_oper",  getName_emp_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b9","id_emp_oper=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前物品准备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_item_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_item_pre",  getName_item_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前物品准备");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_item_pre=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术医师陈述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ssyscsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ssyscs",  getName_ssyscsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术医师陈述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_ssyscs=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉医师陈述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mzyscsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mzyscs",  getName_mzyscsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉医师陈述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_mzyscs=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术护士陈述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sshscsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sshscs",  getName_sshscsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术护士陈述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_sshscs=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 各种管路属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_gcglADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_gcgl",  getName_gcglCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("各种管路");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_gcgl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者去向属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hzqxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hzqx",  getName_hzqxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者去向");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_hzqx=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术医师签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sign_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign_doc",  getName_sign_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术医师签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b15","id_sign_doc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉医师签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sign_anaerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign_anaer",  getName_sign_anaerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉医师签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b16","id_sign_anaer=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术室护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sign_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign_nur",  getName_sign_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术室护士签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b17","id_sign_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取手术安全核查ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_opersafeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_opersafe");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术安全核查ID"); 
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
	 * 获取就诊编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_entp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊编码"); 
		return column;
	}
	/**
	 * 获取科别ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科别ID"); 
		return column;
	}
	/**
	 * 获取科别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科别"); 
		return column;
	}
	/**
	 * 获取患者性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者性别"); 
		return column;
	}
	/**
	 * 获取患者性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者性别编码"); 
		return column;
	}
	/**
	 * 获取患者年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者年龄"); 
		return column;
	}
	/**
	 * 获取病案号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案号"); 
		return column;
	}
	/**
	 * 获取麻醉方式ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_anesthesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_anesthesia");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式ID"); 
		return column;
	}
	/**
	 * 获取麻醉方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_anesthesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_anesthesia");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式编码"); 
		return column;
	}
	/**
	 * 获取手术方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_methodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_method");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术方式"); 
		return column;
	}
	/**
	 * 获取术者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术者"); 
		return column;
	}
	/**
	 * 获取手术日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_oper");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术日期"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_groupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_group");
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
	 * 获取患者姓名丶性别丶年龄正确(麻醉前)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_patinfobeforeanaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_patinfobeforeana");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("患者姓名丶性别丶年龄正确(麻醉前)"); 
		return column;
	}
	/**
	 * 获取手术方式确认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_opermodebeforeanaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_opermodebeforeana");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("手术方式确认"); 
		return column;
	}
	/**
	 * 获取手术部位与标识确认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ssbwybsqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ssbwybsq");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("手术部位与标识确认"); 
		return column;
	}
	/**
	 * 获取手术知情同意表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_sszqtyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_sszqty");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("手术知情同意"); 
		return column;
	}
	/**
	 * 获取麻醉知情同意表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_mzzqtyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_mzzqty");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("麻醉知情同意"); 
		return column;
	}
	/**
	 * 获取麻醉方式确认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_mzfsqrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_mzfsqr");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("麻醉方式确认"); 
		return column;
	}
	/**
	 * 获取麻醉设备安全检查完成表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_mzsbaqjcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_mzsbaqjc");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("麻醉设备安全检查完成"); 
		return column;
	}
	/**
	 * 获取皮肤是否完整表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_pfsfwzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_pfsfwz");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("皮肤是否完整"); 
		return column;
	}
	/**
	 * 获取术前皮肤准备正确表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_sqpfzbzqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_sqpfzbzq");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术前皮肤准备正确"); 
		return column;
	}
	/**
	 * 获取静脉通道建立完成表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_jmtdjlwcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_jmtdjlwc");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("静脉通道建立完成"); 
		return column;
	}
	/**
	 * 获取患者是否有过敏史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_hzsfygmsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_hzsfygms");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("患者是否有过敏史"); 
		return column;
	}
	/**
	 * 获取抗菌药物皮试结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_kjywpsjgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_kjywpsjg");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("抗菌药物皮试结果"); 
		return column;
	}
	/**
	 * 获取术前备血表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_sqbxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_sqbx");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术前备血"); 
		return column;
	}
	/**
	 * 获取术前物品准备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_item_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_item_pre");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前物品准备"); 
		return column;
	}
	/**
	 * 获取术前物品准备编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_item_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_item_pre");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前物品准备编码"); 
		return column;
	}
	/**
	 * 获取（麻醉实施前）其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBf_ana_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bf_ana_other");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("（麻醉实施前）其他"); 
		return column;
	}
	/**
	 * 获取患者姓名丶性别丶年龄正确表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_xmxbnlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_xmxbnl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("患者姓名丶性别丶年龄正确"); 
		return column;
	}
	/**
	 * 获取（术前）手术方式确认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_sqssfsqrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_sqssfsqr");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("（术前）手术方式确认"); 
		return column;
	}
	/**
	 * 获取（术前）手术部位与标识确认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_sqssbwybCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_sqssbwyb");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("（术前）手术部位与标识确认"); 
		return column;
	}
	/**
	 * 获取手术医师陈述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ssyscsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ssyscs");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术医师陈述"); 
		return column;
	}
	/**
	 * 获取手术医师陈述编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ssyscsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ssyscs");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术医师陈述编码"); 
		return column;
	}
	/**
	 * 获取麻醉医师陈述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mzyscsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mzyscs");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉医师陈述"); 
		return column;
	}
	/**
	 * 获取麻醉医师陈述编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mzyscsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mzyscs");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉医师陈述编码"); 
		return column;
	}
	/**
	 * 获取手术护士陈述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sshscsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sshscs");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术护士陈述"); 
		return column;
	}
	/**
	 * 获取手术护士陈述编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sshscsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sshscs");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术护士陈述编码"); 
		return column;
	}
	/**
	 * 获取是否需要相关影像资料表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_sfxyxgyxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_sfxyxgyx");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否需要相关影像资料"); 
		return column;
	}
	/**
	 * 获取（术前）其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBf_oper_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bf_oper_other");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("（术前）其他"); 
		return column;
	}
	/**
	 * 获取患者姓名丶性别丶年龄正确（术后）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_shhzxmdxbdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_shhzxmdxbd");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("患者姓名丶性别丶年龄正确（术后）"); 
		return column;
	}
	/**
	 * 获取实际手术方式确认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_sjssfsqrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_sjssfsqr");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("实际手术方式确认"); 
		return column;
	}
	/**
	 * 获取手术用药丶输血的核查表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ssyydsxdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ssyydsxd");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("手术用药丶输血的核查"); 
		return column;
	}
	/**
	 * 获取手术用物清点正确表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ssywqdzqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ssywqdzq");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("手术用物清点正确"); 
		return column;
	}
	/**
	 * 获取手术标本确认表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ssbbqrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ssbbqr");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("手术标本确认"); 
		return column;
	}
	/**
	 * 获取（术后）皮肤是否完整表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_shpfsfwzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_shpfsfwz");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("（术后）皮肤是否完整"); 
		return column;
	}
	/**
	 * 获取各种管路表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_gcglCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_gcgl");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("各种管路"); 
		return column;
	}
	/**
	 * 获取各种管路编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_gcglCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_gcgl");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("各种管路编码"); 
		return column;
	}
	/**
	 * 获取患者去向表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hzqxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hzqx");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者去向"); 
		return column;
	}
	/**
	 * 获取患者去向编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hzqxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hzqx");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者去向编码"); 
		return column;
	}
	/**
	 * 获取（管路）其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPipe_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pipe_other");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("（管路）其他"); 
		return column;
	}
	/**
	 * 获取（患者离开前）其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_lev_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_lev_other");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("（患者离开前）其他"); 
		return column;
	}
	/**
	 * 获取手术医师签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sign_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign_doc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术医师签名"); 
		return column;
	}
	/**
	 * 获取麻醉医师签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sign_anaerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign_anaer");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉医师签名"); 
		return column;
	}
	/**
	 * 获取手术室护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sign_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术室护士签名"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_anesthesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_anesthesia");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取术者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_oper");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术者"); 
		return column;
	}
	/**
	 * 获取术前物品准备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_item_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_item_pre");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前物品准备"); 
		return column;
	}
	/**
	 * 获取手术医师陈述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ssyscsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ssyscs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术医师陈述"); 
		return column;
	}
	/**
	 * 获取麻醉医师陈述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mzyscsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mzyscs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉医师陈述"); 
		return column;
	}
	/**
	 * 获取手术护士陈述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sshscsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sshscs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术护士陈述"); 
		return column;
	}
	/**
	 * 获取各种管路表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_gcglCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_gcgl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("各种管路"); 
		return column;
	}
	/**
	 * 获取患者去向表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hzqxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hzqx");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者去向"); 
		return column;
	}
	/**
	 * 获取手术医师签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sign_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign_doc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术医师签名"); 
		return column;
	}
	/**
	 * 获取麻醉医师签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sign_anaerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign_anaer");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉医师签名"); 
		return column;
	}
	/**
	 * 获取手术室护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sign_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术室护士签名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_group");
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
