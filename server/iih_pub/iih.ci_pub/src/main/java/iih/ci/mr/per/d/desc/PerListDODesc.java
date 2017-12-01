
package iih.ci.mr.per.d.desc;

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
 * 实体 DO 元数据信息
 */
public class PerListDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.per.d.PerListDO";
	public static final String CLASS_DISPALYNAME = "实体";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_PER_QC_ITM";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_list";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PerListDODesc(){
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
		this.setKeyDesc(getId_listADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_perADesc(tblDesc));
		this.add(getId_listADesc(tblDesc));
		this.add(getId_perADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getFileftADesc(tblDesc));
		this.add(getFibottomADesc(tblDesc));
		this.add(getFicenterADesc(tblDesc));
		this.add(getJhyktopleftADesc(tblDesc));
		this.add(getJhyktopcenterADesc(tblDesc));
		this.add(getJhyktoprightADesc(tblDesc));
		this.add(getJhyktopbottomleftADesc(tblDesc));
		this.add(getJhyktopbottomcenterADesc(tblDesc));
		this.add(getJhyktopbottomrightADesc(tblDesc));
		this.add(getYntopvalueADesc(tblDesc));
		this.add(getYnbottomvalueADesc(tblDesc));
		this.add(getDdvalueADesc(tblDesc));
		this.add(getDdpositionADesc(tblDesc));
		this.add(getPlitopleftADesc(tblDesc));
		this.add(getPlitopcenterADesc(tblDesc));
		this.add(getPlitoprightADesc(tblDesc));
		this.add(getPlitbottomleftADesc(tblDesc));
		this.add(getPlitbottomcenterADesc(tblDesc));
		this.add(getPlitbottomrightADesc(tblDesc));
		this.add(getCejtopleftADesc(tblDesc));
		this.add(getCejtopcenterADesc(tblDesc));
		this.add(getCejtoprightADesc(tblDesc));
		this.add(getCejbottomleftADesc(tblDesc));
		this.add(getCejbottomcenterADesc(tblDesc));
		this.add(getCejbottomrightADesc(tblDesc));
		this.add(getBitopvalueADesc(tblDesc));
		this.add(getBibottomvalueADesc(tblDesc));
		this.add(getPdtopleftADesc(tblDesc));
		this.add(getPdtopcenterADesc(tblDesc));
		this.add(getPdtoprightADesc(tblDesc));
		this.add(getPdbottomleftADesc(tblDesc));
		this.add(getPdbottomcenterADesc(tblDesc));
		this.add(getPdbottomrightADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getBleedtopleftADesc(tblDesc));
		this.add(getBleedtopcenterADesc(tblDesc));
		this.add(getBleedtoprightADesc(tblDesc));
		this.add(getBleedbottomleftADesc(tblDesc));
		this.add(getBleedbottomcenterADesc(tblDesc));
		this.add(getBleedbottomrightADesc(tblDesc));
		this.add(getTeechstatusADesc(tblDesc));
		this.add(getTeechindexADesc(tblDesc));
		this.add(getDt_opADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_listCDesc(tblDesc));
		tblDesc.add(getId_listCDesc(tblDesc));
		tblDesc.add(getId_perCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getFileftCDesc(tblDesc));
		tblDesc.add(getFibottomCDesc(tblDesc));
		tblDesc.add(getFicenterCDesc(tblDesc));
		tblDesc.add(getJhyktopleftCDesc(tblDesc));
		tblDesc.add(getJhyktopcenterCDesc(tblDesc));
		tblDesc.add(getJhyktoprightCDesc(tblDesc));
		tblDesc.add(getJhyktopbottomleftCDesc(tblDesc));
		tblDesc.add(getJhyktopbottomcenterCDesc(tblDesc));
		tblDesc.add(getJhyktopbottomrightCDesc(tblDesc));
		tblDesc.add(getYntopvalueCDesc(tblDesc));
		tblDesc.add(getYnbottomvalueCDesc(tblDesc));
		tblDesc.add(getDdvalueCDesc(tblDesc));
		tblDesc.add(getDdpositionCDesc(tblDesc));
		tblDesc.add(getPlitopleftCDesc(tblDesc));
		tblDesc.add(getPlitopcenterCDesc(tblDesc));
		tblDesc.add(getPlitoprightCDesc(tblDesc));
		tblDesc.add(getPlitbottomleftCDesc(tblDesc));
		tblDesc.add(getPlitbottomcenterCDesc(tblDesc));
		tblDesc.add(getPlitbottomrightCDesc(tblDesc));
		tblDesc.add(getCejtopleftCDesc(tblDesc));
		tblDesc.add(getCejtopcenterCDesc(tblDesc));
		tblDesc.add(getCejtoprightCDesc(tblDesc));
		tblDesc.add(getCejbottomleftCDesc(tblDesc));
		tblDesc.add(getCejbottomcenterCDesc(tblDesc));
		tblDesc.add(getCejbottomrightCDesc(tblDesc));
		tblDesc.add(getBitopvalueCDesc(tblDesc));
		tblDesc.add(getBibottomvalueCDesc(tblDesc));
		tblDesc.add(getPdtopleftCDesc(tblDesc));
		tblDesc.add(getPdtopcenterCDesc(tblDesc));
		tblDesc.add(getPdtoprightCDesc(tblDesc));
		tblDesc.add(getPdbottomleftCDesc(tblDesc));
		tblDesc.add(getPdbottomcenterCDesc(tblDesc));
		tblDesc.add(getPdbottomrightCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getBleedtopleftCDesc(tblDesc));
		tblDesc.add(getBleedtopcenterCDesc(tblDesc));
		tblDesc.add(getBleedtoprightCDesc(tblDesc));
		tblDesc.add(getBleedbottomleftCDesc(tblDesc));
		tblDesc.add(getBleedbottomcenterCDesc(tblDesc));
		tblDesc.add(getBleedbottomrightCDesc(tblDesc));
		tblDesc.add(getTeechstatusCDesc(tblDesc));
		tblDesc.add(getTeechindexCDesc(tblDesc));
		tblDesc.add(getDt_opCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 牙周子表ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_listADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_list",  getId_listCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("牙周子表ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * id_per属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_per",  getId_perCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("id_per");
		attrDesc.setNullable(false);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * FI根分叉病变左属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFileftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fileft",  getFileftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("FI根分叉病变左");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * FI根分叉病变底属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFibottomADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fibottom",  getFibottomCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("FI根分叉病变底");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * FI根分叉病变中属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFicenterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ficenter",  getFicenterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("FI根分叉病变中");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 角化宽龈左上属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJhyktopleftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Jhyktopleft",  getJhyktopleftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("角化宽龈左上");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 角化宽龈上中属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJhyktopcenterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Jhyktopcenter",  getJhyktopcenterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("角化宽龈上中");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 角化宽龈右上属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJhyktoprightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Jhyktopright",  getJhyktoprightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("角化宽龈右上");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 角化宽龈左下属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJhyktopbottomleftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Jhyktopbottomleft",  getJhyktopbottomleftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("角化宽龈左下");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 角化宽龈下中属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJhyktopbottomcenterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Jhyktopbottomcenter",  getJhyktopbottomcenterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("角化宽龈下中");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 角化宽龈下右属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJhyktopbottomrightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Jhyktopbottomright",  getJhyktopbottomrightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("角化宽龈下右");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 溢脓上属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYntopvalueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Yntopvalue",  getYntopvalueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("溢脓上");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 溢脓下属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYnbottomvalueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ynbottomvalue",  getYnbottomvalueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("溢脓下");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 动度值域属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDdvalueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ddvalue",  getDdvalueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("动度值域");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 动度位置属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDdpositionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ddposition",  getDdpositionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("动度位置");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 菌斑指数左上属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPlitopleftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Plitopleft",  getPlitopleftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("菌斑指数左上");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 菌斑指数上中属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPlitopcenterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Plitopcenter",  getPlitopcenterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("菌斑指数上中");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 菌斑指数右上属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPlitoprightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Plitopright",  getPlitoprightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("菌斑指数右上");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 菌斑指数左下属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPlitbottomleftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Plitbottomleft",  getPlitbottomleftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("菌斑指数左下");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 菌斑指数下中属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPlitbottomcenterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Plitbottomcenter",  getPlitbottomcenterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("菌斑指数下中");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 菌斑指数下右属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPlitbottomrightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Plitbottomright",  getPlitbottomrightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("菌斑指数下右");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 龈源-CEJ左上属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCejtopleftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cejtopleft",  getCejtopleftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("龈源-CEJ左上");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 龈源-CEJ上中属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCejtopcenterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cejtopcenter",  getCejtopcenterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("龈源-CEJ上中");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 龈源-CEJ右上属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCejtoprightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cejtopright",  getCejtoprightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("龈源-CEJ右上");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 龈源-CEJ左下属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCejbottomleftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cejbottomleft",  getCejbottomleftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("龈源-CEJ左下");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 龈源-CEJ下中属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCejbottomcenterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cejbottomcenter",  getCejbottomcenterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("龈源-CEJ下中");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 龈源-CEJ下右属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCejbottomrightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cejbottomright",  getCejbottomrightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("龈源-CEJ下右");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * BI出血指数上属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBitopvalueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bitopvalue",  getBitopvalueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("BI出血指数上");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * BI出血指数下属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBibottomvalueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bibottomvalue",  getBibottomvalueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("BI出血指数下");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * PD探测深度左上属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPdtopleftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pdtopleft",  getPdtopleftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("PD探测深度左上");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * PD探测深度上中属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPdtopcenterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pdtopcenter",  getPdtopcenterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("PD探测深度上中");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * PD探测深度右上属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPdtoprightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pdtopright",  getPdtoprightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("PD探测深度右上");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * PD探测深度左下属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPdbottomleftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pdbottomleft",  getPdbottomleftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("PD探测深度左下");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * PD探测深度下中属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPdbottomcenterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pdbottomcenter",  getPdbottomcenterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("PD探测深度下中");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * PD探测深度下右属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPdbottomrightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pdbottomright",  getPdbottomrightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("PD探测深度下右");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出血点左上属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBleedtopleftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bleedtopleft",  getBleedtopleftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出血点左上");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出血点上中属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBleedtopcenterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bleedtopcenter",  getBleedtopcenterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出血点上中");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出血点右上属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBleedtoprightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bleedtopright",  getBleedtoprightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出血点右上");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出血点左下属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBleedbottomleftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bleedbottomleft",  getBleedbottomleftCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出血点左下");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出血点下中属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBleedbottomcenterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bleedbottomcenter",  getBleedbottomcenterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出血点下中");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出血点下右属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBleedbottomrightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bleedbottomright",  getBleedbottomrightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出血点下右");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 牙齿状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTeechstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Teechstatus",  getTeechstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("牙齿状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 牙齿位置属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTeechindexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Teechindex",  getTeechindexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("牙齿位置");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊就诊日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_op",  getDt_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("门诊就诊日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取牙周子表ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_listCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_list");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("牙周子表ID"); 
		return column;
	}
	/**
	 * 获取id_per表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_per");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("id_per"); 
		return column;
	}
	/**
	 * 获取就诊ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊ID"); 
		return column;
	}
	/**
	 * 获取FI根分叉病变左表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFileftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fileft");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("FI根分叉病变左"); 
		return column;
	}
	/**
	 * 获取FI根分叉病变底表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFibottomCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fibottom");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("FI根分叉病变底"); 
		return column;
	}
	/**
	 * 获取FI根分叉病变中表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFicenterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ficenter");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("FI根分叉病变中"); 
		return column;
	}
	/**
	 * 获取角化宽龈左上表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJhyktopleftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Jhyktopleft");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("角化宽龈左上"); 
		return column;
	}
	/**
	 * 获取角化宽龈上中表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJhyktopcenterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Jhyktopcenter");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("角化宽龈上中"); 
		return column;
	}
	/**
	 * 获取角化宽龈右上表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJhyktoprightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Jhyktopright");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("角化宽龈右上"); 
		return column;
	}
	/**
	 * 获取角化宽龈左下表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJhyktopbottomleftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Jhyktopbottomleft");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("角化宽龈左下"); 
		return column;
	}
	/**
	 * 获取角化宽龈下中表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJhyktopbottomcenterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Jhyktopbottomcenter");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("角化宽龈下中"); 
		return column;
	}
	/**
	 * 获取角化宽龈下右表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJhyktopbottomrightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Jhyktopbottomright");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("角化宽龈下右"); 
		return column;
	}
	/**
	 * 获取溢脓上表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYntopvalueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Yntopvalue");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("溢脓上"); 
		return column;
	}
	/**
	 * 获取溢脓下表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYnbottomvalueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ynbottomvalue");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("溢脓下"); 
		return column;
	}
	/**
	 * 获取动度值域表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDdvalueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ddvalue");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("动度值域"); 
		return column;
	}
	/**
	 * 获取动度位置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDdpositionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ddposition");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("动度位置"); 
		return column;
	}
	/**
	 * 获取菌斑指数左上表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPlitopleftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Plitopleft");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("菌斑指数左上"); 
		return column;
	}
	/**
	 * 获取菌斑指数上中表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPlitopcenterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Plitopcenter");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("菌斑指数上中"); 
		return column;
	}
	/**
	 * 获取菌斑指数右上表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPlitoprightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Plitopright");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("菌斑指数右上"); 
		return column;
	}
	/**
	 * 获取菌斑指数左下表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPlitbottomleftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Plitbottomleft");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("菌斑指数左下"); 
		return column;
	}
	/**
	 * 获取菌斑指数下中表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPlitbottomcenterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Plitbottomcenter");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("菌斑指数下中"); 
		return column;
	}
	/**
	 * 获取菌斑指数下右表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPlitbottomrightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Plitbottomright");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("菌斑指数下右"); 
		return column;
	}
	/**
	 * 获取龈源-CEJ左上表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCejtopleftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cejtopleft");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("龈源-CEJ左上"); 
		return column;
	}
	/**
	 * 获取龈源-CEJ上中表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCejtopcenterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cejtopcenter");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("龈源-CEJ上中"); 
		return column;
	}
	/**
	 * 获取龈源-CEJ右上表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCejtoprightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cejtopright");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("龈源-CEJ右上"); 
		return column;
	}
	/**
	 * 获取龈源-CEJ左下表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCejbottomleftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cejbottomleft");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("龈源-CEJ左下"); 
		return column;
	}
	/**
	 * 获取龈源-CEJ下中表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCejbottomcenterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cejbottomcenter");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("龈源-CEJ下中"); 
		return column;
	}
	/**
	 * 获取龈源-CEJ下右表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCejbottomrightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cejbottomright");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("龈源-CEJ下右"); 
		return column;
	}
	/**
	 * 获取BI出血指数上表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBitopvalueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bitopvalue");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("BI出血指数上"); 
		return column;
	}
	/**
	 * 获取BI出血指数下表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBibottomvalueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bibottomvalue");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("BI出血指数下"); 
		return column;
	}
	/**
	 * 获取PD探测深度左上表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPdtopleftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pdtopleft");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("PD探测深度左上"); 
		return column;
	}
	/**
	 * 获取PD探测深度上中表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPdtopcenterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pdtopcenter");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("PD探测深度上中"); 
		return column;
	}
	/**
	 * 获取PD探测深度右上表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPdtoprightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pdtopright");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("PD探测深度右上"); 
		return column;
	}
	/**
	 * 获取PD探测深度左下表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPdbottomleftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pdbottomleft");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("PD探测深度左下"); 
		return column;
	}
	/**
	 * 获取PD探测深度下中表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPdbottomcenterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pdbottomcenter");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("PD探测深度下中"); 
		return column;
	}
	/**
	 * 获取PD探测深度下右表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPdbottomrightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pdbottomright");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("PD探测深度下右"); 
		return column;
	}
	/**
	 * 获取患者id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者id"); 
		return column;
	}
	/**
	 * 获取出血点左上表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBleedtopleftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bleedtopleft");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出血点左上"); 
		return column;
	}
	/**
	 * 获取出血点上中表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBleedtopcenterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bleedtopcenter");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出血点上中"); 
		return column;
	}
	/**
	 * 获取出血点右上表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBleedtoprightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bleedtopright");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出血点右上"); 
		return column;
	}
	/**
	 * 获取出血点左下表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBleedbottomleftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bleedbottomleft");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出血点左下"); 
		return column;
	}
	/**
	 * 获取出血点下中表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBleedbottomcenterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bleedbottomcenter");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出血点下中"); 
		return column;
	}
	/**
	 * 获取出血点下右表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBleedbottomrightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bleedbottomright");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出血点下右"); 
		return column;
	}
	/**
	 * 获取牙齿状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTeechstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Teechstatus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("牙齿状态"); 
		return column;
	}
	/**
	 * 获取牙齿位置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTeechindexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Teechindex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("牙齿位置"); 
		return column;
	}
	/**
	 * 获取门诊就诊日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_op");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("门诊就诊日期"); 
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
