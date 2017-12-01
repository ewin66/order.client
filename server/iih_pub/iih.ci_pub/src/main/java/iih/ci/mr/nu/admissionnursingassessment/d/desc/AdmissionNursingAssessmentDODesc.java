
package iih.ci.mr.nu.admissionnursingassessment.d.desc;

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
 * 入院护理评估单 DO 元数据信息
 */
public class AdmissionNursingAssessmentDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.admissionnursingassessment.d.AdmissionNursingAssessmentDO";
	public static final String CLASS_DISPALYNAME = "入院护理评估单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_NU_ANA";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_ana";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public AdmissionNursingAssessmentDODesc(){
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
		this.setKeyDesc(getId_anaADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_anaADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getGlqtADesc(tblDesc));
		this.add(getSd_referalsrcADesc(tblDesc));
		this.add(getId_referalsrcADesc(tblDesc));
		this.add(getOther_referalsrcADesc(tblDesc));
		this.add(getId_ryxdfsADesc(tblDesc));
		this.add(getSd_yrxdfsADesc(tblDesc));
		this.add(getRyxdfs_otherADesc(tblDesc));
		this.add(getId_jyADesc(tblDesc));
		this.add(getSd_jyADesc(tblDesc));
		this.add(getEu_zjADesc(tblDesc));
		this.add(getEu_pbADesc(tblDesc));
		this.add(getEu_gmsADesc(tblDesc));
		this.add(getEu_shxyADesc(tblDesc));
		this.add(getEu_shyjADesc(tblDesc));
		this.add(getEu_jwsADesc(tblDesc));
		this.add(getEu_qxADesc(tblDesc));
		this.add(getId_qxxxADesc(tblDesc));
		this.add(getSd_qxxxADesc(tblDesc));
		this.add(getOther_qxxxADesc(tblDesc));
		this.add(getEu_ysspADesc(tblDesc));
		this.add(getId_ysspycxxADesc(tblDesc));
		this.add(getSd_ysspycxxADesc(tblDesc));
		this.add(getOther_ysspycxxADesc(tblDesc));
		this.add(getEu_stzkslADesc(tblDesc));
		this.add(getId_stzkslxxADesc(tblDesc));
		this.add(getSd_stzkslxxADesc(tblDesc));
		this.add(getOther_stzkslxxADesc(tblDesc));
		this.add(getEu_stzktlADesc(tblDesc));
		this.add(getId_stzktlxxADesc(tblDesc));
		this.add(getSd_stzktlxxADesc(tblDesc));
		this.add(getOther_stzktlxxADesc(tblDesc));
		this.add(getEu_stzkyyADesc(tblDesc));
		this.add(getId_stzkyyxxADesc(tblDesc));
		this.add(getSd_stzkyyxxADesc(tblDesc));
		this.add(getOther_stzkyyxxADesc(tblDesc));
		this.add(getEu_stzkmrADesc(tblDesc));
		this.add(getId_stzkmrxxADesc(tblDesc));
		this.add(getSd_stzkmrxxADesc(tblDesc));
		this.add(getOther_stzkmrxxADesc(tblDesc));
		this.add(getEu_stzkjsADesc(tblDesc));
		this.add(getId_stzkjsxxADesc(tblDesc));
		this.add(getSd_stzkjsxxADesc(tblDesc));
		this.add(getOther_stzkjsxxADesc(tblDesc));
		this.add(getEu_stzkpnADesc(tblDesc));
		this.add(getId_stzkpnxxADesc(tblDesc));
		this.add(getSd_stzkpnxxADesc(tblDesc));
		this.add(getOther_stzkpnxxADesc(tblDesc));
		this.add(getEu_stzkpbADesc(tblDesc));
		this.add(getId_stzkpbxxADesc(tblDesc));
		this.add(getSd_stzkpbxxADesc(tblDesc));
		this.add(getOther_stzkpbxxADesc(tblDesc));
		this.add(getId_stzkhdADesc(tblDesc));
		this.add(getSd_stzkhdADesc(tblDesc));
		this.add(getOher_stzkhdADesc(tblDesc));
		this.add(getEu_stzksmADesc(tblDesc));
		this.add(getId_stzksmxxADesc(tblDesc));
		this.add(getSd_stzksmxxADesc(tblDesc));
		this.add(getOther_stzksmxxADesc(tblDesc));
		this.add(getEu_stzkzlnlADesc(tblDesc));
		this.add(getId_stzkzlnlxxADesc(tblDesc));
		this.add(getSd_stzkzlnlxxADesc(tblDesc));
		this.add(getOther_stzkzlnlxxADesc(tblDesc));
		this.add(getEu_stzkpfADesc(tblDesc));
		this.add(getId_pfyclxADesc(tblDesc));
		this.add(getSd_pfyclxADesc(tblDesc));
		this.add(getOther_pfyclxADesc(tblDesc));
		this.add(getPressuresoreADesc(tblDesc));
		this.add(getEu_glADesc(tblDesc));
		this.add(getId_glylgADesc(tblDesc));
		this.add(getSd_glylgADesc(tblDesc));
		this.add(getOther_glylgADesc(tblDesc));
		this.add(getId_glwzjmADesc(tblDesc));
		this.add(getSd_glwzjmADesc(tblDesc));
		this.add(getId_glsjmADesc(tblDesc));
		this.add(getSd_glsjmADesc(tblDesc));
		this.add(getOther_glsjmADesc(tblDesc));
		this.add(getId_glrgqdADesc(tblDesc));
		this.add(getSd_glrgqdADesc(tblDesc));
		this.add(getEu_ddfxpgADesc(tblDesc));
		this.add(getScore_falllADesc(tblDesc));
		this.add(getInforsourcesADesc(tblDesc));
		this.add(getSignatureADesc(tblDesc));
		this.add(getDt_assessADesc(tblDesc));
		this.add(getZkpgADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getName_referalsrcADesc(tblDesc));
		this.add(getName_ryxdfsADesc(tblDesc));
		this.add(getName_jyADesc(tblDesc));
		this.add(getName_qxxxADesc(tblDesc));
		this.add(getName_ysspycxxADesc(tblDesc));
		this.add(getName_stzkslxxADesc(tblDesc));
		this.add(getName_stzktlxxADesc(tblDesc));
		this.add(getName_stzkyyxxADesc(tblDesc));
		this.add(getName_stzkmrxxADesc(tblDesc));
		this.add(getName_stzkjsxxADesc(tblDesc));
		this.add(getName_stzkpnxxADesc(tblDesc));
		this.add(getName_stzkpbxxADesc(tblDesc));
		this.add(getName_stzkhdADesc(tblDesc));
		this.add(getName_stzksmxxADesc(tblDesc));
		this.add(getName_stzkzlnlxxADesc(tblDesc));
		this.add(getName_pfyclxADesc(tblDesc));
		this.add(getName_glylgADesc(tblDesc));
		this.add(getName_glwzjmADesc(tblDesc));
		this.add(getName_glsjmADesc(tblDesc));
		this.add(getName_glrgqdADesc(tblDesc));
		this.add(getName_signatureADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_anaCDesc(tblDesc));
		tblDesc.add(getId_anaCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getSd_sexCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getGlqtCDesc(tblDesc));
		tblDesc.add(getSd_referalsrcCDesc(tblDesc));
		tblDesc.add(getId_referalsrcCDesc(tblDesc));
		tblDesc.add(getOther_referalsrcCDesc(tblDesc));
		tblDesc.add(getId_ryxdfsCDesc(tblDesc));
		tblDesc.add(getSd_yrxdfsCDesc(tblDesc));
		tblDesc.add(getRyxdfs_otherCDesc(tblDesc));
		tblDesc.add(getId_jyCDesc(tblDesc));
		tblDesc.add(getSd_jyCDesc(tblDesc));
		tblDesc.add(getEu_zjCDesc(tblDesc));
		tblDesc.add(getEu_pbCDesc(tblDesc));
		tblDesc.add(getEu_gmsCDesc(tblDesc));
		tblDesc.add(getEu_shxyCDesc(tblDesc));
		tblDesc.add(getEu_shyjCDesc(tblDesc));
		tblDesc.add(getEu_jwsCDesc(tblDesc));
		tblDesc.add(getEu_qxCDesc(tblDesc));
		tblDesc.add(getId_qxxxCDesc(tblDesc));
		tblDesc.add(getSd_qxxxCDesc(tblDesc));
		tblDesc.add(getOther_qxxxCDesc(tblDesc));
		tblDesc.add(getEu_ysspCDesc(tblDesc));
		tblDesc.add(getId_ysspycxxCDesc(tblDesc));
		tblDesc.add(getSd_ysspycxxCDesc(tblDesc));
		tblDesc.add(getOther_ysspycxxCDesc(tblDesc));
		tblDesc.add(getEu_stzkslCDesc(tblDesc));
		tblDesc.add(getId_stzkslxxCDesc(tblDesc));
		tblDesc.add(getSd_stzkslxxCDesc(tblDesc));
		tblDesc.add(getOther_stzkslxxCDesc(tblDesc));
		tblDesc.add(getEu_stzktlCDesc(tblDesc));
		tblDesc.add(getId_stzktlxxCDesc(tblDesc));
		tblDesc.add(getSd_stzktlxxCDesc(tblDesc));
		tblDesc.add(getOther_stzktlxxCDesc(tblDesc));
		tblDesc.add(getEu_stzkyyCDesc(tblDesc));
		tblDesc.add(getId_stzkyyxxCDesc(tblDesc));
		tblDesc.add(getSd_stzkyyxxCDesc(tblDesc));
		tblDesc.add(getOther_stzkyyxxCDesc(tblDesc));
		tblDesc.add(getEu_stzkmrCDesc(tblDesc));
		tblDesc.add(getId_stzkmrxxCDesc(tblDesc));
		tblDesc.add(getSd_stzkmrxxCDesc(tblDesc));
		tblDesc.add(getOther_stzkmrxxCDesc(tblDesc));
		tblDesc.add(getEu_stzkjsCDesc(tblDesc));
		tblDesc.add(getId_stzkjsxxCDesc(tblDesc));
		tblDesc.add(getSd_stzkjsxxCDesc(tblDesc));
		tblDesc.add(getOther_stzkjsxxCDesc(tblDesc));
		tblDesc.add(getEu_stzkpnCDesc(tblDesc));
		tblDesc.add(getId_stzkpnxxCDesc(tblDesc));
		tblDesc.add(getSd_stzkpnxxCDesc(tblDesc));
		tblDesc.add(getOther_stzkpnxxCDesc(tblDesc));
		tblDesc.add(getEu_stzkpbCDesc(tblDesc));
		tblDesc.add(getId_stzkpbxxCDesc(tblDesc));
		tblDesc.add(getSd_stzkpbxxCDesc(tblDesc));
		tblDesc.add(getOther_stzkpbxxCDesc(tblDesc));
		tblDesc.add(getId_stzkhdCDesc(tblDesc));
		tblDesc.add(getSd_stzkhdCDesc(tblDesc));
		tblDesc.add(getOher_stzkhdCDesc(tblDesc));
		tblDesc.add(getEu_stzksmCDesc(tblDesc));
		tblDesc.add(getId_stzksmxxCDesc(tblDesc));
		tblDesc.add(getSd_stzksmxxCDesc(tblDesc));
		tblDesc.add(getOther_stzksmxxCDesc(tblDesc));
		tblDesc.add(getEu_stzkzlnlCDesc(tblDesc));
		tblDesc.add(getId_stzkzlnlxxCDesc(tblDesc));
		tblDesc.add(getSd_stzkzlnlxxCDesc(tblDesc));
		tblDesc.add(getOther_stzkzlnlxxCDesc(tblDesc));
		tblDesc.add(getEu_stzkpfCDesc(tblDesc));
		tblDesc.add(getId_pfyclxCDesc(tblDesc));
		tblDesc.add(getSd_pfyclxCDesc(tblDesc));
		tblDesc.add(getOther_pfyclxCDesc(tblDesc));
		tblDesc.add(getPressuresoreCDesc(tblDesc));
		tblDesc.add(getEu_glCDesc(tblDesc));
		tblDesc.add(getId_glylgCDesc(tblDesc));
		tblDesc.add(getSd_glylgCDesc(tblDesc));
		tblDesc.add(getOther_glylgCDesc(tblDesc));
		tblDesc.add(getId_glwzjmCDesc(tblDesc));
		tblDesc.add(getSd_glwzjmCDesc(tblDesc));
		tblDesc.add(getId_glsjmCDesc(tblDesc));
		tblDesc.add(getSd_glsjmCDesc(tblDesc));
		tblDesc.add(getOther_glsjmCDesc(tblDesc));
		tblDesc.add(getId_glrgqdCDesc(tblDesc));
		tblDesc.add(getSd_glrgqdCDesc(tblDesc));
		tblDesc.add(getEu_ddfxpgCDesc(tblDesc));
		tblDesc.add(getScore_falllCDesc(tblDesc));
		tblDesc.add(getInforsourcesCDesc(tblDesc));
		tblDesc.add(getSignatureCDesc(tblDesc));
		tblDesc.add(getDt_assessCDesc(tblDesc));
		tblDesc.add(getZkpgCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 入院护理评估单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_anaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ana",  getId_anaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院护理评估单主键");
		attrDesc.setNullable(false);
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
	 * 患者就诊ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者就诊ID");
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
	 * 患者性别id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex",  getId_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者性别id");
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
	 * 床号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bed",  getName_bedCDesc(tblDesc), this);
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
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
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
	 * 入院诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diagnosis",  getName_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管路其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGlqtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Glqt",  getGlqtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管路其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院来源方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_referalsrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_referalsrc",  getSd_referalsrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院来源方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院来源方式ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_referalsrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_referalsrc",  getId_referalsrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院来源方式ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 住院来院方式其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_referalsrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_referalsrc",  getOther_referalsrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院来院方式其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院行动方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ryxdfsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ryxdfs",  getId_ryxdfsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院行动方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院行动方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_yrxdfsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_yrxdfs",  getSd_yrxdfsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院行动方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院行动方式_其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRyxdfs_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ryxdfs_other",  getRyxdfs_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院行动方式_其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教育属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_jyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_jy",  getId_jyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 文化教育水平编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_jyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_jy",  getSd_jyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化教育水平编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宗教属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_zjADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_zj",  getEu_zjCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("宗教");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 陪伴属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_pbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_pb",  getEu_pbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("陪伴");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_gmsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_gms",  getEu_gmsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("过敏史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 嗜好吸烟属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_shxyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_shxy",  getEu_shxyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("嗜好吸烟");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 嗜好饮酒属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_shyjADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_shyj",  getEu_shyjCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("嗜好饮酒");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 既往史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_jwsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_jws",  getEu_jwsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("既往史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 情绪属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_qxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_qx",  getEu_qxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("情绪");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 情绪选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qxxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qxxx",  getId_qxxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情绪选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 情绪选项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_qxxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_qxxx",  getSd_qxxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情绪选项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 情绪选项其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_qxxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_qxxx",  getOther_qxxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情绪选项其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识水平属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ysspADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_yssp",  getEu_ysspCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("意识水平");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识水平异常选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ysspycxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ysspycxx",  getId_ysspycxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识水平异常选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 意识异常选项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ysspycxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ysspycxx",  getSd_ysspycxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识异常选项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识异常选项其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_ysspycxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_ysspycxx",  getOther_ysspycxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识异常选项其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况视力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_stzkslADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_stzksl",  getEu_stzkslCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("身体状况视力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况视力选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stzkslxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stzkslxx",  getId_stzkslxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身体状况视力选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 视力异常编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stzkslxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stzkslxx",  getSd_stzkslxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("视力异常编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 视力异常选项其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_stzkslxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_stzkslxx",  getOther_stzkslxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("视力异常选项其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况听力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_stzktlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_stzktl",  getEu_stzktlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("身体状况听力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况听力选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stzktlxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stzktlxx",  getId_stzktlxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身体状况听力选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 听力异常编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stzktlxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stzktlxx",  getSd_stzktlxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("听力异常编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 听力异常选项其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_stzktlxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_stzktlxx",  getOther_stzktlxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("听力异常选项其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况语言属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_stzkyyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_stzkyy",  getEu_stzkyyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("身体状况语言");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况语言选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stzkyyxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stzkyyxx",  getId_stzkyyxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身体状况语言选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 语音异常选项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stzkyyxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stzkyyxx",  getSd_stzkyyxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语音异常选项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 语言异常选项其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_stzkyyxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_stzkyyxx",  getOther_stzkyyxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语言异常选项其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况面容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_stzkmrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_stzkmr",  getEu_stzkmrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("身体状况面容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况面容选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stzkmrxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stzkmrxx",  getId_stzkmrxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身体状况面容选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 面容异常选项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stzkmrxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stzkmrxx",  getSd_stzkmrxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("面容异常选项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 面容异常选项其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_stzkmrxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_stzkmrxx",  getOther_stzkmrxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("面容异常选项其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况进食属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_stzkjsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_stzkjs",  getEu_stzkjsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("身体状况进食");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况进食选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stzkjsxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stzkjsxx",  getId_stzkjsxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身体状况进食选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 进食异常选项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stzkjsxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stzkjsxx",  getSd_stzkjsxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进食异常选项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进食异常选项其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_stzkjsxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_stzkjsxx",  getOther_stzkjsxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进食异常选项其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况排尿属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_stzkpnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_stzkpn",  getEu_stzkpnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("身体状况排尿");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况排尿选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stzkpnxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stzkpnxx",  getId_stzkpnxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身体状况排尿选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排尿异常选项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stzkpnxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stzkpnxx",  getSd_stzkpnxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排尿异常选项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排尿异常选项其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_stzkpnxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_stzkpnxx",  getOther_stzkpnxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排尿异常选项其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况排便属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_stzkpbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_stzkpb",  getEu_stzkpbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("身体状况排便");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况排便选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stzkpbxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stzkpbxx",  getId_stzkpbxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身体状况排便选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排便异常选项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stzkpbxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stzkpbxx",  getSd_stzkpbxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排便异常选项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排便异常选项其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_stzkpbxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_stzkpbxx",  getOther_stzkpbxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排便异常选项其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stzkhdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stzkhd",  getId_stzkhdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身体状况活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 活动编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stzkhdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stzkhd",  getSd_stzkhdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOher_stzkhdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oher_stzkhd",  getOher_stzkhdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况睡眠属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_stzksmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_stzksm",  getEu_stzksmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("身体状况睡眠");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况睡眠选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stzksmxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stzksmxx",  getId_stzksmxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身体状况睡眠选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 睡眠异常选项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stzksmxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stzksmxx",  getSd_stzksmxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠异常选项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 睡眠异常选项其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_stzksmxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_stzksmxx",  getOther_stzksmxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠异常选项其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况自理能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_stzkzlnlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_stzkzlnl",  getEu_stzkzlnlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("身体状况自理能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况自理能力选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stzkzlnlxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stzkzlnlxx",  getId_stzkzlnlxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身体状况自理能力选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 自理能力情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stzkzlnlxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stzkzlnlxx",  getSd_stzkzlnlxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自理能力情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自理能力情况其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_stzkzlnlxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_stzkzlnlxx",  getOther_stzkzlnlxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自理能力情况其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体状况皮肤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_stzkpfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_stzkpf",  getEu_stzkpfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("身体状况皮肤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤异常类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pfyclxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pfyclx",  getId_pfyclxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤异常类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤异常选项编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pfyclxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pfyclx",  getSd_pfyclxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤异常选项编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤异常选项其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_pfyclxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_pfyclx",  getOther_pfyclxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤异常选项其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPressuresoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pressuresore",  getPressuresoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("压疮评分");
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
	private IAttrDesc getEu_glADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_gl",  getEu_glCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("管路");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管路引流管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_glylgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_glylg",  getId_glylgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管路引流管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 引流管类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_glylgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_glylg",  getSd_glylgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流管类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流管类型其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_glylgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_glylg",  getOther_glylgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流管类型其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管路外周静脉属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_glwzjmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_glwzjm",  getId_glwzjmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管路外周静脉");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 外周静脉编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_glwzjmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_glwzjm",  getSd_glwzjmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("外周静脉编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管路深静脉属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_glsjmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_glsjm",  getId_glsjmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管路深静脉");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 深静脉编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_glsjmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_glsjm",  getSd_glsjmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("深静脉编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 深静脉其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_glsjmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_glsjm",  getOther_glsjmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("深静脉其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管路人工气道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_glrgqdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_glrgqd",  getId_glrgqdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("管路人工气道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 人工气道编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_glrgqdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_glrgqd",  getSd_glrgqdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人工气道编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒风险评估属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ddfxpgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ddfxpg",  getEu_ddfxpgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("跌倒风险评估");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_falllADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_falll",  getScore_falllCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 信息来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInforsourcesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inforsources",  getInforsourcesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("信息来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSignatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Signature",  getSignatureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 评估日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_assessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_assess",  getDt_assessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("评估日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 专科评估属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZkpgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zkpg",  getZkpgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("专科评估");
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_referalsrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_referalsrc",  getName_referalsrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_referalsrc=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院行动方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ryxdfsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ryxdfs",  getName_ryxdfsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院行动方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_ryxdfs=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教育属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_jyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_jy",  getName_jyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_jy=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 情绪异常选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qxxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_qxxx",  getName_qxxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情绪异常选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_qxxx=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识水平异常选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ysspycxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ysspycxx",  getName_ysspycxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识水平异常选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_ysspycxx=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 视力异常选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stzkslxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stzkslxx",  getName_stzkslxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("视力异常选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_stzkslxx=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 听力异常选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stzktlxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stzktlxx",  getName_stzktlxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("听力异常选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_stzktlxx=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 语音异常选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stzkyyxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stzkyyxx",  getName_stzkyyxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语音异常选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_stzkyyxx=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 面容异常选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stzkmrxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stzkmrxx",  getName_stzkmrxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("面容异常选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_stzkmrxx=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进食异常选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stzkjsxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stzkjsxx",  getName_stzkjsxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进食异常选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_stzkjsxx=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排尿异常选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stzkpnxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stzkpnxx",  getName_stzkpnxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排尿异常选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_stzkpnxx=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排便异常选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stzkpbxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stzkpbxx",  getName_stzkpbxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排便异常选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_stzkpbxx=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stzkhdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stzkhd",  getName_stzkhdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_stzkhd=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 睡眠异常选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stzksmxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stzksmxx",  getName_stzksmxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠异常选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_stzksmxx=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自理能力异常选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stzkzlnlxxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stzkzlnlxx",  getName_stzkzlnlxxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自理能力异常选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_stzkzlnlxx=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤异常选项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pfyclxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pfyclx",  getName_pfyclxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤异常选项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_pfyclx=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_glylgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_glylg",  getName_glylgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_glylg=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 外周静脉属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_glwzjmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_glwzjm",  getName_glwzjmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("外周静脉");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_glwzjm=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 深静脉属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_glsjmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_glsjm",  getName_glsjmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("深静脉");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_glsjm=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人工气道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_glrgqdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_glrgqd",  getName_glrgqdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人工气道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_glrgqd=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signatureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_signature",  getName_signatureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b8","signature=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取入院护理评估单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_anaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ana");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院护理评估单主键"); 
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
	 * 获取患者就诊ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者就诊ID"); 
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
	 * 获取患者性别id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者性别id"); 
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
	 * 获取床号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bed");
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
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院号"); 
		return column;
	}
	/**
	 * 获取入院诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagnosis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院诊断"); 
		return column;
	}
	/**
	 * 获取管路其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGlqtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Glqt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管路其它"); 
		return column;
	}
	/**
	 * 获取住院来源方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_referalsrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_referalsrc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院来源方式编码"); 
		return column;
	}
	/**
	 * 获取住院来源方式ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_referalsrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_referalsrc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院来源方式ID"); 
		return column;
	}
	/**
	 * 获取住院来院方式其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_referalsrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_referalsrc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院来院方式其他"); 
		return column;
	}
	/**
	 * 获取入院行动方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ryxdfsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ryxdfs");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院行动方式"); 
		return column;
	}
	/**
	 * 获取入院行动方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_yrxdfsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_yrxdfs");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院行动方式编码"); 
		return column;
	}
	/**
	 * 获取入院行动方式_其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRyxdfs_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ryxdfs_other");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院行动方式_其他"); 
		return column;
	}
	/**
	 * 获取教育表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_jyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_jy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育"); 
		return column;
	}
	/**
	 * 获取文化教育水平编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_jyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_jy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化教育水平编码"); 
		return column;
	}
	/**
	 * 获取宗教表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_zjCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_zj");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("宗教"); 
		return column;
	}
	/**
	 * 获取陪伴表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_pbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_pb");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("陪伴"); 
		return column;
	}
	/**
	 * 获取过敏史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_gmsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_gms");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("过敏史"); 
		return column;
	}
	/**
	 * 获取嗜好吸烟表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_shxyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_shxy");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("嗜好吸烟"); 
		return column;
	}
	/**
	 * 获取嗜好饮酒表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_shyjCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_shyj");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("嗜好饮酒"); 
		return column;
	}
	/**
	 * 获取既往史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_jwsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_jws");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("既往史"); 
		return column;
	}
	/**
	 * 获取情绪表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_qxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_qx");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("情绪"); 
		return column;
	}
	/**
	 * 获取情绪选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qxxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qxxx");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情绪选项"); 
		return column;
	}
	/**
	 * 获取情绪选项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_qxxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_qxxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情绪选项编码"); 
		return column;
	}
	/**
	 * 获取情绪选项其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_qxxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_qxxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情绪选项其他"); 
		return column;
	}
	/**
	 * 获取意识水平表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ysspCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_yssp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("意识水平"); 
		return column;
	}
	/**
	 * 获取意识水平异常选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ysspycxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ysspycxx");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识水平异常选项"); 
		return column;
	}
	/**
	 * 获取意识异常选项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ysspycxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ysspycxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识异常选项编码"); 
		return column;
	}
	/**
	 * 获取意识异常选项其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_ysspycxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_ysspycxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识异常选项其他"); 
		return column;
	}
	/**
	 * 获取身体状况视力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_stzkslCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_stzksl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身体状况视力"); 
		return column;
	}
	/**
	 * 获取身体状况视力选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stzkslxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stzkslxx");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身体状况视力选项"); 
		return column;
	}
	/**
	 * 获取视力异常编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stzkslxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stzkslxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("视力异常编码"); 
		return column;
	}
	/**
	 * 获取视力异常选项其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_stzkslxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_stzkslxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("视力异常选项其他"); 
		return column;
	}
	/**
	 * 获取身体状况听力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_stzktlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_stzktl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身体状况听力"); 
		return column;
	}
	/**
	 * 获取身体状况听力选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stzktlxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stzktlxx");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身体状况听力选项"); 
		return column;
	}
	/**
	 * 获取听力异常编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stzktlxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stzktlxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("听力异常编码"); 
		return column;
	}
	/**
	 * 获取听力异常选项其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_stzktlxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_stzktlxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("听力异常选项其他"); 
		return column;
	}
	/**
	 * 获取身体状况语言表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_stzkyyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_stzkyy");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身体状况语言"); 
		return column;
	}
	/**
	 * 获取身体状况语言选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stzkyyxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stzkyyxx");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身体状况语言选项"); 
		return column;
	}
	/**
	 * 获取语音异常选项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stzkyyxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stzkyyxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语音异常选项编码"); 
		return column;
	}
	/**
	 * 获取语言异常选项其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_stzkyyxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_stzkyyxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语言异常选项其他"); 
		return column;
	}
	/**
	 * 获取身体状况面容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_stzkmrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_stzkmr");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身体状况面容"); 
		return column;
	}
	/**
	 * 获取身体状况面容选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stzkmrxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stzkmrxx");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身体状况面容选项"); 
		return column;
	}
	/**
	 * 获取面容异常选项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stzkmrxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stzkmrxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面容异常选项编码"); 
		return column;
	}
	/**
	 * 获取面容异常选项其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_stzkmrxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_stzkmrxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面容异常选项其他"); 
		return column;
	}
	/**
	 * 获取身体状况进食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_stzkjsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_stzkjs");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身体状况进食"); 
		return column;
	}
	/**
	 * 获取身体状况进食选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stzkjsxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stzkjsxx");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身体状况进食选项"); 
		return column;
	}
	/**
	 * 获取进食异常选项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stzkjsxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stzkjsxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进食异常选项编码"); 
		return column;
	}
	/**
	 * 获取进食异常选项其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_stzkjsxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_stzkjsxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进食异常选项其他"); 
		return column;
	}
	/**
	 * 获取身体状况排尿表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_stzkpnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_stzkpn");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身体状况排尿"); 
		return column;
	}
	/**
	 * 获取身体状况排尿选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stzkpnxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stzkpnxx");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身体状况排尿选项"); 
		return column;
	}
	/**
	 * 获取排尿异常选项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stzkpnxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stzkpnxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排尿异常选项编码"); 
		return column;
	}
	/**
	 * 获取排尿异常选项其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_stzkpnxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_stzkpnxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排尿异常选项其他"); 
		return column;
	}
	/**
	 * 获取身体状况排便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_stzkpbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_stzkpb");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身体状况排便"); 
		return column;
	}
	/**
	 * 获取身体状况排便选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stzkpbxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stzkpbxx");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身体状况排便选项"); 
		return column;
	}
	/**
	 * 获取排便异常选项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stzkpbxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stzkpbxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排便异常选项编码"); 
		return column;
	}
	/**
	 * 获取排便异常选项其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_stzkpbxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_stzkpbxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排便异常选项其他"); 
		return column;
	}
	/**
	 * 获取身体状况活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stzkhdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stzkhd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身体状况活动"); 
		return column;
	}
	/**
	 * 获取活动编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stzkhdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stzkhd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动编码"); 
		return column;
	}
	/**
	 * 获取活动其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOher_stzkhdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oher_stzkhd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动其他"); 
		return column;
	}
	/**
	 * 获取身体状况睡眠表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_stzksmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_stzksm");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身体状况睡眠"); 
		return column;
	}
	/**
	 * 获取身体状况睡眠选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stzksmxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stzksmxx");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身体状况睡眠选项"); 
		return column;
	}
	/**
	 * 获取睡眠异常选项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stzksmxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stzksmxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠异常选项编码"); 
		return column;
	}
	/**
	 * 获取睡眠异常选项其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_stzksmxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_stzksmxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠异常选项其他"); 
		return column;
	}
	/**
	 * 获取身体状况自理能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_stzkzlnlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_stzkzlnl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身体状况自理能力"); 
		return column;
	}
	/**
	 * 获取身体状况自理能力选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stzkzlnlxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stzkzlnlxx");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身体状况自理能力选项"); 
		return column;
	}
	/**
	 * 获取自理能力情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stzkzlnlxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stzkzlnlxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理能力情况编码"); 
		return column;
	}
	/**
	 * 获取自理能力情况其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_stzkzlnlxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_stzkzlnlxx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理能力情况其他"); 
		return column;
	}
	/**
	 * 获取身体状况皮肤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_stzkpfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_stzkpf");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身体状况皮肤"); 
		return column;
	}
	/**
	 * 获取皮肤异常类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pfyclxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pfyclx");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤异常类型"); 
		return column;
	}
	/**
	 * 获取皮肤异常选项编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pfyclxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pfyclx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤异常选项编码"); 
		return column;
	}
	/**
	 * 获取皮肤异常选项其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_pfyclxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_pfyclx");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤异常选项其他"); 
		return column;
	}
	/**
	 * 获取压疮评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPressuresoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pressuresore");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("压疮评分"); 
		return column;
	}
	/**
	 * 获取管路表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_glCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_gl");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("管路"); 
		return column;
	}
	/**
	 * 获取管路引流管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_glylgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_glylg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管路引流管"); 
		return column;
	}
	/**
	 * 获取引流管类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_glylgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_glylg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流管类型编码"); 
		return column;
	}
	/**
	 * 获取引流管类型其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_glylgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_glylg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流管类型其他"); 
		return column;
	}
	/**
	 * 获取管路外周静脉表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_glwzjmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_glwzjm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管路外周静脉"); 
		return column;
	}
	/**
	 * 获取外周静脉编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_glwzjmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_glwzjm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("外周静脉编码"); 
		return column;
	}
	/**
	 * 获取管路深静脉表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_glsjmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_glsjm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管路深静脉"); 
		return column;
	}
	/**
	 * 获取深静脉编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_glsjmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_glsjm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("深静脉编码"); 
		return column;
	}
	/**
	 * 获取深静脉其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_glsjmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_glsjm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("深静脉其他"); 
		return column;
	}
	/**
	 * 获取管路人工气道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_glrgqdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_glrgqd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("管路人工气道"); 
		return column;
	}
	/**
	 * 获取人工气道编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_glrgqdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_glrgqd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人工气道编码"); 
		return column;
	}
	/**
	 * 获取跌倒风险评估表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ddfxpgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ddfxpg");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("跌倒风险评估"); 
		return column;
	}
	/**
	 * 获取跌倒评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_falllCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_falll");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒评分"); 
		return column;
	}
	/**
	 * 获取信息来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInforsourcesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inforsources");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("信息来源"); 
		return column;
	}
	/**
	 * 获取评估人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSignatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Signature");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估人"); 
		return column;
	}
	/**
	 * 获取评估日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_assessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_assess");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("评估日期"); 
		return column;
	}
	/**
	 * 获取专科评估表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZkpgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zkpg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("专科评估"); 
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
	 * 获取入院方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_referalsrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_referalsrc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式"); 
		return column;
	}
	/**
	 * 获取入院行动方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ryxdfsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ryxdfs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院行动方式"); 
		return column;
	}
	/**
	 * 获取教育表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_jyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_jy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育"); 
		return column;
	}
	/**
	 * 获取情绪异常选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qxxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_qxxx");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情绪异常选项"); 
		return column;
	}
	/**
	 * 获取意识水平异常选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ysspycxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ysspycxx");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识水平异常选项"); 
		return column;
	}
	/**
	 * 获取视力异常选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stzkslxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stzkslxx");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("视力异常选项"); 
		return column;
	}
	/**
	 * 获取听力异常选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stzktlxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stzktlxx");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("听力异常选项"); 
		return column;
	}
	/**
	 * 获取语音异常选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stzkyyxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stzkyyxx");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语音异常选项"); 
		return column;
	}
	/**
	 * 获取面容异常选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stzkmrxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stzkmrxx");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面容异常选项"); 
		return column;
	}
	/**
	 * 获取进食异常选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stzkjsxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stzkjsxx");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进食异常选项"); 
		return column;
	}
	/**
	 * 获取排尿异常选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stzkpnxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stzkpnxx");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排尿异常选项"); 
		return column;
	}
	/**
	 * 获取排便异常选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stzkpbxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stzkpbxx");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排便异常选项"); 
		return column;
	}
	/**
	 * 获取活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stzkhdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stzkhd");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动"); 
		return column;
	}
	/**
	 * 获取睡眠异常选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stzksmxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stzksmxx");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠异常选项"); 
		return column;
	}
	/**
	 * 获取自理能力异常选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stzkzlnlxxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stzkzlnlxx");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理能力异常选项"); 
		return column;
	}
	/**
	 * 获取皮肤异常选项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pfyclxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pfyclx");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤异常选项"); 
		return column;
	}
	/**
	 * 获取引流管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_glylgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_glylg");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流管"); 
		return column;
	}
	/**
	 * 获取外周静脉表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_glwzjmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_glwzjm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("外周静脉"); 
		return column;
	}
	/**
	 * 获取深静脉表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_glsjmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_glsjm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("深静脉"); 
		return column;
	}
	/**
	 * 获取人工气道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_glrgqdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_glrgqd");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人工气道"); 
		return column;
	}
	/**
	 * 获取评估人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signatureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_signature");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估人"); 
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
