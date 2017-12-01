
package iih.ci.mr.mrlogitm.d.desc;

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
 * 病历记录操作明细 DO 元数据信息
 */
public class CiMrLogItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.mrlogitm.d.CiMrLogItmDO";
	public static final String CLASS_DISPALYNAME = "病历记录操作明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mr_log_itm";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_mr_log_itm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiMrLogItmDODesc(){
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
		this.setKeyDesc(getId_mr_log_itmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_mr_log_itmADesc(tblDesc));
		this.add(getId_mr_logADesc(tblDesc));
		this.add(getText_operate_itmADesc(tblDesc));
		this.add(getId_type_operate_itmADesc(tblDesc));
		this.add(getSd_type_operate_itmADesc(tblDesc));
		this.add(getPremissionlevelADesc(tblDesc));
		this.add(getId_user_inADesc(tblDesc));
		this.add(getUser_in_nameADesc(tblDesc));
		this.add(getTitle_operate_itmADesc(tblDesc));
		this.add(getDt_operate_itmADesc(tblDesc));
		this.add(getType_operate_itm_codeADesc(tblDesc));
		this.add(getType_operate_itm_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mr_log_itmCDesc(tblDesc));
		tblDesc.add(getId_mr_log_itmCDesc(tblDesc));
		tblDesc.add(getId_mr_logCDesc(tblDesc));
		tblDesc.add(getText_operate_itmCDesc(tblDesc));
		tblDesc.add(getId_type_operate_itmCDesc(tblDesc));
		tblDesc.add(getSd_type_operate_itmCDesc(tblDesc));
		tblDesc.add(getPremissionlevelCDesc(tblDesc));
		tblDesc.add(getId_user_inCDesc(tblDesc));
		tblDesc.add(getUser_in_nameCDesc(tblDesc));
		tblDesc.add(getTitle_operate_itmCDesc(tblDesc));
		tblDesc.add(getDt_operate_itmCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 操作明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mr_log_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mr_log_itm",  getId_mr_log_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作明细主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病历操作记录主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mr_logADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mr_log",  getId_mr_logCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历操作记录主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getText_operate_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Text_operate_itm",  getText_operate_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病历操作记录类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_type_operate_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_type_operate_itm",  getId_type_operate_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历操作记录类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病历操作记录类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_type_operate_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_type_operate_itm",  getSd_type_operate_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历操作记录类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作级别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPremissionlevelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Premissionlevel",  getPremissionlevelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("操作级别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 内部操作人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_user_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_user_in",  getId_user_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("内部操作人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 操作人名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUser_in_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("User_in_name",  getUser_in_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("操作人名称");
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
	private IAttrDesc getTitle_operate_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Title_operate_itm",  getTitle_operate_itmCDesc(tblDesc), this);
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
	 * 操作时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_operate_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_operate_itm",  getDt_operate_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("操作时间");
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
	private IAttrDesc getType_operate_itm_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Type_operate_itm_code",  getType_operate_itm_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_type_operate_itm=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getType_operate_itm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Type_operate_itm_name",  getType_operate_itm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_type_operate_itm=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取操作明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mr_log_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mr_log_itm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("操作明细主键"); 
		return column;
	}
	/**
	 * 获取病历操作记录主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mr_logCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mr_log");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历操作记录主键"); 
		return column;
	}
	/**
	 * 获取操作内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getText_operate_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Text_operate_itm");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作内容"); 
		return column;
	}
	/**
	 * 获取病历操作记录类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_type_operate_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_type_operate_itm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历操作记录类型"); 
		return column;
	}
	/**
	 * 获取病历操作记录类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_type_operate_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_type_operate_itm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历操作记录类型编码"); 
		return column;
	}
	/**
	 * 获取操作级别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPremissionlevelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Premissionlevel");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("操作级别"); 
		return column;
	}
	/**
	 * 获取内部操作人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_user_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_user_in");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("内部操作人"); 
		return column;
	}
	/**
	 * 获取操作人名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUser_in_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"User_in_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("操作人名称"); 
		return column;
	}
	/**
	 * 获取标题表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTitle_operate_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Title_operate_itm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标题"); 
		return column;
	}
	/**
	 * 获取操作时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_operate_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_operate_itm");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("操作时间"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getType_operate_itm_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Type_operate_itm_code");
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
	private IColumnDesc getType_operate_itm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Type_operate_itm_name");
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
