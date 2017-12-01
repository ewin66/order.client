
package iih.ci.mr.nu.obstetrics.opspathandover.d.desc;

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
 * 手术病人情况交接登记单 DO 元数据信息
 */
public class OpsPatHandoverDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.obstetrics.opspathandover.d.OpsPatHandoverDO";
	public static final String CLASS_DISPALYNAME = "手术病人情况交接登记单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mr_nu_opspathandover";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_opspathandover";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OpsPatHandoverDODesc(){
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
		this.setKeyDesc(getId_opspathandoverADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_opspathandoverADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getDt_createADesc(tblDesc));
		this.add(getDt_acceptADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getDt_inroomADesc(tblDesc));
		this.add(getName_operationADesc(tblDesc));
		this.add(getEu_sqyyADesc(tblDesc));
		this.add(getId_skin_conADesc(tblDesc));
		this.add(getSd_skin_conADesc(tblDesc));
		this.add(getEu_jzrsADesc(tblDesc));
		this.add(getId_con_stateinADesc(tblDesc));
		this.add(getSd_con_stateinADesc(tblDesc));
		this.add(getEu_zthdzcADesc(tblDesc));
		this.add(getEu_grssADesc(tblDesc));
		this.add(getEu_blADesc(tblDesc));
		this.add(getEu_jmtlADesc(tblDesc));
		this.add(getEu_lzdnADesc(tblDesc));
		this.add(getEu_pfqkADesc(tblDesc));
		this.add(getDes_skin_inADesc(tblDesc));
		this.add(getRemarks_zrADesc(tblDesc));
		this.add(getId_emp_nur_inchkADesc(tblDesc));
		this.add(getId_emp_opr_inchkADesc(tblDesc));
		this.add(getDt_outroomADesc(tblDesc));
		this.add(getId_liquidADesc(tblDesc));
		this.add(getSd_liquidADesc(tblDesc));
		this.add(getId_con_stateoutADesc(tblDesc));
		this.add(getSd_con_stateoutADesc(tblDesc));
		this.add(getId_breath_typeADesc(tblDesc));
		this.add(getSd_breath_typeADesc(tblDesc));
		this.add(getEu_wzjmtcADesc(tblDesc));
		this.add(getEu_lzdngctADesc(tblDesc));
		this.add(getEu_zxjmADesc(tblDesc));
		this.add(getEu_qkylADesc(tblDesc));
		this.add(getId_infusion_bloodADesc(tblDesc));
		this.add(getSd_infusion_bloodADesc(tblDesc));
		this.add(getId_blood_proADesc(tblDesc));
		this.add(getSd_blood_proADesc(tblDesc));
		this.add(getEu_hxypzsqkADesc(tblDesc));
		this.add(getEu_pfqjADesc(tblDesc));
		this.add(getEu_shjjblADesc(tblDesc));
		this.add(getEu_shjjpfqkADesc(tblDesc));
		this.add(getDes_skin_outADesc(tblDesc));
		this.add(getRemark_jjADesc(tblDesc));
		this.add(getId_emp_nur_outchkADesc(tblDesc));
		this.add(getId_emp_opr_outchkADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getDt_birth_patADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_skin_conADesc(tblDesc));
		this.add(getName_con_stateinADesc(tblDesc));
		this.add(getName_nur_inchkADesc(tblDesc));
		this.add(getName_opr_inchkADesc(tblDesc));
		this.add(getName_liquidADesc(tblDesc));
		this.add(getName_con_stateoutADesc(tblDesc));
		this.add(getName_breath_typeADesc(tblDesc));
		this.add(getName_infusion_bloodADesc(tblDesc));
		this.add(getName_blood_proADesc(tblDesc));
		this.add(getName_nur_outchkADesc(tblDesc));
		this.add(getName_opr_outchkADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_opspathandoverCDesc(tblDesc));
		tblDesc.add(getId_opspathandoverCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getDt_createCDesc(tblDesc));
		tblDesc.add(getDt_acceptCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getDt_inroomCDesc(tblDesc));
		tblDesc.add(getName_operationCDesc(tblDesc));
		tblDesc.add(getEu_sqyyCDesc(tblDesc));
		tblDesc.add(getId_skin_conCDesc(tblDesc));
		tblDesc.add(getSd_skin_conCDesc(tblDesc));
		tblDesc.add(getEu_jzrsCDesc(tblDesc));
		tblDesc.add(getId_con_stateinCDesc(tblDesc));
		tblDesc.add(getSd_con_stateinCDesc(tblDesc));
		tblDesc.add(getEu_zthdzcCDesc(tblDesc));
		tblDesc.add(getEu_grssCDesc(tblDesc));
		tblDesc.add(getEu_blCDesc(tblDesc));
		tblDesc.add(getEu_jmtlCDesc(tblDesc));
		tblDesc.add(getEu_lzdnCDesc(tblDesc));
		tblDesc.add(getEu_pfqkCDesc(tblDesc));
		tblDesc.add(getDes_skin_inCDesc(tblDesc));
		tblDesc.add(getRemarks_zrCDesc(tblDesc));
		tblDesc.add(getId_emp_nur_inchkCDesc(tblDesc));
		tblDesc.add(getId_emp_opr_inchkCDesc(tblDesc));
		tblDesc.add(getDt_outroomCDesc(tblDesc));
		tblDesc.add(getId_liquidCDesc(tblDesc));
		tblDesc.add(getSd_liquidCDesc(tblDesc));
		tblDesc.add(getId_con_stateoutCDesc(tblDesc));
		tblDesc.add(getSd_con_stateoutCDesc(tblDesc));
		tblDesc.add(getId_breath_typeCDesc(tblDesc));
		tblDesc.add(getSd_breath_typeCDesc(tblDesc));
		tblDesc.add(getEu_wzjmtcCDesc(tblDesc));
		tblDesc.add(getEu_lzdngctCDesc(tblDesc));
		tblDesc.add(getEu_zxjmCDesc(tblDesc));
		tblDesc.add(getEu_qkylCDesc(tblDesc));
		tblDesc.add(getId_infusion_bloodCDesc(tblDesc));
		tblDesc.add(getSd_infusion_bloodCDesc(tblDesc));
		tblDesc.add(getId_blood_proCDesc(tblDesc));
		tblDesc.add(getSd_blood_proCDesc(tblDesc));
		tblDesc.add(getEu_hxypzsqkCDesc(tblDesc));
		tblDesc.add(getEu_pfqjCDesc(tblDesc));
		tblDesc.add(getEu_shjjblCDesc(tblDesc));
		tblDesc.add(getEu_shjjpfqkCDesc(tblDesc));
		tblDesc.add(getDes_skin_outCDesc(tblDesc));
		tblDesc.add(getRemark_jjCDesc(tblDesc));
		tblDesc.add(getId_emp_nur_outchkCDesc(tblDesc));
		tblDesc.add(getId_emp_opr_outchkCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 手术病人交接单主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_opspathandoverADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_opspathandover",  getId_opspathandoverCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术病人交接单主键标识");
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
		attrDesc.setRefType(true);
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
	 * 登记日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_create",  getDt_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("登记日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接病人时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_acceptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_accept",  getDt_acceptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("接病人时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 床位号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bed",  getName_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床位号");
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
	 * 入室时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_inroomADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_inroom",  getDt_inroomCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("入室时间");
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
	private IAttrDesc getName_operationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_operation",  getName_operationCDesc(tblDesc), this);
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
	 * 术前用药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_sqyyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_sqyy",  getEu_sqyyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术前用药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备皮情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skin_conADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin_con",  getId_skin_conCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备皮情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 备皮情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skin_conADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin_con",  getSd_skin_conCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备皮情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊入室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_jzrsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_jzrs",  getEu_jzrsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("急诊入室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入室意识状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_con_stateinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_con_statein",  getId_con_stateinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入室意识状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前意识状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_con_stateinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_con_statein",  getSd_con_stateinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前意识状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肢体活动正常属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_zthdzcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_zthdzc",  getEu_zthdzcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("肢体活动正常");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_grssADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_grss",  getEu_grssCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("感染手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病历属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_blADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_bl",  getEu_blCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("病历");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉通路属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_jmtlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_jmtl",  getEu_jmtlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("静脉通路");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 留置导尿属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_lzdnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_lzdn",  getEu_lzdnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("留置导尿");
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
	private IAttrDesc getEu_pfqkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_pfqk",  getEu_pfqkCDesc(tblDesc), this);
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
	 * 皮肤情况备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_skin_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_skin_in",  getDes_skin_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤情况备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * (转入)备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRemarks_zrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Remarks_zr",  getRemarks_zrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("(转入)备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入室病区核对护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_nur_inchkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_nur_inchk",  getId_emp_nur_inchkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入室病区核对护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入室手术室核对护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_opr_inchkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_opr_inchk",  getId_emp_opr_inchkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入室手术室核对护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出室时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_outroomADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_outroom",  getDt_outroomCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("出室时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后液体属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_liquidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_liquid",  getId_liquidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后液体");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后液体档案编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_liquidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_liquid",  getSd_liquidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后液体档案编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交接意识状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_con_stateoutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_con_stateout",  getId_con_stateoutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交接意识状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后意识状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_con_stateoutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_con_stateout",  getSd_con_stateoutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后意识状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_breath_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_breath_type",  getId_breath_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 呼吸方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_breath_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_breath_type",  getSd_breath_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 外周静脉通畅属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_wzjmtcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_wzjmtc",  getEu_wzjmtcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("外周静脉通畅");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 留置导尿管畅通属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_lzdngctADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_lzdngct",  getEu_lzdngctCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("留置导尿管畅通");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中心静脉属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_zxjmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_zxjm",  getEu_zxjmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("中心静脉");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口引流属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_qkylADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_qkyl",  getEu_qkylCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("切口引流");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术输血属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infusion_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infusion_blood",  getId_infusion_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术输血");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术中输血编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_infusion_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infusion_blood",  getSd_infusion_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中输血编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转出血制品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blood_proADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blood_pro",  getId_blood_proCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转出血制品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 转出血制品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_blood_proADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_blood_pro",  getSd_blood_proCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转出血制品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 化学药品灼伤情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_hxypzsqkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_hxypzsqk",  getEu_hxypzsqkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("化学药品灼伤情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤清洁属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_pfqjADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_pfqj",  getEu_pfqjCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("皮肤清洁");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后交接病历属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_shjjblADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_shjjbl",  getEu_shjjblCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后交接病历");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后交接皮肤情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_shjjpfqkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_shjjpfqk",  getEu_shjjpfqkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后交接皮肤情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后交接皮肤情况备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_skin_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_skin_out",  getDes_skin_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后交接皮肤情况备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * （交接）备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRemark_jjADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Remark_jj",  getRemark_jjCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("（交接）备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出室手术室核对护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_nur_outchkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_nur_outchk",  getId_emp_nur_outchkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出室手术室核对护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出室病区核对护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_opr_outchkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_opr_outchk",  getId_emp_opr_outchkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出室病区核对护士");
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
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b8","id_ent=id_ent","name_pat"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者出生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_birth_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_birth_pat",  getDt_birth_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("患者出生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b8","id_ent=id_ent","dt_birth_pat"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院病案编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病案编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b9","id_pat=id_pat","code_amr_ip"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b17","id_dep_nur=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备皮情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skin_conADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skin_con",  getName_skin_conCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备皮情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_skin_con=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_con_stateinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_con_statein",  getName_con_stateinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_con_statein=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入室病区护士核对签字属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nur_inchkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur_inchk",  getName_nur_inchkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入室病区护士核对签字");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b2","id_emp_nur_inchk=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入室手术室护士核对签字属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_opr_inchkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_opr_inchk",  getName_opr_inchkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入室手术室护士核对签字");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b3","id_emp_opr_inchk=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后液体属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_liquidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_liquid",  getName_liquidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后液体");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_liquid=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后意识状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_con_stateoutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_con_stateout",  getName_con_stateoutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后意识状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_con_stateout=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_breath_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_breath_type",  getName_breath_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_breath_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术中输血属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infusion_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infusion_blood",  getName_infusion_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术中输血");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_infusion_blood=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转出血制品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_blood_proADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_blood_pro",  getName_blood_proCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转出血制品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_blood_pro=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出室病区护士核对签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nur_outchkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur_outchk",  getName_nur_outchkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出室病区护士核对签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","id_emp_nur_outchk=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出室手术室护士核对签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_opr_outchkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_opr_outchk",  getName_opr_outchkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出室手术室护士核对签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b5","id_emp_opr_outchk=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取手术病人交接单主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_opspathandoverCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_opspathandover");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术病人交接单主键标识"); 
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
		column.setLength(20);
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
	 * 获取登记日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_create");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("登记日期"); 
		return column;
	}
	/**
	 * 获取接病人时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_acceptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_accept");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("接病人时间"); 
		return column;
	}
	/**
	 * 获取病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区"); 
		return column;
	}
	/**
	 * 获取床位号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床位号"); 
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
	 * 获取入室时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_inroomCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_inroom");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入室时间"); 
		return column;
	}
	/**
	 * 获取手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_operationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_operation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术名称"); 
		return column;
	}
	/**
	 * 获取术前用药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_sqyyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_sqyy");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术前用药"); 
		return column;
	}
	/**
	 * 获取备皮情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skin_conCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin_con");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备皮情况"); 
		return column;
	}
	/**
	 * 获取备皮情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skin_conCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin_con");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备皮情况编码"); 
		return column;
	}
	/**
	 * 获取急诊入室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_jzrsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_jzrs");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("急诊入室"); 
		return column;
	}
	/**
	 * 获取入室意识状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_con_stateinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_con_statein");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入室意识状态"); 
		return column;
	}
	/**
	 * 获取术前意识状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_con_stateinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_con_statein");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前意识状态编码"); 
		return column;
	}
	/**
	 * 获取肢体活动正常表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_zthdzcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_zthdzc");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("肢体活动正常"); 
		return column;
	}
	/**
	 * 获取感染手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_grssCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_grss");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("感染手术"); 
		return column;
	}
	/**
	 * 获取病历表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_blCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_bl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("病历"); 
		return column;
	}
	/**
	 * 获取静脉通路表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_jmtlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_jmtl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("静脉通路"); 
		return column;
	}
	/**
	 * 获取留置导尿表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_lzdnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_lzdn");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("留置导尿"); 
		return column;
	}
	/**
	 * 获取皮肤情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_pfqkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_pfqk");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("皮肤情况"); 
		return column;
	}
	/**
	 * 获取皮肤情况备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_skin_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_skin_in");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤情况备注"); 
		return column;
	}
	/**
	 * 获取(转入)备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRemarks_zrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Remarks_zr");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("(转入)备注"); 
		return column;
	}
	/**
	 * 获取入室病区核对护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_nur_inchkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_nur_inchk");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入室病区核对护士"); 
		return column;
	}
	/**
	 * 获取入室手术室核对护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_opr_inchkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_opr_inchk");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入室手术室核对护士"); 
		return column;
	}
	/**
	 * 获取出室时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_outroomCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_outroom");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出室时间"); 
		return column;
	}
	/**
	 * 获取术后液体表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_liquidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_liquid");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后液体"); 
		return column;
	}
	/**
	 * 获取术后液体档案编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_liquidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_liquid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后液体档案编码"); 
		return column;
	}
	/**
	 * 获取交接意识状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_con_stateoutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_con_stateout");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交接意识状态"); 
		return column;
	}
	/**
	 * 获取术后意识状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_con_stateoutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_con_stateout");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后意识状态编码"); 
		return column;
	}
	/**
	 * 获取呼吸方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_breath_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_breath_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸方式"); 
		return column;
	}
	/**
	 * 获取呼吸方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_breath_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_breath_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸方式编码"); 
		return column;
	}
	/**
	 * 获取外周静脉通畅表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_wzjmtcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_wzjmtc");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("外周静脉通畅"); 
		return column;
	}
	/**
	 * 获取留置导尿管畅通表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_lzdngctCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_lzdngct");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("留置导尿管畅通"); 
		return column;
	}
	/**
	 * 获取中心静脉表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_zxjmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_zxjm");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("中心静脉"); 
		return column;
	}
	/**
	 * 获取切口引流表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_qkylCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_qkyl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("切口引流"); 
		return column;
	}
	/**
	 * 获取手术输血表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infusion_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infusion_blood");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术输血"); 
		return column;
	}
	/**
	 * 获取术中输血编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_infusion_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infusion_blood");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中输血编码"); 
		return column;
	}
	/**
	 * 获取转出血制品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blood_proCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blood_pro");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转出血制品"); 
		return column;
	}
	/**
	 * 获取转出血制品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_blood_proCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_blood_pro");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转出血制品编码"); 
		return column;
	}
	/**
	 * 获取化学药品灼伤情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_hxypzsqkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_hxypzsqk");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("化学药品灼伤情况"); 
		return column;
	}
	/**
	 * 获取皮肤清洁表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_pfqjCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_pfqj");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("皮肤清洁"); 
		return column;
	}
	/**
	 * 获取术后交接病历表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_shjjblCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_shjjbl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后交接病历"); 
		return column;
	}
	/**
	 * 获取术后交接皮肤情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_shjjpfqkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_shjjpfqk");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后交接皮肤情况"); 
		return column;
	}
	/**
	 * 获取术后交接皮肤情况备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_skin_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_skin_out");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后交接皮肤情况备注"); 
		return column;
	}
	/**
	 * 获取（交接）备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRemark_jjCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Remark_jj");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("（交接）备注"); 
		return column;
	}
	/**
	 * 获取出室手术室核对护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_nur_outchkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_nur_outchk");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出室手术室核对护士"); 
		return column;
	}
	/**
	 * 获取出室病区核对护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_opr_outchkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_opr_outchk");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出室病区核对护士"); 
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
	 * 获取患者出生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_birth_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_birth_pat");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者出生日期"); 
		return column;
	}
	/**
	 * 获取住院病案编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院病案编号"); 
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
	 * 获取备皮情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skin_conCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skin_con");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备皮情况"); 
		return column;
	}
	/**
	 * 获取意识状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_con_stateinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_con_statein");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识状态"); 
		return column;
	}
	/**
	 * 获取入室病区护士核对签字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nur_inchkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur_inchk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入室病区护士核对签字"); 
		return column;
	}
	/**
	 * 获取入室手术室护士核对签字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_opr_inchkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_opr_inchk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入室手术室护士核对签字"); 
		return column;
	}
	/**
	 * 获取术后液体表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_liquidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_liquid");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后液体"); 
		return column;
	}
	/**
	 * 获取术后意识状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_con_stateoutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_con_stateout");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后意识状态"); 
		return column;
	}
	/**
	 * 获取呼吸方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_breath_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_breath_type");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸方式"); 
		return column;
	}
	/**
	 * 获取术中输血表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_infusion_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infusion_blood");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术中输血"); 
		return column;
	}
	/**
	 * 获取转出血制品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_blood_proCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_blood_pro");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转出血制品"); 
		return column;
	}
	/**
	 * 获取出室病区护士核对签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nur_outchkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur_outchk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出室病区护士核对签名"); 
		return column;
	}
	/**
	 * 获取出室手术室护士核对签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_opr_outchkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_opr_outchk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出室手术室护士核对签名"); 
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
