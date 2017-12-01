
package iih.ci.rcm.contagion.d.desc;

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
 * 传染病报告卡 DO 元数据信息
 */
public class ContagionDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.contagion.d.ContagionDO";
	public static final String CLASS_DISPALYNAME = "传染病报告卡";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_contagion_card";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_contagion";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ContagionDODesc(){
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
		this.setKeyDesc(getId_contagionADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_contagionADesc(tblDesc));
		this.add(getId_mrADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getP_id_contagionADesc(tblDesc));
		this.add(getId_formADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getEu_bklbADesc(tblDesc));
		this.add(getEu_bklb_codeADesc(tblDesc));
		this.add(getEu_bklb_nameADesc(tblDesc));
		this.add(getId_con_cardsuADesc(tblDesc));
		this.add(getSd_con_cardsuADesc(tblDesc));
		this.add(getName_con_cardsuADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getId_codeADesc(tblDesc));
		this.add(getRevised_nameADesc(tblDesc));
		this.add(getRetreat_reasonADesc(tblDesc));
		this.add(getReport_unitADesc(tblDesc));
		this.add(getReport_unit_codeADesc(tblDesc));
		this.add(getReport_unit_nameADesc(tblDesc));
		this.add(getDoctor_cardADesc(tblDesc));
		this.add(getEu_jlcrbADesc(tblDesc));
		this.add(getEu_jlcrb_codeADesc(tblDesc));
		this.add(getEu_jlcrb_nameADesc(tblDesc));
		this.add(getEu_ylcrbADesc(tblDesc));
		this.add(getEu_ylcrb_codeADesc(tblDesc));
		this.add(getEu_ylcrb_nameADesc(tblDesc));
		this.add(getEu_blcrbADesc(tblDesc));
		this.add(getEu_blcrb_codeADesc(tblDesc));
		this.add(getEu_blcrb_nameADesc(tblDesc));
		this.add(getId_other_diseasesADesc(tblDesc));
		this.add(getSd_other_diseasesADesc(tblDesc));
		this.add(getName_other_diseasesADesc(tblDesc));
		this.add(getIs_alikeADesc(tblDesc));
		this.add(getEu_blflADesc(tblDesc));
		this.add(getEu_blfl_codeADesc(tblDesc));
		this.add(getEu_blfl_nameADesc(tblDesc));
		this.add(getEu_brsyADesc(tblDesc));
		this.add(getEu_brsy_codeADesc(tblDesc));
		this.add(getEu_brsy_nameADesc(tblDesc));
		this.add(getEu_rqflADesc(tblDesc));
		this.add(getEu_rqfl_codeADesc(tblDesc));
		this.add(getEu_rqfl_nameADesc(tblDesc));
		this.add(getHzjzxmADesc(tblDesc));
		this.add(getFbrqADesc(tblDesc));
		this.add(getZdrqADesc(tblDesc));
		this.add(getSwrqADesc(tblDesc));
		this.add(getEu_nldwADesc(tblDesc));
		this.add(getEu_nldw_codeADesc(tblDesc));
		this.add(getEu_nldw_nameADesc(tblDesc));
		this.add(getId_emp_entryADesc(tblDesc));
		this.add(getSd_emp_entryADesc(tblDesc));
		this.add(getName_emp_entryADesc(tblDesc));
		this.add(getExact_ageADesc(tblDesc));
		this.add(getWorkunitADesc(tblDesc));
		this.add(getMobADesc(tblDesc));
		this.add(getAddr_nowADesc(tblDesc));
		this.add(getId_provinceADesc(tblDesc));
		this.add(getSd_provinceADesc(tblDesc));
		this.add(getName_provinceADesc(tblDesc));
		this.add(getStreetADesc(tblDesc));
		this.add(getVillageADesc(tblDesc));
		this.add(getHousenumADesc(tblDesc));
		this.add(getResidence_addrADesc(tblDesc));
		this.add(getResidence_codeADesc(tblDesc));
		this.add(getResidenceADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getDt_birthADesc(tblDesc));
		this.add(getDt_contagionADesc(tblDesc));
		this.add(getTelADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getSd_grpADesc(tblDesc));
		this.add(getName_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getSd_orgADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getRemarksADesc(tblDesc));
		this.add(getDelete_resionADesc(tblDesc));
		this.add(getRehect_reasonADesc(tblDesc));
		this.add(getEu_bqflADesc(tblDesc));
		this.add(getCode_eu_bqflADesc(tblDesc));
		this.add(getName_eu_bqflADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getRef_bklb_codeADesc(tblDesc));
		this.add(getRef_bklb_nameADesc(tblDesc));
		this.add(getRef_cardsu_codeADesc(tblDesc));
		this.add(getRef_cardsu_nameADesc(tblDesc));
		this.add(getRef_code_report_unitADesc(tblDesc));
		this.add(getRef_name_report_unitADesc(tblDesc));
		this.add(getRef_code_eu_jlcrbADesc(tblDesc));
		this.add(getRef_name_eu_jlcrbADesc(tblDesc));
		this.add(getRef_code_eu_ylcrbADesc(tblDesc));
		this.add(getRef_name_eu_ylcrbADesc(tblDesc));
		this.add(getCode_eu_blcrbADesc(tblDesc));
		this.add(getName_eu_blcrbADesc(tblDesc));
		this.add(getOther_diseases_codeADesc(tblDesc));
		this.add(getOther_diseases_nameADesc(tblDesc));
		this.add(getCode_eu_rqflADesc(tblDesc));
		this.add(getName_eu_rqflADesc(tblDesc));
		this.add(getCode_eu_brsyADesc(tblDesc));
		this.add(getName_eu_brsyADesc(tblDesc));
		this.add(getRef_code_eu_rqflADesc(tblDesc));
		this.add(getRef_name_eu_rqflADesc(tblDesc));
		this.add(getCode_eu_nldwADesc(tblDesc));
		this.add(getName_eu_nldwADesc(tblDesc));
		this.add(getDoctorcodeADesc(tblDesc));
		this.add(getDoctornameADesc(tblDesc));
		this.add(getProvince_codeADesc(tblDesc));
		this.add(getProvince_nameADesc(tblDesc));
		this.add(getAreacodeADesc(tblDesc));
		this.add(getAreafullnameADesc(tblDesc));
		this.add(getSex_codeADesc(tblDesc));
		this.add(getSex_nameADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getEu_bqfl_codeADesc(tblDesc));
		this.add(getEu_bqfl_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_contagionCDesc(tblDesc));
		tblDesc.add(getId_contagionCDesc(tblDesc));
		tblDesc.add(getId_mrCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getP_id_contagionCDesc(tblDesc));
		tblDesc.add(getId_formCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getEu_bklbCDesc(tblDesc));
		tblDesc.add(getEu_bklb_codeCDesc(tblDesc));
		tblDesc.add(getEu_bklb_nameCDesc(tblDesc));
		tblDesc.add(getId_con_cardsuCDesc(tblDesc));
		tblDesc.add(getSd_con_cardsuCDesc(tblDesc));
		tblDesc.add(getName_con_cardsuCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getId_codeCDesc(tblDesc));
		tblDesc.add(getRevised_nameCDesc(tblDesc));
		tblDesc.add(getRetreat_reasonCDesc(tblDesc));
		tblDesc.add(getReport_unitCDesc(tblDesc));
		tblDesc.add(getReport_unit_codeCDesc(tblDesc));
		tblDesc.add(getReport_unit_nameCDesc(tblDesc));
		tblDesc.add(getDoctor_cardCDesc(tblDesc));
		tblDesc.add(getEu_jlcrbCDesc(tblDesc));
		tblDesc.add(getEu_jlcrb_codeCDesc(tblDesc));
		tblDesc.add(getEu_jlcrb_nameCDesc(tblDesc));
		tblDesc.add(getEu_ylcrbCDesc(tblDesc));
		tblDesc.add(getEu_ylcrb_codeCDesc(tblDesc));
		tblDesc.add(getEu_ylcrb_nameCDesc(tblDesc));
		tblDesc.add(getEu_blcrbCDesc(tblDesc));
		tblDesc.add(getEu_blcrb_codeCDesc(tblDesc));
		tblDesc.add(getEu_blcrb_nameCDesc(tblDesc));
		tblDesc.add(getId_other_diseasesCDesc(tblDesc));
		tblDesc.add(getSd_other_diseasesCDesc(tblDesc));
		tblDesc.add(getName_other_diseasesCDesc(tblDesc));
		tblDesc.add(getIs_alikeCDesc(tblDesc));
		tblDesc.add(getEu_blflCDesc(tblDesc));
		tblDesc.add(getEu_blfl_codeCDesc(tblDesc));
		tblDesc.add(getEu_blfl_nameCDesc(tblDesc));
		tblDesc.add(getEu_brsyCDesc(tblDesc));
		tblDesc.add(getEu_brsy_codeCDesc(tblDesc));
		tblDesc.add(getEu_brsy_nameCDesc(tblDesc));
		tblDesc.add(getEu_rqflCDesc(tblDesc));
		tblDesc.add(getEu_rqfl_codeCDesc(tblDesc));
		tblDesc.add(getEu_rqfl_nameCDesc(tblDesc));
		tblDesc.add(getHzjzxmCDesc(tblDesc));
		tblDesc.add(getFbrqCDesc(tblDesc));
		tblDesc.add(getZdrqCDesc(tblDesc));
		tblDesc.add(getSwrqCDesc(tblDesc));
		tblDesc.add(getEu_nldwCDesc(tblDesc));
		tblDesc.add(getEu_nldw_codeCDesc(tblDesc));
		tblDesc.add(getEu_nldw_nameCDesc(tblDesc));
		tblDesc.add(getId_emp_entryCDesc(tblDesc));
		tblDesc.add(getSd_emp_entryCDesc(tblDesc));
		tblDesc.add(getName_emp_entryCDesc(tblDesc));
		tblDesc.add(getExact_ageCDesc(tblDesc));
		tblDesc.add(getWorkunitCDesc(tblDesc));
		tblDesc.add(getMobCDesc(tblDesc));
		tblDesc.add(getAddr_nowCDesc(tblDesc));
		tblDesc.add(getId_provinceCDesc(tblDesc));
		tblDesc.add(getSd_provinceCDesc(tblDesc));
		tblDesc.add(getName_provinceCDesc(tblDesc));
		tblDesc.add(getStreetCDesc(tblDesc));
		tblDesc.add(getVillageCDesc(tblDesc));
		tblDesc.add(getHousenumCDesc(tblDesc));
		tblDesc.add(getResidence_addrCDesc(tblDesc));
		tblDesc.add(getResidence_codeCDesc(tblDesc));
		tblDesc.add(getResidenceCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getSd_sexCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getDt_birthCDesc(tblDesc));
		tblDesc.add(getDt_contagionCDesc(tblDesc));
		tblDesc.add(getTelCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getSd_grpCDesc(tblDesc));
		tblDesc.add(getName_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getSd_orgCDesc(tblDesc));
		tblDesc.add(getName_orgCDesc(tblDesc));
		tblDesc.add(getRemarksCDesc(tblDesc));
		tblDesc.add(getDelete_resionCDesc(tblDesc));
		tblDesc.add(getRehect_reasonCDesc(tblDesc));
		tblDesc.add(getEu_bqflCDesc(tblDesc));
		tblDesc.add(getCode_eu_bqflCDesc(tblDesc));
		tblDesc.add(getName_eu_bqflCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 传染病报告卡id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_contagionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_contagion",  getId_contagionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("传染病报告卡id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 业务接口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mr",  getId_mrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("业务接口");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 父id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getP_id_contagionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("P_id_contagion",  getP_id_contagionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("父id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 表单id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_formADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_form",  getId_formCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("表单id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡片编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡片编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报卡类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_bklbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_bklb",  getEu_bklbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报卡类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 报卡类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_bklb_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_bklb_code",  getEu_bklb_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报卡类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报卡类别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_bklb_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_bklb_name",  getEu_bklb_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报卡类别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 传染卡状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_con_cardsuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_con_cardsu",  getId_con_cardsuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("传染卡状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 传染卡状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_con_cardsuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_con_cardsu",  getSd_con_cardsuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("传染卡状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 传染卡状态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_con_cardsuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_con_cardsu",  getName_con_cardsuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("传染卡状态名称");
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
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有效证件号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_code",  getId_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有效证件号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 订正病名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRevised_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Revised_name",  getRevised_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("订正病名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退卡原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRetreat_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Retreat_reason",  getRetreat_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退卡原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReport_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Report_unit",  getReport_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 报告单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReport_unit_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Report_unit_code",  getReport_unit_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReport_unit_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Report_unit_name",  getReport_unit_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填卡医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoctor_cardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doctor_card",  getDoctor_cardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("填卡医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 甲类传染病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_jlcrbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_jlcrb",  getEu_jlcrbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("甲类传染病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 甲类传染病编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_jlcrb_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_jlcrb_code",  getEu_jlcrb_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("甲类传染病编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 甲类传染病名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_jlcrb_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_jlcrb_name",  getEu_jlcrb_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("甲类传染病名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 乙类传染病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ylcrbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ylcrb",  getEu_ylcrbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("乙类传染病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 乙类传染病编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ylcrb_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ylcrb_code",  getEu_ylcrb_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("乙类传染病编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 乙类传染病名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ylcrb_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ylcrb_name",  getEu_ylcrb_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("乙类传染病名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 丙类传染病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_blcrbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_blcrb",  getEu_blcrbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("丙类传染病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 丙类传染病编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_blcrb_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_blcrb_code",  getEu_blcrb_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("丙类传染病编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病类传染病名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_blcrb_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_blcrb_name",  getEu_blcrb_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病类传染病名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他传染病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_other_diseasesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_other_diseases",  getId_other_diseasesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他传染病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 其他传染病编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_other_diseasesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_other_diseases",  getSd_other_diseasesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他传染病编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他传染病名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_other_diseasesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_diseases",  getName_other_diseasesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他传染病名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有无相同症状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_alikeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_alike",  getIs_alikeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("有无相同症状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病例分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_blflADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_blfl",  getEu_blflCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病例分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病例分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_blfl_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_blfl_code",  getEu_blfl_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病例分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病例分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_blfl_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_blfl_name",  getEu_blfl_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病例分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病人属于属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_brsyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_brsy",  getEu_brsyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病人属于");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病人属于编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_brsy_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_brsy_code",  getEu_brsy_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病人属于编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病人属于名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_brsy_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_brsy_name",  getEu_brsy_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病人属于名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人群分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_rqflADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_rqfl",  getEu_rqflCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人群分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 人群分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_rqfl_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_rqfl_code",  getEu_rqfl_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人群分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人群分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_rqfl_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_rqfl_name",  getEu_rqfl_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人群分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者家长姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHzjzxmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hzjzxm",  getHzjzxmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者家长姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发病日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFbrqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fbrq",  getFbrqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("发病日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZdrqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zdrq",  getZdrqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("诊断日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死亡日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSwrqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Swrq",  getSwrqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("死亡日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_nldwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_nldw",  getEu_nldwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 年龄单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_nldw_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_nldw_code",  getEu_nldw_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_nldw_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_nldw_name",  getEu_nldw_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报卡医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_entry",  getId_emp_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报卡医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 报卡医生编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emp_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emp_entry",  getSd_emp_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报卡医生编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报卡医生名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_entry",  getName_emp_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报卡医生名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实足年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExact_ageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exact_age",  getExact_ageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("实足年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作单位(学校)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWorkunitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Workunit",  getWorkunitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作单位(学校)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mob",  getMobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 现住址（详填）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddr_nowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Addr_now",  getAddr_nowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("现住址（详填）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 现住址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_provinceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_province",  getId_provinceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("现住址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 现住址编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_provinceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_province",  getSd_provinceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("现住址编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 现住址名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_provinceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_province",  getName_provinceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("现住址名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 乡（镇、街道）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStreetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Street",  getStreetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("乡（镇、街道）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 村属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVillageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Village",  getVillageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("村");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * （门牌号）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHousenumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Housenum",  getHousenumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("（门牌号）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 户籍地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getResidence_addrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Residence_addr",  getResidence_addrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("户籍地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 户籍地址编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getResidence_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Residence_code",  getResidence_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("户籍地址编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 户籍地址名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getResidenceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Residence",  getResidenceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("户籍地址名称");
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_birthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_birth",  getDt_birthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("出生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填卡日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_contagionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_contagion",  getDt_contagionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("填卡日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系电话1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tel",  getTelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系电话1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 集团编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_grp",  getSd_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 集团名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_grp",  getName_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团名称");
		attrDesc.setNullable(true);
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
	 * 组织编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_org",  getSd_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_org",  getName_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRemarksADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Remarks",  getRemarksCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 删除原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDelete_resionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Delete_resion",  getDelete_resionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("删除原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 驳回原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRehect_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rehect_reason",  getRehect_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("驳回原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_bqflADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_bqfl",  getEu_bqflCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病情分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_eu_bqflADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_eu_bqfl",  getCode_eu_bqflCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_eu_bqflADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_eu_bqfl",  getName_eu_bqflCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用5");
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
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_bklb_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_bklb_code",  getRef_bklb_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","eu_bklb=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_bklb_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_bklb_name",  getRef_bklb_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","eu_bklb=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_cardsu_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_cardsu_code",  getRef_cardsu_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_con_cardsu=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_cardsu_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_cardsu_name",  getRef_cardsu_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_con_cardsu=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_code_report_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_code_report_unit",  getRef_code_report_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b2","report_unit=id_org","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_name_report_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_name_report_unit",  getRef_name_report_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b2","report_unit=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_code_eu_jlcrbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_code_eu_jlcrb",  getRef_code_eu_jlcrbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","eu_jlcrb=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_name_eu_jlcrbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_name_eu_jlcrb",  getRef_name_eu_jlcrbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","eu_jlcrb=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_code_eu_ylcrbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_code_eu_ylcrb",  getRef_code_eu_ylcrbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","eu_ylcrb=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_name_eu_ylcrbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_name_eu_ylcrb",  getRef_name_eu_ylcrbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","eu_ylcrb=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_eu_blcrbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_eu_blcrb",  getCode_eu_blcrbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","eu_blcrb=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 丙类传染病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_eu_blcrbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_eu_blcrb",  getName_eu_blcrbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("丙类传染病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","eu_blcrb=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_diseases_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_diseases_code",  getOther_diseases_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_other_diseases=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_diseases_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_diseases_name",  getOther_diseases_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_other_diseases=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_eu_rqflADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_eu_rqfl",  getCode_eu_rqflCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","eu_blfl=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_eu_rqflADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_eu_rqfl",  getName_eu_rqflCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","eu_blfl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_eu_brsyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_eu_brsy",  getCode_eu_brsyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","eu_brsy=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_eu_brsyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_eu_brsy",  getName_eu_brsyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","eu_brsy=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_code_eu_rqflADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_code_eu_rqfl",  getRef_code_eu_rqflCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","eu_rqfl=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_name_eu_rqflADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_name_eu_rqfl",  getRef_name_eu_rqflCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","eu_rqfl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_eu_nldwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_eu_nldw",  getCode_eu_nldwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","eu_nldw=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_eu_nldwADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_eu_nldw",  getName_eu_nldwCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","eu_nldw=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoctorcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doctorcode",  getDoctorcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b3","id_emp_entry=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoctornameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doctorname",  getDoctornameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b3","id_emp_entry=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProvince_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Province_code",  getProvince_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b4","id_province=id_adminarea","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划全称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProvince_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Province_name",  getProvince_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划全称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b4","id_province=id_adminarea","fullname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAreacodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Areacode",  getAreacodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b20","residence_addr=id_adminarea","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划全称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAreafullnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Areafullname",  getAreafullnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划全称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b20","residence_addr=id_adminarea","fullname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSex_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex_code",  getSex_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_sex=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSex_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex_name",  getSex_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_code",  getOrg_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b8","id_org=id_org","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_name",  getOrg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b8","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_bqfl_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_bqfl_code",  getEu_bqfl_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","eu_bqfl=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_bqfl_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_bqfl_name",  getEu_bqfl_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","eu_bqfl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取传染病报告卡id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_contagionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_contagion");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("传染病报告卡id"); 
		return column;
	}
	/**
	 * 获取业务接口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("业务接口"); 
		return column;
	}
	/**
	 * 获取就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊id"); 
		return column;
	}
	/**
	 * 获取父id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getP_id_contagionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"P_id_contagion");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("父id"); 
		return column;
	}
	/**
	 * 获取表单id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_formCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_form");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("表单id"); 
		return column;
	}
	/**
	 * 获取卡片编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡片编号"); 
		return column;
	}
	/**
	 * 获取报卡类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_bklbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_bklb");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡类别"); 
		return column;
	}
	/**
	 * 获取报卡类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_bklb_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_bklb_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡类别编码"); 
		return column;
	}
	/**
	 * 获取报卡类别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_bklb_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_bklb_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡类别名称"); 
		return column;
	}
	/**
	 * 获取传染卡状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_con_cardsuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_con_cardsu");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("传染卡状态"); 
		return column;
	}
	/**
	 * 获取传染卡状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_con_cardsuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_con_cardsu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("传染卡状态编码"); 
		return column;
	}
	/**
	 * 获取传染卡状态名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_con_cardsuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_con_cardsu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("传染卡状态名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取有效证件号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有效证件号"); 
		return column;
	}
	/**
	 * 获取订正病名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRevised_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Revised_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("订正病名"); 
		return column;
	}
	/**
	 * 获取退卡原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRetreat_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Retreat_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退卡原因"); 
		return column;
	}
	/**
	 * 获取报告单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReport_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Report_unit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告单位"); 
		return column;
	}
	/**
	 * 获取报告单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReport_unit_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Report_unit_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告单位编码"); 
		return column;
	}
	/**
	 * 获取报告单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReport_unit_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Report_unit_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告单位名称"); 
		return column;
	}
	/**
	 * 获取填卡医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDoctor_cardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doctor_card");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("填卡医生"); 
		return column;
	}
	/**
	 * 获取甲类传染病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_jlcrbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_jlcrb");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("甲类传染病"); 
		return column;
	}
	/**
	 * 获取甲类传染病编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_jlcrb_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_jlcrb_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("甲类传染病编码"); 
		return column;
	}
	/**
	 * 获取甲类传染病名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_jlcrb_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_jlcrb_name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("甲类传染病名称"); 
		return column;
	}
	/**
	 * 获取乙类传染病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ylcrbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ylcrb");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("乙类传染病"); 
		return column;
	}
	/**
	 * 获取乙类传染病编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ylcrb_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ylcrb_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("乙类传染病编码"); 
		return column;
	}
	/**
	 * 获取乙类传染病名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ylcrb_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ylcrb_name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("乙类传染病名称"); 
		return column;
	}
	/**
	 * 获取丙类传染病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_blcrbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_blcrb");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("丙类传染病"); 
		return column;
	}
	/**
	 * 获取丙类传染病编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_blcrb_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_blcrb_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("丙类传染病编码"); 
		return column;
	}
	/**
	 * 获取病类传染病名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_blcrb_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_blcrb_name");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病类传染病名称"); 
		return column;
	}
	/**
	 * 获取其他传染病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_other_diseasesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_other_diseases");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他传染病"); 
		return column;
	}
	/**
	 * 获取其他传染病编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_other_diseasesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_other_diseases");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他传染病编码"); 
		return column;
	}
	/**
	 * 获取其他传染病名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_other_diseasesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_diseases");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他传染病名称"); 
		return column;
	}
	/**
	 * 获取有无相同症状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_alikeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_alike");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("有无相同症状"); 
		return column;
	}
	/**
	 * 获取病例分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_blflCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_blfl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病例分类"); 
		return column;
	}
	/**
	 * 获取病例分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_blfl_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_blfl_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病例分类编码"); 
		return column;
	}
	/**
	 * 获取病例分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_blfl_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_blfl_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病例分类名称"); 
		return column;
	}
	/**
	 * 获取病人属于表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_brsyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_brsy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病人属于"); 
		return column;
	}
	/**
	 * 获取病人属于编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_brsy_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_brsy_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病人属于编码"); 
		return column;
	}
	/**
	 * 获取病人属于名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_brsy_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_brsy_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病人属于名称"); 
		return column;
	}
	/**
	 * 获取人群分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_rqflCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_rqfl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人群分类"); 
		return column;
	}
	/**
	 * 获取人群分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_rqfl_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_rqfl_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人群分类编码"); 
		return column;
	}
	/**
	 * 获取人群分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_rqfl_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_rqfl_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人群分类名称"); 
		return column;
	}
	/**
	 * 获取患者家长姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHzjzxmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hzjzxm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者家长姓名"); 
		return column;
	}
	/**
	 * 获取发病日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFbrqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fbrq");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发病日期"); 
		return column;
	}
	/**
	 * 获取诊断日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZdrqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zdrq");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("诊断日期"); 
		return column;
	}
	/**
	 * 获取死亡日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSwrqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Swrq");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("死亡日期"); 
		return column;
	}
	/**
	 * 获取年龄单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_nldwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_nldw");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄单位"); 
		return column;
	}
	/**
	 * 获取年龄单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_nldw_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_nldw_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄单位编码"); 
		return column;
	}
	/**
	 * 获取年龄单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_nldw_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_nldw_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄单位名称"); 
		return column;
	}
	/**
	 * 获取报卡医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_entry");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡医生"); 
		return column;
	}
	/**
	 * 获取报卡医生编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emp_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emp_entry");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡医生编码"); 
		return column;
	}
	/**
	 * 获取报卡医生名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_entry");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡医生名称"); 
		return column;
	}
	/**
	 * 获取实足年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExact_ageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exact_age");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("实足年龄"); 
		return column;
	}
	/**
	 * 获取工作单位(学校)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWorkunitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Workunit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作单位(学校)"); 
		return column;
	}
	/**
	 * 获取联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mob");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系电话"); 
		return column;
	}
	/**
	 * 获取现住址（详填）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddr_nowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Addr_now");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("现住址（详填）"); 
		return column;
	}
	/**
	 * 获取现住址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_provinceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_province");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("现住址"); 
		return column;
	}
	/**
	 * 获取现住址编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_provinceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_province");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("现住址编码"); 
		return column;
	}
	/**
	 * 获取现住址名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_provinceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_province");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("现住址名称"); 
		return column;
	}
	/**
	 * 获取乡（镇、街道）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStreetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Street");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("乡（镇、街道）"); 
		return column;
	}
	/**
	 * 获取村表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVillageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Village");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("村"); 
		return column;
	}
	/**
	 * 获取（门牌号）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHousenumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Housenum");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("（门牌号）"); 
		return column;
	}
	/**
	 * 获取户籍地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getResidence_addrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Residence_addr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("户籍地址"); 
		return column;
	}
	/**
	 * 获取户籍地址编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getResidence_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Residence_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("户籍地址编码"); 
		return column;
	}
	/**
	 * 获取户籍地址名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getResidenceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Residence");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("户籍地址名称"); 
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
	 * 获取性别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别名称"); 
		return column;
	}
	/**
	 * 获取出生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_birthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_birth");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出生日期"); 
		return column;
	}
	/**
	 * 获取填卡日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_contagionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_contagion");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("填卡日期"); 
		return column;
	}
	/**
	 * 获取联系电话1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系电话1"); 
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
	 * 获取集团编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_grp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团编码"); 
		return column;
	}
	/**
	 * 获取集团名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_grp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团名称"); 
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
	 * 获取组织编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_org");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织编码"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_org");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRemarksCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Remarks");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取删除原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDelete_resionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Delete_resion");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("删除原因"); 
		return column;
	}
	/**
	 * 获取驳回原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRehect_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rehect_reason");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("驳回原因"); 
		return column;
	}
	/**
	 * 获取病情分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_bqflCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_bqfl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情分类"); 
		return column;
	}
	/**
	 * 获取病情分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_eu_bqflCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_eu_bqfl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情分类编码"); 
		return column;
	}
	/**
	 * 获取病情分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_eu_bqflCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_eu_bqfl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情分类名称"); 
		return column;
	}
	/**
	 * 获取备用1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用1"); 
		return column;
	}
	/**
	 * 获取备用2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用2"); 
		return column;
	}
	/**
	 * 获取备用3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用3"); 
		return column;
	}
	/**
	 * 获取备用4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用4"); 
		return column;
	}
	/**
	 * 获取备用5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用5"); 
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
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRef_bklb_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_bklb_code");
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
	private IColumnDesc getRef_bklb_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_bklb_name");
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
	private IColumnDesc getRef_cardsu_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_cardsu_code");
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
	private IColumnDesc getRef_cardsu_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_cardsu_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取组织编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRef_code_report_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_code_report_unit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织编码"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRef_name_report_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_name_report_unit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRef_code_eu_jlcrbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_code_eu_jlcrb");
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
	private IColumnDesc getRef_name_eu_jlcrbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_name_eu_jlcrb");
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
	private IColumnDesc getRef_code_eu_ylcrbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_code_eu_ylcrb");
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
	private IColumnDesc getRef_name_eu_ylcrbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_name_eu_ylcrb");
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
	private IColumnDesc getCode_eu_blcrbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_eu_blcrb");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取丙类传染病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_eu_blcrbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_eu_blcrb");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("丙类传染病"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_diseases_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_diseases_code");
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
	private IColumnDesc getOther_diseases_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_diseases_name");
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
	private IColumnDesc getCode_eu_rqflCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_eu_rqfl");
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
	private IColumnDesc getName_eu_rqflCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_eu_rqfl");
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
	private IColumnDesc getCode_eu_brsyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_eu_brsy");
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
	private IColumnDesc getName_eu_brsyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_eu_brsy");
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
	private IColumnDesc getRef_code_eu_rqflCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_code_eu_rqfl");
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
	private IColumnDesc getRef_name_eu_rqflCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_name_eu_rqfl");
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
	private IColumnDesc getCode_eu_nldwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_eu_nldw");
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
	private IColumnDesc getName_eu_nldwCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_eu_nldw");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDoctorcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doctorcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员编码"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDoctornameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doctorname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取行政区划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProvince_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Province_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划编码"); 
		return column;
	}
	/**
	 * 获取行政区划全称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProvince_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Province_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划全称"); 
		return column;
	}
	/**
	 * 获取行政区划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAreacodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Areacode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划编码"); 
		return column;
	}
	/**
	 * 获取行政区划全称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAreafullnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Areafullname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划全称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSex_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex_code");
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
	private IColumnDesc getSex_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取组织编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织编码"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_bqfl_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_bqfl_code");
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
	private IColumnDesc getEu_bqfl_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_bqfl_name");
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
