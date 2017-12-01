
package iih.ci.mrfp.other2mrfp.d.desc;

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
 * 病案首页其他信息 DO 元数据信息
 */
public class CiMrFpOtherDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrfp.other2mrfp.d.CiMrFpOtherDO";
	public static final String CLASS_DISPALYNAME = "病案首页其他信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_FP_OTHER";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_cimrfpother";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiMrFpOtherDODesc(){
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
		this.setKeyDesc(getId_cimrfpotherADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_cimrfpotherADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_mrtpADesc(tblDesc));
		this.add(getId_drug_allergyADesc(tblDesc));
		this.add(getName_drug_allergyADesc(tblDesc));
		this.add(getAllergic_drugsADesc(tblDesc));
		this.add(getId_blood_typeADesc(tblDesc));
		this.add(getName_blood_typeADesc(tblDesc));
		this.add(getId_rh_typeADesc(tblDesc));
		this.add(getName_rh_typeADesc(tblDesc));
		this.add(getDirofdeptADesc(tblDesc));
		this.add(getName_zr_docADesc(tblDesc));
		this.add(getName_zz_docADesc(tblDesc));
		this.add(getName_zy_docADesc(tblDesc));
		this.add(getName_emp_phyADesc(tblDesc));
		this.add(getName_emp_nurADesc(tblDesc));
		this.add(getName_learn_docADesc(tblDesc));
		this.add(getName_intern_docADesc(tblDesc));
		this.add(getName_qcp_docADesc(tblDesc));
		this.add(getName_qcp_nurADesc(tblDesc));
		this.add(getName_coderADesc(tblDesc));
		this.add(getId_qom_recordADesc(tblDesc));
		this.add(getName_qom_recordADesc(tblDesc));
		this.add(getQc_dateADesc(tblDesc));
		this.add(getNum_pathoADesc(tblDesc));
		this.add(getOut_hos_modeADesc(tblDesc));
		this.add(getName_out_hos_modeADesc(tblDesc));
		this.add(getName_med_in_1ADesc(tblDesc));
		this.add(getName_med_in_2ADesc(tblDesc));
		this.add(getId_aut_dead_patADesc(tblDesc));
		this.add(getName_aut_dead_patADesc(tblDesc));
		this.add(getId_is_have_inhos_planADesc(tblDesc));
		this.add(getName_is_have_inhos_planADesc(tblDesc));
		this.add(getGoal_inhos_planADesc(tblDesc));
		this.add(getComa_time_bef_inhos_daysADesc(tblDesc));
		this.add(getComa_time_bef_inhos_hoursADesc(tblDesc));
		this.add(getComa_time_bef_inhos_minsADesc(tblDesc));
		this.add(getComa_time_inhos_daysADesc(tblDesc));
		this.add(getComa_time_inhos_hoursADesc(tblDesc));
		this.add(getComa_time_inhos_minsADesc(tblDesc));
		this.add(getVentilator_use_timeADesc(tblDesc));
		this.add(getTumor_grade_tADesc(tblDesc));
		this.add(getTumor_grade_nADesc(tblDesc));
		this.add(getTumor_grade_mADesc(tblDesc));
		this.add(getDlb_score_inADesc(tblDesc));
		this.add(getDlb_score_outADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_cimrfpotherCDesc(tblDesc));
		tblDesc.add(getId_cimrfpotherCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_mrtpCDesc(tblDesc));
		tblDesc.add(getId_drug_allergyCDesc(tblDesc));
		tblDesc.add(getName_drug_allergyCDesc(tblDesc));
		tblDesc.add(getAllergic_drugsCDesc(tblDesc));
		tblDesc.add(getId_blood_typeCDesc(tblDesc));
		tblDesc.add(getName_blood_typeCDesc(tblDesc));
		tblDesc.add(getId_rh_typeCDesc(tblDesc));
		tblDesc.add(getName_rh_typeCDesc(tblDesc));
		tblDesc.add(getDirofdeptCDesc(tblDesc));
		tblDesc.add(getName_zr_docCDesc(tblDesc));
		tblDesc.add(getName_zz_docCDesc(tblDesc));
		tblDesc.add(getName_zy_docCDesc(tblDesc));
		tblDesc.add(getName_emp_phyCDesc(tblDesc));
		tblDesc.add(getName_emp_nurCDesc(tblDesc));
		tblDesc.add(getName_learn_docCDesc(tblDesc));
		tblDesc.add(getName_intern_docCDesc(tblDesc));
		tblDesc.add(getName_qcp_docCDesc(tblDesc));
		tblDesc.add(getName_qcp_nurCDesc(tblDesc));
		tblDesc.add(getName_coderCDesc(tblDesc));
		tblDesc.add(getId_qom_recordCDesc(tblDesc));
		tblDesc.add(getName_qom_recordCDesc(tblDesc));
		tblDesc.add(getQc_dateCDesc(tblDesc));
		tblDesc.add(getNum_pathoCDesc(tblDesc));
		tblDesc.add(getOut_hos_modeCDesc(tblDesc));
		tblDesc.add(getName_out_hos_modeCDesc(tblDesc));
		tblDesc.add(getName_med_in_1CDesc(tblDesc));
		tblDesc.add(getName_med_in_2CDesc(tblDesc));
		tblDesc.add(getId_aut_dead_patCDesc(tblDesc));
		tblDesc.add(getName_aut_dead_patCDesc(tblDesc));
		tblDesc.add(getId_is_have_inhos_planCDesc(tblDesc));
		tblDesc.add(getName_is_have_inhos_planCDesc(tblDesc));
		tblDesc.add(getGoal_inhos_planCDesc(tblDesc));
		tblDesc.add(getComa_time_bef_inhos_daysCDesc(tblDesc));
		tblDesc.add(getComa_time_bef_inhos_hoursCDesc(tblDesc));
		tblDesc.add(getComa_time_bef_inhos_minsCDesc(tblDesc));
		tblDesc.add(getComa_time_inhos_daysCDesc(tblDesc));
		tblDesc.add(getComa_time_inhos_hoursCDesc(tblDesc));
		tblDesc.add(getComa_time_inhos_minsCDesc(tblDesc));
		tblDesc.add(getVentilator_use_timeCDesc(tblDesc));
		tblDesc.add(getTumor_grade_tCDesc(tblDesc));
		tblDesc.add(getTumor_grade_nCDesc(tblDesc));
		tblDesc.add(getTumor_grade_mCDesc(tblDesc));
		tblDesc.add(getDlb_score_inCDesc(tblDesc));
		tblDesc.add(getDlb_score_outCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 病案首页其他信息ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cimrfpotherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cimrfpother",  getId_cimrfpotherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案首页其他信息ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者就诊号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者就诊号");
		attrDesc.setNullable(false);
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
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病案首页主表id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtp",  getId_mrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案首页主表id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有无药物过敏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drug_allergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drug_allergy",  getId_drug_allergyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有无药物过敏");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 有无药物过敏名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drug_allergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drug_allergy",  getName_drug_allergyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有无药物过敏名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏药物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAllergic_drugsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Allergic_drugs",  getAllergic_drugsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏药物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blood_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blood_type",  getId_blood_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_blood_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_blood_type",  getName_blood_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * RH血型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rh_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rh_type",  getId_rh_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("RH血型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * RH血型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rh_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rh_type",  getName_rh_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("RH血型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科主任属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDirofdeptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dirofdept",  getDirofdeptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科主任");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主任（副主任）医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_zr_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_zr_doc",  getName_zr_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主任（副主任）医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主治医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_zz_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_zz_doc",  getName_zz_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主治医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_zy_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_zy_doc",  getName_zy_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主诊医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_phy",  getName_emp_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主诊医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 责任护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_nur",  getName_emp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("责任护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进修医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_learn_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_learn_doc",  getName_learn_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进修医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实习医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_intern_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_intern_doc",  getName_intern_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实习医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qcp_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_qcp_doc",  getName_qcp_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qcp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_qcp_nur",  getName_qcp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_coderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_coder",  getName_coderCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病案质量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qom_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qom_record",  getId_qom_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案质量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病案质量名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qom_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_qom_record",  getName_qom_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案质量名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQc_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qc_date",  getQc_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("质控日期");
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
	private IAttrDesc getNum_pathoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_patho",  getNum_pathoCDesc(tblDesc), this);
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
	 * 离院方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOut_hos_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Out_hos_mode",  getOut_hos_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("离院方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 离院方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_out_hos_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_out_hos_mode",  getName_out_hos_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("离院方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱转院_转入医疗机构名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_med_in_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_med_in_1",  getName_med_in_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱转院_转入医疗机构名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱转社区_转入医疗机构名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_med_in_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_med_in_2",  getName_med_in_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱转社区_转入医疗机构名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死亡患者尸检属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aut_dead_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aut_dead_pat",  getId_aut_dead_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("死亡患者尸检");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 死亡患者尸检名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_aut_dead_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_aut_dead_pat",  getName_aut_dead_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("死亡患者尸检名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有出院31天内再住院的计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_is_have_inhos_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_is_have_inhos_plan",  getId_is_have_inhos_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有出院31天内再住院的计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否有出院31天内再住院的计划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_is_have_inhos_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_is_have_inhos_plan",  getName_is_have_inhos_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有出院31天内再住院的计划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 再次入院目的属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGoal_inhos_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Goal_inhos_plan",  getGoal_inhos_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("再次入院目的");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComa_time_bef_inhos_daysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coma_time_bef_inhos_days",  getComa_time_bef_inhos_daysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("昏迷时间（颅脑损伤患者）入院前 天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 小时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComa_time_bef_inhos_hoursADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coma_time_bef_inhos_hours",  getComa_time_bef_inhos_hoursCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("昏迷时间（颅脑损伤患者）入院前 小时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 分钟属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComa_time_bef_inhos_minsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coma_time_bef_inhos_mins",  getComa_time_bef_inhos_minsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("昏迷时间（颅脑损伤患者）入院前 分钟");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 昏迷时间入院后 天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComa_time_inhos_daysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coma_time_inhos_days",  getComa_time_inhos_daysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("昏迷时间入院后 天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 昏迷时间入院后 小时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComa_time_inhos_hoursADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coma_time_inhos_hours",  getComa_time_inhos_hoursCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("昏迷时间入院后 小时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 昏迷时间入院后 分钟属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComa_time_inhos_minsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coma_time_inhos_mins",  getComa_time_inhos_minsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("昏迷时间入院后 分钟");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸机使用时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVentilator_use_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ventilator_use_time",  getVentilator_use_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呼吸机使用时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肿瘤分期T属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTumor_grade_tADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tumor_grade_t",  getTumor_grade_tCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肿瘤分期T");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肿瘤分期N属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTumor_grade_nADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tumor_grade_n",  getTumor_grade_nCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肿瘤分期N");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肿瘤分期M属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTumor_grade_mADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tumor_grade_m",  getTumor_grade_mCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肿瘤分期M");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日常生活能力评定量表得分入院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDlb_score_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dlb_score_in",  getDlb_score_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日常生活能力评定量表得分入院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日常生活能力评定量表得分出院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDlb_score_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dlb_score_out",  getDlb_score_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日常生活能力评定量表得分出院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取病案首页其他信息ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cimrfpotherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cimrfpother");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病案首页其他信息ID"); 
		return column;
	}
	/**
	 * 获取患者就诊号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者就诊号"); 
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
	 * 获取病案首页主表id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案首页主表id"); 
		return column;
	}
	/**
	 * 获取有无药物过敏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drug_allergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drug_allergy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有无药物过敏"); 
		return column;
	}
	/**
	 * 获取有无药物过敏名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drug_allergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drug_allergy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有无药物过敏名称"); 
		return column;
	}
	/**
	 * 获取过敏药物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAllergic_drugsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Allergic_drugs");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏药物"); 
		return column;
	}
	/**
	 * 获取血型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blood_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blood_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血型"); 
		return column;
	}
	/**
	 * 获取血型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_blood_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_blood_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血型名称"); 
		return column;
	}
	/**
	 * 获取RH血型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rh_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rh_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("RH血型"); 
		return column;
	}
	/**
	 * 获取RH血型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rh_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rh_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("RH血型名称"); 
		return column;
	}
	/**
	 * 获取科主任表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDirofdeptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dirofdept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科主任"); 
		return column;
	}
	/**
	 * 获取主任（副主任）医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_zr_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_zr_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主任（副主任）医师"); 
		return column;
	}
	/**
	 * 获取主治医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_zz_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_zz_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主治医师"); 
		return column;
	}
	/**
	 * 获取住院医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_zy_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_zy_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院医师"); 
		return column;
	}
	/**
	 * 获取主诊医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主诊医师"); 
		return column;
	}
	/**
	 * 获取责任护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("责任护士"); 
		return column;
	}
	/**
	 * 获取进修医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_learn_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_learn_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进修医师"); 
		return column;
	}
	/**
	 * 获取实习医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_intern_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_intern_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实习医师"); 
		return column;
	}
	/**
	 * 获取质控医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qcp_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_qcp_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控医师"); 
		return column;
	}
	/**
	 * 获取质控护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qcp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_qcp_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控护士"); 
		return column;
	}
	/**
	 * 获取编码员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_coderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_coder");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码员"); 
		return column;
	}
	/**
	 * 获取病案质量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qom_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qom_record");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案质量"); 
		return column;
	}
	/**
	 * 获取病案质量名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qom_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_qom_record");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案质量名称"); 
		return column;
	}
	/**
	 * 获取质控日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQc_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qc_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("质控日期"); 
		return column;
	}
	/**
	 * 获取病理号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_pathoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_patho");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病理号"); 
		return column;
	}
	/**
	 * 获取离院方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOut_hos_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Out_hos_mode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("离院方式"); 
		return column;
	}
	/**
	 * 获取离院方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_out_hos_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_out_hos_mode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("离院方式名称"); 
		return column;
	}
	/**
	 * 获取医嘱转院_转入医疗机构名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_med_in_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_med_in_1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱转院_转入医疗机构名称"); 
		return column;
	}
	/**
	 * 获取医嘱转社区_转入医疗机构名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_med_in_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_med_in_2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱转社区_转入医疗机构名称"); 
		return column;
	}
	/**
	 * 获取死亡患者尸检表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aut_dead_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aut_dead_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("死亡患者尸检"); 
		return column;
	}
	/**
	 * 获取死亡患者尸检名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_aut_dead_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_aut_dead_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("死亡患者尸检名称"); 
		return column;
	}
	/**
	 * 获取是否有出院31天内再住院的计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_is_have_inhos_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_is_have_inhos_plan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有出院31天内再住院的计划"); 
		return column;
	}
	/**
	 * 获取是否有出院31天内再住院的计划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_is_have_inhos_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_is_have_inhos_plan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有出院31天内再住院的计划名称"); 
		return column;
	}
	/**
	 * 获取再次入院目的表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGoal_inhos_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Goal_inhos_plan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("再次入院目的"); 
		return column;
	}
	/**
	 * 获取昏迷时间（颅脑损伤患者）入院前 天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComa_time_bef_inhos_daysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coma_time_bef_inhos_days");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("昏迷时间（颅脑损伤患者）入院前 天数"); 
		return column;
	}
	/**
	 * 获取昏迷时间（颅脑损伤患者）入院前 小时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComa_time_bef_inhos_hoursCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coma_time_bef_inhos_hours");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("昏迷时间（颅脑损伤患者）入院前 小时"); 
		return column;
	}
	/**
	 * 获取昏迷时间（颅脑损伤患者）入院前 分钟表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComa_time_bef_inhos_minsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coma_time_bef_inhos_mins");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("昏迷时间（颅脑损伤患者）入院前 分钟"); 
		return column;
	}
	/**
	 * 获取昏迷时间入院后 天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComa_time_inhos_daysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coma_time_inhos_days");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("昏迷时间入院后 天数"); 
		return column;
	}
	/**
	 * 获取昏迷时间入院后 小时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComa_time_inhos_hoursCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coma_time_inhos_hours");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("昏迷时间入院后 小时"); 
		return column;
	}
	/**
	 * 获取昏迷时间入院后 分钟表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComa_time_inhos_minsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coma_time_inhos_mins");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("昏迷时间入院后 分钟"); 
		return column;
	}
	/**
	 * 获取呼吸机使用时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVentilator_use_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ventilator_use_time");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸机使用时间"); 
		return column;
	}
	/**
	 * 获取肿瘤分期T表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTumor_grade_tCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tumor_grade_t");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肿瘤分期T"); 
		return column;
	}
	/**
	 * 获取肿瘤分期N表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTumor_grade_nCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tumor_grade_n");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肿瘤分期N"); 
		return column;
	}
	/**
	 * 获取肿瘤分期M表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTumor_grade_mCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tumor_grade_m");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肿瘤分期M"); 
		return column;
	}
	/**
	 * 获取日常生活能力评定量表得分入院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDlb_score_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dlb_score_in");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日常生活能力评定量表得分入院"); 
		return column;
	}
	/**
	 * 获取日常生活能力评定量表得分出院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDlb_score_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dlb_score_out");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日常生活能力评定量表得分出院"); 
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
