
package iih.ci.mr.nu.healthyedunsrec.d.desc;

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
 * 健康教育记录 DO 元数据信息
 */
public class HealthyEduNsRecDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.healthyedunsrec.d.HealthyEduNsRecDO";
	public static final String CLASS_DISPALYNAME = "健康教育记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_NU_HNER_Rec";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_henr_rec";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HealthyEduNsRecDODesc(){
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
		this.setKeyDesc(getId_henr_recADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_henrADesc(tblDesc));
		this.add(getId_henr_recADesc(tblDesc));
		this.add(getId_henrADesc(tblDesc));
		this.add(getId_eduobjADesc(tblDesc));
		this.add(getSd_eduobjADesc(tblDesc));
		this.add(getId_edumethodADesc(tblDesc));
		this.add(getSd_edumethodADesc(tblDesc));
		this.add(getDt_eduADesc(tblDesc));
		this.add(getEu_xgpjADesc(tblDesc));
		this.add(getId_jyxmADesc(tblDesc));
		this.add(getSd_jyxmADesc(tblDesc));
		this.add(getId_jtnrADesc(tblDesc));
		this.add(getSd_jtnrADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getId_educatorADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_eduobjADesc(tblDesc));
		this.add(getName_edumethodADesc(tblDesc));
		this.add(getJyxm_nameADesc(tblDesc));
		this.add(getJtnr_nameADesc(tblDesc));
		this.add(getName_educatorADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_henr_recCDesc(tblDesc));
		tblDesc.add(getId_henr_recCDesc(tblDesc));
		tblDesc.add(getId_henrCDesc(tblDesc));
		tblDesc.add(getId_eduobjCDesc(tblDesc));
		tblDesc.add(getSd_eduobjCDesc(tblDesc));
		tblDesc.add(getId_edumethodCDesc(tblDesc));
		tblDesc.add(getSd_edumethodCDesc(tblDesc));
		tblDesc.add(getDt_eduCDesc(tblDesc));
		tblDesc.add(getEu_xgpjCDesc(tblDesc));
		tblDesc.add(getId_jyxmCDesc(tblDesc));
		tblDesc.add(getSd_jyxmCDesc(tblDesc));
		tblDesc.add(getId_jtnrCDesc(tblDesc));
		tblDesc.add(getSd_jtnrCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getId_educatorCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 健康教育记录主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_henr_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_henr_rec",  getId_henr_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康教育记录主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康教育属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_henrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_henr",  getId_henrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康教育");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 教育对象ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eduobjADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eduobj",  getId_eduobjCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育对象ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 教育对象编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_eduobjADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_eduobj",  getSd_eduobjCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育对象编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教育方法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_edumethodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_edumethod",  getId_edumethodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育方法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 教育方法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_edumethodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_edumethod",  getSd_edumethodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育方法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教育时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_eduADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_edu",  getDt_eduCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("教育时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 效果评价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_xgpjADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_xgpj",  getEu_xgpjCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("效果评价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教育项目id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_jyxmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_jyxm",  getId_jyxmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育项目id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 教育项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_jyxmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_jyxm",  getSd_jyxmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 具体内容id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_jtnrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_jtnr",  getId_jtnrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("具体内容id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 具体内容编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_jtnrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_jtnr",  getSd_jtnrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("具体内容编码");
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
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
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
	 * 教育者id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_educatorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_educator",  getId_educatorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育者id");
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
	 * 教育对象属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_eduobjADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_eduobj",  getName_eduobjCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育对象");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b8","id_eduobj=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教育方法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_edumethodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_edumethod",  getName_edumethodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育方法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b9","id_edumethod=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教育项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJyxm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Jyxm_name",  getJyxm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b3","id_jyxm=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 具体内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJtnr_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Jtnr_name",  getJtnr_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("具体内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_jtnr=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教育者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_educatorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_educator",  getName_educatorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b5","id_educator=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取健康教育记录主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_henr_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_henr_rec");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("健康教育记录主键"); 
		return column;
	}
	/**
	 * 获取健康教育表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_henrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_henr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康教育"); 
		return column;
	}
	/**
	 * 获取教育对象ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eduobjCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eduobj");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育对象ID"); 
		return column;
	}
	/**
	 * 获取教育对象编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_eduobjCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_eduobj");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育对象编码"); 
		return column;
	}
	/**
	 * 获取教育方法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_edumethodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_edumethod");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育方法"); 
		return column;
	}
	/**
	 * 获取教育方法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_edumethodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_edumethod");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育方法编码"); 
		return column;
	}
	/**
	 * 获取教育时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_eduCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_edu");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("教育时间"); 
		return column;
	}
	/**
	 * 获取效果评价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_xgpjCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_xgpj");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("效果评价"); 
		return column;
	}
	/**
	 * 获取教育项目id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_jyxmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_jyxm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育项目id"); 
		return column;
	}
	/**
	 * 获取教育项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_jyxmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_jyxm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育项目编码"); 
		return column;
	}
	/**
	 * 获取具体内容id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_jtnrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_jtnr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("具体内容id"); 
		return column;
	}
	/**
	 * 获取具体内容编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_jtnrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_jtnr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("具体内容编码"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取教育者id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_educatorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_educator");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育者id"); 
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
	 * 获取教育对象表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_eduobjCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_eduobj");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育对象"); 
		return column;
	}
	/**
	 * 获取教育方法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_edumethodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_edumethod");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育方法"); 
		return column;
	}
	/**
	 * 获取教育项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJyxm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Jyxm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育项目"); 
		return column;
	}
	/**
	 * 获取具体内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJtnr_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Jtnr_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("具体内容"); 
		return column;
	}
	/**
	 * 获取教育者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_educatorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_educator");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育者"); 
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
