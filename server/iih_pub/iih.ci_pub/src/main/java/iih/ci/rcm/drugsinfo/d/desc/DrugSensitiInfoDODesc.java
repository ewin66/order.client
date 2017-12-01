
package iih.ci.rcm.drugsinfo.d.desc;

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
 * 药敏信息 DO 元数据信息
 */
public class DrugSensitiInfoDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.drugsinfo.d.DrugSensitiInfoDO";
	public static final String CLASS_DISPALYNAME = "药敏信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_CONTAGION_CARD_DSI";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_drugseinfo";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public DrugSensitiInfoDODesc(){
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
		this.setKeyDesc(getId_drugseinfoADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_drugseinfoADesc(tblDesc));
		this.add(getId_hospitalreportADesc(tblDesc));
		this.add(getId_samplenameADesc(tblDesc));
		this.add(getSd_samplenameADesc(tblDesc));
		this.add(getName_samplenameADesc(tblDesc));
		this.add(getSubmission_dateADesc(tblDesc));
		this.add(getId_test_methodADesc(tblDesc));
		this.add(getSd_test_methodADesc(tblDesc));
		this.add(getName_test_methodADesc(tblDesc));
		this.add(getId_pathogen_speciesADesc(tblDesc));
		this.add(getSd_pathogen_speciesADesc(tblDesc));
		this.add(getName_pathogen_speciesADesc(tblDesc));
		this.add(getId_spe_test_resultADesc(tblDesc));
		this.add(getSd_spe_test_resultADesc(tblDesc));
		this.add(getName_spe_test_resultADesc(tblDesc));
		this.add(getDrug_sen_testADesc(tblDesc));
		this.add(getDrug_sen_resultADesc(tblDesc));
		this.add(getId_infe_siteADesc(tblDesc));
		this.add(getSd_infe_siteADesc(tblDesc));
		this.add(getName_infe_siteADesc(tblDesc));
		this.add(getSamplename_codeADesc(tblDesc));
		this.add(getSamplename_nameADesc(tblDesc));
		this.add(getTest_method_codeADesc(tblDesc));
		this.add(getTest_method_nameADesc(tblDesc));
		this.add(getPathogen_species_codeADesc(tblDesc));
		this.add(getPathogen_species_nameADesc(tblDesc));
		this.add(getSpe_test_result_codeADesc(tblDesc));
		this.add(getSpe_test_result_nameADesc(tblDesc));
		this.add(getInfe_site_codeADesc(tblDesc));
		this.add(getInfe_site_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_drugseinfoCDesc(tblDesc));
		tblDesc.add(getId_drugseinfoCDesc(tblDesc));
		tblDesc.add(getId_hospitalreportCDesc(tblDesc));
		tblDesc.add(getId_samplenameCDesc(tblDesc));
		tblDesc.add(getSd_samplenameCDesc(tblDesc));
		tblDesc.add(getName_samplenameCDesc(tblDesc));
		tblDesc.add(getSubmission_dateCDesc(tblDesc));
		tblDesc.add(getId_test_methodCDesc(tblDesc));
		tblDesc.add(getSd_test_methodCDesc(tblDesc));
		tblDesc.add(getName_test_methodCDesc(tblDesc));
		tblDesc.add(getId_pathogen_speciesCDesc(tblDesc));
		tblDesc.add(getSd_pathogen_speciesCDesc(tblDesc));
		tblDesc.add(getName_pathogen_speciesCDesc(tblDesc));
		tblDesc.add(getId_spe_test_resultCDesc(tblDesc));
		tblDesc.add(getSd_spe_test_resultCDesc(tblDesc));
		tblDesc.add(getName_spe_test_resultCDesc(tblDesc));
		tblDesc.add(getDrug_sen_testCDesc(tblDesc));
		tblDesc.add(getDrug_sen_resultCDesc(tblDesc));
		tblDesc.add(getId_infe_siteCDesc(tblDesc));
		tblDesc.add(getSd_infe_siteCDesc(tblDesc));
		tblDesc.add(getName_infe_siteCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 药敏信息主键ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drugseinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drugseinfo",  getId_drugseinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药敏信息主键ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 院感上报主卡主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hospitalreportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hospitalreport",  getId_hospitalreportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("院感上报主卡主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 样本名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_samplenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_samplename",  getId_samplenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("样本名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 样本名称编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_samplenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_samplename",  getSd_samplenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("样本名称编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 样本名称名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_samplenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_samplename",  getName_samplenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("样本名称名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 送检日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSubmission_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Submission_date",  getSubmission_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("送检日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验方法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_test_methodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_test_method",  getId_test_methodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验方法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 检验方法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_test_methodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_test_method",  getSd_test_methodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验方法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验方法名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_test_methodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_test_method",  getName_test_methodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验方法名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病原体种类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pathogen_speciesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pathogen_species",  getId_pathogen_speciesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病原体种类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病原体种类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pathogen_speciesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pathogen_species",  getSd_pathogen_speciesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病原体种类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病原体种类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pathogen_speciesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pathogen_species",  getName_pathogen_speciesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病原体种类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本检验结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_spe_test_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_spe_test_result",  getId_spe_test_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本检验结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 标本检验结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_spe_test_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_spe_test_result",  getSd_spe_test_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本检验结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标本检验结果名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_spe_test_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_spe_test_result",  getName_spe_test_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标本检验结果名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病原菌抗生素药敏实验属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrug_sen_testADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drug_sen_test",  getDrug_sen_testCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("病原菌抗生素药敏实验");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病原菌抗生素药敏结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrug_sen_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drug_sen_result",  getDrug_sen_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("病原菌抗生素药敏结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infe_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infe_site",  getId_infe_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 感染部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_infe_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infe_site",  getSd_infe_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染部位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infe_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infe_site",  getName_infe_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染部位名称");
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
	private IAttrDesc getSamplename_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Samplename_code",  getSamplename_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_samplename=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSamplename_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Samplename_name",  getSamplename_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_samplename=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTest_method_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Test_method_code",  getTest_method_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_test_method=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTest_method_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Test_method_name",  getTest_method_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_test_method=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPathogen_species_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pathogen_species_code",  getPathogen_species_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_pathogen_species=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPathogen_species_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pathogen_species_name",  getPathogen_species_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_pathogen_species=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpe_test_result_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spe_test_result_code",  getSpe_test_result_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_spe_test_result=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpe_test_result_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spe_test_result_name",  getSpe_test_result_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_spe_test_result=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfe_site_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infe_site_code",  getInfe_site_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_infe_site=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfe_site_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infe_site_name",  getInfe_site_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_infe_site=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取药敏信息主键ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drugseinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drugseinfo");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("药敏信息主键ID"); 
		return column;
	}
	/**
	 * 获取院感上报主卡主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hospitalreportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hospitalreport");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("院感上报主卡主键"); 
		return column;
	}
	/**
	 * 获取样本名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_samplenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_samplename");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("样本名称"); 
		return column;
	}
	/**
	 * 获取样本名称编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_samplenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_samplename");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("样本名称编码"); 
		return column;
	}
	/**
	 * 获取样本名称名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_samplenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_samplename");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("样本名称名称"); 
		return column;
	}
	/**
	 * 获取送检日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSubmission_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Submission_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("送检日期"); 
		return column;
	}
	/**
	 * 获取检验方法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_test_methodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_test_method");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验方法"); 
		return column;
	}
	/**
	 * 获取检验方法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_test_methodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_test_method");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验方法编码"); 
		return column;
	}
	/**
	 * 获取检验方法名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_test_methodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_test_method");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验方法名称"); 
		return column;
	}
	/**
	 * 获取病原体种类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pathogen_speciesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pathogen_species");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病原体种类"); 
		return column;
	}
	/**
	 * 获取病原体种类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pathogen_speciesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pathogen_species");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病原体种类编码"); 
		return column;
	}
	/**
	 * 获取病原体种类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pathogen_speciesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pathogen_species");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病原体种类名称"); 
		return column;
	}
	/**
	 * 获取标本检验结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_spe_test_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_spe_test_result");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本检验结果"); 
		return column;
	}
	/**
	 * 获取标本检验结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_spe_test_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_spe_test_result");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本检验结果编码"); 
		return column;
	}
	/**
	 * 获取标本检验结果名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_spe_test_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_spe_test_result");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标本检验结果名称"); 
		return column;
	}
	/**
	 * 获取病原菌抗生素药敏实验表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrug_sen_testCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drug_sen_test");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病原菌抗生素药敏实验"); 
		return column;
	}
	/**
	 * 获取病原菌抗生素药敏结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrug_sen_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drug_sen_result");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病原菌抗生素药敏结果"); 
		return column;
	}
	/**
	 * 获取感染部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infe_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infe_site");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染部位"); 
		return column;
	}
	/**
	 * 获取感染部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_infe_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infe_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染部位编码"); 
		return column;
	}
	/**
	 * 获取感染部位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_infe_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infe_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染部位名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSamplename_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Samplename_code");
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
	private IColumnDesc getSamplename_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Samplename_name");
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
	private IColumnDesc getTest_method_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Test_method_code");
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
	private IColumnDesc getTest_method_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Test_method_name");
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
	private IColumnDesc getPathogen_species_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pathogen_species_code");
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
	private IColumnDesc getPathogen_species_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pathogen_species_name");
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
	private IColumnDesc getSpe_test_result_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spe_test_result_code");
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
	private IColumnDesc getSpe_test_result_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spe_test_result_name");
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
	private IColumnDesc getInfe_site_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infe_site_code");
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
	private IColumnDesc getInfe_site_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infe_site_name");
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
