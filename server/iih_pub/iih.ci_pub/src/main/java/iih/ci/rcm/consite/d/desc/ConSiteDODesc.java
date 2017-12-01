
package iih.ci.rcm.consite.d.desc;

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
 * 院感感染部位 DO 元数据信息
 */
public class ConSiteDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.consite.d.ConSiteDO";
	public static final String CLASS_DISPALYNAME = "院感感染部位";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_CONTAGION_SITE";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_site";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ConSiteDODesc(){
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
		this.setKeyDesc(getId_siteADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_siteADesc(tblDesc));
		this.add(getId_hospitalreportADesc(tblDesc));
		this.add(getInfectedateADesc(tblDesc));
		this.add(getId_infecte_siteADesc(tblDesc));
		this.add(getSd_infecte_siteADesc(tblDesc));
		this.add(getName_infecte_siteADesc(tblDesc));
		this.add(getInfecte_site_otherADesc(tblDesc));
		this.add(getId_di_infectionADesc(tblDesc));
		this.add(getSd_di_infectionADesc(tblDesc));
		this.add(getName_di_infectionADesc(tblDesc));
		this.add(getId_inva_operADesc(tblDesc));
		this.add(getSd_inva_operADesc(tblDesc));
		this.add(getName_inva_operADesc(tblDesc));
		this.add(getId_report_deptADesc(tblDesc));
		this.add(getName_report_deptADesc(tblDesc));
		this.add(getSd_report_deptADesc(tblDesc));
		this.add(getId_report_personADesc(tblDesc));
		this.add(getName_report_personADesc(tblDesc));
		this.add(getSd_report_personADesc(tblDesc));
		this.add(getDt_reportADesc(tblDesc));
		this.add(getOperationADesc(tblDesc));
		this.add(getInfecte_site_nameADesc(tblDesc));
		this.add(getInfecte_site_codeADesc(tblDesc));
		this.add(getDi_infection_codeADesc(tblDesc));
		this.add(getDi_infection_nameADesc(tblDesc));
		this.add(getInva_oper_codeADesc(tblDesc));
		this.add(getInva_oper_nameADesc(tblDesc));
		this.add(getReport_dept_codeADesc(tblDesc));
		this.add(getReport_dept_nameADesc(tblDesc));
		this.add(getReport_person_codeADesc(tblDesc));
		this.add(getReport_person_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_siteCDesc(tblDesc));
		tblDesc.add(getId_siteCDesc(tblDesc));
		tblDesc.add(getId_hospitalreportCDesc(tblDesc));
		tblDesc.add(getInfectedateCDesc(tblDesc));
		tblDesc.add(getId_infecte_siteCDesc(tblDesc));
		tblDesc.add(getSd_infecte_siteCDesc(tblDesc));
		tblDesc.add(getName_infecte_siteCDesc(tblDesc));
		tblDesc.add(getInfecte_site_otherCDesc(tblDesc));
		tblDesc.add(getId_di_infectionCDesc(tblDesc));
		tblDesc.add(getSd_di_infectionCDesc(tblDesc));
		tblDesc.add(getName_di_infectionCDesc(tblDesc));
		tblDesc.add(getId_inva_operCDesc(tblDesc));
		tblDesc.add(getSd_inva_operCDesc(tblDesc));
		tblDesc.add(getName_inva_operCDesc(tblDesc));
		tblDesc.add(getId_report_deptCDesc(tblDesc));
		tblDesc.add(getName_report_deptCDesc(tblDesc));
		tblDesc.add(getSd_report_deptCDesc(tblDesc));
		tblDesc.add(getId_report_personCDesc(tblDesc));
		tblDesc.add(getName_report_personCDesc(tblDesc));
		tblDesc.add(getSd_report_personCDesc(tblDesc));
		tblDesc.add(getDt_reportCDesc(tblDesc));
		tblDesc.add(getOperationCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 感染部位主键ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_site",  getId_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染部位主键ID");
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
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfectedateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infectedate",  getInfectedateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("感染日期");
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
	private IAttrDesc getId_infecte_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infecte_site",  getId_infecte_siteCDesc(tblDesc), this);
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
	private IAttrDesc getSd_infecte_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infecte_site",  getSd_infecte_siteCDesc(tblDesc), this);
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
	private IAttrDesc getName_infecte_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infecte_site",  getName_infecte_siteCDesc(tblDesc), this);
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
	 * 感染部位其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfecte_site_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infecte_site_other",  getInfecte_site_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染部位其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_di_infectionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_di_infection",  getId_di_infectionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 感染诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_di_infectionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_di_infection",  getSd_di_infectionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_di_infectionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_di_infection",  getName_di_infectionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 侵袭性操作属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inva_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_inva_oper",  getId_inva_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("侵袭性操作");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 侵袭性操作编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_inva_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_inva_oper",  getSd_inva_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("侵袭性操作编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 侵袭性操作名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_inva_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_inva_oper",  getName_inva_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("侵袭性操作名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_report_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_report_dept",  getId_report_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 报告科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_report_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_report_dept",  getName_report_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_report_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_report_dept",  getSd_report_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填报人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_report_personADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_report_person",  getId_report_personCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("填报人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 填报人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_report_personADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_report_person",  getName_report_personCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("填报人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填报人编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_report_personADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_report_person",  getSd_report_personCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("填报人编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填报日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_reportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_report",  getDt_reportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("填报日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOperationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Operation",  getOperationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作");
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
	private IAttrDesc getInfecte_site_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infecte_site_name",  getInfecte_site_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_infecte_site=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfecte_site_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infecte_site_code",  getInfecte_site_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_infecte_site=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_infection_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_infection_code",  getDi_infection_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b3","id_di_infection=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_infection_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_infection_name",  getDi_infection_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b3","id_di_infection=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInva_oper_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inva_oper_code",  getInva_oper_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_inva_oper=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInva_oper_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inva_oper_name",  getInva_oper_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_inva_oper=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReport_dept_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Report_dept_code",  getReport_dept_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b5","id_report_dept=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReport_dept_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Report_dept_name",  getReport_dept_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b5","id_report_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReport_person_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Report_person_code",  getReport_person_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_report_person=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReport_person_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Report_person_name",  getReport_person_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_report_person=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取感染部位主键ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_site");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("感染部位主键ID"); 
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
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("院感上报主卡主键"); 
		return column;
	}
	/**
	 * 获取感染日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfectedateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infectedate");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("感染日期"); 
		return column;
	}
	/**
	 * 获取感染部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infecte_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infecte_site");
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
	private IColumnDesc getSd_infecte_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infecte_site");
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
	private IColumnDesc getName_infecte_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infecte_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染部位名称"); 
		return column;
	}
	/**
	 * 获取感染部位其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfecte_site_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infecte_site_other");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染部位其他"); 
		return column;
	}
	/**
	 * 获取感染诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_di_infectionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_di_infection");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染诊断"); 
		return column;
	}
	/**
	 * 获取感染诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_di_infectionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_di_infection");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染诊断编码"); 
		return column;
	}
	/**
	 * 获取感染诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_di_infectionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_di_infection");
		column.setLength(3000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染诊断名称"); 
		return column;
	}
	/**
	 * 获取侵袭性操作表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inva_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_inva_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("侵袭性操作"); 
		return column;
	}
	/**
	 * 获取侵袭性操作编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_inva_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_inva_oper");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("侵袭性操作编码"); 
		return column;
	}
	/**
	 * 获取侵袭性操作名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_inva_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_inva_oper");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("侵袭性操作名称"); 
		return column;
	}
	/**
	 * 获取报告科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_report_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_report_dept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告科室"); 
		return column;
	}
	/**
	 * 获取报告科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_report_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_report_dept");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告科室名称"); 
		return column;
	}
	/**
	 * 获取报告科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_report_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_report_dept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告科室编码"); 
		return column;
	}
	/**
	 * 获取填报人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_report_personCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_report_person");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("填报人"); 
		return column;
	}
	/**
	 * 获取填报人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_report_personCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_report_person");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("填报人姓名"); 
		return column;
	}
	/**
	 * 获取填报人编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_report_personCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_report_person");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("填报人编码"); 
		return column;
	}
	/**
	 * 获取填报日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_reportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_report");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("填报日期"); 
		return column;
	}
	/**
	 * 获取操作表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOperationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Operation");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfecte_site_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infecte_site_name");
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
	private IColumnDesc getInfecte_site_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infecte_site_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_infection_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_infection_code");
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
	private IColumnDesc getDi_infection_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_infection_name");
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
	private IColumnDesc getInva_oper_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inva_oper_code");
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
	private IColumnDesc getInva_oper_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inva_oper_name");
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
	private IColumnDesc getReport_dept_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Report_dept_code");
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
	private IColumnDesc getReport_dept_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Report_dept_name");
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
	private IColumnDesc getReport_person_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Report_person_code");
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
	private IColumnDesc getReport_person_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Report_person_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
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
