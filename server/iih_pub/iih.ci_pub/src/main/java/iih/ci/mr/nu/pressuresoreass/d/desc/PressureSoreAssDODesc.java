
package iih.ci.mr.nu.pressuresoreass.d.desc;

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
 * 压疮危险因素评估单 DO 元数据信息
 */
public class PressureSoreAssDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.pressuresoreass.d.PressureSoreAssDO";
	public static final String CLASS_DISPALYNAME = "压疮危险因素评估单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_NU_PUSA";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_puas";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PressureSoreAssDODesc(){
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
		this.setKeyDesc(getId_puasADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_puasADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getId_dep_phyADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getId_sores_physicalADesc(tblDesc));
		this.add(getSd_sores_physicalADesc(tblDesc));
		this.add(getSores_physicalADesc(tblDesc));
		this.add(getId_sores_skinADesc(tblDesc));
		this.add(getSd_sores_skinADesc(tblDesc));
		this.add(getSores_skinADesc(tblDesc));
		this.add(getId_sores_sexADesc(tblDesc));
		this.add(getSd_sores_sexADesc(tblDesc));
		this.add(getSores_sexADesc(tblDesc));
		this.add(getId_sores_ageADesc(tblDesc));
		this.add(getSd_sores_ageADesc(tblDesc));
		this.add(getSores_ageADesc(tblDesc));
		this.add(getId_sores_wgt_decADesc(tblDesc));
		this.add(getSd_sores_wgt_decADesc(tblDesc));
		this.add(getId_sores_wgt_scADesc(tblDesc));
		this.add(getSd_sores_wgt_scADesc(tblDesc));
		this.add(getSores_wgt_scADesc(tblDesc));
		this.add(getId_sores_loss_appetiteADesc(tblDesc));
		this.add(getSd_sores_loss_appetiteADesc(tblDesc));
		this.add(getSores_loss_appetiteADesc(tblDesc));
		this.add(getId_sores_incontinenceADesc(tblDesc));
		this.add(getSd_sores_incontinenceADesc(tblDesc));
		this.add(getSores_incontinenceADesc(tblDesc));
		this.add(getId_sores_sportADesc(tblDesc));
		this.add(getSd_sores_sportADesc(tblDesc));
		this.add(getSores_sportADesc(tblDesc));
		this.add(getId_sores_nutritionADesc(tblDesc));
		this.add(getSd_sores_nutritionADesc(tblDesc));
		this.add(getSores_nutritionADesc(tblDesc));
		this.add(getId_sores_nervousADesc(tblDesc));
		this.add(getSd_sores_nervousADesc(tblDesc));
		this.add(getSores_nervousADesc(tblDesc));
		this.add(getId_sores_traumaADesc(tblDesc));
		this.add(getSd_sores_traumaADesc(tblDesc));
		this.add(getSores_traumaADesc(tblDesc));
		this.add(getId_sores_drugADesc(tblDesc));
		this.add(getSd_sores_drugADesc(tblDesc));
		this.add(getSores_drugADesc(tblDesc));
		this.add(getTotal_scoreADesc(tblDesc));
		this.add(getAss_resultADesc(tblDesc));
		this.add(getDt_assADesc(tblDesc));
		this.add(getId_nur_psnADesc(tblDesc));
		this.add(getId_headnur_psnADesc(tblDesc));
		this.add(getRelationADesc(tblDesc));
		this.add(getVirus_nerveADesc(tblDesc));
		this.add(getSport_nerveADesc(tblDesc));
		this.add(getHem_nerveADesc(tblDesc));
		this.add(getCell_medADesc(tblDesc));
		this.add(getLong_medADesc(tblDesc));
		this.add(getBiotic_medADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_sores_physicalADesc(tblDesc));
		this.add(getName_sores_skinADesc(tblDesc));
		this.add(getName_sores_sexADesc(tblDesc));
		this.add(getName_sores_ageADesc(tblDesc));
		this.add(getName_sores_wgt_decADesc(tblDesc));
		this.add(getName_sores_wgt_scADesc(tblDesc));
		this.add(getName_sores_lossADesc(tblDesc));
		this.add(getName_sores_inconADesc(tblDesc));
		this.add(getName_sores_sportADesc(tblDesc));
		this.add(getName_sores_nutrADesc(tblDesc));
		this.add(getName_sores_nerADesc(tblDesc));
		this.add(getName_sores_traADesc(tblDesc));
		this.add(getName_sores_drugADesc(tblDesc));
		this.add(getName_nur_psnADesc(tblDesc));
		this.add(getName_headnur_psnADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_puasCDesc(tblDesc));
		tblDesc.add(getId_puasCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getSd_sexCDesc(tblDesc));
		tblDesc.add(getId_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getId_sores_physicalCDesc(tblDesc));
		tblDesc.add(getSd_sores_physicalCDesc(tblDesc));
		tblDesc.add(getSores_physicalCDesc(tblDesc));
		tblDesc.add(getId_sores_skinCDesc(tblDesc));
		tblDesc.add(getSd_sores_skinCDesc(tblDesc));
		tblDesc.add(getSores_skinCDesc(tblDesc));
		tblDesc.add(getId_sores_sexCDesc(tblDesc));
		tblDesc.add(getSd_sores_sexCDesc(tblDesc));
		tblDesc.add(getSores_sexCDesc(tblDesc));
		tblDesc.add(getId_sores_ageCDesc(tblDesc));
		tblDesc.add(getSd_sores_ageCDesc(tblDesc));
		tblDesc.add(getSores_ageCDesc(tblDesc));
		tblDesc.add(getId_sores_wgt_decCDesc(tblDesc));
		tblDesc.add(getSd_sores_wgt_decCDesc(tblDesc));
		tblDesc.add(getId_sores_wgt_scCDesc(tblDesc));
		tblDesc.add(getSd_sores_wgt_scCDesc(tblDesc));
		tblDesc.add(getSores_wgt_scCDesc(tblDesc));
		tblDesc.add(getId_sores_loss_appetiteCDesc(tblDesc));
		tblDesc.add(getSd_sores_loss_appetiteCDesc(tblDesc));
		tblDesc.add(getSores_loss_appetiteCDesc(tblDesc));
		tblDesc.add(getId_sores_incontinenceCDesc(tblDesc));
		tblDesc.add(getSd_sores_incontinenceCDesc(tblDesc));
		tblDesc.add(getSores_incontinenceCDesc(tblDesc));
		tblDesc.add(getId_sores_sportCDesc(tblDesc));
		tblDesc.add(getSd_sores_sportCDesc(tblDesc));
		tblDesc.add(getSores_sportCDesc(tblDesc));
		tblDesc.add(getId_sores_nutritionCDesc(tblDesc));
		tblDesc.add(getSd_sores_nutritionCDesc(tblDesc));
		tblDesc.add(getSores_nutritionCDesc(tblDesc));
		tblDesc.add(getId_sores_nervousCDesc(tblDesc));
		tblDesc.add(getSd_sores_nervousCDesc(tblDesc));
		tblDesc.add(getSores_nervousCDesc(tblDesc));
		tblDesc.add(getId_sores_traumaCDesc(tblDesc));
		tblDesc.add(getSd_sores_traumaCDesc(tblDesc));
		tblDesc.add(getSores_traumaCDesc(tblDesc));
		tblDesc.add(getId_sores_drugCDesc(tblDesc));
		tblDesc.add(getSd_sores_drugCDesc(tblDesc));
		tblDesc.add(getSores_drugCDesc(tblDesc));
		tblDesc.add(getTotal_scoreCDesc(tblDesc));
		tblDesc.add(getAss_resultCDesc(tblDesc));
		tblDesc.add(getDt_assCDesc(tblDesc));
		tblDesc.add(getId_nur_psnCDesc(tblDesc));
		tblDesc.add(getId_headnur_psnCDesc(tblDesc));
		tblDesc.add(getRelationCDesc(tblDesc));
		tblDesc.add(getVirus_nerveCDesc(tblDesc));
		tblDesc.add(getSport_nerveCDesc(tblDesc));
		tblDesc.add(getHem_nerveCDesc(tblDesc));
		tblDesc.add(getCell_medCDesc(tblDesc));
		tblDesc.add(getLong_medCDesc(tblDesc));
		tblDesc.add(getBiotic_medCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 压疮危险因素评估单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_puasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_puas",  getId_puasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮危险因素评估单ID");
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
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
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
	 * 科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_phy",  getId_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 入院日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_entry",  getDt_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("入院日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diagnosis",  getName_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体质指数id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sores_physicalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sores_physical",  getId_sores_physicalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体质指数id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体质指数编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sores_physicalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sores_physical",  getSd_sores_physicalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体质指数编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体质指数得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSores_physicalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sores_physical",  getSores_physicalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体质指数得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sores_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sores_skin",  getId_sores_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sores_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sores_skin",  getSd_sores_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤类型得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSores_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sores_skin",  getSores_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("皮肤类型得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮性别id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sores_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sores_sex",  getId_sores_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮性别id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 压疮性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sores_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sores_sex",  getSd_sores_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSores_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sores_sex",  getSores_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("性别得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮年龄id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sores_ageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sores_age",  getId_sores_ageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮年龄id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 压疮年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sores_ageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sores_age",  getSd_sores_ageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSores_ageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sores_age",  getSores_ageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("年龄得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 近期体重下降id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sores_wgt_decADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sores_wgt_dec",  getId_sores_wgt_decCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("近期体重下降id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 近期体重下降属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sores_wgt_decADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sores_wgt_dec",  getSd_sores_wgt_decCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("近期体重下降");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体重下降评分id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sores_wgt_scADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sores_wgt_sc",  getId_sores_wgt_scCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体重下降评分id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体重下降评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sores_wgt_scADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sores_wgt_sc",  getSd_sores_wgt_scCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体重下降评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体重下降得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSores_wgt_scADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sores_wgt_sc",  getSores_wgt_scCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体重下降得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进食少或食欲不振id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sores_loss_appetiteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sores_loss_appetite",  getId_sores_loss_appetiteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进食少或食欲不振id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 进食少或食欲不振属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sores_loss_appetiteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sores_loss_appetite",  getSd_sores_loss_appetiteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("进食少或食欲不振");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进食少或食欲不振得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSores_loss_appetiteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sores_loss_appetite",  getSores_loss_appetiteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("进食少或食欲不振得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失禁id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sores_incontinenceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sores_incontinence",  getId_sores_incontinenceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("失禁id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 失禁属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sores_incontinenceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sores_incontinence",  getSd_sores_incontinenceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("失禁");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失禁得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSores_incontinenceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sores_incontinence",  getSores_incontinenceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("失禁得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 运动能力id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sores_sportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sores_sport",  getId_sores_sportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("运动能力id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 运动能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sores_sportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sores_sport",  getSd_sores_sportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("运动能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 运动能力得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSores_sportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sores_sport",  getSores_sportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("运动能力得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织营养状况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sores_nutritionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sores_nutrition",  getId_sores_nutritionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织营养状况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 组织营养状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sores_nutritionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sores_nutrition",  getSd_sores_nutritionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织营养状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织营养状况得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSores_nutritionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sores_nutrition",  getSores_nutritionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("组织营养状况得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 神经系统缺陷id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sores_nervousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sores_nervous",  getId_sores_nervousCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神经系统缺陷id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 神经系统缺陷属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sores_nervousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sores_nervous",  getSd_sores_nervousCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神经系统缺陷");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 神经系统缺陷得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSores_nervousADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sores_nervous",  getSores_nervousCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("神经系统缺陷得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大手术或创伤id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sores_traumaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sores_trauma",  getId_sores_traumaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大手术或创伤id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 大手术或创伤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sores_traumaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sores_trauma",  getSd_sores_traumaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大手术或创伤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大手术或创伤得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSores_traumaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sores_trauma",  getSores_traumaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("大手术或创伤得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药物id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sores_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sores_drug",  getId_sores_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药物id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sores_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sores_drug",  getSd_sores_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药物得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSores_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sores_drug",  getSores_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("药物得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估总分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTotal_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Total_score",  getTotal_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("评估总分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAss_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ass_result",  getAss_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_assADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_ass",  getDt_assCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("评估时间");
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
	private IAttrDesc getId_nur_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_psn",  getId_nur_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("责任护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病房护士长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_headnur_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_headnur_psn",  getId_headnur_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病房护士长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病人/家属属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Relation",  getRelationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病人/家属");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 糖尿病（神经缺陷）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVirus_nerveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Virus_nerve",  getVirus_nerveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("糖尿病（神经缺陷）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 运动(神经缺陷)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSport_nerveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sport_nerve",  getSport_nerveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("运动(神经缺陷)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 偏瘫(神经缺陷)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHem_nerveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hem_nerve",  getHem_nerveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("偏瘫(神经缺陷)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 细胞毒性药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCell_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cell_med",  getCell_medCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("细胞毒性药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 长期大剂量服用类固醇属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLong_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Long_med",  getLong_medCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("长期大剂量服用类固醇");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗生素属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBiotic_medADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Biotic_med",  getBiotic_medCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("抗生素");
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
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b12","id_pat=id_pat","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phy",  getName_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b14","id_dep_phy=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sores_physicalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sores_physical",  getName_sores_physicalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_sores_physical=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sores_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sores_skin",  getName_sores_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_sores_skin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sores_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sores_sex",  getName_sores_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_sores_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sores_ageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sores_age",  getName_sores_ageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_sores_age=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sores_wgt_decADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sores_wgt_dec",  getName_sores_wgt_decCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_sores_wgt_dec=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sores_wgt_scADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sores_wgt_sc",  getName_sores_wgt_scCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_sores_wgt_sc=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sores_lossADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sores_loss",  getName_sores_lossCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_sores_loss_appetite=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sores_inconADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sores_incon",  getName_sores_inconCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_sores_incontinence=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sores_sportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sores_sport",  getName_sores_sportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_sores_sport=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sores_nutrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sores_nutr",  getName_sores_nutrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_sores_nutrition=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sores_nerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sores_ner",  getName_sores_nerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_sores_nervous=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sores_traADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sores_tra",  getName_sores_traCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_sores_trauma=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sores_drugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sores_drug",  getName_sores_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_sores_drug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nur_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur_psn",  getName_nur_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b28","id_nur_psn=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_headnur_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_headnur_psn",  getName_headnur_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b29","id_headnur_psn=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取压疮危险因素评估单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_puasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_puas");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("压疮危险因素评估单ID"); 
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
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取患者就诊ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者就诊ID"); 
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
	 * 获取科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_phy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室"); 
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
	 * 获取入院日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_entry");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院日期"); 
		return column;
	}
	/**
	 * 获取医疗诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagnosis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗诊断"); 
		return column;
	}
	/**
	 * 获取体质指数id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sores_physicalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sores_physical");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体质指数id"); 
		return column;
	}
	/**
	 * 获取体质指数编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sores_physicalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sores_physical");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体质指数编码"); 
		return column;
	}
	/**
	 * 获取体质指数得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSores_physicalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sores_physical");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体质指数得分"); 
		return column;
	}
	/**
	 * 获取皮肤类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sores_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sores_skin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤类型id"); 
		return column;
	}
	/**
	 * 获取皮肤类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sores_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sores_skin");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤类型"); 
		return column;
	}
	/**
	 * 获取皮肤类型得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSores_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sores_skin");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("皮肤类型得分"); 
		return column;
	}
	/**
	 * 获取压疮性别id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sores_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sores_sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮性别id"); 
		return column;
	}
	/**
	 * 获取压疮性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sores_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sores_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮性别"); 
		return column;
	}
	/**
	 * 获取性别得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSores_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sores_sex");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("性别得分"); 
		return column;
	}
	/**
	 * 获取压疮年龄id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sores_ageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sores_age");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮年龄id"); 
		return column;
	}
	/**
	 * 获取压疮年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sores_ageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sores_age");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮年龄"); 
		return column;
	}
	/**
	 * 获取年龄得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSores_ageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sores_age");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("年龄得分"); 
		return column;
	}
	/**
	 * 获取近期体重下降id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sores_wgt_decCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sores_wgt_dec");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("近期体重下降id"); 
		return column;
	}
	/**
	 * 获取近期体重下降表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sores_wgt_decCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sores_wgt_dec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("近期体重下降"); 
		return column;
	}
	/**
	 * 获取体重下降评分id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sores_wgt_scCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sores_wgt_sc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体重下降评分id"); 
		return column;
	}
	/**
	 * 获取体重下降评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sores_wgt_scCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sores_wgt_sc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体重下降评分"); 
		return column;
	}
	/**
	 * 获取体重下降得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSores_wgt_scCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sores_wgt_sc");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体重下降得分"); 
		return column;
	}
	/**
	 * 获取进食少或食欲不振id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sores_loss_appetiteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sores_loss_appetite");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进食少或食欲不振id"); 
		return column;
	}
	/**
	 * 获取进食少或食欲不振表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sores_loss_appetiteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sores_loss_appetite");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("进食少或食欲不振"); 
		return column;
	}
	/**
	 * 获取进食少或食欲不振得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSores_loss_appetiteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sores_loss_appetite");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("进食少或食欲不振得分"); 
		return column;
	}
	/**
	 * 获取失禁id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sores_incontinenceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sores_incontinence");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("失禁id"); 
		return column;
	}
	/**
	 * 获取失禁表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sores_incontinenceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sores_incontinence");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("失禁"); 
		return column;
	}
	/**
	 * 获取失禁得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSores_incontinenceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sores_incontinence");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("失禁得分"); 
		return column;
	}
	/**
	 * 获取运动能力id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sores_sportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sores_sport");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("运动能力id"); 
		return column;
	}
	/**
	 * 获取运动能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sores_sportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sores_sport");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("运动能力"); 
		return column;
	}
	/**
	 * 获取运动能力得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSores_sportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sores_sport");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("运动能力得分"); 
		return column;
	}
	/**
	 * 获取组织营养状况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sores_nutritionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sores_nutrition");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织营养状况id"); 
		return column;
	}
	/**
	 * 获取组织营养状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sores_nutritionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sores_nutrition");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织营养状况"); 
		return column;
	}
	/**
	 * 获取组织营养状况得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSores_nutritionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sores_nutrition");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("组织营养状况得分"); 
		return column;
	}
	/**
	 * 获取神经系统缺陷id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sores_nervousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sores_nervous");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神经系统缺陷id"); 
		return column;
	}
	/**
	 * 获取神经系统缺陷表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sores_nervousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sores_nervous");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神经系统缺陷"); 
		return column;
	}
	/**
	 * 获取神经系统缺陷得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSores_nervousCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sores_nervous");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("神经系统缺陷得分"); 
		return column;
	}
	/**
	 * 获取大手术或创伤id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sores_traumaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sores_trauma");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大手术或创伤id"); 
		return column;
	}
	/**
	 * 获取大手术或创伤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sores_traumaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sores_trauma");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大手术或创伤"); 
		return column;
	}
	/**
	 * 获取大手术或创伤得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSores_traumaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sores_trauma");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("大手术或创伤得分"); 
		return column;
	}
	/**
	 * 获取药物id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sores_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sores_drug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药物id"); 
		return column;
	}
	/**
	 * 获取药物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sores_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sores_drug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药物"); 
		return column;
	}
	/**
	 * 获取药物得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSores_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sores_drug");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("药物得分"); 
		return column;
	}
	/**
	 * 获取评估总分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotal_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Total_score");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("评估总分"); 
		return column;
	}
	/**
	 * 获取评估结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAss_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ass_result");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估结果"); 
		return column;
	}
	/**
	 * 获取评估时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_assCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_ass");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("评估时间"); 
		return column;
	}
	/**
	 * 获取责任护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_psn");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("责任护士"); 
		return column;
	}
	/**
	 * 获取病房护士长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_headnur_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_headnur_psn");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病房护士长"); 
		return column;
	}
	/**
	 * 获取病人/家属表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Relation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病人/家属"); 
		return column;
	}
	/**
	 * 获取糖尿病（神经缺陷）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVirus_nerveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Virus_nerve");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("糖尿病（神经缺陷）"); 
		return column;
	}
	/**
	 * 获取运动(神经缺陷)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSport_nerveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sport_nerve");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("运动(神经缺陷)"); 
		return column;
	}
	/**
	 * 获取偏瘫(神经缺陷)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHem_nerveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hem_nerve");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("偏瘫(神经缺陷)"); 
		return column;
	}
	/**
	 * 获取细胞毒性药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCell_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cell_med");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("细胞毒性药"); 
		return column;
	}
	/**
	 * 获取长期大剂量服用类固醇表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLong_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Long_med");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("长期大剂量服用类固醇"); 
		return column;
	}
	/**
	 * 获取抗生素表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBiotic_medCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Biotic_med");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("抗生素"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phy");
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
	private IColumnDesc getName_sores_physicalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sores_physical");
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
	private IColumnDesc getName_sores_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sores_skin");
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
	private IColumnDesc getName_sores_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sores_sex");
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
	private IColumnDesc getName_sores_ageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sores_age");
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
	private IColumnDesc getName_sores_wgt_decCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sores_wgt_dec");
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
	private IColumnDesc getName_sores_wgt_scCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sores_wgt_sc");
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
	private IColumnDesc getName_sores_lossCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sores_loss");
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
	private IColumnDesc getName_sores_inconCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sores_incon");
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
	private IColumnDesc getName_sores_sportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sores_sport");
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
	private IColumnDesc getName_sores_nutrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sores_nutr");
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
	private IColumnDesc getName_sores_nerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sores_ner");
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
	private IColumnDesc getName_sores_traCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sores_tra");
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
	private IColumnDesc getName_sores_drugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sores_drug");
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
	private IColumnDesc getName_nur_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur_psn");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_headnur_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_headnur_psn");
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
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
}
