
package iih.ci.ord.ciprn.d.desc;

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
 * 临床打印单明细 DO 元数据信息
 */
public class CiPrnItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.ciprn.d.CiPrnItmDO";
	public static final String CLASS_DISPALYNAME = "临床打印单明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_prn_item";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_ciprnitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiPrnItmDODesc(){
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
		this.setKeyDesc(getId_ciprnitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_ciprnADesc(tblDesc));
		this.add(getId_ciprnitmADesc(tblDesc));
		this.add(getId_ciprnADesc(tblDesc));
		this.add(getId_bizADesc(tblDesc));
		this.add(getAmt_bizADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ciprnitmCDesc(tblDesc));
		tblDesc.add(getId_ciprnitmCDesc(tblDesc));
		tblDesc.add(getId_ciprnCDesc(tblDesc));
		tblDesc.add(getId_bizCDesc(tblDesc));
		tblDesc.add(getAmt_bizCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 临床打印明细项目主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ciprnitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ciprnitm",  getId_ciprnitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床打印明细项目主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床打印单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ciprnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ciprn",  getId_ciprnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床打印单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关联业务主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bizADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_biz",  getId_bizCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关联业务主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 业务金额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_bizADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_biz",  getAmt_bizCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("业务金额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取临床打印明细项目主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ciprnitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ciprnitm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("临床打印明细项目主键"); 
		return column;
	}
	/**
	 * 获取临床打印单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ciprnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ciprn");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床打印单"); 
		return column;
	}
	/**
	 * 获取关联业务主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bizCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_biz");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关联业务主键"); 
		return column;
	}
	/**
	 * 获取业务金额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_bizCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_biz");
		column.setLength(14);
        column.setPrecision(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("业务金额"); 
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
