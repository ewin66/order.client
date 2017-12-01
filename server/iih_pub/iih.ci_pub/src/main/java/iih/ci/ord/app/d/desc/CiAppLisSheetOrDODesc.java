
package iih.ci.ord.app.d.desc;

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
 * 检验申请单对应医嘱 DO 元数据信息
 */
public class CiAppLisSheetOrDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.app.d.CiAppLisSheetOrDO";
	public static final String CLASS_DISPALYNAME = "检验申请单对应医嘱";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_app_lis_or";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_ciapplissheetor";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiAppLisSheetOrDODesc(){
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
		this.setKeyDesc(getId_ciapplissheetorADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_ciapplissheetADesc(tblDesc));
		this.add(getId_ciapplissheetorADesc(tblDesc));
		this.add(getId_ciapplissheetADesc(tblDesc));
		this.add(getId_orlabADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getAmt_appADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ciapplissheetorCDesc(tblDesc));
		tblDesc.add(getId_ciapplissheetorCDesc(tblDesc));
		tblDesc.add(getId_ciapplissheetCDesc(tblDesc));
		tblDesc.add(getId_orlabCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getAmt_appCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 检验申请单对应的医嘱申请主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ciapplissheetorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ciapplissheetor",  getId_ciapplissheetorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验申请单对应的医嘱申请主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验申请单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ciapplissheetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ciapplissheet",  getId_ciapplissheetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检验申请单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对应医嘱检验申请属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orlabADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_orlab",  getId_orlabCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对应医嘱检验申请");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对应医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对应医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对应申请金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_app",  getAmt_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("对应申请金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取检验申请单对应的医嘱申请主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ciapplissheetorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ciapplissheetor");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("检验申请单对应的医嘱申请主键标识"); 
		return column;
	}
	/**
	 * 获取检验申请单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ciapplissheetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ciapplissheet");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检验申请单"); 
		return column;
	}
	/**
	 * 获取对应医嘱检验申请表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orlabCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_orlab");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对应医嘱检验申请"); 
		return column;
	}
	/**
	 * 获取对应医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对应医嘱"); 
		return column;
	}
	/**
	 * 获取对应申请金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_app");
		column.setLength(12);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("对应申请金额"); 
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
