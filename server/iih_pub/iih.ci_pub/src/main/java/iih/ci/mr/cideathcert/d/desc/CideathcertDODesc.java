
package iih.ci.mr.cideathcert.d.desc;

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
 * 死亡诊断证明书 DO 元数据信息
 */
public class CideathcertDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.cideathcert.d.CideathcertDO";
	public static final String CLASS_DISPALYNAME = "死亡诊断证明书";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mr_death_cert";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_death_cert";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CideathcertDODesc(){
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
		this.setKeyDesc(getId_death_certADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_death_certADesc(tblDesc));
		this.add(getTitleADesc(tblDesc));
		this.add(getInhos_noADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getSex_codeADesc(tblDesc));
		this.add(getSex_patADesc(tblDesc));
		this.add(getAge_patADesc(tblDesc));
		this.add(getId_cardtypeADesc(tblDesc));
		this.add(getCard_type_codeADesc(tblDesc));
		this.add(getIdcard_typeADesc(tblDesc));
		this.add(getIdcard_noADesc(tblDesc));
		this.add(getId_countryADesc(tblDesc));
		this.add(getCountry_patADesc(tblDesc));
		this.add(getId_nationADesc(tblDesc));
		this.add(getNation_patADesc(tblDesc));
		this.add(getBirth_patADesc(tblDesc));
		this.add(getId_marryADesc(tblDesc));
		this.add(getMarry_codeADesc(tblDesc));
		this.add(getMarry_statusADesc(tblDesc));
		this.add(getId_degreeADesc(tblDesc));
		this.add(getDegree_codeADesc(tblDesc));
		this.add(getDegree_patADesc(tblDesc));
		this.add(getId_jobADesc(tblDesc));
		this.add(getPersonal_identity_codeADesc(tblDesc));
		this.add(getJob_patADesc(tblDesc));
		this.add(getAddress_provinceADesc(tblDesc));
		this.add(getAddress_countyADesc(tblDesc));
		this.add(getAddress_detailADesc(tblDesc));
		this.add(getAddress_patADesc(tblDesc));
		this.add(getAddress_pat_codeADesc(tblDesc));
		this.add(getAddress_pat_nameADesc(tblDesc));
		this.add(getAddress_pat_streetADesc(tblDesc));
		this.add(getAddress_codeADesc(tblDesc));
		this.add(getAddress_noADesc(tblDesc));
		this.add(getUnknown_dateADesc(tblDesc));
		this.add(getDeath_timeADesc(tblDesc));
		this.add(getDeath_siteADesc(tblDesc));
		this.add(getDeath_site_codeADesc(tblDesc));
		this.add(getDeath_site_nameADesc(tblDesc));
		this.add(getIs_pregnantADesc(tblDesc));
		this.add(getWork_companyADesc(tblDesc));
		this.add(getBirth_placeADesc(tblDesc));
		this.add(getAddress_usualADesc(tblDesc));
		this.add(getRelation_nameADesc(tblDesc));
		this.add(getRelation_phoneADesc(tblDesc));
		this.add(getRelation_addressADesc(tblDesc));
		this.add(getDeath_a_diagADesc(tblDesc));
		this.add(getDeath_a_timespanADesc(tblDesc));
		this.add(getDeath_b_diagADesc(tblDesc));
		this.add(getDeath_b_timespanADesc(tblDesc));
		this.add(getDeath_c_diagADesc(tblDesc));
		this.add(getDeath_c_timespanADesc(tblDesc));
		this.add(getDeath_d_diagADesc(tblDesc));
		this.add(getDeath_d_timespanADesc(tblDesc));
		this.add(getDeath_other_diagADesc(tblDesc));
		this.add(getDeath_other_timespanADesc(tblDesc));
		this.add(getDiag_basisADesc(tblDesc));
		this.add(getDiag_basis_codeADesc(tblDesc));
		this.add(getDiag_basis_nameADesc(tblDesc));
		this.add(getDiag_hospitalADesc(tblDesc));
		this.add(getDiag_hospital_codeADesc(tblDesc));
		this.add(getDiag_hospital_nameADesc(tblDesc));
		this.add(getSign_doctorADesc(tblDesc));
		this.add(getDeath_reasonADesc(tblDesc));
		this.add(getDiag_icdcodeADesc(tblDesc));
		this.add(getDiag_icdnameADesc(tblDesc));
		this.add(getSymptom_signADesc(tblDesc));
		this.add(getInvestigate_nameADesc(tblDesc));
		this.add(getInvestigate_relationADesc(tblDesc));
		this.add(getInvestigate_phoneADesc(tblDesc));
		this.add(getInvestigate_addressADesc(tblDesc));
		this.add(getDeath_inferADesc(tblDesc));
		this.add(getInvestigate_dateADesc(tblDesc));
		this.add(getInvestigaterADesc(tblDesc));
		this.add(getCert_statusADesc(tblDesc));
		this.add(getVerifiedbyADesc(tblDesc));
		this.add(getVerifiedtimeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getCode_sexADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getCode_cardtypeADesc(tblDesc));
		this.add(getName_cardtypeADesc(tblDesc));
		this.add(getCode_countryADesc(tblDesc));
		this.add(getName_countryADesc(tblDesc));
		this.add(getCodeth_countryADesc(tblDesc));
		this.add(getFullname_countryADesc(tblDesc));
		this.add(getCode_nationADesc(tblDesc));
		this.add(getName_nationADesc(tblDesc));
		this.add(getCode_marryADesc(tblDesc));
		this.add(getName_marryADesc(tblDesc));
		this.add(getCode_degreeADesc(tblDesc));
		this.add(getName_degreeADesc(tblDesc));
		this.add(getCode_jobADesc(tblDesc));
		this.add(getName_jobADesc(tblDesc));
		this.add(getCode_addressADesc(tblDesc));
		this.add(getName_addressADesc(tblDesc));
		this.add(getCode_deathsiteADesc(tblDesc));
		this.add(getName_deathsiteADesc(tblDesc));
		this.add(getCode_diagbasisADesc(tblDesc));
		this.add(getName_diagbasisADesc(tblDesc));
		this.add(getCode123ADesc(tblDesc));
		this.add(getName123ADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_death_certCDesc(tblDesc));
		tblDesc.add(getId_death_certCDesc(tblDesc));
		tblDesc.add(getTitleCDesc(tblDesc));
		tblDesc.add(getInhos_noCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getSex_codeCDesc(tblDesc));
		tblDesc.add(getSex_patCDesc(tblDesc));
		tblDesc.add(getAge_patCDesc(tblDesc));
		tblDesc.add(getId_cardtypeCDesc(tblDesc));
		tblDesc.add(getCard_type_codeCDesc(tblDesc));
		tblDesc.add(getIdcard_typeCDesc(tblDesc));
		tblDesc.add(getIdcard_noCDesc(tblDesc));
		tblDesc.add(getId_countryCDesc(tblDesc));
		tblDesc.add(getCountry_patCDesc(tblDesc));
		tblDesc.add(getId_nationCDesc(tblDesc));
		tblDesc.add(getNation_patCDesc(tblDesc));
		tblDesc.add(getBirth_patCDesc(tblDesc));
		tblDesc.add(getId_marryCDesc(tblDesc));
		tblDesc.add(getMarry_codeCDesc(tblDesc));
		tblDesc.add(getMarry_statusCDesc(tblDesc));
		tblDesc.add(getId_degreeCDesc(tblDesc));
		tblDesc.add(getDegree_codeCDesc(tblDesc));
		tblDesc.add(getDegree_patCDesc(tblDesc));
		tblDesc.add(getId_jobCDesc(tblDesc));
		tblDesc.add(getPersonal_identity_codeCDesc(tblDesc));
		tblDesc.add(getJob_patCDesc(tblDesc));
		tblDesc.add(getAddress_provinceCDesc(tblDesc));
		tblDesc.add(getAddress_countyCDesc(tblDesc));
		tblDesc.add(getAddress_detailCDesc(tblDesc));
		tblDesc.add(getAddress_patCDesc(tblDesc));
		tblDesc.add(getAddress_pat_codeCDesc(tblDesc));
		tblDesc.add(getAddress_pat_nameCDesc(tblDesc));
		tblDesc.add(getAddress_pat_streetCDesc(tblDesc));
		tblDesc.add(getAddress_codeCDesc(tblDesc));
		tblDesc.add(getAddress_noCDesc(tblDesc));
		tblDesc.add(getUnknown_dateCDesc(tblDesc));
		tblDesc.add(getDeath_timeCDesc(tblDesc));
		tblDesc.add(getDeath_siteCDesc(tblDesc));
		tblDesc.add(getDeath_site_codeCDesc(tblDesc));
		tblDesc.add(getDeath_site_nameCDesc(tblDesc));
		tblDesc.add(getIs_pregnantCDesc(tblDesc));
		tblDesc.add(getWork_companyCDesc(tblDesc));
		tblDesc.add(getBirth_placeCDesc(tblDesc));
		tblDesc.add(getAddress_usualCDesc(tblDesc));
		tblDesc.add(getRelation_nameCDesc(tblDesc));
		tblDesc.add(getRelation_phoneCDesc(tblDesc));
		tblDesc.add(getRelation_addressCDesc(tblDesc));
		tblDesc.add(getDeath_a_diagCDesc(tblDesc));
		tblDesc.add(getDeath_a_timespanCDesc(tblDesc));
		tblDesc.add(getDeath_b_diagCDesc(tblDesc));
		tblDesc.add(getDeath_b_timespanCDesc(tblDesc));
		tblDesc.add(getDeath_c_diagCDesc(tblDesc));
		tblDesc.add(getDeath_c_timespanCDesc(tblDesc));
		tblDesc.add(getDeath_d_diagCDesc(tblDesc));
		tblDesc.add(getDeath_d_timespanCDesc(tblDesc));
		tblDesc.add(getDeath_other_diagCDesc(tblDesc));
		tblDesc.add(getDeath_other_timespanCDesc(tblDesc));
		tblDesc.add(getDiag_basisCDesc(tblDesc));
		tblDesc.add(getDiag_basis_codeCDesc(tblDesc));
		tblDesc.add(getDiag_basis_nameCDesc(tblDesc));
		tblDesc.add(getDiag_hospitalCDesc(tblDesc));
		tblDesc.add(getDiag_hospital_codeCDesc(tblDesc));
		tblDesc.add(getDiag_hospital_nameCDesc(tblDesc));
		tblDesc.add(getSign_doctorCDesc(tblDesc));
		tblDesc.add(getDeath_reasonCDesc(tblDesc));
		tblDesc.add(getDiag_icdcodeCDesc(tblDesc));
		tblDesc.add(getDiag_icdnameCDesc(tblDesc));
		tblDesc.add(getSymptom_signCDesc(tblDesc));
		tblDesc.add(getInvestigate_nameCDesc(tblDesc));
		tblDesc.add(getInvestigate_relationCDesc(tblDesc));
		tblDesc.add(getInvestigate_phoneCDesc(tblDesc));
		tblDesc.add(getInvestigate_addressCDesc(tblDesc));
		tblDesc.add(getDeath_inferCDesc(tblDesc));
		tblDesc.add(getInvestigate_dateCDesc(tblDesc));
		tblDesc.add(getInvestigaterCDesc(tblDesc));
		tblDesc.add(getCert_statusCDesc(tblDesc));
		tblDesc.add(getVerifiedbyCDesc(tblDesc));
		tblDesc.add(getVerifiedtimeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_death_certADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_death_cert",  getId_death_certCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标题属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Title",  getTitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标题");
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
	private IAttrDesc getInhos_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inhos_no",  getInhos_noCDesc(tblDesc), this);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex",  getId_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别ID");
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
	private IAttrDesc getSex_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex_code",  getSex_codeCDesc(tblDesc), this);
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
	 * 患者性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSex_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex_pat",  getSex_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者性别");
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
	private IAttrDesc getAge_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age_pat",  getAge_patCDesc(tblDesc), this);
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
	 * 证件类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cardtypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cardtype",  getId_cardtypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("证件类型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 证件类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_type_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_type_code",  getCard_type_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("证件类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 证件类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdcard_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idcard_type",  getIdcard_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("证件类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 证件号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdcard_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idcard_no",  getIdcard_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("证件号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国家属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_countryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_country",  getId_countryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者国家属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCountry_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Country_pat",  getCountry_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者国家");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民族属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nation",  getId_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者民族属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNation_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nation_pat",  getNation_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者民族");
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
	private IAttrDesc getBirth_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Birth_pat",  getBirth_patCDesc(tblDesc), this);
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
	 * 婚姻ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_marryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_marry",  getId_marryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 婚姻编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMarry_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Marry_code",  getMarry_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婚姻状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMarry_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Marry_status",  getMarry_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文化程度ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_degreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_degree",  getId_degreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化程度ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 文化程度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDegree_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Degree_code",  getDegree_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化程度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文化程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDegree_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Degree_pat",  getDegree_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 个人身份ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_jobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_job",  getId_jobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("个人身份ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 个人身份编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPersonal_identity_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Personal_identity_code",  getPersonal_identity_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("个人身份编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 个人身份属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJob_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Job_pat",  getJob_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("个人身份");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住址省属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddress_provinceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Address_province",  getAddress_provinceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住址省");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住址县区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddress_countyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Address_county",  getAddress_countyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住址县区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住址明细属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddress_detailADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Address_detail",  getAddress_detailCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住址明细");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死者住址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddress_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Address_pat",  getAddress_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("死者住址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 死者住址编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddress_pat_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Address_pat_code",  getAddress_pat_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("死者住址编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死者住址名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddress_pat_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Address_pat_name",  getAddress_pat_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("死者住址名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死者住址街道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddress_pat_streetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Address_pat_street",  getAddress_pat_streetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("死者住址街道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddress_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Address_code",  getAddress_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddress_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Address_no",  getAddress_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 未知时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUnknown_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Unknown_date",  getUnknown_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("未知时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死亡时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_time",  getDeath_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("死亡时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死亡地点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_site",  getDeath_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("死亡地点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 死亡地点编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_site_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_site_code",  getDeath_site_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("死亡地点编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam79属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_site_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_site_name",  getDeath_site_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam79");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否怀孕属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_pregnantADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_pregnant",  getIs_pregnantCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否怀孕");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生前工作单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWork_companyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Work_company",  getWork_companyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生前工作单位");
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
	private IAttrDesc getBirth_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Birth_place",  getBirth_placeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("户籍地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 常住地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddress_usualADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Address_usual",  getAddress_usualCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("常住地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Relation_name",  getRelation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系人电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelation_phoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Relation_phone",  getRelation_phoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系人住址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelation_addressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Relation_address",  getRelation_addressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人住址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * a疾病直接死亡原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_a_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_a_diag",  getDeath_a_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("a疾病直接死亡原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * a疾病的死亡间隔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_a_timespanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_a_timespan",  getDeath_a_timespanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("a疾病的死亡间隔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * b疾病情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_b_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_b_diag",  getDeath_b_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("b疾病情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * b疾病的死亡间隔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_b_timespanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_b_timespan",  getDeath_b_timespanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("b疾病的死亡间隔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * c疾病的情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_c_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_c_diag",  getDeath_c_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("c疾病的情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * c疾病的死亡间隔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_c_timespanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_c_timespan",  getDeath_c_timespanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("c疾病的死亡间隔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * d疾病的情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_d_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_d_diag",  getDeath_d_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("d疾病的情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * d疾病的死亡间隔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_d_timespanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_d_timespan",  getDeath_d_timespanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("d疾病的死亡间隔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其它诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_other_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_other_diag",  getDeath_other_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其它诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他疾病死亡间隔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_other_timespanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_other_timespan",  getDeath_other_timespanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他疾病死亡间隔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最高诊断依据属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiag_basisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diag_basis",  getDiag_basisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最高诊断依据");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最高诊断依据编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiag_basis_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diag_basis_code",  getDiag_basis_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最高诊断依据编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最高诊断依据名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiag_basis_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diag_basis_name",  getDiag_basis_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最高诊断依据名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最高诊断单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiag_hospitalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diag_hospital",  getDiag_hospitalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最高诊断单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最高诊断单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiag_hospital_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diag_hospital_code",  getDiag_hospital_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最高诊断单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最高诊断单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiag_hospital_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diag_hospital_name",  getDiag_hospital_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最高诊断单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签名医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSign_doctorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sign_doctor",  getSign_doctorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 根本死亡原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_reason",  getDeath_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("根本死亡原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * icd编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiag_icdcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diag_icdcode",  getDiag_icdcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("icd编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * icd名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiag_icdnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diag_icdname",  getDiag_icdnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("icd名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 症状体征属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSymptom_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Symptom_sign",  getSymptom_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("症状体征");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 被调查者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvestigate_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Investigate_name",  getInvestigate_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("被调查者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与患者关系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvestigate_relationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Investigate_relation",  getInvestigate_relationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与患者关系");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 被调查者电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvestigate_phoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Investigate_phone",  getInvestigate_phoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("被调查者电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 被调查者住址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvestigate_addressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Investigate_address",  getInvestigate_addressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("被调查者住址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死因推断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeath_inferADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Death_infer",  getDeath_inferCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("死因推断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvestigate_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Investigate_date",  getInvestigate_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("调查时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvestigaterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Investigater",  getInvestigaterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCert_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cert_status",  getCert_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVerifiedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Verifiedby",  getVerifiedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 审核时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVerifiedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Verifiedtime",  getVerifiedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("审核时间");
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
	private IAttrDesc getCode_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_sex",  getCode_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_sex=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 证件类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_cardtypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_cardtype",  getCode_cardtypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("证件类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_cardtype=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 证件类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cardtypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cardtype",  getName_cardtypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("证件类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_cardtype=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国家地区编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_countryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_country",  getCode_countryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家地区编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_country a0b6","id_country=id_countryzone","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_countryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_country",  getName_countryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_country a0b6","id_country=id_countryzone","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 三位代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeth_countryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Codeth_country",  getCodeth_countryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("三位代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_country a0b6","id_country=id_countryzone","codeth"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 全称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFullname_countryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fullname_country",  getFullname_countryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("全称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_country a0b6","id_country=id_countryzone","fullname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_nation",  getCode_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_nation=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nation",  getName_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_nation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_marryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_marry",  getCode_marryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_marry=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_marryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_marry",  getName_marryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_marry=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_degreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_degree",  getCode_degreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_degree=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_degreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_degree",  getName_degreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_degree=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_jobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_job",  getCode_jobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_job=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_jobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_job",  getName_jobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_job=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_addressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_address",  getCode_addressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b16","address_pat=id_adminarea","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_addressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_address",  getName_addressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b16","address_pat=id_adminarea","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_deathsiteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_deathsite",  getCode_deathsiteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","death_site=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deathsiteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_deathsite",  getName_deathsiteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","death_site=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_diagbasisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_diagbasis",  getCode_diagbasisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","diag_basis=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagbasisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diagbasis",  getName_diagbasisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","diag_basis=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode123ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code123",  getCode123CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","diag_hospital=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName123ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name123",  getName123CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","diag_hospital=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_death_certCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_death_cert");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主键"); 
		return column;
	}
	/**
	 * 获取标题表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Title");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标题"); 
		return column;
	}
	/**
	 * 获取住院号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInhos_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inhos_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院号"); 
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
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取性别ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别ID"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSex_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取患者性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSex_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者性别"); 
		return column;
	}
	/**
	 * 获取年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAge_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄"); 
		return column;
	}
	/**
	 * 获取证件类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cardtypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cardtype");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("证件类型ID"); 
		return column;
	}
	/**
	 * 获取证件类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_type_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_type_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("证件类型编码"); 
		return column;
	}
	/**
	 * 获取证件类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdcard_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idcard_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("证件类型"); 
		return column;
	}
	/**
	 * 获取证件号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdcard_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idcard_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("证件号"); 
		return column;
	}
	/**
	 * 获取国家表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_countryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_country");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家"); 
		return column;
	}
	/**
	 * 获取患者国家表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCountry_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Country_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者国家"); 
		return column;
	}
	/**
	 * 获取民族表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族"); 
		return column;
	}
	/**
	 * 获取患者民族表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNation_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nation_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者民族"); 
		return column;
	}
	/**
	 * 获取出生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBirth_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Birth_pat");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出生日期"); 
		return column;
	}
	/**
	 * 获取婚姻ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_marryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_marry");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻ID"); 
		return column;
	}
	/**
	 * 获取婚姻编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMarry_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Marry_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻编码"); 
		return column;
	}
	/**
	 * 获取婚姻状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMarry_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Marry_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻状况"); 
		return column;
	}
	/**
	 * 获取文化程度ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_degreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_degree");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化程度ID"); 
		return column;
	}
	/**
	 * 获取文化程度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDegree_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Degree_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化程度编码"); 
		return column;
	}
	/**
	 * 获取文化程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDegree_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Degree_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化程度"); 
		return column;
	}
	/**
	 * 获取个人身份ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_jobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_job");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("个人身份ID"); 
		return column;
	}
	/**
	 * 获取个人身份编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPersonal_identity_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Personal_identity_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("个人身份编码"); 
		return column;
	}
	/**
	 * 获取个人身份表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJob_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Job_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("个人身份"); 
		return column;
	}
	/**
	 * 获取住址省表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddress_provinceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Address_province");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住址省"); 
		return column;
	}
	/**
	 * 获取住址县区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddress_countyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Address_county");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住址县区"); 
		return column;
	}
	/**
	 * 获取住址明细表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddress_detailCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Address_detail");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住址明细"); 
		return column;
	}
	/**
	 * 获取死者住址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddress_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Address_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("死者住址"); 
		return column;
	}
	/**
	 * 获取死者住址编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddress_pat_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Address_pat_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("死者住址编码"); 
		return column;
	}
	/**
	 * 获取死者住址名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddress_pat_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Address_pat_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("死者住址名称"); 
		return column;
	}
	/**
	 * 获取死者住址街道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddress_pat_streetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Address_pat_street");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("死者住址街道"); 
		return column;
	}
	/**
	 * 获取行政区代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddress_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Address_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区代码"); 
		return column;
	}
	/**
	 * 获取行政区编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddress_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Address_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区编码"); 
		return column;
	}
	/**
	 * 获取未知时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUnknown_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Unknown_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("未知时间"); 
		return column;
	}
	/**
	 * 获取死亡时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("死亡时间"); 
		return column;
	}
	/**
	 * 获取死亡地点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("死亡地点"); 
		return column;
	}
	/**
	 * 获取死亡地点编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_site_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_site_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("死亡地点编码"); 
		return column;
	}
	/**
	 * 获取displaynam79表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_site_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_site_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam79"); 
		return column;
	}
	/**
	 * 获取是否怀孕表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_pregnantCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_pregnant");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否怀孕"); 
		return column;
	}
	/**
	 * 获取生前工作单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWork_companyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Work_company");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生前工作单位"); 
		return column;
	}
	/**
	 * 获取户籍地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBirth_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Birth_place");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("户籍地址"); 
		return column;
	}
	/**
	 * 获取常住地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddress_usualCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Address_usual");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("常住地址"); 
		return column;
	}
	/**
	 * 获取联系人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Relation_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人"); 
		return column;
	}
	/**
	 * 获取联系人电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelation_phoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Relation_phone");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人电话"); 
		return column;
	}
	/**
	 * 获取联系人住址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelation_addressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Relation_address");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人住址"); 
		return column;
	}
	/**
	 * 获取a疾病直接死亡原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_a_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_a_diag");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("a疾病直接死亡原因"); 
		return column;
	}
	/**
	 * 获取a疾病的死亡间隔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_a_timespanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_a_timespan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("a疾病的死亡间隔"); 
		return column;
	}
	/**
	 * 获取b疾病情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_b_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_b_diag");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("b疾病情况"); 
		return column;
	}
	/**
	 * 获取b疾病的死亡间隔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_b_timespanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_b_timespan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("b疾病的死亡间隔"); 
		return column;
	}
	/**
	 * 获取c疾病的情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_c_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_c_diag");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("c疾病的情况"); 
		return column;
	}
	/**
	 * 获取c疾病的死亡间隔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_c_timespanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_c_timespan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("c疾病的死亡间隔"); 
		return column;
	}
	/**
	 * 获取d疾病的情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_d_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_d_diag");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("d疾病的情况"); 
		return column;
	}
	/**
	 * 获取d疾病的死亡间隔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_d_timespanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_d_timespan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("d疾病的死亡间隔"); 
		return column;
	}
	/**
	 * 获取其它诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_other_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_other_diag");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其它诊断"); 
		return column;
	}
	/**
	 * 获取其他疾病死亡间隔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_other_timespanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_other_timespan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他疾病死亡间隔"); 
		return column;
	}
	/**
	 * 获取最高诊断依据表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiag_basisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diag_basis");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最高诊断依据"); 
		return column;
	}
	/**
	 * 获取最高诊断依据编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiag_basis_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diag_basis_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最高诊断依据编码"); 
		return column;
	}
	/**
	 * 获取最高诊断依据名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiag_basis_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diag_basis_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最高诊断依据名称"); 
		return column;
	}
	/**
	 * 获取最高诊断单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiag_hospitalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diag_hospital");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最高诊断单位"); 
		return column;
	}
	/**
	 * 获取最高诊断单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiag_hospital_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diag_hospital_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最高诊断单位编码"); 
		return column;
	}
	/**
	 * 获取最高诊断单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiag_hospital_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diag_hospital_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最高诊断单位名称"); 
		return column;
	}
	/**
	 * 获取签名医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSign_doctorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sign_doctor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名医生"); 
		return column;
	}
	/**
	 * 获取根本死亡原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_reason");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("根本死亡原因"); 
		return column;
	}
	/**
	 * 获取icd编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiag_icdcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diag_icdcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("icd编码"); 
		return column;
	}
	/**
	 * 获取icd名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiag_icdnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diag_icdname");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("icd名称"); 
		return column;
	}
	/**
	 * 获取症状体征表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSymptom_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Symptom_sign");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("症状体征"); 
		return column;
	}
	/**
	 * 获取被调查者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvestigate_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Investigate_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("被调查者姓名"); 
		return column;
	}
	/**
	 * 获取与患者关系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvestigate_relationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Investigate_relation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与患者关系"); 
		return column;
	}
	/**
	 * 获取被调查者电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvestigate_phoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Investigate_phone");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("被调查者电话"); 
		return column;
	}
	/**
	 * 获取被调查者住址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvestigate_addressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Investigate_address");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("被调查者住址"); 
		return column;
	}
	/**
	 * 获取死因推断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeath_inferCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Death_infer");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("死因推断"); 
		return column;
	}
	/**
	 * 获取调查时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvestigate_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Investigate_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("调查时间"); 
		return column;
	}
	/**
	 * 获取调查者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvestigaterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Investigater");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查者"); 
		return column;
	}
	/**
	 * 获取状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCert_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cert_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("状态"); 
		return column;
	}
	/**
	 * 获取审核人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVerifiedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Verifiedby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核人"); 
		return column;
	}
	/**
	 * 获取审核时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVerifiedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Verifiedtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("审核时间"); 
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
	private IColumnDesc getCode_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_sex");
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
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取证件类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_cardtypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_cardtype");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("证件类型编码"); 
		return column;
	}
	/**
	 * 获取证件类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cardtypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cardtype");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("证件类型名称"); 
		return column;
	}
	/**
	 * 获取国家地区编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_countryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_country");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家地区编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_countryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_country");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取三位代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeth_countryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Codeth_country");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("三位代码"); 
		return column;
	}
	/**
	 * 获取全称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFullname_countryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fullname_country");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("全称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_nation");
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
	private IColumnDesc getName_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nation");
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
	private IColumnDesc getCode_marryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_marry");
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
	private IColumnDesc getName_marryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_marry");
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
	private IColumnDesc getCode_degreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_degree");
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
	private IColumnDesc getName_degreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_degree");
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
	private IColumnDesc getCode_jobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_job");
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
	private IColumnDesc getName_jobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_job");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取行政区划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_addressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_address");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划编码"); 
		return column;
	}
	/**
	 * 获取行政区划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_addressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_address");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_deathsiteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_deathsite");
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
	private IColumnDesc getName_deathsiteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_deathsite");
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
	private IColumnDesc getCode_diagbasisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_diagbasis");
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
	private IColumnDesc getName_diagbasisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagbasis");
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
	private IColumnDesc getCode123CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code123");
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
	private IColumnDesc getName123CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name123");
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
