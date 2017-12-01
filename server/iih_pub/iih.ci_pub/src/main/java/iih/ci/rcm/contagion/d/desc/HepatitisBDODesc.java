
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
 * 乙肝附卡 DO 元数据信息
 */
public class HepatitisBDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.contagion.d.HepatitisBDO";
	public static final String CLASS_DISPALYNAME = "乙肝附卡";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_CONTAGION_CARD_HB";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_contagion_hb";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HepatitisBDODesc(){
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
		this.setKeyDesc(getId_contagion_hbADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_contagionADesc(tblDesc));
		this.add(getId_contagion_hbADesc(tblDesc));
		this.add(getId_contagionADesc(tblDesc));
		this.add(getId_formADesc(tblDesc));
		this.add(getId_hbsag_dtADesc(tblDesc));
		this.add(getCode_hbsag_dtADesc(tblDesc));
		this.add(getName_hbsag_dtADesc(tblDesc));
		this.add(getDt_firstADesc(tblDesc));
		this.add(getAltADesc(tblDesc));
		this.add(getId_hbc_igm1ADesc(tblDesc));
		this.add(getCode_hbc_igm1ADesc(tblDesc));
		this.add(getName_hbc_igm1ADesc(tblDesc));
		this.add(getId_liver_puncture_resultsADesc(tblDesc));
		this.add(getCode_liver_puncture_resultsADesc(tblDesc));
		this.add(getName_liver_puncture_resultsADesc(tblDesc));
		this.add(getId_hbsag_huifuADesc(tblDesc));
		this.add(getCode_hbsag_huifuADesc(tblDesc));
		this.add(getName_hbsag_huifuADesc(tblDesc));
		this.add(getIs_knowADesc(tblDesc));
		this.add(getCard_noADesc(tblDesc));
		this.add(getPat_nameADesc(tblDesc));
		this.add(getParent_nameADesc(tblDesc));
		this.add(getHjdzADesc(tblDesc));
		this.add(getCode_hjdzADesc(tblDesc));
		this.add(getName_hjdzADesc(tblDesc));
		this.add(getTownADesc(tblDesc));
		this.add(getVallegeADesc(tblDesc));
		this.add(getHouse_noADesc(tblDesc));
		this.add(getRept_doctorADesc(tblDesc));
		this.add(getRelation_wayADesc(tblDesc));
		this.add(getCode_rept_doctorADesc(tblDesc));
		this.add(getName_rept_doctorADesc(tblDesc));
		this.add(getHbsag_dt_codeADesc(tblDesc));
		this.add(getHbsag_dt_nameADesc(tblDesc));
		this.add(getHbc_igm_codeADesc(tblDesc));
		this.add(getHbc_igm_nameADesc(tblDesc));
		this.add(getLiver_puncture_results_codeADesc(tblDesc));
		this.add(getLiver_puncture_results_nameADesc(tblDesc));
		this.add(getHbsag_huifu_codeADesc(tblDesc));
		this.add(getHbsag_huifu_nameADesc(tblDesc));
		this.add(getAreacodeADesc(tblDesc));
		this.add(getAreanameADesc(tblDesc));
		this.add(getDoctorcodeADesc(tblDesc));
		this.add(getDoctornameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_contagion_hbCDesc(tblDesc));
		tblDesc.add(getId_contagion_hbCDesc(tblDesc));
		tblDesc.add(getId_contagionCDesc(tblDesc));
		tblDesc.add(getId_formCDesc(tblDesc));
		tblDesc.add(getId_hbsag_dtCDesc(tblDesc));
		tblDesc.add(getCode_hbsag_dtCDesc(tblDesc));
		tblDesc.add(getName_hbsag_dtCDesc(tblDesc));
		tblDesc.add(getDt_firstCDesc(tblDesc));
		tblDesc.add(getAltCDesc(tblDesc));
		tblDesc.add(getId_hbc_igm1CDesc(tblDesc));
		tblDesc.add(getCode_hbc_igm1CDesc(tblDesc));
		tblDesc.add(getName_hbc_igm1CDesc(tblDesc));
		tblDesc.add(getId_liver_puncture_resultsCDesc(tblDesc));
		tblDesc.add(getCode_liver_puncture_resultsCDesc(tblDesc));
		tblDesc.add(getName_liver_puncture_resultsCDesc(tblDesc));
		tblDesc.add(getId_hbsag_huifuCDesc(tblDesc));
		tblDesc.add(getCode_hbsag_huifuCDesc(tblDesc));
		tblDesc.add(getName_hbsag_huifuCDesc(tblDesc));
		tblDesc.add(getIs_knowCDesc(tblDesc));
		tblDesc.add(getCard_noCDesc(tblDesc));
		tblDesc.add(getPat_nameCDesc(tblDesc));
		tblDesc.add(getParent_nameCDesc(tblDesc));
		tblDesc.add(getHjdzCDesc(tblDesc));
		tblDesc.add(getCode_hjdzCDesc(tblDesc));
		tblDesc.add(getName_hjdzCDesc(tblDesc));
		tblDesc.add(getTownCDesc(tblDesc));
		tblDesc.add(getVallegeCDesc(tblDesc));
		tblDesc.add(getHouse_noCDesc(tblDesc));
		tblDesc.add(getRept_doctorCDesc(tblDesc));
		tblDesc.add(getRelation_wayCDesc(tblDesc));
		tblDesc.add(getCode_rept_doctorCDesc(tblDesc));
		tblDesc.add(getName_rept_doctorCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 乙肝附卡ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_contagion_hbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_contagion_hb",  getId_contagion_hbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("乙肝附卡ID");
		attrDesc.setNullable(false);
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
	private IAttrDesc getId_contagionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_contagion",  getId_contagionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("父id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 表单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_formADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_form",  getId_formCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("表单");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HBsAg阳性时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hbsag_dtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hbsag_dt",  getId_hbsag_dtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HBsAg阳性时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * HBsAg阳性时间编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hbsag_dtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hbsag_dt",  getCode_hbsag_dtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HBsAg阳性时间编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HBsAg阳性时间name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hbsag_dtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hbsag_dt",  getName_hbsag_dtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HBsAg阳性时间name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 首次乙肝发病时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_firstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_first",  getDt_firstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("首次乙肝发病时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本次ALT属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAltADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Alt",  getAltCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("本次ALT");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗-HBc IgM1:1000检测结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hbc_igm1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hbc_igm1",  getId_hbc_igm1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗-HBc IgM1:1000检测结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 抗-HBc IgM1:1000检测结果code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hbc_igm1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hbc_igm1",  getCode_hbc_igm1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗-HBc IgM1:1000检测结果code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗-HBc IgM1:1000检测结果name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hbc_igm1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hbc_igm1",  getName_hbc_igm1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗-HBc IgM1:1000检测结果name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肝穿刺检测结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_liver_puncture_resultsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_liver_puncture_results",  getId_liver_puncture_resultsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肝穿刺检测结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 肝穿刺检测结果code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_liver_puncture_resultsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_liver_puncture_results",  getCode_liver_puncture_resultsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肝穿刺检测结果code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肝穿刺检测结果name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_liver_puncture_resultsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_liver_puncture_results",  getName_liver_puncture_resultsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肝穿刺检测结果name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 恢复期血清HBsAg阴转属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hbsag_huifuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hbsag_huifu",  getId_hbsag_huifuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("恢复期血清HBsAg阴转");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 恢复期血清HBsAg阴转code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hbsag_huifuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hbsag_huifu",  getCode_hbsag_huifuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("恢复期血清HBsAg阴转code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 恢复期血清HBsAg阴转name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hbsag_huifuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hbsag_huifu",  getName_hbsag_huifuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("恢复期血清HBsAg阴转name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否知道首次发病时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_knowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_know",  getIs_knowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否知道首次发病时间");
		attrDesc.setNullable(true);
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
	private IAttrDesc getCard_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_no",  getCard_noCDesc(tblDesc), this);
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
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_name",  getPat_nameCDesc(tblDesc), this);
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
	 * 家长姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getParent_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Parent_name",  getParent_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家长姓名");
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
	private IAttrDesc getHjdzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hjdz",  getHjdzCDesc(tblDesc), this);
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
	private IAttrDesc getCode_hjdzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hjdz",  getCode_hjdzCDesc(tblDesc), this);
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
	private IAttrDesc getName_hjdzADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hjdz",  getName_hjdzCDesc(tblDesc), this);
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
	 * 乡镇属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTownADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Town",  getTownCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("乡镇");
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
	private IAttrDesc getVallegeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vallege",  getVallegeCDesc(tblDesc), this);
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
	 * 门牌号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHouse_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("House_no",  getHouse_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门牌号");
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
	private IAttrDesc getRept_doctorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rept_doctor",  getRept_doctorCDesc(tblDesc), this);
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
	 * 联系电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelation_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Relation_way",  getRelation_wayCDesc(tblDesc), this);
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
	 * 报卡医生编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_rept_doctorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_rept_doctor",  getCode_rept_doctorCDesc(tblDesc), this);
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
	 * 报卡医生名字属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rept_doctorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rept_doctor",  getName_rept_doctorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报卡医生名字");
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
	private IAttrDesc getHbsag_dt_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hbsag_dt_code",  getHbsag_dt_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b2","id_hbsag_dt=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHbsag_dt_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hbsag_dt_name",  getHbsag_dt_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b2","id_hbsag_dt=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHbc_igm_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hbc_igm_code",  getHbc_igm_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b3","id_hbc_igm1=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHbc_igm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hbc_igm_name",  getHbc_igm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b3","id_hbc_igm1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLiver_puncture_results_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Liver_puncture_results_code",  getLiver_puncture_results_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b4","id_liver_puncture_results=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLiver_puncture_results_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Liver_puncture_results_name",  getLiver_puncture_results_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b4","id_liver_puncture_results=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHbsag_huifu_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hbsag_huifu_code",  getHbsag_huifu_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b5","id_hbsag_huifu=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHbsag_huifu_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hbsag_huifu_name",  getHbsag_huifu_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b5","id_hbsag_huifu=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a2b6","hjdz=id_adminarea","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAreanameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Areaname",  getAreanameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a2b6","hjdz=id_adminarea","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a2b7","rept_doctor=id_psndoc","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a2b7","rept_doctor=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取乙肝附卡ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_contagion_hbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_contagion_hb");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("乙肝附卡ID"); 
		return column;
	}
	/**
	 * 获取父id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_contagionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_contagion");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("父id"); 
		return column;
	}
	/**
	 * 获取表单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_formCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_form");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("表单"); 
		return column;
	}
	/**
	 * 获取HBsAg阳性时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hbsag_dtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hbsag_dt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HBsAg阳性时间"); 
		return column;
	}
	/**
	 * 获取HBsAg阳性时间编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hbsag_dtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hbsag_dt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HBsAg阳性时间编码"); 
		return column;
	}
	/**
	 * 获取HBsAg阳性时间name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hbsag_dtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hbsag_dt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HBsAg阳性时间name"); 
		return column;
	}
	/**
	 * 获取首次乙肝发病时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_firstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_first");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("首次乙肝发病时间"); 
		return column;
	}
	/**
	 * 获取本次ALT表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAltCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Alt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("本次ALT"); 
		return column;
	}
	/**
	 * 获取抗-HBc IgM1:1000检测结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hbc_igm1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hbc_igm1");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗-HBc IgM1:1000检测结果"); 
		return column;
	}
	/**
	 * 获取抗-HBc IgM1:1000检测结果code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hbc_igm1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hbc_igm1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗-HBc IgM1:1000检测结果code"); 
		return column;
	}
	/**
	 * 获取抗-HBc IgM1:1000检测结果name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hbc_igm1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hbc_igm1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗-HBc IgM1:1000检测结果name"); 
		return column;
	}
	/**
	 * 获取肝穿刺检测结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_liver_puncture_resultsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_liver_puncture_results");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肝穿刺检测结果"); 
		return column;
	}
	/**
	 * 获取肝穿刺检测结果code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_liver_puncture_resultsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_liver_puncture_results");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肝穿刺检测结果code"); 
		return column;
	}
	/**
	 * 获取肝穿刺检测结果name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_liver_puncture_resultsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_liver_puncture_results");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肝穿刺检测结果name"); 
		return column;
	}
	/**
	 * 获取恢复期血清HBsAg阴转表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hbsag_huifuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hbsag_huifu");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("恢复期血清HBsAg阴转"); 
		return column;
	}
	/**
	 * 获取恢复期血清HBsAg阴转code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hbsag_huifuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hbsag_huifu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("恢复期血清HBsAg阴转code"); 
		return column;
	}
	/**
	 * 获取恢复期血清HBsAg阴转name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hbsag_huifuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hbsag_huifu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("恢复期血清HBsAg阴转name"); 
		return column;
	}
	/**
	 * 获取是否知道首次发病时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_knowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_know");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否知道首次发病时间"); 
		return column;
	}
	/**
	 * 获取卡片编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡片编号"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取家长姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getParent_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Parent_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家长姓名"); 
		return column;
	}
	/**
	 * 获取户籍地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHjdzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hjdz");
		column.setLength(20);
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
	private IColumnDesc getCode_hjdzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hjdz");
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
	private IColumnDesc getName_hjdzCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hjdz");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("户籍地址名称"); 
		return column;
	}
	/**
	 * 获取乡镇表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTownCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Town");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("乡镇"); 
		return column;
	}
	/**
	 * 获取村表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVallegeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vallege");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("村"); 
		return column;
	}
	/**
	 * 获取门牌号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHouse_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"House_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门牌号"); 
		return column;
	}
	/**
	 * 获取报卡医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRept_doctorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rept_doctor");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡医生"); 
		return column;
	}
	/**
	 * 获取联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelation_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Relation_way");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系电话"); 
		return column;
	}
	/**
	 * 获取报卡医生编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_rept_doctorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_rept_doctor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡医生编码"); 
		return column;
	}
	/**
	 * 获取报卡医生名字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rept_doctorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rept_doctor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报卡医生名字"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHbsag_dt_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hbsag_dt_code");
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
	private IColumnDesc getHbsag_dt_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hbsag_dt_name");
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
	private IColumnDesc getHbc_igm_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hbc_igm_code");
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
	private IColumnDesc getHbc_igm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hbc_igm_name");
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
	private IColumnDesc getLiver_puncture_results_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Liver_puncture_results_code");
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
	private IColumnDesc getLiver_puncture_results_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Liver_puncture_results_name");
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
	private IColumnDesc getHbsag_huifu_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hbsag_huifu_code");
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
	private IColumnDesc getHbsag_huifu_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hbsag_huifu_name");
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
	private IColumnDesc getAreacodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Areacode");
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
	private IColumnDesc getAreanameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Areaname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划名称"); 
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
